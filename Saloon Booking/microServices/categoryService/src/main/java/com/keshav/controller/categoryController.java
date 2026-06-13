package com.keshav.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keshav.model.category;
import com.keshav.services.categoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class categoryController {
    
    private final categoryService categoryService;

    @GetMapping("/salon/{id}")
    public ResponseEntity<Set<category>> getCategoriesBySalon(@PathVariable Long id) {

        Set<category> categories = categoryService.getAllCategoriesBySalon(id);
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<category> getCategoryById(@PathVariable Long id) throws Exception {

       category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
}
