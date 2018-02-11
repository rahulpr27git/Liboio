package com.dev.rahul.liboio.ui.fragment.contributor;

import android.util.Half;
import android.util.Log;

import com.dev.rahul.liboio.api.LibrariesService;
import com.dev.rahul.liboio.pojo.Contributors;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rahul on 11/2/18.
 */

public class ContributorsRepository implements ContributorsMVP.IContributorsRepository {

    public static final String TAG = ContributorsRepository.class.getSimpleName();

    @Override
    public Single<List<Contributors>> getContributorsList(String platformName, String projectName,
                                                          HashMap<String,String> queryMap) {

        Log.e(TAG, "platform : " + platformName);
        Log.e(TAG, "project : " + projectName);
        Log.e(TAG, "api_key : " + queryMap.toString());

        return LibrariesService.LIBRARIES_SERVICE.getContributors(
                        platformName,
                        projectName,
                        queryMap
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
