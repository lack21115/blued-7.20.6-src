package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f40604a = new String[2];

    public static void a(Context context, String str, String str2) {
        String[] strArr = f40604a;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static String[] a(Context context) {
        String[] a2;
        if (TextUtils.isEmpty(f40604a[0]) || TextUtils.isEmpty(f40604a[1])) {
            if (context == null || (a2 = com.umeng.common.b.a(context).a()) == null) {
                return null;
            }
            String[] strArr = f40604a;
            strArr[0] = a2[0];
            strArr[1] = a2[1];
            return strArr;
        }
        return f40604a;
    }

    public static void b(Context context) {
        String[] strArr = f40604a;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }
}
