package com.tencent.mapsdk.internal;

import android.opengl.EGL14;
import android.opengl.GLUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xi.class */
public class xi extends Thread {
    private static float p = 60.0f;
    private static final int q = 12440;
    private static final int r = 4;
    private static int s = 2000;
    private static long t = 1500;
    private static final String u = "TextureGLRenderThread";
    private WeakReference<yi> b;
    private WeakReference<Object> e;
    private EGL10 h;
    private GL l;
    private long m;

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f24427c = new AtomicBoolean(true);
    private AtomicBoolean d = new AtomicBoolean(false);
    private volatile boolean f = false;
    private EGLConfig g = null;
    private EGLDisplay i = EGL10.EGL_NO_DISPLAY;
    private EGLContext j = EGL10.EGL_NO_CONTEXT;
    private EGLSurface k = EGL10.EGL_NO_SURFACE;
    private volatile long n = 0;
    private boolean o = false;

    public xi(yi yiVar) {
        this.b = new WeakReference<>(yiVar);
        setName(hj.c("TR"));
    }

    private boolean a() {
        try {
            WeakReference<Object> weakReference = this.e;
            if (weakReference == null || weakReference.get() == null) {
                return false;
            }
            Object obj = this.e.get();
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.h = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.i = eglGetDisplay;
            if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
                na.g(u, "eglGetdisplay failed,mEglDisplay == EGL10.EGL_NO_DISPLAY,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
                return false;
            } else if (!this.h.eglInitialize(eglGetDisplay, new int[2])) {
                na.g(u, "eglInitialize failed,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
                return false;
            } else {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (!this.h.eglChooseConfig(this.i, new int[]{EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_ALPHA_SIZE, 8, EGL14.EGL_DEPTH_SIZE, 16, EGL14.EGL_STENCIL_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_NONE}, eGLConfigArr, 1, new int[1])) {
                    na.g(u, "eglChooseConfig failed,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
                    return false;
                }
                EGLConfig eGLConfig = eGLConfigArr[0];
                this.g = eGLConfig;
                EGLSurface eglCreateWindowSurface = this.h.eglCreateWindowSurface(this.i, eGLConfig, obj, null);
                this.k = eglCreateWindowSurface;
                if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                    na.g(u, "eglCreateWindowSurface failed,mEglSurface == EGL10.EGL_NO_SURFACE,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
                    return false;
                }
                EGLContext eglCreateContext = this.h.eglCreateContext(this.i, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, EGL14.EGL_NONE});
                this.j = eglCreateContext;
                if (eglCreateContext == EGL10.EGL_NO_CONTEXT) {
                    na.g(u, "eglCreateContext failed,mEglContext == EGL10.EGL_NO_CONTEXT,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
                    return false;
                }
                EGL10 egl102 = this.h;
                EGLDisplay eGLDisplay = this.i;
                EGLSurface eGLSurface = this.k;
                if (egl102.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eglCreateContext)) {
                    this.l = this.j.getGL();
                    return true;
                }
                na.g(u, "eglMakeCurrent failed,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
                return false;
            }
        } catch (Throwable th) {
            na.g(u, "initializeGLContext failed,errorDetail:" + Log.getStackTraceString(th));
            return true;
        }
    }

    private void b() {
        d();
        c();
        i();
    }

    private void c() {
        EGLContext eGLContext = this.j;
        if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
            na.g(ma.l, "the EglContext is null or status is EGL_NO_CONTEXT");
            return;
        }
        this.h.eglDestroyContext(this.i, eGLContext);
        this.j = EGL10.EGL_NO_CONTEXT;
    }

    private void d() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.k;
        if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            na.g(ma.l, "the EglSurface is null or status is EGL_NO_SURFACE");
            return;
        }
        this.h.eglMakeCurrent(this.i, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.h.eglDestroySurface(this.i, this.k);
        this.k = EGL10.EGL_NO_SURFACE;
    }

    private void i() {
        EGLDisplay eGLDisplay = this.i;
        if (eGLDisplay == null || eGLDisplay == EGL10.EGL_NO_DISPLAY) {
            na.g(ma.l, "the EglDisplay is null or status is EGL_NO_DISPLAY");
            return;
        }
        this.h.eglTerminate(eGLDisplay);
        this.i = EGL10.EGL_NO_DISPLAY;
    }

