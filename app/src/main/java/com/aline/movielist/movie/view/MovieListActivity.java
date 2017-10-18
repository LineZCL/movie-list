package com.aline.movielist.movie.view;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aline.movielist.R;
import com.aline.movielist.movie.model.Movie;
import com.aline.movielist.movie.presenter.MoviePresenter;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends Activity implements MovieListener {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView movieList;
    private MovieListAdapter movieListAdapter;
    private MoviePresenter moviePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        movieList = findViewById(R.id.movies_list);
        layoutManager = new LinearLayoutManager(getBaseContext());
        movieList.setLayoutManager(layoutManager);


        moviePresenter = new MoviePresenter();
        moviePresenter.getMovies(this);
    }

    @Override
    public void fillMovies(List<Movie> movies) {
        if(movieListAdapter == null){
            movieListAdapter = new MovieListAdapter(movies, getApplicationContext());
            movieList.setAdapter(movieListAdapter);
        }
        else{
            movieListAdapter.setMovieList(movies);
            movieListAdapter.notifyDataSetChanged();
        }
    }
}
