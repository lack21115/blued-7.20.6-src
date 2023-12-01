package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/highlight/HorizontalBarHighlighter.class */
public class HorizontalBarHighlighter extends BarHighlighter {
    public HorizontalBarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.BarHighlighter, com.github.mikephil.charting.highlight.ChartHighlighter
    protected float a(float f, float f2, float f3, float f4) {
        return Math.abs(f2 - f4);
    }

    @Override // com.github.mikephil.charting.highlight.BarHighlighter, com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight a(float f, float f2) {
        BarData barData = ((BarDataProvider) this.f22148a).getBarData();
        MPPointD b = b(f2, f);
        Highlight a2 = a((float) b.b, f2, f);
        if (a2 == null) {
            return null;
        }
        IBarDataSet iBarDataSet = (IBarDataSet) barData.a(a2.f());
        if (iBarDataSet.b()) {
            return a(a2, iBarDataSet, (float) b.b, (float) b.f22202a);
        }
        MPPointD.a(b);
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    public List<Highlight> a(IDataSet iDataSet, int i, float f, DataSet.Rounding rounding) {
        ArrayList arrayList = new ArrayList();
        List b = iDataSet.b(f);
        List<Entry> list = b;
        if (b.size() == 0) {
            Entry a2 = iDataSet.a(f, Float.NaN, rounding);
            list = b;
            if (a2 != null) {
                list = iDataSet.b(a2.i());
            }
        }
        if (list.size() == 0) {
            return arrayList;
        }
        for (Entry entry : list) {
            MPPointD b2 = ((BarDataProvider) this.f22148a).a(iDataSet.C()).b(entry.b(), entry.i());
            arrayList.add(new Highlight(entry.i(), entry.b(), (float) b2.f22202a, (float) b2.b, i, iDataSet.C()));
        }
        return arrayList;
    }
}
