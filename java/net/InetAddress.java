package java.net;

import android.system.ErrnoException;
import android.system.GaiException;
import android.system.OsConstants;
import android.system.StructAddrinfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import dalvik.system.BlockGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.Memory;

/* loaded from: source-2895416-dex2jar.jar:java/net/InetAddress.class */
public class InetAddress implements Serializable {
    private static final int NETID_UNSET = 0;
    private static final long serialVersionUID = 3286316764910316507L;
    private int family;
    String hostName;
    byte[] ipaddress;
    private static final AddressCache addressCache = new AddressCache();
    public static final InetAddress UNSPECIFIED = new InetAddress(OsConstants.AF_UNSPEC, null, null);
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("address", Integer.TYPE), new ObjectStreamField("family", Integer.TYPE), new ObjectStreamField("hostName", String.class)};

    /* JADX INFO: Access modifiers changed from: package-private */
    public InetAddress(int i, byte[] bArr, String str) {
        this.family = i;
        this.ipaddress = bArr;
        this.hostName = str;
    }

    private static UnknownHostException badAddressLength(byte[] bArr) throws UnknownHostException {
        throw new UnknownHostException("Address is neither 4 or 16 bytes: " + Arrays.toString(bArr));
    }

    private static InetAddress[] bytesToInetAddresses(byte[][] bArr, String str) throws UnknownHostException {
        InetAddress[] inetAddressArr = new InetAddress[bArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bArr.length) {
                return inetAddressArr;
            }
            inetAddressArr[i2] = makeInetAddress(bArr[i2], str);
            i = i2 + 1;
        }
    }

    public static void clearDnsCache() {
        addressCache.clear();
    }

    private static InetAddress disallowDeprecatedFormats(String str, InetAddress inetAddress) {
        return ((inetAddress instanceof Inet4Address) && str.indexOf(58) == -1) ? Libcore.os.inet_pton(OsConstants.AF_INET, str) : inetAddress;
    }

    public static InetAddress[] getAllByName(String str) throws UnknownHostException {
        return (InetAddress[]) getAllByNameImpl(str, 0).clone();
    }

    private static InetAddress[] getAllByNameImpl(String str, int i) throws UnknownHostException {
        if (str == null || str.isEmpty()) {
            return loopbackAddresses();
        }
        InetAddress parseNumericAddressNoThrow = parseNumericAddressNoThrow(str);
        if (parseNumericAddressNoThrow != null) {
            InetAddress disallowDeprecatedFormats = disallowDeprecatedFormats(str, parseNumericAddressNoThrow);
            if (disallowDeprecatedFormats == null) {
                throw new UnknownHostException("Deprecated IPv4 address format: " + str);
            }
            return new InetAddress[]{disallowDeprecatedFormats};
        }
        return (InetAddress[]) lookupHostByName(str, i).clone();
    }

    public static InetAddress[] getAllByNameOnNet(String str, int i) throws UnknownHostException {
        return (InetAddress[]) getAllByNameImpl(str, i).clone();
    }

    public static InetAddress getByAddress(String str, byte[] bArr) throws UnknownHostException {
        return getByAddress(str, bArr, 0);
    }

    private static InetAddress getByAddress(String str, byte[] bArr, int i) throws UnknownHostException {
        if (bArr == null) {
            throw new UnknownHostException("ipAddress == null");
        }
        if (bArr.length == 4) {
            return new Inet4Address((byte[]) bArr.clone(), str);
        }
        if (bArr.length == 16) {
            return isIPv4MappedAddress(bArr) ? new Inet4Address(ipv4MappedToIPv4(bArr), str) : new Inet6Address((byte[]) bArr.clone(), str, i);
        }
        throw badAddressLength(bArr);
    }

    public static InetAddress getByAddress(byte[] bArr) throws UnknownHostException {
        return getByAddress(null, bArr, 0);
    }

    public static InetAddress getByName(String str) throws UnknownHostException {
        return getAllByNameImpl(str, 0)[0];
    }

    public static InetAddress getByNameOnNet(String str, int i) throws UnknownHostException {
        return getAllByNameImpl(str, i)[0];
    }

    private static InetAddress getHostByAddrImpl(InetAddress inetAddress) throws UnknownHostException {
        BlockGuard.getThreadPolicy().onNetwork();
        try {
            return makeInetAddress((byte[]) inetAddress.ipaddress.clone(), Libcore.os.getnameinfo(inetAddress, OsConstants.NI_NAMEREQD));
        } catch (GaiException e) {
            throw e.rethrowAsUnknownHostException();
        }
    }

    public static InetAddress getLocalHost() throws UnknownHostException {
        return lookupHostByName(Libcore.os.uname().nodename, 0)[0];
    }

    public static InetAddress getLoopbackAddress() {
        return Inet6Address.LOOPBACK;
    }

    private static byte[] ipv4MappedToIPv4(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 4) {
                return bArr2;
            }
            bArr2[i2] = bArr[i2 + 12];
            i = i2 + 1;
        }
    }

    private static boolean isIPv4MappedAddress(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                return bArr[10] == -1 && bArr[11] == -1;
            } else if (bArr[i2] != 0) {
                return false;
            } else {
                i = i2 + 1;
            }
        }
    }

    public static boolean isNumeric(String str) {
        InetAddress parseNumericAddressNoThrow = parseNumericAddressNoThrow(str);
        return (parseNumericAddressNoThrow == null || disallowDeprecatedFormats(str, parseNumericAddressNoThrow) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isReachable(InetAddress inetAddress, InetAddress inetAddress2, int i) throws IOException {
        FileDescriptor socket = IoBridge.socket(true);
        boolean z = false;
        if (inetAddress2 != null) {
            try {
                IoBridge.bind(socket, inetAddress2, 0);
            } catch (IOException e) {
                if (e.getCause() instanceof ErrnoException) {
                    z = ((ErrnoException) e.getCause()).errno == OsConstants.ECONNREFUSED;
                }
            }
        }
        IoBridge.connect(socket, inetAddress, 7, i);
        z = true;
        IoBridge.closeAndSignalBlockedThreads(socket);
        return z;
    }

    private static InetAddress[] lookupHostByName(String str, int i) throws UnknownHostException {
        BlockGuard.getThreadPolicy().onNetwork();
        Object obj = addressCache.get(str, i);
        if (obj != null) {
            if (obj instanceof InetAddress[]) {
                return (InetAddress[]) obj;
            }
            throw new UnknownHostException((String) obj);
        }
        try {
            StructAddrinfo structAddrinfo = new StructAddrinfo();
            structAddrinfo.ai_flags = OsConstants.AI_ADDRCONFIG;
            structAddrinfo.ai_family = OsConstants.AF_UNSPEC;
            structAddrinfo.ai_socktype = OsConstants.SOCK_STREAM;
            InetAddress[] android_getaddrinfo = Libcore.os.android_getaddrinfo(str, structAddrinfo, i);
            int length = android_getaddrinfo.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    addressCache.put(str, i, android_getaddrinfo);
                    return android_getaddrinfo;
                }
                android_getaddrinfo[i3].hostName = str;
                i2 = i3 + 1;
            }
        } catch (GaiException e) {
            if ((e.getCause() instanceof ErrnoException) && ((ErrnoException) e.getCause()).errno == OsConstants.EACCES) {
                throw new SecurityException("Permission denied (missing INTERNET permission?)", e);
            }
            String str2 = "Unable to resolve host \"" + str + "\": " + Libcore.os.gai_strerror(e.error);
            addressCache.putUnknownHost(str, i, str2);
            throw e.rethrowAsUnknownHostException(str2);
        }
    }

    private static InetAddress[] loopbackAddresses() {
        return new InetAddress[]{Inet6Address.LOOPBACK, Inet4Address.LOOPBACK};
    }

    private static InetAddress makeInetAddress(byte[] bArr, String str) throws UnknownHostException {
        if (bArr.length == 4) {
            return new Inet4Address(bArr, str);
        }
        if (bArr.length == 16) {
            return new Inet6Address(bArr, str, 0);
        }
        throw badAddressLength(bArr);
    }

    public static InetAddress parseNumericAddress(String str) {
        InetAddress inetAddress;
        if (str == null || str.isEmpty()) {
            inetAddress = Inet6Address.LOOPBACK;
        } else {
            InetAddress disallowDeprecatedFormats = disallowDeprecatedFormats(str, parseNumericAddressNoThrow(str));
            inetAddress = disallowDeprecatedFormats;
            if (disallowDeprecatedFormats == null) {
                throw new IllegalArgumentException("Not a numeric address: " + str);
            }
        }
        return inetAddress;
    }

    private static InetAddress parseNumericAddressNoThrow(String str) {
        String str2 = str;
        if (str.startsWith("[")) {
            str2 = str;
            if (str.endsWith("]")) {
                str2 = str;
                if (str.indexOf(58) != -1) {
                    str2 = str.substring(1, str.length() - 1);
                }
            }
        }
        StructAddrinfo structAddrinfo = new StructAddrinfo();
        structAddrinfo.ai_flags = OsConstants.AI_NUMERICHOST;
        InetAddress[] inetAddressArr = null;
        try {
            inetAddressArr = Libcore.os.android_getaddrinfo(str2, structAddrinfo, 0);
        } catch (GaiException e) {
        }
        if (inetAddressArr != null) {
            return inetAddressArr[0];
        }
        return null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        int i = readFields.get("address", 0);
        this.ipaddress = new byte[4];
        Memory.pokeInt(this.ipaddress, 0, i, ByteOrder.BIG_ENDIAN);
        this.hostName = (String) readFields.get("hostName", (Object) null);
        this.family = readFields.get("family", 2);
    }

    private Object readResolve() throws ObjectStreamException {
        return new Inet4Address(this.ipaddress, this.hostName);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        if (this.ipaddress == null) {
            putFields.put("address", 0);
        } else {
            putFields.put("address", Memory.peekInt(this.ipaddress, 0, ByteOrder.BIG_ENDIAN));
        }
        putFields.put("family", this.family);
        putFields.put("hostName", this.hostName);
        objectOutputStream.writeFields();
    }

    public boolean equals(Object obj) {
        if (obj instanceof InetAddress) {
            return Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress);
        }
        return false;
    }

    public byte[] getAddress() {
        return (byte[]) this.ipaddress.clone();
    }

    public String getCanonicalHostName() {
        try {
            return getHostByAddrImpl(this).hostName;
        } catch (UnknownHostException e) {
            return getHostAddress();
        }
    }

    public String getHostAddress() {
        return Libcore.os.getnameinfo(this, OsConstants.NI_NUMERICHOST);
    }

    public String getHostName() {
        if (this.hostName == null) {
            try {
                this.hostName = getHostByAddrImpl(this).hostName;
            } catch (UnknownHostException e) {
                this.hostName = getHostAddress();
            }
        }
        return this.hostName;
    }

    public int hashCode() {
        return Arrays.hashCode(this.ipaddress);
    }

    public boolean isAnyLocalAddress() {
        return false;
    }

    public boolean isLinkLocalAddress() {
        return false;
    }

    public boolean isLoopbackAddress() {
        return false;
    }

    public boolean isMCGlobal() {
        return false;
    }

    public boolean isMCLinkLocal() {
        return false;
    }

    public boolean isMCNodeLocal() {
        return false;
    }

    public boolean isMCOrgLocal() {
        return false;
    }

    public boolean isMCSiteLocal() {
        return false;
    }

    public boolean isMulticastAddress() {
        return false;
    }

    public boolean isReachable(int i) throws IOException {
        return isReachable((NetworkInterface) null, 0, i);
    }

    public boolean isReachable(NetworkInterface networkInterface, int i, final int i2) throws IOException {
        boolean z = false;
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("ttl < 0 || timeout < 0");
        }
        if (networkInterface == null) {
            z = isReachable(this, (InetAddress) null, i2);
        } else {
            ArrayList<InetAddress> list = Collections.list(networkInterface.getInetAddresses());
            if (!list.isEmpty()) {
                final CountDownLatch countDownLatch = new CountDownLatch(list.size());
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                for (final InetAddress inetAddress : list) {
                    new Thread() { // from class: java.net.InetAddress.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                if (InetAddress.this.isReachable(this, inetAddress, i2)) {
                                    atomicBoolean.set(true);
                                    while (countDownLatch.getCount() > 0) {
                                        countDownLatch.countDown();
                                    }
                                }
                            } catch (IOException e) {
                            }
                            countDownLatch.countDown();
                        }
                    }.start();
                }
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return atomicBoolean.get();
            }
        }
        return z;
    }

    public boolean isSiteLocalAddress() {
        return false;
    }

    public String toString() {
        return (this.hostName == null ? "" : this.hostName) + BridgeUtil.SPLIT_MARK + getHostAddress();
    }
}
