package com.dev.rahul.liboio.ui.activity.main;

import com.dev.rahul.liboio.api.Libraries;
import com.dev.rahul.liboio.api.LibrariesService;
import com.dev.rahul.liboio.pojo.Platforms;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rahul on 6/1/18.
 */

public class MainRepository implements MainMVP.IMainRepositoryListener {
    @Override
    public Single<List<Platforms>> getPlatforms() {
        return LibrariesService.LIBRARIES_SERVICE.getPlatforms(Libraries.getAPIKey())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
