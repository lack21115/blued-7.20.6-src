package com.anythink.expressad.exoplayer.e;

import com.anythink.expressad.exoplayer.e.k;
import com.anythink.expressad.exoplayer.k.af;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/a.class */
public final class a implements k {

    /* renamed from: a  reason: collision with root package name */
    public final int f7271a;
    public final int[] b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f7272c;
    public final long[] d;
    public final long[] e;
    private final long f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.b = iArr;
        this.f7272c = jArr;
        this.d = jArr2;
        this.e = jArr3;
        int length = iArr.length;
        this.f7271a = length;
        if (length > 0) {
            this.f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f = 0L;
        }
    }

    private int b(long j) {
        return af.a(this.e, j, true);
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final k.a a(long j) {
        int a2 = af.a(this.e, j, true);
        l lVar = new l(this.e[a2], this.f7272c[a2]);
        if (lVar.b >= j || a2 == this.f7271a - 1) {
            return new k.a(lVar);
        }
        int i = a2 + 1;
        return new k.a(lVar, new l(this.e[i], this.f7272c[i]));
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final boolean a() {
        return true;
    }

    @Override // com.anythink.expressad.exoplayer.e.k
    public final long b() {
        return this.f;
    }

    public final String toString() {
        return "ChunkIndex(length=" + this.f7271a + ", sizes=" + Arrays.toString(this.b) + ", offsets=" + Arrays.toString(this.f7272c) + ", timeUs=" + Arrays.toString(this.e) + ", durationsUs=" + Arrays.toString(this.d) + ")";
    }
}
