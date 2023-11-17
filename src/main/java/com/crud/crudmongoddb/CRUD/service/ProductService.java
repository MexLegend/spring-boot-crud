package com.crud.crudmongoddb.CRUD.service;

import com.crud.crudmongoddb.CRUD.dto.ProductDto;
import com.crud.crudmongoddb.CRUD.entity.Product;
import com.crud.crudmongoddb.CRUD.repository.ProductRepository;
import com.crud.crudmongoddb.global.exceptions.AttributeException;
import com.crud.crudmongoddb.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getOne(String _id) throws ResourceNotFoundException {
        return productRepository.findById(_id).
                orElseThrow(()-> new ResourceNotFoundException("Not found"));
    }

    public Product save(ProductDto dto) throws AttributeException {
        if(productRepository.existsByName(dto.getName()))
            throw new AttributeException("Product name already in use");
        Product product = new Product(dto.get_id(), dto.getName(), dto.getPrice());
        return productRepository.save(product);
    }

    public Product update(String _id, ProductDto dto) throws ResourceNotFoundException, AttributeException {
        productRepository.findById(_id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        if(productRepository.existsByName(dto.getName()) && !Objects.equals(productRepository.findByName(dto.getName()).get().get_Id(), _id))
            throw new AttributeException("Name already in use");
        Product product = new Product(dto.get_id(), dto.getName(), dto.getPrice());
        return productRepository.save(product);
    }

    public void delete(String _id) throws ResourceNotFoundException {
        productRepository.findById(_id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        productRepository.deleteById(_id);
    }

}
