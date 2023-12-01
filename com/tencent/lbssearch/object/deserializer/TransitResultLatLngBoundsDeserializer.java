package com.tencent.lbssearch.object.deserializer;

import android.text.TextUtils;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import org.json.JSONException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/deserializer/TransitResultLatLngBoundsDeserializer.class */
public class TransitResultLatLngBoundsDeserializer implements JsonParser.Deserializer<TransitResultObject.LatLngBounds> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public TransitResultObject.LatLngBounds deserialize(Object obj, String str, Object obj2) throws JSONException {
        TransitResultObject.LatLngBounds latLngBounds = new TransitResultObject.LatLngBounds();
        if (obj instanceof TransitResultObject.LatLngBounds) {
            latLngBounds = (TransitResultObject.LatLngBounds) obj;
        }
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        if (str2 == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        String[] split = str2.split(",");
        if (split.length == 4) {
            latLngBounds.northeast = new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
            latLngBounds.southwest = new LatLng(Double.parseDouble(split[2]), Double.parseDouble(split[3]));
            return latLngBounds;
        }
        return null;
    }
}
