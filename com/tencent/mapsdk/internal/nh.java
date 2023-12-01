package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.utilities.visualization.BaseOverlayProvider;
import com.tencent.map.sdk.utilities.visualization.heatmap.GradientVectorOverlayProvider;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.mapsdk.internal.g4;
import com.tencent.mapsdk.internal.i4;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/nh.class */
public class nh implements lh {
    @Override // com.tencent.mapsdk.internal.lh
    public BaseOverlayProvider a(g4 g4Var) {
        g4.c.d dVar;
        if ((g4Var instanceof i4) && g4Var.a()) {
            i4 i4Var = (i4) g4Var;
            GradientVectorOverlayProvider gradientVectorOverlayProvider = new GradientVectorOverlayProvider();
            ArrayList arrayList = new ArrayList();
            for (g4.a.C0957a.AbstractC0958a abstractC0958a : i4Var.b.b.b) {
                if (abstractC0958a instanceof g4.a.C0957a.e) {
                    arrayList.addAll(((g4.a.C0957a.e) abstractC0958a).f37463c);
                }
            }
            gradientVectorOverlayProvider.weightedData(arrayList);
            int size = i4Var.b.f37545c.f37546c.f37547a.f37550a.b.b.size();
            int[] iArr = new int[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                iArr[i2] = i4Var.b.f37545c.f37546c.f37547a.f37550a.b.b.get(i2).intValue();
                i = i2 + 1;
            }
            float[] fArr = new float[i4Var.b.f37545c.f37546c.f37547a.f37550a.b.f37471a.size()];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size) {
                    break;
                }
                fArr[i4] = i4Var.b.f37545c.f37546c.f37547a.f37550a.b.f37471a.get(i4).floatValue();
                i3 = i4 + 1;
            }
            gradientVectorOverlayProvider.gradient(iArr, fArr);
            gradientVectorOverlayProvider.radius(i4Var.b.f37545c.f37546c.f37547a.f37550a.f37548a);
            gradientVectorOverlayProvider.setMaxHeight(i4Var.b.f37545c.d.k.get(1).floatValue());
            i4.a.C0965a.C0966a c0966a = i4Var.b.f37545c.d;
            gradientVectorOverlayProvider.setIntensityRange((float) c0966a.i, (float) c0966a.h);
            i4.a.C0965a.C0966a c0966a2 = i4Var.b.f37545c.d;
            gradientVectorOverlayProvider.zoomRange(c0966a2.f, c0966a2.e);
            gradientVectorOverlayProvider.zIndex(i4Var.b.f37545c.d.b);
            gradientVectorOverlayProvider.displayLevel(i4Var.b.f37545c.d.f37466a);
            gradientVectorOverlayProvider.enable3D(i4Var.b.f37545c.d.j);
            gradientVectorOverlayProvider.opacity((float) i4Var.b.f37545c.d.d);
            gradientVectorOverlayProvider.visibility(!i4Var.b.f37545c.d.f37467c);
            i4.a.C0965a c0965a = i4Var.b.f37545c;
            if (!c0965a.d.l || (dVar = c0965a.f37546c.f37547a.f37550a.f37549c) == null) {
                gradientVectorOverlayProvider.setAnimateDuration(0);
                return gradientVectorOverlayProvider;
            }
            gradientVectorOverlayProvider.setAnimateDuration((int) (dVar.f37470a * 1000.0d));
            return gradientVectorOverlayProvider;
        }
        return null;
    }

    @Override // com.tencent.mapsdk.internal.lh
    public g4 a(g4 g4Var, String str) {
        return g4Var;
    }

    @Override // com.tencent.mapsdk.internal.lh
    public g4 a(byte[] bArr) {
        return (g4) JsonUtils.parseToModel(new String(bArr), i4.class, new Object[0]);
    }
}
