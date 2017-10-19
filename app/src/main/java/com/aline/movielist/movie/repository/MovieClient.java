package com.aline.movielist.movie.repository;

import com.aline.movielist.movie.model.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Movie retrofit client.
 * Created by aline on 18/10/2017.
 */
public interface MovieClient {

    @GET("discover/movie")
    Call<MovieResponse> getMovies(@Query("api_key") String apiKey, @Query("page") Integer page);
}
