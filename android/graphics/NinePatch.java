package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/NinePatch.class */
public class NinePatch {
    private final Bitmap mBitmap;
    public final long mNativeChunk;
    private Paint mPaint;
    private String mSrcName;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/NinePatch$InsetStruct.class */
    public static class InsetStruct {
        public final Rect opticalRect;
        public final float outlineAlpha;
        public final float outlineRadius;
        public final Rect outlineRect;

        InsetStruct(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, int i9, float f2) {
            this.opticalRect = new Rect(i, i2, i3, i4);
            this.outlineRect = new Rect(i5, i6, i7, i8);
            if (f2 != 1.0f) {
                this.opticalRect.scale(f2);
                this.outlineRect.scaleRoundIn(f2);
            }
            this.outlineRadius = f * f2;
            this.outlineAlpha = i9 / 255.0f;
        }
    }

    public NinePatch(Bitmap bitmap, byte[] bArr) {
        this(bitmap, bArr, null);
    }

    public NinePatch(Bitmap bitmap, byte[] bArr, String str) {
        this.mBitmap = bitmap;
        this.mSrcName = str;
        this.mNativeChunk = validateNinePatchChunk(this.mBitmap.ni(), bArr);
    }

    public NinePatch(NinePatch ninePatch) {
        this.mBitmap = ninePatch.mBitmap;
        this.mSrcName = ninePatch.mSrcName;
        if (ninePatch.mPaint != null) {
            this.mPaint = new Paint(ninePatch.mPaint);
        }
        this.mNativeChunk = ninePatch.mNativeChunk;
    }

    public static native boolean isNinePatchChunk(byte[] bArr);

    private static native void nativeDraw(long j, Rect rect, long j2, long j3, long j4, int i, int i2);

    private static native void nativeDraw(long j, RectF rectF, long j2, long j3, long j4, int i, int i2);

    private static native void nativeFinalize(long j);

    private static native long nativeGetTransparentRegion(long j, long j2, Rect rect);

    private static native long validateNinePatchChunk(long j, byte[] bArr);

    public void draw(Canvas canvas, Rect rect) {
        canvas.drawPatch(this, rect, this.mPaint);
    }

    public void draw(Canvas canvas, Rect rect, Paint paint) {
        canvas.drawPatch(this, rect, paint);
    }

    public void draw(Canvas canvas, RectF rectF) {
        canvas.drawPatch(this, rectF, this.mPaint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawSoftware(Canvas canvas, Rect rect, Paint paint) {
        nativeDraw(canvas.getNativeCanvasWrapper(), rect, this.mBitmap.ni(), this.mNativeChunk, paint != null ? paint.mNativePaint : 0L, canvas.mDensity, this.mBitmap.mDensity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawSoftware(Canvas canvas, RectF rectF, Paint paint) {
        nativeDraw(canvas.getNativeCanvasWrapper(), rectF, this.mBitmap.ni(), this.mNativeChunk, paint != null ? paint.mNativePaint : 0L, canvas.mDensity, this.mBitmap.mDensity);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mNativeChunk != 0) {
                nativeFinalize(this.mNativeChunk);
            }
        } finally {
            super.finalize();
        }
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public int getDensity() {
        return this.mBitmap.mDensity;
    }

    public int getHeight() {
        return this.mBitmap.getHeight();
    }

    public String getName() {
        return this.mSrcName;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public final Region getTransparentRegion(Rect rect) {
        long nativeGetTransparentRegion = nativeGetTransparentRegion(this.mBitmap.ni(), this.mNativeChunk, rect);
        if (nativeGetTransparentRegion != 0) {
            return new Region(nativeGetTransparentRegion);
        }
        return null;
    }

    public int getWidth() {
        return this.mBitmap.getWidth();
    }

    public final boolean hasAlpha() {
        return this.mBitmap.hasAlpha();
    }

    public void setPaint(Paint paint) {
        this.mPaint = paint;
    }
}
