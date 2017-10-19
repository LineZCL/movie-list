package com.aline.movielist.movie.presenter;

import com.aline.movielist.movie.model.response.MoviesResponse;
import com.aline.movielist.movie.repository.MovieRepository;
import com.aline.movielist.movie.view.MovieListener;
import com.aline.movielist.service.RepositoryResponseListener;

import javax.inject.Inject;

/**
 * Class responsible for movie's business rules.
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

    /**
     * Get movies in repository.
     * @param movieListener
     */
    public void getMovies(final MovieListener movieListener){
        Integer currentPage = lastPage + 1;

        boolean shouldLoadMore = currentPage <= totalPages;
        if(shouldLoadMore) {
            movieRepository.getMovies(new RepositoryResponseListener<MoviesResponse, String>() {
                @Override
                public void onSuccess(MoviesResponse result) {
                    lastPage = result.getPage();
                    totalPages = result.getTotalPages();
                        movieListener.fillMovies(result.getMovies());
                }

                @Override
                public void onError(String error) {
                    movieListener.showError();
                }
            }, currentPage);
        }
    }

    /**
     * Cancel all requests.
     */
    public void cancelRequests(){
        movieRepository.cancelAll();
    }
}
