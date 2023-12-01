package com.sdk.tencent.u;

import android.content.Context;
import com.sdk.tencent.base.module.manager.SDKManager;
import com.sdk.tencent.f.c;
import com.sdk.tencent.g.b;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/u/a.class */
public class a<T> extends b<T> {
    public a(Context context, com.sdk.tencent.e.a<T> aVar, com.sdk.tencent.f.b bVar) {
        super(context, aVar, bVar);
        a();
    }

    public final void a() {
        if (!c.d) {
            this.g = c.b.b.a();
            c.b.f28051a.a();
            return;
        }
        String testHost = SDKManager.getTestHost();
        if (!com.sdk.tencent.n.b.b(SDKManager.getStatisticalTestHost()).booleanValue()) {
            c.b.f28051a.a();
        }
        if (!com.sdk.tencent.n.b.b(testHost).booleanValue()) {
            testHost = c.b.b.a();
        }
        this.g = testHost;
    }
}
