package com.tencent.mapsdk.internal;

import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/x7.class */
public class x7 extends r7 {
    private float j;
    private float k;
    private float l;
    private float m;

    public x7(float f, float f2, float f3, float f4, long j) {
        super(j);
        this.j = f;
        this.k = f2;
        this.l = f3;
        this.m = f4;
    }

    @Override // com.tencent.mapsdk.internal.r7
    public void a(GL10 gl10, long j) {
        float f = this.k;
        float f2 = this.j;
        float f3 = this.m;
        float f4 = this.l;
        float f5 = (float) j;
        float f6 = (float) this.f24044a;
        gl10.glTranslatef(f2 + (((f - f2) * f5) / f6), f4 + (((f3 - f4) * f5) / f6), 0.0f);
    }
}
