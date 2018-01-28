package com.dev.rahul.liboio.ui.fragment.search.adapter.search;

import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.ui.base.BaseAdapterPresenter;
import com.dev.rahul.liboio.utility.LibUtil;

import java.util.List;

/**
 * Created by rahul on 27/1/18.
 */

public class SearchAdapterPresenter<T extends SearchAdapter.SearchHolder, E extends Projects>
        extends BaseAdapterPresenter<T,E> implements SearchAdapterMVP.ISearchAdapterPresenter<T,E> {

    public SearchAdapterPresenter(List<E> list) {
        super(list);
    }

    @Override
    public void onBind(T holder, int position) {
        E projects = getElementAtPos(position);

        holder.setName(projects.getName());
        holder.setDescription(projects.getDescription());
        holder.setGitDetails(
                String.valueOf(projects.getRank()),
                String.valueOf(projects.getStars()),
                String.valueOf(projects.getForks())
        );
        holder.setReleaseDate(
                LibUtil.getConvertedDate(projects.getLatestReleasePublishedAt())
        );
        holder.setVersion(projects.getLatestReleaseNumber());
        holder.setLicense(projects.getNormalizedLicenses().toString());
    }

    @Override
    public void onRecycle(T holder) {

    }
}
