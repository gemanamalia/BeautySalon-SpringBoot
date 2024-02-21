package com.unibuc.beautysalon.controller;
import com.unibuc.beautysalon.dto.SimpleReviewDto;
import com.unibuc.beautysalon.entity.Review;
import com.unibuc.beautysalon.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<SimpleReviewDto> createReview(@RequestBody SimpleReviewDto simpleReviewDto) {
        Review newReview = reviewService.createReview(simpleReviewDto);
        return ResponseEntity.ok(simpleReviewDto);
    }

    @GetMapping
    public ResponseEntity<List<SimpleReviewDto>> getAllReviewsAsDto() {
        List<SimpleReviewDto> reviewsDto = reviewService.getAllReviewsAsDto();
        return new ResponseEntity<>(reviewsDto, HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        boolean deleted = reviewService.deleteReview(reviewId);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
