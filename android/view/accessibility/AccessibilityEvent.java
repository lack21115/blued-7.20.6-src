package android.view.accessibility;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pools;
import java.util.ArrayList;

/* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityEvent.class */
public final class AccessibilityEvent extends AccessibilityRecord implements Parcelable {
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    private static final boolean DEBUG = false;
    public static final int INVALID_POSITION = -1;
    private static final int MAX_POOL_SIZE = 10;
    @Deprecated
    public static final int MAX_TEXT_LENGTH = 500;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;
    public static final int TYPE_NOTIFICATION_STATE_CHANGED = 64;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
    public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_CLICKED = 1;
    public static final int TYPE_VIEW_FOCUSED = 8;
    public static final int TYPE_VIEW_HOVER_ENTER = 128;
    public static final int TYPE_VIEW_HOVER_EXIT = 256;
    public static final int TYPE_VIEW_LONG_CLICKED = 2;
    public static final int TYPE_VIEW_SCROLLED = 4096;
    public static final int TYPE_VIEW_SELECTED = 4;
    public static final int TYPE_VIEW_TEXT_CHANGED = 16;
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOWS_CHANGED = 4194304;
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;
    public static final int TYPE_WINDOW_STATE_CHANGED = 32;
    int mAction;
    int mContentChangeTypes;
    private long mEventTime;
    private int mEventType;
    int mMovementGranularity;
    private CharSequence mPackageName;
    private ArrayList<AccessibilityRecord> mRecords;
    private static final Pools.SynchronizedPool<AccessibilityEvent> sPool = new Pools.SynchronizedPool<>(10);
    public static final Parcelable.Creator<AccessibilityEvent> CREATOR = new Parcelable.Creator<AccessibilityEvent>() { // from class: android.view.accessibility.AccessibilityEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccessibilityEvent createFromParcel(Parcel parcel) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.initFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccessibilityEvent[] newArray(int i) {
            return new AccessibilityEvent[i];
        }
    };

    private AccessibilityEvent() {
    }

    public static String eventTypeToString(int i) {
        if (i == -1) {
            return "TYPES_ALL_MASK";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = i;
        int i3 = 0;
        while (i2 != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(i2);
            i2 &= numberOfTrailingZeros ^ (-1);
            switch (numberOfTrailingZeros) {
                case 1:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_CLICKED");
                    i3++;
                    break;
                case 2:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_LONG_CLICKED");
                    i3++;
                    break;
                case 4:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_SELECTED");
                    i3++;
                    break;
                case 8:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_FOCUSED");
                    i3++;
                    break;
                case 16:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_TEXT_CHANGED");
                    i3++;
                    break;
                case 32:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_WINDOW_STATE_CHANGED");
                    i3++;
                    break;
                case 64:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_NOTIFICATION_STATE_CHANGED");
                    i3++;
                    break;
                case 128:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_HOVER_ENTER");
                    i3++;
                    break;
                case 256:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_HOVER_EXIT");
                    i3++;
                    break;
                case 512:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_TOUCH_EXPLORATION_GESTURE_START");
                    i3++;
                    break;
                case 1024:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_TOUCH_EXPLORATION_GESTURE_END");
                    i3++;
                    break;
                case 2048:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_WINDOW_CONTENT_CHANGED");
                    i3++;
                    break;
                case 4096:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_SCROLLED");
                    i3++;
                    break;
                case 8192:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_TEXT_SELECTION_CHANGED");
                    i3++;
                    break;
                case 16384:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_ANNOUNCEMENT");
                    i3++;
                    break;
                case 32768:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_ACCESSIBILITY_FOCUSED");
                    i3++;
                    break;
                case 65536:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED");
                    i3++;
                    break;
                case 131072:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY");
                    i3++;
                    break;
                case 262144:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_GESTURE_DETECTION_START");
                    i3++;
                    break;
                case 524288:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_GESTURE_DETECTION_END");
                    i3++;
                    break;
                case 1048576:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_TOUCH_INTERACTION_START");
                    i3++;
                    break;
                case 2097152:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_TOUCH_INTERACTION_END");
                    i3++;
                    break;
                case 4194304:
                    if (i3 > 0) {
                        sb.append(", ");
                    }
                    sb.append("TYPE_WINDOWS_CHANGED");
                    i3++;
                    break;
            }
        }
        if (i3 > 1) {
            sb.insert(0, '[');
            sb.append(']');
        }
        return sb.toString();
    }

    public static AccessibilityEvent obtain() {
        AccessibilityEvent accessibilityEvent = (AccessibilityEvent) sPool.acquire();
        return accessibilityEvent != null ? accessibilityEvent : new AccessibilityEvent();
    }

    public static AccessibilityEvent obtain(int i) {
        AccessibilityEvent obtain = obtain();
        obtain.setEventType(i);
        return obtain;
    }

    public static AccessibilityEvent obtain(AccessibilityEvent accessibilityEvent) {
        AccessibilityEvent obtain = obtain();
        obtain.init(accessibilityEvent);
        if (accessibilityEvent.mRecords != null) {
            int size = accessibilityEvent.mRecords.size();
            obtain.mRecords = new ArrayList<>(size);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                obtain.mRecords.add(AccessibilityRecord.obtain(accessibilityEvent.mRecords.get(i2)));
                i = i2 + 1;
            }
        }
        return obtain;
    }

    private void readAccessibilityRecordFromParcel(AccessibilityRecord accessibilityRecord, Parcel parcel) {
        accessibilityRecord.mBooleanProperties = parcel.readInt();
        accessibilityRecord.mCurrentItemIndex = parcel.readInt();
        accessibilityRecord.mItemCount = parcel.readInt();
        accessibilityRecord.mFromIndex = parcel.readInt();
        accessibilityRecord.mToIndex = parcel.readInt();
        accessibilityRecord.mScrollX = parcel.readInt();
        accessibilityRecord.mScrollY = parcel.readInt();
        accessibilityRecord.mMaxScrollX = parcel.readInt();
        accessibilityRecord.mMaxScrollY = parcel.readInt();
        accessibilityRecord.mAddedCount = parcel.readInt();
        accessibilityRecord.mRemovedCount = parcel.readInt();
        accessibilityRecord.mClassName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        accessibilityRecord.mContentDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        accessibilityRecord.mBeforeText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        accessibilityRecord.mParcelableData = parcel.readParcelable(null);
        parcel.readList(accessibilityRecord.mText, null);
        accessibilityRecord.mSourceWindowId = parcel.readInt();
        accessibilityRecord.mSourceNodeId = parcel.readLong();
        accessibilityRecord.mSealed = parcel.readInt() == 1;
    }

    private void writeAccessibilityRecordToParcel(AccessibilityRecord accessibilityRecord, Parcel parcel, int i) {
        parcel.writeInt(accessibilityRecord.mBooleanProperties);
        parcel.writeInt(accessibilityRecord.mCurrentItemIndex);
        parcel.writeInt(accessibilityRecord.mItemCount);
        parcel.writeInt(accessibilityRecord.mFromIndex);
        parcel.writeInt(accessibilityRecord.mToIndex);
        parcel.writeInt(accessibilityRecord.mScrollX);
        parcel.writeInt(accessibilityRecord.mScrollY);
        parcel.writeInt(accessibilityRecord.mMaxScrollX);
        parcel.writeInt(accessibilityRecord.mMaxScrollY);
        parcel.writeInt(accessibilityRecord.mAddedCount);
        parcel.writeInt(accessibilityRecord.mRemovedCount);
        TextUtils.writeToParcel(accessibilityRecord.mClassName, parcel, i);
        TextUtils.writeToParcel(accessibilityRecord.mContentDescription, parcel, i);
        TextUtils.writeToParcel(accessibilityRecord.mBeforeText, parcel, i);
        parcel.writeParcelable(accessibilityRecord.mParcelableData, i);
        parcel.writeList(accessibilityRecord.mText);
        parcel.writeInt(accessibilityRecord.mSourceWindowId);
        parcel.writeLong(accessibilityRecord.mSourceNodeId);
        parcel.writeInt(accessibilityRecord.mSealed ? 1 : 0);
    }

    public void appendRecord(AccessibilityRecord accessibilityRecord) {
        enforceNotSealed();
        if (this.mRecords == null) {
            this.mRecords = new ArrayList<>();
        }
        this.mRecords.add(accessibilityRecord);
    }

    @Override // android.view.accessibility.AccessibilityRecord
    protected void clear() {
        super.clear();
        this.mEventType = 0;
        this.mMovementGranularity = 0;
        this.mAction = 0;
        this.mContentChangeTypes = 0;
        this.mPackageName = null;
        this.mEventTime = 0L;
        if (this.mRecords != null) {
            while (!this.mRecords.isEmpty()) {
                this.mRecords.remove(0).recycle();
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAction() {
        return this.mAction;
    }

    public int getContentChangeTypes() {
        return this.mContentChangeTypes;
    }

    public long getEventTime() {
        return this.mEventTime;
    }

    public int getEventType() {
        return this.mEventType;
    }

    public int getMovementGranularity() {
        return this.mMovementGranularity;
    }

    public CharSequence getPackageName() {
        return this.mPackageName;
    }

    public AccessibilityRecord getRecord(int i) {
        if (this.mRecords == null) {
            throw new IndexOutOfBoundsException("Invalid index " + i + ", size is 0");
        }
        return this.mRecords.get(i);
    }

    public int getRecordCount() {
        if (this.mRecords == null) {
            return 0;
        }
        return this.mRecords.size();
    }

    void init(AccessibilityEvent accessibilityEvent) {
        super.init((AccessibilityRecord) accessibilityEvent);
        this.mEventType = accessibilityEvent.mEventType;
        this.mMovementGranularity = accessibilityEvent.mMovementGranularity;
        this.mAction = accessibilityEvent.mAction;
        this.mContentChangeTypes = accessibilityEvent.mContentChangeTypes;
        this.mEventTime = accessibilityEvent.mEventTime;
        this.mPackageName = accessibilityEvent.mPackageName;
    }

    public void initFromParcel(Parcel parcel) {
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.mSealed = z;
        this.mEventType = parcel.readInt();
        this.mMovementGranularity = parcel.readInt();
        this.mAction = parcel.readInt();
        this.mContentChangeTypes = parcel.readInt();
        this.mPackageName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mEventTime = parcel.readLong();
        this.mConnectionId = parcel.readInt();
        readAccessibilityRecordFromParcel(this, parcel);
        int readInt = parcel.readInt();
        if (readInt <= 0) {
            return;
        }
        this.mRecords = new ArrayList<>(readInt);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            AccessibilityRecord obtain = AccessibilityRecord.obtain();
            readAccessibilityRecordFromParcel(obtain, parcel);
            obtain.mConnectionId = this.mConnectionId;
            this.mRecords.add(obtain);
            i = i2 + 1;
        }
    }

    @Override // android.view.accessibility.AccessibilityRecord
    public void recycle() {
        clear();
        sPool.release(this);
    }

    public void setAction(int i) {
        enforceNotSealed();
        this.mAction = i;
    }

    public void setContentChangeTypes(int i) {
        enforceNotSealed();
        this.mContentChangeTypes = i;
    }

    public void setEventTime(long j) {
        enforceNotSealed();
        this.mEventTime = j;
    }

    public void setEventType(int i) {
        enforceNotSealed();
        this.mEventType = i;
    }

    public void setMovementGranularity(int i) {
        enforceNotSealed();
        this.mMovementGranularity = i;
    }

    public void setPackageName(CharSequence charSequence) {
        enforceNotSealed();
        this.mPackageName = charSequence;
    }

    @Override // android.view.accessibility.AccessibilityRecord
    public void setSealed(boolean z) {
        super.setSealed(z);
        ArrayList<AccessibilityRecord> arrayList = this.mRecords;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            arrayList.get(i2).setSealed(z);
            i = i2 + 1;
        }
    }

    @Override // android.view.accessibility.AccessibilityRecord
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EventType: ").append(eventTypeToString(this.mEventType));
        sb.append("; EventTime: ").append(this.mEventTime);
        sb.append("; PackageName: ").append(this.mPackageName);
        sb.append("; MovementGranularity: ").append(this.mMovementGranularity);
        sb.append("; Action: ").append(this.mAction);
        sb.append(super.toString());
        sb.append("; recordCount: ").append(getRecordCount());
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(isSealed() ? 1 : 0);
        parcel.writeInt(this.mEventType);
        parcel.writeInt(this.mMovementGranularity);
        parcel.writeInt(this.mAction);
        parcel.writeInt(this.mContentChangeTypes);
        TextUtils.writeToParcel(this.mPackageName, parcel, 0);
        parcel.writeLong(this.mEventTime);
        parcel.writeInt(this.mConnectionId);
        writeAccessibilityRecordToParcel(this, parcel, i);
        int recordCount = getRecordCount();
        parcel.writeInt(recordCount);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= recordCount) {
                return;
            }
            writeAccessibilityRecordToParcel(this.mRecords.get(i3), parcel, i);
            i2 = i3 + 1;
        }
    }
}
