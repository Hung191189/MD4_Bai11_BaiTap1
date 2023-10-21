package com.example.md4_bai11_baitap1.controller;

import com.example.md4_bai11_baitap1.model.Category;
import com.example.md4_bai11_baitap1.model.Posts;
import com.example.md4_bai11_baitap1.service.ICategoryService;
import com.example.md4_bai11_baitap1.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    @Autowired
    IPostsService postsService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Posts>> findAll() {
        List<Posts> postsList = (List<Posts>) postsService.findAll();
        if (postsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(postsList, HttpStatus.OK);
    }

    @PostMapping("/save/{idCategory}")
    public ResponseEntity<Posts> savePosts(@RequestBody Posts posts, @PathVariable Long idCategory) {
        Optional<Category> optionalCategory = categoryService.findById(idCategory);
        posts.setCategory(optionalCategory.get());
        return new ResponseEntity<>(postsService.save(posts), HttpStatus.CREATED);
    }

    @GetMapping("/id}")
    public ResponseEntity<Posts> findByIdPosts(@PathVariable Long id) {
        Optional<Posts> optionalPosts = postsService.findById(id);
        if (!optionalPosts.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalPosts.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Posts> updatePosts(@PathVariable Long id, @RequestBody Posts posts) {
        Optional<Posts> optionalPosts = postsService.findById(id);
        if (!optionalPosts.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        posts.setIdPosts(optionalPosts.get().getIdPosts());
        return new ResponseEntity<>(postsService.save(posts), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Posts> deletePosts(@PathVariable Long id) {
        Optional<Posts> optionalPosts = postsService.findById(id);
        if (!optionalPosts.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postsService.delete(id);
        return new ResponseEntity<>(optionalPosts.get(), HttpStatus.OK);
    }

}
