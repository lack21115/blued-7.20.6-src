package com.huawei.openalliance.ad.ipc;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.utils.ba;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/a.class */
public class a {
    private static final int Code = 60000;
    private static final String I = "Monitor";
    private static final String V = "unbindTask";
    private final String B = V + hashCode();
    private int C = 0;
    private Context F;
    private String S;
    private InterfaceC0436a Z;

    /* renamed from: com.huawei.openalliance.ad.ipc.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/a$a.class */
    public interface InterfaceC0436a {
        void Code();
    }

    public a(Context context, String str, InterfaceC0436a interfaceC0436a) {
        this.F = context.getApplicationContext();
        this.S = str;
        this.Z = interfaceC0436a;
    }

    private int B() {
        return TextUtils.equals(t.f22960cn, this.F.getPackageName()) ? 0 : 60000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        ge.V(Z(), "unbindService");
        try {
            this.Z.Code();
        } catch (Throwable th) {
            ge.I(I, "unbindService err: %s", th.getClass().getSimpleName());
        }
    }

    private String Z() {
        return "Monitor_" + this.S;
    }

    public Context Code() {
        return this.F;
    }

    public void I() {
        synchronized (this) {
            int i = this.C - 1;
            this.C = i;
            if (i < 0) {
                this.C = 0;
            }
            ge.Code(Z(), "dec count: %d", Integer.valueOf(this.C));
            if (this.C <= 0) {
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.C();
                    }
                }, this.B, B());
            }
        }
    }

    public void V() {
        synchronized (this) {
            this.C++;
            ba.Code(this.B);
            ge.V(Z(), "inc count: " + this.C);
        }
    }
}
