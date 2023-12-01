package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.RoutePlanningStepDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/RoutePlanningObject.class */
public abstract class RoutePlanningObject extends BaseObject {

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/RoutePlanningObject$Step.class */
    public static final class Step extends JsonComposer {
        public String accessorial_desc;
        public String act_desc;
        public String dir_desc;
        public float distance;
        public String instruction;
        @Json(deserializer = RoutePlanningStepDeserializer.class)
        public List<Integer> polyline_idx;
        public String road_name;
        public int type;
    }
}
