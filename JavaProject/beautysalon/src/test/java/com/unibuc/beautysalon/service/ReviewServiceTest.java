package com.unibuc.beautysalon.service;

import com.unibuc.beautysalon.dto.SimpleReviewDto;
import com.unibuc.beautysalon.entity.Client;
import com.unibuc.beautysalon.entity.Review;
import com.unibuc.beautysalon.repository.ClientRepository;
import com.unibuc.beautysalon.repository.ReviewRepository;
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
public class ReviewServiceTest {
    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ReviewService reviewService;

    private Review testReview;
    @BeforeEach
    public void setUp() {
        testReview = new Review();
        testReview.setId(1L);
        testReview.setComment("Test comment 1");
        testReview.setRating(1);
    }

    @Test
    public void testGetAllReviews() {
        List<Review> reviewList = Arrays.asList(testReview, new Review(2L, 2, "Test comment 2"));
        Mockito.when(reviewRepository.findAll()).thenReturn(reviewList);

        List<Review> result = reviewService.getAllReviews();

        assertEquals(2, result.size());
        assertEquals("Test comment 1", result.get(0).getComment());
    }

    @Test
    public void testCreateReview() {
        SimpleReviewDto simpleReviewDto = new SimpleReviewDto();
        simpleReviewDto.setRating(5);
        simpleReviewDto.setComment("Great service");
        simpleReviewDto.setClientId(3L);

        Client mockClient = new Client();
        mockClient.setId(1L);
        when(clientRepository.findById(3L)).thenReturn(Optional.of(mockClient));

        Review result = reviewService.createReview(simpleReviewDto);

        assertEquals(5, result.getRating());
        assertEquals("Great service", result.getComment());
        assertEquals(mockClient, result.getClient());
    }

    @Test
    public void testDeleteReview() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(new Review()));

        boolean result = reviewService.deleteReview(1L);

        assertEquals(true, result);
        verify(reviewRepository, times(1)).deleteById(1L);
    }
}
