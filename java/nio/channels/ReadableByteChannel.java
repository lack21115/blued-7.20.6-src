package java.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/ReadableByteChannel.class */
public interface ReadableByteChannel extends Channel {
    int read(ByteBuffer byteBuffer) throws IOException;
}
