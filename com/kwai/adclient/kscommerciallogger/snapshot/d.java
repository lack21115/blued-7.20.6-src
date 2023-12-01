package com.kwai.adclient.kscommerciallogger.snapshot;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwai/adclient/kscommerciallogger/snapshot/d.class */
public class d {
    private final String aEN;
    private final LinkedHashMap<String, String> aEO = new LinkedHashMap<>();
    private final long time = System.nanoTime();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.aEN = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject Gf() {
        JSONObject jSONObject;
        synchronized (this) {
            jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.aEO.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                jSONObject.put("time", this.time);
                jSONObject.put("span_name", this.aEN);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
