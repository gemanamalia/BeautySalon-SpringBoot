package com.unibuc.beautysalon.mapper;

import com.unibuc.beautysalon.dto.SimpleBeautyProfessionslDto;
import com.unibuc.beautysalon.entity.BeautyProfessional;
import org.springframework.stereotype.Component;

@Component
public class BeautyProfessionalMapper {
    public SimpleBeautyProfessionslDto BeautyProfessionalToSimpleBeautyProfessionalDto(BeautyProfessional beautyProfessional) {
        return new SimpleBeautyProfessionslDto(beautyProfessional.getId(), beautyProfessional.getName(), beautyProfessional.getSpecialization());
    }
}
