package com.keshav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keshav.model.user;

public interface userRepository extends JpaRepository<user, Long> {

}
