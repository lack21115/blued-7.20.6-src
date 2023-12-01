package com.anythink.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationBidManager;
import com.anythink.core.common.e.ah;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f6439a;
    private final String b = getClass().getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<String, ConcurrentHashMap<String, aj>> f6440c = new ConcurrentHashMap<>();

    private a() {
    }

    public static a a() {
        if (f6439a == null) {
            synchronized (a.class) {
                try {
                    if (f6439a == null) {
                        f6439a = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6439a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bc, code lost:
        if (com.anythink.core.common.k.g.a(r11.e().getUnitGroupInfo()) < com.anythink.core.common.k.g.a(r10.e().getUnitGroupInfo())) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.anythink.core.common.e.b> a(java.lang.String r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.a.a(java.lang.String, boolean):java.util.List");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0080 -> B:5:0x0032). Please submit an issue!!! */
    private static void a(ATBaseAdAdapter aTBaseAdAdapter, String str, String str2, com.anythink.core.c.d dVar, ai aiVar, int i, Map<String, Object> map) {
        Map<String, Object> c2 = v.a().c(str2);
        int[] iArr = {0};
        if (c2.containsKey(ah.O)) {
            try {
                iArr[0] = ((Integer) c2.get(ah.O)).intValue();
            } catch (Throwable th) {
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aiVar.c());
        com.anythink.core.common.e.e a2 = com.anythink.core.common.k.s.a(str, str2, "", dVar, sb.toString(), 1, 0, iArr[0], map);
        com.anythink.core.common.k.s.a(a2, aiVar, i, true);
        com.anythink.core.common.k.s.a(aTBaseAdAdapter, a2, aiVar);
        a2.q = 3;
        a2.g(aTBaseAdAdapter.getNetworkPlacementId());
        aTBaseAdAdapter.setRefresh(false);
    }

    private static void a(String str, com.anythink.core.common.e.b bVar) {
        try {
            ai unitGroupInfo = bVar.e().getUnitGroupInfo();
            com.anythink.core.common.e.m N = unitGroupInfo.N();
            if (N != null) {
                com.anythink.core.common.e.e h = bVar.h();
                ai c2 = com.anythink.core.b.f.a().c(str);
                double a2 = com.anythink.core.common.k.g.a(c2);
                com.anythink.core.common.e.r rVar = new com.anythink.core.common.e.r();
                rVar.f6674a = 1;
                rVar.b = a2;
                rVar.e = h;
                rVar.f6675c = c2;
                rVar.d = unitGroupInfo;
                N.a(rVar, true);
            }
        } catch (Throwable th) {
        }
    }

    private static void a(JSONArray jSONArray, int i, String str, int i2, String str2, boolean z, int i3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("priority", i);
            jSONObject.put("unit_id", str);
            jSONObject.put("nw_firm_id", i2);
            jSONObject.put("nw_ver", str2);
            jSONObject.put("result", z ? 1 : 0);
            if (i3 != -1) {
                jSONObject.put("reason", i3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jSONArray.put(jSONObject);
    }

    public static void b(String str, ai aiVar) {
        if (aiVar == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("Clean own ad cache :");
        sb.append(aiVar.t());
        sb.append("|||");
        sb.append(aiVar.l());
        sb.append("|||");
        sb.append(aiVar.c());
        int l = aiVar.l();
        if (l != 3) {
            if (l == 4) {
                com.anythink.core.basead.b.a();
                Context g = com.anythink.core.common.b.n.a().g();
                com.anythink.core.basead.b.a();
                com.anythink.core.basead.b.b(g, com.anythink.core.basead.b.a(str, aiVar.t(), aiVar.c()));
                return;
            } else if (l != 7) {
                return;
            }
        }
        com.anythink.core.common.e.m N = aiVar.N();
        com.anythink.core.b.f.a().a(aiVar.t());
        com.anythink.core.b.f.a();
        com.anythink.core.b.f.b(aiVar.t());
        if (N == null || TextUtils.isEmpty(N.token)) {
            return;
        }
        N.b();
        com.anythink.core.common.a.a.a().b(com.anythink.core.common.b.n.a().g(), N.token);
    }

    public final aj a(String str, int i, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list, long j) {
        aj ajVar;
        synchronized (v.a().a(str)) {
            ConcurrentHashMap<String, aj> concurrentHashMap = this.f6440c.get(str);
            ai unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
            String t = aTBaseAdAdapter.getUnitGroupInfo().t();
            ConcurrentHashMap<String, aj> concurrentHashMap2 = concurrentHashMap;
            if (concurrentHashMap == null) {
                concurrentHashMap2 = new ConcurrentHashMap<>();
                this.f6440c.put(str, concurrentHashMap2);
            }
            aj ajVar2 = concurrentHashMap2.get(t);
            if (ajVar2 == null) {
                aj ajVar3 = new aj();
                ajVar3.f6636a = i;
                ajVar3.b = aTBaseAdAdapter.getTrackingInfo().X();
                concurrentHashMap2.put(t, ajVar3);
                ajVar = ajVar3;
            } else {
                ajVar2.f6636a = i;
                ajVar2.b = aTBaseAdAdapter.getTrackingInfo().X();
                ajVar = ajVar2;
            }
            com.anythink.core.common.e.b a2 = ajVar.a();
            if (a2 == null || !TextUtils.equals(w.a().b(str), a2.h().X())) {
                if (list == null || list.size() <= 0) {
                    com.anythink.core.common.e.b bVar = new com.anythink.core.common.e.b();
                    bVar.b(i);
                    bVar.a(aTBaseAdAdapter);
                    bVar.c(System.currentTimeMillis());
                    bVar.b(j);
                    bVar.a(aTBaseAdAdapter.getTrackingInfo().X());
                    bVar.a(unitGroupInfo.A());
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    ajVar.a(arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (BaseAd baseAd : list) {
                        baseAd.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().N());
                        com.anythink.core.common.e.b bVar2 = new com.anythink.core.common.e.b();
                        bVar2.b(i);
                        bVar2.a(aTBaseAdAdapter);
                        bVar2.a(baseAd);
                        bVar2.c(System.currentTimeMillis());
                        bVar2.b(j);
                        bVar2.a(aTBaseAdAdapter.getTrackingInfo().X());
                        bVar2.a(unitGroupInfo.A());
                        arrayList2.add(bVar2);
                    }
                    ajVar.a(arrayList2);
                }
                return ajVar;
            }
            return ajVar;
        }
    }

    public final com.anythink.core.common.e.b a(Context context, String str) {
        synchronized (v.a().a(str)) {
            List<com.anythink.core.common.e.b> a2 = a(context, str, false, false, false, null);
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            return a2.get(0);
        }
    }

    public final com.anythink.core.common.e.b a(Context context, String str, boolean z, boolean z2, Map<String, Object> map) {
        synchronized (v.a().a(str)) {
            List<com.anythink.core.common.e.b> a2 = a(context, str, z, z2, false, map);
            if (a2 == null || a2.size() <= 0) {
                return null;
            }
            return a2.get(0);
        }
    }

    public final com.anythink.core.common.e.b a(String str, ai aiVar) {
        com.anythink.core.common.e.m a2;
        ConcurrentHashMap<String, aj> concurrentHashMap;
        if (((aiVar.l() == 3 || aiVar.l() == 7) && ((a2 = com.anythink.core.b.f.a().a(aiVar)) == null || a2.a())) || (concurrentHashMap = this.f6440c.get(str)) == null) {
            return null;
        }
        aj ajVar = concurrentHashMap.get(aiVar.t());
        com.anythink.core.common.e.b a3 = ajVar != null ? ajVar.a() : null;
        if (a3 == null || !a3.j()) {
            if (a3 != null) {
                a(str, a3);
                a3.k();
                return null;
            }
            return null;
        }
        return a3;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x03d3 A[Catch: all -> 0x06fa, TRY_ENTER, TRY_LEAVE, TryCatch #3 {, blocks: (B:7:0x0018, B:8:0x001b, B:11:0x0052, B:14:0x0055, B:16:0x006b, B:18:0x0073, B:21:0x007e, B:23:0x0089, B:25:0x0099, B:30:0x00aa, B:32:0x00b6, B:34:0x00ce, B:36:0x00da, B:38:0x00e0, B:39:0x00ea, B:41:0x00f6, B:42:0x010e, B:44:0x0120, B:45:0x0138, B:47:0x0141, B:57:0x016a, B:60:0x0181, B:83:0x0282, B:89:0x0296, B:92:0x02a5, B:116:0x033f, B:117:0x0362, B:119:0x0389, B:122:0x03b0, B:123:0x03bf, B:126:0x03c3, B:127:0x03d3, B:128:0x03eb, B:61:0x018b, B:65:0x01a3, B:67:0x01e4, B:71:0x020f, B:74:0x022b, B:75:0x0237, B:78:0x023b, B:79:0x024b, B:82:0x026f, B:49:0x014b, B:49:0x014b, B:50:0x014e, B:52:0x015a, B:129:0x0403, B:132:0x0420, B:134:0x042a, B:136:0x0435, B:138:0x0440, B:141:0x0444, B:143:0x0451, B:145:0x045b, B:148:0x0470, B:150:0x0484, B:154:0x04b2, B:156:0x04c8, B:157:0x04e2, B:160:0x04e6, B:168:0x0505, B:172:0x0514, B:174:0x0526, B:176:0x0531, B:178:0x0539, B:180:0x054d, B:185:0x0562, B:214:0x068d, B:219:0x0695, B:223:0x06ba, B:226:0x06d9, B:228:0x06f7, B:164:0x04f5), top: B:281:0x0018 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:236:0x0700 -> B:281:0x0018). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.e.b> a(android.content.Context r13, java.lang.String r14, boolean r15, boolean r16, boolean r17, java.util.Map<java.lang.String, java.lang.Object> r18) {
        /*
            Method dump skipped, instructions count: 1950
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.a.a(android.content.Context, java.lang.String, boolean, boolean, boolean, java.util.Map):java.util.List");
    }

    public final void a(final Context context, final com.anythink.core.common.e.b bVar) {
        final ATBaseAdAdapter e = bVar.e();
        final com.anythink.core.common.e.e h = bVar.h();
        ai unitGroupInfo = e != null ? e.getUnitGroupInfo() : null;
        if (h != null) {
            v.a().b(h.W()).a(h.X(), unitGroupInfo != null ? com.anythink.core.common.k.g.a(unitGroupInfo) : 0.0d, unitGroupInfo);
            b(h.W(), unitGroupInfo);
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.a.a.a(context).a(h.Y(), h.W(), h.x());
                    com.anythink.core.a.c.a();
                    com.anythink.core.a.c.a(h.W());
                    com.anythink.core.a.c.a().a(h.W(), h.x());
                    a.this.a(h.W(), h.x(), bVar);
                    MediationBidManager b = com.anythink.core.b.f.a().b();
                    if (b != null) {
                        b.notifyWinnerDisplay(h.W(), e.getUnitGroupInfo());
                    }
                }
            });
        }
    }

    public final void a(String str, String str2) {
        aj remove;
        synchronized (v.a().a(str)) {
            ConcurrentHashMap<String, aj> concurrentHashMap = this.f6440c.get(str);
            if (concurrentHashMap != null && concurrentHashMap.size() > 0 && (remove = concurrentHashMap.remove(str2)) != null) {
                remove.c();
            }
        }
    }

    public final void a(String str, String str2, com.anythink.core.c.d dVar) {
        com.anythink.core.common.e.b a2;
        synchronized (v.a().a(str)) {
            ConcurrentHashMap<String, aj> concurrentHashMap = this.f6440c.get(str);
            if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                Iterator<Map.Entry<String, aj>> it = concurrentHashMap.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    aj value = it.next().getValue();
                    if (value != null && (a2 = value.a()) != null) {
                        if (!a2.j()) {
                            a(str, a2);
                            a2.k();
                        } else if (!a2.b().equals(str2)) {
                            com.anythink.core.common.e.e N = a2.e().getTrackingInfo().N();
                            N.v = str2;
                            N.q = 4;
                            com.anythink.core.common.k.s.a(N, dVar);
                            com.anythink.core.common.j.c.a(N, a2.b());
                            value.a(N);
                        }
                    }
                }
            }
        }
    }

    public final void a(String str, String str2, com.anythink.core.common.e.b bVar) {
        aj ajVar;
        synchronized (v.a().a(str)) {
            if (bVar == null) {
                return;
            }
            ConcurrentHashMap<String, aj> concurrentHashMap = this.f6440c.get(str);
            if (concurrentHashMap != null && concurrentHashMap.size() > 0 && (ajVar = concurrentHashMap.get(str2)) != null) {
                ajVar.a(bVar);
                if (!ajVar.d()) {
                    concurrentHashMap.remove(str2);
                }
            }
        }
    }
}
