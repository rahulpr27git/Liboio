package com.dev.rahul.liboio.ui.fragment.contributor;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.pojo.Contributors;
import com.dev.rahul.liboio.ui.base.BaseFragment;
import com.dev.rahul.liboio.ui.fragment.contributor.adapter.ContributorsAdapter;
import com.dev.rahul.liboio.ui.fragment.contributor.adapter.ContributorsAdapterPresenter;
import com.dev.rahul.liboio.utility.EndlessRecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContributorsFragment extends BaseFragment implements ContributorsMVP.IContributorsView {

    public static final String TAG = ContributorsFragment.class.getSimpleName();

    @BindView(R.id.recyclerContributors)
    RecyclerView recyclerContributors;

    public static ContributorsFragment fragment;
    private ContributorsMVP.IContributorsPresenter presenter;
    private ContributorsAdapterPresenter contributorsAdapterPresenter;

    private int pageNumber = 1;

    public ContributorsFragment() {
        presenter = new ContributorsPresenter(new ContributorsRepository());
    }

    public static ContributorsFragment newInstance(Bundle bundle)  {

        if (fragment == null) {
            fragment = new ContributorsFragment();
            fragment.setArguments(bundle);
        }

        return fragment;
    }


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_contibutors;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        Log.e(TAG, "onViewCreated is called");

        recyclerContributors.setHasFixedSize(true);
        GridLayoutManager layout = new GridLayoutManager(getBaseContext(), 4);
        recyclerContributors.setLayoutManager(layout);
        recyclerContributors.setOnScrollListener(new EndlessRecyclerViewScrollListener(layout) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                ++pageNumber;
                presenter.fetchContributorsList();
            }
        });

        presenter.onAttach(this);
        presenter.fetchContributorsList();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState is called");
    }

    @Override
    public void onDestroyView() {
        Log.e(TAG, "onDestroyView is called");
        presenter.onDestroy();
        super.onDestroyView();
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void showContributors(List<Contributors> list) {
        contributorsAdapterPresenter = new ContributorsAdapterPresenter(list);
        recyclerContributors.setAdapter(new ContributorsAdapter(contributorsAdapterPresenter));
    }

    @Override
    public String getPageNumber() {
        return String.valueOf(pageNumber);
    }

    @Override
    public void addNewList(List<Contributors> list) {
        contributorsAdapterPresenter.addNewItems(list);
    }
}
