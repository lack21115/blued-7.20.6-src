package com.tencent.map.a.a;

import com.tencent.map.b.h;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/a/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f23503a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f23504c;
    private int d;

    public b(int i, int i2, int i3, int i4) {
        this.f23503a = 1;
        this.b = 0;
        this.f23504c = 12;
        this.d = 1;
        h.a("argument: " + this.f23503a + " " + this.d + " " + this.b);
        if (i >= 0 && i <= 1) {
            this.f23503a = i;
        }
        if (i2 >= 0 && i2 <= 1) {
            this.d = i2;
        }
        if (i3 == 0 || i3 == 3 || i3 == 4 || i3 == 7) {
            this.b = i3;
        }
        if (this.d == 0) {
            this.b = 0;
        }
        this.f23504c = i4;
    }

    public int a() {
        return this.f23503a;
    }

    public void a(int i) {
    }

    public void a(d dVar) {
    }

    public void a(byte[] bArr, int i) {
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.d;
    }
}
