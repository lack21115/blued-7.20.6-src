package com.tencent.thumbplayer.g.e.a;

import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import com.tencent.thumbplayer.g.c.b;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/e/a/a.class */
public class a implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    EGL10 f39343a;
    EGLDisplay b;

    /* renamed from: c  reason: collision with root package name */
    EGLContext f39344c;
    EGLSurface d;
    com.tencent.thumbplayer.g.c.b e;
    Surface f;
    Object g = new Object();
    boolean h;
    b i;

    public a() {
        a();
    }

    public a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        a(i, i2);
        c();
        a();
    }

    void a() {
        b bVar = new b();
        this.i = bVar;
        bVar.b();
        com.tencent.thumbplayer.g.c.b bVar2 = new com.tencent.thumbplayer.g.c.b(this.i.a());
        this.e = bVar2;
        bVar2.a(new b.a() { // from class: com.tencent.thumbplayer.g.e.a.a.1
            @Override // com.tencent.thumbplayer.g.c.b.a
            public void a() {
                com.tencent.thumbplayer.g.h.b.b("OutputSurface", "mSurfaceTexture:" + a.this.e + " onReleased, release OutputSurface");
                a.this.b();
            }
        });
        this.e.setOnFrameAvailableListener(this);
        this.f = new com.tencent.thumbplayer.g.c.a(this.e);
    }

    void a(int i, int i2) {
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f39343a = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.b = eglGetDisplay;
        if (!this.f39343a.eglInitialize(eglGetDisplay, null)) {
            throw new RuntimeException("unable to initialize EGL10");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.f39343a.eglChooseConfig(this.b, new int[]{12324, 8, 12323, 8, 12322, 8, 12339, 1, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        this.f39344c = this.f39343a.eglCreateContext(this.b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        a("eglCreateContext");
        if (this.f39344c == null) {
            throw new RuntimeException("null context");
        }
        this.d = this.f39343a.eglCreatePbufferSurface(this.b, eGLConfigArr[0], new int[]{12375, i, 12374, i2, 12344});
        a("eglCreatePbufferSurface");
        if (this.d == null) {
            throw new RuntimeException("surface was null");
        }
    }

    void a(String str) {
        boolean z;
        boolean z2 = false;
        while (true) {
            z = z2;
            int eglGetError = this.f39343a.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Log.e("OutputSurface", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z2 = true;
        }
        if (z) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    public void b() {
        EGL10 egl10 = this.f39343a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.f39344c)) {
                EGL10 egl102 = this.f39343a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.f39343a.eglDestroySurface(this.b, this.d);
            this.f39343a.eglDestroyContext(this.b, this.f39344c);
        }
        this.f.release();
        this.b = null;
        this.f39344c = null;
        this.d = null;
        this.f39343a = null;
        this.i = null;
        this.f = null;
        this.e = null;
    }

    public void c() {
        if (this.f39343a == null) {
            throw new RuntimeException("not configured for makeCurrent");
        }
        a("before makeCurrent");
        EGL10 egl10 = this.f39343a;
        EGLDisplay eGLDisplay = this.b;
        EGLSurface eGLSurface = this.d;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f39344c)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public Surface d() {
        return this.f;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.g) {
            if (this.h) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.h = true;
            this.g.notifyAll();
        }
    }
}
