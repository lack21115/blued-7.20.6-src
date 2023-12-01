package com.soft.blued.ui.find.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/ExpandLinearLayout.class */
public final class ExpandLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f30677a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f30678c;
    private float d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandLinearLayout(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        Intrinsics.e(attributeSet, "attributeSet");
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        Intrinsics.e(attributeSet, "attributeSet");
        c();
    }

    private final void c() {
        setOrientation(1);
        setAnimPercent(1.0f);
    }

    private final void d() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "animPercent", 0.0f, 1.0f);
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    private final void setAnimPercent(float f) {
        this.d = f;
        requestLayout();
    }

    public final boolean a() {
        return this.f30677a;
    }

    public final boolean b() {
        this.f30677a = !this.f30677a;
        d();
        return this.f30677a;
    }

    public final int getShowItemHeight() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        this.f30678c = 0;
        if (getChildCount() > 0) {
            int childCount = getChildCount();
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i6);
                Intrinsics.c(childAt, "getChildAt(index)");
                if (!(childAt.getVisibility() == 8)) {
                    int i7 = this.f30678c;
                    int measuredHeight = getChildAt(i6).getMeasuredHeight();
                    View childAt2 = getChildAt(i6);
                    Intrinsics.c(childAt2, "getChildAt(index)");
                    ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    int i8 = marginLayoutParams == null ? 0 : marginLayoutParams.topMargin;
                    View childAt3 = getChildAt(i6);
                    Intrinsics.c(childAt3, "getChildAt(index)");
                    ViewGroup.LayoutParams layoutParams2 = childAt3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = null;
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                    }
                    this.f30678c = i7 + measuredHeight + i8 + (marginLayoutParams2 == null ? 0 : marginLayoutParams2.bottomMargin);
                    if (i6 == getChildCount() - 1) {
                        this.f30678c += getPaddingTop() + getPaddingBottom();
                    }
                }
                i5 = i6 + 1;
            }
            if (this.f30677a) {
                setMeasuredDimension(i, this.b + ((int) ((this.f30678c - i4) * this.d)));
                return;
            }
            setMeasuredDimension(i, this.f30678c - ((int) ((i3 - this.b) * this.d)));
        }
    }

    public final void setOpen(boolean z) {
        this.f30677a = z;
    }

    public final void setShowItemHeight(int i) {
        this.b = i;
    }
}
