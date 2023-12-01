package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.t;
import com.tencent.lbssearch.httpresponse.UrlConstant;
import com.tencent.lbssearch.object.RequestParams;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.mapsdk.internal.f7;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.umeng.analytics.pro.bh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/DrivingParam.class */
public class DrivingParam extends RoutePlanningParam {
    private static final int MAX_WAT_POINTS = 10;
    private int accuracy;
    private List<List<LatLng>> avoidPolygons;
    private boolean cache;
    private String carNumber;
    private CarType carType;
    private String fromPOI;
    private Travel fromTravel;
    private int heading;
    private final Set<String> mExtraFields;
    private int multRoute;
    private int noStep;
    private String policy;
    private RoadType roadType;
    private int speed;
    private boolean trafficSpeed;
    private List<LatLng> waypoints;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/DrivingParam$CarType.class */
    public enum CarType {
        DEF,
        NEW_ENERGY
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/DrivingParam$Policy.class */
    public enum Policy {
        LEAST_TIME,
        PICKUP,
        TRIP
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/DrivingParam$Preference.class */
    public enum Preference {
        REAL_TRAFFIC,
        LEAST_FEE,
        AVOID_HIGHWAY,
        NAV_POINT_FIRST
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/DrivingParam$RoadType.class */
    public enum RoadType {
        DEF,
        ABOVE_BRIDGE,
        BELOW_BRIDGE,
        ON_MAIN_ROAD,
        ON_SIDE_ROAD,
        OPPOSITE_SIDE,
        ON_MAIN_ROAD_BELOW_BRIDGE,
        ON_SIDE_ROAD_BELOW_BRIDGE
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/DrivingParam$Travel.class */
    public static class Travel {
        public List<Point> points = new ArrayList();

        /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/param/DrivingParam$Travel$Point.class */
        public static class Point {
            private LatLng latLng;
            private int speed = -1;
            private int accuracy = -1;
            private int directionOfCar = -1;
            private int directionOfDevice = -1;
            private int time = 0;

            public Point(LatLng latLng) {
                this.latLng = latLng;
            }

            public Point setAccuracy(int i) {
                this.accuracy = i;
                return this;
            }

            public Point setDirectionOfCar(int i) {
                this.directionOfCar = i;
                return this;
            }

            public Point setDirectionOfDevice(int i) {
                this.directionOfDevice = i;
                return this;
            }

            public Point setSpeed(int i) {
                this.speed = i;
                return this;
            }

            public Point setTime(int i) {
                this.time = i;
                return this;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                LatLng latLng = this.latLng;
                if (latLng != null) {
                    sb.append(latLng.latitude);
                    sb.append(",");
                    sb.append(this.latLng.longitude);
                    sb.append(",");
                }
                sb.append(this.speed);
                sb.append(",");
                sb.append(this.accuracy);
                sb.append(",");
                sb.append(this.directionOfCar);
                sb.append(",");
                sb.append(this.directionOfDevice);
                sb.append(",");
                sb.append(this.time);
                return sb.toString();
            }
        }

        public void addPoints(Point... pointArr) {
            if (pointArr != null) {
                this.points.addAll(Arrays.asList(pointArr));
            }
        }

        public String toString() {
            int size = this.points.size();
            int i = size;
            if (size > 50) {
                i = 50;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i) {
                    return super.toString();
                }
                sb.append(this.points.get(i3));
                sb.append(t.aE);
                i2 = i3 + 1;
            }
        }
    }

    public DrivingParam() {
        this.waypoints = new ArrayList();
        this.heading = -1;
        this.speed = -1;
        this.accuracy = -1;
        this.roadType = RoadType.DEF;
        this.carType = CarType.DEF;
        this.noStep = 0;
        this.mExtraFields = new HashSet();
    }

    public DrivingParam(LatLng latLng, LatLng latLng2) {
        super(latLng, latLng2);
        this.waypoints = new ArrayList();
        this.heading = -1;
        this.speed = -1;
        this.accuracy = -1;
        this.roadType = RoadType.DEF;
        this.carType = CarType.DEF;
        this.noStep = 0;
        this.mExtraFields = new HashSet();
    }

    public DrivingParam accuracy(int i) {
        this.accuracy = i;
        return this;
    }

    public DrivingParam addWayPoint(LatLng latLng) {
        if (this.waypoints.size() < 10) {
            this.waypoints.add(latLng);
        }
        return this;
    }

