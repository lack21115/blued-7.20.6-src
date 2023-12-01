package android.graphics;

import android.content.res.AssetManager;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/FontFamily.class */
public class FontFamily {
    public long mNativePtr;

    public FontFamily() {
        this.mNativePtr = nCreateFamily(null, 0);
        if (this.mNativePtr == 0) {
            throw new IllegalStateException("error creating native FontFamily");
        }
    }

    public FontFamily(String str, String str2) {
        int i = 0;
        if ("compact".equals(str2)) {
            i = 1;
        } else if ("elegant".equals(str2)) {
            i = 2;
        }
        this.mNativePtr = nCreateFamily(str, i);
        if (this.mNativePtr == 0) {
            throw new IllegalStateException("error creating native FontFamily");
        }
    }

    private static native boolean nAddFont(long j, String str);

    private static native boolean nAddFontFromAsset(long j, AssetManager assetManager, String str);

    private static native boolean nAddFontWeightStyle(long j, String str, int i, boolean z);

    private static native long nCreateFamily(String str, int i);

    private static native void nUnrefFamily(long j);

    public boolean addFont(String str) {
        return nAddFont(this.mNativePtr, str);
    }

    public boolean addFontFromAsset(AssetManager assetManager, String str) {
        return nAddFontFromAsset(this.mNativePtr, assetManager, str);
    }

    public boolean addFontWeightStyle(String str, int i, boolean z) {
        return nAddFontWeightStyle(this.mNativePtr, str, i, z);
    }

    protected void finalize() throws Throwable {
        try {
            nUnrefFamily(this.mNativePtr);
        } finally {
            super.finalize();
        }
    }
}
