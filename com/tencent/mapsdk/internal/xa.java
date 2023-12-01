package com.tencent.mapsdk.internal;

import android.graphics.PointF;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.map.tools.IndexCallback;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Coordinate;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/xa.class */
public class xa {
    public static double a(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static double a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((((d2 - d4) * d5) + ((d3 - d) * d6)) + (d * d4)) - (d3 * d2);
    }

    public static double a(double d, int i) {
        try {
            return new BigDecimal(d).setScale(i, 4).doubleValue();
        } catch (Exception e) {
            return d;
        }
    }

    public static double a(Coordinate coordinate, Coordinate coordinate2) {
        double x = coordinate.x() - coordinate2.x();
        double y = coordinate.y() - coordinate2.y();
        return Math.sqrt((x * x) + (y * y));
    }

    public static double a(Coordinate coordinate, Coordinate coordinate2, double d, boolean z, Coordinate coordinate3) {
        double a2 = (a(coordinate, coordinate2) * 0.5d) / Math.sin(a(0.5d * d));
        double x = (coordinate.x() + coordinate2.x()) / 2.0d;
        double y = (coordinate.y() + coordinate2.y()) / 2.0d;
        double sqrt = Math.sqrt((Math.pow(a2, 2.0d) / (Math.pow(coordinate.x() - coordinate2.x(), 2.0d) + Math.pow(coordinate.y() - coordinate2.y(), 2.0d))) - 0.25d);
        double y2 = (coordinate.y() - coordinate2.y()) * sqrt;
        double x2 = (coordinate2.x() - coordinate.x()) * sqrt;
        double d2 = y2;
        double d3 = x2;
        if (d - 90.0d <= 1.0E-6d) {
            d2 = -y2;
            d3 = -x2;
        }
        double d4 = d2;
        if (Double.isNaN(d2)) {
            d4 = 0.0d;
        }
        double d5 = d3;
        if (Double.isNaN(d3)) {
            d5 = 0.0d;
        }
        double d6 = z ? x + d4 : x - d4;
        double d7 = z ? y + d5 : y - d5;
        coordinate3.setX(d6);
        coordinate3.setY(d7);
        return a2;
    }

    public static double a(Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3) {
        return Math.atan((a(coordinate, coordinate2) / 2.0d) / c(coordinate3, coordinate, coordinate2)) * 2.0d;
    }

    public static double a(Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3, Coordinate coordinate4) {
        double x = (coordinate2.x() - coordinate.x()) * 2.0d;
        double y = (coordinate2.y() - coordinate.y()) * 2.0d;
        double x2 = (((coordinate2.x() * coordinate2.x()) + (coordinate2.y() * coordinate2.y())) - (coordinate.x() * coordinate.x())) - (coordinate.y() * coordinate.y());
        double x3 = (coordinate3.x() - coordinate2.x()) * 2.0d;
        double y2 = (coordinate3.y() - coordinate2.y()) * 2.0d;
        double x4 = (((coordinate3.x() * coordinate3.x()) + (coordinate3.y() * coordinate3.y())) - (coordinate2.x() * coordinate2.x())) - (coordinate2.y() * coordinate2.y());
        double d = (y2 * x) - (y * x3);
        double d2 = ((x2 * y2) - (x4 * y)) / d;
        double d3 = ((x * x4) - (x3 * x2)) / d;
        coordinate4.setX(d2);
        coordinate4.setY(d3);
        return Math.sqrt(Math.pow(coordinate.x() - d2, 2.0d) + Math.pow(coordinate.y() - d3, 2.0d));
    }

    public static float a(float f, int i) {
        try {
            return new BigDecimal(f).setScale(i, 4).floatValue();
        } catch (Exception e) {
            return f;
        }
    }

    public static int a(int i, int i2) {
        int i3 = i2 - i;
        if (i3 > 0) {
            return new SecureRandom().nextInt(i3) + i;
        }
        if (i3 == 0) {
            return i;
        }
        return 0;
    }

    public static PointF a(PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        float f = pointF2.x;
        float f2 = pointF.x;
        if (f != f2) {
            float f3 = pointF4.x;
            float f4 = pointF3.x;
            if (f3 == f4) {
                return null;
            }
            float f5 = pointF2.y;
            float f6 = pointF.y;
            float f7 = f - f2;
            float f8 = (f5 - f6) / f7;
            float f9 = pointF4.y;
            float f10 = pointF3.y;
            float f11 = f3 - f4;
            float f12 = (f9 - f10) / f11;
            if (f8 == f12) {
                return null;
            }
            float f13 = ((f6 * f) - (f5 * f2)) / f7;
            float f14 = ((f10 * f3) - (f9 * f4)) / f11;
            float f15 = (f14 - f13) / (f8 - f12);
            return new PointF(f15, (f12 * f15) + f14);
        }
        return null;
    }

