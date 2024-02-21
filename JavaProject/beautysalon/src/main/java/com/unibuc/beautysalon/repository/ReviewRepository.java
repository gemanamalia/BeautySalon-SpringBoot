package com.unibuc.beautysalon.repository;
import com.unibuc.beautysalon.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByRatingGreaterThan(int rating);
}
