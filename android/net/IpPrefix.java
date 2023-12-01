package android.net;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/net/IpPrefix.class */
public final class IpPrefix implements Parcelable {
    public static final Parcelable.Creator<IpPrefix> CREATOR = new Parcelable.Creator<IpPrefix>() { // from class: android.net.IpPrefix.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpPrefix createFromParcel(Parcel parcel) {
            return new IpPrefix(parcel.createByteArray(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpPrefix[] newArray(int i) {
            return new IpPrefix[i];
        }
    };
    private final byte[] address;
    private final int prefixLength;

    public IpPrefix(String str) {
        Pair<InetAddress, Integer> parseIpAndMask = NetworkUtils.parseIpAndMask(str);
        this.address = parseIpAndMask.first.getAddress();
        this.prefixLength = parseIpAndMask.second.intValue();
        checkAndMaskAddressAndPrefixLength();
    }

    public IpPrefix(InetAddress inetAddress, int i) {
        this.address = inetAddress.getAddress();
        this.prefixLength = i;
        checkAndMaskAddressAndPrefixLength();
    }

    public IpPrefix(byte[] bArr, int i) {
        this.address = (byte[]) bArr.clone();
        this.prefixLength = i;
        checkAndMaskAddressAndPrefixLength();
    }

    private void checkAndMaskAddressAndPrefixLength() {
        if (this.address.length != 4 && this.address.length != 16) {
            throw new IllegalArgumentException("IpPrefix has " + this.address.length + " bytes which is neither 4 nor 16");
        }
        NetworkUtils.maskRawAddress(this.address, this.prefixLength);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof IpPrefix) {
            IpPrefix ipPrefix = (IpPrefix) obj;
            return Arrays.equals(this.address, ipPrefix.address) && this.prefixLength == ipPrefix.prefixLength;
        }
        return false;
    }

    public InetAddress getAddress() {
        try {
            return InetAddress.getByAddress(this.address);
        } catch (UnknownHostException e) {
            return null;
        }
    }

    public int getPrefixLength() {
        return this.prefixLength;
    }

    public byte[] getRawAddress() {
        return (byte[]) this.address.clone();
    }

    public int hashCode() {
        return Arrays.hashCode(this.address) + (this.prefixLength * 11);
    }

    public String toString() {
        try {
            return InetAddress.getByAddress(this.address).getHostAddress() + BridgeUtil.SPLIT_MARK + this.prefixLength;
        } catch (UnknownHostException e) {
            throw new IllegalStateException("IpPrefix with invalid address! Shouldn't happen.", e);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.address);
        parcel.writeInt(this.prefixLength);
    }
}
