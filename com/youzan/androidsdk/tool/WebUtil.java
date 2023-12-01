package com.youzan.androidsdk.tool;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.youzan.androidsdk.HtmlStorage;
import com.youzan.androidsdk.WebViewCompat;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/WebUtil.class */
public final class WebUtil {
    public static String checkIfAddScheme(String str) {
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getScheme())) {
            String str2 = isYouzanHost(parse.getHost()) ? "https" : "http";
            Uri.Builder buildUpon = parse.buildUpon();
            buildUpon.scheme(str2);
            str = buildUpon.toString();
        }
        return str;
    }

    public static void clearCookie(Context context) {
        HtmlStorage.Manager.clearCookie(context);
    }

    public static void clearLocalStorage() {
        HtmlStorage.Manager.clearLocalStorage();
    }

    public static void copyText(Context context, String str) {
        Environment.copyText(context, str);
    }

    public static boolean dealWAPWxPay(Activity activity, String str) {
        return !TextUtils.isEmpty(str) && SchemeIntent.handleSilently(activity, Uri.parse(str));
    }

    public static int generateRequestId() {
        return Environment.generateRequestId();
    }

    public static void initWebViewParameter(WebViewCompat webViewCompat) {
        WebParameter.initWebViewParameter(webViewCompat);
    }

    public static boolean isNetworkConnect(Context context) {
        return Environment.isNetworkConnect(context);
    }

    public static boolean isTokenInactive(int i) {
        return i == 40009 || i == 40010 || i == 42000;
    }

    public static boolean isYouzanHost(String str) {
        return WebParameter.isYouzanHost(str);
    }

    public static boolean isYouzanPage(String str) {
        return WebParameter.isYouzanPage(str);
    }

    public static void setCookie(Context context, String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        if (context != null) {
            try {
                CookieSyncManager.createInstance(context);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        for (String str2 : list) {
            cookieManager.setCookie(str, str2);
        }
    }
}
