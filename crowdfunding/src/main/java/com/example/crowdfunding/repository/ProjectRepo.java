package com.example.crowdfunding.repository;

import com.example.crowdfunding.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
    Project findByName(String name);
}
