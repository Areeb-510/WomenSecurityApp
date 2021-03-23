package com.example.womentrident;

public class User {

     private String number;
     private String name;
     private int imageid;


    public User(String number, String name, int imageid) {
        this.number = number;
        this.name = name;
        this.imageid = imageid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
