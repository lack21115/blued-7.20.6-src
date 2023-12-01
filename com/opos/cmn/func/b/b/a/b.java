package com.opos.cmn.func.b.b.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f24834a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final a f24835c;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/b$a.class */
    public enum a {
        CN,
        EU,
        SA,
        SEA
    }

    /* renamed from: com.opos.cmn.func.b.b.a.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/b$b.class */
    public static class C0639b {

        /* renamed from: a  reason: collision with root package name */
        private boolean f24838a = true;
        private long b = 54883;

        /* renamed from: c  reason: collision with root package name */
        private a f24839c = null;

        public b a() {
            return new b(this);
        }
    }

    private b(C0639b c0639b) {
        this.f24834a = c0639b.f24838a;
        this.b = c0639b.b;
        this.f24835c = c0639b.f24839c;
    }

    public String toString() {
        return "CloudConfig{enableCloudConfig=" + this.f24834a + ", productId=" + this.b + ", areaCode=" + this.f24835c + '}';
    }
}
