package com.aline.movielist.movie.view;

import com.aline.movielist.movie.model.Movie;

import java.util.List;

/**
 * Created by aline on 18/10/2017.
 */
public interface MovieListener {

    void fillMovies(List<Movie> movies);
    void showError();
}
