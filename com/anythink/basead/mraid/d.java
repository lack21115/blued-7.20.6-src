package com.anythink.basead.mraid;

import android.net.http.SslError;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.basead.c.f;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/mraid/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f6027a = d.class.getSimpleName();

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/mraid/d$a.class */
    public interface a {
        void a();

        void a(com.anythink.basead.c.e eVar);
    }

    public static String a(j jVar, i iVar) {
        if (TextUtils.isEmpty(iVar.i())) {
            if (TextUtils.isEmpty(iVar.h())) {
                return "";
            }
            File b = com.anythink.core.common.res.d.a(n.a().g()).b(jVar, iVar);
            if (b == null) {
                Log.e(f6027a, "loadMraidResource: html no exists: ");
                return com.anythink.core.common.res.d.a(n.a().g()).a(iVar.h(), jVar, iVar);
            }
            String str = f6027a;
            Log.e(str, "loadMraidResource: html exists: " + b.toURI().toString());
            return b.toURI().toString();
        }
        return iVar.i();
    }

    public static void a(final String str, final String str2, final MraidWebView mraidWebView, final a aVar) {
        if (mraidWebView == null) {
            return;
        }
        n.a().a(new Runnable() { // from class: com.anythink.basead.mraid.d.1
            @Override // java.lang.Runnable
            public final void run() {
                String str3 = d.f6027a;
                StringBuilder sb = new StringBuilder();
                sb.append(String.this);
                sb.append(", start load mraid webview");
                com.anythink.basead.mraid.a aVar2 = new com.anythink.basead.mraid.a();
                e eVar = new e(String.this);
                eVar.a(new com.anythink.expressad.atsignalcommon.a.b() { // from class: com.anythink.basead.mraid.d.1.1

                    /* renamed from: a  reason: collision with root package name */
                    boolean f6030a = false;

                    @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                    public final void onPageFinished(WebView webView, String str4) {
                        if (this.f6030a) {
                            return;
                        }
                        this.f6030a = true;
                        if (com.anythink.core.common.res.d.f6907a.equals(str4)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(String.this);
                            sb2.append(", about:blank");
                            if (aVar != null) {
                                aVar.a(f.a(f.n, f.I));
                                return;
                            }
                            return;
                        }
                        com.anythink.expressad.mbbanner.a.a.a.a(webView);
                        if (mraidWebView != null) {
                            com.anythink.basead.a.b.c.a(str, mraidWebView);
                        }
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.this);
                        sb3.append(", load success");
                        if (aVar != null) {
                            aVar.a();
                        }
                    }

                    @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                    public final void onReceivedError(WebView webView, int i, String str4, String str5) {
                        if (this.f6030a) {
                            return;
                        }
                        this.f6030a = true;
                        super.onReceivedError(webView, i, str4, str5);
                        com.anythink.basead.c.e a2 = f.a("10000", i + BridgeUtil.UNDERLINE_STR + str4);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(String.this);
                        sb2.append(", load failed: ");
                        sb2.append(a2.c());
                        if (aVar != null) {
                            aVar.a(a2);
                        }
                    }

                    @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
                    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                        if (this.f6030a) {
                            return;
                        }
                        this.f6030a = true;
                        super.onReceivedSslError(webView, sslErrorHandler, sslError);
                        com.anythink.basead.c.e a2 = f.a("10000", sslError != null ? sslError.toString() : "onReceivedSslError");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(String.this);
                        sb2.append(", load failed: ");
                        sb2.append(a2.c());
                        if (aVar != null) {
                            aVar.a(a2);
                        }
                    }
                });
                mraidWebView.setWebViewClient(eVar);
                mraidWebView.setObject(aVar2);
                mraidWebView.loadUrl(String.this);
            }
        });
    }
}
