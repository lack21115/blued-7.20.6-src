package com.igexin.push.c.c;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/h.class */
public final class h extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9735a = 97;
    public byte b;

    /* renamed from: c  reason: collision with root package name */
    public byte f9736c;

    public h() {
        this.m = 97;
    }

    @Override // com.igexin.push.c.c.c, com.igexin.c.a.d.a.a
    public final void a() {
        this.b = (byte) 0;
        this.f9736c = (byte) 0;
    }

    @Override // com.igexin.push.c.c.c
    public final void a(byte[] bArr) {
        this.b = bArr[0];
        this.f9736c = bArr[1];
    }

    @Override // com.igexin.push.c.c.c
    public final byte[] b() {
        return new byte[]{this.b, this.f9736c};
    }
}
