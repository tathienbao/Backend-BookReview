package com.paf.bookreview.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.bookreview.backend.dto.ReviewDTO;
import com.paf.bookreview.backend.model.Book;
import com.paf.bookreview.backend.model.Review;
import com.paf.bookreview.backend.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<ReviewDTO> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ReviewDTO> getReviewsForBook(Book book) {
        return reviewRepository.findByBook(book).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    private ReviewDTO convertToDTO(Review review) {
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setContent(review.getContent());
        dto.setUserId(review.getUser().getId());
        dto.setBookId(review.getBook().getId());
        dto.setRating(review.getRating());
        return dto;
    }
}
