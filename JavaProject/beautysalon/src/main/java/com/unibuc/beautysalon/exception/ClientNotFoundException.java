package com.unibuc.beautysalon.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(long id) {
        super("Client with id: " + id + " does not exist!");
    }
}

