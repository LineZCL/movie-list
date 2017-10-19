package com.aline.movielist.dagger.module;

import com.aline.movielist.service.ServiceGenerator;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class is intended to provide all required retrofit objects.
 *
 * Created by aline on 19/10/17.
 */


@Module
public class RetrofitModule {

    /**
     * Provide retrofit builder to access the services.
     * @return Retrofit.Builder
     */
    @Provides
    public Retrofit.Builder provideRetrofitBuilder(){
        return new Retrofit.Builder()
                .baseUrl(ServiceGenerator.API_URL)
                .addConverterFactory(GsonConverterFactory.create());
    }
}
