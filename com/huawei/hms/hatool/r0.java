package com.huawei.hms.hatool;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/r0.class */
public class r0 {
    public static boolean a(Context context) {
        return System.currentTimeMillis() - h0.a(context, "Privacy_MY", "flashKeyTime", -1L) > 43200000;
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
                z.f("hmsSdk", "not have read phone permission!");
                return true;
            }
            return false;
        } else if (context.checkSelfPermission(str) != 0) {
            z.f("hmsSdk", "not have read phone permission!");
            return true;
        } else {
            return false;
        }
    }

    public static boolean a(Context context, String str, int i) {
        File filesDir = context.getFilesDir();
        long length = new File(filesDir, "../shared_prefs/" + (h0.c(context, str) + ".xml")).length();
        if (length > i) {
            z.c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i)));
            return true;
        }
        return false;
    }

    public static boolean a(String str, long j, long j2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j - Long.parseLong(str) > j2;
        } catch (NumberFormatException e) {
            z.f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
