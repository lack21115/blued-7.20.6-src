package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: source-9557208-dex2jar.jar:android/net/RssiCurve.class */
public class RssiCurve implements Parcelable {
    public static final Parcelable.Creator<RssiCurve> CREATOR = new Parcelable.Creator<RssiCurve>() { // from class: android.net.RssiCurve.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RssiCurve createFromParcel(Parcel parcel) {
            return new RssiCurve(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RssiCurve[] newArray(int i) {
            return new RssiCurve[i];
        }
    };
    private static final int DEFAULT_ACTIVE_NETWORK_RSSI_BOOST = 25;
    public final int activeNetworkRssiBoost;
    public final int bucketWidth;
    public final byte[] rssiBuckets;
    public final int start;

    public RssiCurve(int i, int i2, byte[] bArr) {
        this(i, i2, bArr, 25);
    }

    public RssiCurve(int i, int i2, byte[] bArr, int i3) {
        this.start = i;
        this.bucketWidth = i2;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("rssiBuckets must be at least one element large.");
        }
        this.rssiBuckets = bArr;
        this.activeNetworkRssiBoost = i3;
    }

    private RssiCurve(Parcel parcel) {
        this.start = parcel.readInt();
        this.bucketWidth = parcel.readInt();
        this.rssiBuckets = new byte[parcel.readInt()];
        parcel.readByteArray(this.rssiBuckets);
        this.activeNetworkRssiBoost = parcel.readInt();
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
        RssiCurve rssiCurve = (RssiCurve) obj;
        return this.start == rssiCurve.start && this.bucketWidth == rssiCurve.bucketWidth && Arrays.equals(this.rssiBuckets, rssiCurve.rssiBuckets) && this.activeNetworkRssiBoost == rssiCurve.activeNetworkRssiBoost;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.start), Integer.valueOf(this.bucketWidth), this.rssiBuckets, Integer.valueOf(this.activeNetworkRssiBoost));
    }

    public byte lookupScore(int i) {
        return lookupScore(i, false);
    }

    public byte lookupScore(int i, boolean z) {
        int i2;
        int i3 = i;
        if (z) {
            i3 = i + this.activeNetworkRssiBoost;
        }
        int i4 = (i3 - this.start) / this.bucketWidth;
        if (i4 < 0) {
            i2 = 0;
        } else {
            i2 = i4;
            if (i4 > this.rssiBuckets.length - 1) {
                i2 = this.rssiBuckets.length - 1;
            }
        }
        return this.rssiBuckets[i2];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RssiCurve[start=").append(this.start).append(",bucketWidth=").append(this.bucketWidth).append(",activeNetworkRssiBoost=").append(this.activeNetworkRssiBoost);
        sb.append(",buckets=");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.rssiBuckets.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append((int) this.rssiBuckets[i2]);
            if (i2 < this.rssiBuckets.length - 1) {
                sb.append(",");
            }
            i = i2 + 1;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.start);
        parcel.writeInt(this.bucketWidth);
        parcel.writeInt(this.rssiBuckets.length);
        parcel.writeByteArray(this.rssiBuckets);
        parcel.writeInt(this.activeNetworkRssiBoost);
    }
}
