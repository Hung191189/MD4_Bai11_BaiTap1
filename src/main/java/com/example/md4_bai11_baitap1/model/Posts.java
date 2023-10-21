package com.example.md4_bai11_baitap1.model;

import javax.persistence.*;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosts;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Posts() {
    }

    public Posts(String name, Category category) {
        this.name = name;
        this.category = category;
    }


    public Posts(Long idPosts, String name, Category category) {
        this.idPosts = idPosts;
        this.name = name;
        this.category = category;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Posts(String name) {
        this.name = name;
    }

    public void setIdPosts(Long idPosts) {
        this.idPosts = idPosts;
    }

    public Long getIdPosts() {
        return idPosts;
    }
}
