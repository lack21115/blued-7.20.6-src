package com.zx.a.I8b7;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.zx.a.I8b7.t0;
import com.zx.a.I8b7.u1;
import java.util.UUID;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/x2.class */
public class x2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a3 f28537a;

    public x2(a3 a3Var) {
        this.f28537a = a3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        t0 t0Var = t0.a.f28509a;
        try {
            t0Var.f28507a = System.currentTimeMillis();
            t0Var.b = UUID.randomUUID().toString().replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
            u1 u1Var = u1.a.f28517a;
            String a2 = u1Var.f28516a.a(24);
            if (!TextUtils.isEmpty(a2)) {
                t0Var.f28508c = Integer.parseInt(a2);
            }
            t0Var.f28508c++;
            b3 b3Var = u1Var.f28516a;
            b3Var.getClass();
            u1Var.f28516a.a(24, t0Var.f28508c + "", true);
            z1.a("process start pts:" + t0Var.f28507a + ", pid:" + t0Var.b + ", rc:" + t0Var.f28508c);
        } catch (Throwable th) {
            z1.a(th);
        }
        if (!this.f28537a.b.get()) {
            throw new IllegalStateException("ZXSdkImpl not init, should init firstly");
        }
        try {
            a3.a(this.f28537a);
        } catch (Throwable th2) {
            this.f28537a.f28410c.onMessage("MESSAGE_ON_ZXID_RECEIVED", n1.a(10000, th2.getMessage()));
            StringBuilder sb = new StringBuilder();
            sb.append("ZXCore start failed: ");
            n2.a(th2, sb);
        }
    }
}
