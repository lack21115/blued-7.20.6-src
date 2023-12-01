package com.youzan.androidsdk.tool;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.sina.weibo.sdk.constant.WBConstants;
import com.youzan.androidsdk.WebViewCompat;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/WebParameter.class */
public final class WebParameter {
    public static final String PATH_DATABASE = "database";

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String[] f1100 = {"tenpay.com", "alipay.com", "qq.com"};

    public static void blockDangerJsInterface(WebViewCompat webViewCompat) {
        webViewCompat.removeJavascriptInterface("searchBoxJavaBridge_");
        webViewCompat.removeJavascriptInterface(Context.ACCESSIBILITY_SERVICE);
        webViewCompat.removeJavascriptInterface("accessibilityTraversal");
    }

    public static String getKdtUnionUrl(Uri uri) {
        if (uri.isOpaque()) {
            return null;
        }
        return uri.getQueryParameter(WBConstants.AUTH_PARAMS_REDIRECT_URL);
    }

    public static String getPreviousUrl(WebViewCompat webViewCompat) {
        return webViewCompat.getPreviousUrl();
    }

    public static void initWebViewParameter(WebViewCompat webViewCompat) {
        webViewCompat.initWebViewParameter();
    }

    public static boolean isBlockHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = f1100;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return false;
            }
            if (str.contains(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean isYouzanHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("youzan.com") || str.contains("koudaitong.com") || str.contains("kdt.im");
    }

    public static boolean isYouzanPage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return isYouzanHost(Uri.parse(str).getHost());
    }

    public static boolean shouldSkipUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        return !TextUtils.isEmpty(getKdtUnionUrl(parse)) || TextUtils.isEmpty(host) || isBlockHost(host);
    }

    public static boolean validPreviousUrl(WebViewCompat webViewCompat) {
        return webViewCompat.validPreviousUrl();
    }

    public static void webViewUAConfiguration(WebViewCompat webViewCompat, String str, String str2) {
        webViewCompat.webViewUAConfiguration(webViewCompat, str, str2);
    }
}
