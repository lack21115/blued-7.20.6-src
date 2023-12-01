package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.lbssearch.object.deserializer.PolylineDeserializer;
import com.tencent.lbssearch.object.deserializer.RoutePlanningStepDeserializer;
import com.tencent.lbssearch.object.result.RoutePlanningObject;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/DrivingResultObject.class */
public class DrivingResultObject extends RoutePlanningObject {
    public static final String EXPERIENCE = "EXPERIENCE";
    public static final String LEAST_DISTANCE = "LEAST_DISTANCE";
    public static final String LEAST_LIGHT = "LEAST_LIGHT";
    public static final String LEAST_TIME = "LEAST_TIME";
    public static final String RECOMMEND = "RECOMMEND";
    public Result result;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/DrivingResultObject$Restriction.class */
    public static final class Restriction extends JsonComposer {
        public int status;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/DrivingResultObject$Result.class */
    public static final class Result extends JsonComposer {
        @Json(name = "nav_session_id")
        public String naviSessionId;
        public List<Route> routes;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/DrivingResultObject$Route.class */
    public static final class Route extends JsonComposer {
        public String direction;
        public float distance;
        public float duration;
        public String mode;
        @Json(deserializer = PolylineDeserializer.class)
        public List<LatLng> polyline;
        public Restriction restriction;
        @Json(name = "route_id")
        public String routeId;
        public List<RoutePlanningObject.Step> steps;
        public List<String> tags;
        public TaxiFare taxi_fare;
        public String toll;
        @Json(name = "speed")
        public List<TrafficSpeed> trafficSpeeds;
        public int traffic_light_count = -1;
        public List<WayPoint> waypoints;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/DrivingResultObject$TaxiFare.class */
    public static final class TaxiFare extends JsonComposer {
        public double fare;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/DrivingResultObject$TrafficSpeed.class */
    public static final class TrafficSpeed extends JsonComposer {
        public int distance;
        public int level;
        @Json(deserializer = RoutePlanningStepDeserializer.class)
        public List<Integer> polyline_idx;
        public int speed;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/DrivingResultObject$WayPoint.class */
    public static final class WayPoint extends JsonComposer {
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String title;
    }
}
