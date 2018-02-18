package com.dev.rahul.liboio.ui.fragment.contributor.adapter;

import com.bumptech.glide.Glide;
import com.dev.rahul.liboio.api.Libraries;
import com.dev.rahul.liboio.pojo.Contributors;
import com.dev.rahul.liboio.ui.base.BaseAdapterPresenter;

import java.util.List;

/**
 * Created by rahul on 11/2/18.
 */

public class ContributorsAdapterPresenter<T extends ContributorsAdapter.ContributorsHolder, E extends Contributors>
        extends BaseAdapterPresenter<T,E> {


    public ContributorsAdapterPresenter(List<E> list) {
        super(list);
    }

    @Override
    public void onBind(T holder, int position) {
        Contributors contributors = getAllElements().get(position);
        holder.setProfileImage(Libraries.getGithubProfileUrl(contributors.getGithubId().toString()));
    }

    @Override
    public void onRecycle(T holder) {
        Glide.with(holder.imgContributors.getContext())
                .clear(holder.imgContributors);
    }
}
