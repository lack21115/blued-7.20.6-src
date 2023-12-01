package com.zx.a.I8b7;

import com.zx.a.I8b7.c3;
import com.zx.sdk.api.PermissionCallback;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/r0.class */
public class r0 implements PermissionCallback {

    /* renamed from: a  reason: collision with root package name */
    public PermissionCallback f28500a;

    public r0(PermissionCallback permissionCallback) {
        this.f28500a = permissionCallback;
    }

    @Override // com.zx.sdk.api.PermissionCallback
    public void onAuthorized() {
        try {
            if (this.f28500a != null) {
                e2 b = e2.b();
                PermissionCallback permissionCallback = this.f28500a;
                b.getClass();
                AtomicInteger atomicInteger = c3.f28421c;
                c3.c.f28423a.b.execute(new b2(b, permissionCallback));
            }
        } catch (Throwable th) {
            z1.a(th);
        }
    }

    @Override // com.zx.sdk.api.PermissionCallback
    public void onUnauthorized() {
        try {
            if (this.f28500a != null) {
                e2 b = e2.b();
                b.getClass();
                AtomicInteger atomicInteger = c3.f28421c;
                c3.c.f28423a.b.execute(new c2(b));
                this.f28500a.onUnauthorized();
            }
        } catch (Throwable th) {
            z1.a(th);
        }
    }
}
