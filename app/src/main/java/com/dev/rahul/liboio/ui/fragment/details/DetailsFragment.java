package com.dev.rahul.liboio.ui.fragment.details;


import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v4.content.MimeTypeFilter;
import android.support.v7.widget.AppCompatTextView;
import android.text.Spanned;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dev.rahul.liboio.R;
import com.dev.rahul.liboio.ui.base.BaseFragment;
import com.dev.rahul.liboio.utility.CustomWebViewClient;
import com.dev.rahul.liboio.utility.LibConstants;

import butterknife.BindView;
import butterknife.ButterKnife;
import im.delight.android.webview.AdvancedWebView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class DetailsFragment extends BaseFragment implements DetailsMVP.IDetailsView {

    public static final String TAG = DetailsFragment.class.getSimpleName();
    public static DetailsFragment fragment;

    @BindView(R.id.tvSourceRank)
    AppCompatTextView tvSourceRank;
    @BindView(R.id.includeDescription)
    View includeDescription;
    @BindView(R.id.includeLicense)
    View includeLicense;
    @BindView(R.id.tvDocumentationTitle)
    AppCompatTextView tvDocumentationTitle;
    @BindView(R.id.webView)
    AdvancedWebView webView;

    public static class IncludeLayout {
        @BindView(R.id.tvTitle)
        AppCompatTextView tvTitle;
        @BindView(R.id.tvName)
        AppCompatTextView tvName;
    }

    IncludeLayout DESCRIPTION;
    IncludeLayout LICENSE;

    private DetailsMVP.IDetailsPresenter presenter;

    public DetailsFragment() {
        presenter = new DetailsPresenter(new DetailsRepository());
    }

    public static DetailsFragment newInstance(Bundle bundle) {
        if (fragment == null) {
            fragment = new DetailsFragment();
            fragment.setArguments(bundle);
        }

        return fragment;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        Log.e(TAG, "onViewCreated is called");

        DESCRIPTION = new IncludeLayout();
        LICENSE = new IncludeLayout();

        ButterKnife.bind(DESCRIPTION, includeDescription);
        ButterKnife.bind(LICENSE, includeLicense);

        presenter.onAttach(this);
        presenter.fetchData();
        presenter.fetchDocumentation();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState is called");
    }

    @Override
    public void setRank(String rank) {
        tvSourceRank.setText(rank);
    }

    @Override
    public void setDescription(String title, String description) {
        DESCRIPTION.tvTitle.setText(title);
        DESCRIPTION.tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        DESCRIPTION.tvName.setText(description);
        DESCRIPTION.tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
    }

    @Override
    public void setLicense(String title, String license) {
        LICENSE.tvTitle.setText(title);
        LICENSE.tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
        LICENSE.tvName.setText(license);
        LICENSE.tvName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
    }

    @Override
    public void setDocumentationTitle(String title) {
        tvDocumentationTitle.setText(title);
    }

    @Override
    public void showDocumentation(String documentation) {
        webView.setWebViewClient(new CustomWebViewClient());
        webView.loadHtml(documentation);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onDestroyView() {
        Log.e(TAG, "onDestroyView is called");
        presenter.onDestroy();
        super.onDestroyView();
    }
}
