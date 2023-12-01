package com.tencent.lbssearch.httpresponse;

import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/httpresponse/AdInfo.class */
public class AdInfo extends JsonComposer {
    public String adcode;
    public String city;
    public String city_code;
    public String district;
    @Json(deserializer = LatLngDeserializer.class, name = "location")
    public LatLng latLng;
    public String name;
    public String nation;
    public String nation_code;
    public String province;
}
