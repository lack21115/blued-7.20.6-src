package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/formatter/ValueFormatter.class */
public abstract class ValueFormatter implements IAxisValueFormatter, IValueFormatter {
    public String a(float f) {
        return String.valueOf(f);
    }

    public String a(float f, AxisBase axisBase) {
        return a(f);
    }

    public String a(float f, BarEntry barEntry) {
        return a(f);
    }

    public String a(float f, PieEntry pieEntry) {
        return a(f);
    }

    public String a(BarEntry barEntry) {
        return a(barEntry.b());
    }

    public String a(BubbleEntry bubbleEntry) {
        return a(bubbleEntry.a());
    }

    public String a(CandleEntry candleEntry) {
        return a(candleEntry.a());
    }

    public String a(Entry entry) {
        return a(entry.b());
    }

    public String a(RadarEntry radarEntry) {
        return a(radarEntry.b());
    }
}
