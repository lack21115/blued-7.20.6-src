package com.anythink.core.common.e;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/x.class */
public final class x {
    private int a;
    private String b;
    private long c;
    private int d;
    private int e;

    public x() {
    }

    public x(int i, String str) {
        this.a = i;
        this.b = str;
        this.d = 0;
        this.e = 0;
        this.c = -1L;
    }

    private void a(String str) {
        this.b = str;
    }

    private void c(int i) {
        this.a = i;
    }

    public final String a() {
        return this.b;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(long j) {
        this.c = j;
    }

    public final long b() {
        return this.c;
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
        return this.a;
    }
}
