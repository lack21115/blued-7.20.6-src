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

/* loaded from: source-2895416-dex2jar.jar:libcore/io/ForwardingOs.class */
public class ForwardingOs implements Os {
    protected final Os os;

    public ForwardingOs(Os os) {
        this.os = os;
    }

    @Override // libcore.io.Os
    public FileDescriptor accept(FileDescriptor fileDescriptor, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        return this.os.accept(fileDescriptor, inetSocketAddress);
    }

    @Override // libcore.io.Os
    public boolean access(String str, int i) throws ErrnoException {
        return this.os.access(str, i);
    }

    @Override // libcore.io.Os
    public InetAddress[] android_getaddrinfo(String str, StructAddrinfo structAddrinfo, int i) throws GaiException {
        return this.os.android_getaddrinfo(str, structAddrinfo, i);
    }

    @Override // libcore.io.Os
    public void bind(FileDescriptor fileDescriptor, InetAddress inetAddress, int i) throws ErrnoException, SocketException {
        this.os.bind(fileDescriptor, inetAddress, i);
    }

    @Override // libcore.io.Os
    public void chmod(String str, int i) throws ErrnoException {
        this.os.chmod(str, i);
    }

    @Override // libcore.io.Os
    public void chown(String str, int i, int i2) throws ErrnoException {
        this.os.chown(str, i, i2);
    }

    @Override // libcore.io.Os
    public void close(FileDescriptor fileDescriptor) throws ErrnoException {
        this.os.close(fileDescriptor);
    }

    @Override // libcore.io.Os
    public void connect(FileDescriptor fileDescriptor, InetAddress inetAddress, int i) throws ErrnoException, SocketException {
        this.os.connect(fileDescriptor, inetAddress, i);
    }

    @Override // libcore.io.Os
    public FileDescriptor dup(FileDescriptor fileDescriptor) throws ErrnoException {
        return this.os.dup(fileDescriptor);
    }

    @Override // libcore.io.Os
    public FileDescriptor dup2(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        return this.os.dup2(fileDescriptor, i);
    }

    @Override // libcore.io.Os
    public String[] environ() {
        return this.os.environ();
    }

    @Override // libcore.io.Os
    public void execv(String str, String[] strArr) throws ErrnoException {
        this.os.execv(str, strArr);
    }

    @Override // libcore.io.Os
    public void execve(String str, String[] strArr, String[] strArr2) throws ErrnoException {
        this.os.execve(str, strArr, strArr2);
    }

    @Override // libcore.io.Os
    public void fchmod(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        this.os.fchmod(fileDescriptor, i);
    }

    @Override // libcore.io.Os
    public void fchown(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        this.os.fchown(fileDescriptor, i, i2);
    }

    @Override // libcore.io.Os
    public int fcntlFlock(FileDescriptor fileDescriptor, int i, StructFlock structFlock) throws ErrnoException, InterruptedIOException {
        return this.os.fcntlFlock(fileDescriptor, i, structFlock);
    }

    @Override // libcore.io.Os
    public int fcntlLong(FileDescriptor fileDescriptor, int i, long j) throws ErrnoException {
        return this.os.fcntlLong(fileDescriptor, i, j);
    }

    @Override // libcore.io.Os
    public int fcntlVoid(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        return this.os.fcntlVoid(fileDescriptor, i);
    }

    @Override // libcore.io.Os
    public void fdatasync(FileDescriptor fileDescriptor) throws ErrnoException {
        this.os.fdatasync(fileDescriptor);
    }

    @Override // libcore.io.Os
    public StructStat fstat(FileDescriptor fileDescriptor) throws ErrnoException {
        return this.os.fstat(fileDescriptor);
    }

    @Override // libcore.io.Os
    public StructStatVfs fstatvfs(FileDescriptor fileDescriptor) throws ErrnoException {
        return this.os.fstatvfs(fileDescriptor);
    }

