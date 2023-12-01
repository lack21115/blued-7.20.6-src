package com.cmic.gen.sdk.tencent.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.cmic.gen.sdk.tencent.auth.GenAuthnHelper;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/d.class */
public class d extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private WebView f8098a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f8099c;
    private LinearLayout d;

    public d(Context context, int i, String str, String str2) {
        super(context, i);
        try {
            this.f8099c = str;
            this.b = str2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ViewGroup c() {
        View findViewById;
        try {
            LinearLayout linearLayout = new LinearLayout(getContext());
            this.d = linearLayout;
            linearLayout.setOrientation(1);
            this.d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            GenAuthThemeConfig authThemeConfig = GenAuthnHelper.getInstance(getContext()).getAuthThemeConfig();
            int clauseLayoutResID = authThemeConfig.getClauseLayoutResID();
            String str = TextUtils.isEmpty(this.f8099c) ? com.cmic.gen.sdk.tencent.c.d[authThemeConfig.getAppLanguageType()] : this.f8099c;
            if (clauseLayoutResID != -1) {
                RelativeLayout a2 = e.a(getContext(), getLayoutInflater().inflate(clauseLayoutResID, (ViewGroup) this.d, false), 1118481, 0, str, (View.OnClickListener) null);
                String clauseLayoutReturnID = authThemeConfig.getClauseLayoutReturnID();
                if (!TextUtils.isEmpty(clauseLayoutReturnID) && (findViewById = a2.findViewById(c.a(getContext(), clauseLayoutReturnID))) != null) {
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.cmic.gen.sdk.tencent.view.d.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            d.this.f8098a.stopLoading();
                            d.this.b();
                        }
                    });
                }
                this.d.addView(a2);
            } else {
                this.d.addView(e.a(getContext(), (View) null, 1118481, 2236962, str, new View.OnClickListener() { // from class: com.cmic.gen.sdk.tencent.view.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        d.this.f8098a.stopLoading();
                        d.this.b();
                    }
                }));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.d;
    }

    private void d() {
        WebView webView = new WebView(getContext());
        this.f8098a = webView;
        WebSettings settings = webView.getSettings();
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setSavePassword(false);
        settings.setJavaScriptEnabled(true);
        this.d.addView(this.f8098a, new LinearLayout.LayoutParams(-1, -1));
        if (Build.VERSION.SDK_INT < 17) {
            this.f8098a.removeJavascriptInterface("searchBoxJavaBridge_");
            this.f8098a.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
            this.f8098a.removeJavascriptInterface("accessibilityTraversal");
        }
        this.f8098a.setWebViewClient(new WebViewClient() { // from class: com.cmic.gen.sdk.tencent.view.d.3
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                Tracker.loadUrl(d.this.f8098a, str);
                return true;
            }
        });
        Tracker.loadUrl(this.f8098a, this.b);
    }

    protected void a() {
        View decorView;
        requestWindowFeature(1);
        int i = 0;
        getWindow().setFeatureDrawableAlpha(0, 0);
        GenAuthThemeConfig authThemeConfig = GenAuthnHelper.getInstance(getContext()).getAuthThemeConfig();
        if (Build.VERSION.SDK_INT >= 21 && authThemeConfig.getStatusBarColor() != 0) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(authThemeConfig.getStatusBarColor());
            getWindow().setNavigationBarColor(authThemeConfig.getStatusBarColor());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (authThemeConfig.isLightColor()) {
                decorView = getWindow().getDecorView();
                i = 8192;
            } else {
                decorView = getWindow().getDecorView();
            }
            decorView.setSystemUiVisibility(i);
        }
        setContentView(c());
    }

    public void b() {
        if (this.f8098a.canGoBack()) {
            this.f8098a.goBack();
        } else {
            dismiss();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        WebView webView = this.f8098a;
        if (webView != null) {
            webView.stopLoading();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.d == null) {
            a();
        }
        if (this.f8098a == null) {
            d();
        }
        super.show();
    }
}
