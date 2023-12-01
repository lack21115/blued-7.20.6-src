package com.google.android.gles_jni;

import javax.microedition.khronos.egl.EGLConfig;

/* loaded from: source-4181928-dex2jar.jar:com/google/android/gles_jni/EGLConfigImpl.class */
public class EGLConfigImpl extends EGLConfig {
    private long mEGLConfig;

    EGLConfigImpl(long j) {
        this.mEGLConfig = j;
    }

    long get() {
        return this.mEGLConfig;
    }
}
