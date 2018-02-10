package com.dev.rahul.liboio.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rahul on 4/2/18.
 */

public class Dependencies {

    @SerializedName("project_name")
    private String projectName;

    private String name;
    private String platform;
    private String requirements;

    @SerializedName("latest_stable")
    private String latestStable;

    private String latest;
    private String deprecated;
    private String outdated;
    private String filepath;
    private String kind;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getLatestStable() {
        return latestStable;
    }

    public void setLatestStable(String latestStable) {
        this.latestStable = latestStable;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public String getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(String deprecated) {
        this.deprecated = deprecated;
    }

    public String getOutdated() {
        return outdated;
    }

    public void setOutdated(String outdated) {
        this.outdated = outdated;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
