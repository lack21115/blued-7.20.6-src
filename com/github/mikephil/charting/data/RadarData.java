package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/RadarData.class */
public class RadarData extends ChartData<IRadarDataSet> {
    /* JADX WARN: Type inference failed for: r0v3, types: [com.github.mikephil.charting.data.Entry] */
    @Override // com.github.mikephil.charting.data.ChartData
    public Entry a(Highlight highlight) {
        return a(highlight.f()).e((int) highlight.a());
    }
}
