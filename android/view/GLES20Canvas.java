package android.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CanvasProperty;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.TemporaryBuffer;
import android.text.GraphicsOperations;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/view/GLES20Canvas.class */
public class GLES20Canvas extends HardwareCanvas {
    private static boolean sIsAvailable = nIsAvailable();
    private Rect mClipBounds;
    private DrawFilter mFilter;
    private CanvasFinalizer mFinalizer;
    private int mHeight;
    private float[] mLine;
    private RectF mPathBounds;
    private float[] mPoint;
    private int mWidth;
    private final boolean mOpaque = false;
    protected long mRenderer = nCreateDisplayListRenderer();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/view/GLES20Canvas$CanvasFinalizer.class */
    public static final class CanvasFinalizer {
        private final long mRenderer;

        public CanvasFinalizer(long j) {
            this.mRenderer = j;
        }

        protected void finalize() throws Throwable {
            try {
                GLES20Canvas.nDestroyRenderer(this.mRenderer);
            } finally {
                super.finalize();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GLES20Canvas() {
        setupFinalizer();
    }

    private Rect getInternalClipBounds() {
        if (this.mClipBounds == null) {
            this.mClipBounds = new Rect();
        }
        return this.mClipBounds;
    }

    private float[] getLineStorage() {
        if (this.mLine == null) {
            this.mLine = new float[4];
        }
        return this.mLine;
    }

    private RectF getPathBounds() {
        if (this.mPathBounds == null) {
            this.mPathBounds = new RectF();
        }
        return this.mPathBounds;
    }

    private float[] getPointStorage() {
        if (this.mPoint == null) {
            this.mPoint = new float[2];
        }
        return this.mPoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAvailable() {
        return sIsAvailable;
    }

    private static native int nCallDrawGLFunction(long j, long j2);

    private static native boolean nClipPath(long j, long j2, int i);

    private static native boolean nClipRect(long j, float f, float f2, float f3, float f4, int i);

    private static native boolean nClipRect(long j, int i, int i2, int i3, int i4, int i5);

    private static native boolean nClipRegion(long j, long j2, int i);

    private static native void nConcatMatrix(long j, long j2);

    private static native long nCreateDisplayListRenderer();

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nDestroyRenderer(long j);

    private static native void nDrawArc(long j, float f, float f2, float f3, float f4, float f5, float f6, boolean z, long j2);

    private static native void nDrawBitmap(long j, long j2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, long j3);

    private static native void nDrawBitmap(long j, long j2, float f, float f2, long j3);

    private static native void nDrawBitmap(long j, long j2, long j3, long j4);

    private static native void nDrawBitmap(long j, int[] iArr, int i, int i2, float f, float f2, int i3, int i4, boolean z, long j2);

    private static native void nDrawBitmapMesh(long j, long j2, int i, int i2, float[] fArr, int i3, int[] iArr, int i4, long j3);

    private static native void nDrawCircle(long j, float f, float f2, float f3, long j2);

    private static native void nDrawCircle(long j, long j2, long j3, long j4, long j5);

    private static native void nDrawColor(long j, int i, int i2);

    private static native void nDrawLayer(long j, long j2, float f, float f2);

    private static native void nDrawLines(long j, float[] fArr, int i, int i2, long j2);

    private static native void nDrawOval(long j, float f, float f2, float f3, float f4, long j2);

    private static native void nDrawPatch(long j, long j2, long j3, float f, float f2, float f3, float f4, long j4);

    private static native void nDrawPath(long j, long j2, long j3);

    private static native void nDrawPoints(long j, float[] fArr, int i, int i2, long j2);

    private static native void nDrawRect(long j, float f, float f2, float f3, float f4, long j2);

    private static native void nDrawRects(long j, long j2, long j3);

    private static native int nDrawRenderNode(long j, long j2, Rect rect, int i);

    private static native void nDrawRoundRect(long j, float f, float f2, float f3, float f4, float f5, float f6, long j2);

    private static native void nDrawRoundRect(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8);

    private static native void nDrawText(long j, String str, int i, int i2, float f, float f2, int i3, long j2, long j3);

    private static native void nDrawText(long j, char[] cArr, int i, int i2, float f, float f2, int i3, long j2, long j3);

    private static native void nDrawTextOnPath(long j, String str, int i, int i2, long j2, float f, float f2, int i3, long j3, long j4);

    private static native void nDrawTextOnPath(long j, char[] cArr, int i, int i2, long j2, float f, float f2, int i3, long j3, long j4);

    private static native void nDrawTextRun(long j, String str, int i, int i2, int i3, int i4, float f, float f2, boolean z, long j2, long j3);

    private static native void nDrawTextRun(long j, char[] cArr, int i, int i2, int i3, int i4, float f, float f2, boolean z, long j2, long j3);

    private static native void nFinish(long j);

    /* JADX INFO: Access modifiers changed from: protected */
    public static native long nFinishRecording(long j);

    private static native boolean nGetClipBounds(long j, Rect rect);

    private static native void nGetMatrix(long j, long j2);

    private static native int nGetMaximumTextureHeight();

    private static native int nGetMaximumTextureWidth();

    private static native int nGetSaveCount(long j);

    private static native void nInsertReorderBarrier(long j, boolean z);

    private static native boolean nIsAvailable();

    private static native int nPrepare(long j, boolean z);

    private static native int nPrepareDirty(long j, int i, int i2, int i3, int i4, boolean z);

    private static native boolean nQuickReject(long j, float f, float f2, float f3, float f4);

    private static native void nResetDisplayListRenderer(long j);

    private static native void nResetPaintFilter(long j);

    private static native void nRestore(long j);

    private static native void nRestoreToCount(long j, int i);

    private static native void nRotate(long j, float f);

    private static native int nSave(long j, int i);

    private static native int nSaveLayer(long j, float f, float f2, float f3, float f4, long j2, int i);

    private static native int nSaveLayer(long j, long j2, int i);

    private static native int nSaveLayerAlpha(long j, float f, float f2, float f3, float f4, int i, int i2);

    private static native int nSaveLayerAlpha(long j, int i, int i2);

    private static native void nScale(long j, float f, float f2);

    private static native void nSetHighContrastText(long j, boolean z);

    private static native void nSetMatrix(long j, long j2);

    private static native void nSetProperty(String str, String str2);

    private static native void nSetViewport(long j, int i, int i2);

    private static native void nSetupPaintFilter(long j, int i, int i2);

    private static native void nSkew(long j, float f, float f2);

    private static native void nTranslate(long j, float f, float f2);

    public static void setProperty(String str, String str2) {
        nSetProperty(str, str2);
    }

    private void setupFinalizer() {
        if (this.mRenderer == 0) {
            throw new IllegalStateException("Could not create GLES20Canvas renderer");
        }
        this.mFinalizer = new CanvasFinalizer(this.mRenderer);
    }

    @Override // android.view.HardwareCanvas
    public int callDrawGLFunction2(long j) {
        return nCallDrawGLFunction(this.mRenderer, j);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path) {
        return nClipPath(this.mRenderer, path.mNativePath, Region.Op.INTERSECT.nativeInt);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path path, Region.Op op) {
        return nClipPath(this.mRenderer, path.mNativePath, op.nativeInt);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f, float f2, float f3, float f4) {
        return nClipRect(this.mRenderer, f, f2, f3, f4, Region.Op.INTERSECT.nativeInt);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float f, float f2, float f3, float f4, Region.Op op) {
        return nClipRect(this.mRenderer, f, f2, f3, f4, op.nativeInt);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(int i, int i2, int i3, int i4) {
        return nClipRect(this.mRenderer, i, i2, i3, i4, Region.Op.INTERSECT.nativeInt);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect) {
        return nClipRect(this.mRenderer, rect.left, rect.top, rect.right, rect.bottom, Region.Op.INTERSECT.nativeInt);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect rect, Region.Op op) {
        return nClipRect(this.mRenderer, rect.left, rect.top, rect.right, rect.bottom, op.nativeInt);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rectF) {
        return nClipRect(this.mRenderer, rectF.left, rectF.top, rectF.right, rectF.bottom, Region.Op.INTERSECT.nativeInt);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF rectF, Region.Op op) {
        return nClipRect(this.mRenderer, rectF.left, rectF.top, rectF.right, rectF.bottom, op.nativeInt);
    }

    @Override // android.graphics.Canvas
    public boolean clipRegion(Region region) {
        return nClipRegion(this.mRenderer, region.mNativeRegion, Region.Op.INTERSECT.nativeInt);
    }

    @Override // android.graphics.Canvas
    public boolean clipRegion(Region region, Region.Op op) {
        return nClipRegion(this.mRenderer, region.mNativeRegion, op.nativeInt);
    }

    @Override // android.graphics.Canvas
    public void concat(Matrix matrix) {
        if (matrix != null) {
            nConcatMatrix(this.mRenderer, matrix.native_instance);
        }
    }

    @Override // android.graphics.Canvas
    public void drawARGB(int i, int i2, int i3, int i4) {
        drawColor(((i & 255) << 24) | ((i2 & 255) << 16) | ((i3 & 255) << 8) | (i4 & 255));
    }

    @Override // android.graphics.Canvas
    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        nDrawArc(this.mRenderer, f, f2, f3, f4, f5, f6, z, paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, float f, float f2, Paint paint) {
        throwIfCannotDraw(bitmap);
        nDrawBitmap(this.mRenderer, bitmap.mNativeBitmap, f, f2, paint == null ? 0L : paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint) {
        throwIfCannotDraw(bitmap);
        nDrawBitmap(this.mRenderer, bitmap.mNativeBitmap, matrix.native_instance, paint == null ? 0L : paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, Rect rect2, Paint paint) {
        int i;
        int i2;
        int i3;
        int i4;
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
        nDrawBitmap(this.mRenderer, bitmap.mNativeBitmap, i, i3, i2, i4, rect2.left, rect2.top, rect2.right, rect2.bottom, j);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap bitmap, Rect rect, RectF rectF, Paint paint) {
        float f;
        float f2;
        float f3;
        float f4;
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
        nDrawBitmap(this.mRenderer, bitmap.mNativeBitmap, f, f3, f2, f4, rectF.left, rectF.top, rectF.right, rectF.bottom, j);
    }

    @Override // android.graphics.Canvas
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
        nDrawBitmap(this.mRenderer, iArr, i, i2, f, f2, i3, i4, z, paint == null ? 0L : paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z, Paint paint) {
        drawBitmap(iArr, i, i2, i3, i4, i5, i6, z, paint);
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(Bitmap bitmap, int i, int i2, float[] fArr, int i3, int[] iArr, int i4, Paint paint) {
        throwIfCannotDraw(bitmap);
        if (i < 0 || i2 < 0 || i3 < 0 || i4 < 0) {
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
        nDrawBitmapMesh(this.mRenderer, bitmap.mNativeBitmap, i, i2, fArr, i3, iArr, i4, paint == null ? 0L : paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float f, float f2, float f3, Paint paint) {
        nDrawCircle(this.mRenderer, f, f2, f3, paint.mNativePaint);
    }

    @Override // android.view.HardwareCanvas
    public void drawCircle(CanvasProperty<Float> canvasProperty, CanvasProperty<Float> canvasProperty2, CanvasProperty<Float> canvasProperty3, CanvasProperty<Paint> canvasProperty4) {
        nDrawCircle(this.mRenderer, canvasProperty.getNativeContainer(), canvasProperty2.getNativeContainer(), canvasProperty3.getNativeContainer(), canvasProperty4.getNativeContainer());
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i) {
        drawColor(i, PorterDuff.Mode.SRC_OVER);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int i, PorterDuff.Mode mode) {
        nDrawColor(this.mRenderer, i, mode.nativeInt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.view.HardwareCanvas
    public void drawHardwareLayer(HardwareLayer hardwareLayer, float f, float f2, Paint paint) {
        hardwareLayer.setLayerPaint(paint);
        nDrawLayer(this.mRenderer, hardwareLayer.getLayerHandle(), f, f2);
    }

    @Override // android.graphics.Canvas
    public void drawLine(float f, float f2, float f3, float f4, Paint paint) {
        float[] lineStorage = getLineStorage();
        lineStorage[0] = f;
        lineStorage[1] = f2;
        lineStorage[2] = f3;
        lineStorage[3] = f4;
        drawLines(lineStorage, 0, 4, paint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, int i, int i2, Paint paint) {
        if (i2 < 4) {
            return;
        }
        if ((i | i2) < 0 || i + i2 > fArr.length) {
            throw new IllegalArgumentException("The lines array must contain 4 elements per line.");
        }
        nDrawLines(this.mRenderer, fArr, i, i2, paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] fArr, Paint paint) {
        drawLines(fArr, 0, fArr.length, paint);
    }

    @Override // android.graphics.Canvas
    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        nDrawOval(this.mRenderer, f, f2, f3, f4, paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawPaint(Paint paint) {
        Rect internalClipBounds = getInternalClipBounds();
        nGetClipBounds(this.mRenderer, internalClipBounds);
        drawRect(internalClipBounds.left, internalClipBounds.top, internalClipBounds.right, internalClipBounds.bottom, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch ninePatch, Rect rect, Paint paint) {
        Bitmap bitmap = ninePatch.getBitmap();
        throwIfCannotDraw(bitmap);
        nDrawPatch(this.mRenderer, bitmap.mNativeBitmap, ninePatch.mNativeChunk, rect.left, rect.top, rect.right, rect.bottom, paint == null ? 0L : paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch ninePatch, RectF rectF, Paint paint) {
        Bitmap bitmap = ninePatch.getBitmap();
        throwIfCannotDraw(bitmap);
        nDrawPatch(this.mRenderer, bitmap.mNativeBitmap, ninePatch.mNativeChunk, rectF.left, rectF.top, rectF.right, rectF.bottom, paint == null ? 0L : paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        if (!path.isSimplePath) {
            nDrawPath(this.mRenderer, path.mNativePath, paint.mNativePaint);
        } else if (path.rects != null) {
            nDrawRects(this.mRenderer, path.rects.mNativeRegion, paint.mNativePaint);
        }
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture picture) {
        picture.endRecording();
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float f, float f2, Paint paint) {
        float[] pointStorage = getPointStorage();
        pointStorage[0] = f;
        pointStorage[1] = f2;
        drawPoints(pointStorage, 0, 2, paint);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, int i, int i2, Paint paint) {
        if (i2 < 2) {
            return;
        }
        nDrawPoints(this.mRenderer, fArr, i, i2, paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] fArr, Paint paint) {
        drawPoints(fArr, 0, fArr.length, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRGB(int i, int i2, int i3) {
        drawColor((-16777216) | ((i & 255) << 16) | ((i2 & 255) << 8) | (i3 & 255));
    }

    @Override // android.graphics.Canvas
    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        if (f == f3 || f2 == f4) {
            return;
        }
        nDrawRect(this.mRenderer, f, f2, f3, f4, paint.mNativePaint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(Rect rect, Paint paint) {
        drawRect(rect.left, rect.top, rect.right, rect.bottom, paint);
    }

    @Override // android.graphics.Canvas
    public void drawRect(RectF rectF, Paint paint) {
        drawRect(rectF.left, rectF.top, rectF.right, rectF.bottom, paint);
    }

    @Override // android.view.HardwareCanvas
    public int drawRenderNode(RenderNode renderNode, Rect rect, int i) {
        return nDrawRenderNode(this.mRenderer, renderNode.getNativeDisplayList(), rect, i);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        nDrawRoundRect(this.mRenderer, f, f2, f3, f4, f5, f6, paint.mNativePaint);
    }

    @Override // android.view.HardwareCanvas
    public void drawRoundRect(CanvasProperty<Float> canvasProperty, CanvasProperty<Float> canvasProperty2, CanvasProperty<Float> canvasProperty3, CanvasProperty<Float> canvasProperty4, CanvasProperty<Float> canvasProperty5, CanvasProperty<Float> canvasProperty6, CanvasProperty<Paint> canvasProperty7) {
        nDrawRoundRect(this.mRenderer, canvasProperty.getNativeContainer(), canvasProperty2.getNativeContainer(), canvasProperty3.getNativeContainer(), canvasProperty4.getNativeContainer(), canvasProperty5.getNativeContainer(), canvasProperty6.getNativeContainer(), canvasProperty7.getNativeContainer());
    }

    @Override // android.graphics.Canvas
    public void drawText(CharSequence charSequence, int i, int i2, float f, float f2, Paint paint) {
        if ((i | i2 | (i2 - i) | (charSequence.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if ((charSequence instanceof String) || (charSequence instanceof SpannedString) || (charSequence instanceof SpannableString)) {
            nDrawText(this.mRenderer, charSequence.toString(), i, i2, f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
        } else if (charSequence instanceof GraphicsOperations) {
            ((GraphicsOperations) charSequence).drawText(this, i, i2, f, f2, paint);
        } else {
            char[] obtain = TemporaryBuffer.obtain(i2 - i);
            TextUtils.getChars(charSequence, i, i2, obtain, 0);
            nDrawText(this.mRenderer, obtain, 0, i2 - i, f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
            TemporaryBuffer.recycle(obtain);
        }
    }

    @Override // android.graphics.Canvas
    public void drawText(String str, float f, float f2, Paint paint) {
        nDrawText(this.mRenderer, str, 0, str.length(), f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
    }

    @Override // android.graphics.Canvas
    public void drawText(String str, int i, int i2, float f, float f2, Paint paint) {
        if ((i | i2 | (i2 - i) | (str.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        nDrawText(this.mRenderer, str, i, i2, f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
    }

    @Override // android.graphics.Canvas
    public void drawText(char[] cArr, int i, int i2, float f, float f2, Paint paint) {
        if ((i | i2 | (i + i2) | ((cArr.length - i) - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        nDrawText(this.mRenderer, cArr, i, i2, f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(String str, Path path, float f, float f2, Paint paint) {
        if (str.length() == 0) {
            return;
        }
        nDrawTextOnPath(this.mRenderer, str, 0, str.length(), path.mNativePath, f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(char[] cArr, int i, int i2, Path path, float f, float f2, Paint paint) {
        if (i < 0 || i + i2 > cArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        nDrawTextOnPath(this.mRenderer, cArr, i, i2, path.mNativePath, f, f2, paint.mBidiFlags, paint.mNativePaint, paint.mNativeTypeface);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(CharSequence charSequence, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        if ((i | i2 | (i2 - i) | (charSequence.length() - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        if ((charSequence instanceof String) || (charSequence instanceof SpannedString) || (charSequence instanceof SpannableString)) {
            nDrawTextRun(this.mRenderer, charSequence.toString(), i, i2, i3, i4, f, f2, z, paint.mNativePaint, paint.mNativeTypeface);
        } else if (charSequence instanceof GraphicsOperations) {
            ((GraphicsOperations) charSequence).drawTextRun(this, i, i2, i3, i4, f, f2, z, paint);
        } else {
            int i5 = i4 - i3;
            char[] obtain = TemporaryBuffer.obtain(i5);
            TextUtils.getChars(charSequence, i3, i4, obtain, 0);
            nDrawTextRun(this.mRenderer, obtain, i - i3, i2 - i, 0, i5, f, f2, z, paint.mNativePaint, paint.mNativeTypeface);
            TemporaryBuffer.recycle(obtain);
        }
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(char[] cArr, int i, int i2, int i3, int i4, float f, float f2, boolean z, Paint paint) {
        if ((i | i2 | ((cArr.length - i) - i2)) < 0) {
            throw new IndexOutOfBoundsException();
        }
        nDrawTextRun(this.mRenderer, cArr, i, i2, i3, i4, f, f2, z, paint.mNativePaint, paint.mNativeTypeface);
    }

    @Override // android.graphics.Canvas
    public void drawVertices(Canvas.VertexMode vertexMode, int i, float[] fArr, int i2, float[] fArr2, int i3, int[] iArr, int i4, short[] sArr, int i5, int i6, Paint paint) {
    }

    @Override // android.graphics.Canvas
    public boolean getClipBounds(Rect rect) {
        return nGetClipBounds(this.mRenderer, rect);
    }

    @Override // android.graphics.Canvas
    public DrawFilter getDrawFilter() {
        return this.mFilter;
    }

    @Override // android.graphics.Canvas
    public int getHeight() {
        return this.mHeight;
    }

    @Override // android.graphics.Canvas
    public void getMatrix(Matrix matrix) {
        nGetMatrix(this.mRenderer, matrix.native_instance);
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapHeight() {
        return nGetMaximumTextureHeight();
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapWidth() {
        return nGetMaximumTextureWidth();
    }

    long getRenderer() {
        return this.mRenderer;
    }

    @Override // android.graphics.Canvas
    public int getSaveCount() {
        return nGetSaveCount(this.mRenderer);
    }

    @Override // android.graphics.Canvas
    public int getWidth() {
        return this.mWidth;
    }

    @Override // android.graphics.Canvas
    public void insertInorderBarrier() {
        nInsertReorderBarrier(this.mRenderer, false);
    }

    @Override // android.graphics.Canvas
    public void insertReorderBarrier() {
        nInsertReorderBarrier(this.mRenderer, true);
    }

    @Override // android.graphics.Canvas
    public boolean isOpaque() {
        return this.mOpaque;
    }

    @Override // android.view.HardwareCanvas
    public void onPostDraw() {
        nFinish(this.mRenderer);
    }

    @Override // android.view.HardwareCanvas
    public int onPreDraw(Rect rect) {
        return rect != null ? nPrepareDirty(this.mRenderer, rect.left, rect.top, rect.right, rect.bottom, this.mOpaque) : nPrepare(this.mRenderer, this.mOpaque);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(float f, float f2, float f3, float f4, Canvas.EdgeType edgeType) {
        return nQuickReject(this.mRenderer, f, f2, f3, f4);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(Path path, Canvas.EdgeType edgeType) {
        RectF pathBounds = getPathBounds();
        path.computeBounds(pathBounds, true);
        return nQuickReject(this.mRenderer, pathBounds.left, pathBounds.top, pathBounds.right, pathBounds.bottom);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(RectF rectF, Canvas.EdgeType edgeType) {
        return nQuickReject(this.mRenderer, rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // android.graphics.Canvas
    public void restore() {
        nRestore(this.mRenderer);
    }

    @Override // android.graphics.Canvas
    public void restoreToCount(int i) {
        nRestoreToCount(this.mRenderer, i);
    }

    @Override // android.graphics.Canvas
    public void rotate(float f) {
        nRotate(this.mRenderer, f);
    }

    @Override // android.graphics.Canvas
    public int save() {
        return nSave(this.mRenderer, 3);
    }

    @Override // android.graphics.Canvas
    public int save(int i) {
        return nSave(this.mRenderer, i);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float f, float f2, float f3, float f4, Paint paint, int i) {
        if (f >= f3 || f2 >= f4) {
            return save(i);
        }
        return nSaveLayer(this.mRenderer, f, f2, f3, f4, paint == null ? 0L : paint.mNativePaint, i);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF rectF, Paint paint, int i) {
        if (rectF != null) {
            return saveLayer(rectF.left, rectF.top, rectF.right, rectF.bottom, paint, i);
        }
        return nSaveLayer(this.mRenderer, paint == null ? 0L : paint.mNativePaint, i);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float f, float f2, float f3, float f4, int i, int i2) {
        return (f >= f3 || f2 >= f4) ? save(i2) : nSaveLayerAlpha(this.mRenderer, f, f2, f3, f4, i, i2);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF rectF, int i, int i2) {
        return rectF != null ? saveLayerAlpha(rectF.left, rectF.top, rectF.right, rectF.bottom, i, i2) : nSaveLayerAlpha(this.mRenderer, i, i2);
    }

    @Override // android.graphics.Canvas
    public void scale(float f, float f2) {
        nScale(this.mRenderer, f, f2);
    }

    @Override // android.graphics.Canvas
    public void setDrawFilter(DrawFilter drawFilter) {
        this.mFilter = drawFilter;
        if (drawFilter == null) {
            nResetPaintFilter(this.mRenderer);
        } else if (drawFilter instanceof PaintFlagsDrawFilter) {
            PaintFlagsDrawFilter paintFlagsDrawFilter = (PaintFlagsDrawFilter) drawFilter;
            nSetupPaintFilter(this.mRenderer, paintFlagsDrawFilter.clearBits, paintFlagsDrawFilter.setBits);
        }
    }

    @Override // android.graphics.Canvas
    public void setHighContrastText(boolean z) {
        nSetHighContrastText(this.mRenderer, z);
    }

    @Override // android.graphics.Canvas
    public void setMatrix(Matrix matrix) {
        nSetMatrix(this.mRenderer, matrix == null ? 0L : matrix.native_instance);
    }

    @Override // android.graphics.Canvas
    public void setViewport(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        nSetViewport(this.mRenderer, i, i2);
    }

    @Override // android.graphics.Canvas
    public void skew(float f, float f2) {
        nSkew(this.mRenderer, f, f2);
    }

    @Override // android.graphics.Canvas
    public void translate(float f, float f2) {
        if (f == 0.0f && f2 == 0.0f) {
            return;
        }
        nTranslate(this.mRenderer, f, f2);
    }
}
