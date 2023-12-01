package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/formatter/LargeValueFormatter.class */
public class LargeValueFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    private String[] f22143a = {"", "k", "m", "b", "t"};
    private int b = 5;
    private String d = "";

    /* renamed from: c  reason: collision with root package name */
    private DecimalFormat f22144c = new DecimalFormat("###E00");

    private String a(double d) {
        String format = this.f22144c.format(d);
        int numericValue = Character.getNumericValue(format.charAt(format.length() - 1));
        String replaceAll = format.replaceAll("E[0-9][0-9]", this.f22143a[Integer.valueOf(Character.getNumericValue(format.charAt(format.length() - 2)) + "" + numericValue).intValue() / 3]);
        while (true) {
            String str = replaceAll;
            if (str.length() <= this.b && !str.matches("[0-9]+\\.[a-z]")) {
                return str;
            }
            replaceAll = str.substring(0, str.length() - 2) + str.substring(str.length() - 1);
        }
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String a(float f) {
        return a(f) + this.d;
    }
}
