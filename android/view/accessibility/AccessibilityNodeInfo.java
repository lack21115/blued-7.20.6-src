package android.view.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.LongArray;
import android.util.Pools;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityNodeInfo.class */
public class AccessibilityNodeInfo implements Parcelable {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    private static final int ACTION_TYPE_MASK = -16777216;
    public static final int ACTIVE_WINDOW_ID = Integer.MAX_VALUE;
    public static final int ANY_WINDOW_ID = -2;
    private static final int BOOLEAN_PROPERTY_ACCESSIBILITY_FOCUSED = 1024;
    private static final int BOOLEAN_PROPERTY_CHECKABLE = 1;
    private static final int BOOLEAN_PROPERTY_CHECKED = 2;
    private static final int BOOLEAN_PROPERTY_CLICKABLE = 32;
    private static final int BOOLEAN_PROPERTY_CONTENT_INVALID = 65536;
    private static final int BOOLEAN_PROPERTY_DISMISSABLE = 16384;
    private static final int BOOLEAN_PROPERTY_EDITABLE = 4096;
    private static final int BOOLEAN_PROPERTY_ENABLED = 128;
    private static final int BOOLEAN_PROPERTY_FOCUSABLE = 4;
    private static final int BOOLEAN_PROPERTY_FOCUSED = 8;
    private static final int BOOLEAN_PROPERTY_LONG_CLICKABLE = 64;
    private static final int BOOLEAN_PROPERTY_MULTI_LINE = 32768;
    private static final int BOOLEAN_PROPERTY_OPENS_POPUP = 8192;
    private static final int BOOLEAN_PROPERTY_PASSWORD = 256;
    private static final int BOOLEAN_PROPERTY_SCROLLABLE = 512;
    private static final int BOOLEAN_PROPERTY_SELECTED = 16;
    private static final int BOOLEAN_PROPERTY_VISIBLE_TO_USER = 2048;
    private static final boolean DEBUG = false;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 8;
    public static final int FLAG_PREFETCH_DESCENDANTS = 4;
    public static final int FLAG_PREFETCH_PREDECESSORS = 1;
    public static final int FLAG_PREFETCH_SIBLINGS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final int LAST_LEGACY_STANDARD_ACTION = 2097152;
    private static final int MAX_POOL_SIZE = 50;
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    public static final int UNDEFINED_CONNECTION_ID = -1;
    public static final int UNDEFINED_ITEM_ID = Integer.MAX_VALUE;
    public static final int UNDEFINED_SELECTION_INDEX = -1;
    private static final long VIRTUAL_DESCENDANT_ID_MASK = -4294967296L;
    private static final int VIRTUAL_DESCENDANT_ID_SHIFT = 32;
    private ArrayList<AccessibilityAction> mActions;
    private int mBooleanProperties;
    private LongArray mChildNodeIds;
    private CharSequence mClassName;
    private CollectionInfo mCollectionInfo;
    private CollectionItemInfo mCollectionItemInfo;
    private CharSequence mContentDescription;
    private CharSequence mError;
    private Bundle mExtras;
    private int mMovementGranularities;
    private CharSequence mPackageName;
    private RangeInfo mRangeInfo;
    private boolean mSealed;
    private CharSequence mText;
    private String mViewIdResourceName;
    public static final long ROOT_NODE_ID = makeNodeId(Integer.MAX_VALUE, Integer.MAX_VALUE);
    private static final Pools.SynchronizedPool<AccessibilityNodeInfo> sPool = new Pools.SynchronizedPool<>(50);
    public static final Parcelable.Creator<AccessibilityNodeInfo> CREATOR = new Parcelable.Creator<AccessibilityNodeInfo>() { // from class: android.view.accessibility.AccessibilityNodeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccessibilityNodeInfo createFromParcel(Parcel parcel) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
            obtain.initFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccessibilityNodeInfo[] newArray(int i) {
            return new AccessibilityNodeInfo[i];
        }
    };
    private int mWindowId = Integer.MAX_VALUE;
    private long mSourceNodeId = ROOT_NODE_ID;
    private long mParentNodeId = ROOT_NODE_ID;
    private long mLabelForId = ROOT_NODE_ID;
    private long mLabeledById = ROOT_NODE_ID;
    private long mTraversalBefore = ROOT_NODE_ID;
    private long mTraversalAfter = ROOT_NODE_ID;
    private final Rect mBoundsInParent = new Rect();
    private final Rect mBoundsInScreen = new Rect();
    private int mMaxTextLength = -1;
    private int mTextSelectionStart = -1;
    private int mTextSelectionEnd = -1;
    private int mInputType = 0;
    private int mLiveRegion = 0;
    private int mConnectionId = -1;

    /* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityNodeInfo$AccessibilityAction.class */
    public static final class AccessibilityAction {
        private final int mActionId;
        private final CharSequence mLabel;
        public static final AccessibilityAction ACTION_FOCUS = new AccessibilityAction(1, null);
        public static final AccessibilityAction ACTION_CLEAR_FOCUS = new AccessibilityAction(2, null);
        public static final AccessibilityAction ACTION_SELECT = new AccessibilityAction(4, null);
        public static final AccessibilityAction ACTION_CLEAR_SELECTION = new AccessibilityAction(8, null);
        public static final AccessibilityAction ACTION_CLICK = new AccessibilityAction(16, null);
        public static final AccessibilityAction ACTION_LONG_CLICK = new AccessibilityAction(32, null);
        public static final AccessibilityAction ACTION_ACCESSIBILITY_FOCUS = new AccessibilityAction(64, null);
        public static final AccessibilityAction ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityAction(128, null);
        public static final AccessibilityAction ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityAction(256, null);
        public static final AccessibilityAction ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityAction(512, null);
        public static final AccessibilityAction ACTION_NEXT_HTML_ELEMENT = new AccessibilityAction(1024, null);
        public static final AccessibilityAction ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityAction(2048, null);
        public static final AccessibilityAction ACTION_SCROLL_FORWARD = new AccessibilityAction(4096, null);
        public static final AccessibilityAction ACTION_SCROLL_BACKWARD = new AccessibilityAction(8192, null);
        public static final AccessibilityAction ACTION_COPY = new AccessibilityAction(16384, null);
        public static final AccessibilityAction ACTION_PASTE = new AccessibilityAction(32768, null);
        public static final AccessibilityAction ACTION_CUT = new AccessibilityAction(65536, null);
        public static final AccessibilityAction ACTION_SET_SELECTION = new AccessibilityAction(131072, null);
        public static final AccessibilityAction ACTION_EXPAND = new AccessibilityAction(262144, null);
        public static final AccessibilityAction ACTION_COLLAPSE = new AccessibilityAction(524288, null);
        public static final AccessibilityAction ACTION_DISMISS = new AccessibilityAction(1048576, null);
        public static final AccessibilityAction ACTION_SET_TEXT = new AccessibilityAction(2097152, null);
        private static final ArraySet<AccessibilityAction> sStandardActions = new ArraySet<>();

