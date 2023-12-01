package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/CellIdentityGsm.class */
public final class CellIdentityGsm implements Parcelable {
    public static final Parcelable.Creator<CellIdentityGsm> CREATOR = new Parcelable.Creator<CellIdentityGsm>() { // from class: android.telephony.CellIdentityGsm.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellIdentityGsm createFromParcel(Parcel parcel) {
            return new CellIdentityGsm(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellIdentityGsm[] newArray(int i) {
            return new CellIdentityGsm[i];
        }
    };
    private static final boolean DBG = false;
    private static final String LOG_TAG = "CellIdentityGsm";
    private final int mCid;
    private final int mLac;
    private final int mMcc;
    private final int mMnc;

    public CellIdentityGsm() {
        this.mMcc = Integer.MAX_VALUE;
        this.mMnc = Integer.MAX_VALUE;
        this.mLac = Integer.MAX_VALUE;
        this.mCid = Integer.MAX_VALUE;
    }

    public CellIdentityGsm(int i, int i2, int i3, int i4) {
        this.mMcc = i;
        this.mMnc = i2;
        this.mLac = i3;
        this.mCid = i4;
    }

    private CellIdentityGsm(Parcel parcel) {
        this.mMcc = parcel.readInt();
        this.mMnc = parcel.readInt();
        this.mLac = parcel.readInt();
        this.mCid = parcel.readInt();
    }

    private CellIdentityGsm(CellIdentityGsm cellIdentityGsm) {
        this.mMcc = cellIdentityGsm.mMcc;
        this.mMnc = cellIdentityGsm.mMnc;
        this.mLac = cellIdentityGsm.mLac;
        this.mCid = cellIdentityGsm.mCid;
    }

    private static void log(String str) {
        Rlog.w(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CellIdentityGsm copy() {
        return new CellIdentityGsm(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (super.equals(obj)) {
            try {
                CellIdentityGsm cellIdentityGsm = (CellIdentityGsm) obj;
                z = false;
                if (this.mMcc == cellIdentityGsm.mMcc) {
                    z = false;
                    if (this.mMnc == cellIdentityGsm.mMnc) {
                        z = false;
                        if (this.mLac == cellIdentityGsm.mLac) {
                            z = false;
                            if (this.mCid == cellIdentityGsm.mCid) {
                                z = true;
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

    @Deprecated
    public int getPsc() {
        return Integer.MAX_VALUE;
    }

    public int hashCode() {
        return (this.mMcc * 31) + (this.mMnc * 31) + (this.mLac * 31) + (this.mCid * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CellIdentityGsm:{");
        sb.append(" mMcc=").append(this.mMcc);
        sb.append(" mMnc=").append(this.mMnc);
        sb.append(" mLac=").append(this.mLac);
        sb.append(" mCid=").append(this.mCid);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMcc);
        parcel.writeInt(this.mMnc);
        parcel.writeInt(this.mLac);
        parcel.writeInt(this.mCid);
    }
}
