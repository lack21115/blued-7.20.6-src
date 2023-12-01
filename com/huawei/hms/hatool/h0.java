package com.huawei.hms.hatool;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/h0.class */
public class h0 {
    public static long a(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            z.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return j;
        }
        SharedPreferences b = b(context, str);
        long j2 = j;
        if (b != null) {
            j2 = b.getLong(str2, j);
        }
        return j2;
    }

    public static String a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            z.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences b = b(context, str);
        String str4 = str3;
        if (b != null) {
            str4 = b.getString(str2, str3);
        }
        return str4;
    }

    public static Map<String, ?> a(Context context, String str) {
        return b(context, str).getAll();
    }

    public static void a(Context context, String str, String... strArr) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "clearData(): parameter error.context,spname";
        } else if (strArr == null) {
            str2 = "clearData(): No data need to be deleted,keys is null";
        } else {
            SharedPreferences b = b(context, str);
            if (b == null) {
                return;
            }
            SharedPreferences.Editor edit = b.edit();
            if (strArr.length == 0) {
                edit.clear();
                edit.commit();
                return;
            }
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return;
                }
                String str3 = strArr[i2];
                if (b.contains(str3)) {
                    edit.remove(str3);
                    edit.commit();
                }
                i = i2 + 1;
            }
        }
        z.f("hmsSdk", str2);
    }

    public static SharedPreferences b(Context context, String str) {
        return context.getSharedPreferences(c(context, str), 0);
    }

    public static void b(Context context, String str, String str2, long j) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            z.f("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences b = b(context, str);
        if (b != null) {
            SharedPreferences.Editor edit = b.edit();
            edit.putLong(str2, j);
            edit.commit();
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            z.e("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences b = b(context, str);
        if (b != null) {
            SharedPreferences.Editor edit = b.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public static String c(Context context, String str) {
        String packageName = context.getPackageName();
        String n = c.n("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(n)) {
            return "hms_" + str + BridgeUtil.UNDERLINE_STR + packageName;
        }
        return "hms_" + str + BridgeUtil.UNDERLINE_STR + packageName + BridgeUtil.UNDERLINE_STR + n;
    }
}
