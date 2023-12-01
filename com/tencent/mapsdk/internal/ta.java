package com.tencent.mapsdk.internal;

import com.tencent.map.lib.models.GeoPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ta.class */
public class ta {
    private static double a(int i, int i2, int i3, float f) {
        double d = 1.0d - f;
        return (d * d * i) + (2.0f * f * d * i2) + (f * f * i3);
    }

    private static double a(p5 p5Var, p5 p5Var2) {
        double d = p5Var2.b - p5Var.b;
        double d2 = p5Var2.f23992c - p5Var.f23992c;
        return Math.sqrt((d * d) + (d2 * d2));
    }

    private static float a(int i, int i2, int i3, int i4, float f) {
        float f2 = (i2 - i) * 3.0f;
        float f3 = ((i3 - i2) * 3.0f) - f2;
        float f4 = f * f;
        return ((((i4 - i) - f2) - f3) * f4 * f) + (f3 * f4) + (f2 * f) + i;
    }

    public static int a(List<GeoPoint> list, int[] iArr, t4 t4Var) {
        int size;
        int i = 0;
        if (list != null && (size = list.size()) >= 2) {
            int i2 = 0;
            while (i < size - 1) {
                int i3 = i + 1;
                int a2 = (int) a(t4Var.a(list.get(i)), t4Var.a(list.get(i3)));
                int max = a2 / Math.max(4, (a2 / 500) * 4);
                iArr[i] = max;
                i2 += max;
                i = i3;
            }
            return i2;
        }
        return 0;
    }

    private static GeoPoint a(List<GeoPoint> list, float f) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        if (size == 3 || size == 4) {
            if (size == 3) {
                GeoPoint geoPoint = list.get(0);
                GeoPoint geoPoint2 = list.get(1);
                GeoPoint geoPoint3 = list.get(2);
                if (geoPoint == null || geoPoint2 == null || geoPoint3 == null) {
                    return null;
                }
                return new GeoPoint((int) a(geoPoint.getLatitudeE6(), geoPoint2.getLatitudeE6(), geoPoint3.getLatitudeE6(), f), (int) a(geoPoint.getLongitudeE6(), geoPoint2.getLongitudeE6(), geoPoint3.getLongitudeE6(), f));
            }
            GeoPoint geoPoint4 = list.get(0);
            GeoPoint geoPoint5 = list.get(1);
            GeoPoint geoPoint6 = list.get(2);
            GeoPoint geoPoint7 = list.get(3);
            if (geoPoint4 == null || geoPoint5 == null || geoPoint6 == null || geoPoint7 == null) {
                return null;
            }
            return new GeoPoint((int) a(geoPoint4.getLatitudeE6(), geoPoint5.getLatitudeE6(), geoPoint6.getLatitudeE6(), geoPoint7.getLatitudeE6(), f), (int) a(geoPoint4.getLongitudeE6(), geoPoint5.getLongitudeE6(), geoPoint6.getLongitudeE6(), geoPoint7.getLongitudeE6(), f));
        }
        return null;
    }

    public static List<GeoPoint> a(List<GeoPoint> list, int i) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(i);
        GeoPoint geoPoint = list.get(0);
        GeoPoint geoPoint2 = list.get(size - 1);
        int longitudeE6 = (geoPoint.getLongitudeE6() + geoPoint2.getLongitudeE6()) / 2;
        int latitudeE6 = (geoPoint.getLatitudeE6() + geoPoint2.getLatitudeE6()) / 2;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                break;
            }
            GeoPoint geoPoint3 = list.get(i3);
            geoPoint3.setLongitudeE6(geoPoint3.getLongitudeE6() - longitudeE6);
            geoPoint3.setLatitudeE6(geoPoint3.getLatitudeE6() - latitudeE6);
            i2 = i3 + 1;
        }
        float f = 1.0f / (i + 1);
        float f2 = f;
        int i4 = 0;
        while (i4 < i) {
            GeoPoint a2 = a(list, f2);
            float f3 = f2;
            if (a2 != null) {
                a2.setLongitudeE6(a2.getLongitudeE6() + longitudeE6);
                a2.setLatitudeE6(a2.getLatitudeE6() + latitudeE6);
                arrayList.add(a2);
                f3 = f2 + f;
            }
            i4++;
            f2 = f3;
        }
        return arrayList;
    }
}
