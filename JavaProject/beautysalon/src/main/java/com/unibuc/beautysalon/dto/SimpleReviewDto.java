package com.unibuc.beautysalon.dto;

import com.unibuc.beautysalon.validation.ValidRating;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class SimpleReviewDto {
    private Long id;

    @NotNull
    @ValidRating
    private int rating;
    @NotNull
    @Length(max = 200, message = "Review comment has max length 200!")
    private String comment;
    @NotNull
    private Long clientId;


    // Constructors
    public SimpleReviewDto() {
    }

    public SimpleReviewDto(Long id, int rating, String comment, Long clientId) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.clientId = clientId;
    }

    // Get and Set
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
