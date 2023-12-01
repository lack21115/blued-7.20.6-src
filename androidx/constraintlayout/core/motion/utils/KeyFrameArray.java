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
        int[] f1996a = new int[101];
        CustomAttribute[] b = new CustomAttribute[101];

        /* renamed from: c  reason: collision with root package name */
        int f1997c;

        public CustomArray() {
            clear();
        }

        public void append(int i, CustomAttribute customAttribute) {
            if (this.b[i] != null) {
                remove(i);
            }
            this.b[i] = customAttribute;
            int[] iArr = this.f1996a;
            int i2 = this.f1997c;
            this.f1997c = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f1996a, 999);
            Arrays.fill(this.b, (Object) null);
            this.f1997c = 0;
        }

        public void dump() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f1996a, this.f1997c)));
            System.out.print("K: [");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f1997c) {
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
            return this.f1996a[i];
        }

        public void remove(int i) {
            this.b[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f1997c;
                if (i2 >= i4) {
                    this.f1997c = i4 - 1;
                    return;
                }
                int[] iArr = this.f1996a;
                int i5 = i3;
                if (i == iArr[i2]) {
                    iArr[i2] = 999;
                    i5 = i3 + 1;
                }
                if (i2 != i5) {
                    int[] iArr2 = this.f1996a;
                    iArr2[i2] = iArr2[i5];
                }
                i3 = i5 + 1;
                i2++;
            }
        }

        public int size() {
            return this.f1997c;
        }

        public CustomAttribute valueAt(int i) {
            return this.b[this.f1996a[i]];
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyFrameArray$CustomVar.class */
    public static class CustomVar {

        /* renamed from: a  reason: collision with root package name */
        int[] f1998a = new int[101];
        CustomVariable[] b = new CustomVariable[101];

        /* renamed from: c  reason: collision with root package name */
        int f1999c;

        public CustomVar() {
            clear();
        }

        public void append(int i, CustomVariable customVariable) {
            if (this.b[i] != null) {
                remove(i);
            }
            this.b[i] = customVariable;
            int[] iArr = this.f1998a;
            int i2 = this.f1999c;
            this.f1999c = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f1998a, 999);
            Arrays.fill(this.b, (Object) null);
            this.f1999c = 0;
        }

        public void dump() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f1998a, this.f1999c)));
            System.out.print("K: [");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f1999c) {
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
            return this.f1998a[i];
        }

        public void remove(int i) {
            this.b[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f1999c;
                if (i2 >= i4) {
                    this.f1999c = i4 - 1;
                    return;
                }
                int[] iArr = this.f1998a;
                int i5 = i3;
                if (i == iArr[i2]) {
                    iArr[i2] = 999;
                    i5 = i3 + 1;
                }
                if (i2 != i5) {
                    int[] iArr2 = this.f1998a;
                    iArr2[i2] = iArr2[i5];
                }
                i3 = i5 + 1;
                i2++;
            }
        }

        public int size() {
            return this.f1999c;
        }

        public CustomVariable valueAt(int i) {
            return this.b[this.f1998a[i]];
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/utils/KeyFrameArray$FloatArray.class */
    static class FloatArray {

        /* renamed from: a  reason: collision with root package name */
        int[] f2000a = new int[101];
        float[][] b = new float[101];

        /* renamed from: c  reason: collision with root package name */
        int f2001c;

        /* JADX WARN: Type inference failed for: r1v3, types: [float[], float[][]] */
        public FloatArray() {
            clear();
        }

        public void append(int i, float[] fArr) {
            if (this.b[i] != null) {
                remove(i);
            }
            this.b[i] = fArr;
            int[] iArr = this.f2000a;
            int i2 = this.f2001c;
            this.f2001c = i2 + 1;
            iArr[i2] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.f2000a, 999);
            Arrays.fill(this.b, (Object) null);
            this.f2001c = 0;
        }

        public void dump() {
            PrintStream printStream = System.out;
            printStream.println("V: " + Arrays.toString(Arrays.copyOf(this.f2000a, this.f2001c)));
            System.out.print("K: [");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f2001c) {
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
            return this.f2000a[i];
        }

        public void remove(int i) {
            this.b[i] = null;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f2001c;
                if (i2 >= i4) {
                    this.f2001c = i4 - 1;
                    return;
                }
                int[] iArr = this.f2000a;
                int i5 = i3;
                if (i == iArr[i2]) {
                    iArr[i2] = 999;
                    i5 = i3 + 1;
                }
                if (i2 != i5) {
                    int[] iArr2 = this.f2000a;
                    iArr2[i2] = iArr2[i5];
                }
                i3 = i5 + 1;
                i2++;
            }
        }

        public int size() {
            return this.f2001c;
        }

        public float[] valueAt(int i) {
            return this.b[this.f2000a[i]];
        }
    }
}
