package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/CellInfoLte.class */
public final class CellInfoLte extends CellInfo implements Parcelable {
    public static final Parcelable.Creator<CellInfoLte> CREATOR = new Parcelable.Creator<CellInfoLte>() { // from class: android.telephony.CellInfoLte.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellInfoLte createFromParcel(Parcel parcel) {
            parcel.readInt();
            return CellInfoLte.createFromParcelBody(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellInfoLte[] newArray(int i) {
            return new CellInfoLte[i];
        }
    };
    private static final boolean DBG = false;
    private static final String LOG_TAG = "CellInfoLte";
    private CellIdentityLte mCellIdentityLte;
    private CellSignalStrengthLte mCellSignalStrengthLte;

    public CellInfoLte() {
        this.mCellIdentityLte = new CellIdentityLte();
        this.mCellSignalStrengthLte = new CellSignalStrengthLte();
    }

    private CellInfoLte(Parcel parcel) {
        super(parcel);
        this.mCellIdentityLte = CellIdentityLte.CREATOR.createFromParcel(parcel);
        this.mCellSignalStrengthLte = CellSignalStrengthLte.CREATOR.createFromParcel(parcel);
    }

    public CellInfoLte(CellInfoLte cellInfoLte) {
        super(cellInfoLte);
        this.mCellIdentityLte = cellInfoLte.mCellIdentityLte.copy();
        this.mCellSignalStrengthLte = cellInfoLte.mCellSignalStrengthLte.copy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static CellInfoLte createFromParcelBody(Parcel parcel) {
        return new CellInfoLte(parcel);
    }

    private static void log(String str) {
        Rlog.w(LOG_TAG, str);
    }

    @Override // android.telephony.CellInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.telephony.CellInfo
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            try {
                CellInfoLte cellInfoLte = (CellInfoLte) obj;
                if (this.mCellIdentityLte.equals(cellInfoLte.mCellIdentityLte)) {
                    return this.mCellSignalStrengthLte.equals(cellInfoLte.mCellSignalStrengthLte);
                }
                return false;
            } catch (ClassCastException e) {
                return false;
            }
        }
        return false;
    }

    public CellIdentityLte getCellIdentity() {
        return this.mCellIdentityLte;
    }

    public CellSignalStrengthLte getCellSignalStrength() {
        return this.mCellSignalStrengthLte;
    }

    @Override // android.telephony.CellInfo
    public int hashCode() {
        return super.hashCode() + this.mCellIdentityLte.hashCode() + this.mCellSignalStrengthLte.hashCode();
    }

    public void setCellIdentity(CellIdentityLte cellIdentityLte) {
        this.mCellIdentityLte = cellIdentityLte;
    }

    public void setCellSignalStrength(CellSignalStrengthLte cellSignalStrengthLte) {
        this.mCellSignalStrengthLte = cellSignalStrengthLte;
    }

    @Override // android.telephony.CellInfo
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CellInfoLte:{");
        stringBuffer.append(super.toString());
        stringBuffer.append(" ").append(this.mCellIdentityLte);
        stringBuffer.append(" ").append(this.mCellSignalStrengthLte);
        stringBuffer.append(i.d);
        return stringBuffer.toString();
    }

    @Override // android.telephony.CellInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i, 3);
        this.mCellIdentityLte.writeToParcel(parcel, i);
        this.mCellSignalStrengthLte.writeToParcel(parcel, i);
    }
}
