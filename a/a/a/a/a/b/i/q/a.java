package a.a.a.a.a.b.i.q;

import a.a.a.a.a.a.h.f;
import a.a.a.a.a.b.i.c;
import a.a.a.a.a.b.i.e;
import android.opengl.GLES20;
import android.opengl.GLES30;
import com.qiniu.pili.droid.streaming.av.encoder.PLH264Encoder;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/q/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final FloatBuffer f1337a = f.a(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    public static final FloatBuffer b = f.a(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});

    /* renamed from: c  reason: collision with root package name */
    public final c f1338c;
    public final a.a.a.a.a.b.i.b d;
    public final int e;
    public final int f;
    public final int g;
    public int h;
    public final b i;
    public boolean j;
    public ByteBuffer k;
    public ByteBuffer l;

    public a() {
        b bVar = new b();
        this.i = bVar;
        this.j = false;
        bVar.a();
        this.f1338c = new c(6408);
        a.a.a.a.a.b.i.b bVar2 = new a.a.a.a.a.b.i.b("varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n", "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D oesTex;\nuniform vec2 xUnit;\nuniform vec4 coeffs;\n\nvoid main() {\n  gl_FragColor.r = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 1.5 * xUnit).rgb);\n  gl_FragColor.g = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc - 0.5 * xUnit).rgb);\n  gl_FragColor.b = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 0.5 * xUnit).rgb);\n  gl_FragColor.a = coeffs.a + dot(coeffs.rgb,\n      texture2D(oesTex, interp_tc + 1.5 * xUnit).rgb);\n}\n");
        this.d = bVar2;
        bVar2.a();
        this.e = this.d.b("texMatrix");
        this.f = this.d.b("xUnit");
        this.g = this.d.b("coeffs");
        GLES20.glUniform1i(this.d.b("oesTex"), 0);
        f.a("Initialize fragment shader uniform values.");
        this.d.a("in_pos", 2, f1337a);
        this.d.a("in_tc", 2, b);
    }

    public ByteBuffer a(int i, int i2, int i3) {
        int i4;
        int i5;
        this.i.a();
        if (this.j) {
            throw new IllegalStateException("YuvConverter.convert called on released object");
        }
        if (i2 % 8 == 0) {
            this.d.a();
            int i6 = (i2 + 7) / 8;
            int i7 = (i3 + 1) / 2;
            int i8 = i3 + i7;
            float[] a2 = e.a(f.f1239c, e.a());
            int i9 = i2 / 4;
            this.f1338c.a(i9, i8);
            GLES20.glBindFramebuffer(36160, this.f1338c.a());
            f.a("glBindFramebuffer");
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
            GLES20.glUniformMatrix4fv(this.e, 1, false, a2, 0);
            GLES20.glViewport(0, 0, (i2 + 3) / 4, i3);
            int i10 = this.f;
            float f = a2[0];
            float f2 = i2;
            GLES20.glUniform2f(i10, f / f2, a2[1] / f2);
            GLES20.glUniform4f(this.g, 0.299f, 0.587f, 0.114f, 0.0f);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glViewport(0, i3, i6, i7);
            GLES20.glUniform2f(this.f, (a2[0] * 2.0f) / f2, (a2[1] * 2.0f) / f2);
            GLES20.glUniform4f(this.g, -0.169f, -0.331f, 0.499f, 0.5f);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glViewport(i2 / 8, i3, i6, i7);
            GLES20.glUniform4f(this.g, 0.499f, -0.418f, -0.0813f, 0.5f);
            GLES20.glDrawArrays(5, 0, 4);
            if (f.b()) {
                if (this.h == 0) {
                    this.h = f.b(((i2 * i3) * 3) / 2);
                }
                GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, this.h);
                PLH264Encoder.getPixelFromPBO(0, 0, i9, i8, 6408, 5121, 0);
                this.k = (ByteBuffer) GLES30.glMapBufferRange(GLES30.GL_PIXEL_PACK_BUFFER, 0, ((i2 * i3) * 3) / 2, 1);
            } else {
                if (this.k == null) {
                    this.k = ByteBuffer.allocate(((i2 * i3) * 3) / 2);
                }
                this.k.clear();
                GLES20.glReadPixels(0, 0, i9, i8, 6408, 5121, this.k);
            }
            f.a("YuvConverter.convert");
            if (this.l == null) {
                this.l = ByteBuffer.allocate(((i2 * i3) * 3) / 2);
            }
            this.l.clear();
            ByteBuffer byteBuffer = this.k;
            if (byteBuffer != null) {
                byteBuffer.clear();
                this.k.position(0);
                this.k.limit(i2 * i3);
                this.l.put(this.k);
                int i11 = i3;
                while (true) {
                    int i12 = i11;
                    i4 = (i3 * 3) / 2;
                    if (i12 >= i4) {
                        break;
                    }
                    this.k.clear();
                    int i13 = i12 * i2;
                    this.k.position(i13);
                    this.k.limit(i13 + (i2 / 2));
                    this.l.put(this.k);
                    i11 = i12 + 1;
                }
                for (i5 = i3; i5 < i4; i5++) {
                    this.k.clear();
                    int i14 = i2 / 2;
                    int i15 = (i5 * i2) + i14;
                    this.k.position(i15);
                    this.k.limit(i15 + i14);
                    this.l.put(this.k);
                }
                this.l.clear();
            }
            if (f.b()) {
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
        this.f1338c.b();
    }
}
