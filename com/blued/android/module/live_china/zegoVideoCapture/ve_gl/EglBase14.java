package com.blued.android.module.live_china.zegoVideoCapture.ve_gl;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase;
import javax.microedition.khronos.egl.EGL10;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/ve_gl/EglBase14.class */
public final class EglBase14 extends EglBase {
    private static final int i = Build.VERSION.SDK_INT;
    private EGLContext j;
    private EGLConfig k;
    private EGLDisplay l;
    private EGLSurface m = EGL14.EGL_NO_SURFACE;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/ve_gl/EglBase14$Context.class */
    public static class Context extends EglBase.Context {
        private final EGLContext a;

        public Context(EGLContext eGLContext) {
            this.a = eGLContext;
        }
    }

    public EglBase14(Context context, int[] iArr) {
        EGLDisplay l = l();
        this.l = l;
        EGLConfig a = a(l, iArr);
        this.k = a;
        this.j = a(context, this.l, a);
    }

    private static EGLConfig a(EGLDisplay eGLDisplay, int[] iArr) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        if (!EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, 1, iArr2, 0)) {
            Log.e("EglBase14", "eglChooseConfig failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
            return null;
        } else if (iArr2[0] <= 0) {
            Log.e("EglBase14", "Unable to find any matching EGL config");
            return null;
        } else {
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (eGLConfig == null) {
                Log.e("EglBase14", "eglChooseConfig returned null");
                return null;
            }
            return eGLConfig;
        }
    }

    private static EGLContext a(Context context, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        EGLContext eglCreateContext;
        if (context != null && context.a == EGL14.EGL_NO_CONTEXT) {
            Log.e("EglBase14", "Invalid sharedContext");
            return null;
        }
        EGLContext eGLContext = context == null ? EGL14.EGL_NO_CONTEXT : context.a;
        synchronized (EglBase.c) {
            eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{12440, 2, EGL10.EGL_NONE}, 0);
        }
        if (eglCreateContext == EGL14.EGL_NO_CONTEXT) {
            Log.e("EglBase14", "Failed to create EGL context: 0x" + Integer.toHexString(EGL14.eglGetError()));
            return null;
        }
        return eglCreateContext;
    }

    private void a(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            this.b = true;
            return;
        }
        k();
        if (this.m != EGL14.EGL_NO_SURFACE) {
            this.b = true;
            return;
        }
        this.m = EGL14.eglCreateWindowSurface(this.l, this.k, obj, new int[]{EGL10.EGL_NONE}, 0);
        int eglGetError = EGL14.eglGetError();
        if (this.m == EGL14.EGL_NO_SURFACE || eglGetError != 12288) {
            this.b = true;
        }
    }

    public static boolean i() {
        StringBuilder sb = new StringBuilder();
        sb.append("SDK version: ");
        sb.append(i);
        sb.append(". isEGL14Supported: ");
        sb.append(i >= 18);
        Log.d("EglBase14", sb.toString());
        return i >= 18;
    }

    private void k() {
        if (this.l == EGL14.EGL_NO_DISPLAY || this.j == EGL14.EGL_NO_CONTEXT || this.k == null) {
            this.b = true;
        }
    }

    private static EGLDisplay l() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            Log.e("EglBase14", "Unable to get EGL14 display: 0x" + Integer.toHexString(EGL14.eglGetError()));
            return eglGetDisplay;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            Log.e("EglBase14", "Unable to initialize EGL14: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
        return eglGetDisplay;
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void a() {
        a(1, 1);
    }

    public void a(int i2, int i3) {
        k();
        if (this.m != EGL14.EGL_NO_SURFACE) {
            this.b = true;
            return;
        }
        this.m = EGL14.eglCreatePbufferSurface(this.l, this.k, new int[]{EGL10.EGL_WIDTH, i2, EGL10.EGL_HEIGHT, i3, EGL10.EGL_NONE}, 0);
        int eglGetError = EGL14.eglGetError();
        if (this.m == EGL14.EGL_NO_SURFACE || eglGetError != 12288) {
            this.b = true;
        }
    }

    public void a(long j) {
        k();
        if (this.m == EGL14.EGL_NO_SURFACE) {
            this.b = true;
            Log.e("EglBase14", "No EGLSurface - can't swap buffers");
            return;
        }
        synchronized (EglBase.c) {
            EGLExt.eglPresentationTimeANDROID(this.l, this.m, j);
            EGL14.eglSwapBuffers(this.l, this.m);
        }
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void a(Surface surface) {
        a((Object) surface);
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public boolean c() {
        return this.m != EGL14.EGL_NO_SURFACE;
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void d() {
        if (this.b || this.m == EGL14.EGL_NO_SURFACE) {
            return;
        }
        EGL14.eglDestroySurface(this.l, this.m);
        this.m = EGL14.EGL_NO_SURFACE;
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void e() {
        if (this.b) {
            return;
        }
        k();
        d();
        g();
        EGL14.eglDestroyContext(this.l, this.j);
        EGL14.eglReleaseThread();
        EGL14.eglTerminate(this.l);
        this.j = EGL14.EGL_NO_CONTEXT;
        this.l = EGL14.EGL_NO_DISPLAY;
        this.k = null;
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void f() {
        k();
        if (this.m == EGL14.EGL_NO_SURFACE) {
            this.b = true;
            Log.e("EglBase14", "No EGLSurface - can't make current");
            return;
        }
        synchronized (EglBase.c) {
            EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
            EGLSurface eglGetCurrentSurface = EGL14.eglGetCurrentSurface(EGL10.EGL_DRAW);
            if (eglGetCurrentContext == this.j && eglGetCurrentSurface == this.m) {
                return;
            }
            if (EGL14.eglMakeCurrent(this.l, this.m, this.m, this.j)) {
                return;
            }
            this.b = true;
            Log.e("EglBase14", "eglMakeCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void g() {
        synchronized (EglBase.c) {
            if (EGL14.eglMakeCurrent(this.l, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
                return;
            }
            this.b = true;
            Log.e("EglBase14", "eglDetachCurrent failed: 0x" + Integer.toHexString(EGL14.eglGetError()));
        }
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void h() {
        k();
        if (this.m == EGL14.EGL_NO_SURFACE) {
            this.b = true;
            Log.e("EglBase14", "No EGLSurface - can't swap buffers");
            return;
        }
        synchronized (EglBase.c) {
            EGL14.eglSwapBuffers(this.l, this.m);
        }
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    /* renamed from: j */
    public Context b() {
        return new Context(this.j);
    }
}
