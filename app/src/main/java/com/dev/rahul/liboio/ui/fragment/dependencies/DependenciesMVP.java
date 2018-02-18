package com.dev.rahul.liboio.ui.fragment.dependencies;

import com.dev.rahul.liboio.pojo.Dependencies;
import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.ui.base.IBasePresenter;
import com.dev.rahul.liboio.ui.base.IBaseView;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by rahul on 12/2/18.
 */

public class DependenciesMVP {

    interface IDependenciesView extends IBaseView {
        void showDependencies(List<Dependencies> list);
    }

    interface IDependenciesPresenter<V extends IDependenciesView> extends IBasePresenter<V> {
        void loadDependencies();
    }

    interface IDependenciesRepository {
        Single<Projects> getProjectDependencies(String platform, String name);
    }
}
