package com.huawei.hms.ads.jsb;

import android.content.Context;
import android.webkit.ValueCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsb/IWebView.class */
public interface IWebView {
    void addJavascriptInterface(Object obj, String str);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    Context getContext();

    String getUrl();

    void loadUrl(String str);

    void removeJavascriptInterface(String str);
}
