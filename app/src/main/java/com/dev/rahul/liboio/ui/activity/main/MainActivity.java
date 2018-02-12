package com.dev.rahul.liboio.ui.activity.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.pojo.Platforms;
import com.dev.rahul.liboio.ui.activity.main.adapter.PlatformsAdapter;
import com.dev.rahul.liboio.ui.activity.main.adapter.PlatformsAdapterPresenter;
import com.dev.rahul.liboio.ui.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMVP.IMainView {

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.recyclerPlatforms)
    RecyclerView recyclerPlatforms;

    private MainPresenter presenter;
    private Context context;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public int getFragmentContainerId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        onAttachSwipeRefreshLayout(swipeRefresh);
        context = this;

        getSupportActionBar().setSubtitle("Platforms");

        recyclerPlatforms.setLayoutManager(new LinearLayoutManager(context));
        recyclerPlatforms.setHasFixedSize(true);

        presenter = new MainPresenter(new MainRepository());
        presenter.onAttach(this);
        presenter.loadPlatforms();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void inflateData(List<Platforms> list) {
        recyclerPlatforms.setAdapter(
                new PlatformsAdapter(new PlatformsAdapterPresenter(list),context)
        );
    }

    @Override
    public void onRefresh() {
        presenter.loadPlatforms();
    }
}
