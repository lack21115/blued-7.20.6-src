package com.zx.a.I8b7;

import com.zx.sdk.api.ZXIDListener;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/a2.class */
public class a2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f42099a;
    public final /* synthetic */ ZXIDListener b;

    public a2(e2 e2Var, String str, ZXIDListener zXIDListener) {
        this.f42099a = str;
        this.b = zXIDListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            e2.a().a(this.f42099a, this.b);
        } catch (Throwable th) {
            ZXIDListener zXIDListener = this.b;
            if (zXIDListener != null) {
                zXIDListener.onFailed(10000, th.getMessage());
            }
            n2.a(th, m2.a("ZXManager.getZXID(zxidListener) failed: "));
        }
    }
}
