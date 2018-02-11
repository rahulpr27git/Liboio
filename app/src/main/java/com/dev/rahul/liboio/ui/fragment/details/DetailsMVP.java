package com.dev.rahul.liboio.ui.fragment.details;

import android.text.Spanned;

import com.dev.rahul.liboio.ui.base.IBasePresenter;
import com.dev.rahul.liboio.ui.base.IBaseView;

import org.jsoup.nodes.Document;

import io.reactivex.Single;

/**
 * Created by rahul on 10/2/18.
 */

public interface DetailsMVP {

    interface IDetailsView extends IBaseView {
        void setRank(String rank);
        void setDescription(String title, String description);
        void setLicense(String title, String license);
        void setDocumentationTitle(String title);
        void showDocumentation(String documentation);
    }

    interface IDetailsPresenter<V extends IDetailsView> extends IBasePresenter<V> {
        void fetchData();
        void fetchDocumentation();
    }

    interface IDetailsRepository {
        Single<Document> parseHtml(String url);
        Single<String> getDocumentationHtml(Document document);
    }
}
