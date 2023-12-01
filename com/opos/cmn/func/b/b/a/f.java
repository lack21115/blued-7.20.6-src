package com.opos.cmn.func.b.b.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f24849a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24850c;
    public final String d;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/f$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f24851a = true;
        private long b = 183258695109709824L;

        /* renamed from: c  reason: collision with root package name */
        private String f24852c = "";
        private String d = "";

        public f a() {
            return new f(this);
        }
    }

    private f(a aVar) {
        this.f24849a = aVar.f24851a;
        this.b = aVar.b;
        this.f24850c = aVar.f24852c;
        this.d = aVar.d;
    }

    public String toString() {
        return "IPv6Config{useIpv6Switcher=" + this.f24849a + ", ipv6ConfigId=" + this.b + ", channelId='" + this.f24850c + "', buildNumber='" + this.d + "'}";
    }
}
