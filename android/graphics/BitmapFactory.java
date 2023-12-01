package android.graphics;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Trace;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/BitmapFactory.class */
public class BitmapFactory {
    private static final int DECODE_BUFFER_SIZE = 16384;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/BitmapFactory$Options.class */
    public static class Options {
        public Bitmap inBitmap;
        public int inDensity;
        @Deprecated
        public boolean inInputShareable;
        public boolean inJustDecodeBounds;
        public boolean inMutable;
        public boolean inPreferQualityOverSpeed;
        @Deprecated
        public boolean inPurgeable;
        public int inSampleSize;
        public int inScreenDensity;
        public int inTargetDensity;
        public byte[] inTempStorage;
        public boolean mCancel;
        public int outHeight;
        public String outMimeType;
        public int outWidth;
        public Bitmap.Config inPreferredConfig = Bitmap.Config.ARGB_8888;
        public boolean inDither = false;
        public boolean inScaled = true;
        public boolean inPremultiplied = true;

        private native void requestCancel();

        public void requestCancelDecode() {
            this.mCancel = true;
            requestCancel();
        }
    }

    public static boolean consumeDrmImageRights(String str) {
        boolean z = false;
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
                        Log.e("BitmapFactory", "Unable to decode drm file: " + e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return false;
                            } catch (IOException e2) {
                                Log.e("BitmapFactory", "Unable to close drm file: " + e2);
                                return false;
                            }
                        }
                        return z;
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream3;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                Log.e("BitmapFactory", "Unable to close drm file: " + e3);
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream = fileInputStream3;
                boolean nativeConsumeDrmImageRights = nativeConsumeDrmImageRights(fileDescriptor);
                z = nativeConsumeDrmImageRights;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                        z = nativeConsumeDrmImageRights;
                    } catch (IOException e4) {
                        Log.e("BitmapFactory", "Unable to close drm file: " + e4);
                        return nativeConsumeDrmImageRights;
                    }
                }
            } catch (IOException e5) {
                e = e5;
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2) {
        return decodeByteArray(bArr, i, i2, null);
    }

    public static Bitmap decodeByteArray(byte[] bArr, int i, int i2, Options options) {
        if ((i | i2) < 0 || bArr.length < i + i2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Trace.traceBegin(2L, "decodeBitmap");
        try {
            Bitmap nativeDecodeByteArray = nativeDecodeByteArray(bArr, i, i2, options);
            if (nativeDecodeByteArray != null || options == null || options.inBitmap == null) {
                setDensityFromOptions(nativeDecodeByteArray, options);
                Trace.traceEnd(2L);
                return nativeDecodeByteArray;
            }
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        } catch (Throwable th) {
            Trace.traceEnd(2L);
            throw th;
        }
    }

    public static Bitmap decodeDrmFile(String str, Options options) {
        Bitmap bitmap;
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
                        Log.e("BitmapFactory", "Unable to decode drm file: " + e);
                        bitmap = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return null;
                            } catch (IOException e2) {
                                Log.e("BitmapFactory", "Unable to close drm file: " + e2);
                                return null;
                            }
                        }
                        return bitmap;
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream3;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                Log.e("BitmapFactory", "Unable to close drm file: " + e3);
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream = fileInputStream3;
                Bitmap nativeDecodeDrmFileDescriptor = nativeDecodeDrmFileDescriptor(fileDescriptor, options);
                bitmap = nativeDecodeDrmFileDescriptor;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                        bitmap = nativeDecodeDrmFileDescriptor;
                    } catch (IOException e4) {
                        Log.e("BitmapFactory", "Unable to close drm file: " + e4);
                        return nativeDecodeDrmFileDescriptor;
                    }
                }
            } catch (IOException e5) {
                e = e5;
            }
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap decodeFile(String str) {
        return decodeFile(str, null);
    }

    public static Bitmap decodeFile(String str, Options options) {
        FileInputStream fileInputStream;
        Bitmap bitmap;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    bitmap = decodeStream(fileInputStream, null, options);
                } catch (Exception e) {
                    e = e;
                    fileInputStream2 = fileInputStream;
                    Log.e("BitmapFactory", "Unable to decode stream: " + e);
                    bitmap = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return null;
                        } catch (IOException e2) {
                            return null;
                        }
                    }
                    return bitmap;
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                fileInputStream = null;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    return bitmap;
                } catch (IOException e5) {
                    return bitmap;
                }
            }
            return bitmap;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor) {
        return decodeFileDescriptor(fileDescriptor, null, null);
    }

    public static Bitmap decodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, Options options) {
        Bitmap decodeStreamInternal;
        Trace.traceBegin(2L, "decodeFileDescriptor");
        try {
            if (nativeIsSeekable(fileDescriptor)) {
                decodeStreamInternal = nativeDecodeFileDescriptor(fileDescriptor, rect, options);
            } else {
                FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
                decodeStreamInternal = decodeStreamInternal(fileInputStream, rect, options);
                try {
                    fileInputStream.close();
                } catch (Throwable th) {
                }
            }
            if (decodeStreamInternal != null || options == null || options.inBitmap == null) {
                setDensityFromOptions(decodeStreamInternal, options);
                Trace.traceEnd(2L);
                return decodeStreamInternal;
            }
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        } catch (Throwable th2) {
            Trace.traceEnd(2L);
            throw th2;
        }
    }

    public static Bitmap decodeResource(Resources resources, int i) {
        return decodeResource(resources, i, null);
    }

    public static Bitmap decodeResource(Resources resources, int i, Options options) {
        Bitmap bitmap;
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        try {
            TypedValue typedValue = new TypedValue();
            InputStream openRawResource = resources.openRawResource(i, typedValue);
            inputStream = openRawResource;
            inputStream2 = openRawResource;
            Bitmap decodeResourceStream = decodeResourceStream(resources, typedValue, openRawResource, null, options);
            bitmap = decodeResourceStream;
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                    bitmap = decodeResourceStream;
                } catch (IOException e) {
                    bitmap = decodeResourceStream;
                }
            }
        } catch (Exception e2) {
            bitmap = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                    bitmap = null;
                } catch (IOException e3) {
                    bitmap = null;
                }
            }
        } catch (Throwable th) {
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e4) {
                }
            }
            throw th;
        }
        if (bitmap != null || options == null || options.inBitmap == null) {
            return bitmap;
        }
        throw new IllegalArgumentException("Problem decoding into existing bitmap");
    }

    public static Bitmap decodeResourceStream(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, Options options) {
        Options options2 = options;
        if (options == null) {
            options2 = new Options();
        }
        if (options2.inDensity == 0 && typedValue != null) {
            int i = typedValue.density;
            if (i == 0) {
                options2.inDensity = 160;
            } else if (i != 65535) {
                options2.inDensity = i;
            }
        }
        if (options2.inTargetDensity == 0 && resources != null) {
            options2.inTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        return decodeStream(inputStream, rect, options2);
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        return decodeStream(inputStream, null, null);
    }

    public static Bitmap decodeStream(InputStream inputStream, Rect rect, Options options) {
        if (inputStream == null) {
            return null;
        }
        Trace.traceBegin(2L, "decodeBitmap");
        try {
            Bitmap nativeDecodeAsset = inputStream instanceof AssetManager.AssetInputStream ? nativeDecodeAsset(((AssetManager.AssetInputStream) inputStream).getNativeAsset(), rect, options) : decodeStreamInternal(inputStream, rect, options);
            if (nativeDecodeAsset != null || options == null || options.inBitmap == null) {
                setDensityFromOptions(nativeDecodeAsset, options);
                Trace.traceEnd(2L);
                return nativeDecodeAsset;
            }
            throw new IllegalArgumentException("Problem decoding into existing bitmap");
        } catch (Throwable th) {
            Trace.traceEnd(2L);
            throw th;
        }
    }

    private static Bitmap decodeStreamInternal(InputStream inputStream, Rect rect, Options options) {
        byte[] bArr = null;
        if (options != null) {
            bArr = options.inTempStorage;
        }
        byte[] bArr2 = bArr;
        if (bArr == null) {
            bArr2 = new byte[16384];
        }
        return nativeDecodeStream(inputStream, bArr2, rect, options);
    }

    public static byte[] getDrmImageBytes(String str) {
        byte[] bArr;
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
                        fileInputStream2 = fileInputStream;
                        Log.e("BitmapFactory", "Unable to decode drm file: " + e);
                        bArr = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return null;
                            } catch (IOException e2) {
                                Log.e("BitmapFactory", "Unable to close drm file: " + e2);
                                return null;
                            }
                        }
                        return bArr;
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream3;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e3) {
                                Log.e("BitmapFactory", "Unable to close drm file: " + e3);
                            }
                        }
                        throw th;
                    }
                }
                fileInputStream = fileInputStream3;
                byte[] nativeGetDrmImageBytes = nativeGetDrmImageBytes(fileDescriptor);
                bArr = nativeGetDrmImageBytes;
                if (fileInputStream3 != null) {
                    try {
                        fileInputStream3.close();
                        bArr = nativeGetDrmImageBytes;
                    } catch (IOException e4) {
                        Log.e("BitmapFactory", "Unable to close drm file: " + e4);
                        return nativeGetDrmImageBytes;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
        return bArr;
    }

    private static native boolean nativeConsumeDrmImageRights(FileDescriptor fileDescriptor);

    private static native Bitmap nativeDecodeAsset(long j, Rect rect, Options options);

    private static native Bitmap nativeDecodeByteArray(byte[] bArr, int i, int i2, Options options);

    private static native Bitmap nativeDecodeDrmFileDescriptor(FileDescriptor fileDescriptor, Options options);

    private static native Bitmap nativeDecodeFileDescriptor(FileDescriptor fileDescriptor, Rect rect, Options options);

    private static native Bitmap nativeDecodeStream(InputStream inputStream, byte[] bArr, Rect rect, Options options);

    private static native byte[] nativeGetDrmImageBytes(FileDescriptor fileDescriptor);

    private static native boolean nativeIsSeekable(FileDescriptor fileDescriptor);

    private static void setDensityFromOptions(Bitmap bitmap, Options options) {
        if (bitmap == null || options == null) {
            return;
        }
        int i = options.inDensity;
        if (i == 0) {
            if (options.inBitmap != null) {
                bitmap.setDensity(Bitmap.getDefaultDensity());
                return;
            }
            return;
        }
        bitmap.setDensity(i);
        int i2 = options.inTargetDensity;
        if (i2 == 0 || i == i2 || i == options.inScreenDensity) {
            return;
        }
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        boolean z = ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk);
        if (options.inScaled || z) {
            bitmap.setDensity(i2);
        }
    }
}
