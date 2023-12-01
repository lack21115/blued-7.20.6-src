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
                for (g4.a.C0787a.AbstractC0788a abstractC0788a : c4Var.b.b.b) {
                    if (abstractC0788a instanceof g4.a.C0787a.b) {
                        g4.a.C0787a.b bVar = (g4.a.C0787a.b) abstractC0788a;
                        arrayList.add(new FromToLatLng(bVar.f23769c.get(0), bVar.f23769c.get(1)));
                    }
                }
                arcLineOverlayProvider.data(arrayList);
            }
            g4.c.e eVar = c4Var.b.f23648c.f23649c.f23652a.f23656a.f23654c;
            if (eVar != null) {
                int size = eVar.b.size();
                int[] iArr = new int[size];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= size) {
                        break;
                    }
                    iArr[i2] = c4Var.b.f23648c.f23649c.f23652a.f23656a.f23654c.b.get(i2).intValue();
                    i = i2 + 1;
                }
                arcLineOverlayProvider.gradient(iArr);
            }
            arcLineOverlayProvider.width(c4Var.b.f23648c.f23649c.f23652a.f23656a.f23653a);
            arcLineOverlayProvider.radian((float) (c4Var.b.f23648c.f23649c.f23652a.f23656a.b * 90.0d));
            c4.a.C0781a.C0782a c0782a = c4Var.b.f23648c.d;
            arcLineOverlayProvider.zoomRange(c0782a.f, c0782a.e);
            arcLineOverlayProvider.zIndex(c4Var.b.f23648c.d.b);
            arcLineOverlayProvider.displayLevel(c4Var.b.f23648c.d.f23775a);
            arcLineOverlayProvider.enable3D(c4Var.b.f23648c.d.h);
            arcLineOverlayProvider.opacity((float) c4Var.b.f23648c.d.d);
            arcLineOverlayProvider.visibility(!c4Var.b.f23648c.d.f23776c);
            c4.a.C0781a.C0782a c0782a2 = c4Var.b.f23648c.d;
            if (!c0782a2.i) {
                arcLineOverlayProvider.setAnimateDuration(0);
                return arcLineOverlayProvider;
            }
            arcLineOverlayProvider.setAnimateDuration((int) (c0782a2.j.f23651c * 1000.0d));
            arcLineOverlayProvider.setHighlightDuration((int) (c4Var.b.f23648c.d.j.f23650a * 1000.0d));
            arcLineOverlayProvider.animateColor(c4Var.b.f23648c.d.j.b);
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
