package com.qiniu.pili.droid.shortvideo.gl.c;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/d.class */
public class d extends g {

    /* renamed from: a  reason: collision with root package name */
    protected float f27713a;
    protected float b;

    /* renamed from: c  reason: collision with root package name */
    protected float f27714c;
    protected float d;
    protected int e;
    protected int f;
    private int o;
    private int p;
    private float q;
    private int r;
    private Bitmap s;
    private boolean t = true;
    private boolean u;
    private k v;

    public d(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    public d(Bitmap bitmap) {
        this.s = bitmap;
    }

    private int a(int i, boolean z) {
        if (!k()) {
            com.qiniu.pili.droid.shortvideo.f.e.j.d("Sticker is not setup.");
            return i;
        }
        int a2 = this.v.a(i);
        GLES20.glBlendEquationSeparate(32774, 32774);
        GLES20.glBlendFuncSeparate(1, 771, 1, 1);
        GLES20.glEnable(3042);
        GLES20.glBindFramebuffer(36160, this.o);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, a2, 0);
        if (z) {
            GLES20.glClear(16384);
        }
        b(this.p);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDisable(3042);
        return a2;
    }

    private void t() {
        k kVar = new k();
        this.v = kVar;
        kVar.a(this.i, this.j);
        this.v.b();
    }

    private void u() {
        if (this.f27714c == 0.0f) {
            this.f27714c = this.f27713a + ((this.e * 1.0f) / this.i);
        }
        if (this.d == 0.0f) {
            this.d = this.b + ((this.f * 1.0f) / this.j);
        }
        if (this.t) {
            float f = this.f27714c;
            if (f > 1.0f) {
                this.f27713a = 1.0f - (f - this.f27713a);
                this.f27714c = 1.0f;
            }
            float f2 = this.d;
            if (f2 > 1.0f) {
                this.b = 1.0f - (f2 - this.b);
                this.d = 1.0f;
            }
        }
        float f3 = this.i / this.j;
        float f4 = f3 * 2.0f;
        float f5 = this.f27713a * f4;
        this.f27713a = f5;
        float f6 = this.b * 2.0f;
        this.b = f6;
        float f7 = this.f27714c * f4;
        this.f27714c = f7;
        float f8 = this.d * 2.0f;
        this.d = f8;
        this.f27713a = f5 - f3;
        float f9 = f6 - 1.0f;
        this.b = f9;
        this.f27714c = f7 - f3;
        float f10 = f8 - 1.0f;
        this.d = f10;
        this.b = f9 * (-1.0f);
        this.d = f10 * (-1.0f);
        this.m = new float[16];
        float f11 = this.f27714c;
        float f12 = this.f27713a;
        float f13 = this.d;
        float f14 = this.b;
        Matrix.orthoM(this.m, 0, -f3, f3, -1.0f, 1.0f, -1.0f, 1.0f);
        float f15 = (f11 - f12) / 2.0f;
        float f16 = (f13 - f14) / 2.0f;
        Matrix.translateM(this.m, 0, this.f27713a + f15, this.b + f16, 0.0f);
        Matrix.rotateM(this.m, 0, this.k, 0.0f, 0.0f, -1.0f);
        Matrix.translateM(this.m, 0, -(this.f27713a + f15), -(this.b + f16), 0.0f);
    }

    public int a(int i) {
        return a(i, false);
    }

    public int a(int i, int i2, boolean z) {
        this.p = i2;
        int a2 = a(i, z);
        this.p = 0;
        return a2;
    }

    public void a(float f) {
        this.q = f;
    }

    public void a(float f, float f2) {
        this.f27714c = this.f27713a + f;
        this.d = this.b + f2;
    }

    public void a(boolean z) {
        this.t = z;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    protected String[] a() {
        return this.u ? new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   gl_Position.y = -gl_Position.y;\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nuniform float u_alpha;\nvoid main() {\n    gl_FragColor = texture2D(u_tex, v_tex_coord) * u_alpha;\n}\n"} : new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nuniform float u_alpha;\nvoid main() {\n    gl_FragColor = texture2D(u_tex, v_tex_coord) * u_alpha;\n}\n"};
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public void b(float f) {
        this.k = f;
    }

    public void b(float f, float f2) {
        this.f27713a = f;
        this.b = f2;
    }

    public void b(boolean z) {
        this.u = z;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean b() {
        if (this.s == null && (this.e == 0 || this.f == 0)) {
            com.qiniu.pili.droid.shortvideo.f.e.j.d("Sticker's bitmap is null, or it's width or height is 0, setup failed.");
            return false;
        }
        this.o = com.qiniu.pili.droid.shortvideo.f.d.e();
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            this.e = bitmap.getWidth();
            int height = this.s.getHeight();
            this.f = height;
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.e * height * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            if (this.s.getConfig() == Bitmap.Config.ARGB_8888) {
                this.s.copyPixelsToBuffer(allocateDirect);
                allocateDirect.position(0);
            }
            this.p = com.qiniu.pili.droid.shortvideo.f.d.a(allocateDirect, this.e, this.f, 6408);
        }
        u();
        t();
        return super.b();
    }

    public void c(float f) {
        b(f);
        Matrix.rotateM(this.m, 0, this.k, 0.0f, 0.0f, -1.0f);
    }

    public void c(boolean z) {
        if (z && this.v != null) {
            this.i = 0;
            this.j = 0;
            this.v.f();
            this.v = null;
        }
        this.f27713a = 0.0f;
        this.b = 0.0f;
        this.f27714c = 0.0f;
        this.d = 0.0f;
        this.e = 0;
        this.f = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean c() {
        this.r = GLES20.glGetUniformLocation(this.l, "u_alpha");
        return super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public void d() {
        super.d();
        GLES20.glUniform1f(this.r, this.q);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public void f() {
        super.f();
        int i = this.o;
        if (i != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            this.o = 0;
        }
        int i2 = this.p;
        if (i2 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
            this.p = 0;
        }
        k kVar = this.v;
        if (kVar != null) {
            kVar.f();
            this.v = null;
        }
    }

    public void h() {
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            this.e = bitmap.getWidth();
            this.f = this.s.getHeight();
        }
        u();
        if (this.v == null) {
            t();
        }
        q();
        r();
        super.s();
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    protected float[] i() {
        float f = this.f27713a;
        float f2 = this.d;
        float f3 = this.b;
        float f4 = this.f27714c;
        return new float[]{f, f2, f, f3, f4, f2, f4, f3};
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    protected float[] j() {
        return com.qiniu.pili.droid.shortvideo.f.d.d;
    }
}
