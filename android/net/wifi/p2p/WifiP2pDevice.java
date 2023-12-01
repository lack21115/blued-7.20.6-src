package android.net.wifi.p2p;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/p2p/WifiP2pDevice.class */
public class WifiP2pDevice implements Parcelable {
    public static final int AVAILABLE = 3;
    public static final int CONNECTED = 0;
    private static final int DEVICE_CAPAB_CLIENT_DISCOVERABILITY = 2;
    private static final int DEVICE_CAPAB_CONCURRENT_OPER = 4;
    private static final int DEVICE_CAPAB_DEVICE_LIMIT = 16;
    private static final int DEVICE_CAPAB_INFRA_MANAGED = 8;
    private static final int DEVICE_CAPAB_INVITATION_PROCEDURE = 32;
    private static final int DEVICE_CAPAB_SERVICE_DISCOVERY = 1;
    public static final int FAILED = 2;
    private static final int GROUP_CAPAB_CROSS_CONN = 16;
    private static final int GROUP_CAPAB_GROUP_FORMATION = 64;
    private static final int GROUP_CAPAB_GROUP_LIMIT = 4;
    private static final int GROUP_CAPAB_GROUP_OWNER = 1;
    private static final int GROUP_CAPAB_INTRA_BSS_DIST = 8;
    private static final int GROUP_CAPAB_PERSISTENT_GROUP = 2;
    private static final int GROUP_CAPAB_PERSISTENT_RECONN = 32;
    public static final int INVITED = 1;
    private static final String TAG = "WifiP2pDevice";
    public static final int UNAVAILABLE = 4;
    private static final int WPS_CONFIG_DISPLAY = 8;
    private static final int WPS_CONFIG_KEYPAD = 256;
    private static final int WPS_CONFIG_PUSHBUTTON = 128;
    public String deviceAddress;
    public int deviceCapability;
    public String deviceName;
    public int groupCapability;
    public String primaryDeviceType;
    public String secondaryDeviceType;
    public int status;
    public WifiP2pWfdInfo wfdInfo;
    public int wpsConfigMethodsSupported;
    private static final Pattern detailedDevicePattern = Pattern.compile("((?:[0-9a-f]{2}:){5}[0-9a-f]{2}) (\\d+ )?p2p_dev_addr=((?:[0-9a-f]{2}:){5}[0-9a-f]{2}) pri_dev_type=(\\d+-[0-9a-fA-F]+-\\d+) name='(.*)' config_methods=(0x[0-9a-fA-F]+) dev_capab=(0x[0-9a-fA-F]+) group_capab=(0x[0-9a-fA-F]+)( wfd_dev_info=0x([0-9a-fA-F]{12}))?");
    private static final Pattern twoTokenPattern = Pattern.compile("(p2p_dev_addr=)?((?:[0-9a-f]{2}:){5}[0-9a-f]{2})");
    private static final Pattern threeTokenPattern = Pattern.compile("(?:[0-9a-f]{2}:){5}[0-9a-f]{2} p2p_dev_addr=((?:[0-9a-f]{2}:){5}[0-9a-f]{2})");
    public static final Parcelable.Creator<WifiP2pDevice> CREATOR = new Parcelable.Creator<WifiP2pDevice>() { // from class: android.net.wifi.p2p.WifiP2pDevice.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pDevice createFromParcel(Parcel parcel) {
            WifiP2pDevice wifiP2pDevice = new WifiP2pDevice();
            wifiP2pDevice.deviceName = parcel.readString();
            wifiP2pDevice.deviceAddress = parcel.readString();
            wifiP2pDevice.primaryDeviceType = parcel.readString();
            wifiP2pDevice.secondaryDeviceType = parcel.readString();
            wifiP2pDevice.wpsConfigMethodsSupported = parcel.readInt();
            wifiP2pDevice.deviceCapability = parcel.readInt();
            wifiP2pDevice.groupCapability = parcel.readInt();
            wifiP2pDevice.status = parcel.readInt();
            if (parcel.readInt() == 1) {
                wifiP2pDevice.wfdInfo = WifiP2pWfdInfo.CREATOR.createFromParcel(parcel);
            }
            return wifiP2pDevice;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiP2pDevice[] newArray(int i) {
            return new WifiP2pDevice[i];
        }
    };

    public WifiP2pDevice() {
        this.deviceName = "";
        this.deviceAddress = "";
        this.status = 4;
    }

    public WifiP2pDevice(WifiP2pDevice wifiP2pDevice) {
        this.deviceName = "";
        this.deviceAddress = "";
        this.status = 4;
        if (wifiP2pDevice != null) {
            this.deviceName = wifiP2pDevice.deviceName;
            this.deviceAddress = wifiP2pDevice.deviceAddress;
            this.primaryDeviceType = wifiP2pDevice.primaryDeviceType;
            this.secondaryDeviceType = wifiP2pDevice.secondaryDeviceType;
            this.wpsConfigMethodsSupported = wifiP2pDevice.wpsConfigMethodsSupported;
            this.deviceCapability = wifiP2pDevice.deviceCapability;
            this.groupCapability = wifiP2pDevice.groupCapability;
            this.status = wifiP2pDevice.status;
            this.wfdInfo = new WifiP2pWfdInfo(wifiP2pDevice.wfdInfo);
        }
    }

