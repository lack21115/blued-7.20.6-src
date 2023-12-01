package com.alipay.sdk.widget;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.alipay.sdk.widget.p;
import com.bytedance.applog.tracker.Tracker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/s.class */
public class s extends WebChromeClient {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.a = pVar;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        p.a aVar;
        aVar = this.a.g;
        return aVar.a(this.a, str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        ProgressBar progressBar3;
        ProgressBar progressBar4;
        Tracker.onProgressChanged(this, webView, i);
        if (i == 100) {
            progressBar4 = this.a.d;
            progressBar4.setVisibility(4);
            return;
        }
        progressBar = this.a.d;
        if (4 == progressBar.getVisibility()) {
            progressBar3 = this.a.d;
            progressBar3.setVisibility(0);
        }
        progressBar2 = this.a.d;
        progressBar2.setProgress(i);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        p.a aVar;
        aVar = this.a.g;
        aVar.a(this.a, str);
    }
}
