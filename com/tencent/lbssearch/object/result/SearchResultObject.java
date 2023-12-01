package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.LatLngDeserializer;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/SearchResultObject.class */
public class SearchResultObject extends BaseObject {
    public int count;
    public List<SearchResultData> data;
    public List<SuggestionResultObject.SubPoi> sub_pois;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/SearchResultObject$SearchResultData.class */
    public static final class SearchResultData extends JsonComposer {
        public AdInfo ad_info;
        public String address;
        public String category;
        @Json(name = "_distance")
        public double distance;
        public String id;
        @Json(deserializer = LatLngDeserializer.class, name = "location")
        public LatLng latLng;
        public Pano pano;
        public String tel;
        public String title;
        public String type;

        /* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/SearchResultObject$SearchResultData$Pano.class */
        public static final class Pano extends JsonComposer {
            public int heading;
            public String id;
            public int pitch;
            public int zoom;
        }
    }
}
