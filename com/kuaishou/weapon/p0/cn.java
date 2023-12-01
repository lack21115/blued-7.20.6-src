package com.kuaishou.weapon.p0;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsWrapper;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.activity.PPSLauncherActivity;
import com.kuaishou.weapon.p0.jni.Engine;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.tendinsv.a.b;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cn.class */
public class cn {

    /* renamed from: a  reason: collision with root package name */
    private Context f10181a;

    public cn(Context context) {
        this.f10181a = context;
    }

    private JSONObject a() {
        try {
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f10181a, "re_po_rt");
            boolean e = a2.e("a1_p_s_p_s");
            boolean e2 = a2.e("a1_p_s_p_s_c_b");
            ai aiVar = new ai(this.f10181a);
            jSONObject.put("0", aiVar.d());
            jSONObject.put("1", aiVar.a());
            jSONObject.put("2", aiVar.c());
            jSONObject.put("3", aiVar.f());
            jSONObject.put("24", aiVar.e());
            jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST, ab.b() ? 1 : 0);
            jSONObject.put(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET, ab.a(this.f10181a) ? 1 : 0);
            JSONObject a3 = ah.a(this.f10181a);
            if (a3 != null) {
                jSONObject.put("4", a3);
            }
            if (a2.b(de.aa, 0) == 1 && (e || e2)) {
                jSONObject.put("25", al.a(this.f10181a) ? 1 : 0);
            }
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean a4 = acVar.a(this.f10181a);
            jSONObject.put("8", a4 ? 1 : 0);
            if (a4) {
                jSONObject.put("61", acVar.b(this.f10181a));
            }
            jSONObject.put("10", acVar.e(this.f10181a));
            jSONObject.put("11", acVar.c(this.f10181a));
            ae aeVar = new ae();
            jSONObject.put("26", aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean b = aoVar.b();
            jSONObject.put("66", b ? 1 : 0);
            if (b) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put(PPSLauncherActivity.Code, aoVar.e());
            jSONObject.put("101", aoVar.c() ? 1 : 0);
            jSONObject.put("102", aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bu.a(this.f10181a));
            jSONObject2.put("03014", bg.g(this.f10181a));
            jSONObject2.put("03020", bu.b(this.f10181a));
            jSONObject2.put("03030", bf.d(this.f10181a));
            jSONObject.put("51", jSONObject2);
            jSONObject.put("107", new an().d());
            jSONObject.put(Camera.Parameters.VIDEO_HFR_2X, ab.b(this.f10181a) ? 1 : 0);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            try {
                jSONObject.put("11301", bg.c(com.kwad.sdk.d.b.Ax().Aw()));
                jSONObject.put("11302", bg.c(com.kwad.sdk.d.b.Ax().getSdkVersion()));
                jSONObject.put("11303", bg.c(com.kwad.sdk.d.b.Ax().getAppId()));
                jSONObject.put(WbFaceError.WBFaceErrorCodeDataSerilizerError, Engine.soVersion);
                return jSONObject;
            } catch (Exception e3) {
                return jSONObject;
            }
        } catch (Throwable th) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a2;
        JSONObject a3;
        try {
            cl clVar = new cl(str, cj.j);
            String a4 = dk.a(ct.f10190a);
            String b = b(a4);
            if (TextUtils.isEmpty(b) || (a2 = clVar.a(this.f10181a)) == null) {
                return null;
            }
            String str2 = ct.h + "?" + cu.a(this.f10181a);
            String str3 = str2;
            if (ct.a()) {
                str3 = str2;
                if (ct.f10190a.contains("api")) {
                    str3 = "/api" + str2;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(b.a.q, b);
            jSONObject.put("host", a4);
            jSONObject.put(OapsWrapper.KEY_PATH, str3);
            String str4 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str4) && str4.length() > 10) {
                jSONObject.put("cookie", str4);
            }
            jSONObject.put("head", a2);
            StringBuilder sb = new StringBuilder();
            sb.append("sdk=" + Build.VERSION.SDK_INT);
            jSONObject.put("parame", sb.toString());
            if (str.equals(cj.h) && (a3 = a()) != null) {
                jSONObject.put("sjd", a3);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String hostAddress = InetAddress.getByName(dk.a(str)).getHostAddress();
            try {
                return !TextUtils.isEmpty(hostAddress) ? !hostAddress.contains(".") ? "" : hostAddress : "";
            } catch (UnknownHostException e) {
                return hostAddress;
            }
        } catch (UnknownHostException e2) {
            return "";
        }
    }
}
