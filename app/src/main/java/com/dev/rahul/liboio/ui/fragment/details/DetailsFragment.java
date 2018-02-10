package com.dev.rahul.liboio.ui.fragment.details;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.ui.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DetailsFragment extends BaseFragment {

    public static final String TAG = DetailsFragment.class.getSimpleName();
    public static DetailsFragment fragment;

    public DetailsFragment() {
        // Required empty public constructor
    }

    public static DetailsFragment newInstance(Bundle bundle) {
        if (fragment == null) {
            fragment = new DetailsFragment();
            fragment.setArguments(bundle);
        }

        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
    }

    @Override
    public void onRefresh() {

    }
}
