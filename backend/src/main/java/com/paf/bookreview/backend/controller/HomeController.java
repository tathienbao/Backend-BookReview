package com.paf.bookreview.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "[Welcome to the Book Review Application API]...... Use /api/books.json; /api/users.json; /api/reviews.json to see the examples...... Use /books; /users; /reviews to see the actual data";
    }
}
