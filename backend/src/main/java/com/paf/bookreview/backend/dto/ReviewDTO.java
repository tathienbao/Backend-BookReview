package com.paf.bookreview.backend.dto;

public class ReviewDTO {

    private Long id;
    private String content;
    private Long userId;
    private Long bookId;
    private int rating;

    public ReviewDTO() {
        // Default constructor
    }

    public ReviewDTO(Long id, String content, Long userId, Long bookId, int rating) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.bookId = bookId;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
