package com.google.android.gles_jni;

import com.blued.das.live.LiveProtos;
import javax.microedition.khronos.egl.EGLSurface;

/* loaded from: source-4181928-dex2jar.jar:com/google/android/gles_jni/EGLSurfaceImpl.class */
public class EGLSurfaceImpl extends EGLSurface {
    long mEGLSurface;
    private long mNativePixelRef;

    public EGLSurfaceImpl() {
        this.mEGLSurface = 0L;
        this.mNativePixelRef = 0L;
    }

    public EGLSurfaceImpl(long j) {
        this.mEGLSurface = j;
        this.mNativePixelRef = 0L;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mEGLSurface == ((EGLSurfaceImpl) obj).mEGLSurface;
    }

    public int hashCode() {
        return ((int) (this.mEGLSurface ^ (this.mEGLSurface >>> 32))) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
    }
}
