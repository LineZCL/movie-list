package com.aline.movielist.movie.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aline.movielist.R;
import com.aline.movielist.movie.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView movieList;
    private MovieListAdapter movieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        movieList = (RecyclerView) findViewById(R.id.movies_list);
        layoutManager = new LinearLayoutManager(getBaseContext());

        movieListAdapter = new MovieListAdapter(generateMovieFakes(), getApplicationContext());
        movieList.setAdapter(movieListAdapter);

        movieList.setLayoutManager(layoutManager);
    }

    private List<Movie> generateMovieFakes(){
        List<Movie> movies = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Movie movie = new Movie();
            movie.setName("Filme " + i );
            movie.setSinopse("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam sed quam id elit maximus eleifend eget sit amet lorem. Sed rutrum sem quis viverra posuere. Aenean nec dui odio. Vestibulum eget diam ac orci pulvinar convallis. Integer sed aliquam nisl. ");

            movies.add(movie);
        }
        return movies;
    }
}
