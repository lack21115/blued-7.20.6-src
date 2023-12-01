package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/net/ScoredNetwork.class */
public class ScoredNetwork implements Parcelable {
    public static final Parcelable.Creator<ScoredNetwork> CREATOR = new Parcelable.Creator<ScoredNetwork>() { // from class: android.net.ScoredNetwork.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScoredNetwork createFromParcel(Parcel parcel) {
            return new ScoredNetwork(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ScoredNetwork[] newArray(int i) {
            return new ScoredNetwork[i];
        }
    };
    public final NetworkKey networkKey;
    public final RssiCurve rssiCurve;

    public ScoredNetwork(NetworkKey networkKey, RssiCurve rssiCurve) {
        this.networkKey = networkKey;
        this.rssiCurve = rssiCurve;
    }

    private ScoredNetwork(Parcel parcel) {
        this.networkKey = NetworkKey.CREATOR.createFromParcel(parcel);
        if (parcel.readByte() == 1) {
            this.rssiCurve = RssiCurve.CREATOR.createFromParcel(parcel);
        } else {
            this.rssiCurve = null;
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
        ScoredNetwork scoredNetwork = (ScoredNetwork) obj;
        return Objects.equals(this.networkKey, scoredNetwork.networkKey) && Objects.equals(this.rssiCurve, scoredNetwork.rssiCurve);
    }

    public int hashCode() {
        return Objects.hash(this.networkKey, this.rssiCurve);
    }

    public String toString() {
        return "ScoredNetwork[key=" + this.networkKey + ",score=" + this.rssiCurve + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.networkKey.writeToParcel(parcel, i);
        if (this.rssiCurve == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        this.rssiCurve.writeToParcel(parcel, i);
    }
}
