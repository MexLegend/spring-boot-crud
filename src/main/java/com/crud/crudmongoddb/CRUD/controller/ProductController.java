package com.crud.crudmongoddb.CRUD.controller;

import com.crud.crudmongoddb.CRUD.dto.ProductDto;
import com.crud.crudmongoddb.CRUD.entity.Product;
import com.crud.crudmongoddb.CRUD.service.ProductService;
import com.crud.crudmongoddb.global.dto.MessageDto;
import com.crud.crudmongoddb.global.exceptions.AttributeException;
import com.crud.crudmongoddb.global.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable("id") String _id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.getOne(_id));
    }

    @PostMapping
    public ResponseEntity<MessageDto> save(@Valid @RequestBody ProductDto dto) throws AttributeException {
        Product product = productService.save(dto);
        String message = "Product " + product.getName() + " have been saved";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message, product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") String _id, @Valid @RequestBody ProductDto dto) throws ResourceNotFoundException, AttributeException {
        dto.set_id(_id);
        Product product = productService.update(_id, dto);
        String message = "Product " + product.getName() + " have been updated";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message, product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") String _id) throws ResourceNotFoundException {
        productService.delete(_id);
        String message = "Product have been deleted";
        return ResponseEntity.ok(new MessageDto(HttpStatus.OK, message));
    }
}
