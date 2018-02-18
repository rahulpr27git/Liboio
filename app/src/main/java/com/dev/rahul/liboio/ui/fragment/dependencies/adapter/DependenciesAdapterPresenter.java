package com.dev.rahul.liboio.ui.fragment.dependencies.adapter;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.pojo.Dependencies;
import com.dev.rahul.liboio.ui.base.BaseAdapterPresenter;

import java.util.List;

/**
 * Created by rahul on 18/2/18.
 */

public class DependenciesAdapterPresenter<T extends DependenciesAdapter.DependenciesHolder, E extends Dependencies>
        extends BaseAdapterPresenter<T,E> implements DependenciesAdapterMVP.IDependenciesPresenter<T,E> {

    public DependenciesAdapterPresenter(List<E> list) {
        super(list);
    }

    @Override
    public void onBind(T holder, int position) {
        Dependencies model = getElementAtPos(position);
        holder.showName(model.getName());
        holder.showPlatformName(model.getPlatform());

        if (model != null && model.getDeprecated())
            holder.showDeprecatedStatus(android.R.color.holo_red_light);
        else
            holder.showDeprecatedStatus(R.color.secondaryTextColor);

        if (model != null && model.getOutdated())
            holder.showOutdatedStatus(android.R.color.holo_orange_light);
        else
            holder.showOutdatedStatus(R.color.secondaryTextColor);

        holder.showVersionAndKind(
                model.getLatestStable(),
                model.getKind()
        );
    }

    @Override
    public void onRecycle(T holder) {

    }
}
