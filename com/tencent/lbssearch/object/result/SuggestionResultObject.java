package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/SuggestionResultObject.class */
public class SuggestionResultObject extends BaseObject {
    public int count;
    public List<SuggestionData> data;
    public List<SubPoi> sub_pois;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/SuggestionResultObject$SubPoi.class */
    public static final class SubPoi extends JsonComposer {
        public AdInfo ad_info;
        public String adcode;
        public String address;
        public String category;
        public String city;
        public String id;
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String parent_id;
        public String tel;
        public String title;
        public String type;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/SuggestionResultObject$SuggestionData.class */
    public static final class SuggestionData extends JsonComposer {
        public float _distance;
        public String adcode;
        public String address;
        public String city;
        public String district;
        public String id;
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public String province;
        public String title;
        public int type;
    }
}
