package libcore.io;

import android.system.ErrnoException;
import android.system.OsConstants;
import android.system.StructGroupReq;
import android.system.StructGroupSourceReq;
import android.system.StructLinger;
import android.system.StructPollfd;
import android.system.StructTimeval;
import android.util.MutableInt;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/IoBridge.class */
public final class IoBridge {
    public static final int JAVA_IP_MULTICAST_TTL = 17;
    public static final int JAVA_MCAST_BLOCK_SOURCE = 23;
    public static final int JAVA_MCAST_JOIN_GROUP = 19;
    public static final int JAVA_MCAST_JOIN_SOURCE_GROUP = 21;
    public static final int JAVA_MCAST_LEAVE_GROUP = 20;
    public static final int JAVA_MCAST_LEAVE_SOURCE_GROUP = 22;
    public static final int JAVA_MCAST_UNBLOCK_SOURCE = 24;

    private IoBridge() {
    }

    public static int available(FileDescriptor fileDescriptor) throws IOException {
        int i = 0;
        try {
            MutableInt mutableInt = new MutableInt(0);
            Libcore.os.ioctlInt(fileDescriptor, OsConstants.FIONREAD, mutableInt);
            if (mutableInt.value < 0) {
                mutableInt.value = 0;
            }
            i = mutableInt.value;
        } catch (ErrnoException e) {
            if (e.errno != OsConstants.ENOTTY) {
                throw e.rethrowAsIOException();
            }
        }
        return i;
    }

    public static void bind(FileDescriptor fileDescriptor, InetAddress inetAddress, int i) throws SocketException {
        Inet6Address inet6Address = inetAddress;
        if (inetAddress instanceof Inet6Address) {
            Inet6Address inet6Address2 = (Inet6Address) inetAddress;
            inet6Address = inetAddress;
            if (inet6Address2.getScopeId() == 0) {
                inet6Address = inetAddress;
                if (inet6Address2.isLinkLocalAddress()) {
                    NetworkInterface byInetAddress = NetworkInterface.getByInetAddress(inetAddress);
                    if (byInetAddress == null) {
                        throw new SocketException("Can't bind to a link-local address without a scope id: " + inetAddress);
                    }
                    try {
                        inet6Address = Inet6Address.getByAddress(inetAddress.getHostName(), inetAddress.getAddress(), byInetAddress.getIndex());
                    } catch (UnknownHostException e) {
                        throw new AssertionError(e);
                    }
                }
            }
        }
        try {
            Libcore.os.bind(fileDescriptor, inet6Address, i);
        } catch (ErrnoException e2) {
            throw new BindException(e2.getMessage(), e2);
        }
    }

    private static boolean booleanFromInt(int i) {
        return i != 0;
    }

    private static int booleanToInt(boolean z) {
        return z ? 1 : 0;
    }

    public static void closeAndSignalBlockedThreads(FileDescriptor fileDescriptor) throws IOException {
        if (fileDescriptor == null || !fileDescriptor.valid()) {
            return;
        }
        int int$ = fileDescriptor.getInt$();
        fileDescriptor.setInt$(-1);
        FileDescriptor fileDescriptor2 = new FileDescriptor();
        fileDescriptor2.setInt$(int$);
        AsynchronousCloseMonitor.signalBlockedThreads(fileDescriptor2);
        try {
            Libcore.os.close(fileDescriptor2);
        } catch (ErrnoException e) {
        }
    }

