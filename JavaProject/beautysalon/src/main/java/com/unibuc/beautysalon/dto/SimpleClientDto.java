package com.unibuc.beautysalon.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class SimpleClientDto {
    private Long id;
    @NotNull
    @Length(max = 200, message = "Name has max length 200!")
    private String name;

    // Constructors
    public SimpleClientDto() {
    }

    public SimpleClientDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Get and Set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
