package androidx.constraintlayout.core;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/ArrayRow.class */
public class ArrayRow implements LinearSystem.Row {

    /* renamed from: a  reason: collision with root package name */
    SolverVariable f1938a = null;
    float b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    boolean f1939c = false;
    ArrayList<SolverVariable> d = new ArrayList<>();
    boolean e = false;
    public ArrayRowVariables variables;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/ArrayRow$ArrayRowVariables.class */
    public interface ArrayRowVariables {
        void add(SolverVariable solverVariable, float f, boolean z);

        void clear();

        boolean contains(SolverVariable solverVariable);

        void display();

        void divideByAmount(float f);

        float get(SolverVariable solverVariable);

        int getCurrentSize();

        SolverVariable getVariable(int i);

        float getVariableValue(int i);

        int indexOf(SolverVariable solverVariable);

        void invert();

        void put(SolverVariable solverVariable, float f);

        float remove(SolverVariable solverVariable, boolean z);

        int sizeInBytes();

        float use(ArrayRow arrayRow, boolean z);
    }

    public ArrayRow() {
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    private SolverVariable a(boolean[] zArr, SolverVariable solverVariable) {
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        int i = 0;
        float f = 0.0f;
        while (true) {
            float f2 = f;
            if (i >= currentSize) {
                return solverVariable2;
            }
            float variableValue = this.variables.getVariableValue(i);
            SolverVariable solverVariable3 = solverVariable2;
            float f3 = f2;
            if (variableValue < 0.0f) {
                SolverVariable variable = this.variables.getVariable(i);
                if (zArr != null) {
                    solverVariable3 = solverVariable2;
                    f3 = f2;
                    if (zArr[variable.id]) {
                    }
                }
                solverVariable3 = solverVariable2;
                f3 = f2;
                if (variable != solverVariable) {
                    if (variable.d != SolverVariable.Type.SLACK) {
                        solverVariable3 = solverVariable2;
                        f3 = f2;
                        if (variable.d != SolverVariable.Type.ERROR) {
                        }
                    }
                    solverVariable3 = solverVariable2;
                    f3 = f2;
                    if (variableValue < f2) {
                        f3 = variableValue;
                        solverVariable3 = variable;
                    }
                }
            }
            i++;
            solverVariable2 = solverVariable3;
            f = f3;
        }
    }

    private boolean a(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow a(SolverVariable solverVariable, int i) {
        this.f1938a = solverVariable;
        float f = i;
        solverVariable.computedValue = f;
        this.b = f;
        this.e = true;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow a(SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.b = (-i) + i2;
                return this;
            }
        } else if (f <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.b = i;
            return this;
        } else if (f >= 1.0f) {
            this.variables.put(solverVariable4, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            this.b = -i2;
            return this;
        } else {
            float f2 = 1.0f - f;
            this.variables.put(solverVariable, f2 * 1.0f);
            this.variables.put(solverVariable2, f2 * (-1.0f));
            this.variables.put(solverVariable3, (-1.0f) * f);
            this.variables.put(solverVariable4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.b = ((-i) * f2) + (i2 * f);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        SolverVariable solverVariable = this.f1938a;
        if (solverVariable != null) {
            return solverVariable.d == SolverVariable.Type.UNRESTRICTED || this.b >= 0.0f;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(LinearSystem linearSystem) {
        boolean z;
        SolverVariable b = b(linearSystem);
        if (b == null) {
            z = true;
        } else {
            b(b);
            z = false;
        }
        if (this.variables.getCurrentSize() == 0) {
            this.e = true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    public ArrayRow addError(LinearSystem linearSystem, int i) {
        this.variables.put(linearSystem.createErrorVariable(i, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(i, "em"), -1.0f);
        return this;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        float f = 1.0f;
        if (solverVariable.strength != 1) {
            if (solverVariable.strength == 2) {
                f = 1000.0f;
            } else if (solverVariable.strength == 3) {
                f = 1000000.0f;
            } else if (solverVariable.strength == 4) {
                f = 1.0E9f;
            } else if (solverVariable.strength == 5) {
                f = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayRow b(SolverVariable solverVariable, int i) {
        this.variables.put(solverVariable, i);
        return this;
    }

    SolverVariable b(LinearSystem linearSystem) {
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        boolean z;
        boolean z2;
        float f;
        float f2;
        boolean a2;
        int currentSize = this.variables.getCurrentSize();
        SolverVariable solverVariable3 = null;
        SolverVariable solverVariable4 = null;
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (true) {
            float f5 = f4;
            if (i >= currentSize) {
                break;
            }
            float variableValue = this.variables.getVariableValue(i);
            SolverVariable variable = this.variables.getVariable(i);
            if (variable.d == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable3 == null) {
                    z = a(variable, linearSystem);
                } else if (f3 > variableValue) {
                    z = a(variable, linearSystem);
                } else {
                    solverVariable = solverVariable3;
                    solverVariable2 = solverVariable4;
                    z = z3;
                    z2 = z4;
                    f = f3;
                    f2 = f5;
                    if (!z3) {
                        solverVariable = solverVariable3;
                        solverVariable2 = solverVariable4;
                        z = z3;
                        z2 = z4;
                        f = f3;
                        f2 = f5;
                        if (a(variable, linearSystem)) {
                            z = true;
                            solverVariable = variable;
                            solverVariable2 = solverVariable4;
                            z2 = z4;
                            f = variableValue;
                            f2 = f5;
                        }
                    }
                }
                solverVariable = variable;
                solverVariable2 = solverVariable4;
                z2 = z4;
                f = variableValue;
                f2 = f5;
            } else {
                solverVariable = solverVariable3;
                solverVariable2 = solverVariable4;
                z = z3;
                z2 = z4;
                f = f3;
                f2 = f5;
                if (solverVariable3 == null) {
                    solverVariable = solverVariable3;
                    solverVariable2 = solverVariable4;
                    z = z3;
                    z2 = z4;
                    f = f3;
                    f2 = f5;
                    if (variableValue < 0.0f) {
                        if (solverVariable4 == null) {
                            a2 = a(variable, linearSystem);
                        } else if (f5 > variableValue) {
                            a2 = a(variable, linearSystem);
                        } else {
                            solverVariable = solverVariable3;
                            solverVariable2 = solverVariable4;
                            z = z3;
                            z2 = z4;
                            f = f3;
                            f2 = f5;
                            if (!z4) {
                                solverVariable = solverVariable3;
                                solverVariable2 = solverVariable4;
                                z = z3;
                                z2 = z4;
                                f = f3;
                                f2 = f5;
                                if (a(variable, linearSystem)) {
                                    z2 = true;
                                    f2 = variableValue;
                                    f = f3;
                                    z = z3;
                                    solverVariable2 = variable;
                                    solverVariable = solverVariable3;
                                }
                            }
                        }
                        z2 = a2;
                        solverVariable = solverVariable3;
                        solverVariable2 = variable;
                        z = z3;
                        f = f3;
                        f2 = variableValue;
                    }
                }
            }
            i++;
            solverVariable3 = solverVariable;
            solverVariable4 = solverVariable2;
            z3 = z;
            z4 = z2;
            f3 = f;
            f4 = f2;
        }
        return solverVariable3 != null ? solverVariable3 : solverVariable4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b() {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.ArrayRow.b():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f1938a;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.f1938a.f1948a = -1;
            this.f1938a = null;
        }
        float remove = this.variables.remove(solverVariable, true) * (-1.0f);
        this.f1938a = solverVariable;
        if (remove == 1.0f) {
            return;
        }
        this.b /= remove;
        this.variables.divideByAmount(remove);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return (this.f1938a != null ? 4 : 0) + 4 + 4 + this.variables.sizeInBytes();
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.variables.clear();
        this.f1938a = null;
        this.b = 0.0f;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f);
        this.variables.put(solverVariable4, -f);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f, float f2, float f3, SolverVariable solverVariable, int i, SolverVariable solverVariable2, int i2, SolverVariable solverVariable3, int i3, SolverVariable solverVariable4, int i4) {
        if (f2 == 0.0f || f == f3) {
            this.b = ((-i) - i2) + i3 + i4;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        float f4 = (f / f2) / (f3 / f2);
        this.b = ((-i) - i2) + (i3 * f4) + (i4 * f4);
        this.variables.put(solverVariable, 1.0f);
        this.variables.put(solverVariable2, -1.0f);
        this.variables.put(solverVariable4, f4);
        this.variables.put(solverVariable3, -f4);
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f, float f2, float f3, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        } else if (f == 0.0f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            return this;
        } else if (f3 == 0.0f) {
            this.variables.put(solverVariable3, 1.0f);
            this.variables.put(solverVariable4, -1.0f);
            return this;
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f4);
            this.variables.put(solverVariable3, -f4);
            return this;
        }
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.b = i * (-1);
            this.variables.put(solverVariable, 1.0f);
            return this;
        }
        this.b = i;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            z = false;
            int i2 = i;
            if (i < 0) {
                i2 = i * (-1);
                z = true;
            }
            this.b = i2;
        }
        if (z) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            return this;
        }
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int i, SolverVariable solverVariable2) {
        this.b = i;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            z = false;
            int i2 = i;
            if (i < 0) {
                i2 = i * (-1);
                z = true;
            }
            this.b = i2;
        }
        if (z) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            return this;
        }
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, 1.0f);
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            z = false;
            int i2 = i;
            if (i < 0) {
                i2 = i * (-1);
                z = true;
            }
            this.b = i2;
        }
        if (z) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            return this;
        }
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, -1.0f);
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.b = -f;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        float f = this.b;
        if (f < 0.0f) {
            this.b = f * (-1.0f);
            this.variables.invert();
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getKey() {
        return this.f1938a;
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        return a(zArr, (SolverVariable) null);
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void initFromRow(LinearSystem.Row row) {
        if (!(row instanceof ArrayRow)) {
            return;
        }
        ArrayRow arrayRow = (ArrayRow) row;
        this.f1938a = null;
        this.variables.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayRow.variables.getCurrentSize()) {
                return;
            }
            this.variables.add(arrayRow.variables.getVariable(i2), arrayRow.variables.getVariableValue(i2), true);
            i = i2 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.f1938a == null && this.b == 0.0f && this.variables.getCurrentSize() == 0;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return a((boolean[]) null, solverVariable);
    }

    public void reset() {
        this.f1938a = null;
        this.variables.clear();
        this.b = 0.0f;
        this.e = false;
    }

    public String toString() {
        return b();
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable == null || !solverVariable.isFinalValue) {
            return;
        }
        this.b += solverVariable.computedValue * this.variables.get(solverVariable);
        this.variables.remove(solverVariable, z);
        if (z) {
            solverVariable.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
            this.e = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        this.b += arrayRow.b * this.variables.use(arrayRow, z);
        if (z) {
            arrayRow.f1938a.removeFromRow(this);
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.f1938a != null && this.variables.getCurrentSize() == 0) {
            this.e = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z) {
        if (solverVariable == null || !solverVariable.g) {
            return;
        }
        float f = this.variables.get(solverVariable);
        this.b += solverVariable.i * f;
        this.variables.remove(solverVariable, z);
        if (z) {
            solverVariable.removeFromRow(this);
        }
        this.variables.add(linearSystem.e.d[solverVariable.h], f, z);
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.variables.getCurrentSize() == 0) {
            this.e = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }

    @Override // androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromSystem(LinearSystem linearSystem) {
        if (linearSystem.b.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int currentSize = this.variables.getCurrentSize();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= currentSize) {
                    break;
                }
                SolverVariable variable = this.variables.getVariable(i2);
                if (variable.f1948a != -1 || variable.isFinalValue || variable.g) {
                    this.d.add(variable);
                }
                i = i2 + 1;
            }
            int size = this.d.size();
            if (size > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= size) {
                        break;
                    }
                    SolverVariable solverVariable = this.d.get(i4);
                    if (solverVariable.isFinalValue) {
                        updateFromFinalVariable(linearSystem, solverVariable, true);
                    } else if (solverVariable.g) {
                        updateFromSynonymVariable(linearSystem, solverVariable, true);
                    } else {
                        updateFromRow(linearSystem, linearSystem.b[solverVariable.f1948a], true);
                    }
                    i3 = i4 + 1;
                }
                this.d.clear();
            } else {
                z = true;
            }
        }
        if (LinearSystem.SIMPLIFY_SYNONYMS && this.f1938a != null && this.variables.getCurrentSize() == 0) {
            this.e = true;
            linearSystem.hasSimpleDefinition = true;
        }
    }
}
