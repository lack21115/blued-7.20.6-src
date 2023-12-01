package com.tencent.qimei.y;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/y/d.class */
public class d extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f24755a;

    public d(g gVar) {
        this.f24755a = gVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        try {
            this.f24755a.a(webView);
        } catch (Exception e) {
            com.tencent.qimei.k.a.a(e);
        }
    }
}
