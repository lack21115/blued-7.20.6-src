package com.xiaomi.push;

import android.content.Context;
import android.os.Build;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dn.class */
public class dn {
    private static void a(byte[] bArr) {
        if (bArr.length >= 2) {
            bArr[0] = 99;
            bArr[1] = 100;
        }
    }

    public static boolean a(Context context, String str, long j) {
        if (com.xiaomi.push.service.ba.a(context).a(hl.DCJobMutualSwitch.a(), false)) {
            return (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && !ag.a(context, str, j);
        }
        return false;
    }

    public static byte[] a(String str, byte[] bArr) {
        byte[] m8496a = bk.m8496a(str);
        try {
            a(m8496a);
            return h.a(m8496a, bArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static byte[] b(String str, byte[] bArr) {
        byte[] m8496a = bk.m8496a(str);
        try {
            a(m8496a);
            return h.b(m8496a, bArr);
        } catch (Exception e) {
            return null;
        }
    }
}
