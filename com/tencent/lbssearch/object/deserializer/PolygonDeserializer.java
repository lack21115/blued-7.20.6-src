package com.tencent.lbssearch.object.deserializer;

import com.tencent.map.tools.json.JsonParser;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/deserializer/PolygonDeserializer.class */
public class PolygonDeserializer implements JsonParser.Deserializer<List<List<LatLng>>> {
    private PolylineDeserializer mPolylineDeserializer = new PolylineDeserializer();

    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public List<List<LatLng>> deserialize(Object obj, String str, Object obj2) throws JSONException {
        if (obj2 == null) {
            return null;
        }
        ArrayList arrayList = null;
        if (obj2 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj2;
            arrayList = null;
            if (jSONArray.length() > 0) {
                ArrayList arrayList2 = new ArrayList(jSONArray.length());
                int i = 0;
                while (true) {
                    int i2 = i;
                    arrayList = arrayList2;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    List<LatLng> deserialize = this.mPolylineDeserializer.deserialize(obj, str, jSONArray.get(i2));
                    if (deserialize != null && deserialize.size() > 0) {
                        arrayList2.add(deserialize);
                    }
                    i = i2 + 1;
                }
            }
        }
        return arrayList;
    }
}
