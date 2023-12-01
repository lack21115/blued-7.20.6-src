package cn.com.chinatelecom.account.api.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/e/c.class */
public final class c {
    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences(b(context), 0);
    }

    public static void a(Context context, String str, int i) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(context).edit().putInt(str, i).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(context).edit().putString(str, str2).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(Context context, String str, long j) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return a(context).edit().putLong(str, j).commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int b(Context context, String str, int i) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return a(context).getInt(str, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public static long b(Context context, String str, long j) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return a(context).getLong(str, j);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    private static String b(Context context) {
        return "ct_account_api_sdk";
    }

    public static String b(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                return a(context).getString(str, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str2;
    }
}
