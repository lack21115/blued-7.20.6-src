package com.cmic.gen.sdk.tencent.a;

import android.text.TextUtils;
import com.cmic.gen.sdk.tencent.e.k;
import com.igexin.assist.sdk.AssistPushConsts;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/a/d.class */
class d {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i) {
        return k.a("sso_config_xf", "maxFailedLogTimes", i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        String a2 = k.a("sso_config_xf", "config_host", (String) null);
        return TextUtils.isEmpty(a2) ? str : a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return System.currentTimeMillis() >= k.a("sso_config_xf", "client_valid", 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(boolean z) {
        return "1".equals(k.a("sso_config_xf", "CLOSE_IPV4_LIST", !z ? "0" : "1"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i) {
        return k.a("sso_config_xf", "pauseTime", i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        String a2 = k.a("sso_config_xf", "https_get_phone_scrip_host", (String) null);
        return TextUtils.isEmpty(a2) ? str : a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(boolean z) {
        return "1".equals(k.a("sso_config_xf", "CLOSE_IPV6_LIST", !z ? "0" : "1"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        String a2 = k.a("sso_config_xf", "logHost", "");
        return TextUtils.isEmpty(a2) ? str : a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(boolean z) {
        String str = !z ? "0" : "1";
        return "1".equals(k.a("sso_config_xf", "CLOSE_M008_APPID_LIST", str)) || "1".equals(k.a("sso_config_xf", "CLOSE_M008_SDKVERSION_LIST", str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(boolean z) {
        return k.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", z ? "CU" : "").contains("CU");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(boolean z) {
        return k.a("sso_config_xf", "CLOSE_FRIEND_WAPKS", z ? AssistPushConsts.MSG_KEY_CONTENT : "").contains(AssistPushConsts.MSG_KEY_CONTENT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(boolean z) {
        return "1".equals(k.a("sso_config_xf", "CLOSE_LOGS_VERSION", z ? "1" : "0"));
    }
}
