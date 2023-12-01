package java.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/ScatteringByteChannel.class */
public interface ScatteringByteChannel extends ReadableByteChannel {
    long read(ByteBuffer[] byteBufferArr) throws IOException;

    long read(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException;
}
