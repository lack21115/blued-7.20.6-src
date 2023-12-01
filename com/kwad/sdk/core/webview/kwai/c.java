package com.kwad.sdk.core.webview.kwai;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/kwai/c.class */
public class c extends com.kwad.sdk.core.webview.kwai.a {
    private a kl;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/webview/kwai/c$a.class */
    public static final class a {
        private KsAdWebView.c LI;
        private y.b ajW;
        private KsAdWebView.d apE;
        private KsAdWebView.b apF;
        private boolean apI;
        private AdTemplate mAdTemplate;
        private final Context mContext;
        private boolean apG = true;
        private boolean apH = true;
        private boolean apD = true;

        public a(Context context) {
            this.mContext = context;
        }

        public final a a(KsAdWebView.b bVar) {
            this.apF = bVar;
            return this;
        }

        public final a b(y.b bVar) {
            this.ajW = bVar;
            return this;
        }

        public final a b(KsAdWebView.d dVar) {
            this.apE = dVar;
            return this;
        }

        public final a bc(boolean z) {
            this.apH = z;
            return this;
        }

        public final a bd(boolean z) {
            this.apG = z;
            return this;
        }

        public final a be(boolean z) {
            this.apI = true;
            return this;
        }

        public final a c(KsAdWebView.c cVar) {
            this.LI = cVar;
            return this;
        }

        public final a ct(AdTemplate adTemplate) {
            this.mAdTemplate = adTemplate;
            return this;
        }

        public final AdTemplate getAdTemplate() {
            return this.mAdTemplate;
        }

        public final y.b getClientParams() {
            return this.ajW;
        }

        public final Context getContext() {
            return this.mContext;
        }

        public final KsAdWebView.d getWebListener() {
            return this.apE;
        }

        public final KsAdWebView.b lI() {
            return this.apF;
        }

        public final KsAdWebView.c os() {
            return this.LI;
        }

        public final boolean yW() {
            return this.apH;
        }

        public final boolean yX() {
            return this.apD;
        }

        public final boolean yY() {
            return this.apG;
        }

        public final boolean yZ() {
            return this.apI;
        }
    }

    public final void dc(String str) {
        this.mUniqueId = str;
    }

    public final a getClientConfig() {
        return this.kl;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.kwad.sdk.core.webview.a.b.b.O(this.mUniqueId, "onPageFinished");
        a aVar = this.kl;
        if (aVar == null || aVar.getWebListener() == null) {
            return;
        }
        this.kl.getWebListener().onPageFinished();
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        com.kwad.sdk.core.webview.a.b.b.O(this.mUniqueId, "onPageStart");
        a aVar = this.kl;
        if (aVar == null || aVar.getWebListener() == null) {
            return;
        }
        this.kl.getWebListener().onPageStart();
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        com.kwad.sdk.core.d.b.d("KsAdWebViewClient", "onReceivedError " + i);
        a aVar = this.kl;
        if (aVar != null && aVar.getWebListener() != null) {
            this.kl.getWebListener().onReceivedHttpError(i, str, str2);
        }
        com.kwad.sdk.core.webview.a.b.b.Q(str2, str);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return (Build.VERSION.SDK_INT >= 26 && renderProcessGoneDetail != null && renderProcessGoneDetail.didCrash()) || super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    public final void setClientConfig(a aVar) {
        this.kl = aVar;
        setNeedHybridLoad(aVar.yX());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.d.b.w("KsAdWebViewClient", "shouldOverrideUrlLoading url=" + str);
        com.kwad.sdk.core.webview.a.b.b.O(this.mUniqueId, "shouldOverrideUrlLoading");
        try {
            if (!str.startsWith("http") && !str.startsWith("https")) {
                if (!str.startsWith("tel:") && !str.startsWith("sms:")) {
                    if (this.kl == null || !this.kl.yW()) {
                        return true;
                    }
                    int g = ((com.kwad.sdk.service.kwai.a) ServiceProvider.get(com.kwad.sdk.service.kwai.a.class)).g(this.kl.getContext(), str);
                    if (g == 1) {
                        if (this.kl.lI() != null) {
                            this.kl.lI().onSuccess();
                        }
                        com.kwad.sdk.core.report.a.a(this.kl.getAdTemplate(), "", 2, (y.b) null);
                        return true;
                    }
                    if (this.kl.lI() != null) {
                        this.kl.lI().onFailed();
                    }
                    if (g == -1) {
                        com.kwad.sdk.core.report.a.b(this.kl.getAdTemplate(), "", 2, (y.b) null);
                        return true;
                    }
                    return true;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (this.kl != null) {
                    this.kl.getContext().startActivity(intent);
                    return true;
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return true;
        }
    }
}
