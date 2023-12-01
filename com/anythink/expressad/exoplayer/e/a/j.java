package com.anythink.expressad.exoplayer.e.a;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final int f4465a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public final int f4466c;
    public final int d;
    public final long e;
    public final long f;
    public final long g;
    public final com.anythink.expressad.exoplayer.m h;
    public final int i;
    public final long[] j;
    public final long[] k;
    public final int l;
    private final k[] m;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/j$a.class */
    public @interface a {
    }

    public j(int i, int i2, long j, long j2, long j3, com.anythink.expressad.exoplayer.m mVar, int i3, k[] kVarArr, int i4, long[] jArr, long[] jArr2) {
        this.f4466c = i;
        this.d = i2;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = mVar;
        this.i = i3;
        this.m = kVarArr;
        this.l = i4;
        this.j = jArr;
        this.k = jArr2;
    }

    public final k a(int i) {
        k[] kVarArr = this.m;
        if (kVarArr == null) {
            return null;
        }
        return kVarArr[i];
    }
}
