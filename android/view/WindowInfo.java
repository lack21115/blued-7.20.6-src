package android.view;

import android.graphics.Rect;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4181928-dex2jar.jar:android/view/WindowInfo.class */
public class WindowInfo implements Parcelable {
    private static final int MAX_POOL_SIZE = 10;
    public final Rect boundsInScreen = new Rect();
    public List<IBinder> childTokens;
    public boolean focused;
    public int layer;
    public IBinder parentToken;
    public IBinder token;
    public int type;
    private static final Pools.SynchronizedPool<WindowInfo> sPool = new Pools.SynchronizedPool<>(10);
    public static final Parcelable.Creator<WindowInfo> CREATOR = new Parcelable.Creator<WindowInfo>() { // from class: android.view.WindowInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WindowInfo createFromParcel(Parcel parcel) {
            WindowInfo obtain = WindowInfo.obtain();
            obtain.initFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WindowInfo[] newArray(int i) {
            return new WindowInfo[i];
        }
    };

    private WindowInfo() {
    }

    private void clear() {
        this.type = 0;
        this.layer = 0;
        this.token = null;
        this.parentToken = null;
        this.focused = false;
        this.boundsInScreen.setEmpty();
        if (this.childTokens != null) {
            this.childTokens.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initFromParcel(Parcel parcel) {
        this.type = parcel.readInt();
        this.layer = parcel.readInt();
        this.token = parcel.readStrongBinder();
        this.parentToken = parcel.readStrongBinder();
        this.focused = parcel.readInt() == 1;
        this.boundsInScreen.readFromParcel(parcel);
        if (parcel.readInt() == 1) {
            if (this.childTokens == null) {
                this.childTokens = new ArrayList();
            }
            parcel.readBinderList(this.childTokens);
        }
    }

    public static WindowInfo obtain() {
        WindowInfo windowInfo = (WindowInfo) sPool.acquire();
        WindowInfo windowInfo2 = windowInfo;
        if (windowInfo == null) {
            windowInfo2 = new WindowInfo();
        }
        return windowInfo2;
    }

    public static WindowInfo obtain(WindowInfo windowInfo) {
        WindowInfo obtain = obtain();
        obtain.type = windowInfo.type;
        obtain.layer = windowInfo.layer;
        obtain.token = windowInfo.token;
        obtain.parentToken = windowInfo.parentToken;
        obtain.focused = windowInfo.focused;
        obtain.boundsInScreen.set(windowInfo.boundsInScreen);
        if (windowInfo.childTokens != null && !windowInfo.childTokens.isEmpty()) {
            if (obtain.childTokens != null) {
                obtain.childTokens.addAll(windowInfo.childTokens);
                return obtain;
            }
            obtain.childTokens = new ArrayList(windowInfo.childTokens);
        }
        return obtain;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void recycle() {
        clear();
        sPool.release(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WindowInfo[");
        sb.append("type=").append(this.type);
        sb.append(", layer=").append(this.layer);
        sb.append(", token=").append(this.token);
        sb.append(", bounds=").append(this.boundsInScreen);
        sb.append(", parent=").append(this.parentToken);
        sb.append(", focused=").append(this.focused);
        sb.append(", children=").append(this.childTokens);
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.layer);
        parcel.writeStrongBinder(this.token);
        parcel.writeStrongBinder(this.parentToken);
        parcel.writeInt(this.focused ? 1 : 0);
        this.boundsInScreen.writeToParcel(parcel, i);
        if (this.childTokens == null || this.childTokens.isEmpty()) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeBinderList(this.childTokens);
    }
}
