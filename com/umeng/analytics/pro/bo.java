package com.umeng.analytics.pro;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bo.class */
public class bo {

    /* renamed from: a  reason: collision with root package name */
    private short[] f40667a;
    private int b = -1;

    public bo(int i) {
        this.f40667a = new short[i];
    }

    private void d() {
        short[] sArr = this.f40667a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy((Object) sArr, 0, (Object) sArr2, 0, sArr.length);
        this.f40667a = sArr2;
    }

    public short a() {
        short[] sArr = this.f40667a;
        int i = this.b;
        this.b = i - 1;
        return sArr[i];
    }

    public void a(short s) {
        if (this.f40667a.length == this.b + 1) {
            d();
        }
        short[] sArr = this.f40667a;
        int i = this.b + 1;
        this.b = i;
        sArr[i] = s;
    }

    public short b() {
        return this.f40667a[this.b];
    }

    public void c() {
        this.b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f40667a.length) {
                sb.append("]>");
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append(" ");
            }
            if (i2 == this.b) {
                sb.append(">>");
            }
            sb.append((int) this.f40667a[i2]);
            if (i2 == this.b) {
                sb.append("<<");
            }
            i = i2 + 1;
        }
    }
}
