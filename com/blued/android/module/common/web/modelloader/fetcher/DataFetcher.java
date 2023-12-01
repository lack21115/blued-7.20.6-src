package com.blued.android.module.common.web.modelloader.fetcher;

import com.blued.android.module.common.web.jsbridge.CallBackFunction;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/modelloader/fetcher/DataFetcher.class */
public interface DataFetcher {

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/web/modelloader/fetcher/DataFetcher$DataFetcherCallback.class */
    public interface DataFetcherCallback {
        void onLoadFailed(Exception exc);

        void onLoadSuccess();
    }

    void cancel();

    void loadData(String str, CallBackFunction callBackFunction, DataFetcherCallback dataFetcherCallback);
}
