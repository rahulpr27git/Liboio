package com.dev.rahul.liboio.ui.fragment.contributor;


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
public class ContributorsFragment extends BaseFragment {

    public static final String TAG = ContributorsFragment.class.getSimpleName();
    public static ContributorsFragment fragment;

    public ContributorsFragment() {
        // Required empty public constructor
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
    public void onRefresh() {

    }
}
