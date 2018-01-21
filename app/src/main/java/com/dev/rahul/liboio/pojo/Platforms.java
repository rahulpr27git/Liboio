package com.dev.rahul.liboio.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rahul on 7/1/18.
 */

public class Platforms {

    private String name = "";

    @SerializedName("project_count")
    private Integer projectCount = 0;

    @SerializedName("homepage")
    private String homePage = "";

    private String color = "";

    @SerializedName("default_language")
    private String defaultLanguage = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(Integer projectCount) {
        this.projectCount = projectCount;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }
}
