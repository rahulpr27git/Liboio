package com.dev.rahul.liboio.ui.fragment.search.adapter.search;

import android.support.v7.widget.AppCompatTextView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.pojo.Projects;
import com.dev.rahul.liboio.ui.base.BaseAdapter;
import com.dev.rahul.liboio.ui.base.BaseHolder;
import com.dev.rahul.liboio.ui.fragment.search.SearchMVP;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rahul on 27/1/18.
 */

public class SearchAdapter<T extends SearchAdapter.SearchHolder,E extends Projects, P extends SearchAdapterMVP.ISearchAdapterPresenter<T,E>>
        extends BaseAdapter<T,E,P>{

    private P presenter;
    private SearchMVP.ISearchView parentView;

    public SearchAdapter(P presenter, SearchMVP.ISearchView parentView) {
        super(presenter);
        this.presenter = presenter;
        this.parentView = parentView;
    }

    @Override
    public T getHolder(ViewGroup parent, int viewType) {
        return (T) new SearchHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_projects,parent,false)
        );
    }

    public class SearchHolder extends BaseHolder implements SearchAdapterMVP.ISearchAdapterView{

        @BindView(R.id.tvName)
        AppCompatTextView tvName;
        @BindView(R.id.tvRank)
        AppCompatTextView tvRank;
        @BindView(R.id.tvStar)
        AppCompatTextView tvStar;
        @BindView(R.id.tvFork)
        AppCompatTextView tvFork;

        @BindView(R.id.includeDescription)
        View includeDescription;
        @BindView(R.id.includeDate)
        View includeDate;
        @BindView(R.id.includeVersion)
        View includeVersion;
        @BindView(R.id.includeLicense)
        View includeLicense;

        IncludeLayout descriptionView;
        IncludeLayout dateView;
        IncludeLayout versionView;
        IncludeLayout licenseView;

        public SearchHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            descriptionView = new IncludeLayout();
            dateView = new IncludeLayout();
            versionView = new IncludeLayout();
            licenseView = new IncludeLayout();

            ButterKnife.bind(descriptionView,includeDescription);
            ButterKnife.bind(dateView,includeDate);
            ButterKnife.bind(versionView,includeVersion);
            ButterKnife.bind(licenseView,includeLicense);
        }

        @Override
        public void setName(String name) {
            tvName.setText(name);
        }

        @Override
        public void setDescription(String description) {
            descriptionView.tvTitle.setText("Description");
            descriptionView.tvName.setText(description);
            descriptionView.tvName.setMaxLines(2);
        }

        @Override
        public void setGitDetails(String rank, String stars, String forks) {
            tvRank.setText(rank);
            tvStar.setText(stars);
            tvFork.setText(forks);
        }

        @Override
        public void setReleaseDate(String date) {
            dateView.tvTitle.setText("Latest Release");
            dateView.tvName.setText(date);
            dateView.tvTitle.setGravity(Gravity.CENTER);
            dateView.tvName.setGravity(Gravity.CENTER);
        }

        @Override
        public void setVersion(String version) {
            versionView.tvTitle.setText("Version");
            versionView.tvName.setText(version);
            versionView.tvTitle.setGravity(Gravity.CENTER);
            versionView.tvName.setGravity(Gravity.CENTER);
        }

        @Override
        public void setLicense(String license) {
            licenseView.tvTitle.setText("Normalized License");
            licenseView.tvName.setText(license);
        }
    }

    static class IncludeLayout {
        @BindView(R.id.tvTitle)
        AppCompatTextView tvTitle;
        @BindView(R.id.tvName)
        AppCompatTextView tvName;
    }
}
