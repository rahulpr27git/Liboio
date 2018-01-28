package com.dev.rahul.liboio.ui.fragment.search.adapter.search;

import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.ui.base.IBaseAdapterPresenter;

/**
 * Created by rahul on 27/1/18.
 */

public interface SearchAdapterMVP {

    interface ISearchAdapterView {
        void setName(String name);
        void setDescription(String description);
        void setGitDetails(String rank, String stars, String forks);
        void setReleaseDate(String date);
        void setVersion(String version);
        void setLicense(String license);
    }

    interface ISearchAdapterPresenter<T extends SearchAdapter.SearchHolder, E extends Projects>
            extends IBaseAdapterPresenter<T,E>{

    }
}
