package com.dev.rahul.liboio.ui.fragment.dependencies.adapter;

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.pojo.Dependencies;
import com.dev.rahul.liboio.ui.base.BaseAdapter;
import com.dev.rahul.liboio.ui.base.BaseHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rahul on 18/2/18.
 */

public class DependenciesAdapter<T extends DependenciesAdapter.DependenciesHolder, E extends Dependencies, P extends DependenciesAdapterPresenter<T,E>>
        extends BaseAdapter<T,E,P> {

    public DependenciesAdapter(P presenter) {
        super(presenter);
    }

    @Override
    public T getHolder(ViewGroup parent, int viewType) {
        return (T) new DependenciesHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_dependecies, parent, false)
        );
    }

    public class DependenciesHolder extends BaseHolder implements DependenciesAdapterMVP.IDependenciesView{

        @BindView(R.id.tvName)
        AppCompatTextView tvName;
        @BindView(R.id.tvPlatform)
        AppCompatTextView tvPlatform;
        @BindView(R.id.tvDeprecated)
        AppCompatTextView tvDeprecated;
        @BindView(R.id.tvOutdated)
        AppCompatTextView tvOutdated;
        @BindView(R.id.tvKindAndVersion)
        AppCompatTextView tvKindAndVersion;

        public DependenciesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void showName(String name) {
            tvName.setText(name);
        }

        @Override
        public void showPlatformName(String platform) {
            tvPlatform.setText(platform);
        }

        @Override
        public void showDeprecatedStatus(int color) {
            tvDeprecated.setBackgroundColor(
                    ResourcesCompat.getColor(tvDeprecated.getContext().getResources(),color,null)
            );
        }

        @Override
        public void showOutdatedStatus(int color) {
            tvOutdated.setBackgroundColor(
                    ResourcesCompat.getColor(tvOutdated.getContext().getResources(),color,null)
            );
        }

        @Override
        public void showVersionAndKind(String version, String kind) {
            tvKindAndVersion.setText("V"+version + " - " + "("+ kind+")");
        }
    }
}
