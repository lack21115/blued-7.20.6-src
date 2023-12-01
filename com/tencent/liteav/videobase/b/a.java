package com.tencent.liteav.videobase.b;

import android.opengl.EGL14;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/b/a.class */
public final class a implements h<EGLContext> {
    private static final int[] i = {EGL14.EGL_SURFACE_TYPE, 1, EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_ALPHA_SIZE, 8, EGL14.EGL_DEPTH_SIZE, 0, EGL14.EGL_STENCIL_SIZE, 0, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_NONE};
    private static final int[] j = {EGL14.EGL_SURFACE_TYPE, 4, EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_ALPHA_SIZE, 8, EGL14.EGL_DEPTH_SIZE, 0, EGL14.EGL_STENCIL_SIZE, 0, EGL14.EGL_RENDERABLE_TYPE, 4, 12610, 1, EGL14.EGL_NONE};
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22897c;
    private EGL10 g;
    private EGLConfig h;
    private EGLDisplay d = EGL10.EGL_NO_DISPLAY;
    private EGLContext e = EGL10.EGL_NO_CONTEXT;
    private EGLSurface f = EGL10.EGL_NO_SURFACE;

    /* renamed from: a  reason: collision with root package name */
    private final String f22896a = "EGL10Helper@" + hashCode();

    private a(int i2, int i3) {
        this.b = i2;
        this.f22897c = i3;
    }

    public static a a(EGLContext eGLContext, Surface surface, int i2, int i3) throws g {
        int i4;
        a aVar = new a(i2, i3);
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            aVar.g = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            aVar.d = eglGetDisplay;
            aVar.g.eglInitialize(eglGetDisplay, new int[2]);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            aVar.g.eglChooseConfig(aVar.d, surface == null ? i : j, eGLConfigArr, 1, new int[1]);
            aVar.h = eGLConfigArr[0];
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                try {
                    aVar.e = aVar.a(aVar.d, aVar.h, 2, eGLContext);
                } catch (g e) {
                    LiteavLog.i(aVar.f22896a, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                    aVar.e = aVar.a(aVar.d, aVar.h, 3, eGLContext);
                    i4 = 3;
                }
            } else {
                aVar.e = aVar.a(aVar.d, aVar.h, 2, eGLContext);
            }
            i4 = 2;
            LiteavLog.i(aVar.f22896a, "create eglContext " + aVar.e + " sharedContext: " + eGLContext + " version:" + i4);
            if (surface == null) {
                aVar.f = aVar.g.eglCreatePbufferSurface(aVar.d, aVar.h, new int[]{EGL14.EGL_WIDTH, aVar.b, EGL14.EGL_HEIGHT, aVar.f22897c, EGL14.EGL_NONE});
            } else {
                try {
                    aVar.f = aVar.g.eglCreateWindowSurface(aVar.d, aVar.h, surface, null);
                } catch (Exception e2) {
                    throw new g(aVar.g.eglGetError(), "", e2);
                }
            }
            if (aVar.f == EGL10.EGL_NO_SURFACE) {
                aVar.g();
            }
            if (aVar.g.eglMakeCurrent(aVar.d, aVar.f, aVar.f, aVar.e)) {
                return aVar;
            }
            aVar.g();
            return aVar;
        } catch (g e3) {
            aVar.c();
            throw e3;
        }
    }

    private EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, EGLContext eGLContext) throws g {
        EGLContext eGLContext2 = eGLContext;
        if (eGLContext == null) {
            eGLContext2 = EGL10.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = this.g.eglCreateContext(eGLDisplay, eGLConfig, eGLContext2, new int[]{12440, i2, EGL14.EGL_NONE});
        g();
        return eglCreateContext;
    }

    private void f() throws g {
        if (this.f != EGL10.EGL_NO_SURFACE) {
            d();
            if (!this.g.eglDestroySurface(this.d, this.f)) {
                g();
            }
            this.f = EGL10.EGL_NO_SURFACE;
        }
    }

    private void g() throws g {
        int eglGetError = this.g.eglGetError();
        if (eglGetError != 12288) {
            throw new g(eglGetError);
        }
    }

    @Override // com.tencent.liteav.videobase.b.h
    public final void a() throws g {
        GLES20.glFinish();
        if (this.g.eglSwapBuffers(this.d, this.f)) {
            return;
        }
        g();
    }

    @Override // com.tencent.liteav.videobase.b.h
    public final void b() throws g {
        EGL10 egl10 = this.g;
        EGLDisplay eGLDisplay = this.d;
        EGLSurface eGLSurface = this.f;
        if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.e)) {
            return;
        }
        g();
    }

    @Override // com.tencent.liteav.videobase.b.h
    public final void c() throws g {
        if (this.d != EGL10.EGL_NO_DISPLAY) {
            d();
            f();
            if (this.e != EGL10.EGL_NO_CONTEXT) {
                String str = this.f22896a;
                LiteavLog.i(str, "destroy eglContext " + this.e);
                this.g.eglDestroyContext(this.d, this.e);
                this.e = EGL10.EGL_NO_CONTEXT;
            }
            this.g.eglTerminate(this.d);
        }
        this.d = EGL10.EGL_NO_DISPLAY;
    }

    @Override // com.tencent.liteav.videobase.b.h
    public final void d() {
        if (this.d != EGL10.EGL_NO_DISPLAY) {
            EGL10 egl10 = this.g;
            EGLDisplay eGLDisplay = this.d;
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        }
    }

    @Override // com.tencent.liteav.videobase.b.h
    public final /* bridge */ /* synthetic */ EGLContext e() {
        return this.e;
    }
}
