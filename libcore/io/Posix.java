package libcore.io;

import android.system.ErrnoException;
import android.system.GaiException;
import android.system.StructAddrinfo;
import android.system.StructFlock;
import android.system.StructGroupReq;
import android.system.StructGroupSourceReq;
import android.system.StructLinger;
import android.system.StructPasswd;
import android.system.StructPollfd;
import android.system.StructStat;
import android.system.StructStatVfs;
import android.system.StructTimeval;
import android.system.StructUcred;
import android.system.StructUtsname;
import android.util.MutableInt;
import android.util.MutableLong;
import java.io.FileDescriptor;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.NioUtils;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/Posix.class */
public final class Posix implements Os {
    private static void maybeUpdateBufferPosition(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 > 0) {
            byteBuffer.position(i2 + i);
        }
    }

    private native int preadBytes(FileDescriptor fileDescriptor, Object obj, int i, int i2, long j) throws ErrnoException, InterruptedIOException;

    private native int pwriteBytes(FileDescriptor fileDescriptor, Object obj, int i, int i2, long j) throws ErrnoException, InterruptedIOException;

    private native int readBytes(FileDescriptor fileDescriptor, Object obj, int i, int i2) throws ErrnoException, InterruptedIOException;

    private native int recvfromBytes(FileDescriptor fileDescriptor, Object obj, int i, int i2, int i3, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException;

    private native int sendtoBytes(FileDescriptor fileDescriptor, Object obj, int i, int i2, int i3, InetAddress inetAddress, int i4) throws ErrnoException, SocketException;

    private native int umaskImpl(int i);

    private native int writeBytes(FileDescriptor fileDescriptor, Object obj, int i, int i2) throws ErrnoException, InterruptedIOException;

    @Override // libcore.io.Os
    public native FileDescriptor accept(FileDescriptor fileDescriptor, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException;

    @Override // libcore.io.Os
    public native boolean access(String str, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native InetAddress[] android_getaddrinfo(String str, StructAddrinfo structAddrinfo, int i) throws GaiException;

    @Override // libcore.io.Os
    public native void bind(FileDescriptor fileDescriptor, InetAddress inetAddress, int i) throws ErrnoException, SocketException;

    @Override // libcore.io.Os
    public native void chmod(String str, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native void chown(String str, int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native void close(FileDescriptor fileDescriptor) throws ErrnoException;

    @Override // libcore.io.Os
    public native void connect(FileDescriptor fileDescriptor, InetAddress inetAddress, int i) throws ErrnoException, SocketException;

    @Override // libcore.io.Os
    public native FileDescriptor dup(FileDescriptor fileDescriptor) throws ErrnoException;

    @Override // libcore.io.Os
    public native FileDescriptor dup2(FileDescriptor fileDescriptor, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native String[] environ();

    @Override // libcore.io.Os
    public native void execv(String str, String[] strArr) throws ErrnoException;

    @Override // libcore.io.Os
    public native void execve(String str, String[] strArr, String[] strArr2) throws ErrnoException;

    @Override // libcore.io.Os
    public native void fchmod(FileDescriptor fileDescriptor, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native void fchown(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native int fcntlFlock(FileDescriptor fileDescriptor, int i, StructFlock structFlock) throws ErrnoException, InterruptedIOException;

    @Override // libcore.io.Os
    public native int fcntlLong(FileDescriptor fileDescriptor, int i, long j) throws ErrnoException;

    @Override // libcore.io.Os
    public native int fcntlVoid(FileDescriptor fileDescriptor, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native void fdatasync(FileDescriptor fileDescriptor) throws ErrnoException;

    @Override // libcore.io.Os
    public native StructStat fstat(FileDescriptor fileDescriptor) throws ErrnoException;

    @Override // libcore.io.Os
    public native StructStatVfs fstatvfs(FileDescriptor fileDescriptor) throws ErrnoException;

    @Override // libcore.io.Os
    public native void fsync(FileDescriptor fileDescriptor) throws ErrnoException;

    @Override // libcore.io.Os
    public native void ftruncate(FileDescriptor fileDescriptor, long j) throws ErrnoException;

    @Override // libcore.io.Os
    public native String gai_strerror(int i);

    @Override // libcore.io.Os
    public native int getegid();

    @Override // libcore.io.Os
    public native String getenv(String str);

    @Override // libcore.io.Os
    public native int geteuid();

    @Override // libcore.io.Os
    public native int getgid();

    @Override // libcore.io.Os
    public native String getnameinfo(InetAddress inetAddress, int i) throws GaiException;

    @Override // libcore.io.Os
    public native SocketAddress getpeername(FileDescriptor fileDescriptor) throws ErrnoException;

    @Override // libcore.io.Os
    public native int getpid();

    @Override // libcore.io.Os
    public native int getppid();

    @Override // libcore.io.Os
    public native StructPasswd getpwnam(String str) throws ErrnoException;

    @Override // libcore.io.Os
    public native StructPasswd getpwuid(int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native SocketAddress getsockname(FileDescriptor fileDescriptor) throws ErrnoException;

    @Override // libcore.io.Os
    public native int getsockoptByte(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native InetAddress getsockoptInAddr(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native int getsockoptInt(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native StructLinger getsockoptLinger(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native StructTimeval getsockoptTimeval(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native StructUcred getsockoptUcred(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native int gettid();

    @Override // libcore.io.Os
    public native int getuid();

    @Override // libcore.io.Os
    public native String if_indextoname(int i);

    @Override // libcore.io.Os
    public native InetAddress inet_pton(int i, String str);

    @Override // libcore.io.Os
    public native InetAddress ioctlInetAddress(FileDescriptor fileDescriptor, int i, String str) throws ErrnoException;

    @Override // libcore.io.Os
    public native int ioctlInt(FileDescriptor fileDescriptor, int i, MutableInt mutableInt) throws ErrnoException;

    @Override // libcore.io.Os
    public native boolean isatty(FileDescriptor fileDescriptor);

    @Override // libcore.io.Os
    public native void kill(int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native void lchown(String str, int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native void link(String str, String str2) throws ErrnoException;

    @Override // libcore.io.Os
    public native void listen(FileDescriptor fileDescriptor, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native long lseek(FileDescriptor fileDescriptor, long j, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native StructStat lstat(String str) throws ErrnoException;

    @Override // libcore.io.Os
    public native void mincore(long j, long j2, byte[] bArr) throws ErrnoException;

    @Override // libcore.io.Os
    public native void mkdir(String str, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native void mkfifo(String str, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native void mlock(long j, long j2) throws ErrnoException;

    @Override // libcore.io.Os
    public native long mmap(long j, long j2, int i, int i2, FileDescriptor fileDescriptor, long j3) throws ErrnoException;

    @Override // libcore.io.Os
    public native void msync(long j, long j2, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native void munlock(long j, long j2) throws ErrnoException;

    @Override // libcore.io.Os
    public native void munmap(long j, long j2) throws ErrnoException;

    @Override // libcore.io.Os
    public native FileDescriptor open(String str, int i, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public native FileDescriptor[] pipe() throws ErrnoException;

    @Override // libcore.io.Os
    public native int poll(StructPollfd[] structPollfdArr, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native void posix_fallocate(FileDescriptor fileDescriptor, long j, long j2) throws ErrnoException;

    @Override // libcore.io.Os
    public native int prctl(int i, long j, long j2, long j3, long j4) throws ErrnoException;

    @Override // libcore.io.Os
    public int pread(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, long j) throws ErrnoException, InterruptedIOException {
        int position = byteBuffer.position();
        int preadBytes = byteBuffer.isDirect() ? preadBytes(fileDescriptor, byteBuffer, position, byteBuffer.remaining(), j) : preadBytes(fileDescriptor, NioUtils.unsafeArray(byteBuffer), NioUtils.unsafeArrayOffset(byteBuffer) + position, byteBuffer.remaining(), j);
        maybeUpdateBufferPosition(byteBuffer, position, preadBytes);
        return preadBytes;
    }

    @Override // libcore.io.Os
    public int pread(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, long j) throws ErrnoException, InterruptedIOException {
        return preadBytes(fileDescriptor, bArr, i, i2, j);
    }

    @Override // libcore.io.Os
    public int pwrite(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, long j) throws ErrnoException, InterruptedIOException {
        int position = byteBuffer.position();
        int pwriteBytes = byteBuffer.isDirect() ? pwriteBytes(fileDescriptor, byteBuffer, position, byteBuffer.remaining(), j) : pwriteBytes(fileDescriptor, NioUtils.unsafeArray(byteBuffer), NioUtils.unsafeArrayOffset(byteBuffer) + position, byteBuffer.remaining(), j);
        maybeUpdateBufferPosition(byteBuffer, position, pwriteBytes);
        return pwriteBytes;
    }

    @Override // libcore.io.Os
    public int pwrite(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, long j) throws ErrnoException, InterruptedIOException {
        return pwriteBytes(fileDescriptor, bArr, i, i2, j);
    }

    @Override // libcore.io.Os
    public int read(FileDescriptor fileDescriptor, ByteBuffer byteBuffer) throws ErrnoException, InterruptedIOException {
        int position = byteBuffer.position();
        int readBytes = byteBuffer.isDirect() ? readBytes(fileDescriptor, byteBuffer, position, byteBuffer.remaining()) : readBytes(fileDescriptor, NioUtils.unsafeArray(byteBuffer), NioUtils.unsafeArrayOffset(byteBuffer) + position, byteBuffer.remaining());
        maybeUpdateBufferPosition(byteBuffer, position, readBytes);
        return readBytes;
    }

    @Override // libcore.io.Os
    public int read(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2) throws ErrnoException, InterruptedIOException {
        return readBytes(fileDescriptor, bArr, i, i2);
    }

    @Override // libcore.io.Os
    public native String readlink(String str) throws ErrnoException;

    @Override // libcore.io.Os
    public native int readv(FileDescriptor fileDescriptor, Object[] objArr, int[] iArr, int[] iArr2) throws ErrnoException, InterruptedIOException;

    @Override // libcore.io.Os
    public int recvfrom(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, int i, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        int position = byteBuffer.position();
        int recvfromBytes = byteBuffer.isDirect() ? recvfromBytes(fileDescriptor, byteBuffer, position, byteBuffer.remaining(), i, inetSocketAddress) : recvfromBytes(fileDescriptor, NioUtils.unsafeArray(byteBuffer), NioUtils.unsafeArrayOffset(byteBuffer) + position, byteBuffer.remaining(), i, inetSocketAddress);
        maybeUpdateBufferPosition(byteBuffer, position, recvfromBytes);
        return recvfromBytes;
    }

    @Override // libcore.io.Os
    public int recvfrom(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        return recvfromBytes(fileDescriptor, bArr, i, i2, i3, inetSocketAddress);
    }

    @Override // libcore.io.Os
    public native void remove(String str) throws ErrnoException;

    @Override // libcore.io.Os
    public native void rename(String str, String str2) throws ErrnoException;

    @Override // libcore.io.Os
    public native long sendfile(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, MutableLong mutableLong, long j) throws ErrnoException;

    @Override // libcore.io.Os
    public int sendto(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, int i, InetAddress inetAddress, int i2) throws ErrnoException, SocketException {
        int position = byteBuffer.position();
        int sendtoBytes = byteBuffer.isDirect() ? sendtoBytes(fileDescriptor, byteBuffer, position, byteBuffer.remaining(), i, inetAddress, i2) : sendtoBytes(fileDescriptor, NioUtils.unsafeArray(byteBuffer), NioUtils.unsafeArrayOffset(byteBuffer) + position, byteBuffer.remaining(), i, inetAddress, i2);
        maybeUpdateBufferPosition(byteBuffer, position, sendtoBytes);
        return sendtoBytes;
    }

    @Override // libcore.io.Os
    public int sendto(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3, InetAddress inetAddress, int i4) throws ErrnoException, SocketException {
        return sendtoBytes(fileDescriptor, bArr, i, i2, i3, inetAddress, i4);
    }

    @Override // libcore.io.Os
    public native void setegid(int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native void setenv(String str, String str2, boolean z) throws ErrnoException;

    @Override // libcore.io.Os
    public native void seteuid(int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native void setgid(int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native int setsid() throws ErrnoException;

    @Override // libcore.io.Os
    public native void setsockoptByte(FileDescriptor fileDescriptor, int i, int i2, int i3) throws ErrnoException;

    @Override // libcore.io.Os
    public native void setsockoptGroupReq(FileDescriptor fileDescriptor, int i, int i2, StructGroupReq structGroupReq) throws ErrnoException;

    @Override // libcore.io.Os
    public native void setsockoptGroupSourceReq(FileDescriptor fileDescriptor, int i, int i2, StructGroupSourceReq structGroupSourceReq) throws ErrnoException;

    @Override // libcore.io.Os
    public native void setsockoptIfreq(FileDescriptor fileDescriptor, int i, int i2, String str) throws ErrnoException;

    @Override // libcore.io.Os
    public native void setsockoptInt(FileDescriptor fileDescriptor, int i, int i2, int i3) throws ErrnoException;

    @Override // libcore.io.Os
    public native void setsockoptIpMreqn(FileDescriptor fileDescriptor, int i, int i2, int i3) throws ErrnoException;

    @Override // libcore.io.Os
    public native void setsockoptLinger(FileDescriptor fileDescriptor, int i, int i2, StructLinger structLinger) throws ErrnoException;

    @Override // libcore.io.Os
    public native void setsockoptTimeval(FileDescriptor fileDescriptor, int i, int i2, StructTimeval structTimeval) throws ErrnoException;

    @Override // libcore.io.Os
    public native void setuid(int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native void shutdown(FileDescriptor fileDescriptor, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public native FileDescriptor socket(int i, int i2, int i3) throws ErrnoException;

    @Override // libcore.io.Os
    public native void socketpair(int i, int i2, int i3, FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2) throws ErrnoException;

    @Override // libcore.io.Os
    public native StructStat stat(String str) throws ErrnoException;

    @Override // libcore.io.Os
    public native StructStatVfs statvfs(String str) throws ErrnoException;

    @Override // libcore.io.Os
    public native String strerror(int i);

    @Override // libcore.io.Os
    public native String strsignal(int i);

    @Override // libcore.io.Os
    public native void symlink(String str, String str2) throws ErrnoException;

    @Override // libcore.io.Os
    public native long sysconf(int i);

    @Override // libcore.io.Os
    public native void tcdrain(FileDescriptor fileDescriptor) throws ErrnoException;

    @Override // libcore.io.Os
    public native void tcsendbreak(FileDescriptor fileDescriptor, int i) throws ErrnoException;

    @Override // libcore.io.Os
    public int umask(int i) {
        if ((i & 511) != i) {
            throw new IllegalArgumentException("Invalid umask: " + i);
        }
        return umaskImpl(i);
    }

    @Override // libcore.io.Os
    public native StructUtsname uname();

    @Override // libcore.io.Os
    public native void unsetenv(String str) throws ErrnoException;

    @Override // libcore.io.Os
    public native int waitpid(int i, MutableInt mutableInt, int i2) throws ErrnoException;

    @Override // libcore.io.Os
    public int write(FileDescriptor fileDescriptor, ByteBuffer byteBuffer) throws ErrnoException, InterruptedIOException {
        int position = byteBuffer.position();
        int writeBytes = byteBuffer.isDirect() ? writeBytes(fileDescriptor, byteBuffer, position, byteBuffer.remaining()) : writeBytes(fileDescriptor, NioUtils.unsafeArray(byteBuffer), NioUtils.unsafeArrayOffset(byteBuffer) + position, byteBuffer.remaining());
        maybeUpdateBufferPosition(byteBuffer, position, writeBytes);
        return writeBytes;
    }

    @Override // libcore.io.Os
    public int write(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2) throws ErrnoException, InterruptedIOException {
        return writeBytes(fileDescriptor, bArr, i, i2);
    }

    @Override // libcore.io.Os
    public native int writev(FileDescriptor fileDescriptor, Object[] objArr, int[] iArr, int[] iArr2) throws ErrnoException, InterruptedIOException;
}
