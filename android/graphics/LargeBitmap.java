package android.graphics;

import android.graphics.BitmapFactory;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/LargeBitmap.class */
public final class LargeBitmap {
    private long mNativeLargeBitmap;
    private boolean mRecycled = false;

    private LargeBitmap(long j) {
        this.mNativeLargeBitmap = j;
    }

    private void checkRecycled(String str) {
        if (this.mRecycled) {
            throw new IllegalStateException(str);
        }
    }

    private static native void nativeClean(long j);

    private static native Bitmap nativeDecodeRegion(long j, int i, int i2, int i3, int i4, BitmapFactory.Options options);

    private static native int nativeGetHeight(long j);

    private static native int nativeGetWidth(long j);

    public Bitmap decodeRegion(Rect rect, BitmapFactory.Options options) {
        checkRecycled("decodeRegion called on recycled large bitmap");
        if (rect.left < 0 || rect.top < 0 || rect.right > getWidth() || rect.bottom > getHeight()) {
            throw new IllegalArgumentException("rectangle is not inside the image");
        }
        return nativeDecodeRegion(this.mNativeLargeBitmap, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top, options);
    }

    protected void finalize() {
        recycle();
    }

    public int getHeight() {
        checkRecycled("getHeight called on recycled large bitmap");
        return nativeGetHeight(this.mNativeLargeBitmap);
    }

    public int getWidth() {
        checkRecycled("getWidth called on recycled large bitmap");
        return nativeGetWidth(this.mNativeLargeBitmap);
    }

    public final boolean isRecycled() {
        return this.mRecycled;
    }

    public void recycle() {
        if (this.mRecycled) {
            return;
        }
        nativeClean(this.mNativeLargeBitmap);
        this.mRecycled = true;
    }
}
