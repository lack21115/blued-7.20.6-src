package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bk;
import com.xiaomi.push.hg;
import com.xiaomi.push.hv;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.ij;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import java.nio.ByteBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ai.class */
public class ai {
    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends ir<T, ?>> ic a(Context context, T t, hg hgVar) {
        return a(context, t, hgVar, !hgVar.equals(hg.Registration), context.getPackageName(), b.m8407a(context).m8408a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends ir<T, ?>> ic a(Context context, T t, hg hgVar, boolean z, String str, String str2) {
        return a(context, t, hgVar, z, str, str2, true);
    }

    protected static <T extends ir<T, ?>> ic a(Context context, T t, hg hgVar, boolean z, String str, String str2, boolean z2) {
        String str3;
        byte[] a2 = iq.a(t);
        if (a2 != null) {
            ic icVar = new ic();
            byte[] bArr = a2;
            if (z) {
                String d = b.m8407a(context).d();
                if (TextUtils.isEmpty(d)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        bArr = com.xiaomi.push.h.b(bk.m8496a(d), a2);
                    } catch (Exception e) {
                        com.xiaomi.channel.commonutils.logger.b.d("encryption error. ");
                        bArr = a2;
                    }
                }
            }
            hv hvVar = new hv();
            hvVar.f584a = 5L;
            hvVar.f585a = "fakeid";
            icVar.a(hvVar);
            icVar.a(ByteBuffer.wrap(bArr));
            icVar.a(hgVar);
            icVar.b(z2);
            icVar.b(str);
            icVar.a(z);
            icVar.a(str2);
            return icVar;
        }
        str3 = "invoke convertThriftObjectToBytes method, return null.";
        com.xiaomi.channel.commonutils.logger.b.m8344a(str3);
        return null;
    }

    public static ir a(Context context, ic icVar) {
        byte[] m8901a;
        if (icVar.m8903b()) {
            byte[] a2 = i.a(context, icVar, e.ASSEMBLE_PUSH_FCM);
            byte[] bArr = a2;
            if (a2 == null) {
                bArr = bk.m8496a(b.m8407a(context).d());
            }
            try {
                m8901a = com.xiaomi.push.h.a(bArr, icVar.m8901a());
            } catch (Exception e) {
                throw new u("the aes decrypt failed.", e);
            }
        } else {
            m8901a = icVar.m8901a();
        }
        ir a3 = a(icVar.a(), icVar.f667b);
        if (a3 != null) {
            iq.a(a3, m8901a);
        }
        return a3;
    }

    private static ir a(hg hgVar, boolean z) {
        switch (aj.f27512a[hgVar.ordinal()]) {
            case 1:
                return new ih();
            case 2:
                return new in();
            case 3:
                return new il();
            case 4:
                return new ip();
            case 5:
                return new ij();
            case 6:
                return new hw();
            case 7:
                return new ib();
            case 8:
                return new ii();
            case 9:
                if (z) {
                    return new Cif();
                }
                hx hxVar = new hx();
                hxVar.a(true);
                return hxVar;
            case 10:
                return new ib();
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends ir<T, ?>> ic b(Context context, T t, hg hgVar, boolean z, String str, String str2) {
        return a(context, t, hgVar, z, str, str2, false);
    }
}
