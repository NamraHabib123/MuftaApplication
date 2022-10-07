package com.example.muftaapplication;

public class generalmodelclass {

    int picture,likesnumber;
    String title,pricetext,descriptiontext,validitydate;


    public generalmodelclass() {
    }

    public generalmodelclass(int picture, int likesnumber, String title, String pricetext, String descriptiontext, String validitydate) {
        this.picture = picture;
        this.likesnumber = likesnumber;
        this.title = title;
        this.pricetext = pricetext;
        this.descriptiontext = descriptiontext;
        this.validitydate = validitydate;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getLikesnumber() {
        return likesnumber;
    }

    public void setLikesnumber(int likesnumber) {
        this.likesnumber = likesnumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPricetext() {
        return pricetext;
    }

    public void setPricetext(String pricetext) {
        this.pricetext = pricetext;
    }

    public String getDescriptiontext() {
        return descriptiontext;
    }

    public void setDescriptiontext(String descriptiontext) {
        this.descriptiontext = descriptiontext;
    }

    public String getValiditydate() {
        return validitydate;
    }

    public void setValiditydate(String validitydate) {
        this.validitydate = validitydate;
    }
}
