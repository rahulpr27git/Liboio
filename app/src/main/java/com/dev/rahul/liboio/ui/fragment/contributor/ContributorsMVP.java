package com.dev.rahul.liboio.ui.fragment.contributor;

import com.dev.rahul.liboio.pojo.Contributors;
import com.dev.rahul.liboio.ui.base.IBasePresenter;
import com.dev.rahul.liboio.ui.base.IBaseView;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by rahul on 11/2/18.
 */

public interface ContributorsMVP {

    interface IContributorsView extends IBaseView {

    }

    interface IContributorsPresenter<V extends IContributorsView> extends IBasePresenter<V> {
        void fetchContributorsList();
    }

    interface IContributorsRepository {
        Single<List<Contributors>> getContributorsList(String platformName, String projectName, String apiKey);
    }
}
