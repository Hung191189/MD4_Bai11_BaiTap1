package com.example.md4_bai11_baitap1.repository;

import com.example.md4_bai11_baitap1.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
