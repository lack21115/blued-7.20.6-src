package a.a.a.a.a.b.i;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.qiniu.pili.droid.streaming.av.encoder.PLH264Encoder;
import java.nio.ByteBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/n.class */
public class n extends g {

    /* renamed from: a  reason: collision with root package name */
    public int f1283a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f1284c;
    public int d;
    public int q;
    public String r;

    public final boolean a(int i, int i2, int i3) {
        int b = a.a.a.a.a.a.h.f.b(i * i2 * i3);
        this.b = b;
        return b != 0;
    }

    public boolean a(int i, int i2, int i3, int i4, int i5, String str) {
        this.d = i3;
        this.q = i5;
        this.r = str;
        o();
        if (!a.a.a.a.a.a.h.f.b() || a(i, i2, i3)) {
            boolean z = false;
            if (super.a(i, i2)) {
                z = false;
                if (b(i, i2, i4)) {
                    z = true;
                }
            }
            return z;
        }
        return false;
    }

    @Override // a.a.a.a.a.b.i.g
    public void b(int i) {
        GLES20.glBindFramebuffer(36160, this.f1283a);
        GLES20.glFramebufferRenderbuffer(36160, 36064, 36161, this.f1284c);
        super.b(i);
        if (a.a.a.a.a.a.h.f.b()) {
            GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, this.b);
            PLH264Encoder.getPixelFromPBO(0, 0, this.e, this.f, this.q, 5121, 0);
        }
        GLES20.glBindFramebuffer(36160, 0);
    }

    public final boolean b(int i, int i2, int i3) {
        int a2 = a.a.a.a.a.a.h.f.a(i3, i, i2);
        this.f1284c = a2;
        return a2 != 0;
    }

    @Override // a.a.a.a.a.b.i.g
    public String[] b() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", this.r};
    }

    @Override // a.a.a.a.a.b.i.g
    public float[] e() {
        return k.f1280c;
    }

    @Override // a.a.a.a.a.b.i.g
    public void g() {
        super.g();
        int i = this.f1283a;
        if (i != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            this.f1283a = 0;
        }
        int i2 = this.b;
        if (i2 != 0) {
            GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
            this.b = 0;
        }
        int i3 = this.f1284c;
        if (i3 != 0) {
            GLES20.glDeleteRenderbuffers(1, new int[]{i3}, 0);
            this.f1284c = 0;
        }
    }

    public ByteBuffer m() {
        if (a.a.a.a.a.a.h.f.b()) {
            GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, this.b);
            return (ByteBuffer) GLES30.glMapBufferRange(GLES30.GL_PIXEL_PACK_BUFFER, 0, this.e * this.f * this.d, 1);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.e * this.f * this.d);
        GLES20.glBindFramebuffer(36160, this.f1283a);
        GLES20.glFramebufferRenderbuffer(36160, 36064, 36161, this.f1284c);
        GLES20.glReadPixels(0, 0, this.e, this.f, this.q, 5121, allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        return allocateDirect;
    }

    public void n() {
        if (a.a.a.a.a.a.h.f.b()) {
            GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, this.b);
            GLES30.glUnmapBuffer(GLES30.GL_PIXEL_PACK_BUFFER);
            GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, 0);
        }
    }

    public final void o() {
        this.f1283a = a.a.a.a.a.a.h.f.c();
    }
}
