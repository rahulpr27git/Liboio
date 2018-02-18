package com.dev.rahul.liboio.ui.activity.project_details;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.dev.rahul.liboio.ui.base.BasePresenter;
import com.dev.rahul.liboio.ui.fragment.contributor.ContributorsFragment;
import com.dev.rahul.liboio.ui.fragment.dependencies.DependenciesFragment;
import com.dev.rahul.liboio.ui.fragment.dependents.DependentsFragment;
import com.dev.rahul.liboio.ui.fragment.details.DetailsFragment;
import com.dev.rahul.liboio.ui.fragment.repository.RepositoryFragment;
import com.dev.rahul.liboio.utility.LibConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 3/2/18.
 */

public class ProjectDetailsPresenter<V extends ProjectDetailsMVP.IProjectDetailsView>
        extends BasePresenter<V> implements ProjectDetailsMVP.IProjectDetailsPresenter<V> {

    public static final String TAG = ProjectDetailsPresenter.class.getSimpleName();

    private ProjectDetailsMVP.IProjectDetailsRepository repository;

    public ProjectDetailsPresenter() {
        this.repository = new ProjectDetailsRepository();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void fetchAndSetDataFromIntent() {
        Bundle bundle = getBaseView().getBundleData();
        if (bundle != null) {
            if (bundle.containsKey(LibConstants.NAME))
                getBaseView().setSubTitle(bundle.getString(LibConstants.NAME));
        }
    }

    @Override
    public void setBottomNavMenuItems() {

        int[] drawables = repository.getNavDrawables();
        String[] titles = repository.getNavTitles();

        List<AHBottomNavigationItem> itemList = new ArrayList<>();

        for (int i = 0 ; i < drawables.length ; i++) {
            itemList.add(new AHBottomNavigationItem(
                    titles[i],drawables[i]
            ));
        }

        getBaseView().setUpBottomNav(itemList);
    }

    @Override
    public void onTabSelected(int pos, boolean wasSelected) {
        Fragment fragment = repository.getFragment(getBaseView().getBundleData())[pos];

        if (fragment instanceof DetailsFragment)
            getBaseView().onReplaceFragment(fragment, DetailsFragment.TAG);
        else if (fragment instanceof DependentsFragment)
            getBaseView().onReplaceFragment(fragment, DependentsFragment.TAG);
        else if (fragment instanceof DependenciesFragment)
            getBaseView().onReplaceFragment(fragment, DependenciesFragment.TAG);
        else if (fragment instanceof ContributorsFragment)
            getBaseView().onReplaceFragment(fragment, ContributorsFragment.TAG);
        else if (fragment instanceof RepositoryFragment)
            getBaseView().onReplaceFragment(fragment, RepositoryFragment.TAG);
    }
}
