package libcore.io;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.io.FileDescriptor;
import java.nio.ByteOrder;

/* loaded from: source-2895416-dex2jar.jar:libcore/io/MemoryMappedFile.class */
public final class MemoryMappedFile implements AutoCloseable {
    private long address;
    private final long size;

    public MemoryMappedFile(long j, long j2) {
        this.address = j;
        this.size = j2;
    }

    public static MemoryMappedFile mmapRO(String str) throws ErrnoException {
        FileDescriptor open = Libcore.os.open(str, OsConstants.O_RDONLY, 0);
        long j = Libcore.os.fstat(open).st_size;
        long mmap = Libcore.os.mmap(0L, j, OsConstants.PROT_READ, OsConstants.MAP_SHARED, open, 0L);
        Libcore.os.close(open);
        return new MemoryMappedFile(mmap, j);
    }

    public BufferIterator bigEndianIterator() {
        return new NioBufferIterator(this.address, (int) this.size, ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);
    }

    @Override // java.lang.AutoCloseable
    public void close() throws ErrnoException {
        synchronized (this) {
            if (this.address != 0) {
                Libcore.os.munmap(this.address, this.size);
                this.address = 0L;
            }
        }
    }

    public BufferIterator littleEndianIterator() {
        return new NioBufferIterator(this.address, (int) this.size, ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN);
    }

    public long size() {
        return this.size;
    }
}
