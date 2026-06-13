package com.keshav.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keshav.model.category;
import com.keshav.payload.dto.salonDTO;
import com.keshav.services.categoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categories/salon-owner")
@RequiredArgsConstructor
public class salonCategoryController {
    
    private final categoryService categoryService;

    @PostMapping()
    public ResponseEntity<category> createCategory(@RequestBody category category) {

        salonDTO salonDto = new salonDTO();
        salonDto.setId(1L);

        category savedCategory = categoryService.saveCategory(category, salonDto);
        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) throws Exception{

        salonDTO salonDto = new salonDTO();
        salonDto.setId(1L);

        categoryService.deleteCategoryById(id, salonDto.getId());
        return ResponseEntity.ok("category deleted successfully");
    }
}
