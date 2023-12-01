package com.anythink.core.b;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.c.k;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.l;
import com.anythink.core.common.e.m;
import com.anythink.core.common.e.r;
import com.anythink.core.common.k.s;
import com.anythink.core.common.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/d.class */
public abstract class d {
    protected com.anythink.core.common.e.a d;
    protected boolean e;

    /* renamed from: a  reason: collision with root package name */
    private final String f6364a = getClass().getSimpleName() + ":";
    protected AtomicBoolean f = new AtomicBoolean(false);

    public d(com.anythink.core.common.e.a aVar) {
        this.d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static JSONArray a(List<ai> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (ai aiVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(k.a.d, aiVar.c());
                jSONObject.put("ad_source_id", aiVar.t());
                jSONObject.put("content", aiVar.g());
                if (!TextUtils.isEmpty(aiVar.z())) {
                    jSONObject.put("error", aiVar.z());
                }
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Exception e) {
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(ai aiVar, String str, long j, int i) {
        aiVar.a(j);
        aiVar.a(0.0d);
        aiVar.d(0.0d);
        aiVar.g(i);
        aiVar.b();
        if (TextUtils.isEmpty(str)) {
            aiVar.h("bid error");
        } else {
            aiVar.h(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static JSONArray b(List<JSONObject> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (JSONObject jSONObject : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(k.a.d, 67);
                if (jSONObject.has("unit_ids")) {
                    jSONObject2.put("unit_ids", jSONObject.get("unit_ids"));
                }
                jSONArray.put(jSONObject2);
            }
            return jSONArray;
        } catch (Exception e) {
            return jSONArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final double a(double d, ai aiVar) {
        double d2;
        double p;
        if (aiVar.ad() == null) {
            return d;
        }
        if (aiVar.ad() == ATAdConst.CURRENCY.RMB) {
            d2 = d;
            p = this.d.n.p();
        } else if (aiVar.ad() != ATAdConst.CURRENCY.RMB_CENT) {
            return d;
        } else {
            d2 = d / 100.0d;
            p = this.d.n.p();
        }
        return d2 * p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final double a(ai aiVar) {
        double d = 1.0d;
        if (aiVar.ad() == null) {
            return 1.0d;
        }
        if (aiVar.ad() == ATAdConst.CURRENCY.RMB_CENT) {
            return (1.0d / this.d.n.p()) * 100.0d;
        }
        if (aiVar.ad() == ATAdConst.CURRENCY.RMB) {
            d = 1.0d / this.d.n.p();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i, l lVar, double d) {
        double d2;
        if (i != 28) {
            return;
        }
        JSONObject f = this.d.n.f();
        double d3 = 0.95d;
        if (f != null) {
            double optDouble = f.optDouble(String.valueOf(i));
            d3 = 0.95d;
            if (optDouble > 0.0d) {
                d3 = 0.95d;
                if (optDouble <= 1.0d) {
                    d3 = optDouble;
                }
            }
        }
        double d4 = lVar.originPrice * d3;
        ArrayList arrayList = new ArrayList(5);
        List<ai> b = w.a().b(this.d.d, this.d.f6612c);
        if (b != null) {
            arrayList.addAll(b);
        }
        Iterator<E> it = arrayList.iterator();
        while (true) {
            d2 = d4;
            if (!it.hasNext()) {
                break;
            }
            double a2 = com.anythink.core.common.k.g.a((ai) it.next());
            if (a2 < lVar.originPrice) {
                d2 = Math.max(d4, a2);
                break;
            }
        }
        double max = Math.max(d2, d);
        double random = max + (Math.random() * (lVar.originPrice - max));
        lVar.setPrice(random);
        lVar.setSortPrice(random);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(com.anythink.core.b.b.a aVar);

    protected abstract void a(ai aiVar, l lVar, long j);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.core.common.e.ai r11, com.anythink.core.common.e.m r12) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.b.d.a(com.anythink.core.common.e.ai, com.anythink.core.common.e.m):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(ai aiVar, String str, int i) {
        return a(aiVar, str, i, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(ai aiVar, String str, int i, int i2) {
        m a2 = f.a().a(aiVar);
        if (a2 != null && !a2.a()) {
            aiVar.a(a2, 0, i, i2);
            aiVar.h(str);
            return true;
        } else if (a2 != null) {
            try {
                com.anythink.core.common.e.e a3 = s.a(this.d.f6612c, this.d.d, "", this.d.n, "", 1, 0, 0, this.d.b != null ? this.d.b.g : null);
                r rVar = new r();
                rVar.f6674a = 1;
                rVar.b = a2.getSortPrice();
                rVar.e = a3;
                rVar.f6675c = aiVar;
                rVar.d = aiVar;
                a2.a(rVar, true);
                return false;
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public final boolean c() {
        return this.f.get();
    }
}
