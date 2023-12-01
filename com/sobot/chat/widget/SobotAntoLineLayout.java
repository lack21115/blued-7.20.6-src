package com.sobot.chat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.sobot.chat.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotAntoLineLayout.class */
public class SobotAntoLineLayout extends ViewGroup {
    public static final int MODE_FILL_PARENT = 0;
    public static final int MODE_WRAP_CONTENT = 1;
    private List<Integer> childOfLine;
    private int mFillMode;
    private int mHorizontalGap;
    private List<Integer> mOriginWidth;
    private int mVerticalGap;

    public SobotAntoLineLayout(Context context) {
        super(context);
        this.mVerticalGap = 16;
        this.mHorizontalGap = 10;
        this.mFillMode = 0;
        this.mOriginWidth = new ArrayList();
    }

    public SobotAntoLineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mVerticalGap = 16;
        this.mHorizontalGap = 10;
        this.mFillMode = 0;
        this.mOriginWidth = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sobot_autoWrapLineLayout);
        this.mHorizontalGap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sobot_autoWrapLineLayout_sobot_horizontalGap, 0);
        this.mVerticalGap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sobot_autoWrapLineLayout_sobot_verticalGap, 0);
        this.mFillMode = obtainStyledAttributes.getInteger(R.styleable.sobot_autoWrapLineLayout_sobot_fillMode, 0);
        obtainStyledAttributes.recycle();
    }

    public SobotAntoLineLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVerticalGap = 16;
        this.mHorizontalGap = 10;
        this.mFillMode = 0;
        this.mOriginWidth = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sobot_autoWrapLineLayout);
        this.mHorizontalGap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sobot_autoWrapLineLayout_sobot_horizontalGap, 0);
        this.mVerticalGap = obtainStyledAttributes.getDimensionPixelSize(R.styleable.sobot_autoWrapLineLayout_sobot_verticalGap, 0);
        this.mFillMode = obtainStyledAttributes.getInteger(R.styleable.sobot_autoWrapLineLayout_sobot_fillMode, 0);
        obtainStyledAttributes.recycle();
    }

    private void layoutModeFillParent() {
        int measuredWidth = getMeasuredWidth();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2;
            if (i >= this.childOfLine.size()) {
                return;
            }
            int intValue = this.childOfLine.get(i).intValue();
            int i5 = 0;
            for (int i6 = 0; i6 < intValue; i6++) {
                i5 += getChildAt(i6 + i4).getMeasuredWidth();
            }
            int i7 = (((measuredWidth - i5) - (this.mHorizontalGap * (intValue - 1))) / intValue) / 2;
            int i8 = 0;
            int i9 = 0;
            int i10 = i4;
            while (true) {
                i2 = i10;
                if (i2 < intValue + i4) {
                    View childAt = getChildAt(i2);
                    i8 = Math.max(i8, childAt.getMeasuredHeight());
                    childAt.setPadding(i7, childAt.getPaddingTop(), i7, childAt.getPaddingBottom());
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredWidth() + (i7 * 2), 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                    childAt.layout(i9, i3, childAt.getMeasuredWidth() + i9, childAt.getMeasuredHeight() + i3);
                    i9 += childAt.getMeasuredWidth() + this.mHorizontalGap;
                    i10 = i2 + 1;
                }
            }
            i3 += i8 + this.mVerticalGap;
            i++;
        }
    }

    private void layoutWrapContent() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2;
            if (i >= this.childOfLine.size()) {
                return;
            }
            int intValue = this.childOfLine.get(i).intValue();
            int i5 = 0;
            int i6 = 0;
            int i7 = i4;
            while (true) {
                i2 = i7;
                if (i2 < intValue + i4) {
                    View childAt = getChildAt(i2);
                    i5 = Math.max(i5, childAt.getMeasuredHeight());
                    childAt.layout(i6, i3, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + i3);
                    i6 += childAt.getMeasuredWidth() + this.mHorizontalGap;
                    i7 = i2 + 1;
                }
            }
            i3 += i5 + this.mVerticalGap;
            i++;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mFillMode == 0) {
            layoutModeFillParent();
        } else {
            layoutWrapContent();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        this.childOfLine = new ArrayList();
        int childCount = getChildCount();
        int size = View.MeasureSpec.getSize(i);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (this.mFillMode != 0) {
                measureChild(childAt, i, i2);
            } else if (this.mOriginWidth.size() <= i8) {
                measureChild(childAt, i, i2);
                this.mOriginWidth.add(Integer.valueOf(childAt.getMeasuredWidth()));
            } else {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.mOriginWidth.get(i8).intValue(), 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
            }
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            i5 += measuredWidth;
            if (i5 <= size) {
                i7 = Math.max(measuredHeight, i7);
                i3 = i4 + 1;
            } else {
                this.childOfLine.add(Integer.valueOf(i4));
                i6 += i7;
                i5 = measuredWidth;
                i7 = measuredHeight;
                i3 = 1;
            }
            i4 = i3;
        }
        this.childOfLine.add(Integer.valueOf(i4));
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= this.childOfLine.size()) {
                setMeasuredDimension(size, i6 + (this.mVerticalGap * (this.childOfLine.size() - 1)) + i7);
                return;
            }
            if (this.childOfLine.get(i10).intValue() == 0) {
                this.childOfLine.remove(i10);
            }
            i9 = i10 + 1;
        }
    }

    public void setFillMode(int i) {
        this.mFillMode = i;
    }

    public void setHorizontalGap(int i) {
        this.mHorizontalGap = i;
    }

    public void setVerticalGap(int i) {
        this.mVerticalGap = i;
    }
}
