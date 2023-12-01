package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/ConstraintWidgetContainer.class */
public class ConstraintWidgetContainer extends WidgetContainer {
    static int Y;
    protected BasicMeasure.Measurer O;
    protected LinearSystem P;
    int Q;
    int R;
    int S;
    int T;
    ChainHead[] U;
    ChainHead[] V;
    int W;
    HashSet<ConstraintWidget> X;
    private int Z;

    /* renamed from: a  reason: collision with root package name */
    BasicMeasure f2075a;
    private boolean aa;
    private int ab;
    private boolean ac;
    private boolean ad;
    private WeakReference<ConstraintAnchor> ae;
    private WeakReference<ConstraintAnchor> af;
    private WeakReference<ConstraintAnchor> ag;
    private WeakReference<ConstraintAnchor> ah;
    public DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    public int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    public BasicMeasure.Measure mMeasure;
    public Metrics mMetrics;
    public boolean mSkipSolver;
    public int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;

    public ConstraintWidgetContainer() {
        this.f2075a = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.O = null;
        this.aa = false;
        this.P = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.U = new ChainHead[4];
        this.V = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.ab = 257;
        this.mSkipSolver = false;
        this.ac = false;
        this.ad = false;
        this.W = 0;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.ah = null;
        this.X = new HashSet<>();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int i, int i2) {
        super(i, i2);
        this.f2075a = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.O = null;
        this.aa = false;
        this.P = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.U = new ChainHead[4];
        this.V = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.ab = 257;
        this.mSkipSolver = false;
        this.ac = false;
        this.ad = false;
        this.W = 0;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.ah = null;
        this.X = new HashSet<>();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
        this.f2075a = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.O = null;
        this.aa = false;
        this.P = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.U = new ChainHead[4];
        this.V = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.ab = 257;
        this.mSkipSolver = false;
        this.ac = false;
        this.ad = false;
        this.W = 0;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.ah = null;
        this.X = new HashSet<>();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(String str, int i, int i2) {
        super(i, i2);
        this.f2075a = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.O = null;
        this.aa = false;
        this.P = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.U = new ChainHead[4];
        this.V = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.ab = 257;
        this.mSkipSolver = false;
        this.ac = false;
        this.ad = false;
        this.W = 0;
        this.ae = null;
        this.af = null;
        this.ag = null;
        this.ah = null;
        this.X = new HashSet<>();
        this.mMeasure = new BasicMeasure.Measure();
        setDebugName(str);
    }

    private void a() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    private void a(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.P.addGreaterThan(this.P.createObjectVariable(constraintAnchor), solverVariable, 0, 5);
    }

    private void a(ConstraintWidget constraintWidget) {
        int i = this.mHorizontalChainsSize;
        ChainHead[] chainHeadArr = this.V;
        if (i + 1 >= chainHeadArr.length) {
            this.V = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.V[this.mHorizontalChainsSize] = new ChainHead(constraintWidget, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void b(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.P.addGreaterThan(solverVariable, this.P.createObjectVariable(constraintAnchor), 0, 5);
    }

    private void b(ConstraintWidget constraintWidget) {
        int i = this.mVerticalChainsSize;
        ChainHead[] chainHeadArr = this.U;
        if (i + 1 >= chainHeadArr.length) {
            this.U = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.U[this.mVerticalChainsSize] = new ChainHead(constraintWidget, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    public static boolean measure(int i, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, BasicMeasure.Measure measure, int i2) {
        int i3;
        int i4;
        if (measurer == null) {
            return false;
        }
        if (constraintWidget.getVisibility() == 8 || (constraintWidget instanceof Guideline) || (constraintWidget instanceof Barrier)) {
            measure.measuredWidth = 0;
            measure.measuredHeight = 0;
            return false;
        }
        measure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        measure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        measure.horizontalDimension = constraintWidget.getWidth();
        measure.verticalDimension = constraintWidget.getHeight();
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i2;
        boolean z = measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = measure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        boolean z5 = z;
        if (z) {
            z5 = z;
            if (constraintWidget.hasDanglingDimension(0)) {
                z5 = z;
                if (constraintWidget.mMatchConstraintDefaultWidth == 0) {
                    z5 = z;
                    if (!z3) {
                        measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        if (z2 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                        }
                        z5 = false;
                    }
                }
            }
        }
        boolean z6 = z2;
        if (z2) {
            z6 = z2;
            if (constraintWidget.hasDanglingDimension(1)) {
                z6 = z2;
                if (constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    z6 = z2;
                    if (!z4) {
                        measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                        if (z5 && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                        }
                        z6 = false;
                    }
                }
            }
        }
        if (constraintWidget.isResolvedHorizontally()) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            z5 = false;
        }
        if (constraintWidget.isResolvedVertically()) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            z6 = false;
        }
        if (z3) {
            if (constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z6) {
                if (measure.verticalBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    i4 = measure.verticalDimension;
                } else {
                    measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    i4 = measure.measuredHeight;
                }
                measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                measure.horizontalDimension = (int) (constraintWidget.getDimensionRatio() * i4);
            }
        }
        if (z4) {
            if (constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z5) {
                if (measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    i3 = measure.horizontalDimension;
                } else {
                    measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    measurer.measure(constraintWidget, measure);
                    i3 = measure.measuredWidth;
                }
                measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
                if (constraintWidget.getDimensionRatioSide() == -1) {
                    measure.verticalDimension = (int) (i3 / constraintWidget.getDimensionRatio());
                } else {
                    measure.verticalDimension = (int) (constraintWidget.getDimensionRatio() * i3);
                }
            }
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(measure.measuredWidth);
        constraintWidget.setHeight(measure.measuredHeight);
        constraintWidget.setHasBaseline(measure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(measure.measuredBaseline);
        measure.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
        return measure.measuredNeedsSolverPass;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.ae;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.ae.get().getFinalValue()) {
            this.ae = new WeakReference<>(constraintAnchor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            a(constraintWidget);
        } else if (i == 1) {
            b(constraintWidget);
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        boolean optimizeFor = optimizeFor(64);
        addToSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            constraintWidget.a(0, false);
            constraintWidget.a(1, false);
            if (constraintWidget instanceof Barrier) {
                z = true;
            }
        }
        if (z) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget2 = this.mChildren.get(i3);
                if (constraintWidget2 instanceof Barrier) {
                    ((Barrier) constraintWidget2).a();
                }
                i2 = i3 + 1;
            }
        }
        this.X.clear();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= size) {
                break;
            }
            ConstraintWidget constraintWidget3 = this.mChildren.get(i5);
            if (constraintWidget3.d()) {
                if (constraintWidget3 instanceof VirtualLayout) {
                    this.X.add(constraintWidget3);
                } else {
                    constraintWidget3.addToSolver(linearSystem, optimizeFor);
                }
            }
            i4 = i5 + 1;
        }
        while (this.X.size() > 0) {
            int size2 = this.X.size();
            Iterator<ConstraintWidget> it = this.X.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                VirtualLayout virtualLayout = (VirtualLayout) it.next();
                if (virtualLayout.contains(this.X)) {
                    virtualLayout.addToSolver(linearSystem, optimizeFor);
                    this.X.remove(virtualLayout);
                    break;
                }
            }
            if (size2 == this.X.size()) {
                Iterator<ConstraintWidget> it2 = this.X.iterator();
                while (it2.hasNext()) {
                    it2.next().addToSolver(linearSystem, optimizeFor);
                }
                this.X.clear();
            }
        }
        if (!LinearSystem.USE_DEPENDENCY_ORDERING) {
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget4 = this.mChildren.get(i7);
                if (constraintWidget4 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget4.mListDimensionBehaviors[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget4.mListDimensionBehaviors[1];
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget4.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget4.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget4.addToSolver(linearSystem, optimizeFor);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget4.setHorizontalDimensionBehaviour(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                        constraintWidget4.setVerticalDimensionBehaviour(dimensionBehaviour2);
                    }
                } else {
                    Optimizer.a(this, linearSystem, constraintWidget4);
                    if (!constraintWidget4.d()) {
                        constraintWidget4.addToSolver(linearSystem, optimizeFor);
                    }
                }
                i6 = i7 + 1;
            }
        } else {
            HashSet<ConstraintWidget> hashSet = new HashSet<>();
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget5 = this.mChildren.get(i9);
                if (!constraintWidget5.d()) {
                    hashSet.add(constraintWidget5);
                }
                i8 = i9 + 1;
            }
            addChildrenToSolverByDependency(this, linearSystem, hashSet, getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator<ConstraintWidget> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next = it3.next();
                Optimizer.a(this, linearSystem, next);
                next.addToSolver(linearSystem, optimizeFor);
            }
        }
        if (this.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, null, 0);
        }
        if (this.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(this, linearSystem, null, 1);
            return true;
        }
        return true;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.ah;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.ah.get().getFinalValue()) {
            this.ah = new WeakReference<>(constraintAnchor);
        }
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.af;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.af.get().getFinalValue()) {
            this.af = new WeakReference<>(constraintAnchor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.ag;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.getFinalValue() > this.ag.get().getFinalValue()) {
            this.ag = new WeakReference<>(constraintAnchor);
        }
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean z) {
        return this.mDependencyGraph.directMeasure(z);
    }

    public boolean directMeasureSetup(boolean z) {
        return this.mDependencyGraph.directMeasureSetup(z);
    }

    public boolean directMeasureWithOrientation(boolean z, int i) {
        return this.mDependencyGraph.directMeasureWithOrientation(z, i);
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.P.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return arrayList;
            }
            ConstraintWidget constraintWidget = this.mChildren.get(i2);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
            i = i2 + 1;
        }
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.O;
    }

    public int getOptimizationLevel() {
        return this.ab;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void getSceneString(StringBuilder sb) {
        sb.append(this.stringId + ":{\n");
        sb.append("  actualWidth:" + this.h);
        sb.append("\n");
        sb.append("  actualHeight:" + this.i);
        sb.append("\n");
        Iterator<ConstraintWidget> it = getChildren().iterator();
        while (it.hasNext()) {
            it.next().getSceneString(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }

    public LinearSystem getSystem() {
        return this.P;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.mChildren.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return arrayList;
            }
            ConstraintWidget constraintWidget = this.mChildren.get(i2);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
            i = i2 + 1;
        }
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.ad;
    }

    public boolean isRtl() {
        return this.aa;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.ac;
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05f6  */
    @Override // androidx.constraintlayout.core.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layout() {
        /*
            Method dump skipped, instructions count: 1577
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.layout():void");
    }

    public long measure(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.Q = i8;
        this.R = i9;
        return this.f2075a.solverMeasure(this, i, i8, i9, i2, i3, i4, i5, i6, i7);
    }

    public boolean optimizeFor(int i) {
        return (this.ab & i) == i;
    }

    @Override // androidx.constraintlayout.core.widgets.WidgetContainer, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.P.reset();
        this.Q = 0;
        this.S = 0;
        this.R = 0;
        this.T = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.O = measurer;
        this.mDependencyGraph.setMeasurer(measurer);
    }

    public void setOptimizationLevel(int i) {
        this.ab = i;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.Q = i;
        this.R = i2;
        this.S = i3;
        this.T = i4;
    }

    public void setPass(int i) {
        this.Z = i;
    }

    public void setRtl(boolean z) {
        this.aa = z;
    }

    public boolean updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        boolean optimizeFor = optimizeFor(64);
        updateFromSolver(linearSystem, optimizeFor);
        int size = this.mChildren.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i);
            constraintWidget.updateFromSolver(linearSystem, optimizeFor);
            if (constraintWidget.hasDimensionOverride()) {
                z = true;
            }
        }
        return z;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromRuns(boolean z, boolean z2) {
        super.updateFromRuns(z, z2);
        int size = this.mChildren.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.mChildren.get(i2).updateFromRuns(z, z2);
            i = i2 + 1;
        }
    }

    public void updateHierarchy() {
        this.f2075a.updateHierarchy(this);
    }
}
