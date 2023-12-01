package java.nio;

import android.system.ErrnoException;
import java.io.FileDescriptor;
import java.io.IOException;
import libcore.io.Libcore;

/* loaded from: source-2895416-dex2jar.jar:java/nio/IoVec.class */
final class IoVec {
    private final int bufferCount;
    private final ByteBuffer[] byteBuffers;
    private final int[] byteCounts;
    private final Direction direction;
    private final Object[] ioBuffers;
    private final int offset;
    private final int[] offsets;

    /* loaded from: source-2895416-dex2jar.jar:java/nio/IoVec$Direction.class */
    enum Direction {
        READV,
        WRITEV
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IoVec(ByteBuffer[] byteBufferArr, int i, int i2, Direction direction) {
        this.byteBuffers = byteBufferArr;
        this.offset = i;
        this.bufferCount = i2;
        this.direction = direction;
        this.ioBuffers = new Object[i2];
        this.offsets = new int[i2];
        this.byteCounts = new int[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void didTransfer(int i) {
        int i2;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i <= 0 || i4 >= this.bufferCount) {
                return;
            }
            ByteBuffer byteBuffer = this.byteBuffers[this.offset + i4];
            if (this.byteCounts[i4] < i) {
                byteBuffer.position(byteBuffer.limit());
                i2 = i - this.byteCounts[i4];
            } else {
                byteBuffer.position((this.direction == Direction.WRITEV ? byteBuffer.position() : 0) + i);
                i2 = 0;
            }
            i = i2;
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int doTransfer(FileDescriptor fileDescriptor) throws IOException {
        try {
            if (this.direction == Direction.READV) {
                int readv = Libcore.os.readv(fileDescriptor, this.ioBuffers, this.offsets, this.byteCounts);
                if (readv == 0) {
                    return -1;
                }
                return readv;
            }
            return Libcore.os.writev(fileDescriptor, this.ioBuffers, this.offsets, this.byteCounts);
        } catch (ErrnoException e) {
            throw e.rethrowAsIOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int init() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.bufferCount) {
                return i;
            }
            ByteBuffer byteBuffer = this.byteBuffers[this.offset + i3];
            if (this.direction == Direction.READV) {
                byteBuffer.checkWritable();
            }
            int remaining = byteBuffer.remaining();
            if (byteBuffer.isDirect()) {
                this.ioBuffers[i3] = byteBuffer;
                this.offsets[i3] = byteBuffer.position();
            } else {
                this.ioBuffers[i3] = NioUtils.unsafeArray(byteBuffer);
                this.offsets[i3] = NioUtils.unsafeArrayOffset(byteBuffer) + byteBuffer.position();
            }
            this.byteCounts[i3] = remaining;
            i += remaining;
            i2 = i3 + 1;
        }
    }
}
