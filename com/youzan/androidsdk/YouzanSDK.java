package com.youzan.androidsdk;

import android.content.Context;
import android.util.Log;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.youzan.androidsdk.tool.AnalyticsUtil;
import com.youzan.androidsdk.tool.Preference;
import com.youzan.androidsdk.tool.UserAgent;
import java.util.TreeMap;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/YouzanSDK.class */
public class YouzanSDK {
    public static final String Pref_KEY_CHECK_UPDATE_TIME = "pref_key_check_update_time";

    /* renamed from: ˊ  reason: contains not printable characters */
    private static volatile YouzanSDKAdapter f1049;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean f1050 = false;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean f1051 = false;

    public static YouzanSDKAdapter getSDKAdapter() {
        YouzanSDKAdapter youzanSDKAdapter;
        synchronized (YouzanSDK.class) {
            try {
                m9181();
                youzanSDKAdapter = f1049;
            } catch (Throwable th) {
                throw th;
            }
        }
        return youzanSDKAdapter;
    }

    public static void init(Context context, String str, String str2, YouzanSDKAdapter youzanSDKAdapter) {
        synchronized (YouzanSDK.class) {
            try {
                String verifyClientId = SDKUtil.verifyClientId(str);
                f1049 = youzanSDKAdapter;
                m9181();
                f1049.isDebug(f1050);
                Log.e("YZSDK", "----->isDebug = " + f1050);
                f1049.init(context, verifyClientId, str2, f1051, f1050);
                if (isOneDay()) {
                    AnalyticsUtil.initAnalytics(context, verifyClientId);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void isDebug(boolean z) {
        f1050 = z;
        if (f1049 != null) {
            f1049.isDebug(z);
        }
    }

    public static boolean isOneDay() {
        Preference instance = Preference.instance();
        if (System.currentTimeMillis() - instance.getLong(Pref_KEY_CHECK_UPDATE_TIME, 0L) >= 86400000) {
            instance.setLong(Pref_KEY_CHECK_UPDATE_TIME, System.currentTimeMillis());
            return true;
        }
        return false;
    }

    public static void isPre(boolean z) {
        f1051 = z;
    }

    public static boolean isReady() {
        if (f1049 == null) {
            return false;
        }
        return f1049.isReady();
    }

    public static void loadConversation(WebViewCompat webViewCompat, String str) {
        f1049.loadConversation(webViewCompat, str);
    }

    public static void sync(Context context, YouzanToken youzanToken) {
        synchronized (YouzanSDK.class) {
            try {
                m9181();
                f1049.sync(context, youzanToken);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void userLogout(Context context) {
        synchronized (YouzanSDK.class) {
            try {
                m9181();
                f1049.userLogout(context);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void yzlogin(String str, String str2, String str3, String str4, String str5, YzLoginCallback yzLoginCallback) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("avatar", str2);
        treeMap.put("clientId", UserAgent.appClintId);
        treeMap.put("extra", str3);
        treeMap.put("nickName", str4);
        treeMap.put("openId", str);
        treeMap.put(ArticleInfo.USER_SEX, str5);
        m9181();
        f1049.yzLogin(f1051, treeMap, yzLoginCallback);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m9181() {
        if (f1049 == null) {
            throw new IllegalStateException("You Should Init with A Valid SDK Adapter,YouzanBasicSDKAdapter for basic sdk, and YouzanHybridSDKAdapter for native sdk");
        }
    }
}
