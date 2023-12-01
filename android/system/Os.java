package android.system;

import android.util.MutableInt;
import android.util.MutableLong;
import java.io.FileDescriptor;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:android/system/Os.class */
public final class Os {
    private Os() {
    }

    public static FileDescriptor accept(FileDescriptor fileDescriptor, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        return Libcore.os.accept(fileDescriptor, inetSocketAddress);
    }

    public static boolean access(String str, int i) throws ErrnoException {
        return Libcore.os.access(str, i);
    }

    public static InetAddress[] android_getaddrinfo(String str, StructAddrinfo structAddrinfo, int i) throws GaiException {
        return Libcore.os.android_getaddrinfo(str, structAddrinfo, i);
    }

    public static void bind(FileDescriptor fileDescriptor, InetAddress inetAddress, int i) throws ErrnoException, SocketException {
        Libcore.os.bind(fileDescriptor, inetAddress, i);
    }

    public static void chmod(String str, int i) throws ErrnoException {
        Libcore.os.chmod(str, i);
    }

    public static void chown(String str, int i, int i2) throws ErrnoException {
        Libcore.os.chown(str, i, i2);
    }

    public static void close(FileDescriptor fileDescriptor) throws ErrnoException {
        Libcore.os.close(fileDescriptor);
    }

    public static void connect(FileDescriptor fileDescriptor, InetAddress inetAddress, int i) throws ErrnoException, SocketException {
        Libcore.os.connect(fileDescriptor, inetAddress, i);
    }

    public static FileDescriptor dup(FileDescriptor fileDescriptor) throws ErrnoException {
        return Libcore.os.dup(fileDescriptor);
    }

    public static FileDescriptor dup2(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        return Libcore.os.dup2(fileDescriptor, i);
    }

    public static String[] environ() {
        return Libcore.os.environ();
    }

    public static void execv(String str, String[] strArr) throws ErrnoException {
        Libcore.os.execv(str, strArr);
    }

    public static void execve(String str, String[] strArr, String[] strArr2) throws ErrnoException {
        Libcore.os.execve(str, strArr, strArr2);
    }

    public static void fchmod(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        Libcore.os.fchmod(fileDescriptor, i);
    }

    public static void fchown(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        Libcore.os.fchown(fileDescriptor, i, i2);
    }

    public static int fcntlFlock(FileDescriptor fileDescriptor, int i, StructFlock structFlock) throws ErrnoException, InterruptedIOException {
        return Libcore.os.fcntlFlock(fileDescriptor, i, structFlock);
    }

    public static int fcntlLong(FileDescriptor fileDescriptor, int i, long j) throws ErrnoException {
        return Libcore.os.fcntlLong(fileDescriptor, i, j);
    }

    public static int fcntlVoid(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        return Libcore.os.fcntlVoid(fileDescriptor, i);
    }

    public static void fdatasync(FileDescriptor fileDescriptor) throws ErrnoException {
        Libcore.os.fdatasync(fileDescriptor);
    }

    public static StructStat fstat(FileDescriptor fileDescriptor) throws ErrnoException {
        return Libcore.os.fstat(fileDescriptor);
    }

    public static StructStatVfs fstatvfs(FileDescriptor fileDescriptor) throws ErrnoException {
        return Libcore.os.fstatvfs(fileDescriptor);
    }

    public static void fsync(FileDescriptor fileDescriptor) throws ErrnoException {
        Libcore.os.fsync(fileDescriptor);
    }

    public static void ftruncate(FileDescriptor fileDescriptor, long j) throws ErrnoException {
        Libcore.os.ftruncate(fileDescriptor, j);
    }

    public static String gai_strerror(int i) {
        return Libcore.os.gai_strerror(i);
    }

    public static int getegid() {
        return Libcore.os.getegid();
    }

    public static String getenv(String str) {
        return Libcore.os.getenv(str);
    }

    public static int geteuid() {
        return Libcore.os.geteuid();
    }

    public static int getgid() {
        return Libcore.os.getgid();
    }

    public static String getnameinfo(InetAddress inetAddress, int i) throws GaiException {
        return Libcore.os.getnameinfo(inetAddress, i);
    }

