package com.alibaba.mtl.appmonitor.d;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/i.class */
class i extends a<JSONObject> {
    protected List<c> e;
    private String p;

    public i(String str, int i) {
        super(i);
        this.p = str;
    }

    public boolean a(int i, Map<String, String> map) {
        List<c> list = this.e;
        if (list != null && map != null) {
            for (c cVar : list) {
                Boolean a = cVar.a(i, map);
                if (a != null) {
                    return a.booleanValue();
                }
            }
        }
        return a(i);
    }

    public void b(JSONObject jSONObject) {
        a((i) jSONObject);
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("extra");
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
                c cVar = new c(this.n);
                if (this.e == null) {
                    this.e = new ArrayList();
                }
                this.e.add(cVar);
                cVar.b(jSONObject2);
                i = i2 + 1;
            }
        } catch (Exception e) {
        }
    }
}
