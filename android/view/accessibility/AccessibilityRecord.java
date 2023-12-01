package android.view.accessibility;

import android.os.Parcelable;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityRecord.class */
public class AccessibilityRecord {
    private static final int GET_SOURCE_PREFETCH_FLAGS = 7;
    private static final int MAX_POOL_SIZE = 10;
    private static final int PROPERTY_CHECKED = 1;
    private static final int PROPERTY_ENABLED = 2;
    private static final int PROPERTY_FULL_SCREEN = 128;
    private static final int PROPERTY_IMPORTANT_FOR_ACCESSIBILITY = 512;
    private static final int PROPERTY_PASSWORD = 4;
    private static final int PROPERTY_SCROLLABLE = 256;
    private static final int UNDEFINED = -1;
    private static AccessibilityRecord sPool;
    private static final Object sPoolLock = new Object();
    private static int sPoolSize;
    CharSequence mBeforeText;
    CharSequence mClassName;
    CharSequence mContentDescription;
    private boolean mIsInPool;
    private AccessibilityRecord mNext;
    Parcelable mParcelableData;
    boolean mSealed;
    int mBooleanProperties = 0;
    int mCurrentItemIndex = -1;
    int mItemCount = -1;
    int mFromIndex = -1;
    int mToIndex = -1;
    int mScrollX = -1;
    int mScrollY = -1;
    int mMaxScrollX = -1;
    int mMaxScrollY = -1;
    int mAddedCount = -1;
    int mRemovedCount = -1;
    long mSourceNodeId = AccessibilityNodeInfo.makeNodeId(-1, -1);
    int mSourceWindowId = -1;
    final List<CharSequence> mText = new ArrayList();
    int mConnectionId = -1;

    private boolean getBooleanProperty(int i) {
        return (this.mBooleanProperties & i) == i;
    }

    public static AccessibilityRecord obtain() {
        synchronized (sPoolLock) {
            if (sPool == null) {
                return new AccessibilityRecord();
            }
            AccessibilityRecord accessibilityRecord = sPool;
            sPool = sPool.mNext;
            sPoolSize--;
            accessibilityRecord.mNext = null;
            accessibilityRecord.mIsInPool = false;
            return accessibilityRecord;
        }
    }

    public static AccessibilityRecord obtain(AccessibilityRecord accessibilityRecord) {
        AccessibilityRecord obtain = obtain();
        obtain.init(accessibilityRecord);
        return obtain;
    }

