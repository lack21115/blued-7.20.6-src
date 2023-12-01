package com.huawei.hms.ads;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.view.Surface;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fe.class */
public final class fe {
    private final int[] B = {EGL14.EGL_RED_SIZE, 8, EGL14.EGL_GREEN_SIZE, 8, EGL14.EGL_BLUE_SIZE, 8, EGL14.EGL_ALPHA_SIZE, 8, EGL14.EGL_RENDERABLE_TYPE, 4, EGL14.EGL_NONE, 0, EGL14.EGL_NONE};
    private EGLContext I;
    private EGLDisplay V;
    private EGLConfig Z;

    public fe() {
        Z();
        I();
        EGL14.eglQueryContext(this.V, this.I, 12440, new int[1], 0);
    }

    private EGLConfig B() {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.V, this.B, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        ge.I("GlEngine", "fail to choose gl config");
        return null;
    }

    private void Code(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new IllegalStateException(str + " err code " + Integer.toHexString(eglGetError));
    }

    private void I() {
        EGLConfig B = B();
        if (B == null) {
            throw new IllegalStateException("fail to get config");
        }
        this.I = EGL14.eglCreateContext(this.V, B, EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, EGL14.EGL_NONE}, 0);
        Code("create context fail");
        this.Z = B;
    }

    private void Z() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.V = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new IllegalStateException("fail to get gl display");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(this.V, iArr, 0, iArr, 1)) {
            return;
        }
        this.V = null;
        throw new IllegalStateException("fail to init gl");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int Code(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.V, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EGLSurface Code(Surface surface) {
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.V, this.Z, surface, new int[]{EGL14.EGL_NONE}, 0);
        Code("create window surface fail");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new IllegalStateException("gl surface is null");
    }

    public void Code() {
        if (this.V != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.V, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.V, this.I);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.V);
        }
        this.V = EGL14.EGL_NO_DISPLAY;
        this.I = EGL14.EGL_NO_CONTEXT;
        this.Z = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Code(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.V, eGLSurface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(EGLSurface eGLSurface) {
        if (EGL14.eglSwapBuffers(this.V, eGLSurface)) {
            return;
        }
        ge.Code("GlEngine", "fail to update buffer");
    }

    public void V() {
        if (!EGL14.eglMakeCurrent(this.V, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            throw new IllegalStateException("set no current fail");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V(EGLSurface eGLSurface) {
        if (!EGL14.eglMakeCurrent(this.V, eGLSurface, eGLSurface, this.I)) {
            throw new IllegalStateException("set current fail");
        }
    }

    protected void finalize() {
        try {
            if (this.V != EGL14.EGL_NO_DISPLAY) {
                Code();
            }
        } finally {
            super.finalize();
        }
    }
}
