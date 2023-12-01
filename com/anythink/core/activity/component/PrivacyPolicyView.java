package com.anythink.core.activity.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.api.ATSDK;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.h;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/activity/component/PrivacyPolicyView.class */
public class PrivacyPolicyView extends RelativeLayout implements View.OnClickListener {
    private static String n = PrivacyPolicyView.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    ViewGroup f6332a;
    LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    LoadingView f6333c;
    TextView d;
    FrameLayout e;
    WebView f;
    CheckBox g;
    View h;
    TextView i;
    boolean j;
    boolean k;
    String l;
    a m;

    /* renamed from: com.anythink.core.activity.component.PrivacyPolicyView$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/activity/component/PrivacyPolicyView$1.class */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            try {
                if (PrivacyPolicyView.this.f == null || PrivacyPolicyView.this.k) {
                    return;
                }
                PrivacyPolicyView.this.j = true;
                Log.d(PrivacyPolicyView.n, "reload.......");
                PrivacyPolicyView.this.loadPolicyUrl(PrivacyPolicyView.this.l);
            } catch (Throwable th) {
            }
        }
    }

    /* renamed from: com.anythink.core.activity.component.PrivacyPolicyView$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/activity/component/PrivacyPolicyView$2.class */
    final class AnonymousClass2 extends WebViewClient {
        AnonymousClass2() {
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            try {
                String str2 = PrivacyPolicyView.n;
                Log.d(str2, "onPageFinished：" + str + "   mIsWebViewloadSuccess:" + PrivacyPolicyView.this.j);
                if (PrivacyPolicyView.this.l.equals(str)) {
                    if (PrivacyPolicyView.this.j) {
                        PrivacyPolicyView.this.b.setVisibility(4);
                        PrivacyPolicyView.this.f6332a.setVisibility(0);
                        PrivacyPolicyView.this.b.setVisibility(8);
                        PrivacyPolicyView.this.f6333c.clearAnimation();
                        if (PrivacyPolicyView.this.m != null) {
                            PrivacyPolicyView.this.m.onPageLoadSuccess();
                        }
                    } else {
                        PrivacyPolicyView.this.b.setVisibility(0);
                        PrivacyPolicyView.this.f6333c.clearAnimation();
                        PrivacyPolicyView.this.d.setVisibility(0);
                        PrivacyPolicyView.this.f6332a.setVisibility(8);
                        if (PrivacyPolicyView.this.m != null) {
                            PrivacyPolicyView.this.m.onPageLoadFail();
                        }
                    }
                    PrivacyPolicyView.this.k = false;
                    super.onPageFinished(webView, str);
                }
            } catch (Throwable th) {
            }
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            Log.d(PrivacyPolicyView.n, "onPageStarted：".concat(String.valueOf(str)));
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            PrivacyPolicyView.this.j = false;
            String str = PrivacyPolicyView.n;
            Log.d(str, "onPageFinished：" + webResourceError.getErrorCode());
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.d(PrivacyPolicyView.n, "shouldOverrideUrlLoading：".concat(String.valueOf(str)));
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            PrivacyPolicyView.a(PrivacyPolicyView.this.getContext(), str);
            return true;
        }
    }

    /* renamed from: com.anythink.core.activity.component.PrivacyPolicyView$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/activity/component/PrivacyPolicyView$3.class */
    final class AnonymousClass3 extends WebChromeClient {
        AnonymousClass3() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            Tracker.onProgressChanged(this, webView, i);
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView webView, String str) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("error")) {
                PrivacyPolicyView.this.j = false;
            }
            super.onReceivedTitle(webView, str);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/activity/component/PrivacyPolicyView$a.class */
    public interface a {
        void onLevelSelect(int i);

        void onPageLoadFail();

        void onPageLoadSuccess();
    }

    public PrivacyPolicyView(Context context) {
        super(context);
        this.j = true;
        this.k = false;
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "privace_policy_layout", "layout"), this);
        this.f6332a = (ViewGroup) findViewById(h.a(getContext(), "policy_content_view", "id"));
        this.b = (LinearLayout) findViewById(h.a(getContext(), "policy_loading_view", "id"));
        this.f6333c = new LoadingView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h.a(getContext(), 30.0f), h.a(getContext(), 30.0f));
        layoutParams.gravity = 1;
        this.f6333c.setLayoutParams(layoutParams);
        this.d = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = h.a(getContext(), 5.0f);
        this.d.setLayoutParams(layoutParams2);
        this.d.setText("Page failed to load, please try again later.");
        this.d.setTextColor(-8947849);
        this.d.setTextSize(1, 12.0f);
        this.b.addView(this.f6333c);
        this.b.addView(this.d);
        this.b.setOnClickListener(new AnonymousClass1());
        this.e = (FrameLayout) findViewById(h.a(getContext(), "policy_webview_area", "id"));
        WebView webView = new WebView(getContext());
        this.f = webView;
        g.a(webView);
        this.e.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
        WebSettings settings = this.f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setAppCacheEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f.setWebViewClient(new AnonymousClass2());
        this.f.setWebChromeClient(new AnonymousClass3());
        this.g = (CheckBox) findViewById(h.a(getContext(), "policy_check_box", "id"));
        this.h = findViewById(h.a(getContext(), "policy_agree_view", "id"));
        this.i = (TextView) findViewById(h.a(getContext(), "policy_reject_view", "id"));
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        int a2 = h.a(getContext(), 20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13472268);
        gradientDrawable.setCornerRadius(a2);
        this.h.setBackgroundDrawable(gradientDrawable);
        this.i.setText(Html.fromHtml("<u>No,Thanks</u>"));
    }

    static /* synthetic */ void a(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "privace_policy_layout", "layout"), this);
        this.f6332a = (ViewGroup) findViewById(h.a(getContext(), "policy_content_view", "id"));
        this.b = (LinearLayout) findViewById(h.a(getContext(), "policy_loading_view", "id"));
        this.f6333c = new LoadingView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(h.a(getContext(), 30.0f), h.a(getContext(), 30.0f));
        layoutParams.gravity = 1;
        this.f6333c.setLayoutParams(layoutParams);
        this.d = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = h.a(getContext(), 5.0f);
        this.d.setLayoutParams(layoutParams2);
        this.d.setText("Page failed to load, please try again later.");
        this.d.setTextColor(-8947849);
        this.d.setTextSize(1, 12.0f);
        this.b.addView(this.f6333c);
        this.b.addView(this.d);
        this.b.setOnClickListener(new AnonymousClass1());
        this.e = (FrameLayout) findViewById(h.a(getContext(), "policy_webview_area", "id"));
        WebView webView = new WebView(getContext());
        this.f = webView;
        g.a(webView);
        this.e.addView(this.f, new FrameLayout.LayoutParams(-1, -1));
        WebSettings settings = this.f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setAppCacheEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f.setWebViewClient(new AnonymousClass2());
        this.f.setWebChromeClient(new AnonymousClass3());
        this.g = (CheckBox) findViewById(h.a(getContext(), "policy_check_box", "id"));
        this.h = findViewById(h.a(getContext(), "policy_agree_view", "id"));
        this.i = (TextView) findViewById(h.a(getContext(), "policy_reject_view", "id"));
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        int a2 = h.a(getContext(), 20.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-13472268);
        gradientDrawable.setCornerRadius(a2);
        this.h.setBackgroundDrawable(gradientDrawable);
        this.i.setText(Html.fromHtml("<u>No,Thanks</u>"));
    }

    private static void b(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void c() {
        WebSettings settings = this.f.getSettings();
        if (settings != null) {
            settings.setJavaScriptEnabled(false);
            settings.setAppCacheEnabled(true);
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportZoom(false);
            settings.setSavePassword(false);
            settings.setDatabaseEnabled(false);
            settings.setRenderPriority(WebSettings.RenderPriority.HIGH);
            settings.setPluginState(WebSettings.PluginState.ON);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
        }
        this.f.setWebViewClient(new AnonymousClass2());
        this.f.setWebChromeClient(new AnonymousClass3());
    }

    public void destory() {
        try {
            removeAllViews();
            if (this.f6332a != null) {
                this.f6332a.removeAllViews();
            }
            if (this.e != null) {
                this.e.removeView(this.f);
                this.f.removeAllViews();
            }
            if (this.f != null) {
                this.f.clearHistory();
                this.f.clearCache(true);
                this.f.destroy();
                this.f = null;
            }
        } catch (Throwable th) {
        }
    }

    public void loadPolicyUrl(String str) {
        if (this.k) {
            return;
        }
        this.l = str;
        if (!h.a(getContext())) {
            this.j = false;
            this.b.setVisibility(0);
            this.f6333c.clearAnimation();
            this.d.setVisibility(0);
            this.f6332a.setVisibility(8);
            a aVar = this.m;
            if (aVar != null) {
                aVar.onPageLoadFail();
                return;
            }
            return;
        }
        this.j = true;
        this.b.setVisibility(0);
        this.f6333c.clearAnimation();
        this.f6333c.startAnimation();
        this.d.setVisibility(8);
        this.k = true;
        if (this.l.equals(this.f.getUrl())) {
            this.f.reload();
        } else {
            Tracker.loadUrl(this.f, this.l);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view == this.h) {
            ATSDK.setGDPRUploadDataLevel(getContext(), 0);
            view.setTag(0);
            a aVar = this.m;
            if (aVar != null) {
                aVar.onLevelSelect(0);
            }
        } else if (view == this.i) {
            ATSDK.setGDPRUploadDataLevel(getContext(), 1);
            view.setTag(1);
            a aVar2 = this.m;
            if (aVar2 != null) {
                aVar2.onLevelSelect(1);
            }
        }
    }

    public void setResultCallbackListener(a aVar) {
        this.m = aVar;
    }
}
