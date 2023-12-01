package java.nio;

import android.system.ErrnoException;
import android.system.OsConstants;
import java.nio.channels.FileChannel;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:java/nio/MappedByteBuffer.class */
public abstract class MappedByteBuffer extends ByteBuffer {
    final MemoryBlock block;
    final FileChannel.MapMode mapMode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MappedByteBuffer(MemoryBlock memoryBlock, int i, FileChannel.MapMode mapMode, long j) {
        super(i, j);
        this.mapMode = mapMode;
        this.block = memoryBlock;
    }

    private void checkIsMapped() {
        if (this.mapMode == null) {
            throw new UnsupportedOperationException();
        }
    }

    public final MappedByteBuffer force() {
        checkIsMapped();
        if (this.mapMode == FileChannel.MapMode.READ_WRITE) {
            try {
                Libcore.os.msync(this.block.toLong(), this.block.getSize(), OsConstants.MS_SYNC);
            } catch (ErrnoException e) {
                throw new AssertionError(e);
            }
        }
        return this;
    }

    public final boolean isLoaded() {
        checkIsMapped();
        long j = this.block.toLong();
        long size = this.block.getSize();
        if (size == 0) {
            return true;
        }
        try {
            int sysconf = (int) Libcore.os.sysconf(OsConstants._SC_PAGE_SIZE);
            int i = (int) (j % sysconf);
            long j2 = i;
            long j3 = size + i;
            byte[] bArr = new byte[(int) (((sysconf + j3) - 1) / sysconf)];
            Libcore.os.mincore(j - j2, j3, bArr);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= bArr.length) {
                    return true;
                }
                if ((bArr[i3] & 1) != 1) {
                    return false;
                }
                i2 = i3 + 1;
            }
        } catch (ErrnoException e) {
            return false;
        }
    }

    public final MappedByteBuffer load() {
        checkIsMapped();
        try {
            Libcore.os.mlock(this.block.toLong(), this.block.getSize());
            Libcore.os.munlock(this.block.toLong(), this.block.getSize());
            return this;
        } catch (ErrnoException e) {
            return this;
        }
    }
}
