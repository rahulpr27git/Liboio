package com.dev.rahul.liboio.ui.fragment.search;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.ui.base.BaseFragment;
import com.dev.rahul.liboio.ui.fragment.search.adapter.projects.ProjectsAdapter;
import com.dev.rahul.liboio.ui.fragment.search.adapter.projects.ProjectsAdapterPresenter;
import com.dev.rahul.liboio.utility.EndlessRecyclerViewScrollListener;

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

    private int pageNumber = 1;
    private SearchPresenter presenter;
    private ProjectsAdapterPresenter projectsAdapterPresenter;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_search;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);

        recyclerProjects.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        recyclerProjects.setLayoutManager(linearLayoutManager);
        recyclerProjects.setOnScrollListener(new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                ++pageNumber;
                presenter.searchWithPlatformName();
            }
        });

        presenter = new SearchPresenter(new SearchRepository());
        presenter.onAttach(this);

        presenter.searchWithPlatformName();

    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState is called");
    }

    @Override
    public void onRefresh() {
        pageNumber = 1;
        presenter.searchWithPlatformName();
    }

    @Override
    public void showSearchResult(List<Projects> list) {
        projectsAdapterPresenter = new ProjectsAdapterPresenter(list);
        recyclerProjects.setAdapter(new ProjectsAdapter(projectsAdapterPresenter, this));
    }

    @Override
    public void addMoreSearchResult(List<Projects> list) {
        projectsAdapterPresenter.addNewItems(list);
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }
}
