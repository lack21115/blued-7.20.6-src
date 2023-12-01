package android.telephony.gsm;

import android.os.Bundle;
import android.telephony.CellLocation;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/gsm/GsmCellLocation.class */
public class GsmCellLocation extends CellLocation {
    private int mCid;
    private int mLac;
    private int mPsc;

    public GsmCellLocation() {
        this.mLac = -1;
        this.mCid = -1;
        this.mPsc = -1;
    }

    public GsmCellLocation(Bundle bundle) {
        this.mLac = -1;
        this.mCid = -1;
        this.mPsc = -1;
        this.mLac = bundle.getInt("lac", this.mLac);
        this.mCid = bundle.getInt("cid", this.mCid);
        this.mPsc = bundle.getInt("psc", this.mPsc);
    }

    private static boolean equalsHandlesNulls(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public boolean equals(Object obj) {
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) obj;
            return obj != null && equalsHandlesNulls(Integer.valueOf(this.mLac), Integer.valueOf(gsmCellLocation.mLac)) && equalsHandlesNulls(Integer.valueOf(this.mCid), Integer.valueOf(gsmCellLocation.mCid)) && equalsHandlesNulls(Integer.valueOf(this.mPsc), Integer.valueOf(gsmCellLocation.mPsc));
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override // android.telephony.CellLocation
    public void fillInNotifierBundle(Bundle bundle) {
        bundle.putInt("lac", this.mLac);
        bundle.putInt("cid", this.mCid);
        bundle.putInt("psc", this.mPsc);
    }

    public int getCid() {
        return this.mCid;
    }

    public int getLac() {
        return this.mLac;
    }

    public int getPsc() {
        return this.mPsc;
    }

    public int hashCode() {
        return this.mLac ^ this.mCid;
    }

    @Override // android.telephony.CellLocation
    public boolean isEmpty() {
        return this.mLac == -1 && this.mCid == -1 && this.mPsc == -1;
    }

    public void setLacAndCid(int i, int i2) {
        this.mLac = i;
        this.mCid = i2;
    }

    public void setPsc(int i) {
        this.mPsc = i;
    }

    public void setStateInvalid() {
        this.mLac = -1;
        this.mCid = -1;
        this.mPsc = -1;
    }

    public String toString() {
        return "[" + this.mLac + "," + this.mCid + "," + this.mPsc + "]";
    }
}
