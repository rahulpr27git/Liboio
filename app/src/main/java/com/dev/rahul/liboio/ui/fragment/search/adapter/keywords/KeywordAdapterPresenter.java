package com.dev.rahul.liboio.ui.fragment.search.adapter.keywords;

import com.dev.rahul.liboio.ui.base.BaseAdapterPresenter;
import com.dev.rahul.liboio.ui.base.BaseHolder;

import java.util.List;

/**
 * Created by rahul on 28/1/18.
 */

public class KeywordAdapterPresenter extends BaseAdapterPresenter implements KeywordAdapterMVP.IKeywordAdapterPresenter{

    public KeywordAdapterPresenter(List<String> list) {
        super(list);
    }

    @Override
    public void onBind(BaseHolder holder, final int position) {
        final KeywordAdapter.KeywordHolder keywordHolder = (KeywordAdapter.KeywordHolder) holder;
        keywordHolder.setKeywordText("#"+getElementAtPos(position));
    }

    @Override
    public void onRecycle(BaseHolder holder) {

    }
}
