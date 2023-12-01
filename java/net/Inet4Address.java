package java.net;

import android.system.OsConstants;
import java.io.ObjectStreamException;
import java.nio.ByteOrder;
import libcore.io.Memory;

/* loaded from: source-2895416-dex2jar.jar:java/net/Inet4Address.class */
public final class Inet4Address extends InetAddress {
    private static final long serialVersionUID = 3286316764910316507L;
    public static final InetAddress ANY = new Inet4Address(new byte[]{0, 0, 0, 0}, null);
    public static final InetAddress ALL = new Inet4Address(new byte[]{-1, -1, -1, -1}, null);
    public static final InetAddress LOOPBACK = new Inet4Address(new byte[]{Byte.MAX_VALUE, 0, 0, 1}, "localhost");

    /* JADX INFO: Access modifiers changed from: package-private */
    public Inet4Address(byte[] bArr, String str) {
        super(OsConstants.AF_INET, bArr, str);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new Inet4Address(this.ipaddress, this.hostName);
    }

    @Override // java.net.InetAddress
    public boolean isAnyLocalAddress() {
        return this.ipaddress[0] == 0 && this.ipaddress[1] == 0 && this.ipaddress[2] == 0 && this.ipaddress[3] == 0;
    }

    @Override // java.net.InetAddress
    public boolean isLinkLocalAddress() {
        return (this.ipaddress[0] & 255) == 169 && (this.ipaddress[1] & 255) == 254;
    }

    @Override // java.net.InetAddress
    public boolean isLoopbackAddress() {
        boolean z = false;
        if ((this.ipaddress[0] & 255) == 127) {
            z = true;
        }
        return z;
    }

    @Override // java.net.InetAddress
    public boolean isMCGlobal() {
        if (isMulticastAddress()) {
            int peekInt = Memory.peekInt(this.ipaddress, 0, ByteOrder.BIG_ENDIAN);
            return (peekInt >>> 8) >= 14680065 && (peekInt >>> 24) <= 238;
        }
        return false;
    }

    @Override // java.net.InetAddress
    public boolean isMCLinkLocal() {
        return (this.ipaddress[0] & 255) == 224 && this.ipaddress[1] == 0 && this.ipaddress[2] == 0;
    }

    @Override // java.net.InetAddress
    public boolean isMCNodeLocal() {
        return false;
    }

    @Override // java.net.InetAddress
    public boolean isMCOrgLocal() {
        return (this.ipaddress[0] & 255) == 239 && (this.ipaddress[1] & 252) == 192;
    }

    @Override // java.net.InetAddress
    public boolean isMCSiteLocal() {
        return (this.ipaddress[0] & 255) == 239 && (this.ipaddress[1] & 255) == 255;
    }

    @Override // java.net.InetAddress
    public boolean isMulticastAddress() {
        boolean z = false;
        if ((this.ipaddress[0] & 240) == 224) {
            z = true;
        }
        return z;
    }

    @Override // java.net.InetAddress
    public boolean isSiteLocalAddress() {
        if ((this.ipaddress[0] & 255) == 10) {
            return true;
        }
        if ((this.ipaddress[0] & 255) == 172 && (this.ipaddress[1] & 240) == 16) {
            return true;
        }
        return (this.ipaddress[0] & 255) == 192 && (this.ipaddress[1] & 255) == 168;
    }
}
