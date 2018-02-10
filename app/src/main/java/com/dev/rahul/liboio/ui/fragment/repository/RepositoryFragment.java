package com.dev.rahul.liboio.ui.fragment.repository;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.ui.base.BaseFragment;

/**
 * create an instance of this fragment.
 */
public class RepositoryFragment extends BaseFragment {

    public static final String TAG = RepositoryFragment.class.getSimpleName();
    public static RepositoryFragment fragment;

    public RepositoryFragment() {
        // Required empty public constructor
    }

    public static RepositoryFragment newInstance(Bundle bundle) {
        if (fragment == null) {
            fragment = new RepositoryFragment();
            fragment.setArguments(bundle);
        }

        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_repository;
    }

    @Override
    public void onRefresh() {

    }
}
