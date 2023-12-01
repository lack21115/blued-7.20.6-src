package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/CellInfo.class */
public abstract class CellInfo implements Parcelable {
    public static final Parcelable.Creator<CellInfo> CREATOR = new Parcelable.Creator<CellInfo>() { // from class: android.telephony.CellInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellInfo createFromParcel(Parcel parcel) {
            switch (parcel.readInt()) {
                case 1:
                    return CellInfoGsm.createFromParcelBody(parcel);
                case 2:
                    return CellInfoCdma.createFromParcelBody(parcel);
                case 3:
                    return CellInfoLte.createFromParcelBody(parcel);
                case 4:
                    return CellInfoWcdma.createFromParcelBody(parcel);
                default:
                    throw new RuntimeException("Bad CellInfo Parcel");
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CellInfo[] newArray(int i) {
            return new CellInfo[i];
        }
    };
    public static final int TIMESTAMP_TYPE_ANTENNA = 1;
    public static final int TIMESTAMP_TYPE_JAVA_RIL = 4;
    public static final int TIMESTAMP_TYPE_MODEM = 2;
    public static final int TIMESTAMP_TYPE_OEM_RIL = 3;
    public static final int TIMESTAMP_TYPE_UNKNOWN = 0;
    protected static final int TYPE_CDMA = 2;
    protected static final int TYPE_GSM = 1;
    protected static final int TYPE_LTE = 3;
    protected static final int TYPE_WCDMA = 4;
    private boolean mRegistered;
    private long mTimeStamp;
    private int mTimeStampType;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellInfo() {
        this.mRegistered = false;
        this.mTimeStampType = 0;
        this.mTimeStamp = Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CellInfo(Parcel parcel) {
        this.mRegistered = parcel.readInt() != 1 ? false : true;
        this.mTimeStampType = parcel.readInt();
        this.mTimeStamp = parcel.readLong();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CellInfo(CellInfo cellInfo) {
        this.mRegistered = cellInfo.mRegistered;
        this.mTimeStampType = cellInfo.mTimeStampType;
        this.mTimeStamp = cellInfo.mTimeStamp;
    }

    private static String timeStampTypeToString(int i) {
        switch (i) {
            case 1:
                return "antenna";
            case 2:
                return "modem";
            case 3:
                return "oem_ril";
            case 4:
                return "java_ril";
            default:
                return "unknown";
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r5.mTimeStampType == r0.mTimeStampType) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            r9 = r0
            r0 = r6
            if (r0 != 0) goto L9
            r0 = 0
            return r0
        L9:
            r0 = r5
            r1 = r6
            if (r0 != r1) goto L10
            r0 = 1
            return r0
        L10:
            r0 = r6
            android.telephony.CellInfo r0 = (android.telephony.CellInfo) r0     // Catch: java.lang.ClassCastException -> L44
            r6 = r0
            r0 = r5
            boolean r0 = r0.mRegistered     // Catch: java.lang.ClassCastException -> L44
            r1 = r6
            boolean r1 = r1.mRegistered     // Catch: java.lang.ClassCastException -> L44
            if (r0 != r1) goto L3e
            r0 = r5
            long r0 = r0.mTimeStamp     // Catch: java.lang.ClassCastException -> L44
            r1 = r6
            long r1 = r1.mTimeStamp     // Catch: java.lang.ClassCastException -> L44
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L3e
            r0 = r5
            int r0 = r0.mTimeStampType     // Catch: java.lang.ClassCastException -> L44
            r7 = r0
            r0 = r6
            int r0 = r0.mTimeStampType     // Catch: java.lang.ClassCastException -> L44
            r8 = r0
            r0 = r7
            r1 = r8
            if (r0 != r1) goto L3e
        L3b:
            r0 = r9
            return r0
        L3e:
            r0 = 0
            r9 = r0
            goto L3b
        L44:
            r6 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.telephony.CellInfo.equals(java.lang.Object):boolean");
    }

    public long getTimeStamp() {
        return this.mTimeStamp;
    }

    public int getTimeStampType() {
        return this.mTimeStampType;
    }

    public int hashCode() {
        return ((this.mRegistered ? 0 : 1) * 31) + (((int) (this.mTimeStamp / 1000)) * 31) + (this.mTimeStampType * 31);
    }

    public boolean isRegistered() {
        return this.mRegistered;
    }

    public void setRegistered(boolean z) {
        this.mRegistered = z;
    }

    public void setTimeStamp(long j) {
        this.mTimeStamp = j;
    }

    public void setTimeStampType(int i) {
        if (i < 0 || i > 4) {
            this.mTimeStampType = 0;
        } else {
            this.mTimeStampType = i;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("mRegistered=").append(this.mRegistered ? "YES" : "NO");
        stringBuffer.append(" mTimeStampType=").append(timeStampTypeToString(this.mTimeStampType));
        stringBuffer.append(" mTimeStamp=").append(this.mTimeStamp).append("ns");
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public abstract void writeToParcel(Parcel parcel, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeToParcel(Parcel parcel, int i, int i2) {
        parcel.writeInt(i2);
        parcel.writeInt(this.mRegistered ? 1 : 0);
        parcel.writeInt(this.mTimeStampType);
        parcel.writeLong(this.mTimeStamp);
    }
}
