package com.unibuc.beautysalon.service;

import com.unibuc.beautysalon.dto.SimpleBeautyProfessionslDto;
import com.unibuc.beautysalon.entity.BeautyProfessional;
import com.unibuc.beautysalon.mapper.BeautyProfessionalMapper;
import com.unibuc.beautysalon.repository.BeautyProfessionalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeautyProfessionalService {
    private final BeautyProfessionalRepository beautyProfessionalRepository;
    private final BeautyProfessionalMapper beautyProfessionalMapper;

    @Autowired
    public BeautyProfessionalService(BeautyProfessionalRepository beautyProfessionalRepository, BeautyProfessionalMapper beautyProfessionalMapper) {
        this.beautyProfessionalRepository = beautyProfessionalRepository;
        this.beautyProfessionalMapper = beautyProfessionalMapper;
    }

    public List<BeautyProfessional> getAllBeautyProfessionals() {
        return beautyProfessionalRepository.findAll();
    }

    public List<SimpleBeautyProfessionslDto> getAllBeautyProfessionalsAsDto() {
        List<BeautyProfessional> beautyProfessionals = beautyProfessionalRepository.findAll();
        return beautyProfessionals.stream()
                .map(beautyProfessionalMapper::BeautyProfessionalToSimpleBeautyProfessionalDto)
                .collect(Collectors.toList());
    }
    public BeautyProfessional getBeautyProfessionalById(Long beautyProfessionalId) {
        Optional<BeautyProfessional> optionalBeautyProfessional = beautyProfessionalRepository.findById(beautyProfessionalId);
        return optionalBeautyProfessional.orElse(null);
    }
    public SimpleBeautyProfessionslDto getBeautyProfessionalDtoById(Long beautyProfessionalId) {
        Optional<BeautyProfessional> optionalBeautyProfessional = beautyProfessionalRepository.findById(beautyProfessionalId);
        if (optionalBeautyProfessional.isPresent()) {
            BeautyProfessional beautyProfessional = optionalBeautyProfessional.get();
            return beautyProfessionalMapper.BeautyProfessionalToSimpleBeautyProfessionalDto(beautyProfessional);
        } else {
            throw new EntityNotFoundException("The employee with id: " + beautyProfessionalId + " was not found.");
        }
    }

    public BeautyProfessional saveBeautyProfessional(BeautyProfessional beautyProfessional) {
        return beautyProfessionalRepository.save(beautyProfessional);
    }

    public boolean deleteBeautyProfessional(Long beautyProfessionalId) {
        Optional<BeautyProfessional> optionalBeautyProfessional = beautyProfessionalRepository.findById(beautyProfessionalId);
        if (optionalBeautyProfessional.isPresent()) {
            beautyProfessionalRepository.deleteById(beautyProfessionalId);
            return true;
        } else {
            return false;
        }
    }
}
