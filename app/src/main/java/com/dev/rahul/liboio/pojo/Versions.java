package com.dev.rahul.liboio.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rahul on 21/1/18.
 */

public class Versions {

    private String number = "0";

    @SerializedName("published_at")
    private String publishedAt = "";

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
