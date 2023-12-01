package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/Guideline.class */
public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNOWN = -1;
    public static final int VERTICAL = 1;
    private boolean U;

    /* renamed from: a  reason: collision with root package name */
    protected float f2126a = -1.0f;
    protected int O = -1;
    protected int P = -1;
    protected boolean Q = true;
    private ConstraintAnchor R = this.mTop;
    private int S = 0;
    private int T = 0;

    /* renamed from: androidx.constraintlayout.core.widgets.Guideline$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/Guideline$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2127a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0071 -> B:49:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0075 -> B:45:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0079 -> B:41:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007d -> B:53:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0081 -> B:47:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0085 -> B:43:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0089 -> B:39:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x008d -> B:51:0x0064). Please submit an issue!!! */
        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f2127a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2127a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2127a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2127a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2127a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2127a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2127a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2127a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f2127a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public Guideline() {
        this.g.clear();
        this.g.add(this.R);
        int length = this.mListAnchors.length;
        for (int i = 0; i < length; i++) {
            this.mListAnchors[i] = this.R;
        }
    }

    void a() {
        float x = getX() / getParent().getWidth();
        if (this.S == 0) {
            x = getY() / getParent().getHeight();
        }
        setGuidePercent(x);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) getParent();
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
        boolean z2 = this.mParent != null && this.mParent.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.S == 0) {
            anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
            anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
            z2 = this.mParent != null && this.mParent.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.U && this.R.hasFinalValue()) {
            SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.R);
            linearSystem.addEquality(createObjectVariable, this.R.getFinalValue());
            if (this.O != -1) {
                if (z2) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
                }
            } else if (this.P != -1 && z2) {
                SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(anchor2);
                linearSystem.addGreaterThan(createObjectVariable, linearSystem.createObjectVariable(anchor), 0, 5);
                linearSystem.addGreaterThan(createObjectVariable2, createObjectVariable, 0, 5);
            }
            this.U = false;
        } else if (this.O != -1) {
            SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.R);
            linearSystem.addEquality(createObjectVariable3, linearSystem.createObjectVariable(anchor), this.O, 8);
            if (z2) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable3, 0, 5);
            }
        } else if (this.P == -1) {
            if (this.f2126a != -1.0f) {
                linearSystem.addConstraint(LinearSystem.createRowDimensionPercent(linearSystem, linearSystem.createObjectVariable(this.R), linearSystem.createObjectVariable(anchor2), this.f2126a));
            }
        } else {
            SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.R);
            SolverVariable createObjectVariable5 = linearSystem.createObjectVariable(anchor2);
            linearSystem.addEquality(createObjectVariable4, createObjectVariable5, -this.P, 8);
            if (z2) {
                linearSystem.addGreaterThan(createObjectVariable4, linearSystem.createObjectVariable(anchor), 0, 5);
                linearSystem.addGreaterThan(createObjectVariable5, createObjectVariable4, 0, 5);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Guideline guideline = (Guideline) constraintWidget;
        this.f2126a = guideline.f2126a;
        this.O = guideline.O;
        this.P = guideline.P;
        this.Q = guideline.Q;
        setOrientation(guideline.S);
    }

    public void cyclePosition() {
        if (this.O != -1) {
            a();
        } else if (this.f2126a != -1.0f) {
            f();
        } else if (this.P != -1) {
            e();
        }
    }

    void e() {
        int x = getX();
        if (this.S == 0) {
            x = getY();
        }
        setGuideBegin(x);
    }

    void f() {
        int width = getParent().getWidth() - getX();
        if (this.S == 0) {
            width = getParent().getHeight() - getY();
        }
        setGuideEnd(width);
    }

    public ConstraintAnchor getAnchor() {
        return this.R;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        int i = AnonymousClass1.f2127a[type.ordinal()];
        if (i == 1 || i == 2) {
            if (this.S == 1) {
                return this.R;
            }
            return null;
        } else if ((i == 3 || i == 4) && this.S == 0) {
            return this.R;
        } else {
            return null;
        }
    }

    public int getOrientation() {
        return this.S;
    }

    public int getRelativeBegin() {
        return this.O;
    }

    public int getRelativeBehaviour() {
        if (this.f2126a != -1.0f) {
            return 0;
        }
        if (this.O != -1) {
            return 1;
        }
        return this.P != -1 ? 2 : -1;
    }

    public int getRelativeEnd() {
        return this.P;
    }

    public float getRelativePercent() {
        return this.f2126a;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    public boolean isPercent() {
        return this.f2126a != -1.0f && this.O == -1 && this.P == -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.U;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.U;
    }

    public void setFinalValue(int i) {
        this.R.setFinalValue(i);
        this.U = true;
    }

    public void setGuideBegin(int i) {
        if (i > -1) {
            this.f2126a = -1.0f;
            this.O = i;
            this.P = -1;
        }
    }

    public void setGuideEnd(int i) {
        if (i > -1) {
            this.f2126a = -1.0f;
            this.O = -1;
            this.P = i;
        }
    }

    public void setGuidePercent(float f) {
        if (f > -1.0f) {
            this.f2126a = f;
            this.O = -1;
            this.P = -1;
        }
    }

    public void setGuidePercent(int i) {
        setGuidePercent(i / 100.0f);
    }

    public void setMinimumPosition(int i) {
        this.T = i;
    }

    public void setOrientation(int i) {
        if (this.S == i) {
            return;
        }
        this.S = i;
        this.g.clear();
        if (this.S == 1) {
            this.R = this.mLeft;
        } else {
            this.R = this.mTop;
        }
        this.g.add(this.R);
        int length = this.mListAnchors.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            this.mListAnchors[i3] = this.R;
            i2 = i3 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        if (getParent() == null) {
            return;
        }
        int objectVariableValue = linearSystem.getObjectVariableValue(this.R);
        if (this.S == 1) {
            setX(objectVariableValue);
            setY(0);
            setHeight(getParent().getHeight());
            setWidth(0);
            return;
        }
        setX(0);
        setY(objectVariableValue);
        setWidth(getParent().getWidth());
        setHeight(0);
    }
}
