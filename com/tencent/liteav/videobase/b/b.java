package com.tencent.liteav.videobase.b;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/b/b.class */
public final class b implements h<EGLContext> {
    private static final int[] h = {EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_ALPHA_SIZE, 8, EGL14.EGL_DEPTH_SIZE, 0, EGL14.EGL_STENCIL_SIZE, 0, EGL14.EGL_RENDERABLE_TYPE, 4, 12610, 1, EGL14.EGL_NONE};
    private static final int[] i = {EGL14.EGL_SURFACE_TYPE, 1, EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_ALPHA_SIZE, 8, EGL14.EGL_DEPTH_SIZE, 0, EGL14.EGL_STENCIL_SIZE, 0, EGL14.EGL_RENDERABLE_TYPE, 4, 12610, 1, EGL14.EGL_NONE};
    private final int d;
    private final int e;
    private EGLConfig f = null;

    /* renamed from: a  reason: collision with root package name */
    public EGLDisplay f22898a = EGL14.EGL_NO_DISPLAY;
    private EGLContext g = EGL14.EGL_NO_CONTEXT;
    public EGLSurface b = EGL14.EGL_NO_SURFACE;

    /* renamed from: c  reason: collision with root package name */
    private final String f22899c = "EGL14Helper@" + hashCode();

    private b(int i2, int i3) {
        this.d = i2;
        this.e = i3;
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, EGLContext eGLContext) throws g {
        EGLContext eGLContext2 = eGLContext;
        if (eGLContext == null) {
            eGLContext2 = EGL14.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext2, new int[]{12440, i2, EGL14.EGL_NONE}, 0);
        f();
        return eglCreateContext;
    }

    public static b a(EGLContext eGLContext, Surface surface, int i2, int i3) throws g {
        int i4;
        b bVar = new b(i2, i3);
        try {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            bVar.f22898a = eglGetDisplay;
            if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                LiteavLog.e(bVar.f22899c, "unable to get EGL14 display");
                throw new g(0);
            }
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(bVar.f22898a, iArr, 0, iArr, 1)) {
                bVar.f22898a = null;
                LiteavLog.e(bVar.f22899c, "unable to initialize EGL14");
                throw new g(0);
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(bVar.f22898a, surface == null ? i : h, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                bVar.f = eGLConfigArr[0];
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 18) {
                    try {
                        bVar.g = a(bVar.f22898a, bVar.f, 2, eGLContext);
                    } catch (g e) {
                        LiteavLog.i(bVar.f22899c, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
                        bVar.g = a(bVar.f22898a, bVar.f, 3, eGLContext);
                        i4 = 3;
                    }
                } else {
                    bVar.g = a(bVar.f22898a, bVar.f, 2, eGLContext);
                }
                i4 = 2;
                LiteavLog.i(bVar.f22899c, "create eglContext " + bVar.g + " sharedContext: " + eGLContext + " version:" + i4);
                if (surface == null) {
                    bVar.b = EGL14.eglCreatePbufferSurface(bVar.f22898a, bVar.f, new int[]{EGL14.EGL_WIDTH, bVar.d, EGL14.EGL_HEIGHT, bVar.e, EGL14.EGL_NONE}, 0);
                } else {
                    try {
                        bVar.b = EGL14.eglCreateWindowSurface(bVar.f22898a, bVar.f, surface, new int[]{EGL14.EGL_NONE}, 0);
                    } catch (Exception e2) {
                        throw new g(EGL14.eglGetError(), "", e2);
                    }
                }
                f();
                if (EGL14.eglMakeCurrent(bVar.f22898a, bVar.b, bVar.b, bVar.g)) {
                    return bVar;
                }
                f();
                return bVar;
            }
            throw new g(0);
        } catch (g e3) {
            bVar.c();
            throw e3;
        }
    }

    private static void f() throws g {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new g(eglGetError);
        }
    }

    @Override // com.tencent.liteav.videobase.b.h
    public final void a() throws g {
        GLES20.glFinish();
        if (EGL14.eglSwapBuffers(this.f22898a, this.b)) {
            return;
        }
        f();
    }

    @Override // com.tencent.liteav.videobase.b.h
    public final void b() throws g {
        EGLDisplay eGLDisplay = this.f22898a;
        EGLSurface eGLSurface = this.b;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.g)) {
            return;
        }
        f();
    }

    @Override // com.tencent.liteav.videobase.b.h
    public final void c() {
        if (this.f22898a != EGL14.EGL_NO_DISPLAY) {
            EGLDisplay eGLDisplay = this.f22898a;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            if (this.b != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.f22898a, this.b);
                this.b = EGL14.EGL_NO_SURFACE;
            }
            if (this.g != EGL14.EGL_NO_CONTEXT) {
                String str = this.f22899c;
                LiteavLog.i(str, "destroy eglContext " + this.g);
                EGL14.eglDestroyContext(this.f22898a, this.g);
                this.g = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f22898a);
        }
        this.f22898a = EGL14.EGL_NO_DISPLAY;
    }

    @Override // com.tencent.liteav.videobase.b.h
    public final void d() {
        if (this.f22898a != EGL14.EGL_NO_DISPLAY) {
            EGLDisplay eGLDisplay = this.f22898a;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
        }
    }

    @Override // com.tencent.liteav.videobase.b.h
    public final /* bridge */ /* synthetic */ EGLContext e() {
        return this.g;
    }
}
