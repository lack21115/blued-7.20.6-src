package android.telecom;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.telecom.InCallService;
import com.android.internal.telecom.IVideoProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/telecom/ParcelableCall.class */
public final class ParcelableCall implements Parcelable {
    public static final Parcelable.Creator<ParcelableCall> CREATOR = new Parcelable.Creator<ParcelableCall>() { // from class: android.telecom.ParcelableCall.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableCall createFromParcel(Parcel parcel) {
            ClassLoader classLoader = ParcelableCall.class.getClassLoader();
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            DisconnectCause disconnectCause = (DisconnectCause) parcel.readParcelable(classLoader);
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, classLoader);
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            Uri uri = (Uri) parcel.readParcelable(classLoader);
            int readInt4 = parcel.readInt();
            String readString2 = parcel.readString();
            int readInt5 = parcel.readInt();
            GatewayInfo gatewayInfo = (GatewayInfo) parcel.readParcelable(classLoader);
            PhoneAccountHandle phoneAccountHandle = (PhoneAccountHandle) parcel.readParcelable(classLoader);
            IVideoProvider asInterface = IVideoProvider.Stub.asInterface(parcel.readStrongBinder());
            String readString3 = parcel.readString();
            ArrayList arrayList2 = new ArrayList();
            parcel.readList(arrayList2, classLoader);
            StatusHints statusHints = (StatusHints) parcel.readParcelable(classLoader);
            int readInt6 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList();
            parcel.readList(arrayList3, classLoader);
            return new ParcelableCall(readString, readInt, disconnectCause, arrayList, readInt2, readInt3, readLong, readLong2, uri, readInt4, readString2, readInt5, gatewayInfo, phoneAccountHandle, asInterface, readString3, arrayList2, statusHints, readInt6, arrayList3, (Bundle) parcel.readParcelable(classLoader), parcel.readInt() == 1, parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableCall[] newArray(int i) {
            return new ParcelableCall[i];
        }
    };
    private final PhoneAccountHandle mAccountHandle;
    private int mCallSubstate;
    private final String mCallerDisplayName;
    private final int mCallerDisplayNamePresentation;
    private final List<String> mCannedSmsResponses;
    private final int mCapabilities;
    private final List<String> mChildCallIds;
    private final List<String> mConferenceableCallIds;
    private final long mConnectTimeMillis;
    private final long mCreateTimeMillis;
    private final DisconnectCause mDisconnectCause;
    private final Bundle mExtras;
    private final GatewayInfo mGatewayInfo;
    private final Uri mHandle;
    private final int mHandlePresentation;
    private final String mId;
    boolean mIsActiveSub;
    private final String mParentCallId;
    private final int mProperties;
    private final int mState;
    private final StatusHints mStatusHints;
    private InCallService.VideoCall mVideoCall;
    private final IVideoProvider mVideoCallProvider;
    private final int mVideoState;

    public ParcelableCall(String str, int i, DisconnectCause disconnectCause, List<String> list, int i2, int i3, long j, long j2, Uri uri, int i4, String str2, int i5, GatewayInfo gatewayInfo, PhoneAccountHandle phoneAccountHandle, IVideoProvider iVideoProvider, String str3, List<String> list2, StatusHints statusHints, int i6, List<String> list3, Bundle bundle, boolean z, int i7) {
        this.mId = str;
        this.mState = i;
        this.mDisconnectCause = disconnectCause;
        this.mCannedSmsResponses = list;
        this.mCapabilities = i2;
        this.mProperties = i3;
        this.mCreateTimeMillis = j;
        this.mConnectTimeMillis = j2;
        this.mHandle = uri;
        this.mHandlePresentation = i4;
        this.mCallerDisplayName = str2;
        this.mCallerDisplayNamePresentation = i5;
        this.mGatewayInfo = gatewayInfo;
        this.mAccountHandle = phoneAccountHandle;
        this.mVideoCallProvider = iVideoProvider;
        this.mParentCallId = str3;
        this.mChildCallIds = list2;
        this.mStatusHints = statusHints;
        this.mVideoState = i6;
        this.mConferenceableCallIds = Collections.unmodifiableList(list3);
        this.mExtras = bundle;
        this.mIsActiveSub = z;
        this.mCallSubstate = i7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PhoneAccountHandle getAccountHandle() {
        return this.mAccountHandle;
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

    public List<String> getCannedSmsResponses() {
        return this.mCannedSmsResponses;
    }

    public int getCapabilities() {
        return this.mCapabilities;
    }

    public List<String> getChildCallIds() {
        return this.mChildCallIds;
    }

    public List<String> getConferenceableCallIds() {
        return this.mConferenceableCallIds;
    }

    public long getConnectTimeMillis() {
        return this.mConnectTimeMillis;
    }

    public long getCreateTimeMillis() {
        return this.mCreateTimeMillis;
    }

    public DisconnectCause getDisconnectCause() {
        return this.mDisconnectCause;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public GatewayInfo getGatewayInfo() {
        return this.mGatewayInfo;
    }

    public Uri getHandle() {
        return this.mHandle;
    }

    public int getHandlePresentation() {
        return this.mHandlePresentation;
    }

    public String getId() {
        return this.mId;
    }

    public String getParentCallId() {
        return this.mParentCallId;
    }

    public int getProperties() {
        return this.mProperties;
    }

    public int getState() {
        return this.mState;
    }

    public StatusHints getStatusHints() {
        return this.mStatusHints;
    }

    public InCallService.VideoCall getVideoCall() {
        if (this.mVideoCall == null && this.mVideoCallProvider != null) {
            try {
                this.mVideoCall = new VideoCallImpl(this.mVideoCallProvider);
            } catch (RemoteException e) {
            }
        }
        return this.mVideoCall;
    }

    public int getVideoState() {
        return this.mVideoState;
    }

    public String toString() {
        return String.format("[%s, parent:%s, children:%s]", this.mId, this.mParentCallId, this.mChildCallIds);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeInt(this.mState);
        parcel.writeParcelable(this.mDisconnectCause, 0);
        parcel.writeList(this.mCannedSmsResponses);
        parcel.writeInt(this.mCapabilities);
        parcel.writeInt(this.mProperties);
        parcel.writeLong(this.mCreateTimeMillis);
        parcel.writeLong(this.mConnectTimeMillis);
        parcel.writeParcelable(this.mHandle, 0);
        parcel.writeInt(this.mHandlePresentation);
        parcel.writeString(this.mCallerDisplayName);
        parcel.writeInt(this.mCallerDisplayNamePresentation);
        parcel.writeParcelable(this.mGatewayInfo, 0);
        parcel.writeParcelable(this.mAccountHandle, 0);
        parcel.writeStrongBinder(this.mVideoCallProvider != null ? this.mVideoCallProvider.asBinder() : null);
        parcel.writeString(this.mParentCallId);
        parcel.writeList(this.mChildCallIds);
        parcel.writeParcelable(this.mStatusHints, 0);
        parcel.writeInt(this.mVideoState);
        parcel.writeList(this.mConferenceableCallIds);
        parcel.writeParcelable(this.mExtras, 0);
        parcel.writeInt(this.mIsActiveSub ? 1 : 0);
        parcel.writeInt(this.mCallSubstate);
    }
}
