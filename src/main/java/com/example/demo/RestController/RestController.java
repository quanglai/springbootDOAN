package com.example.demo.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface RestController<E> {
    @GetMapping()
    List<E> findAll();
    @GetMapping("/{id}")
    ResponseEntity<E> findOne(@PathVariable(name = "id") Long id);
    @PostMapping
    ResponseEntity<E> save(@RequestBody E e);
    @DeleteMapping("/{id}")
    ResponseEntity<E> delete(@PathVariable(name = "id") Long id);
    @PutMapping()
    ResponseEntity<E> update(@RequestBody E e);

}
