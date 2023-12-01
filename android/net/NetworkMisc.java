package android.net;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkMisc.class */
public class NetworkMisc implements Parcelable {
    public static final Parcelable.Creator<NetworkMisc> CREATOR = new Parcelable.Creator<NetworkMisc>() { // from class: android.net.NetworkMisc.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkMisc createFromParcel(Parcel parcel) {
            NetworkMisc networkMisc = new NetworkMisc();
            networkMisc.allowBypass = parcel.readInt() != 0;
            networkMisc.explicitlySelected = parcel.readInt() != 0;
            networkMisc.subscriberId = parcel.readString();
            return networkMisc;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkMisc[] newArray(int i) {
            return new NetworkMisc[i];
        }
    };
    public boolean allowBypass;
    public boolean explicitlySelected;
    public String subscriberId;

    public NetworkMisc() {
    }

    public NetworkMisc(NetworkMisc networkMisc) {
        if (networkMisc != null) {
            this.allowBypass = networkMisc.allowBypass;
            this.explicitlySelected = networkMisc.explicitlySelected;
            this.subscriberId = networkMisc.subscriberId;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.allowBypass ? 1 : 0);
        parcel.writeInt(this.explicitlySelected ? 1 : 0);
        parcel.writeString(this.subscriberId);
    }
}
