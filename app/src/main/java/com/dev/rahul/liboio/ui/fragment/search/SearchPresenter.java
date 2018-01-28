package com.dev.rahul.liboio.ui.fragment.search;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.dev.rahul.liboio.api.Libraries;
import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.ui.base.BasePresenter;
import com.dev.rahul.liboio.utility.LibConstants;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by rahul on 27/1/18.
 */

public class SearchPresenter<V extends SearchMVP.ISearchView> extends BasePresenter<V>
        implements SearchMVP.ISearchPresenter<V> {

    public static final String TAG = SearchPresenter.class.getSimpleName();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private SearchRepository repository;

    public SearchPresenter(SearchRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onDestroy() {
        onDetach();
        compositeDisposable.clear();
    }

    @Override
    public void searchWithPlatformName() {
        Bundle bundle = getBaseView().getBundleData();
        if (bundle != null && bundle.containsKey(LibConstants.PLATFORMS)) {

            getBaseView().setSubTitle(bundle.getString(LibConstants.PLATFORMS)+"'s projects");

            HashMap<String,String> queryParams = new HashMap<>();
            queryParams.put(LibConstants.PLATFORMS, bundle.getString(LibConstants.PLATFORMS));
            queryParams.put(LibConstants.API_KEY, Libraries.getAPIKey());

            search(queryParams);
        }
    }

    @Override
    public void searchByQuery(String query) {

    }

    @Override
    public void search(@NonNull HashMap<String, String> queryParams) {
        getBaseView().onShowLoading();
        compositeDisposable.add(repository.getProjects(queryParams)
                .onErrorReturn(new Function<Throwable, List<Projects>>() {
                    @Override
                    public List<Projects> apply(Throwable throwable) throws Exception {
                        getBaseView().onHideLoading();
                        getBaseView().onError(throwable.getMessage());
                        return Collections.emptyList();
                    }
                }).subscribe(new Consumer<List<Projects>>() {
                    @Override
                    public void accept(List<Projects> list) throws Exception {
                        getBaseView().onHideLoading();
                        if (list.isEmpty()) {
                            getBaseView().onFailed("No projects available");
                        } else {
                            getBaseView().showSearchResult(list);
                        }
                    }
                }));
    }
}
