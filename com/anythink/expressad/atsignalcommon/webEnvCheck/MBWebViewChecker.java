package com.anythink.expressad.atsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/webEnvCheck/MBWebViewChecker.class */
public final class MBWebViewChecker {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f7093a;
    private static volatile Handler b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f7094c;

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
        } catch (Exception e) {
            webView = null;
        }
        return webView != null;
    }

    public static boolean isWebViewAvailable(final Context context) {
        Boolean bool = Boolean.FALSE;
        f7094c = bool;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f7093a == null) {
                try {
                    f7093a = Boolean.valueOf(b(context));
                } catch (Exception e) {
                    f7093a = Boolean.FALSE;
                }
            }
            if (f7093a == null) {
                f7093a = Boolean.FALSE;
            }
            return f7093a.booleanValue();
        }
        if (f7093a == null && b == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            b = handler;
            handler.post(new Runnable() { // from class: com.anythink.expressad.atsignalcommon.webEnvCheck.MBWebViewChecker.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MBWebViewChecker.f7093a == null) {
                        try {
                            Boolean unused = MBWebViewChecker.f7093a = Boolean.valueOf(MBWebViewChecker.b(Context.this));
                        } catch (Exception e2) {
                            Boolean unused2 = MBWebViewChecker.f7093a = Boolean.FALSE;
                        }
                    }
                }
            });
        }
        if (f7093a == null) {
            return true;
        }
        return f7093a.booleanValue();
    }
}
