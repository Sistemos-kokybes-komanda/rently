package com.example.rently.Services;

import com.example.rently.Entities.ReviewsEntity;
import com.example.rently.Repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {
    @Autowired
    private ReviewsRepository reviewsRepository;

    public ReviewsEntity saveReview(ReviewsEntity review){
        return reviewsRepository.save(review);
    }

    public List<ReviewsEntity> getAllReviews() {
        return reviewsRepository.findAll();
    }

    public ReviewsEntity getReviewById(int id) {
        Optional<ReviewsEntity> optionalReview = reviewsRepository.findById(id);
        return optionalReview.orElse(null);
    }

    public ReviewsEntity updateReview(int id, ReviewsEntity updatedReview) {
        if (reviewsRepository.existsById(id)) {
            updatedReview.setId(id);
            return reviewsRepository.save(updatedReview);
        } else {
            return null;
        }
    }
    public void deleteReview(int id) {
        reviewsRepository.deleteById(id);
    }
}
