package android.view.accessibility;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.LongArray;
import android.util.Pools;

/* loaded from: source-4181928-dex2jar.jar:android/view/accessibility/AccessibilityWindowInfo.class */
public final class AccessibilityWindowInfo implements Parcelable {
    private static final int BOOLEAN_PROPERTY_ACCESSIBILITY_FOCUSED = 4;
    private static final int BOOLEAN_PROPERTY_ACTIVE = 1;
    private static final int BOOLEAN_PROPERTY_FOCUSED = 2;
    private static final boolean DEBUG = false;
    private static final int MAX_POOL_SIZE = 10;
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private int mBooleanProperties;
    private LongArray mChildIds;
    private static final Pools.SynchronizedPool<AccessibilityWindowInfo> sPool = new Pools.SynchronizedPool<>(10);
    public static final Parcelable.Creator<AccessibilityWindowInfo> CREATOR = new Parcelable.Creator<AccessibilityWindowInfo>() { // from class: android.view.accessibility.AccessibilityWindowInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccessibilityWindowInfo createFromParcel(Parcel parcel) {
            AccessibilityWindowInfo obtain = AccessibilityWindowInfo.obtain();
            obtain.initFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccessibilityWindowInfo[] newArray(int i) {
            return new AccessibilityWindowInfo[i];
        }
    };
    private int mType = -1;
    private int mLayer = -1;
    private int mId = -1;
    private int mParentId = -1;
    private final Rect mBoundsInScreen = new Rect();
    private int mConnectionId = -1;

    private AccessibilityWindowInfo() {
    }

    private void clear() {
        this.mType = -1;
        this.mLayer = -1;
        this.mBooleanProperties = 0;
        this.mId = -1;
        this.mParentId = -1;
        this.mBoundsInScreen.setEmpty();
        if (this.mChildIds != null) {
            this.mChildIds.clear();
        }
        this.mConnectionId = -1;
    }

