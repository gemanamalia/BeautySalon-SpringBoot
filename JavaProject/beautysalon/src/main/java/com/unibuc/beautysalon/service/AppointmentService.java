package com.unibuc.beautysalon.service;

import com.unibuc.beautysalon.dto.AppointmentDto;
import com.unibuc.beautysalon.entity.Appointment;
import com.unibuc.beautysalon.entity.BeautyProfessional;
import com.unibuc.beautysalon.entity.Client;
import com.unibuc.beautysalon.mapper.AppointmentMapper;
import com.unibuc.beautysalon.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ClientService clientService;
    private final BeautyProfessionalService beautyProfessionalService;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, ClientService clientService, BeautyProfessionalService beautyProfessionalService, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.clientService = clientService;
        this.beautyProfessionalService = beautyProfessionalService;
        this.appointmentMapper = appointmentMapper;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<AppointmentDto> getAllAppointmentsAsDto() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private AppointmentDto convertToDto(Appointment appointment) {
        AppointmentDto dto = new AppointmentDto();
        dto.setId(appointment.getId());
        dto.setClientId(appointment.getClient().getId());
        dto.setBeautyProfessionalId(appointment.getBeautyProfessional().getId());
        return dto;
    }

    public Appointment createAppointment(AppointmentDto appointmentDto) {
        Appointment newAppointment = new Appointment();
        newAppointment.setId(appointmentDto.getId());

        Client client = clientService.getClientById(appointmentDto.getClientId());
        BeautyProfessional beautyProfessional = beautyProfessionalService.getBeautyProfessionalById(appointmentDto.getBeautyProfessionalId());

        if (client != null && beautyProfessional != null) {
            newAppointment.setClient(client);
            newAppointment.setBeautyProfessional(beautyProfessional);

            return appointmentRepository.save(newAppointment);
        } else {
            throw new IllegalArgumentException("The client or beauty professional was not found.");
        }
    }

    public boolean deleteAppointment(Long appointmentId) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if (optionalAppointment.isPresent()) {
            appointmentRepository.deleteById(appointmentId);
            return true;
        } else {
            return false;
        }
    }
}
