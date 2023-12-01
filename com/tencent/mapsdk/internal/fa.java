package com.tencent.mapsdk.internal;

import android.graphics.Point;
import android.location.Location;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fa.class */
public class fa {

    /* renamed from: a  reason: collision with root package name */
    private static final int f37442a = 20037508;
    private static final int b = 30240971;

    /* renamed from: c  reason: collision with root package name */
    public static final int f37443c = 256;
    public static final int d = 20;
    public static final double e = 4.272282972352698E7d;
    private static final double f = 111319.49077777778d;
    private static final double g = 0.017453292519943295d;
    private static final double h = 0.008726646259971648d;
    private static final double i = 114.59155902616465d;

    private static double a(double d2) {
        return (d2 * 3.141592653589793d) / 180.0d;
    }

    public static double a(double d2, double d3, double d4, double d5) {
        double a2 = a(d4 - d2);
        double a3 = a(d5 - d3);
        double a4 = a(d2);
        double a5 = a(d4);
        double d6 = a2 / 2.0d;
        double sin = Math.sin(d6);
        double sin2 = Math.sin(d6);
        double d7 = a3 / 2.0d;
        double sin3 = (sin * sin2) + (Math.sin(d7) * Math.sin(d7) * Math.cos(a4) * Math.cos(a5));
        return Math.atan2(Math.sqrt(sin3), Math.sqrt(1.0d - sin3)) * 2.0d * 6371.0d * 1000.0d;
    }

