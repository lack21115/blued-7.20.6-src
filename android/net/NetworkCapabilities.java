package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: source-9557208-dex2jar.jar:android/net/NetworkCapabilities.class */
public final class NetworkCapabilities implements Parcelable {
    public static final Parcelable.Creator<NetworkCapabilities> CREATOR = new Parcelable.Creator<NetworkCapabilities>() { // from class: android.net.NetworkCapabilities.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkCapabilities createFromParcel(Parcel parcel) {
            NetworkCapabilities networkCapabilities = new NetworkCapabilities();
            networkCapabilities.mNetworkCapabilities = parcel.readLong();
            networkCapabilities.mTransportTypes = parcel.readLong();
            networkCapabilities.mLinkUpBandwidthKbps = parcel.readInt();
            networkCapabilities.mLinkDownBandwidthKbps = parcel.readInt();
            networkCapabilities.mNetworkSpecifier = parcel.readString();
            return networkCapabilities;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetworkCapabilities[] newArray(int i) {
            return new NetworkCapabilities[i];
        }
    };
    private static final long DEFAULT_CAPABILITIES = 57344;
    private static final int MAX_NET_CAPABILITY = 16;
    private static final int MAX_TRANSPORT = 4;
    private static final int MIN_NET_CAPABILITY = 0;
    private static final int MIN_TRANSPORT = 0;
    public static final int NET_CAPABILITY_CBS = 5;
    public static final int NET_CAPABILITY_DUN = 2;
    public static final int NET_CAPABILITY_EIMS = 10;
    public static final int NET_CAPABILITY_FOTA = 3;
    public static final int NET_CAPABILITY_IA = 7;
    public static final int NET_CAPABILITY_IMS = 4;
    public static final int NET_CAPABILITY_INTERNET = 12;
    public static final int NET_CAPABILITY_MMS = 0;
    public static final int NET_CAPABILITY_NOT_METERED = 11;
    public static final int NET_CAPABILITY_NOT_RESTRICTED = 13;
    public static final int NET_CAPABILITY_NOT_VPN = 15;
    public static final int NET_CAPABILITY_RCS = 8;
    public static final int NET_CAPABILITY_SUPL = 1;
    public static final int NET_CAPABILITY_TRUSTED = 14;
    public static final int NET_CAPABILITY_VALIDATED = 16;
    public static final int NET_CAPABILITY_WIFI_P2P = 6;
    public static final int NET_CAPABILITY_XCAP = 9;
    private static final long RESTRICTED_CAPABILITIES = 1980;
    public static final int TRANSPORT_BLUETOOTH = 2;
    public static final int TRANSPORT_CELLULAR = 0;
    public static final int TRANSPORT_ETHERNET = 3;
    public static final int TRANSPORT_VPN = 4;
    public static final int TRANSPORT_WIFI = 1;
    private int mLinkDownBandwidthKbps;
    private int mLinkUpBandwidthKbps;
    private long mNetworkCapabilities;
    private String mNetworkSpecifier;
    private long mTransportTypes;

    public NetworkCapabilities() {
        this.mNetworkCapabilities = DEFAULT_CAPABILITIES;
    }

