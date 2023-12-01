package com.opos.cmn.func.b.b.a;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f24840a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f24841c;
    public final boolean d;
    public final List<String> e;
    public final b f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/c$a.class */
    public static class a {
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f24843c;
        private List<String> e;
        private b f;

        /* renamed from: a  reason: collision with root package name */
        private boolean f24842a = true;
        private boolean d = true;

        public c a() {
            return new c(this);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/b/a/c$b.class */
    public interface b {
    }

    private c(a aVar) {
        this.f24840a = aVar.f24842a;
        this.b = aVar.b;
        this.f24841c = aVar.f24843c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public String toString() {
        return "HttpDnsConfig{enableHttpDns=" + this.f24840a + ", region='" + this.b + "', appVersion='" + this.f24841c + "', enableDnUnit=" + this.d + ", innerWhiteList=" + this.e + ", accountCallback=" + this.f + '}';
    }
}
