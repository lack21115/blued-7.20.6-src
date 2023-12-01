package c.t.m.g;

import java.util.Arrays;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/f4.class */
public class f4 {
    public static volatile f4 e;

    /* renamed from: a  reason: collision with root package name */
    public float f3809a = 0.0f;
    public float b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f3810c = 100.0f;
    public boolean d = false;

    public static f4 a() {
        if (e == null) {
            synchronized (f4.class) {
                try {
                    if (e == null) {
                        e = new f4();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    public boolean a(List<Float> list, int i) {
        if (list.size() >= 5) {
            int size = list.size();
            float[] fArr = new float[size];
            int i2 = 0;
            while (true) {
                int i3 = i2;
                float f = 0.0f;
                if (i3 >= size) {
                    break;
                }
                Float f2 = list.get(i3);
                if (f2 != null) {
                    f = f2.floatValue();
                }
                fArr[i3] = f;
                i2 = i3 + 1;
            }
            Arrays.sort(fArr);
            float[] fArr2 = new float[5];
            float f3 = 0.0f;
            for (int i4 = 0; i4 < 5; i4++) {
                fArr2[i4] = fArr[(size - 1) - i4];
                f3 += fArr2[i4];
            }
            float f4 = f3 / 5.0f;
            float f5 = fArr2[0];
            if (this.b < f4) {
                this.b = f4;
            }
            if (this.f3810c > f4) {
                this.f3810c = f4;
            }
            this.f3809a = f4;
            if (f4 - f4 > 2.0f) {
                this.d = false;
            }
            if (f4 > (this.b + this.f3810c) / 2.0f) {
                this.d = true;
            } else if (f4 < 22.0f) {
                this.d = false;
            }
        }
        return this.d;
    }
}
