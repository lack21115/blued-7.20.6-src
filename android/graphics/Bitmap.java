package android.graphics;

import android.graphics.NinePatch;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import android.util.DisplayMetrics;
import dalvik.system.VMRuntime;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Bitmap.class */
public final class Bitmap implements Parcelable {
    public static final int DENSITY_NONE = 0;
    private static final int WORKING_COMPRESS_STORAGE = 4096;
    private static volatile Matrix sScaleMatrix;
    private byte[] mBuffer;
    int mDensity;
    private final BitmapFinalizer mFinalizer;
    private int mHeight;
    private final boolean mIsMutable;
    public final long mNativeBitmap;
    private byte[] mNinePatchChunk;
    private NinePatch.InsetStruct mNinePatchInsets;
    private boolean mRecycled;
    private boolean mRequestPremultiplied;
    private int mWidth;
    private static volatile int sDefaultDensity = -1;
    public static final Parcelable.Creator<Bitmap> CREATOR = new Parcelable.Creator<Bitmap>() { // from class: android.graphics.Bitmap.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Bitmap createFromParcel(Parcel parcel) {
            Bitmap nativeCreateFromParcel = Bitmap.nativeCreateFromParcel(parcel);
            if (nativeCreateFromParcel == null) {
                throw new RuntimeException("Failed to unparcel Bitmap");
            }
            return nativeCreateFromParcel;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Bitmap[] newArray(int i) {
            return new Bitmap[i];
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.graphics.Bitmap$2  reason: invalid class name */
    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Bitmap$2.class */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0038 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003c -> B:21:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0040 -> B:19:0x0014). Please submit an issue!!! */
        static {
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.RGB_565.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Bitmap$BitmapFinalizer.class */
    private static class BitmapFinalizer {
        private final int mNativeAllocationByteCount;
        private long mNativeBitmap;

        BitmapFinalizer(long j, int i) {
            this.mNativeBitmap = j;
            this.mNativeAllocationByteCount = i;
            if (this.mNativeAllocationByteCount != 0) {
                VMRuntime.getRuntime().registerNativeAllocation(this.mNativeAllocationByteCount);
            }
        }

        public void finalize() {
            try {
                super.finalize();
                if (this.mNativeAllocationByteCount != 0) {
                    VMRuntime.getRuntime().registerNativeFree(this.mNativeAllocationByteCount);
                }
                Bitmap.nativeDestructor(this.mNativeBitmap);
                this.mNativeBitmap = 0L;
            } catch (Throwable th) {
                if (this.mNativeAllocationByteCount != 0) {
                    VMRuntime.getRuntime().registerNativeFree(this.mNativeAllocationByteCount);
                }
                Bitmap.nativeDestructor(this.mNativeBitmap);
                this.mNativeBitmap = 0L;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Bitmap$CompressFormat.class */
    public enum CompressFormat {
        JPEG(0),
        PNG(1),
        WEBP(2);
        
        final int nativeInt;

        CompressFormat(int i) {
            this.nativeInt = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Bitmap$Config.class */
    public enum Config {
        ALPHA_8(1),
        RGB_565(3),
        ARGB_4444(4),
        ARGB_8888(5);
        
        final int nativeInt;
        private static Config[] sConfigs = {null, ALPHA_8, null, RGB_565, ARGB_4444, ARGB_8888};

        Config(int i) {
            this.nativeInt = i;
        }

        static Config nativeToConfig(int i) {
            return sConfigs[i];
        }
    }

    Bitmap(long j, byte[] bArr, int i, int i2, int i3, boolean z, boolean z2, byte[] bArr2, NinePatch.InsetStruct insetStruct) {
        this.mDensity = getDefaultDensity();
        if (j == 0) {
            throw new RuntimeException("internal error: native bitmap is 0");
        }
        this.mWidth = i;
        this.mHeight = i2;
        this.mIsMutable = z;
        this.mRequestPremultiplied = z2;
        this.mBuffer = bArr;
        this.mNativeBitmap = j;
        this.mNinePatchChunk = bArr2;
        this.mNinePatchInsets = insetStruct;
        if (i3 >= 0) {
            this.mDensity = i3;
        }
        this.mFinalizer = new BitmapFinalizer(j, bArr == null ? getByteCount() : 0);
    }

    private void checkPixelAccess(int i, int i2) {
        checkXYSign(i, i2);
        if (i >= getWidth()) {
            throw new IllegalArgumentException("x must be < bitmap.width()");
        }
        if (i2 >= getHeight()) {
            throw new IllegalArgumentException("y must be < bitmap.height()");
        }
    }

    private void checkPixelsAccess(int i, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        checkXYSign(i, i2);
        if (i3 < 0) {
            throw new IllegalArgumentException("width must be >= 0");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("height must be >= 0");
        }
        if (i + i3 > getWidth()) {
            throw new IllegalArgumentException("x + width must be <= bitmap.width()");
        }
        if (i2 + i4 > getHeight()) {
            throw new IllegalArgumentException("y + height must be <= bitmap.height()");
        }
        if (Math.abs(i6) < i3) {
            throw new IllegalArgumentException("abs(stride) must be >= width");
        }
        int i7 = i5 + ((i4 - 1) * i6);
        int length = iArr.length;
        if (i5 < 0 || i5 + i3 > length || i7 < 0 || i7 + i3 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void checkRecycled(String str) {
        if (this.mRecycled) {
            throw new IllegalStateException(str);
        }
    }

    private static void checkWidthHeight(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException("width must be > 0");
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("height must be > 0");
        }
    }

    private static void checkXYSign(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("x must be >= 0");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("y must be >= 0");
        }
    }

    public static Bitmap createBitmap(int i, int i2, Config config) {
        return createBitmap(i, i2, config, true);
    }

    private static Bitmap createBitmap(int i, int i2, Config config, boolean z) {
        return createBitmap((DisplayMetrics) null, i, i2, config, z);
    }

    public static Bitmap createBitmap(Bitmap bitmap) {
        return createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight());
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4) {
        return createBitmap(bitmap, i, i2, i3, i4, (Matrix) null, false);
    }

    public static Bitmap createBitmap(Bitmap bitmap, int i, int i2, int i3, int i4, Matrix matrix, boolean z) {
        Bitmap createBitmap;
        Paint paint;
        checkXYSign(i, i2);
        checkWidthHeight(i3, i4);
        if (i + i3 > bitmap.getWidth()) {
            throw new IllegalArgumentException("x + width must be <= bitmap.width()");
        }
        if (i2 + i4 > bitmap.getHeight()) {
            throw new IllegalArgumentException("y + height must be <= bitmap.height()");
        }
        if (!bitmap.isMutable() && i == 0 && i2 == 0 && i3 == bitmap.getWidth() && i4 == bitmap.getHeight() && (matrix == null || matrix.isIdentity())) {
            return bitmap;
        }
        Canvas canvas = new Canvas();
        Rect rect = new Rect(i, i2, i + i3, i2 + i4);
        RectF rectF = new RectF(0.0f, 0.0f, i3, i4);
        Config config = Config.ARGB_8888;
        Config config2 = bitmap.getConfig();
        if (config2 != null) {
            switch (AnonymousClass2.$SwitchMap$android$graphics$Bitmap$Config[config2.ordinal()]) {
                case 1:
                    config = Config.RGB_565;
                    break;
                case 2:
                    config = Config.ALPHA_8;
                    break;
                default:
                    config = Config.ARGB_8888;
                    break;
            }
        }
        if (matrix == null || matrix.isIdentity()) {
            createBitmap = createBitmap(i3, i4, config, bitmap.hasAlpha());
            paint = null;
        } else {
            boolean z2 = !matrix.rectStaysRect();
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            int round = Math.round(rectF2.width());
            int round2 = Math.round(rectF2.height());
            if (z2) {
                config = Config.ARGB_8888;
            }
            Bitmap createBitmap2 = createBitmap(round, round2, config, z2 || bitmap.hasAlpha());
            canvas.translate(-rectF2.left, -rectF2.top);
            canvas.concat(matrix);
            Paint paint2 = new Paint();
            paint2.setFilterBitmap(z);
            createBitmap = createBitmap2;
            paint = paint2;
            if (z2) {
                paint2.setAntiAlias(true);
                createBitmap = createBitmap2;
                paint = paint2;
            }
        }
        createBitmap.mDensity = bitmap.mDensity;
        createBitmap.setHasAlpha(bitmap.hasAlpha());
        createBitmap.setPremultiplied(bitmap.mRequestPremultiplied);
        canvas.setBitmap(createBitmap);
        canvas.drawBitmap(bitmap, rect, rectF, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static Bitmap createBitmap(DisplayMetrics displayMetrics, int i, int i2, Config config) {
        return createBitmap(displayMetrics, i, i2, config, true);
    }

    private static Bitmap createBitmap(DisplayMetrics displayMetrics, int i, int i2, Config config, boolean z) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("width and height must be > 0");
        }
        Bitmap nativeCreate = nativeCreate(null, 0, i, i, i2, config.nativeInt, true);
        if (displayMetrics != null) {
            nativeCreate.mDensity = displayMetrics.densityDpi;
        }
        nativeCreate.setHasAlpha(z);
        if (config == Config.ARGB_8888 && !z) {
            nativeErase(nativeCreate.mNativeBitmap, -16777216);
        }
        return nativeCreate;
    }

    public static Bitmap createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, int i3, int i4, Config config) {
        checkWidthHeight(i3, i4);
        if (Math.abs(i2) < i3) {
            throw new IllegalArgumentException("abs(stride) must be >= width");
        }
        int i5 = i + ((i4 - 1) * i2);
        int length = iArr.length;
        if (i < 0 || i + i3 > length || i5 < 0 || i5 + i3 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (i3 <= 0 || i4 <= 0) {
            throw new IllegalArgumentException("width and height must be > 0");
        }
        Bitmap nativeCreate = nativeCreate(iArr, i, i2, i3, i4, config.nativeInt, false);
        if (displayMetrics != null) {
            nativeCreate.mDensity = displayMetrics.densityDpi;
        }
        return nativeCreate;
    }

    public static Bitmap createBitmap(DisplayMetrics displayMetrics, int[] iArr, int i, int i2, Config config) {
        return createBitmap(displayMetrics, iArr, 0, i, i, i2, config);
    }

    public static Bitmap createBitmap(int[] iArr, int i, int i2, int i3, int i4, Config config) {
        return createBitmap((DisplayMetrics) null, iArr, i, i2, i3, i4, config);
    }

    public static Bitmap createBitmap(int[] iArr, int i, int i2, Config config) {
        return createBitmap((DisplayMetrics) null, iArr, 0, i, i, i2, config);
    }

    public static Bitmap createScaledBitmap(Bitmap bitmap, int i, int i2, boolean z) {
        Matrix matrix;
        synchronized (Bitmap.class) {
            try {
                matrix = sScaleMatrix;
                sScaleMatrix = null;
            } finally {
            }
        }
        Matrix matrix2 = matrix;
        if (matrix == null) {
            matrix2 = new Matrix();
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        matrix2.setScale(i / width, i2 / height);
        Bitmap createBitmap = createBitmap(bitmap, 0, 0, width, height, matrix2, z);
        synchronized (Bitmap.class) {
            try {
                if (sScaleMatrix == null) {
                    sScaleMatrix = matrix2;
                }
            } finally {
            }
        }
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDefaultDensity() {
        if (sDefaultDensity >= 0) {
            return sDefaultDensity;
        }
        sDefaultDensity = DisplayMetrics.DENSITY_DEVICE;
        return sDefaultDensity;
    }

    private static native boolean nativeCompress(long j, int i, int i2, OutputStream outputStream, byte[] bArr);

    private static native int nativeConfig(long j);

    private static native Bitmap nativeCopy(long j, int i, boolean z);

    private static native void nativeCopyPixelsFromBuffer(long j, Buffer buffer);

    private static native void nativeCopyPixelsToBuffer(long j, Buffer buffer);

    private static native Bitmap nativeCreate(int[] iArr, int i, int i2, int i3, int i4, int i5, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Bitmap nativeCreateFromParcel(Parcel parcel);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeDestructor(long j);

    private static native void nativeErase(long j, int i);

    private static native Bitmap nativeExtractAlpha(long j, long j2, int[] iArr);

    private static native int nativeGenerationId(long j);

    private static native int nativeGetPixel(long j, int i, int i2);

    private static native void nativeGetPixels(long j, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    private static native boolean nativeHasAlpha(long j);

    private static native boolean nativeHasMipMap(long j);

    private static native boolean nativeIsPremultiplied(long j);

    private static native void nativePrepareToDraw(long j);

    private static native void nativeReconfigure(long j, int i, int i2, int i3, int i4, boolean z);

    private static native boolean nativeRecycle(long j);

    private static native int nativeRowBytes(long j);

    private static native boolean nativeSameAs(long j, long j2);

    private static native void nativeSetHasAlpha(long j, boolean z, boolean z2);

    private static native void nativeSetHasMipMap(long j, boolean z);

    private static native void nativeSetPixel(long j, int i, int i2, int i3);

    private static native void nativeSetPixels(long j, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6);

    private static native void nativeSetPremultiplied(long j, boolean z);

    private static native boolean nativeWriteToParcel(long j, boolean z, int i, Parcel parcel);

    public static int scaleFromDensity(int i, int i2, int i3) {
        return (i2 == 0 || i3 == 0 || i2 == i3) ? i : ((i * i3) + (i2 >> 1)) / i2;
    }

    public static void setDefaultDensity(int i) {
        sDefaultDensity = i;
    }

    public boolean compress(CompressFormat compressFormat, int i, OutputStream outputStream) {
        checkRecycled("Can't compress a recycled bitmap");
        if (outputStream == null) {
            throw new NullPointerException();
        }
        if (i < 0 || i > 100) {
            throw new IllegalArgumentException("quality must be 0..100");
        }
        Trace.traceBegin(8192L, "Bitmap.compress");
        boolean nativeCompress = nativeCompress(this.mNativeBitmap, compressFormat.nativeInt, i, outputStream, new byte[4096]);
        Trace.traceEnd(8192L);
        return nativeCompress;
    }

    public Bitmap copy(Config config, boolean z) {
        checkRecycled("Can't copy a recycled bitmap");
        Bitmap nativeCopy = nativeCopy(this.mNativeBitmap, config.nativeInt, z);
        if (nativeCopy != null) {
            nativeCopy.setPremultiplied(this.mRequestPremultiplied);
            nativeCopy.mDensity = this.mDensity;
        }
        return nativeCopy;
    }

    public void copyPixelsFromBuffer(Buffer buffer) {
        char c2;
        checkRecycled("copyPixelsFromBuffer called on recycled bitmap");
        int remaining = buffer.remaining();
        if (buffer instanceof ByteBuffer) {
            c2 = 0;
        } else if (buffer instanceof ShortBuffer) {
            c2 = 1;
        } else if (!(buffer instanceof IntBuffer)) {
            throw new RuntimeException("unsupported Buffer subclass");
        } else {
            c2 = 2;
        }
        long j = remaining;
        long byteCount = getByteCount();
        if ((j << c2) < byteCount) {
            throw new RuntimeException("Buffer not large enough for pixels");
        }
        nativeCopyPixelsFromBuffer(this.mNativeBitmap, buffer);
        buffer.position((int) (buffer.position() + (byteCount >> c2)));
    }

    public void copyPixelsToBuffer(Buffer buffer) {
        char c2;
        int remaining = buffer.remaining();
        if (buffer instanceof ByteBuffer) {
            c2 = 0;
        } else if (buffer instanceof ShortBuffer) {
            c2 = 1;
        } else if (!(buffer instanceof IntBuffer)) {
            throw new RuntimeException("unsupported Buffer subclass");
        } else {
            c2 = 2;
        }
        long j = remaining;
        long byteCount = getByteCount();
        if ((j << c2) < byteCount) {
            throw new RuntimeException("Buffer not large enough for pixels");
        }
        nativeCopyPixelsToBuffer(this.mNativeBitmap, buffer);
        buffer.position((int) (buffer.position() + (byteCount >> c2)));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void eraseColor(int i) {
        checkRecycled("Can't erase a recycled bitmap");
        if (!isMutable()) {
            throw new IllegalStateException("cannot erase immutable bitmaps");
        }
        nativeErase(this.mNativeBitmap, i);
    }

    public Bitmap extractAlpha() {
        return extractAlpha(null, null);
    }

    public Bitmap extractAlpha(Paint paint, int[] iArr) {
        checkRecycled("Can't extractAlpha on a recycled bitmap");
        Bitmap nativeExtractAlpha = nativeExtractAlpha(this.mNativeBitmap, paint != null ? paint.mNativePaint : 0L, iArr);
        if (nativeExtractAlpha == null) {
            throw new RuntimeException("Failed to extractAlpha on Bitmap");
        }
        nativeExtractAlpha.mDensity = this.mDensity;
        return nativeExtractAlpha;
    }

    public final int getAllocationByteCount() {
        return this.mBuffer == null ? getByteCount() : this.mBuffer.length;
    }

    public final int getByteCount() {
        return getRowBytes() * getHeight();
    }

    public final Config getConfig() {
        return Config.nativeToConfig(nativeConfig(this.mNativeBitmap));
    }

    public int getDensity() {
        return this.mDensity;
    }

    public int getGenerationId() {
        return nativeGenerationId(this.mNativeBitmap);
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public byte[] getNinePatchChunk() {
        return this.mNinePatchChunk;
    }

    public NinePatch.InsetStruct getNinePatchInsets() {
        return this.mNinePatchInsets;
    }

    public void getOpticalInsets(Rect rect) {
        if (this.mNinePatchInsets == null) {
            rect.setEmpty();
        } else {
            rect.set(this.mNinePatchInsets.opticalRect);
        }
    }

    public int getPixel(int i, int i2) {
        checkRecycled("Can't call getPixel() on a recycled bitmap");
        checkPixelAccess(i, i2);
        return nativeGetPixel(this.mNativeBitmap, i, i2);
    }

    public void getPixels(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        checkRecycled("Can't call getPixels() on a recycled bitmap");
        if (i5 == 0 || i6 == 0) {
            return;
        }
        checkPixelsAccess(i3, i4, i5, i6, i, i2, iArr);
        nativeGetPixels(this.mNativeBitmap, iArr, i, i2, i3, i4, i5, i6);
    }

    public final int getRowBytes() {
        return nativeRowBytes(this.mNativeBitmap);
    }

    public int getScaledHeight(int i) {
        return scaleFromDensity(getHeight(), this.mDensity, i);
    }

    public int getScaledHeight(Canvas canvas) {
        return scaleFromDensity(getHeight(), this.mDensity, canvas.mDensity);
    }

    public int getScaledHeight(DisplayMetrics displayMetrics) {
        return scaleFromDensity(getHeight(), this.mDensity, displayMetrics.densityDpi);
    }

    public int getScaledWidth(int i) {
        return scaleFromDensity(getWidth(), this.mDensity, i);
    }

    public int getScaledWidth(Canvas canvas) {
        return scaleFromDensity(getWidth(), this.mDensity, canvas.mDensity);
    }

    public int getScaledWidth(DisplayMetrics displayMetrics) {
        return scaleFromDensity(getWidth(), this.mDensity, displayMetrics.densityDpi);
    }

    public final int getWidth() {
        return this.mWidth;
    }

    public final boolean hasAlpha() {
        return nativeHasAlpha(this.mNativeBitmap);
    }

    public final boolean hasMipMap() {
        return nativeHasMipMap(this.mNativeBitmap);
    }

    public final boolean isMutable() {
        return this.mIsMutable;
    }

    public final boolean isPremultiplied() {
        return nativeIsPremultiplied(this.mNativeBitmap);
    }

    public final boolean isRecycled() {
        return this.mRecycled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long ni() {
        return this.mNativeBitmap;
    }

    public void prepareToDraw() {
        nativePrepareToDraw(this.mNativeBitmap);
    }

    public void reconfigure(int i, int i2, Config config) {
        checkRecycled("Can't call reconfigure() on a recycled bitmap");
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("width and height must be > 0");
        }
        if (!isMutable()) {
            throw new IllegalStateException("only mutable bitmaps may be reconfigured");
        }
        if (this.mBuffer == null) {
            throw new IllegalStateException("native-backed bitmaps may not be reconfigured");
        }
        nativeReconfigure(this.mNativeBitmap, i, i2, config.nativeInt, this.mBuffer.length, this.mRequestPremultiplied);
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void recycle() {
        if (this.mRecycled || this.mFinalizer.mNativeBitmap == 0) {
            return;
        }
        if (nativeRecycle(this.mNativeBitmap)) {
            this.mBuffer = null;
            this.mNinePatchChunk = null;
        }
        this.mRecycled = true;
    }

    void reinit(int i, int i2, boolean z) {
        this.mWidth = i;
        this.mHeight = i2;
        this.mRequestPremultiplied = z;
    }

    public boolean sameAs(Bitmap bitmap) {
        if (this != bitmap) {
            return bitmap != null && nativeSameAs(this.mNativeBitmap, bitmap.mNativeBitmap);
        }
        return true;
    }

    public void setConfig(Config config) {
        reconfigure(getWidth(), getHeight(), config);
    }

    public void setDensity(int i) {
        this.mDensity = i;
    }

    public void setHasAlpha(boolean z) {
        nativeSetHasAlpha(this.mNativeBitmap, z, this.mRequestPremultiplied);
    }

    public final void setHasMipMap(boolean z) {
        nativeSetHasMipMap(this.mNativeBitmap, z);
    }

    public void setHeight(int i) {
        reconfigure(getWidth(), i, getConfig());
    }

    public void setNinePatchChunk(byte[] bArr) {
        this.mNinePatchChunk = bArr;
    }

    public void setPixel(int i, int i2, int i3) {
        checkRecycled("Can't call setPixel() on a recycled bitmap");
        if (!isMutable()) {
            throw new IllegalStateException();
        }
        checkPixelAccess(i, i2);
        nativeSetPixel(this.mNativeBitmap, i, i2, i3);
    }

    public void setPixels(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        checkRecycled("Can't call setPixels() on a recycled bitmap");
        if (!isMutable()) {
            throw new IllegalStateException();
        }
        if (i5 == 0 || i6 == 0) {
            return;
        }
        checkPixelsAccess(i3, i4, i5, i6, i, i2, iArr);
        nativeSetPixels(this.mNativeBitmap, iArr, i, i2, i3, i4, i5, i6);
    }

    public final void setPremultiplied(boolean z) {
        this.mRequestPremultiplied = z;
        nativeSetPremultiplied(this.mNativeBitmap, z);
    }

    public void setWidth(int i) {
        reconfigure(i, getHeight(), getConfig());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        checkRecycled("Can't parcel a recycled bitmap");
        if (!nativeWriteToParcel(this.mNativeBitmap, this.mIsMutable, this.mDensity, parcel)) {
            throw new RuntimeException("native writeToParcel failed");
        }
    }
}
