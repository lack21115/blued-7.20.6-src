package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/Geo2AddressResultObject.class */
public class Geo2AddressResultObject extends BaseObject {
    public ReverseAddressResult result;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/Geo2AddressResultObject$ReverseAddressResult.class */
    public static final class ReverseAddressResult extends JsonComposer {
        public AdInfo ad_info;
        public String address;
        public AddressComponent address_component;
        public AddressReference address_reference;
        public FormatterAddress formatted_addresses;
        public int poi_count;
        public List<Poi> pois;

        /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/Geo2AddressResultObject$ReverseAddressResult$AddressReference.class */
        public static final class AddressReference extends JsonComposer {
            public Area crossroad;
            public Area famous_area;
            public Area landmark_l1;
            public Area landmark_l2;
            public Area street;
            public Area street_number;
            public Area town;
            public Area water;

            /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/Geo2AddressResultObject$ReverseAddressResult$AddressReference$Area.class */
            public static final class Area extends JsonComposer {
                public String _dir_desc;
                public float _distance;
                @Json(deserializer = LatLngDeserializer.class, name = "location")
                public LatLng latLng;
                public String title;
            }
        }

        /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/Geo2AddressResultObject$ReverseAddressResult$FormatterAddress.class */
        public static final class FormatterAddress extends JsonComposer {
            public String recommend;
            public String rough;
        }
    }
}