    public DrivingParam addWayPoints(Iterable<LatLng> iterable) {
        if (iterable != null) {
            int i = 0;
            for (LatLng latLng : iterable) {
                this.waypoints.add(latLng);
                int i2 = i + 1;
                i = i2;
                if (i2 > 10) {
                    break;
                }
            }
        }
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam, com.tencent.lbssearch.object.param.ParamObject
    public RequestParams buildParameters() {
        RequestParams buildParameters = super.buildParameters();
        if (!TextUtils.isEmpty(this.fromPOI)) {
            buildParameters.put("from_poi", this.fromPOI);
        }
        int i = this.heading;
        if (i != -1) {
            buildParameters.put("heading", i);
        }
        int i2 = this.speed;
        if (i2 != -1) {
            buildParameters.put("speed", i2);
        }
        int i3 = this.accuracy;
        if (i3 != -1) {
            buildParameters.put("accuracy", i3);
        }
        if (this.trafficSpeed) {
            buildParameters.put("get_speed", 1);
        }
        buildParameters.put("road_type", this.roadType.ordinal());
        buildParameters.put("no_step", this.noStep);
        buildParameters.put("get_mp", this.multRoute);
        Travel travel = this.fromTravel;
        if (travel != null && travel.points.size() > 0) {
            buildParameters.put("from_track", this.fromTravel.toString());
        }
        if (this.waypoints.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (LatLng latLng : this.waypoints) {
                sb.append(locationToParamsString(latLng));
                sb.append(t.aE);
            }
            sb.setLength(sb.length() - 1);
            buildParameters.put("waypoints", sb.toString());
        }
        if (!TextUtils.isEmpty(this.policy)) {
            buildParameters.put(bh.bt, this.policy);
        }
        if (!TextUtils.isEmpty(this.carNumber)) {
            buildParameters.put("plate_number", this.carNumber);
        }
        buildParameters.put("car_type", this.carType.ordinal());
        if (!this.mExtraFields.isEmpty()) {
            buildParameters.put("added_fields", f7.a(this.mExtraFields, ","));
        }
        buildParameters.put("is_cache", this.cache ? "1" : "0");
        if (this.avoidPolygons != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.avoidPolygons.size()) {
                    break;
                }
                List<LatLng> list = this.avoidPolygons.get(i5);
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= list.size()) {
                        break;
                    }
                    LatLng latLng2 = list.get(i7);
                    stringBuffer.append(latLng2.latitude);
                    stringBuffer.append(',');
                    stringBuffer.append(latLng2.longitude);
                    if (i7 != list.size() - 1) {
                        stringBuffer.append(';');
                    }
                    i6 = i7 + 1;
                }
                if (i5 != this.avoidPolygons.size() - 1) {
                    stringBuffer.append('|');
                }
                i4 = i5 + 1;
            }
            buildParameters.put("avoid_polygons", stringBuffer.toString());
        }
        return buildParameters;
    }

    public DrivingParam cache(boolean z) {
        this.cache = z;
        return this;
    }

    public DrivingParam fromPOI(String str) {
        this.fromPOI = str;
        return this;
    }

    public DrivingParam fromTravel(Travel travel) {
        this.fromTravel = travel;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public Class<DrivingResultObject> getResultClass() {
        return DrivingResultObject.class;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public String getUrl() {
        return UrlConstant.ROUTE_PLANNING_DRIVING;
    }

    public DrivingParam heading(int i) {
        this.heading = i;
        return this;
    }

    public DrivingParam policy(Policy policy, Preference... preferenceArr) {
        StringBuilder sb = new StringBuilder();
        if (policy != null) {
            sb.append(policy.name());
        }
        if (preferenceArr != null && preferenceArr.length > 0) {
            int length = preferenceArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                Preference preference = preferenceArr[i2];
                sb.append(",");
                sb.append(preference.name());
                i = i2 + 1;
            }
        }
        this.policy = sb.toString();
        return this;
    }

    public DrivingParam policy(RoutePlanningParam.DrivingPolicy drivingPolicy) {
        StringBuilder sb = new StringBuilder();
        if (drivingPolicy != null) {
            sb.append(drivingPolicy.name());
        }
        this.policy = sb.toString();
        return this;
    }

    public DrivingParam roadType(RoadType roadType) {
        this.roadType = roadType;
        return this;
    }

    public DrivingParam setAvoidPolygons(List<List<LatLng>> list) {
        this.avoidPolygons = list;
        return this;
    }

    public DrivingParam setCarNumber(String str) {
        this.carNumber = str;
        return this;
    }

    public DrivingParam setCarType(CarType carType) {
        this.carType = carType;
        return this;
    }

    public DrivingParam setExtraFields(String... strArr) {
        this.mExtraFields.addAll(Arrays.asList(strArr));
        return this;
    }

    public DrivingParam setMultRoute(int i) {
        this.multRoute = i;
        return this;
    }

    public void setMultyPlan(boolean z) {
    }

    public DrivingParam setNoStep(int i) {
        this.noStep = i;
        return this;
    }

    public DrivingParam speed(int i) {
        this.speed = i;
        return this;
    }

    @Override // com.tencent.lbssearch.object.param.RoutePlanningParam
    public DrivingParam toPOI(String str) {
        return (DrivingParam) super.toPOI(str);
    }

    public DrivingParam trafficSpeed(boolean z) {
        this.trafficSpeed = z;
        return this;
    }
}
