package com.dev.rahul.liboio.ui.activity.project_details;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.pojo.Contributors;
import com.dev.rahul.liboio.ui.fragment.contributor.ContributorsFragment;
import com.dev.rahul.liboio.ui.fragment.dependencies.DependenciesFragment;
import com.dev.rahul.liboio.ui.fragment.dependents.DependentsFragment;
import com.dev.rahul.liboio.ui.fragment.details.DetailsFragment;
import com.dev.rahul.liboio.ui.fragment.repository.RepositoryFragment;

/**
 * Created by rahul on 3/2/18.
 */

public class ProjectDetailsRepository implements ProjectDetailsMVP.IProjectDetailsRepository {

    public static final String TAG = ProjectDetailsRepository.class.getSimpleName();

    @Override
    public Fragment[] getFragment(Bundle bundle) {
        return new Fragment[] {
                DetailsFragment.newInstance(bundle),
                DependenciesFragment.newInstance(bundle),
                DependentsFragment.newInstance(bundle),
                RepositoryFragment.newInstance(bundle),
                ContributorsFragment.newInstance(bundle)
        };
    }
    
    @Override
    public int[] getNavDrawables() {
        return new int[] {
                R.drawable.ic_details,
                R.drawable.ic_dependencies,
                R.drawable.ic_dependents,
                R.drawable.ic_repository_new,
                R.drawable.ic_contribute
        };
    }

    @Override
    public String[] getNavTitles() {
        return new String[] {
                "Details",
                "Dependencies",
                "Dependents",
                "Repositories",
                "Contributor"
        };
    }
}