    @Override // libcore.io.Os
    public void fsync(FileDescriptor fileDescriptor) throws ErrnoException {
        this.os.fsync(fileDescriptor);
    }

    @Override // libcore.io.Os
    public void ftruncate(FileDescriptor fileDescriptor, long j) throws ErrnoException {
        this.os.ftruncate(fileDescriptor, j);
    }

    @Override // libcore.io.Os
    public String gai_strerror(int i) {
        return this.os.gai_strerror(i);
    }

    @Override // libcore.io.Os
    public int getegid() {
        return this.os.getegid();
    }

    @Override // libcore.io.Os
    public String getenv(String str) {
        return this.os.getenv(str);
    }

    @Override // libcore.io.Os
    public int geteuid() {
        return this.os.geteuid();
    }

    @Override // libcore.io.Os
    public int getgid() {
        return this.os.getgid();
    }

    @Override // libcore.io.Os
    public String getnameinfo(InetAddress inetAddress, int i) throws GaiException {
        return this.os.getnameinfo(inetAddress, i);
    }

    @Override // libcore.io.Os
    public SocketAddress getpeername(FileDescriptor fileDescriptor) throws ErrnoException {
        return this.os.getpeername(fileDescriptor);
    }

    @Override // libcore.io.Os
    public int getpid() {
        return this.os.getpid();
    }

    @Override // libcore.io.Os
    public int getppid() {
        return this.os.getppid();
    }

    @Override // libcore.io.Os
    public StructPasswd getpwnam(String str) throws ErrnoException {
        return this.os.getpwnam(str);
    }

    @Override // libcore.io.Os
    public StructPasswd getpwuid(int i) throws ErrnoException {
        return this.os.getpwuid(i);
    }

    @Override // libcore.io.Os
    public SocketAddress getsockname(FileDescriptor fileDescriptor) throws ErrnoException {
        return this.os.getsockname(fileDescriptor);
    }

    @Override // libcore.io.Os
    public int getsockoptByte(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return this.os.getsockoptByte(fileDescriptor, i, i2);
    }

    @Override // libcore.io.Os
    public InetAddress getsockoptInAddr(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return this.os.getsockoptInAddr(fileDescriptor, i, i2);
    }

    @Override // libcore.io.Os
    public int getsockoptInt(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return this.os.getsockoptInt(fileDescriptor, i, i2);
    }

    @Override // libcore.io.Os
    public StructLinger getsockoptLinger(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return this.os.getsockoptLinger(fileDescriptor, i, i2);
    }

    @Override // libcore.io.Os
    public StructTimeval getsockoptTimeval(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return this.os.getsockoptTimeval(fileDescriptor, i, i2);
    }

    @Override // libcore.io.Os
    public StructUcred getsockoptUcred(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        return this.os.getsockoptUcred(fileDescriptor, i, i2);
    }

    @Override // libcore.io.Os
    public int gettid() {
        return this.os.gettid();
    }

    @Override // libcore.io.Os
    public int getuid() {
        return this.os.getuid();
    }

    @Override // libcore.io.Os
    public String if_indextoname(int i) {
        return this.os.if_indextoname(i);
    }

    @Override // libcore.io.Os
    public InetAddress inet_pton(int i, String str) {
        return this.os.inet_pton(i, str);
    }

    @Override // libcore.io.Os
    public InetAddress ioctlInetAddress(FileDescriptor fileDescriptor, int i, String str) throws ErrnoException {
        return this.os.ioctlInetAddress(fileDescriptor, i, str);
    }

    @Override // libcore.io.Os
    public int ioctlInt(FileDescriptor fileDescriptor, int i, MutableInt mutableInt) throws ErrnoException {
        return this.os.ioctlInt(fileDescriptor, i, mutableInt);
    }

    @Override // libcore.io.Os
    public boolean isatty(FileDescriptor fileDescriptor) {
        return this.os.isatty(fileDescriptor);
    }

