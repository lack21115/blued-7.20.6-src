package com.anythink.expressad.atsignalcommon.windvane;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.anythink.expressad.foundation.h.s;
import com.anythink.expressad.foundation.h.t;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/windvane/p.class */
public final class p extends com.anythink.expressad.atsignalcommon.base.b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7116a = "WindVaneWebViewClient";

    /* renamed from: c  reason: collision with root package name */
    public static final int f7117c = 0;
    public static final int d = 1;
    public static final String e = "mmusdk_cache";
    public static final String f = "1";
    public static boolean g = true;
    protected String b;
    private int h;
    private e i;

    public p() {
        this.b = null;
        this.h = 0;
    }

    private p(int i) {
        this.b = null;
        this.h = 0;
        this.h = i;
    }

    private static WebResourceResponse a(String str) {
        Bitmap bitmap;
        try {
            if (TextUtils.isEmpty(str) || !n.d(str)) {
                return null;
            }
            com.anythink.expressad.foundation.g.d.b a2 = com.anythink.expressad.foundation.g.d.b.a(com.anythink.expressad.foundation.b.a.b().d());
            if (!t.a(str)) {
                String a3 = s.a(str);
                File file = new File(a3);
                if (a2.a(str) != null) {
                    bitmap = a2.a(str);
                } else if (file.exists()) {
                    bitmap = com.anythink.expressad.foundation.g.d.a.a(a3);
                    if (bitmap != null) {
                        a2.a(str, bitmap);
                    }
                }
                if (bitmap == null && !bitmap.isRecycled()) {
                    return new WebResourceResponse(n.e(str), "utf-8", com.anythink.expressad.foundation.g.d.a.a(bitmap));
                }
            }
            bitmap = null;
            return bitmap == null ? null : null;
        } catch (Throwable th) {
            return null;
        }
    }

    private static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine + "\n");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return sb.toString();
    }

    private void b(e eVar) {
        this.i = eVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.b = str;
        e eVar = this.i;
        if (eVar != null) {
            eVar.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse a2 = a(str);
        return a2 != null ? a2 : super.shouldInterceptRequest(webView, str);
    }
}
