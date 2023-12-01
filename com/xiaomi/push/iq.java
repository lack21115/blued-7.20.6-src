package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.iy;
import com.xiaomi.push.ji;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/iq.class */
public class iq {
    public static short a(Context context, ic icVar) {
        return a(context, icVar.f713b);
    }

    public static short a(Context context, String str) {
        int i = 0;
        int a2 = g.a(context, str, false).a();
        int i2 = ah.b(context) ? 4 : 0;
        int i3 = ah.a(context) ? 8 : 0;
        if (com.xiaomi.push.service.ax.m12133a(context)) {
            i = 16;
        }
        return (short) (a2 + 0 + i2 + i3 + i);
    }

    public static <T extends ir<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new iw("the message byte is empty.");
        }
        new iv(new ji.a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends ir<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new ix(new iy.a()).a(t);
        } catch (iw e) {
            com.xiaomi.channel.commonutils.logger.b.a("convertThriftObjectToBytes catch TException.", e);
            return null;
        }
    }
}
