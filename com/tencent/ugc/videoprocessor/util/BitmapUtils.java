package com.tencent.ugc.videoprocessor.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/util/BitmapUtils.class */
public class BitmapUtils {
    private static final String TAG = "BitmapUtils";

    public static Bitmap rotateImage(float f, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap && bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
