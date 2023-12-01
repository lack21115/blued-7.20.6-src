package com.tencent.thumbplayer.core.common;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPDrm.class */
public final class TPDrm {
    private static final String TAG = "TPDrm";
    private static boolean mIsLibLoaded;

    static {
        try {
            TPNativeLibraryLoader.loadLibIfNeeded(null);
            mIsLibLoaded = true;
        } catch (UnsupportedOperationException e) {
            TPNativeLog.printLog(4, e.getMessage());
            mIsLibLoaded = false;
        }
    }

    public static int[] getDRMCapabilities() {
        if (isLibLoaded()) {
            try {
                int[] native_getDRMCapabilities = native_getDRMCapabilities();
                int[] iArr = native_getDRMCapabilities;
                if (native_getDRMCapabilities == null) {
                    iArr = new int[0];
                }
                return iArr;
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.toString());
                throw new TPNativeLibraryException("Failed to call native func.");
            }
        }
        throw new TPNativeLibraryException("Failed to load native library.");
    }

    private static boolean isLibLoaded() {
        return mIsLibLoaded;
    }

    static native int[] native_getDRMCapabilities();
}
