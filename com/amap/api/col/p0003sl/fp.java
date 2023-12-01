package com.amap.api.col.p0003sl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.fp  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp.class */
public final class fp extends Handler {
    private static fp a;

    /* renamed from: com.amap.api.col.3sl.fp$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$a.class */
    public static final class a {
        public BusLineResult a;
        public BusLineSearch.OnBusLineSearchListener b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$b.class */
    public static final class b {
        public BusStationResult a;
        public BusStationSearch.OnBusStationSearchListener b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$c.class */
    public static final class c {
        public CloudItemDetail a;
        public CloudSearch.OnCloudSearchListener b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$d */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$d.class */
    public static final class d {
        public CloudResult a;
        public CloudSearch.OnCloudSearchListener b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$e */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$e.class */
    public static final class e {
        public GeocodeResult a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$f */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$f.class */
    public static final class f {
        public List<NearbySearch.NearbyListener> a;
        public NearbySearchResult b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$g */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$g.class */
    public static final class g {
        public PoiItem a;
        public PoiSearch.OnPoiSearchListener b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$h */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$h.class */
    public static final class h {
        public PoiResult a;
        public PoiSearch.OnPoiSearchListener b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$i */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$i.class */
    public static final class i {
        public RegeocodeResult a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$j */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$j.class */
    public static final class j {
        public RoutePOISearchResult a;
        public RoutePOISearch.OnRoutePOISearchListener b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$k */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$k.class */
    public static final class k {
        public LocalWeatherForecastResult a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    /* renamed from: com.amap.api.col.3sl.fp$l */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fp$l.class */
    public static final class l {
        public LocalWeatherLiveResult a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    fp() {
    }

    private fp(Looper looper) {
        super(looper);
    }

    public static fp a() {
        fp fpVar;
        synchronized (fp.class) {
            try {
                if (a == null) {
                    if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
                        a = new fp();
                    }
                    a = new fp(Looper.getMainLooper());
                }
                fpVar = a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fpVar;
    }

    private static void a(Message message) {
        int i2 = message.arg2;
        ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
        String string = message.getData().getString("shareurlkey");
        if (onShareSearchListener == null) {
            return;
        }
        switch (message.what) {
            case AMapException.CODE_AMAP_ENGINE_RESPONSE_ERROR /* 1100 */:
                onShareSearchListener.onPoiShareUrlSearched(string, i2);
                return;
            case 1101:
                onShareSearchListener.onLocationShareUrlSearched(string, i2);
                return;
            case 1102:
                onShareSearchListener.onNaviShareUrlSearched(string, i2);
                return;
            case AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT /* 1103 */:
                onShareSearchListener.onBusRouteShareUrlSearched(string, i2);
                return;
            case 1104:
                onShareSearchListener.onDrivingRouteShareUrlSearched(string, i2);
                return;
            case 1105:
                onShareSearchListener.onWalkRouteShareUrlSearched(string, i2);
                return;
            default:
                return;
        }
    }

    private static void b(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onNearbyInfoUploaded(message.what);
        }
    }

    private static void c(Message message) {
        List<NearbySearch.NearbyListener> list;
        f fVar = (f) message.obj;
        if (fVar == null || (list = fVar.a) == null || list.size() == 0) {
            return;
        }
        NearbySearchResult nearbySearchResult = message.what == 1000 ? fVar.b : null;
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onNearbyInfoSearched(nearbySearchResult, message.what);
        }
    }

    private static void d(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list == null || list.size() == 0) {
            return;
        }
        for (NearbySearch.NearbyListener nearbyListener : list) {
            nearbyListener.onUserInfoCleared(message.what);
        }
    }

    private static void e(Message message) {
        BusStationSearch.OnBusStationSearchListener onBusStationSearchListener;
        b bVar = (b) message.obj;
        if (bVar == null || (onBusStationSearchListener = bVar.b) == null) {
            return;
        }
        BusStationResult busStationResult = null;
        if (message.what == 1000) {
            busStationResult = bVar.a;
        }
        onBusStationSearchListener.onBusStationSearched(busStationResult, message.what);
    }

