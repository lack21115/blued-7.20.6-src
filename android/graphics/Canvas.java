package android.graphics;

import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Region;
import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;
import javax.microedition.khronos.opengles.GL;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Canvas.class */
public class Canvas {
    public static final int ALL_SAVE_FLAG = 31;
    public static final int CLIP_SAVE_FLAG = 2;
    public static final int CLIP_TO_LAYER_SAVE_FLAG = 16;
    public static final int DIRECTION_LTR = 0;
    public static final int DIRECTION_RTL = 1;
    public static final int FULL_COLOR_LAYER_SAVE_FLAG = 8;
    public static final int HAS_ALPHA_LAYER_SAVE_FLAG = 4;
    public static final int MATRIX_SAVE_FLAG = 1;
    private static final int MAXMIMUM_BITMAP_SIZE = 32766;
    private Bitmap mBitmap;
    protected int mDensity;
    private DrawFilter mDrawFilter;
    private final CanvasFinalizer mFinalizer;
    private long mNativeCanvasWrapper;
    protected int mScreenDensity;
    private int mSurfaceFormat;

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Canvas$CanvasFinalizer.class */
    private static final class CanvasFinalizer {
        private long mNativeCanvasWrapper;

        public CanvasFinalizer(long j) {
            this.mNativeCanvasWrapper = j;
        }

        public void dispose() {
            if (this.mNativeCanvasWrapper != 0) {
                Canvas.finalizer(this.mNativeCanvasWrapper);
                this.mNativeCanvasWrapper = 0L;
            }
        }

