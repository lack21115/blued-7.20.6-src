package android.net.wifi;

import android.net.NetworkInfo;
import android.net.NetworkUtils;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.EnumMap;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/net/wifi/WifiInfo.class */
public class WifiInfo implements Parcelable {
    public static final Parcelable.Creator<WifiInfo> CREATOR;
    public static final String FREQUENCY_UNITS = "MHz";
    public static final int INVALID_RSSI = -127;
    public static final String LINK_SPEED_UNITS = "Mbps";
    public static final int MAX_RSSI = 200;
    public static final int MIN_RSSI = -126;
    private static final String TAG = "WifiInfo";
    private static final EnumMap<SupplicantState, NetworkInfo.DetailedState> stateMap = new EnumMap<>(SupplicantState.class);
    public int badRssiCount;
    public int linkStuckCount;
    public int lowRssiCount;
    private String mBSSID;
    private int mFrequency;
    private InetAddress mIpAddress;
    private int mLinkSpeed;
    private String mMacAddress;
    private boolean mMeteredHint;
    private int mNetworkId;
    private int mRssi;
    private SupplicantState mSupplicantState;
    private WifiSsid mWifiSsid;
    public long rxSuccess;
    public double rxSuccessRate;
    public int score;
    public long txBad;
    public double txBadRate;
    public long txRetries;
    public double txRetriesRate;
    public long txSuccess;
    public double txSuccessRate;

