package android.net;

import android.os.Parcel;

/* loaded from: source-9557208-dex2jar.jar:android/net/WifiLinkQualityInfo.class */
public class WifiLinkQualityInfo extends LinkQualityInfo {
    private String mBssid;
    private int mType = Integer.MAX_VALUE;
    private int mRssi = Integer.MAX_VALUE;
    private long mTxGood = Long.MAX_VALUE;
    private long mTxBad = Long.MAX_VALUE;

    public static WifiLinkQualityInfo createFromParcelBody(Parcel parcel) {
        WifiLinkQualityInfo wifiLinkQualityInfo = new WifiLinkQualityInfo();
        wifiLinkQualityInfo.initializeFromParcel(parcel);
        wifiLinkQualityInfo.mType = parcel.readInt();
        wifiLinkQualityInfo.mRssi = parcel.readInt();
        wifiLinkQualityInfo.mTxGood = parcel.readLong();
        wifiLinkQualityInfo.mTxBad = parcel.readLong();
        wifiLinkQualityInfo.mBssid = parcel.readString();
        return wifiLinkQualityInfo;
    }

    public String getBssid() {
        return this.mBssid;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public long getTxBad() {
        return this.mTxBad;
    }

    public long getTxGood() {
        return this.mTxGood;
    }

    public int getType() {
        return this.mType;
    }

    public void setBssid(String str) {
        this.mBssid = str;
    }

    public void setRssi(int i) {
        this.mRssi = i;
    }

    public void setTxBad(long j) {
        this.mTxBad = j;
    }

    public void setTxGood(long j) {
        this.mTxGood = j;
    }

    public void setType(int i) {
        this.mType = i;
    }

    @Override // android.net.LinkQualityInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i, 2);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mRssi);
        parcel.writeLong(this.mTxGood);
        parcel.writeLong(this.mTxBad);
        parcel.writeString(this.mBssid);
    }
}
