package android.net.wifi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiLinkLayerStats.class */
public class WifiLinkLayerStats implements Parcelable {
    public static final Parcelable.Creator<WifiLinkLayerStats> CREATOR = new Parcelable.Creator<WifiLinkLayerStats>() { // from class: android.net.wifi.WifiLinkLayerStats.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiLinkLayerStats createFromParcel(Parcel parcel) {
            WifiLinkLayerStats wifiLinkLayerStats = new WifiLinkLayerStats();
            wifiLinkLayerStats.SSID = parcel.readString();
            wifiLinkLayerStats.BSSID = parcel.readString();
            wifiLinkLayerStats.on_time = parcel.readInt();
            wifiLinkLayerStats.tx_time = parcel.readInt();
            wifiLinkLayerStats.rx_time = parcel.readInt();
            wifiLinkLayerStats.on_time_scan = parcel.readInt();
            return wifiLinkLayerStats;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WifiLinkLayerStats[] newArray(int i) {
            return new WifiLinkLayerStats[i];
        }
    };
    private static final String TAG = "WifiLinkLayerStats";
    public String BSSID;
    public String SSID;
    public int beacon_rx;
    public long lostmpdu_be;
    public long lostmpdu_bk;
    public long lostmpdu_vi;
    public long lostmpdu_vo;
    public int on_time;
    public int on_time_scan;
    public long retries_be;
    public long retries_bk;
    public long retries_vi;
    public long retries_vo;
    public int rssi_mgmt;
    public int rx_time;
    public long rxmpdu_be;
    public long rxmpdu_bk;
    public long rxmpdu_vi;
    public long rxmpdu_vo;
    public int status;
    public int tx_time;
    public long txmpdu_be;
    public long txmpdu_bk;
    public long txmpdu_vi;
    public long txmpdu_vo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getPrintableSsid() {
        if (this.SSID == null) {
            return "";
        }
        int length = this.SSID.length();
        return (length > 2 && this.SSID.charAt(0) == '\"' && this.SSID.charAt(length - 1) == '\"') ? this.SSID.substring(1, length - 1) : (length > 3 && this.SSID.charAt(0) == 'P' && this.SSID.charAt(1) == '\"' && this.SSID.charAt(length - 1) == '\"') ? WifiSsid.createFromAsciiEncoded(this.SSID.substring(2, length - 1)).toString() : this.SSID;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" WifiLinkLayerStats: ").append('\n');
        if (this.SSID != null) {
            sb.append(" SSID: ").append(this.SSID).append('\n');
        }
        if (this.BSSID != null) {
            sb.append(" BSSID: ").append(this.BSSID).append('\n');
        }
        sb.append(" my bss beacon rx: ").append(Integer.toString(this.beacon_rx)).append('\n');
        sb.append(" RSSI mgmt: ").append(Integer.toString(this.rssi_mgmt)).append('\n');
        sb.append(" BE : ").append(" rx=").append(Long.toString(this.rxmpdu_be)).append(" tx=").append(Long.toString(this.txmpdu_be)).append(" lost=").append(Long.toString(this.lostmpdu_be)).append(" retries=").append(Long.toString(this.retries_be)).append('\n');
        sb.append(" BK : ").append(" rx=").append(Long.toString(this.rxmpdu_bk)).append(" tx=").append(Long.toString(this.txmpdu_bk)).append(" lost=").append(Long.toString(this.lostmpdu_bk)).append(" retries=").append(Long.toString(this.retries_bk)).append('\n');
        sb.append(" VI : ").append(" rx=").append(Long.toString(this.rxmpdu_vi)).append(" tx=").append(Long.toString(this.txmpdu_vi)).append(" lost=").append(Long.toString(this.lostmpdu_vi)).append(" retries=").append(Long.toString(this.retries_vi)).append('\n');
        sb.append(" VO : ").append(" rx=").append(Long.toString(this.rxmpdu_vo)).append(" tx=").append(Long.toString(this.txmpdu_vo)).append(" lost=").append(Long.toString(this.lostmpdu_vo)).append(" retries=").append(Long.toString(this.retries_vo)).append('\n');
        sb.append(" on_time : ").append(Integer.toString(this.on_time)).append(" tx_time=").append(Integer.toString(this.tx_time)).append(" rx_time=").append(Integer.toString(this.rx_time)).append(" scan_time=").append(Integer.toString(this.on_time_scan)).append('\n');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.SSID);
        parcel.writeString(this.BSSID);
        parcel.writeInt(this.on_time);
        parcel.writeInt(this.tx_time);
        parcel.writeInt(this.rx_time);
        parcel.writeInt(this.on_time_scan);
    }
}
