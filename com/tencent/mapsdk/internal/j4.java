package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j4.class */
public class j4 implements JsonParser.Deserializer<List<WeightedLatLng>> {
    private static List<WeightedLatLng> a(List<Double> list) {
        if (list != null) {
            if (list.size() < 3) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new WeightedLatLng(new LatLng(list.get(0).doubleValue(), list.get(1).doubleValue()), list.get(2).doubleValue()));
            for (int i = 3; i < list.size(); i += 3) {
                WeightedLatLng weightedLatLng = (WeightedLatLng) arrayList.get((i / 3) - 1);
                arrayList.add(new WeightedLatLng(new LatLng(weightedLatLng.getPoint().latitude + (list.get(i).doubleValue() / 1000000.0d), weightedLatLng.getPoint().longitude + (list.get(i + 1).doubleValue() / 1000000.0d)), weightedLatLng.getIntensity() + (list.get(i + 2).doubleValue() / 100.0d)));
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    /* renamed from: a */
    public List<WeightedLatLng> deserialize(Object obj, String str, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        List<WeightedLatLng> list = null;
        if (obj2 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj2;
            list = null;
            if (jSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= jSONArray.length()) {
                        break;
                    }
                    arrayList.add(Double.valueOf(jSONArray.optDouble(i2)));
                    i = i2 + 1;
                }
                list = a(arrayList);
            }
        }
        return list;
    }
}
