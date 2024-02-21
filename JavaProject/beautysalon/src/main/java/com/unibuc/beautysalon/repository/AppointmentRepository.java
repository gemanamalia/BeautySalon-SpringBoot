package com.unibuc.beautysalon.repository;
import com.unibuc.beautysalon.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByStartTimeAfter(LocalDateTime startTime);
}
