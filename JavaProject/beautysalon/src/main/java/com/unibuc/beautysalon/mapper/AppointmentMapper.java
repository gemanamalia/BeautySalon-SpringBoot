package com.unibuc.beautysalon.mapper;

import com.unibuc.beautysalon.dto.AppointmentDto;
import com.unibuc.beautysalon.entity.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    // appointment -> dto
    public AppointmentDto AppointmentToAppointmentDto(Appointment appointment) {
        return new AppointmentDto(appointment.getId(), appointment.getClient().getId(), appointment.getBeautyProfessional().getId());
    }
}
