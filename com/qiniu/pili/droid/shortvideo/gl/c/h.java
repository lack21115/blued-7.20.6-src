package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/h.class */
public class h extends k {
    private long e;
    private long f = -1;

    /* renamed from: c  reason: collision with root package name */
    private e f14031c = new e();
    private e d = new e();

    public h(long j) {
        this.e = j;
    }

    private float a(long j) {
        long j2 = (j - this.f) / 1000000;
        long j3 = this.e;
        float f = j3 == 0 ? 1.0f : ((float) j2) / ((float) j3);
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private void a(e eVar, int i, float f, boolean z) {
        GLES20.glBlendEquationSeparate(32774, 32774);
        GLES20.glBlendFuncSeparate(1, 771, 1, 1);
        GLES20.glEnable(3042);
        eVar.a(i, f, null, this.b, z);
        GLES20.glDisable(3042);
    }

    private boolean b(long j) {
        return a(j) >= 1.0f;
    }

    private float c(long j) {
        return 1.0f - a(j);
    }

    public int a(int i, int i2, long j) {
        if (i2 <= 0) {
            a(this.f14031c, i, 1.0f, true);
            return this.b;
        } else if (com.qiniu.pili.droid.shortvideo.f.j.a(this.e) < j) {
            a(this.f14031c, i, 1.0f, true);
            return this.b;
        } else {
            if (this.f == -1) {
                this.f = 0L;
            }
            a(this.f14031c, i, a(j), true);
            a(this.d, i2, c(j), false);
            return this.b;
        }
    }

    public int a(int i, int i2, long j, boolean z) {
        if (z) {
            this.f = j;
        }
        if (this.f == -1) {
            com.qiniu.pili.droid.shortvideo.f.e.t.e("TextureFadeProcessor", "no first frame to process!");
            a(this.d, i2, 1.0f, true);
            return this.b;
        } else if (b(j)) {
            a(this.d, i2, 1.0f, true);
            return this.b;
        } else {
            if (i > 0) {
                a(this.f14031c, i, c(j), true);
                a(this.d, i2, a(j), false);
            } else {
                a(this.d, i2, a(j), true);
            }
            return this.b;
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.k, com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean a(int i, int i2) {
        return this.f14031c.a(i, i2) && this.d.a(i, i2) && super.a(i, i2);
    }

    public boolean a(int i, int i2, int i3, int i4, PLDisplayMode pLDisplayMode) {
        return (pLDisplayMode == PLDisplayMode.FIT ? this.f14031c.a(i, i2, PLDisplayMode.FIT) : this.f14031c.b()) && (pLDisplayMode == PLDisplayMode.FIT ? this.d.a(i3, i4, PLDisplayMode.FIT) : this.d.b()) && super.b();
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.k, com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean b() {
        return this.f14031c.b() && this.d.b() && super.b();
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.k, com.qiniu.pili.droid.shortvideo.gl.c.g
    public void f() {
        this.f14031c.f();
        this.d.f();
        super.f();
    }
}