    public static Rect a(GeoPoint geoPoint, Rect rect) {
        int max = Math.max(Math.abs(rect.left - geoPoint.getLongitudeE6()), Math.abs(rect.right - geoPoint.getLongitudeE6()));
        int max2 = Math.max(Math.abs(rect.top - geoPoint.getLatitudeE6()), Math.abs(rect.bottom - geoPoint.getLatitudeE6()));
        return new Rect(geoPoint.getLongitudeE6() - max2, geoPoint.getLatitudeE6() - max, geoPoint.getLongitudeE6() + max2, geoPoint.getLatitudeE6() + max);
    }

    public static Rect a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint == null || geoPoint2 == null || geoPoint.equals(geoPoint2)) {
            return null;
        }
        int abs = Math.abs(geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6());
        int abs2 = Math.abs(geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6());
        return new Rect(geoPoint.getLongitudeE6() - abs, geoPoint.getLatitudeE6() - abs2, geoPoint.getLongitudeE6() + abs, geoPoint.getLatitudeE6() + abs2);
    }

    public static GeoPoint a(GeoPoint geoPoint, GeoPoint geoPoint2, GeoPoint geoPoint3) {
        int latitudeE6 = geoPoint2.getLatitudeE6() - geoPoint.getLatitudeE6();
        int longitudeE6 = geoPoint2.getLongitudeE6() - geoPoint.getLongitudeE6();
        if (latitudeE6 == 0 && longitudeE6 == 0) {
            return null;
        }
        double latitudeE62 = (((geoPoint3.getLatitudeE6() - geoPoint.getLatitudeE6()) * latitudeE6) + ((geoPoint3.getLongitudeE6() - geoPoint.getLongitudeE6()) * longitudeE6)) / ((latitudeE6 * latitudeE6) + (longitudeE6 * longitudeE6));
        return latitudeE62 < 0.0d ? new GeoPoint(geoPoint) : latitudeE62 > 1.0d ? new GeoPoint(geoPoint2) : new GeoPoint(geoPoint.getLatitudeE6() + ((int) (latitudeE6 * latitudeE62)), geoPoint.getLongitudeE6() + ((int) (longitudeE6 * latitudeE62)));
    }

    public static LatLng a(LatLng latLng, LatLng latLng2, int i) {
        double d = latLng2.longitude;
        double d2 = latLng.longitude;
        double d3 = i;
        double d4 = d > d2 ? d2 - d3 : d2 + d3;
        double d5 = latLng2.latitude;
        double d6 = latLng.latitude;
        double d7 = i;
        return new LatLng(d5 > d6 ? d6 - d7 : d6 + d7, d4);
    }

    public static String a() {
        byte[] bArr = new byte[20];
        new SecureRandom().nextBytes(bArr);
        return new String(bArr);
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        IOException e;
        int i;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    byte[] bArr = new byte[10485760];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        i = 0;
                        if (read <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    }
                    String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
                    int length = 40 - bigInteger.length();
                    String str = bigInteger;
                    if (length > 0) {
                        while (true) {
                            str = bigInteger;
                            if (i >= length) {
                                break;
                            }
                            bigInteger = "0" + bigInteger;
                            i++;
                        }
                    }
                    ha.a((Closeable) fileInputStream);
                    return str;
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    ha.a((Closeable) fileInputStream);
                    return "";
                } catch (NoSuchAlgorithmException e3) {
                    e = e3;
                    e.printStackTrace();
                    ha.a((Closeable) fileInputStream);
                    return "";
                } catch (Throwable th) {
                    fileInputStream2 = fileInputStream;
                    th = th;
                    ha.a((Closeable) fileInputStream2);
                    throw th;
                }
            } catch (IOException e4) {
                fileInputStream = null;
                e = e4;
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                fileInputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? str : wa.a(str.getBytes());
    }

    public static <T extends Coordinate> void a(T t, double d, T t2, T t3, boolean z, IndexCallback<Pair<Double, Double>> indexCallback) {
        if (indexCallback == null) {
            return;
        }
        double b = b(t, t2);
        boolean z2 = t.x() > t2.x() ? !z : z;
        int i = 0;
        double d2 = 0.0d;
        while (i < 360) {
            double d3 = i;
            double tan = Math.tan(a(z ? b - d3 : d3 + b));
            boolean z3 = z2;
            if (d2 != 0.0d) {
                z3 = z2;
                if (d2 * tan < 0.0d) {
                    z3 = z2;
                    if (Math.abs(tan) > 1.0d) {
                        z3 = !z2;
                    }
                }
            }
            double sqrt = d / Math.sqrt((tan * tan) + 1.0d);
            double d4 = tan * sqrt;
            na.a(ma.f, i + ":curDeltaK[" + tan + "]deltaKChanged[" + z3 + "]clockwise[" + z + "]deltaX[" + sqrt + "]deltaY[" + d4 + "]");
            double d5 = sqrt;
            double d6 = d4;
            if (z3) {
                d5 = -sqrt;
                d6 = -d4;
            }
            double x = z ? t.x() - d5 : t.x() + d5;
            double y = z ? t.y() - d6 : t.y() + d6;
            double a2 = a(t2.x(), t2.y(), t3.x(), t3.y(), x, y);
            if (z) {
                if (a2 <= 0.0d) {
                    i++;
                    d2 = tan;
                    z2 = z3;
                }
                indexCallback.callback(i, new Pair<>(Double.valueOf(x), Double.valueOf(y)));
                i++;
                d2 = tan;
                z2 = z3;
            } else {
                if (a2 >= 0.0d) {
                    i++;
                    d2 = tan;
                    z2 = z3;
                }
                indexCallback.callback(i, new Pair<>(Double.valueOf(x), Double.valueOf(y)));
                i++;
                d2 = tan;
                z2 = z3;
            }
        }
    }

    public static boolean a(LatLng latLng, double d, LatLng latLng2, LatLng latLng3) {
        if (c((Coordinate) latLng, (Coordinate) latLng2, (Coordinate) latLng3) - d > 1.0E-6d) {
            return false;
        }
        return c(b(latLng, latLng2, latLng3), latLng2, latLng3);
    }

    public static double[] a(LatLng latLng, LatLng latLng2) {
        double d;
        double d2 = Double.NaN;
        if (Math.abs(latLng.longitude - latLng2.longitude) < 1.0E-6d) {
            d = Double.NaN;
        } else if (Math.abs(latLng.latitude - latLng2.latitude) < 1.0E-6d) {
            d2 = 0.0d;
            d = latLng.latitude;
        } else {
            double d3 = latLng2.latitude;
            double d4 = latLng.latitude;
            double d5 = latLng2.longitude;
            double d6 = latLng.longitude;
            d2 = (d3 - d4) / (d5 - d6);
            d = ((d5 * d4) - (d6 * d3)) / (d5 - d4);
        }
        return new double[]{d2, d};
    }

    public static double[] a(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d;
        double[] a2 = a(latLng2, latLng3);
        double d2 = Double.NaN;
        if (Double.isNaN(a2[0])) {
            d = latLng.latitude;
            d2 = 0.0d;
        } else if (a2[0] == 0.0d) {
            d = Double.NaN;
        } else {
            d2 = (-1.0d) / a2[0];
            d = latLng.latitude + ((1.0d / a2[0]) * latLng.longitude);
        }
        return new double[]{d2, d};
    }

    public static double b(double d) {
        double d2 = d % 360.0d;
        if (d2 > 180.0d) {
            return d2 - 360.0d;
        }
        double d3 = d2;
        if (d2 < -180.0d) {
            d3 = d2 + 360.0d;
        }
        return d3;
    }

    public static double b(Coordinate coordinate, Coordinate coordinate2) {
        return c(Math.atan(c(coordinate, coordinate2)));
    }

    public static double b(Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3) {
        return a(coordinate, coordinate2, coordinate3) * a(coordinate, coordinate3);
    }

    public static LatLng b(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        double d;
        double d2;
        double[] a2 = a(latLng2, latLng3);
        if (Double.isNaN(a2[0])) {
            d = latLng2.longitude;
            d2 = latLng.latitude;
        } else if (a2[0] == 0.0d) {
            d = latLng.longitude;
            d2 = latLng2.latitude;
        } else {
            double d3 = a2[0];
            double d4 = d3 * d3;
            double d5 = latLng2.longitude;
            double d6 = latLng.latitude;
            double d7 = latLng2.latitude;
            d = (((d4 * d5) + ((d6 - d7) * d3)) + latLng.longitude) / (d4 + 1.0d);
            d2 = (d3 * (d - d5)) + d7;
        }
        return new LatLng(d2, d);
    }

    public static double c(double d) {
        return (d * 180.0d) / 3.141592653589793d;
    }

    public static double c(Coordinate coordinate, Coordinate coordinate2) {
        return (coordinate.y() - coordinate2.y()) / (coordinate.x() - coordinate2.x());
    }

    public static double c(Coordinate coordinate, Coordinate coordinate2, Coordinate coordinate3) {
        double a2 = a(coordinate, coordinate2);
        double a3 = a(coordinate, coordinate3);
        double a4 = a(coordinate2, coordinate3);
        double d = a2 + a3;
        if (d == a4) {
            return 0.0d;
        }
        if (a4 <= 1.0E-6d) {
            return a2;
        }
        double d2 = a3 * a3;
        double d3 = a2 * a2;
        double d4 = a4 * a4;
        if (d2 >= d3 + d4) {
            return a2;
        }
        if (d3 >= d2 + d4) {
            return a3;
        }
        double d5 = (d + a4) / 2.0d;
        return (Math.sqrt((((d5 - a2) * d5) * (d5 - a3)) * (d5 - a4)) * 2.0d) / a4;
    }

    public static boolean c(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        return (a((Coordinate) latLng2, (Coordinate) latLng3) - a((Coordinate) latLng, (Coordinate) latLng2)) - a((Coordinate) latLng, (Coordinate) latLng3) < 1.0E-6d;
    }
}
