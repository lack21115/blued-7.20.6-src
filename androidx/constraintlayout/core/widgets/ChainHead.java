package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/widgets/ChainHead.class */
public class ChainHead {

    /* renamed from: a  reason: collision with root package name */
    protected ConstraintWidget f2065a;
    protected ConstraintWidget b;

    /* renamed from: c  reason: collision with root package name */
    protected ConstraintWidget f2066c;
    protected ConstraintWidget d;
    protected ConstraintWidget e;
    protected ConstraintWidget f;
    protected ConstraintWidget g;
    protected ArrayList<ConstraintWidget> h;
    protected int i;
    protected int j;
    protected float k = 0.0f;
    int l;
    int m;
    int n;
    boolean o;
    protected boolean p;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    private int t;
    private boolean u;
    private boolean v;

    public ChainHead(ConstraintWidget constraintWidget, int i, boolean z) {
        this.u = false;
        this.f2065a = constraintWidget;
        this.t = i;
        this.u = z;
    }

    private void a() {
        int i = this.t * 2;
        ConstraintWidget constraintWidget = this.f2065a;
        boolean z = true;
        this.o = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z2 = false;
        while (!z2) {
            this.i++;
            constraintWidget.L[this.t] = null;
            constraintWidget.K[this.t] = null;
            if (constraintWidget.getVisibility() != 8) {
                this.l++;
                if (constraintWidget.getDimensionBehaviour(this.t) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.m += constraintWidget.getLength(this.t);
                }
                int margin = this.m + constraintWidget.mListAnchors[i].getMargin();
                this.m = margin;
                int i2 = i + 1;
                this.m = margin + constraintWidget.mListAnchors[i2].getMargin();
                int margin2 = this.n + constraintWidget.mListAnchors[i].getMargin();
                this.n = margin2;
                this.n = margin2 + constraintWidget.mListAnchors[i2].getMargin();
                if (this.b == null) {
                    this.b = constraintWidget;
                }
                this.d = constraintWidget;
                if (constraintWidget.mListDimensionBehaviors[this.t] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    if (constraintWidget.mResolvedMatchConstraintDefault[this.t] == 0 || constraintWidget.mResolvedMatchConstraintDefault[this.t] == 3 || constraintWidget.mResolvedMatchConstraintDefault[this.t] == 2) {
                        this.j++;
                        float f = constraintWidget.mWeight[this.t];
                        if (f > 0.0f) {
                            this.k += constraintWidget.mWeight[this.t];
                        }
                        if (a(constraintWidget, this.t)) {
                            if (f < 0.0f) {
                                this.p = true;
                            } else {
                                this.q = true;
                            }
                            if (this.h == null) {
                                this.h = new ArrayList<>();
                            }
                            this.h.add(constraintWidget);
                        }
                        if (this.f == null) {
                            this.f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget3 = this.g;
                        if (constraintWidget3 != null) {
                            constraintWidget3.K[this.t] = constraintWidget;
                        }
                        this.g = constraintWidget;
                    }
                    if (this.t == 0) {
                        if (constraintWidget.mMatchConstraintDefaultWidth != 0) {
                            this.o = false;
                        } else if (constraintWidget.mMatchConstraintMinWidth != 0 || constraintWidget.mMatchConstraintMaxWidth != 0) {
                            this.o = false;
                        }
                    } else if (constraintWidget.mMatchConstraintDefaultHeight != 0) {
                        this.o = false;
                    } else if (constraintWidget.mMatchConstraintMinHeight != 0 || constraintWidget.mMatchConstraintMaxHeight != 0) {
                        this.o = false;
                    }
                    if (constraintWidget.mDimensionRatio != 0.0f) {
                        this.o = false;
                        this.s = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.L[this.t] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i + 1].mTarget;
            ConstraintWidget constraintWidget4 = null;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.mOwner;
                constraintWidget4 = null;
                if (constraintWidget5.mListAnchors[i].mTarget != null) {
                    constraintWidget4 = constraintWidget5.mListAnchors[i].mTarget.mOwner != constraintWidget ? null : constraintWidget5;
                }
            }
            if (constraintWidget4 == null) {
                constraintWidget4 = constraintWidget;
                z2 = true;
            }
            ConstraintWidget constraintWidget6 = constraintWidget;
            constraintWidget = constraintWidget4;
            constraintWidget2 = constraintWidget6;
        }
        ConstraintWidget constraintWidget7 = this.b;
        if (constraintWidget7 != null) {
            this.m -= constraintWidget7.mListAnchors[i].getMargin();
        }
        ConstraintWidget constraintWidget8 = this.d;
        if (constraintWidget8 != null) {
            this.m -= constraintWidget8.mListAnchors[i + 1].getMargin();
        }
        this.f2066c = constraintWidget;
        if (this.t == 0 && this.u) {
            this.e = constraintWidget;
        } else {
            this.e = this.f2065a;
        }
        if (!this.q || !this.p) {
            z = false;
        }
        this.r = z;
    }

    private static boolean a(ConstraintWidget constraintWidget, int i) {
        if (constraintWidget.getVisibility() == 8 || constraintWidget.mListDimensionBehaviors[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        return constraintWidget.mResolvedMatchConstraintDefault[i] == 0 || constraintWidget.mResolvedMatchConstraintDefault[i] == 3;
    }

    public void define() {
        if (!this.v) {
            a();
        }
        this.v = true;
    }

    public ConstraintWidget getFirst() {
        return this.f2065a;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.f;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.b;
    }

    public ConstraintWidget getHead() {
        return this.e;
    }

    public ConstraintWidget getLast() {
        return this.f2066c;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.g;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.d;
    }

    public float getTotalWeight() {
        return this.k;
    }
}
