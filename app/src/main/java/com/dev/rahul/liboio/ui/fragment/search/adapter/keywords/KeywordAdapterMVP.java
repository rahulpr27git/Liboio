package com.dev.rahul.liboio.ui.fragment.search.adapter.keywords;

import com.dev.rahul.liboio.ui.base.IBaseAdapterPresenter;

/**
 * Created by rahul on 28/1/18.
 */

public class KeywordAdapterMVP {

    interface IKeywordAdapterView {
        void setKeywordText(String keyword);
    }

    interface IKeywordAdapterPresenter extends IBaseAdapterPresenter {

    }
}
