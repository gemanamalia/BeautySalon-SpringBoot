package com.unibuc.beautysalon.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private BeautyProfessional beautyProfessional;

    @OneToMany(mappedBy = "appointment")
    private List<AppointmentProduct> appointmentProducts;

    @FutureOrPresent(message = "The creation date must be a future or present date!")
    private LocalDateTime startTime;

    @FutureOrPresent(message = "The creation date must be a future or present date!")
    private LocalDateTime endTime;

    // Constructors
    public Appointment() {
    }

    public Appointment(Client client, BeautyProfessional beautyProfessional, LocalDateTime startTime, LocalDateTime endTime) {
        this.client = client;
        this.beautyProfessional = beautyProfessional;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Get and Set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BeautyProfessional getBeautyProfessional() {
        return beautyProfessional;
    }

    public void setBeautyProfessional(BeautyProfessional beautyProfessional) {
        this.beautyProfessional = beautyProfessional;
    }

    public List<AppointmentProduct> getAppointmentProducts() {
        return appointmentProducts;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

}
