package a.a.a.a.a.b.i;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/d.class */
public class d extends h {

    /* renamed from: a  reason: collision with root package name */
    public static float[] f1273a = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    public Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    public int f1274c;
    public int d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float[] i = new float[8];
    public int j;
    public float k;
    public int l;

    public d(Bitmap bitmap) {
        this.b = bitmap;
    }

    public void a(float f) {
        this.k = f;
    }

    public void a(float f, float f2) {
        this.g = this.e + f;
        this.h = this.f + f2;
    }

    public void a(int i) {
        this.l = i;
    }

    @Override // a.a.a.a.a.b.i.h
    public boolean a() {
        this.f1274c = a.a.a.a.a.a.h.f.c();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.b.getWidth() * this.b.getHeight() * 4);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        if (this.b.getConfig() == Bitmap.Config.ARGB_8888) {
            this.b.copyPixelsToBuffer(allocateDirect);
            allocateDirect.position(0);
        }
        this.d = a.a.a.a.a.a.h.f.a(allocateDirect, this.b.getWidth(), this.b.getHeight(), 6408);
        this.p = new float[16];
        b();
        return super.a();
    }

    public int b(int i) {
        GLES20.glBlendEquationSeparate(32774, 32774);
        GLES20.glBlendFuncSeparate(1, 771, 1, 1);
        GLES20.glEnable(3042);
        GLES20.glBindFramebuffer(36160, this.f1274c);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        c(this.d);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDisable(3042);
        return i;
    }

    public void b() {
        if (this.g == 0.0f) {
            this.g = this.e + ((this.b.getWidth() * 1.0f) / this.m);
        }
        if (this.h == 0.0f) {
            this.h = this.f + ((this.b.getHeight() * 1.0f) / this.n);
        }
        float f = this.m / this.n;
        float f2 = this.e;
        float f3 = this.f;
        float f4 = ((f2 * 2.0f) * f) - f;
        float f5 = ((this.g * 2.0f) * f) - f;
        float f6 = ((f3 * 2.0f) - 1.0f) * (-1.0f);
        float f7 = ((this.h * 2.0f) - 1.0f) * (-1.0f);
        float[] fArr = this.i;
        fArr[0] = f4;
        fArr[1] = f7;
        fArr[2] = f4;
        fArr[3] = f6;
        fArr[4] = f5;
        fArr[5] = f7;
        fArr[6] = f5;
        fArr[7] = f6;
        Matrix.orthoM(this.p, 0, -f, f, -1.0f, 1.0f, -1.0f, 1.0f);
        float f8 = f4 + ((f5 - f4) / 2.0f);
        float f9 = f6 + ((f7 - f6) / 2.0f);
        Matrix.translateM(this.p, 0, f8, f9, 0.0f);
        Matrix.rotateM(this.p, 0, this.l, 0.0f, 0.0f, -1.0f);
        Matrix.translateM(this.p, 0, -f8, -f9, 0.0f);
    }

    public void b(float f, float f2) {
        this.e = f;
        this.f = f2;
    }

    @Override // a.a.a.a.a.b.i.h
    public String[] c() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex;\nuniform float u_alpha;\nvoid main() {\n    gl_FragColor = texture2D(u_tex, v_tex) * u_alpha;\n}\n"};
    }

    @Override // a.a.a.a.a.b.i.h
    public boolean d() {
        this.j = GLES20.glGetUniformLocation(this.o, "u_alpha");
        return true;
    }

    @Override // a.a.a.a.a.b.i.h
    public float[] e() {
        return this.i;
    }

    @Override // a.a.a.a.a.b.i.h
    public void f() {
        super.f();
        GLES20.glUniform1f(this.j, this.k);
    }

    @Override // a.a.a.a.a.b.i.h
    public float[] g() {
        return f1273a;
    }

    @Override // a.a.a.a.a.b.i.h
    public void h() {
        super.h();
        int i = this.f1274c;
        if (i != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            this.f1274c = 0;
        }
        int i2 = this.d;
        if (i2 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
            this.d = 0;
        }
    }
}
