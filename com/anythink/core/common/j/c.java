package com.anythink.core.common.j;

import android.os.PowerManager;
import android.text.TextUtils;
import com.android.internal.util.cm.PowerMenuConstants;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.AdError;
import com.anythink.core.c.e;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.an;
import com.anythink.core.common.e.g;
import com.anythink.core.common.e.h;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.z;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/j/c.class */
public final class c {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 1;
    public static final int l = 2;
    public static final int m = 3;
    public static final int n = 4;
    public static final int o = 5;
    public static final int p = 0;

    public static void a() {
        h hVar = new h(null, null);
        hVar.a = "1004657";
        a(hVar);
    }

    public static void a(int i2, int i3, int i4, int i5) {
        h hVar = new h(null, String.valueOf(i5));
        hVar.a = "1004641";
        hVar.m = String.valueOf(i2);
        hVar.n = String.valueOf(i3);
        hVar.o = String.valueOf(i4);
        hVar.p = String.valueOf(i5);
        a(hVar);
    }

    public static void a(int i2, long j2, long j3, String str) {
        h hVar = new h(null, null);
        hVar.a = "1004644";
        hVar.e = str;
        hVar.m = String.valueOf(i2);
        hVar.n = String.valueOf(j2);
        hVar.o = String.valueOf(j3);
        hVar.p = String.valueOf(j3 - j2);
        a(hVar);
    }

    private static void a(int i2, long j2, long j3, String str, String str2) {
        h hVar = new h(null, null);
        hVar.a = "1004651";
        hVar.e = str;
        hVar.m = String.valueOf(i2);
        hVar.n = String.valueOf(j3 - j2);
        hVar.o = str2;
        a(hVar);
    }

    public static void a(ai aiVar, com.anythink.core.common.e.a aVar, long j2, boolean z, boolean z2) {
        h hVar = new h(String.valueOf(aVar.e), String.valueOf(aiVar.c()));
        hVar.a = "1004660";
        com.anythink.core.c.d dVar = aVar.n;
        hVar.b = aVar.c;
        hVar.d = aVar.d;
        hVar.g = String.valueOf(dVar != null ? Integer.valueOf(dVar.ae()) : "");
        hVar.l = String.valueOf(dVar != null ? Integer.valueOf(dVar.O()) : "");
        hVar.j = dVar != null ? dVar.U() : "";
        hVar.m = String.valueOf(aiVar.c());
        hVar.n = aiVar.t();
        hVar.o = z ? "1" : "2";
        hVar.p = String.valueOf(j2);
        hVar.q = z2 ? "1" : "2";
        String str = "";
        if (dVar != null) {
            try {
                str = dVar.c();
            } catch (Throwable th) {
            }
        }
        hVar.C = str;
        try {
            Object obj = aVar.b.g.get(ATAdConst.KEY.CP_PLACEMENT_ID);
            if (obj != null) {
                hVar.D = obj.toString();
            }
        } catch (Throwable th2) {
        }
        a(hVar);
    }

    public static void a(an anVar) {
        if (anVar == null) {
            return;
        }
        h hVar = new h(null, String.valueOf(anVar.a()));
        hVar.a = "1004667";
        hVar.m = String.valueOf(anVar.a());
        hVar.n = anVar.b();
        hVar.o = anVar.c();
        hVar.p = anVar.d();
        hVar.q = anVar.f();
        hVar.r = anVar.g();
        hVar.s = String.valueOf(anVar.h());
        hVar.t = anVar.i();
        hVar.b = anVar.e();
        hVar.g = anVar.j();
        hVar.l = anVar.k();
        hVar.d = anVar.l();
        String l2 = anVar.l();
        if (!TextUtils.isEmpty(l2)) {
            com.anythink.core.c.d a2 = e.a(n.a().g()).a(l2);
            hVar.j = a2 != null ? a2.U() : "";
        }
        a(hVar);
    }

