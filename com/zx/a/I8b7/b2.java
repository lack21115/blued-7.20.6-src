package com.zx.a.I8b7;

import com.zx.a.I8b7.u1;
import com.zx.sdk.api.PermissionCallback;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/b2.class */
public class b2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionCallback f28417a;

    public b2(e2 e2Var, PermissionCallback permissionCallback) {
        this.f28417a = permissionCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            u1.a.f28517a.f28516a.c(1);
            m.a("用户已授权获取卓信ID");
            try {
                e2.a().a(t2.f28510a);
            } catch (Exception e) {
                m.b(e.getMessage());
            }
            this.f28417a.onAuthorized();
        } catch (Exception e2) {
            StringBuilder a2 = m2.a("卓信ID授权失败 error: ");
            a2.append(e2.getMessage());
            m.b(a2.toString());
        }
    }
}
