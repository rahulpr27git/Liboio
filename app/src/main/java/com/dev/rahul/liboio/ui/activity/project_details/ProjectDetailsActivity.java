package com.dev.rahul.liboio.ui.activity.project_details;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.ui.base.BaseActivity;
import com.dev.rahul.liboio.ui.fragment.contributor.ContributorsFragment;
import com.dev.rahul.liboio.ui.fragment.dependencies.DependenciesFragment;
import com.dev.rahul.liboio.ui.fragment.dependents.DependentsFragment;
import com.dev.rahul.liboio.ui.fragment.details.DetailsFragment;
import com.dev.rahul.liboio.ui.fragment.repository.RepositoryFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectDetailsActivity extends BaseActivity implements ProjectDetailsMVP.IProjectDetailsView, AHBottomNavigation.OnTabSelectedListener {

    public static final String TAG = ProjectDetailsActivity.class.getSimpleName();
    private String FRAGMENT_TAG = null;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bottomNav)
    AHBottomNavigation bottomNav;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    private ProjectDetailsMVP.IProjectDetailsPresenter presenter;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_project_details;
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
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Project");
        getSupportActionBar().setSubtitle("Details");
        enableBackButton();
        toolbar.getNavigationIcon().setColorFilter(
                ResourcesCompat.getColor(getResources(),android.R.color.white,null),
                PorterDuff.Mode.SRC_IN
        );

        presenter = new ProjectDetailsPresenter();
        presenter.onAttach(this);

        presenter.fetchAndSetDataFromIntent();
        presenter.setBottomNavMenuItems();

    }

    @Override
    public void setUpBottomNav(List<AHBottomNavigationItem> itemList) {
        bottomNav.addItems(itemList);
        bottomNav.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNav.setAccentColor(ResourcesCompat.getColor(getResources(),R.color.colorAccent,null));
        bottomNav.setOnTabSelectedListener(this);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        presenter.onTabSelected(position,wasSelected);
        return true;
    }

    @Override
    public void onRefresh() {

    }
}
