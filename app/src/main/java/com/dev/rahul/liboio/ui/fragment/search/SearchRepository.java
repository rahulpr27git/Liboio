package com.dev.rahul.liboio.ui.fragment.search;

import com.dev.rahul.liboio.api.LibrariesService;
import com.dev.rahul.liboio.pojo.Projects;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rahul on 27/1/18.
 */

public class SearchRepository implements SearchMVP.ISearchRepository {

    public static final String TAG = SearchRepository.class.getSimpleName();

    @Override
    public Single<List<Projects>> getProjects(HashMap<String, String> queryParams) {
        return LibrariesService.LIBRARIES_SERVICE.getProjectSearchResult(queryParams)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
