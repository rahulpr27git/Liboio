package com.dev.rahul.liboio.ui.activity.main;

import com.dev.rahul.liboio.pojo.Platforms;
import com.dev.rahul.liboio.ui.base.IBasePresenter;
import com.dev.rahul.liboio.ui.base.IBaseResponseListener;
import com.dev.rahul.liboio.ui.base.IBaseView;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by rahul on 7/1/18.
 */

public interface MainMVP {

    interface IMainView extends IBaseView {
        void inflateData(List<Platforms> list);
    }

    interface IMainPresenter<V extends IMainView> extends IBasePresenter<V> {
        void loadPlatforms();
        void onDestroy();
    }

    interface IMainRepositoryListener {

        Single<List<Platforms>> getPlatforms();

        interface OnResponseListener extends IBaseResponseListener {

        }
    }
}
