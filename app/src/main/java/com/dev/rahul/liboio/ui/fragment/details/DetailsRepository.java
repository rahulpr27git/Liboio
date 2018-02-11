package com.dev.rahul.liboio.ui.fragment.details;

import android.util.Log;

import com.dev.rahul.liboio.utility.LibConstants;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by rahul on 10/2/18.
 */

public class DetailsRepository implements DetailsMVP.IDetailsRepository {

    public static final String TAG = DetailsRepository.class.getSimpleName();

    @Override
    public Single<Document> parseHtml(final String url) {
        Log.e(TAG, "parseHtml url : " + url);
        return Single.fromCallable(new Callable<Document>() {
                    @Override
                    public Document call() throws Exception {
                        return Jsoup.connect(url).get();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Single<String> getDocumentationHtml(final Document document) {
        return Single.fromCallable(new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return document.getElementsByTag(LibConstants.ARTICLE).html();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
