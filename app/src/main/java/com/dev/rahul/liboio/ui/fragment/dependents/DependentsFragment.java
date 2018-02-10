package com.dev.rahul.liboio.ui.fragment.dependents;


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
public class DependentsFragment extends BaseFragment {
    
    public static final String TAG = DependentsFragment.class.getSimpleName();
    public static DependentsFragment fragment;

    public DependentsFragment() {
        // Required empty public constructor
    }

    public static DependentsFragment newInstance(Bundle bundle) {
        if (fragment == null) {
            fragment = new DependentsFragment();
            fragment.setArguments(bundle);
        }

        return fragment;
    }


    @Override
    public int getLayoutRes() {
        return R.layout.fragment_dependents;
    }

    @Override
    public void onRefresh() {

    }
}
