package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/WidgetRun.class */
public abstract class WidgetRun implements Dependency {
    ConstraintWidget b;

    /* renamed from: c  reason: collision with root package name */
    RunGroup f2102c;
    protected ConstraintWidget.DimensionBehaviour d;
    public int matchConstraintsType;
    DimensionDependency e = new DimensionDependency(this);
    public int orientation = 0;
    boolean f = false;
    public DependencyNode start = new DependencyNode(this);
    public DependencyNode end = new DependencyNode(this);
    protected RunType g = RunType.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/WidgetRun$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2103a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f2103a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2103a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2103a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2103a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2103a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/WidgetRun$RunType.class */
    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.b = constraintWidget;
    }

    private void b(int i, int i2) {
        int i3 = this.matchConstraintsType;
        if (i3 == 0) {
            this.e.resolve(a(i2, i));
        } else if (i3 == 1) {
            this.e.resolve(Math.min(a(this.e.wrapValue, i), i2));
        } else if (i3 == 2) {
            ConstraintWidget parent = this.b.getParent();
            if (parent != null) {
                WidgetRun widgetRun = i == 0 ? parent.horizontalRun : parent.verticalRun;
                if (widgetRun.e.resolved) {
                    ConstraintWidget constraintWidget = this.b;
                    this.e.resolve(a((int) ((widgetRun.e.value * (i == 0 ? constraintWidget.mMatchConstraintPercentWidth : constraintWidget.mMatchConstraintPercentHeight)) + 0.5f), i));
                }
            }
        } else if (i3 != 3) {
        } else {
            if (this.b.horizontalRun.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.b.horizontalRun.matchConstraintsType == 3 && this.b.verticalRun.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.b.verticalRun.matchConstraintsType == 3) {
                return;
            }
            ConstraintWidget constraintWidget2 = this.b;
            WidgetRun widgetRun2 = i == 0 ? constraintWidget2.verticalRun : constraintWidget2.horizontalRun;
            if (widgetRun2.e.resolved) {
                float dimensionRatio = this.b.getDimensionRatio();
                this.e.resolve(i == 1 ? (int) ((widgetRun2.e.value / dimensionRatio) + 0.5f) : (int) ((dimensionRatio * widgetRun2.e.value) + 0.5f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
        if (r5 != r4) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
        if (r5 != r4) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(int r4, int r5) {
        /*
            r3 = this;
            r0 = r5
            if (r0 != 0) goto L2c
            r0 = r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.b
            int r0 = r0.mMatchConstraintMaxWidth
            r6 = r0
            r0 = r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.b
            int r0 = r0.mMatchConstraintMinWidth
            r1 = r4
            int r0 = java.lang.Math.max(r0, r1)
            r5 = r0
            r0 = r6
            if (r0 <= 0) goto L22
            r0 = r6
            r1 = r4
            int r0 = java.lang.Math.min(r0, r1)
            r5 = r0
        L22:
            r0 = r4
            r6 = r0
            r0 = r5
            r1 = r4
            if (r0 == r1) goto L53
            goto L51
        L2c:
            r0 = r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.b
            int r0 = r0.mMatchConstraintMaxHeight
            r6 = r0
            r0 = r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.b
            int r0 = r0.mMatchConstraintMinHeight
            r1 = r4
            int r0 = java.lang.Math.max(r0, r1)
            r5 = r0
            r0 = r6
            if (r0 <= 0) goto L4a
            r0 = r6
            r1 = r4
            int r0 = java.lang.Math.min(r0, r1)
            r5 = r0
        L4a:
            r0 = r4
            r6 = r0
            r0 = r5
            r1 = r4
            if (r0 == r1) goto L53
        L51:
            r0 = r5
            r6 = r0
        L53:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.a(int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DependencyNode a(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.mTarget == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.mTarget.mOwner;
        int i = AnonymousClass1.f2103a[constraintAnchor.mTarget.mType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return constraintWidget.verticalRun.end;
                    }
                    return constraintWidget.verticalRun.baseline;
                }
                return constraintWidget.verticalRun.start;
            }
            return constraintWidget.horizontalRun.end;
        }
        return constraintWidget.horizontalRun.start;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DependencyNode a(ConstraintAnchor constraintAnchor, int i) {
        if (constraintAnchor.mTarget == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.mTarget.mOwner;
        WidgetRun widgetRun = i == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int i2 = AnonymousClass1.f2103a[constraintAnchor.mTarget.mType.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Dependency dependency) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        DependencyNode a2 = a(constraintAnchor);
        DependencyNode a3 = a(constraintAnchor2);
        if (a2.resolved && a3.resolved) {
            int margin = a2.value + constraintAnchor.getMargin();
            int margin2 = a3.value - constraintAnchor2.getMargin();
            int i2 = margin2 - margin;
            if (!this.e.resolved && this.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                b(i, i2);
            }
            if (this.e.resolved) {
                if (this.e.value == i2) {
                    this.start.resolve(margin);
                    this.end.resolve(margin2);
                    return;
                }
                ConstraintWidget constraintWidget = this.b;
                float horizontalBiasPercent = i == 0 ? constraintWidget.getHorizontalBiasPercent() : constraintWidget.getVerticalBiasPercent();
                int i3 = margin;
                if (a2 == a3) {
                    i3 = a2.value;
                    margin2 = a3.value;
                    horizontalBiasPercent = 0.5f;
                }
                this.start.resolve((int) (i3 + 0.5f + (((margin2 - i3) - this.e.value) * horizontalBiasPercent)));
                this.end.resolve(this.start.value + this.e.value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i) {
        dependencyNode.g.add(dependencyNode2);
        dependencyNode.f2088c = i;
        dependencyNode2.f.add(dependencyNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i, DimensionDependency dimensionDependency) {
        dependencyNode.g.add(dependencyNode2);
        dependencyNode.g.add(this.e);
        dependencyNode.d = i;
        dependencyNode.e = dimensionDependency;
        dependencyNode2.f.add(dependencyNode);
        dimensionDependency.f.add(dependencyNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void applyToWidget();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Dependency dependency) {
    }

    abstract void c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d();

    public long getWrapDimension() {
        if (this.e.resolved) {
            return this.e.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        int i;
        int size = this.start.g.size();
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = i3;
            if (i2 >= size) {
                break;
            }
            int i4 = i;
            if (this.start.g.get(i2).f2087a != this) {
                i4 = i + 1;
            }
            i2++;
            i3 = i4;
        }
        int size2 = this.end.g.size();
        int i5 = i;
        int i6 = 0;
        while (i6 < size2) {
            int i7 = i5;
            if (this.end.g.get(i6).f2087a != this) {
                i7 = i5 + 1;
            }
            i6++;
            i5 = i7;
        }
        if (i5 >= 2) {
            z = true;
        }
        return z;
    }

    public boolean isDimensionResolved() {
        return this.e.resolved;
    }

    public boolean isResolved() {
        return this.f;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    public long wrapSize(int i) {
        int i2;
        if (this.e.resolved) {
            long j = this.e.value;
            if (isCenterConnection()) {
                i2 = this.start.f2088c - this.end.f2088c;
            } else if (i != 0) {
                return j - this.end.f2088c;
            } else {
                i2 = this.start.f2088c;
            }
            return j + i2;
        }
        return 0L;
    }
}
