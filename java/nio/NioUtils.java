package java.nio;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.nio.channels.FileChannel;

/* loaded from: source-2895416-dex2jar.jar:java/nio/NioUtils.class */
public final class NioUtils {
    private NioUtils() {
    }

    public static void freeDirectBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return;
        }
        ((DirectByteBuffer) byteBuffer).free();
    }

    public static FileDescriptor getFD(FileChannel fileChannel) {
        return ((FileChannelImpl) fileChannel).getFD();
    }

    public static FileChannel newFileChannel(Closeable closeable, FileDescriptor fileDescriptor, int i) {
        return new FileChannelImpl(closeable, fileDescriptor, i);
    }

    public static byte[] unsafeArray(ByteBuffer byteBuffer) {
        return ((ByteArrayBuffer) byteBuffer).backingArray;
    }

    public static int unsafeArrayOffset(ByteBuffer byteBuffer) {
        return ((ByteArrayBuffer) byteBuffer).arrayOffset;
    }
}
