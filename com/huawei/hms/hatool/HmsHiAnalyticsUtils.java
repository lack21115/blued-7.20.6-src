package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/HmsHiAnalyticsUtils.class */
public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        o1.a();
    }

    public static boolean getInitFlag() {
        return m1.b();
    }

    public static void init(Context context, boolean z, boolean z2, boolean z3, String str, String str2) {
        new n1(context).a(z).c(z2).b(z3).a(0, str).a(1, str).a(str2).a();
    }

    public static void onEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        m1.a(i, str, linkedHashMap);
    }

    public static void onEvent(Context context, String str, String str2) {
        m1.a(context, str, str2);
    }

    public static void onReport() {
        m1.c();
    }

    public static void onStreamEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        m1.b(i, str, linkedHashMap);
    }
}
