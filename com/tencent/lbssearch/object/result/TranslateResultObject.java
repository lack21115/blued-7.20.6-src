package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.deserializer.PolylineDeserializer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.umeng.analytics.pro.d;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/result/TranslateResultObject.class */
public class TranslateResultObject extends BaseObject {
    @Json(deserializer = PolylineDeserializer.class, name = d.B)
    public List<LatLng> latLngs;
}
