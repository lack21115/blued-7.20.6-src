package com.tencent.tendinsv.c;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.tendinsv.listener.LoginAuthCallbacks;
import com.tencent.tendinsv.utils.l;
import com.tencent.tendinsv.utils.t;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tendinsv/c/d.class */
public class d implements LoginAuthCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private Context f39016a;

    public d(Context context) {
        this.f39016a = context;
    }

    @Override // com.tencent.tendinsv.listener.LoginAuthCallbacks
    public void getTokenFailed(int i, int i2, String str, String str2, String str3, long j, long j2, long j3) {
        try {
            l.a(com.tencent.tendinsv.b.H, "getTokenFailed--code==", Integer.valueOf(i), "__operator== ", str3);
            String a2 = com.tencent.tendinsv.utils.d.a(i2, str2, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            long uptimeMillis2 = SystemClock.uptimeMillis();
            com.tencent.tendinsv.b.X.set(com.tencent.tendinsv.b.S);
            e.a().c(i, i2, a2, str2, str3, 4, 4, com.tencent.tendinsv.b.S, j, uptimeMillis2 - j2, uptimeMillis - j3);
        } catch (Exception e) {
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "getTokenFailed_Exception_e=", e);
        }
    }

    @Override // com.tencent.tendinsv.listener.LoginAuthCallbacks
    public void getTokenSuccessed(int i, int i2, String str, String str2, long j, long j2, long j3) {
        try {
            l.a(com.tencent.tendinsv.b.H, "getTokenSuccessed--code==", Integer.valueOf(i), "__TELECOM_VALUE== ", com.tencent.tendinsv.b.p);
        } catch (Exception e) {
            e = e;
        }
        try {
            t.a(this.f39016a, t.R, true);
            com.tencent.tendinsv.b.X.set(com.tencent.tendinsv.b.T);
            e.a().c(i, i2, str, str2, com.tencent.tendinsv.b.p, 4, 4, com.tencent.tendinsv.b.T, j, SystemClock.uptimeMillis() - j2, SystemClock.uptimeMillis() - j3);
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            l.d(com.tencent.tendinsv.b.F, "getTokenSuccessed_Exception_e=", e);
        }
    }
}
