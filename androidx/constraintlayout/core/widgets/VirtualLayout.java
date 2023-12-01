package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/VirtualLayout.class */
public class VirtualLayout extends HelperWidget {
    private int P = 0;
    private int Q = 0;
    private int R = 0;
    private int S = 0;
    private int T = 0;
    private int U = 0;
    private int V = 0;
    private int W = 0;
    private boolean X = false;
    private int Y = 0;
    private int Z = 0;

    /* renamed from: a  reason: collision with root package name */
    protected BasicMeasure.Measure f2129a = new BasicMeasure.Measure();
    BasicMeasure.Measurer O = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        while (this.O == null && getParent() != null) {
            this.O = ((ConstraintWidgetContainer) getParent()).getMeasurer();
        }
        this.f2129a.horizontalBehavior = dimensionBehaviour;
        this.f2129a.verticalBehavior = dimensionBehaviour2;
        this.f2129a.horizontalDimension = i;
        this.f2129a.verticalDimension = i2;
        this.O.measure(constraintWidget, this.f2129a);
        constraintWidget.setWidth(this.f2129a.measuredWidth);
        constraintWidget.setHeight(this.f2129a.measuredHeight);
        constraintWidget.setHasBaseline(this.f2129a.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.f2129a.measuredBaseline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
        this.X = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        BasicMeasure.Measurer measurer = this.mParent != null ? ((ConstraintWidgetContainer) this.mParent).getMeasurer() : null;
        if (measurer == null) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            boolean z = true;
            if (i2 >= this.mWidgetsCount) {
                return true;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            if (constraintWidget != null && !(constraintWidget instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultHeight == 1) {
                    z = false;
                }
                if (!z) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviour;
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviour2;
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    this.f2129a.horizontalBehavior = dimensionBehaviour3;
                    this.f2129a.verticalBehavior = dimensionBehaviour4;
                    this.f2129a.horizontalDimension = constraintWidget.getWidth();
                    this.f2129a.verticalDimension = constraintWidget.getHeight();
                    measurer.measure(constraintWidget, this.f2129a);
                    constraintWidget.setWidth(this.f2129a.measuredWidth);
                    constraintWidget.setHeight(this.f2129a.measuredHeight);
                    constraintWidget.setBaselineDistance(this.f2129a.measuredBaseline);
                }
            }
            i = i2 + 1;
        }
    }

    public void applyRtl(boolean z) {
        if (this.T > 0 || this.U > 0) {
            if (z) {
                this.V = this.U;
                this.W = this.T;
                return;
            }
            this.V = this.T;
            this.W = this.U;
        }
    }

    public void captureWidgets() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mWidgetsCount) {
                return;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i2];
            if (constraintWidget != null) {
                constraintWidget.setInVirtualLayout(true);
            }
            i = i2 + 1;
        }
    }

    public boolean contains(HashSet<ConstraintWidget> hashSet) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mWidgetsCount) {
                return false;
            }
            if (hashSet.contains(this.mWidgets[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public int getMeasuredHeight() {
        return this.Z;
    }

    public int getMeasuredWidth() {
        return this.Y;
    }

    public int getPaddingBottom() {
        return this.Q;
    }

    public int getPaddingLeft() {
        return this.V;
    }

    public int getPaddingRight() {
        return this.W;
    }

    public int getPaddingTop() {
        return this.P;
    }

    public void measure(int i, int i2, int i3, int i4) {
    }

    public boolean needSolverPass() {
        return this.X;
    }

    public void setMeasure(int i, int i2) {
        this.Y = i;
        this.Z = i2;
    }

    public void setPadding(int i) {
        this.R = i;
        this.P = i;
        this.S = i;
        this.Q = i;
        this.T = i;
        this.U = i;
    }

    public void setPaddingBottom(int i) {
        this.Q = i;
    }

    public void setPaddingEnd(int i) {
        this.U = i;
    }

    public void setPaddingLeft(int i) {
        this.R = i;
        this.V = i;
    }

    public void setPaddingRight(int i) {
        this.S = i;
        this.W = i;
    }

    public void setPaddingStart(int i) {
        this.T = i;
        this.V = i;
        this.W = i;
    }

    public void setPaddingTop(int i) {
        this.P = i;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        captureWidgets();
    }
}
