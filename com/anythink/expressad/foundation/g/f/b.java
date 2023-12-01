package com.anythink.expressad.foundation.g.f;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/b.class */
public final class b implements l {

    /* renamed from: a  reason: collision with root package name */
    private int f5020a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5021c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.f5020a = 30000;
        this.f5021c = 0;
    }

    private b(int i, int i2, int i3, int i4, int i5) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.e = Math.max(i, 0);
        this.f = Math.max(i2, 0);
        this.g = Math.max(i3, 0);
        this.h = Math.max(i4, 0);
        this.f5021c = Math.max(i5, 0);
    }

    private b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.e = Math.max(i, 0);
        this.f = Math.max(i2, 0);
        this.g = Math.max(i3, 0);
        this.h = Math.max(i4, 0);
        this.f5021c = Math.max(i5, 0);
        this.d = i6;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int a() {
        return this.f5021c;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int b() {
        return this.f5020a;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int c() {
        return this.b;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final boolean d() {
        int i = this.b + 1;
        this.b = i;
        return i <= this.f5021c;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int e() {
        return this.e;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int f() {
        return this.f;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int g() {
        return this.g;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int h() {
        return this.h;
    }

    @Override // com.anythink.expressad.foundation.g.f.l
    public final int i() {
        return this.d;
    }
}
