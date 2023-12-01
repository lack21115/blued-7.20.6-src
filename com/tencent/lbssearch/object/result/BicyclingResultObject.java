package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.object.deserializer.PolylineDeserializer;
import com.tencent.lbssearch.object.result.RoutePlanningObject;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/BicyclingResultObject.class */
public class BicyclingResultObject extends RoutePlanningObject {
    public Result result;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/BicyclingResultObject$Result.class */
    public static final class Result extends JsonComposer {
        public List<Route> routes;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/BicyclingResultObject$Route.class */
    public static final class Route extends JsonComposer {
        public String direction;
        public float distance;
        public float duration;
        public String mode;
        @Json(deserializer = PolylineDeserializer.class)
        public List<LatLng> polyline;
        public List<RoutePlanningObject.Step> steps;
    }
}
