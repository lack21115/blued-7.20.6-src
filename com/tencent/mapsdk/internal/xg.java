package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xg.class */
public class xg implements Comparable<xg> {
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f38114c;
    public final int d;

    public xg(int i, int i2, int i3) {
        this.b = i;
        this.f38114c = i2;
        this.d = i3;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(xg xgVar) {
        return this.b - xgVar.b;
    }
}
