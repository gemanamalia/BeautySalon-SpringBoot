package com.unibuc.beautysalon.entity;
import com.unibuc.beautysalon.validation.ValidRating;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ValidRating
    private int rating;
    @Length(max = 200)
    private String comment;
    @PastOrPresent(message = "The creation date must be a past or present date!")
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Constructors
    public Review() {
    }

    public Review(Client client, int rating, String comment) {
        this.client = client;
        this.rating = rating;
        this.comment = comment;
        this.timestamp = LocalDateTime.now();
    }

    public Review(Long id, int rating, String comment, LocalDateTime timestamp) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public Review(Long id, int rating, String comment) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
    }

    // Get and Set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

