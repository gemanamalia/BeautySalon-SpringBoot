package com.unibuc.beautysalon.entity;
import jakarta.persistence.*;
import java.util.List;
import org.hibernate.validator.constraints.Length;

@Entity
public class BeautyProfessional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Length(max = 200)
    private String name;
    @Length(max = 200)
    private String specialization;

    @OneToMany(mappedBy = "beautyProfessional")
    private List<Appointment> appointments;

    // Constructors
    public BeautyProfessional() {
    }

    public BeautyProfessional(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public BeautyProfessional(Long id, String name, String specialization) {
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

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
