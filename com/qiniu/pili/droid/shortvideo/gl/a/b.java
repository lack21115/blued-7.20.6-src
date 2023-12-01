package com.qiniu.pili.droid.shortvideo.gl.a;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/a/b.class */
public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private EGLDisplay f14000a;
    private EGLContext b;

    /* renamed from: c  reason: collision with root package name */
    private EGLConfig f14001c;

    public b(Object obj, int i) {
        this.f14000a = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.f14001c = null;
        if (this.f14000a != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        EGLContext eGLContext = obj == null ? EGL14.EGL_NO_CONTEXT : obj;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f14000a = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = {0, 1};
        if (!EGL14.eglInitialize(this.f14000a, iArr, 0, iArr, 1)) {
            this.f14000a = null;
            throw new RuntimeException("unable to initialize EGL14");
        } else if (this.b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig a2 = a(i, 2);
            if (a2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f14000a, a2, (EGLContext) eGLContext, new int[]{12440, 2, EGL14.EGL_NONE}, 0);
            a("eglCreateContext");
            this.f14001c = a2;
            this.b = eglCreateContext;
        }
    }

    private EGLConfig a(int i, int i2) {
        int[] iArr = {EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_ALPHA_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, i2 >= 3 ? 68 : 4, EGL14.EGL_NONE, 0, EGL14.EGL_NONE};
        if ((i & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f14000a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("EGL14", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    private void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public static Object b() {
        return EGL14.eglGetCurrentContext();
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public void a() {
        if (this.f14000a != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.f14000a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f14000a, this.b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f14000a);
        }
        this.f14000a = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.f14001c = null;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public void a(Object obj) {
        EGL14.eglDestroySurface(this.f14000a, (EGLSurface) obj);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public void a(Object obj, long j) {
        EGLExt.eglPresentationTimeANDROID(this.f14000a, (EGLSurface) obj, j);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public Object b(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.f14000a, this.f14001c, obj, new int[]{EGL14.EGL_NONE}, 0);
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public void c(Object obj) {
        if (this.f14000a == EGL14.EGL_NO_DISPLAY) {
            Log.d("EGL14", "NOTE: makeCurrent w/o display");
        }
        EGLSurface eGLSurface = (EGLSurface) obj;
        if (!EGL14.eglMakeCurrent(this.f14000a, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public boolean d(Object obj) {
        return EGL14.eglSwapBuffers(this.f14000a, (EGLSurface) obj);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public void finalize() {
        if (this.f14000a != EGL14.EGL_NO_DISPLAY) {
            Log.w("EGL14", "WARNING: EglCore was not explicitly released -- state may be leaked");
            a();
        }
    }
}
