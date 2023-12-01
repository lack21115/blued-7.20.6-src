package com.opos.cmn.biz.web.b.b.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.http.SslError;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.opos.cmn.biz.web.a.b.c;
import com.youzan.androidsdk.tool.WebParameter;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/b/b/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f11039a;
    private Map<String, Object> b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11040c;
    private WebView d;
    private RelativeLayout e;
    private RelativeLayout f;
    private String j;
    private com.opos.cmn.biz.web.b.a.a.b l;
    private com.opos.cmn.biz.web.b.a.a.a m;
    private RelativeLayout g = null;
    private TextView h = null;
    private ProgressBar i = null;
    private boolean k = false;

    public b(Context context, com.opos.cmn.biz.web.b.a.b bVar) {
        this.f11039a = context;
        this.b = bVar.b;
        this.l = bVar.f11033a;
        this.m = bVar.d;
        this.f11040c = bVar.f11034c;
        f();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                if (this.m != null) {
                    this.m.a(sslErrorHandler, sslError);
                } else if (this.f11039a instanceof Activity) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this.f11039a);
                    builder.setMessage("SSL证书验证错误，是否继续？");
                    builder.setPositiveButton("继续", new DialogInterface.OnClickListener() { // from class: com.opos.cmn.biz.web.b.b.b.b.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            sslErrorHandler.proceed();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.opos.cmn.biz.web.b.b.b.b.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Tracker.onClick(dialogInterface, i);
                            sslErrorHandler.cancel();
                            b.this.r();
                        }
                    });
                    AlertDialog create = builder.create();
                    create.setCancelable(false);
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("WebWidgetImpl", "", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(java.lang.String r6) {
        /*
            r5 = this;
            r0 = r6
            boolean r0 = com.opos.cmn.an.c.a.a(r0)
            if (r0 != 0) goto L57
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> L4e
            r1 = r0
            java.lang.String r2 = "android.intent.action.VIEW"
            r3 = r6
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Exception -> L4e
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L4e
            r8 = r0
            r0 = r8
            java.lang.String r1 = "android.intent.category.BROWSABLE"
            android.content.Intent r0 = r0.addCategory(r1)     // Catch: java.lang.Exception -> L4e
            r0 = r8
            r1 = 0
            android.content.Intent r0 = r0.setComponent(r1)     // Catch: java.lang.Exception -> L4e
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L4e
            r1 = 15
            if (r0 < r1) goto L2f
            r0 = r8
            r1 = 0
            r0.setSelector(r1)     // Catch: java.lang.Exception -> L4e
        L2f:
            r0 = r8
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r0 = r0.addFlags(r1)     // Catch: java.lang.Exception -> L4e
            r0 = r5
            android.content.Context r0 = r0.f11039a     // Catch: java.lang.Exception -> L4e
            r1 = r8
            boolean r0 = com.opos.cmn.an.h.d.a.a(r0, r1)     // Catch: java.lang.Exception -> L4e
            if (r0 == 0) goto L57
            r0 = r5
            android.content.Context r0 = r0.f11039a     // Catch: java.lang.Exception -> L4e
            r1 = r8
            r0.startActivity(r1)     // Catch: java.lang.Exception -> L4e
            r0 = 1
            r7 = r0
            goto L59
        L4e:
            r8 = move-exception
            java.lang.String r0 = "WebWidgetImpl"
            java.lang.String r1 = ""
            r2 = r8
            com.opos.cmn.an.f.a.c(r0, r1, r2)
        L57:
            r0 = 0
            r7 = r0
        L59:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "checkLaunchApp url="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            if (r0 == 0) goto L6f
            goto L72
        L6f:
            java.lang.String r0 = "null"
            r6 = r0
        L72:
            r0 = r8
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            java.lang.String r1 = "result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r8
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "WebWidgetImpl"
            r1 = r8
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.biz.web.b.b.b.b.b(java.lang.String):boolean");
    }

    private void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f11039a);
        this.e = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.e.setFitsSystemWindows(true);
        View g = g();
        this.e.addView(g);
        if (!this.f11040c) {
            g.setVisibility(8);
        }
        h();
        i();
        j();
    }

    private View g() {
        LinearLayout linearLayout = new LinearLayout(this.f11039a);
        linearLayout.setId(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f11039a, 43.33f)));
        if (com.opos.cmn.biz.web.b.b.a.a.b(this.f11039a)) {
            linearLayout.setBackgroundColor(Color.parseColor("#F5EEEEEE"));
        } else {
            com.opos.cmn.biz.web.b.b.a.a.a(linearLayout, com.opos.cmn.an.d.a.a.c(this.f11039a, "o_cmn_biz_ui_web_title_bar_bg.9.png"));
        }
        this.h = new TextView(this.f11039a);
        Drawable c2 = com.opos.cmn.an.d.a.a.c(this.f11039a, "o_cmn_biz_ui_web_close_bn.png");
        c2.setBounds(0, 0, com.opos.cmn.an.h.f.a.a(this.f11039a, 26.0f), com.opos.cmn.an.h.f.a.a(this.f11039a, 24.0f));
        this.h.setCompoundDrawables(c2, null, null, null);
        this.h.setGravity(17);
        this.h.setTextSize(2, 15.0f);
        this.h.setTextColor(Color.parseColor("#2ac795"));
        this.h.setCompoundDrawablePadding(com.opos.cmn.an.h.f.a.a(this.f11039a, 2.0f));
        this.h.setText("返回");
        linearLayout.addView(this.h, new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f11039a, 43.33f)));
        return linearLayout;
    }

    private void h() {
        this.f = new RelativeLayout(this.f11039a);
        WebView webView = new WebView(this.f11039a);
        this.d = webView;
        this.f.addView(webView, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(3, 1);
        this.e.addView(this.f, layoutParams);
    }

    private void i() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f11039a);
        this.g = relativeLayout;
        relativeLayout.setVisibility(8);
        this.g.setGravity(17);
        ImageView imageView = new ImageView(this.f11039a);
        imageView.setId(2);
        imageView.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f11039a, "o_cmn_biz_ui_web_err_tag_img.png"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11039a, 39.33f), com.opos.cmn.an.h.f.a.a(this.f11039a, 40.0f));
        layoutParams.addRule(14, -1);
        this.g.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f11039a);
        textView.setId(3);
        textView.setText("网络繁忙，请刷新");
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(Color.parseColor("#ababab"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(3, 2);
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(this.f11039a, 15.0f);
        this.g.addView(textView, layoutParams2);
        a aVar = new a(this.f11039a, "o_cmn_biz_ui_web_err_refresh_normal_img.png", "o_cmn_biz_ui_web_err_refresh_press_img.png");
        aVar.setGravity(17);
        aVar.setText("刷新");
        aVar.setTextSize(2, 12.0f);
        aVar.setTextColor(Color.parseColor("#36ae9e"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f11039a, 52.67f), com.opos.cmn.an.h.f.a.a(this.f11039a, 23.33f));
        layoutParams3.addRule(14, -1);
        layoutParams3.addRule(3, 3);
        layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(this.f11039a, 37.67f);
        aVar.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.biz.web.b.b.b.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                b bVar = b.this;
                bVar.a(bVar.j);
            }
        });
        this.g.addView(aVar, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(3, 1);
        this.e.addView(this.g, layoutParams4);
    }

    private void j() {
        ProgressBar progressBar = new ProgressBar(this.f11039a);
        this.i = progressBar;
        com.opos.cmn.biz.web.b.b.a.a.a(progressBar, "mOnlyIndeterminate", new Boolean(false));
        this.i.setIndeterminate(false);
        this.i.setProgressDrawable(new ClipDrawable(new ColorDrawable(Color.parseColor("#33cc9c")), 3, 1));
        this.i.setBackgroundColor(Color.parseColor("#cfcfcf"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f11039a, 1.33f));
        layoutParams.addRule(3, 1);
        this.e.addView(this.i, layoutParams);
    }

    private void k() {
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.opos.cmn.biz.web.b.b.b.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                b.this.r();
            }
        });
        m();
        n();
        o();
        l();
        this.d.requestFocusFromTouch();
        this.d.requestFocus();
    }

    private void l() {
        Map<String, Object> map = this.b;
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            for (Map.Entry<String, Object> entry : this.b.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!com.opos.cmn.an.c.a.a(key) && value != null) {
                    com.opos.cmn.an.f.a.b("WebWidgetImpl", "addJavascriptInterface jsName=" + key + ",object=" + value);
                    this.d.addJavascriptInterface(value, key);
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("WebWidgetImpl", "", e);
        }
    }

    private void m() {
        WebSettings settings = this.d.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.f11039a.getApplicationContext().getDir(WebParameter.PATH_DATABASE, 0).getPath());
        settings.setCacheMode(-1);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this.d, true);
            settings.setMixedContentMode(0);
        }
        settings.setAllowContentAccess(false);
    }

    private void n() {
        this.d.setWebChromeClient(new WebChromeClient() { // from class: com.opos.cmn.biz.web.b.b.b.b.3
            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                com.opos.cmn.an.f.a.b("WebWidgetImpl", "consoleMessage:line=" + consoleMessage.lineNumber() + "sourseId=" + consoleMessage.sourceId() + "message=" + consoleMessage.message());
                return super.onConsoleMessage(consoleMessage);
            }

            @Override // android.webkit.WebChromeClient
            public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
                com.opos.cmn.an.f.a.b("WebWidgetImpl", "onExceededDatabaseQuota=url:" + str);
                quotaUpdater.updateQuota(j2 * 2);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                Tracker.onProgressChanged(this, webView, i);
                super.onProgressChanged(webView, i);
                com.opos.cmn.an.f.a.b("WebWidgetImpl", "onProgressChanged:newProgress=" + i);
                b.this.i.setProgress(i);
                if (i < 100 || b.this.i == null) {
                    return;
                }
                b.this.i.setVisibility(8);
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                com.opos.cmn.an.f.a.b("WebWidgetImpl", "onReceivedTitle=title:" + str);
                super.onReceivedTitle(webView, str);
            }
        });
    }

    private void o() {
        this.d.setWebViewClient(new WebViewClient() { // from class: com.opos.cmn.biz.web.b.b.b.b.4
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                StringBuilder sb = new StringBuilder();
                sb.append("onPageFinished:url=");
                if (str == null) {
                    str = com.igexin.push.core.b.l;
                }
                sb.append(str);
                com.opos.cmn.an.f.a.b("WebWidgetImpl", sb.toString());
                if (b.this.k) {
                    return;
                }
                b.this.p();
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                StringBuilder sb = new StringBuilder();
                sb.append("onPageStarted:url=");
                if (str == null) {
                    str = com.igexin.push.core.b.l;
                }
                sb.append(str);
                com.opos.cmn.an.f.a.b("WebWidgetImpl", sb.toString());
                b.this.k = false;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedError:errorCode=");
                sb.append(i);
                sb.append(",description=");
                if (str == null) {
                    str = com.igexin.push.core.b.l;
                }
                sb.append(str);
                sb.append(",failingUrl=");
                if (str2 == null) {
                    str2 = com.igexin.push.core.b.l;
                }
                sb.append(str2);
                com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
                b.this.k = true;
                b.this.q();
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                StringBuilder sb = new StringBuilder();
                sb.append("onReceivedSslError:error=");
                sb.append(sslError != null ? sslError.toString() : com.igexin.push.core.b.l);
                com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
                b.this.a(sslErrorHandler, sslError);
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (Build.VERSION.SDK_INT >= 26) {
                    com.opos.cmn.an.f.a.d("WebWidgetImpl", "onRenderProcessGone WebView rendering process killed to reclaim memory. Recreating...");
                    b.this.c();
                    return true;
                }
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }

            @Override // android.webkit.WebViewClient
            public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
                StringBuilder sb = new StringBuilder();
                sb.append("onUnhandledKeyEvent:event=");
                sb.append(keyEvent != null ? keyEvent.toString() : com.igexin.push.core.b.l);
                com.opos.cmn.an.f.a.c("WebWidgetImpl", sb.toString());
                super.onUnhandledKeyEvent(webView, keyEvent);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                com.opos.cmn.an.f.a.b("WebWidgetImpl", "shouldInterceptRequest : " + str);
                WebResourceResponse a2 = c.a().a(str);
                return a2 != null ? a2 : super.shouldInterceptRequest(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                StringBuilder sb = new StringBuilder();
                sb.append("shouldOverrideUrlLoading:url=");
                sb.append(str != null ? str : com.igexin.push.core.b.l);
                com.opos.cmn.an.f.a.b("WebWidgetImpl", sb.toString());
                if (com.opos.cmn.an.c.a.a(str) || str.startsWith("http")) {
                    return super.shouldOverrideUrlLoading(webView, str);
                }
                b.this.b(str);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.f.setVisibility(0);
        this.g.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f.setVisibility(8);
        this.g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        com.opos.cmn.biz.web.b.a.a.b bVar = this.l;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void s() {
        if (this.d != null) {
            com.opos.cmn.an.f.a.b("WebWidgetImpl", "closeWebView");
            this.d.removeAllViews();
            this.f.removeView(this.d);
            this.d.stopLoading();
            this.d.getSettings().setJavaScriptEnabled(false);
            this.d.clearHistory();
            this.d.clearCache(true);
            this.d.destroyDrawingCache();
            this.d.destroy();
            this.d = null;
        }
    }

    public View a() {
        return this.e;
    }

    public void a(String str) {
        if (this.d == null || com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        Tracker.loadUrl(this.d, str);
        this.j = str;
    }

    public boolean b() {
        RelativeLayout relativeLayout = this.g;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    public void c() {
        if (this.d != null) {
            com.opos.cmn.an.f.a.b("WebWidgetImpl", "closeWebView");
            s();
            RelativeLayout relativeLayout = this.e;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
                this.e = null;
            }
            this.f11039a = null;
        }
    }

    public void d() {
        com.opos.cmn.an.f.a.b("WebWidgetImpl", "reInitWebView");
        s();
        h();
        k();
    }

    public boolean e() {
        WebView webView = this.d;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        this.d.goBack();
        return true;
    }
}
