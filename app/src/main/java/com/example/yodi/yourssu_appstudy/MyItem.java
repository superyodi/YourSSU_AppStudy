package com.example.yodi.yourssu_appstudy;

class MyItem {
    private int drawableId;
    private String title;
    private String description;

    public MyItem(int drawableId, String title, String description) {
        this.drawableId = drawableId;
        this.title = title;
        this.description = description;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
