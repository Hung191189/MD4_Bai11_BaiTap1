package com.example.md4_bai11_baitap1.repository;

import com.example.md4_bai11_baitap1.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostsRepository extends JpaRepository<Posts, Long> {
}
