package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointD;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/highlight/BarHighlighter.class */
public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
    public BarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected float a(float f, float f2, float f3, float f4) {
        return Math.abs(f - f3);
    }

    protected int a(Range[] rangeArr, float f) {
        int i = 0;
        if (rangeArr != null) {
            if (rangeArr.length == 0) {
                return 0;
            }
            int i2 = 0;
            for (Range range : rangeArr) {
                if (range.a(f)) {
                    return i2;
                }
                i2++;
            }
            int max = Math.max(rangeArr.length - 1, 0);
            i = 0;
            if (f > rangeArr[max].b) {
                i = max;
            }
        }
        return i;
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected BarLineScatterCandleBubbleData a() {
        return ((BarDataProvider) this.f22148a).getBarData();
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter, com.github.mikephil.charting.highlight.IHighlighter
    public Highlight a(float f, float f2) {
        Highlight a2 = super.a(f, f2);
        if (a2 == null) {
            return null;
        }
        MPPointD b = b(f, f2);
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarDataProvider) this.f22148a).getBarData().a(a2.f());
        if (iBarDataSet.b()) {
            return a(a2, iBarDataSet, (float) b.f22202a, (float) b.b);
        }
        MPPointD.a(b);
        return a2;
    }

    public Highlight a(Highlight highlight, IBarDataSet iBarDataSet, float f, float f2) {
        BarEntry barEntry = (BarEntry) iBarDataSet.b(f, f2);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.a() == null) {
            return highlight;
        }
        Range[] c2 = barEntry.c();
        if (c2.length > 0) {
            int a2 = a(c2, f2);
            MPPointD b = ((BarDataProvider) this.f22148a).a(iBarDataSet.C()).b(highlight.a(), c2[a2].b);
            Highlight highlight2 = new Highlight(barEntry.i(), barEntry.b(), (float) b.f22202a, (float) b.b, highlight.f(), a2, highlight.h());
            MPPointD.a(b);
            return highlight2;
        }
        return null;
    }
}
