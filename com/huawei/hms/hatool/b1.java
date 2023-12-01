package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/b1.class */
public abstract class b1 {
    public final y0 a(int i) {
        String str;
        if (i != 0) {
            String f = f();
            str = f;
            if (!TextUtils.isEmpty(f)) {
                return new y0(z0.UDID, f);
            }
        } else {
            str = "";
        }
        return new y0(z0.EMPTY, str);
    }

    public y0 a(Context context) {
        String c2 = c();
        if (TextUtils.isEmpty(c2)) {
            String a2 = a();
            if (TextUtils.isEmpty(a2)) {
                boolean e = e();
                String b = b();
                return !TextUtils.isEmpty(b) ? e ? new y0(z0.SN, b) : new y0(z0.UDID, a(b)) : e ? a(d()) : b(d());
            }
            return new y0(z0.IMEI, a2);
        }
        return new y0(z0.UDID, c2);
    }

    public abstract String a();

    public abstract String a(String str);

    public final y0 b(int i) {
        String str;
        if ((i & 4) != 0) {
            String f = f();
            str = f;
            if (!TextUtils.isEmpty(f)) {
                return new y0(z0.UDID, f);
            }
        } else {
            str = "";
        }
        return new y0(z0.EMPTY, str);
    }

    public abstract String b();

    public abstract String c();

    public abstract int d();

    public final boolean e() {
        l b = i.c().b();
        if (TextUtils.isEmpty(b.l())) {
            b.h(f.a());
        }
        return !TextUtils.isEmpty(b.l());
    }

    public final String f() {
        l b = i.c().b();
        if (TextUtils.isEmpty(b.i())) {
            b.e(c1.c());
        }
        return b.i();
    }
}
