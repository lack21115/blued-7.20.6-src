package android.telephony;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/PreciseCallState.class */
public class PreciseCallState implements Parcelable {
    public static final Parcelable.Creator<PreciseCallState> CREATOR = new Parcelable.Creator<PreciseCallState>() { // from class: android.telephony.PreciseCallState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PreciseCallState createFromParcel(Parcel parcel) {
            return new PreciseCallState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PreciseCallState[] newArray(int i) {
            return new PreciseCallState[i];
        }
    };
    public static final int PRECISE_CALL_STATE_ACTIVE = 1;
    public static final int PRECISE_CALL_STATE_ALERTING = 4;
    public static final int PRECISE_CALL_STATE_DIALING = 3;
    public static final int PRECISE_CALL_STATE_DISCONNECTED = 7;
    public static final int PRECISE_CALL_STATE_DISCONNECTING = 8;
    public static final int PRECISE_CALL_STATE_HOLDING = 2;
    public static final int PRECISE_CALL_STATE_IDLE = 0;
    public static final int PRECISE_CALL_STATE_INCOMING = 5;
    public static final int PRECISE_CALL_STATE_NOT_VALID = -1;
    public static final int PRECISE_CALL_STATE_WAITING = 6;
    private int mBackgroundCallState;
    private int mDisconnectCause;
    private int mForegroundCallState;
    private int mPreciseDisconnectCause;
    private int mRingingCallState;

    public PreciseCallState() {
        this.mRingingCallState = -1;
        this.mForegroundCallState = -1;
        this.mBackgroundCallState = -1;
        this.mDisconnectCause = -1;
        this.mPreciseDisconnectCause = -1;
    }

    public PreciseCallState(int i, int i2, int i3, int i4, int i5) {
        this.mRingingCallState = -1;
        this.mForegroundCallState = -1;
        this.mBackgroundCallState = -1;
        this.mDisconnectCause = -1;
        this.mPreciseDisconnectCause = -1;
        this.mRingingCallState = i;
        this.mForegroundCallState = i2;
        this.mBackgroundCallState = i3;
        this.mDisconnectCause = i4;
        this.mPreciseDisconnectCause = i5;
    }

    private PreciseCallState(Parcel parcel) {
        this.mRingingCallState = -1;
        this.mForegroundCallState = -1;
        this.mBackgroundCallState = -1;
        this.mDisconnectCause = -1;
        this.mPreciseDisconnectCause = -1;
        this.mRingingCallState = parcel.readInt();
        this.mForegroundCallState = parcel.readInt();
        this.mBackgroundCallState = parcel.readInt();
        this.mDisconnectCause = parcel.readInt();
        this.mPreciseDisconnectCause = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PreciseCallState preciseCallState = (PreciseCallState) obj;
            return (this.mRingingCallState == preciseCallState.mRingingCallState || this.mForegroundCallState == preciseCallState.mForegroundCallState || this.mBackgroundCallState == preciseCallState.mBackgroundCallState || this.mDisconnectCause == preciseCallState.mDisconnectCause || this.mPreciseDisconnectCause == preciseCallState.mPreciseDisconnectCause) ? false : true;
        }
        return false;
    }

    public int getBackgroundCallState() {
        return this.mBackgroundCallState;
    }

    public int getDisconnectCause() {
        return this.mDisconnectCause;
    }

    public int getForegroundCallState() {
        return this.mForegroundCallState;
    }

    public int getPreciseDisconnectCause() {
        return this.mPreciseDisconnectCause;
    }

    public int getRingingCallState() {
        return this.mRingingCallState;
    }

    public int hashCode() {
        return ((((((((this.mRingingCallState + 31) * 31) + this.mForegroundCallState) * 31) + this.mBackgroundCallState) * 31) + this.mDisconnectCause) * 31) + this.mPreciseDisconnectCause;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Ringing call state: " + this.mRingingCallState);
        stringBuffer.append(", Foreground call state: " + this.mForegroundCallState);
        stringBuffer.append(", Background call state: " + this.mBackgroundCallState);
        stringBuffer.append(", Disconnect cause: " + this.mDisconnectCause);
        stringBuffer.append(", Precise disconnect cause: " + this.mPreciseDisconnectCause);
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRingingCallState);
        parcel.writeInt(this.mForegroundCallState);
        parcel.writeInt(this.mBackgroundCallState);
        parcel.writeInt(this.mDisconnectCause);
        parcel.writeInt(this.mPreciseDisconnectCause);
    }
}
