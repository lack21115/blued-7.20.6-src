package com.opos.mobad.ad.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/s.class */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public final int f11988a;
    public final int b;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/s$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f11989a = 0;
        private int b = 0;

        public a a(int i) {
            this.f11989a = i;
            return this;
        }

        public s a() {
            return new s(this);
        }

        public a b(int i) {
            this.b = i;
            return this;
        }
    }

    public s(a aVar) {
        this.f11988a = aVar.f11989a;
        this.b = aVar.b;
    }

    public String toString() {
        return "NativeAdSize{widthInDp=" + this.f11988a + ", heightInDp=" + this.b + '}';
    }
}
