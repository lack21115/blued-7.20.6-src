package com.anythink.core.b.d;

import com.anythink.core.c.d;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.e;
import com.anythink.core.common.l;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/d/a.class */
public class a {
    static final String a = a.class.getSimpleName();

    public static void a(final String str, final d dVar, final String str2, final int i, final List<ai> list, final long j, final int i2, final int i3) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                String str3 = a.a;
                JSONArray jSONArray = new JSONArray();
                e eVar = new e();
                eVar.x(String.this);
                eVar.y(str2);
                StringBuilder sb = new StringBuilder();
                sb.append(dVar.X());
                eVar.z(sb.toString());
                eVar.w(dVar.U());
                eVar.t(i);
                eVar.e(j);
                eVar.f(System.currentTimeMillis());
                eVar.E(dVar.O());
                eVar.v(dVar.ae());
                eVar.D(i2);
                eVar.q = i3;
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= list.size()) {
                        eVar.s(jSONArray.toString());
                        com.anythink.core.common.j.a.a(n.a().g()).a(11, eVar);
                        return;
                    }
                    ai aiVar = (ai) list.get(i5);
                    if (aiVar.l() != 7 && aiVar.j()) {
                        try {
                            int o = aiVar.o();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("sorttype", o);
                            jSONObject.put("unit_id", aiVar.t());
                            jSONObject.put("bidresult", aiVar.P());
                            jSONObject.put("bidprice", aiVar.M() ? String.valueOf(aiVar.x()) : "0");
                            jSONObject.put(l.am, aiVar.M() ? String.valueOf(aiVar.ag()) : "0");
                            jSONObject.put("nw_firm_id", String.valueOf(aiVar.c()));
                            jSONObject.put("tp_bid_id", aiVar.N() != null ? aiVar.N().g : null);
                            jSONObject.put("rl_bid_status", aiVar.O());
                            jSONObject.put("errormsg", aiVar.z());
                            jSONArray.put(jSONObject);
                        } catch (Exception e) {
                        }
                    }
                    i4 = i5 + 1;
                }
            }
        });
    }
}
