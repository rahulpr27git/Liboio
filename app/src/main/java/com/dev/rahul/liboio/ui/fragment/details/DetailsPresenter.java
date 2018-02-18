package com.dev.rahul.liboio.ui.fragment.details;

import android.os.Bundle;

import com.dev.rahul.liboio.ui.base.BasePresenter;
import com.dev.rahul.liboio.utility.LibConstants;

import org.jsoup.nodes.Document;

import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by rahul on 10/2/18.
 */

public class DetailsPresenter<V extends DetailsMVP.IDetailsView> extends BasePresenter<V>
        implements DetailsMVP.IDetailsPresenter<V> {

    public static final String TAG = DetailsPresenter.class.getSimpleName();

    private CompositeDisposable compositeDisposable;
    private DetailsMVP.IDetailsRepository repository;

    public DetailsPresenter(DetailsMVP.IDetailsRepository repository) {
        this.repository = repository;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onDestroy() {
        DetailsFragment.fragment = null;
        compositeDisposable.clear();
        getBaseView().onRemoveFragment(DetailsFragment.TAG);
    }

    @Override
    public void fetchData() {
        Bundle bundle = getBaseView().getBundleData();

        if (bundle != null) {

            if (bundle.containsKey(LibConstants.DESCRIPTION))
                getBaseView().setDescription("description", bundle.getString(LibConstants.DESCRIPTION));

            if (bundle.containsKey(LibConstants.LICENCES))
                getBaseView().setLicense("licences", bundle.getString(LibConstants.LICENCES));

            if (bundle.containsKey(LibConstants.RANK))
                getBaseView().setRank(String.valueOf(bundle.getInt(LibConstants.RANK)));

        } else {
            getBaseView().onError("Data is empty");
        }
    }

    @Override
    public void fetchDocumentation() {
        Bundle bundle = getBaseView().getBundleData();

        if (bundle != null && bundle.containsKey(LibConstants.REPOSITORY_URL)) {

            getBaseView().onShowLoading();

            DisposableSingleObserver<String> disposableSingleObserver = repository.parseHtml(bundle.getString(LibConstants.REPOSITORY_URL))
                    .flatMap(new Function<Document, SingleSource<String>>() {
                        @Override
                        public SingleSource<String> apply(Document document) throws Exception {
                            getBaseView().setDocumentationTitle(document.title());
                            return repository.getDocumentationHtml(document);
                        }
                    }).subscribeWith(new DisposableSingleObserver<String>() {
                        @Override
                        public void onSuccess(String s) {
                            getBaseView().onHideLoading();
                            getBaseView().showDocumentation(s);
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
}
