package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/widget/VirtualLayout.class */
public abstract class VirtualLayout extends ConstraintHelper {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2243a;
    private boolean b;

    public VirtualLayout(Context context) {
        super(context);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                obtainStyledAttributes.recycle();
                return;
            }
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                this.f2243a = true;
            } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                this.b = true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void a(ConstraintLayout constraintLayout) {
        b(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.f2243a && !this.b) {
            return;
        }
        ViewParent parent = getParent();
        if (!(parent instanceof ConstraintLayout)) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k) {
                return;
            }
            View viewById = constraintLayout.getViewById(this.j[i2]);
            if (viewById != null) {
                if (this.f2243a) {
                    viewById.setVisibility(visibility);
                }
                if (this.b && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
            i = i2 + 1;
        }
    }

    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i, int i2) {
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        b();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        b();
    }
}
