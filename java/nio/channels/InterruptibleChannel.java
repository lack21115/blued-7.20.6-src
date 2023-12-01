package java.nio.channels;

import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/InterruptibleChannel.class */
public interface InterruptibleChannel extends Channel {
    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
