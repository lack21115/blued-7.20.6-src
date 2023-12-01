package com.soft.blued.ui.web.modelloader.fetcher;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.blued.android.module.common.web.jsbridge.BridgeManager;
import com.blued.android.module.common.web.jsbridge.CallBackFunction;
import com.blued.android.module.common.web.modelloader.fetcher.DataFetcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/web/modelloader/fetcher/PageInfoFetcher.class */
public class PageInfoFetcher implements DataFetcher {
    BridgeManager bridgeManager;
    Lifecycle lifecycle;

    public PageInfoFetcher(BridgeManager bridgeManager, Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
        this.bridgeManager = bridgeManager;
    }

    @Override // com.blued.android.module.common.web.modelloader.fetcher.DataFetcher
    public void cancel() {
    }

    @Override // com.blued.android.module.common.web.modelloader.fetcher.DataFetcher
    public void loadData(String str, CallBackFunction callBackFunction, DataFetcher.DataFetcherCallback dataFetcherCallback) {
        this.lifecycle.addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.web.modelloader.fetcher.PageInfoFetcher.1
            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            public void onCreate() {
                PageInfoFetcher.this.sendToJs(0);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public void onDestroy() {
                PageInfoFetcher.this.sendToJs(3);
                PageInfoFetcher.this.lifecycle.removeObserver(this);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            public void onResume() {
                PageInfoFetcher.this.sendToJs(1);
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            public void onStop() {
                PageInfoFetcher.this.sendToJs(2);
            }
        });
    }

    public void sendToJs(int i) {
        Log.v("drb", "NATIVE_TO_JS sendJs type：" + i);
    }
}
