package com.alipay.sdk.widget;

import android.content.Context;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.internal.R;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/p.class */
public class p extends LinearLayout {
    private static Handler f = new Handler(Looper.getMainLooper());
    private ImageView a;
    private TextView b;
    private ImageView c;
    private ProgressBar d;
    private WebView e;
    private a g;
    private b h;
    private c i;
    private final com.alipay.sdk.sys.a j;
    private View.OnClickListener k;
    private final float l;

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/p$a.class */
    public interface a {
        void a(p pVar, String str);

        boolean a(p pVar, String str, String str2, String str3, JsPromptResult jsPromptResult);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/p$b.class */
    public interface b {
        boolean a(p pVar, int i, String str, String str2);

        boolean a(p pVar, SslErrorHandler sslErrorHandler, SslError sslError);

        boolean b(p pVar, String str);

        boolean c(p pVar, String str);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/p$c.class */
    public interface c {
        void a(p pVar);

        void b(p pVar);
    }

    public p(Context context, AttributeSet attributeSet, com.alipay.sdk.sys.a aVar) {
        super(context, attributeSet);
        this.k = new q(this);
        this.j = aVar;
        this.l = context.getResources().getDisplayMetrics().density;
        setOrientation(1);
        a(context);
        b(context);
        c(context);
    }

    public p(Context context, com.alipay.sdk.sys.a aVar) {
        this(context, null, aVar);
    }

    private int a(int i) {
        return (int) (i * this.l);
    }

    private void a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(-218103809);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        this.a = imageView;
        imageView.setOnClickListener(this.k);
        this.a.setScaleType(ImageView.ScaleType.CENTER);
        this.a.setImageDrawable(com.alipay.sdk.util.k.a(com.alipay.sdk.util.k.a, context));
        this.a.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.a, new LinearLayout.LayoutParams(-2, -2));
        View view = new View(context);
        view.setBackgroundColor(-2500135);
        linearLayout.addView(view, new LinearLayout.LayoutParams(a(1), a(25)));
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setTextColor(-15658735);
        this.b.setTextSize(17.0f);
        this.b.setMaxLines(1);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(a(17), 0, 0, 0);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.b, layoutParams);
        ImageView imageView2 = new ImageView(context);
        this.c = imageView2;
        imageView2.setOnClickListener(this.k);
        this.c.setScaleType(ImageView.ScaleType.CENTER);
        this.c.setImageDrawable(com.alipay.sdk.util.k.a(com.alipay.sdk.util.k.b, context));
        this.c.setPadding(a(12), 0, a(12), 0);
        linearLayout.addView(this.c, new LinearLayout.LayoutParams(-2, -2));
        addView(linearLayout, new LinearLayout.LayoutParams(-1, a(48)));
    }

    private void b(Context context) {
        ProgressBar progressBar = new ProgressBar(context, null, R.style.Widget_ProgressBar_Horizontal);
        this.d = progressBar;
        progressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.progress_horizontal));
        this.d.setMax(100);
        this.d.setBackgroundColor(-218103809);
        addView(this.d, new LinearLayout.LayoutParams(-1, a(2)));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x009a -> B:4:0x0086). Please submit an issue!!! */
    private void c(Context context) {
        WebView webView = new WebView(context);
        this.e = webView;
        webView.setVerticalScrollbarOverlay(true);
        a(this.e, context);
        WebSettings settings = this.e.getSettings();
        settings.setUseWideViewPort(true);
        settings.setAppCacheMaxSize(5242880L);
        settings.setAppCachePath(context.getCacheDir().getAbsolutePath());
        settings.setAllowFileAccess(true);
        settings.setAppCacheEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(-1);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDomStorageEnabled(true);
        try {
            this.e.removeJavascriptInterface("searchBoxJavaBridge_");
            this.e.removeJavascriptInterface("accessibility");
            this.e.removeJavascriptInterface("accessibilityTraversal");
        } catch (Exception e) {
        }
        addView(this.e, new LinearLayout.LayoutParams(-1, -1));
    }

    public void a() {
        removeAllViews();
        this.e.removeAllViews();
        this.e.setWebViewClient(null);
        this.e.setWebChromeClient(null);
        this.e.destroy();
    }

    protected void a(WebView webView, Context context) {
        String userAgentString = webView.getSettings().getUserAgentString();
        String packageName = context.getPackageName();
        String a2 = com.alipay.sdk.util.n.a(this.j, context);
        webView.getSettings().setUserAgentString(userAgentString + " AlipaySDK(" + packageName + BridgeUtil.SPLIT_MARK + a2 + BridgeUtil.SPLIT_MARK + "15.7.4)");
    }

    public void a(String str) {
        Tracker.loadUrl(this.e, str);
    }

    public void a(String str, byte[] bArr) {
        this.e.postUrl(str, bArr);
    }

    public ImageView getBackButton() {
        return this.a;
    }

    public ProgressBar getProgressbar() {
        return this.d;
    }

    public ImageView getRefreshButton() {
        return this.c;
    }

    public TextView getTitle() {
        return this.b;
    }

    public String getUrl() {
        return this.e.getUrl();
    }

    public WebView getWebView() {
        return this.e;
    }

    public void setChromeProxy(a aVar) {
        this.g = aVar;
        if (aVar == null) {
            this.e.setWebChromeClient(null);
        } else {
            this.e.setWebChromeClient(new s(this));
        }
    }

    public void setWebClientProxy(b bVar) {
        this.h = bVar;
        if (bVar == null) {
            this.e.setWebViewClient(null);
        } else {
            this.e.setWebViewClient(new t(this));
        }
    }

    public void setWebEventProxy(c cVar) {
        this.i = cVar;
    }
}
