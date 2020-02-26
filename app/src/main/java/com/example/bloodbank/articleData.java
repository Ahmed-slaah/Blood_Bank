package com.example.bloodbank;

public class articleData {
    private String title;

    private int backImg;
    private int likeImg;
    private int dislikeImg ;

    public articleData() {
    }

    public articleData(String title, int backImg, int likeImg, int dislikeImg) {
        this.title = title;
        this.backImg = backImg;
        this.likeImg = likeImg;
        this.dislikeImg = dislikeImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBackImg() {
        return backImg;
    }

    public void setBackImg(int backImg) {
        this.backImg = backImg;
    }

    public int getLikeImg() {
        return likeImg;
    }

    public void setLikeImg(int likeImg) {
        this.likeImg = likeImg;
    }

    public int getDislikeImg() {
        return dislikeImg;
    }

    public void setDislikeImg(int dislikeImg) {
        this.dislikeImg = dislikeImg;
    }
}
