package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/LinearSystem.class */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    private static int f = 1000;
    public static Metrics sMetrics;
    ArrayRow[] b;
    final Cache e;
    private Row h;
    private Row o;
    public boolean hasSimpleDefinition = false;

    /* renamed from: a  reason: collision with root package name */
    int f1942a = 0;
    private HashMap<String, SolverVariable> g = null;
    private int i = 32;
    private int j = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] k = new boolean[32];

    /* renamed from: c  reason: collision with root package name */
    int f1943c = 1;
    int d = 0;
    private int l = 32;
    private SolverVariable[] m = new SolverVariable[f];
    private int n = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/LinearSystem$Row.class */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z);

        void updateFromSystem(LinearSystem linearSystem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/LinearSystem$ValuesRow.class */
    public class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        this.b = null;
        this.b = new ArrayRow[32];
        b();
        Cache cache = new Cache();
        this.e = cache;
        this.h = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.o = new ValuesRow(this.e);
        } else {
            this.o = new ArrayRow(this.e);
        }
    }

    private final int a(Row row, boolean z) {
        int i;
        float f2;
        int i2;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.f1943c) {
                break;
            }
            this.k[i4] = false;
            i3 = i4 + 1;
        }
        boolean z2 = false;
        int i5 = 0;
        while (!z2) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            int i6 = i5 + 1;
            if (i6 >= this.f1943c * 2) {
                return i6;
            }
            if (row.getKey() != null) {
                this.k[row.getKey().id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.k);
            if (pivotCandidate != null) {
                if (this.k[pivotCandidate.id]) {
                    return i6;
                }
                this.k[pivotCandidate.id] = true;
            }
            if (pivotCandidate != null) {
                float f3 = Float.MAX_VALUE;
                int i7 = 0;
                int i8 = -1;
                while (true) {
                    i = i8;
                    if (i7 >= this.d) {
                        break;
                    }
                    ArrayRow arrayRow = this.b[i7];
                    if (arrayRow.f1938a.d == SolverVariable.Type.UNRESTRICTED) {
                        f2 = f3;
                        i2 = i;
                    } else if (arrayRow.e) {
                        f2 = f3;
                        i2 = i;
                    } else {
                        f2 = f3;
                        i2 = i;
                        if (arrayRow.a(pivotCandidate)) {
                            float f4 = arrayRow.variables.get(pivotCandidate);
                            f2 = f3;
                            i2 = i;
                            if (f4 < 0.0f) {
                                float f5 = (-arrayRow.b) / f4;
                                f2 = f3;
                                i2 = i;
                                if (f5 < f3) {
                                    i2 = i7;
                                    f2 = f5;
                                }
                            }
                        }
                    }
                    i7++;
                    f3 = f2;
                    i8 = i2;
                }
                i5 = i6;
                if (i > -1) {
                    ArrayRow arrayRow2 = this.b[i];
                    arrayRow2.f1938a.f1948a = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.b(pivotCandidate);
                    arrayRow2.f1938a.f1948a = i;
                    arrayRow2.f1938a.updateReferencesWithNewDefinition(this, arrayRow2);
                    i5 = i6;
                }
            } else {
                z2 = true;
                i5 = i6;
            }
        }
        return i5;
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable solverVariable;
        SolverVariable acquire = this.e.f1941c.acquire();
        if (acquire == null) {
            SolverVariable solverVariable2 = new SolverVariable(type, str);
            solverVariable2.setType(type, str);
            solverVariable = solverVariable2;
        } else {
            acquire.reset();
            acquire.setType(type, str);
            solverVariable = acquire;
        }
        int i = this.n;
        int i2 = f;
        if (i >= i2) {
            int i3 = i2 * 2;
            f = i3;
            this.m = (SolverVariable[]) Arrays.copyOf(this.m, i3);
        }
        SolverVariable[] solverVariableArr = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        solverVariableArr[i4] = solverVariable;
        return solverVariable;
    }

    private void a() {
        int i = this.i * 2;
        this.i = i;
        this.b = (ArrayRow[]) Arrays.copyOf(this.b, i);
        Cache cache = this.e;
        cache.d = (SolverVariable[]) Arrays.copyOf(cache.d, this.i);
        int i2 = this.i;
        this.k = new boolean[i2];
        this.j = i2;
        this.l = i2;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            Metrics metrics2 = sMetrics;
            metrics2.maxTableSize = Math.max(metrics2.maxTableSize, this.i);
            Metrics metrics3 = sMetrics;
            metrics3.lastTableSize = metrics3.maxTableSize;
        }
    }

    private final void a(ArrayRow arrayRow) {
        int i;
        if (SIMPLIFY_SYNONYMS && arrayRow.e) {
            arrayRow.f1938a.setFinalValue(this, arrayRow.b);
        } else {
            this.b[this.d] = arrayRow;
            arrayRow.f1938a.f1948a = this.d;
            this.d++;
            arrayRow.f1938a.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (!SIMPLIFY_SYNONYMS || !this.hasSimpleDefinition) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.d) {
                this.hasSimpleDefinition = false;
                return;
            }
            if (this.b[i3] == null) {
                System.out.println("WTF");
            }
            ArrayRow[] arrayRowArr = this.b;
            int i4 = i3;
            if (arrayRowArr[i3] != null) {
                i4 = i3;
                if (arrayRowArr[i3].e) {
                    ArrayRow arrayRow2 = this.b[i3];
                    arrayRow2.f1938a.setFinalValue(this, arrayRow2.b);
                    if (OPTIMIZED_ENGINE) {
                        this.e.f1940a.release(arrayRow2);
                    } else {
                        this.e.b.release(arrayRow2);
                    }
                    this.b[i3] = null;
                    int i5 = i3 + 1;
                    int i6 = i5;
                    while (true) {
                        i = this.d;
                        if (i5 >= i) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.b;
                        int i7 = i5 - 1;
                        arrayRowArr2[i7] = arrayRowArr2[i5];
                        if (arrayRowArr2[i7].f1938a.f1948a == i5) {
                            this.b[i7].f1938a.f1948a = i7;
                        }
                        i6 = i5;
                        i5++;
                    }
                    if (i6 < i) {
                        this.b[i6] = null;
                    }
                    this.d--;
                    i4 = i3 - 1;
                }
            }
            i2 = i4 + 1;
        }
    }

    private int b(Row row) throws Exception {
        boolean z;
        float f2;
        int i;
        int i2;
        int i3;
        float f3;
        int i4;
        int i5;
        int i6;
        int i7;
        float f4;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = 0;
        while (true) {
            int i13 = i12;
            if (i13 >= this.d) {
                z = false;
                break;
            } else if (this.b[i13].f1938a.d != SolverVariable.Type.UNRESTRICTED && this.b[i13].b < 0.0f) {
                z = true;
                break;
            } else {
                i12 = i13 + 1;
            }
        }
        if (z) {
            boolean z2 = false;
            int i14 = 0;
            while (!z2) {
                Metrics metrics = sMetrics;
                if (metrics != null) {
                    metrics.bfs++;
                }
                int i15 = i14 + 1;
                float f5 = Float.MAX_VALUE;
                int i16 = 0;
                int i17 = -1;
                int i18 = -1;
                int i19 = 0;
                while (true) {
                    int i20 = i19;
                    if (i16 >= this.d) {
                        break;
                    }
                    ArrayRow arrayRow = this.b[i16];
                    if (arrayRow.f1938a.d == SolverVariable.Type.UNRESTRICTED) {
                        f2 = f5;
                        i = i17;
                        i2 = i18;
                        i3 = i20;
                    } else if (arrayRow.e) {
                        f2 = f5;
                        i = i17;
                        i2 = i18;
                        i3 = i20;
                    } else {
                        f2 = f5;
                        i = i17;
                        i2 = i18;
                        i3 = i20;
                        if (arrayRow.b < 0.0f) {
                            if (SKIP_COLUMNS) {
                                int currentSize = arrayRow.variables.getCurrentSize();
                                int i21 = 0;
                                while (true) {
                                    f2 = f5;
                                    i = i17;
                                    i2 = i18;
                                    i3 = i20;
                                    if (i21 < currentSize) {
                                        SolverVariable variable = arrayRow.variables.getVariable(i21);
                                        float f6 = arrayRow.variables.get(variable);
                                        if (f6 <= 0.0f) {
                                            f4 = f5;
                                            i8 = i17;
                                            i9 = i18;
                                            i10 = i20;
                                        } else {
                                            int i22 = i17;
                                            int i23 = 0;
                                            while (true) {
                                                f4 = f5;
                                                i8 = i22;
                                                i9 = i18;
                                                i10 = i20;
                                                if (i23 < 9) {
                                                    float f7 = variable.b[i23] / f6;
                                                    if (f7 >= f5 || i23 != i20) {
                                                        i11 = i20;
                                                        if (i23 <= i20) {
                                                            i23++;
                                                            i20 = i11;
                                                        }
                                                    }
                                                    i18 = variable.id;
                                                    i11 = i23;
                                                    i22 = i16;
                                                    f5 = f7;
                                                    i23++;
                                                    i20 = i11;
                                                }
                                            }
                                        }
                                        i21++;
                                        f5 = f4;
                                        i17 = i8;
                                        i18 = i9;
                                        i20 = i10;
                                    }
                                }
                            } else {
                                int i24 = 1;
                                while (true) {
                                    f2 = f5;
                                    i = i17;
                                    i2 = i18;
                                    i3 = i20;
                                    if (i24 < this.f1943c) {
                                        SolverVariable solverVariable = this.e.d[i24];
                                        float f8 = arrayRow.variables.get(solverVariable);
                                        if (f8 <= 0.0f) {
                                            f3 = f5;
                                            i4 = i17;
                                            i5 = i18;
                                            i6 = i20;
                                        } else {
                                            int i25 = i17;
                                            int i26 = 0;
                                            while (true) {
                                                f3 = f5;
                                                i4 = i25;
                                                i5 = i18;
                                                i6 = i20;
                                                if (i26 < 9) {
                                                    float f9 = solverVariable.b[i26] / f8;
                                                    if (f9 >= f5 || i26 != i20) {
                                                        i7 = i20;
                                                        if (i26 <= i20) {
                                                            i26++;
                                                            i20 = i7;
                                                        }
                                                    }
                                                    i18 = i24;
                                                    i7 = i26;
                                                    i25 = i16;
                                                    f5 = f9;
                                                    i26++;
                                                    i20 = i7;
                                                }
                                            }
                                        }
                                        i24++;
                                        f5 = f3;
                                        i17 = i4;
                                        i18 = i5;
                                        i20 = i6;
                                    }
                                }
                            }
                        }
                    }
                    i16++;
                    f5 = f2;
                    i17 = i;
                    i18 = i2;
                    i19 = i3;
                }
                if (i17 != -1) {
                    ArrayRow arrayRow2 = this.b[i17];
                    arrayRow2.f1938a.f1948a = -1;
                    Metrics metrics2 = sMetrics;
                    if (metrics2 != null) {
                        metrics2.pivots++;
                    }
                    arrayRow2.b(this.e.d[i18]);
                    arrayRow2.f1938a.f1948a = i17;
                    arrayRow2.f1938a.updateReferencesWithNewDefinition(this, arrayRow2);
                } else {
                    z2 = true;
                }
                i14 = i15;
                if (i15 > this.f1943c / 2) {
                    z2 = true;
                    i14 = i15;
                }
            }
            return i14;
        }
        return 0;
    }

    private void b() {
        if (!OPTIMIZED_ENGINE) {
            for (int i = 0; i < this.d; i++) {
                ArrayRow arrayRow = this.b[i];
                if (arrayRow != null) {
                    this.e.b.release(arrayRow);
                }
                this.b[i] = null;
            }
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.d) {
                return;
            }
            ArrayRow arrayRow2 = this.b[i3];
            if (arrayRow2 != null) {
                this.e.f1940a.release(arrayRow2);
            }
            this.b[i3] = null;
            i2 = i3 + 1;
        }
    }

    private void c() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d) {
                return;
            }
            ArrayRow arrayRow = this.b[i2];
            arrayRow.f1938a.computedValue = arrayRow.b;
            i = i2 + 1;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f2) {
        return linearSystem.createRow().a(solverVariable, solverVariable2, f2);
    }

    private void d() {
        System.out.println("Display Rows (" + this.d + "x" + this.f1943c + ")\n");
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    void a(ArrayRow arrayRow, int i, int i2) {
        arrayRow.b(createErrorVariable(i2, null), i);
    }

    void a(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            Metrics metrics2 = sMetrics;
            metrics2.maxVariables = Math.max(metrics2.maxVariables, this.f1943c);
            Metrics metrics3 = sMetrics;
            metrics3.maxRows = Math.max(metrics3.maxRows, this.d);
        }
        b(row);
        a(row, false);
        c();
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i) {
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
        ArrayRow createRow = createRow();
        double d = f2;
        double sin = Math.sin(d);
        double d2 = i;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (sin * d2));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos(d) * d2));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        ArrayRow createRow = createRow();
        createRow.a(solverVariable, solverVariable2, i, f2, solverVariable3, solverVariable4, i2);
        if (i3 != 8) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0135 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addConstraint(androidx.constraintlayout.core.ArrayRow r7) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.addConstraint(androidx.constraintlayout.core.ArrayRow):void");
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        if (USE_BASIC_SYNONYMS && i2 == 8 && solverVariable2.isFinalValue && solverVariable.f1948a == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i);
            return null;
        }
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        if (i2 != 8) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        if (!USE_BASIC_SYNONYMS || solverVariable.f1948a != -1) {
            int i2 = solverVariable.f1948a;
            if (solverVariable.f1948a == -1) {
                ArrayRow createRow = createRow();
                createRow.a(solverVariable, i);
                addConstraint(createRow);
                return;
            }
            ArrayRow arrayRow = this.b[i2];
            if (arrayRow.e) {
                arrayRow.b = i;
                return;
            } else if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.e = true;
                arrayRow.b = i;
                return;
            } else {
                ArrayRow createRow2 = createRow();
                createRow2.createRowEquals(solverVariable, i);
                addConstraint(createRow2);
                return;
            }
        }
        float f2 = i;
        solverVariable.setFinalValue(this, f2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.f1942a + 1) {
                return;
            }
            SolverVariable solverVariable2 = this.e.d[i4];
            if (solverVariable2 != null && solverVariable2.g && solverVariable2.h == solverVariable.id) {
                solverVariable2.setFinalValue(this, solverVariable2.i + f2);
            }
            i3 = i4 + 1;
        }
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            a(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i2);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i2 != 8) {
            a(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i2);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i != 8) {
            createRow.addError(this, i);
        }
        addConstraint(createRow);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        if (solverVariable.f1948a != -1 || i != 0) {
            addEquality(solverVariable, solverVariable2, i, 8);
            return;
        }
        SolverVariable solverVariable3 = solverVariable2;
        if (solverVariable2.g) {
            float f2 = solverVariable2.i;
            solverVariable3 = this.e.d[solverVariable2.h];
        }
        if (!solverVariable.g) {
            solverVariable.setSynonym(this, solverVariable3, 0.0f);
            return;
        }
        float f3 = solverVariable.i;
        SolverVariable solverVariable4 = this.e.d[solverVariable.h];
    }

    public SolverVariable createErrorVariable(int i, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.f1943c + 1 >= this.j) {
            a();
        }
        SolverVariable a2 = a(SolverVariable.Type.ERROR, str);
        int i2 = this.f1942a + 1;
        this.f1942a = i2;
        this.f1943c++;
        a2.id = i2;
        a2.strength = i;
        this.e.d[this.f1942a] = a2;
        this.h.addError(a2);
        return a2;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.f1943c + 1 >= this.j) {
            a();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        int i = this.f1942a + 1;
        this.f1942a = i;
        this.f1943c++;
        a2.id = i;
        this.e.d[this.f1942a] = a2;
        return a2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0062, code lost:
        if (r4.e.d[r5.id] == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.constraintlayout.core.SolverVariable createObjectVariable(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 0
            r7 = r0
            r0 = r5
            if (r0 != 0) goto L8
            r0 = 0
            return r0
        L8:
            r0 = r4
            int r0 = r0.f1943c
            r1 = 1
            int r0 = r0 + r1
            r1 = r4
            int r1 = r1.j
            if (r0 < r1) goto L19
            r0 = r4
            r0.a()
        L19:
            r0 = r5
            boolean r0 = r0 instanceof androidx.constraintlayout.core.widgets.ConstraintAnchor
            if (r0 == 0) goto La2
            r0 = r5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0
            r8 = r0
            r0 = r8
            androidx.constraintlayout.core.SolverVariable r0 = r0.getSolverVariable()
            r7 = r0
            r0 = r7
            r5 = r0
            r0 = r7
            if (r0 != 0) goto L41
            r0 = r8
            r1 = r4
            androidx.constraintlayout.core.Cache r1 = r1.e
            r0.resetSolverVariable(r1)
            r0 = r8
            androidx.constraintlayout.core.SolverVariable r0 = r0.getSolverVariable()
            r5 = r0
        L41:
            r0 = r5
            int r0 = r0.id
            r1 = -1
            if (r0 == r1) goto L65
            r0 = r5
            int r0 = r0.id
            r1 = r4
            int r1 = r1.f1942a
            if (r0 > r1) goto L65
            r0 = r5
            r7 = r0
            r0 = r4
            androidx.constraintlayout.core.Cache r0 = r0.e
            androidx.constraintlayout.core.SolverVariable[] r0 = r0.d
            r1 = r5
            int r1 = r1.id
            r0 = r0[r1]
            if (r0 != 0) goto La2
        L65:
            r0 = r5
            int r0 = r0.id
            r1 = -1
            if (r0 == r1) goto L71
            r0 = r5
            r0.reset()
        L71:
            r0 = r4
            int r0 = r0.f1942a
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            r0 = r4
            r1 = r6
            r0.f1942a = r1
            r0 = r4
            r1 = r4
            int r1 = r1.f1943c
            r2 = 1
            int r1 = r1 + r2
            r0.f1943c = r1
            r0 = r5
            r1 = r6
            r0.id = r1
            r0 = r5
            androidx.constraintlayout.core.SolverVariable$Type r1 = androidx.constraintlayout.core.SolverVariable.Type.UNRESTRICTED
            r0.d = r1
            r0 = r4
            androidx.constraintlayout.core.Cache r0 = r0.e
            androidx.constraintlayout.core.SolverVariable[] r0 = r0.d
            r1 = r4
            int r1 = r1.f1942a
            r2 = r5
            r0[r1] = r2
            r0 = r5
            r7 = r0
        La2:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.createObjectVariable(java.lang.Object):androidx.constraintlayout.core.SolverVariable");
    }

    public ArrayRow createRow() {
        ValuesRow acquire;
        if (OPTIMIZED_ENGINE) {
            acquire = this.e.f1940a.acquire();
            if (acquire == null) {
                acquire = new ValuesRow(this.e);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        } else {
            acquire = this.e.b.acquire();
            if (acquire == null) {
                acquire = new ArrayRow(this.e);
                ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        }
        SolverVariable.a();
        return acquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.f1943c + 1 >= this.j) {
            a();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        int i = this.f1942a + 1;
        this.f1942a = i;
        this.f1943c++;
        a2.id = i;
        this.e.d[this.f1942a] = a2;
        return a2;
    }

    public void displayReadableRows() {
        d();
        String str = " num vars " + this.f1942a + "\n";
        int i = 0;
        while (i < this.f1942a + 1) {
            SolverVariable solverVariable = this.e.d[i];
            String str2 = str;
            if (solverVariable != null) {
                str2 = str;
                if (solverVariable.isFinalValue) {
                    str2 = str + " $[" + i + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
                }
            }
            i++;
            str = str2;
        }
        String str3 = str + "\n";
        int i2 = 0;
        while (i2 < this.f1942a + 1) {
            SolverVariable solverVariable2 = this.e.d[i2];
            String str4 = str3;
            if (solverVariable2 != null) {
                str4 = str3;
                if (solverVariable2.g) {
                    str4 = str3 + " ~[" + i2 + "] => " + solverVariable2 + " = " + this.e.d[solverVariable2.h] + " + " + solverVariable2.i + "\n";
                }
            }
            i2++;
            str3 = str4;
        }
        String str5 = str3 + "\n\n #  ";
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.d) {
                break;
            }
            str5 = (str5 + this.b[i4].b()) + "\n #  ";
            i3 = i4 + 1;
        }
        String str6 = str5;
        if (this.h != null) {
            str6 = str5 + "Goal: " + this.h + "\n";
        }
        System.out.println(str6);
    }

    public void displayVariablesReadableRows() {
        d();
        String str = "";
        int i = 0;
        while (i < this.d) {
            String str2 = str;
            if (this.b[i].f1938a.d == SolverVariable.Type.UNRESTRICTED) {
                str2 = (str + this.b[i].b()) + "\n";
            }
            i++;
            str = str2;
        }
        System.out.println(str + this.h + "\n");
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.e;
    }

    public int getMemoryUsed() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= this.d) {
                return i3;
            }
            ArrayRow[] arrayRowArr = this.b;
            int i4 = i3;
            if (arrayRowArr[i] != null) {
                i4 = i3 + arrayRowArr[i].c();
            }
            i++;
            i2 = i4;
        }
    }

    public int getNumEquations() {
        return this.d;
    }

    public int getNumVariables() {
        return this.f1942a;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public void minimize() throws Exception {
        boolean z;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.h.isEmpty()) {
            c();
        } else if (!this.graphOptimizer && !this.newgraphOptimizer) {
            a(this.h);
        } else {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.graphOptimizer++;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.d) {
                    z = true;
                    break;
                } else if (!this.b[i2].e) {
                    z = false;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (!z) {
                a(this.h);
                return;
            }
            Metrics metrics3 = sMetrics;
            if (metrics3 != null) {
                metrics3.fullySolved++;
            }
            c();
        }
    }

    public void removeRow(ArrayRow arrayRow) {
        int i;
        if (!arrayRow.e || arrayRow.f1938a == null) {
            return;
        }
        if (arrayRow.f1938a.f1948a != -1) {
            int i2 = arrayRow.f1938a.f1948a;
            while (true) {
                int i3 = i2;
                i = this.d;
                if (i3 >= i - 1) {
                    break;
                }
                int i4 = i3 + 1;
                SolverVariable solverVariable = this.b[i4].f1938a;
                if (solverVariable.f1948a == i4) {
                    solverVariable.f1948a = i3;
                }
                ArrayRow[] arrayRowArr = this.b;
                arrayRowArr[i3] = arrayRowArr[i4];
                i2 = i4;
            }
            this.d = i - 1;
        }
        if (!arrayRow.f1938a.isFinalValue) {
            arrayRow.f1938a.setFinalValue(this, arrayRow.b);
        }
        if (OPTIMIZED_ENGINE) {
            this.e.f1940a.release(arrayRow);
        } else {
            this.e.b.release(arrayRow);
        }
    }

    public void reset() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.d.length) {
                break;
            }
            SolverVariable solverVariable = this.e.d[i2];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i = i2 + 1;
        }
        this.e.f1941c.releaseAll(this.m, this.n);
        this.n = 0;
        Arrays.fill(this.e.d, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.g;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f1942a = 0;
        this.h.clear();
        this.f1943c = 1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.d) {
                break;
            }
            ArrayRow[] arrayRowArr = this.b;
            if (arrayRowArr[i4] != null) {
                arrayRowArr[i4].f1939c = false;
            }
            i3 = i4 + 1;
        }
        b();
        this.d = 0;
        if (OPTIMIZED_ENGINE) {
            this.o = new ValuesRow(this.e);
        } else {
            this.o = new ArrayRow(this.e);
        }
    }
}
