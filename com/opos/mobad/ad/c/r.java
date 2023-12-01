package com.opos.mobad.ad.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/r.class */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public final long f11986a;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/c/r$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f11987a = 30000;

        public a a(long j) {
            if (j >= 500 && j <= 30000) {
                this.f11987a = j;
            }
            return this;
        }

        public r a() {
            return new r(this);
        }
    }

    public r(a aVar) {
        this.f11986a = aVar.f11987a;
    }

    public String toString() {
        return "NativeAdParams{fetchTimeout=" + this.f11986a + '}';
    }
}
