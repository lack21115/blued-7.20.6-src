package java.nio.channels;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/Channel.class */
public interface Channel extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    boolean isOpen();
}
