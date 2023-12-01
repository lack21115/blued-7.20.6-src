package android.net;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkState.class */
public class NetworkState implements Parcelable {
    public static final Parcelable.Creator<NetworkState> CREATOR = new Parcelable.Creator<NetworkState>() { // from class: android.net.NetworkState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkState createFromParcel(Parcel parcel) {
            return new NetworkState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkState[] newArray(int i) {
            return new NetworkState[i];
        }
    };
    public final LinkProperties linkProperties;
    public final Network network;
    public final NetworkCapabilities networkCapabilities;
    public final String networkId;
    public final NetworkInfo networkInfo;
    public final String subscriberId;

    public NetworkState(NetworkInfo networkInfo, LinkProperties linkProperties, NetworkCapabilities networkCapabilities, Network network, String str, String str2) {
        this.networkInfo = networkInfo;
        this.linkProperties = linkProperties;
        this.networkCapabilities = networkCapabilities;
        this.network = network;
        this.subscriberId = str;
        this.networkId = str2;
    }

    public NetworkState(Parcel parcel) {
        this.networkInfo = (NetworkInfo) parcel.readParcelable(null);
        this.linkProperties = (LinkProperties) parcel.readParcelable(null);
        this.networkCapabilities = (NetworkCapabilities) parcel.readParcelable(null);
        this.network = (Network) parcel.readParcelable(null);
        this.subscriberId = parcel.readString();
        this.networkId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.networkInfo, i);
        parcel.writeParcelable(this.linkProperties, i);
        parcel.writeParcelable(this.networkCapabilities, i);
        parcel.writeParcelable(this.network, i);
        parcel.writeString(this.subscriberId);
        parcel.writeString(this.networkId);
    }
}
