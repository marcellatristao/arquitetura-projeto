package com.spring_arquitetura.spring_arquitetura.core;

import java.util.List;

public interface IService<T> {
    public List<T> findAll();
    public T findById(long id);
    public T save(T obj);
    public T update(T obj);
    public boolean delete(long id);
    public boolean exist(long id);
}