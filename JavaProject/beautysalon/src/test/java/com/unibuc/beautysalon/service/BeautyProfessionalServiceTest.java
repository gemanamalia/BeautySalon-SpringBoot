package com.unibuc.beautysalon.service;

import com.unibuc.beautysalon.dto.SimpleBeautyProfessionslDto;
import com.unibuc.beautysalon.entity.BeautyProfessional;
import com.unibuc.beautysalon.mapper.BeautyProfessionalMapper;
import com.unibuc.beautysalon.repository.BeautyProfessionalRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class BeautyProfessionalServiceTest {
    @Mock
    private BeautyProfessionalRepository beautyProfessionalRepository;

    @Mock
    private BeautyProfessionalMapper beautyProfessionalMapper;

    @InjectMocks
    private BeautyProfessionalService beautyProfessionalService;

    private BeautyProfessional bpTest;
    @BeforeEach
    void setUp() {
        bpTest = new BeautyProfessional();
        bpTest.setId(1L);
        bpTest.setName("Beauty Professional Test 1");
        bpTest.setSpecialization("Specialization Test 1");
    }
    @Test
    void getAllBeautyProfessionals() {
        List<BeautyProfessional> beautyProfessionals =  Arrays.asList(bpTest, new BeautyProfessional(2L, "BP test 2", "Specialization 2"));
        Mockito.when(beautyProfessionalRepository.findAll()).thenReturn(beautyProfessionals);

        List<BeautyProfessional> result = beautyProfessionalService.getAllBeautyProfessionals();

        assertEquals(2, result.size());
        assertEquals("Beauty Professional Test 1", result.get(0).getName());
    }

    @Test
    void getBeautyProfessionalById() {
        Long beautyProfessionalId = 1L;
        BeautyProfessional beautyProfessional = new BeautyProfessional();
        when(beautyProfessionalRepository.findById(beautyProfessionalId)).thenReturn(Optional.of(beautyProfessional));

        BeautyProfessional result = beautyProfessionalService.getBeautyProfessionalById(beautyProfessionalId);

        assertNotNull(result);
        assertEquals(beautyProfessional, result);
    }

    @Test
    void getBeautyProfessionalDtoById() {
        Long beautyProfessionalId = 1L;
        BeautyProfessional beautyProfessional = new BeautyProfessional();
        SimpleBeautyProfessionslDto expected = new SimpleBeautyProfessionslDto();
        when(beautyProfessionalRepository.findById(beautyProfessionalId)).thenReturn(Optional.of(beautyProfessional));
        when(beautyProfessionalMapper.BeautyProfessionalToSimpleBeautyProfessionalDto(beautyProfessional)).thenReturn(expected);

        SimpleBeautyProfessionslDto result = beautyProfessionalService.getBeautyProfessionalDtoById(beautyProfessionalId);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void saveBeautyProfessional() {
        BeautyProfessional beautyProfessional = new BeautyProfessional();
        when(beautyProfessionalRepository.save(beautyProfessional)).thenReturn(beautyProfessional);

        BeautyProfessional result = beautyProfessionalService.saveBeautyProfessional(beautyProfessional);

        assertNotNull(result);
        assertEquals(beautyProfessional, result);
    }

    @Test
    void deleteBeautyProfessional() {
        Long beautyProfessionalId = 1L;
        when(beautyProfessionalRepository.findById(beautyProfessionalId)).thenReturn(Optional.of(new BeautyProfessional()));

        boolean result = beautyProfessionalService.deleteBeautyProfessional(beautyProfessionalId);

        assertTrue(result);
        verify(beautyProfessionalRepository, times(1)).deleteById(beautyProfessionalId);
    }
}
