package com.igexin.push.c.c;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/c/c/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23338a = 1944742139;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f23339c;
    public int d;
    public int e;
    public int f;
    public int g;
    public byte h;
    public byte i;
    public byte j;
    public byte k;
    public byte l;
    public byte m;
    public byte n;
    public byte[] o;
    public int p;
    public int q;
    public int r;

    private int a() {
        int i = this.e | this.h;
        this.e = i;
        int i2 = i | this.i;
        this.e = i2;
        int i3 = i2 | this.j;
        this.e = i3;
        return i3;
    }

    private int b() {
        int i = this.g | this.k;
        this.g = i;
        int i2 = i | this.l;
        this.g = i2;
        int i3 = i2 | this.m;
        this.g = i3;
        int i4 = i3 | this.n;
        this.g = i4;
        return i4;
    }

    private void b(byte b) {
        this.g = b & 255;
        this.k = (byte) (b & 3);
        this.l = (byte) (b & 4);
        this.m = (byte) (b & 8);
        this.n = (byte) (b & 16);
    }

    public final void a(byte b) {
        this.e = b & 255;
        this.h = (byte) (b & 192);
        this.i = (byte) (b & 48);
        this.j = (byte) (b & 15);
    }
}
