package com.aline.movielist.service;

/**
 * Created by aline on 18/10/2017.
 */
public interface RepositoryResponseListener<T, E> {
    void onSuccess(T result);
    void onError(E error);
}
