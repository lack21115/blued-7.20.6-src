package com.anythink.expressad.exoplayer.e.a;

import com.anythink.expressad.exoplayer.k.af;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a/m.class */
final class m {

    /* renamed from: a  reason: collision with root package name */
    public final j f7310a;
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f7311c;
    public final int[] d;
    public final int e;
    public final long[] f;
    public final int[] g;
    public final long h;

    public m(j jVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        com.anythink.expressad.exoplayer.k.a.a(iArr.length == jArr2.length);
        com.anythink.expressad.exoplayer.k.a.a(jArr.length == jArr2.length);
        com.anythink.expressad.exoplayer.k.a.a(iArr2.length == jArr2.length);
        this.f7310a = jVar;
        this.f7311c = jArr;
        this.d = iArr;
        this.e = i;
        this.f = jArr2;
        this.g = iArr2;
        this.h = j;
        this.b = jArr.length;
    }

    public final int a(long j) {
        int a2 = af.a(this.f, j, false);
        while (true) {
            int i = a2;
            if (i < 0) {
                return -1;
            }
            if ((this.g[i] & 1) != 0) {
                return i;
            }
            a2 = i - 1;
        }
    }

    public final int b(long j) {
        int a2 = af.a(this.f, j, true, false);
        while (true) {
            int i = a2;
            if (i >= this.f.length) {
                return -1;
            }
            if ((this.g[i] & 1) != 0) {
                return i;
            }
            a2 = i + 1;
        }
    }
}
