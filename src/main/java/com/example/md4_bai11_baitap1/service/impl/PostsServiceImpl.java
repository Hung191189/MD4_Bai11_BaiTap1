package com.example.md4_bai11_baitap1.service.impl;

import com.example.md4_bai11_baitap1.model.Posts;
import com.example.md4_bai11_baitap1.repository.IPostsRepository;
import com.example.md4_bai11_baitap1.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PostsServiceImpl implements IPostsService {
    @Autowired
    IPostsRepository postsRepository;
    @Override
    public Iterable<Posts> findAll() {
        return postsRepository.findAll();
    }

    @Override
    public Optional<Posts> findById(Long id) {
        return postsRepository.findById(id);
    }

    @Override
    public Posts save(Posts posts) {
        return postsRepository.save(posts);
    }

    @Override
    public void delete(Long id) {
        postsRepository.deleteById(id);
    }
}