        protected void finalize() throws Throwable {
            try {
                dispose();
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Canvas$EdgeType.class */
    public enum EdgeType {
        BW(0),
        AA(1);
        
        public final int nativeInt;

        EdgeType(int i) {
            this.nativeInt = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/graphics/Canvas$VertexMode.class */
    public enum VertexMode {
        TRIANGLES(0),
        TRIANGLE_STRIP(1),
        TRIANGLE_FAN(2);
        
        public final int nativeInt;

        VertexMode(int i) {
            this.nativeInt = i;
        }
    }

    public Canvas() {
        this.mDensity = 0;
        this.mScreenDensity = 0;
        if (isHardwareAccelerated()) {
            this.mFinalizer = null;
            return;
        }
        this.mNativeCanvasWrapper = initRaster(0L);
        this.mFinalizer = new CanvasFinalizer(this.mNativeCanvasWrapper);
    }

    public Canvas(long j) {
        this.mDensity = 0;
        this.mScreenDensity = 0;
        if (j == 0) {
            throw new IllegalStateException();
        }
        this.mNativeCanvasWrapper = j;
        this.mFinalizer = new CanvasFinalizer(this.mNativeCanvasWrapper);
        this.mDensity = Bitmap.getDefaultDensity();
    }

    public Canvas(Bitmap bitmap) {
        this.mDensity = 0;
        this.mScreenDensity = 0;
        if (!bitmap.isMutable()) {
            throw new IllegalStateException("Immutable bitmap passed to Canvas constructor");
        }
        throwIfCannotDraw(bitmap);
        this.mNativeCanvasWrapper = initRaster(bitmap.ni());
        this.mFinalizer = new CanvasFinalizer(this.mNativeCanvasWrapper);
        this.mBitmap = bitmap;
        this.mDensity = bitmap.mDensity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkRange(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 + i3 > i) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void finalizer(long j);

    public static native void freeCaches();

    public static native void freeTextLayoutCaches();

    private static native long initRaster(long j);

    private static native void nativeDrawBitmapMatrix(long j, long j2, long j3, long j4);

    private static native void nativeDrawBitmapMesh(long j, long j2, int i, int i2, float[] fArr, int i3, int[] iArr, int i4, long j3);

    private static native void nativeDrawVertices(long j, int i, int i2, float[] fArr, int i3, float[] fArr2, int i4, int[] iArr, int i5, short[] sArr, int i6, int i7, long j2);

    private static native void nativeSetDrawFilter(long j, long j2);

    private static native boolean native_clipPath(long j, long j2, int i);

    private static native boolean native_clipRect(long j, float f, float f2, float f3, float f4, int i);

    private static native boolean native_clipRegion(long j, long j2, int i);

    private static native void native_concat(long j, long j2);

    private static native void native_drawArc(long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z, long j2);

    private native void native_drawBitmap(long j, long j2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, long j3, int i, int i2);

    private native void native_drawBitmap(long j, long j2, float f, float f2, long j3, int i, int i2, int i3);

    private static native void native_drawBitmap(long j, int[] iArr, int i, int i2, float f, float f2, int i3, int i4, boolean z, long j2);

    private static native void native_drawCircle(long j, float f, float f2, float f3, long j2);

    private static native void native_drawColor(long j, int i, int i2);

    private static native void native_drawLine(long j, float f, float f2, float f3, float f4, long j2);

    private static native void native_drawLines(long j, float[] fArr, int i, int i2, long j2);

    private static native void native_drawOval(long j, float f, float f2, float f3, float f4, long j2);

    private static native void native_drawPaint(long j, long j2);

    private static native void native_drawPath(long j, long j2, long j3);

    private static native void native_drawPoint(long j, float f, float f2, long j2);

    private static native void native_drawPoints(long j, float[] fArr, int i, int i2, long j2);

    private static native void native_drawRect(long j, float f, float f2, float f3, float f4, long j2);

    private static native void native_drawRoundRect(long j, float f, float f2, float f3, float f4, float f5, float f6, long j2);

    private static native void native_drawText(long j, String str, int i, int i2, float f, float f2, int i3, long j2, long j3);

    private static native void native_drawText(long j, char[] cArr, int i, int i2, float f, float f2, int i3, long j2, long j3);

    private static native void native_drawTextOnPath(long j, String str, long j2, float f, float f2, int i, long j3, long j4);

    private static native void native_drawTextOnPath(long j, char[] cArr, int i, int i2, long j2, float f, float f2, int i3, long j3, long j4);

    private static native void native_drawTextRun(long j, String str, int i, int i2, int i3, int i4, float f, float f2, boolean z, long j2, long j3);

    private static native void native_drawTextRun(long j, char[] cArr, int i, int i2, int i3, int i4, float f, float f2, boolean z, long j2, long j3);

    private static native void native_getCTM(long j, long j2);

    private static native boolean native_getClipBounds(long j, Rect rect);

    private static native int native_getHeight(long j);

    private static native int native_getSaveCount(long j);

    private static native int native_getWidth(long j);

    private static native boolean native_isOpaque(long j);

    private static native boolean native_quickReject(long j, float f, float f2, float f3, float f4);

    private static native boolean native_quickReject(long j, long j2);

    private static native void native_restore(long j);

    private static native void native_restoreToCount(long j, int i);

    private static native void native_rotate(long j, float f);

    private static native int native_save(long j, int i);

    private static native int native_saveLayer(long j, float f, float f2, float f3, float f4, long j2, int i);

    private static native int native_saveLayerAlpha(long j, float f, float f2, float f3, float f4, int i, int i2);

    private static native void native_scale(long j, float f, float f2);

    private static native void native_setBitmap(long j, long j2, boolean z);

    private static native void native_setMatrix(long j, long j2);

    private static native void native_skew(long j, float f, float f2);

    private static native void native_translate(long j, float f, float f2);

    private void setNativeBitmap(long j) {
        native_setBitmap(this.mNativeCanvasWrapper, j, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void throwIfCannotDraw(Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            throw new RuntimeException("Canvas: trying to use a recycled bitmap " + bitmap);
        }
        if (!bitmap.isPremultiplied() && bitmap.getConfig() == Bitmap.Config.ARGB_8888 && bitmap.hasAlpha()) {
            throw new RuntimeException("Canvas: trying to use a non-premultiplied bitmap " + bitmap);
        }
    }

    public boolean clipPath(Path path) {
        return clipPath(path, Region.Op.INTERSECT);
    }

    public boolean clipPath(Path path, Region.Op op) {
        return native_clipPath(this.mNativeCanvasWrapper, path.ni(), op.nativeInt);
    }

    public boolean clipRect(float f, float f2, float f3, float f4) {
        return native_clipRect(this.mNativeCanvasWrapper, f, f2, f3, f4, Region.Op.INTERSECT.nativeInt);
    }

    public boolean clipRect(float f, float f2, float f3, float f4, Region.Op op) {
        return native_clipRect(this.mNativeCanvasWrapper, f, f2, f3, f4, op.nativeInt);
    }

    public boolean clipRect(int i, int i2, int i3, int i4) {
        return native_clipRect(this.mNativeCanvasWrapper, i, i2, i3, i4, Region.Op.INTERSECT.nativeInt);
    }

    public boolean clipRect(Rect rect) {
        return native_clipRect(this.mNativeCanvasWrapper, rect.left, rect.top, rect.right, rect.bottom, Region.Op.INTERSECT.nativeInt);
    }

    public boolean clipRect(Rect rect, Region.Op op) {
        return native_clipRect(this.mNativeCanvasWrapper, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    public boolean clipRect(RectF rectF) {
        return native_clipRect(this.mNativeCanvasWrapper, rectF.left, rectF.top, rectF.right, rectF.bottom, Region.Op.INTERSECT.nativeInt);
    }

    public boolean clipRect(RectF rectF, Region.Op op) {
        return native_clipRect(this.mNativeCanvasWrapper, rectF.left, rectF.top, rectF.right, rectF.bottom, op.nativeInt);
    }

    public boolean clipRegion(Region region) {
        return clipRegion(region, Region.Op.INTERSECT);
    }

    public boolean clipRegion(Region region, Region.Op op) {
        return native_clipRegion(this.mNativeCanvasWrapper, region.ni(), op.nativeInt);
    }

    public void concat(Matrix matrix) {
        if (matrix != null) {
            native_concat(this.mNativeCanvasWrapper, matrix.native_instance);
        }
    }

    public void drawARGB(int i, int i2, int i3, int i4) {
        drawColor(Color.argb(i, i2, i3, i4));
    }

    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        native_drawArc(this.mNativeCanvasWrapper, f, f2, f3, f4, f5, f6, z, paint.mNativePaint);
    }

    public void drawArc(RectF rectF, float f, float f2, boolean z, Paint paint) {
        drawArc(rectF.left, rectF.top, rectF.right, rectF.bottom, f, f2, z, paint);
    }

    public void drawBitmap(Bitmap bitmap, float f, float f2, Paint paint) {
        throwIfCannotDraw(bitmap);
        native_drawBitmap(this.mNativeCanvasWrapper, bitmap.ni(), f, f2, paint != null ? paint.mNativePaint : 0L, this.mDensity, this.mScreenDensity, bitmap.mDensity);
    }

    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        nativeDrawBitmapMatrix(this.mNativeCanvasWrapper, bitmap.ni(), matrix.ni(), paint != null ? paint.mNativePaint : 0L);
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        int i;
        int i2;
        int i3;
        int i4;
        if (rect2 == null) {
            throw new NullPointerException();
        }
        throwIfCannotDraw(bitmap);
        long j = paint == null ? 0L : paint.mNativePaint;
        if (rect == null) {
            i3 = 0;
            i = 0;
            i2 = bitmap.getWidth();
            i4 = bitmap.getHeight();
        } else {
            i = rect.left;
            i2 = rect.right;
            i3 = rect.top;
            i4 = rect.bottom;
        }
        native_drawBitmap(this.mNativeCanvasWrapper, bitmap.ni(), i, i3, i2, i4, rect2.left, rect2.top, rect2.right, rect2.bottom, j, this.mScreenDensity, bitmap.mDensity);
    }

    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectF, Paint paint) {
        float f;
        float f2;
        float f3;
        float f4;
        if (rectF == null) {
            throw new NullPointerException();
        }
        throwIfCannotDraw(bitmap);
        long j = paint == null ? 0L : paint.mNativePaint;
        if (rect == null) {
            f3 = 0.0f;
            f = 0.0f;
            f2 = bitmap.getWidth();
            f4 = bitmap.getHeight();
        } else {
            f = rect.left;
            f2 = rect.right;
            f3 = rect.top;
            f4 = rect.bottom;
        }
        native_drawBitmap(this.mNativeCanvasWrapper, bitmap.ni(), f, f3, f2, f4, rectF.left, rectF.top, rectF.right, rectF.bottom, j, this.mScreenDensity, bitmap.mDensity);
    }

    @Deprecated
    public void drawBitmap(int[] iArr, int i, int i2, float f, float f2, int i3, int i4, boolean z, Paint paint) {
        if (i3 < 0) {
            throw new IllegalArgumentException("width must be >= 0");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("height must be >= 0");
        }
        if (Math.abs(i2) < i3) {
            throw new IllegalArgumentException("abs(stride) must be >= width");
        }
        int i5 = i + ((i4 - 1) * i2);
        int length = iArr.length;
        if (i < 0 || i + i3 > length || i5 < 0 || i5 + i3 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (i3 == 0 || i4 == 0) {
            return;
        }
        native_drawBitmap(this.mNativeCanvasWrapper, iArr, i, i2, f, f2, i3, i4, z, paint != null ? paint.mNativePaint : 0L);
    }

    @Deprecated
    public void drawBitmap(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Paint paint) {
        drawBitmap(iArr, i, i2, i3, i4, i5, i6, z, paint);
    }

    public void drawBitmapMesh(Bitmap bitmap, int i, int i2, float[] fArr, int i3, int[] iArr, int i4, Paint paint) {
        if ((i | i2 | i3 | i4) < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (i == 0 || i2 == 0) {
            return;
        }
        int i5 = (i + 1) * (i2 + 1);
        checkRange(fArr.length, i3, i5 * 2);
        if (iArr != null) {
            checkRange(iArr.length, i4, i5);
        }
        nativeDrawBitmapMesh(this.mNativeCanvasWrapper, bitmap.ni(), i, i2, fArr, i3, iArr, i4, paint != null ? paint.mNativePaint : 0L);
    }

    public void drawCircle(float f, float f2, float f3, Paint paint) {
        native_drawCircle(this.mNativeCanvasWrapper, f, f2, f3, paint.mNativePaint);
    }

    public void drawColor(int i) {
        native_drawColor(this.mNativeCanvasWrapper, i, PorterDuff.Mode.SRC_OVER.nativeInt);
    }

    public void drawColor(int i, PorterDuff.Mode mode) {
        native_drawColor(this.mNativeCanvasWrapper, i, mode.nativeInt);
    }

    public void drawLine(float f, float f2, float f3, float f4, Paint paint) {
        native_drawLine(this.mNativeCanvasWrapper, f, f2, f3, f4, paint.mNativePaint);
    }

    public void drawLines(float[] fArr, int i, int i2, Paint paint) {
        native_drawLines(this.mNativeCanvasWrapper, fArr, i, i2, paint.mNativePaint);
    }

    public void drawLines(float[] fArr, Paint paint) {
        drawLines(fArr, 0, fArr.length, paint);
    }

    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        native_drawOval(this.mNativeCanvasWrapper, f, f2, f3, f4, paint.mNativePaint);
    }

    public void drawOval(RectF rectF, Paint paint) {
        if (rectF == null) {
            throw new NullPointerException();
        }
        drawOval(rectF.left, rectF.top, rectF.right, rectF.bottom, paint);
    }

    public void drawPaint(Paint paint) {
        native_drawPaint(this.mNativeCanvasWrapper, paint.mNativePaint);
    }

    public void drawPatch(NinePatch ninePatch, Rect rect, Paint paint) {
        ninePatch.drawSoftware(this, rect, paint);
    }

    public void drawPatch(NinePatch ninePatch, RectF rectF, Paint paint) {
        ninePatch.drawSoftware(this, rectF, paint);
    }

    public void drawPath(Path path, Paint paint) {
        native_drawPath(this.mNativeCanvasWrapper, path.ni(), paint.mNativePaint);
    }

    public void drawPicture(Picture picture) {
        picture.endRecording();
        int save = save();
        picture.draw(this);
        restoreToCount(save);
    }

    public void drawPicture(Picture picture, Rect rect) {
        save();
        translate(rect.left, rect.top);
        if (picture.getWidth() > 0 && picture.getHeight() > 0) {
            scale(rect.width() / picture.getWidth(), rect.height() / picture.getHeight());
        }
        drawPicture(picture);
        restore();
    }

    public void drawPicture(Picture picture, RectF rectF) {
        save();
        translate(rectF.left, rectF.top);
        if (picture.getWidth() > 0 && picture.getHeight() > 0) {
            scale(rectF.width() / picture.getWidth(), rectF.height() / picture.getHeight());
        }
        drawPicture(picture);
        restore();
    }

    public void drawPoint(float f, float f2, Paint paint) {
        native_drawPoint(this.mNativeCanvasWrapper, f, f2, paint.mNativePaint);
    }

    public void drawPoints(float[] fArr, int i, int i2, Paint paint) {
        native_drawPoints(this.mNativeCanvasWrapper, fArr, i, i2, paint.mNativePaint);
    }

    public void drawPoints(float[] fArr, Paint paint) {
        drawPoints(fArr, 0, fArr.length, paint);
    }

    @Deprecated
    public void drawPosText(String str, float[] fArr, Paint paint) {
        drawPosText(str.toCharArray(), 0, str.length(), fArr, paint);
    }

    @Deprecated
    public void drawPosText(char[] cArr, int i, int i2, float[] fArr, Paint paint) {
        if (i < 0 || i + i2 > cArr.length || i2 * 2 > fArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return;
            }
            drawText(cArr, i + i4, 1, fArr[i4 * 2], fArr[(i4 * 2) + 1], paint);
            i3 = i4 + 1;
        }
    }

    public void drawRGB(int i, int i2, int i3) {
        drawColor(Color.rgb(i, i2, i3));
    }

    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        native_drawRect(this.mNativeCanvasWrapper, f, f2, f3, f4, paint.mNativePaint);
    }

    public void drawRect(Rect rect, Paint paint) {
        drawRect(rect.left, rect.top, rect.right, rect.bottom, paint);
    }

    public void drawRect(RectF rectF, Paint paint) {
        native_drawRect(this.mNativeCanvasWrapper, rectF.left, rectF.top, rectF.right, rectF.bottom, paint.mNativePaint);
    }

    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        native_drawRoundRect(this.mNativeCanvasWrapper, f, f2, f3, f4, f5, f6, paint.mNativePaint);
    }

    public void drawRoundRect(RectF rectF, float f, float f2, Paint paint) {
        drawRoundRect(rectF.left, rectF.top, rectF.right, rectF.bottom, f, f2, paint);
    }

    public void drawText(CharSequence charSequence, int i, int i2, float f, float f2, Paint paint) {
        if ((i | i2 | (i2 - i) | (charSequence.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if ((charSequence instanceof String) || (charSequence instanceof SpannedString) || (charSequence instanceof SpannableString)) {
            native_drawText(this.mNativeCanvasWrapper, charSequence.toString(), i, i2, f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
        } else if (charSequence instanceof GraphicsOperations) {
            ((GraphicsOperations) charSequence).drawText(this, i, i2, f, f2, paint);
        } else {
            char[] obtain = TemporaryBuffer.obtain(i2 - i);
            TextUtils.getChars(charSequence, i, i2, obtain, 0);
            native_drawText(this.mNativeCanvasWrapper, obtain, 0, i2 - i, f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
            TemporaryBuffer.recycle(obtain);
        }
    }

    public void drawText(String str, float f, float f2, Paint paint) {
        native_drawText(this.mNativeCanvasWrapper, str, 0, str.length(), f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
    }

    public void drawText(String str, int i, int i2, float f, float f2, Paint paint) {
        if ((i | i2 | (i2 - i) | (str.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        native_drawText(this.mNativeCanvasWrapper, str, i, i2, f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
    }

    public void drawText(char[] cArr, int i, int i2, float f, float f2, Paint paint) {
        if ((i | i2 | (i + i2) | ((cArr.length - i) - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        native_drawText(this.mNativeCanvasWrapper, cArr, i, i2, f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
    }

    public void drawTextOnPath(String str, Path path, float f, float f2, Paint paint) {
        if (str.length() > 0) {
            native_drawTextOnPath(this.mNativeCanvasWrapper, str, path.ni(), f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
        }
    }

    public void drawTextOnPath(char[] cArr, int i, int i2, Path path, float f, float f2, Paint paint) {
        if (i < 0 || i + i2 > cArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        native_drawTextOnPath(this.mNativeCanvasWrapper, cArr, i, i2, path.ni(), f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
    }

    public void drawTextRun(CharSequence charSequence, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        if (charSequence == null) {
            throw new NullPointerException("text is null");
        }
        if (paint == null) {
            throw new NullPointerException("paint is null");
        }
        if ((i | i2 | (i2 - i) | (charSequence.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if ((charSequence instanceof String) || (charSequence instanceof SpannedString) || (charSequence instanceof SpannableString)) {
            native_drawTextRun(this.mNativeCanvasWrapper, charSequence.toString(), i, i2, i3, i4, f, f2, z, paint.mNativePaint, paint.mNativeTypeface);
        } else if (charSequence instanceof GraphicsOperations) {
            ((GraphicsOperations) charSequence).drawTextRun(this, i, i2, i3, i4, f, f2, z, paint);
        } else {
            int i5 = i4 - i3;
            char[] obtain = TemporaryBuffer.obtain(i5);
            TextUtils.getChars(charSequence, i3, i4, obtain, 0);
            native_drawTextRun(this.mNativeCanvasWrapper, obtain, i - i3, i2 - i, 0, i5, f, f2, z, paint.mNativePaint, paint.mNativeTypeface);
            TemporaryBuffer.recycle(obtain);
        }
    }

    public void drawTextRun(char[] cArr, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        if (cArr == null) {
            throw new NullPointerException("text is null");
        }
        if (paint == null) {
            throw new NullPointerException("paint is null");
        }
        if ((i | i2 | ((cArr.length - i) - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        native_drawTextRun(this.mNativeCanvasWrapper, cArr, i, i2, i3, i4, f, f2, z, paint.mNativePaint, paint.mNativeTypeface);
    }

    public void drawVertices(VertexMode vertexMode, int i, float[] fArr, int i2, float[] fArr2, int i3, int[] iArr, int i4, short[] sArr, int i5, int i6, Paint paint) {
        checkRange(fArr.length, i2, i);
        if (fArr2 != null) {
            checkRange(fArr2.length, i3, i);
        }
        if (iArr != null) {
            checkRange(iArr.length, i4, i / 2);
        }
        if (sArr != null) {
            checkRange(sArr.length, i5, i6);
        }
        nativeDrawVertices(this.mNativeCanvasWrapper, vertexMode.nativeInt, i, fArr, i2, fArr2, i3, iArr, i4, sArr, i5, i6, paint.mNativePaint);
    }

    public final Rect getClipBounds() {
        Rect rect = new Rect();
        getClipBounds(rect);
        return rect;
    }

    public boolean getClipBounds(Rect rect) {
        return native_getClipBounds(this.mNativeCanvasWrapper, rect);
    }

    public int getDensity() {
        return this.mDensity;
    }

    public DrawFilter getDrawFilter() {
        return this.mDrawFilter;
    }

    @Deprecated
    protected GL getGL() {
        return null;
    }

    public int getHeight() {
        return native_getHeight(this.mNativeCanvasWrapper);
    }

    @Deprecated
    public final Matrix getMatrix() {
        Matrix matrix = new Matrix();
        getMatrix(matrix);
        return matrix;
    }

    @Deprecated
    public void getMatrix(Matrix matrix) {
        native_getCTM(this.mNativeCanvasWrapper, matrix.native_instance);
    }

    public int getMaximumBitmapHeight() {
        return MAXMIMUM_BITMAP_SIZE;
    }

    public int getMaximumBitmapWidth() {
        return MAXMIMUM_BITMAP_SIZE;
    }

    public long getNativeCanvasWrapper() {
        return this.mNativeCanvasWrapper;
    }

    public int getSaveCount() {
        return native_getSaveCount(this.mNativeCanvasWrapper);
    }

    public int getWidth() {
        return native_getWidth(this.mNativeCanvasWrapper);
    }

    public void insertInorderBarrier() {
    }

    public void insertReorderBarrier() {
    }

    public boolean isHardwareAccelerated() {
        return false;
    }

    public boolean isOpaque() {
        return native_isOpaque(this.mNativeCanvasWrapper);
    }

    public boolean isRecordingFor(Object obj) {
        return false;
    }

    public boolean quickReject(float f, float f2, float f3, float f4, EdgeType edgeType) {
        return native_quickReject(this.mNativeCanvasWrapper, f, f2, f3, f4);
    }

    public boolean quickReject(Path path, EdgeType edgeType) {
        return native_quickReject(this.mNativeCanvasWrapper, path.ni());
    }

    public boolean quickReject(RectF rectF, EdgeType edgeType) {
        return native_quickReject(this.mNativeCanvasWrapper, rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public void release() {
        this.mFinalizer.dispose();
    }

    public void restore() {
        native_restore(this.mNativeCanvasWrapper);
    }

    public void restoreToCount(int i) {
        native_restoreToCount(this.mNativeCanvasWrapper, i);
    }

    public void rotate(float f) {
        native_rotate(this.mNativeCanvasWrapper, f);
    }

    public final void rotate(float f, float f2, float f3) {
        translate(f2, f3);
        rotate(f);
        translate(-f2, -f3);
    }

    public int save() {
        return native_save(this.mNativeCanvasWrapper, 3);
    }

    public int save(int i) {
        return native_save(this.mNativeCanvasWrapper, i);
    }

    public int saveLayer(float f, float f2, float f3, float f4, Paint paint) {
        return saveLayer(f, f2, f3, f4, paint, 31);
    }

    public int saveLayer(float f, float f2, float f3, float f4, Paint paint, int i) {
        return native_saveLayer(this.mNativeCanvasWrapper, f, f2, f3, f4, paint != null ? paint.mNativePaint : 0L, i);
    }

    public int saveLayer(RectF rectF, Paint paint) {
        return saveLayer(rectF, paint, 31);
    }

    public int saveLayer(RectF rectF, Paint paint, int i) {
        RectF rectF2 = rectF;
        if (rectF == null) {
            rectF2 = new RectF(getClipBounds());
        }
        return saveLayer(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, paint, i);
    }

    public int saveLayerAlpha(float f, float f2, float f3, float f4, int i) {
        return saveLayerAlpha(f, f2, f3, f4, i, 31);
    }

    public int saveLayerAlpha(float f, float f2, float f3, float f4, int i, int i2) {
        return native_saveLayerAlpha(this.mNativeCanvasWrapper, f, f2, f3, f4, Math.min(255, Math.max(0, i)), i2);
    }

    public int saveLayerAlpha(RectF rectF, int i) {
        return saveLayerAlpha(rectF, i, 31);
    }

    public int saveLayerAlpha(RectF rectF, int i, int i2) {
        RectF rectF2 = rectF;
        if (rectF == null) {
            rectF2 = new RectF(getClipBounds());
        }
        return saveLayerAlpha(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, i, i2);
    }

    public void scale(float f, float f2) {
        native_scale(this.mNativeCanvasWrapper, f, f2);
    }

    public final void scale(float f, float f2, float f3, float f4) {
        translate(f3, f4);
        scale(f, f2);
        translate(-f3, -f4);
    }

    public void setBitmap(Bitmap bitmap) {
        if (isHardwareAccelerated()) {
            throw new RuntimeException("Can't set a bitmap device on a HW accelerated canvas");
        }
        if (bitmap == null) {
            native_setBitmap(this.mNativeCanvasWrapper, 0L, false);
            this.mDensity = 0;
        } else if (!bitmap.isMutable()) {
            throw new IllegalStateException();
        } else {
            throwIfCannotDraw(bitmap);
            native_setBitmap(this.mNativeCanvasWrapper, bitmap.ni(), true);
            this.mDensity = bitmap.mDensity;
        }
        this.mBitmap = bitmap;
    }

    public void setDensity(int i) {
        if (this.mBitmap != null) {
            this.mBitmap.setDensity(i);
        }
        this.mDensity = i;
    }

    public void setDrawFilter(DrawFilter drawFilter) {
        long j = 0;
        if (drawFilter != null) {
            j = drawFilter.mNativeInt;
        }
        this.mDrawFilter = drawFilter;
        nativeSetDrawFilter(this.mNativeCanvasWrapper, j);
    }

    public void setHighContrastText(boolean z) {
    }

    public void setMatrix(Matrix matrix) {
        native_setMatrix(this.mNativeCanvasWrapper, matrix == null ? 0L : matrix.native_instance);
    }

    public void setScreenDensity(int i) {
        this.mScreenDensity = i;
    }

    public void setViewport(int i, int i2) {
    }

    public void skew(float f, float f2) {
        native_skew(this.mNativeCanvasWrapper, f, f2);
    }

    public void translate(float f, float f2) {
        native_translate(this.mNativeCanvasWrapper, f, f2);
    }
}
