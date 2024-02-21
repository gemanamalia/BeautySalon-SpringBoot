package com.unibuc.beautysalon.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class SimpleBeautyProfessionslDto {
    private Long id;
    @NotNull
    @Length(max = 200, message = "Name has max length 200!")
    private String name;

    @NotNull
    @Length(max = 200, message = "Specialization has max length 200!")
    private String specialization;

    // Constructors
    public SimpleBeautyProfessionslDto() {
    }
    public SimpleBeautyProfessionslDto(Long id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
