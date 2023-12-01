package android.net;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkRequest.class */
public class NetworkRequest implements Parcelable {
    public static final Parcelable.Creator<NetworkRequest> CREATOR = new Parcelable.Creator<NetworkRequest>() { // from class: android.net.NetworkRequest.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkRequest createFromParcel(Parcel parcel) {
            return new NetworkRequest((NetworkCapabilities) parcel.readParcelable(null), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkRequest[] newArray(int i) {
            return new NetworkRequest[i];
        }
    };
    public final int legacyType;
    public final NetworkCapabilities networkCapabilities;
    public final int requestId;

    /* loaded from: source-9557208-dex2jar.jar:android/net/NetworkRequest$Builder.class */
    public static class Builder {
        private final NetworkCapabilities mNetworkCapabilities = new NetworkCapabilities();

        public Builder addCapability(int i) {
            this.mNetworkCapabilities.addCapability(i);
            return this;
        }

        public Builder addTransportType(int i) {
            this.mNetworkCapabilities.addTransportType(i);
            return this;
        }

        public NetworkRequest build() {
            NetworkCapabilities networkCapabilities = new NetworkCapabilities(this.mNetworkCapabilities);
            networkCapabilities.maybeMarkCapabilitiesRestricted();
            return new NetworkRequest(networkCapabilities, -1, 0);
        }

        public Builder removeCapability(int i) {
            this.mNetworkCapabilities.removeCapability(i);
            return this;
        }

        public Builder removeTransportType(int i) {
            this.mNetworkCapabilities.removeTransportType(i);
            return this;
        }

        public Builder setLinkDownstreamBandwidthKbps(int i) {
            this.mNetworkCapabilities.setLinkDownstreamBandwidthKbps(i);
            return this;
        }

        public Builder setLinkUpstreamBandwidthKbps(int i) {
            this.mNetworkCapabilities.setLinkUpstreamBandwidthKbps(i);
            return this;
        }

        public Builder setNetworkSpecifier(String str) {
            this.mNetworkCapabilities.setNetworkSpecifier(str);
            return this;
        }
    }

    public NetworkRequest(NetworkCapabilities networkCapabilities, int i, int i2) {
        if (networkCapabilities == null) {
            throw new NullPointerException();
        }
        this.requestId = i2;
        this.networkCapabilities = networkCapabilities;
        this.legacyType = i;
    }

    public NetworkRequest(NetworkRequest networkRequest) {
        this.networkCapabilities = new NetworkCapabilities(networkRequest.networkCapabilities);
        this.requestId = networkRequest.requestId;
        this.legacyType = networkRequest.legacyType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NetworkRequest) {
            NetworkRequest networkRequest = (NetworkRequest) obj;
            if (networkRequest.legacyType == this.legacyType && networkRequest.requestId == this.requestId) {
                if (networkRequest.networkCapabilities == null && this.networkCapabilities == null) {
                    return true;
                }
                return networkRequest.networkCapabilities != null && networkRequest.networkCapabilities.equals(this.networkCapabilities);
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return this.requestId + (this.legacyType * 1013) + (this.networkCapabilities.hashCode() * 1051);
    }

    public String toString() {
        return "NetworkRequest [ id=" + this.requestId + ", legacyType=" + this.legacyType + ", " + this.networkCapabilities.toString() + " ]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.networkCapabilities, i);
        parcel.writeInt(this.legacyType);
        parcel.writeInt(this.requestId);
    }
}
