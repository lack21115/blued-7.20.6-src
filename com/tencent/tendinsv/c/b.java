package com.tencent.tendinsv.c;

import android.content.Context;
import android.os.SystemClock;
import com.sdk.tencent.base.api.ToolUtils;
import com.tencent.tendinsv.listener.GetPhoneInfoCallbacks;
import com.tencent.tendinsv.tool.g;
import com.tencent.tendinsv.tool.i;
import com.tencent.tendinsv.utils.l;
import com.tencent.tendinsv.utils.o;
import com.tencent.tendinsv.utils.t;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/c/b.class */
public class b implements GetPhoneInfoCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private Context f39014a;

    public b(Context context) {
        this.f39014a = context;
    }

    private void a(long j, long j2, long j3) {
        String str;
        com.tencent.tendinsv.b.X.set(com.tencent.tendinsv.b.U);
        if (!com.tencent.tendinsv.b.h.equals(com.tencent.tendinsv.b.p) && !com.tencent.tendinsv.b.g.equals(com.tencent.tendinsv.b.p)) {
            i.a().a(com.tencent.tendinsv.b.i, j, j2, j3);
            return;
        }
        String str2 = "";
        String b = t.b(this.f39014a, com.tencent.tendinsv.b.w, "");
        if (com.tencent.tendinsv.b.h.equals(com.tencent.tendinsv.b.p)) {
            str2 = t.b(this.f39014a, t.g, "");
            str = "3";
        } else if (1 == t.b(this.f39014a, t.D, 1)) {
            str = "4";
        } else {
            ToolUtils.clearCache(this.f39014a);
            str = "2";
        }
        i.a().a(str, com.tencent.tendinsv.b.p, b, str2, j, j2, j3);
    }

    @Override // com.tencent.tendinsv.listener.GetPhoneInfoCallbacks
    public void getPhoneInfoFailed(int i, int i2, String str, String str2, int i3, String str3, long j, long j2, long j3) {
        try {
            o.a();
            l.a(com.tencent.tendinsv.b.H, "getPhoneInfoFailed--code==", Integer.valueOf(i), "__processName== ", Integer.valueOf(i3), "__isGetToken==", Boolean.valueOf(com.tencent.tendinsv.b.Q.get()));
            t.a(this.f39014a, t.U, false);
            com.tencent.tendinsv.b.W.set(com.tencent.tendinsv.b.S);
            String a2 = com.tencent.tendinsv.utils.d.a(i2, str2, str, str3);
            long uptimeMillis = SystemClock.uptimeMillis() - j3;
            long uptimeMillis2 = SystemClock.uptimeMillis() - j2;
            long b = t.b(this.f39014a, t.f, 3L);
            if (!"cache".equals(str2)) {
                t.a(this.f39014a, t.e, System.currentTimeMillis() + (b * 1000));
            }
            try {
                if (i3 == 4) {
                    com.tencent.tendinsv.b.X.set(com.tencent.tendinsv.b.S);
                    e.a().c(i, i2, a2, str2, str3, i3, 2, com.tencent.tendinsv.b.S, j, uptimeMillis2, uptimeMillis);
                    return;
                }
                if (com.tencent.tendinsv.b.Q.getAndSet(false)) {
                    com.tencent.tendinsv.b.X.set(com.tencent.tendinsv.b.S);
                    e.a().c(i, i2, a2, str2, str3, 4, 2, com.tencent.tendinsv.b.S, j, uptimeMillis2, uptimeMillis);
                }
                e.a().b(i, i2, a2, str2, str3, i3, 2, com.tencent.tendinsv.b.S, j, uptimeMillis2, uptimeMillis);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                l.d(com.tencent.tendinsv.b.F, "getPhoneInfoFailed_Exception_e=", e);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.tencent.tendinsv.listener.GetPhoneInfoCallbacks
    public void getPhoneInfoSuccessed(int i, int i2, String str, String str2, int i3, long j, long j2, long j3) {
        try {
            o.a();
            l.a(com.tencent.tendinsv.b.H, "getPhoneInfoSuccessed--code==", Integer.valueOf(i), "__processName== ", Integer.valueOf(i3), "__isGetToken==", Boolean.valueOf(com.tencent.tendinsv.b.Q.get()));
            com.tencent.tendinsv.b.W.set(com.tencent.tendinsv.b.T);
            t.a(this.f39014a, t.U, true);
            t.a(this.f39014a, t.R, true);
            t.a(this.f39014a, t.d, com.tencent.tendinsv.tool.d.a().a(this.f39014a));
            String a2 = com.tencent.tendinsv.utils.d.a(i2, str2, str, this.f39014a);
            long uptimeMillis = SystemClock.uptimeMillis() - j3;
            long uptimeMillis2 = SystemClock.uptimeMillis() - j2;
            if (i3 == 4) {
                g.a().a(i, i2, a2, str2, com.tencent.tendinsv.b.p, i3, 2, com.tencent.tendinsv.b.T, j, uptimeMillis2, uptimeMillis, false, 1);
                a(j, j2, j3);
                return;
            }
            if (com.tencent.tendinsv.b.Q.getAndSet(false)) {
                a(j, j2, j3);
            }
            e.a().b(i, i2, a2, str2, com.tencent.tendinsv.b.p, i3, 2, com.tencent.tendinsv.b.T, j, uptimeMillis2, uptimeMillis);
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "getPhoneInfoSuccessed_Exception_e=", e);
        }
    }
}
