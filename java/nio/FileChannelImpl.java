package java.nio;

import android.system.ErrnoException;
import android.system.OsConstants;
import android.system.StructFlock;
import android.util.MutableLong;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.nio.IoVec;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.FileLockInterruptionException;
import java.nio.channels.NonReadableChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.OverlappingFileLockException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import libcore.io.Libcore;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/nio/FileChannelImpl.class */
public final class FileChannelImpl extends FileChannel {
    private static final Comparator<FileLock> LOCK_COMPARATOR = new Comparator<FileLock>() { // from class: java.nio.FileChannelImpl.1
        @Override // java.util.Comparator
        public int compare(FileLock fileLock, FileLock fileLock2) {
            long position = fileLock.position();
            long position2 = fileLock2.position();
            if (position > position2) {
                return 1;
            }
            return position < position2 ? -1 : 0;
        }
    };
    private final FileDescriptor fd;
    private final Closeable ioObject;
    private final SortedSet<FileLock> locks = new TreeSet(LOCK_COMPARATOR);
    private final int mode;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/nio/FileChannelImpl$FileLockImpl.class */
    public static final class FileLockImpl extends FileLock {
        private boolean isReleased;

        public FileLockImpl(FileChannel fileChannel, long j, long j2, boolean z) {
            super(fileChannel, j, j2, z);
            this.isReleased = false;
        }

        @Override // java.nio.channels.FileLock
        public boolean isValid() {
            return !this.isReleased && channel().isOpen();
        }

        @Override // java.nio.channels.FileLock
        public void release() throws IOException {
            if (!channel().isOpen()) {
                throw new ClosedChannelException();
            }
            if (this.isReleased) {
                return;
            }
            ((FileChannelImpl) channel()).release(this);
            this.isReleased = true;
        }
    }

    public FileChannelImpl(Closeable closeable, FileDescriptor fileDescriptor, int i) {
        this.fd = fileDescriptor;
        this.ioObject = closeable;
        this.mode = i;
    }

    private void addLock(FileLock fileLock) throws OverlappingFileLockException {
        FileLock next;
        synchronized (this) {
            long position = fileLock.position();
            long size = fileLock.size();
            Iterator<FileLock> it = this.locks.iterator();
            do {
                if (it.hasNext()) {
                    next = it.next();
                    if (next.position() > position + size) {
                    }
                }
                this.locks.add(fileLock);
            } while (!next.overlaps(fileLock.position(), fileLock.size()));
            throw new OverlappingFileLockException();
        }
    }

