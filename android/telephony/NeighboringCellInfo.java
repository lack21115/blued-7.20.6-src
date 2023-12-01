package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/NeighboringCellInfo.class */
public class NeighboringCellInfo implements Parcelable {
    public static final Parcelable.Creator<NeighboringCellInfo> CREATOR = new Parcelable.Creator<NeighboringCellInfo>() { // from class: android.telephony.NeighboringCellInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NeighboringCellInfo createFromParcel(Parcel parcel) {
            return new NeighboringCellInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NeighboringCellInfo[] newArray(int i) {
            return new NeighboringCellInfo[i];
        }
    };
    public static final int UNKNOWN_CID = -1;
    public static final int UNKNOWN_RSSI = 99;
    private int mCid;
    private int mLac;
    private int mNetworkType;
    private int mPsc;
    private int mRssi;

    @Deprecated
    public NeighboringCellInfo() {
        this.mRssi = 99;
        this.mLac = -1;
        this.mCid = -1;
        this.mPsc = -1;
        this.mNetworkType = 0;
    }

    @Deprecated
    public NeighboringCellInfo(int i, int i2) {
        this.mRssi = i;
        this.mCid = i2;
    }

    public NeighboringCellInfo(int i, String str, int i2) {
        this.mRssi = i;
        this.mNetworkType = 0;
        this.mPsc = -1;
        this.mLac = -1;
        this.mCid = -1;
        int length = str.length();
        if (length > 8) {
            return;
        }
        String str2 = str;
        if (length < 8) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                str2 = str;
                if (i4 >= 8 - length) {
                    break;
                }
                str = "0" + str;
                i3 = i4 + 1;
            }
        }
        try {
            switch (i2) {
                case 1:
                case 2:
                    this.mNetworkType = i2;
                    if (str2.equalsIgnoreCase("FFFFFFFF")) {
                        return;
                    }
                    this.mCid = Integer.valueOf(str2.substring(4), 16).intValue();
                    this.mLac = Integer.valueOf(str2.substring(0, 4), 16).intValue();
                    return;
                case 3:
                case 8:
                case 9:
                case 10:
                    this.mNetworkType = i2;
                    this.mPsc = Integer.valueOf(str2, 16).intValue();
                    return;
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    return;
            }
        } catch (NumberFormatException e) {
            this.mPsc = -1;
            this.mLac = -1;
            this.mCid = -1;
            this.mNetworkType = 0;
        }
    }

    public NeighboringCellInfo(Parcel parcel) {
        this.mRssi = parcel.readInt();
        this.mLac = parcel.readInt();
        this.mCid = parcel.readInt();
        this.mPsc = parcel.readInt();
        this.mNetworkType = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCid() {
        return this.mCid;
    }

    public int getLac() {
        return this.mLac;
    }

    public int getNetworkType() {
        return this.mNetworkType;
    }

    public int getPsc() {
        return this.mPsc;
    }

    public int getRssi() {
        return this.mRssi;
    }

    @Deprecated
    public void setCid(int i) {
        this.mCid = i;
    }

    @Deprecated
    public void setRssi(int i) {
        this.mRssi = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.mPsc != -1) {
            sb.append(Integer.toHexString(this.mPsc)).append("@").append(this.mRssi == 99 ? Constants.ACCEPT_TIME_SEPARATOR_SERVER : Integer.valueOf(this.mRssi));
        } else if (this.mLac != -1 && this.mCid != -1) {
            sb.append(Integer.toHexString(this.mLac)).append(Integer.toHexString(this.mCid)).append("@").append(this.mRssi == 99 ? Constants.ACCEPT_TIME_SEPARATOR_SERVER : Integer.valueOf(this.mRssi));
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRssi);
        parcel.writeInt(this.mLac);
        parcel.writeInt(this.mCid);
        parcel.writeInt(this.mPsc);
        parcel.writeInt(this.mNetworkType);
    }
}
