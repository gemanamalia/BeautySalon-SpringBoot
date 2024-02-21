package com.unibuc.beautysalon.dto;

import com.unibuc.beautysalon.validation.PositivePrice;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class SimpleProductDto {
    private Long id;

    @NotNull
    @Length(max = 200, message = "Product name has max length 200!")
    private String name;

    @NotNull
    @PositivePrice
    private double price;

    // Constructors
    public SimpleProductDto() {
    }

    public SimpleProductDto(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
