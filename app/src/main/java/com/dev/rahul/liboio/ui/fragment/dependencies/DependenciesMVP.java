package com.dev.rahul.liboio.ui.fragment.dependencies;

import com.dev.rahul.liboio.ui.base.IBasePresenter;
import com.dev.rahul.liboio.ui.base.IBaseView;

/**
 * Created by rahul on 12/2/18.
 */

public class DependenciesMVP {

    interface IDependenciesView extends IBaseView {

    }

    interface IDependenciesPresenter<V extends IDependenciesView> extends IBasePresenter<V> {

    }

    interface IDependenciesRepsoitory {

    }
}
