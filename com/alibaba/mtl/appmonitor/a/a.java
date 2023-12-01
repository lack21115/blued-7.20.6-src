package com.alibaba.mtl.appmonitor.a;

import com.amap.api.maps.model.MyLocationStyle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/a/a.class */
public class a extends d {
    public Map<String, String> d;
    public Map<String, Integer> e;
    public int f = 0;
    public int g = 0;

    @Override // com.alibaba.mtl.appmonitor.a.d
    public JSONObject a() {
        JSONObject a;
        synchronized (this) {
            a = super.a();
            try {
                a.put("successCount", this.f);
                a.put("failCount", this.g);
                if (this.e != null) {
                    JSONArray jSONArray = (JSONArray) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
                    for (Map.Entry<String, Integer> entry : this.e.entrySet()) {
                        JSONObject jSONObject = (JSONObject) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.e.class, new Object[0]);
                        String key = entry.getKey();
                        jSONObject.put(MyLocationStyle.ERROR_CODE, key);
                        jSONObject.put("errorCount", entry.getValue());
                        if (this.d.containsKey(key)) {
                            jSONObject.put("errorMsg", this.d.get(key));
                        }
                        jSONArray.put(jSONObject);
                    }
                    a.put("errors", jSONArray);
                }
            } catch (Exception e) {
            }
        }
        return a;
    }

    public void a(String str, String str2) {
        synchronized (this) {
            if (com.alibaba.mtl.appmonitor.f.b.isBlank(str)) {
                return;
            }
            if (this.d == null) {
                this.d = new HashMap();
            }
            if (this.e == null) {
                this.e = new HashMap();
            }
            if (com.alibaba.mtl.appmonitor.f.b.c(str2)) {
                int i = 100;
                if (str2.length() <= 100) {
                    i = str2.length();
                }
                this.d.put(str, str2.substring(0, i));
            }
            if (this.e.containsKey(str)) {
                this.e.put(str, Integer.valueOf(this.e.get(str).intValue() + 1));
            } else {
                this.e.put(str, 1);
            }
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        synchronized (this) {
            super.clean();
            this.f = 0;
            this.g = 0;
            if (this.d != null) {
                this.d.clear();
            }
            if (this.e != null) {
                this.e.clear();
            }
        }
    }

    public void f() {
        synchronized (this) {
            this.f++;
        }
    }

    public void g() {
        synchronized (this) {
            this.g++;
        }
    }
}
