package com.example.lenovo.clickonlistitemthroughinterface;

/**
 * Created by lenovo on 19/02/2018.
 */

public class ModelClass {

    String string;
    int image;

    public ModelClass(String string,int image) {
        this.image = image;
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public int getImage(){
        return image;
    }
    void changeText(String s){
        this.string = s;
    }
}
