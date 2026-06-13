package com.keshav.services;

import java.util.Set;

import com.keshav.model.category;
import com.keshav.payload.dto.salonDTO;

public interface categoryService {

    category saveCategory(category category, salonDTO salonDto);

    Set<category> getAllCategoriesBySalon(Long id);

    category getCategoryById(Long id) throws Exception;

    void deleteCategoryById(Long id, Long salonId) throws Exception;
}
