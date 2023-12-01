package com.tencent.mapsdk.internal;

import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/v7.class */
public class v7 extends u7 {
    private long n;
    private long o;

    public v7(float f, float f2, float f3, float f4, long j, long j2) {
        super(f, f2, f3, f4, j + j2);
        this.n = j;
        this.o = j2;
    }

    @Override // com.tencent.mapsdk.internal.u7, com.tencent.mapsdk.internal.r7
    public void a(GL10 gl10, long j) {
        float f;
        float f2;
        float f3 = this.k;
        float f4 = this.j;
        float f5 = f3 - f4;
        float f6 = this.m;
        float f7 = this.l;
        float f8 = f6 - f7;
        long j2 = this.n;
        if (j < j2) {
            float f9 = (float) j;
            float f10 = (float) j2;
            f = f4 + ((f5 * f9) / f10);
            f2 = f7 + ((f8 * f9) / f10);
        } else {
            float f11 = (float) (j - j2);
            float f12 = (float) this.o;
            f = f3 - ((f5 * f11) / f12);
            f2 = f6 - ((f8 * f11) / f12);
        }
        gl10.glScalef(f, f2, 1.0f);
    }
}