    public static void a(com.anythink.core.common.e.e eVar) {
        try {
            h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
            hVar.a = "1004640";
            hVar.b = eVar.X();
            hVar.g = String.valueOf(eVar.I());
            hVar.l = String.valueOf(eVar.U());
            hVar.d = eVar.W();
            hVar.m = String.valueOf(eVar.H());
            hVar.n = eVar.x();
            hVar.o = String.valueOf(eVar.z());
            hVar.p = String.valueOf(eVar.J());
            hVar.q = String.valueOf(eVar.K());
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            hVar.A = eVar.Y();
            a(hVar);
        } catch (Throwable th) {
        }
    }

    public static void a(com.anythink.core.common.e.e eVar, int i2, AdError adError) {
        try {
            a(eVar.X(), eVar.W(), eVar.I(), eVar.F(), eVar.H(), eVar.x(), eVar.Y(), -1, i2, adError, eVar.v(), eVar.w(), 0L, eVar.U(), eVar.L(), eVar.q, eVar.P(), eVar.Q());
        } catch (Throwable th) {
        }
    }

    public static void a(com.anythink.core.common.e.e eVar, int i2, AdError adError, long j2) {
        try {
            a(eVar.X(), eVar.W(), eVar.I(), eVar.F(), eVar.H(), eVar.x(), eVar.Y(), eVar.z(), i2, adError, eVar.v(), eVar.w(), j2, eVar.U(), eVar.L(), eVar.q, eVar.P(), eVar.Q());
        } catch (Throwable th) {
        }
    }

    public static void a(com.anythink.core.common.e.e eVar, int i2, String str, double d2, String str2, String str3) {
        h hVar = new h(eVar.Y(), String.valueOf(i2));
        hVar.a = "1004668";
        hVar.d = eVar.W();
        hVar.m = String.valueOf(i2);
        hVar.n = str;
        hVar.o = String.valueOf(d2);
        hVar.p = str2;
        hVar.q = str3;
        hVar.j = eVar.V();
        hVar.g = String.valueOf(eVar.I());
        hVar.l = String.valueOf(eVar.U());
        hVar.C = eVar.P();
        hVar.D = eVar.Q();
        a(hVar);
    }

    public static void a(com.anythink.core.common.e.e eVar, int i2, String str, String str2) {
        try {
            h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
            hVar.a = "1004633";
            hVar.b = eVar.X();
            hVar.d = eVar.W();
            hVar.g = String.valueOf(eVar.I());
            hVar.k = String.valueOf(eVar.F());
            hVar.l = String.valueOf(eVar.U());
            hVar.m = String.valueOf(i2);
            hVar.n = str;
            hVar.q = str2;
            if (TextUtils.equals(str2, eVar.X())) {
                hVar.r = "0";
            } else {
                hVar.r = "1";
            }
            com.anythink.core.c.d a2 = e.a(n.a().g()).a(eVar.W());
            hVar.j = a2 != null ? a2.U() : "";
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            a(hVar);
        } catch (Throwable th) {
        }
    }

    public static void a(com.anythink.core.common.e.e eVar, AdError adError) {
        try {
            h hVar = new h(eVar.Y(), null);
            hVar.a = "1004630";
            hVar.b = eVar.X();
            hVar.d = eVar.W();
            hVar.l = String.valueOf(eVar.U());
            hVar.g = String.valueOf(eVar.I());
            hVar.k = String.valueOf(eVar.F());
            com.anythink.core.c.d a2 = e.a(n.a().g()).a(eVar.W());
            hVar.j = a2 != null ? a2.U() : "";
            if (adError != null) {
                hVar.m = adError.printStackTrace();
                hVar.n = adError.getCode();
            }
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            a(hVar);
        } catch (Throwable th) {
        }
    }

