package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun.class */
public class VerticalWidgetRun extends WidgetRun {

    /* renamed from: a  reason: collision with root package name */
    DimensionDependency f2096a;
    public DependencyNode baseline;

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/VerticalWidgetRun$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2097a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f2097a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2097a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2097a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.baseline = new DependencyNode(this);
        this.f2096a = null;
        this.start.b = DependencyNode.Type.TOP;
        this.end.b = DependencyNode.Type.BOTTOM;
        this.baseline.b = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean a() {
        return this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.b.mMatchConstraintDefaultHeight == 0;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved) {
            this.b.setY(this.start.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void b() {
        this.f2102c = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.e.clear();
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void c() {
        this.f = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.e.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        if (this.b.measured) {
            this.e.resolve(this.b.getHeight());
        }
        if (!this.e.resolved) {
            this.d = this.b.getVerticalDimensionBehaviour();
            if (this.b.hasBaseline()) {
                this.f2096a = new BaselineDimensionDependency(this);
            }
            if (this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.b.getParent()) != null && parent2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int height = parent2.getHeight();
                    int margin = this.b.mTop.getMargin();
                    int margin2 = this.b.mBottom.getMargin();
                    a(this.start, parent2.verticalRun.start, this.b.mTop.getMargin());
                    a(this.end, parent2.verticalRun.end, -this.b.mBottom.getMargin());
                    this.e.resolve((height - margin) - margin2);
                    return;
                } else if (this.d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.e.resolve(this.b.getHeight());
                }
            }
        } else if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.b.getParent()) != null && parent.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
            a(this.start, parent.verticalRun.start, this.b.mTop.getMargin());
            a(this.end, parent.verticalRun.end, -this.b.mBottom.getMargin());
            return;
        }
        if (this.e.resolved && this.b.measured) {
            if (this.b.mListAnchors[2].mTarget != null && this.b.mListAnchors[3].mTarget != null) {
                if (this.b.isInVerticalChain()) {
                    this.start.f2088c = this.b.mListAnchors[2].getMargin();
                    this.end.f2088c = -this.b.mListAnchors[3].getMargin();
                } else {
                    DependencyNode a2 = a(this.b.mListAnchors[2]);
                    if (a2 != null) {
                        a(this.start, a2, this.b.mListAnchors[2].getMargin());
                    }
                    DependencyNode a3 = a(this.b.mListAnchors[3]);
                    if (a3 != null) {
                        a(this.end, a3, -this.b.mListAnchors[3].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                }
                if (this.b.hasBaseline()) {
                    a(this.baseline, this.start, this.b.getBaselineDistance());
                    return;
                }
                return;
            } else if (this.b.mListAnchors[2].mTarget != null) {
                DependencyNode a4 = a(this.b.mListAnchors[2]);
                if (a4 != null) {
                    a(this.start, a4, this.b.mListAnchors[2].getMargin());
                    a(this.end, this.start, this.e.value);
                    if (this.b.hasBaseline()) {
                        a(this.baseline, this.start, this.b.getBaselineDistance());
                        return;
                    }
                    return;
                }
                return;
            } else if (this.b.mListAnchors[3].mTarget != null) {
                DependencyNode a5 = a(this.b.mListAnchors[3]);
                if (a5 != null) {
                    a(this.end, a5, -this.b.mListAnchors[3].getMargin());
                    a(this.start, this.end, -this.e.value);
                }
                if (this.b.hasBaseline()) {
                    a(this.baseline, this.start, this.b.getBaselineDistance());
                    return;
                }
                return;
            } else if (this.b.mListAnchors[4].mTarget != null) {
                DependencyNode a6 = a(this.b.mListAnchors[4]);
                if (a6 != null) {
                    a(this.baseline, a6, 0);
                    a(this.start, this.baseline, -this.b.getBaselineDistance());
                    a(this.end, this.start, this.e.value);
                    return;
                }
                return;
            } else if ((this.b instanceof Helper) || this.b.getParent() == null || this.b.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) {
                return;
            } else {
                a(this.start, this.b.getParent().verticalRun.start, this.b.getY());
                a(this.end, this.start, this.e.value);
                if (this.b.hasBaseline()) {
                    a(this.baseline, this.start, this.b.getBaselineDistance());
                    return;
                }
                return;
            }
        }
        if (this.e.resolved || this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            this.e.addDependency(this);
        } else {
            int i = this.b.mMatchConstraintDefaultHeight;
            if (i == 2) {
                ConstraintWidget parent3 = this.b.getParent();
                if (parent3 != null) {
                    DimensionDependency dimensionDependency = parent3.verticalRun.e;
                    this.e.g.add(dimensionDependency);
                    dimensionDependency.f.add(this.e);
                    this.e.delegateToWidgetRun = true;
                    this.e.f.add(this.start);
                    this.e.f.add(this.end);
                }
            } else if (i == 3 && !this.b.isInVerticalChain() && this.b.mMatchConstraintDefaultWidth != 3) {
                DimensionDependency dimensionDependency2 = this.b.horizontalRun.e;
                this.e.g.add(dimensionDependency2);
                dimensionDependency2.f.add(this.e);
                this.e.delegateToWidgetRun = true;
                this.e.f.add(this.start);
                this.e.f.add(this.end);
            }
        }
        if (this.b.mListAnchors[2].mTarget != null && this.b.mListAnchors[3].mTarget != null) {
            if (this.b.isInVerticalChain()) {
                this.start.f2088c = this.b.mListAnchors[2].getMargin();
                this.end.f2088c = -this.b.mListAnchors[3].getMargin();
            } else {
                DependencyNode a7 = a(this.b.mListAnchors[2]);
                DependencyNode a8 = a(this.b.mListAnchors[3]);
                if (a7 != null) {
                    a7.addDependency(this);
                }
                if (a8 != null) {
                    a8.addDependency(this);
                }
                this.g = WidgetRun.RunType.CENTER;
            }
            if (this.b.hasBaseline()) {
                a(this.baseline, this.start, 1, this.f2096a);
            }
        } else if (this.b.mListAnchors[2].mTarget != null) {
            DependencyNode a9 = a(this.b.mListAnchors[2]);
            if (a9 != null) {
                a(this.start, a9, this.b.mListAnchors[2].getMargin());
                a(this.end, this.start, 1, this.e);
                if (this.b.hasBaseline()) {
                    a(this.baseline, this.start, 1, this.f2096a);
                }
                if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.b.getDimensionRatio() > 0.0f && this.b.horizontalRun.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.b.horizontalRun.e.f.add(this.e);
                    this.e.g.add(this.b.horizontalRun.e);
                    this.e.updateDelegate = this;
                }
            }
        } else if (this.b.mListAnchors[3].mTarget != null) {
            DependencyNode a10 = a(this.b.mListAnchors[3]);
            if (a10 != null) {
                a(this.end, a10, -this.b.mListAnchors[3].getMargin());
                a(this.start, this.end, -1, this.e);
                if (this.b.hasBaseline()) {
                    a(this.baseline, this.start, 1, this.f2096a);
                }
            }
        } else if (this.b.mListAnchors[4].mTarget != null) {
            DependencyNode a11 = a(this.b.mListAnchors[4]);
            if (a11 != null) {
                a(this.baseline, a11, 0);
                a(this.start, this.baseline, -1, this.f2096a);
                a(this.end, this.start, 1, this.e);
            }
        } else if (!(this.b instanceof Helper) && this.b.getParent() != null) {
            a(this.start, this.b.getParent().verticalRun.start, this.b.getY());
            a(this.end, this.start, 1, this.e);
            if (this.b.hasBaseline()) {
                a(this.baseline, this.start, 1, this.f2096a);
            }
            if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.b.getDimensionRatio() > 0.0f && this.b.horizontalRun.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.b.horizontalRun.e.f.add(this.e);
                this.e.g.add(this.b.horizontalRun.e);
                this.e.updateDelegate = this;
            }
        }
        if (this.e.g.size() == 0) {
            this.e.readyToSolve = true;
        }
    }

    public String toString() {
        return "VerticalRun " + this.b.getDebugName();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        float f;
        float dimensionRatio;
        float f2;
        int i;
        int i2 = AnonymousClass1.f2097a[this.g.ordinal()];
        if (i2 == 1) {
            a(dependency);
        } else if (i2 == 2) {
            b(dependency);
        } else if (i2 == 3) {
            a(dependency, this.b.mTop, this.b.mBottom, 1);
            return;
        }
        if (this.e.readyToSolve && !this.e.resolved && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i3 = this.b.mMatchConstraintDefaultHeight;
            if (i3 == 2) {
                ConstraintWidget parent = this.b.getParent();
                if (parent != null && parent.verticalRun.e.resolved) {
                    this.e.resolve((int) ((parent.verticalRun.e.value * this.b.mMatchConstraintPercentHeight) + 0.5f));
                }
            } else if (i3 == 3 && this.b.horizontalRun.e.resolved) {
                int dimensionRatioSide = this.b.getDimensionRatioSide();
                if (dimensionRatioSide == -1) {
                    f = this.b.horizontalRun.e.value;
                    dimensionRatio = this.b.getDimensionRatio();
                } else if (dimensionRatioSide == 0) {
                    f2 = this.b.horizontalRun.e.value * this.b.getDimensionRatio();
                    i = (int) (f2 + 0.5f);
                    this.e.resolve(i);
                } else if (dimensionRatioSide != 1) {
                    i = 0;
                    this.e.resolve(i);
                } else {
                    f = this.b.horizontalRun.e.value;
                    dimensionRatio = this.b.getDimensionRatio();
                }
                f2 = f / dimensionRatio;
                i = (int) (f2 + 0.5f);
                this.e.resolve(i);
            }
        }
        if (this.start.readyToSolve && this.end.readyToSolve) {
            if (this.start.resolved && this.end.resolved && this.e.resolved) {
                return;
            }
            if (!this.e.resolved && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.b.mMatchConstraintDefaultWidth == 0 && !this.b.isInVerticalChain()) {
                DependencyNode dependencyNode = this.start.g.get(0);
                DependencyNode dependencyNode2 = this.end.g.get(0);
                int i4 = dependencyNode.value + this.start.f2088c;
                int i5 = dependencyNode2.value + this.end.f2088c;
                this.start.resolve(i4);
                this.end.resolve(i5);
                this.e.resolve(i5 - i4);
                return;
            }
            if (!this.e.resolved && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.g.size() > 0 && this.end.g.size() > 0) {
                int i6 = (this.end.g.get(0).value + this.end.f2088c) - (this.start.g.get(0).value + this.start.f2088c);
                if (i6 < this.e.wrapValue) {
                    this.e.resolve(i6);
                } else {
                    this.e.resolve(this.e.wrapValue);
                }
            }
            if (this.e.resolved && this.start.g.size() > 0 && this.end.g.size() > 0) {
                DependencyNode dependencyNode3 = this.start.g.get(0);
                DependencyNode dependencyNode4 = this.end.g.get(0);
                int i7 = dependencyNode3.value + this.start.f2088c;
                int i8 = dependencyNode4.value + this.end.f2088c;
                float verticalBiasPercent = this.b.getVerticalBiasPercent();
                if (dependencyNode3 == dependencyNode4) {
                    i7 = dependencyNode3.value;
                    i8 = dependencyNode4.value;
                    verticalBiasPercent = 0.5f;
                }
                this.start.resolve((int) (i7 + 0.5f + (((i8 - i7) - this.e.value) * verticalBiasPercent)));
                this.end.resolve(this.start.value + this.e.value);
            }
        }
    }
}
