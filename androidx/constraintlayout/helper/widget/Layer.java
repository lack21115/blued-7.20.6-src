package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/helper/widget/Layer.class */
public class Layer extends ConstraintHelper {

    /* renamed from: a  reason: collision with root package name */
    ConstraintLayout f2111a;
    protected float b;

    /* renamed from: c  reason: collision with root package name */
    protected float f2112c;
    protected float d;
    protected float e;
    protected float f;
    protected float g;
    boolean h;
    View[] i;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private boolean y;
    private boolean z;

    public Layer(Context context) {
        super(context);
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = 1.0f;
        this.v = 1.0f;
        this.b = Float.NaN;
        this.f2112c = Float.NaN;
        this.d = Float.NaN;
        this.e = Float.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = true;
        this.i = null;
        this.w = 0.0f;
        this.x = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = 1.0f;
        this.v = 1.0f;
        this.b = Float.NaN;
        this.f2112c = Float.NaN;
        this.d = Float.NaN;
        this.e = Float.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = true;
        this.i = null;
        this.w = 0.0f;
        this.x = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = 1.0f;
        this.v = 1.0f;
        this.b = Float.NaN;
        this.f2112c = Float.NaN;
        this.d = Float.NaN;
        this.e = Float.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = true;
        this.i = null;
        this.w = 0.0f;
        this.x = 0.0f;
    }

    private void c() {
        if (this.f2111a == null || this.k == 0) {
            return;
        }
        View[] viewArr = this.i;
        if (viewArr == null || viewArr.length != this.k) {
            this.i = new View[this.k];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                return;
            }
            this.i[i2] = this.f2111a.getViewById(this.j[i2]);
            i = i2 + 1;
        }
    }

    private void d() {
        if (this.f2111a == null) {
            return;
        }
        if (this.i == null) {
            c();
        }
        a();
        double radians = Float.isNaN(this.t) ? 0.0d : Math.toRadians(this.t);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f = this.u;
        float f2 = this.v;
        float f3 = -f2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                return;
            }
            View view = this.i[i2];
            int left = (view.getLeft() + view.getRight()) / 2;
            int top = (view.getTop() + view.getBottom()) / 2;
            float f4 = left - this.b;
            float f5 = top - this.f2112c;
            float f6 = this.w;
            float f7 = this.x;
            view.setTranslationX(((((f * cos) * f4) + ((f3 * sin) * f5)) - f4) + f6);
            view.setTranslationY((((f4 * (f * sin)) + ((f2 * cos) * f5)) - f5) + f7);
            view.setScaleY(this.v);
            view.setScaleX(this.u);
            if (!Float.isNaN(this.t)) {
                view.setRotation(this.t);
            }
            i = i2 + 1;
        }
    }

    protected void a() {
        if (this.f2111a == null) {
            return;
        }
        if (this.h || Float.isNaN(this.b) || Float.isNaN(this.f2112c)) {
            if (!Float.isNaN(this.r) && !Float.isNaN(this.s)) {
                this.f2112c = this.s;
                this.b = this.r;
                return;
            }
            View[] c2 = c(this.f2111a);
            int left = c2[0].getLeft();
            int top = c2[0].getTop();
            int right = c2[0].getRight();
            int bottom = c2[0].getBottom();
            for (int i = 0; i < this.k; i++) {
                View view = c2[i];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.d = right;
            this.e = bottom;
            this.f = left;
            this.g = top;
            if (Float.isNaN(this.r)) {
                this.b = (left + right) / 2;
            } else {
                this.b = this.r;
            }
            if (Float.isNaN(this.s)) {
                this.f2112c = (top + bottom) / 2;
            } else {
                this.f2112c = this.s;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.n = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.y = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.z = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void a(ConstraintLayout constraintLayout) {
        b(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2111a = (ConstraintLayout) getParent();
        if (!this.y && !this.z) {
            return;
        }
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                return;
            }
            View viewById = this.f2111a.getViewById(this.j[i2]);
            if (viewById != null) {
                if (this.y) {
                    viewById.setVisibility(visibility);
                }
                if (this.z && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        b();
    }

    @Override // android.view.View
    public void setPivotX(float f) {
        this.r = f;
        d();
    }

    @Override // android.view.View
    public void setPivotY(float f) {
        this.s = f;
        d();
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.t = f;
        d();
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        this.u = f;
        d();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        this.v = f;
        d();
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        this.w = f;
        d();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        this.x = f;
        d();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        b();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePostLayout(ConstraintLayout constraintLayout) {
        c();
        this.b = Float.NaN;
        this.f2112c = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).getConstraintWidget();
        constraintWidget.setWidth(0);
        constraintWidget.setHeight(0);
        a();
        layout(((int) this.f) - getPaddingLeft(), ((int) this.g) - getPaddingTop(), ((int) this.d) + getPaddingRight(), ((int) this.e) + getPaddingBottom());
        d();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void updatePreDraw(ConstraintLayout constraintLayout) {
        this.f2111a = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.t = rotation;
        } else if (Float.isNaN(this.t)) {
        } else {
            this.t = rotation;
        }
    }
}
