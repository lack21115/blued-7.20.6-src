package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.j;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/AnalyticsConfig.class */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_START_TIME = "startTime";

    /* renamed from: a  reason: collision with root package name */
    static double[] f40591a;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static String f40592c;
    private static String d;
    private static int e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static final String RTD_SP_FILE = at.b().b(at.A);
    private static Object f = new Object();
    private static boolean g = false;
    private static String h = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, int i) {
        e = i;
        com.umeng.common.b.a(context).a(e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.A, 0, "\\|");
            return;
        }
        d = str;
        com.umeng.common.b.a(context).a(d);
    }

    static void a(String str) {
        f40592c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        String str = null;
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            if (cls != null) {
                str = (String) cls.getDeclaredField("SDK_VERSION").get(cls);
            }
            return str;
        } catch (Throwable th) {
            return null;
        }
    }

    public static double[] getLocation() {
        return f40591a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f) {
            str = h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(d)) {
            d = com.umeng.common.b.a(context).c();
        }
        return d;
    }

    public static int getVerticalType(Context context) {
        if (e == 0) {
            e = com.umeng.common.b.a(context).d();
        }
        return e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z;
        synchronized (f) {
            z = g;
        }
        return z;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f) {
            g = false;
            h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f) {
            g = true;
            if (map != null && map.containsKey("debugkey")) {
                h = map.get("debugkey");
            }
        }
    }
}
