package com.aline.movielist.dagger.component;

import com.aline.movielist.dagger.module.MovieModule;
import com.aline.movielist.dagger.module.RetrofitModule;
import com.aline.movielist.movie.view.MovieListActivity;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by aline on 19/10/17.
 */

@Component(modules = {AndroidInjectionModule.class, MovieModule.class, RetrofitModule.class})
public interface MyApplicationComponent{
    void inject (MovieListActivity movieListActivity);

}
