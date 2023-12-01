package com.kuaishou.weapon.p0;

import android.content.Context;
import android.hardware.Camera;
import android.os.Environment;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.ads.hn;
import com.huawei.openalliance.ad.activity.PPSLauncherActivity;
import com.kuaishou.weapon.p0.jni.Engine;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ci.class */
public class ci {

    /* renamed from: a  reason: collision with root package name */
    private Context f23781a;

    public ci(Context context) {
        this.f23781a = context;
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cl(str, cj.j).a(this.f23781a);
            if (a3 == null || (a2 = a()) == null) {
                return null;
            }
            a3.put("module_section", a2);
            return a3.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public JSONObject a() {
        JSONObject g;
        try {
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f23781a, "re_po_rt");
            boolean e = a2.e("a1_p_s_p_s");
            boolean e2 = a2.e("a1_p_s_p_s_c_b");
            if (a2.b(de.E, 1) == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (a2.b(de.I, 1) == 1 && Engine.loadSuccess) {
                    ap apVar = new ap(this.f23781a);
                    jSONObject.put("0", apVar.b("0"));
                    jSONObject.put("1", apVar.b("1"));
                    jSONObject.put("2", apVar.b("2"));
                    jSONObject.put("3", apVar.b("3"));
                    jSONObject.put("4", apVar.b("4"));
                    jSONObject.put("5", apVar.b("5"));
                    jSONObject.put("6", apVar.b("6"));
                    jSONObject.put("7", apVar.b("7"));
                    jSONObject.put("8", apVar.b("8"));
                    jSONObject.put("9", apVar.b("9"));
                    jSONObject.put("10", apVar.b("10"));
                    jSONObject.put("11", apVar.b("11"));
                    jSONObject.put("12", apVar.b("12"));
                    jSONObject.put("13", apVar.b("13"));
                    jSONObject.put("14", apVar.b("14"));
                    jSONObject.put("15", apVar.b("15"));
                    jSONObject.put("16", apVar.b("16"));
                    jSONObject.put("17", apVar.b("17"));
                    jSONObject.put("18", apVar.b("18"));
                    jSONObject.put("19", apVar.b("19"));
                    jSONObject.put(BaseWrapper.ENTER_ID_SYSTEM_HELPER, apVar.b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                    jSONObject.put("21", apVar.b("21"));
                    jSONObject.put("22", apVar.b("22"));
                    jSONObject.put("23", apVar.b("23"));
                    jSONObject.put("24", apVar.b("24"));
                    jSONObject.put("25", apVar.b("25"));
                    jSONObject.put("26", apVar.b("26"));
                    jSONObject.put("27", apVar.b("27"));
                    jSONObject.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, apVar.b(Constants.VIA_ACT_TYPE_TWENTY_EIGHT));
                    jSONObject.put("29", apVar.b("29"));
                    jSONObject.put(BaseWrapper.ENTER_ID_TOOLKIT, apVar.b(BaseWrapper.ENTER_ID_TOOLKIT));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_DEMO, apVar.b(BaseWrapper.ENTER_ID_OAPS_DEMO));
                    jSONObject.put("32", apVar.b("32"));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_ROAMING, apVar.b(BaseWrapper.ENTER_ID_OAPS_ROAMING));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_ASSISTANT_SCREEN, apVar.b(BaseWrapper.ENTER_ID_OAPS_ASSISTANT_SCREEN));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST, apVar.b(BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET, apVar.b(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_GAMESPACE, apVar.b(BaseWrapper.ENTER_ID_OAPS_GAMESPACE));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SYS_CRASH, apVar.b(BaseWrapper.ENTER_ID_OAPS_SYS_CRASH));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SCANNER, apVar.b(BaseWrapper.ENTER_ID_OAPS_SCANNER));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER, apVar.b(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER));
                    jSONObject.put("41", apVar.b("41"));
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_OPEN_GUIDE, apVar.b(BaseWrapper.ENTER_ID_OAPS_OPEN_GUIDE));
                    jSONObject.put("43", apVar.a("43"));
                    jSONObject.put("44", apVar.a("44"));
                    jSONObject.put("101", apVar.b("101"));
                    jSONObject.put(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB, apVar.b(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB));
                    jSONObject.put("105", apVar.b("105"));
                    jSONObject.put("106", apVar.b("106"));
                    jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.V, dk.b(this.f23781a));
                    jSONObject.put("50", dk.a(this.f23781a));
                }
                if (a2.b(de.H, 1) == 1 && Engine.loadSuccess) {
                    at atVar = new at(this.f23781a);
                    jSONObject.put("45", atVar.d("45"));
                    if (atVar.a()) {
                        jSONObject.put("93", 1);
                    }
                    if (atVar.b()) {
                        jSONObject.put("94", 1);
                    }
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP, atVar.d(BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP));
                    jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.Code, atVar.a(com.huawei.openalliance.ad.beans.inner.a.Code));
                    jSONObject.put("51", atVar.b("51"));
                    jSONObject.put("52", atVar.a(this.f23781a, "52", 0));
                    jSONObject.put("55", atVar.c("55"));
                    jSONObject.put("66", atVar.a("66"));
                    jSONObject.put("67", dh.d());
                    jSONObject.put("78", atVar.a("78"));
                    jSONObject.put("79", atVar.a("79"));
                    ay ayVar = new ay(this.f23781a, 200);
                    jSONObject.put(hn.Code, ayVar.a(hn.Code));
                    jSONObject.put("71", ayVar.a("71"));
                    jSONObject.put("72", ayVar.a("72"));
                    jSONObject.put("73", ayVar.a("73"));
                    jSONObject.put("74", ayVar.a("74"));
                }
                if (a2.b(de.K, 1) == 1) {
                    aw awVar = new aw(this.f23781a);
                    jSONObject.put("53", awVar.a(this.f23781a, "53", 1));
                    jSONObject.put("56", awVar.a("56"));
                    jSONObject.put("57", awVar.a("57"));
                    if (e || e2) {
                        aj ajVar = new aj();
                        jSONObject.put("47", ajVar.a(this.f23781a));
                        jSONObject.put("59", ajVar.d(this.f23781a));
                        jSONObject.put(Camera.Parameters.VIDEO_HFR_2X, ajVar.c(this.f23781a));
                        jSONObject.put("61", ajVar.b(this.f23781a));
                        jSONObject.put("62", ajVar.e(this.f23781a));
                        jSONObject.put("65", ajVar.f(this.f23781a));
                        jSONObject.put(PPSLauncherActivity.Code, ajVar.g(this.f23781a));
                        jSONObject.put("75", ajVar.h(this.f23781a));
                        jSONObject.put("80", aj.a());
                        jSONObject.put("85", ajVar.i(this.f23781a));
                        jSONObject.put("87", ajVar.j(this.f23781a));
                        jSONObject.put("91", ajVar.k(this.f23781a));
                        jSONObject.put("92", ajVar.l(this.f23781a));
                    }
                    jSONObject.put("64", dh.a());
                }
                if (a2.b(de.L, 1) == 1) {
                    cr crVar = new cr();
                    jSONObject.put("98", crVar.a());
                    jSONObject.put("107", crVar.b());
                    String d = am.d();
                    if (!TextUtils.isEmpty(d)) {
                        jSONObject.put("77", d);
                    }
                    jSONObject.put("104", am.c());
                    jSONObject.put("109", dk.e(this.f23781a));
                    ai aiVar = new ai(this.f23781a);
                    jSONObject.put("82", aiVar.h());
                    String i = aiVar.i();
                    if (!TextUtils.isEmpty(i)) {
                        jSONObject.put("83", i);
                    }
                    String j = aiVar.j();
                    if (!TextUtils.isEmpty(j)) {
                        jSONObject.put("84", j);
                    }
                    String k = aiVar.k();
                    if (!TextUtils.isEmpty(k)) {
                        jSONObject.put("86", k);
                    }
                }
                if (a2.b(de.J, 1) == 1) {
                    au auVar = new au(this.f23781a);
                    jSONObject.put("95", auVar.b("95"));
                    jSONObject.put("96", auVar.a() ? 1 : 0);
                    jSONObject.put("97", dh.e());
                    try {
                        jSONObject.put("11301", bg.c(com.kwad.sdk.d.b.Ax().Aw()));
                        jSONObject.put("11302", bg.c(com.kwad.sdk.d.b.Ax().getSdkVersion()));
                        jSONObject.put("11303", bg.c(com.kwad.sdk.d.b.Ax().getAppId()));
                    } catch (Throwable th) {
                    }
                }
                try {
                    if (h.a(this.f23781a, "re_po_rt").b(de.aB, 1) == 1) {
                        JSONObject c2 = new ba(this.f23781a, 100, Environment.getExternalStorageDirectory().getAbsolutePath(), ba.a(this.f23781a)).c();
                        if (c2 == null || c2.length() <= 10) {
                            try {
                                jSONObject.put("16102", new ba(this.f23781a, 200, "", true).a("16102"));
                            } catch (Throwable th2) {
                            }
                        } else {
                            jSONObject.put("16002", c2);
                        }
                        if ((e || e2) && (g = bf.g(this.f23781a)) != null && g.length() > 0) {
                            jSONObject.put("16116", g);
                        }
                    }
                } catch (Throwable th3) {
                }
                jSONObject.put("11006", e ? 1 : 0);
                jSONObject.put("11029", e2 ? 1 : 0);
                jSONObject.put(WbFaceError.WBFaceErrorCodeDataSerilizerError, Engine.soVersion);
                jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            }
            return null;
        } catch (Throwable th4) {
            return null;
        }
    }
}