    private void setBooleanProperty(int i, boolean z) {
        if (z) {
            this.mBooleanProperties |= i;
        } else {
            this.mBooleanProperties &= i ^ (-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        this.mSealed = false;
        this.mBooleanProperties = 0;
        this.mCurrentItemIndex = -1;
        this.mItemCount = -1;
        this.mFromIndex = -1;
        this.mToIndex = -1;
        this.mScrollX = -1;
        this.mScrollY = -1;
        this.mMaxScrollX = -1;
        this.mMaxScrollY = -1;
        this.mAddedCount = -1;
        this.mRemovedCount = -1;
        this.mClassName = null;
        this.mContentDescription = null;
        this.mBeforeText = null;
        this.mParcelableData = null;
        this.mText.clear();
        this.mSourceNodeId = AccessibilityNodeInfo.makeNodeId(-1, -1);
        this.mSourceWindowId = -1;
        this.mConnectionId = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enforceNotSealed() {
        if (isSealed()) {
            throw new IllegalStateException("Cannot perform this action on a sealed instance.");
        }
    }

    void enforceSealed() {
        if (!isSealed()) {
            throw new IllegalStateException("Cannot perform this action on a not sealed instance.");
        }
    }

    public int getAddedCount() {
        return this.mAddedCount;
    }

    public CharSequence getBeforeText() {
        return this.mBeforeText;
    }

    public CharSequence getClassName() {
        return this.mClassName;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getCurrentItemIndex() {
        return this.mCurrentItemIndex;
    }

    public int getFromIndex() {
        return this.mFromIndex;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public int getMaxScrollX() {
        return this.mMaxScrollX;
    }

    public int getMaxScrollY() {
        return this.mMaxScrollY;
    }

    public Parcelable getParcelableData() {
        return this.mParcelableData;
    }

    public int getRemovedCount() {
        return this.mRemovedCount;
    }

    public int getScrollX() {
        return this.mScrollX;
    }

    public int getScrollY() {
        return this.mScrollY;
    }

    public AccessibilityNodeInfo getSource() {
        enforceSealed();
        if (this.mConnectionId == -1 || this.mSourceWindowId == -1 || AccessibilityNodeInfo.getAccessibilityViewId(this.mSourceNodeId) == -1) {
            return null;
        }
        return AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(this.mConnectionId, this.mSourceWindowId, this.mSourceNodeId, false, 7);
    }

    public long getSourceNodeId() {
        return this.mSourceNodeId;
    }

    public List<CharSequence> getText() {
        return this.mText;
    }

    public int getToIndex() {
        return this.mToIndex;
    }

    public int getWindowId() {
        return this.mSourceWindowId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init(AccessibilityRecord accessibilityRecord) {
        this.mSealed = accessibilityRecord.mSealed;
        this.mBooleanProperties = accessibilityRecord.mBooleanProperties;
        this.mCurrentItemIndex = accessibilityRecord.mCurrentItemIndex;
        this.mItemCount = accessibilityRecord.mItemCount;
        this.mFromIndex = accessibilityRecord.mFromIndex;
        this.mToIndex = accessibilityRecord.mToIndex;
        this.mScrollX = accessibilityRecord.mScrollX;
        this.mScrollY = accessibilityRecord.mScrollY;
        this.mMaxScrollX = accessibilityRecord.mMaxScrollX;
        this.mMaxScrollY = accessibilityRecord.mMaxScrollY;
        this.mAddedCount = accessibilityRecord.mAddedCount;
        this.mRemovedCount = accessibilityRecord.mRemovedCount;
        this.mClassName = accessibilityRecord.mClassName;
        this.mContentDescription = accessibilityRecord.mContentDescription;
        this.mBeforeText = accessibilityRecord.mBeforeText;
        this.mParcelableData = accessibilityRecord.mParcelableData;
        this.mText.addAll(accessibilityRecord.mText);
        this.mSourceWindowId = accessibilityRecord.mSourceWindowId;
        this.mSourceNodeId = accessibilityRecord.mSourceNodeId;
        this.mConnectionId = accessibilityRecord.mConnectionId;
    }

    public boolean isChecked() {
        return getBooleanProperty(1);
    }

    public boolean isEnabled() {
        return getBooleanProperty(2);
    }

    public boolean isFullScreen() {
        return getBooleanProperty(128);
    }

    public boolean isImportantForAccessibility() {
        return getBooleanProperty(512);
    }

    public boolean isPassword() {
        return getBooleanProperty(4);
    }

    public boolean isScrollable() {
        return getBooleanProperty(256);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSealed() {
        return this.mSealed;
    }

    public void recycle() {
        if (this.mIsInPool) {
            throw new IllegalStateException("Record already recycled!");
        }
        clear();
        synchronized (sPoolLock) {
            if (sPoolSize <= 10) {
                this.mNext = sPool;
                sPool = this;
                this.mIsInPool = true;
                sPoolSize++;
            }
        }
    }

    public void setAddedCount(int i) {
        enforceNotSealed();
        this.mAddedCount = i;
    }

    public void setBeforeText(CharSequence charSequence) {
        enforceNotSealed();
        this.mBeforeText = charSequence;
    }

    public void setChecked(boolean z) {
        enforceNotSealed();
        setBooleanProperty(1, z);
    }

    public void setClassName(CharSequence charSequence) {
        enforceNotSealed();
        this.mClassName = charSequence;
    }

    public void setConnectionId(int i) {
        enforceNotSealed();
        this.mConnectionId = i;
    }

    public void setContentDescription(CharSequence charSequence) {
        enforceNotSealed();
        this.mContentDescription = charSequence;
    }

    public void setCurrentItemIndex(int i) {
        enforceNotSealed();
        this.mCurrentItemIndex = i;
    }

    public void setEnabled(boolean z) {
        enforceNotSealed();
        setBooleanProperty(2, z);
    }

    public void setFromIndex(int i) {
        enforceNotSealed();
        this.mFromIndex = i;
    }

    public void setFullScreen(boolean z) {
        enforceNotSealed();
        setBooleanProperty(128, z);
    }

    public void setItemCount(int i) {
        enforceNotSealed();
        this.mItemCount = i;
    }

    public void setMaxScrollX(int i) {
        enforceNotSealed();
        this.mMaxScrollX = i;
    }

    public void setMaxScrollY(int i) {
        enforceNotSealed();
        this.mMaxScrollY = i;
    }

    public void setParcelableData(Parcelable parcelable) {
        enforceNotSealed();
        this.mParcelableData = parcelable;
    }

    public void setPassword(boolean z) {
        enforceNotSealed();
        setBooleanProperty(4, z);
    }

    public void setRemovedCount(int i) {
        enforceNotSealed();
        this.mRemovedCount = i;
    }

    public void setScrollX(int i) {
        enforceNotSealed();
        this.mScrollX = i;
    }

    public void setScrollY(int i) {
        enforceNotSealed();
        this.mScrollY = i;
    }

    public void setScrollable(boolean z) {
        enforceNotSealed();
        setBooleanProperty(256, z);
    }

    public void setSealed(boolean z) {
        this.mSealed = z;
    }

    public void setSource(View view) {
        setSource(view, -1);
    }

    public void setSource(View view, int i) {
        enforceNotSealed();
        setBooleanProperty(512, i == -1 ? view != null ? view.isImportantForAccessibility() : true : true);
        this.mSourceWindowId = view != null ? view.getAccessibilityWindowId() : -1;
        this.mSourceNodeId = AccessibilityNodeInfo.makeNodeId(view != null ? view.getAccessibilityViewId() : -1, i);
    }

    public void setToIndex(int i) {
        enforceNotSealed();
        this.mToIndex = i;
    }

    public void setWindowId(int i) {
        this.mSourceWindowId = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" [ ClassName: " + ((Object) this.mClassName));
        sb.append("; Text: " + this.mText);
        sb.append("; ContentDescription: " + ((Object) this.mContentDescription));
        sb.append("; ItemCount: " + this.mItemCount);
        sb.append("; CurrentItemIndex: " + this.mCurrentItemIndex);
        sb.append("; IsEnabled: " + getBooleanProperty(2));
        sb.append("; IsPassword: " + getBooleanProperty(4));
        sb.append("; IsChecked: " + getBooleanProperty(1));
        sb.append("; IsFullScreen: " + getBooleanProperty(128));
        sb.append("; Scrollable: " + getBooleanProperty(256));
        sb.append("; BeforeText: " + ((Object) this.mBeforeText));
        sb.append("; FromIndex: " + this.mFromIndex);
        sb.append("; ToIndex: " + this.mToIndex);
        sb.append("; ScrollX: " + this.mScrollX);
        sb.append("; ScrollY: " + this.mScrollY);
        sb.append("; MaxScrollX: " + this.mMaxScrollX);
        sb.append("; MaxScrollY: " + this.mMaxScrollY);
        sb.append("; AddedCount: " + this.mAddedCount);
        sb.append("; RemovedCount: " + this.mRemovedCount);
        sb.append("; ParcelableData: " + this.mParcelableData);
        sb.append(" ]");
        return sb.toString();
    }
}
