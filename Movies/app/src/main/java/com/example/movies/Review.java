package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("author")
    private String author;
    @SerializedName("review")
    private String review;
    @SerializedName("type")
    private String typeOfReview;

    public String getAuthor() {
        return author;
    }

    public String getReview() {
        return review;
    }

    public String getTypeOfReview() {
        return typeOfReview;
    }

    public Review(String author, String review, String typeOfReview) {
        this.author = author;
        this.review = review;
        this.typeOfReview = typeOfReview;
    }

    @Override
    public String toString() {
        return "Review{" +
                "author='" + author + '\'' +
                ", review='" + review + '\'' +
                ", typeOfReview='" + typeOfReview + '\'' +
                '}';
    }
}
