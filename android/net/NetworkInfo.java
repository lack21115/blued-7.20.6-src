package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.EnumMap;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkInfo.class */
public class NetworkInfo implements Parcelable {
    public static final Parcelable.Creator<NetworkInfo> CREATOR;
    private static final EnumMap<DetailedState, State> stateMap = new EnumMap<>(DetailedState.class);
    private DetailedState mDetailedState;
    private String mExtraInfo;
    private boolean mIsAvailable;
    private boolean mIsConnectedToProvisioningNetwork;
    private boolean mIsFailover;
    private boolean mIsRoaming;
    private int mNetworkType;
    private String mReason;
    private State mState;
    private int mSubtype;
    private String mSubtypeName;
    private String mTypeName;

    /* loaded from: source-9557208-dex2jar.jar:android/net/NetworkInfo$DetailedState.class */
    public enum DetailedState {
        IDLE,
        SCANNING,
        CONNECTING,
        AUTHENTICATING,
        OBTAINING_IPADDR,
        CONNECTED,
        SUSPENDED,
        DISCONNECTING,
        DISCONNECTED,
        FAILED,
        BLOCKED,
        VERIFYING_POOR_LINK,
        CAPTIVE_PORTAL_CHECK
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/NetworkInfo$State.class */
    public enum State {
        CONNECTING,
        CONNECTED,
        SUSPENDED,
        DISCONNECTING,
        DISCONNECTED,
        UNKNOWN
    }

