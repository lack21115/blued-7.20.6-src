package java.nio.channels;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.SelectorProvider;

/* loaded from: source-2895416-dex2jar.jar:java/nio/channels/ServerSocketChannel.class */
public abstract class ServerSocketChannel extends AbstractSelectableChannel {
    /* JADX INFO: Access modifiers changed from: protected */
    public ServerSocketChannel(SelectorProvider selectorProvider) {
        super(selectorProvider);
    }

    public static ServerSocketChannel open() throws IOException {
        return SelectorProvider.provider().openServerSocketChannel();
    }

    public abstract SocketChannel accept() throws IOException;

    public abstract ServerSocket socket();

    @Override // java.nio.channels.SelectableChannel
    public final int validOps() {
        return 16;
    }
}
