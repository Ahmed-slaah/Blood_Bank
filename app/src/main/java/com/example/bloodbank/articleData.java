package com.example.bloodbank;

public class articleData {
    private String title;
    private boolean like;

    public articleData() {
    }

    public articleData(String title, boolean like) {
        this.title = title;
        this.like = like;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }
}