    public static SocketAddress getpeername(FileDescriptor fileDescriptor) throws ErrnoException {
        return Libcore.os.getpeername(fileDescriptor);
    }

    public static int getpid() {
        return Libcore.os.getpid();
    }

    public static int getppid() {
        return Libcore.os.getppid();
    }

    public static StructPasswd getpwnam(String str) throws ErrnoException {
        return Libcore.os.getpwnam(str);
    }

    public static StructPasswd getpwuid(int i) throws ErrnoException {
        return Libcore.os.getpwuid(i);
    }

    public static SocketAddress getsockname(FileDescriptor fileDescriptor) throws ErrnoException {
        return Libcore.os.getsockname(fileDescriptor);
    }

    public static int getsockoptByte(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return Libcore.os.getsockoptByte(fileDescriptor, i, i2);
    }

    public static InetAddress getsockoptInAddr(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return Libcore.os.getsockoptInAddr(fileDescriptor, i, i2);
    }

    public static int getsockoptInt(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return Libcore.os.getsockoptInt(fileDescriptor, i, i2);
    }

    public static StructLinger getsockoptLinger(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return Libcore.os.getsockoptLinger(fileDescriptor, i, i2);
    }

    public static StructTimeval getsockoptTimeval(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return Libcore.os.getsockoptTimeval(fileDescriptor, i, i2);
    }

    public static StructUcred getsockoptUcred(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return Libcore.os.getsockoptUcred(fileDescriptor, i, i2);
    }

    public static int gettid() {
        return Libcore.os.gettid();
    }

    public static int getuid() {
        return Libcore.os.getuid();
    }

    public static String if_indextoname(int i) {
        return Libcore.os.if_indextoname(i);
    }

    public static InetAddress inet_pton(int i, String str) {
        return Libcore.os.inet_pton(i, str);
    }

    public static InetAddress ioctlInetAddress(FileDescriptor fileDescriptor, int i, String str) throws ErrnoException {
        return Libcore.os.ioctlInetAddress(fileDescriptor, i, str);
    }

    public static int ioctlInt(FileDescriptor fileDescriptor, int i, MutableInt mutableInt) throws ErrnoException {
        return Libcore.os.ioctlInt(fileDescriptor, i, mutableInt);
    }

    public static boolean isatty(FileDescriptor fileDescriptor) {
        return Libcore.os.isatty(fileDescriptor);
    }

    public static void kill(int i, int i2) throws ErrnoException {
        Libcore.os.kill(i, i2);
    }

    public static void lchown(String str, int i, int i2) throws ErrnoException {
        Libcore.os.lchown(str, i, i2);
    }

    public static void link(String str, String str2) throws ErrnoException {
        Libcore.os.link(str, str2);
    }

    public static void listen(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        Libcore.os.listen(fileDescriptor, i);
    }

    public static long lseek(FileDescriptor fileDescriptor, long j, int i) throws ErrnoException {
        return Libcore.os.lseek(fileDescriptor, j, i);
    }

    public static StructStat lstat(String str) throws ErrnoException {
        return Libcore.os.lstat(str);
    }

    public static void mincore(long j, long j2, byte[] bArr) throws ErrnoException {
        Libcore.os.mincore(j, j2, bArr);
    }

    public static void mkdir(String str, int i) throws ErrnoException {
        Libcore.os.mkdir(str, i);
    }

    public static void mkfifo(String str, int i) throws ErrnoException {
        Libcore.os.mkfifo(str, i);
    }

    public static void mlock(long j, long j2) throws ErrnoException {
        Libcore.os.mlock(j, j2);
    }

    public static long mmap(long j, long j2, int i, int i2, FileDescriptor fileDescriptor, long j3) throws ErrnoException {
        return Libcore.os.mmap(j, j2, i, i2, fileDescriptor, j3);
    }

    public static void msync(long j, long j2, int i) throws ErrnoException {
        Libcore.os.msync(j, j2, i);
    }

    public static void munlock(long j, long j2) throws ErrnoException {
        Libcore.os.munlock(j, j2);
    }

