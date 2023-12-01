package com.sdk.tencent.base.module.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import com.sdk.tencent.base.api.CallBack;
import com.sdk.tencent.base.framework.utils.app.AppUtils;
import com.sdk.tencent.f.c;
import com.sdk.tencent.t.a;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/module/manager/SDKManager.class */
public abstract class SDKManager {
    private static boolean closePermission = false;
    private static boolean isStrong = true;
    public static Context mContext;
    private static boolean smartTrust = true;
    private static String statisticalTestHost = "";
    private static String testHost = "";
    private static boolean useCache = true;
    private static String userAgent;

    public static void closePermission(boolean z) {
        closePermission = z;
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getStatisticalTestHost() {
        return statisticalTestHost;
    }

    public static String getTestHost() {
        return testHost;
    }

    public static String getUserAgent() {
        return userAgent;
    }

    public static void init(Context context, String str) {
        mContext = context;
        a a2 = a.a(context);
        AppUtils.isFirstLogin(context);
        a2.getClass();
        a.b = str;
        a.f14391c = null;
    }

    public static void init(Context context, String str, String str2) {
        mContext = context;
        a a2 = a.a(context);
        AppUtils.isFirstLogin(context);
        a2.getClass();
        a.b = str2;
        a.f14391c = str;
    }

    public static boolean isClosePermission() {
        return closePermission;
    }

    public static boolean isIsStrong() {
        return isStrong;
    }

    public static boolean isSmartTrust() {
        return smartTrust;
    }

    public static void releaseConnect(Context context) {
        ConnectivityManager.NetworkCallback networkCallback;
        String str = com.sdk.tencent.s.a.f14389a;
        com.sdk.tencent.a.a aVar = new com.sdk.tencent.a.a();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        aVar.b = connectivityManager;
        if (connectivityManager == null || (networkCallback = com.sdk.tencent.a.a.g) == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(networkCallback);
        com.sdk.tencent.a.a.f = true;
        com.sdk.tencent.a.a.g = null;
    }

    public static void setDebug(boolean z) {
        c.b = z;
    }

    public static void setDebugHead(boolean z) {
        c.d = z;
    }

    public static void setIsStrong(boolean z) {
        isStrong = z;
    }

    public static void setSmartTrust(boolean z) {
        smartTrust = z;
    }

    public static void setStatisticalTestHost(String str) {
        statisticalTestHost = str;
    }

    public static void setTestHost(String str) {
        testHost = str;
    }

    public static void setUseCache(boolean z) {
        useCache = z;
    }

    public static void setUserAgent(String str) {
        userAgent = str;
    }

    public static <T> void toFailed(CallBack<T> callBack, int i, String str) {
        if (callBack != null) {
            callBack.onFailed(1, i, str, null);
        }
    }

    public static boolean useCache() {
        return useCache;
    }
}
