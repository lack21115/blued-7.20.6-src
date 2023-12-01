package com.tencent.thumbplayer.g.e.a;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
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
    EGL10 f25652a;
    EGLDisplay b;

    /* renamed from: c  reason: collision with root package name */
    EGLContext f25653c;
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
        this.f25652a = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.b = eglGetDisplay;
        if (!this.f25652a.eglInitialize(eglGetDisplay, null)) {
            throw new RuntimeException("unable to initialize EGL10");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.f25652a.eglChooseConfig(this.b, new int[]{EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_SURFACE_TYPE, 1, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_NONE}, eGLConfigArr, 1, new int[1])) {
            throw new RuntimeException("unable to find RGB888+pbuffer EGL config");
        }
        this.f25653c = this.f25652a.eglCreateContext(this.b, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, EGL14.EGL_NONE});
        a("eglCreateContext");
        if (this.f25653c == null) {
            throw new RuntimeException("null context");
        }
        this.d = this.f25652a.eglCreatePbufferSurface(this.b, eGLConfigArr[0], new int[]{EGL14.EGL_WIDTH, i, EGL14.EGL_HEIGHT, i2, EGL14.EGL_NONE});
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
            int eglGetError = this.f25652a.eglGetError();
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
        EGL10 egl10 = this.f25652a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.f25653c)) {
                EGL10 egl102 = this.f25652a;
                EGLDisplay eGLDisplay = this.b;
                EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            }
            this.f25652a.eglDestroySurface(this.b, this.d);
            this.f25652a.eglDestroyContext(this.b, this.f25653c);
        }
        this.f.release();
        this.b = null;
        this.f25653c = null;
        this.d = null;
        this.f25652a = null;
        this.i = null;
        this.f = null;
        this.e = null;
    }

    public void c() {
        if (this.f25652a == null) {
            throw new RuntimeException("not configured for makeCurrent");
        }
        a("before makeCurrent");
        EGL10 egl10 = this.f25652a;
        EGLDisplay eGLDisplay = this.b;
        EGLSurface eGLSurface = this.d;
        if (!egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f25653c)) {
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
