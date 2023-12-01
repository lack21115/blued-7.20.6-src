package com.kwad.components.core.webview.kwai;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bo;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/kwai/a.class */
public final class a {
    private com.kwad.components.core.d.b.c IM;
    private WebView Lc;
    private boolean RK;
    private KsAppDownloadListener RT;
    private int RU = -100;
    private int RV = 0;
    private com.kwad.sdk.core.webview.b cV;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.core.webview.kwai.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/kwai/a$a.class */
    public static final class C0543a extends com.kwad.sdk.core.response.kwai.a {
        public String packageName;
        public String url;
    }

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/kwai/a$b.class */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public int progress;
        public int status;
    }

    public a(WebView webView, com.kwad.sdk.core.webview.b bVar) {
        this.Lc = webView;
        this.mAdTemplate = bVar.getAdTemplate();
        this.cV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(String str) {
        try {
            C0543a c0543a = new C0543a();
            c0543a.parseJson(new JSONObject(str));
            if (k(c0543a.url, c0543a.packageName)) {
                return;
            }
            if (this.IM == null) {
                j(c0543a.url, c0543a.packageName);
            }
            if (this.IM.nk()) {
                return;
            }
            this.IM.d(this.RT);
            this.IM.m(new a.C0519a(this.cV.Lc.getContext()).ao(true).ap(false).I(this.mAdTemplate).ar(false));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    private void h(String str, String str2) {
        WebView webView;
        if (this.RK || TextUtils.isEmpty(str) || (webView = this.Lc) == null) {
            return;
        }
        bo.a(webView, str, str2);
    }

    private void j(String str, String str2) {
        synchronized (this) {
            this.IM = new com.kwad.components.core.d.b.c(this.mAdTemplate, null, str, str2);
            if (this.RT == null) {
                KsAppDownloadListener qU = qU();
                this.RT = qU;
                this.IM.b(qU);
            }
        }
    }

    private static boolean k(String str, String str2) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i, int i2) {
        this.RV = i2;
        if (this.RU != i) {
            this.RU = i;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            h("onDownLoadStatusCallback", sb.toString());
        }
    }

    private KsAppDownloadListener qU() {
        return new com.kwad.sdk.core.download.kwai.a() { // from class: com.kwad.components.core.webview.kwai.a.2
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                a.this.n(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                a.this.n(8, 100);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                a.this.n(0, 0);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                a.this.n(12, 100);
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                a.this.n(4, i);
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                if (i == 0) {
                    a.this.n(1, 0);
                } else {
                    a.this.n(2, i);
                }
            }
        };
    }

    public final void destroy() {
        this.RK = true;
        com.kwad.components.core.d.b.c cVar = this.IM;
        if (cVar != null) {
            cVar.c(this.RT);
        }
    }

    @JavascriptInterface
    public final int getDownLoadStatus(String str, String str2) {
        if (k(str, str2)) {
            return 0;
        }
        if (this.IM == null) {
            j(str, str2);
        }
        return this.IM.nb();
    }

    @JavascriptInterface
    public final int getProgress(String str, String str2) {
        if (k(str, str2)) {
            return 0;
        }
        if (this.IM == null) {
            j(str, str2);
        }
        return this.RV;
    }

    @JavascriptInterface
    public final void handleAdClick(final String str) {
        bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.kwai.a.1
            @Override // java.lang.Runnable
            public final void run() {
                a.this.aI(str);
            }
        });
    }
}
