package com.aline.movielist.dagger.module;

import com.aline.movielist.movie.view.MovieListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by aline on 19/10/17.
 */

@Module
public abstract class MovieModule {
    @ContributesAndroidInjector
    abstract MovieListActivity contributeActivityInjector();}
