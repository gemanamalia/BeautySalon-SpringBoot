package com.unibuc.beautysalon.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(long id) {
        super("Product with id: " + id + " does not exist!");
    }
}