    public static void munmap(long j, long j2) throws ErrnoException {
        Libcore.os.munmap(j, j2);
    }

    public static FileDescriptor open(String str, int i, int i2) throws ErrnoException {
        return Libcore.os.open(str, i, i2);
    }

    public static FileDescriptor[] pipe() throws ErrnoException {
        return Libcore.os.pipe();
    }

    public static int poll(StructPollfd[] structPollfdArr, int i) throws ErrnoException {
        return Libcore.os.poll(structPollfdArr, i);
    }

    public static void posix_fallocate(FileDescriptor fileDescriptor, long j, long j2) throws ErrnoException {
        Libcore.os.posix_fallocate(fileDescriptor, j, j2);
    }

    public static int prctl(int i, long j, long j2, long j3, long j4) throws ErrnoException {
        return Libcore.os.prctl(i, j, j2, j3, j4);
    }

    public static int pread(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, long j) throws ErrnoException, InterruptedIOException {
        return Libcore.os.pread(fileDescriptor, byteBuffer, j);
    }

    public static int pread(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, long j) throws ErrnoException, InterruptedIOException {
        return Libcore.os.pread(fileDescriptor, bArr, i, i2, j);
    }

    public static int pwrite(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, long j) throws ErrnoException, InterruptedIOException {
        return Libcore.os.pwrite(fileDescriptor, byteBuffer, j);
    }

    public static int pwrite(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, long j) throws ErrnoException, InterruptedIOException {
        return Libcore.os.pwrite(fileDescriptor, bArr, i, i2, j);
    }

    public static int read(FileDescriptor fileDescriptor, ByteBuffer byteBuffer) throws ErrnoException, InterruptedIOException {
        return Libcore.os.read(fileDescriptor, byteBuffer);
    }

    public static int read(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2) throws ErrnoException, InterruptedIOException {
        return Libcore.os.read(fileDescriptor, bArr, i, i2);
    }

    public static String readlink(String str) throws ErrnoException {
        return Libcore.os.readlink(str);
    }

    public static int readv(FileDescriptor fileDescriptor, Object[] objArr, int[] iArr, int[] iArr2) throws ErrnoException, InterruptedIOException {
        return Libcore.os.readv(fileDescriptor, objArr, iArr, iArr2);
    }

    public static int recvfrom(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, int i, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        return Libcore.os.recvfrom(fileDescriptor, byteBuffer, i, inetSocketAddress);
    }

    public static int recvfrom(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        return Libcore.os.recvfrom(fileDescriptor, bArr, i, i2, i3, inetSocketAddress);
    }

    public static void remove(String str) throws ErrnoException {
        Libcore.os.remove(str);
    }

    public static void rename(String str, String str2) throws ErrnoException {
        Libcore.os.rename(str, str2);
    }

    public static long sendfile(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, MutableLong mutableLong, long j) throws ErrnoException {
        return Libcore.os.sendfile(fileDescriptor, fileDescriptor2, mutableLong, j);
    }

    public static int sendto(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, int i, InetAddress inetAddress, int i2) throws ErrnoException, SocketException {
        return Libcore.os.sendto(fileDescriptor, byteBuffer, i, inetAddress, i2);
    }

    public static int sendto(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3, InetAddress inetAddress, int i4) throws ErrnoException, SocketException {
        return Libcore.os.sendto(fileDescriptor, bArr, i, i2, i3, inetAddress, i4);
    }

    public static void setegid(int i) throws ErrnoException {
        Libcore.os.setegid(i);
    }

    public static void setenv(String str, String str2, boolean z) throws ErrnoException {
        Libcore.os.setenv(str, str2, z);
    }

    public static void seteuid(int i) throws ErrnoException {
        Libcore.os.seteuid(i);
    }

    public static void setgid(int i) throws ErrnoException {
        Libcore.os.setgid(i);
    }

    public static int setsid() throws ErrnoException {
        return Libcore.os.setsid();
    }

    public static void setsockoptByte(FileDescriptor fileDescriptor, int i, int i2, int i3) throws ErrnoException {
        Libcore.os.setsockoptByte(fileDescriptor, i, i2, i3);
    }