    public WifiP2pDevice(String str) throws IllegalArgumentException {
        this.deviceName = "";
        this.deviceAddress = "";
        this.status = 4;
        String[] split = str.split("[ \n]");
        if (split.length < 1) {
            throw new IllegalArgumentException("Malformed supplicant event");
        }
        switch (split.length) {
            case 1:
                this.deviceAddress = str;
                return;
            case 2:
                Matcher matcher = twoTokenPattern.matcher(str);
                if (!matcher.find()) {
                    throw new IllegalArgumentException("Malformed supplicant event");
                }
                this.deviceAddress = matcher.group(2);
                return;
            case 3:
                Matcher matcher2 = threeTokenPattern.matcher(str);
                if (!matcher2.find()) {
                    throw new IllegalArgumentException("Malformed supplicant event");
                }
                this.deviceAddress = matcher2.group(1);
                return;
            default:
                Matcher matcher3 = detailedDevicePattern.matcher(str);
                if (!matcher3.find()) {
                    throw new IllegalArgumentException("Malformed supplicant event");
                }
                this.deviceAddress = matcher3.group(3);
                this.primaryDeviceType = matcher3.group(4);
                this.deviceName = matcher3.group(5);
                this.wpsConfigMethodsSupported = parseHex(matcher3.group(6));
                this.deviceCapability = parseHex(matcher3.group(7));
                this.groupCapability = parseHex(matcher3.group(8));
                if (matcher3.group(9) != null) {
                    String group = matcher3.group(10);
                    this.wfdInfo = new WifiP2pWfdInfo(parseHex(group.substring(0, 4)), parseHex(group.substring(4, 8)), parseHex(group.substring(8, 12)));
                }
                if (split[0].startsWith("P2P-DEVICE-FOUND")) {
                    this.status = 3;
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r5.startsWith("0X") != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int parseHex(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r1 = "0x"
            boolean r0 = r0.startsWith(r1)
            if (r0 != 0) goto L14
            r0 = r5
            r7 = r0
            r0 = r5
            java.lang.String r1 = "0X"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L1a
        L14:
            r0 = r5
            r1 = 2
            java.lang.String r0 = r0.substring(r1)
            r7 = r0
        L1a:
            r0 = r7
            r1 = 16
            int r0 = java.lang.Integer.parseInt(r0, r1)     // Catch: java.lang.NumberFormatException -> L23
            r6 = r0
            r0 = r6
            return r0
        L23:
            r5 = move-exception
            java.lang.String r0 = "WifiP2pDevice"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = r1
            r2.<init>()
            java.lang.String r2 = "Failed to parse hex string "
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r7
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            int r0 = android.util.Log.e(r0, r1)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.wifi.p2p.WifiP2pDevice.parseHex(java.lang.String):int");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WifiP2pDevice) {
            WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) obj;
            return (wifiP2pDevice == null || wifiP2pDevice.deviceAddress == null) ? this.deviceAddress == null : wifiP2pDevice.deviceAddress.equals(this.deviceAddress);
        }
        return false;
    }

    public boolean isDeviceLimit() {
        return (this.deviceCapability & 16) != 0;
    }

    public boolean isGroupLimit() {
        return (this.groupCapability & 4) != 0;
    }

    public boolean isGroupOwner() {
        return (this.groupCapability & 1) != 0;
    }

    public boolean isInvitationCapable() {
        return (this.deviceCapability & 32) != 0;
    }

    public boolean isServiceDiscoveryCapable() {
        return (this.deviceCapability & 1) != 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Device: ").append(this.deviceName);
        stringBuffer.append("\n deviceAddress: ").append(this.deviceAddress);
        stringBuffer.append("\n primary type: ").append(this.primaryDeviceType);
        stringBuffer.append("\n secondary type: ").append(this.secondaryDeviceType);
        stringBuffer.append("\n wps: ").append(this.wpsConfigMethodsSupported);
        stringBuffer.append("\n grpcapab: ").append(this.groupCapability);
        stringBuffer.append("\n devcapab: ").append(this.deviceCapability);
        stringBuffer.append("\n status: ").append(this.status);
        stringBuffer.append("\n wfdInfo: ").append(this.wfdInfo);
        return stringBuffer.toString();
    }

    public void update(WifiP2pDevice wifiP2pDevice) {
        updateSupplicantDetails(wifiP2pDevice);
        this.status = wifiP2pDevice.status;
    }

    public void updateSupplicantDetails(WifiP2pDevice wifiP2pDevice) {
        if (wifiP2pDevice == null) {
            throw new IllegalArgumentException("device is null");
        }
        if (wifiP2pDevice.deviceAddress == null) {
            throw new IllegalArgumentException("deviceAddress is null");
        }
        if (!this.deviceAddress.equals(wifiP2pDevice.deviceAddress)) {
            throw new IllegalArgumentException("deviceAddress does not match");
        }
        this.deviceName = wifiP2pDevice.deviceName;
        this.primaryDeviceType = wifiP2pDevice.primaryDeviceType;
        this.secondaryDeviceType = wifiP2pDevice.secondaryDeviceType;
        this.wpsConfigMethodsSupported = wifiP2pDevice.wpsConfigMethodsSupported;
        this.deviceCapability = wifiP2pDevice.deviceCapability;
        this.groupCapability = wifiP2pDevice.groupCapability;
        this.wfdInfo = wifiP2pDevice.wfdInfo;
    }

    public boolean wpsDisplaySupported() {
        return (this.wpsConfigMethodsSupported & 8) != 0;
    }

    public boolean wpsKeypadSupported() {
        return (this.wpsConfigMethodsSupported & 256) != 0;
    }

    public boolean wpsPbcSupported() {
        return (this.wpsConfigMethodsSupported & 128) != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceName);
        parcel.writeString(this.deviceAddress);
        parcel.writeString(this.primaryDeviceType);
        parcel.writeString(this.secondaryDeviceType);
        parcel.writeInt(this.wpsConfigMethodsSupported);
        parcel.writeInt(this.deviceCapability);
        parcel.writeInt(this.groupCapability);
        parcel.writeInt(this.status);
        if (this.wfdInfo == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        this.wfdInfo.writeToParcel(parcel, i);
    }
}
