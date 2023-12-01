package com.qiniu.pili.droid.shortvideo.gl.texread;

import android.opengl.GLES20;
import android.opengl.GLES30;
import com.qiniu.pili.droid.shortvideo.gl.texread.e;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/texread/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final FloatBuffer f27728a = GlUtil.a(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private FloatBuffer b = GlUtil.a(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});

    /* renamed from: c  reason: collision with root package name */
    private final b f27729c;
    private final a d;
    private final int e;
    private final int f;
    private final int g;
    private int h;
    private final e.a i;
    private boolean j;
    private ByteBuffer k;
    private ByteBuffer l;
    private int m;
    private int n;
    private int o;
    private int p;

    public d(int i, int i2) {
        e.a aVar = new e.a();
        this.i = aVar;
        this.j = false;
        this.m = i;
        this.o = i;
        this.n = i2;
        this.p = i2;
        aVar.a();
        this.f27729c = new b(6408);
        a aVar2 = new a("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n", "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D oesTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 1.5 * xUnit).rgb);\n}\n");
        this.d = aVar2;
        aVar2.a();
        this.e = this.d.b("texMatrix");
        this.f = this.d.b("xUnit");
        this.g = this.d.b("coeffs");
        GLES20.glUniform1i(this.d.b("oesTex"), 0);
        GlUtil.a("Initialize fragment shader uniform values.");
    }

    public ByteBuffer a(int i) {
        int i2;
        int i3;
        this.i.a();
        if (this.j) {
            throw new IllegalStateException("YuvReader.read called on released object");
        }
        int i4 = this.o;
        if (i4 % 8 == 0) {
            this.d.a();
            this.d.a("in_pos", 2, f27728a);
            this.d.a("in_tc", 2, this.b);
            int i5 = this.o;
            int i6 = (i5 + 3) / 4;
            int i7 = (i5 + 7) / 8;
            int i8 = this.p;
            int i9 = (i8 + 1) / 2;
            int i10 = i8 + i9;
            float[] a2 = c.a(GlUtil.f27722a, c.a());
            int i11 = i4 / 4;
            this.f27729c.a(i11, i10);
            GLES20.glBindFramebuffer(36160, this.f27729c.a());
            GlUtil.a("glBindFramebuffer");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniformMatrix4fv(this.e, 1, false, a2, 0);
            GLES20.glViewport(0, 0, i6, this.p);
            int i12 = this.f;
            float f = a2[0];
            int i13 = this.o;
            GLES20.glUniform2f(i12, f / i13, a2[1] / i13);
            GLES20.glUniform4f(this.g, 0.299f, 0.587f, 0.114f, 0.0f);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glViewport(0, this.p, i7, i9);
            int i14 = this.f;
            float f2 = a2[0];
            int i15 = this.o;
            GLES20.glUniform2f(i14, (f2 * 2.0f) / i15, (a2[1] * 2.0f) / i15);
            GLES20.glUniform4f(this.g, -0.169f, -0.331f, 0.499f, 0.5f);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glViewport(i4 / 8, this.p, i7, i9);
            GLES20.glUniform4f(this.g, 0.499f, -0.418f, -0.0813f, 0.5f);
            GLES20.glDrawArrays(5, 0, 4);
            if (GlUtil.a()) {
                if (this.h == 0) {
                    this.h = GlUtil.b(((this.o * this.p) * 3) / 2);
                }
                GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, this.h);
                GlUtil.read(0, 0, i11, i10, 6408, 5121, 0);
                this.k = (ByteBuffer) GLES30.glMapBufferRange(GLES30.GL_PIXEL_PACK_BUFFER, 0, ((this.o * this.p) * 3) / 2, 1);
            } else {
                if (this.k == null) {
                    this.k = ByteBuffer.allocate(((this.o * this.p) * 3) / 2);
                }
                this.k.clear();
                GLES20.glReadPixels(0, 0, i11, i10, 6408, 5121, this.k);
            }
            GlUtil.a("YuvReader.read");
            if (this.l == null) {
                this.l = ByteBuffer.allocate(((this.o * this.p) * 3) / 2);
            }
            this.l.clear();
            ByteBuffer byteBuffer = this.k;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.k.position(0);
                this.k.limit(this.o * this.p);
                this.l.put(this.k);
                int i16 = this.p;
                while (true) {
                    int i17 = i16;
                    i2 = this.p;
                    if (i17 >= (i2 * 3) / 2) {
                        break;
                    }
                    this.k.clear();
                    int i18 = i17 * i4;
                    this.k.position(i18);
                    this.k.limit(i18 + (i4 / 2));
                    this.l.put(this.k);
                    i16 = i17 + 1;
                }
                for (i3 = i2; i3 < (this.p * 3) / 2; i3++) {
                    this.k.clear();
                    int i19 = i4 / 2;
                    int i20 = (i3 * i4) + i19;
                    this.k.position(i20);
                    this.k.limit(i20 + i19);
                    this.l.put(this.k);
                }
                this.l.clear();
            }
            if (GlUtil.a()) {
                GLES30.glUnmapBuffer(GLES30.GL_PIXEL_PACK_BUFFER);
                GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, 0);
            }
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glBindTexture(3553, 0);
            return this.l;
        }
        throw new IllegalArgumentException("Invalid stride, must be a multiple of 8");
    }

    public void a() {
        this.i.a();
        this.j = true;
        this.d.b();
        this.f27729c.b();
    }
}
