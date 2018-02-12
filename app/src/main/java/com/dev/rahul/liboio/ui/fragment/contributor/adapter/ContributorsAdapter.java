package com.dev.rahul.liboio.ui.fragment.contributor.adapter;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.ui.base.BaseAdapter;
import com.dev.rahul.liboio.ui.base.BaseHolder;
import com.dev.rahul.liboio.ui.base.IBaseAdapterPresenter;
import com.dev.rahul.liboio.utility.GlideApp;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rahul on 11/2/18.
 */

public class ContributorsAdapter extends BaseAdapter {

    private ContributorsAdapterPresenter presenter;

    public ContributorsAdapter(ContributorsAdapterPresenter presenter) {
        super(presenter);
        this.presenter = presenter;
    }

    @Override
    public BaseHolder getHolder(ViewGroup parent, int viewType) {
        return new ContributorsHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_contributor,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder((ContributorsHolder) holder,position);
    }

    public class ContributorsHolder extends BaseHolder  implements ContributorsAdapterMVP.IContributorsAdapterView{

        @BindView(R.id.imgContributors)
        AppCompatImageView imgContributors;

        public ContributorsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @Override
        public void setProfileImage(String url) {
            GlideApp.with(imgContributors.getContext())
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .thumbnail(0.25f)
                    .centerCrop()
                    .into(imgContributors);
        }
    }
}
