package com.sobot.chat.core.a.a;

import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    final f f28207a = this;
    private f b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f28208c;
    private b d;
    private byte[] e;
    private a f;
    private long g;
    private boolean h;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/f$a.class */
    public interface a {
        boolean a(f fVar, j jVar);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/core/a/a/f$b.class */
    public interface b {
        byte[] a(f fVar);
    }

    public f a() {
        f fVar = new f();
        fVar.a(this);
        fVar.a(d());
        fVar.a(e());
        fVar.b(f());
        fVar.a(g());
        fVar.a(h());
        fVar.a(i());
        return fVar;
    }

    public f a(long j) {
        this.g = j;
        return this;
    }

    public f a(a aVar) {
        this.f = aVar;
        return this;
    }

    public f a(b bVar) {
        this.d = bVar;
        return this;
    }

    protected f a(f fVar) {
        this.b = fVar;
        return this;
    }

    public f a(boolean z) {
        this.h = z;
        return this;
    }

    public f a(byte[] bArr) {
        if (bArr != null) {
            this.f28208c = Arrays.copyOf(bArr, bArr.length);
            return this;
        }
        this.f28208c = null;
        return this;
    }

    public boolean a(j jVar) {
        if (g() != null) {
            return g().a(c(), jVar);
        }
        if (f() != null) {
            return jVar.a(f());
        }
        return false;
    }

    public f b(byte[] bArr) {
        if (bArr != null) {
            this.e = Arrays.copyOf(bArr, bArr.length);
            return this;
        }
        this.e = null;
        return this;
    }

    public byte[] b() {
        return e() != null ? e().a(c()) : d();
    }

    public f c() {
        f fVar = this.b;
        return fVar == null ? this : fVar;
    }

    public byte[] d() {
        return this.f28208c;
    }

    public b e() {
        return this.d;
    }

    public byte[] f() {
        return this.e;
    }

    public a g() {
        return this.f;
    }

    public long h() {
        return this.g;
    }

    public boolean i() {
        if (!(d() == null && e() == null) && h() > 0) {
            return this.h;
        }
        return false;
    }
}
