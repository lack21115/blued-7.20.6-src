package com.tencent.smtt.sdk;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/WebViewDatabase.class */
public class WebViewDatabase {

    /* renamed from: a  reason: collision with root package name */
    private static WebViewDatabase f25126a;
    private Context b;

    protected WebViewDatabase(Context context) {
        this.b = context;
    }

    private static WebViewDatabase a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            try {
                if (f25126a == null) {
                    f25126a = new WebViewDatabase(context);
                }
                webViewDatabase = f25126a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return webViewDatabase;
    }

    public static WebViewDatabase getInstance(Context context) {
        return a(context);
    }

    public void clearFormData() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
        } else {
            a2.c().g(this.b);
        }
    }

    public void clearHttpAuthUsernamePassword() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
        } else {
            a2.c().e(this.b);
        }
    }

    @Deprecated
    public void clearUsernamePassword() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
        } else {
            a2.c().c(this.b);
        }
    }

    public boolean hasFormData() {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasFormData() : a2.c().f(this.b);
    }

    public boolean hasHttpAuthUsernamePassword() {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword() : a2.c().d(this.b);
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword() : a2.c().b(this.b);
    }
}
