package com.dev.rahul.liboio.ui.fragment.dependencies;

import android.os.Bundle;
import android.util.Log;

import com.dev.rahul.liboio.pojo.Dependencies;
import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.ui.base.BasePresenter;
import com.dev.rahul.liboio.utility.LibConstants;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by rahul on 12/2/18.
 */

public class DependenciesPresenter<V extends DependenciesMVP.IDependenciesView> extends BasePresenter<V>
        implements DependenciesMVP.IDependenciesPresenter<V> {

    public static final String TAG = DependenciesPresenter.class.getSimpleName();
    private CompositeDisposable compositeDisposable;
    private DependenciesMVP.IDependenciesRepository repository;

    public DependenciesPresenter(DependenciesMVP.IDependenciesRepository repository) {
        this.repository = repository;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDestroy() {
        DependenciesFragment.fragment = null;
        compositeDisposable.clear();
        getBaseView().onRemoveFragment(DependenciesFragment.TAG);
    }

    @Override
    public void loadDependencies() {

        Bundle bundle = getBaseView().getBundleData();
        if (bundle == null) {
            getBaseView().onError("Data is missing");
            return;
        } else {
            if (!bundle.containsKey(LibConstants.PLATFORM_NAME) || !bundle.containsKey(LibConstants.NAME)) {
                getBaseView().onError("Platform or project name is missing.");
                return;
            }
        }

        getBaseView().onShowLoading();

        DisposableSingleObserver<List<Dependencies>> disposableSingleObserver = repository.getProjectDependencies(
                bundle.getString(LibConstants.PLATFORM_NAME),
                bundle.getString(LibConstants.NAME)
        ).map(new Function<Projects, List<Dependencies>>() {
            @Override
            public List<Dependencies> apply(Projects projects) throws Exception {
                return projects.getDependenciesList();
            }
        }).subscribeWith(new DisposableSingleObserver<List<Dependencies>>() {
            @Override
            public void onSuccess(List<Dependencies> dependencies) {
                Log.e(TAG, "Dependencies size => " + dependencies.size());
                getBaseView().onHideLoading();
                getBaseView().showDependencies(dependencies);
            }

            @Override
            public void onError(Throwable e) {
                getBaseView().onHideLoading();
                getBaseView().onError(e.getMessage());
                e.printStackTrace();
            }
        });

        compositeDisposable.add(disposableSingleObserver);
    }
}
