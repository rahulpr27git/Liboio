package com.dev.rahul.liboio.ui.fragment.dependencies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.ui.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DependenciesFragment extends BaseFragment {

    public static final String TAG = DependenciesFragment.class.getSimpleName();
    public static DependenciesFragment fragment;

    public DependenciesFragment() {
        // Required empty public constructor
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
    public void onRefresh() {

    }
}
