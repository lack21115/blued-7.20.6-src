package com.anythink.core.common.e;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/x.class */
public final class x {

    /* renamed from: a  reason: collision with root package name */
    private int f6682a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f6683c;
    private int d;
    private int e;

    public x() {
    }

    public x(int i, String str) {
        this.f6682a = i;
        this.b = str;
        this.d = 0;
        this.e = 0;
        this.f6683c = -1L;
    }

    private void a(String str) {
        this.b = str;
    }

    private void c(int i) {
        this.f6682a = i;
    }

    public final String a() {
        return this.b;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(long j) {
        this.f6683c = j;
    }

    public final long b() {
        return this.f6683c;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final int c() {
        return this.d;
    }

    public final int d() {
        return this.e;
    }

    public final int e() {
        return this.f6682a;
    }
}
