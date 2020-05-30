package com.spring_arquitetura.spring_arquitetura.core;

import com.spring_arquitetura.spring_arquitetura.exceptions.ErrorExcep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class AbstractController<T> {

    @Autowired
    protected IService<T> service;

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") long id){

        if(!service.exist(id)){
        throw new ErrorExcep("Usuario não encontrado");
        }

        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        
    }

    @PostMapping
    public ResponseEntity<?> save( @RequestBody() T obj ){
        return new ResponseEntity<>(service.save(obj), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id ) {
        if(!service.exist(id)){
            throw new ErrorExcep("Usuario não encontrado");
        }
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }

}