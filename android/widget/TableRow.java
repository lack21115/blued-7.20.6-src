package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/widget/TableRow.class */
public class TableRow extends LinearLayout {
    private ChildrenTracker mChildrenTracker;
    private SparseIntArray mColumnToChildIndex;
    private int[] mColumnWidths;
    private int[] mConstrainedColumnWidths;
    private int mNumColumns;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/TableRow$ChildrenTracker.class */
    public class ChildrenTracker implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener listener;

        private ChildrenTracker() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
            this.listener = onHierarchyChangeListener;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            TableRow.this.mColumnToChildIndex = null;
            if (this.listener != null) {
                this.listener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            TableRow.this.mColumnToChildIndex = null;
            if (this.listener != null) {
                this.listener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TableRow$LayoutParams.class */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        private static final int LOCATION = 0;
        private static final int LOCATION_NEXT = 1;
        @ViewDebug.ExportedProperty(category = "layout")
        public int column;
        private int[] mOffset;
        @ViewDebug.ExportedProperty(category = "layout")
        public int span;

        public LayoutParams() {
            super(-1, -2);
            this.mOffset = new int[2];
            this.column = -1;
            this.span = 1;
        }

        public LayoutParams(int i) {
            this();
            this.column = i;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mOffset = new int[2];
            this.column = -1;
            this.span = 1;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.mOffset = new int[2];
            this.column = -1;
            this.span = 1;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mOffset = new int[2];
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TableRow_Cell);
            this.column = obtainStyledAttributes.getInt(0, -1);
            this.span = obtainStyledAttributes.getInt(1, 1);
            if (this.span <= 1) {
                this.span = 1;
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mOffset = new int[2];
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mOffset = new int[2];
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            if (typedArray.hasValue(i)) {
                this.width = typedArray.getLayoutDimension(i, "layout_width");
            } else {
                this.width = -1;
            }
            if (typedArray.hasValue(i2)) {
                this.height = typedArray.getLayoutDimension(i2, "layout_height");
            } else {
                this.height = -2;
            }
        }
    }

    public TableRow(Context context) {
        super(context);
        this.mNumColumns = 0;
        initTableRow();
    }

    public TableRow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mNumColumns = 0;
        initTableRow();
    }

    private void initTableRow() {
        ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
        this.mChildrenTracker = new ChildrenTracker();
        if (onHierarchyChangeListener != null) {
            this.mChildrenTracker.setOnHierarchyChangeListener(onHierarchyChangeListener);
        }
        super.setOnHierarchyChangeListener(this.mChildrenTracker);
    }

    private void mapIndexAndColumns() {
        if (this.mColumnToChildIndex != null) {
            return;
        }
        int i = 0;
        int childCount = getChildCount();
        this.mColumnToChildIndex = new SparseIntArray();
        SparseIntArray sparseIntArray = this.mColumnToChildIndex;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                this.mNumColumns = i;
                return;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            int i4 = i;
            if (layoutParams.column >= i) {
                i4 = layoutParams.column;
            }
            i = i4;
            int i5 = 0;
            while (i5 < layoutParams.span) {
                sparseIntArray.put(i, i3);
                i5++;
                i++;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout
    int getChildrenSkipCount(View view, int i) {
        return ((LayoutParams) view.getLayoutParams()).span - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] getColumnsWidths(int i) {
        int makeMeasureSpec;
        int virtualChildCount = getVirtualChildCount();
        if (this.mColumnWidths == null || virtualChildCount != this.mColumnWidths.length) {
            this.mColumnWidths = new int[virtualChildCount];
        }
        int[] iArr = this.mColumnWidths;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= virtualChildCount) {
                return iArr;
            }
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt == null || virtualChildAt.getVisibility() == 8) {
                iArr[i3] = 0;
            } else {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.span == 1) {
                    switch (layoutParams.width) {
                        case -2:
                            makeMeasureSpec = getChildMeasureSpec(i, 0, -2);
                            break;
                        case -1:
                            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            break;
                        default:
                            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                            break;
                    }
                    virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                    iArr[i3] = virtualChildAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                } else {
                    iArr[i3] = 0;
                }
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.widget.LinearLayout
    int getLocationOffset(View view) {
        return ((LayoutParams) view.getLayoutParams()).mOffset[0];
    }

    @Override // android.widget.LinearLayout
    int getNextLocationOffset(View view) {
        return ((LayoutParams) view.getLayoutParams()).mOffset[1];
    }

    @Override // android.widget.LinearLayout
    public View getVirtualChildAt(int i) {
        if (this.mColumnToChildIndex == null) {
            mapIndexAndColumns();
        }
        int i2 = this.mColumnToChildIndex.get(i, -1);
        if (i2 != -1) {
            return getChildAt(i2);
        }
        return null;
    }

    @Override // android.widget.LinearLayout
    public int getVirtualChildCount() {
        if (this.mColumnToChildIndex == null) {
            mapIndexAndColumns();
        }
        return this.mNumColumns;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.LinearLayout
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        if (this.mConstrainedColumnWidths == null) {
            super.measureChildBeforeLayout(view, i, i2, i3, i4, i5);
            return;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i6 = 0;
        int i7 = layoutParams.span;
        int[] iArr = this.mConstrainedColumnWidths;
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= i7) {
                break;
            }
            i6 += iArr[i + i9];
            i8 = i9 + 1;
        }
        int i10 = layoutParams.gravity;
        boolean isHorizontal = Gravity.isHorizontal(i10);
        int i11 = 1073741824;
        if (isHorizontal) {
            i11 = Integer.MIN_VALUE;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (i6 - layoutParams.leftMargin) - layoutParams.rightMargin), i11), getChildMeasureSpec(i4, this.mPaddingTop + this.mPaddingBottom + layoutParams.topMargin + layoutParams.bottomMargin + i5, layoutParams.height));
        if (!isHorizontal) {
            int[] iArr2 = layoutParams.mOffset;
            layoutParams.mOffset[1] = 0;
            iArr2[0] = 0;
            return;
        }
        layoutParams.mOffset[1] = i6 - view.getMeasuredWidth();
        switch (Gravity.getAbsoluteGravity(i10, getLayoutDirection()) & 7) {
            case 1:
                layoutParams.mOffset[0] = layoutParams.mOffset[1] / 2;
                return;
            case 2:
            case 3:
            case 4:
            default:
                return;
            case 5:
                layoutParams.mOffset[0] = layoutParams.mOffset[1];
                return;
        }
    }

    @Override // android.widget.LinearLayout
    int measureNullChild(int i) {
        return this.mConstrainedColumnWidths[i];
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TableRow.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TableRow.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutHorizontal(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        measureHorizontal(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setColumnCollapsed(int i, boolean z) {
        View virtualChildAt = getVirtualChildAt(i);
        if (virtualChildAt != null) {
            virtualChildAt.setVisibility(z ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setColumnsWidthConstraints(int[] iArr) {
        if (iArr == null || iArr.length < getVirtualChildCount()) {
            throw new IllegalArgumentException("columnWidths should be >= getVirtualChildCount()");
        }
        this.mConstrainedColumnWidths = iArr;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mChildrenTracker.setOnHierarchyChangeListener(onHierarchyChangeListener);
    }
}
