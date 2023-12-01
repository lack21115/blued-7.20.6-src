package androidx.constraintlayout.core.widgets.analyzer;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/BaselineDimensionDependency.class */
class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
    }

    public void update(DependencyNode dependencyNode) {
        ((VerticalWidgetRun) this.f2135a).baseline.f2136c = this.f2135a.b.getBaselineDistance();
        this.resolved = true;
    }
}
