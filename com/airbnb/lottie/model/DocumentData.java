package com.airbnb.lottie.model;

/* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/DocumentData.class */
public class DocumentData {
    public final String a;
    public final String b;
    public final double c;
    public final Justification d;
    public final int e;
    public final double f;
    public final double g;
    public final int h;
    public final int i;
    public final double j;
    public final boolean k;

    /* loaded from: source-6737240-dex2jar.jar:com/airbnb/lottie/model/DocumentData$Justification.class */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, double d, Justification justification, int i, double d2, double d3, int i2, int i3, double d4, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = d;
        this.d = justification;
        this.e = i;
        this.f = d2;
        this.g = d3;
        this.h = i2;
        this.i = i3;
        this.j = d4;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (int) ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c);
        int ordinal = this.d.ordinal();
        int i = this.e;
        long doubleToLongBits = Double.doubleToLongBits(this.f);
        return (((((((hashCode * 31) + ordinal) * 31) + i) * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.h;
    }
}
