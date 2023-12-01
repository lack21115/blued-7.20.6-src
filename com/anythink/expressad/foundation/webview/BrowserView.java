package com.anythink.expressad.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.Headers;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.bytedance.applog.tracker.Tracker;
import com.youzan.androidsdk.tool.WebParameter;
import java.lang.reflect.Method;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/webview/BrowserView.class */
public class BrowserView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5143a = "BrowserView";
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f5144c;
    private WebView d;
    private ToolBar e;
    private a f;
    private c g;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/webview/BrowserView$DownloadListener.class */
    public static final class DownloadListener implements android.webkit.DownloadListener {
        private c campaignEx;
        private String title;

        public DownloadListener() {
        }

        public DownloadListener(c cVar) {
            this.campaignEx = cVar;
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        }

        public final void setTitle(String str) {
            this.title = str;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/webview/BrowserView$a.class */
    public interface a {
        void a();

        boolean a(WebView webView, String str);

        void b();
    }

    public BrowserView(Context context) {
        super(context);
        init();
    }

    public BrowserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BrowserView(Context context, c cVar) {
        super(context);
        this.g = cVar;
        init();
    }

    private void a() {
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f5144c = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.d == null) {
                this.d = b();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.d.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            o.b(f5143a, "webview is error", th);
        }
        this.e = new ToolBar(getContext());
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, t.b(getContext(), 40.0f)));
        this.e.setBackgroundColor(-1);
        addView(this.f5144c);
        WebView webView = this.d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.e);
    }

    private WebView b() {
        WebView webView = new WebView(getContext());
        try {
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAppCacheMaxSize(5242880L);
            settings.setAllowFileAccess(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(true);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            if (Build.VERSION.SDK_INT >= 26) {
                settings.setSafeBrowsingEnabled(false);
            }
            if (Build.VERSION.SDK_INT >= 17) {
                settings.setMediaPlaybackRequiresUserGesture(false);
            }
            settings.setAllowUniversalAccessFromFileURLs(true);
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
            } catch (Exception e) {
                o.d(f5143a, e.getMessage());
            }
            settings.setDatabaseEnabled(true);
            String path = getContext().getDir(WebParameter.PATH_DATABASE, 0).getPath();
            settings.setDatabasePath(path);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
            try {
                Method declaredMethod = WebSettings.class.getDeclaredMethod("setDisplayZoomControls", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(settings, Boolean.FALSE);
            } catch (Exception e2) {
                o.d(f5143a, e2.getMessage());
            }
        } catch (Throwable th) {
            o.d(f5143a, th.getMessage());
        }
        webView.setDownloadListener(new DownloadListener(this.g));
        webView.setWebViewClient(new WebViewClient() { // from class: com.anythink.expressad.foundation.webview.BrowserView.2
            @Override // android.webkit.WebViewClient
            public final void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                o.b(BrowserView.f5143a, "开始! = ".concat(String.valueOf(str)));
                BrowserView.this.b = str;
                if (BrowserView.this.f != null) {
                    a unused = BrowserView.this.f;
                }
                BrowserView.this.f5144c.setVisible(true);
                BrowserView.this.f5144c.setProgressState(5);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                o.b(BrowserView.f5143a, "js大跳! = ".concat(String.valueOf(str)));
                BrowserView.this.e.getItem("backward").setEnabled(true);
                BrowserView.this.e.getItem("forward").setEnabled(false);
                if (BrowserView.this.f != null) {
                    BrowserView.this.f.a(webView2, str);
                    return false;
                }
                return false;
            }
        });
        webView.setWebChromeClient(k.d() <= 10 ? new WebChromeClient() { // from class: com.anythink.expressad.foundation.webview.BrowserView.3
            @Override // android.webkit.WebChromeClient
            public final boolean onJsAlert(WebView webView2, String str, String str2, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsConfirm(WebView webView2, String str, String str2, JsResult jsResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onJsPrompt(WebView webView2, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i) {
                Tracker.onProgressChanged(this, webView2, i);
                if (i == 100) {
                    BrowserView.this.f5144c.setProgressState(7);
                    new Handler().postDelayed(new Runnable() { // from class: com.anythink.expressad.foundation.webview.BrowserView.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BrowserView.this.f5144c.setVisible(false);
                        }
                    }, 200L);
                }
            }
        } : new WebChromeClient() { // from class: com.anythink.expressad.foundation.webview.BrowserView.4
            @Override // android.webkit.WebChromeClient
            public final void onProgressChanged(WebView webView2, int i) {
                Tracker.onProgressChanged(this, webView2, i);
                if (i == 100) {
                    BrowserView.this.f5144c.setProgressState(7);
                    new Handler().postDelayed(new Runnable() { // from class: com.anythink.expressad.foundation.webview.BrowserView.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            BrowserView.this.f5144c.setVisible(false);
                        }
                    }, 200L);
                }
            }
        });
        return webView;
    }

    public void destroy() {
        WebView webView = this.d;
        if (webView != null) {
            webView.stopLoading();
            this.d.setWebViewClient(null);
            this.d.destroy();
            removeAllViews();
        }
    }

    public void init() {
        setOrientation(1);
        setGravity(17);
        ProgressBar progressBar = new ProgressBar(getContext());
        this.f5144c = progressBar;
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-1, 4));
        try {
            if (this.d == null) {
                this.d = b();
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
            this.d.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            o.b(f5143a, "webview is error", th);
        }
        this.e = new ToolBar(getContext());
        this.e.setLayoutParams(new LinearLayout.LayoutParams(-1, t.b(getContext(), 40.0f)));
        this.e.setBackgroundColor(-1);
        addView(this.f5144c);
        WebView webView = this.d;
        if (webView != null) {
            addView(webView);
        }
        addView(this.e);
        this.f5144c.initResource(true);
        this.e.getItem("backward").setEnabled(false);
        this.e.getItem("forward").setEnabled(false);
        this.e.setOnItemClickListener(new View.OnClickListener() { // from class: com.anythink.expressad.foundation.webview.BrowserView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (BrowserView.this.d != null) {
                    BrowserView.this.d.stopLoading();
                }
                String str = (String) view.getTag();
                if (TextUtils.equals(str, "backward")) {
                    BrowserView.this.e.getItem("forward").setEnabled(true);
                    if (BrowserView.this.d != null && BrowserView.this.d.canGoBack()) {
                        BrowserView.this.d.goBack();
                    }
                    View item = BrowserView.this.e.getItem("backward");
                    boolean z = false;
                    if (BrowserView.this.d != null) {
                        z = false;
                        if (BrowserView.this.d.canGoBack()) {
                            z = true;
                        }
                    }
                    item.setEnabled(z);
                } else if (TextUtils.equals(str, "forward")) {
                    BrowserView.this.e.getItem("backward").setEnabled(true);
                    if (BrowserView.this.d != null && BrowserView.this.d.canGoForward()) {
                        BrowserView.this.d.goForward();
                    }
                    View item2 = BrowserView.this.e.getItem("forward");
                    boolean z2 = false;
                    if (BrowserView.this.d != null) {
                        z2 = false;
                        if (BrowserView.this.d.canGoForward()) {
                            z2 = true;
                        }
                    }
                    item2.setEnabled(z2);
                } else if (!TextUtils.equals(str, Headers.REFRESH)) {
                    if (!TextUtils.equals(str, "exits") || BrowserView.this.f == null) {
                        return;
                    }
                    BrowserView.this.f.a();
                } else {
                    BrowserView.this.e.getItem("backward").setEnabled(BrowserView.this.d != null && BrowserView.this.d.canGoBack());
                    View item3 = BrowserView.this.e.getItem("forward");
                    boolean z3 = false;
                    if (BrowserView.this.d != null) {
                        z3 = false;
                        if (BrowserView.this.d.canGoForward()) {
                            z3 = true;
                        }
                    }
                    item3.setEnabled(z3);
                    if (BrowserView.this.d != null) {
                        Tracker.loadUrl(BrowserView.this.d, BrowserView.this.b);
                    }
                }
            }
        });
    }

    public void loadUrl(String str) {
        WebView webView = this.d;
        if (webView != null) {
            Tracker.loadUrl(webView, str);
        }
    }

    public void setListener(a aVar) {
        this.f = aVar;
    }

    public void setWebView(WebView webView) {
        this.d = webView;
    }
}
