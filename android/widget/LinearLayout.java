package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.RemotableViewMethod;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RemoteViews;
import com.alipay.sdk.util.i;
import com.android.internal.R;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:android/widget/LinearLayout.class */
public class LinearLayout extends ViewGroup {
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mBaselineAligned;
    @ViewDebug.ExportedProperty(category = "layout")
    private int mBaselineAlignedChildIndex;
    @ViewDebug.ExportedProperty(category = "measurement")
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    @ViewDebug.ExportedProperty(category = "measurement", flagMapping = {@ViewDebug.FlagToString(equals = -1, mask = -1, name = "NONE"), @ViewDebug.FlagToString(equals = 0, mask = 0, name = "NONE"), @ViewDebug.FlagToString(equals = 48, mask = 48, name = "TOP"), @ViewDebug.FlagToString(equals = 80, mask = 80, name = "BOTTOM"), @ViewDebug.FlagToString(equals = 3, mask = 3, name = "LEFT"), @ViewDebug.FlagToString(equals = 5, mask = 5, name = "RIGHT"), @ViewDebug.FlagToString(equals = 8388611, mask = 8388611, name = "START"), @ViewDebug.FlagToString(equals = 8388613, mask = 8388613, name = "END"), @ViewDebug.FlagToString(equals = 16, mask = 16, name = "CENTER_VERTICAL"), @ViewDebug.FlagToString(equals = 112, mask = 112, name = "FILL_VERTICAL"), @ViewDebug.FlagToString(equals = 1, mask = 1, name = "CENTER_HORIZONTAL"), @ViewDebug.FlagToString(equals = 7, mask = 7, name = "FILL_HORIZONTAL"), @ViewDebug.FlagToString(equals = 17, mask = 17, name = "CENTER"), @ViewDebug.FlagToString(equals = 119, mask = 119, name = "FILL"), @ViewDebug.FlagToString(equals = 8388608, mask = 8388608, name = "RELATIVE")}, formatToHexString = true)
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    @ViewDebug.ExportedProperty(category = "measurement")
    private int mOrientation;
    private int mShowDividers;
    @ViewDebug.ExportedProperty(category = "measurement")
    private int mTotalLength;
    @ViewDebug.ExportedProperty(category = "layout")
    private boolean mUseLargestChild;
    @ViewDebug.ExportedProperty(category = "layout")
    private float mWeightSum;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/LinearLayout$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        @ViewDebug.ExportedProperty(category = "layout", mapping = {@ViewDebug.IntToString(from = -1, to = "NONE"), @ViewDebug.IntToString(from = 0, to = "NONE"), @ViewDebug.IntToString(from = 48, to = "TOP"), @ViewDebug.IntToString(from = 80, to = "BOTTOM"), @ViewDebug.IntToString(from = 3, to = "LEFT"), @ViewDebug.IntToString(from = 5, to = "RIGHT"), @ViewDebug.IntToString(from = 8388611, to = "START"), @ViewDebug.IntToString(from = 8388613, to = "END"), @ViewDebug.IntToString(from = 16, to = "CENTER_VERTICAL"), @ViewDebug.IntToString(from = 112, to = "FILL_VERTICAL"), @ViewDebug.IntToString(from = 1, to = "CENTER_HORIZONTAL"), @ViewDebug.IntToString(from = 7, to = "FILL_HORIZONTAL"), @ViewDebug.IntToString(from = 17, to = "CENTER"), @ViewDebug.IntToString(from = 119, to = "FILL")})
        public int gravity;
        @ViewDebug.ExportedProperty(category = "layout")
        public float weight;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayout_Layout);
            this.weight = obtainStyledAttributes.getFloat(3, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }

        @Override // android.view.ViewGroup.LayoutParams
        public String debug(String str) {
            return str + "LinearLayout.LayoutParams={width=" + sizeToString(this.width) + ", height=" + sizeToString(this.height) + " weight=" + this.weight + i.d;
        }
    }

    public LinearLayout(Context context) {
        this(context, null);
    }

    public LinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public LinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayout, i, i2);
        int i3 = obtainStyledAttributes.getInt(1, -1);
        if (i3 >= 0) {
            setOrientation(i3);
        }
        int i4 = obtainStyledAttributes.getInt(0, -1);
        if (i4 >= 0) {
            setGravity(i4);
        }
        boolean z = obtainStyledAttributes.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(4, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(3, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(6, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(5));
        this.mShowDividers = obtainStyledAttributes.getInt(7, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        obtainStyledAttributes.recycle();
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return;
            }
            View virtualChildAt = getVirtualChildAt(i4);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i5 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i5;
                }
            }
            i3 = i4 + 1;
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i) {
                return;
            }
            View virtualChildAt = getVirtualChildAt(i4);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i5 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i5;
                }
            }
            i3 = i4 + 1;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas canvas) {
        int left;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = isLayoutRtl();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, isLayoutRtl ? virtualChildAt.getRight() + layoutParams.rightMargin : (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth);
            }
            i = i2 + 1;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                left = isLayoutRtl ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.mDividerWidth;
            } else {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                left = isLayoutRtl ? (virtualChildAt2.getLeft() - layoutParams2.leftMargin) - this.mDividerWidth : virtualChildAt2.getRight() + layoutParams2.rightMargin;
            }
            drawVerticalDivider(canvas, left);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
            i = i2 + 1;
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i = -1;
        if (this.mBaselineAlignedChildIndex < 0) {
            i = super.getBaseline();
        } else if (getChildCount() <= this.mBaselineAlignedChildIndex) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        } else {
            View childAt = getChildAt(this.mBaselineAlignedChildIndex);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i2 = this.mBaselineChildTop;
                int i3 = i2;
                if (this.mOrientation == 1) {
                    int i4 = this.mGravity & 112;
                    i3 = i2;
                    if (i4 != 48) {
                        switch (i4) {
                            case 16:
                                i3 = i2 + (((((this.mBottom - this.mTop) - this.mPaddingTop) - this.mPaddingBottom) - this.mTotalLength) / 2);
                                break;
                            case 80:
                                i3 = ((this.mBottom - this.mTop) - this.mPaddingBottom) - this.mTotalLength;
                                break;
                            default:
                                i3 = i2;
                                break;
                        }
                    }
                }
                return ((LayoutParams) childAt.getLayoutParams()).topMargin + i3 + baseline;
            } else if (this.mBaselineAlignedChildIndex != 0) {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        }
        return i;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        boolean z;
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        } else if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        } else if ((this.mShowDividers & 2) != 0) {
            while (true) {
                i--;
                z = false;
                if (i < 0) {
                    break;
                } else if (getChildAt(i).getVisibility() != 8) {
                    z = true;
                    break;
                }
            }
            return z;
        } else {
            return false;
        }
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        boolean isLayoutRtl = isLayoutRtl();
        int i8 = this.mPaddingTop;
        int i9 = i4 - i2;
        int i10 = this.mPaddingBottom;
        int i11 = this.mPaddingBottom;
        int virtualChildCount = getVirtualChildCount();
        int i12 = this.mGravity;
        int i13 = this.mGravity;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        switch (Gravity.getAbsoluteGravity(i12 & 8388615, getLayoutDirection())) {
            case 1:
                i5 = this.mPaddingLeft + (((i3 - i) - this.mTotalLength) / 2);
                break;
            case 5:
                i5 = ((this.mPaddingLeft + i3) - i) - this.mTotalLength;
                break;
            default:
                i5 = this.mPaddingLeft;
                break;
        }
        int i14 = 0;
        int i15 = 1;
        if (isLayoutRtl) {
            i14 = virtualChildCount - 1;
            i15 = -1;
        }
        int i16 = 0;
        while (true) {
            int i17 = i16;
            int i18 = i5;
            if (i17 >= virtualChildCount) {
                return;
            }
            int i19 = i14 + (i15 * i17);
            View virtualChildAt = getVirtualChildAt(i19);
            if (virtualChildAt == null) {
                i5 = i18 + measureNullChild(i19);
                i6 = i17;
            } else {
                i5 = i18;
                i6 = i17;
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i20 = -1;
                    if (z) {
                        i20 = -1;
                        if (layoutParams.height != -1) {
                            i20 = virtualChildAt.getBaseline();
                        }
                    }
                    int i21 = layoutParams.gravity;
                    int i22 = i21;
                    if (i21 < 0) {
                        i22 = i13 & 112;
                    }
                    switch (i22 & 112) {
                        case 16:
                            i7 = ((((((i9 - i8) - i11) - measuredHeight) / 2) + i8) + layoutParams.topMargin) - layoutParams.bottomMargin;
                            break;
                        case 48:
                            int i23 = i8 + layoutParams.topMargin;
                            i7 = i23;
                            if (i20 != -1) {
                                i7 = i23 + (iArr[1] - i20);
                                break;
                            }
                            break;
                        case 80:
                            int i24 = ((i9 - i10) - measuredHeight) - layoutParams.bottomMargin;
                            i7 = i24;
                            if (i20 != -1) {
                                i7 = i24 - (iArr2[2] - (virtualChildAt.getMeasuredHeight() - i20));
                                break;
                            }
                            break;
                        default:
                            i7 = i8;
                            break;
                    }
                    int i25 = i18;
                    if (hasDividerBeforeChildAt(i19)) {
                        i25 = i18 + this.mDividerWidth;
                    }
                    int i26 = i25 + layoutParams.leftMargin;
                    setChildFrame(virtualChildAt, i26 + getLocationOffset(virtualChildAt), i7, measuredWidth, measuredHeight);
                    i5 = i26 + layoutParams.rightMargin + measuredWidth + getNextLocationOffset(virtualChildAt);
                    i6 = i17 + getChildrenSkipCount(virtualChildAt, i19);
                }
            }
            i16 = i6 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = this.mPaddingLeft;
        int i10 = i3 - i;
        int i11 = this.mPaddingRight;
        int i12 = this.mPaddingRight;
        int virtualChildCount = getVirtualChildCount();
        int i13 = this.mGravity;
        int i14 = this.mGravity;
        switch (i13 & 112) {
            case 16:
                i5 = this.mPaddingTop + (((i4 - i2) - this.mTotalLength) / 2);
                break;
            case 80:
                i5 = ((this.mPaddingTop + i4) - i2) - this.mTotalLength;
                break;
            default:
                i5 = this.mPaddingTop;
                break;
        }
        int i15 = 0;
        while (i15 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i15);
            if (virtualChildAt == null) {
                i6 = i5 + measureNullChild(i15);
                i7 = i15;
            } else {
                i6 = i5;
                i7 = i15;
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i16 = layoutParams.gravity;
                    int i17 = i16;
                    if (i16 < 0) {
                        i17 = i14 & 8388615;
                    }
                    switch (Gravity.getAbsoluteGravity(i17, getLayoutDirection()) & 7) {
                        case 1:
                            i8 = ((((((i10 - i9) - i12) - measuredWidth) / 2) + i9) + layoutParams.leftMargin) - layoutParams.rightMargin;
                            break;
                        case 5:
                            i8 = ((i10 - i11) - measuredWidth) - layoutParams.rightMargin;
                            break;
                        default:
                            i8 = i9 + layoutParams.leftMargin;
                            break;
                    }
                    int i18 = i5;
                    if (hasDividerBeforeChildAt(i15)) {
                        i18 = i5 + this.mDividerHeight;
                    }
                    int i19 = i18 + layoutParams.topMargin;
                    setChildFrame(virtualChildAt, i8, i19 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    i6 = i19 + layoutParams.bottomMargin + measuredHeight + getNextLocationOffset(virtualChildAt);
                    i7 = i15 + getChildrenSkipCount(virtualChildAt, i15);
                }
            }
            i15 = i7 + 1;
            i5 = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x03b3, code lost:
        if (r0[3] != (-1)) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0800, code lost:
        if (r0[3] != (-1)) goto L234;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void measureHorizontal(int r9, int r10) {
        /*
            Method dump skipped, instructions count: 2351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.LinearLayout.measureHorizontal(int, int):void");
    }

    int measureNullChild(int i) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int max;
        boolean z2;
        int i7;
        boolean z3;
        this.mTotalLength = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        boolean z4 = true;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        boolean z5 = false;
        boolean z6 = false;
        int i12 = this.mBaselineAlignedChildIndex;
        boolean z7 = this.mUseLargestChild;
        int i13 = Integer.MIN_VALUE;
        int i14 = 0;
        while (i14 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i14);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i14);
                i7 = i13;
            } else if (virtualChildAt.getVisibility() == 8) {
                i14 += getChildrenSkipCount(virtualChildAt, i14);
                i7 = i13;
            } else {
                if (hasDividerBeforeChildAt(i14)) {
                    this.mTotalLength += this.mDividerHeight;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                f += layoutParams.weight;
                if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                    int i15 = this.mTotalLength;
                    this.mTotalLength = Math.max(i15, layoutParams.topMargin + i15 + layoutParams.bottomMargin);
                    z3 = true;
                    i7 = i13;
                } else {
                    int i16 = Integer.MIN_VALUE;
                    if (layoutParams.height == 0) {
                        i16 = Integer.MIN_VALUE;
                        if (layoutParams.weight > 0.0f) {
                            i16 = 0;
                            layoutParams.height = -2;
                        }
                    }
                    measureChildBeforeLayout(virtualChildAt, i14, i, 0, i2, f == 0.0f ? this.mTotalLength : 0);
                    if (i16 != Integer.MIN_VALUE) {
                        layoutParams.height = i16;
                    }
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    int i17 = this.mTotalLength;
                    this.mTotalLength = Math.max(i17, i17 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt));
                    i7 = i13;
                    z3 = z6;
                    if (z7) {
                        i7 = Math.max(measuredHeight, i13);
                        z3 = z6;
                    }
                }
                if (i12 >= 0 && i12 == i14 + 1) {
                    this.mBaselineChildTop = this.mTotalLength;
                }
                if (i14 < i12 && layoutParams.weight > 0.0f) {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
                boolean z8 = z5;
                boolean z9 = false;
                if (mode != 1073741824) {
                    z8 = z5;
                    z9 = false;
                    if (layoutParams.width == -1) {
                        z8 = true;
                        z9 = true;
                    }
                }
                int i18 = layoutParams.leftMargin + layoutParams.rightMargin;
                int measuredWidth = virtualChildAt.getMeasuredWidth() + i18;
                i8 = Math.max(i8, measuredWidth);
                i9 = combineMeasuredStates(i9, virtualChildAt.getMeasuredState());
                z4 = z4 && layoutParams.width == -1;
                if (layoutParams.weight > 0.0f) {
                    if (!z9) {
                        i18 = measuredWidth;
                    }
                    i11 = Math.max(i11, i18);
                } else {
                    if (!z9) {
                        i18 = measuredWidth;
                    }
                    i10 = Math.max(i10, i18);
                }
                i14 += getChildrenSkipCount(virtualChildAt, i14);
                z5 = z8;
                z6 = z3;
            }
            i14++;
            i13 = i7;
        }
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerHeight;
        }
        if (z7 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.mTotalLength = 0;
            int i19 = 0;
            while (true) {
                int i20 = i19;
                if (i20 >= virtualChildCount) {
                    break;
                }
                View virtualChildAt2 = getVirtualChildAt(i20);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i20);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i20 += getChildrenSkipCount(virtualChildAt2, i20);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    int i21 = this.mTotalLength;
                    this.mTotalLength = Math.max(i21, i21 + i13 + layoutParams2.topMargin + layoutParams2.bottomMargin + getNextLocationOffset(virtualChildAt2));
                }
                i19 = i20 + 1;
            }
        }
        this.mTotalLength += this.mPaddingTop + this.mPaddingBottom;
        int resolveSizeAndState = resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), i2, 0);
        int i22 = (resolveSizeAndState & 16777215) - this.mTotalLength;
        if (z6 || (i22 != 0 && f > 0.0f)) {
            if (this.mWeightSum > 0.0f) {
                f = this.mWeightSum;
            }
            this.mTotalLength = 0;
            int i23 = 0;
            i3 = i8;
            int i24 = i22;
            while (true) {
                int i25 = i24;
                if (i23 >= virtualChildCount) {
                    break;
                }
                View virtualChildAt3 = getVirtualChildAt(i23);
                if (virtualChildAt3.getVisibility() == 8) {
                    i6 = i25;
                    i5 = i9;
                    max = i10;
                    z2 = z4;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f2 = layoutParams3.weight;
                    i5 = i9;
                    i6 = i25;
                    float f3 = f;
                    if (f2 > 0.0f) {
                        int i26 = (int) ((i25 * f2) / f);
                        f3 = f - f2;
                        int i27 = i25 - i26;
                        int childMeasureSpec = getChildMeasureSpec(i, this.mPaddingLeft + this.mPaddingRight + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                        if (layoutParams3.height == 0 && mode2 == 1073741824) {
                            if (i26 <= 0) {
                                i26 = 0;
                            }
                            virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i26, 1073741824));
                        } else {
                            int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i26;
                            int i28 = measuredHeight2;
                            if (measuredHeight2 < 0) {
                                i28 = 0;
                            }
                            virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i28, 1073741824));
                        }
                        i6 = i27;
                        i5 = combineMeasuredStates(i9, virtualChildAt3.getMeasuredState() & (-256));
                    }
                    int i29 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                    int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i29;
                    i3 = Math.max(i3, measuredWidth2);
                    max = Math.max(i10, mode != 1073741824 && layoutParams3.width == -1 ? i29 : measuredWidth2);
                    z2 = z4 && layoutParams3.width == -1;
                    int i30 = this.mTotalLength;
                    this.mTotalLength = Math.max(i30, virtualChildAt3.getMeasuredHeight() + i30 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                    f = f3;
                }
                i23++;
                z4 = z2;
                i10 = max;
                i9 = i5;
                i24 = i6;
            }
            this.mTotalLength += this.mPaddingTop + this.mPaddingBottom;
            i4 = i9;
            z = z4;
        } else {
            int max2 = Math.max(i10, i11);
            z = z4;
            i10 = max2;
            i4 = i9;
            i3 = i8;
            if (z7) {
                z = z4;
                i10 = max2;
                i4 = i9;
                i3 = i8;
                if (mode2 != 1073741824) {
                    int i31 = 0;
                    while (true) {
                        int i32 = i31;
                        z = z4;
                        i10 = max2;
                        i4 = i9;
                        i3 = i8;
                        if (i32 >= virtualChildCount) {
                            break;
                        }
                        View virtualChildAt4 = getVirtualChildAt(i32);
                        if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                            virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i13, 1073741824));
                        }
                        i31 = i32 + 1;
                    }
                }
            }
        }
        int i33 = i3;
        if (!z) {
            i33 = i3;
            if (mode != 1073741824) {
                i33 = i10;
            }
        }
        setMeasuredDimension(resolveSizeAndState(Math.max(i33 + this.mPaddingLeft + this.mPaddingRight, getSuggestedMinimumWidth()), i, i4), resolveSizeAndState);
        if (z5) {
            forceUniformWidth(virtualChildCount, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(LinearLayout.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LinearLayout.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    @RemotableViewMethod
    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    @RemotableViewMethod
    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        if (drawable == null) {
            z = true;
        }
        setWillNotDraw(z);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    @RemotableViewMethod
    public void setGravity(int i) {
        if (this.mGravity != i) {
            int i2 = i;
            if ((8388615 & i) == 0) {
                i2 = i | 8388611;
            }
            int i3 = i2;
            if ((i2 & 112) == 0) {
                i3 = i2 | 48;
            }
            this.mGravity = i3;
            requestLayout();
        }
    }

    @RemotableViewMethod
    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.mGravity & 8388615) != i2) {
            this.mGravity = (this.mGravity & (-8388616)) | i2;
            requestLayout();
        }
    }

    @RemotableViewMethod
    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    @RemotableViewMethod
    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.mGravity & 112) != i2) {
            this.mGravity = (this.mGravity & (-113)) | i2;
            requestLayout();
        }
    }

    @RemotableViewMethod
    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
