package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/GuidelineReference.class */
public class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.horizontalRun.b();
        constraintWidget.verticalRun.b();
        this.orientation = ((Guideline) constraintWidget).getOrientation();
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
        if (((Guideline) this.b).getOrientation() == 1) {
            this.b.setX(this.start.value);
        } else {
            this.b.setY(this.start.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void b() {
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void c() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        Guideline guideline = (Guideline) this.b;
        int relativeBegin = guideline.getRelativeBegin();
        int relativeEnd = guideline.getRelativeEnd();
        guideline.getRelativePercent();
        if (guideline.getOrientation() == 1) {
            if (relativeBegin != -1) {
                this.start.g.add(this.b.mParent.horizontalRun.start);
                this.b.mParent.horizontalRun.start.f.add(this.start);
                this.start.f2136c = relativeBegin;
            } else if (relativeEnd != -1) {
                this.start.g.add(this.b.mParent.horizontalRun.end);
                this.b.mParent.horizontalRun.end.f.add(this.start);
                this.start.f2136c = -relativeEnd;
            } else {
                this.start.delegateToWidgetRun = true;
                this.start.g.add(this.b.mParent.horizontalRun.end);
                this.b.mParent.horizontalRun.end.f.add(this.start);
            }
            a(this.b.horizontalRun.start);
            a(this.b.horizontalRun.end);
            return;
        }
        if (relativeBegin != -1) {
            this.start.g.add(this.b.mParent.verticalRun.start);
            this.b.mParent.verticalRun.start.f.add(this.start);
            this.start.f2136c = relativeBegin;
        } else if (relativeEnd != -1) {
            this.start.g.add(this.b.mParent.verticalRun.end);
            this.b.mParent.verticalRun.end.f.add(this.start);
            this.start.f2136c = -relativeEnd;
        } else {
            this.start.delegateToWidgetRun = true;
            this.start.g.add(this.b.mParent.verticalRun.end);
            this.b.mParent.verticalRun.end.f.add(this.start);
        }
        a(this.b.verticalRun.start);
        a(this.b.verticalRun.end);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        if (this.start.readyToSolve && !this.start.resolved) {
            this.start.resolve((int) ((this.start.g.get(0).value * ((Guideline) this.b).getRelativePercent()) + 0.5f));
        }
    }
}
