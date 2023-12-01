package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.l2;
import com.tencent.mapsdk.internal.l2.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j3.class */
public abstract class j3<R extends l2.a> extends h3<R> {
    private String f;
    private String g;

    public void b(String str) {
        this.f = str;
    }

    public void c(String str) {
        this.g = str;
    }

    @Override // com.tencent.mapsdk.internal.h3, com.tencent.mapsdk.internal.l2
    public final String f() {
        return this.g;
    }

    @Override // com.tencent.mapsdk.internal.l2
    public final String g() {
        return this.f;
    }
}