    private boolean getBooleanProperty(int i) {
        return (this.mBooleanProperties & i) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFromParcel(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mLayer = parcel.readInt();
        this.mBooleanProperties = parcel.readInt();
        this.mId = parcel.readInt();
        this.mParentId = parcel.readInt();
        this.mBoundsInScreen.readFromParcel(parcel);
        int readInt = parcel.readInt();
        if (readInt > 0) {
            if (this.mChildIds == null) {
                this.mChildIds = new LongArray(readInt);
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                this.mChildIds.add(parcel.readInt());
                i = i2 + 1;
            }
        }
        this.mConnectionId = parcel.readInt();
    }

    public static AccessibilityWindowInfo obtain() {
        AccessibilityWindowInfo accessibilityWindowInfo = (AccessibilityWindowInfo) sPool.acquire();
        AccessibilityWindowInfo accessibilityWindowInfo2 = accessibilityWindowInfo;
        if (accessibilityWindowInfo == null) {
            accessibilityWindowInfo2 = new AccessibilityWindowInfo();
        }
        return accessibilityWindowInfo2;
    }

    public static AccessibilityWindowInfo obtain(AccessibilityWindowInfo accessibilityWindowInfo) {
        AccessibilityWindowInfo obtain = obtain();
        obtain.mType = accessibilityWindowInfo.mType;
        obtain.mLayer = accessibilityWindowInfo.mLayer;
        obtain.mBooleanProperties = accessibilityWindowInfo.mBooleanProperties;
        obtain.mId = accessibilityWindowInfo.mId;
        obtain.mParentId = accessibilityWindowInfo.mParentId;
        obtain.mBoundsInScreen.set(accessibilityWindowInfo.mBoundsInScreen);
        if (accessibilityWindowInfo.mChildIds != null && accessibilityWindowInfo.mChildIds.size() > 0) {
            if (obtain.mChildIds == null) {
                obtain.mChildIds = accessibilityWindowInfo.mChildIds.clone();
            } else {
                obtain.mChildIds.addAll(accessibilityWindowInfo.mChildIds);
            }
        }
        obtain.mConnectionId = accessibilityWindowInfo.mConnectionId;
        return obtain;
    }

    private void setBooleanProperty(int i, boolean z) {
        if (z) {
            this.mBooleanProperties |= i;
        } else {
            this.mBooleanProperties &= i ^ (-1);
        }
    }

    private static String typeToString(int i) {
        switch (i) {
            case 1:
                return "TYPE_APPLICATION";
            case 2:
                return "TYPE_INPUT_METHOD";
            case 3:
                return "TYPE_SYSTEM";
            case 4:
                return "TYPE_ACCESSIBILITY_OVERLAY";
            default:
                return "<UNKNOWN>";
        }
    }

    public void addChild(int i) {
        if (this.mChildIds == null) {
            this.mChildIds = new LongArray();
        }
        this.mChildIds.add(i);
    }

    public boolean changed(AccessibilityWindowInfo accessibilityWindowInfo) {
        if (accessibilityWindowInfo.mId != this.mId) {
            throw new IllegalArgumentException("Not same window.");
        }
        if (accessibilityWindowInfo.mType != this.mType) {
            throw new IllegalArgumentException("Not same type.");
        }
        if (this.mBoundsInScreen.equals(this.mBoundsInScreen) && this.mLayer == accessibilityWindowInfo.mLayer && this.mBooleanProperties == accessibilityWindowInfo.mBooleanProperties && this.mParentId == accessibilityWindowInfo.mParentId) {
            return this.mChildIds == null ? accessibilityWindowInfo.mChildIds != null : !this.mChildIds.equals(accessibilityWindowInfo.mChildIds);
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mId == ((AccessibilityWindowInfo) obj).mId;
    }

    public void getBoundsInScreen(Rect rect) {
        rect.set(this.mBoundsInScreen);
    }

    public AccessibilityWindowInfo getChild(int i) {
        if (this.mChildIds == null) {
            throw new IndexOutOfBoundsException();
        }
        if (this.mConnectionId == -1) {
            return null;
        }
        return AccessibilityInteractionClient.getInstance().getWindow(this.mConnectionId, (int) this.mChildIds.get(i));
    }

    public int getChildCount() {
        if (this.mChildIds != null) {
            return this.mChildIds.size();
        }
        return 0;
    }

    public int getId() {
        return this.mId;
    }

    public int getLayer() {
        return this.mLayer;
    }

    public AccessibilityWindowInfo getParent() {
        if (this.mConnectionId == -1 || this.mParentId == -1) {
            return null;
        }
        return AccessibilityInteractionClient.getInstance().getWindow(this.mConnectionId, this.mParentId);
    }

    public AccessibilityNodeInfo getRoot() {
        if (this.mConnectionId == -1) {
            return null;
        }
        return AccessibilityInteractionClient.getInstance().findAccessibilityNodeInfoByAccessibilityId(this.mConnectionId, this.mId, AccessibilityNodeInfo.ROOT_NODE_ID, true, 4);
    }

    public int getType() {
        return this.mType;
    }

    public int hashCode() {
        return this.mId;
    }

    public boolean isAccessibilityFocused() {
        return getBooleanProperty(4);
    }

    public boolean isActive() {
        return getBooleanProperty(1);
    }

    public boolean isFocused() {
        return getBooleanProperty(2);
    }

    public void recycle() {
        clear();
        sPool.release(this);
    }

    public void setAccessibilityFocused(boolean z) {
        setBooleanProperty(4, z);
    }

    public void setActive(boolean z) {
        setBooleanProperty(1, z);
    }

    public void setBoundsInScreen(Rect rect) {
        this.mBoundsInScreen.set(rect);
    }

    public void setConnectionId(int i) {
        this.mConnectionId = i;
    }

    public void setFocused(boolean z) {
        setBooleanProperty(2, z);
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setLayer(int i) {
        this.mLayer = i;
    }

    public void setParentId(int i) {
        this.mParentId = i;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccessibilityWindowInfo[");
        sb.append("id=").append(this.mId);
        sb.append(", type=").append(typeToString(this.mType));
        sb.append(", layer=").append(this.mLayer);
        sb.append(", bounds=").append(this.mBoundsInScreen);
        sb.append(", focused=").append(isFocused());
        sb.append(", active=").append(isActive());
        sb.append(", hasParent=").append(this.mParentId != -1);
        sb.append(", hasChildren=").append(this.mChildIds != null && this.mChildIds.size() > 0);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mLayer);
        parcel.writeInt(this.mBooleanProperties);
        parcel.writeInt(this.mId);
        parcel.writeInt(this.mParentId);
        this.mBoundsInScreen.writeToParcel(parcel, i);
        LongArray longArray = this.mChildIds;
        if (longArray != null) {
            int size = longArray.size();
            parcel.writeInt(size);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= size) {
                    break;
                }
                parcel.writeInt((int) longArray.get(i3));
                i2 = i3 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.mConnectionId);
    }
}
