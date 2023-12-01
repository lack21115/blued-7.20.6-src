package com.huawei.secure.android.common.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/webview/UriUtil.class */
public class UriUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23171a = "UriUtil";

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return !URLUtil.isNetworkUrl(str) ? str : getHostByURI(str);
        }
        LogsUtil.i(f23171a, "whiteListUrl is null");
        return null;
    }

    public static String getHostByURI(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.i(f23171a, "url is null");
            return str;
        }
        try {
            if (URLUtil.isNetworkUrl(str)) {
                return new URL(str.replaceAll("[\\\\#]", BridgeUtil.SPLIT_MARK)).getHost();
            }
            LogsUtil.e(f23171a, "url don't starts with http or https");
            return "";
        } catch (MalformedURLException e) {
            LogsUtil.e(f23171a, "getHostByURI error  MalformedURLException : " + e.getMessage());
            return "";
        }
    }

    public static boolean isUrlHostAndPathInWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e(f23171a, "whitelist is null");
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (isUrlHostAndPathMatchWhitelist(str, strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean isUrlHostAndPathMatchWhitelist(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.contains("..") || str.contains("@")) {
            Log.e(f23171a, "url contains unsafe char");
            return false;
        } else if (str2.equals(str)) {
            return true;
        } else {
            if (str.startsWith(str2 + "?")) {
                return true;
            }
            if (str.startsWith(str2 + "#")) {
                return true;
            }
            if (str2.endsWith(BridgeUtil.SPLIT_MARK)) {
                if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                    return false;
                }
                return str.startsWith(str2);
            }
            return false;
        }
    }

    public static boolean isUrlHostInWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e(f23171a, "whitelist is null");
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (isUrlHostMatchWhitelist(str, strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static boolean isUrlHostMatchWhitelist(String str, String str2) {
        String hostByURI = getHostByURI(str);
        if (TextUtils.isEmpty(hostByURI) || TextUtils.isEmpty(str2)) {
            LogsUtil.e(f23171a, "url or whitelist is null");
            return false;
        }
        String a2 = a(str2);
        if (TextUtils.isEmpty(a2)) {
            Log.e(f23171a, "whitelist host is null");
            return false;
        } else if (a2.equals(hostByURI)) {
            return true;
        } else {
            if (hostByURI.endsWith(a2)) {
                try {
                    String substring = hostByURI.substring(0, hostByURI.length() - a2.length());
                    if (substring.endsWith(".")) {
                        return substring.matches("^[A-Za-z0-9.-]+$");
                    }
                    return false;
                } catch (IndexOutOfBoundsException e) {
                    LogsUtil.e(f23171a, "IndexOutOfBoundsException" + e.getMessage());
                    return false;
                } catch (Exception e2) {
                    LogsUtil.e(f23171a, "Exception : " + e2.getMessage());
                    return false;
                }
            }
            return false;
        }
    }

    public static boolean isUrlHostSameWhitelist(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(f23171a, "isUrlHostSameWhitelist: url or host is null");
            return false;
        }
        return TextUtils.equals(getHostByURI(str), a(str2));
    }

    public static boolean isUrlHostSameWhitelist(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            LogsUtil.e(f23171a, "whitelist is null");
            return false;
        }
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (isUrlHostSameWhitelist(str, strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }
}
