package android.hardware.display;

import android.os.Parcel;
import android.os.Parcelable;
import libcore.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/display/WifiDisplay.class */
public final class WifiDisplay implements Parcelable {
    private final boolean mCanConnect;
    private final String mDeviceAddress;
    private final String mDeviceAlias;
    private final String mDeviceName;
    private final boolean mIsAvailable;
    private final boolean mIsRemembered;
    public static final WifiDisplay[] EMPTY_ARRAY = new WifiDisplay[0];
    public static final Parcelable.Creator<WifiDisplay> CREATOR = new Parcelable.Creator<WifiDisplay>() { // from class: android.hardware.display.WifiDisplay.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiDisplay createFromParcel(Parcel parcel) {
            return new WifiDisplay(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiDisplay[] newArray(int i) {
            return i == 0 ? WifiDisplay.EMPTY_ARRAY : new WifiDisplay[i];
        }
    };

    public WifiDisplay(String str, String str2, String str3, boolean z, boolean z2, boolean z3) {
        if (str == null) {
            throw new IllegalArgumentException("deviceAddress must not be null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("deviceName must not be null");
        }
        this.mDeviceAddress = str;
        this.mDeviceName = str2;
        this.mDeviceAlias = str3;
        this.mIsAvailable = z;
        this.mCanConnect = z2;
        this.mIsRemembered = z3;
    }

    public boolean canConnect() {
        return this.mCanConnect;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(WifiDisplay wifiDisplay) {
        return wifiDisplay != null && this.mDeviceAddress.equals(wifiDisplay.mDeviceAddress) && this.mDeviceName.equals(wifiDisplay.mDeviceName) && Objects.equal(this.mDeviceAlias, wifiDisplay.mDeviceAlias);
    }

    public boolean equals(Object obj) {
        return (obj instanceof WifiDisplay) && equals((WifiDisplay) obj);
    }

    public String getDeviceAddress() {
        return this.mDeviceAddress;
    }

    public String getDeviceAlias() {
        return this.mDeviceAlias;
    }

    public String getDeviceName() {
        return this.mDeviceName;
    }

    public String getFriendlyDisplayName() {
        return this.mDeviceAlias != null ? this.mDeviceAlias : this.mDeviceName;
    }

    public boolean hasSameAddress(WifiDisplay wifiDisplay) {
        return wifiDisplay != null && this.mDeviceAddress.equals(wifiDisplay.mDeviceAddress);
    }

    public int hashCode() {
        return this.mDeviceAddress.hashCode();
    }

    public boolean isAvailable() {
        return this.mIsAvailable;
    }

    public boolean isRemembered() {
        return this.mIsRemembered;
    }

    public String toString() {
        String str = this.mDeviceName + " (" + this.mDeviceAddress + ")";
        String str2 = str;
        if (this.mDeviceAlias != null) {
            str2 = str + ", alias " + this.mDeviceAlias;
        }
        return str2 + ", isAvailable " + this.mIsAvailable + ", canConnect " + this.mCanConnect + ", isRemembered " + this.mIsRemembered;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDeviceAddress);
        parcel.writeString(this.mDeviceName);
        parcel.writeString(this.mDeviceAlias);
        parcel.writeInt(this.mIsAvailable ? 1 : 0);
        parcel.writeInt(this.mCanConnect ? 1 : 0);
        parcel.writeInt(this.mIsRemembered ? 1 : 0);
    }
}
