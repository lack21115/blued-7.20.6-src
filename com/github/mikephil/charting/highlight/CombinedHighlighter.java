package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.List;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/highlight/CombinedHighlighter.class */
public class CombinedHighlighter extends ChartHighlighter<CombinedDataProvider> implements IHighlighter {

    /* renamed from: c  reason: collision with root package name */
    protected BarHighlighter f22149c;

    public CombinedHighlighter(CombinedDataProvider combinedDataProvider, BarDataProvider barDataProvider) {
        super(combinedDataProvider);
        this.f22149c = barDataProvider.getBarData() == null ? null : new BarHighlighter(barDataProvider);
    }

    @Override // com.github.mikephil.charting.highlight.ChartHighlighter
    protected List<Highlight> b(float f, float f2, float f3) {
        this.b.clear();
        List<BarLineScatterCandleBubbleData> p = ((CombinedDataProvider) this.f22148a).getCombinedData().p();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= p.size()) {
                return this.b;
            }
            BarLineScatterCandleBubbleData barLineScatterCandleBubbleData = p.get(i2);
            BarHighlighter barHighlighter = this.f22149c;
            if (barHighlighter == null || !(barLineScatterCandleBubbleData instanceof BarData)) {
                int d = barLineScatterCandleBubbleData.d();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < d) {
                        IDataSet a2 = p.get(i2).a(i4);
                        if (a2.p()) {
                            for (Highlight highlight : a(a2, i4, f, DataSet.Rounding.CLOSEST)) {
                                highlight.a(i2);
                                this.b.add(highlight);
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
            } else {
                Highlight a3 = barHighlighter.a(f2, f3);
                if (a3 != null) {
                    a3.a(i2);
                    this.b.add(a3);
                }
            }
            i = i2 + 1;
        }
    }
}
