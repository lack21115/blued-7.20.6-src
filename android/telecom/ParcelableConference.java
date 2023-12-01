package android.telecom;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.internal.telecom.IVideoProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/ParcelableConference.class */
public final class ParcelableConference implements Parcelable {
    public static final Parcelable.Creator<ParcelableConference> CREATOR = new Parcelable.Creator<ParcelableConference>() { // from class: android.telecom.ParcelableConference.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableConference createFromParcel(Parcel parcel) {
            ClassLoader classLoader = ParcelableConference.class.getClassLoader();
            PhoneAccountHandle phoneAccountHandle = (PhoneAccountHandle) parcel.readParcelable(classLoader);
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(2);
            parcel.readList(arrayList, classLoader);
            return new ParcelableConference(phoneAccountHandle, readInt, readInt2, arrayList, IVideoProvider.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readLong());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableConference[] newArray(int i) {
            return new ParcelableConference[i];
        }
    };
    private long mConnectTimeMillis;
    private int mConnectionCapabilities;
    private List<String> mConnectionIds;
    private PhoneAccountHandle mPhoneAccount;
    private int mState;
    private final IVideoProvider mVideoProvider;
    private final int mVideoState;

    public ParcelableConference(PhoneAccountHandle phoneAccountHandle, int i, int i2, List<String> list, IVideoProvider iVideoProvider, int i3) {
        this(phoneAccountHandle, i, i2, list, iVideoProvider, i3, 0L);
    }

    public ParcelableConference(PhoneAccountHandle phoneAccountHandle, int i, int i2, List<String> list, IVideoProvider iVideoProvider, int i3, long j) {
        this.mConnectTimeMillis = 1000L;
        this.mPhoneAccount = phoneAccountHandle;
        this.mState = i;
        this.mConnectionCapabilities = i2;
        this.mConnectionIds = list;
        this.mVideoProvider = iVideoProvider;
        this.mVideoState = i3;
        this.mConnectTimeMillis = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getConnectTimeMillis() {
        return this.mConnectTimeMillis;
    }

    public int getConnectionCapabilities() {
        return this.mConnectionCapabilities;
    }

    public List<String> getConnectionIds() {
        return this.mConnectionIds;
    }

    public PhoneAccountHandle getPhoneAccount() {
        return this.mPhoneAccount;
    }

    public int getState() {
        return this.mState;
    }

    public IVideoProvider getVideoProvider() {
        return this.mVideoProvider;
    }

    public int getVideoState() {
        return this.mVideoState;
    }

    public String toString() {
        return new StringBuffer().append("account: ").append(this.mPhoneAccount).append(", state: ").append(Connection.stateToString(this.mState)).append(", capabilities: ").append(", connectTime: ").append(this.mConnectTimeMillis).append(Connection.capabilitiesToString(this.mConnectionCapabilities)).append(", children: ").append(this.mConnectionIds).append(", VideoState: ").append(this.mVideoState).append(", VideoProvider: ").append(this.mVideoProvider).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mPhoneAccount, 0);
        parcel.writeInt(this.mState);
        parcel.writeInt(this.mConnectionCapabilities);
        parcel.writeList(this.mConnectionIds);
        parcel.writeStrongBinder(this.mVideoProvider != null ? this.mVideoProvider.asBinder() : null);
        parcel.writeInt(this.mVideoState);
        parcel.writeLong(this.mConnectTimeMillis);
    }
}
