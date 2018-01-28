package com.dev.rahul.liboio.ui.fragment.search;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.ui.base.BaseFragment;
import com.dev.rahul.liboio.ui.fragment.search.adapter.search.SearchAdapter;
import com.dev.rahul.liboio.ui.fragment.search.adapter.search.SearchAdapterPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment implements SearchMVP.ISearchView {

    public static final String TAG = SearchFragment.class.getSimpleName();

    @BindView(R.id.recyclerProjects)
    RecyclerView recyclerProjects;

    private SearchPresenter presenter;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_search;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        recyclerProjects.setHasFixedSize(true);
        recyclerProjects.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        presenter = new SearchPresenter(new SearchRepository());
        presenter.onAttach(this);

        presenter.searchWithPlatformName();

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void showSearchResult(List<Projects> list) {
        recyclerProjects.setAdapter(
                new SearchAdapter(new SearchAdapterPresenter(list),this)
        );
    }
}
