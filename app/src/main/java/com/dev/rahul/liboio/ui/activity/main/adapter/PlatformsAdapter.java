package com.dev.rahul.liboio.ui.activity.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.pojo.Platforms;
import com.dev.rahul.liboio.ui.activity.projects.ProjectsActivity;
import com.dev.rahul.liboio.ui.base.BaseAdapter;
import com.dev.rahul.liboio.ui.base.BaseHolder;
import com.dev.rahul.liboio.utility.LibConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by rahul on 14/1/18.
 */

public class PlatformsAdapter<T extends PlatformsAdapter.PlatformHolder, E extends Platforms, P extends PlatformsAdapterMVP.IPlatformsAdapterPresenter<T,E>>
        extends BaseAdapter<T,E,P> {

    private P presenter;
    private Context context;

    public PlatformsAdapter(P presenter, Context context) {
        super(presenter);
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public T getHolder(ViewGroup parent, int viewType) {
        return (T) new PlatformHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_platforms,parent,false)
        );
    }

    public class PlatformHolder extends BaseHolder implements PlatformsAdapterMVP.IPlatformAdapterView {

        @BindView(R.id.tvName)
        AppCompatTextView tvName;
        @BindView(R.id.tvDefaultLanguage)
        AppCompatTextView tvDefaultLanguage;
        @BindView(R.id.tvUrl)
        AppCompatTextView tvUrl;
        @BindView(R.id.tvCount)
        AppCompatTextView tvCount;

        public PlatformHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick(R.id.cardViewPlatforms)
        public void viewProjectList() {
            Intent intent = new Intent(context, ProjectsActivity.class);
            intent.putExtra(LibConstants.PLATFORMS, tvName.getText().toString());
            context.startActivity(intent);
        }

        @Override
        public void setName(String name) {
            tvName.setText(name);
        }

        @Override
        public void setDefaultLanguage(String defaultLanguage) {
            tvDefaultLanguage.setText(defaultLanguage);
        }

        @Override
        public void setUrl(String url) {
            tvUrl.setText(url);
        }

        @Override
        public void setProjects(String counts) {
            tvCount.setText(counts);
        }

        @Override
        public void setDynamicColor(String color) {
            tvCount.setBackgroundColor(Color.parseColor(color));
        }
    }
}
