package com.android.ims;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-4181928-dex2jar.jar:com/android/ims/ImsCallProfile.class */
public class ImsCallProfile implements Parcelable {
    public static final int CALL_RESTRICT_CAUSE_DISABLED = 2;
    public static final int CALL_RESTRICT_CAUSE_HD = 3;
    public static final int CALL_RESTRICT_CAUSE_NONE = 0;
    public static final int CALL_RESTRICT_CAUSE_RAT = 1;
    public static final int CALL_TYPE_VIDEO_N_VOICE = 3;
    public static final int CALL_TYPE_VOICE = 2;
    public static final int CALL_TYPE_VOICE_N_VIDEO = 1;
    public static final int CALL_TYPE_VS = 8;
    public static final int CALL_TYPE_VS_RX = 10;
    public static final int CALL_TYPE_VS_TX = 9;
    public static final int CALL_TYPE_VT = 4;
    public static final int CALL_TYPE_VT_NODIR = 7;
    public static final int CALL_TYPE_VT_RX = 6;
    public static final int CALL_TYPE_VT_TX = 5;
    public static final Parcelable.Creator<ImsCallProfile> CREATOR = new Parcelable.Creator<ImsCallProfile>() { // from class: com.android.ims.ImsCallProfile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsCallProfile createFromParcel(Parcel parcel) {
            return new ImsCallProfile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImsCallProfile[] newArray(int i) {
            return new ImsCallProfile[i];
        }
    };
    public static final int DIALSTRING_NORMAL = 0;
    public static final int DIALSTRING_SS_CONF = 1;
    public static final int DIALSTRING_USSD = 2;
    public static final String EXTRA_ADDITIONAL_CALL_INFO = "AdditionalCallInfo";
    public static final String EXTRA_CALL_DOMAIN = "call_domain";
    public static final String EXTRA_CALL_MODE_CHANGEABLE = "call_mode_changeable";
    public static final String EXTRA_CHILD_NUMBER = "ChildNum";
    public static final String EXTRA_CNA = "cna";
    public static final String EXTRA_CNAP = "cnap";
    public static final String EXTRA_CODEC = "Codec";
    public static final String EXTRA_CONFERENCE = "conference";
    public static final String EXTRA_CONFERENCE_AVAIL = "conference_avail";
    public static final String EXTRA_DIALSTRING = "dialstring";
    public static final String EXTRA_DISPLAY_TEXT = "DisplayText";
    public static final String EXTRA_E_CALL = "e_call";
    public static final String EXTRA_OEM_EXTRAS = "OemCallExtras";
    public static final String EXTRA_OI = "oi";
    public static final String EXTRA_OIR = "oir";
    public static final String EXTRA_PARENT_CALL_ID = "parentCallId";
    public static final String EXTRA_REMOTE_URI = "remote_uri";
    public static final String EXTRA_USSD = "ussd";
    public static final String EXTRA_VMS = "vms";
    public static final int OIR_DEFAULT = 0;
    public static final int OIR_PRESENTATION_NOT_RESTRICTED = 2;
    public static final int OIR_PRESENTATION_RESTRICTED = 1;
    public static final int SERVICE_TYPE_EMERGENCY = 2;
    public static final int SERVICE_TYPE_NONE = 0;
    public static final int SERVICE_TYPE_NORMAL = 1;
    private static final String TAG = "ImsCallProfile";
    public Bundle mCallExtras;
    public int mCallType;
    public ImsStreamMediaProfile mMediaProfile;
    public int mRestrictCause;
    public int mServiceType;

    public ImsCallProfile() {
        this.mRestrictCause = 0;
        this.mServiceType = 1;
        this.mCallType = 1;
        this.mCallExtras = new Bundle();
        this.mMediaProfile = new ImsStreamMediaProfile();
    }

