package com.blued.android.framework.web;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/JSExecutor.class */
public class JSExecutor {

    /* renamed from: a  reason: collision with root package name */
    private WebView f10383a;
    private String b;

    public void a() {
        this.f10383a = null;
    }

    public void a(WebView webView) {
        this.f10383a = webView;
    }

    public void a(String str) {
        this.b = str;
    }

    public boolean a(String str, final String str2) {
        if (this.f10383a == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        this.f10383a.post(new Runnable() { // from class: com.blued.android.framework.web.JSExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                if (JSExecutor.this.f10383a != null) {
                    Tracker.loadUrl(JSExecutor.this.f10383a, str2);
                }
            }
        });
        return true;
    }

    public String b() {
        return this.b;
    }
}
