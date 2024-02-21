package com.unibuc.beautysalon.controller;

import com.unibuc.beautysalon.dto.SimpleBeautyProfessionslDto;
import com.unibuc.beautysalon.entity.BeautyProfessional;
import com.unibuc.beautysalon.service.BeautyProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beautyprofessionals")
public class BeautyProfessionalController {
    private final BeautyProfessionalService beautyProfessionalService;

    @Autowired
    public BeautyProfessionalController(BeautyProfessionalService beautyProfessionalService) {
        this.beautyProfessionalService = beautyProfessionalService;
    }

    @GetMapping
    public ResponseEntity<List<SimpleBeautyProfessionslDto>> getAllBeautyProfessionalsAsDto() {
        List<SimpleBeautyProfessionslDto> simpleBeautyProfessionslDtos = beautyProfessionalService.getAllBeautyProfessionalsAsDto();
        return new ResponseEntity<>(simpleBeautyProfessionslDtos, HttpStatus.OK);
    }

    @GetMapping("/{beautyProfessionalId}")
    public ResponseEntity<SimpleBeautyProfessionslDto> getBeautyProfessionalDtoById(@PathVariable Long beautyProfessionalId) {
        SimpleBeautyProfessionslDto simpleBeautyProfessionslDto = beautyProfessionalService.getBeautyProfessionalDtoById(beautyProfessionalId);
        if (simpleBeautyProfessionslDto != null) {
            return ResponseEntity.ok(simpleBeautyProfessionslDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BeautyProfessional> addSimpleBeautyProfessional(@RequestBody SimpleBeautyProfessionslDto simpleBeautyProfessionslDto){
        BeautyProfessional beautyProfessional = new BeautyProfessional();
        beautyProfessional.setId(simpleBeautyProfessionslDto.getId());
        beautyProfessional.setName(simpleBeautyProfessionslDto.getName());
        beautyProfessional.setSpecialization(simpleBeautyProfessionslDto.getSpecialization());

        BeautyProfessional savedBeautyProfessional = beautyProfessionalService.saveBeautyProfessional(beautyProfessional);
        return new ResponseEntity<>(savedBeautyProfessional, HttpStatus.CREATED);
    }

    @DeleteMapping("/{beautyProfessionalId}")
    public ResponseEntity<Void> deleteBeautyProfessional(@PathVariable Long beautyProfessionalId) {
        boolean deleted = beautyProfessionalService.deleteBeautyProfessional(beautyProfessionalId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