    public ImsCallProfile(int i, int i2) {
        this.mRestrictCause = 0;
        this.mServiceType = i;
        this.mCallType = i2;
        this.mCallExtras = new Bundle();
        this.mMediaProfile = new ImsStreamMediaProfile();
    }

    public ImsCallProfile(Parcel parcel) {
        this.mRestrictCause = 0;
        readFromParcel(parcel);
    }

    public static int OIRToPresentation(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                return 3;
        }
    }

    public static int getCallTypeFromVideoState(int i) {
        int i2;
        boolean isVideoStateSet = isVideoStateSet(i, 1);
        boolean isVideoStateSet2 = isVideoStateSet(i, 2);
        if (isVideoStateSet(i, 4)) {
            i2 = 7;
        } else if (isVideoStateSet && !isVideoStateSet2) {
            return 5;
        } else {
            if (!isVideoStateSet && isVideoStateSet2) {
                return 6;
            }
            if (!isVideoStateSet) {
                return 2;
            }
            i2 = 4;
            if (!isVideoStateSet2) {
                return 2;
            }
        }
        return i2;
    }

    public static int getVideoStateFromImsCallProfile(ImsCallProfile imsCallProfile) {
        int i;
        switch (imsCallProfile.mCallType) {
            case 2:
                i = 0;
                break;
            case 3:
            default:
                i = 0;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 1;
                break;
            case 6:
                i = 2;
                break;
        }
        return (!imsCallProfile.isVideoPaused() || i == 0) ? i & (-5) : i | 4;
    }

    private static boolean isVideoStateSet(int i, int i2) {
        return (i & i2) == i2;
    }

    public static int presentationToOIR(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    private void readFromParcel(Parcel parcel) {
        this.mServiceType = parcel.readInt();
        this.mCallType = parcel.readInt();
        this.mCallExtras = (Bundle) parcel.readParcelable(null);
        this.mMediaProfile = (ImsStreamMediaProfile) parcel.readParcelable(null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCallExtra(String str) {
        return getCallExtra(str, "");
    }

    public String getCallExtra(String str, String str2) {
        return this.mCallExtras == null ? str2 : this.mCallExtras.getString(str, str2);
    }

    public boolean getCallExtraBoolean(String str) {
        return getCallExtraBoolean(str, false);
    }

    public boolean getCallExtraBoolean(String str, boolean z) {
        return this.mCallExtras == null ? z : this.mCallExtras.getBoolean(str, z);
    }

    public int getCallExtraInt(String str) {
        return getCallExtraInt(str, -1);
    }

    public int getCallExtraInt(String str, int i) {
        return this.mCallExtras == null ? i : this.mCallExtras.getInt(str, i);
    }

    public boolean isVideoPaused() {
        return this.mMediaProfile.mVideoDirection == 0;
    }

    public void setCallExtra(String str, String str2) {
        if (this.mCallExtras != null) {
            this.mCallExtras.putString(str, str2);
        }
    }

    public void setCallExtraBoolean(String str, boolean z) {
        if (this.mCallExtras != null) {
            this.mCallExtras.putBoolean(str, z);
        }
    }

    public void setCallExtraInt(String str, int i) {
        if (this.mCallExtras != null) {
            this.mCallExtras.putInt(str, i);
        }
    }

    public String toString() {
        return "{ serviceType=" + this.mServiceType + ", callType=" + this.mCallType + ", callExtras=" + this.mCallExtras.toString() + ", mediaProfile=" + this.mMediaProfile.toString() + " }";
    }

    public void updateCallExtras(ImsCallProfile imsCallProfile) {
        this.mCallExtras.clear();
        this.mCallExtras = (Bundle) imsCallProfile.mCallExtras.clone();
    }

    public void updateCallType(ImsCallProfile imsCallProfile) {
        this.mCallType = imsCallProfile.mCallType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mServiceType);
        parcel.writeInt(this.mCallType);
        parcel.writeParcelable(this.mCallExtras, 0);
        parcel.writeParcelable(this.mMediaProfile, 0);
    }
}
