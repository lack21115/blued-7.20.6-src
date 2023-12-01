package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/analyzer/ChainRun.class */
public class ChainRun extends WidgetRun {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<WidgetRun> f2132a;
    private int h;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.f2132a = new ArrayList<>();
        this.orientation = i;
        e();
    }

    private void e() {
        ConstraintWidget constraintWidget = this.b;
        ConstraintWidget previousChainMember = constraintWidget.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget2 = previousChainMember;
            if (constraintWidget2 == null) {
                break;
            }
            constraintWidget = constraintWidget2;
            previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        }
        this.b = constraintWidget;
        this.f2132a.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = nextChainMember;
            if (constraintWidget3 == null) {
                break;
            }
            this.f2132a.add(constraintWidget3.getRun(this.orientation));
            nextChainMember = constraintWidget3.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.f2132a.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            if (this.orientation == 0) {
                next.b.horizontalChainRun = this;
            } else if (this.orientation == 1) {
                next.b.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.b.getParent()).isRtl()) && this.f2132a.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.f2132a;
            this.b = arrayList.get(arrayList.size() - 1).b;
        }
        this.h = this.orientation == 0 ? this.b.getHorizontalChainStyle() : this.b.getVerticalChainStyle();
    }

    private ConstraintWidget f() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2132a.size()) {
                return null;
            }
            WidgetRun widgetRun = this.f2132a.get(i2);
            if (widgetRun.b.getVisibility() != 8) {
                return widgetRun.b;
            }
            i = i2 + 1;
        }
    }

    private ConstraintWidget g() {
        int size = this.f2132a.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return null;
            }
            WidgetRun widgetRun = this.f2132a.get(i);
            if (widgetRun.b.getVisibility() != 8) {
                return widgetRun.b;
            }
            size = i;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean a() {
        int size = this.f2132a.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return true;
            }
            if (!this.f2132a.get(i2).a()) {
                return false;
            }
            i = i2 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2132a.size()) {
                return;
            }
            this.f2132a.get(i2).applyToWidget();
            i = i2 + 1;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void b() {
        this.f2150c = null;
        Iterator<WidgetRun> it = this.f2132a.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void c() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void d() {
        Iterator<WidgetRun> it = this.f2132a.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = this.f2132a.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.f2132a.get(0).b;
        ConstraintWidget constraintWidget2 = this.f2132a.get(size - 1).b;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode a2 = a(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget f = f();
            if (f != null) {
                margin = f.mLeft.getMargin();
            }
            if (a2 != null) {
                a(this.start, a2, margin);
            }
            DependencyNode a3 = a(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget g = g();
            if (g != null) {
                margin2 = g.mRight.getMargin();
            }
            if (a3 != null) {
                a(this.end, a3, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode a4 = a(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget f2 = f();
            if (f2 != null) {
                margin3 = f2.mTop.getMargin();
            }
            if (a4 != null) {
                a(this.start, a4, margin3);
            }
            DependencyNode a5 = a(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget g2 = g();
            if (g2 != null) {
                margin4 = g2.mBottom.getMargin();
            }
            if (a5 != null) {
                a(this.end, a5, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        WidgetRun widgetRun;
        int size = this.f2132a.size();
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return j;
            }
            j = j + widgetRun.start.f2136c + this.f2132a.get(i2).getWrapDimension() + widgetRun.end.f2136c;
            i = i2 + 1;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        Iterator<WidgetRun> it = this.f2132a.iterator();
        while (it.hasNext()) {
            sb.append(SimpleComparison.LESS_THAN_OPERATION);
            sb.append(it.next());
            sb.append("> ");
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z;
        int i12;
        int i13;
        int i14;
        int i15;
        float f2;
        int i16;
        int i17;
        if (!this.start.resolved || !this.end.resolved) {
            return;
        }
        ConstraintWidget parent = this.b.getParent();
        boolean isRtl = parent instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer) parent).isRtl() : false;
        int i18 = this.end.value - this.start.value;
        int size = this.f2132a.size();
        int i19 = 0;
        while (true) {
            int i20 = i19;
            if (i20 >= size) {
                i = -1;
                break;
            }
            i = i20;
            if (this.f2132a.get(i20).b.getVisibility() != 8) {
                break;
            }
            i19 = i20 + 1;
        }
        int i21 = size - 1;
        int i22 = i21;
        while (true) {
            int i23 = i22;
            i2 = -1;
            if (i23 < 0) {
                break;
            }
            if (this.f2132a.get(i23).b.getVisibility() != 8) {
                i2 = i23;
                break;
            }
            i22 = i23 - 1;
        }
        int i24 = 0;
        while (true) {
            int i25 = i24;
            if (i25 >= 2) {
                i3 = 0;
                i4 = 0;
                i5 = 0;
                f = 0.0f;
                break;
            }
            int i26 = 0;
            i4 = 0;
            i10 = 0;
            i11 = 0;
            f = 0.0f;
            while (i26 < size) {
                WidgetRun widgetRun = this.f2132a.get(i26);
                if (widgetRun.b.getVisibility() == 8) {
                    i16 = i4;
                    i17 = i10;
                } else {
                    int i27 = i11 + 1;
                    int i28 = i4;
                    if (i26 > 0) {
                        i28 = i4;
                        if (i26 >= i) {
                            i28 = i4 + widgetRun.start.f2136c;
                        }
                    }
                    int i29 = widgetRun.e.value;
                    boolean z2 = widgetRun.d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (!z2) {
                        if (widgetRun.matchConstraintsType == 1 && i25 == 0) {
                            i14 = widgetRun.e.wrapValue;
                            i13 = i10 + 1;
                        } else {
                            z = z2;
                            i12 = i29;
                            i13 = i10;
                            if (widgetRun.e.resolved) {
                                i13 = i10;
                                i14 = i29;
                            }
                        }
                        z = true;
                        i12 = i14;
                    } else if (this.orientation == 0 && !widgetRun.b.horizontalRun.e.resolved) {
                        return;
                    } else {
                        z = z2;
                        i12 = i29;
                        i13 = i10;
                        if (this.orientation == 1) {
                            z = z2;
                            i12 = i29;
                            i13 = i10;
                            if (!widgetRun.b.verticalRun.e.resolved) {
                                return;
                            }
                        }
                    }
                    if (z) {
                        i15 = i28 + i12;
                        f2 = f;
                    } else {
                        int i30 = i13 + 1;
                        float f3 = widgetRun.b.mWeight[this.orientation];
                        i15 = i28;
                        i13 = i30;
                        f2 = f;
                        if (f3 >= 0.0f) {
                            f2 = f + f3;
                            i15 = i28;
                            i13 = i30;
                        }
                    }
                    i16 = i15;
                    i17 = i13;
                    i11 = i27;
                    f = f2;
                    if (i26 < i21) {
                        i16 = i15;
                        i17 = i13;
                        i11 = i27;
                        f = f2;
                        if (i26 < i2) {
                            i16 = i15 + (-widgetRun.end.f2136c);
                            f = f2;
                            i11 = i27;
                            i17 = i13;
                        }
                    }
                }
                i26++;
                i4 = i16;
                i10 = i17;
            }
            if (i4 < i18 || i10 == 0) {
                break;
            }
            i24 = i25 + 1;
        }
        i3 = i11;
        i5 = i10;
        int i31 = this.start.value;
        if (isRtl) {
            i31 = this.end.value;
        }
        int i32 = i31;
        if (i4 > i18) {
            i32 = isRtl ? i31 + ((int) (((i4 - i18) / 2.0f) + 0.5f)) : i31 - ((int) (((i4 - i18) / 2.0f) + 0.5f));
        }
        if (i5 > 0) {
            float f4 = i18 - i4;
            int i33 = (int) ((f4 / i5) + 0.5f);
            int i34 = 0;
            int i35 = i32;
            for (int i36 = 0; i36 < size; i36++) {
                WidgetRun widgetRun2 = this.f2132a.get(i36);
                if (widgetRun2.b.getVisibility() != 8 && widgetRun2.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !widgetRun2.e.resolved) {
                    int i37 = f > 0.0f ? (int) (((widgetRun2.b.mWeight[this.orientation] * f4) / f) + 0.5f) : i33;
                    if (this.orientation == 0) {
                        i8 = widgetRun2.b.mMatchConstraintMaxWidth;
                        i9 = widgetRun2.b.mMatchConstraintMinWidth;
                    } else {
                        i8 = widgetRun2.b.mMatchConstraintMaxHeight;
                        i9 = widgetRun2.b.mMatchConstraintMinHeight;
                    }
                    int max = Math.max(i9, widgetRun2.matchConstraintsType == 1 ? Math.min(i37, widgetRun2.e.wrapValue) : i37);
                    int i38 = max;
                    if (i8 > 0) {
                        i38 = Math.min(i8, max);
                    }
                    int i39 = i37;
                    int i40 = i34;
                    if (i38 != i37) {
                        i40 = i34 + 1;
                        i39 = i38;
                    }
                    widgetRun2.e.resolve(i39);
                    i34 = i40;
                }
            }
            if (i34 > 0) {
                int i41 = i5 - i34;
                i7 = 0;
                for (int i42 = 0; i42 < size; i42++) {
                    WidgetRun widgetRun3 = this.f2132a.get(i42);
                    if (widgetRun3.b.getVisibility() != 8) {
                        int i43 = i7;
                        if (i42 > 0) {
                            i43 = i7;
                            if (i42 >= i) {
                                i43 = i7 + widgetRun3.start.f2136c;
                            }
                        }
                        int i44 = i43 + widgetRun3.e.value;
                        i7 = i44;
                        if (i42 < i21) {
                            i7 = i44;
                            if (i42 < i2) {
                                i7 = i44 + (-widgetRun3.end.f2136c);
                            }
                        }
                    }
                }
                i5 = i41;
            } else {
                i7 = i4;
            }
            if (this.h == 2 && i34 == 0) {
                this.h = 0;
                i4 = i7;
                i6 = i5;
                i32 = i35;
            } else {
                i4 = i7;
                i6 = i5;
                i32 = i35;
            }
        } else {
            i6 = i5;
        }
        if (i4 > i18) {
            this.h = 2;
        }
        if (i3 > 0 && i6 == 0 && i == i2) {
            this.h = 2;
        }
        int i45 = this.h;
        if (i45 == 1) {
            int i46 = i3 > 1 ? (i18 - i4) / (i3 - 1) : i3 == 1 ? (i18 - i4) / 2 : 0;
            if (i6 > 0) {
                i46 = 0;
            }
            int i47 = 0;
            while (true) {
                int i48 = i47;
                int i49 = i32;
                if (i48 >= size) {
                    return;
                }
                WidgetRun widgetRun4 = this.f2132a.get(isRtl ? size - (i48 + 1) : i48);
                if (widgetRun4.b.getVisibility() == 8) {
                    widgetRun4.start.resolve(i49);
                    widgetRun4.end.resolve(i49);
                    i32 = i49;
                } else {
                    int i50 = i49;
                    if (i48 > 0) {
                        i50 = isRtl ? i49 - i46 : i49 + i46;
                    }
                    int i51 = i50;
                    if (i48 > 0) {
                        i51 = i50;
                        if (i48 >= i) {
                            i51 = isRtl ? i50 - widgetRun4.start.f2136c : i50 + widgetRun4.start.f2136c;
                        }
                    }
                    if (isRtl) {
                        widgetRun4.end.resolve(i51);
                    } else {
                        widgetRun4.start.resolve(i51);
                    }
                    int i52 = widgetRun4.e.value;
                    int i53 = i52;
                    if (widgetRun4.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i53 = i52;
                        if (widgetRun4.matchConstraintsType == 1) {
                            i53 = widgetRun4.e.wrapValue;
                        }
                    }
                    int i54 = isRtl ? i51 - i53 : i51 + i53;
                    if (isRtl) {
                        widgetRun4.start.resolve(i54);
                    } else {
                        widgetRun4.end.resolve(i54);
                    }
                    widgetRun4.f = true;
                    i32 = i54;
                    if (i48 < i21) {
                        i32 = i54;
                        if (i48 < i2) {
                            i32 = isRtl ? i54 - (-widgetRun4.end.f2136c) : i54 + (-widgetRun4.end.f2136c);
                        }
                    }
                }
                i47 = i48 + 1;
            }
        } else if (i45 == 0) {
            int i55 = (i18 - i4) / (i3 + 1);
            if (i6 > 0) {
                i55 = 0;
            }
            int i56 = 0;
            while (true) {
                int i57 = i56;
                if (i57 >= size) {
                    return;
                }
                WidgetRun widgetRun5 = this.f2132a.get(isRtl ? size - (i57 + 1) : i57);
                if (widgetRun5.b.getVisibility() == 8) {
                    widgetRun5.start.resolve(i32);
                    widgetRun5.end.resolve(i32);
                } else {
                    int i58 = isRtl ? i32 - i55 : i32 + i55;
                    int i59 = i58;
                    if (i57 > 0) {
                        i59 = i58;
                        if (i57 >= i) {
                            i59 = isRtl ? i58 - widgetRun5.start.f2136c : i58 + widgetRun5.start.f2136c;
                        }
                    }
                    if (isRtl) {
                        widgetRun5.end.resolve(i59);
                    } else {
                        widgetRun5.start.resolve(i59);
                    }
                    int i60 = widgetRun5.e.value;
                    int i61 = i60;
                    if (widgetRun5.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        i61 = i60;
                        if (widgetRun5.matchConstraintsType == 1) {
                            i61 = Math.min(i60, widgetRun5.e.wrapValue);
                        }
                    }
                    int i62 = isRtl ? i59 - i61 : i59 + i61;
                    if (isRtl) {
                        widgetRun5.start.resolve(i62);
                    } else {
                        widgetRun5.end.resolve(i62);
                    }
                    i32 = i62;
                    if (i57 < i21) {
                        i32 = i62;
                        if (i57 < i2) {
                            i32 = isRtl ? i62 - (-widgetRun5.end.f2136c) : i62 + (-widgetRun5.end.f2136c);
                        }
                    }
                }
                i56 = i57 + 1;
            }
        } else if (i45 == 2) {
            float horizontalBiasPercent = this.orientation == 0 ? this.b.getHorizontalBiasPercent() : this.b.getVerticalBiasPercent();
            float f5 = horizontalBiasPercent;
            if (isRtl) {
                f5 = 1.0f - horizontalBiasPercent;
            }
            int i63 = (((int) (((i18 - i4) * f5) + 0.5f)) < 0 || i6 > 0) ? 0 : 0;
            int i64 = isRtl ? i32 - i63 : i32 + i63;
            int i65 = 0;
            while (true) {
                int i66 = i65;
                if (i66 >= size) {
                    return;
                }
                WidgetRun widgetRun6 = this.f2132a.get(isRtl ? size - (i66 + 1) : i66);
                if (widgetRun6.b.getVisibility() == 8) {
                    widgetRun6.start.resolve(i64);
                    widgetRun6.end.resolve(i64);
                } else {
                    int i67 = i64;
                    if (i66 > 0) {
                        i67 = i64;
                        if (i66 >= i) {
                            i67 = isRtl ? i64 - widgetRun6.start.f2136c : i64 + widgetRun6.start.f2136c;
                        }
                    }
                    if (isRtl) {
                        widgetRun6.end.resolve(i67);
                    } else {
                        widgetRun6.start.resolve(i67);
                    }
                    int i68 = widgetRun6.e.value;
                    if (widgetRun6.d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                        i68 = widgetRun6.e.wrapValue;
                    }
                    int i69 = isRtl ? i67 - i68 : i67 + i68;
                    if (isRtl) {
                        widgetRun6.start.resolve(i69);
                    } else {
                        widgetRun6.end.resolve(i69);
                    }
                    i64 = i69;
                    if (i66 < i21) {
                        i64 = i69;
                        if (i66 < i2) {
                            i64 = isRtl ? i69 - (-widgetRun6.end.f2136c) : i69 + (-widgetRun6.end.f2136c);
                        }
                    }
                }
                i65 = i66 + 1;
            }
        }
    }
}