    private static void f(Message message) {
        g gVar;
        PoiSearch.OnPoiSearchListener onPoiSearchListener;
        Bundle data;
        if (message.what == 600) {
            h hVar = (h) message.obj;
            if (hVar == null || (onPoiSearchListener = hVar.b) == null || (data = message.getData()) == null) {
                return;
            }
            onPoiSearchListener.onPoiSearched(hVar.a, data.getInt(MyLocationStyle.ERROR_CODE));
        } else if (message.what != 602 || (gVar = (g) message.obj) == null) {
        } else {
            PoiSearch.OnPoiSearchListener onPoiSearchListener2 = gVar.b;
            Bundle data2 = message.getData();
            if (data2 != null) {
                onPoiSearchListener2.onPoiItemSearched(gVar.a, data2.getInt(MyLocationStyle.ERROR_CODE));
            }
        }
    }

    private static void g(Message message) {
        Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
        if (inputtipsListener == null) {
            return;
        }
        ArrayList arrayList = null;
        if (message.what == 1000) {
            arrayList = message.getData().getParcelableArrayList(com.alipay.sdk.util.l.c);
        }
        inputtipsListener.onGetInputtips(arrayList, message.what);
    }

    private static void h(Message message) {
        e eVar;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener;
        GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2;
        if (message.what == 201) {
            i iVar = (i) message.obj;
            if (iVar == null || (onGeocodeSearchListener2 = iVar.b) == null) {
                return;
            }
            onGeocodeSearchListener2.onRegeocodeSearched(iVar.a, message.arg2);
        } else if (message.what != 200 || (eVar = (e) message.obj) == null || (onGeocodeSearchListener = eVar.b) == null) {
        } else {
            onGeocodeSearchListener.onGeocodeSearched(eVar.a, message.arg2);
        }
    }

    private static void i(Message message) {
        DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener == null) {
            return;
        }
        onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable(com.alipay.sdk.util.l.c));
    }

    private static void j(Message message) {
        BusLineSearch.OnBusLineSearchListener onBusLineSearchListener;
        a aVar = (a) message.obj;
        if (aVar == null || (onBusLineSearchListener = aVar.b) == null) {
            return;
        }
        BusLineResult busLineResult = null;
        if (message.what == 1000) {
            busLineResult = aVar.a;
        }
        onBusLineSearchListener.onBusLineSearched(busLineResult, message.what);
    }

    private static void k(Message message) {
        Bundle data;
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null) {
            return;
        }
        if (message.what == 100) {
            Bundle data2 = message.getData();
            if (data2 != null) {
                onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable(com.alipay.sdk.util.l.c), data2.getInt(MyLocationStyle.ERROR_CODE));
            }
        } else if (message.what == 101) {
            Bundle data3 = message.getData();
            if (data3 != null) {
                onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable(com.alipay.sdk.util.l.c), data3.getInt(MyLocationStyle.ERROR_CODE));
            }
        } else if (message.what == 102) {
            Bundle data4 = message.getData();
            if (data4 != null) {
                onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable(com.alipay.sdk.util.l.c), data4.getInt(MyLocationStyle.ERROR_CODE));
            }
        } else if (message.what == 103) {
            Bundle data5 = message.getData();
            if (data5 != null) {
                onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable(com.alipay.sdk.util.l.c), data5.getInt(MyLocationStyle.ERROR_CODE));
            }
        } else if (message.what != 104 || (data = message.getData()) == null) {
        } else {
            onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable(com.alipay.sdk.util.l.c), data.getInt(MyLocationStyle.ERROR_CODE));
        }
    }

    private static void l(Message message) {
        Bundle data;
        RouteSearchV2.OnRouteSearchListener onRouteSearchListener = (RouteSearchV2.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener == null || message.what != 101 || (data = message.getData()) == null) {
            return;
        }
        onRouteSearchListener.onDriveRouteSearched((DriveRouteResultV2) message.getData().getParcelable(com.alipay.sdk.util.l.c), data.getInt(MyLocationStyle.ERROR_CODE));
    }

    private static void m(Message message) {
        Bundle data;
        RouteSearch.OnTruckRouteSearchListener onTruckRouteSearchListener = (RouteSearch.OnTruckRouteSearchListener) message.obj;
        if (onTruckRouteSearchListener == null || message.what != 104 || (data = message.getData()) == null) {
            return;
        }
        onTruckRouteSearchListener.onTruckRouteSearched((TruckRouteRestult) message.getData().getParcelable(com.alipay.sdk.util.l.c), data.getInt(MyLocationStyle.ERROR_CODE));
    }

