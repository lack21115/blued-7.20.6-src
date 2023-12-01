package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyFrameArray.class */
public class KeyFrameArray {

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyFrameArray$CustomArray.class */
    public static class CustomArray {

        /* renamed from: a  reason: collision with root package name */
        int[] f2044a = new int[101];
        CustomAttribute[] b = new CustomAttribute[101];

        /* renamed from: c  reason: collision with root package name */
        int f2045c;

        public CustomArray() {
            clear();
        }

        public void append(int i, CustomAttribute customAttribute) {
            if (this.b[i] != null) {
                remove(i);
            }
            this.b[i] = customAttribute;
            int[] iArr = this.f2044a;
            int i2 = this.f2045c;
            this.f2045c = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f2044a, 999);
            Arrays.fill(this.b, (Object) null);
            this.f2045c = 0;
        }

        public void dump() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f2044a, this.f2045c)));
            System.out.print("K: [");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f2045c) {
                    System.out.println("]");
                    return;
                }
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "" : ", ");
                sb.append(valueAt(i2));
                printStream2.print(sb.toString());
                i = i2 + 1;
            }
        }

        public int keyAt(int i) {
            return this.f2044a[i];
        }

        public void remove(int i) {
            this.b[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f2045c;
                if (i2 >= i4) {
                    this.f2045c = i4 - 1;
                    return;
                }
                int[] iArr = this.f2044a;
                int i5 = i3;
                if (i == iArr[i2]) {
                    iArr[i2] = 999;
                    i5 = i3 + 1;
                }
                if (i2 != i5) {
                    int[] iArr2 = this.f2044a;
                    iArr2[i2] = iArr2[i5];
                }
                i3 = i5 + 1;
                i2++;
            }
        }

        public int size() {
            return this.f2045c;
        }

        public CustomAttribute valueAt(int i) {
            return this.b[this.f2044a[i]];
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyFrameArray$CustomVar.class */
    public static class CustomVar {

        /* renamed from: a  reason: collision with root package name */
        int[] f2046a = new int[101];
        CustomVariable[] b = new CustomVariable[101];

        /* renamed from: c  reason: collision with root package name */
        int f2047c;

        public CustomVar() {
            clear();
        }

        public void append(int i, CustomVariable customVariable) {
            if (this.b[i] != null) {
                remove(i);
            }
            this.b[i] = customVariable;
            int[] iArr = this.f2046a;
            int i2 = this.f2047c;
            this.f2047c = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f2046a, 999);
            Arrays.fill(this.b, (Object) null);
            this.f2047c = 0;
        }

        public void dump() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f2046a, this.f2047c)));
            System.out.print("K: [");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f2047c) {
                    System.out.println("]");
                    return;
                }
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "" : ", ");
                sb.append(valueAt(i2));
                printStream2.print(sb.toString());
                i = i2 + 1;
            }
        }

        public int keyAt(int i) {
            return this.f2046a[i];
        }

        public void remove(int i) {
            this.b[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f2047c;
                if (i2 >= i4) {
                    this.f2047c = i4 - 1;
                    return;
                }
                int[] iArr = this.f2046a;
                int i5 = i3;
                if (i == iArr[i2]) {
                    iArr[i2] = 999;
                    i5 = i3 + 1;
                }
                if (i2 != i5) {
                    int[] iArr2 = this.f2046a;
                    iArr2[i2] = iArr2[i5];
                }
                i3 = i5 + 1;
                i2++;
            }
        }

        public int size() {
            return this.f2047c;
        }

        public CustomVariable valueAt(int i) {
            return this.b[this.f2046a[i]];
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyFrameArray$FloatArray.class */
    static class FloatArray {

        /* renamed from: a  reason: collision with root package name */
        int[] f2048a = new int[101];
        float[][] b = new float[101];

        /* renamed from: c  reason: collision with root package name */
        int f2049c;

        /* JADX WARN: Type inference failed for: r1v3, types: [float[], float[][]] */
        public FloatArray() {
            clear();
        }

        public void append(int i, float[] fArr) {
            if (this.b[i] != null) {
                remove(i);
            }
            this.b[i] = fArr;
            int[] iArr = this.f2048a;
            int i2 = this.f2049c;
            this.f2049c = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f2048a, 999);
            Arrays.fill(this.b, (Object) null);
            this.f2049c = 0;
        }

        public void dump() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f2048a, this.f2049c)));
            System.out.print("K: [");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f2049c) {
                    System.out.println("]");
                    return;
                }
                PrintStream printStream2 = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i2 == 0 ? "" : ", ");
                sb.append(Arrays.toString(valueAt(i2)));
                printStream2.print(sb.toString());
                i = i2 + 1;
            }
        }

        public int keyAt(int i) {
            return this.f2048a[i];
        }

        public void remove(int i) {
            this.b[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f2049c;
                if (i2 >= i4) {
                    this.f2049c = i4 - 1;
                    return;
                }
                int[] iArr = this.f2048a;
                int i5 = i3;
                if (i == iArr[i2]) {
                    iArr[i2] = 999;
                    i5 = i3 + 1;
                }
                if (i2 != i5) {
                    int[] iArr2 = this.f2048a;
                    iArr2[i2] = iArr2[i5];
                }
                i3 = i5 + 1;
                i2++;
            }
        }

        public int size() {
            return this.f2049c;
        }

        public float[] valueAt(int i) {
            return this.b[this.f2048a[i]];
        }
    }
}
