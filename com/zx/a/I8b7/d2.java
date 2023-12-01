package com.zx.a.I8b7;

import android.app.Activity;
import android.os.Handler;
import com.zx.a.I8b7.r2;
import com.zx.sdk.api.PermissionCallback;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/d2.class */
public class d2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionCallback f42115a;
    public final /* synthetic */ Activity b;

    public d2(e2 e2Var, PermissionCallback permissionCallback, Activity activity) {
        this.f42115a = permissionCallback;
        this.b = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            r0 r0Var = new r0(this.f42115a);
            Handler handler = r2.f42192a;
            r2 r2Var = r2.a.f42193a;
            if (r2Var.b()) {
                Activity activity = this.b;
                r2Var.getClass();
                r2.f42192a.post(new q2(r2Var, activity, r0Var));
            } else if (r2Var.a()) {
                r0Var.onAuthorized();
            } else {
                r0Var.onUnauthorized();
            }
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXManager.registerListener(listener) failed: "));
        }
    }
}
