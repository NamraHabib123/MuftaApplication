package com.example.muftaapplication;

public class educationactivitymodelclass {

    int picture;
    String title,expiretime,expireon,dropdowntext,discounttext;

    public educationactivitymodelclass() {
    }

    public educationactivitymodelclass(int picture, String title, String expiretime, String expireon, String dropdowntext, String discounttext) {
        this.picture = picture;
        this.title = title;
        this.expiretime = expiretime;
        this.expireon = expireon;
        this.dropdowntext = dropdowntext;
        this.discounttext = discounttext;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(String expiretime) {
        this.expiretime = expiretime;
    }

    public String getExpireon() {
        return expireon;
    }

    public void setExpireon(String expireon) {
        this.expireon = expireon;
    }

    public String getDropdowntext() {
        return dropdowntext;
    }

    public void setDropdowntext(String dropdowntext) {
        this.dropdowntext = dropdowntext;
    }

    public String getDiscounttext() {
        return discounttext;
    }

    public void setDiscounttext(String discounttext) {
        this.discounttext = discounttext;
    }
}
