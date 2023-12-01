package com.opos.mobad.ad.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/q.class */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public int f25673a;
    public String b;

    public q(int i, String str) {
        this.f25673a = i;
        this.b = str;
    }

    public void a(int i) {
        this.f25673a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String toString() {
        return "NativeAdError{code=" + this.f25673a + ", msg='" + this.b + "'}";
    }
}
