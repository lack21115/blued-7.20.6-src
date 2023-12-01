package android.telecom;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/ConnectionRequest.class */
public final class ConnectionRequest implements Parcelable {
    public static final Parcelable.Creator<ConnectionRequest> CREATOR = new Parcelable.Creator<ConnectionRequest>() { // from class: android.telecom.ConnectionRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConnectionRequest createFromParcel(Parcel parcel) {
            return new ConnectionRequest(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConnectionRequest[] newArray(int i) {
            return new ConnectionRequest[i];
        }
    };
    private final PhoneAccountHandle mAccountHandle;
    private final Uri mAddress;
    private final Bundle mExtras;
    private final int mVideoState;

    private ConnectionRequest(Parcel parcel) {
        this.mAccountHandle = (PhoneAccountHandle) parcel.readParcelable(getClass().getClassLoader());
        this.mAddress = (Uri) parcel.readParcelable(getClass().getClassLoader());
        this.mExtras = (Bundle) parcel.readParcelable(getClass().getClassLoader());
        this.mVideoState = parcel.readInt();
    }

    public ConnectionRequest(PhoneAccountHandle phoneAccountHandle, Uri uri, Bundle bundle) {
        this(phoneAccountHandle, uri, bundle, 0);
    }

    public ConnectionRequest(PhoneAccountHandle phoneAccountHandle, Uri uri, Bundle bundle, int i) {
        this.mAccountHandle = phoneAccountHandle;
        this.mAddress = uri;
        this.mExtras = bundle;
        this.mVideoState = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PhoneAccountHandle getAccountHandle() {
        return this.mAccountHandle;
    }

    public Uri getAddress() {
        return this.mAddress;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getVideoState() {
        return this.mVideoState;
    }

    public String toString() {
        return String.format("ConnectionRequest %s %s", this.mAddress == null ? Uri.EMPTY : Connection.toLogSafePhoneNumber(this.mAddress.toString()), this.mExtras == null ? "" : this.mExtras);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAccountHandle, 0);
        parcel.writeParcelable(this.mAddress, 0);
        parcel.writeParcelable(this.mExtras, 0);
        parcel.writeInt(this.mVideoState);
    }
}
