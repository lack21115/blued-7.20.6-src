package com.anythink.core.common.k;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.common.e.ae;
import com.anythink.core.common.e.ai;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/s.class */
public final class s {
    public static com.anythink.core.common.e.e a(ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.e.e eVar, ai aiVar) {
        aTBaseAdAdapter.setUnitGroupInfo(aiVar);
        boolean z = true;
        if (eVar.F() != 1) {
            z = false;
        }
        aTBaseAdAdapter.setRefresh(z);
        try {
            eVar.u = aTBaseAdAdapter.getNetworkSDKVersion();
        } catch (Throwable th) {
        }
        if (TextUtils.isEmpty(eVar.T())) {
            eVar.v(aTBaseAdAdapter.getNetworkName());
        }
        eVar.e(aTBaseAdAdapter.getClass().getName());
        aTBaseAdAdapter.setTrackingInfo(eVar);
        return eVar;
    }

    public static com.anythink.core.common.e.e a(String str, String str2, String str3, com.anythink.core.c.d dVar, String str4, int i, int i2, int i3, Map<String, Object> map) {
        com.anythink.core.common.e.e eVar = new com.anythink.core.common.e.e();
        eVar.x(str2);
        eVar.y(str);
        eVar.p(str3);
        eVar.m(str4);
        eVar.s(i);
        eVar.t(i2);
        eVar.r = 0;
        eVar.q = 2;
        eVar.s = 0;
        a(eVar, dVar);
        eVar.R();
        eVar.C(com.anythink.core.common.b.n.a().j());
        eVar.D(i3);
        a(map, eVar);
        return eVar;
    }

    public static void a(Context context, com.anythink.core.common.e.e eVar) {
        ae aeVar;
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, ae> a = com.anythink.core.a.a.a(context).a(Integer.parseInt(eVar.Y()));
        if (a != null) {
            Iterator<ae> it = a.values().iterator();
            i = 0;
            int i3 = 0;
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                ae next = it.next();
                i += next.c;
                i3 = i2 + next.d;
            }
            aeVar = a.get(eVar.W());
        } else {
            aeVar = null;
            i = 0;
            i2 = 0;
        }
        eVar.g(i + 1);
        eVar.h(i2 + 1);
        eVar.i((aeVar != null ? aeVar.c : 0) + 1);
        int i4 = 0;
        if (aeVar != null) {
            i4 = aeVar.d;
        }
        eVar.j(i4 + 1);
        new StringBuilder("Check cap waite time:").append(System.currentTimeMillis() - currentTimeMillis);
    }

    public static void a(com.anythink.core.common.e.e eVar, com.anythink.core.c.d dVar) {
        if (eVar == null || dVar == null) {
            return;
        }
        if (dVar.X() == Integer.parseInt("1")) {
            eVar.o("1");
        } else {
            eVar.o("0");
        }
        eVar.E(dVar.O());
        eVar.w(dVar.U());
        eVar.v(dVar.ae());
        eVar.z(String.valueOf(dVar.X()));
        eVar.j(dVar.K());
        eVar.k(dVar.J());
        eVar.c(dVar.x());
        eVar.d(dVar.y());
        eVar.b(dVar.I());
        eVar.a(dVar.L());
        eVar.c(dVar.M());
        eVar.a(dVar.k());
        eVar.b(dVar.l());
        eVar.t(dVar.c());
    }

    public static void a(com.anythink.core.common.e.e eVar, ai aiVar, int i, boolean z) {
        com.anythink.core.common.e.m N;
        String str;
        com.anythink.core.common.e.s e;
        ae.a a = z ? com.anythink.core.a.a.a(com.anythink.core.common.b.n.a().g()).a(eVar.W(), aiVar.t()) : null;
        eVar.c(aiVar.l());
        eVar.u(aiVar.c());
        eVar.l(aiVar.t());
        eVar.l(aiVar.C());
        eVar.m(aiVar.D());
        eVar.f(aiVar.U());
        eVar.o(i);
        eVar.n(aiVar.g());
        eVar.q(a != null ? a.e : 0);
        int i2 = 0;
        if (a != null) {
            i2 = a.d;
        }
        eVar.r(i2);
        if (!aiVar.M()) {
            eVar.d(0.0d);
            eVar.a(0.0d);
        } else if (aiVar.aa()) {
            com.anythink.core.common.e.m N2 = aiVar.N();
            if (N2 != null) {
                eVar.d(N2.o);
                eVar.a(N2.o);
            }
        } else {
            eVar.d(aiVar.x());
            eVar.a(aiVar.ag());
        }
        if (!aiVar.j()) {
            eVar.b(aiVar.J());
            String G = aiVar.G();
            String str2 = G;
            if (TextUtils.isEmpty(G)) {
                str2 = "publisher_defined";
            }
            eVar.i(str2);
        } else if (aiVar.V() != 2) {
            if (aiVar.aa()) {
                com.anythink.core.common.e.m N3 = aiVar.N();
                if (N3 != null) {
                    eVar.b(N3.o * eVar.g());
                    eVar.i(N3.p);
                }
            } else {
                eVar.b(aiVar.x() * eVar.g());
                eVar.i("exact");
            }
        }
        eVar.n(aiVar.i());
        eVar.f(aiVar.y());
        eVar.ao = aiVar.u();
        eVar.ap = aiVar.v();
        eVar.aq = aiVar.w();
        eVar.k(aiVar.F());
        eVar.e(aiVar.V());
        try {
            JSONObject jSONObject = new JSONObject(aiVar.g());
            JSONObject jSONObject2 = new JSONObject();
            if (35 == aiVar.c()) {
                String optString = jSONObject.optString("my_oid");
                com.anythink.core.c.d a2 = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(eVar.W());
                if (a2 != null && (e = a2.e(optString)) != null) {
                    jSONObject2.put("o_id", optString);
                    jSONObject2.put("c_id", e.q());
                }
            }
            if ("0".equals(eVar.Y()) && (3 == aiVar.l() || 7 == aiVar.l())) {
                String optString2 = jSONObject.optString("layout_type");
                if (!TextUtils.isEmpty(optString2)) {
                    str = optString2;
                    if (optString2.equals("0")) {
                    }
                    jSONObject2.put("tpl_type", str);
                }
                str = "2";
                jSONObject2.put("tpl_type", str);
            }
            if (28 == aiVar.c() && (N = aiVar.N()) != null) {
                jSONObject2.put("origin_price", N.originPrice);
            }
            eVar.q(jSONObject2.toString());
        } catch (Throwable th) {
        }
        com.anythink.core.common.e.m N4 = aiVar.N();
        eVar.c(N4 != null ? N4.g : "");
        eVar.w(aiVar.Y());
        eVar.v(aiVar.d());
    }

    public static void a(Map<String, Object> map, com.anythink.core.common.e.e eVar) {
        if (map != null) {
            Object obj = map.get(ATAdConst.KEY.CP_PLACEMENT_ID);
            if (obj != null) {
                eVar.u(obj.toString());
            }
            Object obj2 = map.get(ATAdConst.KEY.CP_LOAD_MODE);
            if (obj2 instanceof Integer) {
                eVar.B(Integer.parseInt(obj2.toString()));
            }
        }
    }
}
