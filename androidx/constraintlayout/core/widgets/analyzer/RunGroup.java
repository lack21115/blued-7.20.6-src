package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/RunGroup.class */
public class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;

    /* renamed from: a  reason: collision with root package name */
    WidgetRun f2142a;
    WidgetRun b;
    int d;
    int e;
    public int position = 0;
    public boolean dual = false;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<WidgetRun> f2143c = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i) {
        this.f2142a = null;
        this.b = null;
        this.d = 0;
        int i2 = index;
        this.d = i2;
        index = i2 + 1;
        this.f2142a = widgetRun;
        this.b = widgetRun;
        this.e = i;
    }

    private long a(DependencyNode dependencyNode, long j) {
        long j2;
        WidgetRun widgetRun = dependencyNode.f2135a;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.f.size();
        int i = 0;
        long j3 = j;
        while (true) {
            j2 = j3;
            if (i >= size) {
                break;
            }
            Dependency dependency = dependencyNode.f.get(i);
            long j4 = j2;
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                j4 = dependencyNode2.f2135a == widgetRun ? j2 : Math.max(j2, a(dependencyNode2, dependencyNode2.f2136c + j));
            }
            i++;
            j3 = j4;
        }
        long j5 = j2;
        if (dependencyNode == widgetRun.start) {
            long wrapDimension = widgetRun.getWrapDimension();
            DependencyNode dependencyNode3 = widgetRun.end;
            long j6 = j + wrapDimension;
            j5 = Math.max(Math.max(j2, a(dependencyNode3, j6)), j6 - widgetRun.end.f2136c);
        }
        return j5;
    }

    private boolean a(WidgetRun widgetRun, int i) {
        if (widgetRun.b.isTerminalWidget[i]) {
            for (Dependency dependency : widgetRun.start.f) {
                if (dependency instanceof DependencyNode) {
                    DependencyNode dependencyNode = (DependencyNode) dependency;
                    if (dependencyNode.f2135a != widgetRun && dependencyNode == dependencyNode.f2135a.start) {
                        if (widgetRun instanceof ChainRun) {
                            Iterator<WidgetRun> it = ((ChainRun) widgetRun).f2132a.iterator();
                            while (it.hasNext()) {
                                a(it.next(), i);
                            }
                        } else if (!(widgetRun instanceof HelperReferences)) {
                            widgetRun.b.isTerminalWidget[i] = false;
                        }
                        a(dependencyNode.f2135a, i);
                    }
                }
            }
            for (Dependency dependency2 : widgetRun.end.f) {
                if (dependency2 instanceof DependencyNode) {
                    DependencyNode dependencyNode2 = (DependencyNode) dependency2;
                    if (dependencyNode2.f2135a != widgetRun && dependencyNode2 == dependencyNode2.f2135a.start) {
                        if (widgetRun instanceof ChainRun) {
                            Iterator<WidgetRun> it2 = ((ChainRun) widgetRun).f2132a.iterator();
                            while (it2.hasNext()) {
                                a(it2.next(), i);
                            }
                        } else if (!(widgetRun instanceof HelperReferences)) {
                            widgetRun.b.isTerminalWidget[i] = false;
                        }
                        a(dependencyNode2.f2135a, i);
                    }
                }
            }
            return false;
        }
        return false;
    }

    private long b(DependencyNode dependencyNode, long j) {
        long j2;
        WidgetRun widgetRun = dependencyNode.f2135a;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.f.size();
        int i = 0;
        long j3 = j;
        while (true) {
            j2 = j3;
            if (i >= size) {
                break;
            }
            Dependency dependency = dependencyNode.f.get(i);
            long j4 = j2;
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                j4 = dependencyNode2.f2135a == widgetRun ? j2 : Math.min(j2, b(dependencyNode2, dependencyNode2.f2136c + j));
            }
            i++;
            j3 = j4;
        }
        long j5 = j2;
        if (dependencyNode == widgetRun.end) {
            long wrapDimension = widgetRun.getWrapDimension();
            DependencyNode dependencyNode3 = widgetRun.start;
            long j6 = j - wrapDimension;
            j5 = Math.min(Math.min(j2, b(dependencyNode3, j6)), j6 - widgetRun.start.f2136c);
        }
        return j5;
    }

    public void add(WidgetRun widgetRun) {
        this.f2143c.add(widgetRun);
        this.b = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        long wrapDimension;
        int i2;
        WidgetRun widgetRun = this.f2142a;
        long j = 0;
        if (widgetRun instanceof ChainRun) {
            if (((ChainRun) widgetRun).orientation != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(widgetRun instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof VerticalWidgetRun)) {
            return 0L;
        }
        DependencyNode dependencyNode = i == 0 ? constraintWidgetContainer.horizontalRun.start : constraintWidgetContainer.verticalRun.start;
        DependencyNode dependencyNode2 = i == 0 ? constraintWidgetContainer.horizontalRun.end : constraintWidgetContainer.verticalRun.end;
        boolean contains = this.f2142a.start.g.contains(dependencyNode);
        boolean contains2 = this.f2142a.end.g.contains(dependencyNode2);
        long wrapDimension2 = this.f2142a.getWrapDimension();
        if (contains && contains2) {
            long a2 = a(this.f2142a.start, 0L);
            long b = b(this.f2142a.end, 0L);
            long j2 = a2 - wrapDimension2;
            long j3 = j2;
            if (j2 >= (-this.f2142a.end.f2136c)) {
                j3 = j2 + this.f2142a.end.f2136c;
            }
            long j4 = ((-b) - wrapDimension2) - this.f2142a.start.f2136c;
            long j5 = j4;
            if (j4 >= this.f2142a.start.f2136c) {
                j5 = j4 - this.f2142a.start.f2136c;
            }
            float biasPercent = this.f2142a.b.getBiasPercent(i);
            if (biasPercent > 0.0f) {
                j = (((float) j5) / biasPercent) + (((float) j3) / (1.0f - biasPercent));
            }
            float f = (float) j;
            wrapDimension = this.f2142a.start.f2136c + (f * biasPercent) + 0.5f + wrapDimension2 + (f * (1.0f - biasPercent)) + 0.5f;
            i2 = this.f2142a.end.f2136c;
        } else if (contains) {
            return Math.max(a(this.f2142a.start, this.f2142a.start.f2136c), this.f2142a.start.f2136c + wrapDimension2);
        } else {
            if (contains2) {
                return Math.max(-b(this.f2142a.end, this.f2142a.end.f2136c), (-this.f2142a.end.f2136c) + wrapDimension2);
            }
            wrapDimension = this.f2142a.start.f2136c + this.f2142a.getWrapDimension();
            i2 = this.f2142a.end.f2136c;
        }
        return wrapDimension - i2;
    }

    public void defineTerminalWidgets(boolean z, boolean z2) {
        if (z) {
            WidgetRun widgetRun = this.f2142a;
            if (widgetRun instanceof HorizontalWidgetRun) {
                a(widgetRun, 0);
            }
        }
        if (z2) {
            WidgetRun widgetRun2 = this.f2142a;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                a(widgetRun2, 1);
            }
        }
    }
}
