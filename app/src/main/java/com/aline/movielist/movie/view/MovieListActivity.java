package com.aline.movielist.movie.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aline.movielist.MyApplication;
import com.aline.movielist.R;
import com.aline.movielist.movie.model.Movie;
import com.aline.movielist.movie.presenter.MoviePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MovieListActivity extends Activity implements MovieListener {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView movieList;

    @Inject
    MovieListAdapter movieListAdapter;

    @Inject
    MoviePresenter moviePresenter;

    private Boolean canAddMovies;

    int pastVisiblesItems, visibleItemCount, totalItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ((MyApplication) getApplication()).getMyApplicationComponent().inject(this);

        canAddMovies = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        movieList = findViewById(R.id.movies_list);
        layoutManager = new LinearLayoutManager(getBaseContext());
        movieList.setLayoutManager(layoutManager);

        moviePresenter.getMovies(this);

        movieList.addOnScrollListener(getMoreMovies);

        movieListAdapter.setMovieList(new ArrayList<Movie>());
        movieListAdapter.setContext(this.getApplicationContext());
        movieList.setAdapter(movieListAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        moviePresenter.cancelRequests();
    }

    private RecyclerView.OnScrollListener getMoreMovies = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            if (dy > 0) //check for scroll down
            {
                visibleItemCount = layoutManager.getChildCount();
                totalItemCount = layoutManager.getItemCount();
                pastVisiblesItems = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                    if (canAddMovies) {
                        canAddMovies = false;
                        moviePresenter.getMovies(MovieListActivity.this);
                    }
                }
            }
        }
    };


    @Override
    public void fillMovies(List<Movie> movies) {
        movieListAdapter.addMovieList(movies);
        movieListAdapter.notifyDataSetChanged();

        canAddMovies = true;
    }
}
