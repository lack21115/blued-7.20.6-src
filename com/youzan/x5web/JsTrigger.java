package com.youzan.x5web;

import android.os.Handler;
import com.tencent.smtt.sdk.WebView;
import com.youzan.jsbridge.dispatcher.BridgeTrigger;
import com.youzan.jsbridge.util.Logger;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/JsTrigger.class */
public class JsTrigger extends BridgeTrigger {
    private static final String TAG = "JsTrigger";
    private Handler mMainThreadHandler = new Handler();
    private WebView mWebView;

    public JsTrigger(WebView webView) {
        this.mWebView = webView;
    }

    @Override // com.youzan.jsbridge.dispatcher.BridgeTrigger
    public void doLoadJs(final String str) {
        Handler handler;
        if (this.mWebView == null || (handler = this.mMainThreadHandler) == null) {
            Logger.e(TAG, "doEvent, but webview or handler is null");
        } else {
            handler.post(new Runnable() { // from class: com.youzan.x5web.JsTrigger.1
                @Override // java.lang.Runnable
                public void run() {
                    JsTrigger.this.mWebView.loadUrl(str);
                }
            });
        }
    }
}
