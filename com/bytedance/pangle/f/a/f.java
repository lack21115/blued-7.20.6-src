package com.bytedance.pangle.f.a;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/f/a/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    int[] f21403a;
    int[] b;

    private static final int a(int[] iArr, int i) {
        int i2 = iArr[i / 4];
        return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
    }

    public final String a(int i) {
        int[] iArr;
        if (i < 0 || (iArr = this.f21403a) == null || i >= iArr.length) {
            return null;
        }
        int i2 = iArr[i];
        int a2 = a(this.b, i2);
        StringBuilder sb = new StringBuilder(a2);
        while (a2 != 0) {
            i2 += 2;
            sb.append((char) a(this.b, i2));
            a2--;
        }
        return sb.toString();
    }
}
