package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/TypedBundle.class */
public class TypedBundle {

    /* renamed from: a  reason: collision with root package name */
    int[] f2066a = new int[10];
    int[] b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    int f2067c = 0;
    int[] d = new int[10];
    float[] e = new float[10];
    int f = 0;
    int[] g = new int[5];
    String[] h = new String[5];
    int i = 0;
    int[] j = new int[4];
    boolean[] k = new boolean[4];
    int l = 0;

    public void add(int i, float f) {
        int i2 = this.f;
        int[] iArr = this.d;
        if (i2 >= iArr.length) {
            this.d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.e;
            this.e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.d;
        int i3 = this.f;
        iArr2[i3] = i;
        float[] fArr2 = this.e;
        this.f = i3 + 1;
        fArr2[i3] = f;
    }

    public void add(int i, int i2) {
        int i3 = this.f2067c;
        int[] iArr = this.f2066a;
        if (i3 >= iArr.length) {
            this.f2066a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.b;
            this.b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f2066a;
        int i4 = this.f2067c;
        iArr3[i4] = i;
        int[] iArr4 = this.b;
        this.f2067c = i4 + 1;
        iArr4[i4] = i2;
    }

    public void add(int i, String str) {
        int i2 = this.i;
        int[] iArr = this.g;
        if (i2 >= iArr.length) {
            this.g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.h;
            this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.g;
        int i3 = this.i;
        iArr2[i3] = i;
        String[] strArr2 = this.h;
        this.i = i3 + 1;
        strArr2[i3] = str;
    }

    public void add(int i, boolean z) {
        int i2 = this.l;
        int[] iArr = this.j;
        if (i2 >= iArr.length) {
            this.j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.k;
            this.k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.j;
        int i3 = this.l;
        iArr2[i3] = i;
        boolean[] zArr2 = this.k;
        this.l = i3 + 1;
        zArr2[i3] = z;
    }

    public void addIfNotNull(int i, String str) {
        if (str != null) {
            add(i, str);
        }
    }

    public void applyDelta(TypedBundle typedBundle) {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f2067c) {
                break;
            }
            typedBundle.add(this.f2066a[i3], this.b[i3]);
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.f) {
                break;
            }
            typedBundle.add(this.d[i5], this.e[i5]);
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.i) {
                break;
            }
            typedBundle.add(this.g[i7], this.h[i7]);
            i6 = i7 + 1;
        }
        for (i = 0; i < this.l; i++) {
            typedBundle.add(this.j[i], this.k[i]);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        int i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f2067c) {
                break;
            }
            typedValues.setValue(this.f2066a[i3], this.b[i3]);
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.f) {
                break;
            }
            typedValues.setValue(this.d[i5], this.e[i5]);
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.i) {
                break;
            }
            typedValues.setValue(this.g[i7], this.h[i7]);
            i6 = i7 + 1;
        }
        for (i = 0; i < this.l; i++) {
            typedValues.setValue(this.j[i], this.k[i]);
        }
    }

    public void clear() {
        this.l = 0;
        this.i = 0;
        this.f = 0;
        this.f2067c = 0;
    }

    public int getInteger(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.f2067c) {
                return -1;
            }
            if (this.f2066a[i3] == i) {
                return this.b[i3];
            }
            i2 = i3 + 1;
        }
    }
}
