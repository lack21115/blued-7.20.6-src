package java.net;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import libcore.io.IoUtils;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:java/net/NetworkInterface.class */
public final class NetworkInterface {
    private static final File SYS_CLASS_NET = new File("/sys/class/net");
    private final List<InetAddress> addresses;
    private final List<InterfaceAddress> interfaceAddresses;
    private final int interfaceIndex;
    private final String name;
    private final List<NetworkInterface> children = new LinkedList();
    private NetworkInterface parent = null;

    private NetworkInterface(String str, int i, List<InetAddress> list, List<InterfaceAddress> list2) {
        this.name = str;
        this.interfaceIndex = i;
        this.addresses = list;
        this.interfaceAddresses = list2;
    }

    private static void collectIpv4Address(String str, List<InetAddress> list, List<InterfaceAddress> list2) throws SocketException {
        FileDescriptor fileDescriptor = null;
        FileDescriptor fileDescriptor2 = null;
        FileDescriptor fileDescriptor3 = null;
        try {
            try {
                FileDescriptor socket = Libcore.os.socket(OsConstants.AF_INET, OsConstants.SOCK_DGRAM, 0);
                InetAddress ioctlInetAddress = Libcore.os.ioctlInetAddress(socket, OsConstants.SIOCGIFADDR, str);
                InetAddress ioctlInetAddress2 = Libcore.os.ioctlInetAddress(socket, OsConstants.SIOCGIFBRDADDR, str);
                InetAddress ioctlInetAddress3 = Libcore.os.ioctlInetAddress(socket, OsConstants.SIOCGIFNETMASK, str);
                InetAddress inetAddress = ioctlInetAddress2;
                if (ioctlInetAddress2.equals(Inet4Address.ANY)) {
                    inetAddress = null;
                }
                list.add(ioctlInetAddress);
                fileDescriptor3 = socket;
                fileDescriptor = socket;
                fileDescriptor2 = socket;
                list2.add(new InterfaceAddress((Inet4Address) ioctlInetAddress, (Inet4Address) inetAddress, (Inet4Address) ioctlInetAddress3));
                IoUtils.closeQuietly(socket);
            } catch (ErrnoException e) {
                if (e.errno != OsConstants.EADDRNOTAVAIL) {
                    FileDescriptor fileDescriptor4 = fileDescriptor3;
                    throw rethrowAsSocketException(e);
                } else {
                    IoUtils.closeQuietly(fileDescriptor3);
                }
            } catch (Exception e2) {
                throw rethrowAsSocketException(e2);
            }
        } catch (Throwable th) {
            IoUtils.closeQuietly(fileDescriptor);
            throw th;
        }
    }

