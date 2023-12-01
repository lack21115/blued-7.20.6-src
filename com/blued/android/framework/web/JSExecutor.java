package com.blued.android.framework.web;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/web/JSExecutor.class */
public class JSExecutor {
    private WebView a;
    private String b;

    public void a() {
        this.a = null;
    }

    public void a(WebView webView) {
        this.a = webView;
    }

    public void a(String str) {
        this.b = str;
    }

    public boolean a(String str, final String str2) {
        if (this.a == null || TextUtils.isEmpty(str2)) {
            return false;
        }
        this.a.post(new Runnable() { // from class: com.blued.android.framework.web.JSExecutor.1
            @Override // java.lang.Runnable
            public void run() {
                if (JSExecutor.this.a != null) {
                    Tracker.loadUrl(JSExecutor.this.a, str2);
                }
            }
        });
        return true;
    }

    public String b() {
        return this.b;
    }
}