    private void j() {
        WeakReference<Object> weakReference;
        while (this.f24427c.get() && !this.d.get() && System.currentTimeMillis() - this.m <= s) {
            d();
            try {
                weakReference = this.e;
            } catch (Throwable th) {
                na.g(u, "updateSurface failed,errorDetail:" + Log.getStackTraceString(th));
            }
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            EGLSurface eglCreateWindowSurface = this.h.eglCreateWindowSurface(this.i, this.g, this.e.get(), null);
            this.k = eglCreateWindowSurface;
            if (eglCreateWindowSurface == EGL10.EGL_NO_SURFACE) {
                na.g(u, "eglCreateWindowSurface failed,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
            } else if (this.h.eglMakeCurrent(this.i, eglCreateWindowSurface, eglCreateWindowSurface, this.j)) {
                return;
            } else {
                na.g(u, "eglMakeCurrent failed,errorDetail:" + GLUtils.getEGLErrorString(this.h.eglGetError()));
            }
        }
    }

    public void a(float f) {
        if (f <= 0.0f) {
            na.b(ma.l, "帧率设置不在有效值范围内");
        } else {
            p = f;
        }
    }

    public void a(Object obj) {
        WeakReference<Object> weakReference = this.e;
        if (weakReference != null && weakReference.get() != null) {
            this.f = true;
        }
        this.e = new WeakReference<>(obj);
        synchronized (this) {
            notifyAll();
        }
    }

    public void e() {
        this.f24427c.set(false);
        this.d.set(false);
        synchronized (this) {
            notifyAll();
        }
        interrupt();
    }

    public void f() {
        this.d.set(true);
        synchronized (this) {
            notifyAll();
        }
    }

    public void g() {
        this.d.set(false);
        synchronized (this) {
            notifyAll();
        }
    }

    public void h() {
        this.o = true;
        this.n = System.currentTimeMillis();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        WeakReference<Object> weakReference;
        super.run();
        WeakReference<yi> weakReference2 = this.b;
        if (weakReference2 != null && weakReference2.get() != null) {
            this.b.get().g();
        }
        boolean z = false;
        while (this.f24427c.get()) {
            while (this.f24427c.get() && ((weakReference = this.e) == null || weakReference.get() == null)) {
                synchronized (this) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            boolean z2 = z;
            if (!z) {
                z2 = a();
            }
            if (z2) {
                try {
                    synchronized (this) {
                        while (this.f24427c.get() && this.d.get()) {
                            wait();
                        }
                    }
                    if (this.f) {
                        this.m = System.currentTimeMillis();
                        j();
                        this.o = true;
                        this.f = false;
                        h();
                    }
                    WeakReference<yi> weakReference3 = this.b;
                    z = z2;
                    if (weakReference3 != null) {
                        z = z2;
                        if (weakReference3.get() != null) {
                            yi yiVar = this.b.get();
                            if (!this.o || System.currentTimeMillis() - this.n >= t) {
                                this.o = false;
                                this.n = 0L;
                            } else if (yiVar != null) {
                                yiVar.h();
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            if (yiVar != null && yiVar.a((GL10) this.l)) {
                                this.h.eglSwapBuffers(this.i, this.k);
                            }
                            int currentTimeMillis2 = (int) ((1000.0f / p) - ((float) (System.currentTimeMillis() - currentTimeMillis)));
                            z = z2;
                            if (currentTimeMillis2 > 0) {
                                synchronized (this) {
                                    try {
                                        wait(currentTimeMillis2);
                                    } catch (InterruptedException e2) {
                                    }
                                }
                                z = z2;
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (!this.f24427c.get()) {
                        z = z2;
                        if (!(th instanceof InterruptedException)) {
                        }
                    }
                    na.g(u, "TextureGLRenderThread Render Exception:" + Log.getStackTraceString(th));
                    z = z2;
                }
            } else {
                z = z2;
            }
        }
        WeakReference<yi> weakReference4 = this.b;
        if (weakReference4 != null && weakReference4.get() != null) {
            this.b.get().p();
            this.b = null;
        }
        b();
    }
}
