package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/ArrayLinkedVariables.class */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static float l = 0.001f;
    protected final Cache b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayRow f1985c;

    /* renamed from: a  reason: collision with root package name */
    int f1984a = 0;
    private int d = 8;
    private SolverVariable e = null;
    private int[] f = new int[8];
    private int[] g = new int[8];
    private float[] h = new float[8];
    private int i = -1;
    private int j = -1;
    private boolean k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.f1985c = arrayRow;
        this.b = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f, boolean z) {
        float f2 = l;
        if (f <= (-f2) || f >= f2) {
            int i = this.i;
            if (i == -1) {
                this.i = 0;
                this.h[0] = f;
                this.f[0] = solverVariable.id;
                this.g[this.i] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.f1985c);
                this.f1984a++;
                if (this.k) {
                    return;
                }
                int i2 = this.j + 1;
                this.j = i2;
                int[] iArr = this.f;
                if (i2 >= iArr.length) {
                    this.k = true;
                    this.j = iArr.length - 1;
                    return;
                }
                return;
            }
            int i3 = -1;
            for (int i4 = 0; i != -1 && i4 < this.f1984a; i4++) {
                if (this.f[i] == solverVariable.id) {
                    float f3 = this.h[i] + f;
                    float f4 = l;
                    float f5 = f3;
                    if (f3 > (-f4)) {
                        f5 = f3;
                        if (f3 < f4) {
                            f5 = 0.0f;
                        }
                    }
                    this.h[i] = f5;
                    if (f5 == 0.0f) {
                        if (i == this.i) {
                            this.i = this.g[i];
                        } else {
                            int[] iArr2 = this.g;
                            iArr2[i3] = iArr2[i];
                        }
                        if (z) {
                            solverVariable.removeFromRow(this.f1985c);
                        }
                        if (this.k) {
                            this.j = i;
                        }
                        solverVariable.usageInRowCount--;
                        this.f1984a--;
                        return;
                    }
                    return;
                }
                if (this.f[i] < solverVariable.id) {
                    i3 = i;
                }
                i = this.g[i];
            }
            int i5 = this.j;
            if (this.k) {
                int[] iArr3 = this.f;
                if (iArr3[i5] != -1) {
                    i5 = iArr3.length;
                }
            } else {
                i5++;
            }
            int[] iArr4 = this.f;
            int i6 = i5;
            if (i5 >= iArr4.length) {
                i6 = i5;
                if (this.f1984a < iArr4.length) {
                    int i7 = 0;
                    while (true) {
                        int i8 = i7;
                        int[] iArr5 = this.f;
                        i6 = i5;
                        if (i8 >= iArr5.length) {
                            break;
                        } else if (iArr5[i8] == -1) {
                            i6 = i8;
                            break;
                        } else {
                            i7 = i8 + 1;
                        }
                    }
                }
            }
            int[] iArr6 = this.f;
            int i9 = i6;
            if (i6 >= iArr6.length) {
                i9 = iArr6.length;
                int i10 = this.d * 2;
                this.d = i10;
                this.k = false;
                this.j = i9 - 1;
                this.h = Arrays.copyOf(this.h, i10);
                this.f = Arrays.copyOf(this.f, this.d);
                this.g = Arrays.copyOf(this.g, this.d);
            }
            this.f[i9] = solverVariable.id;
            this.h[i9] = f;
            if (i3 != -1) {
                int[] iArr7 = this.g;
                iArr7[i9] = iArr7[i3];
                iArr7[i3] = i9;
            } else {
                this.g[i9] = this.i;
                this.i = i9;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.f1985c);
            this.f1984a++;
            if (!this.k) {
                this.j++;
            }
            int i11 = this.j;
            int[] iArr8 = this.f;
            if (i11 >= iArr8.length) {
                this.k = true;
                this.j = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i = this.i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i == -1 || i3 >= this.f1984a) {
                break;
            }
            SolverVariable solverVariable = this.b.d[this.f[i]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.f1985c);
            }
            i = this.g[i];
            i2 = i3 + 1;
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f1984a = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i = this.i;
        if (i == -1) {
            return false;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i == -1 || i3 >= this.f1984a) {
                return false;
            }
            if (this.f[i] == solverVariable.id) {
                return true;
            }
            i = this.g[i];
            i2 = i3 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i = this.f1984a;
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
        int i = this.i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i == -1 || i3 >= this.f1984a) {
                return;
            }
            float[] fArr = this.h;
            fArr[i] = fArr[i] / f;
            i = this.g[i];
            i2 = i3 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i = this.i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i == -1 || i3 >= this.f1984a) {
                return 0.0f;
            }
            if (this.f[i] == solverVariable.id) {
                return this.h[i];
            }
            i = this.g[i];
            i2 = i3 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.f1984a;
    }

    public int getHead() {
        return this.i;
    }

    public final int getId(int i) {
        return this.f[i];
    }

    public final int getNextIndice(int i) {
        return this.g[i];
    }

    public final float getValue(int i) {
        return this.h[i];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i) {
        int i2 = this.i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 == -1 || i4 >= this.f1984a) {
                return null;
            }
            if (i4 == i) {
                return this.b.d[this.f[i2]];
            }
            i2 = this.g[i2];
            i3 = i4 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i) {
        int i2 = this.i;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 == -1 || i4 >= this.f1984a) {
                return 0.0f;
            }
            if (i4 == i) {
                return this.h[i2];
            }
            i2 = this.g[i2];
            i3 = i4 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i = this.i;
        if (i == -1) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i == -1 || i3 >= this.f1984a) {
                return -1;
            }
            if (this.f[i] == solverVariable.id) {
                return i;
            }
            i = this.g[i];
            i2 = i3 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i = this.i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i == -1 || i3 >= this.f1984a) {
                return;
            }
            float[] fArr = this.h;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.g[i];
            i2 = i3 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            this.h[0] = f;
            this.f[0] = solverVariable.id;
            this.g[this.i] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.f1985c);
            this.f1984a++;
            if (this.k) {
                return;
            }
            int i2 = this.j + 1;
            this.j = i2;
            int[] iArr = this.f;
            if (i2 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.f1984a; i4++) {
            if (this.f[i] == solverVariable.id) {
                this.h[i] = f;
                return;
            }
            if (this.f[i] < solverVariable.id) {
                i3 = i;
            }
            i = this.g[i];
        }
        int i5 = this.j;
        if (this.k) {
            int[] iArr2 = this.f;
            if (iArr2[i5] != -1) {
                i5 = iArr2.length;
            }
        } else {
            i5++;
        }
        int[] iArr3 = this.f;
        int i6 = i5;
        if (i5 >= iArr3.length) {
            i6 = i5;
            if (this.f1984a < iArr3.length) {
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    int[] iArr4 = this.f;
                    i6 = i5;
                    if (i8 >= iArr4.length) {
                        break;
                    } else if (iArr4[i8] == -1) {
                        i6 = i8;
                        break;
                    } else {
                        i7 = i8 + 1;
                    }
                }
            }
        }
        int[] iArr5 = this.f;
        int i9 = i6;
        if (i6 >= iArr5.length) {
            i9 = iArr5.length;
            int i10 = this.d * 2;
            this.d = i10;
            this.k = false;
            this.j = i9 - 1;
            this.h = Arrays.copyOf(this.h, i10);
            this.f = Arrays.copyOf(this.f, this.d);
            this.g = Arrays.copyOf(this.g, this.d);
        }
        this.f[i9] = solverVariable.id;
        this.h[i9] = f;
        if (i3 != -1) {
            int[] iArr6 = this.g;
            iArr6[i9] = iArr6[i3];
            iArr6[i3] = i9;
        } else {
            this.g[i9] = this.i;
            this.i = i9;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.f1985c);
        this.f1984a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f1984a >= this.f.length) {
            this.k = true;
        }
        int i11 = this.j;
        int[] iArr7 = this.f;
        if (i11 >= iArr7.length) {
            this.k = true;
            this.j = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z) {
        if (this.e == solverVariable) {
            this.e = null;
        }
        int i = this.i;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f1984a) {
            if (this.f[i] == solverVariable.id) {
                if (i == this.i) {
                    this.i = this.g[i];
                } else {
                    int[] iArr = this.g;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    solverVariable.removeFromRow(this.f1985c);
                }
                solverVariable.usageInRowCount--;
                this.f1984a--;
                this.f[i] = -1;
                if (this.k) {
                    this.j = i;
                }
                return this.h[i];
            }
            i2++;
            i3 = i;
            i = this.g[i];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.f.length * 4 * 3) + 0 + 36;
    }

    public String toString() {
        int i = this.i;
        String str = "";
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i == -1 || i3 >= this.f1984a) {
                break;
            }
            str = ((str + " -> ") + this.h[i] + " : ") + this.b.d[this.f[i]];
            i = this.g[i];
            i2 = i3 + 1;
        }
        return str;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        float f = get(arrayRow.f1986a);
        remove(arrayRow.f1986a, z);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= currentSize) {
                return f;
            }
            SolverVariable variable = arrayRowVariables.getVariable(i2);
            add(variable, arrayRowVariables.get(variable) * f, z);
            i = i2 + 1;
        }
    }
}
