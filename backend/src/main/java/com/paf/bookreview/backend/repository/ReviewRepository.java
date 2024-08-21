package com.paf.bookreview.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paf.bookreview.backend.model.Book;
import com.paf.bookreview.backend.model.Review;
import com.paf.bookreview.backend.model.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByBook(Book book);

    List<Review> findByUser(User user);
}
