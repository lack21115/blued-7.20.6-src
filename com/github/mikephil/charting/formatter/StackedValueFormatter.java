package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/formatter/StackedValueFormatter.class */
public class StackedValueFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8539a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private DecimalFormat f8540c;

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String a(float f, BarEntry barEntry) {
        float[] a2;
        if (this.f8539a || (a2 = barEntry.a()) == null) {
            return this.f8540c.format(f) + this.b;
        } else if (a2[a2.length - 1] == f) {
            return this.f8540c.format(barEntry.b()) + this.b;
        } else {
            return "";
        }
    }
}
