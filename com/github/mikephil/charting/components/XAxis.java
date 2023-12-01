package com.github.mikephil.charting.components;

import com.github.mikephil.charting.utils.Utils;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/XAxis.class */
public class XAxis extends AxisBase {
    public int C = 1;
    public int D = 1;
    public int E = 1;
    public int F = 1;
    protected float G = 0.0f;
    private boolean H = false;
    private XAxisPosition I = XAxisPosition.TOP;

    /* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/XAxis$XAxisPosition.class */
    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.y = Utils.a(4.0f);
    }

    public XAxisPosition A() {
        return this.I;
    }

    public float B() {
        return this.G;
    }

    public boolean C() {
        return this.H;
    }

    public void a(XAxisPosition xAxisPosition) {
        this.I = xAxisPosition;
    }
}
