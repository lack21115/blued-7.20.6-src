package androidx.constraintlayout.core;

import java.util.Arrays;
import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/SolverVariable.class */
public class SolverVariable implements Comparable<SolverVariable> {
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static int k = 1;
    private static int l = 1;
    private static int m = 1;
    private static int n = 1;
    private static int o = 1;

    /* renamed from: a  reason: collision with root package name */
    int f1948a;
    float[] b;

    /* renamed from: c  reason: collision with root package name */
    float[] f1949c;
    public float computedValue;
    Type d;
    ArrayRow[] e;
    int f;
    boolean g;
    int h;
    float i;
    public int id;
    public boolean inGoal;
    public boolean isFinalValue;
    HashSet<ArrayRow> j;
    private String p;
    public int strength;
    public int usageInRowCount;

    /* renamed from: androidx.constraintlayout.core.SolverVariable$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/SolverVariable$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1950a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[Type.values().length];
            f1950a = iArr;
            try {
                iArr[Type.UNRESTRICTED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1950a[Type.CONSTANT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1950a[Type.SLACK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1950a[Type.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1950a[Type.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/SolverVariable$Type.class */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.f1948a = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.b = new float[9];
        this.f1949c = new float[9];
        this.e = new ArrayRow[16];
        this.f = 0;
        this.usageInRowCount = 0;
        this.g = false;
        this.h = -1;
        this.i = 0.0f;
        this.j = null;
        this.d = type;
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.f1948a = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.b = new float[9];
        this.f1949c = new float[9];
        this.e = new ArrayRow[16];
        this.f = 0;
        this.usageInRowCount = 0;
        this.g = false;
        this.h = -1;
        this.i = 0.0f;
        this.j = null;
        this.p = str;
        this.d = type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        l++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i2 = i;
            int i3 = this.f;
            if (i2 >= i3) {
                ArrayRow[] arrayRowArr = this.e;
                if (i3 >= arrayRowArr.length) {
                    this.e = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.e;
                int i4 = this.f;
                arrayRowArr2[i4] = arrayRow;
                this.f = i4 + 1;
                return;
            } else if (this.e[i2] == arrayRow) {
                return;
            } else {
                i = i2 + 1;
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(SolverVariable solverVariable) {
        return this.id - solverVariable.id;
    }

    public String getName() {
        return this.p;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.f;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            if (this.e[i3] == arrayRow) {
                while (i3 < i - 1) {
                    ArrayRow[] arrayRowArr = this.e;
                    int i4 = i3 + 1;
                    arrayRowArr[i3] = arrayRowArr[i4];
                    i3 = i4;
                }
                this.f--;
                return;
            }
            i2 = i3 + 1;
        }
    }

    public void reset() {
        this.p = null;
        this.d = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.f1948a = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.g = false;
        this.h = -1;
        this.i = 0.0f;
        int i = this.f;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.f = 0;
                this.usageInRowCount = 0;
                this.inGoal = false;
                Arrays.fill(this.f1949c, 0.0f);
                return;
            }
            this.e[i3] = null;
            i2 = i3 + 1;
        }
    }

    public void setFinalValue(LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        this.g = false;
        this.h = -1;
        this.i = 0.0f;
        int i = this.f;
        this.f1948a = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.f = 0;
                return;
            } else {
                this.e[i3].updateFromFinalVariable(linearSystem, this, false);
                i2 = i3 + 1;
            }
        }
    }

    public void setName(String str) {
        this.p = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f) {
        this.g = true;
        this.h = solverVariable.id;
        this.i = f;
        int i = this.f;
        this.f1948a = -1;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.f = 0;
                linearSystem.displayReadableRows();
                return;
            }
            this.e[i3].updateFromSynonymVariable(linearSystem, this, false);
            i2 = i3 + 1;
        }
    }

    public void setType(Type type, String str) {
        this.d = type;
    }

    public String toString() {
        if (this.p != null) {
            return "" + this.p;
        }
        return "" + this.id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i = this.f;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                this.f = 0;
                return;
            } else {
                this.e[i3].updateFromRow(linearSystem, arrayRow, false);
                i2 = i3 + 1;
            }
        }
    }
}
