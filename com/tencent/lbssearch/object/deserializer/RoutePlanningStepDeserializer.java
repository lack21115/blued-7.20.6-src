package com.tencent.lbssearch.object.deserializer;

import com.tencent.map.tools.json.JsonParser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/deserializer/RoutePlanningStepDeserializer.class */
public class RoutePlanningStepDeserializer implements JsonParser.Deserializer<List<Integer>> {
    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public List<Integer> deserialize(Object obj, String str, Object obj2) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (obj2 instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj2;
            if (jSONArray.length() == 2) {
                arrayList.add(Integer.valueOf(jSONArray.getInt(0) / 2));
                arrayList.add(Integer.valueOf(jSONArray.getInt(1) / 2));
            }
        }
        return arrayList;
    }
}
