package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/Address2GeoResultObject.class */
public class Address2GeoResultObject extends BaseObject {
    public Address2GeoResult result;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/Address2GeoResultObject$Address2GeoResult.class */
    public static final class Address2GeoResult extends JsonComposer {
        public AdInfo ad_info;
        public AddressComponent address_components;
        public float deviation;
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public int level;
        public int reliability;
        public float similarity;
    }
}
