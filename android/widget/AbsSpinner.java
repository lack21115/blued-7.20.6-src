package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import com.alipay.sdk.util.i;
import com.android.internal.R;

/* loaded from: source-4181928-dex2jar.jar:android/widget/AbsSpinner.class */
public abstract class AbsSpinner extends AdapterView<SpinnerAdapter> {
    SpinnerAdapter mAdapter;
    private DataSetObserver mDataSetObserver;
    int mHeightMeasureSpec;
    final RecycleBin mRecycler;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    final Rect mSpinnerPadding;
    private Rect mTouchFrame;
    int mWidthMeasureSpec;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsSpinner$RecycleBin.class */
    public class RecycleBin {
        private final SparseArray<View> mScrapHeap = new SparseArray<>();

        RecycleBin() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void clear() {
            SparseArray<View> sparseArray = this.mScrapHeap;
            int size = sparseArray.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    sparseArray.clear();
                    return;
                }
                View valueAt = sparseArray.valueAt(i2);
                if (valueAt != null) {
                    AbsSpinner.this.removeDetachedView(valueAt, true);
                }
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View get(int i) {
            View view = this.mScrapHeap.get(i);
            if (view != null) {
                this.mScrapHeap.delete(i);
            }
            return view;
        }

        public void put(int i, View view) {
            this.mScrapHeap.put(i, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/AbsSpinner$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.AbsSpinner.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int position;
        long selectedId;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.position = parcel.readInt();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "AbsSpinner.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " position=" + this.position + i.d;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeInt(this.position);
        }
    }

    public AbsSpinner(Context context) {
        super(context);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
    }

