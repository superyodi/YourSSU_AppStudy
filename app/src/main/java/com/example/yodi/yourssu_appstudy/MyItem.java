package com.example.yodi.yourssu_appstudy;

class MyItem {
    private int imageRes;
    private String title;

    public MyItem(int imageRes, String title) {
        this.imageRes = imageRes;
        this.title = title;

    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
