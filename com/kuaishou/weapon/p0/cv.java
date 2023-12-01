package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.y;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.tencent.open.SocialConstants;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cv.class */
public class cv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f23802a;

    public cv(Context context) {
        this.f23802a = context;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x06d2 -> B:98:0x0278). Please submit an issue!!! */
    private y b(String str) {
        try {
            y yVar = new y();
            JSONObject jSONObject = new JSONObject(str);
            yVar.e(jSONObject.optInt("status", 1));
            if (yVar.z() != 1) {
                return null;
            }
            yVar.f(jSONObject.optInt("bwc", 3));
            yVar.g(jSONObject.optInt("blpc", 3));
            yVar.h(jSONObject.optInt("scc", 0));
            yVar.j(jSONObject.optString("dpver"));
            yVar.k(jSONObject.optString("bver"));
            yVar.d(jSONObject.optInt("dpd", 12));
            yVar.b(jSONObject.optInt("aar", 30));
            yVar.e(jSONObject.optString(SharePatchInfo.OAT_DIR));
            yVar.f(jSONObject.optString("is"));
            yVar.a(jSONObject.optInt("ii"));
            yVar.c(jSONObject.optInt(SocialConstants.PARAM_ACT, 0));
            try {
                yVar.h(jSONObject.optString("aver"));
                JSONObject jSONObject2 = jSONObject.getJSONObject("a");
                if (jSONObject2 != null) {
                    y.a aVar = new y.a();
                    try {
                        aVar.c(jSONObject2.optInt("as", 0));
                        aVar.d(jSONObject2.optInt("ac", 3));
                        aVar.e(jSONObject2.optInt(com.anythink.expressad.d.a.b.cZ, 8));
                        aVar.b(jSONObject2.optInt("ab", 0));
                        aVar.a(jSONObject2.optInt("am", 0));
                        yVar.a(aVar);
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
            try {
                yVar.b(jSONObject.optString("acver"));
                JSONObject jSONObject3 = jSONObject.getJSONObject("ac");
                if (jSONObject3 != null) {
                    y.b bVar = new y.b();
                    bVar.a(jSONObject3.optInt("acs", 1));
                    bVar.b(jSONObject3.optInt("acc", 3));
                    bVar.c(jSONObject3.optInt("aci", 8));
                    yVar.a(bVar);
                }
            } catch (Exception e3) {
            }
            try {
                yVar.a(jSONObject.optString("rver"));
                y.g gVar = new y.g();
                JSONObject jSONObject4 = jSONObject.getJSONObject("r");
                if (jSONObject4 != null) {
                    gVar.b(jSONObject4.optInt("rs", 1));
                    gVar.c(jSONObject4.optInt(com.anythink.core.common.g.c.R, 6));
                    gVar.d(jSONObject4.optInt("ri", 4));
                    gVar.e(jSONObject4.optInt("ro", 5));
                    gVar.a(jSONObject4.optInt("rb", 0));
                    JSONObject jSONObject5 = jSONObject4.getJSONObject("rcl");
                    y.g.a aVar2 = new y.g.a();
                    aVar2.l(jSONObject5.optInt("da", 1));
                    aVar2.b(jSONObject5.optInt("em", 1));
                    aVar2.m(jSONObject5.optInt(AppIconSetting.LARGE_ICON_URL, 1));
                    aVar2.f(jSONObject5.optInt("rcd", 1));
                    aVar2.g(jSONObject5.optInt("dv", 1));
                    aVar2.h(jSONObject5.optInt("re", 1));
                    aVar2.c(jSONObject5.optInt(com.anythink.expressad.video.dynview.a.a.Z, 1));
                    aVar2.a(jSONObject5.optInt("hk", 0));
                    aVar2.k(jSONObject5.optInt("vp", 0));
                    aVar2.i(jSONObject5.optInt("mc", 0));
                    aVar2.e(jSONObject5.optInt("sc", 1));
                    aVar2.d(jSONObject5.optInt("ud", 1));
                    aVar2.j(jSONObject5.optInt("xp", 1));
                    aVar2.n(jSONObject5.optInt("vl", 0));
                    gVar.a(aVar2);
                    yVar.a(gVar);
                }
            } catch (Exception e4) {
            }
            try {
                y.c cVar = new y.c();
                JSONObject jSONObject6 = jSONObject.getJSONObject("b");
                cVar.b(jSONObject6.optInt("bc", 2));
                cVar.c(jSONObject6.optInt("bi", 12));
                cVar.a(jSONObject6.optInt("bs", 1));
                try {
                    JSONObject jSONObject7 = jSONObject6.getJSONObject("pry");
                    y.c.b bVar2 = new y.c.b();
                    try {
                        bVar2.e(jSONObject7.optInt("gifa", 1));
                        bVar2.d(jSONObject7.optInt("gnci", 1));
                        bVar2.f(jSONObject7.optInt("gsl", 1));
                        bVar2.c(jSONObject7.optInt("gso", 1));
                        bVar2.a(jSONObject7.optInt("gno", 1));
                        bVar2.b(jSONObject7.optInt("gnon", 1));
                        bVar2.g(jSONObject7.optInt("rl", 1));
                        bVar2.i(jSONObject7.optInt("grs", 1));
                        bVar2.h(jSONObject7.optInt("grt", 1));
                        cVar.a(bVar2);
                    } catch (Exception e5) {
                    }
                } catch (Exception e6) {
                }
                try {
                    JSONObject jSONObject8 = jSONObject6.getJSONObject("bcl");
                    y.c.a aVar3 = new y.c.a();
                    aVar3.a(jSONObject8.optInt("a", 1));
                    aVar3.i(jSONObject8.optInt("r", 1));
                    aVar3.b(jSONObject8.optInt("c", 1));
                    aVar3.j(jSONObject8.optInt("s", 1));
                    aVar3.d(jSONObject8.optInt("d", 1));
                    aVar3.k(jSONObject8.optInt("u", 1));
                    aVar3.m(jSONObject8.optInt(IAdInterListener.AdReqParam.WIDTH, 0));
                    aVar3.f(jSONObject8.optInt("n", 0));
                    aVar3.p(jSONObject8.optInt("ie", 1));
                    aVar3.e(jSONObject8.optInt("is", 0));
                    try {
                        aVar3.n(jSONObject8.optInt("ic", 1));
                        try {
                            aVar3.o(jSONObject8.optInt("btm", 1));
                            aVar3.l(jSONObject8.optInt("mc", 1));
                            aVar3.q(jSONObject8.optInt("rp", 1));
                            aVar3.g(jSONObject8.optInt("tc", 1));
                            aVar3.c(jSONObject8.optInt("il", 1));
                            try {
                                aVar3.h(jSONObject8.optInt("p", 1));
                                aVar3.r(jSONObject8.optInt("l", 1));
                                cVar.a(aVar3);
                                yVar.a(cVar);
                            } catch (Exception e7) {
                            }
                        } catch (Exception e8) {
                        }
                    } catch (Exception e9) {
                    }
                } catch (Exception e10) {
                }
            } catch (Exception e11) {
            }
            try {
                yVar.g(jSONObject.optString("cver"));
                y.d dVar = new y.d();
                JSONObject jSONObject9 = jSONObject.getJSONObject("c");
                dVar.b(jSONObject9.optInt("cc", 2));
                dVar.c(jSONObject9.optInt("ci", 12));
                dVar.a(jSONObject9.optInt(OapsKey.KEY_CHECKSUM, 1));
                dVar.d(jSONObject9.optInt(OapsKey.KEY_CALLBACK, 0));
                JSONObject jSONObject10 = jSONObject9.getJSONObject("ccl");
                y.d.a aVar4 = new y.d.a();
                aVar4.a(jSONObject10.optInt("d", 1));
                aVar4.b(jSONObject10.optInt("mc", 1));
                aVar4.c(jSONObject10.optInt(IAdInterListener.AdReqParam.WIDTH, 0));
                aVar4.d(jSONObject10.optInt("is", 1));
                aVar4.e(jSONObject10.optInt("ic", 1));
                aVar4.f(jSONObject10.optInt("btm", 1));
                aVar4.g(jSONObject10.optInt("ie", 1));
                aVar4.h(jSONObject10.optInt("n", 0));
                dVar.a(aVar4);
                yVar.a(dVar);
            } catch (Exception e12) {
            }
            try {
                yVar.i(jSONObject.optString("pgver"));
                JSONObject optJSONObject = jSONObject.optJSONObject("p");
                if (optJSONObject != null) {
                    y.f fVar = new y.f();
                    fVar.a(optJSONObject.optInt("ps", 1));
                    fVar.b(optJSONObject.optInt(t.x, 2));
                    fVar.c(optJSONObject.optInt("pi", 12));
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("pcl");
                    if (optJSONObject2 != null) {
                        y.f.a aVar5 = new y.f.a();
                        aVar5.d(optJSONObject2.optInt(com.alipay.sdk.app.statistic.c.f4610c, 1));
                        aVar5.c(optJSONObject2.optInt(Launcher.Host.GC, 1));
                        aVar5.b(optJSONObject2.optInt("pke", 1));
                        aVar5.e(optJSONObject2.optInt("pds", 1));
                        aVar5.a(optJSONObject2.optInt("pam", 1));
                        fVar.a(aVar5);
                    }
                    yVar.a(fVar);
                }
            } catch (Exception e13) {
            }
            try {
                yVar.m(jSONObject.optString("socver"));
                JSONObject optJSONObject3 = jSONObject.optJSONObject("soc");
                if (optJSONObject3 != null) {
                    y.h hVar = new y.h();
                    hVar.c(optJSONObject3.optInt("socs", 0));
                    hVar.d(optJSONObject3.optInt("socc", 2));
                    hVar.b(optJSONObject3.optInt("soci", 12));
                    hVar.a(optJSONObject3.optInt("snack", 0));
                    yVar.a(hVar);
                }
            } catch (Exception e14) {
            }
            try {
                yVar.d(jSONObject.optString("hver"));
                JSONObject optJSONObject4 = jSONObject.optJSONObject("h");
                if (optJSONObject4 != null) {
                    y.e eVar = new y.e();
                    eVar.b(optJSONObject4.optInt("hs", 1));
                    eVar.c(optJSONObject4.optInt("hc", 2));
                    eVar.a(optJSONObject4.optInt("hi", 12));
                    eVar.d(optJSONObject4.optInt("hsdc", 1));
                    eVar.e(optJSONObject4.optInt("hlbr", 1));
                    eVar.a(optJSONObject4.optString("pr"));
                    yVar.a(eVar);
                }
                return yVar;
            } catch (Exception e15) {
                return yVar;
            }
        } catch (Exception e16) {
            return null;
        }
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                String a2 = new bm(this.f23802a).a(jSONObject.getString("antispamPluginRsp"));
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                y b = b(a2);
                if (b != null) {
                    de.a(this.f23802a).a(str, b);
                } else {
                    de.a(this.f23802a).b(System.currentTimeMillis());
                }
            }
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = ct.f23798a + ct.d;
            String a2 = cu.a(this.f23802a);
            String str2 = str;
            if (!TextUtils.isEmpty(a2)) {
                str2 = str + "?" + a2;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject b = cu.b(this.f23802a);
            if (b != null) {
                jSONObject.put("data", new bm(this.f23802a).c(b.toString()));
            }
            l a3 = l.a(this.f23802a);
            m mVar = new m(str2, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            a3.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cv.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str3) {
                    try {
                        cv.this.a(str3);
                    } catch (Exception e) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str3) {
                }
            });
        } catch (Exception e) {
        }
    }
}
