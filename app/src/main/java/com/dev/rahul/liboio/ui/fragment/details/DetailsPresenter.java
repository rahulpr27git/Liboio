package com.dev.rahul.liboio.ui.fragment.details;

import com.dev.rahul.liboio.ui.base.BasePresenter;

/**
 * Created by rahul on 10/2/18.
 */

public class DetailsPresenter<V extends DetailsMVP.IDetailsView> extends BasePresenter<V>
        implements DetailsMVP.IDetailsPresenter<V>{

    public static final String TAG = DetailsPresenter.class.getSimpleName();

    private DetailsMVP.IDetailsRepository repository;

    public DetailsPresenter(DetailsMVP.IDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onDestroy() {

    }
}
