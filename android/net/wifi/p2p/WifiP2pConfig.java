package android.net.wifi.p2p;

import android.net.wifi.WpsInfo;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pConfig.class */
public class WifiP2pConfig implements Parcelable {
    public static final Parcelable.Creator<WifiP2pConfig> CREATOR = new Parcelable.Creator<WifiP2pConfig>() { // from class: android.net.wifi.p2p.WifiP2pConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pConfig createFromParcel(Parcel parcel) {
            WifiP2pConfig wifiP2pConfig = new WifiP2pConfig();
            wifiP2pConfig.deviceAddress = parcel.readString();
            wifiP2pConfig.wps = (WpsInfo) parcel.readParcelable(null);
            wifiP2pConfig.groupOwnerIntent = parcel.readInt();
            wifiP2pConfig.netId = parcel.readInt();
            return wifiP2pConfig;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pConfig[] newArray(int i) {
            return new WifiP2pConfig[i];
        }
    };
    public static final int MAX_GROUP_OWNER_INTENT = 15;
    public static final int MIN_GROUP_OWNER_INTENT = 0;
    public String deviceAddress;
    public int groupOwnerIntent;
    public int netId;
    public WpsInfo wps;

    public WifiP2pConfig() {
        this.deviceAddress = "";
        this.groupOwnerIntent = -1;
        this.netId = -2;
        this.wps = new WpsInfo();
        this.wps.setup = 0;
    }

    public WifiP2pConfig(WifiP2pConfig wifiP2pConfig) {
        this.deviceAddress = "";
        this.groupOwnerIntent = -1;
        this.netId = -2;
        if (wifiP2pConfig != null) {
            this.deviceAddress = wifiP2pConfig.deviceAddress;
            this.wps = new WpsInfo(wifiP2pConfig.wps);
            this.groupOwnerIntent = wifiP2pConfig.groupOwnerIntent;
            this.netId = wifiP2pConfig.netId;
        }
    }

    public WifiP2pConfig(String str) throws IllegalArgumentException {
        int i;
        this.deviceAddress = "";
        this.groupOwnerIntent = -1;
        this.netId = -2;
        String[] split = str.split(" ");
        if (split.length < 2 || !split[0].equals("P2P-GO-NEG-REQUEST")) {
            throw new IllegalArgumentException("Malformed supplicant event");
        }
        this.deviceAddress = split[1];
        this.wps = new WpsInfo();
        if (split.length > 2) {
            try {
                i = Integer.parseInt(split[2].split("=")[1]);
            } catch (NumberFormatException e) {
                i = 0;
            }
            switch (i) {
                case 1:
                    this.wps.setup = 1;
                    return;
                case 2:
                case 3:
                default:
                    this.wps.setup = 0;
                    return;
                case 4:
                    this.wps.setup = 0;
                    return;
                case 5:
                    this.wps.setup = 2;
                    return;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void invalidate() {
        this.deviceAddress = "";
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n address: ").append(this.deviceAddress);
        stringBuffer.append("\n wps: ").append(this.wps);
        stringBuffer.append("\n groupOwnerIntent: ").append(this.groupOwnerIntent);
        stringBuffer.append("\n persist: ").append(this.netId);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceAddress);
        parcel.writeParcelable(this.wps, i);
        parcel.writeInt(this.groupOwnerIntent);
        parcel.writeInt(this.netId);
    }
}
