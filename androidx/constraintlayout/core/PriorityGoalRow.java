package androidx.constraintlayout.core;

import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/PriorityGoalRow.class */
public class PriorityGoalRow extends ArrayRow {
    GoalVariableAccessor f;
    Cache g;
    private int h;
    private SolverVariable[] i;
    private SolverVariable[] j;
    private int k;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/PriorityGoalRow$GoalVariableAccessor.class */
    class GoalVariableAccessor {

        /* renamed from: a  reason: collision with root package name */
        SolverVariable f1994a;
        PriorityGoalRow b;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.b = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 9) {
                    return;
                }
                float[] fArr = this.f1994a.f1997c;
                fArr[i2] = fArr[i2] + solverVariable.f1997c[i2];
                if (Math.abs(this.f1994a.f1997c[i2]) < 1.0E-4f) {
                    this.f1994a.f1997c[i2] = 0.0f;
                }
                i = i2 + 1;
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f) {
            boolean z = true;
            if (!this.f1994a.inGoal) {
                for (int i = 0; i < 9; i++) {
                    float f2 = solverVariable.f1997c[i];
                    if (f2 != 0.0f) {
                        float f3 = f2 * f;
                        float f4 = f3;
                        if (Math.abs(f3) < 1.0E-4f) {
                            f4 = 0.0f;
                        }
                        this.f1994a.f1997c[i] = f4;
                    } else {
                        this.f1994a.f1997c[i] = 0.0f;
                    }
                }
                return true;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= 9) {
                    break;
                }
                float[] fArr = this.f1994a.f1997c;
                fArr[i3] = fArr[i3] + (solverVariable.f1997c[i3] * f);
                if (Math.abs(this.f1994a.f1997c[i3]) < 1.0E-4f) {
                    this.f1994a.f1997c[i3] = 0.0f;
                } else {
                    z = false;
                }
                i2 = i3 + 1;
            }
            if (z) {
                PriorityGoalRow.this.d(this.f1994a);
                return false;
            }
            return false;
        }

        public void init(SolverVariable solverVariable) {
            this.f1994a = solverVariable;
        }

        public final boolean isNegative() {
            int i = 8;
            while (true) {
                int i2 = i;
                if (i2 < 0) {
                    return false;
                }
                float f = this.f1994a.f1997c[i2];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
                i = i2 - 1;
            }
        }

        public final boolean isNull() {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 9) {
                    return true;
                }
                if (this.f1994a.f1997c[i2] != 0.0f) {
                    return false;
                }
                i = i2 + 1;
            }
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i = 8;
            while (true) {
                int i2 = i;
                if (i2 < 0) {
                    return false;
                }
                float f = solverVariable.f1997c[i2];
                float f2 = this.f1994a.f1997c[i2];
                if (f2 != f) {
                    return f2 < f;
                }
                i = i2 - 1;
            }
        }

        public void reset() {
            Arrays.fill(this.f1994a.f1997c, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            String str2 = str;
            if (this.f1994a != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    str2 = str;
                    if (i2 >= 9) {
                        break;
                    }
                    str = str + this.f1994a.f1997c[i2] + " ";
                    i = i2 + 1;
                }
            }
            return str2 + "] " + this.f1994a;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.h = 128;
        this.i = new SolverVariable[128];
        this.j = new SolverVariable[128];
        this.k = 0;
        this.f = new GoalVariableAccessor(this);
        this.g = cache;
    }

    private final void c(SolverVariable solverVariable) {
        int i;
        int i2 = this.k;
        SolverVariable[] solverVariableArr = this.i;
        if (i2 + 1 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.i = solverVariableArr2;
            this.j = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.i;
        int i3 = this.k;
        solverVariableArr3[i3] = solverVariable;
        int i4 = i3 + 1;
        this.k = i4;
        if (i4 > 1 && solverVariableArr3[i4 - 1].id > solverVariable.id) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                i = this.k;
                if (i6 >= i) {
                    break;
                }
                this.j[i6] = this.i[i6];
                i5 = i6 + 1;
            }
            Arrays.sort(this.j, 0, i, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.id - solverVariable3.id;
                }
            });
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= this.k) {
                    break;
                }
                this.i[i8] = this.j[i8];
                i7 = i8 + 1;
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(SolverVariable solverVariable) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                return;
            }
            if (this.i[i2] == solverVariable) {
                while (true) {
                    int i3 = this.k;
                    if (i2 >= i3 - 1) {
                        this.k = i3 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                    SolverVariable[] solverVariableArr = this.i;
                    int i4 = i2 + 1;
                    solverVariableArr[i2] = solverVariableArr[i4];
                    i2 = i4;
                }
            } else {
                i = i2 + 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.f.init(solverVariable);
        this.f.reset();
        solverVariable.f1997c[solverVariable.strength] = 1.0f;
        c(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.k = 0;
        this.b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = -1;
        while (true) {
            i = i4;
            if (i3 >= this.k) {
                break;
            }
            SolverVariable solverVariable = this.i[i3];
            if (zArr[solverVariable.id]) {
                i2 = i;
            } else {
                this.f.init(solverVariable);
                if (i == -1) {
                    i2 = i;
                    if (!this.f.isNegative()) {
                    }
                    i2 = i3;
                } else {
                    i2 = i;
                    if (!this.f.isSmallerThan(this.i[i])) {
                    }
                    i2 = i3;
                }
            }
            i3++;
            i4 = i2;
        }
        if (i == -1) {
            return null;
        }
        return this.i[i];
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.k == 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.b + ") : ";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                return str;
            }
            this.f.init(this.i[i2]);
            str = str + this.f + " ";
            i = i2 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.f1986a;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= currentSize) {
                d(solverVariable);
                return;
            }
            SolverVariable variable = arrayRowVariables.getVariable(i2);
            float variableValue = arrayRowVariables.getVariableValue(i2);
            this.f.init(variable);
            if (this.f.addToGoal(solverVariable, variableValue)) {
                c(variable);
            }
            this.b += arrayRow.b * variableValue;
            i = i2 + 1;
        }
    }
}
