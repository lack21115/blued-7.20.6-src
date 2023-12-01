package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.lbssearch.object.deserializer.PolylineDeserializer;
import com.tencent.lbssearch.object.deserializer.TransitResultLatLngBoundsDeserializer;
import com.tencent.lbssearch.object.deserializer.TransitResultSegmentDeserializer;
import com.tencent.lbssearch.object.result.RoutePlanningObject;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.map.tools.json.annotation.JsonType;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject.class */
public class TransitResultObject extends RoutePlanningObject {
    public Result result;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$Destination.class */
    public static final class Destination extends JsonComposer {
        public String id;
        public String title;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$Exit.class */
    public static final class Exit extends JsonComposer {
        public String id;
        public String title;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$GetOnOrOff.class */
    public static final class GetOnOrOff extends JsonComposer {
        public Exit exit;
        public String id;
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String title;
    }

    @JsonType(deserializer = TransitResultLatLngBoundsDeserializer.class)
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$LatLngBounds.class */
    public static final class LatLngBounds extends JsonComposer {
        public LatLng northeast;
        public LatLng southwest;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$Line.class */
    public static final class Line extends JsonComposer {
        public Destination destination;
        public float distance;
        public float duration;
        public GetOnOrOff getoff;
        public GetOnOrOff geton;
        public String id;
        @Json(deserializer = PolylineDeserializer.class)
        public List<LatLng> polyline;
        public double price;
        public int running_status;
        public int station_count;
        public List<Station> stations;
        public String title;
        public String vehicle;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$Result.class */
    public static final class Result extends JsonComposer {
        public List<Route> routes;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$Route.class */
    public static final class Route extends JsonComposer {
        public LatLngBounds bounds;
        public float distance;
        public long duration;
        public long duration_1m;
        public List<Segment> steps;
    }

    @JsonType(deserializer = TransitResultSegmentDeserializer.class)
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$Segment.class */
    public static abstract class Segment extends JsonComposer {
        public String mode;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$Station.class */
    public static final class Station extends JsonComposer {
        public String id;
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String title;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$Transit.class */
    public static final class Transit extends Segment {
        public List<Line> lines;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TransitResultObject$Walking.class */
    public static final class Walking extends Segment {
        public String accessorial_desc;
        public String direction;
        public float distance;
        public float duration;
        @Json(deserializer = PolylineDeserializer.class)
        public List<LatLng> polyline;
        public List<RoutePlanningObject.Step> steps;
    }
}
