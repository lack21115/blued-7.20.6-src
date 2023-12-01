package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.alipay.sdk.util.i;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/Barrier.class */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private int O = 0;
    private boolean P = true;
    private int Q = 0;

    /* renamed from: a  reason: collision with root package name */
    boolean f2112a = false;

    public Barrier() {
    }

    public Barrier(String str) {
        setDebugName(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mWidgetsCount) {
                return;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            if (this.P || constraintWidget.allowedInBarrier()) {
                int i3 = this.O;
                if (i3 == 0 || i3 == 1) {
                    constraintWidget.a(0, true);
                } else if (i3 == 2 || i3 == 3) {
                    constraintWidget.a(1, true);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        int i;
        int i2;
        this.mListAnchors[0] = this.mLeft;
        this.mListAnchors[2] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        this.mListAnchors[3] = this.mBottom;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mListAnchors.length) {
                break;
            }
            this.mListAnchors[i4].b = linearSystem.createObjectVariable(this.mListAnchors[i4]);
            i3 = i4 + 1;
        }
        int i5 = this.O;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.mListAnchors[this.O];
        if (!this.f2112a) {
            allSolved();
        }
        if (this.f2112a) {
            this.f2112a = false;
            int i6 = this.O;
            if (i6 == 0 || i6 == 1) {
                linearSystem.addEquality(this.mLeft.b, this.k);
                linearSystem.addEquality(this.mRight.b, this.k);
                return;
            } else if (i6 == 2 || i6 == 3) {
                linearSystem.addEquality(this.mTop.b, this.l);
                linearSystem.addEquality(this.mBottom.b, this.l);
                return;
            } else {
                return;
            }
        }
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= this.mWidgetsCount) {
                z2 = false;
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i8];
            if ((this.P || constraintWidget.allowedInBarrier()) && ((((i = this.O) == 0 || i == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i2 = this.O) == 2 || i2 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                break;
            }
            i7 = i8 + 1;
        }
        z2 = true;
        boolean z3 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
        boolean z4 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
        boolean z5 = !z2 && ((this.O == 0 && z3) || ((this.O == 2 && z4) || ((this.O == 1 && z3) || (this.O == 3 && z4))));
        int i9 = 5;
        if (!z5) {
            i9 = 4;
        }
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= this.mWidgetsCount) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mWidgets[i11];
            if (this.P || constraintWidget2.allowedInBarrier()) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.O]);
                constraintWidget2.mListAnchors[this.O].b = createObjectVariable;
                int i12 = (constraintWidget2.mListAnchors[this.O].mTarget == null || constraintWidget2.mListAnchors[this.O].mTarget.mOwner != this) ? 0 : constraintWidget2.mListAnchors[this.O].mMargin + 0;
                int i13 = this.O;
                if (i13 == 0 || i13 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor.b, createObjectVariable, this.Q - i12, z2);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor.b, createObjectVariable, this.Q + i12, z2);
                }
                linearSystem.addEquality(constraintAnchor.b, createObjectVariable, this.Q + i12, i9);
            }
            i10 = i11 + 1;
        }
        int i14 = this.O;
        if (i14 == 0) {
            linearSystem.addEquality(this.mRight.b, this.mLeft.b, 0, 8);
            linearSystem.addEquality(this.mLeft.b, this.mParent.mRight.b, 0, 4);
            linearSystem.addEquality(this.mLeft.b, this.mParent.mLeft.b, 0, 0);
        } else if (i14 == 1) {
            linearSystem.addEquality(this.mLeft.b, this.mRight.b, 0, 8);
            linearSystem.addEquality(this.mLeft.b, this.mParent.mLeft.b, 0, 4);
            linearSystem.addEquality(this.mLeft.b, this.mParent.mRight.b, 0, 0);
        } else if (i14 == 2) {
            linearSystem.addEquality(this.mBottom.b, this.mTop.b, 0, 8);
            linearSystem.addEquality(this.mTop.b, this.mParent.mBottom.b, 0, 4);
            linearSystem.addEquality(this.mTop.b, this.mParent.mTop.b, 0, 0);
        } else if (i14 == 3) {
            linearSystem.addEquality(this.mTop.b, this.mBottom.b, 0, 8);
            linearSystem.addEquality(this.mTop.b, this.mParent.mTop.b, 0, 4);
            linearSystem.addEquality(this.mTop.b, this.mParent.mBottom.b, 0, 0);
        }
    }

    public boolean allSolved() {
        boolean z;
        boolean z2;
        int i = 0;
        boolean z3 = true;
        while (true) {
            z = z3;
            if (i >= this.mWidgetsCount) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (this.P || constraintWidget.allowedInBarrier()) {
                int i2 = this.O;
                if ((i2 != 0 && i2 != 1) || constraintWidget.isResolvedHorizontally()) {
                    int i3 = this.O;
                    if (i3 != 2) {
                        z2 = z;
                        if (i3 != 3) {
                        }
                    }
                    z2 = z;
                    if (constraintWidget.isResolvedVertically()) {
                    }
                }
                z2 = false;
            } else {
                z2 = z;
            }
            i++;
            z3 = z2;
        }
        if (!z || this.mWidgetsCount <= 0) {
            return false;
        }
        int i4 = 0;
        boolean z4 = false;
        for (int i5 = 0; i5 < this.mWidgetsCount; i5++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i5];
            if (this.P || constraintWidget2.allowedInBarrier()) {
                int i6 = i4;
                boolean z5 = z4;
                if (!z4) {
                    int i7 = this.O;
                    if (i7 == 0) {
                        i4 = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i7 == 1) {
                        i4 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i7 == 2) {
                        i4 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i7 == 3) {
                        i4 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z5 = true;
                    i6 = i4;
                }
                int i8 = this.O;
                if (i8 == 0) {
                    i4 = Math.min(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                    z4 = z5;
                } else if (i8 == 1) {
                    i4 = Math.max(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                    z4 = z5;
                } else if (i8 == 2) {
                    i4 = Math.min(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                    z4 = z5;
                } else {
                    i4 = i6;
                    z4 = z5;
                    if (i8 == 3) {
                        i4 = Math.max(i6, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                        z4 = z5;
                    }
                }
            }
        }
        int i9 = i4 + this.Q;
        int i10 = this.O;
        if (i10 == 0 || i10 == 1) {
            setFinalHorizontal(i9, i9);
        } else {
            setFinalVertical(i9, i9);
        }
        this.f2112a = true;
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.P;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.O = barrier.O;
        this.P = barrier.P;
        this.Q = barrier.Q;
    }

    public boolean getAllowsGoneWidget() {
        return this.P;
    }

    public int getBarrierType() {
        return this.O;
    }

    public int getMargin() {
        return this.Q;
    }

    public int getOrientation() {
        int i = this.O;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.f2112a;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.f2112a;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.P = z;
    }

    public void setBarrierType(int i) {
        this.O = i;
    }

    public void setMargin(int i) {
        this.Q = i;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mWidgetsCount) {
                return str + i.d;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            String str2 = str;
            if (i2 > 0) {
                str2 = str + ", ";
            }
            str = str2 + constraintWidget.getDebugName();
            i = i2 + 1;
        }
    }
}
