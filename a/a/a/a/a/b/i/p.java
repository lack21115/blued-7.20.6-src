package a.a.a.a.a.b.i;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import java.nio.FloatBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/p.class */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public a.a.a.a.a.i.b.b f1335a;
    public FloatBuffer b;

    /* renamed from: c  reason: collision with root package name */
    public FloatBuffer f1336c;
    public WatermarkSetting d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;

    public void a() {
        a.a.a.a.a.i.b.b bVar = this.f1335a;
        if (bVar != null) {
            bVar.h();
            this.f1335a = null;
        }
        int i = this.e;
        if (i != 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.e = 0;
        }
        int i2 = this.n;
        if (i2 != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i2}, 0);
            this.n = 0;
        }
    }

    public void a(int i) {
        FloatBuffer floatBuffer;
        int i2;
        GLES20.glViewport(this.j, this.k, this.l, this.m);
        GLES20.glBindFramebuffer(36160, this.n);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        FloatBuffer floatBuffer2 = this.b;
        if (floatBuffer2 != null && (floatBuffer = this.f1336c) != null && (i2 = this.e) != 0) {
            this.f1335a.a(a.a.a.a.a.a.h.f.f1239c, floatBuffer2, 0, this.f, this.g, this.i, floatBuffer, i2, this.h);
        }
        GLES20.glBindFramebuffer(36160, 0);
    }

    public boolean a(int i, int i2, float f, float f2, float f3, float f4, WatermarkSetting watermarkSetting) {
        float f5 = i;
        this.l = (int) (f3 * f5);
        float f6 = i2;
        int i3 = (int) (f4 * f6);
        this.m = i3;
        this.j = (int) (f5 * f);
        this.k = ((int) (f6 * (1.0f - f2))) - i3;
        this.f1335a = new a.a.a.a.a.i.b.b(watermarkSetting.getAlpha());
        this.d = watermarkSetting;
        this.g = 2;
        this.i = 8;
        this.f = 4;
        this.h = 8;
        b();
        return d();
    }

    public boolean a(int i, int i2, WatermarkSetting watermarkSetting) {
        return a(i, i2, 0.0f, 0.0f, 1.0f, 1.0f, watermarkSetting);
    }

    public final void b() {
        this.n = a.a.a.a.a.a.h.f.c();
    }

    public final void c() {
        WatermarkSetting watermarkSetting = this.d;
        if (watermarkSetting == null) {
            a.a.a.a.a.e.e.f1361c.d("WatermarkSticker", "no settings for watermarkTexture");
            this.e = -1;
            return;
        }
        Bitmap watermarkBitmap = watermarkSetting.getWatermarkBitmap();
        if (watermarkBitmap == null) {
            a.a.a.a.a.e.e.f1361c.d("WatermarkSticker", "no resources for watermarkTexture");
            this.e = -1;
            return;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        a.a.a.a.a.a.h.f.b("glGenTextures");
        this.e = iArr[0];
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f1361c;
        eVar.c("WatermarkSticker", "prepare watermark Texture:" + this.e);
        GLES20.glBindTexture(3553, this.e);
        a.a.a.a.a.a.h.f.b("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6408, watermarkBitmap.getWidth(), watermarkBitmap.getHeight(), 0, 6408, 5121, a.a.a.a.a.i.b.b.a(watermarkBitmap));
        a.a.a.a.a.a.h.f.b("glTexImage2D");
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindTexture(3553, 0);
        if (watermarkBitmap.isRecycled()) {
            return;
        }
        watermarkBitmap.recycle();
    }

    public final boolean d() {
        c();
        this.b = a.a.a.a.a.i.b.b.a(this.d, this.l, this.m);
        FloatBuffer a2 = a.a.a.a.a.i.b.b.a();
        this.f1336c = a2;
        return (this.e == -1 || this.b == null || a2 == null) ? false : true;
    }
}
