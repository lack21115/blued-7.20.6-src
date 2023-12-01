package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/CellIdentityWcdma.class */
public final class CellIdentityWcdma implements Parcelable {
    public static final Parcelable.Creator<CellIdentityWcdma> CREATOR = new Parcelable.Creator<CellIdentityWcdma>() { // from class: android.telephony.CellIdentityWcdma.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellIdentityWcdma createFromParcel(Parcel parcel) {
            return new CellIdentityWcdma(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellIdentityWcdma[] newArray(int i) {
            return new CellIdentityWcdma[i];
        }
    };
    private static final boolean DBG = false;
    private static final String LOG_TAG = "CellIdentityWcdma";
    private final int mCid;
    private final int mLac;
    private final int mMcc;
    private final int mMnc;
    private final int mPsc;

    public CellIdentityWcdma() {
        this.mMcc = Integer.MAX_VALUE;
        this.mMnc = Integer.MAX_VALUE;
        this.mLac = Integer.MAX_VALUE;
        this.mCid = Integer.MAX_VALUE;
        this.mPsc = Integer.MAX_VALUE;
    }

    public CellIdentityWcdma(int i, int i2, int i3, int i4, int i5) {
        this.mMcc = i;
        this.mMnc = i2;
        this.mLac = i3;
        this.mCid = i4;
        this.mPsc = i5;
    }

    private CellIdentityWcdma(Parcel parcel) {
        this.mMcc = parcel.readInt();
        this.mMnc = parcel.readInt();
        this.mLac = parcel.readInt();
        this.mCid = parcel.readInt();
        this.mPsc = parcel.readInt();
    }

    private CellIdentityWcdma(CellIdentityWcdma cellIdentityWcdma) {
        this.mMcc = cellIdentityWcdma.mMcc;
        this.mMnc = cellIdentityWcdma.mMnc;
        this.mLac = cellIdentityWcdma.mLac;
        this.mCid = cellIdentityWcdma.mCid;
        this.mPsc = cellIdentityWcdma.mPsc;
    }

    private static void log(String str) {
        Rlog.w(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CellIdentityWcdma copy() {
        return new CellIdentityWcdma(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (super.equals(obj)) {
            try {
                CellIdentityWcdma cellIdentityWcdma = (CellIdentityWcdma) obj;
                z = false;
                if (this.mMcc == cellIdentityWcdma.mMcc) {
                    z = false;
                    if (this.mMnc == cellIdentityWcdma.mMnc) {
                        z = false;
                        if (this.mLac == cellIdentityWcdma.mLac) {
                            z = false;
                            if (this.mCid == cellIdentityWcdma.mCid) {
                                z = false;
                                if (this.mPsc == cellIdentityWcdma.mPsc) {
                                    z = true;
                                }
                            }
                        }
                    }
                }
            } catch (ClassCastException e) {
                return false;
            }
        }
        return z;
    }

    public int getCid() {
        return this.mCid;
    }

    public int getLac() {
        return this.mLac;
    }

    public int getMcc() {
        return this.mMcc;
    }

    public int getMnc() {
        return this.mMnc;
    }

    public int getPsc() {
        return this.mPsc;
    }

    public int hashCode() {
        return (this.mMcc * 31) + (this.mMnc * 31) + (this.mLac * 31) + (this.mCid * 31) + (this.mPsc * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CellIdentityWcdma:{");
        sb.append(" mMcc=").append(this.mMcc);
        sb.append(" mMnc=").append(this.mMnc);
        sb.append(" mLac=").append(this.mLac);
        sb.append(" mCid=").append(this.mCid);
        sb.append(" mPsc=").append(this.mPsc);
        sb.append(i.d);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMcc);
        parcel.writeInt(this.mMnc);
        parcel.writeInt(this.mLac);
        parcel.writeInt(this.mCid);
        parcel.writeInt(this.mPsc);
    }
}
