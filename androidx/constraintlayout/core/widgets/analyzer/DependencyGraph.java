package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/DependencyGraph.class */
public class DependencyGraph {
    private ConstraintWidgetContainer b;
    private ConstraintWidgetContainer e;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2134c = true;
    private boolean d = true;
    private ArrayList<WidgetRun> f = new ArrayList<>();
    private ArrayList<RunGroup> g = new ArrayList<>();
    private BasicMeasure.Measurer h = null;
    private BasicMeasure.Measure i = new BasicMeasure.Measure();

    /* renamed from: a  reason: collision with root package name */
    ArrayList<RunGroup> f2133a = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.b = constraintWidgetContainer;
        this.e = constraintWidgetContainer;
    }

    private int a(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        int size = this.f2133a.size();
        long j = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return (int) j;
            }
            j = Math.max(j, this.f2133a.get(i3).computeWrapSize(constraintWidgetContainer, i));
            i2 = i3 + 1;
        }
    }

    private void a(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i2) {
        this.i.horizontalBehavior = dimensionBehaviour;
        this.i.verticalBehavior = dimensionBehaviour2;
        this.i.horizontalDimension = i;
        this.i.verticalDimension = i2;
        this.h.measure(constraintWidget, this.i);
        constraintWidget.setWidth(this.i.measuredWidth);
        constraintWidget.setHeight(this.i.measuredHeight);
        constraintWidget.setHasBaseline(this.i.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.i.measuredBaseline);
    }

    private void a(DependencyNode dependencyNode, int i, int i2, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.f2135a;
        if (widgetRun.f2150c != null || widgetRun == this.b.horizontalRun || widgetRun == this.b.verticalRun) {
            return;
        }
        RunGroup runGroup2 = runGroup;
        if (runGroup == null) {
            runGroup2 = new RunGroup(widgetRun, i2);
            arrayList.add(runGroup2);
        }
        widgetRun.f2150c = runGroup2;
        runGroup2.add(widgetRun);
        for (Dependency dependency : widgetRun.start.f) {
            if (dependency instanceof DependencyNode) {
                a((DependencyNode) dependency, i, 0, dependencyNode2, arrayList, runGroup2);
            }
        }
        for (Dependency dependency2 : widgetRun.end.f) {
            if (dependency2 instanceof DependencyNode) {
                a((DependencyNode) dependency2, i, 1, dependencyNode2, arrayList, runGroup2);
            }
        }
        if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.f) {
                if (dependency3 instanceof DependencyNode) {
                    a((DependencyNode) dependency3, i, 2, dependencyNode2, arrayList, runGroup2);
                }
            }
        }
        for (DependencyNode dependencyNode3 : widgetRun.start.g) {
            if (dependencyNode3 == dependencyNode2) {
                runGroup2.dual = true;
            }
            a(dependencyNode3, i, 0, dependencyNode2, arrayList, runGroup2);
        }
        for (DependencyNode dependencyNode4 : widgetRun.end.g) {
            if (dependencyNode4 == dependencyNode2) {
                runGroup2.dual = true;
            }
            a(dependencyNode4, i, 1, dependencyNode2, arrayList, runGroup2);
        }
        if (i == 1 && (widgetRun instanceof VerticalWidgetRun)) {
            for (DependencyNode dependencyNode5 : ((VerticalWidgetRun) widgetRun).baseline.g) {
                a(dependencyNode5, i, 2, dependencyNode2, arrayList, runGroup2);
            }
        }
    }

    private void a(WidgetRun widgetRun, int i, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : widgetRun.start.f) {
            if (dependency instanceof DependencyNode) {
                a((DependencyNode) dependency, i, 0, widgetRun.end, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                a(((WidgetRun) dependency).start, i, 0, widgetRun.end, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.end.f) {
            if (dependency2 instanceof DependencyNode) {
                a((DependencyNode) dependency2, i, 1, widgetRun.start, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                a(((WidgetRun) dependency2).end, i, 1, widgetRun.start, arrayList, null);
            }
        }
        if (i == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.f) {
                if (dependency3 instanceof DependencyNode) {
                    a((DependencyNode) dependency3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x011c, code lost:
        if (r0.mRight.mTarget == null) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8) {
        /*
            Method dump skipped, instructions count: 1603
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):boolean");
    }

    public void buildGraph() {
        buildGraph(this.f);
        this.f2133a.clear();
        RunGroup.index = 0;
        a(this.b.horizontalRun, 0, this.f2133a);
        a(this.b.verticalRun, 1, this.f2133a);
        this.f2134c = false;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        HashSet hashSet;
        arrayList.clear();
        this.e.horizontalRun.b();
        this.e.verticalRun.b();
        arrayList.add(this.e.horizontalRun);
        arrayList.add(this.e.verticalRun);
        Iterator<ConstraintWidget> it = this.e.mChildren.iterator();
        HashSet hashSet2 = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new GuidelineReference(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    HashSet hashSet3 = hashSet2;
                    if (hashSet2 == null) {
                        hashSet3 = new HashSet();
                    }
                    hashSet3.add(next.horizontalChainRun);
                    hashSet2 = hashSet3;
                } else {
                    arrayList.add(next.horizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    hashSet = hashSet2;
                    if (hashSet2 == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.verticalRun);
                    hashSet = hashSet2;
                }
                hashSet2 = hashSet;
                if (next instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(next));
                    hashSet2 = hashSet;
                }
            }
        }
        if (hashSet2 != null) {
            arrayList.addAll(hashSet2);
        }
        Iterator<WidgetRun> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
        Iterator<WidgetRun> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.b != this.e) {
                next2.d();
            }
        }
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        if (this.f2134c) {
            buildGraph();
            Iterator<ConstraintWidget> it = this.b.mChildren.iterator();
            boolean z = false;
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.isTerminalWidget[0] = true;
                next.isTerminalWidget[1] = true;
                if (next instanceof Barrier) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            Iterator<RunGroup> it2 = this.f2133a.iterator();
            while (it2.hasNext()) {
                it2.next().defineTerminalWidgets(dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT, dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
            }
        }
    }

    public boolean directMeasure(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = z & true;
        if (this.f2134c || this.d) {
            Iterator<ConstraintWidget> it = this.b.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                next.horizontalRun.c();
                next.verticalRun.c();
            }
            this.b.ensureWidgetRuns();
            this.b.measured = false;
            this.b.horizontalRun.c();
            this.b.verticalRun.c();
            this.d = false;
        }
        if (a(this.e)) {
            return false;
        }
        this.b.setX(0);
        this.b.setY(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.b.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.b.getDimensionBehaviour(1);
        if (this.f2134c) {
            buildGraph();
        }
        int x = this.b.getX();
        int y = this.b.getY();
        this.b.horizontalRun.start.resolve(x);
        this.b.verticalRun.start.resolve(y);
        measureWidgets();
        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            boolean z5 = z4;
            if (z4) {
                Iterator<WidgetRun> it2 = this.f.iterator();
                while (true) {
                    z5 = z4;
                    if (!it2.hasNext()) {
                        break;
                    } else if (!it2.next().a()) {
                        z5 = false;
                        break;
                    }
                }
            }
            if (z5 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.b.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer = this.b;
                constraintWidgetContainer.setWidth(a(constraintWidgetContainer, 0));
                this.b.horizontalRun.e.resolve(this.b.getWidth());
            }
            if (z5 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.b.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.b;
                constraintWidgetContainer2.setHeight(a(constraintWidgetContainer2, 1));
                this.b.verticalRun.e.resolve(this.b.getHeight());
            }
        }
        if (this.b.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || this.b.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int width = this.b.getWidth() + x;
            this.b.horizontalRun.end.resolve(width);
            this.b.horizontalRun.e.resolve(width - x);
            measureWidgets();
            if (this.b.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || this.b.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = this.b.getHeight() + y;
                this.b.verticalRun.end.resolve(height);
                this.b.verticalRun.e.resolve(height - y);
            }
            measureWidgets();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator<WidgetRun> it3 = this.f.iterator();
        while (it3.hasNext()) {
            WidgetRun next2 = it3.next();
            if (next2.b != this.b || next2.f) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it4 = this.f.iterator();
        while (true) {
            z3 = true;
            if (!it4.hasNext()) {
                break;
            }
            WidgetRun next3 = it4.next();
            if (z2 || next3.b != this.b) {
                if (!next3.start.resolved || ((!next3.end.resolved && !(next3 instanceof GuidelineReference)) || (!next3.e.resolved && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference)))) {
                    break;
                }
            }
        }
        z3 = false;
        this.b.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.b.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z3;
    }

    public boolean directMeasureSetup(boolean z) {
        if (this.f2134c) {
            Iterator<ConstraintWidget> it = this.b.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                next.horizontalRun.e.resolved = false;
                next.horizontalRun.f = false;
                next.horizontalRun.c();
                next.verticalRun.e.resolved = false;
                next.verticalRun.f = false;
                next.verticalRun.c();
            }
            this.b.ensureWidgetRuns();
            this.b.measured = false;
            this.b.horizontalRun.e.resolved = false;
            this.b.horizontalRun.f = false;
            this.b.horizontalRun.c();
            this.b.verticalRun.e.resolved = false;
            this.b.verticalRun.f = false;
            this.b.verticalRun.c();
            buildGraph();
        }
        if (a(this.e)) {
            return false;
        }
        this.b.setX(0);
        this.b.setY(0);
        this.b.horizontalRun.start.resolve(0);
        this.b.verticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean z, int i) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = z & true;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.b.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.b.getDimensionBehaviour(1);
        int x = this.b.getX();
        int y = this.b.getY();
        if (z5 && (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
            Iterator<WidgetRun> it = this.f.iterator();
            while (true) {
                z4 = z5;
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.orientation == i && !next.a()) {
                    z4 = false;
                    break;
                }
            }
            if (i == 0) {
                if (z4 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.b.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer = this.b;
                    constraintWidgetContainer.setWidth(a(constraintWidgetContainer, 0));
                    this.b.horizontalRun.e.resolve(this.b.getWidth());
                }
            } else if (z4 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.b.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.b;
                constraintWidgetContainer2.setHeight(a(constraintWidgetContainer2, 1));
                this.b.verticalRun.e.resolve(this.b.getHeight());
            }
        }
        if (i == 0) {
            if (this.b.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.FIXED || this.b.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int width = this.b.getWidth() + x;
                this.b.horizontalRun.end.resolve(width);
                this.b.horizontalRun.e.resolve(width - x);
                z2 = true;
            }
            z2 = false;
        } else {
            if (this.b.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.FIXED || this.b.mListDimensionBehaviors[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = this.b.getHeight() + y;
                this.b.verticalRun.end.resolve(height);
                this.b.verticalRun.e.resolve(height - y);
                z2 = true;
            }
            z2 = false;
        }
        measureWidgets();
        Iterator<WidgetRun> it2 = this.f.iterator();
        while (it2.hasNext()) {
            WidgetRun next2 = it2.next();
            if (next2.orientation == i && (next2.b != this.b || next2.f)) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it3 = this.f.iterator();
        while (true) {
            z3 = true;
            if (!it3.hasNext()) {
                break;
            }
            WidgetRun next3 = it3.next();
            if (next3.orientation == i && (z2 || next3.b != this.b)) {
                if (!next3.start.resolved || !next3.end.resolved || (!(next3 instanceof ChainRun) && !next3.e.resolved)) {
                    break;
                }
            }
        }
        z3 = false;
        this.b.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.b.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z3;
    }

    public void invalidateGraph() {
        this.f2134c = true;
    }

    public void invalidateMeasures() {
        this.d = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
        if (r0 == 1) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void measureWidgets() {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.DependencyGraph.measureWidgets():void");
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.h = measurer;
    }
}
