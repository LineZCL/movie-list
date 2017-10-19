package com.aline.movielist.movie.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aline.movielist.R;
import com.aline.movielist.movie.model.Movie;
import com.aline.movielist.movie.presenter.MoviePresenter;

import java.util.List;

public class MovieListActivity extends Activity implements MovieListener {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView movieList;
    private MovieListAdapter movieListAdapter;
    private MoviePresenter moviePresenter;

    private Boolean canAddMovies;

    int pastVisiblesItems, visibleItemCount, totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        canAddMovies = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        movieList = findViewById(R.id.movies_list);
        layoutManager = new LinearLayoutManager(getBaseContext());
        movieList.setLayoutManager(layoutManager);


        moviePresenter = new MoviePresenter();
        moviePresenter.getMovies(this);

        movieList.addOnScrollListener(getMoreMovies);
    }


    private RecyclerView.OnScrollListener getMoreMovies = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (dy > 0) //check for scroll downc
            {
                visibleItemCount = layoutManager.getChildCount();
                totalItemCount = layoutManager.getItemCount();
                pastVisiblesItems = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                    if(canAddMovies) {
                        canAddMovies = false;
                        moviePresenter.getMovies(MovieListActivity.this);
                    }
                }
            }
        }
    };


    @Override
    public void fillMovies(List<Movie> movies) {
        if (movieListAdapter == null) {
            movieListAdapter = new MovieListAdapter(movies, getApplicationContext());
            movieList.setAdapter(movieListAdapter);
        } else {
            movieListAdapter.addMovieList(movies);
            movieListAdapter.notifyDataSetChanged();
        }

        canAddMovies = true;
    }
}
