package com.rrojase.retomitoccode.service;

import java.util.List;

public interface ICRUDService<T, ID> {
    List<T> findAll() throws Exception;
    T findById(ID id) throws Exception;
    T save(T t) throws Exception;
    T update(ID id, T t) throws Exception;
    void delete(ID id) throws Exception;
}