    public static void connect(FileDescriptor fileDescriptor, InetAddress inetAddress, int i) throws SocketException {
        try {
            connect(fileDescriptor, inetAddress, i, 0);
        } catch (SocketTimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public static void connect(FileDescriptor fileDescriptor, InetAddress inetAddress, int i, int i2) throws SocketException, SocketTimeoutException {
        try {
            connectErrno(fileDescriptor, inetAddress, i, i2);
        } catch (ErrnoException e) {
            throw new ConnectException(connectDetail(inetAddress, i, i2, e), e);
        } catch (SocketException e2) {
            throw e2;
        } catch (SocketTimeoutException e3) {
            throw e3;
        } catch (IOException e4) {
            throw new SocketException(e4);
        }
    }

    private static String connectDetail(InetAddress inetAddress, int i, int i2, ErrnoException errnoException) {
        String str = "failed to connect to " + inetAddress + " (port " + i + ")";
        String str2 = str;
        if (i2 > 0) {
            str2 = str + " after " + i2 + "ms";
        }
        String str3 = str2;
        if (errnoException != null) {
            str3 = str2 + ": " + errnoException.getMessage();
        }
        return str3;
    }

    private static void connectErrno(FileDescriptor fileDescriptor, InetAddress inetAddress, int i, int i2) throws ErrnoException, IOException {
        int currentTimeMillis;
        if (i2 == 0) {
            Libcore.os.connect(fileDescriptor, inetAddress, i);
            return;
        }
        IoUtils.setBlocking(fileDescriptor, false);
        long currentTimeMillis2 = System.currentTimeMillis();
        long j = i2;
        try {
            Libcore.os.connect(fileDescriptor, inetAddress, i);
            IoUtils.setBlocking(fileDescriptor, true);
        } catch (ErrnoException e) {
            if (e.errno != OsConstants.EINPROGRESS) {
                throw e;
            }
            do {
                currentTimeMillis = (int) ((currentTimeMillis2 + j) - System.currentTimeMillis());
                if (currentTimeMillis <= 0) {
                    throw new SocketTimeoutException(connectDetail(inetAddress, i, i2, null));
                }
            } while (!isConnected(fileDescriptor, inetAddress, i, i2, currentTimeMillis));
            IoUtils.setBlocking(fileDescriptor, true);
        }
    }

    private static int getGroupSourceReqOp(int i) {
        switch (i) {
            case 21:
                return OsConstants.MCAST_JOIN_SOURCE_GROUP;
            case 22:
                return OsConstants.MCAST_LEAVE_SOURCE_GROUP;
            case 23:
                return OsConstants.MCAST_BLOCK_SOURCE;
            case 24:
                return OsConstants.MCAST_UNBLOCK_SOURCE;
            default:
                throw new AssertionError("Unknown java value for setsocketopt op lookup: " + i);
        }
    }

    public static InetAddress getSocketLocalAddress(FileDescriptor fileDescriptor) throws SocketException {
        try {
            return ((InetSocketAddress) Libcore.os.getsockname(fileDescriptor)).getAddress();
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    public static int getSocketLocalPort(FileDescriptor fileDescriptor) throws SocketException {
        try {
            return ((InetSocketAddress) Libcore.os.getsockname(fileDescriptor)).getPort();
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    public static Object getSocketOption(FileDescriptor fileDescriptor, int i) throws SocketException {
        try {
            return getSocketOptionErrno(fileDescriptor, i);
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    private static Object getSocketOptionErrno(FileDescriptor fileDescriptor, int i) throws ErrnoException, SocketException {
        switch (i) {
            case 1:
                return Boolean.valueOf(booleanFromInt(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.IPPROTO_TCP, OsConstants.TCP_NODELAY)));
            case 3:
                return Integer.valueOf(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.IPPROTO_IPV6, OsConstants.IPV6_TCLASS));
            case 4:
                return Boolean.valueOf(booleanFromInt(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_REUSEADDR)));
            case 8:
                return Boolean.valueOf(booleanFromInt(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_KEEPALIVE)));
            case 16:
                return Libcore.os.getsockoptInAddr(fileDescriptor, OsConstants.IPPROTO_IP, OsConstants.IP_MULTICAST_IF);
            case 17:
                return Integer.valueOf(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.IPPROTO_IPV6, OsConstants.IPV6_MULTICAST_HOPS));
            case 18:
                return Boolean.valueOf(booleanFromInt(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.IPPROTO_IPV6, OsConstants.IPV6_MULTICAST_LOOP)));
            case 31:
                return Integer.valueOf(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.IPPROTO_IPV6, OsConstants.IPV6_MULTICAST_IF));
            case 32:
                return Boolean.valueOf(booleanFromInt(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_BROADCAST)));
            case 128:
                StructLinger structLinger = Libcore.os.getsockoptLinger(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_LINGER);
                if (structLinger.isOn()) {
                    return Integer.valueOf(structLinger.l_linger);
                }
                return false;
            case 4097:
                return Integer.valueOf(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_SNDBUF));
            case 4098:
                return Integer.valueOf(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_RCVBUF));
            case 4099:
                return Boolean.valueOf(booleanFromInt(Libcore.os.getsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_OOBINLINE)));
            case 4102:
                return Integer.valueOf((int) Libcore.os.getsockoptTimeval(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_RCVTIMEO).toMillis());
            default:
                throw new SocketException("Unknown socket option: " + i);
        }
    }

    public static boolean isConnected(FileDescriptor fileDescriptor, InetAddress inetAddress, int i, int i2, int i3) throws IOException {
        try {
            StructPollfd[] structPollfdArr = {new StructPollfd()};
            structPollfdArr[0].fd = fileDescriptor;
            structPollfdArr[0].events = (short) OsConstants.POLLOUT;
            if (Libcore.os.poll(structPollfdArr, i3) == 0) {
                return false;
            }
            int i4 = Libcore.os.getsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_ERROR);
            if (i4 == 0) {
                return true;
            }
            throw new ErrnoException("isConnected", i4);
        } catch (ErrnoException e) {
            if (fileDescriptor.valid()) {
                if (e.errno != OsConstants.EINTR) {
                    String connectDetail = connectDetail(inetAddress, i, i2, e);
                    if (e.errno == OsConstants.ETIMEDOUT) {
                        throw new SocketTimeoutException(connectDetail, e);
                    }
                    throw new ConnectException(connectDetail, e);
                }
                return false;
            }
            throw new SocketException("Socket closed");
        }
    }

    private static int maybeThrowAfterRecvfrom(boolean z, boolean z2, ErrnoException errnoException) throws SocketException, SocketTimeoutException {
        if (z) {
            if (errnoException.errno == OsConstants.EAGAIN) {
                return 0;
            }
            throw errnoException.rethrowAsSocketException();
        } else if (z2 && errnoException.errno == OsConstants.ECONNREFUSED) {
            throw new PortUnreachableException("", errnoException);
        } else {
            if (errnoException.errno == OsConstants.EAGAIN) {
                throw new SocketTimeoutException(errnoException);
            }
            throw errnoException.rethrowAsSocketException();
        }
    }

    private static int maybeThrowAfterSendto(boolean z, ErrnoException errnoException) throws SocketException {
        if (z) {
            if (errnoException.errno == OsConstants.ECONNRESET || errnoException.errno == OsConstants.ECONNREFUSED) {
                return 0;
            }
        } else if (errnoException.errno == OsConstants.EAGAIN) {
            return 0;
        }
        throw errnoException.rethrowAsSocketException();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0087 -> B:20:0x0054). Please submit an issue!!! */
    public static FileDescriptor open(String str, int i) throws FileNotFoundException {
        FileDescriptor fileDescriptor = null;
        try {
            FileDescriptor open = Libcore.os.open(str, i, (OsConstants.O_ACCMODE & i) == OsConstants.O_RDONLY ? 0 : 384);
            if (OsConstants.S_ISDIR(Libcore.os.fstat(open).st_mode)) {
                fileDescriptor = open;
                throw new ErrnoException("open", OsConstants.EISDIR);
            }
            return open;
        } catch (ErrnoException e) {
            if (fileDescriptor != null) {
                try {
                    IoUtils.close(fileDescriptor);
                } catch (IOException e2) {
                }
            }
            FileNotFoundException fileNotFoundException = new FileNotFoundException(str + ": " + e.getMessage());
            fileNotFoundException.initCause(e);
            throw fileNotFoundException;
        }
    }

    private static int postRecvfrom(boolean z, DatagramPacket datagramPacket, boolean z2, InetSocketAddress inetSocketAddress, int i) {
        int i2;
        if (z && i == 0) {
            i2 = -1;
        } else {
            i2 = i;
            if (datagramPacket != null) {
                datagramPacket.setReceivedLength(i);
                i2 = i;
                if (!z2) {
                    datagramPacket.setAddress(inetSocketAddress.getAddress());
                    datagramPacket.setPort(inetSocketAddress.getPort());
                    return i;
                }
            }
        }
        return i2;
    }

    public static int read(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2) throws IOException {
        int i3;
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        if (i2 == 0) {
            i3 = 0;
        } else {
            try {
                int read = Libcore.os.read(fileDescriptor, bArr, i, i2);
                i3 = read;
                if (read == 0) {
                    return -1;
                }
            } catch (ErrnoException e) {
                i3 = 0;
                if (e.errno != OsConstants.EAGAIN) {
                    throw e.rethrowAsIOException();
                }
            }
        }
        return i3;
    }

    public static int recvfrom(boolean z, FileDescriptor fileDescriptor, ByteBuffer byteBuffer, int i, DatagramPacket datagramPacket, boolean z2) throws IOException {
        InetSocketAddress inetSocketAddress;
        if (datagramPacket == null || z2) {
            inetSocketAddress = null;
        } else {
            try {
                inetSocketAddress = new InetSocketAddress();
            } catch (ErrnoException e) {
                return maybeThrowAfterRecvfrom(z, z2, e);
            }
        }
        return postRecvfrom(z, datagramPacket, z2, inetSocketAddress, Libcore.os.recvfrom(fileDescriptor, byteBuffer, i, inetSocketAddress));
    }

    public static int recvfrom(boolean z, FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3, DatagramPacket datagramPacket, boolean z2) throws IOException {
        InetSocketAddress inetSocketAddress;
        if (datagramPacket == null || z2) {
            inetSocketAddress = null;
        } else {
            try {
                inetSocketAddress = new InetSocketAddress();
            } catch (ErrnoException e) {
                return maybeThrowAfterRecvfrom(z, z2, e);
            }
        }
        return postRecvfrom(z, datagramPacket, z2, inetSocketAddress, Libcore.os.recvfrom(fileDescriptor, bArr, i, i2, i3, inetSocketAddress));
    }

    public static int sendto(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, int i, InetAddress inetAddress, int i2) throws IOException {
        boolean z = inetAddress != null;
        if (z || byteBuffer.remaining() != 0) {
            try {
                return Libcore.os.sendto(fileDescriptor, byteBuffer, i, inetAddress, i2);
            } catch (ErrnoException e) {
                return maybeThrowAfterSendto(z, e);
            }
        }
        return 0;
    }

    public static int sendto(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3, InetAddress inetAddress, int i4) throws IOException {
        boolean z = inetAddress != null;
        if (z || i2 > 0) {
            try {
                return Libcore.os.sendto(fileDescriptor, bArr, i, i2, i3, inetAddress, i4);
            } catch (ErrnoException e) {
                return maybeThrowAfterSendto(z, e);
            }
        }
        return 0;
    }

    public static void setSocketOption(FileDescriptor fileDescriptor, int i, Object obj) throws SocketException {
        try {
            setSocketOptionErrno(fileDescriptor, i, obj);
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    private static void setSocketOptionErrno(FileDescriptor fileDescriptor, int i, Object obj) throws ErrnoException, SocketException {
        switch (i) {
            case 1:
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_TCP, OsConstants.TCP_NODELAY, booleanToInt(((Boolean) obj).booleanValue()));
                return;
            case 3:
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IP, OsConstants.IP_TOS, ((Integer) obj).intValue());
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IPV6, OsConstants.IPV6_TCLASS, ((Integer) obj).intValue());
                return;
            case 4:
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_REUSEADDR, booleanToInt(((Boolean) obj).booleanValue()));
                return;
            case 8:
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_KEEPALIVE, booleanToInt(((Boolean) obj).booleanValue()));
                return;
            case 16:
                throw new UnsupportedOperationException("Use IP_MULTICAST_IF2 on Android");
            case 17:
                Libcore.os.setsockoptByte(fileDescriptor, OsConstants.IPPROTO_IP, OsConstants.IP_MULTICAST_TTL, ((Integer) obj).intValue());
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IPV6, OsConstants.IPV6_MULTICAST_HOPS, ((Integer) obj).intValue());
                return;
            case 18:
                Libcore.os.setsockoptByte(fileDescriptor, OsConstants.IPPROTO_IP, OsConstants.IP_MULTICAST_LOOP, booleanToInt(((Boolean) obj).booleanValue()));
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IPV6, OsConstants.IPV6_MULTICAST_LOOP, booleanToInt(((Boolean) obj).booleanValue()));
                return;
            case 19:
            case 20:
                StructGroupReq structGroupReq = (StructGroupReq) obj;
                Libcore.os.setsockoptGroupReq(fileDescriptor, structGroupReq.gr_group instanceof Inet4Address ? OsConstants.IPPROTO_IP : OsConstants.IPPROTO_IPV6, i == 19 ? OsConstants.MCAST_JOIN_GROUP : OsConstants.MCAST_LEAVE_GROUP, structGroupReq);
                return;
            case 21:
            case 22:
            case 23:
            case 24:
                StructGroupSourceReq structGroupSourceReq = (StructGroupSourceReq) obj;
                Libcore.os.setsockoptGroupSourceReq(fileDescriptor, structGroupSourceReq.gsr_group instanceof Inet4Address ? OsConstants.IPPROTO_IP : OsConstants.IPPROTO_IPV6, getGroupSourceReqOp(i), structGroupSourceReq);
                return;
            case 31:
                Libcore.os.setsockoptIpMreqn(fileDescriptor, OsConstants.IPPROTO_IP, OsConstants.IP_MULTICAST_IF, ((Integer) obj).intValue());
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.IPPROTO_IPV6, OsConstants.IPV6_MULTICAST_IF, ((Integer) obj).intValue());
                return;
            case 32:
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_BROADCAST, booleanToInt(((Boolean) obj).booleanValue()));
                return;
            case 128:
                boolean z = false;
                int i2 = 0;
                if (obj instanceof Integer) {
                    z = true;
                    i2 = Math.min(((Integer) obj).intValue(), 65535);
                }
                Libcore.os.setsockoptLinger(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_LINGER, new StructLinger(booleanToInt(z), i2));
                return;
            case 4097:
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_SNDBUF, ((Integer) obj).intValue());
                return;
            case 4098:
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_RCVBUF, ((Integer) obj).intValue());
                return;
            case 4099:
                Libcore.os.setsockoptInt(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_OOBINLINE, booleanToInt(((Boolean) obj).booleanValue()));
                return;
            case 4102:
                Libcore.os.setsockoptTimeval(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_RCVTIMEO, StructTimeval.fromMillis(((Integer) obj).intValue()));
                return;
            default:
                throw new SocketException("Unknown socket option: " + i);
        }
    }

    public static FileDescriptor socket(boolean z) throws SocketException {
        try {
            FileDescriptor socket = Libcore.os.socket(OsConstants.AF_INET6, z ? OsConstants.SOCK_STREAM : OsConstants.SOCK_DGRAM, 0);
            if (z) {
                return socket;
            }
            Libcore.os.setsockoptInt(socket, OsConstants.IPPROTO_IPV6, OsConstants.IPV6_MULTICAST_HOPS, 1);
            return socket;
        } catch (ErrnoException e) {
            throw e.rethrowAsSocketException();
        }
    }

    public static void write(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(bArr.length, i, i2);
        int i3 = i2;
        if (i2 == 0) {
            return;
        }
        while (i3 > 0) {
            try {
                int write = Libcore.os.write(fileDescriptor, bArr, i, i3);
                i3 -= write;
                i += write;
            } catch (ErrnoException e) {
                throw e.rethrowAsIOException();
            }
        }
    }
}
