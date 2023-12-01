package com.tencent.qimei.o;

import com.tencent.qimei.o.d;
import com.tencent.qimei.o.m;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/c.class */
public class c implements com.tencent.qimei.c.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f24677a;

    public c(d dVar) {
        this.f24677a = dVar;
    }

    @Override // com.tencent.qimei.c.d
    public void a(int i) {
        String str;
        d.a aVar;
        boolean z;
        String str2;
        str = this.f24677a.f24679c;
        com.tencent.qimei.k.a.b("SDK_INIT", "OD 初始化完成(appKey: %s)，结果:%s", str, Integer.valueOf(i));
        aVar = this.f24677a.j;
        u uVar = (u) aVar;
        if (uVar.d()) {
            w a2 = w.a(uVar.g);
            String b = a2.b();
            if (b.isEmpty()) {
                a2.a();
            } else {
                long b2 = com.tencent.qimei.i.f.a(a2.b).b("t_s_t");
                if (0 == b2) {
                    z = false;
                } else {
                    z = false;
                    if (com.tencent.qimei.c.a.c() > b2) {
                        z = true;
                    }
                }
                if (z) {
                    try {
                        JSONObject jSONObject = new JSONObject(b);
                        String optString = jSONObject.optString(m.a.KEY_ENCRYPT_KEY.W);
                        String optString2 = jSONObject.optString(m.a.KEY_PARAMS.W);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(m.a.KEY_PARAMS_APP_KEY.W, a2.b);
                        jSONObject2.put(m.a.KEY_ENCRYPT_KEY.W, optString);
                        jSONObject2.put(m.a.KEY_PARAMS.W, optString2);
                        str2 = jSONObject2.toString();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        str2 = "";
                    }
                    a2.c(m.f24691a.a(com.tencent.qimei.j.a.a(), a2.b, com.tencent.qimei.a.a.i(a2.b), str2));
                } else if (com.tencent.qimei.a.a.a(com.tencent.qimei.i.f.a(a2.b).b("t_s_t"))) {
                    a2.a();
                }
            }
        }
        uVar.e();
        uVar.getQimei(new t(uVar));
    }
}
