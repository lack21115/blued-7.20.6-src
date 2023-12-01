package com.meizu.cloud.pushsdk.c.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/g/j.class */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    final byte[] f10462a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f10463c;
    boolean d;
    final boolean e;
    j f;
    j g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j() {
        this.f10462a = new byte[2048];
        this.e = true;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(j jVar) {
        this(jVar.f10462a, jVar.b, jVar.f10463c);
    }

    j(byte[] bArr, int i, int i2) {
        this.f10462a = bArr;
        this.b = i;
        this.f10463c = i2;
        this.e = false;
        this.d = true;
    }

    public j a() {
        j jVar = this.f;
        if (jVar == this) {
            jVar = null;
        }
        j jVar2 = this.g;
        jVar2.f = this.f;
        this.f.g = jVar2;
        this.f = null;
        this.g = null;
        return jVar;
    }

    public j a(int i) {
        if (i <= 0 || i > this.f10463c - this.b) {
            throw new IllegalArgumentException();
        }
        j jVar = new j(this);
        jVar.f10463c = jVar.b + i;
        this.b += i;
        this.g.a(jVar);
        return jVar;
    }

    public j a(j jVar) {
        jVar.g = this;
        jVar.f = this.f;
        this.f.g = jVar;
        this.f = jVar;
        return jVar;
    }

    public void a(j jVar, int i) {
        if (!jVar.e) {
            throw new IllegalArgumentException();
        }
        int i2 = jVar.f10463c;
        if (i2 + i > 2048) {
            if (jVar.d) {
                throw new IllegalArgumentException();
            }
            int i3 = jVar.b;
            if ((i2 + i) - i3 > 2048) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = jVar.f10462a;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            jVar.f10463c -= jVar.b;
            jVar.b = 0;
        }
        System.arraycopy(this.f10462a, this.b, jVar.f10462a, jVar.f10463c, i);
        jVar.f10463c += i;
        this.b += i;
    }

    public void b() {
        j jVar = this.g;
        if (jVar == this) {
            throw new IllegalStateException();
        }
        if (jVar.e) {
            int i = this.f10463c - this.b;
            if (i > (2048 - jVar.f10463c) + (jVar.d ? 0 : jVar.b)) {
                return;
            }
            a(this.g, i);
            a();
            k.a(this);
        }
    }
}
