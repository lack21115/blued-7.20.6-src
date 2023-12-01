package java.net;

import android.system.OsConstants;
import java.nio.charset.StandardCharsets;

/* loaded from: source-2895416-dex2jar.jar:java/net/InetUnixAddress.class */
public final class InetUnixAddress extends InetAddress {
    public InetUnixAddress(String str) {
        this(str.getBytes(StandardCharsets.UTF_8));
    }

    public InetUnixAddress(byte[] bArr) {
        super(OsConstants.AF_UNIX, bArr, null);
    }

    @Override // java.net.InetAddress
    public String toString() {
        return "InetUnixAddress[" + new String(this.ipaddress, StandardCharsets.UTF_8) + "]";
    }
}
