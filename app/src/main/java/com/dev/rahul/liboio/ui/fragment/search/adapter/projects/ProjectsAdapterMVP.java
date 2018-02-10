package com.dev.rahul.liboio.ui.fragment.search.adapter.projects;

import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.ui.base.IBaseAdapterPresenter;

import java.util.List;

/**
 * Created by rahul on 27/1/18.
 */

public interface ProjectsAdapterMVP {

    interface IProjectsAdapterView {
        void setName(String name);
        void setDescription(String description);
        void setGitDetails(String rank, String stars, String forks);
        void setReleaseDate(String date);
        void setVersion(String version);
        void setLicense(String license);
        void setKeywords(List<String> list);
    }

    interface IProjectsAdapterPresenter<T extends ProjectsAdapter.ProjectsHolder, E extends Projects>
            extends IBaseAdapterPresenter<T,E>{
    }
}