        static {
            sStandardActions.add(ACTION_FOCUS);
            sStandardActions.add(ACTION_CLEAR_FOCUS);
            sStandardActions.add(ACTION_SELECT);
            sStandardActions.add(ACTION_CLEAR_SELECTION);
            sStandardActions.add(ACTION_CLICK);
            sStandardActions.add(ACTION_LONG_CLICK);
            sStandardActions.add(ACTION_ACCESSIBILITY_FOCUS);
            sStandardActions.add(ACTION_CLEAR_ACCESSIBILITY_FOCUS);
            sStandardActions.add(ACTION_NEXT_AT_MOVEMENT_GRANULARITY);
            sStandardActions.add(ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY);
            sStandardActions.add(ACTION_NEXT_HTML_ELEMENT);
            sStandardActions.add(ACTION_PREVIOUS_HTML_ELEMENT);
            sStandardActions.add(ACTION_SCROLL_FORWARD);
            sStandardActions.add(ACTION_SCROLL_BACKWARD);
            sStandardActions.add(ACTION_COPY);
            sStandardActions.add(ACTION_PASTE);
            sStandardActions.add(ACTION_CUT);
            sStandardActions.add(ACTION_SET_SELECTION);
            sStandardActions.add(ACTION_EXPAND);
            sStandardActions.add(ACTION_COLLAPSE);
            sStandardActions.add(ACTION_DISMISS);
            sStandardActions.add(ACTION_SET_TEXT);
        }

        public AccessibilityAction(int i, CharSequence charSequence) {
            if (((-16777216) & i) == 0 && Integer.bitCount(i) != 1) {
                throw new IllegalArgumentException("Invalid standard action id");
            }
            this.mActionId = i;
            this.mLabel = charSequence;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (getClass() == obj.getClass()) {
                if (this.mActionId != ((AccessibilityAction) obj).mActionId) {
                    z = false;
                }
                return z;
            }
            return false;
        }

        public int getId() {
            return this.mActionId;
        }

        public CharSequence getLabel() {
            return this.mLabel;
        }

        public int hashCode() {
            return this.mActionId;
        }

