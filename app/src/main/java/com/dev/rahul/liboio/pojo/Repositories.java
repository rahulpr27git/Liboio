package com.dev.rahul.liboio.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rahul on 10/2/18.
 */

public class Repositories {

    @SerializedName("full_name")
    private String fullName = "";

    private String description = "";
    private Boolean fork = false;

    @SerializedName("created_at")
    private String createdAt = "";

    @SerializedName("updated_at")
    private String updatedAt = "";

    @SerializedName("pushed_at")
    private String pushedAt;

    private String homepage;
    private Integer size = 0;
    /**
     * {
     "stargazers_count": 57994,
     "language": "JavaScript",
     "has_issues": true,
     "has_wiki": true,
     "has_pages": false,
     "forks_count": 28772,
     "mirror_url": null,
     "open_issues_count": 640,
     "default_branch": "master",
     "subscribers_count": 4404,
     "uuid": "460078",
     "source_name": null,
     "license": "MIT",
     "private": false,
     "contributions_count": 1278,
     "has_readme": "README.closure.md",
     "has_changelog": "CHANGELOG.md",
     "has_contributing": "CONTRIBUTING.md",
     "has_license": "LICENSE",
     "has_coc": null,
     "has_threat_model": null,
     "has_audit": null,
     "status": null,
     "last_synced_at": "2017-12-31T18:19:30.642Z",
     "rank": 24,
     "host_type": "GitHub",
     "host_domain": null,
     "name": null,
     "scm": "git",
     "fork_policy": null,
     "github_id": "460078",
     "pull_requests_enabled": null,
     "logo_url": null,
     "github_contributions_count": 1278,
     "keywords": [

     ]
     }
     */
}
