package com.example.muftaapplication;

public class fragmenthomemodelclass {
    String imagetitle,availablediscounts;
    int picture;


    public fragmenthomemodelclass() {
    }

    public fragmenthomemodelclass(String imagetitle, String availablediscounts, int picture) {
        this.imagetitle = imagetitle;
        this.availablediscounts = availablediscounts;
        this.picture = picture;
    }


    public String getImagetitle() {
        return imagetitle;
    }

    public void setImagetitle(String imagetitle) {
        this.imagetitle = imagetitle;
    }

    public String getAvailablediscounts() {
        return availablediscounts;
    }

    public void setAvailablediscounts(String availablediscounts) {
        this.availablediscounts = availablediscounts;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
