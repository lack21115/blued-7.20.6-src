package com.tencent.mapsdk.internal;

import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s7.class */
public class s7 extends r7 {
    private float j;
    private float k;

    public s7(float f, float f2, long j) {
        super(j);
        this.j = f;
        this.k = f2;
    }

    @Override // com.tencent.mapsdk.internal.r7
    public void a(GL10 gl10, long j) {
        float f = this.k;
        float f2 = this.j;
        float f3 = f2 + (((f - f2) * ((float) j)) / ((float) this.f24044a));
        gl10.glColor4f(f3, f3, f3, f3);
    }
}
