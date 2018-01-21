package com.dev.rahul.liboio.ui.base;

import android.support.annotation.NonNull;

/**
 * Created by rahul on 4/1/18.
 */

public interface IBaseView {

    void onShowLoading();
    void onHideLoading();

    void onFailed(@NonNull String message);
    void onError(@NonNull String error);
    void onSuccess(@NonNull String message);
}
