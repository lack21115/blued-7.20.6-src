package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.Legend;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/LegendEntry.class */
public class LegendEntry {

    /* renamed from: a  reason: collision with root package name */
    public String f8495a;
    public Legend.LegendForm b;

    /* renamed from: c  reason: collision with root package name */
    public float f8496c;
    public float d;
    public DashPathEffect e;
    public int f;

    public LegendEntry() {
        this.b = Legend.LegendForm.DEFAULT;
        this.f8496c = Float.NaN;
        this.d = Float.NaN;
        this.e = null;
        this.f = 1122867;
    }

    public LegendEntry(String str, Legend.LegendForm legendForm, float f, float f2, DashPathEffect dashPathEffect, int i) {
        this.b = Legend.LegendForm.DEFAULT;
        this.f8496c = Float.NaN;
        this.d = Float.NaN;
        this.e = null;
        this.f = 1122867;
        this.f8495a = str;
        this.b = legendForm;
        this.f8496c = f;
        this.d = f2;
        this.e = dashPathEffect;
        this.f = i;
    }
}
