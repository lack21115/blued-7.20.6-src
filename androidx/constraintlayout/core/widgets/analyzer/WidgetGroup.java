package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/WidgetGroup.class */
public class WidgetGroup {
    static int b;

    /* renamed from: c  reason: collision with root package name */
    int f2099c;
    int e;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ConstraintWidget> f2098a = new ArrayList<>();
    boolean d = false;
    ArrayList<MeasureResult> f = null;
    private int g = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/WidgetGroup$MeasureResult.class */
    public class MeasureResult {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<ConstraintWidget> f2100a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f2101c;
        int d;
        int e;
        int f;
        int g;

        public MeasureResult(ConstraintWidget constraintWidget, LinearSystem linearSystem, int i) {
            this.f2100a = new WeakReference<>(constraintWidget);
            this.b = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
            this.f2101c = linearSystem.getObjectVariableValue(constraintWidget.mTop);
            this.d = linearSystem.getObjectVariableValue(constraintWidget.mRight);
            this.e = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
            this.f = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
            this.g = i;
        }

        public void apply() {
            ConstraintWidget constraintWidget = this.f2100a.get();
            if (constraintWidget != null) {
                constraintWidget.setFinalFrame(this.b, this.f2101c, this.d, this.e, this.f, this.g);
            }
        }
    }

    public WidgetGroup(int i) {
        this.f2099c = -1;
        this.e = 0;
        int i2 = b;
        b = i2 + 1;
        this.f2099c = i2;
        this.e = i;
    }

    private int a(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int objectVariableValue;
        int objectVariableValue2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).getParent();
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList.size()) {
                break;
            }
            arrayList.get(i3).addToSolver(linearSystem, false);
            i2 = i3 + 1;
        }
        if (i == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.minimize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f = new ArrayList<>();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= arrayList.size()) {
                break;
            }
            this.f.add(new MeasureResult(arrayList.get(i5), linearSystem, i));
            i4 = i5 + 1;
        }
        if (i == 0) {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mLeft);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mRight);
            linearSystem.reset();
        } else {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mTop);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mBottom);
            linearSystem.reset();
        }
        return objectVariableValue2 - objectVariableValue;
    }

    private String a() {
        int i = this.e;
        return i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown";
    }

    private boolean a(ConstraintWidget constraintWidget) {
        return this.f2098a.contains(constraintWidget);
    }

    public boolean add(ConstraintWidget constraintWidget) {
        if (this.f2098a.contains(constraintWidget)) {
            return false;
        }
        this.f2098a.add(constraintWidget);
        return true;
    }

    public void apply() {
        if (this.f == null || !this.d) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f.size()) {
                return;
            }
            this.f.get(i2).apply();
            i = i2 + 1;
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        int size = this.f2098a.size();
        if (this.g != -1 && size > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup = arrayList.get(i2);
                if (this.g == widgetGroup.f2099c) {
                    moveTo(this.e, widgetGroup);
                }
                i = i2 + 1;
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void clear() {
        this.f2098a.clear();
    }

    public int getId() {
        return this.f2099c;
    }

    public int getOrientation() {
        return this.e;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2098a.size()) {
                return false;
            }
            if (widgetGroup.a(this.f2098a.get(i2))) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public boolean isAuthoritative() {
        return this.d;
    }

    public int measureWrap(LinearSystem linearSystem, int i) {
        if (this.f2098a.size() == 0) {
            return 0;
        }
        return a(linearSystem, this.f2098a, i);
    }

    public void moveTo(int i, WidgetGroup widgetGroup) {
        Iterator<ConstraintWidget> it = this.f2098a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            widgetGroup.add(next);
            if (i == 0) {
                next.horizontalGroup = widgetGroup.getId();
            } else {
                next.verticalGroup = widgetGroup.getId();
            }
        }
        this.g = widgetGroup.f2099c;
    }

    public void setAuthoritative(boolean z) {
        this.d = z;
    }

    public void setOrientation(int i) {
        this.e = i;
    }

    public int size() {
        return this.f2098a.size();
    }

    public String toString() {
        String str = a() + " [" + this.f2099c + "] <";
        Iterator<ConstraintWidget> it = this.f2098a.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            str = str + " " + next.getDebugName();
        }
        return str + " >";
    }
}
