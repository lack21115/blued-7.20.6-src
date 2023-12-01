package com.soft.blued.ui.web.modelloader.fetcher;

import android.util.Log;
import com.blued.android.module.common.web.jsbridge.CallBackFunction;
import com.blued.android.module.common.web.modelloader.fetcher.DataFetcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/fetcher/WebShareFetcher.class */
public class WebShareFetcher implements DataFetcher {
    public void cancel() {
    }

    public void loadData(String str, CallBackFunction callBackFunction, DataFetcher.DataFetcherCallback dataFetcherCallback) {
        Log.v("drb", "loadData jsonData:" + str);
        callBackFunction.onCallBack("android给js回调「setHeadMenu」");
        if (dataFetcherCallback != null) {
            dataFetcherCallback.onLoadSuccess();
        }
    }
}