        public String toString() {
            return "AccessibilityAction: " + AccessibilityNodeInfo.getActionSymbolicName(this.mActionId) + " - " + ((Object) this.mLabel);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityNodeInfo$CollectionInfo.class */
    public static final class CollectionInfo {
        private static final int MAX_POOL_SIZE = 20;
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;
        private static final Pools.SynchronizedPool<CollectionInfo> sPool = new Pools.SynchronizedPool<>(20);
        private int mColumnCount;
        private boolean mHierarchical;
        private int mRowCount;
        private int mSelectionMode;

        private CollectionInfo(int i, int i2, boolean z, int i3) {
            this.mRowCount = i;
            this.mColumnCount = i2;
            this.mHierarchical = z;
            this.mSelectionMode = i3;
        }

        private void clear() {
            this.mRowCount = 0;
            this.mColumnCount = 0;
            this.mHierarchical = false;
            this.mSelectionMode = 0;
        }

        public static CollectionInfo obtain(int i, int i2, boolean z) {
            return obtain(i, i2, z, 0);
        }

        public static CollectionInfo obtain(int i, int i2, boolean z, int i3) {
            CollectionInfo collectionInfo = (CollectionInfo) sPool.acquire();
            if (collectionInfo == null) {
                return new CollectionInfo(i, i2, z, i3);
            }
            collectionInfo.mRowCount = i;
            collectionInfo.mColumnCount = i2;
            collectionInfo.mHierarchical = z;
            collectionInfo.mSelectionMode = i3;
            return collectionInfo;
        }

        public static CollectionInfo obtain(CollectionInfo collectionInfo) {
            return obtain(collectionInfo.mRowCount, collectionInfo.mColumnCount, collectionInfo.mHierarchical, collectionInfo.mSelectionMode);
        }

        public int getColumnCount() {
            return this.mColumnCount;
        }

        public int getRowCount() {
            return this.mRowCount;
        }

        public int getSelectionMode() {
            return this.mSelectionMode;
        }

        public boolean isHierarchical() {
            return this.mHierarchical;
        }

        void recycle() {
            clear();
            sPool.release(this);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityNodeInfo$CollectionItemInfo.class */
    public static final class CollectionItemInfo {
        private static final int MAX_POOL_SIZE = 20;
        private static final Pools.SynchronizedPool<CollectionItemInfo> sPool = new Pools.SynchronizedPool<>(20);
        private int mColumnIndex;
        private int mColumnSpan;
        private boolean mHeading;
        private int mRowIndex;
        private int mRowSpan;
        private boolean mSelected;

        private CollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            this.mRowIndex = i;
            this.mRowSpan = i2;
            this.mColumnIndex = i3;
            this.mColumnSpan = i4;
            this.mHeading = z;
            this.mSelected = z2;
        }

        private void clear() {
            this.mColumnIndex = 0;
            this.mColumnSpan = 0;
            this.mRowIndex = 0;
            this.mRowSpan = 0;
            this.mHeading = false;
            this.mSelected = false;
        }

        public static CollectionItemInfo obtain(int i, int i2, int i3, int i4, boolean z) {
            return obtain(i, i2, i3, i4, z, false);
        }

        public static CollectionItemInfo obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            CollectionItemInfo collectionItemInfo = (CollectionItemInfo) sPool.acquire();
            if (collectionItemInfo == null) {
                return new CollectionItemInfo(i, i2, i3, i4, z, z2);
            }
            collectionItemInfo.mRowIndex = i;
            collectionItemInfo.mRowSpan = i2;
            collectionItemInfo.mColumnIndex = i3;
            collectionItemInfo.mColumnSpan = i4;
            collectionItemInfo.mHeading = z;
            collectionItemInfo.mSelected = z2;
            return collectionItemInfo;
        }

        public static CollectionItemInfo obtain(CollectionItemInfo collectionItemInfo) {
            return obtain(collectionItemInfo.mRowIndex, collectionItemInfo.mRowSpan, collectionItemInfo.mColumnIndex, collectionItemInfo.mColumnSpan, collectionItemInfo.mHeading, collectionItemInfo.mSelected);
        }

        public int getColumnIndex() {
            return this.mColumnIndex;
        }

        public int getColumnSpan() {
            return this.mColumnSpan;
        }

        public int getRowIndex() {
            return this.mRowIndex;
        }

        public int getRowSpan() {
            return this.mRowSpan;
        }

        public boolean isHeading() {
            return this.mHeading;
        }

        public boolean isSelected() {
            return this.mSelected;
        }

        void recycle() {
            clear();
            sPool.release(this);
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityNodeInfo$RangeInfo.class */
    public static final class RangeInfo {
        private static final int MAX_POOL_SIZE = 10;
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;
        private static final Pools.SynchronizedPool<RangeInfo> sPool = new Pools.SynchronizedPool<>(10);
        private float mCurrent;
        private float mMax;
        private float mMin;
        private int mType;

        private RangeInfo(int i, float f, float f2, float f3) {
            this.mType = i;
            this.mMin = f;
            this.mMax = f2;
            this.mCurrent = f3;
        }

        private void clear() {
            this.mType = 0;
            this.mMin = 0.0f;
            this.mMax = 0.0f;
            this.mCurrent = 0.0f;
        }

        public static RangeInfo obtain(int i, float f, float f2, float f3) {
            RangeInfo rangeInfo = (RangeInfo) sPool.acquire();
            return rangeInfo != null ? rangeInfo : new RangeInfo(i, f, f2, f3);
        }

        public static RangeInfo obtain(RangeInfo rangeInfo) {
            return obtain(rangeInfo.mType, rangeInfo.mMin, rangeInfo.mMax, rangeInfo.mCurrent);
        }

        public float getCurrent() {
            return this.mCurrent;
        }

        public float getMax() {
            return this.mMax;
        }

        public float getMin() {
            return this.mMin;
        }

        public int getType() {
            return this.mType;
        }

        void recycle() {
            clear();
            sPool.release(this);
        }
    }

    private AccessibilityNodeInfo() {
    }

    private void addChildInternal(View view, int i, boolean z) {
        enforceNotSealed();
        if (this.mChildNodeIds == null) {
            this.mChildNodeIds = new LongArray();
        }
        long makeNodeId = makeNodeId(view != null ? view.getAccessibilityViewId() : Integer.MAX_VALUE, i);
        if (!z || this.mChildNodeIds.indexOf(makeNodeId) < 0) {
            this.mChildNodeIds.add(makeNodeId);
        }
    }

    private void addLegacyStandardActions(int i) {
        while (i > 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i);
            i &= numberOfTrailingZeros ^ (-1);
            addAction(getActionSingleton(numberOfTrailingZeros));
        }
    }

    private boolean canPerformRequestOverConnection(long j) {
        return (this.mWindowId == Integer.MAX_VALUE || getAccessibilityViewId(j) == Integer.MAX_VALUE || this.mConnectionId == -1) ? false : true;
    }

    private void clear() {
        this.mSealed = false;
        this.mSourceNodeId = ROOT_NODE_ID;
        this.mParentNodeId = ROOT_NODE_ID;
        this.mLabelForId = ROOT_NODE_ID;
        this.mLabeledById = ROOT_NODE_ID;
        this.mTraversalBefore = ROOT_NODE_ID;
        this.mTraversalAfter = ROOT_NODE_ID;
        this.mWindowId = Integer.MAX_VALUE;
        this.mConnectionId = -1;
        this.mMaxTextLength = -1;
        this.mMovementGranularities = 0;
        if (this.mChildNodeIds != null) {
            this.mChildNodeIds.clear();
        }
        this.mBoundsInParent.set(0, 0, 0, 0);
        this.mBoundsInScreen.set(0, 0, 0, 0);
        this.mBooleanProperties = 0;
        this.mPackageName = null;
        this.mClassName = null;
        this.mText = null;
        this.mError = null;
        this.mContentDescription = null;
        this.mViewIdResourceName = null;
        if (this.mActions != null) {
            this.mActions.clear();
        }
        this.mTextSelectionStart = -1;
        this.mTextSelectionEnd = -1;
        this.mInputType = 0;
        this.mLiveRegion = 0;
        if (this.mExtras != null) {
            this.mExtras.clear();
        }
        if (this.mRangeInfo != null) {
            this.mRangeInfo.recycle();
            this.mRangeInfo = null;
        }
        if (this.mCollectionInfo != null) {
            this.mCollectionInfo.recycle();
            this.mCollectionInfo = null;
        }
        if (this.mCollectionItemInfo != null) {
            this.mCollectionItemInfo.recycle();
            this.mCollectionItemInfo = null;
        }
    }

    private void enforceValidFocusDirection(int i) {
        switch (i) {
            case 1:
            case 2:
            case 17:
            case 33:
            case 66:
            case 130:
                return;
            default:
                throw new IllegalArgumentException("Unknown direction: " + i);
        }
    }

    private void enforceValidFocusType(int i) {
        switch (i) {
            case 1:
            case 2:
                return;
            default:
                throw new IllegalArgumentException("Unknown focus type: " + i);
        }
    }

    public static int getAccessibilityViewId(long j) {
        return (int) j;
    }

    private static AccessibilityAction getActionSingleton(int i) {
        int size = AccessibilityAction.sStandardActions.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return null;
            }
            AccessibilityAction accessibilityAction = (AccessibilityAction) AccessibilityAction.sStandardActions.valueAt(i3);
            if (i == accessibilityAction.getId()) {
                return accessibilityAction;
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getActionSymbolicName(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    private boolean getBooleanProperty(int i) {
        return (this.mBooleanProperties & i) != 0;
    }

    private static String getMovementGranularitySymbolicName(int i) {
        switch (i) {
            case 1:
                return "MOVEMENT_GRANULARITY_CHARACTER";
            case 2:
                return "MOVEMENT_GRANULARITY_WORD";
            case 4:
                return "MOVEMENT_GRANULARITY_LINE";
            case 8:
                return "MOVEMENT_GRANULARITY_PARAGRAPH";
            case 16:
                return "MOVEMENT_GRANULARITY_PAGE";
            default:
                throw new IllegalArgumentException("Unknown movement granularity: " + i);
        }
    }

    private AccessibilityNodeInfo getNodeForAccessibilityId(long j) {
        if (canPerformRequestOverConnection(j)) {
            return AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(this.mConnectionId, this.mWindowId, j, false, 7);
        }
        return null;
    }

    public static int getVirtualDescendantId(long j) {
        return (int) ((VIRTUAL_DESCENDANT_ID_MASK & j) >> 32);
    }

    private void init(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mSealed = accessibilityNodeInfo.mSealed;
        this.mSourceNodeId = accessibilityNodeInfo.mSourceNodeId;
        this.mParentNodeId = accessibilityNodeInfo.mParentNodeId;
        this.mLabelForId = accessibilityNodeInfo.mLabelForId;
        this.mLabeledById = accessibilityNodeInfo.mLabeledById;
        this.mTraversalBefore = accessibilityNodeInfo.mTraversalBefore;
        this.mTraversalAfter = accessibilityNodeInfo.mTraversalAfter;
        this.mWindowId = accessibilityNodeInfo.mWindowId;
        this.mConnectionId = accessibilityNodeInfo.mConnectionId;
        this.mBoundsInParent.set(accessibilityNodeInfo.mBoundsInParent);
        this.mBoundsInScreen.set(accessibilityNodeInfo.mBoundsInScreen);
        this.mPackageName = accessibilityNodeInfo.mPackageName;
        this.mClassName = accessibilityNodeInfo.mClassName;
        this.mText = accessibilityNodeInfo.mText;
        this.mError = accessibilityNodeInfo.mError;
        this.mContentDescription = accessibilityNodeInfo.mContentDescription;
        this.mViewIdResourceName = accessibilityNodeInfo.mViewIdResourceName;
        ArrayList<AccessibilityAction> arrayList = accessibilityNodeInfo.mActions;
        if (arrayList != null && arrayList.size() > 0) {
            if (this.mActions == null) {
                this.mActions = new ArrayList<>(arrayList);
            } else {
                this.mActions.clear();
                this.mActions.addAll(accessibilityNodeInfo.mActions);
            }
        }
        this.mBooleanProperties = accessibilityNodeInfo.mBooleanProperties;
        this.mMaxTextLength = accessibilityNodeInfo.mMaxTextLength;
        this.mMovementGranularities = accessibilityNodeInfo.mMovementGranularities;
        LongArray longArray = accessibilityNodeInfo.mChildNodeIds;
        if (longArray != null && longArray.size() > 0) {
            if (this.mChildNodeIds == null) {
                this.mChildNodeIds = longArray.clone();
            } else {
                this.mChildNodeIds.clear();
                this.mChildNodeIds.addAll(longArray);
            }
        }
        this.mTextSelectionStart = accessibilityNodeInfo.mTextSelectionStart;
        this.mTextSelectionEnd = accessibilityNodeInfo.mTextSelectionEnd;
        this.mInputType = accessibilityNodeInfo.mInputType;
        this.mLiveRegion = accessibilityNodeInfo.mLiveRegion;
        if (accessibilityNodeInfo.mExtras != null && !accessibilityNodeInfo.mExtras.isEmpty()) {
            getExtras().putAll(accessibilityNodeInfo.mExtras);
        }
        this.mRangeInfo = accessibilityNodeInfo.mRangeInfo != null ? RangeInfo.obtain(accessibilityNodeInfo.mRangeInfo) : null;
        this.mCollectionInfo = accessibilityNodeInfo.mCollectionInfo != null ? CollectionInfo.obtain(accessibilityNodeInfo.mCollectionInfo) : null;
        CollectionItemInfo collectionItemInfo = null;
        if (accessibilityNodeInfo.mCollectionItemInfo != null) {
            collectionItemInfo = CollectionItemInfo.obtain(accessibilityNodeInfo.mCollectionItemInfo);
        }
        this.mCollectionItemInfo = collectionItemInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFromParcel(Parcel parcel) {
        this.mSealed = parcel.readInt() == 1;
        this.mSourceNodeId = parcel.readLong();
        this.mWindowId = parcel.readInt();
        this.mParentNodeId = parcel.readLong();
        this.mLabelForId = parcel.readLong();
        this.mLabeledById = parcel.readLong();
        this.mTraversalBefore = parcel.readLong();
        this.mTraversalAfter = parcel.readLong();
        this.mConnectionId = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.mChildNodeIds = new LongArray(readInt);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                this.mChildNodeIds.add(parcel.readLong());
                i = i2 + 1;
            }
        } else {
            this.mChildNodeIds = null;
        }
        this.mBoundsInParent.top = parcel.readInt();
        this.mBoundsInParent.bottom = parcel.readInt();
        this.mBoundsInParent.left = parcel.readInt();
        this.mBoundsInParent.right = parcel.readInt();
        this.mBoundsInScreen.top = parcel.readInt();
        this.mBoundsInScreen.bottom = parcel.readInt();
        this.mBoundsInScreen.left = parcel.readInt();
        this.mBoundsInScreen.right = parcel.readInt();
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            int readInt3 = parcel.readInt();
            addLegacyStandardActions(readInt3);
            int bitCount = Integer.bitCount(readInt3);
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= readInt2 - bitCount) {
                    break;
                }
                addAction(new AccessibilityAction(parcel.readInt(), parcel.readCharSequence()));
                i3 = i4 + 1;
            }
        }
        this.mMaxTextLength = parcel.readInt();
        this.mMovementGranularities = parcel.readInt();
        this.mBooleanProperties = parcel.readInt();
        this.mPackageName = parcel.readCharSequence();
        this.mClassName = parcel.readCharSequence();
        this.mText = parcel.readCharSequence();
        this.mError = parcel.readCharSequence();
        this.mContentDescription = parcel.readCharSequence();
        this.mViewIdResourceName = parcel.readString();
        this.mTextSelectionStart = parcel.readInt();
        this.mTextSelectionEnd = parcel.readInt();
        this.mInputType = parcel.readInt();
        this.mLiveRegion = parcel.readInt();
        if (parcel.readInt() == 1) {
            getExtras().putAll(parcel.readBundle());
        }
        if (parcel.readInt() == 1) {
            this.mRangeInfo = RangeInfo.obtain(parcel.readInt(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat());
        }
        if (parcel.readInt() == 1) {
            this.mCollectionInfo = CollectionInfo.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt() == 1, parcel.readInt());
        }
        if (parcel.readInt() == 1) {
            this.mCollectionItemInfo = CollectionItemInfo.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() == 1, parcel.readInt() == 1);
        }
    }

