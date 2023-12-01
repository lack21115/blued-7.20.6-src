package com.blued.android.module.external_sense_library.gl;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.blued.android.module.external_sense_library.contract.IGetBufferCallback;
import com.blued.android.module.external_sense_library.glutils.GlUtil;
import com.blued.android.module.external_sense_library.glutils.OpenGLUtils;
import com.blued.android.module.external_sense_library.glutils.TextureRotationUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;
import javax.microedition.khronos.opengles.GL11ExtensionPack;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/gl/TextureProcessor.class */
public class TextureProcessor {
    protected float[] a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float[] l = TextureRotationUtil.f;
    private volatile boolean m;
    private int n;
    private int o;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/gl/TextureProcessor$TextureType.class */
    public @interface TextureType {
    }

    public TextureProcessor(int i) {
        this.a = TextureRotationUtil.a;
        if (i == 1) {
            this.a = TextureRotationUtil.h;
        } else if (i != 2) {
            this.a = TextureRotationUtil.a;
        } else {
            this.a = TextureRotationUtil.c;
        }
    }

    private boolean b(int i, int i2) {
        int a = OpenGLUtils.a(i, i2);
        this.o = a;
        return a != 0;
    }

    private void d() {
        int i = this.d;
        if (i != 0) {
            GLES20.glDeleteProgram(i);
            this.d = 0;
        }
    }

    private void e() {
        int i = this.f;
        if (i != 0) {
            GLES20.glDeleteBuffers(1, new int[]{i}, 0);
            this.f = 0;
        }
        int i2 = this.g;
        if (i2 != 0) {
            GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
            this.g = 0;
        }
    }

    private void f() {
        int i = this.e;
        if (i != 0) {
            GLES30.glDeleteVertexArrays(1, new int[]{i}, 0);
            this.e = 0;
        }
    }

    private void g() {
        float[] l = l();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(l.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(l);
        asFloatBuffer.rewind();
        float[] m = m();
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(m.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        asFloatBuffer2.put(m);
        asFloatBuffer2.rewind();
        int[] iArr = new int[2];
        GLES20.glGenBuffers(2, iArr, 0);
        int i = iArr[0];
        this.f = i;
        this.g = iArr[1];
        GLES20.glBindBuffer(GL11.GL_ARRAY_BUFFER, i);
        GLES20.glBufferData(GL11.GL_ARRAY_BUFFER, 32, asFloatBuffer, GL11.GL_STATIC_DRAW);
        GLES20.glBindBuffer(GL11.GL_ARRAY_BUFFER, this.g);
        GLES20.glBufferData(GL11.GL_ARRAY_BUFFER, 32, asFloatBuffer2, GL11.GL_STATIC_DRAW);
        GLES20.glBindBuffer(GL11.GL_ARRAY_BUFFER, 0);
        h();
        GLES20.glBindBuffer(GL11.GL_ARRAY_BUFFER, 0);
    }

    private void h() {
        GLES20.glBindBuffer(GL11.GL_ARRAY_BUFFER, this.f);
        GLES20.glEnableVertexAttribArray(this.h);
        GLES20.glVertexAttribPointer(this.h, 2, (int) GL10.GL_FLOAT, false, 0, 0);
        GLES20.glBindBuffer(GL11.GL_ARRAY_BUFFER, this.g);
        GLES20.glEnableVertexAttribArray(this.i);
        GLES20.glVertexAttribPointer(this.i, 2, (int) GL10.GL_FLOAT, false, 0, 0);
    }

    private boolean i() {
        String[] o = o();
        boolean z = false;
        int a = OpenGLUtils.a(o[0], o[1]);
        this.d = a;
        if (a != 0) {
            z = true;
        }
        return z;
    }

    private void j() {
        this.n = GlUtil.a();
    }

    private void k() {
        int i = this.o;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.o = 0;
        }
    }

    private float[] l() {
        return this.l;
    }

    private float[] m() {
        return this.a;
    }

    private int n() {
        return GL10.GL_TEXTURE_2D;
    }

    private String[] o() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n"};
    }

    public int a(int i) {
        return a(i, (IGetBufferCallback) null);
    }

    public int a(int i, IGetBufferCallback iGetBufferCallback) {
        GLES20.glBindFramebuffer(GL11ExtensionPack.GL_FRAMEBUFFER_OES, this.n);
        GLES20.glFramebufferTexture2D(GL11ExtensionPack.GL_FRAMEBUFFER_OES, GL11ExtensionPack.GL_COLOR_ATTACHMENT0_OES, GL10.GL_TEXTURE_2D, this.o, 0);
        GLES20.glClear(16384);
        GLES20.glUseProgram(this.d);
        GLES20.glActiveTexture(GL10.GL_TEXTURE0);
        GLES20.glBindTexture(n(), i);
        h();
        GLES20.glUniformMatrix4fv(this.j, 1, false, GlUtil.a, 0);
        GLES20.glUniformMatrix4fv(this.k, 1, false, GlUtil.a, 0);
        GLES20.glViewport(0, 0, this.b, this.c);
        GLES20.glDrawArrays(5, 0, 4);
        if (this.a == TextureRotationUtil.a) {
            int i2 = this.b;
            int i3 = this.c;
            int i4 = i2 * i3 * 4;
            byte[] bArr = new byte[i4];
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i2 * i3 * 4);
            allocateDirect.position(0);
            GLES20.glReadPixels(0, 0, this.b, this.c, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, allocateDirect);
            allocateDirect.get(bArr, 0, i4);
            byte[] a = GlUtil.a(bArr, this.b, this.c);
            if (iGetBufferCallback != null) {
                iGetBufferCallback.readBuffer(a);
            }
        }
        GLES20.glBindBuffer(GL11.GL_ARRAY_BUFFER, 0);
        GLES20.glBindTexture(n(), 0);
        GLES20.glBindFramebuffer(GL11ExtensionPack.GL_FRAMEBUFFER_OES, 0);
        return this.o;
    }

    public boolean a() {
        if (i()) {
            c();
            g();
            j();
            this.m = true;
            return true;
        }
        return false;
    }

    public boolean a(int i, int i2) {
        this.b = i;
        this.c = i2;
        k();
        b(i, i2);
        return true;
    }

    public void b() {
        this.m = false;
        int i = this.n;
        if (i != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            this.n = 0;
        }
        k();
        d();
        e();
        f();
    }

    protected void c() {
        this.h = GLES20.glGetAttribLocation(this.d, "a_pos");
        this.i = GLES20.glGetAttribLocation(this.d, "a_tex");
        this.j = GLES20.glGetUniformLocation(this.d, "u_mvp");
        this.k = GLES20.glGetUniformLocation(this.d, "u_tex_trans");
    }
}
