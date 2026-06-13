package com.keshav.services.implementation;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.keshav.model.category;
import com.keshav.payload.dto.salonDTO;
import com.keshav.repositories.categoryRepository;
import com.keshav.services.categoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class categoryServiceImpl implements categoryService {

    private final categoryRepository categoryRepository;

    @Override
    public category saveCategory(category category, salonDTO salonDto) {
        category newCategory = new category();
        newCategory.setName(category.getName());
        newCategory.setSalonId(salonDto.getId());
        newCategory.setImage(category.getImage());

        return categoryRepository.save(newCategory);
    }

    @Override
    public Set<category> getAllCategoriesBySalon(Long id) {
        return categoryRepository.findBySalonId(id);
    }

    @Override
    public category getCategoryById(Long id) throws Exception {
        category category = categoryRepository.findById(id).orElse(null);

        if(category==null) {
            throw new Exception("category not exist with id " + id);
        }

        return category;
    }

    @Override
    public void deleteCategoryById(Long id, Long salonId) throws Exception {
        category category = getCategoryById(id);

        if(!category.getSalonId().equals(salonId)) {
            throw new Exception("You don't have permision to delete this category");
        }

        categoryRepository.deleteById(id);    
    }

}
