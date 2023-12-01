package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/formatter/DefaultAxisValueFormatter.class */
public class DefaultAxisValueFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    protected DecimalFormat f22140a;
    protected int b;

    public DefaultAxisValueFormatter(int i) {
        this.b = i;
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.f22140a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
                return;
            }
            if (i3 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
            i2 = i3 + 1;
        }
    }

    public int a() {
        return this.b;
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String a(float f) {
        return this.f22140a.format(f);
    }
}
