package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/BasicMeasure.class */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<ConstraintWidget> f2082a = new ArrayList<>();
    private Measure b = new Measure();

    /* renamed from: c  reason: collision with root package name */
    private ConstraintWidgetContainer f2083c;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measure.class */
    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/BasicMeasure$Measurer.class */
    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f2083c = constraintWidgetContainer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x013d, code lost:
        if (r0 == androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r7) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    private void a(ConstraintWidgetContainer constraintWidgetContainer, String str, int i, int i2, int i3) {
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i2);
        constraintWidgetContainer.setHeight(i3);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        this.f2083c.setPass(i);
        this.f2083c.layout();
    }

    private boolean a(Measurer measurer, ConstraintWidget constraintWidget, int i) {
        this.b.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.b.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.b.horizontalDimension = constraintWidget.getWidth();
        this.b.verticalDimension = constraintWidget.getHeight();
        this.b.measuredNeedsSolverPass = false;
        this.b.measureStrategy = i;
        boolean z = this.b.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = this.b.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        if (z3 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.b.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.b.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, this.b);
        constraintWidget.setWidth(this.b.measuredWidth);
        constraintWidget.setHeight(this.b.measuredHeight);
        constraintWidget.setHasBaseline(this.b.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.b.measuredBaseline);
        this.b.measureStrategy = Measure.SELF_DIMENSIONS;
        return this.b.measuredNeedsSolverPass;
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        boolean z;
        int i10;
        boolean z2;
        boolean a2;
        int i11;
        boolean needSolverPass;
        boolean directMeasureSetup;
        int i12;
        int i13;
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        int size = constraintWidgetContainer.mChildren.size();
        int width = constraintWidgetContainer.getWidth();
        int height = constraintWidgetContainer.getHeight();
        boolean enabled = Optimizer.enabled(i, 128);
        boolean z3 = enabled || Optimizer.enabled(i, 64);
        boolean z4 = z3;
        if (z3) {
            while (true) {
                int i14 = i13;
                z4 = z3;
                if (i14 >= size) {
                    break;
                }
                ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i14);
                boolean z5 = (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.getDimensionRatio() > 0.0f;
                i13 = ((constraintWidget.isInHorizontalChain() && z5) || (constraintWidget.isInVerticalChain() && z5) || (constraintWidget instanceof VirtualLayout) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain()) ? 0 : i14 + 1;
            }
            z4 = false;
        }
        if (z4 && LinearSystem.sMetrics != null) {
            LinearSystem.sMetrics.measures++;
        }
        boolean z6 = z4 & ((i4 == 1073741824 && i6 == 1073741824) || enabled);
        if (z6) {
            int min = Math.min(constraintWidgetContainer.getMaxWidth(), i5);
            int min2 = Math.min(constraintWidgetContainer.getMaxHeight(), i7);
            if (i4 == 1073741824 && constraintWidgetContainer.getWidth() != min) {
                constraintWidgetContainer.setWidth(min);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i6 == 1073741824 && constraintWidgetContainer.getHeight() != min2) {
                constraintWidgetContainer.setHeight(min2);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i4 == 1073741824 && i6 == 1073741824) {
                directMeasureSetup = constraintWidgetContainer.directMeasure(enabled);
                i12 = 2;
            } else {
                directMeasureSetup = constraintWidgetContainer.directMeasureSetup(enabled);
                if (i4 == 1073741824) {
                    directMeasureSetup &= constraintWidgetContainer.directMeasureWithOrientation(enabled, 0);
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                if (i6 == 1073741824) {
                    directMeasureSetup = constraintWidgetContainer.directMeasureWithOrientation(enabled, 1) & directMeasureSetup;
                    i12++;
                }
            }
            z = directMeasureSetup;
            i10 = i12;
            if (directMeasureSetup) {
                constraintWidgetContainer.updateFromRuns(i4 == 1073741824, i6 == 1073741824);
                z = directMeasureSetup;
                i10 = i12;
            }
        } else {
            z = false;
            i10 = 0;
        }
        if (z && i10 == 2) {
            return 0L;
        }
        int optimizationLevel = constraintWidgetContainer.getOptimizationLevel();
        if (size > 0) {
            a(constraintWidgetContainer);
        }
        updateHierarchy(constraintWidgetContainer);
        int size2 = this.f2082a.size();
        if (size > 0) {
            a(constraintWidgetContainer, "First pass", 0, width, height);
        }
        if (size2 > 0) {
            boolean z7 = constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z8 = constraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int max = Math.max(constraintWidgetContainer.getWidth(), this.f2083c.getMinWidth());
            int max2 = Math.max(constraintWidgetContainer.getHeight(), this.f2083c.getMinHeight());
            int i15 = 0;
            boolean z9 = false;
            while (true) {
                z2 = z9;
                if (i15 >= size2) {
                    break;
                }
                ConstraintWidget constraintWidget2 = this.f2082a.get(i15);
                if (constraintWidget2 instanceof VirtualLayout) {
                    int width2 = constraintWidget2.getWidth();
                    int height2 = constraintWidget2.getHeight();
                    boolean a3 = a(measurer, constraintWidget2, Measure.TRY_GIVEN_DIMENSIONS) | z2;
                    if (constraintWidgetContainer.mMetrics != null) {
                        constraintWidgetContainer.mMetrics.measuredMatchWidgets++;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        int i16 = max;
                        if (z7) {
                            i16 = max;
                            if (constraintWidget2.getRight() > max) {
                                i16 = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                        }
                        a3 = true;
                        max = i16;
                    }
                    int i17 = max2;
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        i17 = max2;
                        if (z8) {
                            i17 = max2;
                            if (constraintWidget2.getBottom() > max2) {
                                i17 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                        }
                        a3 = true;
                    }
                    needSolverPass = a3 | ((VirtualLayout) constraintWidget2).needSolverPass();
                    max2 = i17;
                } else {
                    needSolverPass = z2;
                }
                i15++;
                z9 = needSolverPass;
            }
            int i18 = 0;
            boolean z10 = z2;
            while (i18 < 2) {
                int i19 = 0;
                while (i19 < size2) {
                    ConstraintWidget constraintWidget3 = this.f2082a.get(i19);
                    if (((constraintWidget3 instanceof Helper) && !(constraintWidget3 instanceof VirtualLayout)) || (constraintWidget3 instanceof Guideline) || constraintWidget3.getVisibility() == 8 || ((z6 && constraintWidget3.horizontalRun.e.resolved && constraintWidget3.verticalRun.e.resolved) || (constraintWidget3 instanceof VirtualLayout))) {
                        i11 = max;
                        a2 = z10;
                    } else {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        int i20 = Measure.TRY_GIVEN_DIMENSIONS;
                        if (i18 == 1) {
                            i20 = Measure.USE_GIVEN_DIMENSIONS;
                        }
                        a2 = a(measurer, constraintWidget3, i20) | z10;
                        if (constraintWidgetContainer.mMetrics != null) {
                            constraintWidgetContainer.mMetrics.measuredMatchWidgets++;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        int i21 = max;
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            i21 = max;
                            if (z7) {
                                i21 = max;
                                if (constraintWidget3.getRight() > max) {
                                    i21 = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                                }
                            }
                            a2 = true;
                        }
                        int i22 = max2;
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            i22 = max2;
                            if (z8) {
                                i22 = max2;
                                if (constraintWidget3.getBottom() > max2) {
                                    i22 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                                }
                            }
                            a2 = true;
                        }
                        if (!constraintWidget3.hasBaseline() || baselineDistance == constraintWidget3.getBaselineDistance()) {
                            max2 = i22;
                            i11 = i21;
                        } else {
                            a2 = true;
                            i11 = i21;
                            max2 = i22;
                        }
                    }
                    i19++;
                    max = i11;
                    z10 = a2;
                }
                if (!z10) {
                    break;
                }
                i18++;
                a(constraintWidgetContainer, "intermediate pass", i18, width, height);
                z10 = false;
            }
        }
        constraintWidgetContainer.setOptimizationLevel(optimizationLevel);
        return 0L;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f2082a.clear();
        int size = constraintWidgetContainer.mChildren.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                constraintWidgetContainer.invalidateGraph();
                return;
            }
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i2);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.f2082a.add(constraintWidget);
            }
            i = i2 + 1;
        }
    }
}
