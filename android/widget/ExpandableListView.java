package android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.ExpandableListConnector;
import com.android.internal.R;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListView.class */
public class ExpandableListView extends ListView {
    public static final int CHILD_INDICATOR_INHERIT = -1;
    private static final int INDICATOR_UNDEFINED = -2;
    private static final long PACKED_POSITION_INT_MASK_CHILD = -1;
    private static final long PACKED_POSITION_INT_MASK_GROUP = 2147483647L;
    private static final long PACKED_POSITION_MASK_CHILD = 4294967295L;
    private static final long PACKED_POSITION_MASK_GROUP = 9223372032559808512L;
    private static final long PACKED_POSITION_MASK_TYPE = Long.MIN_VALUE;
    private static final long PACKED_POSITION_SHIFT_GROUP = 32;
    private static final long PACKED_POSITION_SHIFT_TYPE = 63;
    public static final int PACKED_POSITION_TYPE_CHILD = 1;
    public static final int PACKED_POSITION_TYPE_GROUP = 0;
    public static final int PACKED_POSITION_TYPE_NULL = 2;
    public static final long PACKED_POSITION_VALUE_NULL = 4294967295L;
    private ExpandableListAdapter mAdapter;
    private Drawable mChildDivider;
    private Drawable mChildIndicator;
    private int mChildIndicatorEnd;
    private int mChildIndicatorLeft;
    private int mChildIndicatorRight;
    private int mChildIndicatorStart;
    private ExpandableListConnector mConnector;
    private Drawable mGroupIndicator;
    private int mIndicatorEnd;
    private int mIndicatorLeft;
    private final Rect mIndicatorRect;
    private int mIndicatorRight;
    private int mIndicatorStart;
    private OnChildClickListener mOnChildClickListener;
    private OnGroupClickListener mOnGroupClickListener;
    private OnGroupCollapseListener mOnGroupCollapseListener;
    private OnGroupExpandListener mOnGroupExpandListener;
    private static final int[] EMPTY_STATE_SET = new int[0];
    private static final int[] GROUP_EXPANDED_STATE_SET = {R.attr.state_expanded};
    private static final int[] GROUP_EMPTY_STATE_SET = {R.attr.state_empty};
    private static final int[] GROUP_EXPANDED_EMPTY_STATE_SET = {R.attr.state_expanded, R.attr.state_empty};
    private static final int[][] GROUP_STATE_SETS = {EMPTY_STATE_SET, GROUP_EXPANDED_STATE_SET, GROUP_EMPTY_STATE_SET, GROUP_EXPANDED_EMPTY_STATE_SET};
    private static final int[] CHILD_LAST_STATE_SET = {R.attr.state_last};

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListView$ExpandableListContextMenuInfo.class */
    public static class ExpandableListContextMenuInfo implements ContextMenu.ContextMenuInfo {
        public long id;
        public long packedPosition;
        public View targetView;

        public ExpandableListContextMenuInfo(View view, long j, long j2) {
            this.targetView = view;
            this.packedPosition = j;
            this.id = j2;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListView$OnChildClickListener.class */
    public interface OnChildClickListener {
        boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListView$OnGroupClickListener.class */
    public interface OnGroupClickListener {
        boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListView$OnGroupCollapseListener.class */
    public interface OnGroupCollapseListener {
        void onGroupCollapse(int i);
    }

    /* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListView$OnGroupExpandListener.class */
    public interface OnGroupExpandListener {
        void onGroupExpand(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/widget/ExpandableListView$SavedState.class */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.widget.ExpandableListView.SavedState.1
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
        ArrayList<ExpandableListConnector.GroupMetadata> expandedGroupMetadataList;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.expandedGroupMetadataList = new ArrayList<>();
            parcel.readList(this.expandedGroupMetadataList, ExpandableListConnector.class.getClassLoader());
        }

        SavedState(Parcelable parcelable, ArrayList<ExpandableListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.expandedGroupMetadataList = arrayList;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.expandedGroupMetadataList);
        }
    }

    public ExpandableListView(Context context) {
        this(context, null);
    }

    public ExpandableListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.expandableListViewStyle);
    }

