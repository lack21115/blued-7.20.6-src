package com.huawei.openalliance.ad.feedback;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.utils.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/feedback/FlowLayoutView.class */
public class FlowLayoutView extends ViewGroup {
    private c B;
    private int D;
    private int F;
    private int L;
    private int S;

    /* renamed from: a  reason: collision with root package name */
    private final List<c> f9361a;

    public FlowLayoutView(Context context) {
        this(context, null);
    }

    public FlowLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.D = 1;
        this.S = v.V(context, 8.0f);
        this.F = v.V(context, 8.0f);
        this.f9361a = new ArrayList();
        this.L = 0;
    }

    private void Code() {
        if (this.B == null) {
            this.B = new c();
        }
    }

    private void I() {
        int i = this.L;
        if (i > 0) {
            this.B.Code(i - this.S);
        }
        c cVar = this.B;
        if (cVar != null) {
            this.f9361a.add(cVar);
        }
        this.L = 0;
        this.B = new c();
    }

    private void V() {
        this.f9361a.clear();
        this.B = new c();
        this.L = 0;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth();
        Iterator<c> it = this.f9361a.iterator();
        int i5 = paddingTop;
        while (true) {
            int i6 = i5;
            if (!it.hasNext()) {
                return;
            }
            c next = it.next();
            next.Code(this.D, getLeft(), paddingLeft, i6, (measuredWidth - paddingLeft) - paddingTop, this.S);
            i5 = this.F + next.Code() + i6;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingBottom = getPaddingBottom();
        int paddingTop = getPaddingTop();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        V();
        Code();
        int childCount = getChildCount();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, mode == 1073741824 ? Integer.MIN_VALUE : mode);
            int i5 = Integer.MIN_VALUE;
            if (mode2 != 1073741824) {
                i5 = mode2;
            }
            childAt.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec((size2 - paddingBottom) - paddingTop, i5));
            int measuredWidth = childAt.getMeasuredWidth();
            if (this.L + measuredWidth > size) {
                I();
            }
            int i6 = this.L + this.S + measuredWidth;
            this.L = i6;
            this.B.Code(i6);
            this.B.Code(childAt);
            i3 = i4 + 1;
        }
        c cVar = this.B;
        if (cVar != null && !this.f9361a.contains(cVar)) {
            I();
        }
        Iterator<c> it = this.f9361a.iterator();
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (!it.hasNext()) {
                setMeasuredDimension(View.MeasureSpec.getSize(i), resolveSize(i8 + (this.F * (this.f9361a.size() - 1)) + getPaddingBottom() + getPaddingTop(), i2));
                return;
            }
            i7 = i8 + it.next().Code();
        }
    }

    public void setDefaultDisplayMode(int i) {
        this.D = i;
    }
}
