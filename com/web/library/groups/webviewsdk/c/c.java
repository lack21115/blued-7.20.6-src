package com.web.library.groups.webviewsdk.c;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.content.PermissionChecker;

/* loaded from: source-8829756-dex2jar.jar:com/web/library/groups/webviewsdk/c/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleArrayMap<String, Integer> f41153a;

    static {
        SimpleArrayMap<String, Integer> simpleArrayMap = new SimpleArrayMap<>(8);
        f41153a = simpleArrayMap;
        simpleArrayMap.put(Manifest.permission.ADD_VOICEMAIL, 14);
        f41153a.put(Manifest.permission.BODY_SENSORS, 20);
        f41153a.put(Manifest.permission.READ_CALL_LOG, 16);
        f41153a.put("android.permission.READ_EXTERNAL_STORAGE", 16);
        f41153a.put(Manifest.permission.USE_SIP, 9);
        f41153a.put(Manifest.permission.WRITE_CALL_LOG, 16);
        f41153a.put(Manifest.permission.SYSTEM_ALERT_WINDOW, 23);
        f41153a.put(Manifest.permission.WRITE_SETTINGS, 23);
    }

    private static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 23 || !"Xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
            boolean z = false;
            try {
                if (PermissionChecker.checkSelfPermission(context, str) == 0) {
                    z = true;
                }
                return z;
            } catch (RuntimeException e) {
                return false;
            }
        }
        return b(context, str);
    }

    public static boolean a(Context context, String... strArr) {
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            String str = strArr[i2];
            if (a(str) && !a(context, str)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static boolean a(String str) {
        Integer num = f41153a.get(str);
        return num == null || Build.VERSION.SDK_INT >= num.intValue();
    }

    private static boolean b(Context context, String str) {
        String permissionToOp = AppOpsManagerCompat.permissionToOp(str);
        if (permissionToOp == null) {
            return true;
        }
        return AppOpsManagerCompat.noteOp(context, permissionToOp, Process.myUid(), context.getPackageName()) == 0 && PermissionChecker.checkSelfPermission(context, str) == 0;
    }
}
