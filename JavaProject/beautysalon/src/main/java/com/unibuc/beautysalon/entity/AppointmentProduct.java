package com.unibuc.beautysalon.entity;

import jakarta.persistence.*;

@Entity
public class AppointmentProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Constructors
    public AppointmentProduct() {
    }

    public AppointmentProduct(Appointment appointment, Product product) {
        this.appointment = appointment;
        this.product = product;
    }

    // Get and Set
    public Long getId() {
        return id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}