    public static float a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint == null || geoPoint2 == null) {
            throw new IllegalArgumentException("point is null");
        }
        return (float) a(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d, geoPoint2.getLatitudeE6() / 1000000.0d, geoPoint2.getLongitudeE6() / 1000000.0d);
    }

    public static int a(int i2) {
        return i2 - f37442a;
    }

    public static Point a(GeoPoint geoPoint) {
        if (geoPoint != null) {
            double latitudeE6 = geoPoint.getLatitudeE6() / 1000000.0d;
            double longitudeE6 = geoPoint.getLongitudeE6() / 1000000.0d;
            double log = Math.log(Math.tan((latitudeE6 + 90.0d) * h)) / 0.01745329238474369d;
            Point point = new Point();
            point.x = (int) (((longitudeE6 + 180.0d) / 360.0d) * 2.68435456E8d);
            point.y = (int) (((180.0d - log) / 360.0d) * 2.68435456E8d);
            return point;
        }
        throw new IllegalArgumentException("point is null");
    }

    public static GeoPoint a(int i2, int i3) {
        return new GeoPoint((int) (d(i3) * 1000000.0d), (int) (c(i2) * 1000000.0d));
    }

    public static List<LatLng> a(List<GeoPoint> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (GeoPoint geoPoint : list) {
            arrayList.add(d(geoPoint));
        }
        return arrayList;
    }

    public static void a(double d2, double d3, double d4, double d5, float[] fArr) {
        double d6 = (g * d5) - (d3 * g);
        double atan = Math.atan(Math.tan(d2 * g) * 0.996647189328169d);
        double atan2 = Math.atan(Math.tan(d4 * g) * 0.996647189328169d);
        double cos = Math.cos(atan);
        double cos2 = Math.cos(atan2);
        double sin = Math.sin(atan);
        double sin2 = Math.sin(atan2);
        double d7 = cos * cos2;
        double d8 = sin * sin2;
        double d9 = d6;
        double d10 = 0.0d;
        double d11 = 0.0d;
        double d12 = 0.0d;
        double d13 = 0.0d;
        double d14 = 0.0d;
        int i2 = 0;
        while (i2 < 20) {
            d13 = Math.cos(d9);
            d14 = Math.sin(d9);
            double d15 = cos2 * d14;
            double d16 = (cos * sin2) - ((sin * cos2) * d13);
            double sqrt = Math.sqrt((d15 * d15) + (d16 * d16));
            double d17 = d8 + (d7 * d13);
            d11 = Math.atan2(sqrt, d17);
            double d18 = sqrt == 0.0d ? 0.0d : (d7 * d14) / sqrt;
            double d19 = 1.0d - (d18 * d18);
            double d20 = d19 == 0.0d ? 0.0d : d17 - ((d8 * 2.0d) / d19);
            double d21 = 0.006739496756586903d * d19;
            d10 = ((d21 / 16384.0d) * (((((320.0d - (175.0d * d21)) * d21) - 768.0d) * d21) + 4096.0d)) + 1.0d;
            double d22 = (d21 / 1024.0d) * ((d21 * (((74.0d - (47.0d * d21)) * d21) - 128.0d)) + 256.0d);
            double d23 = 2.0955066698943685E-4d * d19 * (((4.0d - (d19 * 3.0d)) * 0.0033528106718309896d) + 4.0d);
            double d24 = d20 * d20;
            d12 = d22 * sqrt * (d20 + ((d22 / 4.0d) * ((((d24 * 2.0d) - 1.0d) * d17) - ((((d22 / 6.0d) * d20) * (((sqrt * 4.0d) * sqrt) - 3.0d)) * ((d24 * 4.0d) - 3.0d)))));
            double d25 = d6 + ((1.0d - d23) * 0.0033528106718309896d * d18 * (d11 + (sqrt * d23 * (d20 + (d23 * d17 * (((2.0d * d20) * d20) - 1.0d))))));
            if (Math.abs((d25 - d9) / d25) < 1.0E-12d) {
                break;
            }
            i2++;
            d9 = d25;
        }
        fArr[0] = (float) (6356752.3142d * d10 * (d11 - d12));
        if (fArr.length > 1) {
            double d26 = cos * sin2;
            fArr[1] = (float) (((float) Math.atan2(cos2 * d14, d26 - ((sin * cos2) * d13))) * 57.29577951308232d);
            if (fArr.length > 2) {
                fArr[2] = (float) (((float) Math.atan2(cos * d14, ((-sin) * cos2) + (d26 * d13))) * 57.29577951308232d);
            }
        }
    }

    public static float b(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint == null || geoPoint2 == null) {
            return 0.0f;
        }
        float[] fArr = new float[10];
        b(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d, geoPoint2.getLatitudeE6() / 1000000.0d, geoPoint2.getLongitudeE6() / 1000000.0d, fArr);
        return fArr[1];
    }

    public static int b(double d2) {
        return (int) (((Math.log(Math.tan((d2 + 90.0d) * h)) / g) * f) + 3.0240971E7d);
    }

    public static int b(int i2) {
        return i2 - b;
    }

    public static Point b(GeoPoint geoPoint) {
        if (geoPoint != null) {
            return new Point(c(geoPoint.getLongitudeE6() / 1000000.0d), b(geoPoint.getLatitudeE6() / 1000000.0d));
        }
        throw new IllegalArgumentException("point is null");
    }

    public static GeoPoint b(int i2, int i3) {
        return new GeoPoint((int) (Math.toDegrees((Math.atan(Math.exp(3.141592653589793d - (i3 / 4.272282972352698E7d))) - 0.7853981633974483d) * 2.0d) * 1000000.0d), (int) (Math.toDegrees((i2 / 4.272282972352698E7d) - 3.141592653589793d) * 1000000.0d));
    }

    public static void b(double d2, double d3, double d4, double d5, float[] fArr) {
        if (fArr == null || fArr.length < 1) {
            throw new IllegalArgumentException("results is null or has length < 1");
        }
        Location.distanceBetween(d2, d3, d4, d5, fArr);
        fArr[0] = (float) a(d2, d3, d4, d5);
    }

    public static double c(int i2) {
        return (i2 - f37442a) / f;
    }

    public static int c(double d2) {
        return (int) ((d2 * f) + 2.0037508E7d);
    }

    public static Point c(int i2, int i3) {
        return new Point(a(c(i2 / 1000000.0d)), b(b(i3 / 1000000.0d)));
    }

    public static Point c(GeoPoint geoPoint) {
        if (geoPoint != null) {
            return new Point(a(c(geoPoint.getLongitudeE6() / 1000000.0d)), b(b(geoPoint.getLatitudeE6() / 1000000.0d)));
        }
        throw new IllegalArgumentException("point is null");
    }

    public static double d(int i2) {
        return (Math.atan(Math.exp(((i2 - b) / f) * g)) * i) - 90.0d;
    }

    public static GeoPoint d(int i2, int i3) {
        return new GeoPoint((int) (d(f(i3)) * 1000000.0d), (int) (c(e(i2)) * 1000000.0d));
    }

    public static LatLng d(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return new LatLng(geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d);
    }

    public static int e(int i2) {
        return i2 + f37442a;
    }

    public static int f(int i2) {
        return i2 + b;
    }
}
