package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.col.p0003sl.dw;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/maps/utils/SpatialRelationUtil.class */
public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (list == null || latLng == null) {
            return null;
        }
        try {
            if (list.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (LatLng latLng2 : list) {
                arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                if (latLng2.equals(latLng)) {
                    return new Pair<>(Integer.valueOf(i), latLng);
                }
                i++;
            }
            Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
            if (calShortestDistancePoint != null) {
                return new Pair<>(calShortestDistancePoint.first, new LatLng(((DPoint) calShortestDistancePoint.second).x, ((DPoint) calShortestDistancePoint.second).y));
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng, float f, double d) {
        if (list == null || latLng == null) {
            return null;
        }
        try {
            if (list.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (LatLng latLng2 : list) {
                arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                if (latLng2.equals(latLng)) {
                    return new Pair<>(Integer.valueOf(i), latLng);
                }
                i++;
            }
            Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude), f);
            if (calShortestDistancePoint != null) {
                DPoint dPoint = (DPoint) calShortestDistancePoint.second;
                if (AMapUtils.calculateLineDistance(new LatLng(dPoint.x, dPoint.y), latLng) < d) {
                    return new Pair<>(calShortestDistancePoint.first, new LatLng(((DPoint) calShortestDistancePoint.second).x, ((DPoint) calShortestDistancePoint.second).y));
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint, float f) {
        Pair<Integer, DPoint> pair = null;
        Pair<Integer, DPoint> pair2 = null;
        if (list != null) {
            pair2 = null;
            if (dPoint != null) {
                if (list.size() == 0 || list.size() < 2) {
                    return null;
                }
                DPoint dPoint2 = list.get(0);
                double d = 0.0d;
                int size = list.size();
                int i = 1;
                while (true) {
                    int i2 = size - 1;
                    pair2 = pair;
                    if (i > i2) {
                        break;
                    }
                    DPoint dPoint3 = list.get(i);
                    if (i == i2 && dPoint3.equals(dPoint)) {
                        return new Pair<>(Integer.valueOf(i), dPoint);
                    }
                    if (checkRotateIsMatch(dPoint2, dPoint3, f)) {
                        if (dPoint2.equals(dPoint)) {
                            return new Pair<>(Integer.valueOf(i - 1), dPoint);
                        }
                        int i3 = i;
                        Pair<Double, DPoint> pointToSegDist = pointToSegDist(dPoint.x, dPoint.y, dPoint2.x, dPoint2.y, dPoint3.x, dPoint3.y);
                        if (pair == null) {
                            d = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i3 - 1), pointToSegDist.second);
                        } else if (d > ((Double) pointToSegDist.first).doubleValue()) {
                            d = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i3 - 1), pointToSegDist.second);
                        }
                    }
                    i++;
                    dPoint2 = dPoint3;
                }
            }
        }
        return pair2;
    }

    private static boolean checkRotateIsMatch(DPoint dPoint, DPoint dPoint2, float f) {
        if (f == -1.0f) {
            return true;
        }
        if (dPoint == null || dPoint2 == null) {
            return false;
        }
        float abs = Math.abs((dw.a(dPoint, dPoint2) + 360.0f) - f) % 360.0f;
        float f2 = abs;
        if (abs > 180.0f) {
            f2 = 360.0f - abs;
        }
        return f2 < 50.0f;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 - d3;
        double d8 = d - d3;
        double d9 = d6 - d4;
        double d10 = d2 - d4;
        double d11 = (d7 * d8) + (d9 * d10);
        if (d11 <= 0.0d) {
            return new Pair<>(Double.valueOf(Math.sqrt((d8 * d8) + (d10 * d10))), new DPoint(d3, d4));
        }
        double d12 = (d7 * d7) + (d9 * d9);
        if (d11 >= d12) {
            double d13 = d - d5;
            double d14 = d2 - d6;
            return new Pair<>(Double.valueOf(Math.sqrt((d13 * d13) + (d14 * d14))), new DPoint(d5, d6));
        }
        double d15 = d11 / d12;
        double d16 = d3 + (d7 * d15);
        double d17 = d4 + (d9 * d15);
        double d18 = d - d16;
        double d19 = d17 - d2;
        return new Pair<>(Double.valueOf(Math.sqrt((d18 * d18) + (d19 * d19))), new DPoint(d16, d17));
    }
}
