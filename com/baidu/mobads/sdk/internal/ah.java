package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ah.class */
public class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JSONObject f9303a;
    final /* synthetic */ WebView b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ad f9304c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ad adVar, JSONObject jSONObject, WebView webView) {
        this.f9304c = adVar;
        this.f9303a = jSONObject;
        this.b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f9303a == null || this.b == null) {
            return;
        }
        Tracker.loadUrl(this.b, "javascript:window.sdkCallback.userInteractCb(\"" + this.f9303a.toString().replace("\"", "\\\"") + "\")");
    }
}
