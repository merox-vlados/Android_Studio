package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("movie?field=rating.kp&search=7-10&sortField=votes.kp&sortType=-1&page=2&limit=40&token=SZ023GX-0Q9414N-N0J1M9R-DRJZB1F")
    Single<MovieResponse> loadMovies();
}
