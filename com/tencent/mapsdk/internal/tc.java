package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.vc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/tc.class */
public abstract class tc<T extends vc> {
    public int g;
    public long h;
    public uc<T> i;
    public T j;

    public tc(uc<T> ucVar, T t) {
        this.i = ucVar;
        this.j = t;
    }

    public void a(long j) {
        this.h = j;
    }

    public void a(T t) {
        uc<T> ucVar = this.i;
        if (ucVar == null || t == null) {
            return;
        }
        this.j = t;
        ucVar.c(this);
    }

    public T f() {
        return this.j;
    }

    public String getId() {
        return this.g + "";
    }

    public int l() {
        return this.g;
    }

    public void remove() {
        uc<T> ucVar = this.i;
        if (ucVar == null) {
            return;
        }
        ucVar.b(this);
    }

    public long x() {
        return this.h;
    }
}
