package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/widget/TabWidget.class */
public class TabWidget extends LinearLayout implements View.OnFocusChangeListener {
    private final Rect mBounds;
    private boolean mDrawBottomStrips;
    private int[] mImposedTabWidths;
    private int mImposedTabsHeight;
    private Drawable mLeftStrip;
    private Drawable mRightStrip;
    private int mSelectedTab;
    private OnTabSelectionChanged mSelectionChangedListener;
    private boolean mStripMoved;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabWidget$OnTabSelectionChanged.class */
    interface OnTabSelectionChanged {
        void onTabSelectionChanged(int i, boolean z);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TabWidget$TabClickListener.class */
    private class TabClickListener implements View.OnClickListener {
        private final int mTabIndex;

        private TabClickListener(int i) {
            this.mTabIndex = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TabWidget.this.mSelectionChangedListener.onTabSelectionChanged(this.mTabIndex, true);
        }
    }

    public TabWidget(Context context) {
        this(context, null);
    }

    public TabWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabWidgetStyle);
    }

    public TabWidget(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public TabWidget(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSelectedTab = -1;
        this.mDrawBottomStrips = true;
        this.mBounds = new Rect();
        this.mImposedTabsHeight = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TabWidget, i, i2);
        setStripEnabled(obtainStyledAttributes.getBoolean(3, true));
        setLeftStripDrawable(obtainStyledAttributes.getDrawable(1));
        setRightStripDrawable(obtainStyledAttributes.getDrawable(2));
        obtainStyledAttributes.recycle();
        initTabWidget();
    }

    private void initTabWidget() {
        setChildrenDrawingOrderEnabled(true);
        Context context = this.mContext;
        if (context.getApplicationInfo().targetSdkVersion <= 4) {
            if (this.mLeftStrip == null) {
                this.mLeftStrip = context.getDrawable(R.drawable.tab_bottom_left_v4);
            }
            if (this.mRightStrip == null) {
                this.mRightStrip = context.getDrawable(R.drawable.tab_bottom_right_v4);
            }
        } else {
            if (this.mLeftStrip == null) {
                this.mLeftStrip = context.getDrawable(R.drawable.tab_bottom_left);
            }
            if (this.mRightStrip == null) {
                this.mRightStrip = context.getDrawable(R.drawable.tab_bottom_right);
            }
        }
        setFocusable(true);
        setOnFocusChangeListener(this);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (view.getLayoutParams() == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            layoutParams.setMargins(0, 0, 0, 0);
            view.setLayoutParams(layoutParams);
        }
        view.setFocusable(true);
        view.setClickable(true);
        super.addView(view);
        view.setOnClickListener(new TabClickListener(getTabCount() - 1));
        view.setOnFocusChangeListener(this);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void childDrawableStateChanged(View view) {
        if (this.mSelectedTab != -1 && getTabCount() > 0 && view == getChildTabViewAt(this.mSelectedTab)) {
            invalidate();
        }
        super.childDrawableStateChanged(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (getTabCount() != 0 && this.mDrawBottomStrips) {
            View childTabViewAt = getChildTabViewAt(this.mSelectedTab);
            Drawable drawable = this.mLeftStrip;
            Drawable drawable2 = this.mRightStrip;
            drawable.setState(childTabViewAt.getDrawableState());
            drawable2.setState(childTabViewAt.getDrawableState());
            if (this.mStripMoved) {
                Rect rect = this.mBounds;
                rect.left = childTabViewAt.getLeft();
                rect.right = childTabViewAt.getRight();
                int height = getHeight();
                drawable.setBounds(Math.min(0, rect.left - drawable.getIntrinsicWidth()), height - drawable.getIntrinsicHeight(), rect.left, height);
                drawable2.setBounds(rect.right, height - drawable2.getIntrinsicHeight(), Math.max(getWidth(), rect.right + drawable2.getIntrinsicWidth()), height);
                this.mStripMoved = false;
            }
            drawable.draw(canvas);
            drawable2.draw(canvas);
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View childTabViewAt;
        onPopulateAccessibilityEvent(accessibilityEvent);
        if (this.mSelectedTab == -1 || (childTabViewAt = getChildTabViewAt(this.mSelectedTab)) == null || childTabViewAt.getVisibility() != 0) {
            return false;
        }
        return childTabViewAt.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public void focusCurrentTab(int i) {
        int i2 = this.mSelectedTab;
        setCurrentTab(i);
        if (i2 != i) {
            getChildTabViewAt(i).requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.mSelectedTab != -1) {
            if (i2 == i - 1) {
                return this.mSelectedTab;
            }
            if (i2 >= this.mSelectedTab) {
                return i2 + 1;
            }
        }
        return i2;
    }

    public View getChildTabViewAt(int i) {
        return getChildAt(i);
    }

    public int getTabCount() {
        return getChildCount();
    }

    public boolean isStripEnabled() {
        return this.mDrawBottomStrips;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.LinearLayout
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        int i6 = i2;
        int i7 = i4;
        if (!isMeasureWithLargestChildEnabled()) {
            i6 = i2;
            i7 = i4;
            if (this.mImposedTabsHeight >= 0) {
                i6 = View.MeasureSpec.makeMeasureSpec(this.mImposedTabWidths[i] + i3, 1073741824);
                i7 = View.MeasureSpec.makeMeasureSpec(this.mImposedTabsHeight, 1073741824);
            }
        }
        super.measureChildBeforeLayout(view, i, i6, i3, i7, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.LinearLayout
    public void measureHorizontal(int i, int i2) {
        if (View.MeasureSpec.getMode(i) == 0) {
            super.measureHorizontal(i, i2);
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mImposedTabsHeight = -1;
        super.measureHorizontal(makeMeasureSpec, i2);
        int measuredWidth = getMeasuredWidth() - View.MeasureSpec.getSize(i);
        if (measuredWidth > 0) {
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= childCount) {
                    break;
                }
                if (getChildAt(i5).getVisibility() != 8) {
                    i3++;
                }
                i4 = i5 + 1;
            }
            if (i3 > 0) {
                if (this.mImposedTabWidths == null || this.mImposedTabWidths.length != childCount) {
                    this.mImposedTabWidths = new int[childCount];
                }
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i7);
                    if (childAt.getVisibility() != 8) {
                        int measuredWidth2 = childAt.getMeasuredWidth();
                        int max = Math.max(0, measuredWidth2 - (measuredWidth / i3));
                        this.mImposedTabWidths[i7] = max;
                        measuredWidth -= measuredWidth2 - max;
                        i3--;
                        this.mImposedTabsHeight = Math.max(this.mImposedTabsHeight, childAt.getMeasuredHeight());
                    }
                    i6 = i7 + 1;
                }
            }
        }
        super.measureHorizontal(i, i2);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (view == this && z && getTabCount() > 0 && this.mSelectedTab != -1) {
            getChildTabViewAt(this.mSelectedTab).requestFocus();
        } else if (z) {
            int tabCount = getTabCount();
            for (int i = 0; i < tabCount; i++) {
                if (getChildTabViewAt(i) == view) {
                    setCurrentTab(i);
                    this.mSelectionChangedListener.onTabSelectionChanged(i, false);
                    if (isShown()) {
                        sendAccessibilityEvent(8);
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TabWidget.class.getName());
        accessibilityEvent.setItemCount(getTabCount());
        accessibilityEvent.setCurrentItemIndex(this.mSelectedTab);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TabWidget.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mStripMoved = true;
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.mSelectedTab = -1;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 8 && isFocused()) {
            accessibilityEvent.recycle();
        } else {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setCurrentTab(int i) {
        if (i < 0 || i >= getTabCount() || i == this.mSelectedTab) {
            return;
        }
        if (this.mSelectedTab != -1) {
            getChildTabViewAt(this.mSelectedTab).setSelected(false);
        }
        this.mSelectedTab = i;
        getChildTabViewAt(this.mSelectedTab).setSelected(true);
        this.mStripMoved = true;
        if (isShown()) {
            sendAccessibilityEvent(4);
        }
    }

    public void setDividerDrawable(int i) {
        setDividerDrawable(this.mContext.getDrawable(i));
    }

    @Override // android.widget.LinearLayout
    public void setDividerDrawable(Drawable drawable) {
        super.setDividerDrawable(drawable);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int tabCount = getTabCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= tabCount) {
                return;
            }
            getChildTabViewAt(i2).setEnabled(z);
            i = i2 + 1;
        }
    }

    public void setLeftStripDrawable(int i) {
        setLeftStripDrawable(this.mContext.getDrawable(i));
    }

    public void setLeftStripDrawable(Drawable drawable) {
        this.mLeftStrip = drawable;
        requestLayout();
        invalidate();
    }

    public void setRightStripDrawable(int i) {
        setRightStripDrawable(this.mContext.getDrawable(i));
    }

    public void setRightStripDrawable(Drawable drawable) {
        this.mRightStrip = drawable;
        requestLayout();
        invalidate();
    }

    public void setStripEnabled(boolean z) {
        this.mDrawBottomStrips = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTabSelectionListener(OnTabSelectionChanged onTabSelectionChanged) {
        this.mSelectionChangedListener = onTabSelectionChanged;
    }
}
