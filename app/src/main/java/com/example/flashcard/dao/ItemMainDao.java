package com.example.flashcard.dao;

import android.widget.ImageView;
import android.widget.TextView;

public class ItemMainDao {

    private String textInfo;

    public ItemMainDao(String textInfo){
        this.textInfo = textInfo;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }
}
