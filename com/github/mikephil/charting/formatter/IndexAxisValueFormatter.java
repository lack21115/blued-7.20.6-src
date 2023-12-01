package com.github.mikephil.charting.formatter;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/formatter/IndexAxisValueFormatter.class */
public class IndexAxisValueFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    private String[] f8535a = new String[0];
    private int b = 0;

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String a(float f) {
        int round = Math.round(f);
        return (round < 0 || round >= this.b || round != ((int) f)) ? "" : this.f8535a[round];
    }
}
