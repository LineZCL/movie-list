package com.aline.movielist.core;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Base repository class with default operations, where all repositories need to extends this class.
 * Created by aline on 18/10/2017.
 */
public class BaseRepository {
    protected List<Call> requests;

    public BaseRepository() {
        requests = new ArrayList<>();
    }


    /**
     * Cancels all requests being processed by the service.
     */
    public void cancelAll() {
        for (Call call : requests) {
            if (!call.isCanceled()) {
                call.cancel();
            }
        }
    }
}
