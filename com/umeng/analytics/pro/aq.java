package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/aq.class */
public class aq {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40628a = "cl_count";
    public static final String b = "interval_";

    /* renamed from: c  reason: collision with root package name */
    public static final String f40629c = "config_ts";
    public static final String d = "iucc_s1";
    public static final String e = "iucc_s2";
    public static final String f = "sdk_type_ver";
    public static final String g = "should_fetch";
    private static final String h = "ccg_sp_config_file";

    private aq() {
    }

    public static SharedPreferences a(Context context) {
        if (context != null) {
            try {
                return context.getSharedPreferences(h, 0);
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }
}
