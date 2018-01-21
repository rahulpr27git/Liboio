package com.dev.rahul.liboio.ui.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.Toast;

/**
 * Created by rahul on 4/1/18.
 */

public class BaseFragment extends Fragment implements IBaseView {

    private SwipeRefreshLayout swipeRefreshLayout;
    private View retryView;
    private View dataView;

    private Context context = getActivity();

    public void onAttachRefreshLayout(@NonNull SwipeRefreshLayout swipeRefreshLayout) {
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    public void onAttachRetryView(@NonNull View retryView) {
        this.retryView = retryView;
    }

    public void onAttachDataView(@NonNull View dataView) {
        this.dataView = dataView;
    }

    @Override
    public void onShowLoading() {
        swipeRefreshLayout.setRefreshing(true);
        retryView.setVisibility(View.GONE);
        dataView.setVisibility(View.GONE);
    }

    @Override
    public void onHideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFailed(@NonNull String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(@NonNull String error) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(@NonNull String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
