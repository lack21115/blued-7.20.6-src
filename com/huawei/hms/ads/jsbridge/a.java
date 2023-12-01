package com.huawei.hms.ads.jsbridge;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.huawei.hms.ads.jsb.IWebView;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsbridge/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private volatile String f8902a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.ads.jsbridge.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsbridge/a$a.class */
    public static class CallableC0246a implements Callable<String> {

        /* renamed from: a  reason: collision with root package name */
        private IWebView f8903a;
        private WebView b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8904c;

        CallableC0246a(WebView webView) {
            this.b = webView;
        }

        CallableC0246a(IWebView iWebView) {
            this.f8904c = true;
            this.f8903a = iWebView;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public String call() {
            if (this.f8904c) {
                IWebView iWebView = this.f8903a;
                if (iWebView != null) {
                    return iWebView.getUrl();
                }
                return null;
            }
            WebView webView = this.b;
            if (webView != null) {
                return webView.getUrl();
            }
            return null;
        }
    }

    private static Future<String> a(FutureTask futureTask) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            futureTask.run();
            return futureTask;
        }
        new Handler(Looper.getMainLooper()).post(futureTask);
        return futureTask;
    }

    public static void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    private static String b(WebView webView) {
        try {
            return a(new FutureTask(new CallableC0246a(webView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            b.b("Exception will waiting: " + e.getMessage());
            b.b("exception or timeout while waiting for url");
            return null;
        }
    }

    private static String b(IWebView iWebView) {
        try {
            return a(new FutureTask(new CallableC0246a(iWebView))).get(1L, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            b.b("Exception will waiting: " + e.getMessage());
            b.b("exception or timeout while waiting for url");
            return null;
        }
    }

    public String a(WebView webView) {
        if (webView == null) {
            return null;
        }
        String str = this.f8902a;
        if (str != null) {
            return str;
        }
        b.a("securityExtSetFrameUrl is null ,get url from native");
        return b(webView);
    }

    public String a(IWebView iWebView) {
        if (iWebView == null) {
            return null;
        }
        String str = this.f8902a;
        return str != null ? str : b(iWebView);
    }
}