    public static void collectIpv6Addresses(String str, int i, List<InetAddress> list, List<InterfaceAddress> list2, String[] strArr) throws SocketException {
        String str2 = " " + str;
        try {
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                String str3 = strArr[i3];
                if (str3.endsWith(str2)) {
                    byte[] bArr = new byte[16];
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= bArr.length) {
                            break;
                        }
                        bArr[i5] = (byte) Integer.parseInt(str3.substring(i5 * 2, (i5 * 2) + 2), 16);
                        i4 = i5 + 1;
                    }
                    int indexOf = str3.indexOf(32, 33) + 1;
                    short parseShort = Short.parseShort(str3.substring(indexOf, str3.indexOf(32, indexOf)), 16);
                    Inet6Address inet6Address = new Inet6Address(bArr, null, i);
                    list.add(inet6Address);
                    list2.add(new InterfaceAddress(inet6Address, parseShort));
                }
                i2 = i3 + 1;
            }
        } catch (NumberFormatException e) {
            throw rethrowAsSocketException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NetworkInterface forUnboundMulticastSocket() {
        return new NetworkInterface(null, -1, Arrays.asList(Inet6Address.ANY), Collections.emptyList());
    }

    public static NetworkInterface getByIndex(int i) throws SocketException {
        String if_indextoname = Libcore.os.if_indextoname(i);
        if (if_indextoname == null) {
            return null;
        }
        return getByName(if_indextoname);
    }

    public static NetworkInterface getByInetAddress(InetAddress inetAddress) throws SocketException {
        if (inetAddress == null) {
            throw new NullPointerException("address == null");
        }
        for (NetworkInterface networkInterface : getNetworkInterfacesList()) {
            if (networkInterface.addresses.contains(inetAddress)) {
                return networkInterface;
            }
        }
        return null;
    }

    public static NetworkInterface getByName(String str) throws SocketException {
        if (str == null) {
            throw new NullPointerException("interfaceName == null");
        }
        if (isValidInterfaceName(str)) {
            return getByNameInternal(str, readIfInet6Lines());
        }
        return null;
    }

    private static NetworkInterface getByNameInternal(String str, String[] strArr) throws SocketException {
        int readIntFile = readIntFile("/sys/class/net/" + str + "/ifindex");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        collectIpv6Addresses(str, readIntFile, arrayList, arrayList2, strArr);
        collectIpv4Address(str, arrayList, arrayList2);
        return new NetworkInterface(str, readIntFile, arrayList, arrayList2);
    }

    public static Enumeration<NetworkInterface> getNetworkInterfaces() throws SocketException {
        return Collections.enumeration(getNetworkInterfacesList());
    }

    @FindBugsSuppressWarnings({"DMI_HARDCODED_ABSOLUTE_FILENAME"})
    private static List<NetworkInterface> getNetworkInterfacesList() throws SocketException {
        String[] list = SYS_CLASS_NET.list();
        NetworkInterface[] networkInterfaceArr = new NetworkInterface[list.length];
        boolean[] zArr = new boolean[networkInterfaceArr.length];
        String[] readIfInet6Lines = readIfInet6Lines();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.length) {
                break;
            }
            networkInterfaceArr[i2] = getByNameInternal(list[i2], readIfInet6Lines);
            if (networkInterfaceArr[i2] == null) {
                zArr[i2] = true;
            }
            i = i2 + 1;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= networkInterfaceArr.length) {
                return arrayList;
            }
            if (!zArr[i4]) {
                int i5 = i4;
                while (true) {
                    int i6 = i5;
                    if (i6 >= networkInterfaceArr.length) {
                        break;
                    }
                    if (!zArr[i6] && networkInterfaceArr[i6].name.startsWith(networkInterfaceArr[i4].name + ":")) {
                        networkInterfaceArr[i4].children.add(networkInterfaceArr[i6]);
                        networkInterfaceArr[i6].parent = networkInterfaceArr[i4];
                        networkInterfaceArr[i4].addresses.addAll(networkInterfaceArr[i6].addresses);
                        zArr[i6] = true;
                    }
                    i5 = i6 + 1;
                }
                arrayList.add(networkInterfaceArr[i4]);
                zArr[i4] = true;
            }
            i3 = i4 + 1;
        }
    }

    private boolean hasFlag(int i) throws SocketException {
        return (readIntFile(new StringBuilder().append("/sys/class/net/").append(this.name).append("/flags").toString()) & i) != 0;
    }

    @FindBugsSuppressWarnings({"DMI_HARDCODED_ABSOLUTE_FILENAME"})
    private static boolean isValidInterfaceName(String str) {
        String[] list = SYS_CLASS_NET.list();
        if (list == null) {
            return false;
        }
        int length = list.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (str.equals(list[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private static String[] readIfInet6Lines() throws SocketException {
        try {
            return IoUtils.readFileAsString("/proc/net/if_inet6").split("\n");
        } catch (IOException e) {
            throw rethrowAsSocketException(e);
        }
    }

    private static int readIntFile(String str) throws SocketException {
        try {
            String trim = IoUtils.readFileAsString(str).trim();
            return trim.startsWith("0x") ? Integer.parseInt(trim.substring(2), 16) : Integer.parseInt(trim);
        } catch (Exception e) {
            throw rethrowAsSocketException(e);
        }
    }

    private static SocketException rethrowAsSocketException(Exception exc) throws SocketException {
        SocketException socketException = new SocketException();
        socketException.initCause(exc);
        throw socketException;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NetworkInterface) {
            NetworkInterface networkInterface = (NetworkInterface) obj;
            return this.interfaceIndex == networkInterface.interfaceIndex && this.name.equals(networkInterface.name) && this.addresses.equals(networkInterface.addresses);
        }
        return false;
    }

    public String getDisplayName() {
        return this.name;
    }

    public byte[] getHardwareAddress() throws SocketException {
        try {
            String readFileAsString = IoUtils.readFileAsString("/sys/class/net/" + this.name + "/address");
            byte[] bArr = new byte[readFileAsString.length() / 3];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bArr.length) {
                    break;
                }
                bArr[i2] = (byte) Integer.parseInt(readFileAsString.substring(i2 * 3, (i2 * 3) + 2), 16);
                i = i2 + 1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= bArr.length) {
                    return null;
                }
                if (bArr[i4] != 0) {
                    return bArr;
                }
                i3 = i4 + 1;
            }
        } catch (Exception e) {
            throw rethrowAsSocketException(e);
        }
    }

    public int getIndex() {
        return this.interfaceIndex;
    }

    public Enumeration<InetAddress> getInetAddresses() {
        return Collections.enumeration(this.addresses);
    }

    public List<InterfaceAddress> getInterfaceAddresses() {
        return Collections.unmodifiableList(this.interfaceAddresses);
    }

    public int getMTU() throws SocketException {
        return readIntFile("/sys/class/net/" + this.name + "/mtu");
    }

    public String getName() {
        return this.name;
    }

    public NetworkInterface getParent() {
        return this.parent;
    }

    public Enumeration<NetworkInterface> getSubInterfaces() {
        return Collections.enumeration(this.children);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean isLoopback() throws SocketException {
        return hasFlag(OsConstants.IFF_LOOPBACK);
    }

    public boolean isPointToPoint() throws SocketException {
        return hasFlag(OsConstants.IFF_POINTOPOINT);
    }

    public boolean isUp() throws SocketException {
        return hasFlag(OsConstants.IFF_UP);
    }

    public boolean isVirtual() {
        return this.parent != null;
    }

    public boolean supportsMulticast() throws SocketException {
        return hasFlag(OsConstants.IFF_MULTICAST);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append("[");
        sb.append(this.name);
        sb.append("][");
        sb.append(this.interfaceIndex);
        sb.append("]");
        for (InetAddress inetAddress : this.addresses) {
            sb.append("[");
            sb.append(inetAddress.toString());
            sb.append("]");
        }
        return sb.toString();
    }
}
