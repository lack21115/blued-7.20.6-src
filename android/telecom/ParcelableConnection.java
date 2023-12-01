package android.telecom;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.telecom.IVideoProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/ParcelableConnection.class */
public final class ParcelableConnection implements Parcelable {
    public static final Parcelable.Creator<ParcelableConnection> CREATOR = new Parcelable.Creator<ParcelableConnection>() { // from class: android.telecom.ParcelableConnection.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableConnection createFromParcel(Parcel parcel) {
            ClassLoader classLoader = ParcelableConnection.class.getClassLoader();
            PhoneAccountHandle phoneAccountHandle = (PhoneAccountHandle) parcel.readParcelable(classLoader);
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            Uri uri = (Uri) parcel.readParcelable(classLoader);
            int readInt4 = parcel.readInt();
            String readString = parcel.readString();
            int readInt5 = parcel.readInt();
            IVideoProvider asInterface = IVideoProvider.Stub.asInterface(parcel.readStrongBinder());
            int readInt6 = parcel.readInt();
            boolean z = parcel.readByte() == 1;
            boolean z2 = parcel.readByte() == 1;
            StatusHints statusHints = (StatusHints) parcel.readParcelable(classLoader);
            DisconnectCause disconnectCause = (DisconnectCause) parcel.readParcelable(classLoader);
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            return new ParcelableConnection(phoneAccountHandle, readInt, readInt2, readInt3, uri, readInt4, readString, readInt5, asInterface, readInt6, z, z2, statusHints, disconnectCause, arrayList, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableConnection[] newArray(int i) {
            return new ParcelableConnection[i];
        }
    };
    private final Uri mAddress;
    private final int mAddressPresentation;
    private final int mCallSubstate;
    private final String mCallerDisplayName;
    private final int mCallerDisplayNamePresentation;
    private final List<String> mConferenceableConnectionIds;
    private final int mConnectionCapabilities;
    private final DisconnectCause mDisconnectCause;
    private final boolean mIsVoipAudioMode;
    private final PhoneAccountHandle mPhoneAccount;
    private final int mProperties;
    private final boolean mRingbackRequested;
    private final int mState;
    private final StatusHints mStatusHints;
    private final IVideoProvider mVideoProvider;
    private final int mVideoState;

    public ParcelableConnection(PhoneAccountHandle phoneAccountHandle, int i, int i2, int i3, Uri uri, int i4, String str, int i5, IVideoProvider iVideoProvider, int i6, boolean z, boolean z2, StatusHints statusHints, DisconnectCause disconnectCause, List<String> list, int i7) {
        this.mPhoneAccount = phoneAccountHandle;
        this.mState = i;
        this.mConnectionCapabilities = i2;
        this.mProperties = i3;
        this.mAddress = uri;
        this.mAddressPresentation = i4;
        this.mCallerDisplayName = str;
        this.mCallerDisplayNamePresentation = i5;
        this.mVideoProvider = iVideoProvider;
        this.mVideoState = i6;
        this.mRingbackRequested = z;
        this.mIsVoipAudioMode = z2;
        this.mStatusHints = statusHints;
        this.mDisconnectCause = disconnectCause;
        this.mConferenceableConnectionIds = list;
        this.mCallSubstate = i7;
    }

    public ParcelableConnection(PhoneAccountHandle phoneAccountHandle, int i, int i2, Uri uri, int i3, String str, int i4, IVideoProvider iVideoProvider, int i5, boolean z, boolean z2, StatusHints statusHints, DisconnectCause disconnectCause, List<String> list, int i6) {
        this.mPhoneAccount = phoneAccountHandle;
        this.mState = i;
        this.mConnectionCapabilities = i2;
        this.mProperties = 0;
        this.mAddress = uri;
        this.mAddressPresentation = i3;
        this.mCallerDisplayName = str;
        this.mCallerDisplayNamePresentation = i4;
        this.mVideoProvider = iVideoProvider;
        this.mVideoState = i5;
        this.mRingbackRequested = z;
        this.mIsVoipAudioMode = z2;
        this.mStatusHints = statusHints;
        this.mDisconnectCause = disconnectCause;
        this.mConferenceableConnectionIds = list;
        this.mCallSubstate = i6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCallSubstate() {
        return this.mCallSubstate;
    }

    public String getCallerDisplayName() {
        return this.mCallerDisplayName;
    }

    public int getCallerDisplayNamePresentation() {
        return this.mCallerDisplayNamePresentation;
    }

    public final List<String> getConferenceableConnectionIds() {
        return this.mConferenceableConnectionIds;
    }

    public int getConnectionCapabilities() {
        return this.mConnectionCapabilities;
    }

    public final DisconnectCause getDisconnectCause() {
        return this.mDisconnectCause;
    }

    public Uri getHandle() {
        return this.mAddress;
    }

    public int getHandlePresentation() {
        return this.mAddressPresentation;
    }

    public boolean getIsVoipAudioMode() {
        return this.mIsVoipAudioMode;
    }

    public PhoneAccountHandle getPhoneAccount() {
        return this.mPhoneAccount;
    }

    public int getProperties() {
        return this.mProperties;
    }

    public int getState() {
        return this.mState;
    }

    public final StatusHints getStatusHints() {
        return this.mStatusHints;
    }

    public IVideoProvider getVideoProvider() {
        return this.mVideoProvider;
    }

    public int getVideoState() {
        return this.mVideoState;
    }

    public boolean isRingbackRequested() {
        return this.mRingbackRequested;
    }

    public String toString() {
        return "ParcelableConnection [act:" + this.mPhoneAccount + ", state:" + this.mState + ", capabilities:" + Connection.capabilitiesToString(this.mConnectionCapabilities) + ", properties:" + Integer.toHexString(this.mProperties);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mPhoneAccount, 0);
        parcel.writeInt(this.mState);
        parcel.writeInt(this.mConnectionCapabilities);
        parcel.writeInt(this.mProperties);
        parcel.writeParcelable(this.mAddress, 0);
        parcel.writeInt(this.mAddressPresentation);
        parcel.writeString(this.mCallerDisplayName);
        parcel.writeInt(this.mCallerDisplayNamePresentation);
        parcel.writeStrongBinder(this.mVideoProvider != null ? this.mVideoProvider.asBinder() : null);
        parcel.writeInt(this.mVideoState);
        parcel.writeByte((byte) (this.mRingbackRequested ? 1 : 0));
        parcel.writeByte((byte) (this.mIsVoipAudioMode ? 1 : 0));
        parcel.writeParcelable(this.mStatusHints, 0);
        parcel.writeParcelable(this.mDisconnectCause, 0);
        parcel.writeStringList(this.mConferenceableConnectionIds);
        parcel.writeInt(this.mCallSubstate);
    }
}
