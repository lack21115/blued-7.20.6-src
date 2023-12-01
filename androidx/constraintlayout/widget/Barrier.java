package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/Barrier.class */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;

    /* renamed from: a  reason: collision with root package name */
    private int f2199a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.constraintlayout.core.widgets.Barrier f2200c;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }

    private void a(ConstraintWidget constraintWidget, int i, boolean z) {
        this.b = i;
        if (Build.VERSION.SDK_INT < 17) {
            int i2 = this.f2199a;
            if (i2 == 5) {
                this.b = 0;
            } else if (i2 == 6) {
                this.b = 1;
            }
        } else if (z) {
            int i3 = this.f2199a;
            if (i3 == 5) {
                this.b = 1;
            } else if (i3 == 6) {
                this.b = 0;
            }
        } else {
            int i4 = this.f2199a;
            if (i4 == 5) {
                this.b = 0;
            } else if (i4 == 6) {
                this.b = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            ((androidx.constraintlayout.core.widgets.Barrier) constraintWidget).setBarrierType(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f2200c = new androidx.constraintlayout.core.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    break;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f2200c.setAllowsGoneWidget(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f2200c.setMargin(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
                i = i2 + 1;
            }
            obtainStyledAttributes.recycle();
        }
        this.m = this.f2200c;
        validateParams();
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.f2200c.getAllowsGoneWidget();
    }

    public boolean getAllowsGoneWidget() {
        return this.f2200c.getAllowsGoneWidget();
    }

    public int getMargin() {
        return this.f2200c.getMargin();
    }

    public int getType() {
        return this.f2199a;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.loadParameters(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            androidx.constraintlayout.core.widgets.Barrier barrier = (androidx.constraintlayout.core.widgets.Barrier) helperWidget;
            a(barrier, constraint.layout.mBarrierDirection, ((ConstraintWidgetContainer) helperWidget.getParent()).isRtl());
            barrier.setAllowsGoneWidget(constraint.layout.mBarrierAllowsGoneWidgets);
            barrier.setMargin(constraint.layout.mBarrierMargin);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
        a(constraintWidget, this.f2199a, z);
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f2200c.setAllowsGoneWidget(z);
    }

    public void setDpMargin(int i) {
        this.f2200c.setMargin((int) ((i * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i) {
        this.f2200c.setMargin(i);
    }

    public void setType(int i) {
        this.f2199a = i;
    }
}
