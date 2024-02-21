package com.unibuc.beautysalon.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 200)
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "client")
    private List<Review> reviews;


    // Constructors
    public Client() {
    }

    public Client(String name) {
        this.name = name;
    }

    public Client(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
