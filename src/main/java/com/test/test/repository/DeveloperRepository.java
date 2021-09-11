package com.test.test.repository;

import com.test.test.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer,Integer> {
}
