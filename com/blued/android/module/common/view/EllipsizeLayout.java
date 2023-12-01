package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/EllipsizeLayout.class */
public class EllipsizeLayout extends LinearLayout {
    public EllipsizeLayout(Context context) {
        this(context, null);
    }

    public EllipsizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (getOrientation() == 0 && View.MeasureSpec.getMode(i) == 1073741824) {
            TextView textView = null;
            int childCount = getChildCount();
            int i4 = 0;
            boolean z = false;
            int i5 = 0;
            while (true) {
                i3 = i5;
                if (i4 >= childCount || z) {
                    break;
                }
                View childAt = getChildAt(i4);
                TextView textView2 = textView;
                boolean z2 = z;
                int i6 = i3;
                if (childAt != null) {
                    textView2 = textView;
                    z2 = z;
                    i6 = i3;
                    if (childAt.getVisibility() != 8) {
                        textView2 = textView;
                        boolean z3 = z;
                        if (childAt instanceof TextView) {
                            TextView textView3 = (TextView) childAt;
                            textView2 = textView;
                            z3 = z;
                            if (textView3.getEllipsize() != null) {
                                if (textView == null) {
                                    textView3.setMaxWidth(Integer.MAX_VALUE);
                                    textView2 = textView3;
                                    z3 = z;
                                } else {
                                    z3 = true;
                                    textView2 = textView;
                                }
                            }
                        }
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                        z2 = z3 | (layoutParams.weight > 0.0f);
                        measureChildWithMargins(childAt, i, 0, i2, 0);
                        i6 = i3 + childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                    }
                }
                i4++;
                textView = textView2;
                z = z2;
                i5 = i6;
            }
            boolean z4 = true;
            if (textView != null) {
                z4 = i3 == 0;
            }
            int size = View.MeasureSpec.getSize(i);
            if (!(z | z4) && i3 > size) {
                int measuredWidth = textView.getMeasuredWidth() - (i3 - size);
                if (measuredWidth < 0) {
                    measuredWidth = 0;
                }
                textView.setMaxWidth(measuredWidth);
            }
        }
        super.onMeasure(i, i2);
    }
}
