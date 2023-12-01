package android.telephony;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemProperties;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/SignalStrength.class */
public class SignalStrength implements Parcelable {
    private static final boolean DBG = false;
    public static final int INVALID = Integer.MAX_VALUE;
    private static final String LOG_TAG = "SignalStrength";
    public static final int NUM_SIGNAL_STRENGTH_BINS = 5;
    private static final int RSRP_THRESH_TYPE_CUSTOM = 2;
    private static final int RSRP_THRESH_TYPE_STRICT = 0;
    public static final int SIGNAL_STRENGTH_GOOD = 3;
    public static final int SIGNAL_STRENGTH_GREAT = 4;
    public static final int SIGNAL_STRENGTH_MODERATE = 2;
    public static final int SIGNAL_STRENGTH_NONE_OR_UNKNOWN = 0;
    public static final int SIGNAL_STRENGTH_POOR = 1;
    private boolean isGsm;
    private int mCdmaDbm;
    private int mCdmaEcio;
    private int mEvdoDbm;
    private int mEvdoEcio;
    private int mEvdoSnr;
    private int mGsmBitErrorRate;
    private int mGsmSignalStrength;
    private int mLteCqi;
    private int mLteRsrp;
    private int mLteRsrq;
    private int mLteRssnr;
    private int mLteSignalStrength;
    private int mTdScdmaRscp;
    public static final String[] SIGNAL_STRENGTH_NAMES = {"none", "poor", "moderate", "good", "great"};
    private static final int[] RSRP_THRESH_STRICT = {-140, PackageManager.INSTALL_FAILED_ABORTED, PackageManager.INSTALL_PARSE_FAILED_CERTIFICATE_ENCODING, -95, -85, -44};
    private static final int[] RSRP_THRESH_LENIENT = {-140, -128, -118, PackageManager.INSTALL_PARSE_FAILED_MANIFEST_MALFORMED, -98, -44};
    public static final Parcelable.Creator<SignalStrength> CREATOR = new Parcelable.Creator() { // from class: android.telephony.SignalStrength.1
        @Override // android.os.Parcelable.Creator
        public SignalStrength createFromParcel(Parcel parcel) {
            return new SignalStrength(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SignalStrength[] newArray(int i) {
            return new SignalStrength[i];
        }
    };

    public SignalStrength() {
        this.mGsmSignalStrength = 99;
        this.mGsmBitErrorRate = -1;
        this.mCdmaDbm = -1;
        this.mCdmaEcio = -1;
        this.mEvdoDbm = -1;
        this.mEvdoEcio = -1;
        this.mEvdoSnr = -1;
        this.mLteSignalStrength = 99;
        this.mLteRsrp = Integer.MAX_VALUE;
        this.mLteRsrq = Integer.MAX_VALUE;
        this.mLteRssnr = Integer.MAX_VALUE;
        this.mLteCqi = Integer.MAX_VALUE;
        this.mTdScdmaRscp = Integer.MAX_VALUE;
        this.isGsm = true;
    }

    public SignalStrength(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, boolean z) {
        initialize(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, z);
        this.mTdScdmaRscp = i13;
    }

    public SignalStrength(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z) {
        initialize(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, z);
    }

    public SignalStrength(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        initialize(i, i2, i3, i4, i5, i6, i7, 99, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, z);
    }

    public SignalStrength(Parcel parcel) {
        this.mGsmSignalStrength = parcel.readInt();
        this.mGsmBitErrorRate = parcel.readInt();
        this.mCdmaDbm = parcel.readInt();
        this.mCdmaEcio = parcel.readInt();
        this.mEvdoDbm = parcel.readInt();
        this.mEvdoEcio = parcel.readInt();
        this.mEvdoSnr = parcel.readInt();
        this.mLteSignalStrength = parcel.readInt();
        this.mLteRsrp = parcel.readInt();
        this.mLteRsrq = parcel.readInt();
        this.mLteRssnr = parcel.readInt();
        this.mLteCqi = parcel.readInt();
        this.mTdScdmaRscp = parcel.readInt();
        this.isGsm = parcel.readInt() != 0;
    }

    public SignalStrength(SignalStrength signalStrength) {
        copyFrom(signalStrength);
    }

    public SignalStrength(boolean z) {
        this.mGsmSignalStrength = 99;
        this.mGsmBitErrorRate = -1;
        this.mCdmaDbm = -1;
        this.mCdmaEcio = -1;
        this.mEvdoDbm = -1;
        this.mEvdoEcio = -1;
        this.mEvdoSnr = -1;
        this.mLteSignalStrength = 99;
        this.mLteRsrp = Integer.MAX_VALUE;
        this.mLteRsrq = Integer.MAX_VALUE;
        this.mLteRssnr = Integer.MAX_VALUE;
        this.mLteCqi = Integer.MAX_VALUE;
        this.mTdScdmaRscp = Integer.MAX_VALUE;
        this.isGsm = z;
    }

    private int getLteLevel(boolean z) {
        int i;
        int i2 = -1;
        int i3 = -1;
        int integer = Resources.getSystem().getInteger(17694856);
        int[] intArray = integer == 0 ? RSRP_THRESH_STRICT : integer == 2 ? Resources.getSystem().getIntArray(17236053) : RSRP_THRESH_LENIENT;
        if (this.mLteRsrp > intArray[5]) {
            i2 = -1;
        } else if (this.mLteRsrp >= intArray[4]) {
            i2 = 4;
        } else if (this.mLteRsrp >= intArray[3]) {
            i2 = 3;
        } else if (this.mLteRsrp >= intArray[2]) {
            i2 = 2;
        } else if (this.mLteRsrp >= intArray[1]) {
            i2 = 1;
        } else if (this.mLteRsrp >= intArray[0]) {
            i2 = 0;
        }
        if (!z) {
            if (this.mLteRssnr > 300) {
                i3 = -1;
            } else if (this.mLteRssnr >= 130) {
                i3 = 4;
            } else if (this.mLteRssnr >= 45) {
                i3 = 3;
            } else if (this.mLteRssnr >= 10) {
                i3 = 2;
            } else if (this.mLteRssnr >= -30) {
                i3 = 1;
            } else if (this.mLteRssnr >= -200) {
                i3 = 0;
            }
            if (i3 == -1 || i2 == -1) {
                if (i3 != -1) {
                    return i3;
                }
                if (i2 == -1) {
                    if (this.mLteSignalStrength > 63) {
                        i = 0;
                    } else if (this.mLteSignalStrength >= 12) {
                        i = 4;
                    } else if (this.mLteSignalStrength >= 8) {
                        i = 3;
                    } else if (this.mLteSignalStrength >= 5) {
                        i = 2;
                    } else {
                        i = 0;
                        if (this.mLteSignalStrength >= 0) {
                            i = 1;
                        }
                    }
                    return i;
                }
            } else if (i2 >= i3) {
                return i3;
            }
        }
        return i2;
    }

    private static void log(String str) {
        Rlog.w(LOG_TAG, str);
    }

    public static SignalStrength makeSignalStrengthFromRilParcel(Parcel parcel) {
        SignalStrength signalStrength = new SignalStrength();
        signalStrength.mGsmSignalStrength = parcel.readInt();
        signalStrength.mGsmBitErrorRate = parcel.readInt();
        signalStrength.mCdmaDbm = parcel.readInt();
        signalStrength.mCdmaEcio = parcel.readInt();
        signalStrength.mEvdoDbm = parcel.readInt();
        signalStrength.mEvdoEcio = parcel.readInt();
        signalStrength.mEvdoSnr = parcel.readInt();
        signalStrength.mLteSignalStrength = parcel.readInt();
        signalStrength.mLteRsrp = parcel.readInt();
        signalStrength.mLteRsrq = parcel.readInt();
        signalStrength.mLteRssnr = parcel.readInt();
        signalStrength.mLteCqi = parcel.readInt();
        signalStrength.mTdScdmaRscp = parcel.readInt();
        return signalStrength;
    }

    public static SignalStrength newFromBundle(Bundle bundle) {
        SignalStrength signalStrength = new SignalStrength();
        signalStrength.setFromNotifierBundle(bundle);
        return signalStrength;
    }

    private void setFromNotifierBundle(Bundle bundle) {
        this.mGsmSignalStrength = bundle.getInt("GsmSignalStrength");
        this.mGsmBitErrorRate = bundle.getInt("GsmBitErrorRate");
        this.mCdmaDbm = bundle.getInt("CdmaDbm");
        this.mCdmaEcio = bundle.getInt("CdmaEcio");
        this.mEvdoDbm = bundle.getInt("EvdoDbm");
        this.mEvdoEcio = bundle.getInt("EvdoEcio");
        this.mEvdoSnr = bundle.getInt("EvdoSnr");
        this.mLteSignalStrength = bundle.getInt("LteSignalStrength");
        this.mLteRsrp = bundle.getInt("LteRsrp");
        this.mLteRsrq = bundle.getInt("LteRsrq");
        this.mLteRssnr = bundle.getInt("LteRssnr");
        this.mLteCqi = bundle.getInt("LteCqi");
        this.mTdScdmaRscp = bundle.getInt("TdScdma");
        this.isGsm = bundle.getBoolean("isGsm");
    }

    protected void copyFrom(SignalStrength signalStrength) {
        this.mGsmSignalStrength = signalStrength.mGsmSignalStrength;
        this.mGsmBitErrorRate = signalStrength.mGsmBitErrorRate;
        this.mCdmaDbm = signalStrength.mCdmaDbm;
        this.mCdmaEcio = signalStrength.mCdmaEcio;
        this.mEvdoDbm = signalStrength.mEvdoDbm;
        this.mEvdoEcio = signalStrength.mEvdoEcio;
        this.mEvdoSnr = signalStrength.mEvdoSnr;
        this.mLteSignalStrength = signalStrength.mLteSignalStrength;
        this.mLteRsrp = signalStrength.mLteRsrp;
        this.mLteRsrq = signalStrength.mLteRsrq;
        this.mLteRssnr = signalStrength.mLteRssnr;
        this.mLteCqi = signalStrength.mLteCqi;
        this.mTdScdmaRscp = signalStrength.mTdScdmaRscp;
        this.isGsm = signalStrength.isGsm;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        try {
            SignalStrength signalStrength = (SignalStrength) obj;
            return obj != null && this.mGsmSignalStrength == signalStrength.mGsmSignalStrength && this.mGsmBitErrorRate == signalStrength.mGsmBitErrorRate && this.mCdmaDbm == signalStrength.mCdmaDbm && this.mCdmaEcio == signalStrength.mCdmaEcio && this.mEvdoDbm == signalStrength.mEvdoDbm && this.mEvdoEcio == signalStrength.mEvdoEcio && this.mEvdoSnr == signalStrength.mEvdoSnr && this.mLteSignalStrength == signalStrength.mLteSignalStrength && this.mLteRsrp == signalStrength.mLteRsrp && this.mLteRsrq == signalStrength.mLteRsrq && this.mLteRssnr == signalStrength.mLteRssnr && this.mLteCqi == signalStrength.mLteCqi && this.mTdScdmaRscp == signalStrength.mTdScdmaRscp && this.isGsm == signalStrength.isGsm;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public void fillInNotifierBundle(Bundle bundle) {
        bundle.putInt("GsmSignalStrength", this.mGsmSignalStrength);
        bundle.putInt("GsmBitErrorRate", this.mGsmBitErrorRate);
        bundle.putInt("CdmaDbm", this.mCdmaDbm);
        bundle.putInt("CdmaEcio", this.mCdmaEcio);
        bundle.putInt("EvdoDbm", this.mEvdoDbm);
        bundle.putInt("EvdoEcio", this.mEvdoEcio);
        bundle.putInt("EvdoSnr", this.mEvdoSnr);
        bundle.putInt("LteSignalStrength", this.mLteSignalStrength);
        bundle.putInt("LteRsrp", this.mLteRsrp);
        bundle.putInt("LteRsrq", this.mLteRsrq);
        bundle.putInt("LteRssnr", this.mLteRssnr);
        bundle.putInt("LteCqi", this.mLteCqi);
        bundle.putInt("TdScdma", this.mTdScdmaRscp);
        bundle.putBoolean("isGsm", Boolean.valueOf(this.isGsm).booleanValue());
    }

    public int getAlternateLteLevel() {
        return getLteLevel(true);
    }

    public int getAsuLevel() {
        if (this.isGsm) {
            return (getLteLevel() == 0 || needsOldRilFeature("signalstrength")) ? getTdScdmaLevel() == 0 ? getGsmAsuLevel() : getTdScdmaAsuLevel() : getLteAsuLevel();
        }
        int cdmaAsuLevel = getCdmaAsuLevel();
        int evdoAsuLevel = getEvdoAsuLevel();
        if (evdoAsuLevel == 0) {
            return cdmaAsuLevel;
        }
        if (cdmaAsuLevel != 0 && cdmaAsuLevel < evdoAsuLevel) {
            return cdmaAsuLevel;
        }
        return evdoAsuLevel;
    }

    public int getCdmaAsuLevel() {
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

    public int getDbm() {
        int i;
        if (isGsm()) {
            boolean needsOldRilFeature = needsOldRilFeature("signalstrength");
            i = getLteDbm();
            if (i == Integer.MAX_VALUE || needsOldRilFeature) {
                i = getTdScdmaLevel() == 0 ? getGsmDbm() : getTdScdmaDbm();
            }
        } else {
            int cdmaDbm = getCdmaDbm();
            int evdoDbm = getEvdoDbm();
            i = cdmaDbm;
            if (evdoDbm != -120) {
                if (cdmaDbm == -120) {
                    return evdoDbm;
                }
                i = cdmaDbm;
                if (cdmaDbm >= evdoDbm) {
                    return evdoDbm;
                }
            }
        }
        return i;
    }

    public int getEvdoAsuLevel() {
        int evdoDbm = getEvdoDbm();
        int evdoSnr = getEvdoSnr();
        int i = evdoDbm >= -65 ? 16 : evdoDbm >= -75 ? 8 : evdoDbm >= -85 ? 4 : evdoDbm >= -95 ? 2 : evdoDbm >= -105 ? 1 : 99;
        int i2 = evdoSnr >= 7 ? 16 : evdoSnr >= 6 ? 8 : evdoSnr >= 5 ? 4 : evdoSnr >= 3 ? 2 : evdoSnr >= 1 ? 1 : 99;
        return i < i2 ? i : i2;
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

    public int getGsmAsuLevel() {
        return getGsmSignalStrength();
    }

    public int getGsmBitErrorRate() {
        return this.mGsmBitErrorRate;
    }

    public int getGsmDbm() {
        int gsmSignalStrength = getGsmSignalStrength();
        if (gsmSignalStrength == 99) {
            gsmSignalStrength = -1;
        }
        if (gsmSignalStrength != -1) {
            return (gsmSignalStrength * 2) - 113;
        }
        return -1;
    }

    public int getGsmLevel() {
        int gsmSignalStrength = getGsmSignalStrength();
        if (gsmSignalStrength <= 2 || gsmSignalStrength == 99) {
            return 0;
        }
        if (gsmSignalStrength >= 12) {
            return 4;
        }
        if (gsmSignalStrength >= 8) {
            return 3;
        }
        return gsmSignalStrength >= 5 ? 2 : 1;
    }

    public int getGsmSignalStrength() {
        return this.mGsmSignalStrength;
    }

    public int getLevel() {
        if (!this.isGsm) {
            int cdmaLevel = getCdmaLevel();
            int evdoLevel = getEvdoLevel();
            if (evdoLevel == 0) {
                return cdmaLevel;
            }
            if (cdmaLevel != 0 && cdmaLevel < evdoLevel) {
                return cdmaLevel;
            }
            return evdoLevel;
        }
        boolean needsOldRilFeature = needsOldRilFeature("signalstrength");
        int lteLevel = getLteLevel();
        if (lteLevel == 0 || needsOldRilFeature) {
            int tdScdmaLevel = getTdScdmaLevel();
            lteLevel = tdScdmaLevel;
            if (tdScdmaLevel == 0) {
                lteLevel = getGsmLevel();
            }
        }
        return lteLevel;
    }

    public int getLteAsuLevel() {
        int lteDbm = getLteDbm();
        if (lteDbm == Integer.MAX_VALUE) {
            return 255;
        }
        return lteDbm + 140;
    }

    public int getLteCqi() {
        return this.mLteCqi;
    }

    public int getLteDbm() {
        return this.mLteRsrp;
    }

    public int getLteLevel() {
        return getLteLevel(false);
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

    public int getTdScdmaAsuLevel() {
        int tdScdmaDbm = getTdScdmaDbm();
        if (tdScdmaDbm == Integer.MAX_VALUE) {
            return 255;
        }
        return tdScdmaDbm + 120;
    }

    public int getTdScdmaDbm() {
        return this.mTdScdmaRscp;
    }

    public int getTdScdmaLevel() {
        int tdScdmaDbm = getTdScdmaDbm();
        if (tdScdmaDbm > -25 || tdScdmaDbm == Integer.MAX_VALUE) {
            return 0;
        }
        if (tdScdmaDbm >= -49) {
            return 4;
        }
        if (tdScdmaDbm >= -73) {
            return 3;
        }
        if (tdScdmaDbm >= -97) {
            return 2;
        }
        return tdScdmaDbm >= -120 ? 1 : 0;
    }

    public int hashCode() {
        int i = this.mGsmSignalStrength;
        int i2 = this.mGsmBitErrorRate;
        int i3 = this.mCdmaDbm;
        int i4 = this.mCdmaEcio;
        int i5 = this.mEvdoDbm;
        int i6 = this.mEvdoEcio;
        int i7 = this.mEvdoSnr;
        int i8 = this.mLteSignalStrength;
        int i9 = this.mLteRsrp;
        int i10 = this.mLteRsrq;
        int i11 = this.mLteRssnr;
        int i12 = this.mLteCqi;
        return (this.isGsm ? 1 : 0) + (this.mTdScdmaRscp * 31) + (i * 31) + (i2 * 31) + (i3 * 31) + (i4 * 31) + (i5 * 31) + (i6 * 31) + (i7 * 31) + (i8 * 31) + (i9 * 31) + (i10 * 31) + (i11 * 31) + (i12 * 31);
    }

    public void initialize(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z) {
        this.mGsmSignalStrength = i;
        this.mGsmBitErrorRate = i2;
        this.mCdmaDbm = i3;
        this.mCdmaEcio = i4;
        this.mEvdoDbm = i5;
        this.mEvdoEcio = i6;
        this.mEvdoSnr = i7;
        this.mLteSignalStrength = i8;
        this.mLteRsrp = i9;
        this.mLteRsrq = i10;
        this.mLteRssnr = i11;
        this.mLteCqi = i12;
        this.mTdScdmaRscp = Integer.MAX_VALUE;
        this.isGsm = z;
    }

    public void initialize(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        initialize(i, i2, i3, i4, i5, i6, i7, 99, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, z);
    }

    public boolean isGsm() {
        return this.isGsm;
    }

    public boolean needsOldRilFeature(String str) {
        String[] split = SystemProperties.get("ro.telephony.ril.config", "").split(",");
        int length = split.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (split[i2].equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public void setGsm(boolean z) {
        this.isGsm = z;
    }

    public String toString() {
        return "SignalStrength: " + this.mGsmSignalStrength + " " + this.mGsmBitErrorRate + " " + this.mCdmaDbm + " " + this.mCdmaEcio + " " + this.mEvdoDbm + " " + this.mEvdoEcio + " " + this.mEvdoSnr + " " + this.mLteSignalStrength + " " + this.mLteRsrp + " " + this.mLteRsrq + " " + this.mLteRssnr + " " + this.mLteCqi + " " + this.mTdScdmaRscp + " " + (this.isGsm ? "gsm|lte" : "cdma");
    }

    public void validateInput() {
        this.mGsmSignalStrength = this.mGsmSignalStrength >= 0 ? this.mGsmSignalStrength : 99;
        this.mCdmaDbm = this.mCdmaDbm > 0 ? -this.mCdmaDbm : -120;
        this.mCdmaEcio = this.mCdmaEcio > 0 ? -this.mCdmaEcio : -160;
        int i = -120;
        if (this.mEvdoDbm > 0) {
            i = -this.mEvdoDbm;
        }
        this.mEvdoDbm = i;
        this.mEvdoEcio = this.mEvdoEcio >= 0 ? -this.mEvdoEcio : -1;
        this.mEvdoSnr = (this.mEvdoSnr <= 0 || this.mEvdoSnr > 8) ? -1 : this.mEvdoSnr;
        int i2 = 99;
        if (this.mLteSignalStrength >= 0) {
            i2 = this.mLteSignalStrength;
        }
        this.mLteSignalStrength = i2;
        this.mLteRsrp = (this.mLteRsrp < 44 || this.mLteRsrp > 140) ? Integer.MAX_VALUE : -this.mLteRsrp;
        this.mLteRsrq = (this.mLteRsrq < 3 || this.mLteRsrq > 20) ? Integer.MAX_VALUE : -this.mLteRsrq;
        this.mLteRssnr = (this.mLteRssnr < -200 || this.mLteRssnr > 300 || (this.mLteRsrq == Integer.MAX_VALUE && this.mLteRssnr == -1)) ? Integer.MAX_VALUE : this.mLteRssnr;
        int i3 = Integer.MAX_VALUE;
        if (this.mTdScdmaRscp >= 25) {
            i3 = Integer.MAX_VALUE;
            if (this.mTdScdmaRscp <= 120) {
                i3 = -this.mTdScdmaRscp;
            }
        }
        this.mTdScdmaRscp = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mGsmSignalStrength);
        parcel.writeInt(this.mGsmBitErrorRate);
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
        parcel.writeInt(this.mTdScdmaRscp);
        parcel.writeInt(this.isGsm ? 1 : 0);
    }
}
