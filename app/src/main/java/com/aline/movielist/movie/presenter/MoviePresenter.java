package com.aline.movielist.movie.presenter;

import com.aline.movielist.movie.model.response.MovieResponse;
import com.aline.movielist.movie.repository.MovieRepository;
import com.aline.movielist.movie.view.MovieListener;
import com.aline.movielist.service.RepositoryResponseListener;

import javax.inject.Inject;

/**
 * Created by aline on 18/10/2017.
 */
public class MoviePresenter {

    private Integer lastPage;
    private Integer totalPages;

    @Inject
    MovieRepository movieRepository;

    @Inject
    public MoviePresenter(){
        this.lastPage = 0;
        this.totalPages = 1;
    }

    public void getMovies(final MovieListener movieListener){
        Integer pageNow = lastPage + 1;

        if(pageNow <= totalPages) {
            movieRepository.getMovies(new RepositoryResponseListener<MovieResponse, String>() {
                @Override
                public void onSuccess(MovieResponse result) {
                    lastPage = result.getPage();
                    totalPages = result.getTotalPages();
                        movieListener.fillMovies(result.getMovies());
                }

                @Override
                public void onError(String error) {
                    ///TODO: Arrumar esquema de erro.
                }
            }, pageNow);
        }
    }
}
