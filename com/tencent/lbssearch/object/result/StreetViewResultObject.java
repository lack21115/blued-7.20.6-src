package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/StreetViewResultObject.class */
public class StreetViewResultObject extends BaseObject {
    public Details detail;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/StreetViewResultObject$Details.class */
    public static final class Details extends JsonComposer {
        public String description;
        public int heading;
        public String id;
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public int pitch;
        public int pov_exp;
        public int zoom;
    }
}
