package java.nio.channels;

import java.io.IOException;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.nio.channels.spi.SelectorProvider;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/SelectableChannel.class */
public abstract class SelectableChannel extends AbstractInterruptibleChannel implements Channel {
    public abstract Object blockingLock();

    public abstract SelectableChannel configureBlocking(boolean z) throws IOException;

    public abstract boolean isBlocking();

    public abstract boolean isRegistered();

    public abstract SelectionKey keyFor(Selector selector);

    public abstract SelectorProvider provider();

    public final SelectionKey register(Selector selector, int i) throws ClosedChannelException {
        return register(selector, i, null);
    }

    public abstract SelectionKey register(Selector selector, int i, Object obj) throws ClosedChannelException;

    public abstract int validOps();
}