    public static void a(com.anythink.core.common.e.e eVar, AdError adError, Map<String, Object> map) {
        h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
        hVar.a = "1004636";
        hVar.b = eVar.X();
        hVar.d = eVar.W();
        hVar.g = String.valueOf(eVar.I());
        hVar.k = String.valueOf(eVar.F());
        hVar.l = String.valueOf(eVar.U());
        hVar.m = String.valueOf(eVar.H());
        hVar.n = eVar.x();
        hVar.o = String.valueOf(eVar.A());
        hVar.p = adError.getCode();
        hVar.q = adError.getPlatformCode();
        hVar.r = adError.getPlatformMSG();
        com.anythink.core.c.d a2 = e.a(n.a().g()).a(eVar.W());
        hVar.j = a2 != null ? a2.U() : "";
        hVar.A = eVar.Y();
        if (map != null) {
            try {
                if (map.containsKey("offer_id")) {
                    hVar.s = map.get("offer_id").toString();
                }
            } catch (Throwable th) {
            }
        }
        hVar.C = eVar.P();
        hVar.D = eVar.Q();
        a(hVar);
    }

    public static void a(com.anythink.core.common.e.e eVar, com.anythink.core.c.d dVar, String str, String str2) {
        try {
            h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
            hVar.a = "1004658";
            hVar.b = eVar.X();
            hVar.d = eVar.W();
            hVar.g = String.valueOf(eVar.I());
            hVar.k = String.valueOf(eVar.F());
            hVar.l = String.valueOf(eVar.U());
            hVar.j = dVar != null ? dVar.U() : "";
            hVar.m = String.valueOf(eVar.H());
            hVar.n = eVar.x();
            hVar.o = eVar.l();
            hVar.p = eVar.e();
            hVar.q = eVar.C;
            hVar.r = str;
            hVar.s = str2;
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            a(hVar);
        } catch (Throwable th) {
        }
    }

    public static void a(com.anythink.core.common.e.e eVar, ai aiVar, double d2, String str) {
        h hVar = new h(String.valueOf(eVar.Y()), String.valueOf(aiVar.c()));
        hVar.a = "1004659";
        hVar.b = eVar.X();
        hVar.d = eVar.W();
        hVar.g = String.valueOf(eVar.I());
        hVar.l = String.valueOf(eVar.U());
        hVar.j = eVar.V();
        hVar.m = String.valueOf(aiVar.c());
        hVar.n = aiVar.t();
        hVar.o = String.valueOf(d2);
        hVar.p = str;
        hVar.C = eVar.P();
        hVar.D = eVar.Q();
        a(hVar);
    }

    public static void a(com.anythink.core.common.e.e eVar, String str) {
        try {
            h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
            hVar.a = "1004639";
            hVar.b = eVar.X();
            hVar.d = eVar.W();
            hVar.l = String.valueOf(eVar.U());
            hVar.g = String.valueOf(eVar.I());
            hVar.m = String.valueOf(eVar.H());
            hVar.n = eVar.x();
            hVar.o = String.valueOf(eVar.z());
            hVar.p = str;
            hVar.A = eVar.Y();
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            a(hVar);
        } catch (Throwable th) {
        }
    }

    public static void a(com.anythink.core.common.e.e eVar, String str, String str2) {
        h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
        hVar.a = "1004669";
        hVar.b = eVar.X();
        hVar.d = eVar.W();
        hVar.m = String.valueOf(eVar.H());
        hVar.n = str;
        hVar.o = str2;
        hVar.j = eVar.V();
        hVar.g = String.valueOf(eVar.I());
        hVar.l = String.valueOf(eVar.U());
        hVar.C = eVar.P();
        hVar.D = eVar.Q();
        a(hVar);
    }

    public static void a(com.anythink.core.common.e.e eVar, boolean z) {
        h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
        hVar.a = "1004634";
        hVar.b = eVar.X();
        hVar.d = eVar.W();
        hVar.g = String.valueOf(eVar.I());
        hVar.k = String.valueOf(eVar.F());
        hVar.l = String.valueOf(eVar.U());
        hVar.m = String.valueOf(eVar.H());
        hVar.n = eVar.x();
        hVar.o = String.valueOf(eVar.A());
        hVar.p = z ? "1" : "0";
        hVar.q = String.valueOf(eVar.z);
        com.anythink.core.c.d a2 = e.a(n.a().g()).a(eVar.W());
        hVar.j = a2 != null ? a2.U() : "";
        hVar.A = eVar.Y();
        hVar.C = eVar.P();
        hVar.D = eVar.Q();
        a(hVar);
    }

