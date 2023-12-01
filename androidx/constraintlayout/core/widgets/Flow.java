package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/Flow.class */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] am;
    private int P = -1;
    private int Q = -1;
    private int R = -1;
    private int S = -1;
    private int T = -1;
    private int U = -1;
    private float V = 0.5f;
    private float W = 0.5f;
    private float X = 0.5f;
    private float Y = 0.5f;
    private float Z = 0.5f;
    private float aa = 0.5f;
    private int ab = 0;
    private int ac = 0;
    private int ad = 2;
    private int ae = 2;
    private int af = 0;
    private int ag = -1;
    private int ah = 0;
    private ArrayList<WidgetsList> ai = new ArrayList<>();
    private ConstraintWidget[] aj = null;
    private ConstraintWidget[] ak = null;
    private int[] al = null;
    private int an = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/Flow$WidgetsList.class */
    public class WidgetsList {

        /* renamed from: c  reason: collision with root package name */
        private int f2125c;
        private ConstraintAnchor e;
        private ConstraintAnchor f;
        private ConstraintAnchor g;
        private ConstraintAnchor h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int r;
        private ConstraintWidget d = null;

        /* renamed from: a  reason: collision with root package name */
        int f2124a = 0;
        private int m = 0;
        private int n = 0;
        private int o = 0;
        private int p = 0;
        private int q = 0;

        public WidgetsList(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2) {
            this.f2125c = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.r = 0;
            this.f2125c = i;
            this.e = constraintAnchor;
            this.f = constraintAnchor2;
            this.g = constraintAnchor3;
            this.h = constraintAnchor4;
            this.i = Flow.this.getPaddingLeft();
            this.j = Flow.this.getPaddingTop();
            this.k = Flow.this.getPaddingRight();
            this.l = Flow.this.getPaddingBottom();
            this.r = i2;
        }

        private void a() {
            this.m = 0;
            this.n = 0;
            this.d = null;
            this.f2124a = 0;
            int i = this.p;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= i || this.o + i3 >= Flow.this.an) {
                    return;
                }
                ConstraintWidget constraintWidget = Flow.this.am[this.o + i3];
                if (this.f2125c == 0) {
                    int width = constraintWidget.getWidth();
                    int i4 = Flow.this.ab;
                    if (constraintWidget.getVisibility() == 8) {
                        i4 = 0;
                    }
                    this.m += width + i4;
                    int b = Flow.this.b(constraintWidget, this.r);
                    if (this.d == null || this.f2124a < b) {
                        this.d = constraintWidget;
                        this.f2124a = b;
                        this.n = b;
                    }
                } else {
                    int a2 = Flow.this.a(constraintWidget, this.r);
                    int b2 = Flow.this.b(constraintWidget, this.r);
                    int i5 = Flow.this.ac;
                    if (constraintWidget.getVisibility() == 8) {
                        i5 = 0;
                    }
                    this.n += b2 + i5;
                    if (this.d == null || this.f2124a < a2) {
                        this.d = constraintWidget;
                        this.f2124a = a2;
                        this.m = a2;
                    }
                }
                i2 = i3 + 1;
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            int i = 0;
            if (this.f2125c == 0) {
                int a2 = Flow.this.a(constraintWidget, this.r);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.q++;
                    a2 = 0;
                }
                int i2 = Flow.this.ab;
                if (constraintWidget.getVisibility() == 8) {
                    i2 = 0;
                }
                this.m += a2 + i2;
                int b = Flow.this.b(constraintWidget, this.r);
                if (this.d == null || this.f2124a < b) {
                    this.d = constraintWidget;
                    this.f2124a = b;
                    this.n = b;
                }
            } else {
                int a3 = Flow.this.a(constraintWidget, this.r);
                int b2 = Flow.this.b(constraintWidget, this.r);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.q++;
                    b2 = 0;
                }
                int i3 = Flow.this.ac;
                if (constraintWidget.getVisibility() != 8) {
                    i = i3;
                }
                this.n += b2 + i;
                if (this.d == null || this.f2124a < a3) {
                    this.d = constraintWidget;
                    this.f2124a = a3;
                    this.m = a3;
                }
            }
            this.p++;
        }

        public void clear() {
            this.f2124a = 0;
            this.d = null;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:237:0x06fb A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x01da  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void createConstraints(boolean r6, int r7, boolean r8) {
            /*
                Method dump skipped, instructions count: 1788
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.WidgetsList.createConstraints(boolean, int, boolean):void");
        }

        public int getHeight() {
            return this.f2125c == 1 ? this.n - Flow.this.ac : this.n;
        }

        public int getWidth() {
            return this.f2125c == 0 ? this.m - Flow.this.ab : this.m;
        }

        public void measureMatchConstraints(int i) {
            int i2 = this.q;
            if (i2 == 0) {
                return;
            }
            int i3 = this.p;
            int i4 = i / i2;
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= i3 || this.o + i6 >= Flow.this.an) {
                    break;
                }
                ConstraintWidget constraintWidget = Flow.this.am[this.o + i6];
                if (this.f2125c == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.a(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    Flow.this.a(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i4);
                }
                i5 = i6 + 1;
            }
            a();
        }

        public void setStartIndex(int i) {
            this.o = i;
        }

        public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i2, int i3, int i4, int i5, int i6) {
            this.f2125c = i;
            this.e = constraintAnchor;
            this.f = constraintAnchor2;
            this.g = constraintAnchor3;
            this.h = constraintAnchor4;
            this.i = i2;
            this.j = i3;
            this.k = i4;
            this.l = i5;
            this.r = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int a(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.mMatchConstraintDefaultWidth == 0) {
                return 0;
            }
            if (constraintWidget.mMatchConstraintDefaultWidth == 2) {
                int i2 = (int) (constraintWidget.mMatchConstraintPercentWidth * i);
                if (i2 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    a(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i2, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i2;
            } else if (constraintWidget.mMatchConstraintDefaultWidth == 1) {
                return constraintWidget.getWidth();
            } else {
                if (constraintWidget.mMatchConstraintDefaultWidth == 3) {
                    return (int) ((constraintWidget.getHeight() * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getWidth();
    }

    private void a(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        WidgetsList widgetsList;
        int paddingRight;
        int i5;
        int paddingBottom;
        WidgetsList widgetsList2;
        if (i == 0) {
            return;
        }
        this.ai.clear();
        WidgetsList widgetsList3 = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
        this.ai.add(widgetsList3);
        if (i2 != 0) {
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            while (true) {
                i4 = i6;
                if (i8 >= i) {
                    break;
                }
                ConstraintWidget constraintWidget = constraintWidgetArr[i8];
                int b = b(constraintWidget, i3);
                int i9 = i6;
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i9 = i6 + 1;
                }
                boolean z = (i7 == i3 || (this.ac + i7) + b > i3) && widgetsList3.d != null;
                boolean z2 = z;
                if (!z) {
                    z2 = z;
                    if (i8 > 0) {
                        int i10 = this.ag;
                        z2 = z;
                        if (i10 > 0) {
                            z2 = z;
                            if (i8 % i10 == 0) {
                                z2 = true;
                            }
                        }
                    }
                }
                if (z2) {
                    widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                    widgetsList.setStartIndex(i8);
                    this.ai.add(widgetsList);
                } else {
                    widgetsList = widgetsList3;
                    if (i8 > 0) {
                        i7 += this.ac + b;
                        widgetsList3.add(constraintWidget);
                        i8++;
                        i6 = i9;
                    }
                }
                i7 = b;
                widgetsList3 = widgetsList;
                widgetsList3.add(constraintWidget);
                i8++;
                i6 = i9;
            }
        } else {
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                i4 = i11;
                if (i13 >= i) {
                    break;
                }
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i13];
                int a2 = a(constraintWidget2, i3);
                int i14 = i11;
                if (constraintWidget2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i14 = i11 + 1;
                }
                boolean z3 = (i12 == i3 || (this.ab + i12) + a2 > i3) && widgetsList3.d != null;
                boolean z4 = z3;
                if (!z3) {
                    z4 = z3;
                    if (i13 > 0) {
                        int i15 = this.ag;
                        z4 = z3;
                        if (i15 > 0) {
                            z4 = z3;
                            if (i13 % i15 == 0) {
                                z4 = true;
                            }
                        }
                    }
                }
                if (z4) {
                    widgetsList2 = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                    widgetsList2.setStartIndex(i13);
                    this.ai.add(widgetsList2);
                } else {
                    widgetsList2 = widgetsList3;
                    if (i13 > 0) {
                        i12 += this.ab + a2;
                        widgetsList3.add(constraintWidget2);
                        i13++;
                        i11 = i14;
                    }
                }
                i12 = a2;
                widgetsList3 = widgetsList2;
                widgetsList3.add(constraintWidget2);
                i13++;
                i11 = i14;
            }
        }
        int size = this.ai.size();
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = this.mTop;
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight2 = getPaddingRight();
        int paddingBottom2 = getPaddingBottom();
        boolean z5 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i4 > 0 && z5) {
            int i16 = 0;
            while (true) {
                int i17 = i16;
                if (i17 >= size) {
                    break;
                }
                WidgetsList widgetsList4 = this.ai.get(i17);
                if (i2 == 0) {
                    widgetsList4.measureMatchConstraints(i3 - widgetsList4.getWidth());
                } else {
                    widgetsList4.measureMatchConstraints(i3 - widgetsList4.getHeight());
                }
                i16 = i17 + 1;
            }
        }
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        while (i20 < size) {
            WidgetsList widgetsList5 = this.ai.get(i20);
            if (i2 == 0) {
                if (i20 < size - 1) {
                    constraintAnchor4 = this.ai.get(i20 + 1).d.mTop;
                    paddingBottom = 0;
                } else {
                    constraintAnchor4 = this.mBottom;
                    paddingBottom = getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor5 = widgetsList5.d.mBottom;
                widgetsList5.setup(i2, constraintAnchor, constraintAnchor2, constraintAnchor3, constraintAnchor4, paddingLeft, paddingTop, paddingRight2, paddingBottom, i3);
                int max = Math.max(i19, widgetsList5.getWidth());
                int height = i18 + widgetsList5.getHeight();
                i18 = height;
                if (i20 > 0) {
                    i18 = height + this.ac;
                }
                constraintAnchor2 = constraintAnchor5;
                paddingBottom2 = paddingBottom;
                i5 = max;
                paddingTop = 0;
            } else {
                int i21 = i20;
                if (i21 < size - 1) {
                    constraintAnchor3 = this.ai.get(i21 + 1).d.mLeft;
                    paddingRight = 0;
                } else {
                    constraintAnchor3 = this.mRight;
                    paddingRight = getPaddingRight();
                }
                ConstraintAnchor constraintAnchor6 = widgetsList5.d.mRight;
                widgetsList5.setup(i2, constraintAnchor, constraintAnchor2, constraintAnchor3, constraintAnchor4, paddingLeft, paddingTop, paddingRight, paddingBottom2, i3);
                int width = i19 + widgetsList5.getWidth();
                int max2 = Math.max(i18, widgetsList5.getHeight());
                int i22 = width;
                if (i21 > 0) {
                    i22 = width + this.ab;
                }
                paddingRight2 = paddingRight;
                constraintAnchor = constraintAnchor6;
                i5 = i22;
                i18 = max2;
                paddingLeft = 0;
            }
            i20++;
            i19 = i5;
        }
        iArr[0] = i19;
        iArr[1] = i18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.mMatchConstraintDefaultHeight == 0) {
                return 0;
            }
            if (constraintWidget.mMatchConstraintDefaultHeight == 2) {
                int i2 = (int) (constraintWidget.mMatchConstraintPercentHeight * i);
                if (i2 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    a(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i2);
                }
                return i2;
            } else if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
                return constraintWidget.getHeight();
            } else {
                if (constraintWidget.mMatchConstraintDefaultHeight == 3) {
                    return (int) ((constraintWidget.getWidth() * constraintWidget.mDimensionRatio) + 0.5f);
                }
            }
        }
        return constraintWidget.getHeight();
    }

    private void b(boolean z) {
        ConstraintWidget constraintWidget;
        int i;
        if (this.al == null || this.ak == null || this.aj == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.an) {
                break;
            }
            this.am[i3].resetAnchors();
            i2 = i3 + 1;
        }
        int[] iArr = this.al;
        int i4 = iArr[0];
        int i5 = iArr[1];
        ConstraintWidget constraintWidget2 = null;
        float f = this.V;
        int i6 = 0;
        while (i6 < i4) {
            if (z) {
                i = (i4 - i6) - 1;
                f = 1.0f - this.V;
            } else {
                i = i6;
            }
            ConstraintWidget constraintWidget3 = this.ak[i];
            ConstraintWidget constraintWidget4 = constraintWidget2;
            if (constraintWidget3 != null) {
                if (constraintWidget3.getVisibility() == 8) {
                    constraintWidget4 = constraintWidget2;
                } else {
                    if (i6 == 0) {
                        constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                        constraintWidget3.setHorizontalChainStyle(this.P);
                        constraintWidget3.setHorizontalBiasPercent(f);
                    }
                    if (i6 == i4 - 1) {
                        constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                    }
                    if (i6 > 0 && constraintWidget2 != null) {
                        constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.ab);
                        constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                    }
                    constraintWidget4 = constraintWidget3;
                }
            }
            i6++;
            constraintWidget2 = constraintWidget4;
        }
        int i7 = 0;
        while (i7 < i5) {
            ConstraintWidget constraintWidget5 = this.aj[i7];
            ConstraintWidget constraintWidget6 = constraintWidget2;
            if (constraintWidget5 != null) {
                if (constraintWidget5.getVisibility() == 8) {
                    constraintWidget6 = constraintWidget2;
                } else {
                    if (i7 == 0) {
                        constraintWidget5.connect(constraintWidget5.mTop, this.mTop, getPaddingTop());
                        constraintWidget5.setVerticalChainStyle(this.Q);
                        constraintWidget5.setVerticalBiasPercent(this.W);
                    }
                    if (i7 == i5 - 1) {
                        constraintWidget5.connect(constraintWidget5.mBottom, this.mBottom, getPaddingBottom());
                    }
                    if (i7 > 0 && constraintWidget2 != null) {
                        constraintWidget5.connect(constraintWidget5.mTop, constraintWidget2.mBottom, this.ac);
                        constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget5.mTop, 0);
                    }
                    constraintWidget6 = constraintWidget5;
                }
            }
            i7++;
            constraintWidget2 = constraintWidget6;
        }
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= i4) {
                return;
            }
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 < i5) {
                    int i12 = (i11 * i4) + i9;
                    if (this.ah == 1) {
                        i12 = (i9 * i5) + i11;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.am;
                    if (i12 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i12]) != null && constraintWidget.getVisibility() != 8) {
                        ConstraintWidget constraintWidget7 = this.ak[i9];
                        ConstraintWidget constraintWidget8 = this.aj[i11];
                        if (constraintWidget != constraintWidget7) {
                            constraintWidget.connect(constraintWidget.mLeft, constraintWidget7.mLeft, 0);
                            constraintWidget.connect(constraintWidget.mRight, constraintWidget7.mRight, 0);
                        }
                        if (constraintWidget != constraintWidget8) {
                            constraintWidget.connect(constraintWidget.mTop, constraintWidget8.mTop, 0);
                            constraintWidget.connect(constraintWidget.mBottom, constraintWidget8.mBottom, 0);
                        }
                    }
                    i10 = i11 + 1;
                }
            }
            i8 = i9 + 1;
        }
    }

    private void b(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        WidgetsList widgetsList;
        int i5;
        int paddingRight;
        int i6;
        int paddingBottom;
        int i7;
        if (i == 0) {
            return;
        }
        this.ai.clear();
        WidgetsList widgetsList2 = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
        this.ai.add(widgetsList2);
        if (i2 != 0) {
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                i4 = i9;
                if (i10 >= i) {
                    break;
                }
                ConstraintWidget constraintWidget = constraintWidgetArr[i10];
                int b = b(constraintWidget, i3);
                int i11 = i9;
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11 = i9 + 1;
                }
                boolean z = (i8 == i3 || (this.ac + i8) + b > i3) && widgetsList2.d != null;
                boolean z2 = z;
                if (!z) {
                    z2 = z;
                    if (i10 > 0) {
                        int i12 = this.ag;
                        z2 = z;
                        if (i12 > 0) {
                            z2 = z;
                            if (i12 < 0) {
                                z2 = true;
                            }
                        }
                    }
                }
                if (z2) {
                    widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                    widgetsList.setStartIndex(i10);
                    this.ai.add(widgetsList);
                } else {
                    widgetsList = widgetsList2;
                    if (i10 > 0) {
                        i5 = i8 + this.ac + b;
                        widgetsList2.add(constraintWidget);
                        i10++;
                        i8 = i5;
                        i9 = i11;
                    }
                }
                i5 = b;
                widgetsList2 = widgetsList;
                widgetsList2.add(constraintWidget);
                i10++;
                i8 = i5;
                i9 = i11;
            }
        } else {
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            while (true) {
                i4 = i14;
                if (i16 >= i) {
                    break;
                }
                int i17 = i13 + 1;
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i16];
                int a2 = a(constraintWidget2, i3);
                int i18 = i14;
                if (constraintWidget2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i18 = i14 + 1;
                }
                boolean z3 = (i15 == i3 || (this.ab + i15) + a2 > i3) && widgetsList2.d != null;
                boolean z4 = z3;
                if (!z3) {
                    z4 = z3;
                    if (i16 > 0) {
                        int i19 = this.ag;
                        z4 = z3;
                        if (i19 > 0) {
                            z4 = z3;
                            if (i17 > i19) {
                                z4 = true;
                            }
                        }
                    }
                }
                if (z4) {
                    widgetsList2 = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
                    widgetsList2.setStartIndex(i16);
                    this.ai.add(widgetsList2);
                    i7 = i17;
                    i15 = a2;
                } else {
                    i15 = i16 > 0 ? i15 + this.ab + a2 : a2;
                    i7 = 0;
                }
                widgetsList2.add(constraintWidget2);
                i16++;
                i13 = i7;
                i14 = i18;
            }
        }
        int size = this.ai.size();
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = this.mTop;
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight2 = getPaddingRight();
        int paddingBottom2 = getPaddingBottom();
        boolean z5 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i4 > 0 && z5) {
            int i20 = 0;
            while (true) {
                int i21 = i20;
                if (i21 >= size) {
                    break;
                }
                WidgetsList widgetsList3 = this.ai.get(i21);
                if (i2 == 0) {
                    widgetsList3.measureMatchConstraints(i3 - widgetsList3.getWidth());
                } else {
                    widgetsList3.measureMatchConstraints(i3 - widgetsList3.getHeight());
                }
                i20 = i21 + 1;
            }
        }
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i24 < size) {
            WidgetsList widgetsList4 = this.ai.get(i24);
            if (i2 == 0) {
                if (i24 < size - 1) {
                    constraintAnchor4 = this.ai.get(i24 + 1).d.mTop;
                    paddingBottom = 0;
                } else {
                    constraintAnchor4 = this.mBottom;
                    paddingBottom = getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor5 = widgetsList4.d.mBottom;
                widgetsList4.setup(i2, constraintAnchor, constraintAnchor2, constraintAnchor3, constraintAnchor4, paddingLeft, paddingTop, paddingRight2, paddingBottom, i3);
                int max = Math.max(i23, widgetsList4.getWidth());
                int height = i22 + widgetsList4.getHeight();
                i22 = height;
                if (i24 > 0) {
                    i22 = height + this.ac;
                }
                constraintAnchor2 = constraintAnchor5;
                paddingBottom2 = paddingBottom;
                i6 = max;
                paddingTop = 0;
            } else {
                int i25 = i24;
                if (i25 < size - 1) {
                    constraintAnchor3 = this.ai.get(i25 + 1).d.mLeft;
                    paddingRight = 0;
                } else {
                    constraintAnchor3 = this.mRight;
                    paddingRight = getPaddingRight();
                }
                ConstraintAnchor constraintAnchor6 = widgetsList4.d.mRight;
                widgetsList4.setup(i2, constraintAnchor, constraintAnchor2, constraintAnchor3, constraintAnchor4, paddingLeft, paddingTop, paddingRight, paddingBottom2, i3);
                int width = i23 + widgetsList4.getWidth();
                int max2 = Math.max(i22, widgetsList4.getHeight());
                int i26 = width;
                if (i25 > 0) {
                    i26 = width + this.ab;
                }
                paddingRight2 = paddingRight;
                constraintAnchor = constraintAnchor6;
                i6 = i26;
                i22 = max2;
                paddingLeft = 0;
            }
            i24++;
            i23 = i6;
        }
        iArr[0] = i23;
        iArr[1] = i22;
    }

    private void c(ConstraintWidget[] constraintWidgetArr, int i, int i2, int i3, int[] iArr) {
        WidgetsList widgetsList;
        if (i == 0) {
            return;
        }
        if (this.ai.size() == 0) {
            widgetsList = new WidgetsList(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, i3);
            this.ai.add(widgetsList);
        } else {
            widgetsList = this.ai.get(0);
            widgetsList.clear();
            widgetsList.setup(i2, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i3);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i) {
                iArr[0] = widgetsList.getWidth();
                iArr[1] = widgetsList.getHeight();
                return;
            }
            widgetsList.add(constraintWidgetArr[i5]);
            i4 = i5 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0112, code lost:
        if (r8 != 1) goto L133;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x0312 -> B:50:0x0126). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:124:0x0320 -> B:50:0x0126). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x0338 -> B:50:0x0126). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:129:0x0346 -> B:50:0x0126). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(androidx.constraintlayout.core.widgets.ConstraintWidget[] r6, int r7, int r8, int r9, int[] r10) {
        /*
            Method dump skipped, instructions count: 866
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.d(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        boolean z2 = getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl();
        int i = this.af;
        if (i != 0) {
            if (i == 1) {
                int size = this.ai.size();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= size) {
                        break;
                    }
                    this.ai.get(i3).createConstraints(z2, i3, i3 == size - 1);
                    i2 = i3 + 1;
                }
            } else if (i == 2) {
                b(z2);
            } else if (i == 3) {
                int size2 = this.ai.size();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= size2) {
                        break;
                    }
                    this.ai.get(i5).createConstraints(z2, i5, i5 == size2 - 1);
                    i4 = i5 + 1;
                }
            }
        } else if (this.ai.size() > 0) {
            this.ai.get(0).createConstraints(z2, 0, true);
        }
        a(false);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.P = flow.P;
        this.Q = flow.Q;
        this.R = flow.R;
        this.S = flow.S;
        this.T = flow.T;
        this.U = flow.U;
        this.V = flow.V;
        this.W = flow.W;
        this.X = flow.X;
        this.Y = flow.Y;
        this.Z = flow.Z;
        this.aa = flow.aa;
        this.ab = flow.ab;
        this.ac = flow.ac;
        this.ad = flow.ad;
        this.ae = flow.ae;
        this.af = flow.af;
        this.ag = flow.ag;
        this.ah = flow.ah;
    }

    public float getMaxElementsWrap() {
        return this.ag;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (this.mWidgetsCount > 0 && !a()) {
            setMeasure(0, 0);
            a(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr = new int[2];
        int i7 = (i2 - paddingLeft) - paddingRight;
        if (this.ah == 1) {
            i7 = (i4 - paddingTop) - paddingBottom;
        }
        if (this.ah == 0) {
            if (this.P == -1) {
                this.P = 0;
            }
            if (this.Q == -1) {
                this.Q = 0;
            }
        } else {
            if (this.P == -1) {
                this.P = 0;
            }
            if (this.Q == -1) {
                this.Q = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i5 = i9;
            if (i8 >= this.mWidgetsCount) {
                break;
            }
            int i10 = i5;
            if (this.mWidgets[i8].getVisibility() == 8) {
                i10 = i5 + 1;
            }
            i8++;
            i9 = i10;
        }
        int i11 = this.mWidgetsCount;
        if (i5 > 0) {
            constraintWidgetArr = new ConstraintWidget[this.mWidgetsCount - i5];
            int i12 = 0;
            int i13 = 0;
            while (true) {
                i6 = i13;
                if (i12 >= this.mWidgetsCount) {
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i12];
                int i14 = i6;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr[i6] = constraintWidget;
                    i14 = i6 + 1;
                }
                i12++;
                i13 = i14;
            }
            i11 = i6;
        }
        this.am = constraintWidgetArr;
        this.an = i11;
        int i15 = this.af;
        if (i15 == 0) {
            c(constraintWidgetArr, i11, this.ah, i7, iArr);
        } else if (i15 == 1) {
            a(constraintWidgetArr, i11, this.ah, i7, iArr);
        } else if (i15 == 2) {
            d(constraintWidgetArr, i11, this.ah, i7, iArr);
        } else if (i15 == 3) {
            b(constraintWidgetArr, i11, this.ah, i7, iArr);
        }
        boolean z = true;
        int i16 = iArr[0] + paddingLeft + paddingRight;
        int i17 = iArr[1] + paddingTop + paddingBottom;
        int min = i == 1073741824 ? i2 : i == Integer.MIN_VALUE ? Math.min(i16, i2) : i == 0 ? i16 : 0;
        int min2 = i3 == 1073741824 ? i4 : i3 == Integer.MIN_VALUE ? Math.min(i17, i4) : i3 == 0 ? i17 : 0;
        setMeasure(min, min2);
        setWidth(min);
        setHeight(min2);
        if (this.mWidgetsCount <= 0) {
            z = false;
        }
        a(z);
    }

    public void setFirstHorizontalBias(float f) {
        this.X = f;
    }

    public void setFirstHorizontalStyle(int i) {
        this.R = i;
    }

    public void setFirstVerticalBias(float f) {
        this.Y = f;
    }

    public void setFirstVerticalStyle(int i) {
        this.S = i;
    }

    public void setHorizontalAlign(int i) {
        this.ad = i;
    }

    public void setHorizontalBias(float f) {
        this.V = f;
    }

    public void setHorizontalGap(int i) {
        this.ab = i;
    }

    public void setHorizontalStyle(int i) {
        this.P = i;
    }

    public void setLastHorizontalBias(float f) {
        this.Z = f;
    }

    public void setLastHorizontalStyle(int i) {
        this.T = i;
    }

    public void setLastVerticalBias(float f) {
        this.aa = f;
    }

    public void setLastVerticalStyle(int i) {
        this.U = i;
    }

    public void setMaxElementsWrap(int i) {
        this.ag = i;
    }

    public void setOrientation(int i) {
        this.ah = i;
    }

    public void setVerticalAlign(int i) {
        this.ae = i;
    }

    public void setVerticalBias(float f) {
        this.W = f;
    }

    public void setVerticalGap(int i) {
        this.ac = i;
    }

    public void setVerticalStyle(int i) {
        this.Q = i;
    }

    public void setWrapMode(int i) {
        this.af = i;
    }
}
