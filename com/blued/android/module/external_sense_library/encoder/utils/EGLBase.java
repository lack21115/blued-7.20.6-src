package com.blued.android.module.external_sense_library.encoder.utils;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import javax.microedition.khronos.egl.EGL10;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/encoder/utils/EGLBase.class */
public class EGLBase {
    private EGLConfig a = null;
    private EGLContext b = EGL14.EGL_NO_CONTEXT;
    private EGLDisplay c = EGL14.EGL_NO_DISPLAY;
    private EGLContext d = EGL14.EGL_NO_CONTEXT;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/encoder/utils/EGLBase$EglSurface.class */
    public static class EglSurface {
        private final EGLBase a;
        private EGLSurface b;
        private final int c;
        private final int d;

        EglSurface(EGLBase eGLBase, Object obj) {
            this.b = EGL14.EGL_NO_SURFACE;
            if (!(obj instanceof SurfaceView) && !(obj instanceof Surface) && !(obj instanceof SurfaceHolder) && !(obj instanceof SurfaceTexture)) {
                throw new IllegalArgumentException("unsupported surface");
            }
            this.a = eGLBase;
            EGLSurface b = eGLBase.b(obj);
            this.b = b;
            this.c = this.a.a(b, EGL10.EGL_WIDTH);
            this.d = this.a.a(this.b, EGL10.EGL_HEIGHT);
        }

        public void a() {
            this.a.a(this.b);
        }

        public void b() {
            this.a.b(this.b);
        }

        public void c() {
            this.a.b();
            this.a.c(this.b);
            this.b = EGL14.EGL_NO_SURFACE;
        }

        public EGLContext getContext() {
            return this.a.getContext();
        }
    }

    public EGLBase(EGLContext eGLContext, boolean z, boolean z2) {
        a(eGLContext, z, z2);
    }

    private EGLConfig a(boolean z, boolean z2) {
        int[] iArr = {EGL10.EGL_RENDERABLE_TYPE, 4, EGL10.EGL_RED_SIZE, 8, EGL10.EGL_GREEN_SIZE, 8, EGL10.EGL_BLUE_SIZE, 8, EGL10.EGL_ALPHA_SIZE, 8, EGL10.EGL_NONE, EGL10.EGL_NONE, EGL10.EGL_NONE, EGL10.EGL_NONE, EGL10.EGL_NONE, EGL10.EGL_NONE, EGL10.EGL_NONE};
        int i = 10;
        if (z) {
            iArr[10] = 12325;
            i = 12;
            iArr[11] = 16;
        }
        int i2 = 16;
        int i3 = i;
        if (z2) {
            i2 = 16;
            i3 = i;
            if (Build.VERSION.SDK_INT >= 18) {
                int i4 = i + 1;
                iArr[i] = 12610;
                i3 = i4 + 1;
                iArr[i4] = 1;
                i2 = 16;
            }
        }
        while (i2 >= i3) {
            iArr[i2] = 12344;
            i2--;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.c, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("EGLBase", "unable to find RGBA8888 /  EGLConfig");
        return null;
    }

    private EGLContext a(EGLContext eGLContext) {
        EGLContext eglCreateContext = EGL14.eglCreateContext(this.c, this.a, eGLContext, new int[]{12440, 2, EGL10.EGL_NONE}, 0);
        a("eglCreateContext");
        return eglCreateContext;
    }

    private void a(EGLContext eGLContext, boolean z, boolean z2) {
        if (this.c != EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("EGL already set up");
        }
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.c = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetDisplay failed");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.c, iArr, 0, iArr, 1)) {
            this.c = null;
            throw new RuntimeException("eglInitialize failed");
        }
        if (eGLContext == null) {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        if (this.b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig a = a(z, z2);
            this.a = a;
            if (a == null) {
                throw new RuntimeException("chooseConfig failed");
            }
            this.b = a(eGLContext);
        }
        EGL14.eglQueryContext(this.c, this.b, 12440, new int[1], 0);
        b();
    }

    private void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(EGLSurface eGLSurface) {
        if (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) {
            if (EGL14.eglGetError() == 12299) {
                Log.e("EGLBase", "makeCurrent:returned EGL_BAD_NATIVE_WINDOW.");
                return false;
            }
            return false;
        } else if (EGL14.eglMakeCurrent(this.c, eGLSurface, eGLSurface, this.b)) {
            return true;
        } else {
            Log.w("EGLBase", "eglMakeCurrent:" + EGL14.eglGetError());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(EGLSurface eGLSurface) {
        if (EGL14.eglSwapBuffers(this.c, eGLSurface)) {
            return 12288;
        }
        return EGL14.eglGetError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EGLSurface b(Object obj) {
        try {
            return EGL14.eglCreateWindowSurface(this.c, this.a, obj, new int[]{EGL10.EGL_NONE}, 0);
        } catch (IllegalArgumentException e) {
            Log.e("EGLBase", "eglCreateWindowSurface", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (EGL14.eglMakeCurrent(this.c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            return;
        }
        Log.w("TAG", "makeDefault" + EGL14.eglGetError());
    }

    private void c() {
        if (!EGL14.eglDestroyContext(this.c, this.b)) {
            Log.e("destroyContext", "display:" + this.c + " context: " + this.b);
            StringBuilder sb = new StringBuilder();
            sb.append("eglDestroyContex:");
            sb.append(EGL14.eglGetError());
            Log.e("EGLBase", sb.toString());
        }
        this.b = EGL14.EGL_NO_CONTEXT;
        if (this.d != EGL14.EGL_NO_CONTEXT) {
            if (!EGL14.eglDestroyContext(this.c, this.d)) {
                Log.e("destroyContext", "display:" + this.c + " context: " + this.d);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("eglDestroyContex:");
                sb2.append(EGL14.eglGetError());
                Log.e("EGLBase", sb2.toString());
            }
            this.d = EGL14.EGL_NO_CONTEXT;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EGLSurface eGLSurface) {
        if (eGLSurface != EGL14.EGL_NO_SURFACE) {
            EGL14.eglMakeCurrent(this.c, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.c, eGLSurface);
        }
        EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
    }

    public int a(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.c, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    public EglSurface a(Object obj) {
        EglSurface eglSurface = new EglSurface(this, obj);
        eglSurface.a();
        return eglSurface;
    }

    public void a() {
        if (this.c != EGL14.EGL_NO_DISPLAY) {
            c();
            EGL14.eglTerminate(this.c);
            EGL14.eglReleaseThread();
        }
        this.c = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
    }

    public EGLContext getContext() {
        return this.b;
    }
}
