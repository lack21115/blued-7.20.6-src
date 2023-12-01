package com.bytedance.pangle.f.a;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/f/a/c.class */
final class c {

    /* renamed from: a  reason: collision with root package name */
    int[] f7794a = new int[32];
    int b;

    /* renamed from: c  reason: collision with root package name */
    int f7795c;

    public final void a() {
        b();
        int i = this.b;
        int[] iArr = this.f7794a;
        iArr[i] = 0;
        iArr[i + 1] = 0;
        this.b = i + 2;
        this.f7795c++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        int[] iArr = this.f7794a;
        int length = iArr.length;
        int i = this.b;
        int i2 = length - i;
        if (i2 <= 2) {
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            this.f7794a = iArr2;
        }
    }
}
