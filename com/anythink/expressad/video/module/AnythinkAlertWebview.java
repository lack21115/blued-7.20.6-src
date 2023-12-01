package com.anythink.expressad.video.module;

import android.content.ClipDescription;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.b.a;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.webview.BrowserView;
import com.anythink.expressad.video.signal.factory.b;
import com.anythink.expressad.videocommon.b.i;
import com.anythink.expressad.videocommon.e.c;
import com.anythink.expressad.videocommon.e.d;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/AnythinkAlertWebview.class */
public class AnythinkAlertWebview extends AnythinkH5EndCardView {
    private String A;

    public AnythinkAlertWebview(Context context) {
        super(context);
    }

    public AnythinkAlertWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public final String a() {
        if (TextUtils.isEmpty(this.x)) {
            return "";
        }
        c.a().a(a.b().e(), this.x, false);
        String J = d.J();
        this.A = J;
        return !TextUtils.isEmpty(J) ? i.a().c(this.A) : "";
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    protected final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        String a2 = a();
        if (!this.f || this.b == null || TextUtils.isEmpty(a2)) {
            this.e.a(101, "");
            return;
        }
        BrowserView.DownloadListener downloadListener = new BrowserView.DownloadListener(this.b);
        downloadListener.setTitle(this.b.bb());
        this.s.setDownloadListener(downloadListener);
        this.s.setCampaignId(this.b.aZ());
        setCloseVisible(8);
        this.s.setApiManagerJSFactory(bVar);
        this.s.setWebViewListener(new com.anythink.expressad.atsignalcommon.a.b() { // from class: com.anythink.expressad.video.module.AnythinkAlertWebview.1
            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                o.d("AlertWebview", "===========finish+".concat(String.valueOf(str)));
                j.a();
                j.a(webView, "onJSBridgeConnected", "");
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                o.d("AlertWebview", "===========onReceivedError");
                if (AnythinkAlertWebview.this.w) {
                    return;
                }
                o.a(AnythinkBaseView.TAG, "onReceivedError,url:".concat(String.valueOf(str2)));
                AnythinkAlertWebview.this.w = true;
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void readyState(WebView webView, int i) {
                super.readyState(webView, i);
                o.d("MBridgeAlertWebview", "===========readyState  :  ".concat(String.valueOf(i)));
                if (AnythinkAlertWebview.this.w) {
                    return;
                }
                AnythinkAlertWebview anythinkAlertWebview = AnythinkAlertWebview.this;
                boolean z = true;
                if (i != 1) {
                    z = false;
                }
                anythinkAlertWebview.v = z;
            }
        });
        setHtmlSource(com.anythink.expressad.videocommon.b.j.a().b(a2));
        this.v = false;
        if (TextUtils.isEmpty(this.u)) {
            o.a(AnythinkBaseView.TAG, "load url:".concat(String.valueOf(a2)));
            this.s.loadUrl(a2);
        } else {
            o.a(AnythinkBaseView.TAG, "load html...");
            this.s.loadDataWithBaseURL(a2, this.u, ClipDescription.MIMETYPE_TEXT_HTML, "UTF-8", null);
        }
        this.s.setBackgroundColor(0);
        setBackgroundColor(0);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.h
    public void webviewshow() {
        if (this.q != null) {
            this.q.setBackgroundColor(0);
        }
        super.webviewshow();
    }
}
