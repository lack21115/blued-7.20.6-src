package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/HelperReferences.class */
public class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void a(DependencyNode dependencyNode) {
        this.start.f.add(dependencyNode);
        dependencyNode.g.add(this.start);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean a() {
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.b instanceof Barrier) {
            int barrierType = ((Barrier) this.b).getBarrierType();
            if (barrierType == 0 || barrierType == 1) {
                this.b.setX(this.start.value);
            } else {
                this.b.setY(this.start.value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void b() {
        this.f2150c = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void c() {
        this.start.resolved = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        if (!(this.b instanceof Barrier)) {
            return;
        }
        this.start.delegateToWidgetRun = true;
        Barrier barrier = (Barrier) this.b;
        int barrierType = barrier.getBarrierType();
        boolean allowsGoneWidget = barrier.getAllowsGoneWidget();
        if (barrierType == 0) {
            this.start.b = DependencyNode.Type.LEFT;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= barrier.mWidgetsCount) {
                    a(this.b.horizontalRun.start);
                    a(this.b.horizontalRun.end);
                    return;
                }
                ConstraintWidget constraintWidget = barrier.mWidgets[i2];
                if (allowsGoneWidget || constraintWidget.getVisibility() != 8) {
                    DependencyNode dependencyNode = constraintWidget.horizontalRun.start;
                    dependencyNode.f.add(this.start);
                    this.start.g.add(dependencyNode);
                }
                i = i2 + 1;
            }
        } else if (barrierType == 1) {
            this.start.b = DependencyNode.Type.RIGHT;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= barrier.mWidgetsCount) {
                    a(this.b.horizontalRun.start);
                    a(this.b.horizontalRun.end);
                    return;
                }
                ConstraintWidget constraintWidget2 = barrier.mWidgets[i4];
                if (allowsGoneWidget || constraintWidget2.getVisibility() != 8) {
                    DependencyNode dependencyNode2 = constraintWidget2.horizontalRun.end;
                    dependencyNode2.f.add(this.start);
                    this.start.g.add(dependencyNode2);
                }
                i3 = i4 + 1;
            }
        } else if (barrierType != 2) {
            if (barrierType != 3) {
                return;
            }
            this.start.b = DependencyNode.Type.BOTTOM;
            for (int i5 = 0; i5 < barrier.mWidgetsCount; i5++) {
                ConstraintWidget constraintWidget3 = barrier.mWidgets[i5];
                if (allowsGoneWidget || constraintWidget3.getVisibility() != 8) {
                    DependencyNode dependencyNode3 = constraintWidget3.verticalRun.end;
                    dependencyNode3.f.add(this.start);
                    this.start.g.add(dependencyNode3);
                }
            }
            a(this.b.verticalRun.start);
            a(this.b.verticalRun.end);
        } else {
            this.start.b = DependencyNode.Type.TOP;
            int i6 = 0;
            while (true) {
                int i7 = i6;
                if (i7 >= barrier.mWidgetsCount) {
                    a(this.b.verticalRun.start);
                    a(this.b.verticalRun.end);
                    return;
                }
                ConstraintWidget constraintWidget4 = barrier.mWidgets[i7];
                if (allowsGoneWidget || constraintWidget4.getVisibility() != 8) {
                    DependencyNode dependencyNode4 = constraintWidget4.verticalRun.start;
                    dependencyNode4.f.add(this.start);
                    this.start.g.add(dependencyNode4);
                }
                i6 = i7 + 1;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0044, code lost:
        if (r0 < r7) goto L15;
     */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r5) {
        /*
            r4 = this;
            r0 = r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r0.b
            androidx.constraintlayout.core.widgets.Barrier r0 = (androidx.constraintlayout.core.widgets.Barrier) r0
            r5 = r0
            r0 = r5
            int r0 = r0.getBarrierType()
            r10 = r0
            r0 = r4
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r0 = r0.g
            java.util.Iterator r0 = r0.iterator()
            r11 = r0
            r0 = 0
            r6 = r0
            r0 = -1
            r7 = r0
        L20:
            r0 = r11
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L5d
            r0 = r11
            java.lang.Object r0 = r0.next()
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r0
            int r0 = r0.value
            r8 = r0
            r0 = r7
            r1 = -1
            if (r0 == r1) goto L47
            r0 = r7
            r9 = r0
            r0 = r8
            r1 = r7
            if (r0 >= r1) goto L4b
        L47:
            r0 = r8
            r9 = r0
        L4b:
            r0 = r9
            r7 = r0
            r0 = r6
            r1 = r8
            if (r0 >= r1) goto L20
            r0 = r8
            r6 = r0
            r0 = r9
            r7 = r0
            goto L20
        L5d:
            r0 = r10
            if (r0 == 0) goto L79
            r0 = r10
            r1 = 2
            if (r0 != r1) goto L6b
            goto L79
        L6b:
            r0 = r4
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.start
            r1 = r6
            r2 = r5
            int r2 = r2.getMargin()
            int r1 = r1 + r2
            r0.resolve(r1)
            return
        L79:
            r0 = r4
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r0 = r0.start
            r1 = r7
            r2 = r5
            int r2 = r2.getMargin()
            int r1 = r1 + r2
            r0.resolve(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HelperReferences.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
