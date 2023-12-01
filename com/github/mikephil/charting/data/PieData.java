package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/PieData.class */
public class PieData extends ChartData<IPieDataSet> {
    @Override // com.github.mikephil.charting.data.ChartData
    public Entry a(Highlight highlight) {
        return a().e((int) highlight.a());
    }

    public IPieDataSet a() {
        return (IPieDataSet) this.i.get(0);
    }

    @Override // com.github.mikephil.charting.data.ChartData
    /* renamed from: b */
    public IPieDataSet a(int i) {
        if (i == 0) {
            return a();
        }
        return null;
    }

    public float l() {
        float f = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= a().H()) {
                return f;
            }
            f += a().e(i2).b();
            i = i2 + 1;
        }
    }
}
