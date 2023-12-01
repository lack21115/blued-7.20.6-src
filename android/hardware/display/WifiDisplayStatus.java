package android.hardware.display;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/display/WifiDisplayStatus.class */
public final class WifiDisplayStatus implements Parcelable {
    public static final Parcelable.Creator<WifiDisplayStatus> CREATOR = new Parcelable.Creator<WifiDisplayStatus>() { // from class: android.hardware.display.WifiDisplayStatus.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiDisplayStatus createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            WifiDisplay wifiDisplay = null;
            if (parcel.readInt() != 0) {
                wifiDisplay = WifiDisplay.CREATOR.createFromParcel(parcel);
            }
            WifiDisplay[] newArray = WifiDisplay.CREATOR.newArray(parcel.readInt());
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= newArray.length) {
                    return new WifiDisplayStatus(readInt, readInt2, readInt3, wifiDisplay, newArray, WifiDisplaySessionInfo.CREATOR.createFromParcel(parcel));
                }
                newArray[i2] = WifiDisplay.CREATOR.createFromParcel(parcel);
                i = i2 + 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiDisplayStatus[] newArray(int i) {
            return new WifiDisplayStatus[i];
        }
    };
    public static final int DISPLAY_STATE_CONNECTED = 2;
    public static final int DISPLAY_STATE_CONNECTING = 1;
    public static final int DISPLAY_STATE_NOT_CONNECTED = 0;
    public static final int FEATURE_STATE_DISABLED = 1;
    public static final int FEATURE_STATE_OFF = 2;
    public static final int FEATURE_STATE_ON = 3;
    public static final int FEATURE_STATE_UNAVAILABLE = 0;
    public static final int SCAN_STATE_NOT_SCANNING = 0;
    public static final int SCAN_STATE_SCANNING = 1;
    private final WifiDisplay mActiveDisplay;
    private final int mActiveDisplayState;
    private final WifiDisplay[] mDisplays;
    private final int mFeatureState;
    private final int mScanState;
    private final WifiDisplaySessionInfo mSessionInfo;

    public WifiDisplayStatus() {
        this(0, 0, 0, null, WifiDisplay.EMPTY_ARRAY, null);
    }

    public WifiDisplayStatus(int i, int i2, int i3, WifiDisplay wifiDisplay, WifiDisplay[] wifiDisplayArr, WifiDisplaySessionInfo wifiDisplaySessionInfo) {
        if (wifiDisplayArr == null) {
            throw new IllegalArgumentException("displays must not be null");
        }
        this.mFeatureState = i;
        this.mScanState = i2;
        this.mActiveDisplayState = i3;
        this.mActiveDisplay = wifiDisplay;
        this.mDisplays = wifiDisplayArr;
        this.mSessionInfo = wifiDisplaySessionInfo == null ? new WifiDisplaySessionInfo() : wifiDisplaySessionInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WifiDisplay getActiveDisplay() {
        return this.mActiveDisplay;
    }

    public int getActiveDisplayState() {
        return this.mActiveDisplayState;
    }

    public WifiDisplay[] getDisplays() {
        return this.mDisplays;
    }

    public int getFeatureState() {
        return this.mFeatureState;
    }

    public int getScanState() {
        return this.mScanState;
    }

    public WifiDisplaySessionInfo getSessionInfo() {
        return this.mSessionInfo;
    }

    public String toString() {
        return "WifiDisplayStatus{featureState=" + this.mFeatureState + ", scanState=" + this.mScanState + ", activeDisplayState=" + this.mActiveDisplayState + ", activeDisplay=" + this.mActiveDisplay + ", displays=" + Arrays.toString(this.mDisplays) + ", sessionInfo=" + this.mSessionInfo + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mFeatureState);
        parcel.writeInt(this.mScanState);
        parcel.writeInt(this.mActiveDisplayState);
        if (this.mActiveDisplay != null) {
            parcel.writeInt(1);
            this.mActiveDisplay.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.mDisplays.length);
        WifiDisplay[] wifiDisplayArr = this.mDisplays;
        int length = wifiDisplayArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                this.mSessionInfo.writeToParcel(parcel, i);
                return;
            } else {
                wifiDisplayArr[i3].writeToParcel(parcel, i);
                i2 = i3 + 1;
            }
        }
    }
}
