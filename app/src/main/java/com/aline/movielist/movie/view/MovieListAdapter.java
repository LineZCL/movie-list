package com.aline.movielist.movie.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aline.movielist.R;
import com.aline.movielist.helper.ImageHelper;
import com.aline.movielist.movie.model.Movie;

import java.util.List;

import javax.inject.Inject;

/**
 * Movie list adapter
 * Created by aline on 18/10/2017.
 */
public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieItemHolder> {

    private List<Movie> movieList;
    private Context context;
    private View root;

    @Inject
    public MovieListAdapter(){

    }

    @Override
    public MovieItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        root = LayoutInflater.from(context).inflate(R.layout.movie_item, null, false);
        return new MovieItemHolder(root);
    }

    @Override
    public void onBindViewHolder(MovieItemHolder holder, int position) {
        Movie movie = movieList.get(position);
        if (movie != null) {
            holder.txtNameMovie.setText(movie.getName());
            holder.txtSinopse.setText(movie.getSynopsis());
            ImageHelper.loadImage(holder.imgMovie, context, movie.getImageId());
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public void setContext(Context context){
        this.context = context;
    }

    public void addMovieList(List<Movie> movies) {

        this.movieList.addAll(movies);
    }

    public class MovieItemHolder extends RecyclerView.ViewHolder {
        private ImageView imgMovie;
        private TextView txtNameMovie;
        private TextView txtSinopse;

        public MovieItemHolder(View itemView) {
            super(itemView);

            imgMovie = (ImageView) itemView.findViewById(R.id.img_movie);
            txtNameMovie = (TextView) itemView.findViewById(R.id.txt_movie_name);
            txtSinopse = (TextView) itemView.findViewById(R.id.txt_sinopse);
        }
    }
}
