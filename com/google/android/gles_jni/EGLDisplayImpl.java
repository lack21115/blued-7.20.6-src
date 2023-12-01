package com.google.android.gles_jni;

import javax.microedition.khronos.egl.EGLDisplay;

/* loaded from: source-4181928-dex2jar.jar:com/google/android/gles_jni/EGLDisplayImpl.class */
public class EGLDisplayImpl extends EGLDisplay {
    long mEGLDisplay;

    public EGLDisplayImpl(long j) {
        this.mEGLDisplay = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mEGLDisplay == ((EGLDisplayImpl) obj).mEGLDisplay;
    }

    public int hashCode() {
        return ((int) (this.mEGLDisplay ^ (this.mEGLDisplay >>> 32))) + 527;
    }
}
