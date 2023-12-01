package com.anythink.expressad.a;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.anythink.expressad.foundation.h.o;
import com.bytedance.applog.tracker.Tracker;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/g.class */
public class g {
    private static final int p = 1;
    private static final int q = 2;
    private static final int r = 0;
    boolean b;

    /* renamed from: c  reason: collision with root package name */
    boolean f6970c;
    private int e;
    private int f;
    private com.anythink.expressad.d.a h;
    private a i;
    private String j;
    private String k;
    private WebView l;
    private boolean m;
    private String n;
    private int o;
    private boolean t;
    private static final String d = g.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static long f6969a = 0;
    private boolean s = false;
    private final Runnable u = new Runnable() { // from class: com.anythink.expressad.a.g.4
        @Override // java.lang.Runnable
        public final void run() {
            g.n(g.this);
            g.this.o = 1;
            String str = g.d;
            o.d(str, "js超时！超时上限：" + g.this.f + "ms");
            g.p(g.this);
        }
    };
    private final Runnable v = new Runnable() { // from class: com.anythink.expressad.a.g.5
        @Override // java.lang.Runnable
        public final void run() {
            g.n(g.this);
            g.this.o = 2;
            String str = g.d;
            o.d(str, "http超时！超时上限：" + g.this.e + "ms");
            g.p(g.this);
        }
    };
    private Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/a/g$a.class */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, String str3);

        boolean a();

        boolean a(String str);

        boolean b(String str);
    }

    public g(boolean z) {
        this.e = 15000;
        this.f = 3000;
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.foundation.b.a.b().e();
        com.anythink.expressad.d.a b = com.anythink.expressad.d.b.b();
        this.h = b;
        if (b == null) {
            com.anythink.expressad.d.b.a();
            this.h = com.anythink.expressad.d.b.c();
        }
        this.m = this.h.v();
        if (z) {
            this.e = (int) this.h.q();
            this.f = (int) this.h.q();
            return;
        }
        this.e = (int) this.h.r();
        this.f = (int) this.h.r();
    }

    private void a(Context context, final String str, final String str2) {
        WebView webView = new WebView(context);
        this.l = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.l.getSettings().setCacheMode(2);
        this.l.getSettings().setLoadsImagesAutomatically(false);
        this.l.setWebViewClient(new WebViewClient() { // from class: com.anythink.expressad.a.g.2
            private boolean a() {
                return g.this.b || g.this.f6970c;
            }

            @Override // android.webkit.WebViewClient
            public final void onPageFinished(WebView webView2, String str3) {
                super.onPageFinished(webView2, str3);
                try {
                    Tracker.loadUrl(webView2, "javascript:window.navigator.vibrate([]);");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[Catch: all -> 0x00fd, TRY_LEAVE, TryCatch #1 {Exception -> 0x0102, blocks: (B:2:0x0000, B:5:0x0017, B:7:0x0028, B:9:0x0037, B:11:0x0048, B:13:0x004d, B:10:0x0040, B:16:0x0051, B:19:0x005c, B:22:0x0068, B:24:0x006f, B:27:0x00bf, B:29:0x00d1, B:31:0x00e1, B:34:0x00fb, B:32:0x00f3, B:25:0x0098), top: B:48:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:25:0x0098 A[Catch: all -> 0x00fd, TRY_ENTER, TryCatch #1 {Exception -> 0x0102, blocks: (B:2:0x0000, B:5:0x0017, B:7:0x0028, B:9:0x0037, B:11:0x0048, B:13:0x004d, B:10:0x0040, B:16:0x0051, B:19:0x005c, B:22:0x0068, B:24:0x006f, B:27:0x00bf, B:29:0x00d1, B:31:0x00e1, B:34:0x00fb, B:32:0x00f3, B:25:0x0098), top: B:48:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:47:0x0110  */
            @Override // android.webkit.WebViewClient
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onPageStarted(android.webkit.WebView r4, java.lang.String r5, android.graphics.Bitmap r6) {
                /*
                    Method dump skipped, instructions count: 278
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.g.AnonymousClass2.onPageStarted(android.webkit.WebView, java.lang.String, android.graphics.Bitmap):void");
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedError(WebView webView2, int i, String str3, String str4) {
                String str5 = g.d;
                o.b(str5, "onReceivedError: errno = " + i + ", url: " + webView2.getUrl() + ",\n onReceivedError：, description: " + str3 + ", failingUrl: " + str4);
                synchronized (g.d) {
                    g.e(g.this);
                    g.this.f();
                    g.c(g.this);
                }
                if (g.this.i != null) {
                    g.this.i.a(webView2.getUrl(), str3, g.this.n);
                }
            }

            @Override // android.webkit.WebViewClient
            public final void onReceivedSslError(WebView webView2, SslErrorHandler sslErrorHandler, SslError sslError) {
                try {
                    String str3 = g.d;
                    o.a(str3, "onReceivedSslError IS_SP_CBT_CF:" + com.anythink.expressad.a.q);
                    if (com.anythink.expressad.a.q && sslErrorHandler != null) {
                        sslErrorHandler.cancel();
                    }
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    TextUtils.isEmpty(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str3) {
                synchronized (g.d) {
                    o.a(g.d, "override js跳转：".concat(String.valueOf(str3)));
                    g.this.f6970c = true;
                    g.this.j();
                    if (g.this.t) {
                        g.this.h();
                        g.c(g.this);
                        return true;
                    }
                    g.this.j = str3;
                    if (g.this.i != null && g.this.i.b(str3)) {
                        g.e(g.this);
                        g.this.h();
                        g.c(g.this);
                        return true;
                    } else if (!g.this.m) {
                        Tracker.loadUrl(g.this.l, str3);
                        return true;
                    } else {
                        HashMap hashMap = new HashMap();
                        if (g.this.l.getUrl() != null) {
                            hashMap.put(HttpHeaders.REFERER, g.this.l.getUrl());
                        }
                        Tracker.loadUrl(g.this.l, str3, hashMap);
                        return true;
                    }
                }
            }
        });
        this.l.setWebChromeClient(new WebChromeClient() { // from class: com.anythink.expressad.a.g.3
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView2, String str3, String str4, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView2, String str3, String str4, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView2, String str3, String str4, String str5, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i) {
                Tracker.onProgressChanged(this, webView2, i);
                if (i == 100) {
                    try {
                        String str3 = g.d;
                        o.b(str3, "加载页面-进度完成：" + webView2.getUrl());
                        Tracker.loadUrl(webView2, "javascript:window.navigator.vibrate([]);");
                        if (!g.this.t && !g.this.f6970c) {
                            g.m(g.this);
                        }
                        if (g.this.i != null) {
                            a aVar = g.this.i;
                            webView2.getUrl();
                            aVar.a();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, Context context, String str3) {
        try {
            a(context, str, str2);
            if (!TextUtils.isEmpty(this.k)) {
                this.l.getSettings().setDefaultTextEncodingName("utf-8");
                this.f = 2000;
                this.e = 2000;
                o.b(d, this.k);
                Tracker.loadDataWithBaseURL(this.l, str3, this.k, "*/*", "utf-8", str3);
            } else if (!this.m) {
                Tracker.loadUrl(this.l, str3);
            } else {
                HashMap hashMap = new HashMap();
                if (this.l.getUrl() != null) {
                    hashMap.put(HttpHeaders.REFERER, this.l.getUrl());
                }
                Tracker.loadUrl(this.l, str3, hashMap);
            }
        } catch (Throwable th) {
            try {
                if (this.i != null) {
                    this.i.a(this.j, th.getMessage(), this.n);
                }
            } catch (Exception e) {
            }
        }
    }

    private void a(final String str, final String str2, final String str3, final Context context) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            a(str2, str3, context, this.j);
        } else {
            this.g.post(new Runnable() { // from class: com.anythink.expressad.a.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    g gVar = g.this;
                    gVar.a(str2, str3, context, gVar.j);
                }
            });
        }
    }

    private void b() {
        synchronized (d) {
            try {
                f();
                if (this.i != null) {
                    this.i.a(this.j, this.n);
                }
            } catch (Exception e) {
                o.d(d, "webview colse to failed");
            } catch (Throwable th) {
                o.d(d, "webview colse to failed");
            }
        }
    }

    private void c() {
        synchronized (d) {
            try {
                try {
                    f();
                    this.l.destroy();
                    if (this.i != null) {
                        this.i.a(this.j, this.n);
                    }
                }
            } catch (Exception e) {
                o.d(d, "webview colse to failed");
            }
        }
    }

    static /* synthetic */ void c(g gVar) {
        synchronized (d) {
            try {
                gVar.f();
                if (gVar.i != null) {
                    gVar.i.a(gVar.j, gVar.n);
                }
            } catch (Exception e) {
                o.d(d, "webview colse to failed");
            } catch (Throwable th) {
                o.d(d, "webview colse to failed");
            }
        }
    }

    private void d() {
        h();
        this.g.postDelayed(this.v, this.e);
    }

    private void e() {
        j();
        this.g.postDelayed(this.u, this.f);
    }

    static /* synthetic */ boolean e(g gVar) {
        gVar.t = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        j();
        h();
    }

    static /* synthetic */ void f(g gVar) {
        gVar.h();
        gVar.g.postDelayed(gVar.v, gVar.e);
    }

    private void g() {
        this.g.postDelayed(this.v, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.g.removeCallbacks(this.v);
    }

    private void i() {
        this.g.postDelayed(this.u, this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.g.removeCallbacks(this.u);
    }

    static /* synthetic */ void m(g gVar) {
        gVar.j();
        gVar.g.postDelayed(gVar.u, gVar.f);
    }

    static /* synthetic */ boolean n(g gVar) {
        gVar.s = true;
        return true;
    }

    static /* synthetic */ void p(g gVar) {
        synchronized (d) {
            try {
                try {
                    gVar.f();
                    gVar.l.destroy();
                    if (gVar.i != null) {
                        gVar.i.a(gVar.j, gVar.n);
                    }
                }
            } catch (Exception e) {
                o.d(d, "webview colse to failed");
            }
        }
    }

    public final void a(String str, String str2, String str3, Context context, String str4, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("OverrideUrlLoadingListener can not be null");
        }
        this.j = str4;
        this.i = aVar;
        a(str, str2, str3, context);
    }

    public final void a(String str, String str2, String str3, Context context, String str4, String str5, a aVar) {
        if (aVar == null) {
            throw new NullPointerException("OverrideUrlLoadingListener can not be null");
        }
        this.k = str5;
        this.j = str4;
        this.i = aVar;
        a(str, str2, str3, context);
    }
}
