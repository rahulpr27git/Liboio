package com.dev.rahul.liboio.ui.fragment.search;

import android.support.annotation.NonNull;

import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.ui.base.IBasePresenter;
import com.dev.rahul.liboio.ui.base.IBaseResponseListener;
import com.dev.rahul.liboio.ui.base.IBaseView;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by rahul on 27/1/18.
 */

public interface SearchMVP {

    interface ISearchView extends IBaseView {
        void showSearchResult(List<Projects> list);
    }

    interface ISearchPresenter<V extends ISearchView> extends IBasePresenter<V> {
        void searchWithPlatformName();
        void searchByQuery(@NonNull String query);
        void search(@NonNull HashMap<String,String> queryParams);
    }

    interface ISearchRepository {

        Single<List<Projects>> getProjects(HashMap<String,String> queryParams);

        interface OnResponseListener extends IBaseResponseListener {

        }
    }
}
