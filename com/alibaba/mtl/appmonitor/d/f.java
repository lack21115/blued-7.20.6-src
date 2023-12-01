package com.alibaba.mtl.appmonitor.d;

import com.umeng.analytics.pro.bh;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/f.class */
public class f extends g {
    String TAG;
    private int o;
    private int p;

    public f(com.alibaba.mtl.appmonitor.a.f fVar, int i) {
        super(fVar, i);
        this.TAG = "AlarmSampling";
        this.o = 0;
        this.p = 0;
        this.o = i;
        this.p = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.mtl.appmonitor.d.a
    public void a(JSONObject jSONObject) {
        super.a((f) jSONObject);
        this.o = this.n;
        this.p = this.n;
        try {
            Integer valueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (valueOf != null) {
                this.o = valueOf.intValue();
            }
            Integer valueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (valueOf2 != null) {
                this.p = valueOf2.intValue();
            }
        } catch (Exception e) {
        }
    }

    public boolean a(int i, String str, String str2, Boolean bool, Map<String, String> map) {
        h hVar;
        boolean z = false;
        com.alibaba.mtl.log.e.i.a(this.TAG, "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.o), "failSampling:" + this.p);
        if (this.o == null || (hVar = this.o.get(str)) == null || !(hVar instanceof d)) {
            if (bool.booleanValue()) {
                if (i < this.o) {
                    z = true;
                }
                return z;
            }
            boolean z2 = false;
            if (i < this.p) {
                z2 = true;
            }
            return z2;
        }
        return ((d) hVar).a(i, str2, bool, map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public /* bridge */ /* synthetic */ boolean a(int i, String str, String str2, Map map) {
        return super.a(i, str, str2, map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public void b(JSONObject jSONObject) {
        a(jSONObject);
        c(jSONObject);
        this.o.clear();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("metrics");
            if (jSONArray == null) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString(bh.e);
                if (com.alibaba.mtl.appmonitor.f.b.c(string)) {
                    h hVar = this.o.get(string);
                    d dVar = hVar;
                    if (hVar == null) {
                        dVar = new d(string, this.o, this.p);
                        this.o.put(string, dVar);
                    }
                    dVar.b(jSONObject2);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
        }
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public void setSampling(int i) {
        super.setSampling(i);
        this.o = i;
        this.p = i;
    }
}
