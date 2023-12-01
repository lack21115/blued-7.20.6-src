package com.opos.mobad.ad.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/q.class */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public int f11985a;
    public String b;

    public q(int i, String str) {
        this.f11985a = i;
        this.b = str;
    }

    public void a(int i) {
        this.f11985a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String toString() {
        return "NativeAdError{code=" + this.f11985a + ", msg='" + this.b + "'}";
    }
}
