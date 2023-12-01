package com.android.internal.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/util/ImageUtils.class */
public class ImageUtils {
    private static final int ALPHA_TOLERANCE = 50;
    private static final int COMPACT_BITMAP_SIZE = 64;
    private static final int TOLERANCE = 20;
    private int[] mTempBuffer;
    private Bitmap mTempCompactBitmap;
    private Canvas mTempCompactBitmapCanvas;
    private Paint mTempCompactBitmapPaint;
    private final Matrix mTempMatrix = new Matrix();

    private void ensureBufferSize(int i) {
        if (this.mTempBuffer == null || this.mTempBuffer.length < i) {
            this.mTempBuffer = new int[i];
        }
    }

    public static boolean isGrayscale(int i) {
        if (((i >> 24) & 255) < 50) {
            return true;
        }
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = i & 255;
        return Math.abs(i2 - i3) < 20 && Math.abs(i2 - i4) < 20 && Math.abs(i3 - i4) < 20;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0020, code lost:
        if (r0 > 64) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isGrayscale(android.graphics.Bitmap r10) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.util.ImageUtils.isGrayscale(android.graphics.Bitmap):boolean");
    }
}
