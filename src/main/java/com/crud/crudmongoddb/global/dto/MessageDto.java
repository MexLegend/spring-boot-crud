package com.crud.crudmongoddb.global.dto;

import com.crud.crudmongoddb.CRUD.entity.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDto {

    private HttpStatus status;
    private  String message;

    private  Product product;

    public MessageDto() {
    }

    public MessageDto(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public MessageDto(HttpStatus status, String message, Product product) {
        this.status = status;
        this.message = message;
        this.product = product;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
