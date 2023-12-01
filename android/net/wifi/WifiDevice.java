package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiDevice.class */
public class WifiDevice implements Parcelable {
    private static final String AP_STA_CONNECTED_STR = "AP-STA-CONNECTED";
    private static final String AP_STA_DISCONNECTED_STR = "AP-STA-DISCONNECTED";
    public static final int BLACKLISTED = 2;
    public static final int CONNECTED = 1;
    public static final Parcelable.Creator<WifiDevice> CREATOR = new Parcelable.Creator<WifiDevice>() { // from class: android.net.wifi.WifiDevice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiDevice createFromParcel(Parcel parcel) {
            WifiDevice wifiDevice = new WifiDevice();
            wifiDevice.deviceAddress = parcel.readString();
            wifiDevice.deviceName = parcel.readString();
            wifiDevice.deviceState = parcel.readInt();
            return wifiDevice;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiDevice[] newArray(int i) {
            return new WifiDevice[i];
        }
    };
    public static final int DISCONNECTED = 0;
    public String deviceAddress;
    public String deviceName;
    public int deviceState;

    public WifiDevice() {
        this.deviceAddress = "";
        this.deviceName = "";
        this.deviceState = 0;
    }

    public WifiDevice(String str) throws IllegalArgumentException {
        this.deviceAddress = "";
        this.deviceName = "";
        this.deviceState = 0;
        String[] split = str.split(" ");
        if (split.length < 2) {
            throw new IllegalArgumentException();
        }
        if (split[0].indexOf(AP_STA_CONNECTED_STR) != -1) {
            this.deviceState = 1;
        } else if (split[0].indexOf(AP_STA_DISCONNECTED_STR) == -1) {
            throw new IllegalArgumentException();
        } else {
            this.deviceState = 0;
        }
        this.deviceAddress = split[1];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof WifiDevice)) {
            return false;
        }
        WifiDevice wifiDevice = (WifiDevice) obj;
        return this.deviceAddress == null ? wifiDevice.deviceAddress == null : this.deviceAddress.equals(wifiDevice.deviceAddress);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceAddress);
        parcel.writeString(this.deviceName);
        parcel.writeInt(this.deviceState);
    }
}
