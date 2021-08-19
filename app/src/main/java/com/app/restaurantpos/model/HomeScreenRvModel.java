package com.app.restaurantpos.model;

public class HomeScreenRvModel {

  public String txt;
  public int image;

  public HomeScreenRvModel(String txt, int image) {
    this.txt = txt;
    this.image = image;
  }

  public String getTxt() {
    return txt;
  }

  public void setTxt(String txt) {
    this.txt = txt;
  }

  public int getImage() {
    return image;
  }

  public void setImage(int image) {
    this.image = image;
  }
}
