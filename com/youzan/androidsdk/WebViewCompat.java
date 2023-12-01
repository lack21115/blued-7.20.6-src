package com.youzan.androidsdk;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/WebViewCompat.class */
public abstract class WebViewCompat {
    public abstract Context getContext();

    public abstract String getPreviousUrl();

    public abstract void initWebViewParameter();

    public abstract void loadUrl(String str);

    public abstract void removeJavascriptInterface(String str);

    public abstract boolean validPreviousUrl();

    public abstract void webViewUAConfiguration(WebViewCompat webViewCompat, String str, String str2);
}
