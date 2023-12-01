package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/ah.class */
public class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JSONObject f6463a;
    final /* synthetic */ WebView b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ad f6464c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ad adVar, JSONObject jSONObject, WebView webView) {
        this.f6464c = adVar;
        this.f6463a = jSONObject;
        this.b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6463a == null || this.b == null) {
            return;
        }
        Tracker.loadUrl(this.b, "javascript:window.sdkCallback.userInteractCb(\"" + this.f6463a.toString().replace("\"", "\\\"") + "\")");
    }
}