    @Override // libcore.io.Os
    public void kill(int i, int i2) throws ErrnoException {
        this.os.kill(i, i2);
    }

    @Override // libcore.io.Os
    public void lchown(String str, int i, int i2) throws ErrnoException {
        this.os.lchown(str, i, i2);
    }

    @Override // libcore.io.Os
    public void link(String str, String str2) throws ErrnoException {
        this.os.link(str, str2);
    }

    @Override // libcore.io.Os
    public void listen(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        this.os.listen(fileDescriptor, i);
    }

    @Override // libcore.io.Os
    public long lseek(FileDescriptor fileDescriptor, long j, int i) throws ErrnoException {
        return this.os.lseek(fileDescriptor, j, i);
    }

    @Override // libcore.io.Os
    public StructStat lstat(String str) throws ErrnoException {
        return this.os.lstat(str);
    }

    @Override // libcore.io.Os
    public void mincore(long j, long j2, byte[] bArr) throws ErrnoException {
        this.os.mincore(j, j2, bArr);
    }

    @Override // libcore.io.Os
    public void mkdir(String str, int i) throws ErrnoException {
        this.os.mkdir(str, i);
    }

    @Override // libcore.io.Os
    public void mkfifo(String str, int i) throws ErrnoException {
        this.os.mkfifo(str, i);
    }

    @Override // libcore.io.Os
    public void mlock(long j, long j2) throws ErrnoException {
        this.os.mlock(j, j2);
    }

    @Override // libcore.io.Os
    public long mmap(long j, long j2, int i, int i2, FileDescriptor fileDescriptor, long j3) throws ErrnoException {
        return this.os.mmap(j, j2, i, i2, fileDescriptor, j3);
    }

    @Override // libcore.io.Os
    public void msync(long j, long j2, int i) throws ErrnoException {
        this.os.msync(j, j2, i);
    }

    @Override // libcore.io.Os
    public void munlock(long j, long j2) throws ErrnoException {
        this.os.munlock(j, j2);
    }

    @Override // libcore.io.Os
    public void munmap(long j, long j2) throws ErrnoException {
        this.os.munmap(j, j2);
    }

    @Override // libcore.io.Os
    public FileDescriptor open(String str, int i, int i2) throws ErrnoException {
        return this.os.open(str, i, i2);
    }

    @Override // libcore.io.Os
    public FileDescriptor[] pipe() throws ErrnoException {
        return this.os.pipe();
    }

    @Override // libcore.io.Os
    public int poll(StructPollfd[] structPollfdArr, int i) throws ErrnoException {
        return this.os.poll(structPollfdArr, i);
    }

    @Override // libcore.io.Os
    public void posix_fallocate(FileDescriptor fileDescriptor, long j, long j2) throws ErrnoException {
        this.os.posix_fallocate(fileDescriptor, j, j2);
    }

    @Override // libcore.io.Os
    public int prctl(int i, long j, long j2, long j3, long j4) throws ErrnoException {
        return this.os.prctl(i, j, j2, j3, j4);
    }

    @Override // libcore.io.Os
    public int pread(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, long j) throws ErrnoException, InterruptedIOException {
        return this.os.pread(fileDescriptor, byteBuffer, j);
    }

    @Override // libcore.io.Os
    public int pread(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, long j) throws ErrnoException, InterruptedIOException {
        return this.os.pread(fileDescriptor, bArr, i, i2, j);
    }

    @Override // libcore.io.Os
    public int pwrite(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, long j) throws ErrnoException, InterruptedIOException {
        return this.os.pwrite(fileDescriptor, byteBuffer, j);
    }

    @Override // libcore.io.Os
    public int pwrite(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, long j) throws ErrnoException, InterruptedIOException {
        return this.os.pwrite(fileDescriptor, bArr, i, i2, j);
    }

