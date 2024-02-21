package com.unibuc.beautysalon.repository;
import com.unibuc.beautysalon.entity.BeautyProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeautyProfessionalRepository extends JpaRepository<BeautyProfessional, Long> {
    Optional<BeautyProfessional> findBySpecialization(String specialization);
}

