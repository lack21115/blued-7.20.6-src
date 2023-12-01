package com.alipay.android.phone.mrpc.core;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/p.class */
public final class p extends u {

    /* renamed from: c  reason: collision with root package name */
    private int f4534c;
    private String d;
    private long e;
    private long f;
    private String g;
    private HttpUrlHeader h;

    public p(HttpUrlHeader httpUrlHeader, int i, String str, byte[] bArr) {
        this.h = httpUrlHeader;
        this.f4534c = i;
        this.d = str;
        this.f4539a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.h;
    }

    public final void a(long j) {
        this.e = j;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void b(long j) {
        this.f = j;
    }
}
