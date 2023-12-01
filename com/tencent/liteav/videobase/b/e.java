package com.tencent.liteav.videobase.b;

import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.j;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/b/e.class */
public final class e {
    private static final j b = new j();

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicInteger f36594c = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    public h<?> f36595a;
    private boolean d = false;

    public static void a(e eVar) {
        if (eVar == null) {
            return;
        }
        eVar.b();
        Runnable a2 = f.a(eVar);
        if (eVar.d) {
            b.a(a2, 100L);
        } else {
            a2.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(e eVar) {
        try {
            if (eVar.f36595a != null) {
                eVar.f36595a.c();
                eVar.f36595a = null;
            }
            f36594c.decrementAndGet();
            LiteavLog.i("EGLCore", "EGLCore destroy success. ".concat(String.valueOf(eVar)));
        } catch (g e) {
            LiteavLog.e("EGLCore", "EGLCore destroy failed.", e);
        }
    }

    public final void a() throws g {
        h<?> hVar = this.f36595a;
        if (hVar != null) {
            hVar.b();
        }
    }

    public final void a(Object obj, Surface surface, int i, int i2) throws g {
        this.d = surface == null;
        if (obj == null) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
                this.f36595a = b.a((EGLContext) null, surface, i, i2);
            } else {
                this.f36595a = a.a((javax.microedition.khronos.egl.EGLContext) null, surface, i, i2);
            }
        } else if (obj instanceof javax.microedition.khronos.egl.EGLContext) {
            this.f36595a = a.a((javax.microedition.khronos.egl.EGLContext) obj, surface, i, i2);
        } else if (LiteavSystemInfo.getSystemOSVersionInt() < 17 || !(obj instanceof EGLContext)) {
            throw new g(0, "sharedContext isn't EGLContext");
        } else {
            this.f36595a = b.a((EGLContext) obj, surface, i, i2);
        }
        f36594c.incrementAndGet();
        LiteavLog.i("EGLCore", "EGLCore created in thread " + Thread.currentThread().getId() + ", sharedContext: " + obj + ", Surface: " + surface + ", width: " + i + ", height:" + i2);
    }

    public final void b() {
        h<?> hVar = this.f36595a;
        if (hVar != null) {
            hVar.d();
        }
    }

    public final void c() throws g {
        h<?> hVar = this.f36595a;
        if (hVar != null) {
            hVar.a();
        }
    }

    public final Object d() {
        h<?> hVar = this.f36595a;
        if (hVar == null) {
            return null;
        }
        return hVar.e();
    }
}
