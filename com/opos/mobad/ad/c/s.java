package com.opos.mobad.ad.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/s.class */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public final int f25676a;
    public final int b;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/s$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f25677a = 0;
        private int b = 0;

        public a a(int i) {
            this.f25677a = i;
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
        this.f25676a = aVar.f25677a;
        this.b = aVar.b;
    }

    public String toString() {
        return "NativeAdSize{widthInDp=" + this.f25676a + ", heightInDp=" + this.b + '}';
    }
}
