package okio;

import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:okio/JvmFileHandle.class */
public final class JvmFileHandle extends FileHandle {
    private final RandomAccessFile randomAccessFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JvmFileHandle(boolean z, RandomAccessFile randomAccessFile) {
        super(z);
        Intrinsics.e(randomAccessFile, "randomAccessFile");
        this.randomAccessFile = randomAccessFile;
    }

    @Override // okio.FileHandle
    protected void protectedClose() {
        synchronized (this) {
            this.randomAccessFile.close();
        }
    }

    @Override // okio.FileHandle
    protected void protectedFlush() {
        synchronized (this) {
            this.randomAccessFile.getFD().sync();
        }
    }

    @Override // okio.FileHandle
    protected int protectedRead(long j, byte[] array, int i, int i2) {
        int i3;
        synchronized (this) {
            Intrinsics.e(array, "array");
            this.randomAccessFile.seek(j);
            int i4 = 0;
            while (true) {
                i3 = i4;
                if (i3 >= i2) {
                    break;
                }
                int read = this.randomAccessFile.read(array, i, i2 - i3);
                if (read != -1) {
                    i4 = i3 + read;
                } else if (i3 == 0) {
                    return -1;
                }
            }
            return i3;
        }
    }

    @Override // okio.FileHandle
    protected void protectedResize(long j) {
        synchronized (this) {
            long size = size();
            long j2 = j - size;
            if (j2 > 0) {
                int i = (int) j2;
                protectedWrite(size, new byte[i], 0, i);
            } else {
                this.randomAccessFile.setLength(j);
            }
        }
    }

    @Override // okio.FileHandle
    protected long protectedSize() {
        long length;
        synchronized (this) {
            length = this.randomAccessFile.length();
        }
        return length;
    }

    @Override // okio.FileHandle
    protected void protectedWrite(long j, byte[] array, int i, int i2) {
        synchronized (this) {
            Intrinsics.e(array, "array");
            this.randomAccessFile.seek(j);
            this.randomAccessFile.write(array, i, i2);
        }
    }
}
