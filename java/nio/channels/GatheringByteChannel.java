package java.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/GatheringByteChannel.class */
public interface GatheringByteChannel extends WritableByteChannel {
    long write(ByteBuffer[] byteBufferArr) throws IOException;

    long write(ByteBuffer[] byteBufferArr, int i, int i2) throws IOException;
}
