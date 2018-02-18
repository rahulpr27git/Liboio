package com.dev.rahul.liboio.ui.activity.projects;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.ui.base.BaseActivity;
import com.dev.rahul.liboio.ui.fragment.search.SearchFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectsActivity extends BaseActivity {

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_projects;
    }

    @Override
    public int getFragmentContainerId() {
        return R.id.container;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        onAttachSwipeRefreshLayout(swipeRefresh);

        Bundle bundle = getBundleData();
        if (bundle != null) {
            Fragment fragment = new SearchFragment();
            fragment.setArguments(bundle);
            onReplaceFragment(fragment,SearchFragment.TAG);
        }

        enableBackButton();

    }

    @Override
    public void onRefresh() {

    }
}