    private static boolean isDefaultLegacyStandardAction(AccessibilityAction accessibilityAction) {
        return accessibilityAction.getId() <= 2097152 && TextUtils.isEmpty(accessibilityAction.getLabel());
    }

    public static long makeNodeId(int i, int i2) {
        int i3 = i2;
        if (i2 == -1) {
            i3 = Integer.MAX_VALUE;
        }
        return (i3 << 32) | i;
    }

    public static AccessibilityNodeInfo obtain() {
        AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) sPool.acquire();
        return accessibilityNodeInfo != null ? accessibilityNodeInfo : new AccessibilityNodeInfo();
    }

    public static AccessibilityNodeInfo obtain(View view) {
        AccessibilityNodeInfo obtain = obtain();
        obtain.setSource(view);
        return obtain;
    }

    public static AccessibilityNodeInfo obtain(View view, int i) {
        AccessibilityNodeInfo obtain = obtain();
        obtain.setSource(view, i);
        return obtain;
    }

    public static AccessibilityNodeInfo obtain(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo obtain = obtain();
        obtain.init(accessibilityNodeInfo);
        return obtain;
    }

    private void setBooleanProperty(int i, boolean z) {
        enforceNotSealed();
        if (z) {
            this.mBooleanProperties |= i;
        } else {
            this.mBooleanProperties &= i ^ (-1);
        }
    }

    @Deprecated
    public void addAction(int i) {
        enforceNotSealed();
        if (((-16777216) & i) != 0) {
            throw new IllegalArgumentException("Action is not a combination of the standard actions: " + i);
        }
        addLegacyStandardActions(i);
    }

    public void addAction(AccessibilityAction accessibilityAction) {
        enforceNotSealed();
        if (accessibilityAction == null) {
            return;
        }
        if (this.mActions == null) {
            this.mActions = new ArrayList<>();
        }
        this.mActions.remove(accessibilityAction);
        this.mActions.add(accessibilityAction);
    }

    public void addChild(View view) {
        addChildInternal(view, Integer.MAX_VALUE, true);
    }

    public void addChild(View view, int i) {
        addChildInternal(view, i, true);
    }

    public void addChildUnchecked(View view) {
        addChildInternal(view, Integer.MAX_VALUE, false);
    }

    public boolean canOpenPopup() {
        return getBooleanProperty(8192);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected void enforceNotSealed() {
        if (isSealed()) {
            throw new IllegalStateException("Cannot perform this action on a sealed instance.");
        }
    }

    protected void enforceSealed() {
        if (!isSealed()) {
            throw new IllegalStateException("Cannot perform this action on a not sealed instance.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) obj;
            return this.mSourceNodeId == accessibilityNodeInfo.mSourceNodeId && this.mWindowId == accessibilityNodeInfo.mWindowId;
        }
        return false;
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str) {
        enforceSealed();
        return !canPerformRequestOverConnection(this.mSourceNodeId) ? Collections.emptyList() : AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfosByText(this.mConnectionId, this.mWindowId, this.mSourceNodeId, str);
    }

    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId(String str) {
        enforceSealed();
        return !canPerformRequestOverConnection(this.mSourceNodeId) ? Collections.emptyList() : AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfosByViewId(this.mConnectionId, this.mWindowId, this.mSourceNodeId, str);
    }

    public AccessibilityNodeInfo findFocus(int i) {
        enforceSealed();
        enforceValidFocusType(i);
        if (canPerformRequestOverConnection(this.mSourceNodeId)) {
            return AccessibilityInteractionClient.getInstance().findFocus(this.mConnectionId, this.mWindowId, this.mSourceNodeId, i);
        }
        return null;
    }

    public AccessibilityNodeInfo focusSearch(int i) {
        enforceSealed();
        enforceValidFocusDirection(i);
        if (canPerformRequestOverConnection(this.mSourceNodeId)) {
            return AccessibilityInteractionClient.getInstance().focusSearch(this.mConnectionId, this.mWindowId, this.mSourceNodeId, i);
        }
        return null;
    }

    public List<AccessibilityAction> getActionList() {
        return this.mActions == null ? Collections.emptyList() : this.mActions;
    }

    @Deprecated
    public int getActions() {
        int i = 0;
        if (this.mActions == null) {
            return 0;
        }
        int size = this.mActions.size();
        int i2 = 0;
        while (i2 < size) {
            int id = this.mActions.get(i2).getId();
            int i3 = i;
            if (id <= 2097152) {
                i3 = i | id;
            }
            i2++;
            i = i3;
        }
        return i;
    }

    public void getBoundsInParent(Rect rect) {
        rect.set(this.mBoundsInParent.left, this.mBoundsInParent.top, this.mBoundsInParent.right, this.mBoundsInParent.bottom);
    }

    public void getBoundsInScreen(Rect rect) {
        rect.set(this.mBoundsInScreen.left, this.mBoundsInScreen.top, this.mBoundsInScreen.right, this.mBoundsInScreen.bottom);
    }

    public AccessibilityNodeInfo getChild(int i) {
        enforceSealed();
        if (this.mChildNodeIds != null && canPerformRequestOverConnection(this.mSourceNodeId)) {
            return AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(this.mConnectionId, this.mWindowId, this.mChildNodeIds.get(i), false, 4);
        }
        return null;
    }

    public int getChildCount() {
        if (this.mChildNodeIds == null) {
            return 0;
        }
        return this.mChildNodeIds.size();
    }

    public long getChildId(int i) {
        if (this.mChildNodeIds == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.mChildNodeIds.get(i);
    }

    public LongArray getChildNodeIds() {
        return this.mChildNodeIds;
    }

    public CharSequence getClassName() {
        return this.mClassName;
    }

    public CollectionInfo getCollectionInfo() {
        return this.mCollectionInfo;
    }

    public CollectionItemInfo getCollectionItemInfo() {
        return this.mCollectionItemInfo;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public CharSequence getError() {
        return this.mError;
    }

    public Bundle getExtras() {
        if (this.mExtras == null) {
            this.mExtras = new Bundle();
        }
        return this.mExtras;
    }

    public int getInputType() {
        return this.mInputType;
    }

    public AccessibilityNodeInfo getLabelFor() {
        enforceSealed();
        return getNodeForAccessibilityId(this.mLabelForId);
    }

    public AccessibilityNodeInfo getLabeledBy() {
        enforceSealed();
        return getNodeForAccessibilityId(this.mLabeledById);
    }

    public int getLiveRegion() {
        return this.mLiveRegion;
    }

    public int getMaxTextLength() {
        return this.mMaxTextLength;
    }

    public int getMovementGranularities() {
        return this.mMovementGranularities;
    }

    public CharSequence getPackageName() {
        return this.mPackageName;
    }

    public AccessibilityNodeInfo getParent() {
        enforceSealed();
        return getNodeForAccessibilityId(this.mParentNodeId);
    }

    public long getParentNodeId() {
        return this.mParentNodeId;
    }

    public RangeInfo getRangeInfo() {
        return this.mRangeInfo;
    }

    public long getSourceNodeId() {
        return this.mSourceNodeId;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public int getTextSelectionEnd() {
        return this.mTextSelectionEnd;
    }

    public int getTextSelectionStart() {
        return this.mTextSelectionStart;
    }

    public AccessibilityNodeInfo getTraversalAfter() {
        enforceSealed();
        return getNodeForAccessibilityId(this.mTraversalAfter);
    }

    public AccessibilityNodeInfo getTraversalBefore() {
        enforceSealed();
        return getNodeForAccessibilityId(this.mTraversalBefore);
    }

    public String getViewIdResourceName() {
        return this.mViewIdResourceName;
    }

    public AccessibilityWindowInfo getWindow() {
        enforceSealed();
        if (canPerformRequestOverConnection(this.mSourceNodeId)) {
            return AccessibilityInteractionClient.getInstance().getWindow(this.mConnectionId, this.mWindowId);
        }
        return null;
    }

    public int getWindowId() {
        return this.mWindowId;
    }

    public int hashCode() {
        return ((((getAccessibilityViewId(this.mSourceNodeId) + 31) * 31) + getVirtualDescendantId(this.mSourceNodeId)) * 31) + this.mWindowId;
    }

    public boolean isAccessibilityFocused() {
        return getBooleanProperty(1024);
    }

    public boolean isCheckable() {
        return getBooleanProperty(1);
    }

    public boolean isChecked() {
        return getBooleanProperty(2);
    }

    public boolean isClickable() {
        return getBooleanProperty(32);
    }

    public boolean isContentInvalid() {
        return getBooleanProperty(65536);
    }

    public boolean isDismissable() {
        return getBooleanProperty(16384);
    }

    public boolean isEditable() {
        return getBooleanProperty(4096);
    }

    public boolean isEnabled() {
        return getBooleanProperty(128);
    }

    public boolean isFocusable() {
        return getBooleanProperty(4);
    }

    public boolean isFocused() {
        return getBooleanProperty(8);
    }

    public boolean isLongClickable() {
        return getBooleanProperty(64);
    }

    public boolean isMultiLine() {
        return getBooleanProperty(32768);
    }

    public boolean isPassword() {
        return getBooleanProperty(256);
    }

    public boolean isScrollable() {
        return getBooleanProperty(512);
    }

    public boolean isSealed() {
        return this.mSealed;
    }

    public boolean isSelected() {
        return getBooleanProperty(16);
    }

    public boolean isVisibleToUser() {
        return getBooleanProperty(2048);
    }

    public boolean performAction(int i) {
        enforceSealed();
        if (canPerformRequestOverConnection(this.mSourceNodeId)) {
            return AccessibilityInteractionClient.getInstance().performAccessibilityAction(this.mConnectionId, this.mWindowId, this.mSourceNodeId, i, null);
        }
        return false;
    }

    public boolean performAction(int i, Bundle bundle) {
        enforceSealed();
        if (canPerformRequestOverConnection(this.mSourceNodeId)) {
            return AccessibilityInteractionClient.getInstance().performAccessibilityAction(this.mConnectionId, this.mWindowId, this.mSourceNodeId, i, bundle);
        }
        return false;
    }

    public void recycle() {
        clear();
        sPool.release(this);
    }

    public boolean refresh() {
        return refresh(true);
    }

    public boolean refresh(boolean z) {
        AccessibilityNodeInfo findAccessibilityNodeInfoByAccessibilityId;
        enforceSealed();
        if (canPerformRequestOverConnection(this.mSourceNodeId) && (findAccessibilityNodeInfoByAccessibilityId = AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(this.mConnectionId, this.mWindowId, this.mSourceNodeId, z, 0)) != null) {
            init(findAccessibilityNodeInfoByAccessibilityId);
            findAccessibilityNodeInfoByAccessibilityId.recycle();
            return true;
        }
        return false;
    }

    @Deprecated
    public void removeAction(int i) {
        enforceNotSealed();
        removeAction(getActionSingleton(i));
    }

    public boolean removeAction(AccessibilityAction accessibilityAction) {
        enforceNotSealed();
        if (this.mActions == null || accessibilityAction == null) {
            return false;
        }
        return this.mActions.remove(accessibilityAction);
    }

    public boolean removeChild(View view) {
        return removeChild(view, Integer.MAX_VALUE);
    }

    public boolean removeChild(View view, int i) {
        enforceNotSealed();
        LongArray longArray = this.mChildNodeIds;
        if (longArray == null) {
            return false;
        }
        int indexOf = longArray.indexOf(makeNodeId(view != null ? view.getAccessibilityViewId() : Integer.MAX_VALUE, i));
        if (indexOf >= 0) {
            longArray.remove(indexOf);
            return true;
        }
        return false;
    }

    public void setAccessibilityFocused(boolean z) {
        setBooleanProperty(1024, z);
    }

    public void setBoundsInParent(Rect rect) {
        enforceNotSealed();
        this.mBoundsInParent.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setBoundsInScreen(Rect rect) {
        enforceNotSealed();
        this.mBoundsInScreen.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setCanOpenPopup(boolean z) {
        enforceNotSealed();
        setBooleanProperty(8192, z);
    }

    public void setCheckable(boolean z) {
        setBooleanProperty(1, z);
    }

    public void setChecked(boolean z) {
        setBooleanProperty(2, z);
    }

    public void setClassName(CharSequence charSequence) {
        enforceNotSealed();
        this.mClassName = charSequence;
    }

    public void setClickable(boolean z) {
        setBooleanProperty(32, z);
    }

    public void setCollectionInfo(CollectionInfo collectionInfo) {
        enforceNotSealed();
        this.mCollectionInfo = collectionInfo;
    }

    public void setCollectionItemInfo(CollectionItemInfo collectionItemInfo) {
        enforceNotSealed();
        this.mCollectionItemInfo = collectionItemInfo;
    }

    public void setConnectionId(int i) {
        enforceNotSealed();
        this.mConnectionId = i;
    }

    public void setContentDescription(CharSequence charSequence) {
        enforceNotSealed();
        this.mContentDescription = charSequence;
    }

    public void setContentInvalid(boolean z) {
        setBooleanProperty(65536, z);
    }

    public void setDismissable(boolean z) {
        setBooleanProperty(16384, z);
    }

    public void setEditable(boolean z) {
        setBooleanProperty(4096, z);
    }

    public void setEnabled(boolean z) {
        setBooleanProperty(128, z);
    }

    public void setError(CharSequence charSequence) {
        enforceNotSealed();
        this.mError = charSequence;
    }

    public void setFocusable(boolean z) {
        setBooleanProperty(4, z);
    }

    public void setFocused(boolean z) {
        setBooleanProperty(8, z);
    }

    public void setInputType(int i) {
        enforceNotSealed();
        this.mInputType = i;
    }

    public void setLabelFor(View view) {
        setLabelFor(view, Integer.MAX_VALUE);
    }

    public void setLabelFor(View view, int i) {
        enforceNotSealed();
        this.mLabelForId = makeNodeId(view != null ? view.getAccessibilityViewId() : Integer.MAX_VALUE, i);
    }

    public void setLabeledBy(View view) {
        setLabeledBy(view, Integer.MAX_VALUE);
    }

    public void setLabeledBy(View view, int i) {
        enforceNotSealed();
        this.mLabeledById = makeNodeId(view != null ? view.getAccessibilityViewId() : Integer.MAX_VALUE, i);
    }

    public void setLiveRegion(int i) {
        enforceNotSealed();
        this.mLiveRegion = i;
    }

    public void setLongClickable(boolean z) {
        setBooleanProperty(64, z);
    }

    public void setMaxTextLength(int i) {
        enforceNotSealed();
        this.mMaxTextLength = i;
    }

    public void setMovementGranularities(int i) {
        enforceNotSealed();
        this.mMovementGranularities = i;
    }

    public void setMultiLine(boolean z) {
        setBooleanProperty(32768, z);
    }

    public void setPackageName(CharSequence charSequence) {
        enforceNotSealed();
        this.mPackageName = charSequence;
    }

    public void setParent(View view) {
        setParent(view, Integer.MAX_VALUE);
    }

    public void setParent(View view, int i) {
        enforceNotSealed();
        this.mParentNodeId = makeNodeId(view != null ? view.getAccessibilityViewId() : Integer.MAX_VALUE, i);
    }

    public void setPassword(boolean z) {
        setBooleanProperty(256, z);
    }

    public void setRangeInfo(RangeInfo rangeInfo) {
        enforceNotSealed();
        this.mRangeInfo = rangeInfo;
    }

    public void setScrollable(boolean z) {
        setBooleanProperty(512, z);
    }

    public void setSealed(boolean z) {
        this.mSealed = z;
    }

    public void setSelected(boolean z) {
        setBooleanProperty(16, z);
    }

    public void setSource(View view) {
        setSource(view, Integer.MAX_VALUE);
    }

    public void setSource(View view, int i) {
        enforceNotSealed();
        this.mWindowId = view != null ? view.getAccessibilityWindowId() : Integer.MAX_VALUE;
        this.mSourceNodeId = makeNodeId(view != null ? view.getAccessibilityViewId() : Integer.MAX_VALUE, i);
    }

    public void setText(CharSequence charSequence) {
        enforceNotSealed();
        this.mText = charSequence;
    }

    public void setTextSelection(int i, int i2) {
        enforceNotSealed();
        this.mTextSelectionStart = i;
        this.mTextSelectionEnd = i2;
    }

    public void setTraversalAfter(View view) {
        setTraversalAfter(view, Integer.MAX_VALUE);
    }

    public void setTraversalAfter(View view, int i) {
        enforceNotSealed();
        this.mTraversalAfter = makeNodeId(view != null ? view.getAccessibilityViewId() : Integer.MAX_VALUE, i);
    }

    public void setTraversalBefore(View view) {
        setTraversalBefore(view, Integer.MAX_VALUE);
    }

    public void setTraversalBefore(View view, int i) {
        enforceNotSealed();
        this.mTraversalBefore = makeNodeId(view != null ? view.getAccessibilityViewId() : Integer.MAX_VALUE, i);
    }

    public void setViewIdResourceName(String str) {
        enforceNotSealed();
        this.mViewIdResourceName = str;
    }

    public void setVisibleToUser(boolean z) {
        setBooleanProperty(2048, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; boundsInParent: " + this.mBoundsInParent);
        sb.append("; boundsInScreen: " + this.mBoundsInScreen);
        sb.append("; packageName: ").append(this.mPackageName);
        sb.append("; className: ").append(this.mClassName);
        sb.append("; text: ").append(this.mText);
        sb.append("; error: ").append(this.mError);
        sb.append("; maxTextLength: ").append(this.mMaxTextLength);
        sb.append("; contentDescription: ").append(this.mContentDescription);
        sb.append("; viewIdResName: ").append(this.mViewIdResourceName);
        sb.append("; checkable: ").append(isCheckable());
        sb.append("; checked: ").append(isChecked());
        sb.append("; focusable: ").append(isFocusable());
        sb.append("; focused: ").append(isFocused());
        sb.append("; selected: ").append(isSelected());
        sb.append("; clickable: ").append(isClickable());
        sb.append("; longClickable: ").append(isLongClickable());
        sb.append("; enabled: ").append(isEnabled());
        sb.append("; password: ").append(isPassword());
        sb.append("; scrollable: ").append(isScrollable());
        sb.append("; actions: ").append(this.mActions);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(isSealed() ? 1 : 0);
        parcel.writeLong(this.mSourceNodeId);
        parcel.writeInt(this.mWindowId);
        parcel.writeLong(this.mParentNodeId);
        parcel.writeLong(this.mLabelForId);
        parcel.writeLong(this.mLabeledById);
        parcel.writeLong(this.mTraversalBefore);
        parcel.writeLong(this.mTraversalAfter);
        parcel.writeInt(this.mConnectionId);
        LongArray longArray = this.mChildNodeIds;
        if (longArray != null) {
            int size = longArray.size();
            parcel.writeInt(size);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                parcel.writeLong(longArray.get(i3));
                i2 = i3 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.mBoundsInParent.top);
        parcel.writeInt(this.mBoundsInParent.bottom);
        parcel.writeInt(this.mBoundsInParent.left);
        parcel.writeInt(this.mBoundsInParent.right);
        parcel.writeInt(this.mBoundsInScreen.top);
        parcel.writeInt(this.mBoundsInScreen.bottom);
        parcel.writeInt(this.mBoundsInScreen.left);
        parcel.writeInt(this.mBoundsInScreen.right);
        if (this.mActions != null && !this.mActions.isEmpty()) {
            int size2 = this.mActions.size();
            parcel.writeInt(size2);
            int i4 = 0;
            int i5 = 0;
            while (i5 < size2) {
                AccessibilityAction accessibilityAction = this.mActions.get(i5);
                int i6 = i4;
                if (isDefaultLegacyStandardAction(accessibilityAction)) {
                    i6 = i4 | accessibilityAction.getId();
                }
                i5++;
                i4 = i6;
            }
            parcel.writeInt(i4);
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= size2) {
                    break;
                }
                AccessibilityAction accessibilityAction2 = this.mActions.get(i8);
                if (!isDefaultLegacyStandardAction(accessibilityAction2)) {
                    parcel.writeInt(accessibilityAction2.getId());
                    parcel.writeCharSequence(accessibilityAction2.getLabel());
                }
                i7 = i8 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.mMaxTextLength);
        parcel.writeInt(this.mMovementGranularities);
        parcel.writeInt(this.mBooleanProperties);
        parcel.writeCharSequence(this.mPackageName);
        parcel.writeCharSequence(this.mClassName);
        parcel.writeCharSequence(this.mText);
        parcel.writeCharSequence(this.mError);
        parcel.writeCharSequence(this.mContentDescription);
        parcel.writeString(this.mViewIdResourceName);
        parcel.writeInt(this.mTextSelectionStart);
        parcel.writeInt(this.mTextSelectionEnd);
        parcel.writeInt(this.mInputType);
        parcel.writeInt(this.mLiveRegion);
        if (this.mExtras != null) {
            parcel.writeInt(1);
            parcel.writeBundle(this.mExtras);
        } else {
            parcel.writeInt(0);
        }
        if (this.mRangeInfo != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.mRangeInfo.getType());
            parcel.writeFloat(this.mRangeInfo.getMin());
            parcel.writeFloat(this.mRangeInfo.getMax());
            parcel.writeFloat(this.mRangeInfo.getCurrent());
        } else {
            parcel.writeInt(0);
        }
        if (this.mCollectionInfo != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.mCollectionInfo.getRowCount());
            parcel.writeInt(this.mCollectionInfo.getColumnCount());
            parcel.writeInt(this.mCollectionInfo.isHierarchical() ? 1 : 0);
            parcel.writeInt(this.mCollectionInfo.getSelectionMode());
        } else {
            parcel.writeInt(0);
        }
        if (this.mCollectionItemInfo != null) {
            parcel.writeInt(1);
            parcel.writeInt(this.mCollectionItemInfo.getColumnIndex());
            parcel.writeInt(this.mCollectionItemInfo.getColumnSpan());
            parcel.writeInt(this.mCollectionItemInfo.getRowIndex());
            parcel.writeInt(this.mCollectionItemInfo.getRowSpan());
            parcel.writeInt(this.mCollectionItemInfo.isHeading() ? 1 : 0);
            parcel.writeInt(this.mCollectionItemInfo.isSelected() ? 1 : 0);
        } else {
            parcel.writeInt(0);
        }
        recycle();
    }
}
