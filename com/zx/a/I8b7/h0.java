package com.zx.a.I8b7;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/h0.class */
public class h0 implements c0 {

    /* renamed from: a  reason: collision with root package name */
    public e0 f42132a;
    public boolean b = true;

    public h0(e0 e0Var) {
        this.f42132a = (e0) o1.a(e0Var);
    }

    @Override // com.zx.a.I8b7.c0
    public void a(int i, String str, String str2, Throwable th) {
        int i2 = i;
        if ((i & 240) != 0) {
            i2 = i & 15;
        }
        this.f42132a.a(i2, str, str2, th);
    }

    @Override // com.zx.a.I8b7.c0
    public boolean a(int i, String str) {
        int i2 = i & 240;
        if (i2 == 0 || i2 == 16) {
            return this.b;
        }
        return false;
    }
}
