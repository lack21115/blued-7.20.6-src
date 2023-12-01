package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import com.alipay.sdk.util.i;
import com.android.internal.R;

@RemoteViews.RemoteView
@Deprecated
/* loaded from: source-4181928-dex2jar.jar:android/widget/AbsoluteLayout.class */
public class AbsoluteLayout extends ViewGroup {

    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsoluteLayout$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int x;
        public int y;

        public LayoutParams(int i, int i2, int i3, int i4) {
            super(i, i2);
            this.x = i3;
            this.y = i4;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AbsoluteLayout_Layout);
            this.x = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
            this.y = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @Override // android.view.ViewGroup.LayoutParams
        public String debug(String str) {
            return str + "Absolute.LayoutParams={width=" + sizeToString(this.width) + ", height=" + sizeToString(this.height) + " x=" + this.x + " y=" + this.y + i.d;
        }
    }

    public AbsoluteLayout(Context context) {
        this(context, null);
    }

    public AbsoluteLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsoluteLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public AbsoluteLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 0, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= childCount) {
                return;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i7 = this.mPaddingLeft + layoutParams.x;
                int i8 = this.mPaddingTop + layoutParams.y;
                childAt.layout(i7, i8, childAt.getMeasuredWidth() + i7, childAt.getMeasuredHeight() + i8);
            }
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        measureChildren(i, i2);
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            int i6 = i3;
            int i7 = i4;
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i8 = layoutParams.x;
                int measuredWidth = childAt.getMeasuredWidth();
                int i9 = layoutParams.y;
                int measuredHeight = childAt.getMeasuredHeight();
                i7 = Math.max(i4, i8 + measuredWidth);
                i6 = Math.max(i3, i9 + measuredHeight);
            }
            i5++;
            i3 = i6;
            i4 = i7;
        }
        setMeasuredDimension(resolveSizeAndState(Math.max(i4 + this.mPaddingLeft + this.mPaddingRight, getSuggestedMinimumWidth()), i, 0), resolveSizeAndState(Math.max(i3 + this.mPaddingTop + this.mPaddingBottom, getSuggestedMinimumHeight()), i2, 0));
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
