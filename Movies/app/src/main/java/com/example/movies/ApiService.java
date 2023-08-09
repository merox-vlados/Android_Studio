package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("v1.3/movie?field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&limit=40&token=SZ023GX-0Q9414N-N0J1M9R-DRJZB1F")
    Single<MovieResponse> loadMovies(@Query("page") int page);
    @GET("v1.3/movie/{id}?token=SZ023GX-0Q9414N-N0J1M9R-DRJZB1F")
    Single<TrailerResponse> loadTrailers(@Path("id") int id);

    @GET("v1/review?token=SZ023GX-0Q9414N-N0J1M9R-DRJZB1F")
    Single<ReviewResponse> loadReview(@Query("movieId") int id,
                                      @Query("page") int page);
}
