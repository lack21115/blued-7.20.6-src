package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiConnectionStatistics.class */
public class WifiConnectionStatistics implements Parcelable {
    public static final Parcelable.Creator<WifiConnectionStatistics> CREATOR = new Parcelable.Creator<WifiConnectionStatistics>() { // from class: android.net.wifi.WifiConnectionStatistics.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiConnectionStatistics createFromParcel(Parcel parcel) {
            WifiConnectionStatistics wifiConnectionStatistics = new WifiConnectionStatistics();
            wifiConnectionStatistics.num24GhzConnected = parcel.readInt();
            wifiConnectionStatistics.num5GhzConnected = parcel.readInt();
            wifiConnectionStatistics.numAutoJoinAttempt = parcel.readInt();
            wifiConnectionStatistics.numAutoRoamAttempt = parcel.readInt();
            wifiConnectionStatistics.numWifiManagerJoinAttempt = parcel.readInt();
            int readInt = parcel.readInt();
            while (true) {
                int i = readInt;
                if (i <= 0) {
                    return wifiConnectionStatistics;
                }
                wifiConnectionStatistics.untrustedNetworkHistory.put(parcel.readString(), new WifiNetworkConnectionStatistics(parcel.readInt(), parcel.readInt()));
                readInt = i - 1;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiConnectionStatistics[] newArray(int i) {
            return new WifiConnectionStatistics[i];
        }
    };
    private static final String TAG = "WifiConnnectionStatistics";
    public int num24GhzConnected;
    public int num5GhzConnected;
    public int numAutoJoinAttempt;
    public int numAutoRoamAttempt;
    public int numWifiManagerJoinAttempt;
    public HashMap<String, WifiNetworkConnectionStatistics> untrustedNetworkHistory = new HashMap<>();

    public WifiConnectionStatistics() {
    }

    public WifiConnectionStatistics(WifiConnectionStatistics wifiConnectionStatistics) {
        if (wifiConnectionStatistics != null) {
            this.untrustedNetworkHistory.putAll(wifiConnectionStatistics.untrustedNetworkHistory);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void incrementOrAddUntrusted(String str, int i, int i2) {
        WifiNetworkConnectionStatistics wifiNetworkConnectionStatistics;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.untrustedNetworkHistory.containsKey(str)) {
            WifiNetworkConnectionStatistics wifiNetworkConnectionStatistics2 = this.untrustedNetworkHistory.get(str);
            wifiNetworkConnectionStatistics = wifiNetworkConnectionStatistics2;
            if (wifiNetworkConnectionStatistics2 != null) {
                wifiNetworkConnectionStatistics2.numConnection += i;
                wifiNetworkConnectionStatistics2.numUsage += i2;
                wifiNetworkConnectionStatistics = wifiNetworkConnectionStatistics2;
            }
        } else {
            wifiNetworkConnectionStatistics = new WifiNetworkConnectionStatistics(i, i2);
        }
        if (wifiNetworkConnectionStatistics != null) {
            this.untrustedNetworkHistory.put(str, wifiNetworkConnectionStatistics);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connected on: 2.4Ghz=").append(this.num24GhzConnected);
        sb.append(" 5Ghz=").append(this.num5GhzConnected).append("\n");
        sb.append(" join=").append(this.numWifiManagerJoinAttempt);
        sb.append("\\").append(this.numAutoJoinAttempt).append("\n");
        sb.append(" roam=").append(this.numAutoRoamAttempt).append("\n");
        for (String str : this.untrustedNetworkHistory.keySet()) {
            WifiNetworkConnectionStatistics wifiNetworkConnectionStatistics = this.untrustedNetworkHistory.get(str);
            if (wifiNetworkConnectionStatistics != null) {
                sb.append(str).append(" ").append(wifiNetworkConnectionStatistics.toString()).append("\n");
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.num24GhzConnected);
        parcel.writeInt(this.num5GhzConnected);
        parcel.writeInt(this.numAutoJoinAttempt);
        parcel.writeInt(this.numAutoRoamAttempt);
        parcel.writeInt(this.numWifiManagerJoinAttempt);
        parcel.writeInt(this.untrustedNetworkHistory.size());
        for (String str : this.untrustedNetworkHistory.keySet()) {
            WifiNetworkConnectionStatistics wifiNetworkConnectionStatistics = this.untrustedNetworkHistory.get(str);
            parcel.writeString(str);
            parcel.writeInt(wifiNetworkConnectionStatistics.numConnection);
            parcel.writeInt(wifiNetworkConnectionStatistics.numUsage);
        }
    }
}
