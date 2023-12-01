package com.google.android.gles_jni;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: source-4181928-dex2jar.jar:com/google/android/gles_jni/EGLImpl.class */
public class EGLImpl implements EGL10 {
    private EGLContextImpl mContext = new EGLContextImpl(-1);
    private EGLDisplayImpl mDisplay = new EGLDisplayImpl(-1);
    private EGLSurfaceImpl mSurface = new EGLSurfaceImpl(-1);

    static {
        _nativeClassInit();
    }

    private native long _eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr);

    private native long _eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr);

    private native void _eglCreatePixmapSurface(EGLSurface eGLSurface, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr);

    private native long _eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr);

    private native long _eglCreateWindowSurfaceTexture(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr);

    private native long _eglGetCurrentContext();

    private native long _eglGetCurrentDisplay();

    private native long _eglGetCurrentSurface(int i);

    private native long _eglGetDisplay(Object obj);

    private static native void _nativeClassInit();

    public static native int getInitCount(EGLDisplay eGLDisplay);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglChooseConfig(EGLDisplay eGLDisplay, int[] iArr, EGLConfig[] eGLConfigArr, int i, int[] iArr2);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglCopyBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface, Object obj);

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglCreateContext(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int[] iArr) {
        long _eglCreateContext = _eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        return _eglCreateContext == 0 ? EGL10.EGL_NO_CONTEXT : new EGLContextImpl(_eglCreateContext);
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePbufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int[] iArr) {
        long _eglCreatePbufferSurface = _eglCreatePbufferSurface(eGLDisplay, eGLConfig, iArr);
        return _eglCreatePbufferSurface == 0 ? EGL10.EGL_NO_SURFACE : new EGLSurfaceImpl(_eglCreatePbufferSurface);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [javax.microedition.khronos.egl.EGLSurface] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.android.gles_jni.EGLImpl] */
    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreatePixmapSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        EGLSurfaceImpl eGLSurfaceImpl = new EGLSurfaceImpl();
        _eglCreatePixmapSurface(eGLSurfaceImpl, eGLDisplay, eGLConfig, obj, iArr);
        EGLSurfaceImpl eGLSurfaceImpl2 = eGLSurfaceImpl;
        if (eGLSurfaceImpl.mEGLSurface == 0) {
            eGLSurfaceImpl2 = EGL10.EGL_NO_SURFACE;
        }
        return eGLSurfaceImpl2;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglCreateWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj, int[] iArr) {
        long _eglCreateWindowSurfaceTexture;
        Surface surface = null;
        if (obj instanceof SurfaceView) {
            surface = ((SurfaceView) obj).getHolder().getSurface();
        } else if (obj instanceof SurfaceHolder) {
            surface = ((SurfaceHolder) obj).getSurface();
        } else if (obj instanceof Surface) {
            surface = (Surface) obj;
        }
        if (surface != null) {
            _eglCreateWindowSurfaceTexture = _eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, iArr);
        } else if (!(obj instanceof SurfaceTexture)) {
            throw new UnsupportedOperationException("eglCreateWindowSurface() can only be called with an instance of Surface, SurfaceView, SurfaceHolder or SurfaceTexture at the moment.");
        } else {
            _eglCreateWindowSurfaceTexture = _eglCreateWindowSurfaceTexture(eGLDisplay, eGLConfig, obj, iArr);
        }
        return _eglCreateWindowSurfaceTexture == 0 ? EGL10.EGL_NO_SURFACE : new EGLSurfaceImpl(_eglCreateWindowSurfaceTexture);
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglDestroyContext(EGLDisplay eGLDisplay, EGLContext eGLContext);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglDestroySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglGetConfigAttrib(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int[] iArr);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglGetConfigs(EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr, int i, int[] iArr);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [javax.microedition.khronos.egl.EGLContext] */
    @Override // javax.microedition.khronos.egl.EGL10
    public EGLContext eglGetCurrentContext() {
        EGLContextImpl eGLContextImpl;
        synchronized (this) {
            long _eglGetCurrentContext = _eglGetCurrentContext();
            if (_eglGetCurrentContext == 0) {
                eGLContextImpl = EGL10.EGL_NO_CONTEXT;
            } else {
                if (this.mContext.mEGLContext != _eglGetCurrentContext) {
                    this.mContext = new EGLContextImpl(_eglGetCurrentContext);
                }
                eGLContextImpl = this.mContext;
            }
        }
        return eGLContextImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [javax.microedition.khronos.egl.EGLDisplay] */
    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetCurrentDisplay() {
        EGLDisplayImpl eGLDisplayImpl;
        synchronized (this) {
            long _eglGetCurrentDisplay = _eglGetCurrentDisplay();
            if (_eglGetCurrentDisplay == 0) {
                eGLDisplayImpl = EGL10.EGL_NO_DISPLAY;
            } else {
                if (this.mDisplay.mEGLDisplay != _eglGetCurrentDisplay) {
                    this.mDisplay = new EGLDisplayImpl(_eglGetCurrentDisplay);
                }
                eGLDisplayImpl = this.mDisplay;
            }
        }
        return eGLDisplayImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [javax.microedition.khronos.egl.EGLSurface] */
    @Override // javax.microedition.khronos.egl.EGL10
    public EGLSurface eglGetCurrentSurface(int i) {
        EGLSurfaceImpl eGLSurfaceImpl;
        synchronized (this) {
            long _eglGetCurrentSurface = _eglGetCurrentSurface(i);
            if (_eglGetCurrentSurface == 0) {
                eGLSurfaceImpl = EGL10.EGL_NO_SURFACE;
            } else {
                if (this.mSurface.mEGLSurface != _eglGetCurrentSurface) {
                    this.mSurface = new EGLSurfaceImpl(_eglGetCurrentSurface);
                }
                eGLSurfaceImpl = this.mSurface;
            }
        }
        return eGLSurfaceImpl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [javax.microedition.khronos.egl.EGLDisplay] */
    @Override // javax.microedition.khronos.egl.EGL10
    public EGLDisplay eglGetDisplay(Object obj) {
        EGLDisplayImpl eGLDisplayImpl;
        synchronized (this) {
            long _eglGetDisplay = _eglGetDisplay(obj);
            if (_eglGetDisplay == 0) {
                eGLDisplayImpl = EGL10.EGL_NO_DISPLAY;
            } else {
                if (this.mDisplay.mEGLDisplay != _eglGetDisplay) {
                    this.mDisplay = new EGLDisplayImpl(_eglGetDisplay);
                }
                eGLDisplayImpl = this.mDisplay;
            }
        }
        return eGLDisplayImpl;
    }

    @Override // javax.microedition.khronos.egl.EGL10
    public native int eglGetError();

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglInitialize(EGLDisplay eGLDisplay, int[] iArr);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglMakeCurrent(EGLDisplay eGLDisplay, EGLSurface eGLSurface, EGLSurface eGLSurface2, EGLContext eGLContext);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglQueryContext(EGLDisplay eGLDisplay, EGLContext eGLContext, int i, int[] iArr);

    @Override // javax.microedition.khronos.egl.EGL10
    public native String eglQueryString(EGLDisplay eGLDisplay, int i);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglQuerySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i, int[] iArr);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglReleaseThread();

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglSwapBuffers(EGLDisplay eGLDisplay, EGLSurface eGLSurface);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglTerminate(EGLDisplay eGLDisplay);

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglWaitGL();

    @Override // javax.microedition.khronos.egl.EGL10
    public native boolean eglWaitNative(int i, Object obj);
}