    public static void setsockoptGroupReq(FileDescriptor fileDescriptor, int i, int i2, StructGroupReq structGroupReq) throws ErrnoException {
        Libcore.os.setsockoptGroupReq(fileDescriptor, i, i2, structGroupReq);
    }

    public static void setsockoptGroupSourceReq(FileDescriptor fileDescriptor, int i, int i2, StructGroupSourceReq structGroupSourceReq) throws ErrnoException {
        Libcore.os.setsockoptGroupSourceReq(fileDescriptor, i, i2, structGroupSourceReq);
    }

    public static void setsockoptIfreq(FileDescriptor fileDescriptor, int i, int i2, String str) throws ErrnoException {
        Libcore.os.setsockoptIfreq(fileDescriptor, i, i2, str);
    }

    public static void setsockoptInt(FileDescriptor fileDescriptor, int i, int i2, int i3) throws ErrnoException {
        Libcore.os.setsockoptInt(fileDescriptor, i, i2, i3);
    }

    public static void setsockoptIpMreqn(FileDescriptor fileDescriptor, int i, int i2, int i3) throws ErrnoException {
        Libcore.os.setsockoptIpMreqn(fileDescriptor, i, i2, i3);
    }

    public static void setsockoptLinger(FileDescriptor fileDescriptor, int i, int i2, StructLinger structLinger) throws ErrnoException {
        Libcore.os.setsockoptLinger(fileDescriptor, i, i2, structLinger);
    }

    public static void setsockoptTimeval(FileDescriptor fileDescriptor, int i, int i2, StructTimeval structTimeval) throws ErrnoException {
        Libcore.os.setsockoptTimeval(fileDescriptor, i, i2, structTimeval);
    }

    public static void setuid(int i) throws ErrnoException {
        Libcore.os.setuid(i);
    }

    public static void shutdown(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        Libcore.os.shutdown(fileDescriptor, i);
    }

    public static FileDescriptor socket(int i, int i2, int i3) throws ErrnoException {
        return Libcore.os.socket(i, i2, i3);
    }

    public static void socketpair(int i, int i2, int i3, FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2) throws ErrnoException {
        Libcore.os.socketpair(i, i2, i3, fileDescriptor, fileDescriptor2);
    }

    public static StructStat stat(String str) throws ErrnoException {
        return Libcore.os.stat(str);
    }

    public static StructStatVfs statvfs(String str) throws ErrnoException {
        return Libcore.os.statvfs(str);
    }

    public static String strerror(int i) {
        return Libcore.os.strerror(i);
    }

    public static String strsignal(int i) {
        return Libcore.os.strsignal(i);
    }

    public static void symlink(String str, String str2) throws ErrnoException {
        Libcore.os.symlink(str, str2);
    }

    public static long sysconf(int i) {
        return Libcore.os.sysconf(i);
    }

    public static void tcdrain(FileDescriptor fileDescriptor) throws ErrnoException {
        Libcore.os.tcdrain(fileDescriptor);
    }

    public static void tcsendbreak(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        Libcore.os.tcsendbreak(fileDescriptor, i);
    }

    public static int umask(int i) {
        return Libcore.os.umask(i);
    }

    public static StructUtsname uname() {
        return Libcore.os.uname();
    }

    public static void unsetenv(String str) throws ErrnoException {
        Libcore.os.unsetenv(str);
    }

    public static int waitpid(int i, MutableInt mutableInt, int i2) throws ErrnoException {
        return Libcore.os.waitpid(i, mutableInt, i2);
    }

    public static int write(FileDescriptor fileDescriptor, ByteBuffer byteBuffer) throws ErrnoException, InterruptedIOException {
        return Libcore.os.write(fileDescriptor, byteBuffer);
    }

    public static int write(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2) throws ErrnoException, InterruptedIOException {
        return Libcore.os.write(fileDescriptor, bArr, i, i2);
    }

    public static int writev(FileDescriptor fileDescriptor, Object[] objArr, int[] iArr, int[] iArr2) throws ErrnoException, InterruptedIOException {
        return Libcore.os.writev(fileDescriptor, objArr, iArr, iArr2);
    }
}
