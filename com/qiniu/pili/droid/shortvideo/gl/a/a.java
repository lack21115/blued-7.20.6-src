package com.qiniu.pili.droid.shortvideo.gl.a;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.util.Log;
import android.view.Surface;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/a/a.class */
public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private EGLDisplay f13998a;
    private EGLContext b;

    /* renamed from: c  reason: collision with root package name */
    private EGLConfig f13999c;
    private EGL10 d = (EGL10) EGLContext.getEGL();

    public a(Object obj, int i) {
        this.f13998a = EGL10.EGL_NO_DISPLAY;
        this.b = EGL10.EGL_NO_CONTEXT;
        this.f13999c = null;
        if (this.f13998a != EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        EGLContext eGLContext = obj == null ? EGL10.EGL_NO_CONTEXT : obj;
        EGLDisplay eglGetDisplay = this.d.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f13998a = eglGetDisplay;
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL10 display");
        }
        if (!this.d.eglInitialize(this.f13998a, new int[2])) {
            this.f13998a = null;
            throw new RuntimeException("unable to initialize EGL10");
        } else if (this.b == EGL10.EGL_NO_CONTEXT) {
            EGLConfig a2 = a(i, 2);
            if (a2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eglCreateContext = this.d.eglCreateContext(this.f13998a, a2, (EGLContext) eGLContext, new int[]{12440, 2, EGL14.EGL_NONE});
            a("eglCreateContext");
            this.f13999c = a2;
            this.b = eglCreateContext;
        }
    }

    private EGLConfig a(int i, int i2) {
        int[] iArr = {EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_NONE, 0, EGL14.EGL_NONE};
        if ((i & 1) != 0) {
            iArr[8] = 12610;
            iArr[9] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (this.d.eglChooseConfig(this.f13998a, iArr, eGLConfigArr, 1, new int[1])) {
            return eGLConfigArr[0];
        }
        Log.w("EGL10", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    private void a(String str) {
        int eglGetError = this.d.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public static Object b() {
        return ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public void a() {
        if (this.f13998a != EGL10.EGL_NO_DISPLAY) {
            this.d.eglMakeCurrent(this.f13998a, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.d.eglDestroyContext(this.f13998a, this.b);
            this.d.eglTerminate(this.f13998a);
        }
        this.f13998a = EGL10.EGL_NO_DISPLAY;
        this.b = EGL10.EGL_NO_CONTEXT;
        this.f13999c = null;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public void a(Object obj) {
        this.d.eglDestroySurface(this.f13998a, (EGLSurface) obj);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public void a(Object obj, long j) {
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public Object b(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            throw new RuntimeException("invalid surface: " + obj);
        }
        EGLSurface eglCreateWindowSurface = this.d.eglCreateWindowSurface(this.f13998a, this.f13999c, obj, new int[]{EGL14.EGL_NONE});
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new RuntimeException("surface was null");
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public void c(Object obj) {
        if (this.f13998a == EGL10.EGL_NO_DISPLAY) {
            Log.d("EGL10", "NOTE: makeCurrent w/o display");
        }
        EGLSurface eGLSurface = (EGLSurface) obj;
        if (!this.d.eglMakeCurrent(this.f13998a, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public boolean d(Object obj) {
        return this.d.eglSwapBuffers(this.f13998a, (EGLSurface) obj);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.a.c
    public void finalize() {
        if (this.f13998a != EGL10.EGL_NO_DISPLAY) {
            Log.w("EGL10", "WARNING: EglCore was not explicitly released -- state may be leaked");
            a();
        }
    }
}
