package com.tencent.lbssearch.object.deserializer;

import android.text.TextUtils;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.map.tools.json.JsonParser;
import com.tencent.map.tools.json.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/lbssearch/object/deserializer/TransitResultSegmentDeserializer.class */
public class TransitResultSegmentDeserializer implements JsonParser.Deserializer<TransitResultObject.Segment> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.map.tools.json.JsonParser.Deserializer
    public TransitResultObject.Segment deserialize(Object obj, String str, Object obj2) throws JSONException {
        if (obj2 == null) {
            return null;
        }
        TransitResultObject.Segment segment = null;
        if (obj2 instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj2;
            String string = jSONObject.getString("mode");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if ("WALKING".equalsIgnoreCase(string)) {
                return (TransitResultObject.Segment) JsonUtils.parseToModel(jSONObject, TransitResultObject.Walking.class, new Object[0]);
            }
            segment = null;
            if ("TRANSIT".equalsIgnoreCase(string)) {
                segment = (TransitResultObject.Segment) JsonUtils.parseToModel(jSONObject, TransitResultObject.Transit.class, new Object[0]);
            }
        }
        return segment;
    }
}
