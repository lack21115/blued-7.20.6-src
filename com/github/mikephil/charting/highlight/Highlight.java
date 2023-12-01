package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/highlight/Highlight.class */
public class Highlight {

    /* renamed from: a  reason: collision with root package name */
    private float f22150a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f22151c;
    private float d;
    private int e;
    private int f;
    private int g;
    private YAxis.AxisDependency h;
    private float i;
    private float j;

    public Highlight(float f, float f2, float f3, float f4, int i, int i2, YAxis.AxisDependency axisDependency) {
        this(f, f2, f3, f4, i, axisDependency);
        this.g = i2;
    }

    public Highlight(float f, float f2, float f3, float f4, int i, YAxis.AxisDependency axisDependency) {
        this.f22150a = Float.NaN;
        this.b = Float.NaN;
        this.e = -1;
        this.g = -1;
        this.f22150a = f;
        this.b = f2;
        this.f22151c = f3;
        this.d = f4;
        this.f = i;
        this.h = axisDependency;
    }

    public float a() {
        return this.f22150a;
    }

    public void a(float f, float f2) {
        this.i = f;
        this.j = f2;
    }

    public void a(int i) {
        this.e = i;
    }

    public boolean a(Highlight highlight) {
        return highlight != null && this.f == highlight.f && this.f22150a == highlight.f22150a && this.g == highlight.g && this.e == highlight.e;
    }

    public float b() {
        return this.b;
    }

    public float c() {
        return this.f22151c;
    }

    public float d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public int g() {
        return this.g;
    }

    public YAxis.AxisDependency h() {
        return this.h;
    }

    public float i() {
        return this.i;
    }

    public float j() {
        return this.j;
    }

    public String toString() {
        return "Highlight, x: " + this.f22150a + ", y: " + this.b + ", dataSetIndex: " + this.f + ", stackIndex (only stacked barentry): " + this.g;
    }
}
