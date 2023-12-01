package com.kwad.components.core.m;

import android.content.Context;
import com.kwad.components.core.l.kwai.b;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.t;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/m/a.class */
public final class a {
    private static boolean Oh = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.m.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/m/a$a.class */
    public static final class C0526a {
        private static final a Oj = new a();
    }

    protected a() {
    }

    private static q a(long j, AdTemplate adTemplate, String str) {
        return new q(j, adTemplate, str);
    }

    private static q b(long j, AdTemplate adTemplate) {
        return new q(j, adTemplate);
    }

    public static a pb() {
        return C0526a.Oj;
    }

    public static q v(long j) {
        return new q(j);
    }

    public final void N(AdTemplate adTemplate) {
        h.a2(b(10007L, adTemplate));
    }

    public final void O(AdTemplate adTemplate) {
        h.a2(b(10208L, adTemplate));
    }

    public final void P(AdTemplate adTemplate) {
        h.a2(b(10209L, adTemplate));
    }

    public final void a(int i, AdTemplate adTemplate, String str) {
        h.a2(a(i, adTemplate, str));
    }

    public final void a(b bVar) {
        q v = v(10215L);
        v.NY = bVar.NY;
        v.Oe = bVar.Oe;
        v.Of = bVar.Of;
        v.Og = bVar.Og;
        h.a2(v);
    }

    public final void a(AdTemplate adTemplate, int i, int i2) {
        q b = b(12006L, adTemplate);
        b.Tt = i;
        b.aiQ = i2;
        h.a2(b);
    }

    public final void a(AdTemplate adTemplate, long j, int i) {
        q b = b(104L, adTemplate);
        b.clickTime = l.cx(adTemplate);
        b.ajo = j;
        b.ajp = i;
        h.a2(b);
    }

    public final void a(AdTemplate adTemplate, long j, long j2, int i) {
        q b = b(10203L, adTemplate);
        b.Vl = j;
        b.blockDuration = j2;
        b.aiP = i;
        h.a2(b);
    }

    public final void a(AdTemplate adTemplate, String str, String str2) {
        q b = b(10003L, adTemplate);
        b.failUrl = str;
        b.errorMsg = str2;
        h.a2(b);
    }

    public final void a(SceneImpl sceneImpl, boolean z, String str) {
        q v = v(10216L);
        v.ajk = z;
        v.ajl = str;
        v.Ow = sceneImpl;
        h.a2(v);
    }

    public final void a(boolean z, List<Integer> list) {
        q v = v(10204L);
        v.ajk = z;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (Integer num : list) {
                jSONArray.put(num);
            }
            v.ajj = jSONArray;
        }
        h.a2(v);
    }

    public final void aB(int i) {
        q v = v(10104L);
        v.aja = i;
        h.a2(v);
    }

    public final void aC(int i) {
        q v = v(10107L);
        v.ajb = i;
        h.a2(v);
    }

    public final void ag(Context context) {
        q v = v(11L);
        JSONArray[] c2 = InstalledAppInfoManager.c(context, d.sD());
        v.aiT = c2[0];
        v.aiU = c2[1];
        h.a2(v);
    }

    public final void b(long j, int i) {
        if (d.uP()) {
            q v = v(20000L);
            v.timestamp = System.currentTimeMillis();
            v.ajJ = i;
            v.posId = j;
            v.ajK = 3034000;
            h.a2(v);
        }
    }

    public final void b(AdTemplate adTemplate, int i, int i2) {
        q b = b(10002L, adTemplate);
        b.xc();
        b.failUrl = com.kwad.sdk.core.response.a.d.bT(adTemplate) ? com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : com.kwad.sdk.core.response.a.d.cd(adTemplate);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put("extra", i2);
            b.errorMsg = jSONObject.toString();
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e);
        }
        h.a2(b);
    }

    public final void b(AdTemplate adTemplate, int i, String str) {
        q b = b(adTemplate.isPlayAgainData ? 12300 : 10109, adTemplate);
        b.ajb = 1;
        b.ajc = str;
        h.a2(b);
    }

    public final void b(AdTemplate adTemplate, String str, String str2) {
        q b = b(10005L, adTemplate);
        b.failUrl = com.kwad.sdk.core.response.a.d.bT(adTemplate) ? com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : com.kwad.sdk.core.response.a.d.cd(adTemplate);
        b.failUrl = str;
        b.errorMsg = str2;
        h.a2(b);
    }

    public final void c(AdTemplate adTemplate, int i, String str) {
        q b = b(107L, adTemplate);
        b.errorCode = i;
        b.errorMsg = str;
        h.a2(b);
    }

    public final void c(AdTemplate adTemplate, long j) {
        q b = b(10202L, adTemplate);
        b.aji = j;
        h.a2(b);
    }

    public final void c(JSONArray jSONArray) {
        q v = v(10200L);
        v.aje = jSONArray;
        h.a2(v);
    }

    public final void d(AdTemplate adTemplate, long j) {
        q b = b(10206L, adTemplate);
        b.ajy = j;
        h.a2(b);
    }

    public final void e(AdTemplate adTemplate, long j) {
        q b = b(10207L, adTemplate);
        b.ajz = j;
        h.a2(b);
    }

    public final void e(String str, String str2, boolean z) {
        q v = v(12200L);
        v.ajH = str;
        v.ajI = str2;
        h.a(v, z);
    }

    public final void e(JSONObject jSONObject, int i) {
        q v = v(10201L);
        t.putValue(jSONObject, "appChangeType", i);
        v.ajd = jSONObject;
        h.a2(v);
    }

    public final void f(AdTemplate adTemplate, int i) {
        q b = b(10108L, adTemplate);
        b.ajb = i;
        h.a2(b);
    }

    public final void g(AdTemplate adTemplate, int i) {
        if (d.uP()) {
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            q v = v(20000L);
            v.timestamp = System.currentTimeMillis();
            v.ajJ = i;
            v.trace = cb.trace;
            v.ajK = 3034000;
            v.posId = com.kwad.sdk.core.response.a.d.bU(adTemplate);
            h.a2(v);
        }
    }

    public final void pc() {
        if (Oh) {
            return;
        }
        Oh = true;
        g.execute(new aw() { // from class: com.kwad.components.core.m.a.1
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                q v = a.v(8L);
                v.ajA = f.tG();
                h.a2(v);
            }
        });
    }

    public final void pd() {
        h.a2(v(10101L));
    }

    public final void pe() {
        h.a2(v(10106L));
    }
}