    @Override // libcore.io.Os
    public int read(FileDescriptor fileDescriptor, ByteBuffer byteBuffer) throws ErrnoException, InterruptedIOException {
        return this.os.read(fileDescriptor, byteBuffer);
    }

    @Override // libcore.io.Os
    public int read(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2) throws ErrnoException, InterruptedIOException {
        return this.os.read(fileDescriptor, bArr, i, i2);
    }

    @Override // libcore.io.Os
    public String readlink(String str) throws ErrnoException {
        return this.os.readlink(str);
    }

    @Override // libcore.io.Os
    public int readv(FileDescriptor fileDescriptor, Object[] objArr, int[] iArr, int[] iArr2) throws ErrnoException, InterruptedIOException {
        return this.os.readv(fileDescriptor, objArr, iArr, iArr2);
    }

    @Override // libcore.io.Os
    public int recvfrom(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, int i, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        return this.os.recvfrom(fileDescriptor, byteBuffer, i, inetSocketAddress);
    }

    @Override // libcore.io.Os
    public int recvfrom(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        return this.os.recvfrom(fileDescriptor, bArr, i, i2, i3, inetSocketAddress);
    }

    @Override // libcore.io.Os
    public void remove(String str) throws ErrnoException {
        this.os.remove(str);
    }

    @Override // libcore.io.Os
    public void rename(String str, String str2) throws ErrnoException {
        this.os.rename(str, str2);
    }

    @Override // libcore.io.Os
    public long sendfile(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, MutableLong mutableLong, long j) throws ErrnoException {
        return this.os.sendfile(fileDescriptor, fileDescriptor2, mutableLong, j);
    }

    @Override // libcore.io.Os
    public int sendto(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, int i, InetAddress inetAddress, int i2) throws ErrnoException, SocketException {
        return this.os.sendto(fileDescriptor, byteBuffer, i, inetAddress, i2);
    }

    @Override // libcore.io.Os
    public int sendto(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3, InetAddress inetAddress, int i4) throws ErrnoException, SocketException {
        return this.os.sendto(fileDescriptor, bArr, i, i2, i3, inetAddress, i4);
    }

    @Override // libcore.io.Os
    public void setegid(int i) throws ErrnoException {
        this.os.setegid(i);
    }

    @Override // libcore.io.Os
    public void setenv(String str, String str2, boolean z) throws ErrnoException {
        this.os.setenv(str, str2, z);
    }

    @Override // libcore.io.Os
    public void seteuid(int i) throws ErrnoException {
        this.os.seteuid(i);
    }

    @Override // libcore.io.Os
    public void setgid(int i) throws ErrnoException {
        this.os.setgid(i);
    }

    @Override // libcore.io.Os
    public int setsid() throws ErrnoException {
        return this.os.setsid();
    }

    @Override // libcore.io.Os
    public void setsockoptByte(FileDescriptor fileDescriptor, int i, int i2, int i3) throws ErrnoException {
        this.os.setsockoptByte(fileDescriptor, i, i2, i3);
    }

    @Override // libcore.io.Os
    public void setsockoptGroupReq(FileDescriptor fileDescriptor, int i, int i2, StructGroupReq structGroupReq) throws ErrnoException {
        this.os.setsockoptGroupReq(fileDescriptor, i, i2, structGroupReq);
    }

    @Override // libcore.io.Os
    public void setsockoptGroupSourceReq(FileDescriptor fileDescriptor, int i, int i2, StructGroupSourceReq structGroupSourceReq) throws ErrnoException {
        this.os.setsockoptGroupSourceReq(fileDescriptor, i, i2, structGroupSourceReq);
    }

    @Override // libcore.io.Os
    public void setsockoptIfreq(FileDescriptor fileDescriptor, int i, int i2, String str) throws ErrnoException {
        this.os.setsockoptIfreq(fileDescriptor, i, i2, str);
    }

