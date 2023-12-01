package java.nio.channels;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/Selector.class */
public abstract class Selector implements Closeable {
    public static Selector open() throws IOException {
        return SelectorProvider.provider().openSelector();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close() throws IOException;

    public abstract boolean isOpen();

    public abstract Set<SelectionKey> keys();

    public abstract SelectorProvider provider();

    public abstract int select() throws IOException;

    public abstract int select(long j) throws IOException;

    public abstract int selectNow() throws IOException;

    public abstract Set<SelectionKey> selectedKeys();

    public abstract Selector wakeup();
}
