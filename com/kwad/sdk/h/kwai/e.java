package com.kwad.sdk.h.kwai;

import android.hardware.SensorEvent;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/h/kwai/e.class */
public final class e extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public int sensorType = -1;
    public List<Float> axI = new ArrayList();
    public long timestamp = 0;

    public static e a(SensorEvent sensorEvent, long j) {
        if (sensorEvent == null) {
            return null;
        }
        e eVar = new e();
        eVar.sensorType = sensorEvent.sensor.getType();
        eVar.timestamp = j / 1000;
        float[] fArr = sensorEvent.values;
        int length = fArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return eVar;
            }
            eVar.axI.add(Float.valueOf(fArr[i2]));
            i = i2 + 1;
        }
    }

    private void a(e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.sensorType = jSONObject.optInt("sensorType");
        eVar.timestamp = jSONObject.optLong("timestamp");
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(e eVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "sensorType", eVar.sensorType);
        t.putValue(jSONObject, "timestamp", eVar.timestamp);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public final void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        t.putValue(jSONObject, "values", this.axI);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject b = b(this, new JSONObject());
        afterToJson(b);
        return b;
    }
}
