package com.spring_arquitetura.spring_arquitetura.core;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public class AbstractService<T> implements IService<T> {

    @Autowired
    protected JpaRepository<T, Long> repository;

    @Override
    public List<T> findAll() {
        List<T> lista = repository.findAll();

        return lista;
    }

    @Override
    public T findById(long id) {
       
        return repository.getOne(id);

    }

    @Override
    @javax.transaction.Transactional
    public T save(T obj) {
        return repository.save(obj);
    }

    @Override
    public T update(T obj) {
        return null;
    }


    public T update(long id) {
        T obj = this.findById(id);
        if (obj != null) {
            return obj;
        }
            else{
                return null;



        }

    }

    @Override
    public boolean delete(long id) {
        T obj = this.findById(id);
        if (obj != null) {
            repository.delete(obj);
            return true;
        }
        return false;
    }

    @Override
    public boolean exist(long id) {
        return repository.existsById(id);       
    }

}