package com.zx.a.I8b7;

import android.text.TextUtils;
import com.zx.a.I8b7.t0;
import com.zx.a.I8b7.u1;
import java.util.UUID;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/x2.class */
public class x2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a3 f42228a;

    public x2(a3 a3Var) {
        this.f42228a = a3Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        t0 t0Var = t0.a.f42200a;
        try {
            t0Var.f42198a = System.currentTimeMillis();
            t0Var.b = UUID.randomUUID().toString().replaceAll("-", "");
            u1 u1Var = u1.a.f42208a;
            String a2 = u1Var.f42207a.a(24);
            if (!TextUtils.isEmpty(a2)) {
                t0Var.f42199c = Integer.parseInt(a2);
            }
            t0Var.f42199c++;
            b3 b3Var = u1Var.f42207a;
            b3Var.getClass();
            u1Var.f42207a.a(24, t0Var.f42199c + "", true);
            z1.a("process start pts:" + t0Var.f42198a + ", pid:" + t0Var.b + ", rc:" + t0Var.f42199c);
        } catch (Throwable th) {
            z1.a(th);
        }
        if (!this.f42228a.b.get()) {
            throw new IllegalStateException("ZXSdkImpl not init, should init firstly");
        }
        try {
            a3.a(this.f42228a);
        } catch (Throwable th2) {
            this.f42228a.f42101c.onMessage("MESSAGE_ON_ZXID_RECEIVED", n1.a(10000, th2.getMessage()));
            StringBuilder sb = new StringBuilder();
            sb.append("ZXCore start failed: ");
            n2.a(th2, sb);
        }
    }
}
