package android.hardware.camera2.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CaptureRequest;
import android.util.Rational;
import android.util.Size;
import com.android.internal.util.Preconditions;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/ParamsUtils.class */
public class ParamsUtils {
    private static final int RATIONAL_DENOMINATOR = 1000000;

    private ParamsUtils() {
        throw new AssertionError();
    }

    public static void convertRectF(Rect rect, RectF rectF) {
        Preconditions.checkNotNull(rect, "source must not be null");
        Preconditions.checkNotNull(rectF, "destination must not be null");
        rectF.left = rect.left;
        rectF.right = rect.right;
        rectF.bottom = rect.bottom;
        rectF.top = rect.top;
    }

    public static Rational createRational(float f) {
        int i;
        int i2;
        float f2;
        if (Float.isNaN(f)) {
            return Rational.NaN;
        }
        if (f == Float.POSITIVE_INFINITY) {
            return Rational.POSITIVE_INFINITY;
        }
        if (f == Float.NEGATIVE_INFINITY) {
            return Rational.NEGATIVE_INFINITY;
        }
        if (f == 0.0f) {
            return Rational.ZERO;
        }
        while (true) {
            i2 = i;
            f2 = f * i2;
            i = ((f2 <= -2.14748365E9f || f2 >= 2.14748365E9f) && i2 != 1) ? i2 / 10 : 1000000;
        }
        return new Rational((int) f2, i2);
    }

    public static Rect createRect(RectF rectF) {
        Preconditions.checkNotNull(rectF, "rect must not be null");
        Rect rect = new Rect();
        rectF.roundOut(rect);
        return rect;
    }

    public static Rect createRect(Size size) {
        Preconditions.checkNotNull(size, "size must not be null");
        return new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    public static Size createSize(Rect rect) {
        Preconditions.checkNotNull(rect, "rect must not be null");
        return new Size(rect.width(), rect.height());
    }

    public static <T> T getOrDefault(CaptureRequest captureRequest, CaptureRequest.Key<T> key, T t) {
        Preconditions.checkNotNull(captureRequest, "r must not be null");
        Preconditions.checkNotNull(key, "key must not be null");
        Preconditions.checkNotNull(t, "defaultValue must not be null");
        T t2 = (T) captureRequest.get(key);
        return t2 == null ? t : t2;
    }

    public static Rect mapRect(Matrix matrix, Rect rect) {
        Preconditions.checkNotNull(matrix, "transform must not be null");
        Preconditions.checkNotNull(rect, "rect must not be null");
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        return createRect(rectF);
    }
}
