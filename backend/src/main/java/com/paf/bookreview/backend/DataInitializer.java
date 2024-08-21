package com.paf.bookreview.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.javafaker.Faker;
import com.paf.bookreview.backend.model.Book;
import com.paf.bookreview.backend.model.Review;
import com.paf.bookreview.backend.model.Role;
import com.paf.bookreview.backend.model.User;
import com.paf.bookreview.backend.repository.BookRepository;
import com.paf.bookreview.backend.repository.ReviewRepository;
import com.paf.bookreview.backend.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
@Profile("!test")
public class DataInitializer {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    private final Faker faker = new Faker();
    private final Random random = new Random();

    @PostConstruct
    @Transactional
    public void init() {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User(
                    faker.name().username(),
                    faker.internet().emailAddress(),
                    "password",
                    faker.name().fullName(),
                    Role.REVIEWER
            );
            users.add(user);
        }
        userRepository.saveAll(users);

        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Book book = new Book(
                    faker.book().title(),
                    faker.book().author(),
                    faker.code().isbn13(),
                    faker.book().publisher(),
                    LocalDate.of(faker.number().numberBetween(1900, 2023), faker.number().numberBetween(1, 12), faker.number().numberBetween(1, 28)),
                    faker.lorem().sentence(),
                    faker.book().genre(),
                    (float) faker.number().randomDouble(1, 1, 5),
                    faker.internet().url(),
                    faker.number().numberBetween(100, 1000)
            );
            books.add(book);
        }
        bookRepository.saveAll(books);

        List<Review> reviews = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Review review = new Review(
                    faker.lorem().paragraph(),
                    users.get(random.nextInt(users.size())),
                    books.get(random.nextInt(books.size())),
                    faker.number().numberBetween(1, 5)
            );
            reviews.add(review);
        }
        reviewRepository.saveAll(reviews);
    }
}