    static {
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.IDLE, (DetailedState) State.DISCONNECTED);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.SCANNING, (DetailedState) State.DISCONNECTED);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.CONNECTING, (DetailedState) State.CONNECTING);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.AUTHENTICATING, (DetailedState) State.CONNECTING);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.OBTAINING_IPADDR, (DetailedState) State.CONNECTING);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.VERIFYING_POOR_LINK, (DetailedState) State.CONNECTING);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.CAPTIVE_PORTAL_CHECK, (DetailedState) State.CONNECTING);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.CONNECTED, (DetailedState) State.CONNECTED);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.SUSPENDED, (DetailedState) State.SUSPENDED);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.DISCONNECTING, (DetailedState) State.DISCONNECTING);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.DISCONNECTED, (DetailedState) State.DISCONNECTED);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.FAILED, (DetailedState) State.DISCONNECTED);
        stateMap.put((EnumMap<DetailedState, State>) DetailedState.BLOCKED, (DetailedState) State.DISCONNECTED);
        CREATOR = new Parcelable.Creator<NetworkInfo>() { // from class: android.net.NetworkInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NetworkInfo createFromParcel(Parcel parcel) {
                NetworkInfo networkInfo = new NetworkInfo(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString());
                networkInfo.mState = State.valueOf(parcel.readString());
                networkInfo.mDetailedState = DetailedState.valueOf(parcel.readString());
                networkInfo.mIsFailover = parcel.readInt() != 0;
                networkInfo.mIsAvailable = parcel.readInt() != 0;
                networkInfo.mIsRoaming = parcel.readInt() != 0;
                networkInfo.mIsConnectedToProvisioningNetwork = parcel.readInt() != 0;
                networkInfo.mReason = parcel.readString();
                networkInfo.mExtraInfo = parcel.readString();
                return networkInfo;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public NetworkInfo[] newArray(int i) {
                return new NetworkInfo[i];
            }
        };
    }

    public NetworkInfo(int i, int i2, String str, String str2) {
        if (!ConnectivityManager.isNetworkTypeValid(i)) {
            throw new IllegalArgumentException("Invalid network type: " + i);
        }
        this.mNetworkType = i;
        this.mSubtype = i2;
        this.mTypeName = str;
        this.mSubtypeName = str2;
        setDetailedState(DetailedState.IDLE, null, null);
        this.mState = State.UNKNOWN;
        this.mIsAvailable = false;
        this.mIsRoaming = false;
        this.mIsConnectedToProvisioningNetwork = false;
    }

    public NetworkInfo(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            synchronized (networkInfo) {
                this.mNetworkType = networkInfo.mNetworkType;
                this.mSubtype = networkInfo.mSubtype;
                this.mTypeName = networkInfo.mTypeName;
                this.mSubtypeName = networkInfo.mSubtypeName;
                this.mState = networkInfo.mState;
                this.mDetailedState = networkInfo.mDetailedState;
                this.mReason = networkInfo.mReason;
                this.mExtraInfo = networkInfo.mExtraInfo;
                this.mIsFailover = networkInfo.mIsFailover;
                this.mIsRoaming = networkInfo.mIsRoaming;
                this.mIsAvailable = networkInfo.mIsAvailable;
                this.mIsConnectedToProvisioningNetwork = networkInfo.mIsConnectedToProvisioningNetwork;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DetailedState getDetailedState() {
        DetailedState detailedState;
        synchronized (this) {
            detailedState = this.mDetailedState;
        }
        return detailedState;
    }

    public String getExtraInfo() {
        String str;
        synchronized (this) {
            str = this.mExtraInfo;
        }
        return str;
    }

    public String getReason() {
        String str;
        synchronized (this) {
            str = this.mReason;
        }
        return str;
    }

    public State getState() {
        State state;
        synchronized (this) {
            state = this.mState;
        }
        return state;
    }

    public int getSubtype() {
        int i;
        synchronized (this) {
            i = this.mSubtype;
        }
        return i;
    }

    public String getSubtypeName() {
        String str;
        synchronized (this) {
            str = this.mSubtypeName;
        }
        return str;
    }

    public int getType() {
        int i;
        synchronized (this) {
            i = this.mNetworkType;
        }
        return i;
    }

    public String getTypeName() {
        String str;
        synchronized (this) {
            str = this.mTypeName;
        }
        return str;
    }

    public boolean isAvailable() {
        boolean z;
        synchronized (this) {
            z = this.mIsAvailable;
        }
        return z;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this) {
            z = this.mState == State.CONNECTED;
        }
        return z;
    }

    public boolean isConnectedOrConnecting() {
        boolean z;
        synchronized (this) {
            if (this.mState != State.CONNECTED && this.mState != State.CONNECTING) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    public boolean isConnectedToProvisioningNetwork() {
        boolean z;
        synchronized (this) {
            z = this.mIsConnectedToProvisioningNetwork;
        }
        return z;
    }

    public boolean isFailover() {
        boolean z;
        synchronized (this) {
            z = this.mIsFailover;
        }
        return z;
    }

    public boolean isRoaming() {
        boolean z;
        synchronized (this) {
            z = this.mIsRoaming;
        }
        return z;
    }

    public void setDetailedState(DetailedState detailedState, String str, String str2) {
        synchronized (this) {
            this.mDetailedState = detailedState;
            this.mState = stateMap.get(detailedState);
            this.mReason = str;
            this.mExtraInfo = str2;
        }
    }

    public void setExtraInfo(String str) {
        synchronized (this) {
            this.mExtraInfo = str;
        }
    }

    public void setFailover(boolean z) {
        synchronized (this) {
            this.mIsFailover = z;
        }
    }

    public void setIsAvailable(boolean z) {
        synchronized (this) {
            this.mIsAvailable = z;
        }
    }

    public void setIsConnectedToProvisioningNetwork(boolean z) {
        synchronized (this) {
            this.mIsConnectedToProvisioningNetwork = z;
        }
    }

    public void setRoaming(boolean z) {
        synchronized (this) {
            this.mIsRoaming = z;
        }
    }

    public void setSubtype(int i, String str) {
        synchronized (this) {
            this.mSubtype = i;
            this.mSubtypeName = str;
        }
    }

    public void setType(int i) {
        synchronized (this) {
            this.mNetworkType = i;
        }
    }

    public String toString() {
        String sb;
        synchronized (this) {
            StringBuilder sb2 = new StringBuilder("[");
            sb2.append("type: ").append(getTypeName()).append("[").append(getSubtypeName()).append("], state: ").append(this.mState).append("/").append(this.mDetailedState).append(", reason: ").append(this.mReason == null ? "(unspecified)" : this.mReason).append(", extra: ").append(this.mExtraInfo == null ? "(none)" : this.mExtraInfo).append(", roaming: ").append(this.mIsRoaming).append(", failover: ").append(this.mIsFailover).append(", isAvailable: ").append(this.mIsAvailable).append(", isConnectedToProvisioningNetwork: ").append(this.mIsConnectedToProvisioningNetwork).append("]");
            sb = sb2.toString();
        }
        return sb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            parcel.writeInt(this.mNetworkType);
            parcel.writeInt(this.mSubtype);
            parcel.writeString(this.mTypeName);
            parcel.writeString(this.mSubtypeName);
            parcel.writeString(this.mState.name());
            parcel.writeString(this.mDetailedState.name());
            parcel.writeInt(this.mIsFailover ? 1 : 0);
            parcel.writeInt(this.mIsAvailable ? 1 : 0);
            parcel.writeInt(this.mIsRoaming ? 1 : 0);
            parcel.writeInt(this.mIsConnectedToProvisioningNetwork ? 1 : 0);
            parcel.writeString(this.mReason);
            parcel.writeString(this.mExtraInfo);
        }
    }
}
