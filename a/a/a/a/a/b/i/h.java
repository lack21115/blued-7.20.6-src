package a.a.a.a.a.b.i;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/h.class */
public abstract class h {
    public int m;
    public int n;
    public int o;
    public float[] p;
    public int q;
    public int r;
    public int s;
    public int t;
    public FloatBuffer u;
    public FloatBuffer v;

    public void a(int i, float[] fArr) {
        GLES20.glUseProgram(this.o);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        int i2 = this.s;
        float[] fArr2 = this.p;
        float[] fArr3 = fArr2;
        if (fArr2 == null) {
            fArr3 = a.a.a.a.a.a.h.f.f1191c;
        }
        GLES20.glUniformMatrix4fv(i2, 1, false, fArr3, 0);
        int i3 = this.t;
        float[] fArr4 = fArr;
        if (fArr == null) {
            fArr4 = a.a.a.a.a.a.h.f.f1191c;
        }
        GLES20.glUniformMatrix4fv(i3, 1, false, fArr4, 0);
        GLES20.glViewport(0, 0, this.m, this.n);
        this.u.put(e());
        this.u.rewind();
        GLES20.glEnableVertexAttribArray(this.q);
        GLES20.glVertexAttribPointer(this.q, 2, 5126, false, 0, (Buffer) this.u);
        GLES20.glEnableVertexAttribArray(this.r);
        GLES20.glVertexAttribPointer(this.r, 2, 5126, false, 0, (Buffer) this.v);
        f();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, 0);
    }

    public boolean a() {
        String[] c2 = c();
        int a2 = a.a.a.a.a.a.h.f.a(c2[0], c2[1]);
        this.o = a2;
        this.q = GLES20.glGetAttribLocation(a2, "a_pos");
        this.r = GLES20.glGetAttribLocation(this.o, "a_tex");
        this.s = GLES20.glGetUniformLocation(this.o, "u_mvp");
        this.t = GLES20.glGetUniformLocation(this.o, "u_tex_trans");
        d();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.u = allocateDirect.asFloatBuffer();
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect2.asFloatBuffer();
        this.v = asFloatBuffer;
        asFloatBuffer.put(g());
        this.v.rewind();
        return true;
    }

    public boolean a(int i, int i2) {
        this.m = i;
        this.n = i2;
        return true;
    }

    public void c(int i) {
        a(i, (float[]) null);
    }

    public abstract String[] c();

    public abstract boolean d();

    public abstract float[] e();

    public void f() {
    }

    public abstract float[] g();

    public void h() {
        int i = this.o;
        if (i != 0) {
            GLES20.glDeleteProgram(i);
            this.o = 0;
        }
    }
}
