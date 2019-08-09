package com.jahanshahi.itime.main;

import android.app.Activity;
import android.graphics.drawable.Drawable;

class MainItem {
    private Drawable background;
    private String title;
    private String description;
    private Class destination;

    public Class getDestination() {
        return destination;
    }

    public void setDestination(Class destination) {
        this.destination = destination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getBackground() {
        return background;
    }

    public void setBackground(Drawable background) {
        this.background = background;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
