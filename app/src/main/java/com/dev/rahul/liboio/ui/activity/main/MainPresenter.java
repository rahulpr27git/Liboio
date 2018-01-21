package com.dev.rahul.liboio.ui.activity.main;

import android.util.Log;

import com.dev.rahul.liboio.pojo.Platforms;
import com.dev.rahul.liboio.ui.base.BasePresenter;

import java.util.Collections;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by rahul on 6/1/18.
 */

public class MainPresenter<V extends MainMVP.IMainView> extends BasePresenter<V> implements MainMVP.IMainPresenter<V> {

    private final String TAG = MainPresenter.class.getSimpleName();

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MainRepository repository;

    public MainPresenter(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void loadPlatforms() {
        getBaseView().onShowLoading();
        compositeDisposable.add(repository.getPlatforms()
                .onErrorReturn(new Function<Throwable, List<Platforms>>() {
                    @Override
                    public List<Platforms> apply(Throwable throwable) throws Exception {
                        getBaseView().onHideLoading();
                        getBaseView().onError(throwable.getMessage());
                        return Collections.emptyList();
                    }
                })
                .subscribe(new Consumer<List<Platforms>>() {
                    @Override
                    public void accept(List<Platforms> platforms) throws Exception {
                        getBaseView().onHideLoading();
                        getBaseView().inflateData(platforms);
                        Log.e(TAG, "loadPlatforms size = > " + platforms.size());
                    }
                }));
    }

    @Override
    public void onDestroy() {
        onDetach();
        compositeDisposable.clear();
    }
}
