package com.dev.rahul.liboio.ui.fragment.dependencies;

import com.dev.rahul.liboio.api.Libraries;
import com.dev.rahul.liboio.api.LibrariesService;
import com.dev.rahul.liboio.pojo.Projects;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rahul on 12/2/18.
 */

public class DependenciesRepository implements DependenciesMVP.IDependenciesRepository {
    @Override
    public Single<Projects> getProjectDependencies(String platform, String name) {
        return LibrariesService.LIBRARIES_SERVICE
                .getProjectDependencies(platform, name, Libraries.getAPIKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
