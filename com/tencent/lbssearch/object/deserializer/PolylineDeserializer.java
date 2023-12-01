package com.tencent.lbssearch.object.deserializer;

import com.tencent.map.tools.json.JsonParser;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/deserializer/PolylineDeserializer.class */
public class PolylineDeserializer implements JsonParser.Deserializer<List<LatLng>> {
    private static List<LatLng> calcCoord(List<Double> list) {
        if (list != null) {
            if (list.size() < 2) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new LatLng(list.get(0).doubleValue(), list.get(1).doubleValue()));
            for (int i = 2; i < list.size(); i += 2) {
                int i2 = (i / 2) - 1;
                arrayList.add(new LatLng((float) (Math.round((((LatLng) arrayList.get(i2)).latitude + (list.get(i).doubleValue() / 1000000.0d)) * 1000000.0d) / 1000000.0d), (float) (Math.round((((LatLng) arrayList.get(i2)).longitude + (list.get(i + 1).doubleValue() / 1000000.0d)) * 1000000.0d) / 1000000.0d)));
            }
            return arrayList;
        }
        return null;
    }

    private static List<LatLng> normalCoord(List<Double> list) {
        if (list == null || list.size() < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            arrayList.add(new LatLng((float) (Math.round(list.get(i2 + 1).doubleValue() * 1000000.0d) / 1000000.0d), (float) (Math.round(list.get(i2).doubleValue() * 1000000.0d) / 1000000.0d)));
            i = i2 + 2;
        }
    }

    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public List<LatLng> deserialize(Object obj, String str, Object obj2) throws JSONException {
        if (obj2 == null) {
            return null;
        }
        List<LatLng> list = null;
        if (obj2 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj2;
            list = null;
            if (jSONArray.length() > 0) {
                if (jSONArray.get(0) instanceof JSONObject) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        arrayList.add(new LatLng(jSONObject.optDouble("lat"), jSONObject.optDouble("lng")));
                    }
                    return arrayList;
                }
                ArrayList arrayList2 = new ArrayList();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < jSONArray.length()) {
                        arrayList2.add(Double.valueOf(jSONArray.optDouble(i3)));
                        i2 = i3 + 1;
                    } else {
                        try {
                            return calcCoord(arrayList2);
                        } catch (Exception e) {
                            list = normalCoord(arrayList2);
                        }
                    }
                }
            }
        }
        return list;
    }
}
