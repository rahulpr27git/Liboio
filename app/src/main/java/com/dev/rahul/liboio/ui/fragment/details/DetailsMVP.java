package com.dev.rahul.liboio.ui.fragment.details;

import com.dev.rahul.liboio.ui.base.IBasePresenter;
import com.dev.rahul.liboio.ui.base.IBaseView;

/**
 * Created by rahul on 10/2/18.
 */

public interface DetailsMVP {

    interface IDetailsView extends IBaseView {

    }

    interface IDetailsPresenter<V extends IDetailsView> extends IBasePresenter<V> {

    }

    interface IDetailsRepository {

    }
}
