package com.example.rently.Controllers;

import com.example.rently.Entities.ReviewsEntity;
import com.example.rently.Services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;
    @GetMapping("/reviews")
    public List<ReviewsEntity> getAllReviews() {
        return reviewsService.getAllReviews();
    }
    @GetMapping("/review/{id}")
    public ReviewsEntity getReviewById(@PathVariable int id) {
        return reviewsService.getReviewById(id);
    }
    @PostMapping("/review/save")
    public ReviewsEntity saveReview(@RequestBody ReviewsEntity review) {
        return reviewsService.saveReview(review);
    }
    @PutMapping("/review/update/{id}")
    public ReviewsEntity updateReview(@PathVariable int id, @RequestBody ReviewsEntity updatedReview) {
        return reviewsService.updateReview(id, updatedReview);
    }
    @DeleteMapping("/review/delete/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewsService.deleteReview(id);
    }
}
