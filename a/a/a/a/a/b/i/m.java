package a.a.a.a.a.b.i;

import android.opengl.GLES20;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/m.class */
public class m extends g {
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f1330c;

    @Override // a.a.a.a.a.b.i.g
    public boolean a(int i, int i2) {
        m();
        return super.a(i, i2) && b(i, i2);
    }

    public int b(int i, float[] fArr) {
        GLES20.glBindFramebuffer(36160, this.b);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f1330c, 0);
        a(i, fArr);
        GLES20.glBindFramebuffer(36160, 0);
        return this.f1330c;
    }

    public final boolean b(int i, int i2) {
        this.f1330c = a.a.a.a.a.a.h.f.a(null, i, i2, 6408);
        return true;
    }

    public int d(int i) {
        return b(i, (float[]) null);
    }

    @Override // a.a.a.a.a.b.i.g
    public void g() {
        super.g();
        int i = this.b;
        if (i != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            this.b = 0;
        }
        int i2 = this.f1330c;
        if (i2 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
            this.f1330c = 0;
        }
    }

    public final void m() {
        this.b = a.a.a.a.a.a.h.f.c();
    }
}
