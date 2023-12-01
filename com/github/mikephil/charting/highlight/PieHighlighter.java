package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/highlight/PieHighlighter.class */
public class PieHighlighter extends PieRadarHighlighter<PieChart> {
    public PieHighlighter(PieChart pieChart) {
        super(pieChart);
    }

    @Override // com.github.mikephil.charting.highlight.PieRadarHighlighter
    protected Highlight a(int i, float f, float f2) {
        IPieDataSet a2 = ((PieData) ((PieChart) this.f8545a).getData()).a();
        return new Highlight(i, a2.e(i).b(), f, f2, 0, a2.C());
    }
}
