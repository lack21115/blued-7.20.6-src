package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/CellSignalStrengthCdma.class */
public final class CellSignalStrengthCdma extends CellSignalStrength implements Parcelable {
    public static final Parcelable.Creator<CellSignalStrengthCdma> CREATOR = new Parcelable.Creator<CellSignalStrengthCdma>() { // from class: android.telephony.CellSignalStrengthCdma.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellSignalStrengthCdma createFromParcel(Parcel parcel) {
            return new CellSignalStrengthCdma(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellSignalStrengthCdma[] newArray(int i) {
            return new CellSignalStrengthCdma[i];
        }
    };
    private static final boolean DBG = false;
    private static final String LOG_TAG = "CellSignalStrengthCdma";
    private int mCdmaDbm;
    private int mCdmaEcio;
    private int mEvdoDbm;
    private int mEvdoEcio;
    private int mEvdoSnr;

    public CellSignalStrengthCdma() {
        setDefaultValues();
    }

    public CellSignalStrengthCdma(int i, int i2, int i3, int i4, int i5) {
        initialize(i, i2, i3, i4, i5);
    }

    private CellSignalStrengthCdma(Parcel parcel) {
        this.mCdmaDbm = parcel.readInt() * (-1);
        this.mCdmaEcio = parcel.readInt() * (-1);
        this.mEvdoDbm = parcel.readInt() * (-1);
        this.mEvdoEcio = parcel.readInt() * (-1);
        this.mEvdoSnr = parcel.readInt();
    }

    public CellSignalStrengthCdma(CellSignalStrengthCdma cellSignalStrengthCdma) {
        copyFrom(cellSignalStrengthCdma);
    }

    private static void log(String str) {
        Rlog.w(LOG_TAG, str);
    }

    @Override // android.telephony.CellSignalStrength
    public CellSignalStrengthCdma copy() {
        return new CellSignalStrengthCdma(this);
    }

    protected void copyFrom(CellSignalStrengthCdma cellSignalStrengthCdma) {
        this.mCdmaDbm = cellSignalStrengthCdma.mCdmaDbm;
        this.mCdmaEcio = cellSignalStrengthCdma.mCdmaEcio;
        this.mEvdoDbm = cellSignalStrengthCdma.mEvdoDbm;
        this.mEvdoEcio = cellSignalStrengthCdma.mEvdoEcio;
        this.mEvdoSnr = cellSignalStrengthCdma.mEvdoSnr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.telephony.CellSignalStrength
    public boolean equals(Object obj) {
        try {
            CellSignalStrengthCdma cellSignalStrengthCdma = (CellSignalStrengthCdma) obj;
            return obj != null && this.mCdmaDbm == cellSignalStrengthCdma.mCdmaDbm && this.mCdmaEcio == cellSignalStrengthCdma.mCdmaEcio && this.mEvdoDbm == cellSignalStrengthCdma.mEvdoDbm && this.mEvdoEcio == cellSignalStrengthCdma.mEvdoEcio && this.mEvdoSnr == cellSignalStrengthCdma.mEvdoSnr;
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override // android.telephony.CellSignalStrength
    public int getAsuLevel() {
        int cdmaDbm = getCdmaDbm();
        int cdmaEcio = getCdmaEcio();
        int i = cdmaDbm >= -75 ? 16 : cdmaDbm >= -82 ? 8 : cdmaDbm >= -90 ? 4 : cdmaDbm >= -95 ? 2 : cdmaDbm >= -100 ? 1 : 99;
        int i2 = cdmaEcio >= -90 ? 16 : cdmaEcio >= -100 ? 8 : cdmaEcio >= -115 ? 4 : cdmaEcio >= -130 ? 2 : cdmaEcio >= -150 ? 1 : 99;
        return i < i2 ? i : i2;
    }

    public int getCdmaDbm() {
        return this.mCdmaDbm;
    }

    public int getCdmaEcio() {
        return this.mCdmaEcio;
    }

    public int getCdmaLevel() {
        int cdmaDbm = getCdmaDbm();
        int cdmaEcio = getCdmaEcio();
        int i = cdmaDbm >= -75 ? 4 : cdmaDbm >= -85 ? 3 : cdmaDbm >= -95 ? 2 : cdmaDbm >= -100 ? 1 : 0;
        int i2 = cdmaEcio >= -90 ? 4 : cdmaEcio >= -110 ? 3 : cdmaEcio >= -130 ? 2 : cdmaEcio >= -150 ? 1 : 0;
        return i < i2 ? i : i2;
    }

    @Override // android.telephony.CellSignalStrength
    public int getDbm() {
        int cdmaDbm = getCdmaDbm();
        int evdoDbm = getEvdoDbm();
        return cdmaDbm < evdoDbm ? cdmaDbm : evdoDbm;
    }

    public int getEvdoDbm() {
        return this.mEvdoDbm;
    }

    public int getEvdoEcio() {
        return this.mEvdoEcio;
    }

    public int getEvdoLevel() {
        int evdoDbm = getEvdoDbm();
        int evdoSnr = getEvdoSnr();
        int i = evdoDbm >= -65 ? 4 : evdoDbm >= -75 ? 3 : evdoDbm >= -90 ? 2 : evdoDbm >= -105 ? 1 : 0;
        int i2 = evdoSnr >= 7 ? 4 : evdoSnr >= 5 ? 3 : evdoSnr >= 3 ? 2 : evdoSnr >= 1 ? 1 : 0;
        return i < i2 ? i : i2;
    }

    public int getEvdoSnr() {
        return this.mEvdoSnr;
    }

    @Override // android.telephony.CellSignalStrength
    public int getLevel() {
        int cdmaLevel = getCdmaLevel();
        int evdoLevel = getEvdoLevel();
        return evdoLevel == 0 ? getCdmaLevel() : cdmaLevel == 0 ? getEvdoLevel() : cdmaLevel < evdoLevel ? cdmaLevel : evdoLevel;
    }

    @Override // android.telephony.CellSignalStrength
    public int hashCode() {
        return (this.mCdmaDbm * 31) + (this.mCdmaEcio * 31) + (this.mEvdoDbm * 31) + (this.mEvdoEcio * 31) + (this.mEvdoSnr * 31);
    }

    public void initialize(int i, int i2, int i3, int i4, int i5) {
        this.mCdmaDbm = i;
        this.mCdmaEcio = i2;
        this.mEvdoDbm = i3;
        this.mEvdoEcio = i4;
        this.mEvdoSnr = i5;
    }

    public void setCdmaDbm(int i) {
        this.mCdmaDbm = i;
    }

    public void setCdmaEcio(int i) {
        this.mCdmaEcio = i;
    }

    @Override // android.telephony.CellSignalStrength
    public void setDefaultValues() {
        this.mCdmaDbm = Integer.MAX_VALUE;
        this.mCdmaEcio = Integer.MAX_VALUE;
        this.mEvdoDbm = Integer.MAX_VALUE;
        this.mEvdoEcio = Integer.MAX_VALUE;
        this.mEvdoSnr = Integer.MAX_VALUE;
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

    public String toString() {
        return "CellSignalStrengthCdma: cdmaDbm=" + this.mCdmaDbm + " cdmaEcio=" + this.mCdmaEcio + " evdoDbm=" + this.mEvdoDbm + " evdoEcio=" + this.mEvdoEcio + " evdoSnr=" + this.mEvdoSnr;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mCdmaDbm * (-1));
        parcel.writeInt(this.mCdmaEcio * (-1));
        parcel.writeInt(this.mEvdoDbm * (-1));
        parcel.writeInt(this.mEvdoEcio * (-1));
        parcel.writeInt(this.mEvdoSnr);
    }
}
