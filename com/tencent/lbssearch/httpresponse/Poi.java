package com.tencent.lbssearch.httpresponse;

import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/httpresponse/Poi.class */
public class Poi extends JsonComposer {
    public float _distance;
    public String address;
    public String category;
    public String id;
    @Json(deserializer = LatLngDeserializer.class, name = "location")
    public LatLng latLng;
    public String title;
}
