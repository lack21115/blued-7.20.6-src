package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.alipay.sdk.widget.j;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.ChargeStationInfo;
import com.amap.api.services.route.Cost;
import com.amap.api.services.route.DistanceItem;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DrivePathV2;
import com.amap.api.services.route.DrivePlanPath;
import com.amap.api.services.route.DrivePlanStep;
import com.amap.api.services.route.DriveRoutePlanResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveRouteResultV2;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.DriveStepV2;
import com.amap.api.services.route.ElecConsumeInfo;
import com.amap.api.services.route.Navi;
import com.amap.api.services.route.Path;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.TimeInfo;
import com.amap.api.services.route.TimeInfosElement;
import com.amap.api.services.route.TruckPath;
import com.amap.api.services.route.TruckRouteRestult;
import com.amap.api.services.route.TruckStep;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import com.android.internal.util.cm.QSConstants;
import com.anythink.core.common.b.e;
import com.anythink.core.common.b.g;
import com.anythink.core.common.c.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3sl.fm  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/fm.class */
public final class fm {
    private static String[] a = {"010", "021", "022", "023", "1852", "1853"};

    private static List<RailwayStationItem> A(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("via_stops")) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return arrayList;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    arrayList.add(z(optJSONObject));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private static List<Railway> B(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("alters")) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return arrayList;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    Railway railway = new Railway();
                    railway.setID(a(optJSONObject, "id"));
                    railway.setName(a(optJSONObject, "name"));
                    arrayList.add(railway);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private static List<RailwaySpace> C(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("spaces")) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return arrayList;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    arrayList.add(D(optJSONObject));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private static RailwaySpace D(JSONObject jSONObject) throws JSONException {
        return new RailwaySpace(a(jSONObject, g.c.b), q(a(jSONObject, "cost")));
    }

    private static TaxiItem E(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItem taxiItem = new TaxiItem();
        taxiItem.setOrigin(c(jSONObject, "origin"));
        taxiItem.setDestination(c(jSONObject, "destination"));
        taxiItem.setDistance(q(a(jSONObject, "distance")));
        taxiItem.setDuration(q(a(jSONObject, "duration")));
        taxiItem.setSname(a(jSONObject, "sname"));
        taxiItem.setTname(a(jSONObject, "tname"));
        return taxiItem;
    }

