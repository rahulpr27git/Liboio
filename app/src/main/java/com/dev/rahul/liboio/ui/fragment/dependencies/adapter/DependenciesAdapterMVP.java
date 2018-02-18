package com.dev.rahul.liboio.ui.fragment.dependencies.adapter;

import com.dev.rahul.liboio.pojo.Dependencies;
import com.dev.rahul.liboio.ui.base.IBaseAdapterPresenter;

/**
 * Created by rahul on 18/2/18.
 */

public class DependenciesAdapterMVP {

    interface IDependenciesView {
        void showName(String name);
        void showPlatformName(String platform);
        void showDeprecatedStatus(int color);
        void showOutdatedStatus(int color);
        void showVersionAndKind(String version, String kind);
    }

    interface IDependenciesPresenter<T extends DependenciesAdapter.DependenciesHolder, E extends Dependencies>
            extends IBaseAdapterPresenter<T, E> {

    }
}
