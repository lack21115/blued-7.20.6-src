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
            AggregationOverlayProvider honeyCombVectorOverlayProvider = b4Var.b.f37308c.f37309c.f37310a.f37313a.f37312c.equals("hexagon") ? new HoneyCombVectorOverlayProvider() : b4Var.b.f37308c.f37309c.f37310a.f37313a.f37312c.equals("grid") ? new SquareVectorOverlayProvider() : null;
            if (honeyCombVectorOverlayProvider == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (g4.a.C0957a.AbstractC0958a abstractC0958a : b4Var.b.b.b) {
                if (abstractC0958a instanceof g4.a.C0957a.e) {
                    arrayList.addAll(((g4.a.C0957a.e) abstractC0958a).f37463c);
                }
            }
            AggregationOverlayProvider nodes = honeyCombVectorOverlayProvider.nodes((WeightedLatLng[]) arrayList.toArray(new WeightedLatLng[0]));
            int size = b4Var.b.f37308c.f37309c.f37310a.f37313a.d.b.size();
            int[] iArr = new int[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                iArr[i2] = b4Var.b.f37308c.f37309c.f37310a.f37313a.d.b.get(i2).intValue();
                i = i2 + 1;
            }
            double[] dArr = new double[b4Var.b.f37308c.f37309c.f37310a.f37313a.d.f37471a.size()];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    break;
                }
                dArr[i4] = b4Var.b.f37308c.f37309c.f37310a.f37313a.d.f37471a.get(i4).doubleValue();
                i3 = i4 + 1;
            }
            nodes.colors(iArr, dArr);
            nodes.size(b4Var.b.f37308c.f37309c.f37310a.f37313a.b);
            nodes.gap(b4Var.b.f37308c.f37309c.f37310a.f37313a.f37311a);
            nodes.setHeightRange(b4Var.b.f37308c.d.k.get(0).doubleValue(), b4Var.b.f37308c.d.k.get(1).doubleValue());
            b4.a.C0946a.C0947a c0947a = b4Var.b.f37308c.d;
            nodes.setIntensityRange(c0947a.i, c0947a.h);
            b4.a.C0946a.C0947a c0947a2 = b4Var.b.f37308c.d;
            nodes.zoomRange(c0947a2.f, c0947a2.e);
            nodes.zIndex(b4Var.b.f37308c.d.b);
            nodes.displayLevel(b4Var.b.f37308c.d.f37466a);
            nodes.enable3D(b4Var.b.f37308c.d.j);
            nodes.opacity((float) b4Var.b.f37308c.d.d);
            nodes.visibility(!b4Var.b.f37308c.d.f37467c);
            b4.a.C0946a c0946a = b4Var.b.f37308c;
            if (!c0946a.d.l || (dVar = c0946a.f37309c.f37310a.f37313a.e) == null) {
                nodes.setAnimateDuration(0);
                return nodes;
            }
            nodes.setAnimateDuration((int) (dVar.f37470a * 1000.0d));
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
