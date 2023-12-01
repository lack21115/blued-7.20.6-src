package a.a.a.a.a.b.i;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/g.class */
public class g {
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public float[] l;
    public int m;
    public int n;
    public int o;
    public int p;

    public int a() {
        return 3553;
    }

    public void a(int i) {
        if (this.l == null) {
            this.l = new float[16];
        }
        this.g = i;
        Matrix.setIdentityM(this.l, 0);
        Matrix.rotateM(this.l, 0, i, 0.0f, 0.0f, -1.0f);
    }

    public void a(int i, float[] fArr) {
        GLES20.glUseProgram(this.h);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(a(), i);
        if (a.a.a.a.a.a.h.f.b()) {
            GLES30.glBindVertexArray(this.i);
        } else {
            k();
        }
        int i2 = this.o;
        float[] fArr2 = this.l;
        if (fArr2 == null) {
            fArr2 = a.a.a.a.a.a.h.f.f1191c;
        }
        GLES20.glUniformMatrix4fv(i2, 1, false, fArr2, 0);
        float[] fArr3 = fArr;
        if (fArr == null) {
            fArr3 = a.a.a.a.a.a.h.f.f1191c;
        }
        GLES20.glUniformMatrix4fv(this.p, 1, false, fArr3, 0);
        GLES20.glViewport(c(), d(), this.e, this.f);
        i();
        GLES20.glDrawArrays(5, 0, 4);
        if (a.a.a.a.a.a.h.f.b()) {
            GLES30.glBindVertexArray(0);
        }
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindTexture(a(), 0);
    }

    public boolean a(int i, int i2) {
        this.e = i;
        this.f = i2;
        return l() && h() && j();
    }

    public void b(int i) {
        a(i, (float[]) null);
    }

    public String[] b() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex);\n}\n"};
    }

    public int c() {
        return 0;
    }

    public int d() {
        return 0;
    }

    public float[] e() {
        return k.f1279a;
    }

    public float[] f() {
        return k.d;
    }

    public void g() {
        int i = this.h;
        if (i != 0) {
            GLES20.glDeleteProgram(i);
            this.h = 0;
        }
        int i2 = this.j;
        if (i2 != 0) {
            GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
            this.j = 0;
        }
        int i3 = this.k;
        if (i3 != 0) {
            GLES20.glDeleteBuffers(1, new int[]{i3}, 0);
            this.k = 0;
        }
        int i4 = this.i;
        if (i4 != 0) {
            GLES30.glDeleteVertexArrays(1, new int[]{i4}, 0);
            this.i = 0;
        }
    }

    public boolean h() {
        this.m = GLES20.glGetAttribLocation(this.h, "a_pos");
        this.n = GLES20.glGetAttribLocation(this.h, "a_tex");
        this.o = GLES20.glGetUniformLocation(this.h, "u_mvp");
        this.p = GLES20.glGetUniformLocation(this.h, "u_tex_trans");
        return a.a.a.a.a.a.h.f.b("TextureDrawer glBindAttribLocation");
    }

    public void i() {
    }

    public final boolean j() {
        float[] e = e();
        if (Math.abs(this.g) == 90 || Math.abs(this.g) == 270) {
            float f = e[4] - e[0];
            float f2 = e[3] - e[1];
            e[1] = e[3] - f;
            e[4] = e[0] + f2;
            e[5] = e[3] - f;
            e[6] = e[0] + f2;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(e.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(e);
        asFloatBuffer.rewind();
        float[] f3 = f();
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(f3.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(f3);
        asFloatBuffer2.rewind();
        int[] iArr = new int[2];
        GLES20.glGenBuffers(2, iArr, 0);
        int i = iArr[0];
        this.j = i;
        this.k = iArr[1];
        GLES20.glBindBuffer(34962, i);
        GLES20.glBufferData(34962, 32, asFloatBuffer, 35044);
        GLES20.glBindBuffer(34962, this.k);
        GLES20.glBufferData(34962, 32, asFloatBuffer2, 35044);
        GLES20.glBindBuffer(34962, 0);
        if (a.a.a.a.a.a.h.f.b()) {
            int d = a.a.a.a.a.a.h.f.d();
            this.i = d;
            GLES30.glBindVertexArray(d);
        }
        k();
        if (a.a.a.a.a.a.h.f.b()) {
            GLES30.glBindVertexArray(0);
        }
        GLES20.glBindBuffer(34962, 0);
        return a.a.a.a.a.a.h.f.b("TextureDrawer setup VAO, VBOs.");
    }

    public final void k() {
        GLES20.glBindBuffer(34962, this.j);
        GLES20.glEnableVertexAttribArray(this.m);
        GLES20.glVertexAttribPointer(this.m, 2, 5126, false, 0, 0);
        GLES20.glBindBuffer(34962, this.k);
        GLES20.glEnableVertexAttribArray(this.n);
        GLES20.glVertexAttribPointer(this.n, 2, 5126, false, 0, 0);
    }

    public final boolean l() {
        String[] b = b();
        boolean z = false;
        int a2 = a.a.a.a.a.a.h.f.a(b[0], b[1]);
        this.h = a2;
        if (a2 != 0) {
            z = true;
        }
        return z;
    }
}
