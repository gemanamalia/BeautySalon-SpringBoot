package com.unibuc.beautysalon.dto;

import jakarta.validation.constraints.NotNull;

public class AppointmentDto {
    private Long id;
    @NotNull
    private Long clientId;
    @NotNull
    private Long beautyProfessionalId;

    // Constructors
    public AppointmentDto() {
    }

    public AppointmentDto(Long id, Long clientId, Long beautyProfessionalId) {
        this.id = id;
        this.clientId = clientId;
        this.beautyProfessionalId = beautyProfessionalId;
    }

    // Get & Set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBeautyProfessionalId() {
        return beautyProfessionalId;
    }

    public void setBeautyProfessionalId(Long beautyProfessionalId) {
        this.beautyProfessionalId = beautyProfessionalId;
    }
}
