package com.aline.movielist.core;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by aline on 18/10/2017.
 */
public class BaseRepository {
    protected List<Call> requests;

    public BaseRepository() {
        requests = new ArrayList<>();
    }

    public void cancelAll() {
        for (Call call : requests) {
            if (!call.isCanceled()) {
                call.cancel();
            }
        }
    }
}
