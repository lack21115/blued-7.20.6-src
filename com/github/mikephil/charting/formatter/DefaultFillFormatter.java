package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/formatter/DefaultFillFormatter.class */
public class DefaultFillFormatter implements IFillFormatter {
    @Override // com.github.mikephil.charting.formatter.IFillFormatter
    public float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        float yChartMax = lineDataProvider.getYChartMax();
        float yChartMin = lineDataProvider.getYChartMin();
        LineData lineData = lineDataProvider.getLineData();
        if (iLineDataSet.K() <= 0.0f || iLineDataSet.J() >= 0.0f) {
            if (lineData.f() > 0.0f) {
                yChartMax = 0.0f;
            }
            if (lineData.e() < 0.0f) {
                yChartMin = 0.0f;
            }
            return iLineDataSet.J() >= 0.0f ? yChartMin : yChartMax;
        }
        return 0.0f;
    }
}
