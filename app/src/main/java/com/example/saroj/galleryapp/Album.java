package com.example.saroj.galleryapp;

/**
 * Created by saroj on 2/3/2017.
 */

public class Album {
    private String id,title;
    public Album(){}
    public Album(String id,String title){
        this.setId(id);
        this.setTitle(title);

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
