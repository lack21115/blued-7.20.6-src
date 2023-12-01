package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private int f14029a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14030c;
    private int f;
    protected int g;
    protected int h;
    protected int i;
    protected int j;
    protected float k;
    protected int l;
    protected float[] m;
    protected float[] n;
    private int o;
    private int p;
    private int q;
    private int t;
    private int u;
    private volatile boolean v;
    private float d = 1.0f;
    private float e = 1.0f;
    private float[] r = com.qiniu.pili.droid.shortvideo.f.d.b;
    private float[] s = com.qiniu.pili.droid.shortvideo.f.d.f13983c;

    private void a(float f, float f2, float f3, float f4) {
        float f5 = (this.i * 1.0f) / this.j;
        float f6 = f5 * 2.0f;
        float f7 = (f * f6) - f5;
        float f8 = (f6 * f2) - f5;
        float f9 = ((f3 * 2.0f) - 1.0f) * (-1.0f);
        float f10 = ((2.0f * f4) - 1.0f) * (-1.0f);
        float[] fArr = new float[16];
        this.m = fArr;
        Matrix.orthoM(fArr, 0, -f5, f5, -1.0f, 1.0f, -1.0f, 1.0f);
        Matrix.rotateM(this.m, 0, this.k, 0.0f, 0.0f, -1.0f);
        this.r = new float[]{f7, f10, f7, f9, f8, f10, f8, f9};
    }

    private void b(int i, int i2) {
        this.r = com.qiniu.pili.droid.shortvideo.f.d.b;
        float f = (this.i * 1.0f) / this.j;
        float f2 = i;
        float f3 = i2;
        if ((f2 * 1.0f) / f3 < f) {
            float f4 = ((f3 - (f2 / f)) / 2.0f) / f3;
            float f5 = 1.0f - f4;
            this.s = new float[]{0.0f, f4, 0.0f, f5, 1.0f, f4, 1.0f, f5};
            return;
        }
        float f6 = ((f2 - (f3 * f)) / 2.0f) / f2;
        float f7 = 1.0f - f6;
        this.s = new float[]{f6, 0.0f, f6, 1.0f, f7, 0.0f, f7, 1.0f};
    }

    private void c(int i, int i2) {
        float f;
        float f2;
        this.s = com.qiniu.pili.droid.shortvideo.f.d.f13983c;
        int i3 = this.i;
        float f3 = i3;
        float f4 = 1.0f;
        int i4 = this.j;
        float f5 = (f3 * 1.0f) / i4;
        float f6 = (i * 1.0f) / i2;
        float f7 = 0.0f;
        if (f6 < f5) {
            float f8 = i4 * f6;
            f7 = 0.5f - ((f8 / i3) / 2.0f);
            this.t = (int) (i3 * f7);
            f4 = ((f8 / i3) / 2.0f) + 0.5f;
            f = 0.0f;
            f2 = 1.0f;
        } else {
            float f9 = i3 / f6;
            f = 0.5f - ((f9 / i4) / 2.0f);
            f2 = ((f9 / i4) / 2.0f) + 0.5f;
            this.u = (int) (i4 * f);
        }
        a(f7, f4, f, f2);
    }

    private void h() {
        GLES20.glBindBuffer(34962, this.b);
        GLES20.glEnableVertexAttribArray(this.f);
        GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, this.f14030c);
        GLES20.glEnableVertexAttribArray(this.o);
        GLES20.glVertexAttribPointer(this.o, 2, 5126, false, 0, 0);
    }

    private boolean t() {
        String[] a2 = a();
        boolean z = false;
        int a3 = com.qiniu.pili.droid.shortvideo.f.d.a(a2[0], a2[1]);
        this.l = a3;
        if (a3 != 0) {
            z = true;
        }
        return z;
    }

    public void a(int i, float[] fArr) {
        a(i, fArr, -1);
    }

    public void a(int i, float[] fArr, int i2) {
        GLES20.glUseProgram(this.l);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(g(), i);
        if (com.qiniu.pili.droid.shortvideo.f.d.a()) {
            GLES30.glBindVertexArray(this.f14029a);
        } else {
            h();
        }
        if (i2 != -1 && this.n == null) {
            float[] fArr2 = new float[16];
            this.n = fArr2;
            Matrix.setIdentityM(fArr2, 0);
            Matrix.rotateM(this.n, 0, i2, 0.0f, 0.0f, -1.0f);
        }
        if (this.d != 1.0f || this.e != 1.0f) {
            float[] fArr3 = this.n;
            if (fArr3 != null) {
                Matrix.scaleM(fArr3, 0, this.d, this.e, 1.0f);
            }
            float[] fArr4 = this.m;
            if (fArr4 != null) {
                Matrix.scaleM(fArr4, 0, this.d, this.e, 1.0f);
            } else {
                float[] fArr5 = new float[16];
                this.m = fArr5;
                Matrix.setIdentityM(fArr5, 0);
                Matrix.scaleM(this.m, 0, this.d, this.e, 1.0f);
            }
            this.d = 1.0f;
            this.e = 1.0f;
        }
        if (i2 == -1) {
            int i3 = this.p;
            float[] fArr6 = this.m;
            if (fArr6 == null) {
                fArr6 = com.qiniu.pili.droid.shortvideo.f.d.f;
            }
            GLES20.glUniformMatrix4fv(i3, 1, false, fArr6, 0);
        } else {
            GLES20.glUniformMatrix4fv(this.p, 1, false, this.n, 0);
        }
        float[] fArr7 = fArr;
        if (fArr == null) {
            fArr7 = com.qiniu.pili.droid.shortvideo.f.d.f;
        }
        GLES20.glUniformMatrix4fv(this.q, 1, false, fArr7, 0);
        GLES20.glViewport(this.g, this.h, this.i, this.j);
        d();
        GLES20.glDrawArrays(5, 0, 4);
        e();
        if (com.qiniu.pili.droid.shortvideo.f.d.a()) {
            GLES30.glBindVertexArray(0);
        }
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindTexture(g(), 0);
    }

    public void a(float[] fArr) {
        this.s = fArr;
    }

    public boolean a(int i, int i2) {
        this.i = i;
        this.j = i2;
        return true;
    }

    public boolean a(int i, int i2, PLDisplayMode pLDisplayMode) {
        if (pLDisplayMode == PLDisplayMode.FULL) {
            b(i, i2);
        } else if (pLDisplayMode == PLDisplayMode.FIT) {
            c(i, i2);
        }
        return b();
    }

    protected String[] a() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n"};
    }

    public void b(float f) {
        if (this.m == null) {
            this.m = new float[16];
        }
        this.k = f;
        Matrix.setIdentityM(this.m, 0);
        Matrix.rotateM(this.m, 0, f, 0.0f, 0.0f, -1.0f);
    }

    public void b(int i) {
        a(i, (float[]) null);
    }

    public boolean b() {
        if (t() && c() && s()) {
            this.v = true;
            return true;
        }
        return false;
    }

    public void c(float f, float f2) {
        this.d = f;
        this.e = f2;
    }

    public boolean c() {
        this.f = GLES20.glGetAttribLocation(this.l, "a_pos");
        this.o = GLES20.glGetAttribLocation(this.l, "a_tex");
        this.p = GLES20.glGetUniformLocation(this.l, "u_mvp");
        this.q = GLES20.glGetUniformLocation(this.l, "u_tex_trans");
        return com.qiniu.pili.droid.shortvideo.f.d.a("TextureDrawer glBindAttribLocation");
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
        this.v = false;
        p();
        q();
        r();
    }

    protected int g() {
        return 3553;
    }

    protected float[] i() {
        return this.r;
    }

    protected float[] j() {
        return this.s;
    }

    public boolean k() {
        return this.v;
    }

    public int l() {
        return this.t;
    }

    public int m() {
        return this.u;
    }

    public int n() {
        return this.i;
    }

    public int o() {
        return this.j;
    }

    protected void p() {
        int i = this.l;
        if (i != 0) {
            GLES20.glDeleteProgram(i);
            this.l = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        int i = this.b;
        if (i != 0) {
            GLES20.glDeleteBuffers(1, new int[]{i}, 0);
            this.b = 0;
        }
        int i2 = this.f14030c;
        if (i2 != 0) {
            GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
            this.f14030c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        int i = this.f14029a;
        if (i != 0) {
            GLES30.glDeleteVertexArrays(1, new int[]{i}, 0);
            this.f14029a = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean s() {
        float[] i = i();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(i);
        asFloatBuffer.rewind();
        float[] j = j();
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(j.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(j);
        asFloatBuffer2.rewind();
        int[] iArr = new int[2];
        GLES20.glGenBuffers(2, iArr, 0);
        int i2 = iArr[0];
        this.b = i2;
        this.f14030c = iArr[1];
        GLES20.glBindBuffer(34962, i2);
        GLES20.glBufferData(34962, 32, asFloatBuffer, 35044);
        GLES20.glBindBuffer(34962, this.f14030c);
        GLES20.glBufferData(34962, 32, asFloatBuffer2, 35044);
        GLES20.glBindBuffer(34962, 0);
        if (com.qiniu.pili.droid.shortvideo.f.d.a()) {
            int d = com.qiniu.pili.droid.shortvideo.f.d.d();
            this.f14029a = d;
            GLES30.glBindVertexArray(d);
        }
        h();
        if (com.qiniu.pili.droid.shortvideo.f.d.a()) {
            GLES30.glBindVertexArray(0);
        }
        GLES20.glBindBuffer(34962, 0);
        return com.qiniu.pili.droid.shortvideo.f.d.a("TextureDrawer setup VAO, VBOs.");
    }
}
