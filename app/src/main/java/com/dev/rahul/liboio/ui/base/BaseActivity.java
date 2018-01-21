package com.dev.rahul.liboio.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.dev.rahul.liboio.R;

import butterknife.BindView;

/**
 * Created by rahul on 4/1/18.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements IBaseView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    private View retryView;
    private View dataView;

    private Context context = this;

    public abstract int getLayoutRes();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
    }

    @Override
    public void onShowLoading() {
        if (swipeRefresh != null)
            swipeRefresh.setRefreshing(true);
        if (retryView != null)
            retryView.setVisibility(View.GONE);
        if (dataView != null)
            dataView.setVisibility(View.GONE);
    }

    @Override
    public void onHideLoading() {
        if (swipeRefresh != null)
            swipeRefresh.setRefreshing(false);
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
