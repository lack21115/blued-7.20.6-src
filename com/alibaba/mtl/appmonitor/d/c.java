package com.alibaba.mtl.appmonitor.d;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/c.class */
public class c extends a<JSONObject> {
    private Map<String, b> n;

    public c(int i) {
        super(i);
        this.n = new HashMap();
    }

    public Boolean a(int i, Map<String, String> map) {
        Map<String, b> map2;
        if (map == null || (map2 = this.n) == null) {
            return null;
        }
        for (String str : map2.keySet()) {
            if (!this.n.get(str).b(map.get(str))) {
                return null;
            }
        }
        return Boolean.valueOf(a(i));
    }

    public void b(JSONObject jSONObject) {
        a((c) jSONObject);
    }
}
