package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiNetworkConnectionStatistics.class */
public class WifiNetworkConnectionStatistics implements Parcelable {
    public static final Parcelable.Creator<WifiNetworkConnectionStatistics> CREATOR = new Parcelable.Creator<WifiNetworkConnectionStatistics>() { // from class: android.net.wifi.WifiNetworkConnectionStatistics.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiNetworkConnectionStatistics createFromParcel(Parcel parcel) {
            return new WifiNetworkConnectionStatistics(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiNetworkConnectionStatistics[] newArray(int i) {
            return new WifiNetworkConnectionStatistics[i];
        }
    };
    private static final String TAG = "WifiNetworkConnnectionStatistics";
    public int numConnection;
    public int numUsage;

    public WifiNetworkConnectionStatistics() {
    }

    public WifiNetworkConnectionStatistics(int i, int i2) {
        this.numConnection = i;
        this.numUsage = i2;
    }

    public WifiNetworkConnectionStatistics(WifiNetworkConnectionStatistics wifiNetworkConnectionStatistics) {
        this.numConnection = wifiNetworkConnectionStatistics.numConnection;
        this.numUsage = wifiNetworkConnectionStatistics.numUsage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("c=").append(this.numConnection);
        sb.append(" u=").append(this.numUsage);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.numConnection);
        parcel.writeInt(this.numUsage);
    }
}
