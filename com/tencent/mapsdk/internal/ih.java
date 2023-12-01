package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.aggregation.AggregationOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.aggregation.HoneyCombVectorOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.aggregation.SquareVectorOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.datamodels.WeightedLatLng;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.b4;
import com.tencent.mapsdk.internal.g4;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ih.class */
public class ih implements lh {
    @Override // com.tencent.mapsdk.internal.lh
    public BaseOverlayProvider a(g4 g4Var) {
        g4.c.d dVar;
        if ((g4Var instanceof b4) && g4Var.a()) {
            b4 b4Var = (b4) g4Var;
            AggregationOverlayProvider honeyCombVectorOverlayProvider = b4Var.b.f23617c.f23618c.f23619a.f23622a.f23621c.equals("hexagon") ? new HoneyCombVectorOverlayProvider() : b4Var.b.f23617c.f23618c.f23619a.f23622a.f23621c.equals("grid") ? new SquareVectorOverlayProvider() : null;
            if (honeyCombVectorOverlayProvider == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (g4.a.C0787a.AbstractC0788a abstractC0788a : b4Var.b.b.b) {
                if (abstractC0788a instanceof g4.a.C0787a.e) {
                    arrayList.addAll(((g4.a.C0787a.e) abstractC0788a).f23772c);
                }
            }
            AggregationOverlayProvider nodes = honeyCombVectorOverlayProvider.nodes((WeightedLatLng[]) arrayList.toArray(new WeightedLatLng[0]));
            int size = b4Var.b.f23617c.f23618c.f23619a.f23622a.d.b.size();
            int[] iArr = new int[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                iArr[i2] = b4Var.b.f23617c.f23618c.f23619a.f23622a.d.b.get(i2).intValue();
                i = i2 + 1;
            }
            double[] dArr = new double[b4Var.b.f23617c.f23618c.f23619a.f23622a.d.f23780a.size()];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    break;
                }
                dArr[i4] = b4Var.b.f23617c.f23618c.f23619a.f23622a.d.f23780a.get(i4).doubleValue();
                i3 = i4 + 1;
            }
            nodes.colors(iArr, dArr);
            nodes.size(b4Var.b.f23617c.f23618c.f23619a.f23622a.b);
            nodes.gap(b4Var.b.f23617c.f23618c.f23619a.f23622a.f23620a);
            nodes.setHeightRange(b4Var.b.f23617c.d.k.get(0).doubleValue(), b4Var.b.f23617c.d.k.get(1).doubleValue());
            b4.a.C0776a.C0777a c0777a = b4Var.b.f23617c.d;
            nodes.setIntensityRange(c0777a.i, c0777a.h);
            b4.a.C0776a.C0777a c0777a2 = b4Var.b.f23617c.d;
            nodes.zoomRange(c0777a2.f, c0777a2.e);
            nodes.zIndex(b4Var.b.f23617c.d.b);
            nodes.displayLevel(b4Var.b.f23617c.d.f23775a);
            nodes.enable3D(b4Var.b.f23617c.d.j);
            nodes.opacity((float) b4Var.b.f23617c.d.d);
            nodes.visibility(!b4Var.b.f23617c.d.f23776c);
            b4.a.C0776a c0776a = b4Var.b.f23617c;
            if (!c0776a.d.l || (dVar = c0776a.f23618c.f23619a.f23622a.e) == null) {
                nodes.setAnimateDuration(0);
                return nodes;
            }
            nodes.setAnimateDuration((int) (dVar.f23779a * 1000.0d));
            return nodes;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.lh
    public g4 a(g4 g4Var, String str) {
        return g4Var;
    }

    @Override // com.tencent.mapsdk.internal.lh
    /* renamed from: b */
    public b4 a(byte[] bArr) {
        return (b4) JsonUtils.parseToModel(new String(bArr), b4.class, new Object[0]);
    }
}
