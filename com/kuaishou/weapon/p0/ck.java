package com.kuaishou.weapon.p0;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.ads.hn;
import com.huawei.openalliance.ad.activity.PPSLauncherActivity;
import com.igexin.sdk.PushConsts;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.connect.common.Constants;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/ck.class */
public class ck {

    /* renamed from: a  reason: collision with root package name */
    private Context f23784a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f23785c;

    public ck(Context context, int i, int i2) {
        this.f23784a = context;
        this.b = i;
        this.f23785c = i2;
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cl(str, cj.j).a(this.f23784a);
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
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f23784a, "re_po_rt");
            boolean e = a2.e("a1_p_s_p_s");
            boolean e2 = a2.e("a1_p_s_p_s_c_b");
            ai aiVar = new ai(this.f23784a);
            jSONObject.put("0", aiVar.d());
            jSONObject.put("1", aiVar.a());
            jSONObject.put("2", aiVar.c());
            jSONObject.put("3", aiVar.f());
            jSONObject.put("24", aiVar.e());
            jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST, ab.b() ? 1 : 0);
            jSONObject.put(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET, ab.a(this.f23784a) ? 1 : 0);
            JSONObject a3 = ah.a(this.f23784a);
            if (a3 != null) {
                jSONObject.put("4", a3);
            }
            z zVar = new z();
            JSONArray a4 = zVar.a(this.f23784a);
            jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.V, a4);
            jSONObject.put("146", zVar.e());
            jSONObject.put("154", zVar.a());
            jSONObject.put("168", di.b(a4));
            jSONObject.put("169", di.a(a4));
            jSONObject.put("185", zVar.d());
            jSONObject.put("191", zVar.c());
            if (zVar.b() != null) {
                jSONObject.put("161", zVar.b());
            }
            jSONObject.put("22", ab.a());
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean a5 = acVar.a(this.f23784a);
            jSONObject.put("8", a5 ? 1 : 0);
            if (a5) {
                jSONObject.put("61", acVar.b(this.f23784a));
            }
            jSONObject.put("181", acVar.f(this.f23784a) ? 1 : 0);
            jSONObject.put("9", acVar.d(this.f23784a));
            jSONObject.put("10", acVar.e(this.f23784a));
            jSONObject.put("11", acVar.c(this.f23784a));
            ae aeVar = new ae();
            jSONObject.put("26", aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            jSONObject.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, aeVar.b("/proc/cpuinfo") ? 1 : 0);
            jSONObject.put("29", aeVar.b("/proc/meminfo") ? 1 : 0);
            jSONObject.put("96", aeVar.a());
            jSONObject.put("134", aeVar.b());
            an anVar = new an();
            Set<String> b = anVar.b();
            Set<String> c2 = anVar.c();
            if (c2 != null) {
                jSONObject.put(BaseWrapper.ENTER_ID_TOOLKIT, 1);
                jSONObject.put("32", new JSONArray((Collection) c2));
            } else {
                jSONObject.put(BaseWrapper.ENTER_ID_TOOLKIT, 0);
            }
            if (b != null) {
                jSONObject.put(BaseWrapper.ENTER_ID_OAPS_DEMO, 1);
                jSONObject.put(BaseWrapper.ENTER_ID_OAPS_ROAMING, new JSONArray((Collection) b));
            } else {
                jSONObject.put(BaseWrapper.ENTER_ID_OAPS_DEMO, 0);
            }
            Set<String> a6 = anVar.a();
            if (a6 != null) {
                jSONObject.put(BaseWrapper.ENTER_ID_OAPS_ASSISTANT_SCREEN, a6);
                if (b != null || c2 != null) {
                    HashSet hashSet = new HashSet();
                    if (b != null) {
                        hashSet.add(b);
                    }
                    if (c2 != null) {
                        hashSet.add(c2);
                    }
                    jSONObject.put("13", anVar.a(this.f23784a, 13, hashSet));
                    jSONObject.put("14", anVar.a(this.f23784a, 14, hashSet));
                    jSONObject.put("15", anVar.a(this.f23784a, 15, hashSet));
                    jSONObject.put("16", anVar.a(this.f23784a, 16, hashSet));
                    jSONObject.put("17", anVar.a(this.f23784a, 17, hashSet));
                    jSONObject.put("18", anVar.a(this.f23784a, 18, hashSet));
                    jSONObject.put("19", anVar.a(this.f23784a, 19, hashSet));
                    jSONObject.put(BaseWrapper.ENTER_ID_SYSTEM_HELPER, anVar.a(this.f23784a, 20, hashSet));
                    jSONObject.put("21", anVar.a(this.f23784a, 21, hashSet));
                    jSONObject.put("130", anVar.b(hashSet));
                }
            }
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean b2 = aoVar.b();
            jSONObject.put("66", b2 ? 1 : 0);
            if (b2) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put(PPSLauncherActivity.Code, aoVar.e());
            jSONObject.put("101", aoVar.c() ? 1 : 0);
            jSONObject.put(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB, aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            jSONObject.put(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL, new ad().a() ? 1 : 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bu.a(this.f23784a));
            jSONObject2.put("03014", bg.g(this.f23784a));
            jSONObject2.put("03020", bu.b(this.f23784a));
            jSONObject2.put("03030", bf.d(this.f23784a));
            jSONObject.put("51", jSONObject2);
            an anVar2 = new an();
            jSONObject.put("107", anVar2.d());
            jSONObject.put("155", anVar2.e());
            jSONObject.put("170", anVar2.g());
            jSONObject.put("190", anVar2.f());
            ag agVar = new ag();
            jSONObject.put("131", agVar.a());
            jSONObject.put("145", agVar.a(this.f23784a));
            jSONObject.put("132", dj.a());
            jSONObject.put("133", new ai(this.f23784a).g());
            if (a2.b(de.af, 1) == 1) {
                jSONObject.put("139", dk.c(this.f23784a));
                jSONObject.put("140", dk.d(this.f23784a));
                jSONObject.put("147", dk.a());
                jSONObject.put("148", dh.b());
                jSONObject.put("149", dh.c());
                jSONObject.put("151", dj.b());
            }
            if (a2.b(de.aa, 0) == 1) {
                if (e || e2) {
                    jSONObject.put("25", al.a(this.f23784a) ? 1 : 0);
                }
                jSONObject.put("128", ad.b() ? 1 : 0);
            }
            if (Engine.loadSuccess) {
                as asVar = new as(this.f23784a, 100);
                jSONObject.put("6", asVar.a("6"));
                JSONArray a7 = asVar.a(asVar.a(), "41");
                if (a7 != null && a7.length() > 0) {
                    JSONArray c3 = asVar.c(asVar.a(), "41");
                    JSONArray b3 = asVar.b(asVar.a(), "41");
                    jSONObject.put(BaseWrapper.ENTER_ID_OAPS_OPEN_GUIDE, c3);
                    jSONObject.put("43", b3);
                    jSONObject.put("41", asVar.a(asVar.a(a7, c3), b3));
                }
                jSONObject.put("47", asVar.a("47"));
                jSONObject.put(com.huawei.openalliance.ad.beans.inner.a.Code, asVar.a(com.huawei.openalliance.ad.beans.inner.a.Code));
                jSONObject.put("23", asVar.a("23"));
                jSONObject.put(BaseWrapper.ENTER_ID_OAPS_GAMESPACE, asVar.a(BaseWrapper.ENTER_ID_OAPS_GAMESPACE));
                jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SYS_CRASH, asVar.a(BaseWrapper.ENTER_ID_OAPS_SYS_CRASH));
                jSONObject.put(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER, asVar.b(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER));
                jSONObject.put("45", asVar.b("45"));
                jSONObject.put(BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP, asVar.e(BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP));
                jSONObject.put("91", asVar.a("91"));
                jSONObject.put("62", asVar.c("62"));
                jSONObject.put("63", asVar.c("63"));
                jSONObject.put("64", asVar.c("64"));
                jSONObject.put("85", asVar.d("85"));
                jSONObject.put("50", asVar.a("50"));
                jSONObject.put(hn.Code, asVar.c(hn.Code));
                jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SCANNER, asVar.a(BaseWrapper.ENTER_ID_OAPS_SCANNER));
                jSONObject.put("52", asVar.a("52"));
                jSONObject.put("53", asVar.a("53"));
                jSONObject.put("54", asVar.a("54"));
                jSONObject.put("55", asVar.a("55"));
                jSONObject.put("73", asVar.a("73"));
                jSONObject.put("74", asVar.a("74"));
                jSONObject.put("104", asVar.a("104"));
                if (a2.b(de.V, 1) == 1 && Build.VERSION.SDK_INT < 23) {
                    ar arVar = new ar(this.f23784a);
                    String a8 = arVar.a("57");
                    if (!TextUtils.isEmpty(a8)) {
                        jSONObject.put("57", a8);
                        jSONObject.put("56", arVar.a("56"));
                    }
                }
                jSONObject.put("77", asVar.a("77"));
                jSONObject.put("78", asVar.a("78"));
                jSONObject.put("79", asVar.a("79"));
                jSONObject.put("84", asVar.a("84"));
                jSONObject.put("80", asVar.a("80"));
                jSONObject.put("81", asVar.a("81"));
                jSONObject.put("82", asVar.a("82"));
                jSONObject.put("83", asVar.a("83"));
                jSONObject.put("87", asVar.a("87"));
                jSONObject.put("89", asVar.a("89"));
                jSONObject.put("90", asVar.d("90"));
                jSONObject.put("75", asVar.a("75"));
                jSONObject.put("88", asVar.a("88"));
                jSONObject.put("92", asVar.a("92"));
                jSONObject.put("93", asVar.a("93"));
                jSONObject.put("94", asVar.a("94"));
                jSONObject.put("95", asVar.a("95"));
                jSONObject.put("98", asVar.a("98"));
                jSONObject.put("100", asVar.a("100"));
                jSONObject.put("105", asVar.a("105"));
                if (a2.b(de.X, 1) == 1) {
                    aq aqVar = new aq(this.f23784a, 0);
                    jSONObject.put("108", aqVar.a("108"));
                    jSONObject.put("109", aqVar.a("109"));
                    jSONObject.put("111", aqVar.a("111"));
                }
                if (a2.b(de.Z, 1) == 1) {
                    aq aqVar2 = new aq(this.f23784a, 1);
                    jSONObject.put("112", aqVar2.b("112"));
                    jSONObject.put("113", aqVar2.a("113"));
                    jSONObject.put("114", aqVar2.a("114"));
                    jSONObject.put("115", aqVar2.a("115"));
                    jSONObject.put("116", aqVar2.a("116"));
                    jSONObject.put("117", aqVar2.a("117"));
                    jSONObject.put(Camera.Parameters.VIDEO_HFR_4X, aqVar2.a(Camera.Parameters.VIDEO_HFR_4X));
                    aq aqVar3 = new aq(this.f23784a, 4);
                    jSONObject.put("124", aqVar3.a("124"));
                    jSONObject.put("125", aqVar3.a("125"));
                    jSONObject.put("126", aqVar3.a("126"));
                    jSONObject.put("127", aqVar3.a("127"));
                }
                if (a2.b(de.ab, 0) == 1) {
                    av avVar = new av(this.f23784a, 100);
                    jSONObject.put("97", avVar.a("97"));
                    jSONObject.put("118", avVar.a("118"));
                    jSONObject.put("119", avVar.a("119"));
                    jSONObject.put("135", avVar.a("135"));
                    jSONObject.put("174", avVar.a("174"));
                    av avVar2 = new av(this.f23784a, 200);
                    jSONObject.put("173", avVar2.a("173"));
                    jSONObject.put("182", avVar2.a("182"));
                }
                if (a2.b(de.W, 1) == 1) {
                    jSONObject.put("129", new bd(this.f23784a, 4).a("129"));
                    bd bdVar = new bd(this.f23784a, 1);
                    jSONObject.put("121", bdVar.a(bdVar.a(), "121"));
                    bd bdVar2 = new bd(this.f23784a, 2);
                    jSONObject.put("137", bdVar2.a("137"));
                    jSONObject.put("138", bdVar2.a("138"));
                    jSONObject.put("141", bdVar2.a("141"));
                    jSONObject.put("142", bdVar2.a("142"));
                    be beVar = new be(this.f23784a, 3);
                    JSONArray b4 = beVar.b("150");
                    jSONObject.put("150", b4);
                    if (b4 != null) {
                        jSONObject.put("188", beVar.a(b4));
                    }
                }
                if (a2.b(de.S, 1) == 1) {
                    az azVar = new az(this.f23784a, 100);
                    jSONObject.put("152", azVar.a("152"));
                    jSONObject.put("153", azVar.a("153"));
                    jSONObject.put("156", azVar.a("156"));
                    jSONObject.put("157", azVar.a("157"));
                    jSONObject.put("163", azVar.a("163"));
                    jSONObject.put("171", azVar.a("171", true));
                    jSONObject.put("172", azVar.b("172"));
                    jSONObject.put("177", new az(this.f23784a, 500).d("177"));
                }
                if ((e || e2) && a2.b(de.U, 0) == 1) {
                    jSONObject.put("158", new az(this.f23784a, 300).b("158"));
                }
                if (a2.b(de.ae, 0) == 1) {
                    bc bcVar = new bc(this.f23784a);
                    jSONObject.put("162", bcVar.a("162"));
                    jSONObject.put("160", bcVar.a(bcVar.a(), "160"));
                    az azVar2 = new az(this.f23784a, 400);
                    jSONObject.put("164", azVar2.a("164"));
                    jSONObject.put("165", azVar2.a("165"));
                    jSONObject.put("166", azVar2.c("166"));
                    jSONObject.put("167", azVar2.a("167"));
                }
                if (a2.b(de.ac, 1) == 1) {
                    ax axVar = new ax(this.f23784a, 600);
                    jSONObject.put("179", axVar.a("179"));
                    jSONObject.put("186", axVar.a("186"));
                    jSONObject.put("189", axVar.a("189"));
                }
            }
            jSONObject.put("58", ae.a(this.f23784a));
            jSONObject.put(Camera.Parameters.VIDEO_HFR_2X, ab.b(this.f23784a) ? 1 : 0);
            jSONObject.put(WbFaceError.WBFaceErrorCodeInputParaNull, Engine.loadSuccess ? 1 : 0);
            jSONObject.put(WbFaceError.WBFaceErrorCodeDataSerilizerError, Engine.soVersion);
            jSONObject.put("11008", a2.b(de.g, bp.e));
            jSONObject.put("11009", br.a(this.f23784a.getApplicationContext()));
            try {
                jSONObject.put("11301", bg.c(com.kwad.sdk.d.b.Ax().Aw()));
                jSONObject.put("11302", bg.c(com.kwad.sdk.d.b.Ax().getSdkVersion()));
                jSONObject.put("11303", bg.c(com.kwad.sdk.d.b.Ax().getAppId()));
            } catch (Throwable th) {
            }
            String b5 = a2.b(de.k, "", true);
            if (!TextUtils.isEmpty(b5)) {
                jSONObject.put("183", b5);
                a2.c(de.k, "");
            }
            jSONObject.put("187", ak.a(this.f23784a) ? 1 : 0);
            jSONObject.put("11006", e ? 1 : 0);
            jSONObject.put("11029", e2 ? 1 : 0);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            jSONObject.put(PushConsts.SEND_MESSAGE_ERROR, this.b);
            jSONObject.put("20001", this.f23785c);
            try {
                jSONObject.put("02078", A.getE("W_S_V"));
                jSONObject.put("02079", A.getE("W_S_S_V"));
            } catch (Throwable th2) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable th3) {
            return null;
        }
    }
}
