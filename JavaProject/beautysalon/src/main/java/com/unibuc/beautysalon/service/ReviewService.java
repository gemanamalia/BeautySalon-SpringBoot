package com.unibuc.beautysalon.service;

import com.unibuc.beautysalon.dto.SimpleReviewDto;
import com.unibuc.beautysalon.entity.Client;
import com.unibuc.beautysalon.entity.Review;
import com.unibuc.beautysalon.mapper.ReviewMapper;
import com.unibuc.beautysalon.repository.ReviewRepository;
import com.unibuc.beautysalon.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ClientRepository clientRepository;
    private final ReviewMapper reviewMapper;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ClientRepository clientRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.clientRepository = clientRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
    public List<SimpleReviewDto> getAllReviewsAsDto() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(reviewMapper::ReviewToSimpleReviewDto)
                .collect(Collectors.toList());
    }

    public Review getReviewById(Long reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        return optionalReview.orElse(null);
    }

    public Review createReview(SimpleReviewDto simpleReviewDto) {
        Review newReview = new Review();
        newReview.setRating(simpleReviewDto.getRating());
        newReview.setComment(simpleReviewDto.getComment());

        Long clientId = simpleReviewDto.getClientId();
        Client existingClient = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("No client with id " + clientId + "!"));
        newReview.setClient(existingClient);

        reviewRepository.save(newReview);
        return newReview;
    }

    public boolean deleteReview(Long reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            reviewRepository.deleteById(reviewId);
            return true;
        } else {
            return false;
        }
    }
}
