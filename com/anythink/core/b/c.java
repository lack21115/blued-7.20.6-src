package com.anythink.core.b;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.al;
import com.anythink.core.common.e.m;
import com.anythink.core.common.k.t;
import com.anythink.core.common.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/c.class */
public final class c extends e {
    String a;
    List<ai> b;
    List<ai> c;

    public c(com.anythink.core.common.e.a aVar) {
        super(aVar);
        this.a = com.anythink.core.common.k.g.a(aVar.a, this.l, this.m, aVar.e, 0).toString();
        if (aVar.j == null) {
            this.b = new ArrayList(4);
            this.c = new ArrayList(1);
            return;
        }
        this.b = new ArrayList(aVar.j);
        this.c = new ArrayList(aVar.j);
    }

    private void a(JSONArray jSONArray) {
        if (this.d.x == null || !this.d.x.booleanValue() || this.d.i == null) {
            return;
        }
        int size = this.d.i.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            ai aiVar = this.d.i.get(i2);
            if (t.a(this.m, aiVar)) {
                jSONArray.put(new al.a(aiVar).a());
            }
            i = i2 + 1;
        }
    }

    private void a(JSONArray jSONArray, JSONArray jSONArray2) {
        List<ai> list;
        List<ai> list2 = this.b;
        if (list2 != null) {
            int size = list2.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                ai aiVar = list2.get(i2);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_SOURCE_ID, aiVar.t());
                    jSONObject.put("price", aiVar.x());
                    m N = aiVar.N();
                    if (N != null) {
                        jSONObject.put("tp_bid_id", N.g);
                    }
                    jSONObject.put(l.am, aiVar.ag());
                    jSONArray2.put(jSONObject);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                i = i2 + 1;
            }
        }
        if (this.d.x == null || !this.d.x.booleanValue() || (list = this.c) == null) {
            return;
        }
        for (ai aiVar2 : list) {
            if (t.a(this.m, aiVar2)) {
                jSONArray.put(new al.a(aiVar2).a());
            }
        }
    }

    private String e() {
        if (this.d.m) {
            JSONArray jSONArray = new JSONArray();
            if (this.q != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.AD_SOURCE_ID, this.q.k);
                    jSONObject.put("tp_bid_id", this.q.g);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        }
        return "[]";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.b.e, com.anythink.core.b.d
    public final void a(ai aiVar, com.anythink.core.common.e.l lVar, long j) {
        super.a(aiVar, lVar, j);
        if (aiVar.aa()) {
            return;
        }
        com.anythink.core.common.k.g.a(this.b, aiVar, false);
    }

    @Override // com.anythink.core.b.e
    protected final void a(List<JSONObject> list, com.anythink.core.common.g.i iVar) {
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        a(jSONArray, jSONArray2);
        a(jSONArray);
        com.anythink.core.b.a.b bVar = new com.anythink.core.b.a.b();
        bVar.a = this.a;
        bVar.b = jSONArray2.toString();
        bVar.c = e();
        bVar.f = this.d.n.ar();
        if (this.d.x != null && this.d.x.booleanValue()) {
            if (this.d.w != null) {
                bVar.d = this.d.w.a().toString();
            }
            bVar.e = jSONArray.toString();
        }
        bVar.g = this.d.n.e();
        com.anythink.core.b.a.a aVar = new com.anythink.core.b.a.a(this.n, this.m, this.l, list, 0);
        aVar.a(bVar);
        aVar.a(0, iVar);
    }

    @Override // com.anythink.core.b.e
    protected final String b() {
        return this.d.l;
    }
}
