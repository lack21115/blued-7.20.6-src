package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.FromToLatLng;
import com.tencent.map.sdk.utilities.visualization.od.ArcLineOverlayProvider;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.c4;
import com.tencent.mapsdk.internal.g4;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/jh.class */
public class jh implements lh {
    @Override // com.tencent.mapsdk.internal.lh
    public BaseOverlayProvider a(g4 g4Var) {
        if ((g4Var instanceof c4) && g4Var.a()) {
            c4 c4Var = (c4) g4Var;
            ArcLineOverlayProvider arcLineOverlayProvider = new ArcLineOverlayProvider();
            if (c4Var.b.b.b != null) {
                ArrayList arrayList = new ArrayList();
                for (g4.a.C0957a.AbstractC0958a abstractC0958a : c4Var.b.b.b) {
                    if (abstractC0958a instanceof g4.a.C0957a.b) {
                        g4.a.C0957a.b bVar = (g4.a.C0957a.b) abstractC0958a;
                        arrayList.add(new FromToLatLng(bVar.f37460c.get(0), bVar.f37460c.get(1)));
                    }
                }
                arcLineOverlayProvider.data(arrayList);
            }
            g4.c.e eVar = c4Var.b.f37339c.f37340c.f37343a.f37347a.f37345c;
            if (eVar != null) {
                int size = eVar.b.size();
                int[] iArr = new int[size];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    iArr[i2] = c4Var.b.f37339c.f37340c.f37343a.f37347a.f37345c.b.get(i2).intValue();
                    i = i2 + 1;
                }
                arcLineOverlayProvider.gradient(iArr);
            }
            arcLineOverlayProvider.width(c4Var.b.f37339c.f37340c.f37343a.f37347a.f37344a);
            arcLineOverlayProvider.radian((float) (c4Var.b.f37339c.f37340c.f37343a.f37347a.b * 90.0d));
            c4.a.C0951a.C0952a c0952a = c4Var.b.f37339c.d;
            arcLineOverlayProvider.zoomRange(c0952a.f, c0952a.e);
            arcLineOverlayProvider.zIndex(c4Var.b.f37339c.d.b);
            arcLineOverlayProvider.displayLevel(c4Var.b.f37339c.d.f37466a);
            arcLineOverlayProvider.enable3D(c4Var.b.f37339c.d.h);
            arcLineOverlayProvider.opacity((float) c4Var.b.f37339c.d.d);
            arcLineOverlayProvider.visibility(!c4Var.b.f37339c.d.f37467c);
            c4.a.C0951a.C0952a c0952a2 = c4Var.b.f37339c.d;
            if (!c0952a2.i) {
                arcLineOverlayProvider.setAnimateDuration(0);
                return arcLineOverlayProvider;
            }
            arcLineOverlayProvider.setAnimateDuration((int) (c0952a2.j.f37342c * 1000.0d));
            arcLineOverlayProvider.setHighlightDuration((int) (c4Var.b.f37339c.d.j.f37341a * 1000.0d));
            arcLineOverlayProvider.animateColor(c4Var.b.f37339c.d.j.b);
            return arcLineOverlayProvider;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.lh
    public g4 a(g4 g4Var, String str) {
        return g4Var;
    }

    @Override // com.tencent.mapsdk.internal.lh
    public g4 a(byte[] bArr) {
        return (g4) JsonUtils.parseToModel(new String(bArr), c4.class, new Object[0]);
    }
}
