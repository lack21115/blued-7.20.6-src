package java.nio.channels;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/WritableByteChannel.class */
public interface WritableByteChannel extends Channel {
    int write(ByteBuffer byteBuffer) throws IOException;
}
