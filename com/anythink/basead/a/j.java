package com.anythink.basead.a;

import android.text.TextUtils;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ac;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/j.class */
public final class j {
    private static String a(String str, com.anythink.basead.c.b bVar) {
        return str.replaceAll("\\{__CLICK_ID__\\}", bVar.a == null ? "" : bVar.a);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x025d -> B:4:0x004e). Please submit an issue!!! */
    private static String a(String str, com.anythink.basead.c.i iVar) {
        String str2;
        String str3 = "{}";
        com.anythink.basead.c.a aVar = iVar.g;
        int i = iVar.e;
        int i2 = iVar.f;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_x", aVar.e);
            jSONObject.put("down_y", aVar.f);
            jSONObject.put("up_x", aVar.g);
            jSONObject.put("up_y", aVar.h);
        } catch (JSONException e) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            float f = aVar.e;
            float f2 = i;
            jSONObject2.put("down_x", (int) ((f / f2) * 1000.0f));
            float f3 = aVar.e;
            float f4 = i2;
            jSONObject2.put("down_y", (int) ((f3 / f4) * 1000.0f));
            jSONObject2.put("up_x", (int) ((aVar.g / f2) * 1000.0f));
            jSONObject2.put("up_y", (int) ((aVar.h / f4) * 1000.0f));
        } catch (JSONException e2) {
        }
        try {
            str2 = URLEncoder.encode(jSONObject.toString(), "utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = "{}";
        }
        try {
            str3 = URLEncoder.encode(jSONObject2.toString(), "utf-8");
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        int i3 = aVar.i ? 1 : 2;
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.a);
        String replaceAll = str.replaceAll("\\{__DOWN_X__\\}", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(aVar.b);
        String replaceAll2 = replaceAll.replaceAll("\\{__DOWN_Y__\\}", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(aVar.c);
        String replaceAll3 = replaceAll2.replaceAll("\\{__UP_X__\\}", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(aVar.d);
        String replaceAll4 = replaceAll3.replaceAll("\\{__UP_Y__\\}", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(aVar.e);
        String replaceAll5 = replaceAll4.replaceAll("\\{__RE_DOWN_X__\\}", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(aVar.f);
        String replaceAll6 = replaceAll5.replaceAll("\\{__RE_DOWN_Y__\\}", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(aVar.g);
        String replaceAll7 = replaceAll6.replaceAll("\\{__RE_UP_X__\\}", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(aVar.h);
        String replaceAll8 = replaceAll7.replaceAll("\\{__RE_UP_Y__\\}", sb8.toString()).replaceAll("\\{ABSOLUTE_COORD\\}", str2).replaceAll("\\{RELATIVE_COORD\\}", str3).replaceAll("\\{__DPLINK_TYPE__\\}", String.valueOf(i3));
        String str4 = replaceAll8;
        if (aVar.i) {
            str4 = replaceAll8.replaceAll("&apk_ptype=\\{apk_ptype\\}", "");
        }
        return (aVar.j == -1 ? str4.replaceAll("&apk_ptype=\\{apk_ptype\\}", "") : str4.replaceAll("\\{apk_ptype\\}", String.valueOf(aVar.j))).replaceAll("\\{opdptype\\}", aVar.i ? "1" : "0");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str, com.anythink.basead.c.i iVar, long j) {
        String sb;
        String sb2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = str;
        if (iVar.g != null) {
            str2 = a(str, iVar);
        }
        String str3 = str2;
        if (iVar.h != null) {
            str3 = a(str2, iVar.h);
        }
        String str4 = str3;
        if (iVar.i != null) {
            str4 = a(str3, iVar.i);
        }
        long j2 = j / 1000;
        if (iVar.c == 0) {
            sb = "__REQ_WIDTH__";
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(iVar.c);
            sb = sb3.toString();
        }
        String replaceAll = str4.replaceAll("\\{__REQ_WIDTH__\\}", sb);
        if (iVar.d == 0) {
            sb2 = "__REQ_HEIGHT__";
        } else {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(iVar.d);
            sb2 = sb4.toString();
        }
        String replaceAll2 = replaceAll.replaceAll("\\{__REQ_HEIGHT__\\}", sb2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(iVar.e);
        String replaceAll3 = replaceAll2.replaceAll("\\{__WIDTH__\\}", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(iVar.f);
        return replaceAll3.replaceAll("\\{__HEIGHT__\\}", sb6.toString()).replaceAll("\\{__TS__\\}", String.valueOf(j2)).replaceAll("\\{__TS_MSEC__\\}", String.valueOf(j)).replaceAll("\\{__END_TS__\\}", String.valueOf(j2)).replaceAll("\\{__END_TS_MSEC__\\}", String.valueOf(j)).replaceAll("\\{__PLAY_SEC__\\}", "0").replaceAll("\\{", "").replaceAll("\\}", "");
    }

    private static String a(String str, com.anythink.basead.c.j jVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(jVar.a);
        String replaceAll = str.replaceAll("\\{__VIDEO_TIME__\\}", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(jVar.b);
        String replaceAll2 = replaceAll.replaceAll("\\{__BEGIN_TIME__\\}", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(jVar.c);
        String replaceAll3 = replaceAll2.replaceAll("\\{__END_TIME__\\}", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(jVar.d);
        String replaceAll4 = replaceAll3.replaceAll("\\{__PLAY_FIRST_FRAME__\\}", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(jVar.e);
        String replaceAll5 = replaceAll4.replaceAll("\\{__PLAY_LAST_FRAME__\\}", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(jVar.l);
        String replaceAll6 = replaceAll5.replaceAll("\\{__SCENE__\\}", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(jVar.o);
        String replaceAll7 = replaceAll6.replaceAll("\\{__TYPE__\\}", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(jVar.r);
        String replaceAll8 = replaceAll7.replaceAll("\\{__BEHAVIOR__\\}", sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append(jVar.u);
        String replaceAll9 = replaceAll8.replaceAll("\\{__STATUS__\\}", sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append(jVar.h);
        String replaceAll10 = replaceAll9.replaceAll("\\{__PLAY_SEC__\\}", sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append(jVar.f / 1000);
        String replaceAll11 = replaceAll10.replaceAll("\\{__TS__\\}", sb11.toString());
        StringBuilder sb12 = new StringBuilder();
        sb12.append(jVar.f);
        String replaceAll12 = replaceAll11.replaceAll("\\{__TS_MSEC__\\}", sb12.toString());
        StringBuilder sb13 = new StringBuilder();
        sb13.append(jVar.g / 1000);
        String replaceAll13 = replaceAll12.replaceAll("\\{__END_TS__\\}", sb13.toString());
        StringBuilder sb14 = new StringBuilder();
        sb14.append(jVar.g);
        String replaceAll14 = replaceAll13.replaceAll("\\{__END_TS_MSEC__\\}", sb14.toString());
        StringBuilder sb15 = new StringBuilder();
        sb15.append(jVar.h / 1000);
        String replaceAll15 = replaceAll14.replaceAll("\\{__PLAY_SEC__\\}", sb15.toString());
        StringBuilder sb16 = new StringBuilder();
        sb16.append(jVar.h);
        return replaceAll15.replaceAll("\\{__PLAY_MSEC__\\}", sb16.toString());
    }

    private static void a(int i, com.anythink.basead.c.i iVar, aa aaVar, ac acVar, Map<String, Object> map) {
        String str;
        switch (i) {
            case 1:
                str = acVar.C();
                break;
            case 2:
                str = acVar.D();
                break;
            case 3:
                str = acVar.E();
                break;
            case 4:
                str = acVar.F();
                break;
            case 5:
                str = acVar.G();
                break;
            case 6:
                str = acVar.L();
                break;
            case 7:
                str = acVar.M();
                break;
            case 8:
                str = acVar.A();
                break;
            case 9:
                str = acVar.B();
                break;
            case 10:
                str = acVar.z();
                break;
            case 11:
                str = acVar.H();
                break;
            case 12:
                str = acVar.J();
                break;
            case 13:
                str = acVar.K();
                break;
            case 14:
                str = acVar.I();
                break;
            case 15:
                str = acVar.Z();
                break;
            case 16:
                str = acVar.aa();
                break;
            case 17:
                str = acVar.ab();
                break;
            case 18:
                str = acVar.N();
                break;
            case 19:
                str = acVar.O();
                break;
            case 20:
                str = acVar.ac();
                break;
            case 21:
                str = acVar.P();
                break;
            case 22:
            case 32:
            default:
                str = "";
                break;
            case 23:
                str = acVar.ad();
                break;
            case 24:
                str = acVar.ae();
                break;
            case 25:
                str = acVar.af();
                break;
            case 26:
                str = acVar.ag();
                break;
            case 27:
                str = acVar.ah();
                break;
            case 28:
                str = acVar.aj();
                break;
            case 29:
                str = acVar.ai();
                break;
            case 30:
                str = acVar.ak();
                break;
            case 31:
                str = acVar.al();
                break;
            case 33:
                str = acVar.am();
                break;
            case 34:
                str = acVar.an();
                break;
            case 35:
                str = acVar.ap();
                break;
        }
        if (a(str)) {
            return;
        }
        com.anythink.basead.g.f fVar = new com.anythink.basead.g.f(i, aaVar, str, map);
        fVar.b(iVar.b);
        fVar.a(0, (com.anythink.core.common.g.i) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void a(int i, aa aaVar, com.anythink.basead.c.i iVar) {
        String str;
        String[] strArr;
        ac X = aaVar.X();
        if (X == null) {
            return;
        }
        Map<String, Object> c = com.anythink.core.common.k.h.c(X.c());
        try {
            switch (i) {
                case 1:
                    strArr = X.g();
                    break;
                case 2:
                    strArr = X.h();
                    break;
                case 3:
                    strArr = X.i();
                    break;
                case 4:
                    strArr = X.j();
                    break;
                case 5:
                    strArr = X.k();
                    break;
                case 6:
                    strArr = X.p();
                    break;
                case 7:
                    strArr = X.q();
                    break;
                case 8:
                    strArr = X.e();
                    break;
                case 9:
                    strArr = X.f();
                    break;
                case 10:
                    strArr = X.d();
                    break;
                case 11:
                    strArr = X.l();
                    break;
                case 12:
                    strArr = X.n();
                    break;
                case 13:
                    strArr = X.o();
                    break;
                case 14:
                    strArr = X.m();
                    break;
                case 15:
                    strArr = X.Q();
                    break;
                case 16:
                    strArr = X.R();
                    break;
                case 17:
                    strArr = X.S();
                    break;
                case 18:
                    strArr = X.r();
                    break;
                case 19:
                    strArr = X.s();
                    break;
                case 20:
                    strArr = X.T();
                    break;
                case 21:
                    strArr = X.t();
                    break;
                case 22:
                default:
                    strArr = null;
                    break;
                case 23:
                    strArr = X.U();
                    break;
                case 24:
                    strArr = X.V();
                    break;
                case 25:
                    strArr = X.W();
                    break;
                case 26:
                    strArr = X.X();
                    break;
                case 27:
                    strArr = X.Y();
                    break;
                case 28:
                    strArr = X.v();
                    break;
                case 29:
                    strArr = X.u();
                    break;
                case 30:
                    strArr = X.w();
                    break;
                case 31:
                    strArr = X.x();
                    break;
                case 32:
                    com.anythink.basead.c.j jVar = iVar.h;
                    Map<Integer, String[]> y = X.y();
                    if (jVar != null && y != null) {
                        strArr = y.get(Integer.valueOf(jVar.i));
                        break;
                    }
                    strArr = null;
                    break;
                case 33:
                    strArr = X.a();
                    break;
                case 34:
                    strArr = X.b();
                    break;
                case 35:
                    strArr = X.ao();
                    break;
            }
            if (strArr != null) {
                boolean W = (i == 8 || i == 9) ? aaVar.k().W() : false;
                long currentTimeMillis = System.currentTimeMillis();
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < length) {
                        com.anythink.basead.g.e eVar = new com.anythink.basead.g.e(i, a(strArr[i3], iVar, currentTimeMillis), aaVar, c);
                        eVar.a(W);
                        eVar.a(0, (com.anythink.core.common.g.i) null);
                        i2 = i3 + 1;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        switch (i) {
            case 1:
                str = X.C();
                break;
            case 2:
                str = X.D();
                break;
            case 3:
                str = X.E();
                break;
            case 4:
                str = X.F();
                break;
            case 5:
                str = X.G();
                break;
            case 6:
                str = X.L();
                break;
            case 7:
                str = X.M();
                break;
            case 8:
                str = X.A();
                break;
            case 9:
                str = X.B();
                break;
            case 10:
                str = X.z();
                break;
            case 11:
                str = X.H();
                break;
            case 12:
                str = X.J();
                break;
            case 13:
                str = X.K();
                break;
            case 14:
                str = X.I();
                break;
            case 15:
                str = X.Z();
                break;
            case 16:
                str = X.aa();
                break;
            case 17:
                str = X.ab();
                break;
            case 18:
                str = X.N();
                break;
            case 19:
                str = X.O();
                break;
            case 20:
                str = X.ac();
                break;
            case 21:
                str = X.P();
                break;
            case 22:
            case 32:
            default:
                str = "";
                break;
            case 23:
                str = X.ad();
                break;
            case 24:
                str = X.ae();
                break;
            case 25:
                str = X.af();
                break;
            case 26:
                str = X.ag();
                break;
            case 27:
                str = X.ah();
                break;
            case 28:
                str = X.aj();
                break;
            case 29:
                str = X.ai();
                break;
            case 30:
                str = X.ak();
                break;
            case 31:
                str = X.al();
                break;
            case 33:
                str = X.am();
                break;
            case 34:
                str = X.an();
                break;
            case 35:
                str = X.ap();
                break;
        }
        if (a(str)) {
            return;
        }
        com.anythink.basead.g.f fVar = new com.anythink.basead.g.f(i, aaVar, str, c);
        fVar.b(iVar.b);
        fVar.a(0, (com.anythink.core.common.g.i) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(int i, aa aaVar, ac acVar, Map<String, Object> map, com.anythink.basead.c.i iVar) {
        String[] strArr;
        try {
            switch (i) {
                case 1:
                    strArr = acVar.g();
                    break;
                case 2:
                    strArr = acVar.h();
                    break;
                case 3:
                    strArr = acVar.i();
                    break;
                case 4:
                    strArr = acVar.j();
                    break;
                case 5:
                    strArr = acVar.k();
                    break;
                case 6:
                    strArr = acVar.p();
                    break;
                case 7:
                    strArr = acVar.q();
                    break;
                case 8:
                    strArr = acVar.e();
                    break;
                case 9:
                    strArr = acVar.f();
                    break;
                case 10:
                    strArr = acVar.d();
                    break;
                case 11:
                    strArr = acVar.l();
                    break;
                case 12:
                    strArr = acVar.n();
                    break;
                case 13:
                    strArr = acVar.o();
                    break;
                case 14:
                    strArr = acVar.m();
                    break;
                case 15:
                    strArr = acVar.Q();
                    break;
                case 16:
                    strArr = acVar.R();
                    break;
                case 17:
                    strArr = acVar.S();
                    break;
                case 18:
                    strArr = acVar.r();
                    break;
                case 19:
                    strArr = acVar.s();
                    break;
                case 20:
                    strArr = acVar.T();
                    break;
                case 21:
                    strArr = acVar.t();
                    break;
                case 22:
                default:
                    strArr = null;
                    break;
                case 23:
                    strArr = acVar.U();
                    break;
                case 24:
                    strArr = acVar.V();
                    break;
                case 25:
                    strArr = acVar.W();
                    break;
                case 26:
                    strArr = acVar.X();
                    break;
                case 27:
                    strArr = acVar.Y();
                    break;
                case 28:
                    strArr = acVar.v();
                    break;
                case 29:
                    strArr = acVar.u();
                    break;
                case 30:
                    strArr = acVar.w();
                    break;
                case 31:
                    strArr = acVar.x();
                    break;
                case 32:
                    com.anythink.basead.c.j jVar = iVar.h;
                    Map<Integer, String[]> y = acVar.y();
                    if (jVar != null && y != null) {
                        strArr = y.get(Integer.valueOf(jVar.i));
                        break;
                    }
                    strArr = null;
                    break;
                case 33:
                    strArr = acVar.a();
                    break;
                case 34:
                    strArr = acVar.b();
                    break;
                case 35:
                    strArr = acVar.ao();
                    break;
            }
            if (strArr == null) {
                return;
            }
            boolean W = (i == 8 || i == 9) ? aaVar.k().W() : false;
            long currentTimeMillis = System.currentTimeMillis();
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                com.anythink.basead.g.e eVar = new com.anythink.basead.g.e(i, a(strArr[i3], iVar, currentTimeMillis), aaVar, map);
                eVar.a(W);
                eVar.a(0, (com.anythink.core.common.g.i) null);
                i2 = i3 + 1;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return new JSONObject(str).length() <= 0;
        } catch (Throwable th) {
            return true;
        }
    }
}
