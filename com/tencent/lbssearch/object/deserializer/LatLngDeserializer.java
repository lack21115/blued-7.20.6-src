package com.tencent.lbssearch.object.deserializer;

import com.tencent.map.tools.json.JsonParser;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/deserializer/LatLngDeserializer.class */
public class LatLngDeserializer implements JsonParser.Deserializer<LatLng> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public LatLng deserialize(Object obj, String str, Object obj2) throws JSONException {
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj2;
            return new LatLng(jSONObject.optDouble("lat"), jSONObject.optDouble("lng"));
        } else if (obj2 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj2;
            if (jSONArray.length() < 2) {
                return null;
            }
            return jSONArray.length() > 2 ? new LatLng(jSONArray.getDouble(0), jSONArray.getDouble(1), jSONArray.getDouble(2)) : new LatLng(jSONArray.getDouble(0), jSONArray.getDouble(1));
        } else if ((obj2 instanceof JSONStringer) || (obj2 instanceof String)) {
            String[] split = obj2.toString().split(",");
            if (split.length < 2) {
                return null;
            }
            return split.length > 2 ? new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2])) : new LatLng(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
        } else {
            return null;
        }
    }
}
