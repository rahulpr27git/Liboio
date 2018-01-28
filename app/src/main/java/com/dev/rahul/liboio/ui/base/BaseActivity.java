package com.dev.rahul.liboio.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by rahul on 4/1/18.
 */

public abstract class BaseActivity extends AppCompatActivity
        implements IBaseView, SwipeRefreshLayout.OnRefreshListener {

    private Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        setSwipeListener(this);
    }

    @Override
    public void setSwipeListener(SwipeRefreshLayout.OnRefreshListener listener) {
        if (getSwipeRefreshView() != null)
            getSwipeRefreshView().setOnRefreshListener(listener);
    }

    @Override
    public void enableBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void disableBackButton() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void setSubTitle(String subTitle) {
        getSupportActionBar().setSubtitle(subTitle);
    }

    @Override
    public void onShowLoading() {
        if (getSwipeRefreshView() != null)
            getSwipeRefreshView().setRefreshing(true);
        if (getRetryView() != null)
            getRetryView().setVisibility(View.GONE);
        if (getDataView() != null)
            getDataView().setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home)
            onBackPressed();

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onHideLoading() {
        if (getSwipeRefreshView() != null)
            getSwipeRefreshView().setRefreshing(false);
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

    @Override
    public void onAttachFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(getFragmentContainerId(),fragment,tag);
        fragmentTransaction.commit();

    }

    @Override
    public void onDetachFragment(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
    }

    @Override
    public Bundle getBundleData() {
        return getIntent() != null ? getIntent().getExtras() : null;
    }

    public abstract int getLayoutRes();
    public abstract int getFragmentContainerId();
    public abstract SwipeRefreshLayout getSwipeRefreshView();
    public abstract View getRetryView();
    public abstract View getDataView();
}
