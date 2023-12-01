package com.kwad.components.core.webview.jshandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.text.TextUtils;
import com.kwad.components.core.r.l;
import com.umeng.analytics.pro.bh;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/k.class */
public final class k implements SensorEventListener, com.kwad.sdk.core.webview.b.a {
    private Map<Integer, com.kwad.sdk.core.webview.b.c> Sl = new ConcurrentHashMap();

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/webview/jshandler/k$a.class */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public int So;
        public ArrayList<Float> Sp;
        public int accuracy;
        public long timestamp;
        public int type;

        @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.So = jSONObject.optInt(bh.aX);
            this.timestamp = jSONObject.optLong("timestamp");
            this.accuracy = jSONObject.optInt("accuracy");
            JSONArray optJSONArray = jSONObject.optJSONArray("values");
            ArrayList<Float> arrayList = new ArrayList<>();
            if (optJSONArray == null) {
                this.Sp = arrayList;
                return;
            }
            int i = 0;
            while (true) {
                try {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    Object obj = optJSONArray.get(i2);
                    if (obj != null) {
                        arrayList.add((Float) obj);
                    }
                    i = i2 + 1;
                } catch (Throwable th) {
                }
            }
            this.Sp = arrayList;
        }

        @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            int i = this.type;
            if (i != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "type", i);
            }
            int i2 = this.So;
            if (i2 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, bh.aX, i2);
            }
            long j = this.timestamp;
            if (j != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "timestamp", j);
            }
            int i3 = this.accuracy;
            if (i3 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "accuracy", i3);
            }
            if (!this.Sp.isEmpty()) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "values", this.Sp);
            }
            return jSONObject;
        }
    }

    private void a(int i, int i2, final com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.r.l.pS().a(i, i2, this, new l.b() { // from class: com.kwad.components.core.webview.jshandler.k.1
            @Override // com.kwad.components.core.r.l.b
            public final void onFailed() {
                cVar.onError(-1, "sensor is not support");
            }
        });
    }

    private void a(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 4) {
            type = 2;
        } else if (type == 10) {
            type = 1;
        }
        com.kwad.sdk.core.webview.b.c cVar = this.Sl.get(Integer.valueOf(type));
        if (cVar == null) {
            return;
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= sensorEvent.values.length) {
                a aVar = new a();
                aVar.Sp = arrayList;
                aVar.timestamp = sensorEvent.timestamp;
                aVar.accuracy = sensorEvent.accuracy;
                cVar.a(aVar);
                return;
            }
            arrayList.add(Float.valueOf(sensorEvent.values[i2]));
            i = i2 + 1;
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final String getKey() {
        return "registerSensorListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, com.kwad.sdk.core.webview.b.c cVar) {
        if (TextUtils.isEmpty(str)) {
            cVar.onError(-1, "data is empty");
            return;
        }
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.Sl.put(Integer.valueOf(aVar.type), cVar);
        a(aVar.type, aVar.So, cVar);
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.components.core.r.l.pS().a(this);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }
}
