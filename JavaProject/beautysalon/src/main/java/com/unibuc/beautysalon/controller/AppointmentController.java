package com.unibuc.beautysalon.controller;
import com.unibuc.beautysalon.dto.AppointmentDto;
import com.unibuc.beautysalon.entity.Appointment;
import com.unibuc.beautysalon.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        Appointment newAppointment = appointmentService.createAppointment(appointmentDto);
        return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointmentsAsDto() {
        List<AppointmentDto> appointmentsDto = appointmentService.getAllAppointmentsAsDto();
        return new ResponseEntity<>(appointmentsDto, HttpStatus.OK);
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId) {
        boolean deleted = appointmentService.deleteAppointment(appointmentId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
