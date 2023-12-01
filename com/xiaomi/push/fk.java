package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.fn;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/fk.class */
public class fk {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f41409a = Log.isLoggable("BCompressed", 3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(fj fjVar, byte[] bArr) {
        try {
            byte[] a2 = fn.a.a(bArr);
            if (f41409a) {
                com.xiaomi.channel.commonutils.logger.b.m11395a("BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + fjVar);
                if (fjVar.f448a == 1) {
                    com.xiaomi.channel.commonutils.logger.b.m11395a("BCompressed", "decompress not support upStream");
                }
            }
            return a2;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11395a("BCompressed", "decompress error ".concat(String.valueOf(e)));
            return bArr;
        }
    }
}
