package com.crud.crudmongoddb.CRUD.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDto {
    private String _id;
    @NotBlank(message = "Product name is required")
    private String name;
    @Min(value = 1, message = "Product price is required")
    private int price;


    public ProductDto() {
    }

    public ProductDto(String _id, String name, int price) {
        this._id = _id;
        this.name = name;
        this.price = price;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
