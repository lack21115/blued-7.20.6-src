package com.tencent.smtt.sdk;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/URLUtil.class */
public final class URLUtil {
    public static String composeSearchUrl(String str, String str2, String str3) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.composeSearchUrl(str, str2, str3) : a2.c().a(str, str2, str3);
    }

    public static byte[] decode(byte[] bArr) throws IllegalArgumentException {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.decode(bArr) : a2.c().a(bArr);
    }

    public static final String guessFileName(String str, String str2, String str3) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.guessFileName(str, str2, str3) : a2.c().b(str, str2, str3);
    }

    public static String guessUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.guessUrl(str) : a2.c().m(str);
    }

    public static boolean isAboutUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isAboutUrl(str) : a2.c().q(str);
    }

    public static boolean isAssetUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isAssetUrl(str) : a2.c().n(str);
    }

    public static boolean isContentUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isContentUrl(str) : a2.c().w(str);
    }

    @Deprecated
    public static boolean isCookielessProxyUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isCookielessProxyUrl(str) : a2.c().o(str);
    }

    public static boolean isDataUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isDataUrl(str) : a2.c().r(str);
    }

    public static boolean isFileUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isFileUrl(str) : a2.c().p(str);
    }

    public static boolean isHttpUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isHttpUrl(str) : a2.c().t(str);
    }

    public static boolean isHttpsUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isHttpsUrl(str) : a2.c().u(str);
    }

    public static boolean isJavaScriptUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isJavaScriptUrl(str) : a2.c().s(str);
    }

    public static boolean isNetworkUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isNetworkUrl(str) : a2.c().v(str);
    }

    public static boolean isValidUrl(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.isValidUrl(str) : a2.c().x(str);
    }

    public static String stripAnchor(String str) {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.URLUtil.stripAnchor(str) : a2.c().y(str);
    }
}
