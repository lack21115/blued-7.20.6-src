package com.android.ims;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: source-4181928-dex2jar.jar:com/android/ims/ImsConferenceState.class */
public class ImsConferenceState implements Parcelable {
    public static final Parcelable.Creator<ImsConferenceState> CREATOR = new Parcelable.Creator<ImsConferenceState>() { // from class: com.android.ims.ImsConferenceState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsConferenceState createFromParcel(Parcel parcel) {
            return new ImsConferenceState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsConferenceState[] newArray(int i) {
            return new ImsConferenceState[i];
        }
    };
    public static final String DISPLAY_TEXT = "display-text";
    public static final String ENDPOINT = "endpoint";
    public static final String SIP_STATUS_CODE = "sipstatuscode";
    public static final String STATUS = "status";
    public static final String STATUS_ALERTING = "alerting";
    public static final String STATUS_CONNECTED = "connected";
    public static final String STATUS_CONNECT_FAIL = "connect-fail";
    public static final String STATUS_DIALING_IN = "dialing-in";
    public static final String STATUS_DIALING_OUT = "dialing-out";
    public static final String STATUS_DISCONNECTED = "disconnected";
    public static final String STATUS_DISCONNECTING = "disconnecting";
    public static final String STATUS_MUTED_VIA_FOCUS = "muted-via-focus";
    public static final String STATUS_ON_HOLD = "on-hold";
    public static final String STATUS_PENDING = "pending";
    public static final String USER = "user";
    public HashMap<String, Bundle> mParticipants = new HashMap<>();

    public ImsConferenceState() {
    }

    public ImsConferenceState(Parcel parcel) {
        readFromParcel(parcel);
    }

    public static int getConnectionStateForStatus(String str) {
        int i;
        if (str.equals(STATUS_PENDING)) {
            i = 0;
        } else if (str.equals(STATUS_DIALING_IN)) {
            return 2;
        } else {
            if (str.equals(STATUS_ALERTING) || str.equals(STATUS_DIALING_OUT)) {
                return 3;
            }
            if (str.equals(STATUS_ON_HOLD)) {
                return 5;
            }
            i = 4;
            if (!str.equals(STATUS_CONNECTED)) {
                i = 4;
                if (!str.equals(STATUS_MUTED_VIA_FOCUS)) {
                    i = 4;
                    if (!str.equals(STATUS_DISCONNECTING)) {
                        i = 4;
                        if (str.equals(STATUS_DISCONNECTED)) {
                            return 6;
                        }
                    }
                }
            }
        }
        return i;
    }

    private void readFromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= readInt) {
                return;
            }
            this.mParticipants.put(parcel.readString(), (Bundle) parcel.readParcelable(null));
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Set<Map.Entry<String, Bundle>> entrySet;
        parcel.writeInt(this.mParticipants.size());
        if (this.mParticipants.size() <= 0 || (entrySet = this.mParticipants.entrySet()) == null) {
            return;
        }
        for (Map.Entry<String, Bundle> entry : entrySet) {
            parcel.writeString(entry.getKey());
            parcel.writeParcelable(entry.getValue(), 0);
        }
    }
}
