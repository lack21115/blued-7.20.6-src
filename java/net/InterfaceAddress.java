package java.net;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;

/* loaded from: source-2895416-dex2jar.jar:java/net/InterfaceAddress.class */
public class InterfaceAddress {
    private final InetAddress address;
    private final InetAddress broadcastAddress;
    private final short prefixLength;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterfaceAddress(Inet4Address inet4Address, Inet4Address inet4Address2, Inet4Address inet4Address3) {
        this.address = inet4Address;
        this.broadcastAddress = inet4Address2;
        this.prefixLength = countPrefixLength(inet4Address3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterfaceAddress(Inet6Address inet6Address, short s) {
        this.address = inet6Address;
        this.broadcastAddress = null;
        this.prefixLength = s;
    }

    private static short countPrefixLength(Inet4Address inet4Address) {
        short s = 0;
        byte[] bArr = inet4Address.ipaddress;
        int length = bArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return s;
            }
            byte b = bArr[i2];
            int i3 = 0;
            while (i3 < 8) {
                short s2 = s;
                if (((1 << i3) & b) != 0) {
                    s2 = (short) (s + 1);
                }
                i3++;
                s = s2;
            }
            i = i2 + 1;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InterfaceAddress) {
            InterfaceAddress interfaceAddress = (InterfaceAddress) obj;
            if (this.address == null) {
                if (interfaceAddress.address != null) {
                    return false;
                }
            } else if (!this.address.equals(interfaceAddress.address)) {
                return false;
            }
            if (interfaceAddress.prefixLength == this.prefixLength) {
                return this.broadcastAddress == null ? interfaceAddress.broadcastAddress == null : this.broadcastAddress.equals(interfaceAddress.broadcastAddress);
            }
            return false;
        }
        return false;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public InetAddress getBroadcast() {
        return this.broadcastAddress;
    }

    public short getNetworkPrefixLength() {
        return this.prefixLength;
    }

    public int hashCode() {
        int i = 0;
        int i2 = this.address == null ? 0 : -this.address.hashCode();
        if (this.broadcastAddress != null) {
            i = this.broadcastAddress.hashCode();
        }
        return i2 + i + this.prefixLength;
    }

    public String toString() {
        return this.address + BridgeUtil.SPLIT_MARK + ((int) this.prefixLength) + " [" + this.broadcastAddress + "]";
    }
}
