package com.blued.android.module.common.utils.gaode;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.R;
import com.blued.android.module.common.utils.CommonPreferences;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/gaode/GaoDeUtils.class */
public final class GaoDeUtils {
    private static AMapLocationClient f;
    private static OnLocationListener g;
    public static final GaoDeUtils a = new GaoDeUtils();
    private static int b = 20;
    private static int c = AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE;
    private static int d = 5000;
    private static String e = "GaoDeUtils";
    private static final AMapLocationListener h = new AMapLocationListener() { // from class: com.blued.android.module.common.utils.gaode.-$$Lambda$GaoDeUtils$TuFZE-i6xGP6HFL0qwhWGxlVRpU
        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            GaoDeUtils.a(aMapLocation);
        }
    };

    private GaoDeUtils() {
    }

    @JvmStatic
    public static final void a(final LifecycleOwner lifeCycleOwner, final int i, LatLonPoint lp, int i2, String keyword, final boolean z, final OnPOIListener listener) {
        Intrinsics.e(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.e(lp, "lp");
        Intrinsics.e(keyword, "keyword");
        Intrinsics.e(listener, "listener");
        try {
            if (BlueAppLocal.d()) {
                ServiceSettings.getInstance().setLanguage("zh-CN");
            } else {
                ServiceSettings.getInstance().setLanguage("en");
            }
            final PoiSearch.Query query = new PoiSearch.Query(keyword, "", "");
            query.setPageSize(b);
            query.setPageNum(i);
            PoiSearch poiSearch = new PoiSearch(AppUtils.a(), query);
            poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() { // from class: com.blued.android.module.common.utils.gaode.GaoDeUtils$getPoi$1
                @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
                public void onPoiItemSearched(PoiItem poiItem, int i3) {
                    Intrinsics.e(poiItem, "poiItem");
                    Log.d(GaoDeUtils.a.a(), "onPoiItemSearched");
                }

                @Override // com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener
                public void onPoiSearched(PoiResult poiResult, int i3) {
                    LatLonPoint latLonPoint;
                    Intrinsics.e(poiResult, "poiResult");
                    Log.d(GaoDeUtils.a.a(), Intrinsics.a("onPoiSearched:code=", (Object) Integer.valueOf(i3)));
                    if (i3 != 1000) {
                        if (lifeCycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                            listener.onComplete(i3, null, false);
                        }
                    } else if (poiResult.getQuery() == null || !poiResult.getQuery().equals(PoiSearch.Query.this)) {
                    } else {
                        if (poiResult.getPois().size() <= 0) {
                            AppMethods.d(R.string.common_net_error);
                            return;
                        }
                        ArrayList<PoiItem> pois = poiResult.getPois();
                        Intrinsics.c(pois, "poiResult.pois");
                        ArrayList<PoiItem> arrayList = pois;
                        ArrayList arrayList2 = new ArrayList(arrayList.size());
                        int size = arrayList.size();
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            if (i5 >= size) {
                                break;
                            }
                            PositionPOIModel positionPOIModel = new PositionPOIModel();
                            positionPOIModel.name = arrayList.get(i5).getTitle();
                            positionPOIModel.address = arrayList.get(i5).getSnippet();
                            positionPOIModel.province = arrayList.get(i5).getProvinceName();
                            positionPOIModel.city = arrayList.get(i5).getCityName();
                            positionPOIModel.area = arrayList.get(i5).getAdName();
                            positionPOIModel.distance = arrayList.get(i5).getDistance() + "";
                            if (arrayList.get(i5).getLatLonPoint() != null) {
                                positionPOIModel.longitude = latLonPoint.getLongitude() + "";
                                positionPOIModel.latitude = latLonPoint.getLatitude() + "";
                            }
                            arrayList2.add(positionPOIModel);
                            i4 = i5 + 1;
                        }
                        if (z && i == 0) {
                            PositionPOIModel positionPOIModel2 = new PositionPOIModel();
                            positionPOIModel2.name = CommonPreferences.x();
                            positionPOIModel2.address = CommonPreferences.z();
                            positionPOIModel2.province = CommonPreferences.y();
                            positionPOIModel2.longitude = CommonPreferences.u();
                            positionPOIModel2.latitude = CommonPreferences.v();
                            positionPOIModel2.city = CommonPreferences.x();
                            positionPOIModel2.area = CommonPreferences.z();
                            positionPOIModel2.distance = "0";
                            arrayList2.add(0, positionPOIModel2);
                        }
                        if (lifeCycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                            OnPOIListener onPOIListener = listener;
                            boolean z2 = true;
                            if (poiResult.getPageCount() <= i + 1) {
                                z2 = false;
                            }
                            onPOIListener.onComplete(0, arrayList2, z2);
                        }
                    }
                }
            });
            if (i2 > 0) {
                poiSearch.setBound(new PoiSearch.SearchBound(lp, i2, true));
            }
            poiSearch.searchPOIAsyn();
        } catch (Exception e2) {
            Log.d(e, Intrinsics.a("e=", (Object) e2.getMessage()));
            if (lifeCycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                listener.onComplete(-1, null, false);
            }
        }
    }

    @JvmStatic
    public static final void a(LifecycleOwner lifeCycleOwner, int i, LatLonPoint lp, OnPOIListener listener) {
        Intrinsics.e(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.e(lp, "lp");
        Intrinsics.e(listener, "listener");
        a(lifeCycleOwner, i, lp, c, "", false, listener);
    }

    @JvmStatic
    public static final void a(LifecycleOwner lifeCycleOwner, int i, OnPOIListener listener) {
        Intrinsics.e(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.e(listener, "listener");
        LatLonPoint w = CommonPreferences.w();
        Intrinsics.c(w, "getGPS()");
        a(lifeCycleOwner, i, w, c, "", true, listener);
    }

    @JvmStatic
    public static final void a(LifecycleOwner lifeCycleOwner, int i, String keyword, OnPOIListener listener) {
        Intrinsics.e(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.e(keyword, "keyword");
        Intrinsics.e(listener, "listener");
        LatLonPoint w = CommonPreferences.w();
        Intrinsics.c(w, "getGPS()");
        a(lifeCycleOwner, i, w, 0, keyword, false, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
        if ((r6.getLatitude() == 0.0d) == false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(com.amap.api.location.AMapLocation r6) {
        /*
            Method dump skipped, instructions count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.gaode.GaoDeUtils.a(com.amap.api.location.AMapLocation):void");
    }

    @JvmStatic
    public static final void a(OnLocationListener onLocationListener) {
        Intrinsics.e(onLocationListener, "onLocationListener");
        a.b();
        g = onLocationListener;
        AMapLocationClient aMapLocationClient = f;
        if (aMapLocationClient == null) {
            return;
        }
        aMapLocationClient.startLocation();
    }

    private final void b() {
        if (f == null) {
            f = new AMapLocationClient(AppInfo.d());
            AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
            aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            aMapLocationClientOption.setOnceLocation(true);
            aMapLocationClientOption.setOnceLocationLatest(true);
            aMapLocationClientOption.setHttpTimeOut(10000L);
            AMapLocationClient aMapLocationClient = f;
            if (aMapLocationClient != null) {
                aMapLocationClient.setLocationOption(aMapLocationClientOption);
            }
            AMapLocationClient aMapLocationClient2 = f;
            if (aMapLocationClient2 == null) {
                return;
            }
            aMapLocationClient2.setLocationListener(h);
        }
    }

    @JvmStatic
    public static final void b(LifecycleOwner lifeCycleOwner, int i, String keyword, OnPOIListener listener) {
        Intrinsics.e(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.e(keyword, "keyword");
        Intrinsics.e(listener, "listener");
        LatLonPoint w = CommonPreferences.w();
        Intrinsics.c(w, "getGPS()");
        a(lifeCycleOwner, i, w, d, keyword, false, listener);
    }

    @JvmStatic
    public static final void c(LifecycleOwner lifeCycleOwner, int i, String keyword, OnPOIListener listener) {
        Intrinsics.e(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.e(keyword, "keyword");
        Intrinsics.e(listener, "listener");
        a(lifeCycleOwner, i, Intrinsics.a(CommonPreferences.x(), (Object) keyword), listener);
    }

    @JvmStatic
    public static final void d(LifecycleOwner lifeCycleOwner, int i, String keyword, OnPOIListener listener) {
        Intrinsics.e(lifeCycleOwner, "lifeCycleOwner");
        Intrinsics.e(keyword, "keyword");
        Intrinsics.e(listener, "listener");
        a(lifeCycleOwner, i, keyword, listener);
    }

    public final String a() {
        return e;
    }
}
