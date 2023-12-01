package android.net;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/LinkQualityInfo.class */
public class LinkQualityInfo implements Parcelable {
    public static final Parcelable.Creator<LinkQualityInfo> CREATOR = new Parcelable.Creator<LinkQualityInfo>() { // from class: android.net.LinkQualityInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkQualityInfo createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt == 1) {
                LinkQualityInfo linkQualityInfo = new LinkQualityInfo();
                linkQualityInfo.initializeFromParcel(parcel);
                return linkQualityInfo;
            } else if (readInt == 2) {
                return WifiLinkQualityInfo.createFromParcelBody(parcel);
            } else {
                if (readInt == 3) {
                    return MobileLinkQualityInfo.createFromParcelBody(parcel);
                }
                return null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LinkQualityInfo[] newArray(int i) {
            return new LinkQualityInfo[i];
        }
    };
    public static final int NORMALIZED_MAX_SIGNAL_STRENGTH = 99;
    public static final int NORMALIZED_MIN_SIGNAL_STRENGTH = 0;
    public static final int NORMALIZED_SIGNAL_STRENGTH_RANGE = 100;
    protected static final int OBJECT_TYPE_LINK_QUALITY_INFO = 1;
    protected static final int OBJECT_TYPE_MOBILE_LINK_QUALITY_INFO = 3;
    protected static final int OBJECT_TYPE_WIFI_LINK_QUALITY_INFO = 2;
    public static final int UNKNOWN_INT = Integer.MAX_VALUE;
    public static final long UNKNOWN_LONG = Long.MAX_VALUE;
    private int mNetworkType = -1;
    private int mNormalizedSignalStrength = Integer.MAX_VALUE;
    private long mPacketCount = Long.MAX_VALUE;
    private long mPacketErrorCount = Long.MAX_VALUE;
    private int mTheoreticalTxBandwidth = Integer.MAX_VALUE;
    private int mTheoreticalRxBandwidth = Integer.MAX_VALUE;
    private int mTheoreticalLatency = Integer.MAX_VALUE;
    private long mLastDataSampleTime = Long.MAX_VALUE;
    private int mDataSampleDuration = Integer.MAX_VALUE;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDataSampleDuration() {
        return this.mDataSampleDuration;
    }

    public long getLastDataSampleTime() {
        return this.mLastDataSampleTime;
    }

    public int getNetworkType() {
        return this.mNetworkType;
    }

    public int getNormalizedSignalStrength() {
        return this.mNormalizedSignalStrength;
    }

    public long getPacketCount() {
        return this.mPacketCount;
    }

    public long getPacketErrorCount() {
        return this.mPacketErrorCount;
    }

    public int getTheoreticalLatency() {
        return this.mTheoreticalLatency;
    }

    public int getTheoreticalRxBandwidth() {
        return this.mTheoreticalRxBandwidth;
    }

    public int getTheoreticalTxBandwidth() {
        return this.mTheoreticalTxBandwidth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initializeFromParcel(Parcel parcel) {
        this.mNetworkType = parcel.readInt();
        this.mNormalizedSignalStrength = parcel.readInt();
        this.mPacketCount = parcel.readLong();
        this.mPacketErrorCount = parcel.readLong();
        this.mTheoreticalTxBandwidth = parcel.readInt();
        this.mTheoreticalRxBandwidth = parcel.readInt();
        this.mTheoreticalLatency = parcel.readInt();
        this.mLastDataSampleTime = parcel.readLong();
        this.mDataSampleDuration = parcel.readInt();
    }

    public void setDataSampleDuration(int i) {
        this.mDataSampleDuration = i;
    }

    public void setLastDataSampleTime(long j) {
        this.mLastDataSampleTime = j;
    }

    public void setNetworkType(int i) {
        this.mNetworkType = i;
    }

    public void setNormalizedSignalStrength(int i) {
        this.mNormalizedSignalStrength = i;
    }

    public void setPacketCount(long j) {
        this.mPacketCount = j;
    }

    public void setPacketErrorCount(long j) {
        this.mPacketErrorCount = j;
    }

    public void setTheoreticalLatency(int i) {
        this.mTheoreticalLatency = i;
    }

    public void setTheoreticalRxBandwidth(int i) {
        this.mTheoreticalRxBandwidth = i;
    }

    public void setTheoreticalTxBandwidth(int i) {
        this.mTheoreticalTxBandwidth = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(parcel, i, 1);
    }

    public void writeToParcel(Parcel parcel, int i, int i2) {
        parcel.writeInt(i2);
        parcel.writeInt(this.mNetworkType);
        parcel.writeInt(this.mNormalizedSignalStrength);
        parcel.writeLong(this.mPacketCount);
        parcel.writeLong(this.mPacketErrorCount);
        parcel.writeInt(this.mTheoreticalTxBandwidth);
        parcel.writeInt(this.mTheoreticalRxBandwidth);
        parcel.writeInt(this.mTheoreticalLatency);
        parcel.writeLong(this.mLastDataSampleTime);
        parcel.writeInt(this.mDataSampleDuration);
    }
}
