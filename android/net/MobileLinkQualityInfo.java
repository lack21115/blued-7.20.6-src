package android.net;

import android.os.Parcel;

/* loaded from: source-9557208-dex2jar.jar:android/net/MobileLinkQualityInfo.class */
public class MobileLinkQualityInfo extends LinkQualityInfo {
    private int mMobileNetworkType = Integer.MAX_VALUE;
    private int mRssi = Integer.MAX_VALUE;
    private int mGsmErrorRate = Integer.MAX_VALUE;
    private int mCdmaDbm = Integer.MAX_VALUE;
    private int mCdmaEcio = Integer.MAX_VALUE;
    private int mEvdoDbm = Integer.MAX_VALUE;
    private int mEvdoEcio = Integer.MAX_VALUE;
    private int mEvdoSnr = Integer.MAX_VALUE;
    private int mLteSignalStrength = Integer.MAX_VALUE;
    private int mLteRsrp = Integer.MAX_VALUE;
    private int mLteRsrq = Integer.MAX_VALUE;
    private int mLteRssnr = Integer.MAX_VALUE;
    private int mLteCqi = Integer.MAX_VALUE;

    public static MobileLinkQualityInfo createFromParcelBody(Parcel parcel) {
        MobileLinkQualityInfo mobileLinkQualityInfo = new MobileLinkQualityInfo();
        mobileLinkQualityInfo.initializeFromParcel(parcel);
        mobileLinkQualityInfo.mMobileNetworkType = parcel.readInt();
        mobileLinkQualityInfo.mRssi = parcel.readInt();
        mobileLinkQualityInfo.mGsmErrorRate = parcel.readInt();
        mobileLinkQualityInfo.mCdmaDbm = parcel.readInt();
        mobileLinkQualityInfo.mCdmaEcio = parcel.readInt();
        mobileLinkQualityInfo.mEvdoDbm = parcel.readInt();
        mobileLinkQualityInfo.mEvdoEcio = parcel.readInt();
        mobileLinkQualityInfo.mEvdoSnr = parcel.readInt();
        mobileLinkQualityInfo.mLteSignalStrength = parcel.readInt();
        mobileLinkQualityInfo.mLteRsrp = parcel.readInt();
        mobileLinkQualityInfo.mLteRsrq = parcel.readInt();
        mobileLinkQualityInfo.mLteRssnr = parcel.readInt();
        mobileLinkQualityInfo.mLteCqi = parcel.readInt();
        return mobileLinkQualityInfo;
    }

    public int getCdmaDbm() {
        return this.mCdmaDbm;
    }

    public int getCdmaEcio() {
        return this.mCdmaEcio;
    }

    public int getEvdoDbm() {
        return this.mEvdoDbm;
    }

    public int getEvdoEcio() {
        return this.mEvdoEcio;
    }

    public int getEvdoSnr() {
        return this.mEvdoSnr;
    }

    public int getGsmErrorRate() {
        return this.mGsmErrorRate;
    }

    public int getLteCqi() {
        return this.mLteCqi;
    }

    public int getLteRsrp() {
        return this.mLteRsrp;
    }

    public int getLteRsrq() {
        return this.mLteRsrq;
    }

    public int getLteRssnr() {
        return this.mLteRssnr;
    }

    public int getLteSignalStrength() {
        return this.mLteSignalStrength;
    }

    public int getMobileNetworkType() {
        return this.mMobileNetworkType;
    }

    public int getRssi() {
        return this.mRssi;
    }

    public void setCdmaDbm(int i) {
        this.mCdmaDbm = i;
    }

    public void setCdmaEcio(int i) {
        this.mCdmaEcio = i;
    }

    public void setEvdoDbm(int i) {
        this.mEvdoDbm = i;
    }

    public void setEvdoEcio(int i) {
        this.mEvdoEcio = i;
    }

    public void setEvdoSnr(int i) {
        this.mEvdoSnr = i;
    }

    public void setGsmErrorRate(int i) {
        this.mGsmErrorRate = i;
    }

    public void setLteCqi(int i) {
        this.mLteCqi = i;
    }

    public void setLteRsrp(int i) {
        this.mLteRsrp = i;
    }

    public void setLteRsrq(int i) {
        this.mLteRsrq = i;
    }

    public void setLteRssnr(int i) {
        this.mLteRssnr = i;
    }

    public void setLteSignalStrength(int i) {
        this.mLteSignalStrength = i;
    }

    public void setMobileNetworkType(int i) {
        this.mMobileNetworkType = i;
    }

    public void setRssi(int i) {
        this.mRssi = i;
    }

    @Override // android.net.LinkQualityInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i, 3);
        parcel.writeInt(this.mMobileNetworkType);
        parcel.writeInt(this.mRssi);
        parcel.writeInt(this.mGsmErrorRate);
        parcel.writeInt(this.mCdmaDbm);
        parcel.writeInt(this.mCdmaEcio);
        parcel.writeInt(this.mEvdoDbm);
        parcel.writeInt(this.mEvdoEcio);
        parcel.writeInt(this.mEvdoSnr);
        parcel.writeInt(this.mLteSignalStrength);
        parcel.writeInt(this.mLteRsrp);
        parcel.writeInt(this.mLteRsrq);
        parcel.writeInt(this.mLteRssnr);
        parcel.writeInt(this.mLteCqi);
    }
}