    public AbsSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public AbsSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mSpinnerPadding = new Rect();
        this.mRecycler = new RecycleBin();
        initAbsSpinner();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AbsSpinner, i, i2);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter = new ArrayAdapter(context, 17367048, textArray);
            arrayAdapter.setDropDownViewResource(17367049);
            setAdapter((SpinnerAdapter) arrayAdapter);
        }
        obtainStyledAttributes.recycle();
    }

    private void initAbsSpinner() {
        setFocusable(true);
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    @Override // android.widget.AdapterView
    public SpinnerAdapter getAdapter() {
        return this.mAdapter;
    }

    int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    int getChildWidth(View view) {
        return view.getMeasuredWidth();
    }

    @Override // android.widget.AdapterView
    public int getCount() {
        return this.mItemCount;
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        if (this.mItemCount <= 0 || this.mSelectedPosition < 0) {
            return null;
        }
        return getChildAt(this.mSelectedPosition - this.mFirstPosition);
    }

    abstract void layout(int i, boolean z);

    @Override // android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsSpinner.class.getName());
    }

    @Override // android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsSpinner.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        this.mSpinnerPadding.left = this.mPaddingLeft > this.mSelectionLeftPadding ? this.mPaddingLeft : this.mSelectionLeftPadding;
        this.mSpinnerPadding.top = this.mPaddingTop > this.mSelectionTopPadding ? this.mPaddingTop : this.mSelectionTopPadding;
        this.mSpinnerPadding.right = this.mPaddingRight > this.mSelectionRightPadding ? this.mPaddingRight : this.mSelectionRightPadding;
        this.mSpinnerPadding.bottom = this.mPaddingBottom > this.mSelectionBottomPadding ? this.mPaddingBottom : this.mSelectionBottomPadding;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        int selectedItemPosition = getSelectedItemPosition();
        boolean z = true;
        int i3 = 0;
        int i4 = 0;
        if (selectedItemPosition >= 0) {
            z = true;
            i3 = 0;
            i4 = 0;
            if (this.mAdapter != null) {
                z = true;
                i3 = 0;
                i4 = 0;
                if (selectedItemPosition < this.mAdapter.getCount()) {
                    View view = this.mRecycler.get(selectedItemPosition);
                    View view2 = view;
                    if (view == null) {
                        View view3 = this.mAdapter.getView(selectedItemPosition, null, this);
                        view2 = view3;
                        if (view3.getImportantForAccessibility() == 0) {
                            view3.setImportantForAccessibility(1);
                            view2 = view3;
                        }
                    }
                    z = true;
                    i3 = 0;
                    i4 = 0;
                    if (view2 != null) {
                        this.mRecycler.put(selectedItemPosition, view2);
                        if (view2.getLayoutParams() == null) {
                            this.mBlockLayoutRequests = true;
                            view2.setLayoutParams(generateDefaultLayoutParams());
                            this.mBlockLayoutRequests = false;
                        }
                        measureChild(view2, i, i2);
                        i3 = getChildHeight(view2) + this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
                        i4 = getChildWidth(view2) + this.mSpinnerPadding.left + this.mSpinnerPadding.right;
                        z = false;
                    }
                }
            }
        }
        int i5 = i3;
        int i6 = i4;
        if (z) {
            int i7 = this.mSpinnerPadding.top + this.mSpinnerPadding.bottom;
            i5 = i7;
            i6 = i4;
            if (mode == 0) {
                i6 = this.mSpinnerPadding.left + this.mSpinnerPadding.right;
                i5 = i7;
            }
        }
        setMeasuredDimension(resolveSizeAndState(Math.max(i6, getSuggestedMinimumWidth()), i, 0), resolveSizeAndState(Math.max(i5, getSuggestedMinimumHeight()), i2, 0));
        this.mHeightMeasureSpec = i2;
        this.mWidthMeasureSpec = i;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.selectedId >= 0) {
            this.mDataChanged = true;
            this.mNeedSync = true;
            this.mSyncRowId = savedState.selectedId;
            this.mSyncPosition = savedState.position;
            this.mSyncMode = 0;
            requestLayout();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.selectedId = getSelectedItemId();
        if (savedState.selectedId >= 0) {
            savedState.position = getSelectedItemPosition();
            return savedState;
        }
        savedState.position = -1;
        return savedState;
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.mTouchFrame;
        Rect rect2 = rect;
        if (rect == null) {
            this.mTouchFrame = new Rect();
            rect2 = this.mTouchFrame;
        }
        int childCount = getChildCount();
        while (true) {
            int i3 = childCount - 1;
            if (i3 < 0) {
                return -1;
            }
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect2);
                if (rect2.contains(i, i2)) {
                    return this.mFirstPosition + i3;
                }
            }
            childCount = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recycleAllViews() {
        int childCount = getChildCount();
        RecycleBin recycleBin = this.mRecycler;
        int i = this.mFirstPosition;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                return;
            }
            recycleBin.put(i + i3, getChildAt(i3));
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mBlockLayoutRequests) {
            return;
        }
        super.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetList() {
        this.mDataChanged = false;
        this.mNeedSync = false;
        removeAllViewsInLayout();
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        invalidate();
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        int i = -1;
        if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mDataSetObserver);
            resetList();
        }
        this.mAdapter = spinnerAdapter;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedRowId = Long.MIN_VALUE;
        if (this.mAdapter != null) {
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            checkFocus();
            this.mDataSetObserver = new AdapterView.AdapterDataSetObserver();
            this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
            if (this.mItemCount > 0) {
                i = 0;
            }
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            checkFocus();
            resetList();
            checkSelectionChanged();
        }
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        setNextSelectedPositionInt(i);
        requestLayout();
        invalidate();
    }

    public void setSelection(int i, boolean z) {
        setSelectionInt(i, z && this.mFirstPosition <= i && i <= (this.mFirstPosition + getChildCount()) - 1);
    }

    void setSelectionInt(int i, boolean z) {
        if (i != this.mOldSelectedPosition) {
            this.mBlockLayoutRequests = true;
            int i2 = this.mSelectedPosition;
            setNextSelectedPositionInt(i);
            layout(i - i2, z);
            this.mBlockLayoutRequests = false;
        }
    }
}
