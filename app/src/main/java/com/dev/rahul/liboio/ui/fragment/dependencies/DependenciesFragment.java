package com.dev.rahul.liboio.ui.fragment.dependencies;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.pojo.Dependencies;
import com.dev.rahul.liboio.ui.base.BaseFragment;
import com.dev.rahul.liboio.ui.fragment.dependencies.adapter.DependenciesAdapter;
import com.dev.rahul.liboio.ui.fragment.dependencies.adapter.DependenciesAdapterPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DependenciesFragment extends BaseFragment implements DependenciesMVP.IDependenciesView {

    public static final String TAG = DependenciesFragment.class.getSimpleName();

    @BindView(R.id.recyclerDependencies)
    RecyclerView recyclerDependencies;

    public static DependenciesFragment fragment;
    private DependenciesMVP.IDependenciesPresenter presenter;
    private DependenciesAdapterPresenter dependenciesAdapterPresenter;

    public DependenciesFragment() {
        presenter = new DependenciesPresenter(new DependenciesRepository());
    }

    public static DependenciesFragment newInstance(Bundle bundle) {
        if (fragment == null) {
            fragment = new DependenciesFragment();
            fragment.setArguments(bundle);
        }

        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_dependencies;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        recyclerDependencies.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recyclerDependencies.setHasFixedSize(true);

        presenter.onAttach(this);
        presenter.loadDependencies();
    }

    @Override
    public void onDestroyView() {
        presenter.onDestroy();
        super.onDestroyView();
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void showDependencies(List<Dependencies> list) {
        dependenciesAdapterPresenter = new DependenciesAdapterPresenter(list);
        recyclerDependencies.setAdapter(
                new DependenciesAdapter(dependenciesAdapterPresenter)
        );
    }
}
