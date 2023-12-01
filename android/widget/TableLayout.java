package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.android.internal.R;
import java.util.regex.Pattern;

/* loaded from: source-4181928-dex2jar.jar:android/widget/TableLayout.class */
public class TableLayout extends LinearLayout {
    private SparseBooleanArray mCollapsedColumns;
    private boolean mInitialized;
    private int[] mMaxWidths;
    private PassThroughHierarchyChangeListener mPassThroughListener;
    private boolean mShrinkAllColumns;
    private SparseBooleanArray mShrinkableColumns;
    private boolean mStretchAllColumns;
    private SparseBooleanArray mStretchableColumns;

    /* loaded from: source-4181928-dex2jar.jar:android/widget/TableLayout$LayoutParams.class */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams() {
            super(-1, -2);
        }

        public LayoutParams(int i, int i2) {
            super(-1, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(-1, i2, f);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @Override // android.view.ViewGroup.LayoutParams
        protected void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            this.width = -1;
            if (typedArray.hasValue(i2)) {
                this.height = typedArray.getLayoutDimension(i2, "layout_height");
            } else {
                this.height = -2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/TableLayout$PassThroughHierarchyChangeListener.class */
    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;

        private PassThroughHierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            TableLayout.this.trackCollapsedColumns(view2);
            if (this.mOnHierarchyChangeListener != null) {
                this.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (this.mOnHierarchyChangeListener != null) {
                this.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public TableLayout(Context context) {
        super(context);
        initTableLayout();
    }

    public TableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TableLayout);
        String string = obtainStyledAttributes.getString(0);
        if (string != null) {
            if (string.charAt(0) == '*') {
                this.mStretchAllColumns = true;
            } else {
                this.mStretchableColumns = parseColumns(string);
            }
        }
        String string2 = obtainStyledAttributes.getString(1);
        if (string2 != null) {
            if (string2.charAt(0) == '*') {
                this.mShrinkAllColumns = true;
            } else {
                this.mShrinkableColumns = parseColumns(string2);
            }
        }
        String string3 = obtainStyledAttributes.getString(2);
        if (string3 != null) {
            this.mCollapsedColumns = parseColumns(string3);
        }
        obtainStyledAttributes.recycle();
        initTableLayout();
    }

    private void findLargestCells(int i) {
        boolean z;
        boolean z2 = true;
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 8) {
                z = z2;
            } else {
                z = z2;
                if (childAt instanceof TableRow) {
                    TableRow tableRow = (TableRow) childAt;
                    tableRow.getLayoutParams().height = -2;
                    int[] columnsWidths = tableRow.getColumnsWidths(i);
                    int length = columnsWidths.length;
                    if (z2) {
                        if (this.mMaxWidths == null || this.mMaxWidths.length != length) {
                            this.mMaxWidths = new int[length];
                        }
                        System.arraycopy(columnsWidths, 0, this.mMaxWidths, 0, length);
                        z = false;
                    } else {
                        int length2 = this.mMaxWidths.length;
                        int i3 = length - length2;
                        if (i3 > 0) {
                            int[] iArr = this.mMaxWidths;
                            this.mMaxWidths = new int[length];
                            System.arraycopy(iArr, 0, this.mMaxWidths, 0, iArr.length);
                            System.arraycopy(columnsWidths, iArr.length, this.mMaxWidths, iArr.length, i3);
                        }
                        int[] iArr2 = this.mMaxWidths;
                        int min = Math.min(length2, length);
                        int i4 = 0;
                        while (true) {
                            int i5 = i4;
                            z = z2;
                            if (i5 < min) {
                                iArr2[i5] = Math.max(iArr2[i5], columnsWidths[i5]);
                                i4 = i5 + 1;
                            }
                        }
                    }
                }
            }
            i2++;
            z2 = z;
        }
    }

    private void initTableLayout() {
        if (this.mCollapsedColumns == null) {
            this.mCollapsedColumns = new SparseBooleanArray();
        }
        if (this.mStretchableColumns == null) {
            this.mStretchableColumns = new SparseBooleanArray();
        }
        if (this.mShrinkableColumns == null) {
            this.mShrinkableColumns = new SparseBooleanArray();
        }
        setOrientation(1);
        this.mPassThroughListener = new PassThroughHierarchyChangeListener();
        super.setOnHierarchyChangeListener(this.mPassThroughListener);
        this.mInitialized = true;
    }

    private void mutateColumnsWidth(SparseBooleanArray sparseBooleanArray, boolean z, int i, int i2) {
        int i3;
        int i4 = 0;
        int[] iArr = this.mMaxWidths;
        int length = iArr.length;
        int size = z ? length : sparseBooleanArray.size();
        int i5 = (i - i2) / size;
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt instanceof TableRow) {
                childAt.forceLayout();
            }
            i6 = i7 + 1;
        }
        if (z) {
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= size) {
                    return;
                }
                iArr[i9] = iArr[i9] + i5;
                i8 = i9 + 1;
            }
        } else {
            int i10 = 0;
            while (true) {
                int i11 = i10;
                i3 = i4;
                if (i11 >= size) {
                    break;
                }
                int keyAt = sparseBooleanArray.keyAt(i11);
                i4 = i3;
                if (sparseBooleanArray.valueAt(i11)) {
                    if (keyAt < length) {
                        iArr[keyAt] = iArr[keyAt] + i5;
                        i4 = i3;
                    } else {
                        i4 = i3 + 1;
                    }
                }
                i10 = i11 + 1;
            }
            if (i3 <= 0 || i3 >= size) {
                return;
            }
            int i12 = (i3 * i5) / (size - i3);
            int i13 = 0;
            while (true) {
                int i14 = i13;
                if (i14 >= size) {
                    return;
                }
                int keyAt2 = sparseBooleanArray.keyAt(i14);
                if (sparseBooleanArray.valueAt(i14) && keyAt2 < length) {
                    if (i12 > iArr[keyAt2]) {
                        iArr[keyAt2] = 0;
                    } else {
                        iArr[keyAt2] = iArr[keyAt2] + i12;
                    }
                }
                i13 = i14 + 1;
            }
        }
    }

    private static SparseBooleanArray parseColumns(String str) {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        String[] split = Pattern.compile("\\s*,\\s*").split(str);
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sparseBooleanArray;
            }
            try {
                int parseInt = Integer.parseInt(split[i2]);
                if (parseInt >= 0) {
                    sparseBooleanArray.put(parseInt, true);
                }
            } catch (NumberFormatException e) {
            }
            i = i2 + 1;
        }
    }

    private void requestRowsLayout() {
        if (!this.mInitialized) {
            return;
        }
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            getChildAt(i2).requestLayout();
            i = i2 + 1;
        }
    }

    private void shrinkAndStretchColumns(int i) {
        if (this.mMaxWidths == null) {
            return;
        }
        int i2 = 0;
        int[] iArr = this.mMaxWidths;
        int length = iArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            i2 += iArr[i4];
            i3 = i4 + 1;
        }
        int size = (View.MeasureSpec.getSize(i) - this.mPaddingLeft) - this.mPaddingRight;
        if (i2 > size && (this.mShrinkAllColumns || this.mShrinkableColumns.size() > 0)) {
            mutateColumnsWidth(this.mShrinkableColumns, this.mShrinkAllColumns, size, i2);
        } else if (i2 < size) {
            if (this.mStretchAllColumns || this.mStretchableColumns.size() > 0) {
                mutateColumnsWidth(this.mStretchableColumns, this.mStretchAllColumns, size, i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackCollapsedColumns(View view) {
        if (!(view instanceof TableRow)) {
            return;
        }
        TableRow tableRow = (TableRow) view;
        SparseBooleanArray sparseBooleanArray = this.mCollapsedColumns;
        int size = sparseBooleanArray.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            int keyAt = sparseBooleanArray.keyAt(i2);
            boolean valueAt = sparseBooleanArray.valueAt(i2);
            if (valueAt) {
                tableRow.setColumnCollapsed(keyAt, valueAt);
            }
            i = i2 + 1;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view);
        requestRowsLayout();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        super.addView(view, i);
        requestRowsLayout();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        requestRowsLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, layoutParams);
        requestRowsLayout();
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

    public boolean isColumnCollapsed(int i) {
        return this.mCollapsedColumns.get(i);
    }

    public boolean isColumnShrinkable(int i) {
        return this.mShrinkAllColumns || this.mShrinkableColumns.get(i);
    }

    public boolean isColumnStretchable(int i) {
        return this.mStretchAllColumns || this.mStretchableColumns.get(i);
    }

    public boolean isShrinkAllColumns() {
        return this.mShrinkAllColumns;
    }

    public boolean isStretchAllColumns() {
        return this.mStretchAllColumns;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.LinearLayout
    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        if (view instanceof TableRow) {
            ((TableRow) view).setColumnsWidthConstraints(this.mMaxWidths);
        }
        super.measureChildBeforeLayout(view, i, i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.LinearLayout
    public void measureVertical(int i, int i2) {
        findLargestCells(i);
        shrinkAndStretchColumns(i);
        super.measureVertical(i, i2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TableLayout.class.getName());
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TableLayout.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutVertical(i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        measureVertical(i, i2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInitialized) {
            int childCount = getChildCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                getChildAt(i2).forceLayout();
                i = i2 + 1;
            }
        }
        super.requestLayout();
    }

    public void setColumnCollapsed(int i, boolean z) {
        this.mCollapsedColumns.put(i, z);
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                requestRowsLayout();
                return;
            }
            View childAt = getChildAt(i3);
            if (childAt instanceof TableRow) {
                ((TableRow) childAt).setColumnCollapsed(i, z);
            }
            i2 = i3 + 1;
        }
    }

    public void setColumnShrinkable(int i, boolean z) {
        this.mShrinkableColumns.put(i, z);
        requestRowsLayout();
    }

    public void setColumnStretchable(int i, boolean z) {
        this.mStretchableColumns.put(i, z);
        requestRowsLayout();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mPassThroughListener.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setShrinkAllColumns(boolean z) {
        this.mShrinkAllColumns = z;
    }

    public void setStretchAllColumns(boolean z) {
        this.mStretchAllColumns = z;
    }
}
