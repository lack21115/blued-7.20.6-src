package com.blued.android.module.yy_china.web.modelloader.fetcher;

import android.util.Log;
import com.blued.android.module.common.web.jsbridge.CallBackFunction;
import com.blued.android.module.common.web.modelloader.fetcher.DataFetcher;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/web/modelloader/fetcher/WebPayBeansFetcher.class */
public class WebPayBeansFetcher implements DataFetcher {
    @Override // com.blued.android.module.common.web.modelloader.fetcher.DataFetcher
    public void cancel() {
    }

    @Override // com.blued.android.module.common.web.modelloader.fetcher.DataFetcher
    public void loadData(String str, CallBackFunction callBackFunction, DataFetcher.DataFetcherCallback dataFetcherCallback) {
        Log.v("drb", "loadData jsonData:" + str);
    }
}
