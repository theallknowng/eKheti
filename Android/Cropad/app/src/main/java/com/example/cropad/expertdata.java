package com.example.cropad;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class expertdata {
    String name;
    String title;
    String link;
//    ImageView imag;


    public expertdata(String name, String title, String link  ) {
        this.name = name;
        this.title = title;
        this.link = link;
//        this.imag = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
//
//    public ImageView getImag() {
//        return imag;
//    }
//
//    public void setImag(ImageView imag) {
//        this.imag = imag;
//    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