    private static ElecConsumeInfo F(JSONObject jSONObject) throws AMapException {
        try {
            ElecConsumeInfo elecConsumeInfo = new ElecConsumeInfo();
            elecConsumeInfo.setRunOutPoint(c(jSONObject, "runout_point"));
            elecConsumeInfo.setRunOutStepIndex(b(jSONObject, "runout_step_index"));
            elecConsumeInfo.setConsumeEnergy(b(jSONObject, "consume_energy"));
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("left_energy");
            if (optJSONArray != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    arrayList.add(Integer.valueOf(optJSONArray.optInt(i2)));
                    i = i2 + 1;
                }
            }
            elecConsumeInfo.setLeftEnergy(arrayList);
            return elecConsumeInfo;
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseElecConsumeInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static Navi G(JSONObject jSONObject) throws AMapException {
        try {
            Navi navi = new Navi();
            navi.setAction(a(jSONObject, "action"));
            navi.setAssistantAction(a(jSONObject, "assistant_action"));
            return navi;
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseNavi");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static List<Photo> H(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && jSONObject.has("photos")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("photos");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return arrayList;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                Photo photo = new Photo();
                photo.setTitle(a(optJSONObject, "title"));
                photo.setUrl(a(optJSONObject, "url"));
                arrayList.add(photo);
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private static RoutePOIItem I(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(a(jSONObject, "id"));
        routePOIItem.setTitle(a(jSONObject, "name"));
        routePOIItem.setPoint(c(jSONObject, QSConstants.TILE_LOCATION));
        routePOIItem.setDistance(q(a(jSONObject, "distance")));
        routePOIItem.setDuration(q(a(jSONObject, "duration")));
        return routePOIItem;
    }

    private static RidePath J(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(q(a(jSONObject, "distance")));
            ridePath.setDuration(s(a(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(a(optJSONObject, "instruction"));
                        rideStep.setOrientation(a(optJSONObject, "orientation"));
                        rideStep.setRoad(a(optJSONObject, "road"));
                        rideStep.setDistance(q(a(optJSONObject, "distance")));
                        rideStep.setDuration(q(a(optJSONObject, "duration")));
                        rideStep.setPolyline(d(optJSONObject, "polyline"));
                        rideStep.setAction(a(optJSONObject, "action"));
                        rideStep.setAssistantAction(a(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                    i = i2 + 1;
                }
                ridePath.setSteps(arrayList);
                d(ridePath, arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseRidePath");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static BusRouteResult a(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                BusRouteResult busRouteResult = new BusRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                if (optJSONObject == null) {
                    return busRouteResult;
                }
                busRouteResult.setStartPos(c(optJSONObject, "origin"));
                busRouteResult.setTargetPos(c(optJSONObject, "destination"));
                busRouteResult.setTaxiCost(q(a(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("transits") && (optJSONArray = optJSONObject.optJSONArray("transits")) != null) {
                    busRouteResult.setPaths(a(optJSONArray));
                    return busRouteResult;
                }
                return busRouteResult;
            }
            return null;
        } catch (JSONException e) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null) {
            return "";
        }
        String str2 = "";
        if (jSONObject.has(str)) {
            str2 = "";
            if (!jSONObject.optString(str).equals("[]")) {
                str2 = jSONObject.optString(str).trim();
            }
        }
        return str2;
    }

    public static ArrayList<SuggestionCity> a(JSONObject jSONObject) throws JSONException, NumberFormatException {
        JSONArray optJSONArray;
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (jSONObject.has("cities") && (optJSONArray = jSONObject.optJSONArray("cities")) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return arrayList;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    arrayList.add(new SuggestionCity(a(optJSONObject, "name"), a(optJSONObject, "citycode"), a(optJSONObject, "adcode"), p(a(optJSONObject, "num"))));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> a(org.json.JSONObject r7, boolean r8) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.fm.a(org.json.JSONObject, boolean):java.util.ArrayList");
    }

    private static List<BusPath> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return arrayList;
            }
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                busPath.setCost(q(a(optJSONObject, "cost")));
                busPath.setDuration(s(a(optJSONObject, "duration")));
                busPath.setNightBus(t(a(optJSONObject, "nightflag")));
                busPath.setWalkDistance(q(a(optJSONObject, "walking_distance")));
                busPath.setDistance(q(a(optJSONObject, "distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f = 0.0f;
                    float f2 = 0.0f;
                    int i3 = 0;
                    while (i3 < optJSONArray.length()) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                        float f3 = f;
                        float f4 = f2;
                        if (optJSONObject2 != null) {
                            BusStep q = q(optJSONObject2);
                            f3 = f;
                            f4 = f2;
                            if (q != null) {
                                arrayList2.add(q);
                                float f5 = f2;
                                if (q.getWalk() != null) {
                                    f5 = f2 + q.getWalk().getDistance();
                                }
                                f3 = f;
                                f4 = f5;
                                if (q.getBusLines() != null) {
                                    f3 = f;
                                    f4 = f5;
                                    if (q.getBusLines().size() > 0) {
                                        f3 = f + q.getBusLines().get(0).getDistance();
                                        f4 = f5;
                                    }
                                }
                            }
                        }
                        i3++;
                        f = f3;
                        f2 = f4;
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f);
                    busPath.setWalkDistance(f2);
                    arrayList.add(busPath);
                }
            }
            i = i2 + 1;
        }
    }

    private static void a(PoiItem poiItem, JSONObject jSONObject) throws JSONException {
        List<Photo> H = H(jSONObject.optJSONObject("deep_info"));
        List<Photo> list = H;
        if (H.size() == 0) {
            list = H(jSONObject);
        }
        poiItem.setPhotos(list);
    }

    private static void a(RegeocodeAddress regeocodeAddress) {
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() <= 0) && l(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    private static void a(Cost cost, JSONObject jSONObject) throws AMapException {
        try {
            cost.setTolls(q(a(jSONObject, "tolls")));
            cost.setTollDistance(q(a(jSONObject, "toll_distance")));
            cost.setTollRoad(a(jSONObject, "toll_road"));
            cost.setDuration(q(a(jSONObject, "duration")));
            cost.setTrafficLights(p(a(jSONObject, "traffic_lights")));
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseCostDetail");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    driveStep.setTMCs(arrayList);
                    return;
                }
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    tmc.setDistance(p(a(optJSONObject, "distance")));
                    tmc.setStatus(a(optJSONObject, "status"));
                    tmc.setPolyline(d(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
                i = i2 + 1;
            }
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(Path path, List<WalkStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        ArrayList arrayList = polyline;
        if (polyline == null) {
            arrayList = new ArrayList();
        }
        for (WalkStep walkStep : list) {
            if (walkStep != null && walkStep.getPolyline() != null) {
                arrayList.addAll(walkStep.getPolyline());
            }
        }
        path.setPolyline(arrayList);
    }

    private static void a(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (!jSONObject.has("districts")) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("districts");
            if (optJSONArray == null) {
                routeSearchCity.setDistricts(arrayList);
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                District district = new District();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    district.setDistrictName(a(optJSONObject, "name"));
                    district.setDistrictAdcode(a(optJSONObject, "adcode"));
                    arrayList.add(district);
                }
                i = i2 + 1;
            }
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseCrossDistricts");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void a(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    truckStep.setRouteSearchCityList(arrayList);
                    return;
                }
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                    a(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
                i = i2 + 1;
            }
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                regeocodeAddress.setCrossroads(arrayList);
                return;
            }
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                crossroad.setId(a(optJSONObject, "id"));
                crossroad.setDirection(a(optJSONObject, "direction"));
                crossroad.setDistance(q(a(optJSONObject, "distance")));
                crossroad.setCenterPoint(c(optJSONObject, QSConstants.TILE_LOCATION));
                crossroad.setFirstRoadId(a(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(a(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(a(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(a(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
            i = i2 + 1;
        }
    }

    public static void a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        if (jSONArray == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                break;
            }
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                arrayList.add(o(optJSONObject));
            }
            i = i2 + 1;
        }
        if (districtItem != null) {
            districtItem.setSubDistrict(arrayList);
        }
    }

    public static void a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setCountry(a(jSONObject, DistrictSearchQuery.KEYWORDS_COUNTRY));
        regeocodeAddress.setCountryCode(a(jSONObject, "countrycode"));
        regeocodeAddress.setProvince(a(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(a(jSONObject, DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(a(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(a(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(a(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(a(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(a(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(a(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(a(optJSONObject, "street"));
        streetNumber.setNumber(a(optJSONObject, "number"));
        streetNumber.setLatLonPoint(c(optJSONObject, QSConstants.TILE_LOCATION));
        streetNumber.setDirection(a(optJSONObject, "direction"));
        streetNumber.setDistance(q(a(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(p(jSONObject));
        regeocodeAddress.setTowncode(a(jSONObject, "towncode"));
        a(regeocodeAddress);
    }

    private static int b(JSONObject jSONObject, String str) throws JSONException {
        int i = -1;
        if (jSONObject == null) {
            return -1;
        }
        if (jSONObject.has(str)) {
            i = jSONObject.optInt(str);
        }
        return i;
    }

    public static DriveRouteResult b(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                DriveRouteResult driveRouteResult = new DriveRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                if (optJSONObject == null) {
                    return driveRouteResult;
                }
                driveRouteResult.setStartPos(c(optJSONObject, "origin"));
                driveRouteResult.setTargetPos(c(optJSONObject, "destination"));
                driveRouteResult.setTaxiCost(q(a(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= optJSONArray.length()) {
                            driveRouteResult.setPaths(arrayList);
                            return driveRouteResult;
                        }
                        DrivePath drivePath = new DrivePath();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            drivePath.setDistance(q(a(optJSONObject2, "distance")));
                            drivePath.setDuration(s(a(optJSONObject2, "duration")));
                            drivePath.setStrategy(a(optJSONObject2, "strategy"));
                            drivePath.setTolls(q(a(optJSONObject2, "tolls")));
                            drivePath.setTollDistance(q(a(optJSONObject2, "toll_distance")));
                            drivePath.setTotalTrafficlights(p(a(optJSONObject2, "traffic_lights")));
                            drivePath.setRestriction(p(a(optJSONObject2, "restriction")));
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray2 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= optJSONArray2.length()) {
                                        break;
                                    }
                                    DriveStep driveStep = new DriveStep();
                                    JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                                    if (optJSONObject3 != null) {
                                        driveStep.setInstruction(a(optJSONObject3, "instruction"));
                                        driveStep.setOrientation(a(optJSONObject3, "orientation"));
                                        driveStep.setRoad(a(optJSONObject3, "road"));
                                        driveStep.setDistance(q(a(optJSONObject3, "distance")));
                                        driveStep.setTolls(q(a(optJSONObject3, "tolls")));
                                        driveStep.setTollDistance(q(a(optJSONObject3, "toll_distance")));
                                        driveStep.setTollRoad(a(optJSONObject3, "toll_road"));
                                        driveStep.setDuration(q(a(optJSONObject3, "duration")));
                                        driveStep.setPolyline(d(optJSONObject3, "polyline"));
                                        driveStep.setAction(a(optJSONObject3, "action"));
                                        driveStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                        b(driveStep, optJSONObject3);
                                        a(driveStep, optJSONObject3);
                                        arrayList2.add(driveStep);
                                    }
                                    i3 = i4 + 1;
                                }
                                drivePath.setSteps(arrayList2);
                                b(drivePath, arrayList2);
                                arrayList.add(drivePath);
                            }
                        }
                        i = i2 + 1;
                    }
                }
                return driveRouteResult;
            }
            return null;
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            fe.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<String> b(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return arrayList;
            }
            arrayList.add(optJSONArray.optString(i2));
            i = i2 + 1;
        }
    }

    private static List<ChargeStationInfo> b(JSONArray jSONArray) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return arrayList;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                ChargeStationInfo chargeStationInfo = new ChargeStationInfo();
                chargeStationInfo.setName(a(jSONObject, "name"));
                chargeStationInfo.setPoiId(a(jSONObject, "poiid"));
                chargeStationInfo.setBrandName(a(jSONObject, "brand_name"));
                chargeStationInfo.setShowPoint(c(jSONObject, "show_point"));
                chargeStationInfo.setProjectivePoint(c(jSONObject, "projective_point"));
                chargeStationInfo.setMaxPower(b(jSONObject, "max_power"));
                chargeStationInfo.setChargePercent(b(jSONObject, "charge_percent"));
                chargeStationInfo.setChargeTime(b(jSONObject, "charge_time"));
                chargeStationInfo.setRemainingCapacity(b(jSONObject, "remaining_capacity"));
                chargeStationInfo.setVoltage(b(jSONObject, "voltage"));
                chargeStationInfo.setAmperage(b(jSONObject, "amperage"));
                chargeStationInfo.setStepIndex(b(jSONObject, "step_index"));
                arrayList.add(chargeStationInfo);
                i = i2 + 1;
            }
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseChargeStationInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    driveStep.setRouteSearchCityList(arrayList);
                    return;
                }
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                    a(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
                i = i2 + 1;
            }
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(Path path, List<DriveStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        ArrayList arrayList = polyline;
        if (polyline == null) {
            arrayList = new ArrayList();
        }
        for (DriveStep driveStep : list) {
            if (driveStep != null && driveStep.getPolyline() != null) {
                arrayList.addAll(driveStep.getPolyline());
            }
        }
        path.setPolyline(arrayList);
    }

    private static void b(TruckStep truckStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    truckStep.setTMCs(arrayList);
                    return;
                }
                TMC tmc = new TMC();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    tmc.setDistance(p(a(optJSONObject, "distance")));
                    tmc.setStatus(a(optJSONObject, "status"));
                    tmc.setPolyline(d(optJSONObject, "polyline"));
                    arrayList.add(tmc);
                }
                i = i2 + 1;
            }
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                regeocodeAddress.setRoads(arrayList);
                return;
            }
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                regeocodeRoad.setId(a(optJSONObject, "id"));
                regeocodeRoad.setName(a(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(c(optJSONObject, QSConstants.TILE_LOCATION));
                regeocodeRoad.setDirection(a(optJSONObject, "direction"));
                regeocodeRoad.setDistance(q(a(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
            i = i2 + 1;
        }
    }

    private static LatLonPoint c(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return n(jSONObject.optString(str));
        }
        return null;
    }

    public static DriveRouteResultV2 c(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("route")) {
                DriveRouteResultV2 driveRouteResultV2 = new DriveRouteResultV2();
                JSONObject optJSONObject = jSONObject.optJSONObject("route");
                if (optJSONObject == null) {
                    return driveRouteResultV2;
                }
                driveRouteResultV2.setStartPos(c(optJSONObject, "origin"));
                driveRouteResultV2.setTargetPos(c(optJSONObject, "destination"));
                driveRouteResultV2.setTaxiCost(q(a(optJSONObject, "taxi_cost")));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= optJSONArray.length()) {
                            driveRouteResultV2.setPaths(arrayList);
                            return driveRouteResultV2;
                        }
                        DrivePathV2 drivePathV2 = new DrivePathV2();
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            drivePathV2.setDistance(q(a(optJSONObject2, "distance")));
                            drivePathV2.setStrategy(a(optJSONObject2, "strategy"));
                            drivePathV2.setRestriction(p(a(optJSONObject2, "restriction")));
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("cost");
                            if (optJSONObject3 != null) {
                                Cost cost = new Cost();
                                a(cost, optJSONObject3);
                                drivePathV2.setCost(cost);
                            }
                            JSONObject optJSONObject4 = optJSONObject2.optJSONObject("elec_consume_info");
                            if (optJSONObject4 != null) {
                                drivePathV2.setElecConsumeInfo(F(optJSONObject4));
                            }
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("charge_station_info");
                            if (optJSONArray2 != null) {
                                drivePathV2.setChargeStationInfo(b(optJSONArray2));
                            }
                            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray3 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= optJSONArray3.length()) {
                                        break;
                                    }
                                    DriveStepV2 driveStepV2 = new DriveStepV2();
                                    JSONObject optJSONObject5 = optJSONArray3.optJSONObject(i4);
                                    if (optJSONObject5 != null) {
                                        driveStepV2.setInstruction(a(optJSONObject5, "instruction"));
                                        driveStepV2.setOrientation(a(optJSONObject5, "orientation"));
                                        driveStepV2.setStepDistance(p(a(optJSONObject5, "step_distance")));
                                        driveStepV2.setRoad(a(optJSONObject5, "road_name"));
                                        driveStepV2.setPolyline(d(optJSONObject5, "polyline"));
                                        JSONObject optJSONObject6 = optJSONObject5.optJSONObject("cost");
                                        if (optJSONObject6 != null) {
                                            Cost cost2 = new Cost();
                                            a(cost2, optJSONObject6);
                                            driveStepV2.setCostDetail(cost2);
                                        }
                                        JSONObject optJSONObject7 = optJSONObject5.optJSONObject("navi");
                                        if (optJSONObject7 != null) {
                                            driveStepV2.setNavi(G(optJSONObject7));
                                        }
                                        JSONArray optJSONArray4 = optJSONObject5.optJSONArray("cities");
                                        if (optJSONArray4 != null) {
                                            driveStepV2.setRouteSearchCityList(d(optJSONArray4));
                                        }
                                        JSONArray optJSONArray5 = optJSONObject5.optJSONArray("tmcs");
                                        if (optJSONArray5 != null) {
                                            driveStepV2.setTMCs(c(optJSONArray5));
                                        }
                                        arrayList2.add(driveStepV2);
                                    }
                                    i3 = i4 + 1;
                                }
                                drivePathV2.setSteps(arrayList2);
                                c(drivePathV2, arrayList2);
                                arrayList.add(drivePathV2);
                            }
                        }
                        i = i2 + 1;
                    }
                }
                return driveRouteResultV2;
            }
            return null;
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            fe.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<PoiItem> c(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray != null) {
            if (optJSONArray.length() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        arrayList.add(d(optJSONObject));
                    }
                    i = i2 + 1;
                }
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    private static List<TMC> c(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return arrayList;
                }
                TMC tmc = new TMC();
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    tmc.setDistance(p(a(optJSONObject, "tmc_distance")));
                    tmc.setStatus(a(optJSONObject, "tmc_status"));
                    tmc.setPolyline(d(optJSONObject, "tmc_polyline"));
                    arrayList.add(tmc);
                }
                i = i2 + 1;
            } catch (JSONException e) {
                fe.a(e, "JSONHelper", "parseTMCsV5");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    private static void c(Path path, List<DriveStepV2> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        ArrayList arrayList = polyline;
        if (polyline == null) {
            arrayList = new ArrayList();
        }
        for (DriveStepV2 driveStepV2 : list) {
            if (driveStepV2 != null && driveStepV2.getPolyline() != null) {
                arrayList.addAll(driveStepV2.getPolyline());
            }
        }
        path.setPolyline(arrayList);
    }

    public static void c(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                regeocodeAddress.setAois(arrayList);
                return;
            }
            AoiItem aoiItem = new AoiItem();
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                aoiItem.setId(a(optJSONObject, "id"));
                aoiItem.setName(a(optJSONObject, "name"));
                aoiItem.setAdcode(a(optJSONObject, "adcode"));
                aoiItem.setLocation(c(optJSONObject, QSConstants.TILE_LOCATION));
                aoiItem.setArea(Float.valueOf(q(a(optJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
            i = i2 + 1;
        }
    }

    public static PoiItem d(JSONObject jSONObject) throws JSONException {
        PoiItem poiItem = new PoiItem(a(jSONObject, "id"), c(jSONObject, QSConstants.TILE_LOCATION), a(jSONObject, "name"), a(jSONObject, "address"));
        poiItem.setAdCode(a(jSONObject, "adcode"));
        poiItem.setProvinceName(a(jSONObject, "pname"));
        poiItem.setCityName(a(jSONObject, "cityname"));
        poiItem.setAdName(a(jSONObject, "adname"));
        poiItem.setCityCode(a(jSONObject, "citycode"));
        poiItem.setProvinceCode(a(jSONObject, "pcode"));
        poiItem.setDirection(a(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!g(a2)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    fe.a(e, "JSONHelper", "parseBasePoi");
                } catch (Exception e2) {
                    fe.a(e2, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(a(jSONObject, "tel"));
        poiItem.setTypeDes(a(jSONObject, "type"));
        poiItem.setEnter(c(jSONObject, "entr_location"));
        poiItem.setExit(c(jSONObject, "exit_location"));
        poiItem.setWebsite(a(jSONObject, "website"));
        poiItem.setPostcode(a(jSONObject, "postcode"));
        String a3 = a(jSONObject, "business_area");
        String str = a3;
        if (g(a3)) {
            str = a(jSONObject, "businessarea");
        }
        poiItem.setBusinessArea(str);
        poiItem.setEmail(a(jSONObject, "email"));
        if (o(a(jSONObject, "indoor_map"))) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(a(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(j(optJSONObject));
                    }
                }
            }
            poiItem.setSubPois(arrayList);
        }
        poiItem.setIndoorDate(e(jSONObject, "indoor_data"));
        poiItem.setPoiExtension(f(jSONObject, "biz_ext"));
        poiItem.setTypeCode(a(jSONObject, "typecode"));
        poiItem.setShopID(a(jSONObject, "shopid"));
        a(poiItem, jSONObject);
        return poiItem;
    }

    public static WalkRouteResult d(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            walkRouteResult.setStartPos(c(optJSONObject, "origin"));
            walkRouteResult.setTargetPos(c(optJSONObject, "destination"));
            if (!optJSONObject.has("paths")) {
                return walkRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    walkRouteResult.setPaths(arrayList);
                    return walkRouteResult;
                }
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(q(a(optJSONObject2, "distance")));
                    walkPath.setDuration(s(a(optJSONObject2, "duration")));
                    if (optJSONObject2.has("steps")) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= optJSONArray2.length()) {
                                    break;
                                }
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i4);
                                if (optJSONObject3 != null) {
                                    walkStep.setInstruction(a(optJSONObject3, "instruction"));
                                    walkStep.setOrientation(a(optJSONObject3, "orientation"));
                                    walkStep.setRoad(a(optJSONObject3, "road"));
                                    walkStep.setDistance(q(a(optJSONObject3, "distance")));
                                    walkStep.setDuration(q(a(optJSONObject3, "duration")));
                                    walkStep.setPolyline(d(optJSONObject3, "polyline"));
                                    walkStep.setAction(a(optJSONObject3, "action"));
                                    walkStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                                i3 = i4 + 1;
                            }
                            walkPath.setSteps(arrayList2);
                            a(walkPath, arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
                i = i2 + 1;
            }
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static ArrayList<LatLonPoint> d(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return m(jSONObject.optString(str));
        }
        return null;
    }

    private static List<RouteSearchCity> d(JSONArray jSONArray) throws AMapException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            try {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return arrayList;
                }
                RouteSearchCity routeSearchCity = new RouteSearchCity();
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                    routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                    routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                    a(routeSearchCity, optJSONObject);
                    arrayList.add(routeSearchCity);
                }
                i = i2 + 1;
            } catch (JSONException e) {
                fe.a(e, "JSONHelper", "parseCrossCity");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    private static void d(Path path, List<RideStep> list) {
        List<LatLonPoint> polyline = path.getPolyline();
        ArrayList arrayList = polyline;
        if (polyline == null) {
            arrayList = new ArrayList();
        }
        for (RideStep rideStep : list) {
            if (rideStep != null && rideStep.getPolyline() != null) {
                arrayList.addAll(rideStep.getPolyline());
            }
        }
        path.setPolyline(arrayList);
    }

    private static IndoorData e(JSONObject jSONObject, String str) throws JSONException {
        int i;
        String str2;
        String str3;
        JSONObject optJSONObject;
        if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null && optJSONObject.has("cpid") && optJSONObject.has("floor")) {
            str3 = a(optJSONObject, "cpid");
            i = p(a(optJSONObject, "floor"));
            str2 = a(optJSONObject, "truefloor");
        } else {
            i = 0;
            str2 = "";
            str3 = "";
        }
        return new IndoorData(str3, i, str2);
    }

    public static LocalWeatherLive e(String str) throws AMapException {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("lives")) {
                LocalWeatherLive localWeatherLive = new LocalWeatherLive();
                JSONArray optJSONArray = jSONObject.optJSONArray("lives");
                if (optJSONArray != null) {
                    if (optJSONArray.length() > 0 && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
                        localWeatherLive.setAdCode(a(optJSONObject, "adcode"));
                        localWeatherLive.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                        localWeatherLive.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                        localWeatherLive.setWeather(a(optJSONObject, "weather"));
                        localWeatherLive.setTemperature(a(optJSONObject, "temperature"));
                        localWeatherLive.setWindDirection(a(optJSONObject, "winddirection"));
                        localWeatherLive.setWindPower(a(optJSONObject, "windpower"));
                        localWeatherLive.setHumidity(a(optJSONObject, "humidity"));
                        localWeatherLive.setReportTime(a(optJSONObject, "reporttime"));
                    }
                    return localWeatherLive;
                }
                return localWeatherLive;
            }
            return null;
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<BusStationItem> e(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray != null) {
            if (optJSONArray.length() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        arrayList.add(k(optJSONObject));
                    }
                    i = i2 + 1;
                }
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    private static PoiItemExtension f(JSONObject jSONObject, String str) throws JSONException {
        String str2;
        String str3;
        JSONObject optJSONObject;
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            str2 = "";
            str3 = "";
        } else {
            str3 = a(optJSONObject, "open_time");
            str2 = a(optJSONObject, "rating");
        }
        return new PoiItemExtension(str3, str2);
    }

    public static LocalWeatherForecast f(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("forecasts")) {
                LocalWeatherForecast localWeatherForecast = new LocalWeatherForecast();
                JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
                if (jSONArray != null) {
                    if (jSONArray.length() <= 0) {
                        return localWeatherForecast;
                    }
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return localWeatherForecast;
                    }
                    localWeatherForecast.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    localWeatherForecast.setAdCode(a(optJSONObject, "adcode"));
                    localWeatherForecast.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    localWeatherForecast.setReportTime(a(optJSONObject, "reporttime"));
                    if (!optJSONObject.has("casts")) {
                        return localWeatherForecast;
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                            if (optJSONObject2 != null) {
                                localDayWeatherForecast.setDate(a(optJSONObject2, "date"));
                                localDayWeatherForecast.setWeek(a(optJSONObject2, "week"));
                                localDayWeatherForecast.setDayWeather(a(optJSONObject2, "dayweather"));
                                localDayWeatherForecast.setNightWeather(a(optJSONObject2, "nightweather"));
                                localDayWeatherForecast.setDayTemp(a(optJSONObject2, "daytemp"));
                                localDayWeatherForecast.setNightTemp(a(optJSONObject2, "nighttemp"));
                                localDayWeatherForecast.setDayWindDirection(a(optJSONObject2, "daywind"));
                                localDayWeatherForecast.setNightWindDirection(a(optJSONObject2, "nightwind"));
                                localDayWeatherForecast.setDayWindPower(a(optJSONObject2, "daypower"));
                                localDayWeatherForecast.setNightWindPower(a(optJSONObject2, "nightpower"));
                                arrayList.add(localDayWeatherForecast);
                            }
                        }
                        localWeatherForecast.setWeatherForecast(arrayList);
                        return localWeatherForecast;
                    }
                    localWeatherForecast.setWeatherForecast(arrayList);
                }
                return localWeatherForecast;
            }
            return null;
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<BusLineItem> f(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return arrayList;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                arrayList.add(n(optJSONObject));
            }
            i = i2 + 1;
        }
    }

    public static ArrayList<GeocodeAddress> g(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray != null) {
            if (optJSONArray.length() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        GeocodeAddress geocodeAddress = new GeocodeAddress();
                        geocodeAddress.setFormatAddress(a(optJSONObject, "formatted_address"));
                        geocodeAddress.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                        geocodeAddress.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                        geocodeAddress.setDistrict(a(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                        geocodeAddress.setTownship(a(optJSONObject, "township"));
                        geocodeAddress.setNeighborhood(a(optJSONObject.optJSONObject("neighborhood"), "name"));
                        geocodeAddress.setBuilding(a(optJSONObject.optJSONObject("building"), "name"));
                        geocodeAddress.setAdcode(a(optJSONObject, "adcode"));
                        geocodeAddress.setLatLonPoint(c(optJSONObject, QSConstants.TILE_LOCATION));
                        geocodeAddress.setLevel(a(optJSONObject, "level"));
                        geocodeAddress.setCountry(a(optJSONObject, DistrictSearchQuery.KEYWORDS_COUNTRY));
                        geocodeAddress.setPostcode(a(optJSONObject, "postcode"));
                        arrayList.add(geocodeAddress);
                    }
                    i = i2 + 1;
                }
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    public static boolean g(String str) {
        return str == null || str.equals("");
    }

    public static RideRouteResult h(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data")) {
                RideRouteResult rideRouteResult = new RideRouteResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                rideRouteResult.setStartPos(c(optJSONObject, "origin"));
                rideRouteResult.setTargetPos(c(optJSONObject, "destination"));
                ArrayList arrayList = new ArrayList();
                Object opt = optJSONObject.opt("paths");
                if (opt == null) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                if (opt instanceof JSONArray) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= optJSONArray.length()) {
                            break;
                        }
                        RidePath J = J(optJSONArray.optJSONObject(i2));
                        if (J != null) {
                            arrayList.add(J);
                        }
                        i = i2 + 1;
                    }
                } else if (opt instanceof JSONObject) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                    if (!optJSONObject2.has("path")) {
                        rideRouteResult.setPaths(arrayList);
                        return rideRouteResult;
                    }
                    RidePath J2 = J(optJSONObject2.optJSONObject("path"));
                    if (J2 != null) {
                        arrayList.add(J2);
                    }
                }
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            return null;
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<Tip> h(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                return arrayList;
            }
            Tip tip = new Tip();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                tip.setName(a(optJSONObject, "name"));
                tip.setDistrict(a(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                tip.setAdcode(a(optJSONObject, "adcode"));
                tip.setID(a(optJSONObject, "id"));
                tip.setAddress(a(optJSONObject, "address"));
                tip.setTypeCode(a(optJSONObject, "typecode"));
                String a2 = a(optJSONObject, QSConstants.TILE_LOCATION);
                if (!TextUtils.isEmpty(a2)) {
                    String[] split = a2.split(",");
                    if (split.length == 2) {
                        tip.setPostion(new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(tip);
            }
            i = i2 + 1;
        }
    }

    public static DistanceResult i(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("results")) {
                return null;
            }
            DistanceResult distanceResult = new DistanceResult();
            JSONArray optJSONArray = jSONObject.optJSONArray("results");
            ArrayList arrayList = new ArrayList();
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    distanceResult.setDistanceResults(arrayList);
                    return distanceResult;
                }
                DistanceItem distanceItem = new DistanceItem();
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                distanceItem.setOriginId(p(a(jSONObject2, "origin_id")));
                distanceItem.setDestId(p(a(jSONObject2, "dest_id")));
                distanceItem.setDistance(q(a(jSONObject2, "distance")));
                distanceItem.setDuration(q(a(jSONObject2, "duration")));
                String a2 = a(jSONObject2, "info");
                if (!TextUtils.isEmpty(a2)) {
                    distanceItem.setErrorInfo(a2);
                    distanceItem.setErrorCode(p(a(jSONObject2, g.c.b)));
                }
                arrayList.add(distanceItem);
                i = i2 + 1;
            }
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseRouteDistance");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static ArrayList<RoutePOIItem> i(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        Object opt = jSONObject.opt("pois");
        if (opt instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray != null && optJSONArray.length() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        arrayList.add(I(optJSONObject));
                    }
                    i = i2 + 1;
                }
            }
            return arrayList;
        } else if (opt instanceof JSONObject) {
            arrayList.add(I(((JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    private static SubPoiItem j(JSONObject jSONObject) throws JSONException {
        SubPoiItem subPoiItem = new SubPoiItem(a(jSONObject, "id"), c(jSONObject, QSConstants.TILE_LOCATION), a(jSONObject, "name"), a(jSONObject, "address"));
        subPoiItem.setSubName(a(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(a(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!g(a2)) {
                try {
                    subPoiItem.setDistance((int) Float.parseFloat(a2));
                    return subPoiItem;
                } catch (NumberFormatException e) {
                    fe.a(e, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e2) {
                    fe.a(e2, "JSONHelper", "parseSubPoiItem");
                    return subPoiItem;
                }
            }
        }
        return subPoiItem;
    }

    public static TruckRouteRestult j(String str) throws AMapException {
        JSONArray optJSONArray;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data")) {
                TruckRouteRestult truckRouteRestult = new TruckRouteRestult();
                JSONObject optJSONObject = jSONObject.optJSONObject("data").optJSONObject("route");
                truckRouteRestult.setStartPos(c(optJSONObject, "origin"));
                truckRouteRestult.setTargetPos(c(optJSONObject, "destination"));
                if (optJSONObject.has("paths") && (optJSONArray = optJSONObject.optJSONArray("paths")) != null) {
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            truckRouteRestult.setPaths(arrayList);
                            return truckRouteRestult;
                        }
                        TruckPath truckPath = new TruckPath();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        truckPath.setDistance(q(a(jSONObject2, "distance")));
                        truckPath.setDuration(s(a(jSONObject2, "duration")));
                        truckPath.setStrategy(a(jSONObject2, "strategy"));
                        truckPath.setTolls(q(a(jSONObject2, "tolls")));
                        truckPath.setTollDistance(q(a(jSONObject2, "toll_distance")));
                        truckPath.setTotalTrafficlights(p(a(jSONObject2, "traffic_lights")));
                        truckPath.setRestriction(p(a(jSONObject2, "restriction")));
                        JSONArray optJSONArray2 = jSONObject2.optJSONArray("steps");
                        if (optJSONArray2 != null) {
                            ArrayList arrayList2 = new ArrayList();
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= optJSONArray2.length()) {
                                    break;
                                }
                                TruckStep truckStep = new TruckStep();
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i4);
                                if (optJSONObject2 != null) {
                                    truckStep.setInstruction(a(optJSONObject2, "instruction"));
                                    truckStep.setOrientation(a(optJSONObject2, "orientation"));
                                    truckStep.setRoad(a(optJSONObject2, "road"));
                                    truckStep.setDistance(q(a(optJSONObject2, "distance")));
                                    truckStep.setTolls(q(a(optJSONObject2, "tolls")));
                                    truckStep.setTollDistance(q(a(optJSONObject2, "toll_distance")));
                                    truckStep.setTollRoad(a(optJSONObject2, "toll_road"));
                                    truckStep.setDuration(q(a(optJSONObject2, "duration")));
                                    truckStep.setPolyline(d(optJSONObject2, "polyline"));
                                    truckStep.setAction(a(optJSONObject2, "action"));
                                    truckStep.setAssistantAction(a(optJSONObject2, "assistant_action"));
                                    a(truckStep, optJSONObject2);
                                    b(truckStep, optJSONObject2);
                                    arrayList2.add(truckStep);
                                }
                                i3 = i4 + 1;
                            }
                            truckPath.setSteps(arrayList2);
                            arrayList.add(truckPath);
                        }
                        i = i2 + 1;
                    }
                }
                return truckRouteRestult;
            }
            return null;
        } catch (JSONException e) {
            fe.a(e, "JSONHelper", "parseTruckRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static BusStationItem k(JSONObject jSONObject) throws JSONException {
        BusStationItem l = l(jSONObject);
        l.setAdCode(a(jSONObject, "adcode"));
        l.setCityCode(a(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            l.setBusLineItems(arrayList);
            return l;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                l.setBusLineItems(arrayList);
                return l;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                arrayList.add(m(optJSONObject));
            }
            i = i2 + 1;
        }
    }

    public static DriveRoutePlanResult k(String str) throws AMapException {
        JSONArray optJSONArray;
        String str2;
        JSONArray jSONArray;
        String str3 = "协议解析错误 - ProtocolException";
        String str4 = "协议解析错误 - ProtocolException";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                jSONObject.optInt("errcode");
                jSONObject.optString("errmsg");
                jSONObject.optString("errdetail");
            }
            if (jSONObject.has("data")) {
                DriveRoutePlanResult driveRoutePlanResult = new DriveRoutePlanResult();
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.has("paths")) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("paths");
                    if (optJSONArray2 == null) {
                        return driveRoutePlanResult;
                    }
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    JSONArray jSONArray2 = optJSONArray2;
                    while (true) {
                        JSONArray jSONArray3 = jSONArray2;
                        str3 = "协议解析错误 - ProtocolException";
                        str4 = "协议解析错误 - ProtocolException";
                        if (i >= jSONArray3.length()) {
                            break;
                        }
                        DrivePlanPath drivePlanPath = new DrivePlanPath();
                        JSONObject optJSONObject2 = jSONArray3.optJSONObject(i);
                        if (optJSONObject2 != null) {
                            drivePlanPath.setDistance(q(a(optJSONObject2, "distance")));
                            drivePlanPath.setTrafficLights(p(a(optJSONObject2, "traffic_lights")));
                            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("steps");
                            if (optJSONArray3 != null) {
                                ArrayList arrayList2 = new ArrayList();
                                int i2 = 0;
                                while (true) {
                                    int i3 = i2;
                                    if (i3 >= optJSONArray3.length()) {
                                        break;
                                    }
                                    DrivePlanStep drivePlanStep = new DrivePlanStep();
                                    JSONObject optJSONObject3 = optJSONArray3.optJSONObject(i3);
                                    if (optJSONObject3 != null) {
                                        drivePlanStep.setAdCode(a(optJSONObject3, "adcode"));
                                        drivePlanStep.setRoad(a(optJSONObject3, "road"));
                                        drivePlanStep.setDistance(q(a(optJSONObject3, "distance")));
                                        str3 = "协议解析错误 - ProtocolException";
                                        str4 = "协议解析错误 - ProtocolException";
                                        try {
                                            drivePlanStep.setToll(p(a(optJSONObject3, RouteSearch.DRIVING_EXCLUDE_TOLL)) == 1);
                                            drivePlanStep.setPolyline(d(optJSONObject3, "polyline"));
                                            arrayList2.add(drivePlanStep);
                                        } catch (JSONException e) {
                                            e = e;
                                            fe.a(e, "JSONHelper", "parseDriveRoute");
                                            throw new AMapException(str4);
                                        } catch (Throwable th) {
                                            th = th;
                                            fe.a(th, "JSONHelper", "parseDriveRouteThrowable");
                                            throw new AMapException(str3);
                                        }
                                    }
                                    i2 = i3 + 1;
                                }
                                drivePlanPath.setSteps(arrayList2);
                                arrayList.add(drivePlanPath);
                                jSONArray = jSONArray3;
                                i++;
                                jSONArray2 = jSONArray;
                            }
                        }
                        jSONArray = jSONArray3;
                        i++;
                        jSONArray2 = jSONArray;
                    }
                    driveRoutePlanResult.setPaths(arrayList);
                    if (optJSONObject.has("time_infos") && (optJSONArray = optJSONObject.optJSONArray("time_infos")) != null) {
                        ArrayList arrayList3 = new ArrayList();
                        int i4 = 0;
                        String str5 = "starttime";
                        while (true) {
                            String str6 = str5;
                            if (i4 >= optJSONArray.length()) {
                                str3 = "协议解析错误 - ProtocolException";
                                str4 = "协议解析错误 - ProtocolException";
                                driveRoutePlanResult.setTimeInfos(arrayList3);
                                return driveRoutePlanResult;
                            }
                            TimeInfo timeInfo = new TimeInfo();
                            JSONObject optJSONObject4 = optJSONArray.optJSONObject(i4);
                            if (optJSONObject4 != null) {
                                if (!optJSONObject4.has(str6)) {
                                    return driveRoutePlanResult;
                                }
                                timeInfo.setStartTime(s(a(optJSONObject4, str6)));
                                JSONArray optJSONArray4 = optJSONObject4.optJSONArray("elements");
                                if (optJSONArray4 != null) {
                                    ArrayList arrayList4 = new ArrayList();
                                    int i5 = 0;
                                    while (true) {
                                        int i6 = i5;
                                        if (i6 >= optJSONArray4.length()) {
                                            break;
                                        }
                                        TimeInfosElement timeInfosElement = new TimeInfosElement();
                                        JSONObject optJSONObject5 = optJSONArray4.optJSONObject(i6);
                                        if (optJSONObject5 != null) {
                                            timeInfosElement.setPathindex(p(a(optJSONObject5, "pathindex")));
                                            timeInfosElement.setDuration(q(a(optJSONObject5, "duration")));
                                            timeInfosElement.setTolls(q(a(optJSONObject5, "tolls")));
                                            int p = p(a(optJSONObject5, "restriction"));
                                            timeInfosElement.setRestriction((p == 2 || p == -1) ? 0 : 1);
                                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("tmcs");
                                            if (optJSONArray5 != null) {
                                                ArrayList arrayList5 = new ArrayList();
                                                int i7 = 0;
                                                while (true) {
                                                    int i8 = i7;
                                                    if (i8 >= optJSONArray5.length()) {
                                                        break;
                                                    }
                                                    TMC tmc = new TMC();
                                                    JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i8);
                                                    if (optJSONObject6 != null) {
                                                        tmc.setStatus(a(optJSONObject6, "status"));
                                                        tmc.setDistance(p(a(optJSONObject6, "distance")));
                                                        tmc.setPolyline(d(optJSONObject6, "polyline"));
                                                        arrayList5.add(tmc);
                                                    }
                                                    i7 = i8 + 1;
                                                }
                                                timeInfosElement.setTMCs(arrayList5);
                                                arrayList4.add(timeInfosElement);
                                            }
                                        }
                                        i5 = i6 + 1;
                                    }
                                    timeInfo.setElements(arrayList4);
                                    arrayList3.add(timeInfo);
                                    str2 = str6;
                                    i4++;
                                    str5 = str2;
                                }
                            }
                            str2 = str6;
                            i4++;
                            str5 = str2;
                        }
                    }
                    return driveRoutePlanResult;
                }
                return driveRoutePlanResult;
            }
            return null;
        } catch (JSONException e2) {
            e = e2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static BusStationItem l(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(c(jSONObject, QSConstants.TILE_LOCATION));
        busStationItem.setBusStationName(a(jSONObject, "name"));
        return busStationItem;
    }

    private static boolean l(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String[] strArr = a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (str.trim().equals(strArr[i2].trim())) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static BusLineItem m(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(a(jSONObject, "id"));
        busLineItem.setBusLineType(a(jSONObject, "type"));
        busLineItem.setBusLineName(a(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(d(jSONObject, "polyline"));
        busLineItem.setCityCode(a(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(a(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(a(jSONObject, "end_stop"));
        return busLineItem;
    }

    private static ArrayList<LatLonPoint> m(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        String[] split = str.split(i.b);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= split.length) {
                return arrayList;
            }
            arrayList.add(n(split[i2]));
            i = i2 + 1;
        }
    }

    private static BusLineItem n(JSONObject jSONObject) throws JSONException {
        BusLineItem m = m(jSONObject);
        m.setFirstBusTime(fe.d(a(jSONObject, e.a)));
        m.setLastBusTime(fe.d(a(jSONObject, e.b)));
        m.setBusCompany(a(jSONObject, "company"));
        m.setDistance(q(a(jSONObject, "distance")));
        m.setBasicPrice(q(a(jSONObject, "basic_price")));
        m.setTotalPrice(q(a(jSONObject, "total_price")));
        m.setBounds(d(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            m.setBusStations(arrayList);
            return m;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= optJSONArray.length()) {
                m.setBusStations(arrayList);
                return m;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                arrayList.add(l(optJSONObject));
            }
            i = i2 + 1;
        }
    }

    private static LatLonPoint n(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    private static DistrictItem o(JSONObject jSONObject) throws JSONException {
        String optString;
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(a(jSONObject, "citycode"));
        districtItem.setAdcode(a(jSONObject, "adcode"));
        districtItem.setName(a(jSONObject, "name"));
        districtItem.setLevel(a(jSONObject, "level"));
        districtItem.setCenter(c(jSONObject, "center"));
        if (jSONObject.has("polyline") && (optString = jSONObject.optString("polyline")) != null && optString.length() > 0) {
            districtItem.setDistrictBoundary(optString.split("\\|"));
        }
        a(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    private static boolean o(String str) {
        return str == null || str.equals("") || str.equals("0");
    }

    private static int p(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            fe.a(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    private static List<BusinessArea> p(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (optJSONArray != null) {
            if (optJSONArray.length() != 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    BusinessArea businessArea = new BusinessArea();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        businessArea.setCenterPoint(c(optJSONObject, QSConstants.TILE_LOCATION));
                        businessArea.setName(a(optJSONObject, "name"));
                        arrayList.add(businessArea);
                    }
                    i = i2 + 1;
                }
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    private static float q(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            fe.a(e, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    private static BusStep q(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStep busStep = new BusStep();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStep.setWalk(r(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStep.setBusLines(s(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStep.setEntrance(t(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject(j.o);
        if (optJSONObject4 != null) {
            busStep.setExit(t(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStep.setRailway(y(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStep.setTaxi(E(optJSONObject6));
        }
        if ((busStep.getWalk() == null || busStep.getWalk().getSteps().size() == 0) && busStep.getBusLines().size() == 0 && busStep.getRailway() == null && busStep.getTaxi() == null) {
            return null;
        }
        return busStep;
    }

    private static double r(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            fe.a(e, "JSONHelper", "str2float");
            return 0.0d;
        }
    }

    private static RouteBusWalkItem r(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(c(jSONObject, "origin"));
        routeBusWalkItem.setDestination(c(jSONObject, "destination"));
        routeBusWalkItem.setDistance(q(a(jSONObject, "distance")));
        routeBusWalkItem.setDuration(s(a(jSONObject, "duration")));
        if (jSONObject.has("steps") && (optJSONArray = jSONObject.optJSONArray("steps")) != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    routeBusWalkItem.setSteps(arrayList);
                    a(routeBusWalkItem, arrayList);
                    return routeBusWalkItem;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    arrayList.add(u(optJSONObject));
                }
                i = i2 + 1;
            }
        }
        return routeBusWalkItem;
    }

    private static long s(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            fe.a(e, "JSONHelper", "str2long");
            return 0L;
        }
    }

    private static List<RouteBusLineItem> s(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("buslines")) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return arrayList;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    arrayList.add(v(optJSONObject));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private static Doorway t(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(a(jSONObject, "name"));
        doorway.setLatLonPoint(c(jSONObject, QSConstants.TILE_LOCATION));
        return doorway;
    }

    private static boolean t(String str) {
        return (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) ? false : true;
    }

    private static WalkStep u(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(a(jSONObject, "instruction"));
        walkStep.setOrientation(a(jSONObject, "orientation"));
        walkStep.setRoad(a(jSONObject, "road"));
        walkStep.setDistance(q(a(jSONObject, "distance")));
        walkStep.setDuration(q(a(jSONObject, "duration")));
        walkStep.setPolyline(d(jSONObject, "polyline"));
        walkStep.setAction(a(jSONObject, "action"));
        walkStep.setAssistantAction(a(jSONObject, "assistant_action"));
        return walkStep;
    }

    private static RouteBusLineItem v(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(x(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(x(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(a(jSONObject, "name"));
        routeBusLineItem.setBusLineId(a(jSONObject, "id"));
        routeBusLineItem.setBusLineType(a(jSONObject, "type"));
        routeBusLineItem.setDistance(q(a(jSONObject, "distance")));
        routeBusLineItem.setDuration(q(a(jSONObject, "duration")));
        routeBusLineItem.setPolyline(d(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(fe.d(a(jSONObject, e.a)));
        routeBusLineItem.setLastBusTime(fe.d(a(jSONObject, e.b)));
        routeBusLineItem.setPassStationNum(p(a(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(w(jSONObject));
        return routeBusLineItem;
    }

    private static List<BusStationItem> w(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("via_stops")) != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return arrayList;
                }
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    arrayList.add(x(optJSONObject));
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private static BusStationItem x(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(a(jSONObject, "name"));
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(c(jSONObject, QSConstants.TILE_LOCATION));
        return busStationItem;
    }

    private static RouteRailwayItem y(JSONObject jSONObject) throws JSONException {
        RouteRailwayItem routeRailwayItem = null;
        if (jSONObject == null) {
            return null;
        }
        if (jSONObject.has("id")) {
            if (!jSONObject.has("name")) {
                return null;
            }
            routeRailwayItem = new RouteRailwayItem();
            routeRailwayItem.setID(a(jSONObject, "id"));
            routeRailwayItem.setName(a(jSONObject, "name"));
            routeRailwayItem.setTime(a(jSONObject, g.a.g));
            routeRailwayItem.setTrip(a(jSONObject, "trip"));
            routeRailwayItem.setDistance(q(a(jSONObject, "distance")));
            routeRailwayItem.setType(a(jSONObject, "type"));
            routeRailwayItem.setDeparturestop(z(jSONObject.optJSONObject("departure_stop")));
            routeRailwayItem.setArrivalstop(z(jSONObject.optJSONObject("arrival_stop")));
            routeRailwayItem.setViastops(A(jSONObject));
            routeRailwayItem.setAlters(B(jSONObject));
            routeRailwayItem.setSpaces(C(jSONObject));
        }
        return routeRailwayItem;
    }

    private static RailwayStationItem z(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(a(jSONObject, "id"));
        railwayStationItem.setName(a(jSONObject, "name"));
        railwayStationItem.setLocation(c(jSONObject, QSConstants.TILE_LOCATION));
        railwayStationItem.setAdcode(a(jSONObject, "adcode"));
        railwayStationItem.setTime(a(jSONObject, g.a.g));
        railwayStationItem.setisStart(t(a(jSONObject, "start")));
        railwayStationItem.setisEnd(t(a(jSONObject, "end")));
        railwayStationItem.setWait(q(a(jSONObject, "wait")));
        return railwayStationItem;
    }
}