    public static void a(final com.anythink.core.common.e.e eVar, final boolean z, final int i2, final int i3, final String str, final int i4, final String str2, final String str3, final String str4, final boolean z2, final String str5) {
        try {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    h hVar = new h(com.anythink.core.common.e.e.this.Y(), String.valueOf(com.anythink.core.common.e.e.this.H()));
                    hVar.a = "1004632";
                    hVar.b = com.anythink.core.common.e.e.this.X();
                    hVar.d = com.anythink.core.common.e.e.this.W();
                    hVar.g = String.valueOf(com.anythink.core.common.e.e.this.I());
                    hVar.k = String.valueOf(com.anythink.core.common.e.e.this.F());
                    hVar.l = String.valueOf(com.anythink.core.common.e.e.this.U());
                    hVar.m = z ? "1" : "0";
                    hVar.n = String.valueOf(i2);
                    hVar.o = String.valueOf(i3);
                    hVar.p = str;
                    hVar.q = String.valueOf(i4);
                    hVar.r = str2;
                    hVar.s = str3;
                    hVar.t = str4;
                    if (TextUtils.equals(str4, com.anythink.core.common.e.e.this.X())) {
                        hVar.u = "0";
                    } else {
                        hVar.u = "1";
                    }
                    if (z2) {
                        hVar.v = "1";
                    } else {
                        hVar.v = "0";
                    }
                    hVar.w = str5;
                    com.anythink.core.c.d a2 = e.a(n.a().g()).a(com.anythink.core.common.e.e.this.W());
                    hVar.j = a2 != null ? a2.U() : "";
                    hVar.A = com.anythink.core.common.e.e.this.Y();
                    hVar.C = com.anythink.core.common.e.e.this.P();
                    hVar.D = com.anythink.core.common.e.e.this.Q();
                    c.a(hVar);
                }
            });
        } catch (Exception e2) {
        }
    }

    public static void a(com.anythink.core.common.e.e eVar, boolean z, long j2, long j3, long j4) {
        try {
            h hVar = new h(eVar.Y(), String.valueOf(eVar.H()));
            hVar.a = "1004643";
            hVar.b = eVar.X();
            hVar.d = eVar.W();
            hVar.g = String.valueOf(eVar.I());
            hVar.k = String.valueOf(eVar.F());
            hVar.l = String.valueOf(eVar.U());
            hVar.m = eVar.Y();
            hVar.n = String.valueOf(j2);
            hVar.o = String.valueOf(j3);
            hVar.p = String.valueOf(j4);
            hVar.q = String.valueOf(eVar.H());
            hVar.r = eVar.x();
            hVar.s = String.valueOf(eVar.A());
            hVar.t = String.valueOf(eVar.z);
            hVar.u = z ? "1" : "0";
            com.anythink.core.c.d a2 = e.a(n.a().g()).a(eVar.W());
            hVar.j = a2 != null ? a2.U() : "";
            hVar.A = eVar.Y();
            hVar.C = eVar.P();
            hVar.D = eVar.Q();
            a(hVar);
        } catch (Throwable th) {
        }
    }

    protected static void a(final h hVar) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.c.3
            /* JADX WARN: Code restructure failed: missing block: B:24:0x00cc, code lost:
                if (r0.contains(r0.A) != false) goto L23;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x00cf, code lost:
                r5 = true;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x0106, code lost:
                if (r0.contains(r0.A) != false) goto L23;
             */
            /* JADX WARN: Removed duplicated region for block: B:41:0x0136  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x01a8  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void run() {
                /*
                    Method dump skipped, instructions count: 556
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.j.c.AnonymousClass3.run():void");
            }
        });
    }

    public static void a(i iVar, j jVar, String str, String str2) {
        if (iVar == null || jVar == null) {
            return;
        }
        h hVar = new h(String.valueOf(jVar.j), String.valueOf(jVar.f));
        hVar.a = "1004652";
        hVar.d = jVar.b;
        hVar.m = String.valueOf(jVar.f);
        hVar.n = jVar.c;
        hVar.b = jVar.d;
        if (iVar instanceof s) {
            hVar.o = "1";
        } else if (iVar instanceof g) {
            hVar.o = "2";
        } else if (iVar instanceof z) {
            hVar.o = "3";
        }
        hVar.p = str;
        if (TextUtils.equals("0", str)) {
            hVar.q = str2;
        }
        hVar.r = iVar.p();
        hVar.s = iVar.q();
        hVar.t = iVar.B();
        hVar.u = iVar.r();
        hVar.v = iVar.s();
        hVar.w = iVar.t();
        hVar.x = iVar.u();
        hVar.y = iVar.x();
        try {
            if (iVar instanceof aa) {
                StringBuilder sb = new StringBuilder();
                String Z = ((aa) iVar).Z();
                if (!TextUtils.isEmpty(Z)) {
                    JSONArray jSONArray = new JSONArray(Z);
                    int length = jSONArray.length();
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= length) {
                            break;
                        }
                        sb.append(jSONArray.optString(i3));
                        sb.append(",");
                        i2 = i3 + 1;
                    }
                    if (sb.length() > 1) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    hVar.z = sb.toString();
                }
            }
        } catch (Throwable th) {
        }
        a(hVar);
    }

    public static void a(j jVar, i iVar, int i2) {
        try {
            h hVar = new h(String.valueOf(jVar.j), String.valueOf(jVar.f));
            hVar.a = "1004679";
            hVar.b = jVar.d;
            hVar.d = jVar.b;
            if (iVar instanceof g) {
                hVar.m = ((g) iVar).T();
            }
            hVar.n = jVar.c;
            hVar.o = iVar.p();
            hVar.p = String.valueOf(iVar.d());
            hVar.q = iVar.e();
            hVar.r = iVar.f();
            hVar.s = String.valueOf(i2);
            a(hVar);
        } catch (Throwable th) {
        }
    }

    public static void a(j jVar, i iVar, String str, String str2, int i2) {
        if (jVar == null || iVar == null) {
            return;
        }
        h hVar = new h(String.valueOf(jVar.j), String.valueOf(jVar.f));
        hVar.a = "1004650";
        hVar.d = jVar.b;
        hVar.m = iVar.p();
        hVar.n = String.valueOf(iVar.d());
        hVar.o = str;
        hVar.p = str2;
        hVar.q = String.valueOf(i2);
        hVar.b = jVar.d;
        hVar.t = String.valueOf(jVar.j);
        a(hVar);
    }

    public static void a(j jVar, i iVar, String str, String str2, String str3, String str4) {
        if (jVar == null || iVar == null) {
            return;
        }
        h hVar = new h(null, null);
        hVar.a = "1004648";
        hVar.d = jVar.b;
        hVar.m = iVar.p();
        hVar.n = String.valueOf(iVar.d());
        hVar.o = str;
        hVar.p = str2;
        hVar.q = str3;
        hVar.r = str4;
        hVar.b = jVar.d;
        a(hVar);
    }

    public static void a(final String str) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (TextUtils.isEmpty(String.this)) {
                    return;
                }
                h a2 = h.a(String.this);
                if (TextUtils.isEmpty(a2.a)) {
                    return;
                }
                c.a(a2);
            }
        });
    }

    public static void a(String str, ai aiVar, boolean z, long j2, com.anythink.core.common.e.a aVar) {
        com.anythink.core.c.d dVar = aVar != null ? aVar.n : null;
        h hVar = new h(String.valueOf(aVar.e), String.valueOf(aiVar.c()));
        hVar.a = "1004665";
        hVar.d = str;
        hVar.j = dVar != null ? dVar.U() : "";
        hVar.m = String.valueOf(aiVar.c());
        hVar.n = aiVar.t();
        hVar.o = String.valueOf(z ? 1 : 2);
        hVar.p = String.valueOf(j2);
        String str2 = "";
        if (dVar != null) {
            try {
                str2 = dVar.c();
            } catch (Throwable th) {
            }
        }
        hVar.C = str2;
        try {
            Object obj = aVar.b.g.get(ATAdConst.KEY.CP_PLACEMENT_ID);
            if (obj != null) {
                hVar.D = obj.toString();
            }
        } catch (Throwable th2) {
        }
        a(hVar);
    }

    private static void a(String str, String str2, int i2, int i3, int i4, String str3, String str4, int i5, int i6, AdError adError, int i7, double d2, long j2, int i8, int i9, int i10, String str5, String str6) {
        h hVar = new h(str4, String.valueOf(i4));
        hVar.a = "1004631";
        hVar.b = str;
        hVar.d = str2;
        hVar.g = String.valueOf(i2);
        hVar.k = String.valueOf(i3);
        hVar.l = String.valueOf(i8);
        hVar.m = String.valueOf(i4);
        hVar.n = str3;
        hVar.o = String.valueOf(i5);
        hVar.p = String.valueOf(i6);
        hVar.q = adError != null ? adError.getPlatformCode() : "";
        hVar.r = adError != null ? adError.getPlatformMSG() : "";
        hVar.s = String.valueOf(i7);
        hVar.t = String.valueOf(d2);
        if (i6 == 0) {
            hVar.u = String.valueOf(j2);
        }
        hVar.v = String.valueOf(i9);
        hVar.w = String.valueOf(i10);
        com.anythink.core.c.d a2 = e.a(n.a().g()).a(str2);
        hVar.j = a2 != null ? a2.U() : "";
        hVar.C = str5;
        hVar.D = str6;
        a(hVar);
    }

    public static void a(String str, String str2, int i2, String str3, JSONArray jSONArray, int i3, int i4, int i5, String str4, int i6) {
        h hVar = new h(null, null);
        hVar.a = "1004675";
        hVar.b = str2;
        hVar.d = str;
        hVar.m = str3;
        hVar.n = String.valueOf(i2);
        hVar.o = jSONArray != null ? jSONArray.toString() : "";
        hVar.p = String.valueOf(i3);
        hVar.q = String.valueOf(i4);
        hVar.r = String.valueOf(i5);
        hVar.s = str4;
        hVar.t = String.valueOf(i6);
        a(hVar);
    }

    public static void a(String str, String str2, long j2, long j3, long j4) {
        h hVar = new h(null, null);
        hVar.a = "1004635";
        if (!TextUtils.isEmpty(str2)) {
            hVar.d = str2;
        }
        hVar.m = str;
        hVar.n = String.valueOf(j2);
        hVar.o = String.valueOf(j3);
        hVar.p = String.valueOf(j4);
        a(hVar);
    }

    private static void a(String str, String str2, com.anythink.core.c.d dVar, String str3) {
        h hVar = new h(null, null);
        hVar.a = "1004646";
        hVar.b = str;
        hVar.d = str2;
        hVar.g = String.valueOf(dVar.ae());
        hVar.l = String.valueOf(dVar.O());
        hVar.j = dVar.U();
        hVar.t = String.valueOf(str3);
        a(hVar);
    }

    public static void a(String str, String str2, String str3) {
        h hVar = new h(null, null);
        hVar.a = "1004647";
        hVar.e = str3;
        hVar.m = str2;
        hVar.n = str;
        a(hVar);
    }

    public static void a(String str, String str2, String str3, int i2, String str4, long j2, long j3) {
        h hVar = new h(null, null);
        hVar.a = "1004642";
        hVar.b = str;
        hVar.m = str2;
        hVar.n = str3;
        hVar.o = String.valueOf(i2);
        if (i2 == 3 || i2 == 10) {
            hVar.p = str4;
        } else if (i2 == 2) {
            hVar.q = String.valueOf(j2);
            hVar.r = String.valueOf(((float) j3) / 1024.0f);
        }
        a(hVar);
    }

    public static void a(String str, String str2, String str3, String str4) {
        h hVar = new h(null, null);
        hVar.a = "1004637";
        hVar.d = str;
        hVar.m = str2;
        hVar.n = str3;
        hVar.o = str4;
        a(hVar);
    }

    public static void a(String str, String str2, String str3, String str4, long j2, String str5, long j3, long j4, int i2, long j5) {
        h hVar = new h(null, null);
        hVar.a = "1004638";
        hVar.d = str;
        hVar.m = str2;
        hVar.n = str3;
        hVar.o = str4;
        hVar.p = String.valueOf(j2);
        hVar.q = str5;
        hVar.r = String.valueOf(j3);
        hVar.s = String.valueOf(j4);
        String str6 = null;
        if ("1".equals(str4)) {
            str6 = String.valueOf(j5);
        }
        hVar.t = str6;
        hVar.u = String.valueOf(i2);
        a(hVar);
    }

    private static void a(final String str, final String str2, final String str3, final String str4, final String str5, final int i2, final boolean z, final String str6, final String str7) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.j.c.2
            @Override // java.lang.Runnable
            public final void run() {
                h hVar = new h(String.this, str5);
                hVar.a = "1004680";
                hVar.b = str;
                hVar.d = str2;
                hVar.m = str3;
                hVar.n = String.valueOf(i2);
                hVar.o = z ? "1" : "0";
                boolean z2 = true;
                try {
                    z2 = ((PowerManager) n.a().g().getSystemService(PowerMenuConstants.GLOBAL_ACTION_KEY_POWER)).isScreenOn();
                } catch (Throwable th) {
                }
                hVar.p = z2 ? "1" : "0";
                hVar.q = com.anythink.core.common.k.h.a(n.a().g()) ? "1" : "0";
                hVar.r = str7;
                hVar.s = str6;
                c.a(hVar);
            }
        });
    }

    public static void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        h hVar = new h(null, null);
        hVar.a = "1004616";
        hVar.d = str5;
        hVar.m = str;
        hVar.n = str2;
        hVar.o = str3;
        hVar.p = str4;
        hVar.q = str6;
        hVar.r = str7;
        a(hVar);
    }

    private static boolean a(h hVar, com.anythink.core.c.a aVar) {
        Map<String, String> e2;
        if (TextUtils.isEmpty(hVar.a) || TextUtils.isEmpty(hVar.B) || TextUtils.isEmpty(hVar.A) || (e2 = aVar.e(hVar.a)) == null) {
            return false;
        }
        if (e2.containsKey("0")) {
            String str = e2.get("0");
            return !TextUtils.isEmpty(str) && str.contains(hVar.A);
        } else if (e2.containsKey(hVar.B)) {
            String str2 = e2.get(hVar.B);
            return !TextUtils.isEmpty(str2) && str2.contains(hVar.A);
        } else {
            return false;
        }
    }

    public static void b(String str, String str2, String str3) {
        h hVar = new h(null, null);
        hVar.a = "1004666";
        hVar.m = str;
        hVar.n = str2;
        hVar.o = str3;
        a(hVar);
    }

    private static /* synthetic */ boolean b(h hVar, com.anythink.core.c.a aVar) {
        Map<String, String> e2;
        if (TextUtils.isEmpty(hVar.a) || TextUtils.isEmpty(hVar.B) || TextUtils.isEmpty(hVar.A) || (e2 = aVar.e(hVar.a)) == null) {
            return false;
        }
        if (e2.containsKey("0")) {
            String str = e2.get("0");
            return !TextUtils.isEmpty(str) && str.contains(hVar.A);
        } else if (e2.containsKey(hVar.B)) {
            String str2 = e2.get(hVar.B);
            return !TextUtils.isEmpty(str2) && str2.contains(hVar.A);
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(h hVar, String str) {
        String str2 = hVar.B;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return false;
                }
                if (TextUtils.equals(str2, jSONArray.optString(i3))) {
                    return true;
                }
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            return false;
        }
    }
}
