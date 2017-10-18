package com.aline.movielist.movie.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aline on 18/10/2017.
 */
public class Movie {
    private Integer id;

    @SerializedName("title")
    private String name;
    @SerializedName("overview")
    private String synopsis;
    @SerializedName("poster_path")
    private String imageId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }
}