    public NetworkCapabilities(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            this.mNetworkCapabilities = networkCapabilities.mNetworkCapabilities;
            this.mTransportTypes = networkCapabilities.mTransportTypes;
            this.mLinkUpBandwidthKbps = networkCapabilities.mLinkUpBandwidthKbps;
            this.mLinkDownBandwidthKbps = networkCapabilities.mLinkDownBandwidthKbps;
            this.mNetworkSpecifier = networkCapabilities.mNetworkSpecifier;
        }
    }

    private void combineLinkBandwidths(NetworkCapabilities networkCapabilities) {
        this.mLinkUpBandwidthKbps = Math.max(this.mLinkUpBandwidthKbps, networkCapabilities.mLinkUpBandwidthKbps);
        this.mLinkDownBandwidthKbps = Math.max(this.mLinkDownBandwidthKbps, networkCapabilities.mLinkDownBandwidthKbps);
    }

    private void combineNetCapabilities(NetworkCapabilities networkCapabilities) {
        this.mNetworkCapabilities |= networkCapabilities.mNetworkCapabilities;
    }

    private void combineSpecifiers(NetworkCapabilities networkCapabilities) {
        String networkSpecifier = networkCapabilities.getNetworkSpecifier();
        if (TextUtils.isEmpty(networkSpecifier)) {
            return;
        }
        if (!TextUtils.isEmpty(this.mNetworkSpecifier)) {
            throw new IllegalStateException("Can't combine two networkSpecifiers");
        }
        setNetworkSpecifier(networkSpecifier);
    }

    private void combineTransportTypes(NetworkCapabilities networkCapabilities) {
        this.mTransportTypes |= networkCapabilities.mTransportTypes;
    }

    private int[] enumerateBits(long j) {
        int[] iArr = new int[Long.bitCount(j)];
        int i = 0;
        int i2 = 0;
        while (j > 0) {
            if ((j & 1) == 1) {
                iArr[i2] = i;
                i2++;
            }
            j >>= 1;
            i++;
        }
        return iArr;
    }

    private boolean equalsLinkBandwidths(NetworkCapabilities networkCapabilities) {
        return this.mLinkUpBandwidthKbps == networkCapabilities.mLinkUpBandwidthKbps && this.mLinkDownBandwidthKbps == networkCapabilities.mLinkDownBandwidthKbps;
    }

    private boolean equalsSpecifier(NetworkCapabilities networkCapabilities) {
        return TextUtils.isEmpty(this.mNetworkSpecifier) ? TextUtils.isEmpty(networkCapabilities.mNetworkSpecifier) : this.mNetworkSpecifier.equals(networkCapabilities.mNetworkSpecifier);
    }

    private boolean satisfiedByLinkBandwidths(NetworkCapabilities networkCapabilities) {
        return this.mLinkUpBandwidthKbps <= networkCapabilities.mLinkUpBandwidthKbps && this.mLinkDownBandwidthKbps <= networkCapabilities.mLinkDownBandwidthKbps;
    }

    private boolean satisfiedByNetCapabilities(NetworkCapabilities networkCapabilities) {
        return (networkCapabilities.mNetworkCapabilities & this.mNetworkCapabilities) == this.mNetworkCapabilities;
    }

    private boolean satisfiedBySpecifier(NetworkCapabilities networkCapabilities) {
        return TextUtils.isEmpty(this.mNetworkSpecifier) || this.mNetworkSpecifier.equals(networkCapabilities.mNetworkSpecifier);
    }

    private boolean satisfiedByTransportTypes(NetworkCapabilities networkCapabilities) {
        return this.mTransportTypes == 0 || (this.mTransportTypes & networkCapabilities.mTransportTypes) != 0;
    }

    public NetworkCapabilities addCapability(int i) {
        if (i < 0 || i > 16) {
            throw new IllegalArgumentException("NetworkCapability out of range");
        }
        this.mNetworkCapabilities |= 1 << i;
        return this;
    }

    public NetworkCapabilities addTransportType(int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("TransportType out of range");
        }
        this.mTransportTypes |= 1 << i;
        setNetworkSpecifier(this.mNetworkSpecifier);
        return this;
    }

    public void combineCapabilities(NetworkCapabilities networkCapabilities) {
        combineNetCapabilities(networkCapabilities);
        combineTransportTypes(networkCapabilities);
        combineLinkBandwidths(networkCapabilities);
        combineSpecifiers(networkCapabilities);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NetworkCapabilities)) {
            return false;
        }
        NetworkCapabilities networkCapabilities = (NetworkCapabilities) obj;
        return equalsNetCapabilities(networkCapabilities) && equalsTransportTypes(networkCapabilities) && equalsLinkBandwidths(networkCapabilities) && equalsSpecifier(networkCapabilities);
    }

    public boolean equalsNetCapabilities(NetworkCapabilities networkCapabilities) {
        return networkCapabilities.mNetworkCapabilities == this.mNetworkCapabilities;
    }

    public boolean equalsTransportTypes(NetworkCapabilities networkCapabilities) {
        return networkCapabilities.mTransportTypes == this.mTransportTypes;
    }

    public int[] getCapabilities() {
        return enumerateBits(this.mNetworkCapabilities);
    }

    public int getLinkDownstreamBandwidthKbps() {
        return this.mLinkDownBandwidthKbps;
    }

    public int getLinkUpstreamBandwidthKbps() {
        return this.mLinkUpBandwidthKbps;
    }

    public String getNetworkSpecifier() {
        return this.mNetworkSpecifier;
    }

    public int[] getTransportTypes() {
        return enumerateBits(this.mTransportTypes);
    }

    public boolean hasCapability(int i) {
        boolean z = true;
        if (i < 0 || i > 16) {
            z = false;
        } else if ((this.mNetworkCapabilities & (1 << i)) == 0) {
            return false;
        }
        return z;
    }

    public boolean hasTransport(int i) {
        boolean z = true;
        if (i < 0 || i > 4) {
            z = false;
        } else if ((this.mTransportTypes & (1 << i)) == 0) {
            return false;
        }
        return z;
    }

    public int hashCode() {
        int i = (int) (this.mNetworkCapabilities & (-1));
        int i2 = (int) (this.mNetworkCapabilities >> 32);
        int i3 = (int) (this.mTransportTypes & (-1));
        int i4 = (int) (this.mTransportTypes >> 32);
        int i5 = this.mLinkUpBandwidthKbps;
        return (TextUtils.isEmpty(this.mNetworkSpecifier) ? 0 : this.mNetworkSpecifier.hashCode() * 17) + (this.mLinkDownBandwidthKbps * 13) + i + (i2 * 3) + (i3 * 5) + (i4 * 7) + (i5 * 11);
    }

    public void maybeMarkCapabilitiesRestricted() {
        if ((this.mNetworkCapabilities & (-59325)) != 0 || (this.mNetworkCapabilities & RESTRICTED_CAPABILITIES) == 0) {
            return;
        }
        removeCapability(13);
    }

    public NetworkCapabilities removeCapability(int i) {
        if (i < 0 || i > 16) {
            throw new IllegalArgumentException("NetworkCapability out of range");
        }
        this.mNetworkCapabilities &= (1 << i) ^ (-1);
        return this;
    }

    public NetworkCapabilities removeTransportType(int i) {
        if (i < 0 || i > 4) {
            throw new IllegalArgumentException("TransportType out of range");
        }
        this.mTransportTypes &= (1 << i) ^ (-1);
        setNetworkSpecifier(this.mNetworkSpecifier);
        return this;
    }

    public boolean satisfiedByNetworkCapabilities(NetworkCapabilities networkCapabilities) {
        return networkCapabilities != null && satisfiedByNetCapabilities(networkCapabilities) && satisfiedByTransportTypes(networkCapabilities) && satisfiedByLinkBandwidths(networkCapabilities) && satisfiedBySpecifier(networkCapabilities);
    }

    public void setLinkDownstreamBandwidthKbps(int i) {
        this.mLinkDownBandwidthKbps = i;
    }

    public void setLinkUpstreamBandwidthKbps(int i) {
        this.mLinkUpBandwidthKbps = i;
    }

    public void setNetworkSpecifier(String str) {
        if (!TextUtils.isEmpty(str) && Long.bitCount(this.mTransportTypes) != 1) {
            throw new IllegalStateException("Must have a single transport specified to use setNetworkSpecifier");
        }
        this.mNetworkSpecifier = str;
    }

    public String toString() {
        String str;
        String str2;
        int[] transportTypes = getTransportTypes();
        String str3 = transportTypes.length > 0 ? " Transports: " : "";
        int i = 0;
        while (i < transportTypes.length) {
            switch (transportTypes[i]) {
                case 0:
                    str2 = str3 + "CELLULAR";
                    break;
                case 1:
                    str2 = str3 + "WIFI";
                    break;
                case 2:
                    str2 = str3 + "BLUETOOTH";
                    break;
                case 3:
                    str2 = str3 + "ETHERNET";
                    break;
                case 4:
                    str2 = str3 + "VPN";
                    break;
                default:
                    str2 = str3;
                    break;
            }
            int i2 = i + 1;
            i = i2;
            str3 = str2;
            if (i2 < transportTypes.length) {
                str3 = str2 + "|";
                i = i2;
            }
        }
        int[] capabilities = getCapabilities();
        String str4 = capabilities.length > 0 ? " Capabilities: " : "";
        int i3 = 0;
        while (i3 < capabilities.length) {
            switch (capabilities[i3]) {
                case 0:
                    str = str4 + "MMS";
                    break;
                case 1:
                    str = str4 + "SUPL";
                    break;
                case 2:
                    str = str4 + "DUN";
                    break;
                case 3:
                    str = str4 + "FOTA";
                    break;
                case 4:
                    str = str4 + "IMS";
                    break;
                case 5:
                    str = str4 + "CBS";
                    break;
                case 6:
                    str = str4 + "WIFI_P2P";
                    break;
                case 7:
                    str = str4 + "IA";
                    break;
                case 8:
                    str = str4 + "RCS";
                    break;
                case 9:
                    str = str4 + "XCAP";
                    break;
                case 10:
                    str = str4 + "EIMS";
                    break;
                case 11:
                    str = str4 + "NOT_METERED";
                    break;
                case 12:
                    str = str4 + "INTERNET";
                    break;
                case 13:
                    str = str4 + "NOT_RESTRICTED";
                    break;
                case 14:
                    str = str4 + "TRUSTED";
                    break;
                case 15:
                    str = str4 + "NOT_VPN";
                    break;
                default:
                    str = str4;
                    break;
            }
            int i4 = i3 + 1;
            str4 = str;
            i3 = i4;
            if (i4 < capabilities.length) {
                str4 = str + "&";
                i3 = i4;
            }
        }
        return "[" + str3 + str4 + (this.mLinkUpBandwidthKbps > 0 ? " LinkUpBandwidth>=" + this.mLinkUpBandwidthKbps + "Kbps" : "") + (this.mLinkDownBandwidthKbps > 0 ? " LinkDnBandwidth>=" + this.mLinkDownBandwidthKbps + "Kbps" : "") + (this.mNetworkSpecifier == null ? "" : " Specifier: <" + this.mNetworkSpecifier + SimpleComparison.GREATER_THAN_OPERATION) + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mNetworkCapabilities);
        parcel.writeLong(this.mTransportTypes);
        parcel.writeInt(this.mLinkUpBandwidthKbps);
        parcel.writeInt(this.mLinkDownBandwidthKbps);
        parcel.writeString(this.mNetworkSpecifier);
    }
}
