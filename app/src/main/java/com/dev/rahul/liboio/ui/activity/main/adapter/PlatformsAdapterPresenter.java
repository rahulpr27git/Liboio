package com.dev.rahul.liboio.ui.activity.main.adapter;

import com.dev.rahul.liboio.pojo.Platforms;
import com.dev.rahul.liboio.ui.base.BaseAdapterPresenter;
import com.dev.rahul.liboio.utility.LibUtil;

import java.util.List;

/**
 * Created by rahul on 14/1/18.
 */

public class PlatformsAdapterPresenter<T extends PlatformsAdapter.PlatformHolder, E extends Platforms>
        extends BaseAdapterPresenter<T,E>
        implements PlatformAdapterMVP.IPlatformsAdapterPresenter<T,E> {

    public PlatformsAdapterPresenter(List<E> list) {
        super(list);
    }

    @Override
    public void onBind(T holder, int position) {
        E platforms = getElementAtPos(position);

        holder.setName(platforms.getName());
        holder.setDefaultLanguage(platforms.getDefaultLanguage());
        holder.setUrl(platforms.getHomePage());
        holder.setProjects(LibUtil.formattedCount(platforms.getProjectCount()));
    }

    @Override
    public void onRecycle(T holder) {

    }
}
