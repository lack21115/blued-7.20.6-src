package com.opos.mobad.ad.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public final long f25674a;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/r$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f25675a = 30000;

        public a a(long j) {
            if (j >= 500 && j <= 30000) {
                this.f25675a = j;
            }
            return this;
        }

        public r a() {
            return new r(this);
        }
    }

    public r(a aVar) {
        this.f25674a = aVar.f25675a;
    }

    public String toString() {
        return "NativeAdParams{fetchTimeout=" + this.f25674a + '}';
    }
}