    private static void n(Message message) {
        Bundle data;
        RouteSearch.OnRoutePlanSearchListener onRoutePlanSearchListener = (RouteSearch.OnRoutePlanSearchListener) message.obj;
        if (onRoutePlanSearchListener == null || message.what != 105 || (data = message.getData()) == null) {
            return;
        }
        int i2 = data.getInt(MyLocationStyle.ERROR_CODE);
        DriveRoutePlanResult driveRoutePlanResult = (DriveRoutePlanResult) message.getData().getParcelable(com.alipay.sdk.util.l.c);
        if (onRoutePlanSearchListener != null) {
            onRoutePlanSearchListener.onDriveRoutePlanSearched(driveRoutePlanResult, i2);
        }
    }

    private static void o(Message message) {
        c cVar;
        if (message.what == 700) {
            d dVar = (d) message.obj;
            if (dVar == null) {
                return;
            }
            dVar.b.onCloudSearched(dVar.a, message.arg2);
        } else if (message.what != 701 || (cVar = (c) message.obj) == null) {
        } else {
            cVar.b.onCloudItemDetailSearched(cVar.a, message.arg2);
        }
    }

    private static void p(Message message) {
        k kVar;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener;
        Bundle data;
        WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2;
        Bundle data2;
        if (message.what == 1301) {
            l lVar = (l) message.obj;
            if (lVar == null || (onWeatherSearchListener2 = lVar.b) == null || (data2 = message.getData()) == null) {
                return;
            }
            onWeatherSearchListener2.onWeatherLiveSearched(lVar.a, data2.getInt(MyLocationStyle.ERROR_CODE));
        } else if (message.what != 1302 || (kVar = (k) message.obj) == null || (onWeatherSearchListener = kVar.b) == null || (data = message.getData()) == null) {
        } else {
            onWeatherSearchListener.onWeatherForecastSearched(kVar.a, data.getInt(MyLocationStyle.ERROR_CODE));
        }
    }

    private static void q(Message message) {
        RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener;
        Bundle data;
        j jVar = (j) message.obj;
        if (jVar == null || (onRoutePOISearchListener = jVar.b) == null || (data = message.getData()) == null) {
            return;
        }
        onRoutePOISearchListener.onRoutePoiSearched(jVar.a, data.getInt(MyLocationStyle.ERROR_CODE));
    }

    private static void r(Message message) {
        Bundle data;
        DistanceSearch.OnDistanceSearchListener onDistanceSearchListener = (DistanceSearch.OnDistanceSearchListener) message.obj;
        if (onDistanceSearchListener == null || message.what != 400 || (data = message.getData()) == null) {
            return;
        }
        onDistanceSearchListener.onDistanceSearched((DistanceResult) message.getData().getParcelable(com.alipay.sdk.util.l.c), data.getInt(MyLocationStyle.ERROR_CODE));
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            int i2 = message.arg1;
            if (i2 == 101) {
                l(message);
                return;
            }
            switch (i2) {
                case 1:
                    k(message);
                    return;
                case 2:
                    h(message);
                    return;
                case 3:
                    j(message);
                    return;
                case 4:
                    i(message);
                    return;
                case 5:
                    g(message);
                    return;
                case 6:
                    f(message);
                    return;
                case 7:
                    e(message);
                    return;
                case 8:
                    d(message);
                    return;
                case 9:
                    c(message);
                    return;
                case 10:
                    b(message);
                    return;
                case 11:
                    a(message);
                    return;
                case 12:
                    o(message);
                    return;
                case 13:
                    p(message);
                    return;
                case 14:
                    q(message);
                    return;
                default:
                    switch (i2) {
                        case 16:
                            r(message);
                            return;
                        case 17:
                            m(message);
                            return;
                        case 18:
                            n(message);
                            return;
                        default:
                            return;
                    }
            }
        } catch (Throwable th) {
            fe.a(th, "MessageHandler", "handleMessage");
        }
    }
}
