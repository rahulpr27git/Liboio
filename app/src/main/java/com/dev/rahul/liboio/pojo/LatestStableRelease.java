package com.dev.rahul.liboio.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rahul on 21/1/18.
 */

public class LatestStableRelease {

    private Integer id = 0;

    @SerializedName("repository_id")
    private Integer repositoryId = 0;

    private String name = "";
    private String sha = "";
    private String kind = "";

    @SerializedName("published_at")
    private String publishedAt = "";

    @SerializedName("created_at")
    private String createdAt = "";

    @SerializedName("updated_at")
    private String updatedAt = "";
}
