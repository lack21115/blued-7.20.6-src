package android.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
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
import com.android.internal.R;
import java.util.ArrayList;

@RemoteViews.RemoteView
/* loaded from: source-4181928-dex2jar.jar:android/widget/FrameLayout.class */
public class FrameLayout extends ViewGroup {
    private static final int DEFAULT_CHILD_GRAVITY = 8388659;
    @ViewDebug.ExportedProperty(category = "drawing")
    private Drawable mForeground;
    boolean mForegroundBoundsChanged;
    @ViewDebug.ExportedProperty(category = "drawing")
    private int mForegroundGravity;
    @ViewDebug.ExportedProperty(category = "drawing")
    protected boolean mForegroundInPadding;
    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingBottom;
    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingLeft;
    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingRight;
    @ViewDebug.ExportedProperty(category = "padding")
    private int mForegroundPaddingTop;
    private ColorStateList mForegroundTintList;
    private PorterDuff.Mode mForegroundTintMode;
    private boolean mHasForegroundTint;
    private boolean mHasForegroundTintMode;
    private final ArrayList<View> mMatchParentChildren;
    @ViewDebug.ExportedProperty(category = "measurement")
    boolean mMeasureAllChildren;
    private final Rect mOverlayBounds;
    private final Rect mSelfBounds;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/FrameLayout$LayoutParams.class */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.gravity = -1;
            this.gravity = i3;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FrameLayout_Layout);
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
            this.gravity = layoutParams.gravity;
        }
    }

    public FrameLayout(Context context) {
        super(context);
        this.mMeasureAllChildren = false;
        this.mForegroundTintList = null;
        this.mForegroundTintMode = null;
        this.mHasForegroundTint = false;
        this.mHasForegroundTintMode = false;
        this.mForegroundPaddingLeft = 0;
        this.mForegroundPaddingTop = 0;
        this.mForegroundPaddingRight = 0;
        this.mForegroundPaddingBottom = 0;
        this.mSelfBounds = new Rect();
        this.mOverlayBounds = new Rect();
        this.mForegroundGravity = 119;
        this.mForegroundInPadding = true;
        this.mForegroundBoundsChanged = false;
        this.mMatchParentChildren = new ArrayList<>(1);
    }

    public FrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrameLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public FrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mMeasureAllChildren = false;
        this.mForegroundTintList = null;
        this.mForegroundTintMode = null;
        this.mHasForegroundTint = false;
        this.mHasForegroundTintMode = false;
        this.mForegroundPaddingLeft = 0;
        this.mForegroundPaddingTop = 0;
        this.mForegroundPaddingRight = 0;
        this.mForegroundPaddingBottom = 0;
        this.mSelfBounds = new Rect();
        this.mOverlayBounds = new Rect();
        this.mForegroundGravity = 119;
        this.mForegroundInPadding = true;
        this.mForegroundBoundsChanged = false;
        this.mMatchParentChildren = new ArrayList<>(1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FrameLayout, i, i2);
        this.mForegroundGravity = obtainStyledAttributes.getInt(2, this.mForegroundGravity);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        }
        if (obtainStyledAttributes.getBoolean(1, false)) {
            setMeasureAllChildren(true);
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.mForegroundTintMode = Drawable.parseTintMode(obtainStyledAttributes.getInt(4, -1), this.mForegroundTintMode);
            this.mHasForegroundTintMode = true;
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.mForegroundTintList = obtainStyledAttributes.getColorStateList(3);
            this.mHasForegroundTint = true;
        }
        this.mForegroundInPadding = obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
        applyForegroundTint();
    }

    private void applyForegroundTint() {
        if (this.mForeground != null) {
            if (this.mHasForegroundTint || this.mHasForegroundTintMode) {
                this.mForeground = this.mForeground.mutate();
                if (this.mHasForegroundTint) {
                    this.mForeground.setTintList(this.mForegroundTintList);
                }
                if (this.mHasForegroundTintMode) {
                    this.mForeground.setTintMode(this.mForegroundTintMode);
                }
                if (this.mForeground.isStateful()) {
                    this.mForeground.setState(getDrawableState());
                }
            }
        }
    }

    private int getPaddingBottomWithForeground() {
        return this.mForegroundInPadding ? Math.max(this.mPaddingBottom, this.mForegroundPaddingBottom) : this.mPaddingBottom + this.mForegroundPaddingBottom;
    }

    private int getPaddingTopWithForeground() {
        return this.mForegroundInPadding ? Math.max(this.mPaddingTop, this.mForegroundPaddingTop) : this.mPaddingTop + this.mForegroundPaddingTop;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mForeground != null) {
            Drawable drawable = this.mForeground;
            if (this.mForegroundBoundsChanged) {
                this.mForegroundBoundsChanged = false;
                Rect rect = this.mSelfBounds;
                Rect rect2 = this.mOverlayBounds;
                int i = this.mRight - this.mLeft;
                int i2 = this.mBottom - this.mTop;
                if (this.mForegroundInPadding) {
                    rect.set(0, 0, i, i2);
                } else {
                    rect.set(this.mPaddingLeft, this.mPaddingTop, i - this.mPaddingRight, i2 - this.mPaddingBottom);
                }
                Gravity.apply(this.mForegroundGravity, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2, getLayoutDirection());
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.mForeground != null) {
            this.mForeground.setHotspot(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.mForeground == null || !this.mForeground.isStateful()) {
            return;
        }
        this.mForeground.setState(getDrawableState());
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        boolean gatherTransparentRegion = super.gatherTransparentRegion(region);
        if (region != null && this.mForeground != null) {
            applyDrawableToTransparentRegion(this.mForeground, region);
        }
        return gatherTransparentRegion;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Deprecated
    public boolean getConsiderGoneChildrenWhenMeasuring() {
        return getMeasureAllChildren();
    }

    public Drawable getForeground() {
        return this.mForeground;
    }

    public int getForegroundGravity() {
        return this.mForegroundGravity;
    }

    public ColorStateList getForegroundTintList() {
        return this.mForegroundTintList;
    }

    public PorterDuff.Mode getForegroundTintMode() {
        return this.mForegroundTintMode;
    }

    public boolean getMeasureAllChildren() {
        return this.mMeasureAllChildren;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPaddingLeftWithForeground() {
        return this.mForegroundInPadding ? Math.max(this.mPaddingLeft, this.mForegroundPaddingLeft) : this.mPaddingLeft + this.mForegroundPaddingLeft;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPaddingRightWithForeground() {
        return this.mForegroundInPadding ? Math.max(this.mPaddingRight, this.mForegroundPaddingRight) : this.mPaddingRight + this.mForegroundPaddingRight;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.mForeground != null) {
            this.mForeground.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void layoutChildren(int i, int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int childCount = getChildCount();
        int paddingLeftWithForeground = getPaddingLeftWithForeground();
        int paddingRightWithForeground = (i3 - i) - getPaddingRightWithForeground();
        int paddingTopWithForeground = getPaddingTopWithForeground();
        int paddingBottomWithForeground = (i4 - i2) - getPaddingBottomWithForeground();
        this.mForegroundBoundsChanged = true;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= childCount) {
                return;
            }
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i9 = layoutParams.gravity;
                int i10 = i9;
                if (i9 == -1) {
                    i10 = DEFAULT_CHILD_GRAVITY;
                }
                switch (Gravity.getAbsoluteGravity(i10, getLayoutDirection()) & 7) {
                    case 1:
                        i5 = (((((paddingRightWithForeground - paddingLeftWithForeground) - measuredWidth) / 2) + paddingLeftWithForeground) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        if (!z) {
                            i5 = (paddingRightWithForeground - measuredWidth) - layoutParams.rightMargin;
                            break;
                        }
                    default:
                        i5 = paddingLeftWithForeground + layoutParams.leftMargin;
                        break;
                }
                switch (i10 & 112) {
                    case 16:
                        i6 = (((((paddingBottomWithForeground - paddingTopWithForeground) - measuredHeight) / 2) + paddingTopWithForeground) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        break;
                    case 48:
                        i6 = paddingTopWithForeground + layoutParams.topMargin;
                        break;
                    case 80:
                        i6 = (paddingBottomWithForeground - measuredHeight) - layoutParams.bottomMargin;
                        break;
                    default:
                        i6 = paddingTopWithForeground + layoutParams.topMargin;
                        break;
                }
                childAt.layout(i5, i6, i5 + measuredWidth, i6 + measuredHeight);
            }
            i7 = i8 + 1;
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(FrameLayout.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(FrameLayout.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutChildren(i, i2, i3, i4, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int childCount = getChildCount();
        boolean z = (View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == 1073741824) ? false : true;
        this.mMatchParentChildren.clear();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (!this.mMeasureAllChildren) {
                i3 = i8;
                i4 = i6;
                i5 = i7;
                if (childAt.getVisibility() == 8) {
                    i9++;
                    i8 = i3;
                    i6 = i4;
                    i7 = i5;
                }
            }
            measureChildWithMargins(childAt, i, 0, i2, 0);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int max = Math.max(i7, childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
            int max2 = Math.max(i6, childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
            int combineMeasuredStates = combineMeasuredStates(i8, childAt.getMeasuredState());
            i3 = combineMeasuredStates;
            i4 = max2;
            i5 = max;
            if (z) {
                if (layoutParams.width != -1) {
                    i3 = combineMeasuredStates;
                    i4 = max2;
                    i5 = max;
                    if (layoutParams.height != -1) {
                    }
                }
                this.mMatchParentChildren.add(childAt);
                i5 = max;
                i4 = max2;
                i3 = combineMeasuredStates;
            }
            i9++;
            i8 = i3;
            i6 = i4;
            i7 = i5;
        }
        int paddingLeftWithForeground = getPaddingLeftWithForeground();
        int paddingRightWithForeground = getPaddingRightWithForeground();
        int max3 = Math.max(i6 + getPaddingTopWithForeground() + getPaddingBottomWithForeground(), getSuggestedMinimumHeight());
        int max4 = Math.max(i7 + paddingLeftWithForeground + paddingRightWithForeground, getSuggestedMinimumWidth());
        Drawable foreground = getForeground();
        int i10 = max3;
        int i11 = max4;
        if (foreground != null) {
            i10 = Math.max(max3, foreground.getMinimumHeight());
            i11 = Math.max(max4, foreground.getMinimumWidth());
        }
        setMeasuredDimension(resolveSizeAndState(i11, i, i8), resolveSizeAndState(i10, i2, i8 << 16));
        int size = this.mMatchParentChildren.size();
        if (size <= 1) {
            return;
        }
        int i12 = 0;
        while (true) {
            int i13 = i12;
            if (i13 >= size) {
                return;
            }
            View view = this.mMatchParentChildren.get(i13);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            view.measure(marginLayoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec((((getMeasuredWidth() - getPaddingLeftWithForeground()) - getPaddingRightWithForeground()) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, 1073741824) : getChildMeasureSpec(i, getPaddingLeftWithForeground() + getPaddingRightWithForeground() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, marginLayoutParams.width), marginLayoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec((((getMeasuredHeight() - getPaddingTopWithForeground()) - getPaddingBottomWithForeground()) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin, 1073741824) : getChildMeasureSpec(i2, getPaddingTopWithForeground() + getPaddingBottomWithForeground() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
            i12 = i13 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mForegroundBoundsChanged = true;
    }

    public void setForeground(Drawable drawable) {
        if (this.mForeground != drawable) {
            if (this.mForeground != null) {
                this.mForeground.setCallback(null);
                unscheduleDrawable(this.mForeground);
            }
            this.mForeground = drawable;
            this.mForegroundPaddingLeft = 0;
            this.mForegroundPaddingTop = 0;
            this.mForegroundPaddingRight = 0;
            this.mForegroundPaddingBottom = 0;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                drawable.setLayoutDirection(getLayoutDirection());
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                applyForegroundTint();
                if (this.mForegroundGravity == 119) {
                    Rect rect = new Rect();
                    if (drawable.getPadding(rect)) {
                        this.mForegroundPaddingLeft = rect.left;
                        this.mForegroundPaddingTop = rect.top;
                        this.mForegroundPaddingRight = rect.right;
                        this.mForegroundPaddingBottom = rect.bottom;
                    }
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @RemotableViewMethod
    public void setForegroundGravity(int i) {
        if (this.mForegroundGravity != i) {
            int i2 = i;
            if ((8388615 & i) == 0) {
                i2 = i | 8388611;
            }
            int i3 = i2;
            if ((i2 & 112) == 0) {
                i3 = i2 | 48;
            }
            this.mForegroundGravity = i3;
            if (this.mForegroundGravity != 119 || this.mForeground == null) {
                this.mForegroundPaddingLeft = 0;
                this.mForegroundPaddingTop = 0;
                this.mForegroundPaddingRight = 0;
                this.mForegroundPaddingBottom = 0;
            } else {
                Rect rect = new Rect();
                if (this.mForeground.getPadding(rect)) {
                    this.mForegroundPaddingLeft = rect.left;
                    this.mForegroundPaddingTop = rect.top;
                    this.mForegroundPaddingRight = rect.right;
                    this.mForegroundPaddingBottom = rect.bottom;
                }
            }
            requestLayout();
        }
    }

    public void setForegroundTintList(ColorStateList colorStateList) {
        this.mForegroundTintList = colorStateList;
        this.mHasForegroundTint = true;
        applyForegroundTint();
    }

    public void setForegroundTintMode(PorterDuff.Mode mode) {
        this.mForegroundTintMode = mode;
        this.mHasForegroundTintMode = true;
        applyForegroundTint();
    }

    @RemotableViewMethod
    public void setMeasureAllChildren(boolean z) {
        this.mMeasureAllChildren = z;
    }

    @Override // android.view.View
    @RemotableViewMethod
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.mForeground != null) {
            this.mForeground.setVisible(i == 0, false);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mForeground;
    }
}
