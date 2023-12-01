package com.tencent.tendinsv.c;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.tendinsv.listener.InitCallbacks;
import com.tencent.tendinsv.tool.g;
import com.tencent.tendinsv.tool.j;
import com.tencent.tendinsv.utils.l;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/c/c.class */
public class c implements InitCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private Context f25324a;

    public c(Context context) {
        this.f25324a = context;
    }

    @Override // com.tencent.tendinsv.listener.InitCallbacks
    public void initFailed(int i, int i2, String str, String str2, int i3, long j, long j2, long j3) {
        try {
            String a2 = com.tencent.tendinsv.tool.d.a().a(this.f25324a);
            l.a(com.tencent.tendinsv.b.H, "InitFailed--code==", Integer.valueOf(i), "__operator==", a2, "__processName== ", Integer.valueOf(i3), "__isGetToken==", Boolean.valueOf(com.tencent.tendinsv.b.Q.get()), "__isPreInitia==", "__isAuthentication==", Boolean.valueOf(com.tencent.tendinsv.b.R.get()));
            com.tencent.tendinsv.b.V.set(com.tencent.tendinsv.b.S);
            String a3 = com.tencent.tendinsv.utils.d.a(i2, str2, str);
            long uptimeMillis = SystemClock.uptimeMillis() - j3;
            long uptimeMillis2 = SystemClock.uptimeMillis() - j2;
            if (i3 == 2) {
                com.tencent.tendinsv.b.W.set(com.tencent.tendinsv.b.S);
                e.a().b(i, i2, a3, str2, a2, i3, 1, com.tencent.tendinsv.b.S, j, uptimeMillis2, uptimeMillis);
                if (com.tencent.tendinsv.b.Q.getAndSet(false)) {
                    com.tencent.tendinsv.b.X.set(com.tencent.tendinsv.b.S);
                    try {
                        e.a().c(i, i2, a3, str2, a2, i3, 1, com.tencent.tendinsv.b.S, j, uptimeMillis2, uptimeMillis);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        l.d(com.tencent.tendinsv.b.F, "InitFailed_Exception_e=", e);
                    }
                }
            } else if (i3 == 4) {
                com.tencent.tendinsv.b.W.set(com.tencent.tendinsv.b.S);
                com.tencent.tendinsv.b.X.set(com.tencent.tendinsv.b.S);
                e.a().c(i, i2, a3, str2, a2, i3, 1, com.tencent.tendinsv.b.S, j, uptimeMillis2, uptimeMillis);
            } else {
                if (i3 == 11) {
                    com.tencent.tendinsv.b.Y.set(com.tencent.tendinsv.b.S);
                    e.a().d(i, i2, a3, str2, a2, i3, 1, com.tencent.tendinsv.b.S, j, uptimeMillis2, uptimeMillis);
                }
                e.a().a(i, i2, a3, str2, a2, i3, 1, com.tencent.tendinsv.b.S, j, uptimeMillis2, uptimeMillis);
                if (com.tencent.tendinsv.b.R.getAndSet(false)) {
                    com.tencent.tendinsv.b.Y.set(com.tencent.tendinsv.b.S);
                    e.a().d(i, i2, a3, str2, a2, 11, 1, com.tencent.tendinsv.b.S, j, uptimeMillis2, uptimeMillis);
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @Override // com.tencent.tendinsv.listener.InitCallbacks
    public void initSuccessed(int i, int i2, String str, String str2, int i3, long j, long j2, long j3) {
        try {
            g.a().b();
            String a2 = com.tencent.tendinsv.tool.d.a().a(this.f25324a);
            l.a(com.tencent.tendinsv.b.H, "initSuccessed--code==", Integer.valueOf(i), "__operator==", a2, "__processName== ", Integer.valueOf(i3), "__isGetToken==", Boolean.valueOf(com.tencent.tendinsv.b.Q.get()), "__isPreInitia==", "__isAuthentication==", Boolean.valueOf(com.tencent.tendinsv.b.R.get()));
            com.tencent.tendinsv.b.V.set(com.tencent.tendinsv.b.T);
            j.a().c();
            String a3 = com.tencent.tendinsv.utils.d.a(i2, str2, str);
            long uptimeMillis = SystemClock.uptimeMillis() - j3;
            long uptimeMillis2 = SystemClock.uptimeMillis() - j2;
            if (i3 == 2 || i3 == 4) {
                com.tencent.tendinsv.tool.l.a().b(i3, null, j, j2, j3);
                try {
                    g.a().a(i, i2, a3, str2, a2, i3, 1, com.tencent.tendinsv.b.T, j, uptimeMillis2, uptimeMillis, false, 1);
                    return;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    l.d(com.tencent.tendinsv.b.F, "InitSuccessed_Exception_e=", e);
                    return;
                }
            }
            if (i3 == 11) {
                com.tencent.tendinsv.tool.c.a().b(11, j, j2, j3);
                g.a().a(i, i2, a3, str2, a2, i3, 1, com.tencent.tendinsv.b.T, j, uptimeMillis2, uptimeMillis, false, 1);
            }
            e.a().a(i, i2, a3, str2, a2, i3, 1, com.tencent.tendinsv.b.T, j, uptimeMillis2, uptimeMillis);
            if (com.tencent.tendinsv.b.R.getAndSet(false)) {
                com.tencent.tendinsv.tool.c.a().b(11, j, j2, j3);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
