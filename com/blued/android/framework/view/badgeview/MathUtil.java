package com.blued.android.framework.view.badgeview;

import android.graphics.PointF;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/badgeview/MathUtil.class */
public class MathUtil {
    public static double a(double d) {
        return (d / 6.283185307179586d) * 360.0d;
    }

    public static double a(double d, int i) {
        double d2 = d;
        if (d < 0.0d) {
            d2 = d + 1.5707963267948966d;
        }
        return d2 + ((i - 1) * 1.5707963267948966d);
    }

    public static int a(PointF pointF, PointF pointF2) {
        if (pointF.x > pointF2.x) {
            if (pointF.y > pointF2.y) {
                return 4;
            }
            return pointF.y < pointF2.y ? 1 : -1;
        } else if (pointF.x < pointF2.x) {
            if (pointF.y > pointF2.y) {
                return 3;
            }
            return pointF.y < pointF2.y ? 2 : -1;
        } else {
            return -1;
        }
    }

    public static void a(PointF pointF, float f, Double d, List<PointF> list) {
        float f2;
        if (d != null) {
            double atan = (float) Math.atan(d.doubleValue());
            double cos = Math.cos(atan);
            double d2 = f;
            f = (float) (cos * d2);
            f2 = (float) (Math.sin(atan) * d2);
        } else {
            f2 = 0.0f;
        }
        list.add(new PointF(pointF.x + f, pointF.y + f2));
        list.add(new PointF(pointF.x - f, pointF.y - f2));
    }

    public static float b(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
    }
}
