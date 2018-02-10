package com.dev.rahul.liboio.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rahul on 21/1/18.
 */

public class Projects {

    private String name = "";
    private String platform = "";
    private String description = "";
    private String homeapage = "";

    @SerializedName("repository_url")
    private String repositoryUrl = "";

    @SerializedName("normalized_licenses")
    private List<String> normalizedLicenses;

    private Integer rank = 0;

    @SerializedName("latest_release_published_at")
    private String latestReleasePublishedAt = "";

    @SerializedName("latest_release_number")
    private String latestReleaseNumber = "";

    private String language = "";
    private String status = "";

    @SerializedName("package_manager_url")
    private String packageManagerUrl = "";

    private Integer stars = 0;
    private Integer forks = 0;
    private List<String> keywords;

    @SerializedName("latest_stable_release")
    private LatestStableRelease latestStableReleaseList;

    @SerializedName("dependencies")
    private List<Dependencies> dependenciesList;

    @SerializedName("dependents_count")
    private Integer dependentsCount = 0;

    @SerializedName("dependent_repos_count")
    private Integer dependentReposCount = 0;

    @SerializedName("versions")
    private List<Versions> versionsList;

    public Integer getDependentsCount() {
        return dependentsCount;
    }

    public void setDependentsCount(Integer dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    public Integer getDependentReposCount() {
        return dependentReposCount;
    }

    public void setDependentReposCount(Integer dependentReposCount) {
        this.dependentReposCount = dependentReposCount;
    }

    public List<Versions> getVersionsList() {
        return versionsList;
    }

    public void setVersionsList(List<Versions> versionsList) {
        this.versionsList = versionsList;
    }

    public List<Dependencies> getDependenciesList() {
        return dependenciesList;
    }

    public void setDependenciesList(List<Dependencies> dependenciesList) {
        this.dependenciesList = dependenciesList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHomeapage() {
        return homeapage;
    }

    public void setHomeapage(String homeapage) {
        this.homeapage = homeapage;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public List<String> getNormalizedLicenses() {
        return normalizedLicenses;
    }

    public void setNormalizedLicenses(List<String> normalizedLicenses) {
        this.normalizedLicenses = normalizedLicenses;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getLatestReleasePublishedAt() {
        return latestReleasePublishedAt;
    }

    public void setLatestReleasePublishedAt(String latestReleasePublishedAt) {
        this.latestReleasePublishedAt = latestReleasePublishedAt;
    }

    public String getLatestReleaseNumber() {
        return latestReleaseNumber;
    }

    public void setLatestReleaseNumber(String latestReleaseNumber) {
        this.latestReleaseNumber = latestReleaseNumber;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPackageManagerUrl() {
        return packageManagerUrl;
    }

    public void setPackageManagerUrl(String packageManagerUrl) {
        this.packageManagerUrl = packageManagerUrl;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Integer getForks() {
        return forks;
    }

    public void setForks(Integer forks) {
        this.forks = forks;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public LatestStableRelease getLatestStableReleaseList() {
        return latestStableReleaseList;
    }

    public void setLatestStableReleaseList(LatestStableRelease latestStableReleaseList) {
        this.latestStableReleaseList = latestStableReleaseList;
    }
}
