package com.unibuc.beautysalon.mapper;

import com.unibuc.beautysalon.dto.SimpleReviewDto;
import com.unibuc.beautysalon.entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {
    // review -> dto
    public SimpleReviewDto ReviewToSimpleReviewDto(Review review) {
        return new SimpleReviewDto(review.getId(), review.getRating(), review.getComment(),  review.getClient().getId());
    }
}
