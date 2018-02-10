package com.dev.rahul.liboio.ui.activity.project_details;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.dev.rahul.liboio.ui.base.IBasePresenter;
import com.dev.rahul.liboio.ui.base.IBaseView;

import java.util.List;

/**
 * Created by rahul on 3/2/18.
 */

public interface ProjectDetailsMVP {

    interface IProjectDetailsView extends IBaseView {
        void setUpBottomNav(List<AHBottomNavigationItem> itemList);
    }

    interface IProjectDetailsPresenter<V extends IProjectDetailsView> extends IBasePresenter<V> {
        void fetchAndSetDataFromIntent();
        void setBottomNavMenuItems();
        void onTabSelected(int pos, boolean wasSelected);
    }

    interface IProjectDetailsRepository {
        Fragment[] getFragment(Bundle bundle);
        int[] getNavDrawables();
        String[] getNavTitles();
    }
}
