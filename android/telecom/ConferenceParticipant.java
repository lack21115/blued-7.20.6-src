package android.telecom;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/ConferenceParticipant.class */
public class ConferenceParticipant implements Parcelable {
    public static final Parcelable.Creator<ConferenceParticipant> CREATOR = new Parcelable.Creator<ConferenceParticipant>() { // from class: android.telecom.ConferenceParticipant.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConferenceParticipant createFromParcel(Parcel parcel) {
            ClassLoader classLoader = ParcelableCall.class.getClassLoader();
            return new ConferenceParticipant((Uri) parcel.readParcelable(classLoader), parcel.readString(), (Uri) parcel.readParcelable(classLoader), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConferenceParticipant[] newArray(int i) {
            return new ConferenceParticipant[i];
        }
    };
    private final String mDisplayName;
    private final Uri mEndpoint;
    private final Uri mHandle;
    private final int mState;

    public ConferenceParticipant(Uri uri, String str, Uri uri2, int i) {
        this.mHandle = uri;
        this.mDisplayName = str;
        this.mEndpoint = uri2;
        this.mState = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public Uri getEndpoint() {
        return this.mEndpoint;
    }

    public Uri getHandle() {
        return this.mHandle;
    }

    public int getState() {
        return this.mState;
    }

    public String toString() {
        return "[ConferenceParticipant Handle: " + this.mHandle + " DisplayName: " + this.mDisplayName + " Endpoint: " + this.mEndpoint + " State: " + this.mState + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mHandle, 0);
        parcel.writeString(this.mDisplayName);
        parcel.writeParcelable(this.mEndpoint, 0);
        parcel.writeInt(this.mState);
    }
}
