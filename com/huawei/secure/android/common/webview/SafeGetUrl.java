package com.huawei.secure.android.common.webview;

import android.util.Log;
import android.webkit.WebView;
import com.huawei.secure.android.common.util.b;
import com.huawei.secure.android.common.util.c;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/webview/SafeGetUrl.class */
public class SafeGetUrl {

    /* renamed from: c  reason: collision with root package name */
    private static final String f9554c = "SafeGetUrl";
    private static final long d = 200;

    /* renamed from: a  reason: collision with root package name */
    private String f9555a;
    private WebView b;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/webview/SafeGetUrl$a.class */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f9556a;

        a(CountDownLatch countDownLatch) {
            this.f9556a = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            SafeGetUrl safeGetUrl = SafeGetUrl.this;
            safeGetUrl.setUrl(safeGetUrl.b.getUrl());
            this.f9556a.countDown();
        }
    }

    public SafeGetUrl() {
    }

    public SafeGetUrl(WebView webView) {
        this.b = webView;
    }

    public String getUrlMethod() {
        if (this.b == null) {
            return "";
        }
        if (b.a()) {
            return this.b.getUrl();
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.a(new a(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            Log.e(f9554c, "getUrlMethod: InterruptedException " + e.getMessage(), e);
        }
        return this.f9555a;
    }

    public WebView getWebView() {
        return this.b;
    }

    public void setUrl(String str) {
        this.f9555a = str;
    }

    public void setWebView(WebView webView) {
        this.b = webView;
    }
}