    @Override // libcore.io.Os
    public void setsockoptInt(FileDescriptor fileDescriptor, int i, int i2, int i3) throws ErrnoException {
        this.os.setsockoptInt(fileDescriptor, i, i2, i3);
    }

    @Override // libcore.io.Os
    public void setsockoptIpMreqn(FileDescriptor fileDescriptor, int i, int i2, int i3) throws ErrnoException {
        this.os.setsockoptIpMreqn(fileDescriptor, i, i2, i3);
    }

    @Override // libcore.io.Os
    public void setsockoptLinger(FileDescriptor fileDescriptor, int i, int i2, StructLinger structLinger) throws ErrnoException {
        this.os.setsockoptLinger(fileDescriptor, i, i2, structLinger);
    }

    @Override // libcore.io.Os
    public void setsockoptTimeval(FileDescriptor fileDescriptor, int i, int i2, StructTimeval structTimeval) throws ErrnoException {
        this.os.setsockoptTimeval(fileDescriptor, i, i2, structTimeval);
    }

    @Override // libcore.io.Os
    public void setuid(int i) throws ErrnoException {
        this.os.setuid(i);
    }

    @Override // libcore.io.Os
    public void shutdown(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        this.os.shutdown(fileDescriptor, i);
    }

    @Override // libcore.io.Os
    public FileDescriptor socket(int i, int i2, int i3) throws ErrnoException {
        return this.os.socket(i, i2, i3);
    }

    @Override // libcore.io.Os
    public void socketpair(int i, int i2, int i3, FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2) throws ErrnoException {
        this.os.socketpair(i, i2, i3, fileDescriptor, fileDescriptor2);
    }

    @Override // libcore.io.Os
    public StructStat stat(String str) throws ErrnoException {
        return this.os.stat(str);
    }

    @Override // libcore.io.Os
    public StructStatVfs statvfs(String str) throws ErrnoException {
        return this.os.statvfs(str);
    }

    @Override // libcore.io.Os
    public String strerror(int i) {
        return this.os.strerror(i);
    }

    @Override // libcore.io.Os
    public String strsignal(int i) {
        return this.os.strsignal(i);
    }

    @Override // libcore.io.Os
    public void symlink(String str, String str2) throws ErrnoException {
        this.os.symlink(str, str2);
    }

    @Override // libcore.io.Os
    public long sysconf(int i) {
        return this.os.sysconf(i);
    }

    @Override // libcore.io.Os
    public void tcdrain(FileDescriptor fileDescriptor) throws ErrnoException {
        this.os.tcdrain(fileDescriptor);
    }

    @Override // libcore.io.Os
    public void tcsendbreak(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        this.os.tcsendbreak(fileDescriptor, i);
    }

    @Override // libcore.io.Os
    public int umask(int i) {
        return this.os.umask(i);
    }

    @Override // libcore.io.Os
    public StructUtsname uname() {
        return this.os.uname();
    }

    @Override // libcore.io.Os
    public void unsetenv(String str) throws ErrnoException {
        this.os.unsetenv(str);
    }

    @Override // libcore.io.Os
    public int waitpid(int i, MutableInt mutableInt, int i2) throws ErrnoException {
        return this.os.waitpid(i, mutableInt, i2);
    }

    @Override // libcore.io.Os
    public int write(FileDescriptor fileDescriptor, ByteBuffer byteBuffer) throws ErrnoException, InterruptedIOException {
        return this.os.write(fileDescriptor, byteBuffer);
    }

    @Override // libcore.io.Os
    public int write(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2) throws ErrnoException, InterruptedIOException {
        return this.os.write(fileDescriptor, bArr, i, i2);
    }

    @Override // libcore.io.Os
    public int writev(FileDescriptor fileDescriptor, Object[] objArr, int[] iArr, int[] iArr2) throws ErrnoException, InterruptedIOException {
        return this.os.writev(fileDescriptor, objArr, iArr, iArr2);
    }
}
