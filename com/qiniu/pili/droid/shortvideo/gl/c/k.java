package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/k.class */
public class k extends g {

    /* renamed from: a  reason: collision with root package name */
    protected int f14033a;
    protected int b;

    private boolean b(int i, int i2) {
        this.b = com.qiniu.pili.droid.shortvideo.f.d.a((ByteBuffer) null, i, i2, 6408);
        return true;
    }

    private void h() {
        int i = this.b;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.b = 0;
        }
    }

    private void t() {
        this.f14033a = com.qiniu.pili.droid.shortvideo.f.d.e();
    }

    public int a(int i) {
        return b(i, (float[]) null);
    }

    public int a(int i, float[] fArr, int i2, int i3) {
        GLES20.glBindFramebuffer(36160, this.f14033a);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        GLES20.glClear(16384);
        a(i, fArr, i3);
        GLES20.glBindFramebuffer(36160, 0);
        return i2;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean a(int i, int i2) {
        super.a(i, i2);
        h();
        return b(i, i2);
    }

    public int b(int i, float[] fArr) {
        return b(i, fArr, this.b);
    }

    public int b(int i, float[] fArr, int i2) {
        return a(i, fArr, i2, -1);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean b() {
        t();
        return super.b();
    }

    public int c(int i, float[] fArr, int i2) {
        return a(i, fArr, this.b, i2);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public void f() {
        super.f();
        int i = this.f14033a;
        if (i != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            this.f14033a = 0;
        }
        h();
    }
}
