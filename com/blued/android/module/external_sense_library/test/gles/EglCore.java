package com.blued.android.module.external_sense_library.test.gles;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/test/gles/EglCore.class */
public final class EglCore {

    /* renamed from: a  reason: collision with root package name */
    private EGLDisplay f11286a;
    private EGLContext b;

    /* renamed from: c  reason: collision with root package name */
    private EGLConfig f11287c;
    private int d;

    public EglCore() {
        this(null, 0);
    }

    public EglCore(EGLContext eGLContext, int i) {
        EGLConfig b;
        this.f11286a = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.f11287c = null;
        this.d = -1;
        if (this.f11286a != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        EGLContext eGLContext2 = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f11286a = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.f11286a, iArr, 0, iArr, 1)) {
            this.f11286a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        if ((i & 2) != 0 && (b = b(i, 3)) != null) {
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.f11286a, b, eGLContext2, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.f11287c = b;
                this.b = eglCreateContext;
                this.d = 3;
            }
        }
        if (this.b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig b2 = b(i, 2);
            if (b2 == null) {
                throw new RuntimeException("Unable to find a suitable EGLConfig");
            }
            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.f11286a, b2, eGLContext2, new int[]{12440, 2, 12344}, 0);
            a("eglCreateContext");
            this.f11287c = b2;
            this.b = eglCreateContext2;
            this.d = 2;
        }
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.f11286a, this.b, 12440, iArr2, 0);
        Log.d("Grafika", "EGLContext created, client version " + iArr2[0]);
    }

    private void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    private EGLConfig b(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f11286a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("Grafika", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    public int a(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f11286a, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    public EGLSurface a(int i, int i2) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(this.f11286a, this.f11287c, new int[]{12375, i, 12374, i2, 12344}, 0);
        a("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new RuntimeException("surface was null");
    }

    public void a() {
        if (this.f11286a != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglMakeCurrent(this.f11286a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.f11286a, this.b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f11286a);
        }
        this.f11286a = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.f11287c = null;
    }

    public void a(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.f11286a, eGLSurface);
    }

    public void b(EGLSurface eGLSurface) {
        if (this.f11286a == EGL14.EGL_NO_DISPLAY) {
            Log.d("Grafika", "NOTE: makeCurrent w/o display");
        }
        if (!EGL14.eglMakeCurrent(this.f11286a, eGLSurface, eGLSurface, this.b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean c(EGLSurface eGLSurface) {
        return this.b.equals(EGL14.eglGetCurrentContext()) && eGLSurface.equals(EGL14.eglGetCurrentSurface(12377));
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f11286a != EGL14.EGL_NO_DISPLAY) {
                Log.w("Grafika", "WARNING: EglCore was not explicitly released -- state may be leaked");
                a();
            }
        } finally {
            super.finalize();
        }
    }
}
