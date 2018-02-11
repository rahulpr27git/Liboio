package com.dev.rahul.liboio.ui.fragment.contributor;

import android.os.Bundle;
import android.util.Log;

import com.dev.rahul.liboio.api.Libraries;
import com.dev.rahul.liboio.pojo.Contributors;
import com.dev.rahul.liboio.ui.base.BasePresenter;
import com.dev.rahul.liboio.ui.base.IBaseView;
import com.dev.rahul.liboio.utility.LibConstants;

import java.util.HashMap;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by rahul on 11/2/18.
 */

public class ContributorsPresenter<V extends ContributorsMVP.IContributorsView> extends BasePresenter<V>
        implements ContributorsMVP.IContributorsPresenter<V> {

    public static final String TAG = ContributorsPresenter.class.getSimpleName();

    private ContributorsMVP.IContributorsRepository repository;
    private CompositeDisposable compositeDisposable;

    public ContributorsPresenter(ContributorsMVP.IContributorsRepository repository) {
        this.repository = repository;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDestroy() {
        ContributorsFragment.fragment = null;
        compositeDisposable.clear();
        getBaseView().onDetachFragment(ContributorsFragment.TAG);
    }

    @Override
    public void fetchContributorsList() {
        Bundle bundle = getBaseView().getBundleData();
        if (bundle != null) {

            HashMap<String,String> queryMap = new HashMap<>();
            queryMap.put(LibConstants.API_KEY, Libraries.getAPIKey());
            queryMap.put(LibConstants.PER_PAGE, "30");
            queryMap.put(LibConstants.PAGE,getBaseView().getPageNumber());

            getBaseView().onShowLoading();

            DisposableSingleObserver<List<Contributors>> disposableSingleObserver = repository.getContributorsList(
                    bundle.getString(LibConstants.PLATFORM_NAME),
                    bundle.getString(LibConstants.NAME),
                    queryMap
            ).subscribeWith(new DisposableSingleObserver<List<Contributors>>() {
                @Override
                public void onSuccess(List<Contributors> contributors) {

                    if (getBaseView().getPageNumber().equals("1"))
                        getBaseView().showContributors(contributors);
                    else
                        getBaseView().addNewList(contributors);

                    getBaseView().onHideLoading();
                }

                @Override
                public void onError(Throwable e) {
                    getBaseView().onHideLoading();
                    getBaseView().onError(e.getMessage());
                    e.printStackTrace();
                }
            });

            compositeDisposable.add(disposableSingleObserver);

        } else {
            getBaseView().onError("Bundle data is missing");
        }
    }
}
