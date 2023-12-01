package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/CellIdentityLte.class */
public final class CellIdentityLte implements Parcelable {
    public static final Parcelable.Creator<CellIdentityLte> CREATOR = new Parcelable.Creator<CellIdentityLte>() { // from class: android.telephony.CellIdentityLte.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellIdentityLte createFromParcel(Parcel parcel) {
            return new CellIdentityLte(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellIdentityLte[] newArray(int i) {
            return new CellIdentityLte[i];
        }
    };
    private static final boolean DBG = false;
    private static final String LOG_TAG = "CellIdentityLte";
    private final int mCi;
    private final int mMcc;
    private final int mMnc;
    private final int mPci;
    private final int mTac;

    public CellIdentityLte() {
        this.mMcc = Integer.MAX_VALUE;
        this.mMnc = Integer.MAX_VALUE;
        this.mCi = Integer.MAX_VALUE;
        this.mPci = Integer.MAX_VALUE;
        this.mTac = Integer.MAX_VALUE;
    }

    public CellIdentityLte(int i, int i2, int i3, int i4, int i5) {
        this.mMcc = i;
        this.mMnc = i2;
        this.mCi = i3;
        this.mPci = i4;
        this.mTac = i5;
    }

    private CellIdentityLte(Parcel parcel) {
        this.mMcc = parcel.readInt();
        this.mMnc = parcel.readInt();
        this.mCi = parcel.readInt();
        this.mPci = parcel.readInt();
        this.mTac = parcel.readInt();
    }

    private CellIdentityLte(CellIdentityLte cellIdentityLte) {
        this.mMcc = cellIdentityLte.mMcc;
        this.mMnc = cellIdentityLte.mMnc;
        this.mCi = cellIdentityLte.mCi;
        this.mPci = cellIdentityLte.mPci;
        this.mTac = cellIdentityLte.mTac;
    }

    private static void log(String str) {
        Rlog.w(LOG_TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CellIdentityLte copy() {
        return new CellIdentityLte(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (super.equals(obj)) {
            try {
                CellIdentityLte cellIdentityLte = (CellIdentityLte) obj;
                z = false;
                if (this.mMcc == cellIdentityLte.mMcc) {
                    z = false;
                    if (this.mMnc == cellIdentityLte.mMnc) {
                        z = false;
                        if (this.mCi == cellIdentityLte.mCi) {
                            z = false;
                            if (this.mPci == cellIdentityLte.mPci) {
                                z = false;
                                if (this.mTac == cellIdentityLte.mTac) {
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

    public int getCi() {
        return this.mCi;
    }

    public int getMcc() {
        return this.mMcc;
    }

    public int getMnc() {
        return this.mMnc;
    }

    public int getPci() {
        return this.mPci;
    }

    public int getTac() {
        return this.mTac;
    }

    public int hashCode() {
        return (this.mMcc * 31) + (this.mMnc * 31) + (this.mCi * 31) + (this.mPci * 31) + (this.mTac * 31);
    }

    public String toString() {
        return "CellIdentityLte:{ mMcc=" + this.mMcc + " mMnc=" + this.mMnc + " mCi=" + this.mCi + " mPci=" + this.mPci + " mTac=" + this.mTac + i.d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mMcc);
        parcel.writeInt(this.mMnc);
        parcel.writeInt(this.mCi);
        parcel.writeInt(this.mPci);
        parcel.writeInt(this.mTac);
    }
}
