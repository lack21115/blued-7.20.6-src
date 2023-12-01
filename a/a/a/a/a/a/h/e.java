package a.a.a.a.a.a.h;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/h/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static int f1236a = 12375;
    public static int b = 12374;

    /* renamed from: c  reason: collision with root package name */
    public d f1237c;
    public Object d = null;
    public int e = -1;
    public int f = -1;

    public e(d dVar) {
        this.f1237c = dVar;
    }

    public int a() {
        int i = this.e;
        int i2 = i;
        if (i < 0) {
            i2 = this.f1237c.a(this.d, f1236a);
        }
        return i2;
    }

    public void a(int i, int i2) {
        if (this.d != null) {
            throw new IllegalStateException("surface already created");
        }
        this.d = this.f1237c.a(i, i2);
        this.e = i;
        this.f = i2;
    }

    public void a(long j) {
        this.f1237c.a(this.d, j);
    }

    public void a(Object obj) {
        if (this.d != null) {
            throw new IllegalStateException("surface already created");
        }
        this.d = this.f1237c.b(obj);
    }

    public int b() {
        int i = this.f;
        int i2 = i;
        if (i < 0) {
            i2 = this.f1237c.a(this.d, b);
        }
        return i2;
    }

    public void c() {
        this.f1237c.a(this.d);
        this.d = null;
        this.f = -1;
        this.e = -1;
    }

    public void d() {
        this.f1237c.c(this.d);
    }

    public boolean e() {
        boolean d = this.f1237c.d(this.d);
        if (!d) {
            a.a.a.a.a.e.e.f1361c.b("GlUtil", "WARNING: swapBuffers() failed");
        }
        return d;
    }

    public Bitmap f() {
        if (this.f1237c.e(this.d)) {
            int a2 = a();
            int b2 = b();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(a2 * b2 * 4);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            GLES20.glReadPixels(0, 0, a2, b2, 6408, 5121, allocateDirect);
            f.b("glReadPixels");
            allocateDirect.rewind();
            Bitmap createBitmap = Bitmap.createBitmap(a2, b2, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(allocateDirect);
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f1361c;
            eVar.b("GlUtil", "captured " + a2 + "x" + b2);
            return createBitmap;
        }
        throw new RuntimeException("Expected EGL context/surface is not current");
    }
}
