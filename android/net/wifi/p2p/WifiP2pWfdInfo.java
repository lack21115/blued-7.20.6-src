package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pWfdInfo.class */
public class WifiP2pWfdInfo implements Parcelable {
    private static final int COUPLED_SINK_SUPPORT_AT_SINK = 8;
    private static final int COUPLED_SINK_SUPPORT_AT_SOURCE = 4;
    public static final Parcelable.Creator<WifiP2pWfdInfo> CREATOR = new Parcelable.Creator<WifiP2pWfdInfo>() { // from class: android.net.wifi.p2p.WifiP2pWfdInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pWfdInfo createFromParcel(Parcel parcel) {
            WifiP2pWfdInfo wifiP2pWfdInfo = new WifiP2pWfdInfo();
            wifiP2pWfdInfo.readFromParcel(parcel);
            return wifiP2pWfdInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pWfdInfo[] newArray(int i) {
            return new WifiP2pWfdInfo[i];
        }
    };
    private static final int DEVICE_TYPE = 3;
    public static final int PRIMARY_SINK = 1;
    public static final int SECONDARY_SINK = 2;
    private static final int SESSION_AVAILABLE = 48;
    private static final int SESSION_AVAILABLE_BIT1 = 16;
    private static final int SESSION_AVAILABLE_BIT2 = 32;
    public static final int SOURCE_OR_PRIMARY_SINK = 3;
    private static final String TAG = "WifiP2pWfdInfo";
    public static final int WFD_SOURCE = 0;
    private int mCtrlPort;
    private int mDeviceInfo;
    private int mMaxThroughput;
    private boolean mWfdEnabled;

    public WifiP2pWfdInfo() {
    }

    public WifiP2pWfdInfo(int i, int i2, int i3) {
        this.mWfdEnabled = true;
        this.mDeviceInfo = i;
        this.mCtrlPort = i2;
        this.mMaxThroughput = i3;
    }

    public WifiP2pWfdInfo(WifiP2pWfdInfo wifiP2pWfdInfo) {
        if (wifiP2pWfdInfo != null) {
            this.mWfdEnabled = wifiP2pWfdInfo.mWfdEnabled;
            this.mDeviceInfo = wifiP2pWfdInfo.mDeviceInfo;
            this.mCtrlPort = wifiP2pWfdInfo.mCtrlPort;
            this.mMaxThroughput = wifiP2pWfdInfo.mMaxThroughput;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getControlPort() {
        return this.mCtrlPort;
    }

    public String getDeviceInfoHex() {
        return String.format(Locale.US, "%04x%04x%04x%04x", 6, Integer.valueOf(this.mDeviceInfo), Integer.valueOf(this.mCtrlPort), Integer.valueOf(this.mMaxThroughput));
    }

    public int getDeviceType() {
        return this.mDeviceInfo & 3;
    }

    public int getMaxThroughput() {
        return this.mMaxThroughput;
    }

    public boolean isCoupledSinkSupportedAtSink() {
        return (this.mDeviceInfo & 8) != 0;
    }

    public boolean isCoupledSinkSupportedAtSource() {
        return (this.mDeviceInfo & 8) != 0;
    }

    public boolean isSessionAvailable() {
        return (this.mDeviceInfo & 48) != 0;
    }

    public boolean isWfdEnabled() {
        return this.mWfdEnabled;
    }

    public void readFromParcel(Parcel parcel) {
        boolean z = true;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.mWfdEnabled = z;
        this.mDeviceInfo = parcel.readInt();
        this.mCtrlPort = parcel.readInt();
        this.mMaxThroughput = parcel.readInt();
    }

    public void setControlPort(int i) {
        this.mCtrlPort = i;
    }

    public void setCoupledSinkSupportAtSink(boolean z) {
        if (z) {
            this.mDeviceInfo |= 8;
        } else {
            this.mDeviceInfo &= -9;
        }
    }

    public void setCoupledSinkSupportAtSource(boolean z) {
        if (z) {
            this.mDeviceInfo |= 8;
        } else {
            this.mDeviceInfo &= -9;
        }
    }

    public boolean setDeviceType(int i) {
        if (i < 0 || i > 3) {
            return false;
        }
        this.mDeviceInfo |= i;
        return true;
    }

    public void setMaxThroughput(int i) {
        this.mMaxThroughput = i;
    }

    public void setSessionAvailable(boolean z) {
        if (!z) {
            this.mDeviceInfo &= -49;
            return;
        }
        this.mDeviceInfo |= 16;
        this.mDeviceInfo &= -33;
    }

    public void setWfdEnabled(boolean z) {
        this.mWfdEnabled = z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WFD enabled: ").append(this.mWfdEnabled);
        stringBuffer.append("WFD DeviceInfo: ").append(this.mDeviceInfo);
        stringBuffer.append("\n WFD CtrlPort: ").append(this.mCtrlPort);
        stringBuffer.append("\n WFD MaxThroughput: ").append(this.mMaxThroughput);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mWfdEnabled ? 1 : 0);
        parcel.writeInt(this.mDeviceInfo);
        parcel.writeInt(this.mCtrlPort);
        parcel.writeInt(this.mMaxThroughput);
    }
}