    static {
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.DISCONNECTED, (SupplicantState) NetworkInfo.DetailedState.DISCONNECTED);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.INTERFACE_DISABLED, (SupplicantState) NetworkInfo.DetailedState.DISCONNECTED);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.INACTIVE, (SupplicantState) NetworkInfo.DetailedState.IDLE);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.SCANNING, (SupplicantState) NetworkInfo.DetailedState.SCANNING);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.AUTHENTICATING, (SupplicantState) NetworkInfo.DetailedState.CONNECTING);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.ASSOCIATING, (SupplicantState) NetworkInfo.DetailedState.CONNECTING);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.ASSOCIATED, (SupplicantState) NetworkInfo.DetailedState.CONNECTING);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.FOUR_WAY_HANDSHAKE, (SupplicantState) NetworkInfo.DetailedState.AUTHENTICATING);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.GROUP_HANDSHAKE, (SupplicantState) NetworkInfo.DetailedState.AUTHENTICATING);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.COMPLETED, (SupplicantState) NetworkInfo.DetailedState.OBTAINING_IPADDR);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.DORMANT, (SupplicantState) NetworkInfo.DetailedState.DISCONNECTED);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.UNINITIALIZED, (SupplicantState) NetworkInfo.DetailedState.IDLE);
        stateMap.put((EnumMap<SupplicantState, NetworkInfo.DetailedState>) SupplicantState.INVALID, (SupplicantState) NetworkInfo.DetailedState.FAILED);
        CREATOR = new Parcelable.Creator<WifiInfo>() { // from class: android.net.wifi.WifiInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WifiInfo createFromParcel(Parcel parcel) {
                WifiInfo wifiInfo = new WifiInfo();
                wifiInfo.setNetworkId(parcel.readInt());
                wifiInfo.setRssi(parcel.readInt());
                wifiInfo.setLinkSpeed(parcel.readInt());
                wifiInfo.setFrequency(parcel.readInt());
                if (parcel.readByte() == 1) {
                    try {
                        wifiInfo.setInetAddress(InetAddress.getByAddress(parcel.createByteArray()));
                    } catch (UnknownHostException e) {
                    }
                }
                if (parcel.readInt() == 1) {
                    wifiInfo.mWifiSsid = WifiSsid.CREATOR.createFromParcel(parcel);
                }
                wifiInfo.mBSSID = parcel.readString();
                wifiInfo.mMacAddress = parcel.readString();
                wifiInfo.mMeteredHint = parcel.readInt() != 0;
                wifiInfo.score = parcel.readInt();
                wifiInfo.txSuccessRate = parcel.readDouble();
                wifiInfo.txRetriesRate = parcel.readDouble();
                wifiInfo.txBadRate = parcel.readDouble();
                wifiInfo.rxSuccessRate = parcel.readDouble();
                wifiInfo.badRssiCount = parcel.readInt();
                wifiInfo.lowRssiCount = parcel.readInt();
                wifiInfo.mSupplicantState = SupplicantState.CREATOR.createFromParcel(parcel);
                return wifiInfo;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public WifiInfo[] newArray(int i) {
                return new WifiInfo[i];
            }
        };
    }

    public WifiInfo() {
        this.mWifiSsid = null;
        this.mBSSID = null;
        this.mNetworkId = -1;
        this.mSupplicantState = SupplicantState.UNINITIALIZED;
        this.mRssi = INVALID_RSSI;
        this.mLinkSpeed = -1;
        this.mFrequency = -1;
    }

    public WifiInfo(WifiInfo wifiInfo) {
        if (wifiInfo != null) {
            this.mSupplicantState = wifiInfo.mSupplicantState;
            this.mBSSID = wifiInfo.mBSSID;
            this.mWifiSsid = wifiInfo.mWifiSsid;
            this.mNetworkId = wifiInfo.mNetworkId;
            this.mRssi = wifiInfo.mRssi;
            this.mLinkSpeed = wifiInfo.mLinkSpeed;
            this.mFrequency = wifiInfo.mFrequency;
            this.mIpAddress = wifiInfo.mIpAddress;
            this.mMacAddress = wifiInfo.mMacAddress;
            this.mMeteredHint = wifiInfo.mMeteredHint;
            this.txBad = wifiInfo.txBad;
            this.txRetries = wifiInfo.txRetries;
            this.txSuccess = wifiInfo.txSuccess;
            this.rxSuccess = wifiInfo.rxSuccess;
            this.txBadRate = wifiInfo.txBadRate;
            this.txRetriesRate = wifiInfo.txRetriesRate;
            this.txSuccessRate = wifiInfo.txSuccessRate;
            this.rxSuccessRate = wifiInfo.rxSuccessRate;
            this.score = wifiInfo.score;
            this.badRssiCount = wifiInfo.badRssiCount;
            this.lowRssiCount = wifiInfo.lowRssiCount;
            this.linkStuckCount = wifiInfo.linkStuckCount;
        }
    }

    public static NetworkInfo.DetailedState getDetailedStateOf(SupplicantState supplicantState) {
        return stateMap.get(supplicantState);
    }

    public static String removeDoubleQuotes(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = str.length();
            str2 = str;
            if (length > 1) {
                str2 = str;
                if (str.charAt(0) == '\"') {
                    str2 = str;
                    if (str.charAt(length - 1) == '\"') {
                        return str.substring(1, length - 1);
                    }
                }
            }
        }
        return str2;
    }

    static SupplicantState valueOf(String str) {
        if ("4WAY_HANDSHAKE".equalsIgnoreCase(str)) {
            return SupplicantState.FOUR_WAY_HANDSHAKE;
        }
        try {
            return SupplicantState.valueOf(str.toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException e) {
            return SupplicantState.INVALID;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBSSID() {
        return this.mBSSID;
    }

    public int getFrequency() {
        return this.mFrequency;
    }

    public boolean getHiddenSSID() {
        if (this.mWifiSsid == null) {
            return false;
        }
        return this.mWifiSsid.isHidden();
    }

    public int getIpAddress() {
        int i = 0;
        if (this.mIpAddress instanceof Inet4Address) {
            i = NetworkUtils.inetAddressToInt((Inet4Address) this.mIpAddress);
        }
        return i;
    }

    public int getLinkSpeed() {
        return this.mLinkSpeed;
    }

    public String getMacAddress() {
        return this.mMacAddress;
    }

    public boolean getMeteredHint() {
        return this.mMeteredHint;
    }

    public int getNetworkId() {
        return this.mNetworkId;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public String getSSID() {
        if (this.mWifiSsid != null) {
            String wifiSsid = this.mWifiSsid.toString();
            return !TextUtils.isEmpty(wifiSsid) ? "\"" + wifiSsid + "\"" : this.mWifiSsid.getHexString();
        }
        return WifiSsid.NONE;
    }

    public SupplicantState getSupplicantState() {
        return this.mSupplicantState;
    }

    public WifiSsid getWifiSsid() {
        return this.mWifiSsid;
    }

    public boolean is24GHz() {
        return ScanResult.is24GHz(this.mFrequency);
    }

    public boolean is5GHz() {
        return ScanResult.is5GHz(this.mFrequency);
    }

    public void reset() {
        setInetAddress(null);
        setBSSID(null);
        setSSID(null);
        setNetworkId(-1);
        setRssi(INVALID_RSSI);
        setLinkSpeed(-1);
        setFrequency(-1);
        setMeteredHint(false);
        this.txBad = 0L;
        this.txSuccess = 0L;
        this.rxSuccess = 0L;
        this.txRetries = 0L;
        this.txBadRate = 0.0d;
        this.txSuccessRate = 0.0d;
        this.rxSuccessRate = 0.0d;
        this.txRetriesRate = 0.0d;
        this.lowRssiCount = 0;
        this.badRssiCount = 0;
        this.linkStuckCount = 0;
        this.score = 0;
    }

    public void setBSSID(String str) {
        this.mBSSID = str;
    }

    public void setFrequency(int i) {
        this.mFrequency = i;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.mIpAddress = inetAddress;
    }

    public void setLinkSpeed(int i) {
        this.mLinkSpeed = i;
    }

    public void setMacAddress(String str) {
        this.mMacAddress = str;
    }

    public void setMeteredHint(boolean z) {
        this.mMeteredHint = z;
    }

    public void setNetworkId(int i) {
        this.mNetworkId = i;
    }

    public void setRssi(int i) {
        int i2 = i;
        if (i < -127) {
            i2 = -127;
        }
        int i3 = i2;
        if (i2 > 200) {
            i3 = 200;
        }
        this.mRssi = i3;
    }

    public void setSSID(WifiSsid wifiSsid) {
        this.mWifiSsid = wifiSsid;
    }

    public void setSupplicantState(SupplicantState supplicantState) {
        this.mSupplicantState = supplicantState;
    }

    void setSupplicantState(String str) {
        this.mSupplicantState = valueOf(str);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SSID: ").append(this.mWifiSsid == null ? WifiSsid.NONE : this.mWifiSsid).append(", BSSID: ").append(this.mBSSID == null ? "<none>" : this.mBSSID).append(", MAC: ").append(this.mMacAddress == null ? "<none>" : this.mMacAddress).append(", Supplicant state: ").append(this.mSupplicantState == null ? "<none>" : this.mSupplicantState).append(", RSSI: ").append(this.mRssi).append(", Link speed: ").append(this.mLinkSpeed).append(LINK_SPEED_UNITS).append(", Frequency: ").append(this.mFrequency).append(FREQUENCY_UNITS).append(", Net ID: ").append(this.mNetworkId).append(", Metered hint: ").append(this.mMeteredHint).append(", score: ").append(Integer.toString(this.score));
        return stringBuffer.toString();
    }

    public void updatePacketRates(long j, long j2) {
        this.txBad = 0L;
        this.txRetries = 0L;
        this.txBadRate = 0.0d;
        this.txRetriesRate = 0.0d;
        this.txSuccessRate = (this.txSuccessRate * 0.5d) + ((j - this.txSuccess) * 0.5d);
        this.rxSuccessRate = (this.rxSuccessRate * 0.5d) + ((j2 - this.rxSuccess) * 0.5d);
        this.txSuccess = j;
        this.rxSuccess = j2;
    }

    public void updatePacketRates(WifiLinkLayerStats wifiLinkLayerStats) {
        if (wifiLinkLayerStats == null) {
            this.txBad = 0L;
            this.txSuccess = 0L;
            this.rxSuccess = 0L;
            this.txRetries = 0L;
            this.txBadRate = 0.0d;
            this.txSuccessRate = 0.0d;
            this.rxSuccessRate = 0.0d;
            this.txRetriesRate = 0.0d;
            return;
        }
        long j = wifiLinkLayerStats.txmpdu_be + wifiLinkLayerStats.txmpdu_bk + wifiLinkLayerStats.txmpdu_vi + wifiLinkLayerStats.txmpdu_vo;
        long j2 = wifiLinkLayerStats.retries_be + wifiLinkLayerStats.retries_bk + wifiLinkLayerStats.retries_vi + wifiLinkLayerStats.retries_vo;
        long j3 = wifiLinkLayerStats.rxmpdu_be + wifiLinkLayerStats.rxmpdu_bk + wifiLinkLayerStats.rxmpdu_vi + wifiLinkLayerStats.rxmpdu_vo;
        long j4 = wifiLinkLayerStats.lostmpdu_be + wifiLinkLayerStats.lostmpdu_bk + wifiLinkLayerStats.lostmpdu_vi + wifiLinkLayerStats.lostmpdu_vo;
        this.txBadRate = (this.txBadRate * 0.5d) + ((j4 - this.txBad) * 0.5d);
        this.txSuccessRate = (this.txSuccessRate * 0.5d) + ((j - this.txSuccess) * 0.5d);
        this.rxSuccessRate = (this.rxSuccessRate * 0.5d) + ((j3 - this.rxSuccess) * 0.5d);
        this.txRetriesRate = (this.txRetriesRate * 0.5d) + ((j2 - this.txRetries) * 0.5d);
        this.txBad = j4;
        this.txSuccess = j;
        this.rxSuccess = j3;
        this.txRetries = j2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.mNetworkId);
        parcel.writeInt(this.mRssi);
        parcel.writeInt(this.mLinkSpeed);
        parcel.writeInt(this.mFrequency);
        if (this.mIpAddress != null) {
            parcel.writeByte((byte) 1);
            parcel.writeByteArray(this.mIpAddress.getAddress());
        } else {
            parcel.writeByte((byte) 0);
        }
        if (this.mWifiSsid != null) {
            parcel.writeInt(1);
            this.mWifiSsid.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.mBSSID);
        parcel.writeString(this.mMacAddress);
        if (!this.mMeteredHint) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.score);
        parcel.writeDouble(this.txSuccessRate);
        parcel.writeDouble(this.txRetriesRate);
        parcel.writeDouble(this.txBadRate);
        parcel.writeDouble(this.rxSuccessRate);
        parcel.writeInt(this.badRssiCount);
        parcel.writeInt(this.lowRssiCount);
        this.mSupplicantState.writeToParcel(parcel, i);
    }
}
