package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/formatter/PercentFormatter.class */
public class PercentFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f8538a = new DecimalFormat("###,###,##0.0");
    private PieChart b;

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String a(float f) {
        return this.f8538a.format(f) + " %";
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String a(float f, PieEntry pieEntry) {
        PieChart pieChart = this.b;
        return (pieChart == null || !pieChart.i()) ? this.f8538a.format(f) : a(f);
    }
}
