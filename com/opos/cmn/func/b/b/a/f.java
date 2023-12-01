package com.opos.cmn.func.b.b.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f11161a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11162c;
    public final String d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/f$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11163a = true;
        private long b = 183258695109709824L;

        /* renamed from: c  reason: collision with root package name */
        private String f11164c = "";
        private String d = "";

        public f a() {
            return new f(this);
        }
    }

    private f(a aVar) {
        this.f11161a = aVar.f11163a;
        this.b = aVar.b;
        this.f11162c = aVar.f11164c;
        this.d = aVar.d;
    }

    public String toString() {
        return "IPv6Config{useIpv6Switcher=" + this.f11161a + ", ipv6ConfigId=" + this.b + ", channelId='" + this.f11162c + "', buildNumber='" + this.d + "'}";
    }
}
