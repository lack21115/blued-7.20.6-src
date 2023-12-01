package libcore.io;

import android.system.ErrnoException;
import android.system.OsConstants;
import android.system.StructLinger;
import android.system.StructPollfd;
import android.system.StructStat;
import android.system.StructStatVfs;
import android.util.MutableLong;
import dalvik.system.BlockGuard;
import dalvik.system.SocketTagger;
import java.io.FileDescriptor;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/BlockGuardOs.class */
public class BlockGuardOs extends ForwardingOs {
    public BlockGuardOs(Os os) {
        super(os);
    }

    private static boolean isLingerSocket(FileDescriptor fileDescriptor) throws ErrnoException {
        StructLinger structLinger = Libcore.os.getsockoptLinger(fileDescriptor, OsConstants.SOL_SOCKET, OsConstants.SO_LINGER);
        return structLinger.isOn() && structLinger.l_linger > 0;
    }

    private FileDescriptor tagSocket(FileDescriptor fileDescriptor) throws ErrnoException {
        try {
            SocketTagger.get().tag(fileDescriptor);
            return fileDescriptor;
        } catch (SocketException e) {
            throw new ErrnoException("socket", OsConstants.EINVAL, e);
        }
    }

    private void untagSocket(FileDescriptor fileDescriptor) throws ErrnoException {
        try {
            SocketTagger.get().untag(fileDescriptor);
        } catch (SocketException e) {
            throw new ErrnoException("socket", OsConstants.EINVAL, e);
        }
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public FileDescriptor accept(FileDescriptor fileDescriptor, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        BlockGuard.getThreadPolicy().onNetwork();
        return tagSocket(this.os.accept(fileDescriptor, inetSocketAddress));
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public boolean access(String str, int i) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.access(str, i);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void chmod(String str, int i) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.chmod(str, i);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void chown(String str, int i, int i2) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.chown(str, i, i2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void close(FileDescriptor fileDescriptor) throws ErrnoException {
        try {
            if (fileDescriptor.isSocket()) {
                if (isLingerSocket(fileDescriptor)) {
                    BlockGuard.getThreadPolicy().onNetwork();
                }
                untagSocket(fileDescriptor);
            }
        } catch (ErrnoException e) {
        }
        this.os.close(fileDescriptor);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void connect(FileDescriptor fileDescriptor, InetAddress inetAddress, int i) throws ErrnoException, SocketException {
        BlockGuard.getThreadPolicy().onNetwork();
        this.os.connect(fileDescriptor, inetAddress, i);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void fchmod(FileDescriptor fileDescriptor, int i) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.fchmod(fileDescriptor, i);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void fchown(FileDescriptor fileDescriptor, int i, int i2) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.fchown(fileDescriptor, i, i2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void fdatasync(FileDescriptor fileDescriptor) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.fdatasync(fileDescriptor);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public StructStat fstat(FileDescriptor fileDescriptor) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.fstat(fileDescriptor);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public StructStatVfs fstatvfs(FileDescriptor fileDescriptor) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.fstatvfs(fileDescriptor);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void fsync(FileDescriptor fileDescriptor) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.fsync(fileDescriptor);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void ftruncate(FileDescriptor fileDescriptor, long j) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.ftruncate(fileDescriptor, j);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void lchown(String str, int i, int i2) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.lchown(str, i, i2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void link(String str, String str2) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.link(str, str2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public long lseek(FileDescriptor fileDescriptor, long j, int i) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.lseek(fileDescriptor, j, i);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public StructStat lstat(String str) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.lstat(str);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void mkdir(String str, int i) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.mkdir(str, i);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void mkfifo(String str, int i) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.mkfifo(str, i);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public FileDescriptor open(String str, int i, int i2) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        if ((OsConstants.O_ACCMODE & i2) != OsConstants.O_RDONLY) {
            BlockGuard.getThreadPolicy().onWriteToDisk();
        }
        return this.os.open(str, i, i2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int poll(StructPollfd[] structPollfdArr, int i) throws ErrnoException {
        if (i != 0) {
            BlockGuard.getThreadPolicy().onNetwork();
        }
        return this.os.poll(structPollfdArr, i);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void posix_fallocate(FileDescriptor fileDescriptor, long j, long j2) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.posix_fallocate(fileDescriptor, j, j2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int pread(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, long j) throws ErrnoException, InterruptedIOException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.pread(fileDescriptor, byteBuffer, j);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int pread(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, long j) throws ErrnoException, InterruptedIOException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.pread(fileDescriptor, bArr, i, i2, j);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int pwrite(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, long j) throws ErrnoException, InterruptedIOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return this.os.pwrite(fileDescriptor, byteBuffer, j);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int pwrite(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, long j) throws ErrnoException, InterruptedIOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return this.os.pwrite(fileDescriptor, bArr, i, i2, j);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int read(FileDescriptor fileDescriptor, ByteBuffer byteBuffer) throws ErrnoException, InterruptedIOException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.read(fileDescriptor, byteBuffer);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int read(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2) throws ErrnoException, InterruptedIOException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.read(fileDescriptor, bArr, i, i2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public String readlink(String str) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.readlink(str);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int readv(FileDescriptor fileDescriptor, Object[] objArr, int[] iArr, int[] iArr2) throws ErrnoException, InterruptedIOException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.readv(fileDescriptor, objArr, iArr, iArr2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int recvfrom(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, int i, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        BlockGuard.getThreadPolicy().onNetwork();
        return this.os.recvfrom(fileDescriptor, byteBuffer, i, inetSocketAddress);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int recvfrom(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3, InetSocketAddress inetSocketAddress) throws ErrnoException, SocketException {
        BlockGuard.getThreadPolicy().onNetwork();
        return this.os.recvfrom(fileDescriptor, bArr, i, i2, i3, inetSocketAddress);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void remove(String str) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.remove(str);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void rename(String str, String str2) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.rename(str, str2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public long sendfile(FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2, MutableLong mutableLong, long j) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return this.os.sendfile(fileDescriptor, fileDescriptor2, mutableLong, j);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int sendto(FileDescriptor fileDescriptor, ByteBuffer byteBuffer, int i, InetAddress inetAddress, int i2) throws ErrnoException, SocketException {
        BlockGuard.getThreadPolicy().onNetwork();
        return this.os.sendto(fileDescriptor, byteBuffer, i, inetAddress, i2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int sendto(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2, int i3, InetAddress inetAddress, int i4) throws ErrnoException, SocketException {
        if (inetAddress != null) {
            BlockGuard.getThreadPolicy().onNetwork();
        }
        return this.os.sendto(fileDescriptor, bArr, i, i2, i3, inetAddress, i4);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public FileDescriptor socket(int i, int i2, int i3) throws ErrnoException {
        return tagSocket(this.os.socket(i, i2, i3));
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void socketpair(int i, int i2, int i3, FileDescriptor fileDescriptor, FileDescriptor fileDescriptor2) throws ErrnoException {
        this.os.socketpair(i, i2, i3, fileDescriptor, fileDescriptor2);
        tagSocket(fileDescriptor);
        tagSocket(fileDescriptor2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public StructStat stat(String str) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.stat(str);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public StructStatVfs statvfs(String str) throws ErrnoException {
        BlockGuard.getThreadPolicy().onReadFromDisk();
        return this.os.statvfs(str);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public void symlink(String str, String str2) throws ErrnoException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        this.os.symlink(str, str2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int write(FileDescriptor fileDescriptor, ByteBuffer byteBuffer) throws ErrnoException, InterruptedIOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return this.os.write(fileDescriptor, byteBuffer);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int write(FileDescriptor fileDescriptor, byte[] bArr, int i, int i2) throws ErrnoException, InterruptedIOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return this.os.write(fileDescriptor, bArr, i, i2);
    }

    @Override // libcore.io.ForwardingOs, libcore.io.Os
    public int writev(FileDescriptor fileDescriptor, Object[] objArr, int[] iArr, int[] iArr2) throws ErrnoException, InterruptedIOException {
        BlockGuard.getThreadPolicy().onWriteToDisk();
        return this.os.writev(fileDescriptor, objArr, iArr, iArr2);
    }
}
