package com.anythink.expressad.atsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/webEnvCheck/MBWebViewChecker.class */
public final class MBWebViewChecker {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f4255a;
    private static volatile Handler b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f4256c;

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
        f4256c = bool;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f4255a == null) {
                try {
                    f4255a = Boolean.valueOf(b(context));
                } catch (Exception e) {
                    f4255a = Boolean.FALSE;
                }
            }
            if (f4255a == null) {
                f4255a = Boolean.FALSE;
            }
            return f4255a.booleanValue();
        }
        if (f4255a == null && b == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            b = handler;
            handler.post(new Runnable() { // from class: com.anythink.expressad.atsignalcommon.webEnvCheck.MBWebViewChecker.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MBWebViewChecker.f4255a == null) {
                        try {
                            Boolean unused = MBWebViewChecker.f4255a = Boolean.valueOf(MBWebViewChecker.b(Context.this));
                        } catch (Exception e2) {
                            Boolean unused2 = MBWebViewChecker.f4255a = Boolean.FALSE;
                        }
                    }
                }
            });
        }
        if (f4255a == null) {
            return true;
        }
        return f4255a.booleanValue();
    }
}
