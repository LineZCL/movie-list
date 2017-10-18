package com.aline.movielist.movie.presenter;

import com.aline.movielist.movie.model.response.MovieResponse;
import com.aline.movielist.movie.repository.MovieRepository;
import com.aline.movielist.movie.view.MovieListener;
import com.aline.movielist.service.RepositoryResponseListener;

/**
 * Created by aline on 18/10/2017.
 */
public class MoviePresenter {

    public void getMovies(final MovieListener movieListener){
        MovieRepository movieRepository = new MovieRepository();

        movieRepository.getMovies(new RepositoryResponseListener<MovieResponse, String>() {
            @Override
            public void onSuccess(MovieResponse result) {
                movieListener.fillMovies(result.getMovies());
            }

            @Override
            public void onError(String error) {
                ///TODO: Arrumar esquema de erro.
            }
        });
    }
}
