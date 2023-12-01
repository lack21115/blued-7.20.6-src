package com.alibaba.mtl.appmonitor.d;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/d/d.class */
public class d extends h {
    private int o;
    private int p;

    public d(String str, int i, int i2) {
        super(str, 0);
        this.o = this.n;
        this.p = this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.mtl.appmonitor.d.a
    public void a(JSONObject jSONObject) {
        super.a((d) jSONObject);
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
            com.alibaba.mtl.log.e.i.a("AlarmModuleSampling", "[updateSelfSampling]", jSONObject, "successSampling:", valueOf, "failSampling");
        } catch (Exception e) {
        }
    }

    public boolean a(int i, String str, Boolean bool, Map<String, String> map) {
        i iVar;
        com.alibaba.mtl.log.e.i.a("AlarmModuleSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.o), "failSampling:", Integer.valueOf(this.p));
        return (this.p == null || (iVar = this.p.get(str)) == null || !(iVar instanceof e)) ? a(i, bool.booleanValue()) : ((e) iVar).a(i, bool, map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.h
    public /* bridge */ /* synthetic */ boolean a(int i, String str, Map map) {
        return super.a(i, str, map);
    }

    protected boolean a(int i, boolean z) {
        return z ? i < this.o : i < this.p;
    }

    @Override // com.alibaba.mtl.appmonitor.d.h
    public void b(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("monitorPoints");
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
                String string = jSONObject2.getString("monitorPoint");
                if (com.alibaba.mtl.appmonitor.f.b.c(string)) {
                    i iVar = this.p.get(string);
                    e eVar = iVar;
                    if (iVar == null) {
                        eVar = new e(string, this.o, this.p);
                        this.p.put(string, eVar);
                    }
                    eVar.b(jSONObject2);
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
        }
    }
}
