package com.alibaba.mtl.log.a;

import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/a/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f4481a = new d();
    private String S;
    private Map<String, c> s = Collections.synchronizedMap(new HashMap());

    public static d a() {
        return f4481a;
    }

    public Map<String, c> b() {
        return this.s;
    }

    public void b(String str) {
        JSONObject jSONObject;
        i.a("HostConfigMgr", "host config:" + str);
        if (str != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("content");
                if (jSONObject3 != null && (jSONObject = jSONObject3.getJSONObject("hosts")) != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next != null) {
                            c cVar = new c();
                            JSONObject jSONObject4 = jSONObject.getJSONObject(next);
                            if (jSONObject4 != null) {
                                cVar.R = next.substring(1);
                                cVar.Q = jSONObject4.getString("host");
                                JSONArray jSONArray = jSONObject4.getJSONArray("eids");
                                if (jSONArray != null) {
                                    cVar.f4480a = new ArrayList<>();
                                    int i = 0;
                                    while (true) {
                                        int i2 = i;
                                        if (i2 >= jSONArray.length()) {
                                            break;
                                        }
                                        cVar.f4480a.add(jSONArray.getString(i2));
                                        i = i2 + 1;
                                    }
                                }
                            }
                            Map<String, c> map = this.s;
                            map.put(cVar.R + "", cVar);
                        }
                    }
                }
                this.S = jSONObject2.getString("timestamp");
            } catch (Throwable th) {
            }
        }
    }
}
