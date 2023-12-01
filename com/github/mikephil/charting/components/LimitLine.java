package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/LimitLine.class */
public class LimitLine extends ComponentBase {

    /* renamed from: a  reason: collision with root package name */
    private float f8497a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private int f8498c;
    private Paint.Style d;
    private String e;
    private DashPathEffect f;
    private LimitLabelPosition g;

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/LimitLine$LimitLabelPosition.class */
    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public float a() {
        return this.f8497a;
    }

    public float b() {
        return this.b;
    }

    public int c() {
        return this.f8498c;
    }

    public DashPathEffect d() {
        return this.f;
    }

    public Paint.Style e() {
        return this.d;
    }

    public LimitLabelPosition f() {
        return this.g;
    }

    public String g() {
        return this.e;
    }
}
