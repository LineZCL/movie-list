package com.aline.movielist.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by aline on 18/10/2017.
 */
public class ServiceGenerator {

    public static String API_URL = "https://api.themoviedb.org/3/";
    public static String API_TOKEN = "e9901fb8c398baa4b0b9f1585f2f930f";

    private static OkHttpClient.Builder getHttpClient() {
        return new OkHttpClient.Builder();
    }

    private static Retrofit.Builder getBuilder() {
        return new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create());
    }

    public static <T> T createService(Class<T> serviceClass) {
        OkHttpClient.Builder okHttpClient = getHttpClient();
        Retrofit retrofit = getBuilder().client(okHttpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}