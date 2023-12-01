package com.tencent.txcopyrightedmedia.impl.utils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/bc.class */
public final class bc {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f40088a;
    public long b = -1;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f40089c;
    public long d;
    public long e;

    public final void a(byte[] bArr, long j) {
        this.f40088a = bArr;
        this.b = j;
    }

    public final void a(byte[] bArr, long j, long j2) {
        this.f40089c = bArr;
        this.d = j;
        this.e = j2;
    }

    public final boolean a() {
        byte[] bArr = this.f40088a;
        return bArr == null || bArr.length == 0;
    }
}
