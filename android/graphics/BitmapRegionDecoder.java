package android.graphics;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/BitmapRegionDecoder.class */
public final class BitmapRegionDecoder {
    private long mNativeBitmapRegionDecoder;
    private final Object mNativeLock = new Object();
    private boolean mRecycled = false;

    private BitmapRegionDecoder(long j) {
        this.mNativeBitmapRegionDecoder = j;
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

    private static native BitmapRegionDecoder nativeNewInstance(long j, boolean z);

    private static native BitmapRegionDecoder nativeNewInstance(FileDescriptor fileDescriptor, boolean z);

    private static native BitmapRegionDecoder nativeNewInstance(InputStream inputStream, byte[] bArr, boolean z);

    private static native BitmapRegionDecoder nativeNewInstance(byte[] bArr, int i, int i2, boolean z);

    private static native BitmapRegionDecoder nativeNewInstanceFromDrmFileDescriptor(FileDescriptor fileDescriptor, boolean z);

    public static BitmapRegionDecoder newInstance(FileDescriptor fileDescriptor, boolean z) throws IOException {
        return nativeNewInstance(fileDescriptor, z);
    }

    public static BitmapRegionDecoder newInstance(InputStream inputStream, boolean z) throws IOException {
        return inputStream instanceof AssetManager.AssetInputStream ? nativeNewInstance(((AssetManager.AssetInputStream) inputStream).getNativeAsset(), z) : nativeNewInstance(inputStream, new byte[16384], z);
    }

    public static BitmapRegionDecoder newInstance(String str, boolean z) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                BitmapRegionDecoder newInstance = newInstance(fileInputStream2, z);
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                        return newInstance;
                    }
                }
                return newInstance;
            } catch (Throwable th) {
                fileInputStream = fileInputStream2;
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static BitmapRegionDecoder newInstance(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if ((i | i2) < 0 || bArr.length < i + i2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return nativeNewInstance(bArr, i, i2, z);
    }

    public static BitmapRegionDecoder newInstanceDrmFile(String str, boolean z) throws IOException {
        BitmapRegionDecoder bitmapRegionDecoder;
        FileDescriptor fileDescriptor = null;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File file = new File(str);
                FileInputStream fileInputStream3 = null;
                if (file.exists()) {
                    fileInputStream3 = new FileInputStream(file);
                    try {
                        fileDescriptor = fileInputStream3.getFD();
                    } catch (IOException e) {
                        fileInputStream = fileInputStream3;
                        e = e;
                        Log.e("BitmapRegionDecoder", "Unable to decode drm file: " + e);
                        bitmapRegionDecoder = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return null;
                            } catch (IOException e2) {
                                Log.e("BitmapRegionDecoder", "Unable to close drm file: " + e2);
                                return null;
                            }
                        }
                        return bitmapRegionDecoder;
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream3;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                Log.e("BitmapRegionDecoder", "Unable to close drm file: " + e3);
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream = fileInputStream3;
                BitmapRegionDecoder nativeNewInstanceFromDrmFileDescriptor = nativeNewInstanceFromDrmFileDescriptor(fileDescriptor, z);
                bitmapRegionDecoder = nativeNewInstanceFromDrmFileDescriptor;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                        bitmapRegionDecoder = nativeNewInstanceFromDrmFileDescriptor;
                    } catch (IOException e4) {
                        Log.e("BitmapRegionDecoder", "Unable to close drm file: " + e4);
                        return nativeNewInstanceFromDrmFileDescriptor;
                    }
                }
            } catch (IOException e5) {
                e = e5;
            }
            return bitmapRegionDecoder;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public Bitmap decodeRegion(Rect rect, BitmapFactory.Options options) {
        Bitmap nativeDecodeRegion;
        synchronized (this.mNativeLock) {
            checkRecycled("decodeRegion called on recycled region decoder");
            if (rect.right <= 0 || rect.bottom <= 0 || rect.left >= getWidth() || rect.top >= getHeight()) {
                throw new IllegalArgumentException("rectangle is outside the image");
            }
            nativeDecodeRegion = nativeDecodeRegion(this.mNativeBitmapRegionDecoder, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top, options);
        }
        return nativeDecodeRegion;
    }

    protected void finalize() throws Throwable {
        try {
            recycle();
        } finally {
            super.finalize();
        }
    }

    public int getHeight() {
        int nativeGetHeight;
        synchronized (this.mNativeLock) {
            checkRecycled("getHeight called on recycled region decoder");
            nativeGetHeight = nativeGetHeight(this.mNativeBitmapRegionDecoder);
        }
        return nativeGetHeight;
    }

    public int getWidth() {
        int nativeGetWidth;
        synchronized (this.mNativeLock) {
            checkRecycled("getWidth called on recycled region decoder");
            nativeGetWidth = nativeGetWidth(this.mNativeBitmapRegionDecoder);
        }
        return nativeGetWidth;
    }

    public final boolean isRecycled() {
        return this.mRecycled;
    }

    public void recycle() {
        synchronized (this.mNativeLock) {
            if (!this.mRecycled) {
                nativeClean(this.mNativeBitmapRegionDecoder);
                this.mRecycled = true;
            }
        }
    }
}
