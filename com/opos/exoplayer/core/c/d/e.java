package com.opos.exoplayer.core.c.d;

import com.opos.exoplayer.core.Format;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/d/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final int f25124a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final long f25125c;
    public final long d;
    public final long e;
    public final Format f;
    public final int g;
    public final long[] h;
    public final long[] i;
    public final int j;
    private final f[] k;

    public e(int i, int i2, long j, long j2, long j3, Format format, int i3, f[] fVarArr, int i4, long[] jArr, long[] jArr2) {
        this.f25124a = i;
        this.b = i2;
        this.f25125c = j;
        this.d = j2;
        this.e = j3;
        this.f = format;
        this.g = i3;
        this.k = fVarArr;
        this.j = i4;
        this.h = jArr;
        this.i = jArr2;
    }

    public f a(int i) {
        f[] fVarArr = this.k;
        if (fVarArr == null) {
            return null;
        }
        return fVarArr[i];
    }
}
