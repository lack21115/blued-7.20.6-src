package com.zx.a.I8b7;

import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/w1.class */
public class w1 {

    /* renamed from: a  reason: collision with root package name */
    public final q f28529a;
    public final List<g0> b;

    /* renamed from: c  reason: collision with root package name */
    public final SSLSocketFactory f28530c;
    public final HostnameVerifier d;
    public final boolean e;
    public final int f;
    public final int g;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/w1$a.class */
    public static final class a {

        /* renamed from: c  reason: collision with root package name */
        public SSLSocketFactory f28532c;
        public final List<g0> b = new ArrayList();

        /* renamed from: a  reason: collision with root package name */
        public q f28531a = new q();
        public boolean e = true;
        public int f = 7000;
        public int g = 7000;
        public HostnameVerifier d = v1.f28527a;
    }

    public w1(a aVar) {
        this.f28529a = aVar.f28531a;
        List<g0> a2 = l1.a(aVar.b);
        this.b = a2;
        this.f28530c = aVar.f28532c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        if (a2.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + a2);
        }
    }
}
