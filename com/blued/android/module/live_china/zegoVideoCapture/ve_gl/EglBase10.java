package com.blued.android.module.live_china.zegoVideoCapture.ve_gl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/ve_gl/EglBase10.class */
public final class EglBase10 extends EglBase {
    private EGLContext j;
    private EGLConfig k;
    private EGLDisplay l;
    private EGLSurface m = EGL10.EGL_NO_SURFACE;
    private final EGL10 i = (EGL10) EGLContext.getEGL();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/zegoVideoCapture/ve_gl/EglBase10$Context.class */
    public static class Context extends EglBase.Context {

        /* renamed from: a  reason: collision with root package name */
        private final EGLContext f15499a;

        public Context(EGLContext eGLContext) {
            this.f15499a = eGLContext;
        }
    }

    public EglBase10(Context context, int[] iArr) {
        EGLDisplay j = j();
        this.l = j;
        EGLConfig a2 = a(j, iArr);
        this.k = a2;
        this.j = a(context, this.l, a2);
    }

    private EGLConfig a(EGLDisplay eGLDisplay, int[] iArr) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr2 = new int[1];
        if (!this.i.eglChooseConfig(eGLDisplay, iArr, eGLConfigArr, 1, iArr2)) {
            this.b = true;
            String str = f15496a;
            Log.e(str, "eglChooseConfig failed: 0x" + Integer.toHexString(this.i.eglGetError()));
            return null;
        } else if (iArr2[0] <= 0) {
            this.b = true;
            Log.e(f15496a, "Unable to find any matching EGL config");
            return null;
        } else {
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (eGLConfig == null) {
                this.b = true;
                Log.e(f15496a, "eglChooseConfig returned null");
                return null;
            }
            return eGLConfig;
        }
    }

    private EGLContext a(Context context, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        EGLContext eglCreateContext;
        if (context != null && context.f15499a == EGL10.EGL_NO_CONTEXT) {
            this.b = true;
            Log.e(f15496a, "Invalid sharedContext");
            return null;
        }
        EGLContext eGLContext = context == null ? EGL10.EGL_NO_CONTEXT : context.f15499a;
        synchronized (EglBase.f15497c) {
            eglCreateContext = this.i.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{12440, 2, 12344});
        }
        if (eglCreateContext == EGL10.EGL_NO_CONTEXT) {
            this.b = true;
            String str = f15496a;
            Log.e(str, "Failed to create EGL context: 0x" + Integer.toHexString(this.i.eglGetError()));
        }
        return eglCreateContext;
    }

    private void a(Object obj) {
        if (!(obj instanceof SurfaceHolder) && !(obj instanceof SurfaceTexture)) {
            this.b = true;
            Log.e(f15496a, "Input must be either a SurfaceHolder or SurfaceTexture");
            return;
        }
        i();
        if (this.m != EGL10.EGL_NO_SURFACE) {
            this.b = true;
            Log.e(f15496a, "Already has an EGLSurface");
            return;
        }
        this.m = this.i.eglCreateWindowSurface(this.l, this.k, obj, new int[]{12344});
        int eglGetError = this.i.eglGetError();
        if (this.m == EGL10.EGL_NO_SURFACE || eglGetError != 12288) {
            this.b = true;
            String str = f15496a;
            Log.e(str, "Failed to create window surface: 0x" + Integer.toHexString(eglGetError));
        }
    }

    private void i() {
        if (this.l == EGL10.EGL_NO_DISPLAY || this.j == EGL10.EGL_NO_CONTEXT || this.k == null) {
            this.b = true;
            Log.e(f15496a, "This object has been released");
        }
    }

    private EGLDisplay j() {
        EGLDisplay eglGetDisplay = this.i.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (eglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            this.b = true;
            String str = f15496a;
            Log.e(str, "Unable to get EGL10 display: 0x" + Integer.toHexString(this.i.eglGetError()));
            return eglGetDisplay;
        }
        if (!this.i.eglInitialize(eglGetDisplay, new int[2])) {
            this.b = true;
            String str2 = f15496a;
            Log.e(str2, "Unable to initialize EGL10: 0x" + Integer.toHexString(this.i.eglGetError()));
        }
        return eglGetDisplay;
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void a() {
        a(1, 1);
    }

    public void a(int i, int i2) {
        i();
        if (this.m != EGL10.EGL_NO_SURFACE) {
            this.b = true;
            Log.e(f15496a, "Already has an EGLSurface");
            return;
        }
        this.m = this.i.eglCreatePbufferSurface(this.l, this.k, new int[]{12375, i, 12374, i2, 12344});
        int eglGetError = this.i.eglGetError();
        if (this.m == EGL10.EGL_NO_SURFACE || eglGetError != 12288) {
            this.b = true;
            String str = f15496a;
            Log.e(str, "Failed to create pixel buffer surface with size " + i + "x" + i2 + ": 0x" + Integer.toHexString(eglGetError));
        }
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void a(Surface surface) {
        a(new SurfaceHolder(surface) { // from class: com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase10.1FakeSurfaceHolder
            private final Surface b;

            {
                this.b = surface;
            }

            @Override // android.view.SurfaceHolder
            public void addCallback(SurfaceHolder.Callback callback) {
            }

            @Override // android.view.SurfaceHolder
            public Surface getSurface() {
                return this.b;
            }

            @Override // android.view.SurfaceHolder
            public Rect getSurfaceFrame() {
                return null;
            }

            @Override // android.view.SurfaceHolder
            public boolean isCreating() {
                return false;
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas() {
                return null;
            }

            @Override // android.view.SurfaceHolder
            public Canvas lockCanvas(Rect rect) {
                return null;
            }

            @Override // android.view.SurfaceHolder
            public void removeCallback(SurfaceHolder.Callback callback) {
            }

            @Override // android.view.SurfaceHolder
            public void setFixedSize(int i, int i2) {
            }

            @Override // android.view.SurfaceHolder
            public void setFormat(int i) {
            }

            @Override // android.view.SurfaceHolder
            public void setKeepScreenOn(boolean z) {
            }

            @Override // android.view.SurfaceHolder
            public void setSizeFromLayout() {
            }

            @Override // android.view.SurfaceHolder
            @Deprecated
            public void setType(int i) {
            }

            @Override // android.view.SurfaceHolder
            public void unlockCanvasAndPost(Canvas canvas) {
            }
        });
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public EglBase.Context b() {
        return new Context(this.j);
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public boolean c() {
        return this.m != EGL10.EGL_NO_SURFACE;
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void d() {
        if (this.b || this.m == EGL10.EGL_NO_SURFACE) {
            return;
        }
        this.i.eglDestroySurface(this.l, this.m);
        this.m = EGL10.EGL_NO_SURFACE;
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void e() {
        if (this.b) {
            return;
        }
        i();
        d();
        g();
        this.i.eglDestroyContext(this.l, this.j);
        this.i.eglTerminate(this.l);
        this.j = EGL10.EGL_NO_CONTEXT;
        this.l = EGL10.EGL_NO_DISPLAY;
        this.k = null;
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void f() {
        i();
        if (this.m == EGL10.EGL_NO_SURFACE) {
            this.b = true;
            Log.e(f15496a, "No EGLSurface - can't make current");
            return;
        }
        synchronized (EglBase.f15497c) {
            EGLContext eglGetCurrentContext = this.i.eglGetCurrentContext();
            EGLSurface eglGetCurrentSurface = this.i.eglGetCurrentSurface(12377);
            if (eglGetCurrentContext == this.j && eglGetCurrentSurface == this.m) {
                return;
            }
            if (this.i.eglMakeCurrent(this.l, this.m, this.m, this.j)) {
                return;
            }
            this.b = true;
            String str = f15496a;
            Log.e(str, "eglMakeCurrent failed: 0x" + Integer.toHexString(this.i.eglGetError()));
        }
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void g() {
        synchronized (EglBase.f15497c) {
            if (!this.i.eglMakeCurrent(this.l, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT)) {
                this.b = true;
                String str = f15496a;
                Log.e(str, "eglDetachCurrent failed: 0x" + Integer.toHexString(this.i.eglGetError()));
            }
        }
    }

    @Override // com.blued.android.module.live_china.zegoVideoCapture.ve_gl.EglBase
    public void h() {
        i();
        if (this.m == EGL10.EGL_NO_SURFACE) {
            this.b = true;
            Log.e(f15496a, "No EGLSurface - can't swap buffers");
            return;
        }
        synchronized (EglBase.f15497c) {
            this.i.eglSwapBuffers(this.l, this.m);
        }
    }
}
