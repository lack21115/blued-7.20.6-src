package android.telephony;

import android.net.LinkProperties;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telephony/PreciseDataConnectionState.class */
public class PreciseDataConnectionState implements Parcelable {
    public static final Parcelable.Creator<PreciseDataConnectionState> CREATOR = new Parcelable.Creator<PreciseDataConnectionState>() { // from class: android.telephony.PreciseDataConnectionState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PreciseDataConnectionState createFromParcel(Parcel parcel) {
            return new PreciseDataConnectionState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PreciseDataConnectionState[] newArray(int i) {
            return new PreciseDataConnectionState[i];
        }
    };
    private String mAPN;
    private String mAPNType;
    private String mFailCause;
    private LinkProperties mLinkProperties;
    private int mNetworkType;
    private String mReason;
    private int mState;

    public PreciseDataConnectionState() {
        this.mState = -1;
        this.mNetworkType = 0;
        this.mAPNType = "";
        this.mAPN = "";
        this.mReason = "";
        this.mLinkProperties = null;
        this.mFailCause = "";
    }

    public PreciseDataConnectionState(int i, int i2, String str, String str2, String str3, LinkProperties linkProperties, String str4) {
        this.mState = -1;
        this.mNetworkType = 0;
        this.mAPNType = "";
        this.mAPN = "";
        this.mReason = "";
        this.mLinkProperties = null;
        this.mFailCause = "";
        this.mState = i;
        this.mNetworkType = i2;
        this.mAPNType = str;
        this.mAPN = str2;
        this.mReason = str3;
        this.mLinkProperties = linkProperties;
        this.mFailCause = str4;
    }

    private PreciseDataConnectionState(Parcel parcel) {
        this.mState = -1;
        this.mNetworkType = 0;
        this.mAPNType = "";
        this.mAPN = "";
        this.mReason = "";
        this.mLinkProperties = null;
        this.mFailCause = "";
        this.mState = parcel.readInt();
        this.mNetworkType = parcel.readInt();
        this.mAPNType = parcel.readString();
        this.mAPN = parcel.readString();
        this.mReason = parcel.readString();
        this.mLinkProperties = (LinkProperties) parcel.readParcelable(null);
        this.mFailCause = parcel.readString();
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
            PreciseDataConnectionState preciseDataConnectionState = (PreciseDataConnectionState) obj;
            if (this.mAPN == null) {
                if (preciseDataConnectionState.mAPN != null) {
                    return false;
                }
            } else if (!this.mAPN.equals(preciseDataConnectionState.mAPN)) {
                return false;
            }
            if (this.mAPNType == null) {
                if (preciseDataConnectionState.mAPNType != null) {
                    return false;
                }
            } else if (!this.mAPNType.equals(preciseDataConnectionState.mAPNType)) {
                return false;
            }
            if (this.mFailCause == null) {
                if (preciseDataConnectionState.mFailCause != null) {
                    return false;
                }
            } else if (!this.mFailCause.equals(preciseDataConnectionState.mFailCause)) {
                return false;
            }
            if (this.mLinkProperties == null) {
                if (preciseDataConnectionState.mLinkProperties != null) {
                    return false;
                }
            } else if (!this.mLinkProperties.equals(preciseDataConnectionState.mLinkProperties)) {
                return false;
            }
            if (this.mNetworkType != preciseDataConnectionState.mNetworkType) {
                return false;
            }
            if (this.mReason == null) {
                if (preciseDataConnectionState.mReason != null) {
                    return false;
                }
            } else if (!this.mReason.equals(preciseDataConnectionState.mReason)) {
                return false;
            }
            return this.mState == preciseDataConnectionState.mState;
        }
        return false;
    }

    public String getDataConnectionAPN() {
        return this.mAPN;
    }

    public String getDataConnectionAPNType() {
        return this.mAPNType;
    }

    public String getDataConnectionChangeReason() {
        return this.mReason;
    }

    public String getDataConnectionFailCause() {
        return this.mFailCause;
    }

    public LinkProperties getDataConnectionLinkProperties() {
        return this.mLinkProperties;
    }

    public int getDataConnectionNetworkType() {
        return this.mNetworkType;
    }

    public int getDataConnectionState() {
        return this.mState;
    }

    public int hashCode() {
        int i = 0;
        int i2 = this.mState;
        int i3 = this.mNetworkType;
        int hashCode = this.mAPNType == null ? 0 : this.mAPNType.hashCode();
        int hashCode2 = this.mAPN == null ? 0 : this.mAPN.hashCode();
        int hashCode3 = this.mReason == null ? 0 : this.mReason.hashCode();
        int hashCode4 = this.mLinkProperties == null ? 0 : this.mLinkProperties.hashCode();
        if (this.mFailCause != null) {
            i = this.mFailCause.hashCode();
        }
        return ((((((((((((i2 + 31) * 31) + i3) * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data Connection state: " + this.mState);
        sb.append(", Network type: " + this.mNetworkType);
        sb.append(", APN type: " + this.mAPNType);
        sb.append(", APN: " + this.mAPN);
        sb.append(", Change reason: " + this.mReason);
        sb.append(", Link properties: " + this.mLinkProperties);
        sb.append(", Fail cause: " + this.mFailCause);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeInt(this.mNetworkType);
        parcel.writeString(this.mAPNType);
        parcel.writeString(this.mAPN);
        parcel.writeString(this.mReason);
        parcel.writeParcelable(this.mLinkProperties, i);
        parcel.writeString(this.mFailCause);
    }
}
