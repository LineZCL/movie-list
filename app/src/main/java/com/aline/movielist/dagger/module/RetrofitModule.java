package com.aline.movielist.dagger.module;

import com.aline.movielist.service.ServiceGenerator;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aline on 19/10/17.
 */


@Module
public class RetrofitModule {

    @Provides
    public Retrofit.Builder provideRetrofitBuilder(){
        return new Retrofit.Builder()
                .baseUrl(ServiceGenerator.API_URL)
                .addConverterFactory(GsonConverterFactory.create());
    }
}
