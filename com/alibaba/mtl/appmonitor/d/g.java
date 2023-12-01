package com.alibaba.mtl.appmonitor.d;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/g.class */
public class g extends a<JSONObject> {
    private com.alibaba.mtl.appmonitor.a.f e;
    protected Map<String, h> o;
    protected int q;

    public g(com.alibaba.mtl.appmonitor.a.f fVar, int i) {
        super(i);
        this.q = -1;
        this.e = fVar;
        this.o = Collections.synchronizedMap(new HashMap());
    }

    public boolean a(int i, String str, String str2, Map<String, String> map) {
        h hVar;
        Map<String, h> map2 = this.o;
        return (map2 == null || (hVar = map2.get(str)) == null) ? i < this.n : hVar.a(i, str2, map);
    }

    public void b(JSONObject jSONObject) {
        a((g) jSONObject);
        c(jSONObject);
        this.o.clear();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("metrics");
            if (optJSONArray == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    return;
                }
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                String optString = jSONObject2.optString("module");
                if (com.alibaba.mtl.appmonitor.f.b.c(optString)) {
                    h hVar = this.o.get(optString);
                    h hVar2 = hVar;
                    if (hVar == null) {
                        hVar2 = new h(optString, this.n);
                        this.o.put(optString, hVar2);
                    }
                    hVar2.b(jSONObject2);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(JSONObject jSONObject) {
        com.alibaba.mtl.log.e.i.a("EventTypeSampling", "[updateEventTypeTriggerCount]", this, jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            int optInt = jSONObject.optInt("cacheCount");
            if (optInt <= 0 || this.e == null) {
                return;
            }
            this.e.b(optInt);
        } catch (Throwable th) {
            com.alibaba.mtl.log.e.i.a("EventTypeSampling", "updateTriggerCount", th);
        }
    }

    public void setSampling(int i) {
        this.n = i;
    }
}
