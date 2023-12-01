package com.amap.api.col.p0003sl;

import android.os.Bundle;
import android.telecom.PhoneAccount;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.c  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static long f4802a;

    private static double a(DPoint dPoint, DPoint dPoint2, DPoint dPoint3) {
        double longitude;
        double latitude;
        double longitude2 = dPoint.getLongitude();
        double longitude3 = dPoint2.getLongitude();
        double latitude2 = dPoint.getLatitude();
        double latitude3 = dPoint2.getLatitude();
        double longitude4 = dPoint3.getLongitude() - dPoint2.getLongitude();
        double latitude4 = dPoint3.getLatitude() - dPoint2.getLatitude();
        double d = (((longitude2 - longitude3) * longitude4) + ((latitude2 - latitude3) * latitude4)) / ((longitude4 * longitude4) + (latitude4 * latitude4));
        boolean z = dPoint2.getLongitude() == dPoint3.getLongitude() && dPoint2.getLatitude() == dPoint3.getLatitude();
        if (d < 0.0d || z) {
            longitude = dPoint2.getLongitude();
            latitude = dPoint2.getLatitude();
        } else if (d > 1.0d) {
            longitude = dPoint3.getLongitude();
            latitude = dPoint3.getLatitude();
        } else {
            double longitude5 = dPoint2.getLongitude();
            latitude = dPoint2.getLatitude() + (d * latitude4);
            longitude = longitude5 + (longitude4 * d);
        }
        return i.a(new DPoint(dPoint.getLatitude(), dPoint.getLongitude()), new DPoint(latitude, longitude));
    }

    public static int a(String str, List<GeoFence> list, Bundle bundle) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            int i = optInt2;
            if (optInt == 1) {
                JSONArray optJSONArray = jSONObject.optJSONArray("pois");
                i = optInt2;
                if (optJSONArray != null) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        i = optInt2;
                        if (i3 >= optJSONArray.length()) {
                            break;
                        }
                        GeoFence geoFence = new GeoFence();
                        PoiItem poiItem = new PoiItem();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        poiItem.setPoiId(jSONObject2.optString("id"));
                        poiItem.setPoiName(jSONObject2.optString("name"));
                        poiItem.setPoiType(jSONObject2.optString("type"));
                        poiItem.setTypeCode(jSONObject2.optString("typecode"));
                        poiItem.setAddress(jSONObject2.optString("address"));
                        String optString = jSONObject2.optString("location");
                        if (optString != null) {
                            String[] split = optString.split(",");
                            poiItem.setLongitude(Double.parseDouble(split[0]));
                            poiItem.setLatitude(Double.parseDouble(split[1]));
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                            arrayList2.add(dPoint);
                            arrayList.add(arrayList2);
                            geoFence.setPointList(arrayList);
                            geoFence.setCenter(dPoint);
                        }
                        poiItem.setTel(jSONObject2.optString(PhoneAccount.SCHEME_TEL));
                        poiItem.setProvince(jSONObject2.optString("pname"));
                        poiItem.setCity(jSONObject2.optString("cityname"));
                        poiItem.setAdname(jSONObject2.optString("adname"));
                        geoFence.setPoiItem(poiItem);
                        StringBuilder sb = new StringBuilder();
                        sb.append(a());
                        geoFence.setFenceId(sb.toString());
                        if (bundle != null) {
                            geoFence.setCustomId(bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
                            geoFence.setPendingIntentAction(bundle.getString("pendingIntentAction"));
                            geoFence.setType(2);
                            geoFence.setRadius(bundle.getFloat("fenceRadius"));
                            geoFence.setExpiration(bundle.getLong("expiration"));
                            geoFence.setActivatesAction(bundle.getInt("activatesAction", 1));
                        }
                        if (list != null) {
                            list.add(geoFence);
                        }
                        i2 = i3 + 1;
                    }
                }
            }
            return i;
        } catch (Throwable th) {
            return 5;
        }
    }

    public static long a() {
        long j;
        synchronized (c.class) {
            try {
                long b = i.b();
                if (b > f4802a) {
                    f4802a = b;
                } else {
                    f4802a++;
                }
                j = f4802a;
            } finally {
            }
        }
        return j;
    }

    private List<DPoint> a(List<DPoint> list, float f) {
        if (list == null) {
            return null;
        }
        if (list.size() <= 2) {
            return list;
        }
        double d = 0.0d;
        ArrayList arrayList = new ArrayList();
        DPoint dPoint = list.get(0);
        DPoint dPoint2 = list.get(list.size() - 1);
        int i = 1;
        int i2 = 0;
        while (i < list.size() - 1) {
            double a2 = a(list.get(i), dPoint, dPoint2);
            double d2 = d;
            if (a2 > d) {
                i2 = i;
                d2 = a2;
            }
            i++;
            d = d2;
        }
        if (d < f) {
            arrayList.add(dPoint);
            arrayList.add(dPoint2);
            return arrayList;
        }
        List<DPoint> a3 = a(list.subList(0, i2 + 1), f);
        List<DPoint> a4 = a(list.subList(i2, list.size()), f);
        arrayList.addAll(a3);
        arrayList.remove(arrayList.size() - 1);
        arrayList.addAll(a4);
        return arrayList;
    }

    public static int b(String str, List<GeoFence> list, Bundle bundle) {
        return a(str, list, bundle);
    }

    public final int c(String str, List<GeoFence> list, Bundle bundle) {
        String str2;
        String str3;
        ArrayList a2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            int optInt2 = jSONObject.optInt("infocode", 0);
            String string = bundle.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
            String string2 = bundle.getString("pendingIntentAction");
            float f = bundle.getFloat("fenceRadius");
            long j = bundle.getLong("expiration");
            int i = bundle.getInt("activatesAction", 1);
            int i2 = optInt2;
            if (optInt == 1) {
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                i2 = optInt2;
                if (optJSONArray != null) {
                    int i3 = 0;
                    while (true) {
                        String str4 = string2;
                        i2 = optInt2;
                        if (i3 >= optJSONArray.length()) {
                            break;
                        }
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        GeoFence geoFence = new GeoFence();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        String optString = jSONObject2.optString("citycode");
                        String optString2 = jSONObject2.optString("adcode");
                        String optString3 = jSONObject2.optString("name");
                        String string3 = jSONObject2.getString("center");
                        DPoint dPoint = new DPoint();
                        if (string3 != null) {
                            String[] split = string3.split(",");
                            dPoint.setLatitude(Double.parseDouble(split[1]));
                            dPoint.setLongitude(Double.parseDouble(split[0]));
                            geoFence.setCenter(dPoint);
                        }
                        geoFence.setCustomId(string);
                        geoFence.setPendingIntentAction(str4);
                        geoFence.setType(3);
                        geoFence.setRadius(f);
                        geoFence.setExpiration(j);
                        geoFence.setActivatesAction(i);
                        StringBuilder sb = new StringBuilder();
                        sb.append(a());
                        geoFence.setFenceId(sb.toString());
                        String optString4 = jSONObject2.optString("polyline");
                        if (optString4 != null) {
                            String[] split2 = optString4.split("\\|");
                            int length = split2.length;
                            float f2 = Float.MAX_VALUE;
                            int i4 = 0;
                            float f3 = Float.MIN_VALUE;
                            while (i4 < length) {
                                String str5 = split2[i4];
                                DistrictItem districtItem = new DistrictItem();
                                ArrayList arrayList3 = new ArrayList();
                                districtItem.setCitycode(optString);
                                districtItem.setAdcode(optString2);
                                districtItem.setDistrictName(optString3);
                                String str6 = optString3;
                                String[] split3 = str5.split(";");
                                int i5 = 0;
                                while (true) {
                                    int i6 = i5;
                                    if (i6 >= split3.length) {
                                        break;
                                    }
                                    String[] split4 = split3[i6].split(",");
                                    if (split4.length > 1) {
                                        arrayList3.add(new DPoint(Double.parseDouble(split4[1]), Double.parseDouble(split4[0])));
                                    }
                                    i5 = i6 + 1;
                                }
                                if (arrayList3.size() > 100.0f) {
                                    try {
                                        a2 = a(arrayList3, 100.0f);
                                    } catch (Throwable th) {
                                        return 5;
                                    }
                                } else {
                                    a2 = arrayList3;
                                }
                                arrayList2.add(a2);
                                districtItem.setPolyline(a2);
                                arrayList.add(districtItem);
                                f3 = Math.max(f3, a.b(dPoint, a2));
                                f2 = Math.min(f2, a.a(dPoint, a2));
                                i4++;
                                optString3 = str6;
                            }
                            geoFence.setMaxDis2Center(f3);
                            geoFence.setMinDis2Center(f2);
                            geoFence.setDistrictItemList(arrayList);
                            geoFence.setPointList(arrayList2);
                            list.add(geoFence);
                            str3 = string;
                            str2 = str4;
                        } else {
                            String str7 = string;
                            str2 = str4;
                            str3 = str7;
                        }
                        i3++;
                        string2 = str2;
                        string = str3;
                    }
                }
            }
            return i2;
        } catch (Throwable th2) {
            return 5;
        }
    }
}
