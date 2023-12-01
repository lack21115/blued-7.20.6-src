package a.a.a.a.a.b.i;

import android.opengl.GLES20;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/o.class */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public int f1285a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f1286c;
    public int d;
    public int e;
    public List<f> f = new ArrayList();

    public int a() {
        return this.f1285a;
    }

    public int a(int i, int i2) {
        if (this.f.size() <= i) {
            return 0;
        }
        GLES20.glBindFramebuffer(36160, this.f1286c);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.d, 0);
        b(i, i2);
        GLES20.glBindFramebuffer(36160, 0);
        return this.d;
    }

    public int a(int i, int i2, float f, float f2, float f3, float f4, PreviewAppearance.ScaleType scaleType) {
        float f5 = this.f1285a;
        int i3 = (int) (f5 * f3);
        float f6 = this.b;
        int i4 = (int) (f6 * f4);
        int i5 = (int) (f5 * f);
        int i6 = (int) (f6 * (1.0f - f2));
        f fVar = new f();
        fVar.a(i, i2, i5, i6 - i4, i3, i4, scaleType);
        fVar.a(this.e);
        this.f.add(fVar);
        return this.f.size() - 1;
    }

    public boolean a(int i, int i2, boolean z) {
        this.f1285a = i;
        this.b = i2;
        f();
        if (z) {
            return c(i, i2);
        }
        return true;
    }

    public int b() {
        return this.b;
    }

    public void b(int i, int i2) {
        if (this.f.size() <= i) {
            return;
        }
        GLES20.glClear(16384);
        this.f.get(i).b(i2);
    }

    public int c() {
        return this.f.size();
    }

    public final boolean c(int i, int i2) {
        this.d = a.a.a.a.a.a.h.f.a(null, i, i2, 6408);
        return true;
    }

    public void d() {
        this.f.clear();
    }

    public void e() {
        int i = this.f1286c;
        if (i != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
            this.f1286c = 0;
        }
        int i2 = this.d;
        if (i2 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
            this.d = 0;
        }
        Iterator<f> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().g();
            it.remove();
        }
    }

    public final void f() {
        this.f1286c = a.a.a.a.a.a.h.f.c();
    }
}
