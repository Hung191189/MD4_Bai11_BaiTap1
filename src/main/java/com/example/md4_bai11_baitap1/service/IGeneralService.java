package com.example.md4_bai11_baitap1.service;

import java.util.Optional;

public interface IGeneralService<R> {
Iterable<R> findAll();
Optional<R> findById(Long id);
R save (R r);
void delete(Long id);

}
