package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.util.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.al  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/al.class */
public final class al {

    /* renamed from: a  reason: collision with root package name */
    static double f4740a = 3.141592653589793d;
    private static boolean d = false;
    private static final double[] e = {25.575374d, 120.391111d};
    private static final double[] f = {21.405235d, 121.649046d};
    private static final List<LatLng> g = new ArrayList(Arrays.asList(new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)));
    public static double b = 6378245.0d;

    /* renamed from: c  reason: collision with root package name */
    public static double f4741c = 0.006693421622965943d;

    private static double a(double d2) {
        return Math.sin(d2 * 3000.0d * (f4740a / 180.0d)) * 2.0E-5d;
    }

    private static double a(double d2, double d3) {
        return (Math.cos(d3 / 100000.0d) * (d2 / 18000.0d)) + (Math.sin(d2 / 100000.0d) * (d3 / 9000.0d));
    }

    public static LatLng a(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (dp.a(latLng.latitude, latLng.longitude)) {
            DPoint a2 = a(DPoint.obtain(latLng.longitude, latLng.latitude), d);
            LatLng latLng2 = new LatLng(a2.y, a2.x, false);
            a2.recycle();
            return latLng2;
        }
        return latLng;
    }

    public static LatLng a(LatLng latLng) {
        if (latLng != null) {
            try {
                if (dp.a(latLng.latitude, latLng.longitude)) {
                    DPoint e2 = e(latLng.longitude, latLng.latitude);
                    LatLng latLng2 = new LatLng(e2.y, e2.x, false);
                    e2.recycle();
                    return latLng2;
                }
                LatLng latLng3 = latLng;
                if (f(latLng.latitude, latLng.longitude)) {
                    DPoint e3 = e(latLng.longitude, latLng.latitude);
                    latLng3 = g(e3.y, e3.x);
                }
                return latLng3;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return latLng;
    }

    private static DPoint a(double d2, double d3, double d4, double d5) {
        DPoint obtain = DPoint.obtain();
        double d6 = d2 - d4;
        double d7 = d3 - d5;
        DPoint d8 = d(d6, d7);
        obtain.x = c((d2 + d6) - d8.x);
        obtain.y = c((d3 + d7) - d8.y);
        return obtain;
    }

    private static DPoint a(DPoint dPoint, boolean z) {
        DPoint dPoint2 = dPoint;
        try {
            if (dp.a(dPoint.y, dPoint.x)) {
                double[] dArr = new double[2];
                if (!z) {
                    dArr = a.a(dPoint.x, dPoint.y);
                }
                dPoint.recycle();
                dPoint2 = DPoint.obtain(dArr[0], dArr[1]);
            }
            return dPoint2;
        } catch (Throwable th) {
            return dPoint;
        }
    }

    private static double b(double d2) {
        return Math.cos(d2 * 3000.0d * (f4740a / 180.0d)) * 3.0E-6d;
    }

    private static double b(double d2, double d3) {
        return (Math.sin(d3 / 100000.0d) * (d2 / 18000.0d)) + (Math.cos(d2 / 100000.0d) * (d3 / 9000.0d));
    }

    public static LatLng b(Context context, LatLng latLng) {
        try {
            if (dp.a(latLng.latitude, latLng.longitude)) {
                DPoint c2 = c(latLng.longitude, latLng.latitude);
                LatLng a2 = a(context, new LatLng(c2.y, c2.x, false));
                c2.recycle();
                return a2;
            }
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            return latLng;
        }
    }

    private static double c(double d2) {
        return new BigDecimal(d2).setScale(8, 4).doubleValue();
    }

    private static DPoint c(double d2, double d3) {
        double d4;
        double d5;
        double d6 = ((long) (d2 * 100000.0d)) % 36000000;
        double d7 = ((long) (d3 * 100000.0d)) % 36000000;
        int i = (int) ((-a(d6, d7)) + d6);
        int i2 = (int) ((-b(d6, d7)) + d7);
        return DPoint.obtain(((int) (((-a(i, i2)) + d6) + (d6 > 0.0d ? 1 : -1))) / 100000.0d, ((int) (((-b(d5, d4)) + d7) + (d7 > 0.0d ? 1 : -1))) / 100000.0d);
    }

    private static DPoint d(double d2, double d3) {
        DPoint obtain = DPoint.obtain();
        double cos = Math.cos(b(d2) + Math.atan2(d3, d2));
        double a2 = a(d3);
        double d4 = (d2 * d2) + (d3 * d3);
        double sqrt = Math.sqrt(d4);
        double sin = Math.sin(b(d2) + Math.atan2(d3, d2));
        double a3 = a(d3);
        double sqrt2 = Math.sqrt(d4);
        obtain.x = c((cos * (a2 + sqrt)) + 0.0065d);
        obtain.y = c((sin * (a3 + sqrt2)) + 0.006d);
        return obtain;
    }

    private static DPoint e(double d2, double d3) {
        DPoint dPoint = null;
        double d4 = 0.006401062d;
        double d5 = 0.0060424805d;
        for (int i = 0; i < 2; i++) {
            dPoint = a(d2, d3, d4, d5);
            d4 = d2 - dPoint.x;
            d5 = d3 - dPoint.y;
        }
        return dPoint;
    }

    private static boolean f(double d2, double d3) {
        return dw.a(new LatLng(d2, d3), g);
    }

    private static LatLng g(double d2, double d3) {
        LatLng h = h(d2, d3);
        return new LatLng((d2 * 2.0d) - h.latitude, (d3 * 2.0d) - h.longitude);
    }

    private static LatLng h(double d2, double d3) {
        double d4 = d3 - 105.0d;
        double d5 = d2 - 35.0d;
        double i = i(d4, d5);
        double j = j(d4, d5);
        double d6 = (d2 / 180.0d) * f4740a;
        double sin = Math.sin(d6);
        double d7 = 1.0d - ((f4741c * sin) * sin);
        double sqrt = Math.sqrt(d7);
        double d8 = b;
        return new LatLng(d2 + ((i * 180.0d) / ((((1.0d - f4741c) * d8) / (d7 * sqrt)) * f4740a)), d3 + ((j * 180.0d) / (((d8 / sqrt) * Math.cos(d6)) * f4740a)));
    }

    private static double i(double d2, double d3) {
        double d4 = d2 * 2.0d;
        return (-100.0d) + d4 + (d3 * 3.0d) + (d3 * 0.2d * d3) + (0.1d * d2 * d3) + (Math.sqrt(Math.abs(d2)) * 0.2d) + ((((Math.sin((d2 * 6.0d) * f4740a) * 20.0d) + (Math.sin(d4 * f4740a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f4740a * d3) * 20.0d) + (Math.sin((d3 / 3.0d) * f4740a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d3 / 12.0d) * f4740a) * 160.0d) + (Math.sin((d3 * f4740a) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double j(double d2, double d3) {
        double d4 = d2 * 0.1d;
        return d2 + 300.0d + (d3 * 2.0d) + (d4 * d2) + (d4 * d3) + (Math.sqrt(Math.abs(d2)) * 0.1d) + ((((Math.sin((6.0d * d2) * f4740a) * 20.0d) + (Math.sin((d2 * 2.0d) * f4740a) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(f4740a * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * f4740a) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * f4740a) * 150.0d) + (Math.sin((d2 / 30.0d) * f4740a) * 300.0d)) * 2.0d) / 3.0d);
    }
}