    public ExpandableListView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ExpandableListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mIndicatorRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableListView, i, i2);
        this.mGroupIndicator = obtainStyledAttributes.getDrawable(0);
        this.mChildIndicator = obtainStyledAttributes.getDrawable(1);
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.mIndicatorRight = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        if (this.mIndicatorRight == 0 && this.mGroupIndicator != null) {
            this.mIndicatorRight = this.mIndicatorLeft + this.mGroupIndicator.getIntrinsicWidth();
        }
        this.mChildIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(4, -1);
        this.mChildIndicatorRight = obtainStyledAttributes.getDimensionPixelSize(5, -1);
        this.mChildDivider = obtainStyledAttributes.getDrawable(6);
        if (!isRtlCompatibilityMode()) {
            this.mIndicatorStart = obtainStyledAttributes.getDimensionPixelSize(7, -2);
            this.mIndicatorEnd = obtainStyledAttributes.getDimensionPixelSize(8, -2);
            this.mChildIndicatorStart = obtainStyledAttributes.getDimensionPixelSize(9, -1);
            this.mChildIndicatorEnd = obtainStyledAttributes.getDimensionPixelSize(10, -1);
        }
        obtainStyledAttributes.recycle();
    }

    private int getAbsoluteFlatPosition(int i) {
        return getHeaderViewsCount() + i;
    }

    private long getChildOrGroupId(ExpandableListPosition expandableListPosition) {
        return expandableListPosition.type == 1 ? this.mAdapter.getChildId(expandableListPosition.groupPos, expandableListPosition.childPos) : this.mAdapter.getGroupId(expandableListPosition.groupPos);
    }

    private int getFlatPositionForConnector(int i) {
        return i - getHeaderViewsCount();
    }

    private Drawable getIndicator(ExpandableListConnector.PositionMetadata positionMetadata) {
        Drawable drawable;
        int i = 1;
        int i2 = 0;
        if (positionMetadata.position.type == 2) {
            Drawable drawable2 = this.mGroupIndicator;
            drawable = drawable2;
            if (drawable2 != null) {
                drawable = drawable2;
                if (drawable2.isStateful()) {
                    boolean z = positionMetadata.groupMetadata == null || positionMetadata.groupMetadata.lastChildFlPos == positionMetadata.groupMetadata.flPos;
                    if (!positionMetadata.isExpanded()) {
                        i = 0;
                    }
                    if (z) {
                        i2 = 2;
                    }
                    drawable2.setState(GROUP_STATE_SETS[i | i2]);
                    drawable = drawable2;
                }
            }
        } else {
            Drawable drawable3 = this.mChildIndicator;
            drawable = drawable3;
            if (drawable3 != null) {
                drawable = drawable3;
                if (drawable3.isStateful()) {
                    drawable3.setState(positionMetadata.position.flatListPos == positionMetadata.groupMetadata.lastChildFlPos ? CHILD_LAST_STATE_SET : EMPTY_STATE_SET);
                    return drawable3;
                }
            }
        }
        return drawable;
    }

    public static int getPackedPositionChild(long j) {
        if (j != 4294967295L && (j & Long.MIN_VALUE) == Long.MIN_VALUE) {
            return (int) (j & 4294967295L);
        }
        return -1;
    }

    public static long getPackedPositionForChild(int i, int i2) {
        return Long.MIN_VALUE | ((i & PACKED_POSITION_INT_MASK_GROUP) << PACKED_POSITION_SHIFT_GROUP) | (i2 & (-1));
    }

    public static long getPackedPositionForGroup(int i) {
        return (i & PACKED_POSITION_INT_MASK_GROUP) << PACKED_POSITION_SHIFT_GROUP;
    }

    public static int getPackedPositionGroup(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((PACKED_POSITION_MASK_GROUP & j) >> PACKED_POSITION_SHIFT_GROUP);
    }

    public static int getPackedPositionType(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    private boolean hasRtlSupport() {
        return this.mContext.getApplicationInfo().hasRtlSupport();
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private boolean isRtlCompatibilityMode() {
        boolean z = false;
        int i = this.mContext.getApplicationInfo().targetSdkVersion;
        boolean z2 = (this.mContext.getApplicationInfo().flags & 1) != 0;
        if ((i < 17 && !z2) || !hasRtlSupport()) {
            z = true;
        }
        return z;
    }

    private void resolveChildIndicator() {
        if (isLayoutRtl()) {
            if (this.mChildIndicatorStart >= -1) {
                this.mChildIndicatorRight = this.mChildIndicatorStart;
            }
            if (this.mChildIndicatorEnd >= -1) {
                this.mChildIndicatorLeft = this.mChildIndicatorEnd;
                return;
            }
            return;
        }
        if (this.mChildIndicatorStart >= -1) {
            this.mChildIndicatorLeft = this.mChildIndicatorStart;
        }
        if (this.mChildIndicatorEnd >= -1) {
            this.mChildIndicatorRight = this.mChildIndicatorEnd;
        }
    }

    private void resolveIndicator() {
        if (isLayoutRtl()) {
            if (this.mIndicatorStart >= 0) {
                this.mIndicatorRight = this.mIndicatorStart;
            }
            if (this.mIndicatorEnd >= 0) {
                this.mIndicatorLeft = this.mIndicatorEnd;
            }
        } else {
            if (this.mIndicatorStart >= 0) {
                this.mIndicatorLeft = this.mIndicatorStart;
            }
            if (this.mIndicatorEnd >= 0) {
                this.mIndicatorRight = this.mIndicatorEnd;
            }
        }
        if (this.mIndicatorRight != 0 || this.mGroupIndicator == null) {
            return;
        }
        this.mIndicatorRight = this.mIndicatorLeft + this.mGroupIndicator.getIntrinsicWidth();
    }

    public boolean collapseGroup(int i) {
        boolean collapseGroup = this.mConnector.collapseGroup(i);
        if (this.mOnGroupCollapseListener != null) {
            this.mOnGroupCollapseListener.onGroupCollapse(i);
        }
        return collapseGroup;
    }

    @Override // android.widget.AbsListView
    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return new AdapterView.AdapterContextMenuInfo(view, i, j);
        }
        ExpandableListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(getFlatPositionForConnector(i));
        ExpandableListPosition expandableListPosition = unflattenedPos.position;
        long childOrGroupId = getChildOrGroupId(expandableListPosition);
        long packedPosition = expandableListPosition.getPackedPosition();
        unflattenedPos.recycle();
        return new ExpandableListContextMenuInfo(view, packedPosition, childOrGroupId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int i;
        super.dispatchDraw(canvas);
        if (this.mChildIndicator == null && this.mGroupIndicator == null) {
            return;
        }
        int i2 = 0;
        boolean z = (this.mGroupFlags & 34) == 34;
        if (z) {
            i2 = canvas.save();
            int i3 = this.mScrollX;
            int i4 = this.mScrollY;
            canvas.clipRect(this.mPaddingLeft + i3, this.mPaddingTop + i4, ((this.mRight + i3) - this.mLeft) - this.mPaddingRight, ((this.mBottom + i4) - this.mTop) - this.mPaddingBottom);
        }
        int headerViewsCount = getHeaderViewsCount();
        int i5 = this.mItemCount;
        int footerViewsCount = getFooterViewsCount();
        int i6 = this.mBottom;
        int i7 = -4;
        Rect rect = this.mIndicatorRect;
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = this.mFirstPosition - headerViewsCount;
        while (i8 < childCount) {
            if (i9 < 0) {
                i = i7;
            } else if (i9 > ((i5 - footerViewsCount) - headerViewsCount) - 1) {
                break;
            } else {
                View childAt = getChildAt(i8);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                i = i7;
                if (bottom >= 0) {
                    i = i7;
                    if (top <= i6) {
                        ExpandableListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(i9);
                        boolean isLayoutRtl = isLayoutRtl();
                        int width = getWidth();
                        i = i7;
                        if (unflattenedPos.position.type != i7) {
                            if (unflattenedPos.position.type != 1) {
                                rect.left = isLayoutRtl ? width - this.mIndicatorRight : this.mIndicatorLeft;
                                rect.right = isLayoutRtl ? width - this.mIndicatorLeft : this.mIndicatorRight;
                            } else if (isLayoutRtl) {
                                rect.left = this.mChildIndicatorLeft == -1 ? this.mRight - this.mIndicatorRight : this.mRight - this.mChildIndicatorRight;
                                rect.right = this.mChildIndicatorRight == -1 ? this.mRight - this.mIndicatorLeft : this.mRight - this.mChildIndicatorLeft;
                            } else {
                                rect.left = this.mChildIndicatorLeft == -1 ? this.mIndicatorLeft : this.mChildIndicatorLeft;
                                rect.right = this.mChildIndicatorRight == -1 ? this.mIndicatorRight : this.mChildIndicatorRight;
                            }
                            rect.left = (isLayoutRtl ? -this.mPaddingRight : this.mPaddingLeft) + rect.left;
                            rect.right = (isLayoutRtl ? -this.mPaddingRight : this.mPaddingLeft) + rect.right;
                            i = unflattenedPos.position.type;
                        }
                        if (rect.left != rect.right) {
                            if (this.mStackFromBottom) {
                                rect.top = top;
                                rect.bottom = bottom;
                            } else {
                                rect.top = top;
                                rect.bottom = bottom;
                            }
                            Drawable indicator = getIndicator(unflattenedPos);
                            if (indicator != null) {
                                indicator.setBounds(rect);
                                indicator.draw(canvas);
                            }
                        }
                        unflattenedPos.recycle();
                    }
                }
            }
            i8++;
            i9++;
            i7 = i;
        }
        if (z) {
            canvas.restoreToCount(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.widget.ListView
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        int i2 = i + this.mFirstPosition;
        if (i2 >= 0) {
            ExpandableListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(getFlatPositionForConnector(i2));
            if (unflattenedPos.position.type == 1 || (unflattenedPos.isExpanded() && unflattenedPos.groupMetadata.lastChildFlPos != unflattenedPos.groupMetadata.flPos)) {
                Drawable drawable = this.mChildDivider;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                unflattenedPos.recycle();
                return;
            }
            unflattenedPos.recycle();
        }
        super.drawDivider(canvas, rect, i2);
    }

    public boolean expandGroup(int i) {
        return expandGroup(i, false);
    }

    public boolean expandGroup(int i, boolean z) {
        ExpandableListPosition obtain = ExpandableListPosition.obtain(2, i, -1, -1);
        ExpandableListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtain);
        obtain.recycle();
        boolean expandGroup = this.mConnector.expandGroup(flattenedPos);
        if (this.mOnGroupExpandListener != null) {
            this.mOnGroupExpandListener.onGroupExpand(i);
        }
        if (z) {
            int headerViewsCount = flattenedPos.position.flatListPos + getHeaderViewsCount();
            smoothScrollToPosition(this.mAdapter.getChildrenCount(i) + headerViewsCount, headerViewsCount);
        }
        flattenedPos.recycle();
        return expandGroup;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.mAdapter;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(getFlatPositionForConnector(i));
        long packedPosition = unflattenedPos.position.getPackedPosition();
        unflattenedPos.recycle();
        return packedPosition;
    }

    public int getFlatListPosition(long j) {
        ExpandableListPosition obtainPosition = ExpandableListPosition.obtainPosition(j);
        ExpandableListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtainPosition);
        obtainPosition.recycle();
        int i = flattenedPos.position.flatListPos;
        flattenedPos.recycle();
        return getAbsoluteFlatPosition(i);
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int packedPositionGroup = getPackedPositionGroup(selectedPosition);
        return getPackedPositionType(selectedPosition) == 0 ? this.mAdapter.getGroupId(packedPositionGroup) : this.mAdapter.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public long getSelectedPosition() {
        return getExpandableListPosition(getSelectedItemPosition());
    }

    boolean handleItemClick(View view, int i, long j) {
        boolean z;
        ExpandableListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(i);
        long childOrGroupId = getChildOrGroupId(unflattenedPos.position);
        if (unflattenedPos.position.type == 2) {
            if (this.mOnGroupClickListener != null && this.mOnGroupClickListener.onGroupClick(this, view, unflattenedPos.position.groupPos, childOrGroupId)) {
                unflattenedPos.recycle();
                return true;
            }
            if (unflattenedPos.isExpanded()) {
                this.mConnector.collapseGroup(unflattenedPos);
                playSoundEffect(0);
                if (this.mOnGroupCollapseListener != null) {
                    this.mOnGroupCollapseListener.onGroupCollapse(unflattenedPos.position.groupPos);
                }
            } else {
                this.mConnector.expandGroup(unflattenedPos);
                playSoundEffect(0);
                if (this.mOnGroupExpandListener != null) {
                    this.mOnGroupExpandListener.onGroupExpand(unflattenedPos.position.groupPos);
                }
                int i2 = unflattenedPos.position.groupPos;
                int headerViewsCount = unflattenedPos.position.flatListPos + getHeaderViewsCount();
                smoothScrollToPosition(this.mAdapter.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            z = true;
        } else if (this.mOnChildClickListener != null) {
            playSoundEffect(0);
            return this.mOnChildClickListener.onChildClick(this, view, unflattenedPos.position.groupPos, unflattenedPos.position.childPos, childOrGroupId);
        } else {
            z = false;
        }
        unflattenedPos.recycle();
        return z;
    }

    public boolean isGroupExpanded(int i) {
        return this.mConnector.isGroupExpanded(i);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableListView.class.getName());
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableListView.class.getName());
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (this.mConnector == null || savedState.expandedGroupMetadataList == null) {
            return;
        }
        this.mConnector.setExpandedGroupMetadataList(savedState.expandedGroupMetadataList);
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRtlPropertiesChanged(int i) {
        resolveIndicator();
        resolveChildIndicator();
    }

    @Override // android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.mConnector != null ? this.mConnector.getExpandedGroupMetadataList() : null);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        return isHeaderOrFooterPosition(i) ? super.performItemClick(view, i, j) : handleItemClick(view, getFlatPositionForConnector(i), j);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.mAdapter = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.mConnector = new ExpandableListConnector(expandableListAdapter);
        } else {
            this.mConnector = null;
        }
        super.setAdapter((ListAdapter) this.mConnector);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    public void setChildDivider(Drawable drawable) {
        this.mChildDivider = drawable;
    }

    public void setChildIndicator(Drawable drawable) {
        this.mChildIndicator = drawable;
    }

    public void setChildIndicatorBounds(int i, int i2) {
        this.mChildIndicatorLeft = i;
        this.mChildIndicatorRight = i2;
        resolveChildIndicator();
    }

    public void setChildIndicatorBoundsRelative(int i, int i2) {
        this.mChildIndicatorStart = i;
        this.mChildIndicatorEnd = i2;
        resolveChildIndicator();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.mGroupIndicator = drawable;
        if (this.mIndicatorRight != 0 || this.mGroupIndicator == null) {
            return;
        }
        this.mIndicatorRight = this.mIndicatorLeft + this.mGroupIndicator.getIntrinsicWidth();
    }

    public void setIndicatorBounds(int i, int i2) {
        this.mIndicatorLeft = i;
        this.mIndicatorRight = i2;
        resolveIndicator();
    }

    public void setIndicatorBoundsRelative(int i, int i2) {
        this.mIndicatorStart = i;
        this.mIndicatorEnd = i2;
        resolveIndicator();
    }

    public void setOnChildClickListener(OnChildClickListener onChildClickListener) {
        this.mOnChildClickListener = onChildClickListener;
    }

    public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
        this.mOnGroupClickListener = onGroupClickListener;
    }

    public void setOnGroupCollapseListener(OnGroupCollapseListener onGroupCollapseListener) {
        this.mOnGroupCollapseListener = onGroupCollapseListener;
    }

    public void setOnGroupExpandListener(OnGroupExpandListener onGroupExpandListener) {
        this.mOnGroupExpandListener = onGroupExpandListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
    }

    public boolean setSelectedChild(int i, int i2, boolean z) {
        ExpandableListPosition obtainChildPosition = ExpandableListPosition.obtainChildPosition(i, i2);
        ExpandableListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtainChildPosition);
        ExpandableListConnector.PositionMetadata positionMetadata = flattenedPos;
        if (flattenedPos == null) {
            if (!z) {
                return false;
            }
            expandGroup(i);
            ExpandableListConnector.PositionMetadata flattenedPos2 = this.mConnector.getFlattenedPos(obtainChildPosition);
            positionMetadata = flattenedPos2;
            if (flattenedPos2 == null) {
                throw new IllegalStateException("Could not find child");
            }
        }
        super.setSelection(getAbsoluteFlatPosition(positionMetadata.position.flatListPos));
        obtainChildPosition.recycle();
        positionMetadata.recycle();
        return true;
    }

    public void setSelectedGroup(int i) {
        ExpandableListPosition obtainGroupPosition = ExpandableListPosition.obtainGroupPosition(i);
        ExpandableListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtainGroupPosition);
        obtainGroupPosition.recycle();
        super.setSelection(getAbsoluteFlatPosition(flattenedPos.position.flatListPos));
        flattenedPos.recycle();
    }
}
