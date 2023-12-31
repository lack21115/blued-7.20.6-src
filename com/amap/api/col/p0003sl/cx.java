package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.amap.api.maps.AMap;
import com.amap.api.services.district.DistrictSearchQuery;

/* renamed from: com.amap.api.col.3sl.cx  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/cx.class */
public final class cx {
    public static final int[][] a = {new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{12}, new int[]{1}, new int[]{13}, new int[]{14}, new int[]{15, 16}, new int[]{17, 18, 19, 20, 21, 26, 27, 28}, new int[]{22, 23}, new int[]{24, 25}, new int[]{39, 40, 41}, new int[]{29, 30, 31}, new int[]{32, 33, 34, 35, 36, 37, 38}};
    public static final String[] b = {"land", "water", "green", "building", "highway", "arterial", AMap.LOCAL, "railway", "subway", "boundary", "poilabel", "districtlable"};
    public static final String[][] c = {new String[]{"land", "edu", "public", "traffic", "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway"}, new String[]{"water"}, new String[]{"green"}, new String[]{"buildings"}, new String[]{"highWay"}, new String[]{"ringRoad", "nationalRoad"}, new String[]{"provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", "other"}, new String[]{"railway", "highSpeedRailway"}, new String[]{"subwayline", "subwayBeingBuilt"}, new String[]{"China", "foreign", "provincial"}, new String[]{"guideBoards", "pois", "aois"}, new String[]{"continent", DistrictSearchQuery.KEYWORDS_COUNTRY, DistrictSearchQuery.KEYWORDS_PROVINCE, DistrictSearchQuery.KEYWORDS_CITY, DistrictSearchQuery.KEYWORDS_DISTRICT, "town", "village"}};
    public static final String[] d = {"regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels"};

    public static String[] a(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            String[] strArr = b;
            i = -1;
            if (i3 >= strArr.length) {
                break;
            } else if (strArr[i3].equals(str)) {
                i = i3;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        if (i >= 0) {
            return c[i];
        }
        return null;
    }

    public static String b(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            String[] strArr = b;
            i = -1;
            if (i3 >= strArr.length) {
                break;
            } else if (strArr[i3].equals(str)) {
                i = i3;
                break;
            } else {
                i2 = i3 + 1;
            }
        }
        if (i >= 0) {
            return d[i];
        }
        return null;
    }
}
