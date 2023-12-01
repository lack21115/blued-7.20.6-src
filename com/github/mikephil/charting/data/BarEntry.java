package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Range;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/data/BarEntry.class */
public class BarEntry extends Entry {

    /* renamed from: a  reason: collision with root package name */
    private float[] f22118a;
    private Range[] b;

    /* renamed from: c  reason: collision with root package name */
    private float f22119c;
    private float d;

    public float[] a() {
        return this.f22118a;
    }

    @Override // com.github.mikephil.charting.data.BaseEntry
    public float b() {
        return super.b();
    }

    public Range[] c() {
        return this.b;
    }

    public boolean d() {
        return this.f22118a != null;
    }

    public float e() {
        return this.d;
    }

    public float f() {
        return this.f22119c;
    }
}
