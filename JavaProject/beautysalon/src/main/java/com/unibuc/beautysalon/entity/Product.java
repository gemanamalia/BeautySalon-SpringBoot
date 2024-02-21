package com.unibuc.beautysalon.entity;
import com.unibuc.beautysalon.validation.PositivePrice;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Product name can not be null.")
    @Length(max = 200)
    private String name;
    @PositivePrice
    private double price;

    @OneToMany(mappedBy = "product")
    private List<AppointmentProduct> appointmentProducts;

    // Constructors
    public Product() {
    }
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Get and Set
    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

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

    public List<AppointmentProduct> getAppointmentProducts() {
        return appointmentProducts;
    }
}
