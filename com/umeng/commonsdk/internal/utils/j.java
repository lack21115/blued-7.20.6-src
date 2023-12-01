package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.at;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/internal/utils/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40882a = at.b().b(at.r);
    private static final String b = "um_common_strength";

    /* renamed from: c  reason: collision with root package name */
    private static final String f40883c = "um_common_battery";

    public static String a(Context context) {
        String str = null;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f40882a, 0);
            str = null;
            if (sharedPreferences != null) {
                str = sharedPreferences.getString(f40883c, null);
            }
        }
        return str;
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f40882a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f40883c, str).commit();
    }
}
