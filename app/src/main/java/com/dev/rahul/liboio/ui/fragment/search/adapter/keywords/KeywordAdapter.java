package com.dev.rahul.liboio.ui.fragment.search.adapter.keywords;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.ui.base.BaseAdapter;
import com.dev.rahul.liboio.ui.base.BaseHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by rahul on 28/1/18.
 */

public class KeywordAdapter extends BaseAdapter {

    private KeywordAdapterMVP.IKeywordAdapterPresenter presenter;

    public KeywordAdapter(KeywordAdapterMVP.IKeywordAdapterPresenter presenter) {
        super(presenter);
        this.presenter = presenter;

    }

    @Override
    public BaseHolder getHolder(ViewGroup parent, int viewType) {
        return new KeywordHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_keywords,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder((KeywordHolder) holder,position);
    }

    public class KeywordHolder extends BaseHolder implements KeywordAdapterMVP.IKeywordAdapterView {

        @BindView(R.id.tvKeyword)
        AppCompatTextView tvKeyword;

        public KeywordHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick(R.id.tvKeyword)
        public void onClickKeyword() {

        }

        @Override
        public void setKeywordText(String keyword) {
            tvKeyword.setText(keyword);
        }
    }
}
