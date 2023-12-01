package com.sobot.chat.core.a.a;

import java.net.InetSocketAddress;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/a.class */
public class a {
    public static final int b = 15000;

    /* renamed from: a  reason: collision with root package name */
    final a f28197a;

    /* renamed from: c  reason: collision with root package name */
    private a f28198c;
    private String d;
    private String e;
    private int f;

    public a() {
        this((String) null, (String) null);
    }

    public a(String str, int i) {
        this(str, "" + i);
    }

    public a(String str, int i, int i2) {
        this(str, "" + i, i2);
    }

    public a(String str, String str2) {
        this(str, str2, 15000);
    }

    public a(String str, String str2, int i) {
        this.f28197a = this;
        this.d = str;
        this.e = str2;
        this.f = i;
    }

    public a a() {
        a aVar = new a(f(), g(), h());
        aVar.a(this);
        return aVar;
    }

    public a a(int i) {
        b("" + i);
        return this;
    }

    protected a a(a aVar) {
        this.f28198c = aVar;
        return this;
    }

    public a a(String str) {
        this.d = str;
        return this;
    }

    public a b(int i) {
        this.f = i;
        return this;
    }

    public a b(String str) {
        this.e = str;
        return this;
    }

    public void b() {
        if (!com.sobot.chat.core.a.b.c.a(f(), com.sobot.chat.core.a.b.c.f)) {
            throw new IllegalArgumentException("we need a correct remote IP to connect. Current is " + f());
        } else if (!com.sobot.chat.core.a.b.c.a(g(), com.sobot.chat.core.a.b.c.g)) {
            throw new IllegalArgumentException("we need a correct remote port to connect. Current is " + g());
        } else if (h() >= 0) {
        } else {
            throw new IllegalArgumentException("we need connectionTimeout > 0. Current is " + h());
        }
    }

    public int c() {
        if (g() == null) {
            return 0;
        }
        return Integer.valueOf(g()).intValue();
    }

    public InetSocketAddress d() {
        return new InetSocketAddress(f(), c());
    }

    public a e() {
        a aVar = this.f28198c;
        return aVar == null ? this : aVar;
    }

    public String f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public int h() {
        return this.f;
    }
}
