package com.opos.mobad.model.d;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.b.a.b;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.data.FloatLayerData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.model.data.PendantData;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final int f26413a = y.e.APP_INSTALLED.a();
    private static final int b = y.e.APP_UNINSTALLED.a();

    private static com.opos.mobad.model.b.e a(Context context, x xVar) {
        if (com.opos.cmn.d.b.a(com.opos.cmn.d.c.a(context, xVar.d), xVar.e)) {
            return null;
        }
        com.opos.mobad.model.b.e eVar = new com.opos.mobad.model.b.e();
        eVar.a(xVar.d);
        eVar.b(xVar.e);
        eVar.c(com.opos.cmn.d.c.a(context, xVar.d));
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MaterialFileData a(Context context, com.opos.mobad.b.a.b bVar, Set<com.opos.mobad.model.b.e> set, boolean z, q qVar) {
        x xVar = bVar.D;
        if (z) {
            set = null;
        }
        return a(context, xVar, true, set, qVar);
    }

    private static MaterialFileData a(Context context, x xVar, boolean z) {
        if (xVar != null) {
            MaterialFileData materialFileData = new MaterialFileData();
            materialFileData.a(z ? xVar.d : com.opos.cmn.d.c.a(context, xVar.d));
            materialFileData.b(xVar.e);
            return materialFileData;
        }
        return null;
    }

    private static MaterialFileData a(Context context, x xVar, boolean z, Set<com.opos.mobad.model.b.e> set, q qVar) {
        if (xVar == null || com.opos.cmn.an.c.a.a(xVar.d)) {
            return null;
        }
        if (set != null) {
            com.opos.mobad.model.b.e a2 = a(context, xVar);
            if (a2 != null) {
                set.add(a2);
                if (!z) {
                    com.opos.mobad.service.j.n.a().a(false);
                }
            } else {
                if (!z) {
                    com.opos.mobad.service.j.n.a().a(true);
                }
                if (qVar != null) {
                    qVar.a(xVar.d, 2);
                }
                com.opos.cmn.an.f.a.b("AdLoader", "material File " + xVar.toString() + " exists,don't need download again!!!");
            }
            return a(context, xVar, false);
        }
        return a(context, xVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<MaterialData> a(Context context, y yVar, Set<com.opos.mobad.model.b.e> set, Set<com.opos.mobad.model.b.e> set2, boolean z, q qVar) {
        List<MaterialFileData> a2;
        List<MaterialFileData> a3;
        List<MaterialFileData> a4;
        List<x> list = yVar.V;
        if (z) {
            a2 = a(context, list, null, qVar);
            a3 = a(context, yVar.ba, null, qVar);
            a4 = yVar.Q == y.b.RAW_VIDEO ? a(context, yVar.S, set2, qVar) : a(context, yVar.S, null, qVar);
        } else {
            a2 = a(context, list, set, qVar);
            a3 = a(context, yVar.ba, set2, qVar);
            a4 = a(context, yVar.S, set, qVar);
        }
        MaterialData materialData = new MaterialData(yVar, a4, a2, a(context, yVar.aq, null, qVar), a3, yVar.aH != null ? new FloatLayerData(yVar.aH, a(context, yVar.aH.d, false, set, qVar), a(context, yVar.aH.g, set2, qVar), a(context, yVar.aH.h, set2, qVar)) : null, yVar.aY != null ? new PendantData(a(context, yVar.aY.g, false, set2, qVar), yVar.aY) : null);
        ArrayList arrayList = new ArrayList();
        arrayList.add(materialData);
        return arrayList;
    }

    private static List<MaterialFileData> a(Context context, List<x> list, Set<com.opos.mobad.model.b.e> set, q qVar) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            if (list.size() <= 0) {
                return arrayList;
            }
            for (x xVar : list) {
                MaterialFileData a2 = a(context, xVar, false, set, qVar);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, com.opos.mobad.b.a.b bVar, List<x> list) {
        if (bVar.M == b.c.PLAY_CACHE) {
            x xVar = list.get(0);
            if (TextUtils.isEmpty(com.opos.cmn.d.d.a(context, xVar.d, xVar.e))) {
                com.opos.mobad.service.j.n.a().b(false);
                com.opos.cmn.an.f.a.b("AdLoader", "isVideoEnableMaterial but not cache video");
                return false;
            }
            com.opos.mobad.service.j.n.a().b(true);
        }
        com.opos.cmn.an.f.a.b("AdLoader", "isVideoEnableMaterial");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, y yVar, q qVar) {
        boolean z = yVar == null || !b(context, yVar, qVar);
        com.opos.cmn.an.f.a.b("AdLoader", "isValidMaterialEntity materialEntity=", yVar, "result=", Boolean.valueOf(z));
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(y yVar) {
        return yVar.Q == y.b.VIDEO || yVar.Q == y.b.FULL_VIDEO || yVar.Q == y.b.POP_WINDOW_VIDEO || yVar.Q == y.b.RAW_VIDEO || yVar.Q == y.b.VIDEO_HTML || yVar.Q == y.b.VIDEO_TIP_BAR;
    }

    static boolean b(Context context, y yVar, q qVar) {
        boolean z = true;
        if (yVar.aL != null) {
            int intValue = yVar.aL.intValue();
            int i = f26413a;
            if (i == (i & intValue) && !TextUtils.isEmpty(yVar.X) && com.opos.cmn.an.h.d.a.d(context, yVar.X)) {
                com.opos.cmn.an.f.a.b("AdLoader", "filter install");
                if (qVar != null) {
                    qVar.a(yVar);
                    return true;
                }
            } else {
                int i2 = b;
                if (i2 == (intValue & i2) && !TextUtils.isEmpty(yVar.X) && !com.opos.cmn.an.h.d.a.d(context, yVar.X)) {
                    com.opos.cmn.an.f.a.b("AdLoader", "filter uninstall");
                    if (qVar != null) {
                        qVar.g(yVar);
                        return true;
                    }
                }
            }
            return z;
        }
        z = false;
        return z;
    }

    public static boolean b(y yVar) {
        if (yVar == null) {
            return false;
        }
        return yVar.R == y.h.OPEN_MINI_PROGRAM || yVar.aI == y.h.OPEN_MINI_PROGRAM || yVar.aJ == y.h.OPEN_MINI_PROGRAM || yVar.au == y.h.OPEN_MINI_PROGRAM || yVar.av == y.h.OPEN_MINI_PROGRAM;
    }
}
