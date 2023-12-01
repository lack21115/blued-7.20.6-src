package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun.class */
public class HorizontalWidgetRun extends WidgetRun {

    /* renamed from: a  reason: collision with root package name */
    private static int[] f2140a = new int[2];

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/HorizontalWidgetRun$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2141a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f2141a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2141a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2141a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.b = DependencyNode.Type.LEFT;
        this.end.b = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void a(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else if (i5 != 1) {
                return;
            } else {
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean a() {
        return this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.b.mMatchConstraintDefaultWidth == 0;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved) {
            this.b.setX(this.start.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void b() {
        this.f2150c = null;
        this.start.clear();
        this.end.clear();
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
        this.e.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        if (this.b.measured) {
            this.e.resolve(this.b.getWidth());
        }
        if (!this.e.resolved) {
            this.d = this.b.getHorizontalDimensionBehaviour();
            if (this.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.b.getParent()) != null && (parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
                    int width = parent2.getWidth();
                    int margin = this.b.mLeft.getMargin();
                    int margin2 = this.b.mRight.getMargin();
                    a(this.start, parent2.horizontalRun.start, this.b.mLeft.getMargin());
                    a(this.end, parent2.horizontalRun.end, -this.b.mRight.getMargin());
                    this.e.resolve((width - margin) - margin2);
                    return;
                } else if (this.d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.e.resolve(this.b.getWidth());
                }
            }
        } else if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.b.getParent()) != null && (parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
            a(this.start, parent.horizontalRun.start, this.b.mLeft.getMargin());
            a(this.end, parent.horizontalRun.end, -this.b.mRight.getMargin());
            return;
        }
        if (this.e.resolved && this.b.measured) {
            if (this.b.mListAnchors[0].mTarget != null && this.b.mListAnchors[1].mTarget != null) {
                if (this.b.isInHorizontalChain()) {
                    this.start.f2136c = this.b.mListAnchors[0].getMargin();
                    this.end.f2136c = -this.b.mListAnchors[1].getMargin();
                    return;
                }
                DependencyNode a2 = a(this.b.mListAnchors[0]);
                if (a2 != null) {
                    a(this.start, a2, this.b.mListAnchors[0].getMargin());
                }
                DependencyNode a3 = a(this.b.mListAnchors[1]);
                if (a3 != null) {
                    a(this.end, a3, -this.b.mListAnchors[1].getMargin());
                }
                this.start.delegateToWidgetRun = true;
                this.end.delegateToWidgetRun = true;
                return;
            } else if (this.b.mListAnchors[0].mTarget != null) {
                DependencyNode a4 = a(this.b.mListAnchors[0]);
                if (a4 != null) {
                    a(this.start, a4, this.b.mListAnchors[0].getMargin());
                    a(this.end, this.start, this.e.value);
                    return;
                }
                return;
            } else if (this.b.mListAnchors[1].mTarget != null) {
                DependencyNode a5 = a(this.b.mListAnchors[1]);
                if (a5 != null) {
                    a(this.end, a5, -this.b.mListAnchors[1].getMargin());
                    a(this.start, this.end, -this.e.value);
                    return;
                }
                return;
            } else if ((this.b instanceof Helper) || this.b.getParent() == null || this.b.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) {
                return;
            } else {
                a(this.start, this.b.getParent().horizontalRun.start, this.b.getX());
                a(this.end, this.start, this.e.value);
                return;
            }
        }
        if (this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i = this.b.mMatchConstraintDefaultWidth;
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
            } else if (i == 3) {
                if (this.b.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    this.b.verticalRun.start.updateDelegate = this;
                    this.b.verticalRun.end.updateDelegate = this;
                    this.e.updateDelegate = this;
                    if (this.b.isInVerticalChain()) {
                        this.e.g.add(this.b.verticalRun.e);
                        this.b.verticalRun.e.f.add(this.e);
                        this.b.verticalRun.e.updateDelegate = this;
                        this.e.g.add(this.b.verticalRun.start);
                        this.e.g.add(this.b.verticalRun.end);
                        this.b.verticalRun.start.f.add(this.e);
                        this.b.verticalRun.end.f.add(this.e);
                    } else if (this.b.isInHorizontalChain()) {
                        this.b.verticalRun.e.g.add(this.e);
                        this.e.f.add(this.b.verticalRun.e);
                    } else {
                        this.b.verticalRun.e.g.add(this.e);
                    }
                } else {
                    DimensionDependency dimensionDependency2 = this.b.verticalRun.e;
                    this.e.g.add(dimensionDependency2);
                    dimensionDependency2.f.add(this.e);
                    this.b.verticalRun.start.f.add(this.e);
                    this.b.verticalRun.end.f.add(this.e);
                    this.e.delegateToWidgetRun = true;
                    this.e.f.add(this.start);
                    this.e.f.add(this.end);
                    this.start.g.add(this.e);
                    this.end.g.add(this.e);
                }
            }
        }
        if (this.b.mListAnchors[0].mTarget != null && this.b.mListAnchors[1].mTarget != null) {
            if (this.b.isInHorizontalChain()) {
                this.start.f2136c = this.b.mListAnchors[0].getMargin();
                this.end.f2136c = -this.b.mListAnchors[1].getMargin();
                return;
            }
            DependencyNode a6 = a(this.b.mListAnchors[0]);
            DependencyNode a7 = a(this.b.mListAnchors[1]);
            if (a6 != null) {
                a6.addDependency(this);
            }
            if (a7 != null) {
                a7.addDependency(this);
            }
            this.g = WidgetRun.RunType.CENTER;
        } else if (this.b.mListAnchors[0].mTarget != null) {
            DependencyNode a8 = a(this.b.mListAnchors[0]);
            if (a8 != null) {
                a(this.start, a8, this.b.mListAnchors[0].getMargin());
                a(this.end, this.start, 1, this.e);
            }
        } else if (this.b.mListAnchors[1].mTarget != null) {
            DependencyNode a9 = a(this.b.mListAnchors[1]);
            if (a9 != null) {
                a(this.end, a9, -this.b.mListAnchors[1].getMargin());
                a(this.start, this.end, -1, this.e);
            }
        } else if ((this.b instanceof Helper) || this.b.getParent() == null) {
        } else {
            a(this.start, this.b.getParent().horizontalRun.start, this.b.getX());
            a(this.end, this.start, 1, this.e);
        }
    }

    public String toString() {
        return "HorizontalRun " + this.b.getDebugName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x0551, code lost:
        if (r0 != 1) goto L148;
     */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r10) {
        /*
            Method dump skipped, instructions count: 2122
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
