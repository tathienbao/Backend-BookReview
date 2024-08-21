package com.paf.bookreview.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.bookreview.backend.model.Book;
import com.paf.bookreview.backend.model.Review;
import com.paf.bookreview.backend.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public List<Review> getReviewsForBook(Book book) {
        return reviewRepository.findByBook(book);
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }
}
