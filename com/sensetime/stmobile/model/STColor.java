package com.sensetime.stmobile.model;

/* loaded from: source-8303388-dex2jar.jar:com/sensetime/stmobile/model/STColor.class */
public class STColor {

    /* renamed from: a  reason: collision with root package name */
    public float f28093a;
    public float b;
    public float g;
    public float r;

    public STColor(float f, float f2, float f3, float f4) {
        this.r = f;
        this.g = f2;
        this.b = f3;
        this.f28093a = f4;
    }

    public float getA() {
        return this.f28093a;
    }

    public float getB() {
        return this.b;
    }

    public float getG() {
        return this.g;
    }

    public float getR() {
        return this.r;
    }

    public String toString() {
        return "STColor{r=" + this.r + ", g=" + this.g + ", b=" + this.b + ", a=" + this.f28093a + '}';
    }
}
