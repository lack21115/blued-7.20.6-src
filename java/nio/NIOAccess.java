package java.nio;

/* loaded from: source-2895416-dex2jar.jar:java/nio/NIOAccess.class */
final class NIOAccess {
    NIOAccess() {
    }

    static Object getBaseArray(Buffer buffer) {
        if (buffer.hasArray()) {
            return buffer.array();
        }
        return null;
    }

    static int getBaseArrayOffset(Buffer buffer) {
        if (buffer.hasArray()) {
            return (buffer.arrayOffset() + buffer.position) << buffer._elementSizeShift;
        }
        return 0;
    }

    static long getBasePointer(Buffer buffer) {
        long j = buffer.effectiveDirectAddress;
        if (j == 0) {
            return 0L;
        }
        return (buffer.position << buffer._elementSizeShift) + j;
    }
}
