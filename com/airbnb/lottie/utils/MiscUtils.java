package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/utils/MiscUtils.class */
public class MiscUtils {
    private static PointF a = new PointF();

    public static double a(double d, double d2, double d3) {
        return d + (d3 * (d2 - d));
    }

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(float f, float f2) {
        return a((int) f, (int) f2);
    }

    private static int a(int i, int i2) {
        return i - (i2 * b(i, i2));
    }

    public static int a(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static int a(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.c(keyPathElementContent.b(), i)) {
            list.add(keyPath2.a(keyPathElementContent.b()).a(keyPathElementContent));
        }
    }

    public static void a(ShapeData shapeData, Path path) {
        path.reset();
        PointF a2 = shapeData.a();
        path.moveTo(a2.x, a2.y);
        a.set(a2.x, a2.y);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= shapeData.c().size()) {
                break;
            }
            CubicCurveData cubicCurveData = shapeData.c().get(i2);
            PointF a3 = cubicCurveData.a();
            PointF b = cubicCurveData.b();
            PointF c = cubicCurveData.c();
            if (a3.equals(a) && b.equals(c)) {
                path.lineTo(c.x, c.y);
            } else {
                path.cubicTo(a3.x, a3.y, b.x, b.y, c.x, c.y);
            }
            a.set(c.x, c.y);
            i = i2 + 1;
        }
        if (shapeData.b()) {
            path.close();
        }
    }

    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static int b(int i, int i2) {
        int i3 = i / i2;
        int i4 = i3;
        if (!((i ^ i2) >= 0)) {
            i4 = i3;
            if (i % i2 != 0) {
                i4 = i3 - 1;
            }
        }
        return i4;
    }

    public static boolean c(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }
}
