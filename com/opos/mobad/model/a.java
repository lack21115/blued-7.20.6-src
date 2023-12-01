package com.opos.mobad.model;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.d.d;
import com.opos.cmn.d.e;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.n.d.h;
import java.text.DecimalFormat;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/a.class */
public class a {
    private static com.opos.mobad.n.d.a a(AppPrivacyData appPrivacyData) {
        if (appPrivacyData == null) {
            return null;
        }
        return new com.opos.mobad.n.d.a(appPrivacyData.d, appPrivacyData.f12781c);
    }

    public static final h a(Context context, AdItemData adItemData, MaterialData materialData, boolean z) {
        return a(context, adItemData, materialData, z, materialData.Z());
    }

    public static final h a(Context context, AdItemData adItemData, MaterialData materialData, boolean z, boolean z2) {
        return a(context, adItemData, materialData, z, z2, 0, 0);
    }

    public static final h a(Context context, AdItemData adItemData, MaterialData materialData, boolean z, boolean z2, int i, int i2) {
        h hVar = new h();
        hVar.a(materialData.i()).b(materialData.h()).a(adItemData.j()).c(adItemData.B()).d(a(context, materialData, z)).f(adItemData.k()).g(materialData.g).a(adItemData.K() > 0 ? adItemData.K() : materialData.u(), materialData.v() * 1000).e(adItemData.b()).h(adItemData.T()).a(a(adItemData.O())).h(a(materialData.ad())).g(b(materialData.l())).e(adItemData.U()).b(z2).a(i).b(i2).i(materialData.T() == 2 ? 1 : 0);
        MaterialFileData l = adItemData.l();
        if (l != null) {
            hVar.c(l.a(), l.b());
        }
        List<MaterialFileData> g = materialData.g();
        if (g != null && g.size() > 0) {
            hVar.a(g.get(0).a(), adItemData.f(), materialData.c());
        }
        List<MaterialFileData> f = materialData.f();
        if (f != null && f.size() > 0) {
            for (MaterialFileData materialFileData : f) {
                hVar.a(materialFileData.a(), materialFileData.b());
            }
        }
        List<MaterialFileData> j = materialData.j();
        if (j != null && j.size() > 0) {
            hVar.d(j.get(0).a(), j.get(0).b());
        }
        List<MaterialFileData> F = materialData.F();
        if (F != null && F.size() > 0) {
            MaterialFileData materialFileData2 = F.get(0);
            String a2 = materialFileData2.a();
            if (adItemData.r() == 1) {
                a2 = d.a(context, materialFileData2.a());
            } else if (adItemData.r() == 2) {
                a2 = e.a(context, materialFileData2.a());
            }
            hVar.e(a2, materialFileData2.b());
        }
        hVar.d(!adItemData.D());
        a(context, hVar, adItemData, materialData, z);
        a(hVar, adItemData, materialData);
        return hVar;
    }

    public static final h a(Context context, a.C0537a c0537a, boolean z, boolean z2) {
        return a(context, c0537a.b, c0537a.f12795c, z, z2);
    }

    private static String a(long j) {
        StringBuilder sb;
        if (j <= 0) {
            return null;
        }
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0");
            if (j >= 100000000) {
                sb = new StringBuilder();
                sb.append(decimalFormat.format(((float) j) / 1.0E8f));
                sb.append("亿次");
            } else if (j < 10000) {
                return null;
            } else {
                sb = new StringBuilder();
                sb.append(decimalFormat.format(((float) j) / 10000.0f));
                sb.append("万次");
            }
            return sb.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String a(Context context, MaterialData materialData, boolean z) {
        String str = "立刻打开";
        if (materialData != null) {
            if (z) {
                return "立刻打开";
            }
            if (TextUtils.isEmpty(materialData.Y())) {
                switch (materialData.e()) {
                    case 1:
                        return "点击查看";
                    case 2:
                        return (com.opos.cmn.an.c.a.a(materialData.k()) || !com.opos.cmn.an.h.d.a.d(context, materialData.k())) ? "点击安装" : "立刻打开";
                    case 3:
                        return (com.opos.cmn.an.c.a.a(materialData.k()) || !com.opos.cmn.an.h.d.a.d(context, materialData.k())) ? "立即下载" : "立刻打开";
                    case 5:
                        return "查看详情";
                    case 6:
                        return "秒开";
                    case 7:
                        return "打开";
                }
                return str;
            }
            return materialData.Y();
        }
        str = "";
        return str;
    }

    private static void a(Context context, h hVar, AdItemData adItemData, MaterialData materialData, boolean z) {
        MaterialFileData materialFileData;
        FloatLayerData U = materialData.U();
        if (U == null) {
            return;
        }
        hVar.k(U.c());
        hVar.l(U.b());
        hVar.k(U.c());
        hVar.j(a(context, materialData, z));
        List<MaterialFileData> d = U.d();
        if (d != null && d.size() > 0) {
            for (MaterialFileData materialFileData2 : d) {
                hVar.b(materialFileData2.a(), materialFileData2.b());
            }
        }
        MaterialFileData a2 = U.a();
        if (a2 != null) {
            hVar.f(a2.a(), a2.b());
        }
        List<MaterialFileData> e = U.e();
        if (e == null || e.size() <= 0 || (materialFileData = e.get(0)) == null) {
            return;
        }
        hVar.a(materialFileData.a(), materialFileData.b(), adItemData.f(), materialData.c());
    }

    private static void a(h hVar, AdItemData adItemData, MaterialData materialData) {
        if (com.opos.mobad.service.c.b.a().c(materialData.b()) == 0) {
            hVar.i(com.opos.mobad.service.c.b.a().d(materialData.b()));
        }
    }

    private static String b(long j) {
        StringBuilder sb;
        if (j <= 0) {
            return null;
        }
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0");
            if (j >= 1073741824) {
                sb = new StringBuilder();
                sb.append(decimalFormat.format(((float) j) / 1.07374182E9f));
                sb.append("GB");
            } else if (j < 1048576) {
                return null;
            } else {
                sb = new StringBuilder();
                sb.append(decimalFormat.format(((float) j) / 1048576.0f));
                sb.append("MB");
            }
            return sb.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("", "", (Throwable) e);
            return null;
        }
    }
}
