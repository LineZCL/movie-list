package com.aline.movielist.movie.repository;

import android.util.Log;

import com.aline.movielist.core.BaseRepository;
import com.aline.movielist.movie.model.response.MoviesResponse;
import com.aline.movielist.service.RepositoryResponseListener;
import com.aline.movielist.service.ServiceGenerator;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class of interactions with the service
 * Created by aline on 18/10/2017.
 */
public class MovieRepository extends BaseRepository{

    @Inject
    ServiceGenerator serviceGenerator;

    @Inject
    public MovieRepository() {
    }

    /**
     * Search for movies on the service
     * @param listener
     * @param page
     */
    public void getMovies(final RepositoryResponseListener<MoviesResponse, String> listener, Integer page){
        MovieClient movieClient = serviceGenerator.createService(MovieClient.class);
        Call<MoviesResponse> call = movieClient.getMovies(ServiceGenerator.API_TOKEN, page);
        requests.add(call);

        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if(response.code() != 200){
                    String error = response.code() + " - " + response.errorBody().source();
                    Log.d("[Movie - ERROR]", error);
                    listener.onError(error);
                }
                else {
                    listener.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                t.printStackTrace();
                Log.d("[Movie - ERROR]", t.getMessage());
                listener.onError(t.getMessage());
            }
        });
    }
}