    private FileLock basicLock(long j, long j2, boolean z, boolean z2) throws IOException {
        int i = this.mode & OsConstants.O_ACCMODE;
        if (i == OsConstants.O_RDONLY) {
            if (!z) {
                throw new NonWritableChannelException();
            }
        } else if (i == OsConstants.O_WRONLY && z) {
            throw new NonReadableChannelException();
        }
        if (j < 0 || j2 < 0) {
            throw new IllegalArgumentException("position=" + j + " size=" + j2);
        }
        FileLockImpl fileLockImpl = new FileLockImpl(this, j, j2, z);
        addLock(fileLockImpl);
        StructFlock structFlock = new StructFlock();
        structFlock.l_type = (short) (z ? OsConstants.F_RDLCK : OsConstants.F_WRLCK);
        structFlock.l_whence = (short) OsConstants.SEEK_SET;
        structFlock.l_start = j;
        structFlock.l_len = translateLockLength(j2);
        try {
            try {
                boolean z3 = Libcore.os.fcntlFlock(this.fd, z2 ? OsConstants.F_SETLKW64 : OsConstants.F_SETLK64, structFlock) != -1;
                if (!z3) {
                    removeLock(fileLockImpl);
                }
                if (z3) {
                    return fileLockImpl;
                }
                return null;
            } catch (ErrnoException e) {
                throw e.rethrowAsIOException();
            }
        } catch (Throwable th) {
            if (0 == 0) {
                removeLock(fileLockImpl);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int calculateTotalRemaining(ByteBuffer[] byteBufferArr, int i, int i2, boolean z) {
        int i3 = 0;
        int i4 = i;
        while (true) {
            int i5 = i4;
            if (i5 >= i + i2) {
                return i3;
            }
            i3 += byteBufferArr[i5].remaining();
            if (z) {
                byteBufferArr[i5].checkWritable();
            }
            i4 = i5 + 1;
        }
    }

    private void checkOpen() throws ClosedChannelException {
        if (!isOpen()) {
            throw new ClosedChannelException();
        }
    }

    private void checkReadable() {
        if ((this.mode & OsConstants.O_ACCMODE) == OsConstants.O_WRONLY) {
            throw new NonReadableChannelException();
        }
    }

    private void checkWritable() {
        if ((this.mode & OsConstants.O_ACCMODE) == OsConstants.O_RDONLY) {
            throw new NonWritableChannelException();
        }
    }

    private int readImpl(ByteBuffer byteBuffer, long j) throws IOException {
        int i;
        boolean z = true;
        byteBuffer.checkWritable();
        checkOpen();
        checkReadable();
        if (byteBuffer.hasRemaining()) {
            try {
                begin();
                try {
                    int read = j == -1 ? Libcore.os.read(this.fd, byteBuffer) : Libcore.os.pread(this.fd, byteBuffer, j);
                    i = read;
                    if (read == 0) {
                        i = -1;
                    }
                } catch (ErrnoException e) {
                    if (e.errno != OsConstants.EAGAIN) {
                        throw e.rethrowAsIOException();
                    }
                    i = 0;
                }
                if (1 == 0 || i < 0) {
                    z = false;
                }
                end(z);
                return i;
            } catch (Throwable th) {
                end(0 != 0 && 0 >= 0);
                throw th;
            }
        }
        return 0;
    }

    private void removeLock(FileLock fileLock) {
        synchronized (this) {
            this.locks.remove(fileLock);
        }
    }

    private int transferIoVec(IoVec ioVec) throws IOException {
        if (ioVec.init() == 0) {
            return 0;
        }
        try {
            begin();
            int doTransfer = ioVec.doTransfer(this.fd);
            end(true);
            ioVec.didTransfer(doTransfer);
            return doTransfer;
        } catch (Throwable th) {
            end(false);
            throw th;
        }
    }

    private static long translateLockLength(long j) {
        long j2 = j;
        if (j == Long.MAX_VALUE) {
            j2 = 0;
        }
        return j2;
    }

    private int writeImpl(ByteBuffer byteBuffer, long j) throws IOException {
        checkOpen();
        checkWritable();
        if (byteBuffer == null) {
            throw new NullPointerException("buffer == null");
        }
        if (byteBuffer.hasRemaining()) {
            try {
                begin();
                try {
                    int write = j == -1 ? Libcore.os.write(this.fd, byteBuffer) : Libcore.os.pwrite(this.fd, byteBuffer, j);
                    end(true);
                    return write;
                } catch (ErrnoException e) {
                    throw e.rethrowAsIOException();
                }
            } catch (Throwable th) {
                end(false);
                throw th;
            }
        }
        return 0;
    }

    @Override // java.nio.channels.FileChannel
    public void force(boolean z) throws IOException {
        checkOpen();
        if ((this.mode & OsConstants.O_ACCMODE) != OsConstants.O_RDONLY) {
            try {
                if (z) {
                    Libcore.os.fsync(this.fd);
                } else {
                    Libcore.os.fdatasync(this.fd);
                }
            } catch (ErrnoException e) {
                throw e.rethrowAsIOException();
            }
        }
    }

    public FileDescriptor getFD() {
        return this.fd;
    }

    @Override // java.nio.channels.spi.AbstractInterruptibleChannel
    protected void implCloseChannel() throws IOException {
        this.ioObject.close();
    }

    @Override // java.nio.channels.FileChannel
    public final FileLock lock(long j, long j2, boolean z) throws IOException {
        checkOpen();
        try {
            begin();
            FileLock basicLock = basicLock(j, j2, z, true);
            try {
                end(true);
                return basicLock;
            } catch (ClosedByInterruptException e) {
                throw new FileLockInterruptionException();
            }
        } catch (Throwable th) {
            try {
                end(false);
                throw th;
            } catch (ClosedByInterruptException e2) {
                throw new FileLockInterruptionException();
            }
        }
    }

    @Override // java.nio.channels.FileChannel
    public final MappedByteBuffer map(FileChannel.MapMode mapMode, long j, long j2) throws IOException {
        checkOpen();
        if (mapMode == null) {
            throw new NullPointerException("mapMode == null");
        }
        if (j < 0 || j2 < 0 || j2 > 2147483647L) {
            throw new IllegalArgumentException("position=" + j + " size=" + j2);
        }
        int i = this.mode & OsConstants.O_ACCMODE;
        if (i == OsConstants.O_RDONLY) {
            if (mapMode != FileChannel.MapMode.READ_ONLY) {
                throw new NonWritableChannelException();
            }
        } else if (i == OsConstants.O_WRONLY) {
            throw new NonReadableChannelException();
        }
        if (j + j2 > size()) {
            try {
                Libcore.os.ftruncate(this.fd, j + j2);
            } catch (ErrnoException e) {
                try {
                    if (OsConstants.S_ISREG(Libcore.os.fstat(this.fd).st_mode) || e.errno != OsConstants.EINVAL) {
                        throw e.rethrowAsIOException();
                    }
                } catch (ErrnoException e2) {
                    throw e2.rethrowAsIOException();
                }
            }
        }
        long sysconf = j - (j % Libcore.os.sysconf(OsConstants._SC_PAGE_SIZE));
        int i2 = (int) (j - sysconf);
        return new DirectByteBuffer(MemoryBlock.mmap(this.fd, sysconf, j2 + i2, mapMode), (int) j2, i2, mapMode == FileChannel.MapMode.READ_ONLY, mapMode);
    }

    @Override // java.nio.channels.FileChannel
    public long position() throws IOException {
        checkOpen();
        try {
            return Libcore.os.lseek(this.fd, 0L, OsConstants.SEEK_CUR);
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    @Override // java.nio.channels.FileChannel
    public FileChannel position(long j) throws IOException {
        checkOpen();
        if (j < 0) {
            throw new IllegalArgumentException("position: " + j);
        }
        try {
            Libcore.os.lseek(this.fd, j, OsConstants.SEEK_SET);
            return this;
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        return readImpl(byteBuffer, -1L);
    }

    @Override // java.nio.channels.FileChannel
    public int read(ByteBuffer byteBuffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("position: " + j);
        }
        return readImpl(byteBuffer, j);
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.ScatteringByteChannel
    public long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(byteBufferArr.length, i, i2);
        checkOpen();
        checkReadable();
        return transferIoVec(new IoVec(byteBufferArr, i, i2, IoVec.Direction.READV));
    }

    public void release(FileLock fileLock) throws IOException {
        checkOpen();
        StructFlock structFlock = new StructFlock();
        structFlock.l_type = (short) OsConstants.F_UNLCK;
        structFlock.l_whence = (short) OsConstants.SEEK_SET;
        structFlock.l_start = fileLock.position();
        structFlock.l_len = translateLockLength(fileLock.size());
        try {
            Libcore.os.fcntlFlock(this.fd, OsConstants.F_SETLKW64, structFlock);
            removeLock(fileLock);
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    @Override // java.nio.channels.FileChannel
    public long size() throws IOException {
        checkOpen();
        try {
            return Libcore.os.fstat(this.fd).st_size;
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    @Override // java.nio.channels.FileChannel
    public long transferFrom(ReadableByteChannel readableByteChannel, long j, long j2) throws IOException {
        checkOpen();
        if (readableByteChannel.isOpen()) {
            checkWritable();
            if (j < 0 || j2 < 0 || j2 > 2147483647L) {
                throw new IllegalArgumentException("position=" + j + " count=" + j2);
            }
            if (j > size()) {
                return 0L;
            }
            if (!(readableByteChannel instanceof FileChannel)) {
                ByteBuffer allocate = ByteBuffer.allocate((int) j2);
                readableByteChannel.read(allocate);
                allocate.flip();
                return write(allocate, j);
            }
            FileChannel fileChannel = (FileChannel) readableByteChannel;
            long size = fileChannel.size();
            long position = fileChannel.position();
            long min = Math.min(j2, size - position);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, min);
            try {
                fileChannel.position(position + min);
                return write(map, j);
            } finally {
                NioUtils.freeDirectBuffer(map);
            }
        }
        throw new ClosedChannelException();
    }

    @Override // java.nio.channels.FileChannel
    public long transferTo(long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
        checkOpen();
        if (writableByteChannel.isOpen()) {
            checkReadable();
            if (writableByteChannel instanceof FileChannelImpl) {
                ((FileChannelImpl) writableByteChannel).checkWritable();
            }
            if (j < 0 || j2 < 0) {
                throw new IllegalArgumentException("position=" + j + " count=" + j2);
            }
            if (j2 == 0 || j >= size()) {
                return 0L;
            }
            long min = Math.min(j2, size() - j);
            if (writableByteChannel instanceof SocketChannelImpl) {
                FileDescriptor fd = ((SocketChannelImpl) writableByteChannel).getFD();
                try {
                    begin();
                    try {
                        long sendfile = Libcore.os.sendfile(fd, this.fd, new MutableLong(j), min);
                        end(true);
                        return sendfile;
                    } catch (ErrnoException e) {
                        if (e.errno != OsConstants.ENOSYS && e.errno != OsConstants.EINVAL) {
                            throw e.rethrowAsIOException();
                        }
                        end(false);
                    }
                } catch (Throwable th) {
                    end(false);
                    throw th;
                }
            }
            MappedByteBuffer mappedByteBuffer = null;
            try {
                MappedByteBuffer map = map(FileChannel.MapMode.READ_ONLY, j, min);
                mappedByteBuffer = map;
                long write = writableByteChannel.write(map);
                NioUtils.freeDirectBuffer(map);
                return write;
            } catch (Throwable th2) {
                NioUtils.freeDirectBuffer(mappedByteBuffer);
                throw th2;
            }
        }
        throw new ClosedChannelException();
    }

    @Override // java.nio.channels.FileChannel
    public FileChannel truncate(long j) throws IOException {
        checkOpen();
        if (j < 0) {
            throw new IllegalArgumentException("size < 0: " + j);
        }
        checkWritable();
        if (j < size()) {
            try {
                Libcore.os.ftruncate(this.fd, j);
            } catch (ErrnoException e) {
                throw e.rethrowAsIOException();
            }
        }
        if (position() > j) {
            position(j);
        }
        return this;
    }

    @Override // java.nio.channels.FileChannel
    public final FileLock tryLock(long j, long j2, boolean z) throws IOException {
        checkOpen();
        return basicLock(j, j2, z, false);
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        return writeImpl(byteBuffer, -1L);
    }

    @Override // java.nio.channels.FileChannel
    public int write(ByteBuffer byteBuffer, long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("position < 0: " + j);
        }
        return writeImpl(byteBuffer, j);
    }

    @Override // java.nio.channels.FileChannel, java.nio.channels.GatheringByteChannel
    public long write(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException {
        Arrays.checkOffsetAndCount(byteBufferArr.length, i, i2);
        checkOpen();
        checkWritable();
        return transferIoVec(new IoVec(byteBufferArr, i, i2, IoVec.Direction.WRITEV));
    }
}
