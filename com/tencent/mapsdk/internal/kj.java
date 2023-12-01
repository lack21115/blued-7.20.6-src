package com.tencent.mapsdk.internal;

import android.opengl.EGL14;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.map.lib.models.AccessibleTouchItem;
import com.tencent.mapsdk.internal.hj;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kj.class */
public class kj extends hj implements ae, hj.n, me, x1 {
    private final yi G;
    private boolean H;
    private Object I;
    private e1 J;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kj$a.class */
    public class a implements hj.g {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.hj.g
        public EGLContext a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, EGL14.EGL_NONE});
            if (kj.this.G != null) {
                kj.this.G.g();
            }
            return eglCreateContext;
        }

        @Override // com.tencent.mapsdk.internal.hj.g
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (kj.this.G != null) {
                kj.this.G.p();
            }
            EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
            egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/kj$b.class */
    public class b implements hj.h {
        public b() {
        }

        @Override // com.tencent.mapsdk.internal.hj.h
        public EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            EGLSurface eGLSurface;
            try {
                eGLSurface = egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, kj.this.I, null);
            } catch (IllegalArgumentException | OutOfMemoryError e) {
                eGLSurface = null;
            }
            if (kj.this.G != null) {
                kj.this.G.g();
            }
            return eGLSurface;
        }

        @Override // com.tencent.mapsdk.internal.hj.h
        public void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            if (kj.this.G != null) {
                kj.this.G.p();
            }
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public kj(e1 e1Var) {
        super(e1Var.getContext());
        this.J = e1Var;
        this.I = e1Var.i();
        this.G = (yi) e1Var.j();
        L();
        setContentDescription(AccessibleTouchItem.MAP_DEFAULT_CONTENT_DESCRIPTION);
    }

    private void S() {
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        a(8, 8, 8, 8, 16, 8);
        setEGLContextFactory(new a());
        if (this.I != null) {
            setEGLWindowSurfaceFactory(new b());
        }
    }

    public static boolean a(hj hjVar, boolean z) {
        if (Build.VERSION.SDK_INT < 11) {
            return false;
        }
        hjVar.setPreserveEGLContextOnPause(z);
        return true;
    }

    @Override // com.tencent.mapsdk.internal.ae
    public void L() {
        S();
        a(this, this.J.k());
        setRenderMode(0);
        this.H = a((hj) this, true);
    }

    @Override // com.tencent.mapsdk.internal.hj.n
    public void a(GL10 gl10, int i, int i2) {
        yi yiVar = this.G;
        if (yiVar != null) {
            yiVar.a(gl10, i, i2);
        }
    }

    @Override // com.tencent.mapsdk.internal.hj.n
    public void a(GL10 gl10, EGLConfig eGLConfig) {
        yi yiVar = this.G;
        if (yiVar != null) {
            yiVar.a(gl10, eGLConfig);
        }
    }

    @Override // com.tencent.mapsdk.internal.hj.n
    public boolean a(GL10 gl10) {
        yi yiVar = this.G;
        if (yiVar == null) {
            return false;
        }
        return yiVar.a(gl10);
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        yi yiVar = this.G;
        if (yiVar == null || !yiVar.a(motionEvent)) {
            return super.dispatchHoverEvent(motionEvent);
        }
        return true;
    }

    @Override // com.tencent.mapsdk.internal.me
    public int getEGLContextHash() {
        yi yiVar = this.G;
        if (yiVar != null) {
            return yiVar.getEGLContextHash();
        }
        return 0;
    }

    public a1 getVectorMapDelegate() {
        return this.G;
    }

    @Override // com.tencent.mapsdk.internal.x1
    public View getView() {
        return this;
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void j() {
        if (getVisibility() == 0) {
            a();
        }
    }

    @Override // com.tencent.mapsdk.internal.hj, com.tencent.mapsdk.internal.x1
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.tencent.mapsdk.internal.hj, com.tencent.mapsdk.internal.x1
    public void onPause() {
        if (this.H) {
            super.onPause();
        }
    }

    @Override // com.tencent.mapsdk.internal.hj, com.tencent.mapsdk.internal.x1
    public void onResume() {
        if (this.H) {
            super.onResume();
        }
    }

    @Override // android.view.View, com.tencent.mapsdk.internal.x1
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        yi yiVar = this.G;
        if (yiVar != null) {
            yiVar.d(i, i2);
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void onSurfaceChanged(Object obj, int i, int i2) {
    }

    @Override // android.view.View, com.tencent.mapsdk.internal.x1
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.mapsdk.internal.x1
    public void setMapOpaque(boolean z) {
    }

    @Override // com.tencent.mapsdk.internal.hj.n
    public void x() {
        yi yiVar = this.G;
        if (yiVar != null) {
            yiVar.x();
        }
    }

    @Override // com.tencent.mapsdk.internal.x1
    public boolean z() {
        return false;
    }
}
