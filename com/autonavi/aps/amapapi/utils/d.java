package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import com.amap.api.location.DPoint;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/autonavi/aps/amapapi/utils/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    static double f9280a = 3.141592653589793d;
    private static final List<DPoint> b = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));

    private static double a(double d) {
        return Math.sin(d * 3000.0d * (f9280a / 180.0d)) * 2.0E-5d;
    }

    private static double a(double d, double d2) {
        return (Math.cos(d2 / 100000.0d) * (d / 18000.0d)) + (Math.sin(d / 100000.0d) * (d2 / 9000.0d));
    }

    private static DPoint a(double d, double d2, double d3, double d4) {
        DPoint dPoint = new DPoint();
        double d5 = d - d3;
        double d6 = d2 - d4;
        DPoint d7 = d(d5, d6);
        dPoint.setLongitude(c((d + d5) - d7.getLongitude()));
        dPoint.setLatitude(c((d2 + d6) - d7.getLatitude()));
        return dPoint;
    }

    public static DPoint a(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        return b(dPoint);
    }

    public static DPoint a(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (b.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return c(dPoint);
                }
                DPoint dPoint2 = dPoint;
                if (e(dPoint.getLatitude(), dPoint.getLongitude())) {
                    DPoint c2 = c(dPoint);
                    dPoint2 = f(c2.getLatitude(), c2.getLongitude());
                }
                return dPoint2;
            } catch (Throwable th) {
                b.a(th, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    private static double b(double d) {
        return Math.cos(d * 3000.0d * (f9280a / 180.0d)) * 3.0E-6d;
    }

    private static double b(double d, double d2) {
        return (Math.sin(d2 / 100000.0d) * (d / 18000.0d)) + (Math.cos(d / 100000.0d) * (d2 / 9000.0d));
    }

    public static DPoint b(Context context, DPoint dPoint) {
        try {
            return !b.a(dPoint.getLatitude(), dPoint.getLongitude()) ? dPoint : a(context, c(dPoint.getLongitude(), dPoint.getLatitude()));
        } catch (Throwable th) {
            b.a(th, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    private static DPoint b(DPoint dPoint) {
        try {
            if (b.a(dPoint.getLatitude(), dPoint.getLongitude())) {
                double[] a2 = com.autonavi.util.a.a(dPoint.getLongitude(), dPoint.getLatitude());
                return new DPoint(a2[1], a2[0]);
            }
            return dPoint;
        } catch (Throwable th) {
            b.a(th, "OffsetUtil", "cover part2");
            return dPoint;
        }
    }

    private static double c(double d) {
        return new BigDecimal(d).setScale(8, 4).doubleValue();
    }

    private static DPoint c(double d, double d2) {
        double d3;
        double d4;
        double d5 = ((long) (d * 100000.0d)) % 36000000;
        double d6 = ((long) (d2 * 100000.0d)) % 36000000;
        int i = (int) ((-a(d5, d6)) + d5);
        int i2 = (int) ((-b(d5, d6)) + d6);
        return new DPoint(((int) (((-b(d4, d3)) + d6) + (d6 > 0.0d ? 1 : -1))) / 100000.0d, ((int) (((-a(i, i2)) + d5) + (d5 > 0.0d ? 1 : -1))) / 100000.0d);
    }

    private static DPoint c(DPoint dPoint) {
        DPoint dPoint2 = null;
        double d = 0.006401062d;
        double d2 = 0.0060424805d;
        for (int i = 0; i < 2; i++) {
            dPoint2 = a(dPoint.getLongitude(), dPoint.getLatitude(), d, d2);
            d = dPoint.getLongitude() - dPoint2.getLongitude();
            d2 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }

    private static DPoint d(double d, double d2) {
        DPoint dPoint = new DPoint();
        double cos = Math.cos(b(d) + Math.atan2(d2, d));
        double a2 = a(d2);
        double d3 = (d * d) + (d2 * d2);
        double sqrt = Math.sqrt(d3);
        double sin = Math.sin(b(d) + Math.atan2(d2, d));
        double a3 = a(d2);
        double sqrt2 = Math.sqrt(d3);
        dPoint.setLongitude(c((cos * (a2 + sqrt)) + 0.0065d));
        dPoint.setLatitude(c((sin * (a3 + sqrt2)) + 0.006d));
        return dPoint;
    }

    private static boolean e(double d, double d2) {
        return b.a(new DPoint(d, d2), b);
    }

    private static DPoint f(double d, double d2) {
        DPoint g = g(d, d2);
        return new DPoint((d * 2.0d) - g.getLatitude(), (d2 * 2.0d) - g.getLongitude());
    }

    private static DPoint g(double d, double d2) {
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double h = h(d3, d4);
        double i = i(d3, d4);
        double d5 = (d / 180.0d) * f9280a;
        double sin = Math.sin(d5);
        double d6 = 1.0d - ((0.006693421622965943d * sin) * sin);
        double sqrt = Math.sqrt(d6);
        return new DPoint(d + ((h * 180.0d) / ((6335552.717000426d / (d6 * sqrt)) * f9280a)), d2 + ((i * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d5)) * f9280a)));
    }

    private static double h(double d, double d2) {
        double d3 = d * 2.0d;
        return (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((d * 6.0d) * f9280a) * 20.0d) + (Math.sin(d3 * f9280a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f9280a * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * f9280a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * f9280a) * 160.0d) + (Math.sin((d2 * f9280a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double i(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * f9280a) * 20.0d) + (Math.sin((d * 2.0d) * f9280a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f9280a * d) * 20.0d) + (Math.sin((d / 3.0d) * f9280a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * f9280a) * 150.0d) + (Math.sin((d / 30.0d) * f9280a) * 300.0d)) * 2.0d) / 3.0d);
    }
}
