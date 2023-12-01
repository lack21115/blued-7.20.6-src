package com.opos.cmn.func.b.b.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f11146a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final a f11147c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/b$a.class */
    public enum a {
        CN,
        EU,
        SA,
        SEA
    }

    /* renamed from: com.opos.cmn.func.b.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/b$b.class */
    public static class C0469b {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11150a = true;
        private long b = 54883;

        /* renamed from: c  reason: collision with root package name */
        private a f11151c = null;

        public b a() {
            return new b(this);
        }
    }

    private b(C0469b c0469b) {
        this.f11146a = c0469b.f11150a;
        this.b = c0469b.b;
        this.f11147c = c0469b.f11151c;
    }

    public String toString() {
        return "CloudConfig{enableCloudConfig=" + this.f11146a + ", productId=" + this.b + ", areaCode=" + this.f11147c + '}';
    }
}
