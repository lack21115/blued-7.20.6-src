package com.efs.sdk.base.core.e;

import com.efs.sdk.base.core.util.Log;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/e/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private com.efs.sdk.base.core.e.a.a f8162a;

    public abstract com.efs.sdk.base.core.e.a.a a();

    public final void a(com.efs.sdk.base.core.d.b bVar) {
        try {
            if (this.f8162a == null) {
                synchronized (this) {
                    if (this.f8162a == null) {
                        com.efs.sdk.base.core.e.a.a a2 = a();
                        this.f8162a = a2;
                        if (a2 == null) {
                            return;
                        }
                    }
                }
            }
            this.f8162a.a(bVar);
        } catch (Throwable th) {
            Log.e("efs.processor", "log handle error", th);
        }
    }
}
