package com.example.yodi.yourssu_appstudy;

public class Fruit {
    private String id;
    private String fruit_eng;
    private  String fruit_kor;

    public Fruit(String id, String fruit_eng, String fruit_kor) {
        this.id = id;
        this.fruit_eng = fruit_eng;
        this.fruit_kor = fruit_kor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFruit_eng() {
        return fruit_eng;
    }

    public void setFruit_eng(String fruit_eng) {
        this.fruit_eng = fruit_eng;
    }

    public String getFruit_kor() {
        return fruit_kor;
    }

    public void setFruit_kor(String fruit_kor) {
        this.fruit_kor = fruit_kor;
    }
}
