package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkKey.class */
public class NetworkKey implements Parcelable {
    public static final Parcelable.Creator<NetworkKey> CREATOR = new Parcelable.Creator<NetworkKey>() { // from class: android.net.NetworkKey.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkKey createFromParcel(Parcel parcel) {
            return new NetworkKey(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkKey[] newArray(int i) {
            return new NetworkKey[i];
        }
    };
    public static final int TYPE_WIFI = 1;
    public final int type;
    public final WifiKey wifiKey;

    public NetworkKey(WifiKey wifiKey) {
        this.type = 1;
        this.wifiKey = wifiKey;
    }

    private NetworkKey(Parcel parcel) {
        this.type = parcel.readInt();
        switch (this.type) {
            case 1:
                this.wifiKey = WifiKey.CREATOR.createFromParcel(parcel);
                return;
            default:
                throw new IllegalArgumentException("Parcel has unknown type: " + this.type);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NetworkKey networkKey = (NetworkKey) obj;
        return this.type == networkKey.type && Objects.equals(this.wifiKey, networkKey.wifiKey);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.type), this.wifiKey);
    }

    public String toString() {
        switch (this.type) {
            case 1:
                return this.wifiKey.toString();
            default:
                return "InvalidKey";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        switch (this.type) {
            case 1:
                this.wifiKey.writeToParcel(parcel, i);
                return;
            default:
                throw new IllegalStateException("NetworkKey has unknown type " + this.type);
        }
    }
}
