package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.hg;
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

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/ce.class */
public class ce {
    public static ir a(Context context, ic icVar) {
        if (icVar.m8903b()) {
            return null;
        }
        byte[] m8901a = icVar.m8901a();
        ir a2 = a(icVar.a(), icVar.f667b);
        if (a2 != null) {
            iq.a(a2, m8901a);
        }
        return a2;
    }

    private static ir a(hg hgVar, boolean z) {
        switch (cf.f27972a[hgVar.ordinal()]) {
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
}
