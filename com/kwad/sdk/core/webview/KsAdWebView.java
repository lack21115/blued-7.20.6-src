package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityManager;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwad.sdk.core.webview.kwai.c;
import com.kwad.sdk.j.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.s;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/KsAdWebView.class */
public class KsAdWebView extends com.kwad.sdk.core.webview.c {
    private com.kwad.sdk.core.webview.kwai.c apw;
    private String apx;
    private long apy;
    private com.kwad.sdk.core.webview.d apz;
    private c.a kl;
    private String mUniqueId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/KsAdWebView$a.class */
    public final class a implements DownloadListener {
        private a() {
        }

        /* synthetic */ a(KsAdWebView ksAdWebView, byte b) {
            this();
        }

        @Override // android.webkit.DownloadListener
        public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (KsAdWebView.this.kl == null || KsAdWebView.this.kl.getAdTemplate() == null || !KsAdWebView.this.kl.yY()) {
                try {
                    KsAdWebView.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return;
                } catch (Exception e) {
                    com.kwad.sdk.core.d.b.printStackTrace(e);
                    return;
                }
            }
            com.kwad.sdk.core.response.a.d.cb(KsAdWebView.this.kl.getAdTemplate()).adConversionInfo.appDownloadUrl = str;
            KsAdWebView.this.kl.getAdTemplate().isWebViewDownload = true;
            c.a readyClientConfig = KsAdWebView.this.getReadyClientConfig();
            if (readyClientConfig != null) {
                readyClientConfig.ct(KsAdWebView.this.kl.getAdTemplate());
            }
            ((com.kwad.sdk.service.kwai.a) ServiceProvider.get(com.kwad.sdk.service.kwai.a.class)).h(k.wrapContextIfNeed(KsAdWebView.this.getContext()), KsAdWebView.this.kl.getAdTemplate());
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/KsAdWebView$b.class */
    public interface b {
        void onFailed();

        void onSuccess();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/KsAdWebView$c.class */
    public interface c {
        void ot();
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/KsAdWebView$d.class */
    public interface d {
        void onPageFinished();

        void onPageStart();

        void onReceivedHttpError(int i, String str, String str2);
    }

    public KsAdWebView(Context context) {
        super(context);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public KsAdWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c.a getReadyClientConfig() {
        com.kwad.sdk.core.webview.kwai.c cVar = this.apw;
        if (cVar == null || cVar.getClientConfig() == null) {
            return null;
        }
        return this.apw.getClientConfig();
    }

    private void init(Context context) {
        com.kwad.sdk.core.d.b.i("KsAdWebView", "init");
        setAccessibilityStateDisable(context);
        WebSettings a2 = bn.a(this);
        a2.setUseWideViewPort(true);
        a2.setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(false);
        com.kwad.sdk.core.webview.kwai.c cVar = new com.kwad.sdk.core.webview.kwai.c() { // from class: com.kwad.sdk.core.webview.KsAdWebView.1
            @Override // com.kwad.sdk.core.webview.kwai.c, android.webkit.WebViewClient
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (KsAdWebView.this.apz != null) {
                    KsAdWebView.this.apz.c(KsAdWebView.this.kl);
                }
            }

            @Override // com.kwad.sdk.core.webview.kwai.c, android.webkit.WebViewClient
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (KsAdWebView.this.apz != null) {
                    com.kwad.sdk.core.webview.d unused = KsAdWebView.this.apz;
                    com.kwad.sdk.core.webview.d.d(KsAdWebView.this.kl);
                }
            }
        };
        this.apw = cVar;
        cVar.dc(this.mUniqueId);
        setWebViewClient(this.apw);
        setWebChromeClient(new com.kwad.sdk.core.webview.kwai.b());
        setDownloadListener(new a(this, (byte) 0));
        String userAgentString = a2.getUserAgentString();
        a2.setUserAgentString(userAgentString + yV());
        c.a aVar = new c.a(getContext());
        this.kl = aVar;
        if (aVar.yZ()) {
            this.apz = new com.kwad.sdk.core.webview.d();
        }
    }

    private void setAccessibilityStateDisable(Context context) {
        if (Build.VERSION.SDK_INT != 17 || context == null) {
            return;
        }
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
            if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                return;
            }
            s.a((Object) accessibilityManager, "setState", 0);
        } catch (Throwable th) {
        }
    }

    private String yV() {
        return "KSADSDK_V3.3.40_" + getContext().getPackageName() + "_" + com.kwad.sdk.utils.k.bH(getContext());
    }

    public c.a getClientConfig() {
        return this.kl;
    }

    public long getLoadTime() {
        return this.apy;
    }

    public String getLoadUrl() {
        return this.apx;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        com.kwad.sdk.core.webview.a.b.b.dn(this.mUniqueId);
        this.apx = str;
        this.apy = System.currentTimeMillis();
        super.loadUrl(str);
    }

    public final void onActivityCreate() {
        com.kwad.sdk.core.webview.d dVar = this.apz;
        if (dVar != null) {
            dVar.a(this.kl);
        }
    }

    public final void onActivityDestroy() {
        release();
        com.kwad.sdk.core.webview.d dVar = this.apz;
        if (dVar != null) {
            dVar.b(this.kl);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        c.a aVar = this.kl;
        if (aVar == null || aVar.os() == null) {
            return;
        }
        this.kl.os().ot();
    }

    public void setClientConfig(c.a aVar) {
        this.apw.setClientConfig(aVar);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (com.kwad.kwai.kwai.a.bI.booleanValue() && !(webChromeClient instanceof com.kwad.sdk.core.webview.kwai.b)) {
            throw new IllegalArgumentException("client is not instanceof KSWebChromeClient");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (com.kwad.kwai.kwai.a.bI.booleanValue() && !(webViewClient instanceof com.kwad.sdk.core.webview.kwai.a)) {
            throw new IllegalArgumentException("Not supported set webViewClient, please check it");
        }
        super.setWebViewClient(webViewClient);
    }
}
