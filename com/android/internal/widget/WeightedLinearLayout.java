package com.android.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/WeightedLinearLayout.class */
public class WeightedLinearLayout extends LinearLayout {
    private float mMajorWeightMax;
    private float mMajorWeightMin;
    private float mMinorWeightMax;
    private float mMinorWeightMin;

    public WeightedLinearLayout(Context context) {
        super(context);
    }

    public WeightedLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WeightedLinearLayout);
        this.mMajorWeightMin = obtainStyledAttributes.getFloat(0, 0.0f);
        this.mMinorWeightMin = obtainStyledAttributes.getFloat(1, 0.0f);
        this.mMajorWeightMax = obtainStyledAttributes.getFloat(2, 0.0f);
        this.mMinorWeightMax = obtainStyledAttributes.getFloat(3, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        boolean z = i3 < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        float f = z ? this.mMinorWeightMin : this.mMajorWeightMin;
        float f2 = z ? this.mMinorWeightMax : this.mMajorWeightMax;
        boolean z2 = false;
        int i4 = makeMeasureSpec;
        if (mode == Integer.MIN_VALUE) {
            int i5 = (int) (i3 * f);
            int i6 = (int) (i3 * f);
            if (f <= 0.0f || measuredWidth >= i5) {
                z2 = false;
                i4 = makeMeasureSpec;
                if (f2 > 0.0f) {
                    z2 = false;
                    i4 = makeMeasureSpec;
                    if (measuredWidth > i6) {
                        i4 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                        z2 = true;
                    }
                }
            } else {
                i4 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                z2 = true;
            }
        }
        if (z2) {
            super.onMeasure(i4, i2);
        }
    }
}
