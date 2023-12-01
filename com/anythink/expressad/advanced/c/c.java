package com.anythink.expressad.advanced.c;

import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.advanced.view.ATNativeAdvancedView;
import com.anythink.expressad.advanced.view.ATNativeAdvancedWebview;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.videocommon.b.e;
import com.anythink.expressad.videocommon.b.i;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f7026a = "ResManager";
    private static int b = 1;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/c$a.class */
    public interface a {
        void a();

        void b();
    }

    private static com.anythink.expressad.foundation.d.c a(com.anythink.expressad.foundation.d.c cVar) {
        if (!TextUtils.isEmpty(cVar.c()) || (!TextUtils.isEmpty(cVar.d()) && cVar.d().contains("<MBTPLMARK>"))) {
            cVar.a(true);
            cVar.b(false);
            return cVar;
        }
        cVar.a(false);
        cVar.b(true);
        return cVar;
    }

    private static String a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return "file:///" + file.getAbsolutePath();
            }
            return "";
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Exception e) {
                e.getMessage();
                return "";
            }
        }
    }

    private static void a(ATNativeAdvancedView aTNativeAdvancedView, String str, com.anythink.expressad.foundation.d.c cVar, String str2, String str3, int i) {
        a(aTNativeAdvancedView, str, cVar, str2, str3, i, null);
    }

    private static void a(final ATNativeAdvancedView aTNativeAdvancedView, final String str, final com.anythink.expressad.foundation.d.c cVar, String str2, String str3, int i, final a aVar) {
        if (aTNativeAdvancedView == null || aTNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = new NativeAdvancedJSBridgeImpl(aTNativeAdvancedView.getContext(), str2, str3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        nativeAdvancedJSBridgeImpl.setCampaignList(arrayList);
        nativeAdvancedJSBridgeImpl.setAllowSkip(i);
        aTNativeAdvancedView.setAdvancedNativeJSBridgeImpl(nativeAdvancedJSBridgeImpl);
        final ATNativeAdvancedWebview advancedNativeWebview = aTNativeAdvancedView.getAdvancedNativeWebview();
        System.currentTimeMillis();
        advancedNativeWebview.setWebViewListener(new com.anythink.expressad.atsignalcommon.a.b() { // from class: com.anythink.expressad.advanced.c.c.1
            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onPageFinished(WebView webView, String str4) {
                super.onPageFinished(webView, str4);
                if (!com.anythink.expressad.foundation.d.c.this.s()) {
                    com.anythink.expressad.advanced.a.a.a(com.anythink.expressad.foundation.d.c.this.Z());
                    aTNativeAdvancedView.setH5Ready(true);
                    o.a("WindVaneWebView", "======渲染成功：finish");
                }
                NativeAdvancedJsUtils.fireOnJSBridgeConnected(webView);
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedError(WebView webView, int i2, String str4, String str5) {
                super.onReceivedError(webView, i2, str4, str5);
                aTNativeAdvancedView.setH5Ready(false);
                o.a("WindVaneWebView", "======渲染失败");
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                aTNativeAdvancedView.setH5Ready(false);
                o.a("WindVaneWebView", "======渲染失败");
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }

            @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
            public final void readyState(WebView webView, int i2) {
                super.readyState(webView, i2);
                if (i2 == 1) {
                    com.anythink.expressad.advanced.a.a.a(com.anythink.expressad.foundation.d.c.this.Z());
                    aTNativeAdvancedView.setH5Ready(true);
                    o.a("WindVaneWebView", "======渲染成功：ready");
                } else {
                    aTNativeAdvancedView.setH5Ready(false);
                    o.a("WindVaneWebView", "======渲染失败");
                }
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        });
        if (advancedNativeWebview.isDestroyed()) {
            aTNativeAdvancedView.setH5Ready(false);
            return;
        }
        o.a(f7026a, "======开始渲染：".concat(String.valueOf(str)));
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.anythink.expressad.advanced.c.c.2
            @Override // java.lang.Runnable
            public final void run() {
                ATNativeAdvancedWebview.this.loadUrl(str);
            }
        });
    }

    public static boolean a(ATNativeAdvancedView aTNativeAdvancedView, com.anythink.expressad.foundation.d.c cVar) {
        boolean z;
        if (aTNativeAdvancedView == null) {
            o.d(f7026a, "mbAdvancedNativeView  is null");
            return false;
        }
        boolean z2 = true;
        if (!TextUtils.isEmpty(cVar.S())) {
            z2 = aTNativeAdvancedView.isVideoReady();
            o.d(f7026a, "======isReady isVideoReady:".concat(String.valueOf(z2)));
        }
        boolean z3 = z2;
        if (z2) {
            z3 = z2;
            if (!TextUtils.isEmpty(cVar.c())) {
                z3 = com.anythink.expressad.advanced.a.a.b(cVar.Z());
                o.d(f7026a, "======isReady getAdZip:" + z3 + "---requestId:" + cVar.Z());
            }
        }
        boolean z4 = z3;
        if (z3) {
            z4 = z3;
            if (TextUtils.isEmpty(cVar.c())) {
                z4 = z3;
                if (!TextUtils.isEmpty(cVar.d())) {
                    z4 = com.anythink.expressad.advanced.a.a.b(cVar.Z());
                    o.d(f7026a, "======isReady getAdHtml:".concat(String.valueOf(z4)));
                }
            }
        }
        if (TextUtils.isEmpty(cVar.c()) && TextUtils.isEmpty(cVar.d())) {
            o.d(f7026a, "======isReady getAdHtml  getAdZip all are empty");
            z = false;
        } else {
            z = z4;
        }
        boolean z5 = z;
        if (z) {
            z5 = z;
            if (!TextUtils.isEmpty(cVar.I())) {
                z5 = aTNativeAdvancedView.isEndCardReady();
                o.d(f7026a, "======isReady isEndCardReady:".concat(String.valueOf(z5)));
            }
        }
        return z5;
    }

    public static boolean a(ATNativeAdvancedView aTNativeAdvancedView, com.anythink.expressad.foundation.d.c cVar, String str, String str2, int i, a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (cVar != null) {
            aTNativeAdvancedView.clearResState();
            if (TextUtils.isEmpty(cVar.S())) {
                z3 = true;
            } else {
                boolean a2 = e.a().a(298, str2, cVar.A());
                z3 = a2;
                if (a2) {
                    z3 = a2;
                }
                if (!TextUtils.isEmpty(cVar.I()) && !aTNativeAdvancedView.isEndCardReady() && !TextUtils.isEmpty(i.a().c(cVar.I()))) {
                    aTNativeAdvancedView.setEndCardReady(true);
                }
                if (!TextUtils.isEmpty(cVar.c()) || aTNativeAdvancedView.isH5Ready()) {
                    z4 = false;
                } else {
                    String c2 = i.a().c(cVar.c());
                    if (TextUtils.isEmpty(c2)) {
                        z4 = false;
                        z3 = false;
                    } else if (com.anythink.expressad.advanced.a.a.b(cVar.Z())) {
                        aTNativeAdvancedView.setH5Ready(true);
                        z4 = false;
                        z3 = true;
                    } else {
                        a(aTNativeAdvancedView, c2, cVar, str, str2, i, aVar);
                        z4 = true;
                    }
                }
                if (TextUtils.isEmpty(cVar.c()) || TextUtils.isEmpty(cVar.d()) || aTNativeAdvancedView.isH5Ready()) {
                    z = z4;
                    z2 = z3;
                } else {
                    String a3 = a(cVar.d());
                    z = z4;
                    z2 = false;
                    if (!TextUtils.isEmpty(a3)) {
                        if (com.anythink.expressad.advanced.a.a.b(cVar.Z())) {
                            aTNativeAdvancedView.setH5Ready(true);
                            if (cVar.H()) {
                                aTNativeAdvancedView.setVideoReady(true);
                            }
                            z2 = true;
                            z = z4;
                        } else {
                            a(aTNativeAdvancedView, a3, cVar, str, str2, i, aVar);
                            z = true;
                            z2 = z3;
                        }
                    }
                }
            }
            aTNativeAdvancedView.setVideoReady(true);
            if (!TextUtils.isEmpty(cVar.I())) {
                aTNativeAdvancedView.setEndCardReady(true);
            }
            if (TextUtils.isEmpty(cVar.c())) {
            }
            z4 = false;
            if (TextUtils.isEmpty(cVar.c())) {
            }
            z = z4;
            z2 = z3;
        } else {
            z = false;
            z2 = false;
        }
        if (z2 && !z) {
            aVar.a();
        }
        return z2;
    }
}
