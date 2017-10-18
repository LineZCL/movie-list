package com.aline.movielist.movie.model.response;

import com.aline.movielist.movie.model.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Model that return of service
 * Created by aline on 18/10/2017.
 */
public class MovieResponse {
    private Integer page;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("results")
    private List<Movie> movies;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
