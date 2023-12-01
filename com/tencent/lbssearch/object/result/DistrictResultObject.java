package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.lbssearch.object.deserializer.PolygonDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/DistrictResultObject.class */
public class DistrictResultObject extends BaseObject {
    public String data_version;
    public List<List<DistrictResult>> result;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/DistrictResultObject$DistrictResult.class */
    public static final class DistrictResult extends JsonComposer {
        public List<Integer> cidx;
        public String fullname;
        public int id;
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String name;
        public List<String> pinyin;
        @Json(deserializer = PolygonDeserializer.class, name = "polygon")
        public List<List<LatLng>> polygon;
    }
}
