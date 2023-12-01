package com.zx.a.I8b7;

import com.zx.sdk.api.Callback;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/h2.class */
public class h2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28442a;
    public final /* synthetic */ Callback b;

    public h2(e2 e2Var, String str, Callback callback) {
        this.f28442a = str;
        this.b = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            e2.a().a(this.f28442a, this.b);
        } catch (Throwable th) {
            Callback callback = this.b;
            if (callback != null) {
                callback.onFailed(10000, th.getMessage());
            }
            n2.a(th, m2.a("ZXManager.getTag() failed: "));
        }
    }
}
