package com.blued.android.core.image.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.lang.reflect.Array;
import java.security.MessageDigest;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/image/transform/CropSquareCircleTransformation.class */
public class CropSquareCircleTransformation extends BitmapTransformation {
    private static final Paint b = new Paint(7);

    /* renamed from: c  reason: collision with root package name */
    private static final Paint f9565c;
    private int d;

    static {
        Paint paint = new Paint(b);
        f9565c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public CropSquareCircleTransformation() {
        this(1);
    }

    public CropSquareCircleTransformation(int i) {
        this.d = 1;
        this.d = i;
    }

    private PointF a(float f, float f2) {
        PointF pointF = new PointF(0.0f, 0.0f);
        int i = (f > f2 ? 1 : (f == f2 ? 0 : -1));
        if (i == 0) {
            return pointF;
        }
        if (i > 0) {
            int i2 = this.d;
            if (i2 == 1) {
                pointF.set((f2 - f) / 2.0f, 0.0f);
                return pointF;
            } else if (i2 != 2) {
                return pointF;
            } else {
                pointF.set(f2 - f, 0.0f);
                return pointF;
            }
        }
        int i3 = this.d;
        if (i3 == 1) {
            pointF.set(0.0f, (f - f2) / 2.0f);
            return pointF;
        } else if (i3 != 2) {
            return pointF;
        } else {
            pointF.set(0.0f, f - f2);
            return pointF;
        }
    }

    private void a(Canvas canvas, Paint paint, float f) {
        PointF[][] a2 = a(f);
        Path path = new Path();
        path.moveTo(a2[0][0].x, a2[0][0].y);
        int i = 0;
        while (i < 8) {
            float f2 = a2[1][i].x;
            float f3 = a2[1][i].y;
            PointF[] pointFArr = a2[0];
            i++;
            int i2 = i % 8;
            path.quadTo(f2, f3, pointFArr[i2].x, a2[0][i2].y);
        }
        path.close();
        canvas.drawPath(path, paint);
    }

    private PointF[][] a(float f) {
        float sqrt = (float) Math.sqrt(2.0d);
        float f2 = f / 2.0f;
        PointF[][] pointFArr = (PointF[][]) Array.newInstance(PointF.class, 2, 8);
        float f3 = f2 - (((f / 0.95f) / 2.0f) / sqrt);
        float f4 = f - f3;
        pointFArr[0] = new PointF[8];
        pointFArr[0][0] = new PointF(f, f2);
        pointFArr[0][1] = new PointF(f4, f4);
        pointFArr[0][2] = new PointF(f2, f);
        pointFArr[0][3] = new PointF(f3, f4);
        pointFArr[0][4] = new PointF(0.0f, f2);
        pointFArr[0][5] = new PointF(f3, f3);
        pointFArr[0][6] = new PointF(f2, 0.0f);
        pointFArr[0][7] = new PointF(f4, f3);
        float f5 = f3 * 2.0f;
        float f6 = f - f5;
        pointFArr[1] = new PointF[8];
        pointFArr[1][0] = new PointF(f, f6);
        pointFArr[1][1] = new PointF(f6, f);
        pointFArr[1][2] = new PointF(f5, f);
        pointFArr[1][3] = new PointF(0.0f, f6);
        pointFArr[1][4] = new PointF(0.0f, f5);
        pointFArr[1][5] = new PointF(f5, 0.0f);
        pointFArr[1][6] = new PointF(f6, 0.0f);
        pointFArr[1][7] = new PointF(f, f5);
        return pointFArr;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        int min = Math.min(i, i2);
        float f = min;
        float width = bitmap.getWidth();
        float f2 = f / width;
        float height = bitmap.getHeight();
        float max = Math.max(f2, f / height);
        float f3 = width * max;
        float f4 = max * height;
        PointF a2 = a(f3, f4);
        RectF rectF = new RectF(a2.x, a2.y, a2.x + f3, a2.y + f4);
        Bitmap a3 = TransformUtils.a(bitmapPool, bitmap);
        Bitmap a4 = bitmapPool.a(min, min, TransformUtils.a(bitmap));
        a4.setHasAlpha(true);
        TransformationUtils.a().lock();
        try {
            Canvas canvas = new Canvas(a4);
            a(canvas, b, f);
            canvas.drawBitmap(a3, (Rect) null, rectF, f9565c);
            TransformUtils.a(canvas);
            TransformationUtils.a().unlock();
            if (!a3.equals(bitmap)) {
                bitmapPool.a(a3);
            }
            return a4;
        } catch (Throwable th) {
            TransformationUtils.a().unlock();
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        messageDigest.update(("com.blued.android.core.transform.CropSquareCircleTransformation.1" + this.d).getBytes(f20706a));
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof CropSquareCircleTransformation) && ((CropSquareCircleTransformation) obj).d == this.d;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (-1286243350) + (this.d * 10);
    }

    public String toString() {
        return "CropSquareCircleTransformation(position=" + this.d + ")";
    }
}
