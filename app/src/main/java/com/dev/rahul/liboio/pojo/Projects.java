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
    private List<LatestStableRelease> latestStableReleaseList;
}
