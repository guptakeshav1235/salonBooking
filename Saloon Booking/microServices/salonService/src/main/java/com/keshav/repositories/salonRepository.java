package com.keshav.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.keshav.model.salon;

public interface salonRepository extends JpaRepository<salon, Long> {
    salon findByOwnerId(Long id);

    @Query(
        "SELECT s FROM salon s WHERE" +
            "(lower(s.city) LIKE lower(concat('%', :keyword, '%')) OR " + 
            "lower(s.name) LIKE lower(concat('%', :keyword, '%')) OR " +
            "lower(s.address) LIKE lower(concat('%', :keyword, '%')))"    
    )
    List<salon> searchSalons(@Param("keyword") String keyword);
}
