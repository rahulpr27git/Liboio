package com.dev.rahul.liboio.ui.activity.main.adapter;

import com.dev.rahul.liboio.pojo.Platforms;
import com.dev.rahul.liboio.ui.base.IBaseAdapterPresenter;

/**
 * Created by rahul on 20/1/18.
 */

public interface PlatformsAdapterMVP {

    interface IPlatformAdapterView {

        void setName(String name);
        void setDefaultLanguage(String defaultLanguage);
        void setUrl(String url);
        void setProjects(String counts);
    }

    interface IPlatformsAdapterPresenter<T extends PlatformsAdapter.PlatformHolder, E extends Platforms>
            extends IBaseAdapterPresenter<T,E> {

    }
}
