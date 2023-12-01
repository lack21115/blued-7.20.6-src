package android.telecom;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bw;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/DisconnectCause.class */
public final class DisconnectCause implements Parcelable {
    public static final int BUSY = 7;
    public static final int CANCELED = 4;
    public static final int CONNECTION_MANAGER_NOT_SUPPORTED = 10;
    public static final Parcelable.Creator<DisconnectCause> CREATOR = new Parcelable.Creator<DisconnectCause>() { // from class: android.telecom.DisconnectCause.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisconnectCause createFromParcel(Parcel parcel) {
            return new DisconnectCause(parcel.readInt(), TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DisconnectCause[] newArray(int i) {
            return new DisconnectCause[i];
        }
    };
    public static final int ERROR = 1;
    public static final int LOCAL = 2;
    public static final int MISSED = 5;
    public static final int OTHER = 9;
    public static final int REJECTED = 6;
    public static final int REMOTE = 3;
    public static final int RESTRICTED = 8;
    public static final int UNKNOWN = 0;
    private int mDisconnectCode;
    private CharSequence mDisconnectDescription;
    private CharSequence mDisconnectLabel;
    private String mDisconnectReason;
    private int mToneToPlay;

    public DisconnectCause(int i) {
        this(i, null, null, null, -1);
    }

    public DisconnectCause(int i, CharSequence charSequence, CharSequence charSequence2, String str) {
        this(i, charSequence, charSequence2, str, -1);
    }

    public DisconnectCause(int i, CharSequence charSequence, CharSequence charSequence2, String str, int i2) {
        this.mDisconnectCode = i;
        this.mDisconnectLabel = charSequence;
        this.mDisconnectDescription = charSequence2;
        this.mDisconnectReason = str;
        this.mToneToPlay = i2;
    }

    public DisconnectCause(int i, String str) {
        this(i, null, null, str, -1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof DisconnectCause) {
            DisconnectCause disconnectCause = (DisconnectCause) obj;
            z = false;
            if (Objects.equals(Integer.valueOf(this.mDisconnectCode), Integer.valueOf(disconnectCause.getCode()))) {
                z = false;
                if (Objects.equals(this.mDisconnectLabel, disconnectCause.getLabel())) {
                    z = false;
                    if (Objects.equals(this.mDisconnectDescription, disconnectCause.getDescription())) {
                        z = false;
                        if (Objects.equals(this.mDisconnectReason, disconnectCause.getReason())) {
                            z = false;
                            if (Objects.equals(Integer.valueOf(this.mToneToPlay), Integer.valueOf(disconnectCause.getTone()))) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public int getCode() {
        return this.mDisconnectCode;
    }

    public CharSequence getDescription() {
        return this.mDisconnectDescription;
    }

    public CharSequence getLabel() {
        return this.mDisconnectLabel;
    }

    public String getReason() {
        return this.mDisconnectReason;
    }

    public int getTone() {
        return this.mToneToPlay;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDisconnectCode)) + Objects.hashCode(this.mDisconnectLabel) + Objects.hashCode(this.mDisconnectDescription) + Objects.hashCode(this.mDisconnectReason) + Objects.hashCode(Integer.valueOf(this.mToneToPlay));
    }

    public String toString() {
        String str;
        switch (getCode()) {
            case 1:
                str = bw.l;
                break;
            case 2:
                str = CalendarContract.ACCOUNT_TYPE_LOCAL;
                break;
            case 3:
                str = "REMOTE";
                break;
            case 4:
            default:
                str = "UNKNOWN";
                break;
            case 5:
                str = "MISSED";
                break;
            case 6:
                str = "REJECTED";
                break;
            case 7:
                str = "BUSY";
                break;
            case 8:
                str = "RESTRICTED";
                break;
            case 9:
                str = "OTHER";
                break;
        }
        String charSequence = this.mDisconnectLabel == null ? "" : this.mDisconnectLabel.toString();
        return "DisconnectCause [ Code: (" + str + ") Label: (" + charSequence + ") Description: (" + (this.mDisconnectDescription == null ? "" : this.mDisconnectDescription.toString()) + ") Reason: (" + (this.mDisconnectReason == null ? "" : this.mDisconnectReason) + ") Tone: (" + this.mToneToPlay + ") ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mDisconnectCode);
        TextUtils.writeToParcel(this.mDisconnectLabel, parcel, i);
        TextUtils.writeToParcel(this.mDisconnectDescription, parcel, i);
        parcel.writeString(this.mDisconnectReason);
        parcel.writeInt(this.mToneToPlay);
    }
}
