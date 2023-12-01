package java.net;

import android.system.OsConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.util.Arrays;
import java.util.Enumeration;

/* loaded from: source-2895416-dex2jar.jar:java/net/Inet6Address.class */
public final class Inet6Address extends InetAddress {
    public static final InetAddress ANY = new Inet6Address(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, null, 0);
    public static final InetAddress LOOPBACK = new Inet6Address(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, "localhost", 0);
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("ipaddress", byte[].class), new ObjectStreamField("scope_id", Integer.TYPE), new ObjectStreamField("scope_id_set", Boolean.TYPE), new ObjectStreamField("scope_ifname_set", Boolean.TYPE), new ObjectStreamField("ifname", String.class)};
    private static final long serialVersionUID = 6880410070516793377L;
    private String ifname;
    private int scope_id;
    private boolean scope_id_set;
    private boolean scope_ifname_set;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Inet6Address(byte[] bArr, String str, int i) {
        super(OsConstants.AF_INET6, bArr, str);
        this.scope_id = i;
        this.scope_id_set = i != 0;
    }

    private boolean compareLocalType(Inet6Address inet6Address) {
        if (inet6Address.isSiteLocalAddress() && isSiteLocalAddress()) {
            return true;
        }
        if (inet6Address.isLinkLocalAddress() && isLinkLocalAddress()) {
            return true;
        }
        return (inet6Address.isSiteLocalAddress() || inet6Address.isLinkLocalAddress()) ? false : true;
    }

    public static Inet6Address getByAddress(String str, byte[] bArr, int i) throws UnknownHostException {
        if (bArr == null || bArr.length != 16) {
            throw new UnknownHostException("Not an IPv6 address: " + Arrays.toString(bArr));
        }
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        return new Inet6Address(bArr, str, i2);
    }

    public static Inet6Address getByAddress(String str, byte[] bArr, NetworkInterface networkInterface) throws UnknownHostException {
        Inet6Address byAddress = getByAddress(str, bArr, 0);
        if (networkInterface != null) {
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (true) {
                if (!inetAddresses.hasMoreElements()) {
                    break;
                }
                InetAddress nextElement = inetAddresses.nextElement();
                if (nextElement.getAddress().length == 16) {
                    Inet6Address inet6Address = (Inet6Address) nextElement;
                    if (inet6Address.compareLocalType(byAddress)) {
                        byAddress.scope_id_set = true;
                        byAddress.scope_id = inet6Address.scope_id;
                        byAddress.scope_ifname_set = true;
                        byAddress.ifname = networkInterface.getName();
                        break;
                    }
                }
            }
            if (!byAddress.scope_id_set) {
                throw new UnknownHostException("Scope id not found for address: " + Arrays.toString(bArr));
            }
        }
        return byAddress;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.ipaddress = (byte[]) readFields.get("ipaddress", (Object) null);
        this.scope_id = readFields.get("scope_id", 0);
        this.scope_id_set = readFields.get("scope_id_set", false);
        this.ifname = (String) readFields.get("ifname", (Object) null);
        this.scope_ifname_set = readFields.get("scope_ifname_set", false);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        if (this.ipaddress == null) {
            putFields.put("ipaddress", (Object) null);
        } else {
            putFields.put("ipaddress", this.ipaddress);
        }
        putFields.put("scope_id", this.scope_id);
        putFields.put("scope_id_set", this.scope_id_set);
        putFields.put("scope_ifname_set", this.scope_ifname_set);
        putFields.put("ifname", this.ifname);
        objectOutputStream.writeFields();
    }

    public int getScopeId() {
        if (this.scope_id_set) {
            return this.scope_id;
        }
        return 0;
    }

    public NetworkInterface getScopedInterface() {
        NetworkInterface networkInterface = null;
        try {
            if (this.scope_ifname_set) {
                networkInterface = null;
                if (this.ifname != null) {
                    networkInterface = NetworkInterface.getByName(this.ifname);
                }
            }
            return networkInterface;
        } catch (SocketException e) {
            return null;
        }
    }

    @Override // java.net.InetAddress
    public boolean isAnyLocalAddress() {
        return Arrays.equals(this.ipaddress, ANY.ipaddress);
    }

    public boolean isIPv4CompatibleAddress() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 12) {
                return true;
            }
            if (this.ipaddress[i2] != 0) {
                return false;
            }
            i = i2 + 1;
        }
    }

    @Override // java.net.InetAddress
    public boolean isLinkLocalAddress() {
        return (this.ipaddress[0] & 255) == 254 && (this.ipaddress[1] & 192) == 128;
    }

    @Override // java.net.InetAddress
    public boolean isLoopbackAddress() {
        return Arrays.equals(this.ipaddress, LOOPBACK.ipaddress);
    }

    @Override // java.net.InetAddress
    public boolean isMCGlobal() {
        return (this.ipaddress[0] & 255) == 255 && (this.ipaddress[1] & 15) == 14;
    }

    @Override // java.net.InetAddress
    public boolean isMCLinkLocal() {
        return (this.ipaddress[0] & 255) == 255 && (this.ipaddress[1] & 15) == 2;
    }

    @Override // java.net.InetAddress
    public boolean isMCNodeLocal() {
        return (this.ipaddress[0] & 255) == 255 && (this.ipaddress[1] & 15) == 1;
    }

    @Override // java.net.InetAddress
    public boolean isMCOrgLocal() {
        return (this.ipaddress[0] & 255) == 255 && (this.ipaddress[1] & 15) == 8;
    }

    @Override // java.net.InetAddress
    public boolean isMCSiteLocal() {
        return (this.ipaddress[0] & 255) == 255 && (this.ipaddress[1] & 15) == 5;
    }

    @Override // java.net.InetAddress
    public boolean isMulticastAddress() {
        boolean z = false;
        if ((this.ipaddress[0] & 255) == 255) {
            z = true;
        }
        return z;
    }

    @Override // java.net.InetAddress
    public boolean isSiteLocalAddress() {
        return (this.ipaddress[0] & 255) == 254 && (this.ipaddress[1] & 192) == 192;
    }

    @Override // java.net.InetAddress
    public String toString() {
        return this.ifname != null ? super.toString() + "%" + this.ifname : this.scope_id != 0 ? super.toString() + "%" + this.scope_id : super.toString();
    }
}
