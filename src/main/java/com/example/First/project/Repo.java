package com.example.First.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<Product,Integer> {
    List<Product> findByNameContainingIgnoreCase(String name);
}
