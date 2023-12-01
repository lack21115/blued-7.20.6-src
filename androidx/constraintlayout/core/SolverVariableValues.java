package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/SolverVariableValues.class */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static float j = 0.001f;
    protected final Cache i;
    private final ArrayRow n;
    private final int k = -1;
    private int l = 16;
    private int m = 16;

    /* renamed from: a  reason: collision with root package name */
    int[] f2000a = new int[16];
    int[] b = new int[16];

    /* renamed from: c  reason: collision with root package name */
    int[] f2001c = new int[16];
    float[] d = new float[16];
    int[] e = new int[16];
    int[] f = new int[16];
    int g = 0;
    int h = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.n = arrayRow;
        this.i = cache;
        clear();
    }

    private void a() {
        int i = this.l * 2;
        this.f2001c = Arrays.copyOf(this.f2001c, i);
        this.d = Arrays.copyOf(this.d, i);
        this.e = Arrays.copyOf(this.e, i);
        this.f = Arrays.copyOf(this.f, i);
        this.b = Arrays.copyOf(this.b, i);
        int i2 = this.l;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.l = i;
                return;
            }
            this.f2001c[i3] = -1;
            this.b[i3] = -1;
            i2 = i3 + 1;
        }
    }

    private void a(int i, SolverVariable solverVariable, float f) {
        this.f2001c[i] = solverVariable.id;
        this.d[i] = f;
        this.e[i] = -1;
        this.f[i] = -1;
        solverVariable.addToRow(this.n);
        solverVariable.usageInRowCount++;
        this.g++;
    }

    private void a(SolverVariable solverVariable) {
        int i = solverVariable.id % this.m;
        int i2 = this.f2000a[i];
        if (i2 == -1) {
            return;
        }
        int i3 = solverVariable.id;
        int i4 = i2;
        if (this.f2001c[i2] == i3) {
            int[] iArr = this.f2000a;
            int[] iArr2 = this.b;
            iArr[i] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        while (true) {
            int[] iArr3 = this.b;
            if (iArr3[i4] == -1 || this.f2001c[iArr3[i4]] == i3) {
                break;
            }
            i4 = iArr3[i4];
        }
        int[] iArr4 = this.b;
        int i5 = iArr4[i4];
        if (i5 == -1 || this.f2001c[i5] != i3) {
            return;
        }
        iArr4[i4] = iArr4[i5];
        iArr4[i5] = -1;
    }

    private void a(SolverVariable solverVariable, int i) {
        int[] iArr;
        int i2 = solverVariable.id % this.m;
        int[] iArr2 = this.f2000a;
        int i3 = iArr2[i2];
        int i4 = i3;
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.b;
                if (iArr[i4] == -1) {
                    break;
                }
                i4 = iArr[i4];
            }
            iArr[i4] = i;
        }
        this.b[i] = -1;
    }

    private int b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.l) {
                return -1;
            }
            if (this.f2001c[i2] == -1) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    private void b(int i, SolverVariable solverVariable, float f) {
        int b = b();
        a(b, solverVariable, f);
        if (i != -1) {
            this.e[b] = i;
            int[] iArr = this.f;
            iArr[b] = iArr[i];
            iArr[i] = b;
        } else {
            this.e[b] = -1;
            if (this.g > 0) {
                this.f[b] = this.h;
                this.h = b;
            } else {
                this.f[b] = -1;
            }
        }
        int[] iArr2 = this.f;
        if (iArr2[b] != -1) {
            this.e[iArr2[b]] = b;
        }
        a(solverVariable, b);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f, boolean z) {
        float f2 = j;
        if (f <= (-f2) || f >= f2) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f);
                return;
            }
            float[] fArr = this.d;
            fArr[indexOf] = fArr[indexOf] + f;
            float f3 = fArr[indexOf];
            float f4 = j;
            if (f3 <= (-f4) || fArr[indexOf] >= f4) {
                return;
            }
            fArr[indexOf] = 0.0f;
            remove(solverVariable, z);
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int i = this.g;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                break;
            }
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                variable.removeFromRow(this.n);
            }
            i2 = i3 + 1;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= this.l) {
                break;
            }
            this.f2001c[i5] = -1;
            this.b[i5] = -1;
            i4 = i5 + 1;
        }
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.m) {
                this.g = 0;
                this.h = -1;
                return;
            }
            this.f2000a[i7] = -1;
            i6 = i7 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i = this.g;
        System.out.print("{ ");
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                System.out.println(" }");
                return;
            }
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i3) + " ");
            }
            i2 = i3 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f) {
        int i = this.g;
        int i2 = this.h;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return;
            }
            float[] fArr = this.d;
            fArr[i2] = fArr[i2] / f;
            i2 = this.f[i2];
            if (i2 == -1) {
                return;
            }
            i3 = i4 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.d[indexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.g;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i) {
        int i2 = this.g;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.h;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i2) {
                return null;
            }
            if (i5 == i && i3 != -1) {
                return this.i.d[this.f2001c[i3]];
            }
            i3 = this.f[i3];
            if (i3 == -1) {
                return null;
            }
            i4 = i5 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i) {
        int i2 = this.g;
        int i3 = this.h;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i2) {
                return 0.0f;
            }
            if (i5 == i) {
                return this.d[i3];
            }
            i3 = this.f[i3];
            if (i3 == -1) {
                return 0.0f;
            }
            i4 = i5 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        if (this.g == 0 || solverVariable == null) {
            return -1;
        }
        int i = solverVariable.id;
        int i2 = this.f2000a[i % this.m];
        if (i2 == -1) {
            return -1;
        }
        int i3 = i2;
        if (this.f2001c[i2] == i) {
            return i2;
        }
        while (true) {
            int[] iArr = this.b;
            if (iArr[i3] == -1 || this.f2001c[iArr[i3]] == i) {
                break;
            }
            i3 = iArr[i3];
        }
        int[] iArr2 = this.b;
        if (iArr2[i3] != -1 && this.f2001c[iArr2[i3]] == i) {
            return iArr2[i3];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i = this.g;
        int i2 = this.h;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return;
            }
            float[] fArr = this.d;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f[i2];
            if (i2 == -1) {
                return;
            }
            i3 = i4 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f) {
        int i;
        float f2 = j;
        if (f > (-f2) && f < f2) {
            remove(solverVariable, true);
            return;
        }
        int i2 = 0;
        if (this.g == 0) {
            a(0, solverVariable, f);
            a(solverVariable, 0);
            this.h = 0;
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            this.d[indexOf] = f;
            return;
        }
        if (this.g + 1 >= this.l) {
            a();
        }
        int i3 = this.g;
        int i4 = this.h;
        int i5 = -1;
        while (true) {
            i = i5;
            if (i2 >= i3) {
                break;
            } else if (this.f2001c[i4] == solverVariable.id) {
                this.d[i4] = f;
                return;
            } else {
                if (this.f2001c[i4] < solverVariable.id) {
                    i5 = i4;
                }
                i4 = this.f[i4];
                if (i4 == -1) {
                    i = i5;
                    break;
                }
                i2++;
            }
        }
        b(i, solverVariable, f);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        a(solverVariable);
        float f = this.d[indexOf];
        if (this.h == indexOf) {
            this.h = this.f[indexOf];
        }
        this.f2001c[indexOf] = -1;
        int[] iArr = this.e;
        if (iArr[indexOf] != -1) {
            int[] iArr2 = this.f;
            iArr2[iArr[indexOf]] = iArr2[indexOf];
        }
        int[] iArr3 = this.f;
        if (iArr3[indexOf] != -1) {
            int[] iArr4 = this.e;
            iArr4[iArr3[indexOf]] = iArr4[indexOf];
        }
        this.g--;
        solverVariable.usageInRowCount--;
        if (z) {
            solverVariable.removeFromRow(this.n);
        }
        return f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str;
        String str2;
        String str3 = hashCode() + " { ";
        int i = this.g;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return str3 + " }";
            }
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                String str4 = str3 + variable + " = " + getVariableValue(i3) + " ";
                int indexOf = indexOf(variable);
                String str5 = str4 + "[p: ";
                if (this.e[indexOf] != -1) {
                    str = str5 + this.i.d[this.f2001c[this.e[indexOf]]];
                } else {
                    str = str5 + "none";
                }
                String str6 = str + ", n: ";
                if (this.f[indexOf] != -1) {
                    str2 = str6 + this.i.d[this.f2001c[this.f[indexOf]]];
                } else {
                    str2 = str6 + "none";
                }
                str3 = str2 + "]";
            }
            i2 = i3 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.f1986a);
        remove(arrayRow.f1986a, z);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i = solverVariableValues.h;
        int i2 = 0;
        int i3 = 0;
        while (i2 < currentSize) {
            int i4 = i2;
            if (solverVariableValues.f2001c[i3] != -1) {
                add(this.i.d[solverVariableValues.f2001c[i3]], solverVariableValues.d[i3] * f, z);
                i4 = i2 + 1;
            }
            i3++;
            i2 = i4;
        }
        return f;
    }
}
