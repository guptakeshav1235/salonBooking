package com.keshav.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keshav.model.category;

public interface categoryRepository extends JpaRepository<category, Long> {

    Set<category> findBySalonId(Long id);
}
