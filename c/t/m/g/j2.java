package c.t.m.g;

import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/j2.class */
public class j2 {

    /* renamed from: a  reason: collision with root package name */
    public int f3799a;
    public int[] b;

    /* renamed from: c  reason: collision with root package name */
    public int f3800c;
    public int d;
    public int e;

    public j2(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("cacheSize max > 0.");
        }
        this.f3799a = i;
        this.b = new int[i];
        a();
    }

    public void a() {
        this.d = 0;
        this.e = 0;
        this.f3800c = 0;
        Arrays.fill(this.b, 0);
    }

    public void a(int i) {
        int i2 = this.f3800c;
        int[] iArr = this.b;
        int i3 = this.d;
        int i4 = i2 - iArr[i3];
        this.f3800c = i4;
        this.f3800c = i4 + i;
        iArr[i3] = i;
        int i5 = i3 + 1;
        this.d = i5;
        if (i5 == this.f3799a) {
            this.d = 0;
        }
        int i6 = this.e;
        if (i6 < Integer.MAX_VALUE) {
            this.e = i6 + 1;
        }
    }

    public int b() {
        return this.f3799a;
    }

    public final int b(int i) {
        int i2 = this.e;
        int i3 = this.f3799a;
        return i2 < i3 ? i : ((this.d + i) + i3) % i3;
    }

    public int c() {
        int i = this.e;
        int i2 = this.f3799a;
        return i < i2 ? i : i2;
    }

    public int c(int i) {
        if (i < 0 || i >= c()) {
            throw new ArrayIndexOutOfBoundsException("cache max size is " + this.f3799a + ",current size is " + c() + ",index is " + i);
        }
        return this.b[b(i)];
    }
}
