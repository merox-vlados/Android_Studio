package com.example.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    List<Review> reviews = new ArrayList<>();

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false;
        )
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);

        int colorId;
        switch (review.getTypeOfReview()) {
            case "Позитивный":
                colorId = android.R.color.holo_green_light;
            case "Негативный":
                colorId = android.R.color.holo_red_light;
            default:
                colorId = android.R.color.holo_purple;
        }

        holder.textViewAuthor.setText(review.getAuthor());

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }



    static class ReviewViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayoutReview;
        private TextView textViewAuthor;
        private TextView textViewReview;
        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutReview = itemView.findViewById(R.id.linearLayoutReview);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewReview = itemView.findViewById(R.id.textViewReview);
        }
    }
}
