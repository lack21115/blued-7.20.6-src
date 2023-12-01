package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/ScanResult.class */
public class ScanResult implements Parcelable {
    public static final int AUTHENTICATION_ERROR = 128;
    public static final int AUTO_JOIN_DISABLED = 32;
    public static final int AUTO_ROAM_DISABLED = 16;
    public static final Parcelable.Creator<ScanResult> CREATOR = new Parcelable.Creator<ScanResult>() { // from class: android.net.wifi.ScanResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScanResult createFromParcel(Parcel parcel) {
            WifiSsid wifiSsid = null;
            if (parcel.readInt() == 1) {
                wifiSsid = WifiSsid.CREATOR.createFromParcel(parcel);
            }
            ScanResult scanResult = new ScanResult(wifiSsid, parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readInt(), parcel.readInt());
            scanResult.seen = parcel.readLong();
            scanResult.autoJoinStatus = parcel.readInt();
            scanResult.untrusted = parcel.readInt() != 0;
            scanResult.numConnection = parcel.readInt();
            scanResult.numUsage = parcel.readInt();
            scanResult.numIpConfigFailures = parcel.readInt();
            scanResult.isAutoJoinCandidate = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt != 0) {
                scanResult.informationElements = new InformationElement[readInt];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readInt) {
                        break;
                    }
                    scanResult.informationElements[i2] = new InformationElement();
                    scanResult.informationElements[i2].id = parcel.readInt();
                    scanResult.informationElements[i2].bytes = new byte[parcel.readInt()];
                    parcel.readByteArray(scanResult.informationElements[i2].bytes);
                    i = i2 + 1;
                }
            }
            return scanResult;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScanResult[] newArray(int i) {
            return new ScanResult[i];
        }
    };
    public static final int ENABLED = 0;
    public static final int UNSPECIFIED = -1;
    public String BSSID;
    public String SSID;
    public int autoJoinStatus;
    public long blackListTimestamp;
    public String capabilities;
    public int distanceCm;
    public int distanceSdCm;
    public int frequency;
    public InformationElement[] informationElements;
    public int isAutoJoinCandidate;
    public int level;
    public int numConnection;
    public int numIpConfigFailures;
    public int numUsage;
    public long seen;
    public long timestamp;
    public boolean untrusted;
    public WifiSsid wifiSsid;

    /* loaded from: source-9557208-dex2jar.jar:android/net/wifi/ScanResult$InformationElement.class */
    public static class InformationElement {
        public byte[] bytes;
        public int id;

        public InformationElement() {
        }

        public InformationElement(InformationElement informationElement) {
            this.id = informationElement.id;
            this.bytes = (byte[]) informationElement.bytes.clone();
        }
    }

    public ScanResult() {
    }

    public ScanResult(ScanResult scanResult) {
        if (scanResult != null) {
            this.wifiSsid = scanResult.wifiSsid;
            this.SSID = scanResult.SSID;
            this.BSSID = scanResult.BSSID;
            this.capabilities = scanResult.capabilities;
            this.level = scanResult.level;
            this.frequency = scanResult.frequency;
            this.timestamp = scanResult.timestamp;
            this.distanceCm = scanResult.distanceCm;
            this.distanceSdCm = scanResult.distanceSdCm;
            this.seen = scanResult.seen;
            this.autoJoinStatus = scanResult.autoJoinStatus;
            this.untrusted = scanResult.untrusted;
            this.numConnection = scanResult.numConnection;
            this.numUsage = scanResult.numUsage;
            this.numIpConfigFailures = scanResult.numIpConfigFailures;
            this.isAutoJoinCandidate = scanResult.isAutoJoinCandidate;
        }
    }

    public ScanResult(WifiSsid wifiSsid, String str, String str2, int i, int i2, long j) {
        this.wifiSsid = wifiSsid;
        this.SSID = wifiSsid != null ? wifiSsid.toString() : WifiSsid.NONE;
        this.BSSID = str;
        this.capabilities = str2;
        this.level = i;
        this.frequency = i2;
        this.timestamp = j;
        this.distanceCm = -1;
        this.distanceSdCm = -1;
    }

    public ScanResult(WifiSsid wifiSsid, String str, String str2, int i, int i2, long j, int i3, int i4) {
        this.wifiSsid = wifiSsid;
        this.SSID = wifiSsid != null ? wifiSsid.toString() : WifiSsid.NONE;
        this.BSSID = str;
        this.capabilities = str2;
        this.level = i;
        this.frequency = i2;
        this.timestamp = j;
        this.distanceCm = i3;
        this.distanceSdCm = i4;
    }

    public static boolean is24GHz(int i) {
        return i > 2400 && i < 2500;
    }

    public static boolean is5GHz(int i) {
        return i > 4900 && i < 5900;
    }

    public void averageRssi(int i, long j, int i2) {
        if (this.seen == 0) {
            this.seen = System.currentTimeMillis();
        }
        long j2 = this.seen - j;
        if (j <= 0 || j2 <= 0 || j2 >= i2 / 2) {
            return;
        }
        double d = 0.5d - (j2 / i2);
        this.level = (int) ((this.level * (1.0d - d)) + (i * d));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean is24GHz() {
        return is24GHz(this.frequency);
    }

    public boolean is5GHz() {
        return is5GHz(this.frequency);
    }

    public void setAutoJoinStatus(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            this.blackListTimestamp = 0L;
        } else if (i2 > this.autoJoinStatus) {
            this.blackListTimestamp = System.currentTimeMillis();
        }
        this.autoJoinStatus = i2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SSID: ").append(this.wifiSsid == null ? WifiSsid.NONE : this.wifiSsid).append(", BSSID: ").append(this.BSSID == null ? "<none>" : this.BSSID).append(", capabilities: ").append(this.capabilities == null ? "<none>" : this.capabilities).append(", level: ").append(this.level).append(", frequency: ").append(this.frequency).append(", timestamp: ").append(this.timestamp);
        stringBuffer.append(", distance: ").append(this.distanceCm != -1 ? Integer.valueOf(this.distanceCm) : "?").append("(cm)");
        stringBuffer.append(", distanceSd: ").append(this.distanceSdCm != -1 ? Integer.valueOf(this.distanceSdCm) : "?").append("(cm)");
        if (this.autoJoinStatus != 0) {
            stringBuffer.append(", status: ").append(this.autoJoinStatus);
        }
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.wifiSsid != null) {
            parcel.writeInt(1);
            this.wifiSsid.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.BSSID);
        parcel.writeString(this.capabilities);
        parcel.writeInt(this.level);
        parcel.writeInt(this.frequency);
        parcel.writeLong(this.timestamp);
        parcel.writeInt(this.distanceCm);
        parcel.writeInt(this.distanceSdCm);
        parcel.writeLong(this.seen);
        parcel.writeInt(this.autoJoinStatus);
        parcel.writeInt(this.untrusted ? 1 : 0);
        parcel.writeInt(this.numConnection);
        parcel.writeInt(this.numUsage);
        parcel.writeInt(this.numIpConfigFailures);
        parcel.writeInt(this.isAutoJoinCandidate);
        if (this.informationElements == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(this.informationElements.length);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.informationElements.length) {
                return;
            }
            parcel.writeInt(this.informationElements[i3].id);
            parcel.writeInt(this.informationElements[i3].bytes.length);
            parcel.writeByteArray(this.informationElements[i3].bytes);
            i2 = i3 + 1;
        }
    }
}
