package com.android.internal.util;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/VirtualRefBasePtr.class */
public final class VirtualRefBasePtr {
    private long mNativePtr;

    public VirtualRefBasePtr(long j) {
        this.mNativePtr = j;
        nIncStrong(this.mNativePtr);
    }

    private static native void nDecStrong(long j);

    private static native void nIncStrong(long j);

    protected void finalize() throws Throwable {
        try {
            release();
        } finally {
            super.finalize();
        }
    }

    public long get() {
        return this.mNativePtr;
    }

    public void release() {
        if (this.mNativePtr != 0) {
            nDecStrong(this.mNativePtr);
            this.mNativePtr = 0L;
        }
    }
}
